package mqq.app;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.utils.MonitorSocketStat;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.util.WeakReference;

public abstract class MobileQQ
  extends BaseApplication
  implements Handler.Callback
{
  public static final String ACTION_MAIN_PROCESS_ALIVE = "com.tencent.mobileqq__alive";
  public static final int BROADCAST_INFO_LIST_SIZE = 5;
  public static final String KEY_UIN = "uin";
  private static final int MSG_ACCOUNT = 1;
  protected static final int MSG_LAST_UIN = 3;
  private static final int MSG_MONITOR = 2;
  public static final String PACKAGE_NAME = "com.tencent.mobileqq";
  private static final String PREF_KEY = "currentAccount";
  private static final String PREF_SHARE = "share";
  private static final String PROPERTY_NAME = "Properties";
  public static final int STATE_EMPTY = 1;
  public static final int STATE_INITING = 2;
  public static final int STATE_READY = 3;
  private static boolean hasTryExit;
  public static String processName;
  public static String sInjectResult;
  public static boolean sIsToolProc;
  public static MobileQQ sMobileQQ;
  private boolean accountChanged;
  private final List<WeakReference<BaseActivity>> activitys = new ArrayList();
  public final ArrayList<WeakReference<AppActivity>> appActivities = new ArrayList();
  protected final ArrayList<WeakReference<AppService>> appServices = new ArrayList();
  public Queue<Pair<Long, String>> broadcastInfoQueue = new LinkedList();
  private Runnable doExit = new Runnable()
  {
    public void run()
    {
      if ((MobileQQ.this.activitys.isEmpty()) && (MobileQQ.this.appActivities.isEmpty()) && (MobileQQ.this.otherTypeActivitys.isEmpty()))
      {
        localObject1 = new Intent("mqq.intent.action.EXIT_" + MobileQQ.processName);
        MobileQQ.this.sendBroadcast((Intent)localObject1);
        if (MobileQQ.this.getProcessName().endsWith(":video"))
        {
          MobileQQ.this.mService.msfSub.unbindMsfService();
          MobileQQ.this.mAppRuntime.onDestroy();
        }
        MobileQQ.this.mHandler.postDelayed(new Runnable()
        {
          public void run()
          {
            if (MobileQQ.this.stopMSF)
            {
              MobileQQ.this.mService.msfSub.stopMsfService();
              MobileQQ.killProcess(BaseApplication.getContext(), "com.tencent.mobileqq:MSF");
            }
            if (QLog.isColorLevel())
            {
              QLog.i("mqq", 2, String.format("Application(%s) exit.", new Object[] { MobileQQ.processName }));
              QLog.i("mqq", 2, "===========================================================");
            }
            System.exit(0);
          }
        }, 300L);
        return;
      }
      Object localObject1 = new StringBuffer();
      Iterator localIterator = MobileQQ.this.activitys.iterator();
      Object localObject2;
      while (localIterator.hasNext())
      {
        localObject2 = (BaseActivity)((WeakReference)localIterator.next()).get();
        if (localObject2 != null)
        {
          ((StringBuffer)localObject1).append(localObject2.getClass().getSimpleName());
          ((StringBuffer)localObject1).append(",");
        }
      }
      localIterator = MobileQQ.this.appActivities.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (AppActivity)((WeakReference)localIterator.next()).get();
        if (localObject2 != null)
        {
          ((StringBuffer)localObject1).append(localObject2.getClass().getSimpleName());
          ((StringBuffer)localObject1).append(",");
        }
      }
      localIterator = MobileQQ.this.otherTypeActivitys.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (Activity)((WeakReference)localIterator.next()).get();
        if (localObject2 != null)
        {
          ((StringBuffer)localObject1).append(localObject2.getClass().getSimpleName());
          ((StringBuffer)localObject1).append(",");
        }
      }
      if ((!MobileQQ.hasTryExit) && (QLog.isColorLevel()))
      {
        QLog.i("mqq", 2, "do exit ->" + ((StringBuffer)localObject1).toString());
        MobileQQ.access$702(true);
      }
      ((StringBuffer)localObject1).delete(0, ((StringBuffer)localObject1).length());
      MobileQQ.this.mHandler.postDelayed(this, 50L);
    }
  };
  private boolean isCrashed;
  public boolean isPCActive;
  private AppRuntime mAppRuntime;
  final Handler mHandler = new Handler(this);
  private volatile AtomicInteger mRuntimeState = new AtomicInteger(1);
  private MainService mService;
  protected final ArrayList<WeakReference<Activity>> otherTypeActivitys = new ArrayList();
  private final Properties properties = new Properties();
  List<SimpleAccount> sortAccountList = null;
  public String startComponentInfo;
  private boolean stopMSF;
  private boolean stopMsfOnCrash;
  private Handler subHandler;
  
  private void exit(final boolean paramBoolean1, boolean paramBoolean2)
  {
    this.stopMSF = paramBoolean2;
    Object localObject;
    if (getProcessName().endsWith(":video"))
    {
      localObject = this.mService.msfSub;
      if (paramBoolean1) {
        break label126;
      }
    }
    label126:
    for (paramBoolean2 = true;; paramBoolean2 = false)
    {
      ((MsfServiceSdk)localObject).unRegisterMsfService(Boolean.valueOf(paramBoolean2));
      this.mService.reportMSFCallBackCost(-1L, true);
      closeAllActivitys();
      QLog.d("mqq", 1, "exit isCrashed=" + this.isCrashed + " stopMsfOnCrash=" + this.stopMsfOnCrash);
      localObject = new Runnable()
      {
        public void run()
        {
          try
          {
            if (MobileQQ.this.mAppRuntime == null) {
              MobileQQ.this.waitAppRuntime(null);
            }
            if (!MobileQQ.this.getProcessName().endsWith(":video"))
            {
              MobileQQ.this.mAppRuntime.onDestroy();
              if (!paramBoolean1) {
                MobileQQ.this.mService.msfSub.unRegisterMsfService();
              }
              MobileQQ.this.mService.msfSub.unbindMsfService();
            }
            if (MobileQQ.this.isCrashed)
            {
              Object localObject = new Intent("mqq.intent.action.EXIT_" + MobileQQ.processName);
              MobileQQ.this.sendBroadcast((Intent)localObject);
              localObject = MobileQQ.this.getProcessName();
              if ((((String)localObject).equals("com.tencent.mobileqq")) && (MobileQQ.this.stopMsfOnCrash))
              {
                QLog.d("mqq", 1, "stop and kill msf service");
                MobileQQ.this.mService.msfSub.stopMsfService();
                MobileQQ.killProcess(BaseApplication.getContext(), "com.tencent.mobileqq:MSF");
                System.exit(0);
                return;
              }
              if (((String)localObject).endsWith(":video")) {
                MobileQQ.this.mAppRuntime.onDestroy();
              }
              System.exit(0);
              return;
            }
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel()) {
              QLog.d("mqq", 2, "exit exception=" + localException);
            }
            System.exit(0);
            return;
          }
          MobileQQ.this.doExit.run();
        }
      };
      if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
        break;
      }
      this.mHandler.postAtFrontOfQueue((Runnable)localObject);
      return;
    }
    ((Runnable)localObject).run();
  }
  
  public static MobileQQ getMobileQQ()
  {
    return sMobileQQ;
  }
  
  public static String getShortUinStr(String paramString)
  {
    String str;
    if (paramString == null) {
      str = "";
    }
    do
    {
      return str;
      str = paramString;
    } while (paramString.length() <= 4);
    return paramString.substring(0, 4);
  }
  
  public static boolean killProcess(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null)) {}
    ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
    do
    {
      while (!paramContext.hasNext())
      {
        do
        {
          return false;
          paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
        } while (paramContext == null);
        paramContext = paramContext.iterator();
      }
      localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
    } while (!localRunningAppProcessInfo.processName.equals(paramString));
    Process.killProcess(localRunningAppProcessInfo.pid);
    return true;
  }
  
  private void loadProperites()
  {
    Object localObject7 = null;
    Object localObject8 = null;
    Object localObject1 = null;
    Object localObject6 = null;
    for (;;)
    {
      try
      {
        localFileInputStream = openFileInput("Properties");
        localObject6 = localFileInputStream;
        localObject7 = localFileInputStream;
        localObject8 = localFileInputStream;
        localObject1 = localFileInputStream;
        this.properties.load(localFileInputStream);
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        FileInputStream localFileInputStream;
        Object localObject2 = localObject6;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject2 = localObject6;
        QLog.d("mqq", 2, "can not loadProperites => file not found");
        localObject2 = localObject6;
        localFileNotFoundException.printStackTrace();
        if (localObject6 == null) {
          continue;
        }
        try
        {
          localObject6.close();
          return;
        }
        catch (IOException localIOException2)
        {
          localIOException2.printStackTrace();
          return;
        }
      }
      catch (IOException localIOException6)
      {
        Object localObject3 = localObject7;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject3 = localObject7;
        QLog.d("mqq", 2, "can not loadProperites => IOException");
        localObject3 = localObject7;
        localIOException6.printStackTrace();
        if (localObject7 == null) {
          continue;
        }
        try
        {
          localObject7.close();
          return;
        }
        catch (IOException localIOException3)
        {
          localIOException3.printStackTrace();
          return;
        }
      }
      catch (Exception localException)
      {
        Object localObject4 = localObject8;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject4 = localObject8;
        QLog.d("mqq", 2, "can not loadProperites ");
        localObject4 = localObject8;
        localException.printStackTrace();
        if (localObject8 == null) {
          continue;
        }
        try
        {
          localObject8.close();
          return;
        }
        catch (IOException localIOException4)
        {
          localIOException4.printStackTrace();
          return;
        }
      }
      finally
      {
        if (localIOException4 == null) {
          break label192;
        }
      }
      try
      {
        localFileInputStream.close();
        return;
      }
      catch (IOException localIOException1)
      {
        localIOException1.printStackTrace();
        return;
      }
    }
    try
    {
      localIOException4.close();
      label192:
      throw localObject5;
    }
    catch (IOException localIOException5)
    {
      for (;;)
      {
        localIOException5.printStackTrace();
      }
    }
  }
  
  public void QQProcessExit(boolean paramBoolean)
  {
    exit(false, paramBoolean);
  }
  
  void addActivity(BaseActivity paramBaseActivity)
  {
    this.activitys.add(0, new WeakReference(paramBaseActivity));
  }
  
  public void addOtherTypeActivity(Activity paramActivity) {}
  
  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
    sMobileQQ = this;
  }
  
  public void closeAllActivitys()
  {
    Runnable local2 = new Runnable()
    {
      public void run()
      {
        try
        {
          i = MobileQQ.this.activitys.size();
          QLog.d("mqq", 1, "closeAllActivitys...BaseActivity count: " + i);
          i -= 1;
          if (i < 0) {
            break label163;
          }
          Object localObject1 = (WeakReference)MobileQQ.this.activitys.get(i);
          if (localObject1 == null) {
            break label408;
          }
          localObject1 = (BaseActivity)((WeakReference)localObject1).get();
          label75:
          if (localObject1 == null) {
            MobileQQ.this.activitys.remove(i);
          } else if (!((Activity)localObject1).isFinishing()) {
            ((Activity)localObject1).finish();
          }
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("mqq", 2, "closeAllActivitys: " + localException.getMessage());
          }
        }
        label145:
        return;
        MobileQQ.this.activitys.remove(i);
        break label401;
        label163:
        int i = MobileQQ.this.appActivities.size();
        QLog.d("mqq", 1, "closeAllActivitys...AppActivity count: " + i);
        i -= 1;
        label203:
        if (i >= 0)
        {
          localObject2 = (WeakReference)MobileQQ.this.appActivities.get(i);
          if (localObject2 == null) {
            break label420;
          }
          localObject2 = (AppActivity)((WeakReference)localObject2).get();
          label234:
          if (localObject2 == null) {
            MobileQQ.this.appActivities.remove(i);
          } else if (!((Activity)localObject2).isFinishing()) {
            ((Activity)localObject2).finish();
          } else {
            MobileQQ.this.appActivities.remove(i);
          }
        }
        else
        {
          i = MobileQQ.this.otherTypeActivitys.size();
          QLog.d("mqq", 1, "closeAllActivitys...other Activity count: " + i);
          i -= 1;
          if (i < 0) {
            break label430;
          }
          localObject2 = (WeakReference)MobileQQ.this.otherTypeActivitys.get(i);
          if (localObject2 == null) {
            break label432;
          }
        }
        label322:
        for (Object localObject2 = (Activity)((WeakReference)localObject2).get();; localObject2 = null)
        {
          if (localObject2 == null)
          {
            MobileQQ.this.otherTypeActivitys.remove(i);
          }
          else if (!((Activity)localObject2).isFinishing())
          {
            ((Activity)localObject2).finish();
          }
          else
          {
            MobileQQ.this.otherTypeActivitys.remove(i);
            break label425;
            i -= 1;
            break;
            localObject2 = null;
            break label75;
            i -= 1;
            break label203;
            localObject2 = null;
            break label234;
          }
          i -= 1;
          break label322;
          break label145;
        }
      }
    };
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
    {
      this.mHandler.postAtFrontOfQueue(local2);
      return;
    }
    local2.run();
  }
  
  public void crashed()
  {
    this.isCrashed = true;
  }
  
  void createNewRuntime(final SimpleAccount paramSimpleAccount, final boolean paramBoolean1, final boolean paramBoolean2, final int paramInt, final String paramString)
  {
    QLog.d("MobileQQ", 1, "createNewRuntime, " + paramBoolean2 + paramBoolean1 + paramInt + paramString);
    paramSimpleAccount = new Runnable()
    {
      public void run()
      {
        if (MobileQQ.this.mAppRuntime == null) {}
        for (int i = 1;; i = 0)
        {
          localObject1 = MobileQQ.this.createRuntime(MobileQQ.processName, true);
          if (localObject1 != null) {
            break;
          }
          QLog.i("mqq", 1, MobileQQ.processName + " needn't AppRuntime!");
          return;
        }
        ((AppRuntime)localObject1).init(MobileQQ.this, MobileQQ.this.mService, paramSimpleAccount);
        if (!MobileQQ.this.getProcessName().endsWith(":video")) {
          ((AppRuntime)localObject1).getService().msfSub.registerMsfService();
        }
        long l3;
        long l1;
        long l2;
        if ((paramSimpleAccount != null) && (paramSimpleAccount.isLogined()))
        {
          boolean bool = true;
          if (paramInt != 2) {
            bool = ((AppRuntime)localObject1).canAutoLogin(paramSimpleAccount.getUin());
          }
          if ((paramBoolean1) || (bool)) {
            ((AppRuntime)localObject1).setLogined();
          }
          QLog.d("MobileQQ", 1, "createNewRuntime, canAutoOK: " + bool);
          MobileQQ.access$802(MobileQQ.this, ((AppRuntime)localObject1).isLogin());
          if (!((AppRuntime)localObject1).isLogin()) {
            break label609;
          }
          if (MobileQQ.this.mAppRuntime != null)
          {
            MobileQQ.this.mAppRuntime.logout(Constants.LogoutReason.switchAccount, true);
            MobileQQ.this.mAppRuntime.onDestroy();
          }
          if (paramBoolean2)
          {
            localObject2 = MobileQQ.this.getFirstSimpleAccount();
            l3 = System.currentTimeMillis();
            l1 = l3;
            if (localObject2 != null) {
              l2 = l3;
            }
          }
        }
        try
        {
          long l4 = MobileQQ.this.string2Long(MobileQQ.this.getProperty(((SimpleAccount)localObject2).getUin() + Constants.Key._logintime));
          l1 = l3;
          if (l3 <= l4)
          {
            l3 = l4 + 1L;
            l1 = l3;
            l2 = l3;
            if (QLog.isColorLevel())
            {
              l2 = l3;
              QLog.d("mqq", 2, "CNR account savetime => system time is error..shit");
              l1 = l3;
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            l1 = l2;
          }
        }
        Object localObject2 = ((AppRuntime)localObject1).getAccount();
        if ((localObject2 != null) && (MobileQQ.this.getProcessName().equals(MobileQQ.this.getPackageName())))
        {
          localObject2 = MobileQQ.this.mHandler.obtainMessage(3, localObject2);
          MobileQQ.this.mHandler.sendMessageDelayed((Message)localObject2, 1000L);
        }
        MobileQQ.this.setProperty(((AppRuntime)localObject1).getAccount() + Constants.Key._logintime, String.valueOf(l1));
        ((AppRuntime)localObject1).onCreate(null);
        MobileQQ.access$002(MobileQQ.this, (AppRuntime)localObject1);
        label477:
        Object localObject1 = MobileQQ.this.mHandler.obtainMessage(1);
        if (i != 0) {}
        for (i = 1;; i = 0)
        {
          ((Message)localObject1).arg2 = i;
          ((Message)localObject1).arg1 = paramInt;
          ((Message)localObject1).obj = paramString;
          if (Looper.getMainLooper() != Looper.myLooper()) {
            break label643;
          }
          MobileQQ.this.mHandler.dispatchMessage((Message)localObject1);
          return;
          if (paramSimpleAccount != null)
          {
            QLog.d("MobileQQ", 1, "CNR account != null and account.isLogined =" + paramSimpleAccount.isLogined());
            break;
          }
          QLog.d("MobileQQ", 1, "CNR account == null");
          break;
          label609:
          if (MobileQQ.this.mAppRuntime != null) {
            break label477;
          }
          ((AppRuntime)localObject1).onCreate(null);
          MobileQQ.access$002(MobileQQ.this, (AppRuntime)localObject1);
          break label477;
        }
        label643:
        MobileQQ.this.mHandler.sendMessage((Message)localObject1);
      }
    };
    if (this.mAppRuntime == null)
    {
      paramSimpleAccount.run();
      return;
    }
    this.mHandler.post(paramSimpleAccount);
  }
  
  public abstract AppRuntime createRuntime(String paramString, boolean paramBoolean);
  
  void dispatchAccountEvent(Constants.LogoutReason paramLogoutReason, int paramInt, boolean paramBoolean, String paramString)
  {
    int j = this.activitys.size();
    int i;
    label24:
    Object localObject;
    if (paramLogoutReason != null)
    {
      i = 1;
      j -= 1;
      if (j < 0) {
        break label159;
      }
      localObject = (BaseActivity)((WeakReference)this.activitys.get(j)).get();
      if (localObject != null) {
        break label83;
      }
      this.activitys.remove(j);
    }
    for (;;)
    {
      j -= 1;
      break label24;
      i = 0;
      break;
      label83:
      if (i == 0)
      {
        ((BaseActivity)localObject).setAppRuntime(this.mAppRuntime);
        if (this.accountChanged)
        {
          QLog.d("MobileQQ", 1, "dispatchAE  onAccountChanged");
          ((BaseActivity)localObject).onAccountChanged();
        }
        else
        {
          QLog.d("MobileQQ", 1, "dispatchAE  onAccoutChangeFailed");
          ((BaseActivity)localObject).onAccoutChangeFailed();
        }
      }
      else
      {
        QLog.d("MobileQQ", 1, "dispatchAE  onLogou");
        ((BaseActivity)localObject).onLogout(paramLogoutReason);
      }
    }
    label159:
    j = this.appActivities.size() - 1;
    if (j >= 0)
    {
      localObject = (AppActivity)((WeakReference)this.appActivities.get(j)).get();
      if (localObject == null) {
        this.appActivities.remove(j);
      }
      for (;;)
      {
        j -= 1;
        break;
        if (i == 0)
        {
          ((AppActivity)localObject).setAppRuntime(this.mAppRuntime);
          if (this.accountChanged)
          {
            QLog.d("MobileQQ", 1, "dispatchAE  onAccountChanged");
            ((AppActivity)localObject).onAccountChanged();
          }
          else
          {
            QLog.d("MobileQQ", 1, "dispatchAE  onAccoutChangeFailed");
            ((AppActivity)localObject).onAccoutChangeFailed();
          }
        }
        else
        {
          QLog.d("MobileQQ", 1, "dispatchAE  onLogou");
          ((AppActivity)localObject).onLogout(paramLogoutReason);
        }
      }
    }
    j = this.appServices.size() - 1;
    if (j >= 0)
    {
      localObject = (AppService)((WeakReference)this.appServices.get(j)).get();
      if (localObject == null) {
        this.appServices.remove(j);
      }
      for (;;)
      {
        j -= 1;
        break;
        if (i == 0)
        {
          ((AppService)localObject).setAppRuntime(this.mAppRuntime);
          if (this.accountChanged)
          {
            QLog.d("MobileQQ", 1, "dispatchAE S onAccountChanged");
            ((AppService)localObject).onAccountChanged();
          }
          else
          {
            QLog.d("MobileQQ", 1, "dispatchAE S onAccoutChangeFailed");
            ((AppService)localObject).onAccoutChangeFailed();
          }
        }
        else
        {
          QLog.d("MobileQQ", 1, "dispatchAE S onLogou");
          ((AppService)localObject).onLogout(paramLogoutReason);
        }
      }
    }
    Foreground.updateRuntimeState(this.mAppRuntime);
    if (getPackageName().equals(getProcessName()))
    {
      if (i != 0) {
        break label594;
      }
      if (this.accountChanged)
      {
        if (paramBoolean) {
          break label571;
        }
        paramLogoutReason = new Intent("mqq.intent.action.ACCOUNT_CHANGED");
        paramLogoutReason.putExtra("account", this.mAppRuntime.getAccount());
        paramLogoutReason.putExtra("type", paramInt);
        paramLogoutReason.setPackage("com.tencent.mobileqq");
        sendBroadcast(paramLogoutReason);
        paramLogoutReason = new Intent("mqq.intent.action.EXIT_" + getMobileQQ().getPackageName());
        paramLogoutReason.putExtra("K_EXCEP", paramString);
        paramLogoutReason.setPackage("com.tencent.mobileqq");
        sendBroadcast(paramLogoutReason);
      }
    }
    return;
    label571:
    paramLogoutReason = new Intent("com.tencent.mobileqq__alive");
    paramLogoutReason.setPackage("com.tencent.mobileqq");
    sendBroadcast(paramLogoutReason);
    return;
    label594:
    sendBroadcast(new Intent("mqq.intent.action.LOGOUT"));
  }
  
  /* Error */
  public final void doInit(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 128	mqq/app/MobileQQ:mRuntimeState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   4: iconst_1
    //   5: iconst_2
    //   6: invokevirtual 519	java/util/concurrent/atomic/AtomicInteger:compareAndSet	(II)Z
    //   9: ifne +4 -> 13
    //   12: return
    //   13: aload_0
    //   14: getstatic 520	mqq/app/MobileQQ:processName	Ljava/lang/String;
    //   17: invokevirtual 523	mqq/app/MobileQQ:isNeedMSF	(Ljava/lang/String;)Z
    //   20: istore_2
    //   21: ldc 222
    //   23: iconst_1
    //   24: new 224	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   31: ldc_w 525
    //   34: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: getstatic 520	mqq/app/MobileQQ:processName	Ljava/lang/String;
    //   40: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 245	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   49: getstatic 520	mqq/app/MobileQQ:processName	Ljava/lang/String;
    //   52: ldc_w 527
    //   55: invokevirtual 193	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   58: ifne +245 -> 303
    //   61: iload_2
    //   62: ifeq +241 -> 303
    //   65: aload_0
    //   66: invokespecial 529	mqq/app/MobileQQ:loadProperites	()V
    //   69: aload_0
    //   70: new 195	mqq/app/MainService
    //   73: dup
    //   74: aload_0
    //   75: aload_0
    //   76: getstatic 520	mqq/app/MobileQQ:processName	Ljava/lang/String;
    //   79: invokevirtual 533	mqq/app/MobileQQ:getAppId	(Ljava/lang/String;)I
    //   82: aload_0
    //   83: getstatic 520	mqq/app/MobileQQ:processName	Ljava/lang/String;
    //   86: invokevirtual 536	mqq/app/MobileQQ:getBootBroadcastName	(Ljava/lang/String;)Ljava/lang/String;
    //   89: iload_1
    //   90: invokespecial 539	mqq/app/MainService:<init>	(Lmqq/app/MobileQQ;ILjava/lang/String;Z)V
    //   93: putfield 153	mqq/app/MobileQQ:mService	Lmqq/app/MainService;
    //   96: aload_0
    //   97: invokevirtual 185	mqq/app/MobileQQ:getProcessName	()Ljava/lang/String;
    //   100: ldc 187
    //   102: invokevirtual 193	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   105: ifne +13 -> 118
    //   108: aload_0
    //   109: getfield 153	mqq/app/MobileQQ:mService	Lmqq/app/MainService;
    //   112: getfield 199	mqq/app/MainService:msfSub	Lcom/tencent/mobileqq/msf/sdk/MsfServiceSdk;
    //   115: invokevirtual 542	com/tencent/mobileqq/msf/sdk/MsfServiceSdk:initMsfService	()V
    //   118: aload_0
    //   119: invokevirtual 545	mqq/app/MobileQQ:getAllAccounts	()Ljava/util/List;
    //   122: astore_3
    //   123: aload_3
    //   124: ifnull +258 -> 382
    //   127: aload_3
    //   128: iconst_0
    //   129: invokeinterface 417 2 0
    //   134: checkcast 547	com/tencent/qphone/base/remote/SimpleAccount
    //   137: astore_3
    //   138: aload_3
    //   139: astore 4
    //   141: aload_3
    //   142: ifnonnull +136 -> 278
    //   145: ldc 222
    //   147: iconst_1
    //   148: ldc_w 549
    //   151: invokestatic 245	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: aload_0
    //   155: ldc 49
    //   157: iconst_0
    //   158: invokevirtual 553	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   161: astore 6
    //   163: aload_3
    //   164: astore 4
    //   166: aload 6
    //   168: ifnull +110 -> 278
    //   171: aload 6
    //   173: ldc 46
    //   175: aconst_null
    //   176: invokeinterface 559 3 0
    //   181: astore 5
    //   183: invokestatic 360	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   186: ifeq +30 -> 216
    //   189: ldc 222
    //   191: iconst_1
    //   192: new 224	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   199: ldc_w 561
    //   202: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload 5
    //   207: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokestatic 245	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   216: aload_3
    //   217: astore 4
    //   219: aload 5
    //   221: ifnull +57 -> 278
    //   224: aload 6
    //   226: invokeinterface 565 1 0
    //   231: ldc 46
    //   233: invokeinterface 570 2 0
    //   238: invokeinterface 573 1 0
    //   243: pop
    //   244: new 547	com/tencent/qphone/base/remote/SimpleAccount
    //   247: dup
    //   248: invokespecial 574	com/tencent/qphone/base/remote/SimpleAccount:<init>	()V
    //   251: astore 4
    //   253: aload 4
    //   255: aload 5
    //   257: invokevirtual 577	com/tencent/qphone/base/remote/SimpleAccount:setUin	(Ljava/lang/String;)V
    //   260: aload 4
    //   262: invokevirtual 580	com/tencent/qphone/base/remote/SimpleAccount:isLogined	()Z
    //   265: pop
    //   266: aload 4
    //   268: ldc_w 582
    //   271: iconst_1
    //   272: invokestatic 585	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   275: invokevirtual 589	com/tencent/qphone/base/remote/SimpleAccount:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
    //   278: iconst_0
    //   279: istore_1
    //   280: getstatic 520	mqq/app/MobileQQ:processName	Ljava/lang/String;
    //   283: ldc 43
    //   285: invokevirtual 327	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   288: ifeq +5 -> 293
    //   291: iconst_1
    //   292: istore_1
    //   293: aload_0
    //   294: aload 4
    //   296: iconst_0
    //   297: iload_1
    //   298: iconst_5
    //   299: aconst_null
    //   300: invokevirtual 591	mqq/app/MobileQQ:createNewRuntime	(Lcom/tencent/qphone/base/remote/SimpleAccount;ZZILjava/lang/String;)V
    //   303: aload_0
    //   304: new 475	android/content/Intent
    //   307: dup
    //   308: new 224	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   315: ldc_w 593
    //   318: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: getstatic 520	mqq/app/MobileQQ:processName	Ljava/lang/String;
    //   324: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   330: invokespecial 480	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   333: invokevirtual 504	mqq/app/MobileQQ:sendBroadcast	(Landroid/content/Intent;)V
    //   336: aload_0
    //   337: getfield 128	mqq/app/MobileQQ:mRuntimeState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   340: astore_3
    //   341: aload_3
    //   342: monitorenter
    //   343: aload_0
    //   344: getfield 128	mqq/app/MobileQQ:mRuntimeState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   347: iconst_3
    //   348: invokevirtual 596	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   351: aload_0
    //   352: getfield 128	mqq/app/MobileQQ:mRuntimeState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   355: invokevirtual 601	java/lang/Object:notifyAll	()V
    //   358: aload_3
    //   359: monitorexit
    //   360: ldc 222
    //   362: iconst_1
    //   363: ldc_w 603
    //   366: invokestatic 245	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   369: aload_0
    //   370: getfield 135	mqq/app/MobileQQ:mHandler	Landroid/os/Handler;
    //   373: iconst_2
    //   374: ldc2_w 604
    //   377: invokevirtual 609	android/os/Handler:sendEmptyMessageDelayed	(IJ)Z
    //   380: pop
    //   381: return
    //   382: aconst_null
    //   383: astore_3
    //   384: goto -246 -> 138
    //   387: astore 4
    //   389: aload_3
    //   390: monitorexit
    //   391: aload 4
    //   393: athrow
    //   394: astore_3
    //   395: ldc 222
    //   397: iconst_1
    //   398: ldc_w 611
    //   401: aload_3
    //   402: invokestatic 615	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   405: new 617	java/lang/RuntimeException
    //   408: dup
    //   409: aload_3
    //   410: invokespecial 620	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   413: athrow
    //   414: astore 4
    //   416: aload_0
    //   417: getfield 128	mqq/app/MobileQQ:mRuntimeState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   420: astore_3
    //   421: aload_3
    //   422: monitorenter
    //   423: aload_0
    //   424: getfield 128	mqq/app/MobileQQ:mRuntimeState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   427: iconst_3
    //   428: invokevirtual 596	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   431: aload_0
    //   432: getfield 128	mqq/app/MobileQQ:mRuntimeState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   435: invokevirtual 601	java/lang/Object:notifyAll	()V
    //   438: aload_3
    //   439: monitorexit
    //   440: ldc 222
    //   442: iconst_1
    //   443: ldc_w 603
    //   446: invokestatic 245	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   449: aload_0
    //   450: getfield 135	mqq/app/MobileQQ:mHandler	Landroid/os/Handler;
    //   453: iconst_2
    //   454: ldc2_w 604
    //   457: invokevirtual 609	android/os/Handler:sendEmptyMessageDelayed	(IJ)Z
    //   460: pop
    //   461: aload 4
    //   463: athrow
    //   464: astore 4
    //   466: aload_3
    //   467: monitorexit
    //   468: aload 4
    //   470: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	471	0	this	MobileQQ
    //   0	471	1	paramBoolean	boolean
    //   20	42	2	bool	boolean
    //   394	16	3	localThrowable	Throwable
    //   139	156	4	localObject2	Object
    //   387	5	4	localObject3	Object
    //   414	48	4	localObject4	Object
    //   464	5	4	localObject5	Object
    //   181	75	5	str	String
    //   161	64	6	localSharedPreferences	SharedPreferences
    // Exception table:
    //   from	to	target	type
    //   343	360	387	finally
    //   389	391	387	finally
    //   13	61	394	java/lang/Throwable
    //   65	118	394	java/lang/Throwable
    //   118	123	394	java/lang/Throwable
    //   127	138	394	java/lang/Throwable
    //   145	163	394	java/lang/Throwable
    //   171	216	394	java/lang/Throwable
    //   224	278	394	java/lang/Throwable
    //   280	291	394	java/lang/Throwable
    //   293	303	394	java/lang/Throwable
    //   303	336	394	java/lang/Throwable
    //   13	61	414	finally
    //   65	118	414	finally
    //   118	123	414	finally
    //   127	138	414	finally
    //   145	163	414	finally
    //   171	216	414	finally
    //   224	278	414	finally
    //   280	291	414	finally
    //   293	303	414	finally
    //   303	336	414	finally
    //   395	414	414	finally
    //   423	440	464	finally
    //   466	468	464	finally
  }
  
  public List<SimpleAccount> getAllAccounts()
  {
    if (this.sortAccountList == null)
    {
      ArrayList localArrayList = MsfSdkUtils.getLoginedAccountList();
      if ((localArrayList != null) && (!localArrayList.isEmpty())) {
        this.sortAccountList = localArrayList;
      }
    }
    if ((this.sortAccountList != null) && (this.sortAccountList.size() > 0))
    {
      Collections.sort(this.sortAccountList, new Comparator()
      {
        public int compare(SimpleAccount paramAnonymousSimpleAccount1, SimpleAccount paramAnonymousSimpleAccount2)
        {
          long l1 = MobileQQ.this.string2Long(MobileQQ.this.getProperty(paramAnonymousSimpleAccount1.getUin() + Constants.Key._logintime));
          long l2 = MobileQQ.this.string2Long(MobileQQ.this.getProperty(paramAnonymousSimpleAccount2.getUin() + Constants.Key._logintime));
          if (paramAnonymousSimpleAccount1 != null) {
            QLog.d("mqq", 1, "a1.getUin() = " + MsfSdkUtils.getShortUin(paramAnonymousSimpleAccount1.getUin()) + ";key.time = " + l1 + ", isLogined=" + paramAnonymousSimpleAccount1.isLogined());
          }
          if (paramAnonymousSimpleAccount2 != null) {
            QLog.d("mqq", 1, "a2.getUin() = " + MsfSdkUtils.getShortUin(paramAnonymousSimpleAccount2.getUin()) + ";key.time = " + l2 + ", isLogined=" + paramAnonymousSimpleAccount2.isLogined());
          }
          if (l2 > l1) {
            return 1;
          }
          return -1;
        }
      });
      return Collections.unmodifiableList(this.sortAccountList);
    }
    if (QLog.isColorLevel()) {
      QLog.w("mqq", 2, "Account list is NULL!");
    }
    return null;
  }
  
  public List<SimpleAccount> getAllNotSynAccountList()
  {
    return this.sortAccountList;
  }
  
  public abstract int getAppId(String paramString);
  
  public AppRuntime getAppRuntime(String paramString)
    throws AccountNotMatchException
  {
    AppRuntime localAppRuntime = waitAppRuntime(null);
    if ((paramString != null) && (paramString.equals(localAppRuntime.getAccount()))) {}
    while (paramString == localAppRuntime.getAccount()) {
      return localAppRuntime;
    }
    throw new AccountNotMatchException(localAppRuntime.getAccount(), paramString);
  }
  
  public abstract String getBootBroadcastName(String paramString);
  
  public SimpleAccount getFirstSimpleAccount()
  {
    List localList = getAllAccounts();
    if ((localList == null) || (localList.size() == 0)) {
      return null;
    }
    return (SimpleAccount)localList.get(0);
  }
  
  public String getProcessName()
  {
    if (processName == null)
    {
      int i = 0;
      String str2;
      do
      {
        str2 = MsfSdkUtils.getProcessName(this);
        i += 1;
      } while ((i < 3) && ("unknown".equals(str2)));
      String str1 = str2;
      if ("unknown".equals(str2)) {
        str1 = "com.tencent.mobileqq";
      }
      processName = str1;
      BaseApplication.processName = str1;
    }
    return processName;
  }
  
  public String getProperty(String paramString)
  {
    return this.properties.getProperty(paramString);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    SharedPreferences localSharedPreferences;
    do
    {
      return true;
      int i = paramMessage.arg1;
      if (paramMessage.arg2 == 1) {}
      for (boolean bool = true;; bool = false)
      {
        dispatchAccountEvent(null, i, bool, (String)paramMessage.obj);
        return true;
      }
      monitor.setProcessName(processName);
      try
      {
        monitor.start();
        return true;
      }
      catch (Throwable paramMessage)
      {
        QLog.d("mqq", 1, "", paramMessage);
        return true;
      }
      paramMessage = (String)paramMessage.obj;
      localSharedPreferences = getSharedPreferences("Last_Login", 4);
    } while (localSharedPreferences.getString("uin", "").equals(paramMessage));
    localSharedPreferences.edit().putString("uin", paramMessage).commit();
    return true;
  }
  
  public abstract boolean isNeedMSF(String paramString);
  
  public boolean isRuntimeReady()
  {
    return this.mRuntimeState.get() == 3;
  }
  
  public boolean onActivityCreate(Object paramObject, Intent paramIntent)
  {
    return false;
  }
  
  public void onActivityFocusChanged(AppActivity paramAppActivity, boolean paramBoolean) {}
  
  public void onCreate()
  {
    sMobileQQ = this;
    super.onCreate();
  }
  
  public void otherProcessExit(boolean paramBoolean)
  {
    exit(paramBoolean, false);
  }
  
  public AppRuntime peekAppRuntime()
  {
    return this.mAppRuntime;
  }
  
  public List<SimpleAccount> refreAccountList()
  {
    ArrayList localArrayList = MsfSdkUtils.getLoginedAccountList();
    if ((localArrayList != null) && (!localArrayList.isEmpty())) {
      this.sortAccountList = localArrayList;
    }
    if ((this.sortAccountList != null) && (this.sortAccountList.size() > 0))
    {
      Collections.sort(this.sortAccountList, new Comparator()
      {
        public int compare(SimpleAccount paramAnonymousSimpleAccount1, SimpleAccount paramAnonymousSimpleAccount2)
        {
          long l = MobileQQ.this.string2Long(MobileQQ.this.getProperty(paramAnonymousSimpleAccount1.getUin() + Constants.Key._logintime));
          if (MobileQQ.this.string2Long(MobileQQ.this.getProperty(paramAnonymousSimpleAccount2.getUin() + Constants.Key._logintime)) > l) {
            return 1;
          }
          return -1;
        }
      });
      return Collections.unmodifiableList(this.sortAccountList);
    }
    if (QLog.isColorLevel()) {
      QLog.d("mqq", 2, "refreAccountList Account list is NULL!");
    }
    return this.sortAccountList;
  }
  
  void removeActivity(BaseActivity paramBaseActivity)
  {
    this.activitys.remove(new WeakReference(paramBaseActivity));
  }
  
  public void removeOtherTypeActivity(Activity paramActivity) {}
  
  public void reportPCActive(String paramString, int paramInt) {}
  
  public void setAutoLogin(boolean paramBoolean)
  {
    if ((this.mAppRuntime != null) && (this.mAppRuntime.getAccount() != null) && (this.mAppRuntime.getAccount().length() > 0)) {
      this.mAppRuntime.setAutoLogin(paramBoolean);
    }
  }
  
  public void setProperty(String arg1, String paramString2)
  {
    this.properties.setProperty(???, paramString2);
    if (this.subHandler == null) {}
    synchronized (this.properties)
    {
      if (this.subHandler == null)
      {
        paramString2 = new HandlerThread("property-saver");
        paramString2.start();
        this.subHandler = new Handler(paramString2.getLooper());
      }
      this.subHandler.post(new Runnable()
      {
        public void run()
        {
          Object localObject3 = null;
          Object localObject1 = null;
          for (;;)
          {
            try
            {
              localFileOutputStream = MobileQQ.this.openFileOutput("Properties", 0);
              localObject1 = localFileOutputStream;
              localObject3 = localFileOutputStream;
              MobileQQ.this.properties.store(localFileOutputStream, null);
              localObject1 = localFileOutputStream;
              localObject3 = localFileOutputStream;
              localFileOutputStream.flush();
            }
            catch (Exception localException)
            {
              FileOutputStream localFileOutputStream;
              localObject3 = localIOException1;
              localException.printStackTrace();
              if (localIOException1 == null) {
                continue;
              }
              try
              {
                localIOException1.close();
                return;
              }
              catch (IOException localIOException2)
              {
                localIOException2.printStackTrace();
                return;
              }
            }
            finally
            {
              if (localObject3 == null) {
                break label85;
              }
            }
            try
            {
              localFileOutputStream.close();
              return;
            }
            catch (IOException localIOException1)
            {
              localIOException1.printStackTrace();
              return;
            }
          }
          try
          {
            localObject3.close();
            label85:
            throw localObject2;
          }
          catch (IOException localIOException3)
          {
            for (;;)
            {
              localIOException3.printStackTrace();
            }
          }
        }
      });
      return;
    }
  }
  
  public void setSortAccountList(List<SimpleAccount> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Collections.sort(paramList, new Comparator()
      {
        public int compare(SimpleAccount paramAnonymousSimpleAccount1, SimpleAccount paramAnonymousSimpleAccount2)
        {
          long l = MobileQQ.this.string2Long(MobileQQ.this.getProperty(paramAnonymousSimpleAccount1.getUin() + Constants.Key._logintime));
          if (MobileQQ.this.string2Long(MobileQQ.this.getProperty(paramAnonymousSimpleAccount2.getUin() + Constants.Key._logintime)) > l) {
            return 1;
          }
          return -1;
        }
      });
      this.sortAccountList = paramList;
    }
    if (QLog.isColorLevel()) {
      QLog.d("mqq", 2, "sort AccountList" + this.sortAccountList);
    }
  }
  
  public void startActivity(Intent paramIntent)
  {
    paramIntent.putExtra("preAct", getClass().getSimpleName());
    paramIntent.putExtra("preAct_time", System.currentTimeMillis());
    super.startActivity(paramIntent);
  }
  
  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    paramIntent.putExtra("preAct", getClass().getSimpleName());
    paramIntent.putExtra("preAct_time", System.currentTimeMillis());
    super.startActivity(paramIntent, paramBundle);
  }
  
  public void startService()
  {
    if (this.mService != null) {
      this.mService.start();
    }
  }
  
  public void stopMsfOnCrash(boolean paramBoolean)
  {
    this.stopMsfOnCrash = paramBoolean;
    if (this.stopMsfOnCrash) {
      QLog.d("mqq", 1, "stop and kill msf stopMsfOnCrash=" + this.stopMsfOnCrash);
    }
    try
    {
      this.mService.msfSub.unRegisterMsfService();
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        for (;;)
        {
          this.mService.msfSub.unbindMsfService();
          this.mService.msfSub.stopMsfService();
          try
          {
            killProcess(getContext(), "com.tencent.mobileqq:MSF");
            return;
          }
          catch (Throwable localThrowable3)
          {
            localThrowable3.printStackTrace();
          }
          localThrowable1 = localThrowable1;
          localThrowable1.printStackTrace();
        }
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          localThrowable2.printStackTrace();
        }
      }
    }
  }
  
  public long string2Long(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.w("mqq", 2, "string2Long number is empty");
      }
      return 0L;
    }
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.w("mqq", 2, "string2Long catch exception");
      }
      paramString.printStackTrace();
    }
    return 0L;
  }
  
  public AppRuntime waitAppRuntime(BaseActivity arg1)
  {
    int i = this.mRuntimeState.get();
    if (i != 3) {
      if (i == 1)
      {
        QLog.e("mqq", 1, "waitInit when empty: ", new RuntimeException(""));
        doInit(true);
      }
    }
    synchronized (this.mRuntimeState)
    {
      i = this.mRuntimeState.get();
      if (i == 2) {}
      try
      {
        this.mRuntimeState.wait();
        return this.mAppRuntime;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
          QLog.e("mqq", 1, "waitInit failed", localInterruptedException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.app.MobileQQ
 * JD-Core Version:    0.7.0.1
 */