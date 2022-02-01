package mqq.app;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.support.v4.util.ArraySet;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.msf.core.MsfExitReceiver;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.utils.MonitorSocketStat;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class MobileQQ
  extends BaseApplication
  implements Handler.Callback
{
  public static final String ACTION_MAIN_PROCESS_ALIVE = "com.tencent.mobileqq__alive";
  public static final String ACTION_PROCESS_EXIT = "com.tencent.process.exit";
  public static final int BROADCAST_INFO_LIST_SIZE = 5;
  private static final ArraySet<String> BROADCAST_WHITE_LIST;
  public static final String KEY_UIN = "uin";
  private static final int MSG_ACCOUNT = 1;
  protected static final int MSG_LAST_UIN = 3;
  private static final int MSG_MONITOR = 2;
  public static final String PACKAGE_NAME = "com.tencent.mobileqq";
  private static final String[] PERMS = { "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_PHONE_STATE" };
  public static final String PREF_BROADCAST = "broadcast_white_pref";
  private static final String PREF_KEY = "currentAccount";
  private static final String PREF_SHARE = "share";
  public static final String PREF_WHITE_LIST_KEY = "white_list";
  private static final String PROPERTY_NAME = "Properties";
  public static final int STATE_EMPTY = 1;
  public static final int STATE_INITING = 2;
  public static final int STATE_READY = 3;
  public static final ConcurrentHashMap<String, Boolean> S_MODULE_LOADED = new ConcurrentHashMap();
  private static boolean hasInit;
  private static boolean hasTryExit = false;
  public static String processName;
  private static volatile boolean sHasPhonePermission;
  private static volatile boolean sHasSDCardPermission;
  public static String sInjectResult = null;
  public static boolean sIsToolProc;
  public static MobileQQ sMobileQQ;
  private boolean accountChanged;
  private final List<WeakReference<BaseActivity>> activitys = new ArrayList();
  public final ArrayList<WeakReference<AppActivity>> appActivities = new ArrayList();
  protected final ArrayList<WeakReference<AppService>> appServices = new ArrayList();
  public Queue<Pair<Long, String>> broadcastInfoQueue;
  private Runnable doExit;
  private boolean isCrashed;
  public boolean isPCActive;
  private ArrayList<AppCallback> mAppCallbacks;
  private AppRuntime mAppRuntime;
  final Handler mHandler;
  private volatile AtomicInteger mRuntimeState;
  private MainService mService;
  protected final ArrayList<WeakReference<Activity>> otherTypeActivitys = new ArrayList();
  private volatile Properties properties;
  List<SimpleAccount> sortAccountList;
  public String startComponentInfo;
  private boolean stopMSF;
  private boolean stopMsfOnCrash;
  private Handler subHandler;
  
  static
  {
    BROADCAST_WHITE_LIST = new ArraySet();
    sIsToolProc = false;
  }
  
  public MobileQQ()
  {
    BROADCAST_WHITE_LIST.add("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
    BROADCAST_WHITE_LIST.add("com.android.launcher.action.INSTALL_SHORTCUT");
    BROADCAST_WHITE_LIST.add("android.intent.action.APPLICATION_MESSAGE_UPDATE");
    BROADCAST_WHITE_LIST.add("com.tencent.qlauncher.action.ACTION_UPDATE_SHORTCUT");
    BROADCAST_WHITE_LIST.add("android.intent.action.BADGE_COUNT_UPDATE");
    BROADCAST_WHITE_LIST.add("com.sonyericsson.home.action.UPDATE_BADGE");
    BROADCAST_WHITE_LIST.add("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
    BROADCAST_WHITE_LIST.add("com.miui.util.LongScreenshotUtils.LongScreenshot");
    this.stopMsfOnCrash = false;
    this.isPCActive = false;
    this.broadcastInfoQueue = new LinkedList();
    this.startComponentInfo = null;
    this.mRuntimeState = new AtomicInteger(1);
    this.mHandler = new Handler(this);
    this.mAppCallbacks = new ArrayList();
    this.stopMSF = false;
    this.doExit = new MobileQQ.3(this);
    this.sortAccountList = null;
  }
  
  public static void addBroadcastWhitList(Collection<String> paramCollection)
  {
    if (paramCollection != null) {
      synchronized (BROADCAST_WHITE_LIST)
      {
        BROADCAST_WHITE_LIST.addAll(paramCollection);
        return;
      }
    }
  }
  
  private void ensureInitProperty()
  {
    Object localObject4;
    if (this.properties == null) {
      for (;;)
      {
        Properties localProperties;
        Object localObject1;
        FileInputStream localFileInputStream;
        try
        {
          if (this.properties == null)
          {
            localProperties = new Properties();
            localObject4 = null;
            localObject1 = null;
          }
        }
        finally {}
        try
        {
          localFileInputStream = openFileInput("Properties");
          localObject1 = localFileInputStream;
          localObject4 = localFileInputStream;
          localProperties.load(localFileInputStream);
          if (localFileInputStream == null) {}
        }
        catch (Exception localException)
        {
          localObject4 = localObject2;
          QLog.e("mqq", 1, "", localException);
          if (localObject2 == null) {
            continue;
          }
          try
          {
            localObject2.close();
          }
          catch (IOException localIOException2)
          {
            localIOException2.printStackTrace();
          }
          continue;
        }
        finally
        {
          if (localObject4 == null) {
            break label118;
          }
          try
          {
            localObject4.close();
            throw localObject3;
          }
          catch (IOException localIOException3)
          {
            for (;;)
            {
              localIOException3.printStackTrace();
            }
          }
        }
        try
        {
          localFileInputStream.close();
          this.properties = localProperties;
          return;
        }
        catch (IOException localIOException1)
        {
          localIOException1.printStackTrace();
        }
      }
    }
    label118:
  }
  
  private void exit(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.stopMSF = paramBoolean2;
    Object localObject;
    if (getQQProcessName().endsWith(":video"))
    {
      localObject = this.mService.msfSub;
      if (paramBoolean1) {
        break label130;
      }
    }
    label130:
    for (paramBoolean2 = true;; paramBoolean2 = false)
    {
      ((MsfServiceSdk)localObject).unRegisterMsfService(Boolean.valueOf(paramBoolean2));
      this.mService.reportMSFCallBackCost(-1L, true);
      closeAllActivitys();
      QLog.d("mqq", 1, "exit isCrashed=" + this.isCrashed + " stopMsfOnCrash=" + this.stopMsfOnCrash);
      localObject = new MobileQQ.1(this, paramBoolean1);
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
    if ((paramContext == null) || (paramString == null)) {
      return false;
    }
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext != null)
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (localRunningAppProcessInfo.processName.equals(paramString))
        {
          if (QLog.isColorLevel()) {
            QLog.d("mqq", 2, "kill process = " + paramString);
          }
          Process.killProcess(localRunningAppProcessInfo.pid);
          return true;
        }
      }
    }
    return false;
  }
  
  public static void restrictBroadcast(Intent paramIntent)
  {
    if ((TextUtils.isEmpty(paramIntent.getPackage())) && ((paramIntent.getFlags() & 0x1000000) == 0)) {
      synchronized (BROADCAST_WHITE_LIST)
      {
        boolean bool = hasInit;
        if (!bool)
        {
          try
          {
            Object localObject = getContext().getSharedPreferences("broadcast_white_pref", 4).getString("white_list", null);
            if (localObject != null)
            {
              localObject = new JSONObject((String)localObject).getJSONArray("white_list");
              int i = 0;
              while (i < ((JSONArray)localObject).length())
              {
                BROADCAST_WHITE_LIST.add(((JSONArray)localObject).optString(i, ""));
                i += 1;
              }
            }
            if (BROADCAST_WHITE_LIST.contains(paramIntent.getAction())) {
              break label151;
            }
          }
          catch (Throwable localThrowable)
          {
            hasInit = true;
          }
        }
        else
        {
          paramIntent.setPackage("com.tencent.mobileqq");
          if (QLog.isColorLevel()) {
            QLog.i("mqq", 2, "sending broadcast without package");
          }
        }
        label151:
        return;
      }
    }
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
    MobileQQ.2 local2 = new MobileQQ.2(this);
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
  
  void createNewRuntime(SimpleAccount paramSimpleAccount, boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    QLog.d("MobileQQ", 1, "createNewRuntime, " + paramBoolean2 + paramBoolean1 + paramInt + paramString);
    paramSimpleAccount = new MobileQQ.5(this, paramSimpleAccount, paramInt, paramBoolean1, paramBoolean2, paramString);
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
    if (getPackageName().equals(getQQProcessName()))
    {
      if (i != 0) {
        break label613;
      }
      if (this.accountChanged)
      {
        if (paramBoolean) {
          break label590;
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
    try
    {
      QIPCServerHelper.getInstance().notifyOnAccountChanged();
      return;
    }
    catch (Exception paramLogoutReason)
    {
      QLog.d("mqq", 1, "onAccountChanged", paramLogoutReason);
      return;
    }
    label590:
    paramLogoutReason = new Intent("com.tencent.mobileqq__alive");
    paramLogoutReason.setPackage("com.tencent.mobileqq");
    sendBroadcast(paramLogoutReason);
    return;
    label613:
    sendBroadcast(new Intent("mqq.intent.action.LOGOUT"));
  }
  
  /* Error */
  public final void doInit(boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: iconst_0
    //   4: istore_2
    //   5: aload_0
    //   6: getfield 179	mqq/app/MobileQQ:mRuntimeState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   9: iconst_1
    //   10: iconst_2
    //   11: invokevirtual 644	java/util/concurrent/atomic/AtomicInteger:compareAndSet	(II)Z
    //   14: ifne +4 -> 18
    //   17: return
    //   18: aload_0
    //   19: getstatic 645	mqq/app/MobileQQ:processName	Ljava/lang/String;
    //   22: invokevirtual 648	mqq/app/MobileQQ:isNeedMSF	(Ljava/lang/String;)Z
    //   25: istore_3
    //   26: ldc_w 265
    //   29: iconst_1
    //   30: new 314	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 315	java/lang/StringBuilder:<init>	()V
    //   37: ldc_w 650
    //   40: invokevirtual 321	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: getstatic 645	mqq/app/MobileQQ:processName	Ljava/lang/String;
    //   46: invokevirtual 321	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 329	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 333	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: getstatic 645	mqq/app/MobileQQ:processName	Ljava/lang/String;
    //   58: ldc_w 652
    //   61: invokevirtual 285	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   64: ifne +252 -> 316
    //   67: iload_3
    //   68: ifeq +248 -> 316
    //   71: aload_0
    //   72: new 287	mqq/app/MainService
    //   75: dup
    //   76: aload_0
    //   77: aload_0
    //   78: getstatic 645	mqq/app/MobileQQ:processName	Ljava/lang/String;
    //   81: invokevirtual 656	mqq/app/MobileQQ:getAppId	(Ljava/lang/String;)I
    //   84: aload_0
    //   85: getstatic 645	mqq/app/MobileQQ:processName	Ljava/lang/String;
    //   88: invokevirtual 659	mqq/app/MobileQQ:getBootBroadcastName	(Ljava/lang/String;)Ljava/lang/String;
    //   91: iload_1
    //   92: invokespecial 662	mqq/app/MainService:<init>	(Lmqq/app/MobileQQ;ILjava/lang/String;Z)V
    //   95: putfield 209	mqq/app/MobileQQ:mService	Lmqq/app/MainService;
    //   98: aload_0
    //   99: invokevirtual 279	mqq/app/MobileQQ:getQQProcessName	()Ljava/lang/String;
    //   102: ldc_w 281
    //   105: invokevirtual 285	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   108: ifne +13 -> 121
    //   111: aload_0
    //   112: getfield 209	mqq/app/MobileQQ:mService	Lmqq/app/MainService;
    //   115: getfield 291	mqq/app/MainService:msfSub	Lcom/tencent/mobileqq/msf/sdk/MsfServiceSdk;
    //   118: invokevirtual 665	com/tencent/mobileqq/msf/sdk/MsfServiceSdk:initMsfService	()V
    //   121: aload_0
    //   122: invokevirtual 668	mqq/app/MobileQQ:getAllAccounts	()Ljava/util/List;
    //   125: astore 5
    //   127: aload 5
    //   129: ifnull +16 -> 145
    //   132: aload 5
    //   134: iconst_0
    //   135: invokeinterface 540 2 0
    //   140: checkcast 670	com/tencent/qphone/base/remote/SimpleAccount
    //   143: astore 4
    //   145: aload 4
    //   147: astore 5
    //   149: aload 4
    //   151: ifnonnull +140 -> 291
    //   154: ldc_w 265
    //   157: iconst_1
    //   158: ldc_w 672
    //   161: invokestatic 333	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   164: aload_0
    //   165: ldc 42
    //   167: iconst_0
    //   168: invokevirtual 673	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   171: astore 7
    //   173: aload 4
    //   175: astore 5
    //   177: aload 7
    //   179: ifnull +112 -> 291
    //   182: aload 7
    //   184: ldc 39
    //   186: aconst_null
    //   187: invokeinterface 461 3 0
    //   192: astore 6
    //   194: invokestatic 417	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   197: ifeq +31 -> 228
    //   200: ldc_w 265
    //   203: iconst_1
    //   204: new 314	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 315	java/lang/StringBuilder:<init>	()V
    //   211: ldc_w 675
    //   214: invokevirtual 321	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: aload 6
    //   219: invokevirtual 321	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: invokevirtual 329	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokestatic 333	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   228: aload 4
    //   230: astore 5
    //   232: aload 6
    //   234: ifnull +57 -> 291
    //   237: aload 7
    //   239: invokeinterface 679 1 0
    //   244: ldc 39
    //   246: invokeinterface 684 2 0
    //   251: invokeinterface 687 1 0
    //   256: pop
    //   257: new 670	com/tencent/qphone/base/remote/SimpleAccount
    //   260: dup
    //   261: invokespecial 688	com/tencent/qphone/base/remote/SimpleAccount:<init>	()V
    //   264: astore 5
    //   266: aload 5
    //   268: aload 6
    //   270: invokevirtual 691	com/tencent/qphone/base/remote/SimpleAccount:setUin	(Ljava/lang/String;)V
    //   273: aload 5
    //   275: invokevirtual 694	com/tencent/qphone/base/remote/SimpleAccount:isLogined	()Z
    //   278: pop
    //   279: aload 5
    //   281: ldc_w 696
    //   284: iconst_1
    //   285: invokestatic 699	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   288: invokevirtual 703	com/tencent/qphone/base/remote/SimpleAccount:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
    //   291: iload_2
    //   292: istore_1
    //   293: getstatic 645	mqq/app/MobileQQ:processName	Ljava/lang/String;
    //   296: ldc 31
    //   298: invokevirtual 414	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   301: ifeq +5 -> 306
    //   304: iconst_1
    //   305: istore_1
    //   306: aload_0
    //   307: aload 5
    //   309: iconst_0
    //   310: iload_1
    //   311: iconst_5
    //   312: aconst_null
    //   313: invokevirtual 705	mqq/app/MobileQQ:createNewRuntime	(Lcom/tencent/qphone/base/remote/SimpleAccount;ZZILjava/lang/String;)V
    //   316: aload_0
    //   317: new 432	android/content/Intent
    //   320: dup
    //   321: new 314	java/lang/StringBuilder
    //   324: dup
    //   325: invokespecial 315	java/lang/StringBuilder:<init>	()V
    //   328: ldc_w 707
    //   331: invokevirtual 321	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: getstatic 645	mqq/app/MobileQQ:processName	Ljava/lang/String;
    //   337: invokevirtual 321	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: invokevirtual 329	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: invokespecial 599	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   346: invokevirtual 618	mqq/app/MobileQQ:sendBroadcast	(Landroid/content/Intent;)V
    //   349: aload_0
    //   350: getfield 179	mqq/app/MobileQQ:mRuntimeState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   353: astore 4
    //   355: aload 4
    //   357: monitorenter
    //   358: aload_0
    //   359: getfield 179	mqq/app/MobileQQ:mRuntimeState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   362: iconst_3
    //   363: invokevirtual 710	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   366: aload_0
    //   367: getfield 179	mqq/app/MobileQQ:mRuntimeState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   370: invokevirtual 715	java/lang/Object:notifyAll	()V
    //   373: aload 4
    //   375: monitorexit
    //   376: ldc_w 265
    //   379: iconst_1
    //   380: ldc_w 717
    //   383: invokestatic 333	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   386: aload_0
    //   387: getfield 186	mqq/app/MobileQQ:mHandler	Landroid/os/Handler;
    //   390: iconst_2
    //   391: ldc2_w 718
    //   394: invokevirtual 723	android/os/Handler:sendEmptyMessageDelayed	(IJ)Z
    //   397: pop
    //   398: return
    //   399: astore 5
    //   401: aload 4
    //   403: monitorexit
    //   404: aload 5
    //   406: athrow
    //   407: astore 4
    //   409: ldc_w 265
    //   412: iconst_1
    //   413: ldc_w 725
    //   416: aload 4
    //   418: invokestatic 273	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   421: new 727	java/lang/RuntimeException
    //   424: dup
    //   425: aload 4
    //   427: invokespecial 730	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   430: athrow
    //   431: astore 5
    //   433: aload_0
    //   434: getfield 179	mqq/app/MobileQQ:mRuntimeState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   437: astore 4
    //   439: aload 4
    //   441: monitorenter
    //   442: aload_0
    //   443: getfield 179	mqq/app/MobileQQ:mRuntimeState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   446: iconst_3
    //   447: invokevirtual 710	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   450: aload_0
    //   451: getfield 179	mqq/app/MobileQQ:mRuntimeState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   454: invokevirtual 715	java/lang/Object:notifyAll	()V
    //   457: aload 4
    //   459: monitorexit
    //   460: ldc_w 265
    //   463: iconst_1
    //   464: ldc_w 717
    //   467: invokestatic 333	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   470: aload_0
    //   471: getfield 186	mqq/app/MobileQQ:mHandler	Landroid/os/Handler;
    //   474: iconst_2
    //   475: ldc2_w 718
    //   478: invokevirtual 723	android/os/Handler:sendEmptyMessageDelayed	(IJ)Z
    //   481: pop
    //   482: aload 5
    //   484: athrow
    //   485: astore 5
    //   487: aload 4
    //   489: monitorexit
    //   490: aload 5
    //   492: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	493	0	this	MobileQQ
    //   0	493	1	paramBoolean	boolean
    //   4	288	2	bool1	boolean
    //   25	43	3	bool2	boolean
    //   407	19	4	localThrowable	Throwable
    //   125	183	5	localObject2	Object
    //   399	6	5	localObject3	Object
    //   431	52	5	localObject4	Object
    //   485	6	5	localObject5	Object
    //   192	77	6	str	String
    //   171	67	7	localSharedPreferences	SharedPreferences
    // Exception table:
    //   from	to	target	type
    //   358	376	399	finally
    //   401	404	399	finally
    //   18	67	407	java/lang/Throwable
    //   71	121	407	java/lang/Throwable
    //   121	127	407	java/lang/Throwable
    //   132	145	407	java/lang/Throwable
    //   154	173	407	java/lang/Throwable
    //   182	228	407	java/lang/Throwable
    //   237	291	407	java/lang/Throwable
    //   293	304	407	java/lang/Throwable
    //   306	316	407	java/lang/Throwable
    //   316	349	407	java/lang/Throwable
    //   18	67	431	finally
    //   71	121	431	finally
    //   121	127	431	finally
    //   132	145	431	finally
    //   154	173	431	finally
    //   182	228	431	finally
    //   237	291	431	finally
    //   293	304	431	finally
    //   306	316	431	finally
    //   316	349	431	finally
    //   409	431	431	finally
    //   442	460	485	finally
    //   487	490	485	finally
  }
  
  public boolean doesHasPhonePermission()
  {
    if (!sHasPhonePermission)
    {
      if (Build.VERSION.SDK_INT < 23) {
        break label42;
      }
      if ((context == null) || (context.checkSelfPermission(PERMS[1]) != 0)) {}
    }
    label42:
    for (sHasPhonePermission = true;; sHasPhonePermission = true) {
      return sHasPhonePermission;
    }
  }
  
  public boolean doesHasSDCardPermission()
  {
    if (!sHasSDCardPermission)
    {
      if (Build.VERSION.SDK_INT < 23) {
        break label42;
      }
      if ((context == null) || (context.checkSelfPermission(PERMS[0]) != 0)) {}
    }
    label42:
    for (sHasSDCardPermission = true;; sHasSDCardPermission = true) {
      return sHasSDCardPermission;
    }
  }
  
  public List<SimpleAccount> getAllAccounts()
  {
    if (this.sortAccountList == null) {
      return refreAccountList();
    }
    return this.sortAccountList;
  }
  
  public List<SimpleAccount> getAllNotSynAccountList()
  {
    return this.sortAccountList;
  }
  
  public abstract int getAppId(String paramString);
  
  public AppRuntime getAppRuntime(String paramString)
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
  
  public int getMsfConnectedNetType()
  {
    try
    {
      int i = this.mService.msfSub.getConnectedNetowrkType();
      return i;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  public String getProperty(String paramString)
  {
    ensureInitProperty();
    return this.properties.getProperty(paramString);
  }
  
  public String getQQProcessName()
  {
    String str;
    if (processName == null)
    {
      int i = 0;
      do
      {
        str = MsfSdkUtils.getProcessName(this);
        i += 1;
      } while ((i < 3) && ("unknown".equals(str)));
      if (!"unknown".equals(str)) {
        break label57;
      }
      str = "com.tencent.mobileqq";
    }
    label57:
    for (;;)
    {
      processName = str;
      BaseApplication.processName = str;
      return processName;
    }
  }
  
  public WeakReference<BaseActivity> getResumeActivity()
  {
    Iterator localIterator = this.activitys.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if (((BaseActivity)localWeakReference.get()).isResume()) {
        return localWeakReference;
      }
    }
    return null;
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
  
  public boolean isModuleLoaded(String paramString)
  {
    if (paramString != null)
    {
      paramString = (Boolean)S_MODULE_LOADED.get(paramString);
      if (paramString != null) {
        return paramString.booleanValue();
      }
    }
    return false;
  }
  
  public abstract boolean isNeedMSF(String paramString);
  
  public boolean isRuntimeReady()
  {
    return this.mRuntimeState.get() == 3;
  }
  
  public void loadModule(String paramString)
  {
    if (paramString == null) {
      return;
    }
    S_MODULE_LOADED.put(paramString, Boolean.valueOf(true));
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
  
  public void onSendBroadcast(Context paramContext, Intent paramIntent)
  {
    for (;;)
    {
      synchronized (this.mAppCallbacks)
      {
        if (this.mAppCallbacks.size() <= 0) {
          break label77;
        }
        arrayOfObject = this.mAppCallbacks.toArray();
        if (arrayOfObject != null)
        {
          int j = arrayOfObject.length;
          int i = 0;
          if (i < j)
          {
            ((AppCallback)arrayOfObject[i]).onSendBroadcast(paramContext, paramIntent);
            i += 1;
          }
        }
      }
      return;
      label77:
      Object[] arrayOfObject = null;
    }
  }
  
  public void otherProcessExit(boolean paramBoolean)
  {
    exit(paramBoolean, false);
  }
  
  public AppRuntime peekAppRuntime()
  {
    return this.mAppRuntime;
  }
  
  public void qqProcessExit(boolean paramBoolean)
  {
    exit(false, paramBoolean);
  }
  
  public List<SimpleAccount> refreAccountList()
  {
    return setSortAccountList(MsfSdkUtils.getLoginedAccountList());
  }
  
  public void registerAppCallbacks(AppCallback paramAppCallback)
  {
    synchronized (this.mAppCallbacks)
    {
      this.mAppCallbacks.add(paramAppCallback);
      return;
    }
  }
  
  void removeActivity(BaseActivity paramBaseActivity)
  {
    this.activitys.remove(new WeakReference(paramBaseActivity));
  }
  
  public void removeOtherTypeActivity(Activity paramActivity) {}
  
  public void reportPCActive(String paramString, int paramInt) {}
  
  public void sendBroadcast(Intent paramIntent)
  {
    restrictBroadcast(paramIntent);
    super.sendBroadcast(paramIntent);
    sMobileQQ.onSendBroadcast(this, paramIntent);
  }
  
  public void sendBroadcast(Intent paramIntent, String paramString)
  {
    restrictBroadcast(paramIntent);
    super.sendBroadcast(paramIntent, paramString);
    sMobileQQ.onSendBroadcast(this, paramIntent);
  }
  
  public void sendOrderedBroadcast(Intent paramIntent, String paramString)
  {
    restrictBroadcast(paramIntent);
    super.sendOrderedBroadcast(paramIntent, paramString);
    sMobileQQ.onSendBroadcast(this, paramIntent);
  }
  
  public void sendOrderedBroadcast(Intent paramIntent, String paramString1, BroadcastReceiver paramBroadcastReceiver, Handler paramHandler, int paramInt, String paramString2, Bundle paramBundle)
  {
    restrictBroadcast(paramIntent);
    super.sendOrderedBroadcast(paramIntent, paramString1, paramBroadcastReceiver, paramHandler, paramInt, paramString2, paramBundle);
    sMobileQQ.onSendBroadcast(this, paramIntent);
  }
  
  public void setAutoLogin(boolean paramBoolean)
  {
    if ((this.mAppRuntime != null) && (this.mAppRuntime.getAccount() != null) && (this.mAppRuntime.getAccount().length() > 0)) {
      this.mAppRuntime.setAutoLogin(paramBoolean);
    }
  }
  
  public void setProperty(String arg1, String paramString2)
  {
    ensureInitProperty();
    this.properties.setProperty(???, paramString2);
    if (???.endsWith(Constants.Key._logintime.toString())) {
      setSortAccountList(this.sortAccountList);
    }
    if (this.subHandler == null) {}
    synchronized (this.properties)
    {
      if (this.subHandler == null)
      {
        paramString2 = new HandlerThread("property-saver");
        paramString2.start();
        this.subHandler = new Handler(paramString2.getLooper());
      }
      this.subHandler.post(new MobileQQ.6(this));
      return;
    }
  }
  
  public List<SimpleAccount> setSortAccountList(List<SimpleAccount> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Collections.sort(paramList, new MobileQQ.4(this));
      if (paramList != this.sortAccountList) {
        this.sortAccountList = paramList;
      }
    }
    return this.sortAccountList;
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
            Intent localIntent = new Intent("com.tencent.process.exit");
            localIntent.putExtra("procName", "com.tencent.mobileqq:MSF");
            localIntent.putExtra("verify", MsfExitReceiver.getLocalVerify("com.tencent.mobileqq:MSF", false));
            sendBroadcast(localIntent);
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
  
  public void unregisterAppCallbacks(AppCallback paramAppCallback)
  {
    synchronized (this.mAppCallbacks)
    {
      this.mAppCallbacks.remove(paramAppCallback);
      return;
    }
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