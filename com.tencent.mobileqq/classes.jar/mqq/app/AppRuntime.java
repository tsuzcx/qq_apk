package mqq.app;

import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.RdmReq;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.ref.Reference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.manager.Manager;
import mqq.observer.AccountObserver;
import mqq.observer.BusinessObserver;
import mqq.observer.SSOAccountObserver;
import mqq.observer.SubAccountObserver;
import mqq.util.WeakReference;

public abstract class AppRuntime
{
  public static final int ACCOUNT_MANAGER = 0;
  public static final int END_UN_LOGIN_MANAGER = 8;
  public static final int LOGIN_AUTO = 2;
  public static final int LOGIN_MANUAL = 1;
  public static final int LOGIN_UNINIT = 0;
  public static final String PROCESS = "process";
  public static final int PROXY_IP_MANAGER = 3;
  public static final int PUSH_MANAGER = 5;
  protected static final int SECURE_FILE_FRAMEWORK_MANAGER = 8;
  public static final int SERVER_CONFIG_MANAGER = 4;
  protected static final String TAG = "mqq";
  public static final int TICKET_MANAGER = 2;
  public static final int TYPE_CREATENEWRUNTIME_CHANGUIN_LOGIN = 4;
  public static final int TYPE_CREATENEWRUNTIME_DIRECT_LOGIN = 1;
  public static final int TYPE_CREATENEWRUNTIME_DIRECT_NET_LOGIN = 3;
  public static final int TYPE_CREATENEWRUNTIME_DOINIT = 5;
  public static final int TYPE_CREATENEWRUNTIME_SWITCHACCOUNT = 2;
  public static final int VERIFYCODE_MANAGER = 6;
  public static final int VERIFYDEVLOCK_MANAGER = 7;
  public static final int WTLOGIN_MANAGER = 1;
  private int batteryCapacity = 0;
  private ConcurrentHashMap<String, String> businessRootFilePaths = new ConcurrentHashMap();
  private CountDownLatch countDownLatch;
  public boolean isBackgroundPause = false;
  public boolean isBackgroundStop = false;
  public boolean isClearTaskBySystem = false;
  protected boolean isLogin;
  private boolean isRunning;
  private long lUin = -1L;
  private SimpleAccount mAccount;
  private MobileQQ mContext;
  private Intent mDevLockIntent = null;
  private Handler mHandler;
  private Intent mKickIntent = null;
  private MainService mService;
  public final ServletContainer mServletContainer = new ServletContainer(this);
  private IAppStateChangeListener mStateChangeListener;
  private String mTempPath;
  ToolProcReceiver mToolReceiver;
  private SparseArray<Manager> managers = new SparseArray();
  Bundle modularSaveInstance;
  private final List<Reference<BusinessObserver>> observers = new Vector();
  private AppRuntime.Status onlineStatus = AppRuntime.Status.offline;
  public AppRuntime parentRuntime = null;
  private int powerConnect = -1;
  ConcurrentHashMap<String, AppRuntime> subRuntimeMap = new ConcurrentHashMap();
  private long uExtOnlineStatus = -1L;
  byte[] uinSign = null;
  
  @Nullable
  private String callMainProcessForSecurityFileResult(@Nullable ISecurityFileHelper paramISecurityFileHelper)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SecurityFileFrameworkManagerImpl", 2, new Object[] { "callMainProcessForSecurityFileResult from= ", MobileQQ.processName });
    }
    this.mTempPath = null;
    Bundle localBundle = new Bundle();
    if (paramISecurityFileHelper != null) {
      localBundle.putString("BUNDLE_KEY_SECURITY_FILE_HELPER_CLASS_NAME", paramISecurityFileHelper.getClass().getName());
    }
    paramISecurityFileHelper = QIPCClientHelper.getInstance().getClient().callServer("SecurityFileModule", "ACTION_GET_BUSINESS_ROOT_PATH", localBundle);
    if (paramISecurityFileHelper != null) {
      if (paramISecurityFileHelper.isSuccess())
      {
        this.mTempPath = paramISecurityFileHelper.data.getString("BUNDLE_KEY_RETURN_FILE_PATH");
        if (TextUtils.isEmpty(this.mTempPath)) {
          QLog.d("SecurityFileFrameworkManagerImpl", 1, "result success but path is empty");
        }
      }
    }
    for (;;)
    {
      return this.mTempPath;
      if (QLog.isColorLevel())
      {
        QLog.d("SecurityFileFrameworkManagerImpl", 2, this.mTempPath);
        continue;
        QLog.d("SecurityFileFrameworkManagerImpl", 1, new Object[] { "result fail: code=", Integer.valueOf(paramISecurityFileHelper.code) });
        if ((paramISecurityFileHelper.e != null) && (QLog.isColorLevel()))
        {
          QLog.d("SecurityFileFrameworkManagerImpl", 2, new Object[] { "result fail: e=", paramISecurityFileHelper.e.getMessage() });
          continue;
          QLog.d("SecurityFileFrameworkManagerImpl", 1, "result null ");
        }
      }
    }
  }
  
  protected void addManager(int paramInt, Manager paramManager)
  {
    synchronized (this.managers)
    {
      if (this.managers.indexOfKey(paramInt) >= 0) {
        throw new IllegalArgumentException("addManager duplicated name = " + paramInt);
      }
    }
    this.managers.put(paramInt, paramManager);
  }
  
  protected boolean canAutoLogin(String paramString)
  {
    boolean bool1 = true;
    if (this.parentRuntime != null) {
      this.parentRuntime.canAutoLogin(paramString);
    }
    boolean bool2;
    if ((paramString == null) || (paramString.length() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SharedPreUtils", 2, "CNR getAutoLoginSharePre uin is null");
      }
      bool2 = false;
      return bool2;
    }
    SharedPreferences localSharedPreferences = this.mContext.getSharedPreferences("sp_login_auto", 4);
    int j = localSharedPreferences.getInt(paramString, 0);
    if (QLog.isColorLevel()) {
      QLog.d("SharedPreUtils", 2, "CNR getAutoLoginSharePre auto flag =" + j);
    }
    int i = j;
    if (j == 0)
    {
      this.mContext.getSharedPreferences(this.mContext.getPackageName() + "_preferences", 4);
      if (localSharedPreferences.getBoolean("login_auto" + paramString, true))
      {
        i = 2;
        label182:
        localSharedPreferences.edit().putInt(paramString, i).commit();
      }
    }
    else
    {
      if (i != 2) {
        break label253;
      }
    }
    for (;;)
    {
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SharedPreUtils", 2, "CNR getAutoLoginSharePre auto =" + bool1);
      return bool1;
      i = 1;
      break label182;
      label253:
      bool1 = false;
    }
  }
  
  public void exitToolProc()
  {
    onDestroy();
    Process.killProcess(Process.myPid());
  }
  
  public String getAccount()
  {
    if (this.parentRuntime != null) {
      return this.parentRuntime.getAccount();
    }
    if (this.mAccount == null) {
      return null;
    }
    return this.mAccount.getUin();
  }
  
  public AppRuntime getAppRuntime(String paramString)
  {
    if (this.parentRuntime != null) {
      paramString = this.parentRuntime.getAppRuntime(paramString);
    }
    Object localObject;
    do
    {
      return paramString;
      localObject = null;
      if (!TextUtils.isEmpty(paramString)) {
        synchronized (paramString.intern())
        {
          AppRuntime localAppRuntime = (AppRuntime)this.subRuntimeMap.get(paramString);
          localObject = localAppRuntime;
          if (localAppRuntime == null)
          {
            localAppRuntime = onGetSubRuntime(paramString);
            localObject = localAppRuntime;
            if (localAppRuntime != null)
            {
              localAppRuntime.setProxy(this);
              localAppRuntime.onCreate(this.modularSaveInstance);
              this.subRuntimeMap.put(paramString, localAppRuntime);
              localObject = localAppRuntime;
            }
          }
        }
      }
      paramString = this;
    } while (localObject == null);
    return localObject;
  }
  
  public MobileQQ getApplication()
  {
    return MobileQQ.sMobileQQ;
  }
  
  public int getBatteryCapacity()
  {
    if (this.parentRuntime != null) {
      return this.parentRuntime.getBatteryCapacity();
    }
    return this.batteryCapacity;
  }
  
  public Intent getDevLockIntent()
  {
    if (this.parentRuntime != null) {
      return this.parentRuntime.getDevLockIntent();
    }
    return this.mDevLockIntent;
  }
  
  public long getExtOnlineStatus()
  {
    if (this.parentRuntime != null) {
      return this.parentRuntime.getExtOnlineStatus();
    }
    return this.uExtOnlineStatus;
  }
  
  public Intent getKickIntent()
  {
    if (this.parentRuntime != null) {
      return this.parentRuntime.getKickIntent();
    }
    return this.mKickIntent;
  }
  
  public long getLongAccountUin()
  {
    if (this.parentRuntime != null) {
      return this.parentRuntime.getLongAccountUin();
    }
    if (this.lUin < 0L) {}
    try
    {
      String str = getAccount();
      if ((str != null) && (str.length() > 0)) {
        this.lUin = Long.parseLong(getAccount());
      }
    }
    catch (Exception localException)
    {
      label51:
      break label51;
    }
    return this.lUin;
  }
  
  public Manager getManager(int paramInt)
  {
    Manager localManager1;
    if (this.parentRuntime != null)
    {
      localManager1 = this.parentRuntime.getManager(paramInt);
      if (localManager1 != null) {
        return localManager1;
      }
    }
    synchronized (this.managers)
    {
      localManager1 = (Manager)this.managers.get(paramInt);
      if (localManager1 != null) {
        return localManager1;
      }
    }
    Manager localManager3 = localManager2;
    if (this.parentRuntime == null) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      localManager3 = localManager2;
      if (localManager2 != null)
      {
        addManager(paramInt, localManager2);
        localManager3 = localManager2;
      }
      return localManager3;
      Object localObject = new WtloginManagerImpl(this);
      continue;
      localObject = new AccountManagerImpl(this);
      continue;
      localObject = new TicketManagerImpl(this);
      continue;
      localObject = new ProxyIpManagerImpl(this);
    }
  }
  
  protected String[] getMessagePushSSOCommands()
  {
    return null;
  }
  
  protected Class<? extends MSFServlet>[] getMessagePushServlets()
  {
    return null;
  }
  
  public String getModuleId()
  {
    return null;
  }
  
  public AppRuntime.Status getOnlineStatus()
  {
    if (this.parentRuntime != null) {
      return this.parentRuntime.getOnlineStatus();
    }
    return this.onlineStatus;
  }
  
  public AppRuntime.Status getOnlineStatusNonSync()
  {
    if (this.parentRuntime != null) {
      return this.parentRuntime.getOnlineStatusNonSync();
    }
    return this.onlineStatus;
  }
  
  public int getPowerConnect()
  {
    if (this.parentRuntime != null) {
      return this.parentRuntime.getPowerConnect();
    }
    return this.powerConnect;
  }
  
  public final SharedPreferences getPreferences()
  {
    String str2 = getAccount();
    String str1 = str2;
    if (str2 == null) {
      str1 = "noLogin";
    }
    return getApplication().getSharedPreferences(str1, 0);
  }
  
  public int getRunningModuleSize()
  {
    if (this.parentRuntime != null) {
      return this.parentRuntime.getRunningModuleSize();
    }
    return this.subRuntimeMap.size();
  }
  
  @Nullable
  public File getSecurityBusinessRootFile(@NonNull ISecurityFileHelper paramISecurityFileHelper)
  {
    if (this.businessRootFilePaths.containsKey(paramISecurityFileHelper.declareBusinessFileName())) {
      localObject = new File((String)this.businessRootFilePaths.get(paramISecurityFileHelper.declareBusinessFileName()));
    }
    File localFile;
    do
    {
      return localObject;
      if (!"com.tencent.mobileqq".equals(MobileQQ.processName)) {
        break;
      }
      localFile = ((SecurityFileFrameworkManagerImpl)getManager(8)).getUINRootFile(paramISecurityFileHelper);
      localObject = localFile;
    } while (localFile == null);
    this.businessRootFilePaths.put(paramISecurityFileHelper.declareBusinessFileName(), localFile.getAbsolutePath());
    return localFile;
    Object localObject = callMainProcessForSecurityFileResult(paramISecurityFileHelper);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    this.businessRootFilePaths.put(paramISecurityFileHelper.declareBusinessFileName(), localObject);
    return new File((String)localObject);
  }
  
  @Nullable
  public File getSecurityUINRootFile()
  {
    if (this.businessRootFilePaths.containsKey("SecurityUINRootFile")) {
      localObject = new File((String)this.businessRootFilePaths.get("SecurityUINRootFile"));
    }
    File localFile;
    do
    {
      return localObject;
      if (!"com.tencent.mobileqq".equals(MobileQQ.processName)) {
        break;
      }
      localFile = ((SecurityFileFrameworkManagerImpl)getManager(8)).getUINRootFile(null);
      localObject = localFile;
    } while (localFile == null);
    this.businessRootFilePaths.put("SecurityUINRootFile", localFile.getAbsolutePath());
    return localFile;
    Object localObject = callMainProcessForSecurityFileResult(null);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    this.businessRootFilePaths.put("SecurityUINRootFile", localObject);
    return new File((String)localObject);
  }
  
  protected MainService getService()
  {
    if (this.parentRuntime != null) {
      return this.parentRuntime.getService();
    }
    return this.mService;
  }
  
  protected ServletContainer getServletContainer()
  {
    return this.mServletContainer;
  }
  
  public void getSubAccountKey(String paramString1, String paramString2, SubAccountObserver paramSubAccountObserver)
  {
    NewIntent localNewIntent = new NewIntent(getApplication(), BuiltInServlet.class);
    localNewIntent.setObserver(paramSubAccountObserver);
    localNewIntent.putExtra("subaccountuin", paramString2);
    localNewIntent.putExtra("mainaccount", paramString1);
    localNewIntent.putExtra("action", 1037);
    getServletContainer().forward(this, localNewIntent);
  }
  
  public byte[] getUinSign()
  {
    if (this.parentRuntime != null) {
      return this.parentRuntime.getUinSign();
    }
    if (this.uinSign == null)
    {
      this.uinSign = new byte[32];
      if (this.mAccount == null) {}
    }
    try
    {
      byte[] arrayOfByte1 = this.mAccount.getUin().toLowerCase().getBytes("utf-8");
      byte[] arrayOfByte2 = MD5.toMD5(arrayOfByte1).toLowerCase().getBytes("utf-8");
      byte[] arrayOfByte3 = new byte[arrayOfByte2.length + arrayOfByte1.length];
      System.arraycopy(arrayOfByte2, 0, arrayOfByte3, 0, arrayOfByte2.length);
      System.arraycopy(arrayOfByte1, 0, arrayOfByte3, arrayOfByte2.length, arrayOfByte1.length);
      this.uinSign = MD5.toMD5(arrayOfByte3).toLowerCase().getBytes("utf-8");
      return this.uinSign;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
  }
  
  void init(MobileQQ paramMobileQQ, MainService paramMainService, SimpleAccount paramSimpleAccount)
  {
    this.mService = paramMainService;
    this.mContext = paramMobileQQ;
    this.mAccount = paramSimpleAccount;
    this.lUin = -1L;
  }
  
  public boolean isLogin()
  {
    if (this.parentRuntime != null) {
      return this.parentRuntime.isLogin();
    }
    return this.isLogin;
  }
  
  public boolean isModuleRunning(String paramString)
  {
    if (this.parentRuntime != null) {
      return this.parentRuntime.isModuleRunning(paramString);
    }
    return this.subRuntimeMap.containsKey(paramString);
  }
  
  public boolean isRunning()
  {
    if (this.parentRuntime != null) {
      return this.parentRuntime.isRunning();
    }
    return this.isRunning;
  }
  
  public void kick(AppRuntime.KickParams paramKickParams)
  {
    MainService localMainService = getService();
    if (localMainService != null) {
      localMainService.kick(paramKickParams);
    }
  }
  
  public void login(SimpleAccount paramSimpleAccount)
  {
    if (this.parentRuntime != null)
    {
      this.parentRuntime.login(paramSimpleAccount);
      return;
    }
    runOnUiThread(new AppRuntime.1(this, paramSimpleAccount));
  }
  
  public void login(String paramString, byte[] paramArrayOfByte, AccountObserver paramAccountObserver)
  {
    getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
    NewIntent localNewIntent = new NewIntent(getApplication(), BuiltInServlet.class);
    localNewIntent.setObserver(paramAccountObserver);
    localNewIntent.putExtra("account", paramString);
    localNewIntent.putExtra("password", paramArrayOfByte);
    localNewIntent.putExtra("action", 1001);
    getServletContainer().forward(this, localNewIntent);
  }
  
  public void login(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, AccountObserver paramAccountObserver)
  {
    getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
    NewIntent localNewIntent = new NewIntent(getApplication(), BuiltInServlet.class);
    localNewIntent.setObserver(paramAccountObserver);
    localNewIntent.putExtra("account", paramString);
    localNewIntent.putExtra("password", paramArrayOfByte1);
    localNewIntent.putExtra("resp_register_supersig", paramArrayOfByte2);
    localNewIntent.putExtra("action", 1001);
    getServletContainer().forward(this, localNewIntent);
  }
  
  public void login(byte[] paramArrayOfByte1, String paramString, byte[] paramArrayOfByte2, AccountObserver paramAccountObserver)
  {
    getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
    NewIntent localNewIntent = new NewIntent(getApplication(), BuiltInServlet.class);
    localNewIntent.putExtra("to_login_uin_encrypt", paramArrayOfByte1);
    localNewIntent.putExtra("account", paramString);
    localNewIntent.putExtra("password", paramArrayOfByte2);
    localNewIntent.putExtra("action", 1001);
    localNewIntent.setObserver(paramAccountObserver);
    getServletContainer().forward(this, localNewIntent);
  }
  
  public void loginSubAccount(String paramString1, String paramString2, String paramString3, SubAccountObserver paramSubAccountObserver)
  {
    getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
    NewIntent localNewIntent = new NewIntent(getApplication(), BuiltInServlet.class);
    localNewIntent.setObserver(paramSubAccountObserver);
    localNewIntent.putExtra("mainaccount", paramString1);
    localNewIntent.putExtra("subaccount", paramString2);
    localNewIntent.putExtra("subpassword", paramString3);
    localNewIntent.putExtra("action", 1035);
    getServletContainer().forward(this, localNewIntent);
  }
  
  protected void logout(Constants.LogoutReason paramLogoutReason, boolean paramBoolean)
  {
    if (isLogin())
    {
      if (paramBoolean) {
        sendOnlineStatus(AppRuntime.Status.offline, false, 0L, false);
      }
      userLogoutReleaseData();
      this.isLogin = false;
      if (!QLog.isColorLevel()) {
        break label100;
      }
      QLog.w("mqq", 2, getAccount() + " logout by " + paramLogoutReason + ", " + paramBoolean);
    }
    for (;;)
    {
      if (paramLogoutReason != Constants.LogoutReason.switchAccount) {
        runOnUiThread(new AppRuntime.2(this, paramLogoutReason));
      }
      return;
      label100:
      QLog.w("mqq", 1, MsfSdkUtils.getShortUin(getAccount()) + " logout by " + paramLogoutReason + ", " + paramBoolean);
    }
  }
  
  public void logout(boolean paramBoolean)
  {
    logout(Constants.LogoutReason.user, paramBoolean);
  }
  
  void notifyObserver(BusinessObserver paramBusinessObserver, int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    runOnUiThread(new AppRuntime.3(this, paramBusinessObserver, paramInt, paramBoolean, paramBundle));
  }
  
  public void notifyObservers(Class<? extends BusinessObserver> paramClass, int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    synchronized (this.observers)
    {
      Iterator localIterator = this.observers.iterator();
      while (localIterator.hasNext())
      {
        BusinessObserver localBusinessObserver = (BusinessObserver)((Reference)localIterator.next()).get();
        if ((localBusinessObserver != null) && (paramClass != null) && ((paramClass == BusinessObserver.class) || (paramClass.isAssignableFrom(localBusinessObserver.getClass())))) {
          notifyObserver(localBusinessObserver, paramInt, paramBoolean, paramBundle);
        }
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    this.modularSaveInstance = paramBundle;
    if (getAccount() == null) {}
    for (;;)
    {
      this.isRunning = true;
      if (isLogin()) {
        start(true);
      }
      if (this.parentRuntime == null) {
        break;
      }
      return;
      getAccount();
    }
    this.mHandler = new Handler(Looper.getMainLooper());
    if (QLog.isColorLevel()) {
      QLog.i("mqq", 2, "[AppRuntime]" + getClass().getSimpleName() + " (" + getAccount() + ") onCreate,savedInstanceState=" + paramBundle);
    }
    for (;;)
    {
      addManager(0, new AccountManagerImpl(this));
      addManager(5, new PushManagerImpl(this));
      addManager(4, new ServerConfigManagerImpl(this));
      addManager(6, new VerifyCodeManagerImpl(this));
      addManager(7, new VerifyDevLockManagerImpl(this));
      if (!MobileQQ.processName.equals("com.tencent.mobileqq")) {
        break;
      }
      addManager(8, new SecurityFileFrameworkManagerImpl(this));
      return;
      QLog.i("mqq", 1, "[AppRuntime]" + getClass().getSimpleName() + " (" + MsfSdkUtils.getShortUin(getAccount()) + ") onCreate,savedInstanceState=" + paramBundle);
    }
  }
  
  public void onDestroy()
  {
    if (this.isRunning)
    {
      if (!QLog.isColorLevel()) {
        break label140;
      }
      QLog.i("mqq", 2, "[AppRuntime]" + getClass().getSimpleName() + " (" + getAccount() + ") onDestroy");
    }
    for (;;)
    {
      this.isRunning = false;
      getServletContainer().destroy();
      Object localObject = this.mService;
      if (localObject != null) {
        ((MainService)localObject).clearServlets();
      }
      if (this.mToolReceiver != null) {
        this.mToolReceiver.unRegister();
      }
      localObject = this.subRuntimeMap.values().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((AppRuntime)((Iterator)localObject).next()).onDestroy();
      }
      label140:
      QLog.i("mqq", 1, "[AppRuntime]" + getClass().getSimpleName() + " (" + MsfSdkUtils.getShortUin(getAccount()) + ") onDestroy");
    }
  }
  
  protected AppRuntime onGetSubRuntime(String paramString)
  {
    return null;
  }
  
  public void onGuardEvent(int paramInt, long paramLong1, long paramLong2)
  {
    NewIntent localNewIntent = new NewIntent(getApplication(), BuiltInServlet.class);
    localNewIntent.putExtra("action", 2200);
    localNewIntent.putExtra("k_event", paramInt);
    localNewIntent.putExtra("k_arg0", paramLong1);
    localNewIntent.putExtra("k_arg1", paramLong2);
    localNewIntent.withouLogin = true;
    localNewIntent.runNow = true;
    startServlet(localNewIntent);
  }
  
  protected void onProcPause() {}
  
  protected void onProcResume() {}
  
  public void onProxyIpChanged()
  {
    if (this.parentRuntime != null) {
      this.parentRuntime.onProxyIpChanged();
    }
  }
  
  public boolean onReceiveUnhandledKickedMsg(String paramString, Intent paramIntent)
  {
    return false;
  }
  
  protected void onRunningBackground()
  {
    this.isBackgroundStop = true;
    if (this.mStateChangeListener != null) {
      this.mStateChangeListener.onRunningBackground();
    }
  }
  
  protected void onRunningForeground()
  {
    this.isBackgroundStop = false;
  }
  
  public void openMsfPCActive(String paramString1, String paramString2, boolean paramBoolean)
  {
    NewIntent localNewIntent = new NewIntent(getApplication(), BuiltInServlet.class);
    localNewIntent.setObserver(null);
    localNewIntent.putExtra("uin", paramString1);
    localNewIntent.putExtra("src", paramString2);
    localNewIntent.putExtra("opened", paramBoolean);
    localNewIntent.putExtra("action", 2128);
    getServletContainer().forward(this, localNewIntent);
  }
  
  public void registObserver(BusinessObserver paramBusinessObserver)
  {
    this.observers.add(new WeakReference(paramBusinessObserver));
  }
  
  public void reportNetworkException(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("mqq", 2, "reportNetworkException " + paramInt);
    }
    NewIntent localNewIntent = new NewIntent(getApplication(), BuiltInServlet.class);
    localNewIntent.putExtra("action", 1042);
    localNewIntent.putExtra("value", paramInt);
    startServlet(localNewIntent);
  }
  
  public final void runOnUiThread(Runnable paramRunnable)
  {
    if (this.parentRuntime != null)
    {
      this.parentRuntime.runOnUiThread(paramRunnable);
      return;
    }
    this.mHandler.post(paramRunnable);
  }
  
  public void sendAppDataIncermentMsg(String paramString, String[] paramArrayOfString, long paramLong)
  {
    if (this.parentRuntime != null) {
      this.parentRuntime.sendAppDataIncermentMsg(paramString, paramArrayOfString, paramLong);
    }
    do
    {
      return;
      paramString = MsfMsgUtil.getAppDataIncermentMsg(this.mService.msfSub.getMsfServiceName(), paramString, paramArrayOfString, paramLong);
      paramString.setAppSeq(MSFServlet.APP_SEQ_FACTORY.incrementAndGet());
      try
      {
        this.mService.msfSub.sendMsg(paramString);
        return;
      }
      catch (Throwable paramArrayOfString) {}
    } while (!QLog.isColorLevel());
    QLog.d("mqq", 2, "[MSF Send]" + paramString.getServiceCmd() + " error " + paramArrayOfString, paramArrayOfString);
  }
  
  public void sendMsgSignal()
  {
    NewIntent localNewIntent = new NewIntent(getApplication(), BuiltInServlet.class);
    localNewIntent.setObserver(null);
    localNewIntent.putExtra("action", 2202);
    getServletContainer().forward(this, localNewIntent);
  }
  
  public void sendOnlineStatus(AppRuntime.Status paramStatus, boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    String[] arrayOfString = getMessagePushSSOCommands();
    if (arrayOfString != null)
    {
      NewIntent localNewIntent = new NewIntent(getApplication(), BuiltInServlet.class);
      localNewIntent.putExtra("action", 1002);
      localNewIntent.putExtra("pushCommands", arrayOfString);
      localNewIntent.putExtra("onlineStatus", paramStatus);
      localNewIntent.putExtra("old", getOnlineStatus());
      localNewIntent.putExtra("kick", paramBoolean1);
      localNewIntent.putExtra("K_SEQ", paramLong);
      localNewIntent.putExtra("isUserSet", paramBoolean2);
      localNewIntent.runNow = true;
      startServlet(localNewIntent);
      setOnlineStatus(paramStatus);
    }
  }
  
  public void sendOnlineStatusWithExt(AppRuntime.Status paramStatus, boolean paramBoolean1, long paramLong1, boolean paramBoolean2, long paramLong2)
  {
    String[] arrayOfString = getMessagePushSSOCommands();
    if (arrayOfString != null)
    {
      NewIntent localNewIntent = new NewIntent(getApplication(), BuiltInServlet.class);
      localNewIntent.putExtra("action", 1002);
      localNewIntent.putExtra("pushCommands", arrayOfString);
      localNewIntent.putExtra("onlineStatus", paramStatus);
      localNewIntent.putExtra("extOnlineStatus", paramLong2);
      localNewIntent.putExtra("old", getOnlineStatus());
      localNewIntent.putExtra("kick", paramBoolean1);
      localNewIntent.putExtra("K_SEQ", paramLong1);
      localNewIntent.putExtra("isUserSet", paramBoolean2);
      if ((paramStatus == AppRuntime.Status.online) && (paramLong2 == 1000L))
      {
        localNewIntent.putExtra("batteryCapacity", getBatteryCapacity());
        localNewIntent.putExtra("powerConnect", getPowerConnect());
      }
      localNewIntent.runNow = true;
      startServlet(localNewIntent);
      setOnlineStatus(paramStatus);
      setExtOnlineStatus(paramLong2);
    }
  }
  
  public void sendWirelessMeibaoReq(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("mqq", 2, "sendWirelessMeibaoReq cmd: " + paramInt);
    }
    NewIntent localNewIntent = new NewIntent(getApplication(), BuiltInServlet.class);
    localNewIntent.putExtra("action", 1044);
    localNewIntent.putExtra("cmd", paramInt);
    startServlet(localNewIntent);
  }
  
  public void sendWirelessPswReq(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("mqq", 2, "sendWirelessPswReq cmd: " + paramInt);
    }
    NewIntent localNewIntent = new NewIntent(getApplication(), BuiltInServlet.class);
    localNewIntent.putExtra("action", 1043);
    localNewIntent.putExtra("cmd", paramInt);
    startServlet(localNewIntent);
  }
  
  public void setAppStateChangeListener(IAppStateChangeListener paramIAppStateChangeListener)
  {
    this.mStateChangeListener = paramIAppStateChangeListener;
  }
  
  public void setAsToolRuntime()
  {
    if (this.mToolReceiver != null) {
      this.mToolReceiver.unRegister();
    }
    this.mToolReceiver = new ToolProcReceiver();
    this.mToolReceiver.mRt = this;
    this.mToolReceiver.register();
  }
  
  public void setAutoLogin(boolean paramBoolean)
  {
    if (this.parentRuntime != null) {
      this.parentRuntime.setAutoLogin(paramBoolean);
    }
  }
  
  public void setBatteryCapacity(int paramInt)
  {
    if (this.parentRuntime != null) {
      this.parentRuntime.setBatteryCapacity(paramInt);
    }
    this.batteryCapacity = paramInt;
  }
  
  public void setCmdCallbacker()
  {
    String[] arrayOfString = getMessagePushSSOCommands();
    if (arrayOfString != null)
    {
      NewIntent localNewIntent = new NewIntent(getApplication(), BuiltInServlet.class);
      localNewIntent.putExtra("action", 1040);
      localNewIntent.putExtra("pushCommands", arrayOfString);
      localNewIntent.runNow = true;
      startServlet(localNewIntent);
    }
  }
  
  public void setDevLockIntent(Intent paramIntent)
  {
    if (this.parentRuntime != null)
    {
      this.parentRuntime.setDevLockIntent(paramIntent);
      return;
    }
    this.mDevLockIntent = paramIntent;
  }
  
  public void setExtOnlineStatus(long paramLong)
  {
    if (this.parentRuntime != null) {
      this.parentRuntime.setExtOnlineStatus(paramLong);
    }
    this.uExtOnlineStatus = paramLong;
  }
  
  public void setInterceptKickListener(AppRuntime.InterceptKickListener paramInterceptKickListener)
  {
    MainService localMainService = getService();
    if (localMainService != null) {
      localMainService.setInterceptKickListener(paramInterceptKickListener);
    }
  }
  
  public void setKickIntent(Intent paramIntent)
  {
    if (this.parentRuntime != null)
    {
      this.parentRuntime.setKickIntent(paramIntent);
      return;
    }
    this.mKickIntent = paramIntent;
  }
  
  public void setLogined()
  {
    if (this.parentRuntime != null) {
      this.parentRuntime.setLogined();
    }
    this.isLogin = true;
  }
  
  public void setOnlineStatus(AppRuntime.Status paramStatus)
  {
    if (this.parentRuntime != null) {
      this.parentRuntime.setOnlineStatus(paramStatus);
    }
    this.onlineStatus = paramStatus;
  }
  
  public void setPowerConnect(int paramInt)
  {
    if (this.parentRuntime != null) {
      this.parentRuntime.setPowerConnect(paramInt);
    }
    this.powerConnect = paramInt;
  }
  
  public void setProxy(AppRuntime paramAppRuntime)
  {
    this.parentRuntime = paramAppRuntime;
    if (paramAppRuntime != null)
    {
      this.isBackgroundPause = paramAppRuntime.isBackgroundPause;
      this.isBackgroundStop = paramAppRuntime.isBackgroundStop;
    }
  }
  
  public void ssoGetA1WithA1(String paramString, byte[] paramArrayOfByte1, long paramLong1, long paramLong2, long paramLong3, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, SSOAccountObserver paramSSOAccountObserver)
  {
    ssoGetA1WithA1(paramString, paramArrayOfByte1, paramLong1, paramLong2, paramLong3, paramArrayOfByte2, paramArrayOfByte3, paramSSOAccountObserver, null);
  }
  
  public void ssoGetA1WithA1(String paramString, byte[] paramArrayOfByte1, long paramLong1, long paramLong2, long paramLong3, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, SSOAccountObserver paramSSOAccountObserver, Bundle paramBundle)
  {
    getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
    NewIntent localNewIntent = new NewIntent(getApplication(), BuiltInServlet.class);
    localNewIntent.setObserver(paramSSOAccountObserver);
    localNewIntent.putExtra("ssoAccount", paramString);
    localNewIntent.putExtra("dstAppName", paramArrayOfByte1);
    localNewIntent.putExtra("dwDstSsoVer", paramLong1);
    localNewIntent.putExtra("dwDstAppid", paramLong2);
    localNewIntent.putExtra("dwSubDstAppid", paramLong3);
    localNewIntent.putExtra("dstAppVer", paramArrayOfByte2);
    localNewIntent.putExtra("dstAppSign", paramArrayOfByte3);
    localNewIntent.putExtra("action", 1102);
    if (paramBundle != null)
    {
      localNewIntent.putExtra("process", getApplication().getQQProcessName());
      localNewIntent.putExtra("extra", paramBundle);
    }
    getServletContainer().forward(this, localNewIntent);
  }
  
  public void ssoGetTicketNoPasswd(String paramString, int paramInt, SSOAccountObserver paramSSOAccountObserver)
  {
    ssoGetTicketNoPasswd(paramString, paramInt, paramSSOAccountObserver, null);
  }
  
  public void ssoGetTicketNoPasswd(String paramString, int paramInt, SSOAccountObserver paramSSOAccountObserver, Bundle paramBundle)
  {
    getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
    NewIntent localNewIntent = new NewIntent(getApplication(), BuiltInServlet.class);
    localNewIntent.setObserver(paramSSOAccountObserver);
    localNewIntent.putExtra("process", getApplication().getQQProcessName());
    localNewIntent.putExtra("ssoAccount", paramString);
    localNewIntent.putExtra("action", 1101);
    localNewIntent.putExtra("targetTicket", paramInt);
    localNewIntent.putExtra("from_where", "ssoAccountAction");
    if (paramBundle != null) {
      localNewIntent.putExtra("extra", paramBundle);
    }
    getServletContainer().forward(this, localNewIntent);
  }
  
  public void ssoLogin(String paramString1, String paramString2, int paramInt, SSOAccountObserver paramSSOAccountObserver)
  {
    ssoLogin(paramString1, paramString2, paramInt, paramSSOAccountObserver, null);
  }
  
  public void ssoLogin(String paramString1, String paramString2, int paramInt, SSOAccountObserver paramSSOAccountObserver, Bundle paramBundle)
  {
    getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
    NewIntent localNewIntent = new NewIntent(getApplication(), BuiltInServlet.class);
    localNewIntent.setObserver(paramSSOAccountObserver);
    localNewIntent.putExtra("process", getApplication().getQQProcessName());
    localNewIntent.putExtra("ssoAccount", paramString1);
    localNewIntent.putExtra("ssoPassword", paramString2);
    localNewIntent.putExtra("action", 1100);
    localNewIntent.putExtra("targetTicket", paramInt);
    if (paramBundle != null) {
      localNewIntent.putExtra("extra", paramBundle);
    }
    getServletContainer().forward(this, localNewIntent);
  }
  
  public void start(boolean paramBoolean)
  {
    NewIntent localNewIntent;
    if (this.parentRuntime == null)
    {
      localObject = getAccount();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localNewIntent = new NewIntent(getApplication(), BuiltInServlet.class);
        localNewIntent.putExtra("action", 2124);
        localNewIntent.putExtra("uin", (String)localObject);
        startServlet(localNewIntent);
      }
    }
    Object localObject = getMessagePushServlets();
    if (localObject != null)
    {
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        localNewIntent = localObject[i];
        startServlet(new NewIntent(getApplication(), localNewIntent));
        i += 1;
      }
    }
  }
  
  public void startPCActivePolling(String paramString1, String paramString2)
  {
    NewIntent localNewIntent = new NewIntent(getApplication(), BuiltInServlet.class);
    localNewIntent.setObserver(null);
    localNewIntent.putExtra("uin", paramString1);
    localNewIntent.putExtra("src", paramString2);
    localNewIntent.putExtra("action", 2126);
    getServletContainer().forward(this, localNewIntent);
  }
  
  public void startServlet(NewIntent paramNewIntent)
  {
    bool = false;
    if (((paramNewIntent.withouLogin) || (isLogin())) && (isRunning())) {
      getServletContainer().forward(this, paramNewIntent);
    }
    do
    {
      return;
      localObject1 = "";
      try
      {
        localObject2 = paramNewIntent.getStringExtra("action");
        localObject1 = localObject2;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          try
          {
            Object localObject2;
            int i = paramNewIntent.getIntExtra("action", 0);
            localObject1 = String.valueOf(i);
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
          }
          continue;
          bool = false;
          continue;
          localObject1 = new StringBuilder().append("can not send intent ,").append(isLogin()).append("|").append(isRunning()).append("|");
          if (this.parentRuntime != null) {
            bool = true;
          }
          QLog.e("mqq", 1, bool);
          continue;
          localObject1 = getAccount();
          continue;
          paramNewIntent = "";
        }
      }
      if (!QLog.isColorLevel()) {
        break label359;
      }
      localObject1 = new StringBuilder().append("can not send intent ").append((String)localObject1).append(",isLogin:").append(isLogin()).append(",isRunning:").append(isRunning()).append(",parentRT:");
      if (this.parentRuntime == null) {
        break label354;
      }
      bool = true;
      QLog.e("mqq", 2, bool);
    } while (((!MainService.isDebugVersion) && (!MainService.isGrayVersion)) || (MsfServiceSdk.get() == null));
    try
    {
      if (getAccount() == null)
      {
        localObject1 = "NoLogin";
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("uinpm", localObject1);
        ((HashMap)localObject2).put("intentWithLogin", String.valueOf(paramNewIntent.withouLogin));
        ((HashMap)localObject2).put("isLogin", String.valueOf(isLogin()));
        ((HashMap)localObject2).put("isRunning", String.valueOf(isRunning()));
        if (paramNewIntent.getComponent() == null) {
          break label436;
        }
        paramNewIntent = paramNewIntent.getComponent().getShortClassName();
        ((HashMap)localObject2).put("compClass", paramNewIntent);
        ((HashMap)localObject2).put("timepm", String.valueOf(System.currentTimeMillis()));
        paramNewIntent = new RdmReq();
        paramNewIntent.eventName = "sendPBToMsfError";
        paramNewIntent.isRealTime = false;
        paramNewIntent.params = ((Map)localObject2);
        paramNewIntent = MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), paramNewIntent);
        paramNewIntent.setNeedCallback(false);
        MsfServiceSdk.get().sendMsg(paramNewIntent);
      }
    }
    catch (Throwable paramNewIntent) {}
  }
  
  public void stopPCActivePolling(String paramString)
  {
    NewIntent localNewIntent = new NewIntent(getApplication(), BuiltInServlet.class);
    localNewIntent.setObserver(null);
    localNewIntent.putExtra("action", 2127);
    localNewIntent.putExtra("src", paramString);
    getServletContainer().forward(this, localNewIntent);
  }
  
  public void switchAccount(SimpleAccount paramSimpleAccount, String paramString)
  {
    if (this.parentRuntime != null)
    {
      this.parentRuntime.switchAccount(paramSimpleAccount, paramString);
      return;
    }
    if (paramSimpleAccount != null)
    {
      getApplication().createNewRuntime(paramSimpleAccount, false, true, 2, paramString);
      return;
    }
    throw new IllegalArgumentException("the newAccount can not be null.");
  }
  
  public void unRegistObserver(BusinessObserver paramBusinessObserver)
  {
    if (paramBusinessObserver == null) {
      return;
    }
    this.observers.remove(new WeakReference(paramBusinessObserver));
  }
  
  public void updateSubAccountLogin(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("mqq", 2, "updateSubAccountLogin isLogined = " + paramBoolean + ";subAccount =" + paramString);
    }
    MsfSdkUtils.updateSimpleAccount(paramString, paramBoolean);
  }
  
  protected void userLogoutReleaseData() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.app.AppRuntime
 * JD-Core Version:    0.7.0.1
 */