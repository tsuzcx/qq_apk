package com.tencent.qzonehub.api.impl;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.automator.AutomatorHelper;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper;
import com.tencent.mobileqq.startup.step.InstallPlugins;
import com.tencent.mobileqq.startup.step.InstallPlugins.QzoneInstallResult;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZoneApiProxy;
import com.tencent.qzonehub.api.contentbox.IFeedViewHolderInterface;
import common.config.service.QzoneConfig;
import cooperation.plugin.IPluginManager;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.api.QZoneApiProxy;
import cooperation.qzone.api.QZoneApiProxy.QZoneLoadCallback;
import cooperation.qzone.api.QzoneFragmentImpl;
import cooperation.qzone.util.QZLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.Servlet;
import mqq.app.ServletContainer;
import mqq.util.WeakReference;

public class QZoneApiProxyImpl
  implements IQZoneApiProxy
{
  private static Method ENV_CHANGE_METHOD;
  private static final String ENV_CHANGE_METHOD_NAME = "onAccountChange";
  private static volatile Class<?> ENV_CLASS;
  private static final String ENV_CLASS_NAME = "com.qzone.app.QZoneRunInQQEnv";
  private static final String ENV_INIT_METHOD_NAME = "init";
  private static final String ENV_QZONE_VERSION_NAME = "isQzoneVersionRight";
  private static final String MSG_FEED_HOLDER_CLASS_NAME = "com.qzone.feed.ui.activity.QZoneMsgFeedViewHolder";
  private static final String QZONE_CONFIG_KEY_MSG_PAGE_TITLE = "msg_page_title";
  private static final String QZONE_CONFIG_KEY_SHOW_SUB_FEEDS = "show_sub_feeds";
  private static final AtomicReference<SharedPreferences> QZONE_SP = new AtomicReference();
  private static final String QZONE_SP_NAME = "qzone_api_proxy_sp_name";
  public static final String SCHOOL_LIST_CLASS_NAME = "com.qzone.feed.ui.activity.QQSchoolExtendFeedsListView";
  private static final String SERVLET_CLASS_NAME = "com.qzone.common.servlet.QZoneServlet";
  static final String SP_AB_TEST_EXPERIMENT_TYPE = "KEY_EXPERIMENT_TYPE";
  static final String SP_AB_TEST_SHOW_QZONE = "SP_AB_TEST_SHOW_QZONE_STATE";
  static final String ShowQzoneInSimpleUISharedPreference = "switch_show_qzone_in_simple_ui";
  private static final String TAG = "QZoneApiProxyImpl";
  private static volatile boolean sIsEnvInit = false;
  private static volatile boolean sIsInit = false;
  public static volatile boolean sIsQzoneInstalled = false;
  public static volatile boolean sIsQzoneVersionRight = false;
  private static volatile WeakReference<AppRuntime> sLastRuntimeRef;
  private static volatile WeakReference<PluginManagerClient> sPluginClientRef = new WeakReference(null);
  private static volatile Constructor<?> sSchoolExtendListConstructor;
  
  @Nullable
  public static IFeedViewHolderInterface createMsgFeedViewHolder(@NonNull Activity paramActivity)
  {
    if (!sIsInit)
    {
      QZLog.w("QZoneApiProxyImpl", "createMsgFeedViewHolder: not init yet");
      return null;
    }
    Object localObject1 = loadQZoneClass(paramActivity, "com.qzone.feed.ui.activity.QZoneMsgFeedViewHolder");
    if (localObject1 == null)
    {
      QZLog.w("QZoneApiProxyImpl", "createMsgFeedViewHolder: failed to get class");
      return null;
    }
    Object localObject2;
    try
    {
      localObject1 = ((Class)localObject1).getConstructor(new Class[] { Activity.class });
    }
    catch (Throwable localThrowable)
    {
      QZLog.w("QZoneApiProxyImpl", "createMsgFeedViewHolder failed to get constructor", localThrowable);
      localObject2 = null;
    }
    if (localObject2 == null) {
      return null;
    }
    try
    {
      paramActivity = (IFeedViewHolderInterface)localObject2.newInstance(new Object[] { paramActivity });
      return paramActivity;
    }
    catch (Throwable paramActivity)
    {
      QZLog.w("QZoneApiProxyImpl", "createMsgFeedViewHolder failed to create instance", paramActivity);
    }
    return null;
  }
  
  public static View createSchoolExtendList(Context paramContext, AttributeSet paramAttributeSet)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("createSchoolExtendList: ");
    boolean bool;
    if (sSchoolExtendListConstructor != null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    QZLog.i("QZoneApiProxyImpl", localStringBuilder.toString());
    if (sSchoolExtendListConstructor == null) {
      return null;
    }
    try
    {
      paramContext = (View)sSchoolExtendListConstructor.newInstance(new Object[] { paramContext, paramAttributeSet });
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      QZLog.w("QZoneApiProxyImpl", "onCreateView: failed", paramContext);
    }
    return null;
  }
  
  @NonNull
  private static SharedPreferences getSelfSharedPreferences(@NonNull Context paramContext)
  {
    QZONE_SP.compareAndSet(null, paramContext.getSharedPreferences("qzone_api_proxy_sp_name", 0));
    return (SharedPreferences)QZONE_SP.get();
  }
  
  public static String getSubFeedTitle(Context paramContext)
  {
    String str = getSelfSharedPreferences(paramContext).getString("msg_page_title", "");
    paramContext = str;
    if (TextUtils.isEmpty(str)) {
      paramContext = HardCodeUtil.a(2131916999);
    }
    return paramContext;
  }
  
  private boolean isQZonePluginValid(@NonNull Context paramContext, @NonNull AppRuntime paramAppRuntime)
  {
    long l = paramAppRuntime.getLongAccountUin();
    boolean bool2 = false;
    int i = LocalMultiProcConfig.getInt4Uin("creditlevel", 0, l);
    if (i == 8)
    {
      paramContext = new StringBuilder();
      paramContext.append("creditLevel");
      paramContext.append(i);
      QZLog.e("QZoneApiProxyImpl", paramContext.toString());
      return false;
    }
    if ((sIsInit) && (sIsEnvInit)) {
      return true;
    }
    if (!isQzonePluginInstalledAndVersionRight(null))
    {
      QZLog.e("QZoneApiProxyImpl", "file not exists");
      return false;
    }
    if (AutomatorHelper.b)
    {
      if (InstallPlugins.c == null)
      {
        i = Build.VERSION.SDK_INT;
        if ((i == 21) || (i == 22))
        {
          QZLog.e("QZoneApiProxyImpl", "isQZonePluginValid null install result");
          return false;
        }
      }
      else if (!InstallPlugins.c.a)
      {
        QZLog.i("QZoneApiProxyImpl", "isQZonePluginValid qzone install failed");
        return false;
      }
      try
      {
        QzonePluginProxyActivity.getQZonePluginClassLoader(BaseApplicationImpl.getApplication());
        if ((initServlet(paramContext, paramAppRuntime)) && (initEnv(paramContext, paramAppRuntime))) {
          return true;
        }
        QZLog.e("QZoneApiProxyImpl", "initServlet erro");
        return false;
      }
      catch (Throwable paramContext)
      {
        QLog.e("QZoneApiProxyImpl", 1, "needShowQzoneFrame", paramContext);
        return false;
      }
    }
    boolean bool1 = bool2;
    if (initServlet(paramContext, paramAppRuntime))
    {
      bool1 = bool2;
      if (initEnv(paramContext, paramAppRuntime)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static boolean isQzoneVersionRight(@NonNull Context paramContext)
  {
    if (sIsQzoneVersionRight) {
      return true;
    }
    if (ENV_CLASS == null) {
      ENV_CLASS = loadQZoneClass(paramContext, "com.qzone.app.QZoneRunInQQEnv");
    }
    QZLog.e("QZoneApiProxyImpl", "isQzoneVersionRight: loadQZoneClass");
    paramContext = ENV_CLASS;
    boolean bool1 = false;
    if (paramContext == null) {
      return false;
    }
    try
    {
      paramContext = ENV_CLASS.getMethod("isQzoneVersionRight", new Class[0]);
    }
    catch (Throwable paramContext)
    {
      QZLog.w("QZoneApiProxyImpl", "isQzoneVersionRight: failed to get init env method", paramContext);
      paramContext = null;
    }
    if (paramContext == null) {
      return false;
    }
    try
    {
      boolean bool2 = ((Boolean)paramContext.invoke(null, new Object[0])).booleanValue();
      bool1 = bool2;
    }
    catch (Throwable paramContext)
    {
      QZLog.w("QZoneApiProxyImpl", "isQzoneVersionRight: failed to init", paramContext);
    }
    sIsQzoneVersionRight = bool1;
    return bool1;
  }
  
  public static boolean isRightAndroidVersion()
  {
    return Build.VERSION.SDK_INT != 19;
  }
  
  @Nullable
  private static <T> Class<T> loadQZoneClass(@NonNull Context paramContext, @NonNull String paramString)
  {
    Class<T> localClass1;
    try
    {
      Class localClass = Class.forName(paramString);
    }
    catch (Throwable localThrowable)
    {
      QZLog.d("QZoneApiProxyImpl", 2, "createAdapter: failed to get class by normal class loader", localThrowable);
      localClass1 = null;
    }
    if (localClass1 == null) {
      try
      {
        paramContext = QzonePluginProxyActivity.getQZonePluginClassLoader(paramContext).loadClass(paramString);
        return paramContext;
      }
      catch (Throwable paramContext)
      {
        QZLog.w("QZoneApiProxyImpl", "createAdapter: failed to get class by qzone plugin class loader", paramContext);
      }
    }
    return localClass1;
  }
  
  public static void recordRuntime(AppRuntime paramAppRuntime)
  {
    sLastRuntimeRef = new WeakReference(paramAppRuntime);
  }
  
  public static void recordSubFeedConfig(@NonNull Context paramContext, boolean paramBoolean, @Nullable String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("recordShowSubFeedConfig: ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(paramString);
    QZLog.i("QZoneApiProxyImpl", ((StringBuilder)localObject).toString());
    localObject = paramString;
    if (paramString == null) {
      localObject = "";
    }
    getSelfSharedPreferences(paramContext).edit().putBoolean("show_sub_feeds", paramBoolean).putString("msg_page_title", (String)localObject).apply();
  }
  
  @Nullable
  public Fragment createLebaFragment(@NonNull Activity paramActivity, @NonNull AppRuntime paramAppRuntime, @NonNull String paramString)
  {
    if (!sIsInit)
    {
      QZLog.w("QZoneApiProxyImpl", "createLebaFragment: not init yet");
      return null;
    }
    paramString = loadQZoneClass(paramAppRuntime.getApp(), paramString);
    if (paramString == null)
    {
      QZLog.e("QZoneApiProxyImpl", "clazz==null");
      return null;
    }
    try
    {
      paramString = (Fragment)paramString.newInstance();
    }
    catch (Throwable paramString)
    {
      QZLog.w("QZoneApiProxyImpl", "createLebaFragment: failed to create instance", paramString);
      paramString = null;
    }
    if (paramString == null) {
      return null;
    }
    int j = 1;
    int i = j;
    if ((paramString instanceof QzoneFragmentImpl)) {
      try
      {
        ((QzoneFragmentImpl)paramString).attachQQContext(paramActivity, paramAppRuntime);
        i = j;
      }
      catch (Throwable paramActivity)
      {
        QZLog.w("QZoneApiProxyImpl", "createLebaFragment: failed to init instance", paramActivity);
        i = 0;
      }
    }
    if (i != 0) {
      return paramString;
    }
    return null;
  }
  
  public String getExpContentInSimpleUI(AppRuntime paramAppRuntime)
  {
    ExpEntityInfo localExpEntityInfo = ABTestController.a().a("exp_shouq_dongtai_jianjie_copy_copy");
    boolean bool = localExpEntityInfo.g();
    String str = "exp_shouq_dongtai_jianjie_C";
    if (bool) {
      str = "exp_shouq_dongtai_jianjie_A";
    } else if (localExpEntityInfo.a("exp_shouq_dongtai_jianjie_B")) {
      str = "exp_shouq_dongtai_jianjie_B";
    } else if (!localExpEntityInfo.a("exp_shouq_dongtai_jianjie_C")) {
      str = null;
    }
    if (!TextUtils.isEmpty(str))
    {
      saveShowQzoneABTest(paramAppRuntime, str);
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("getExpContentInSimpleUI from net expValue=");
      paramAppRuntime.append(str);
      QLog.i("QZoneApiProxyImpl", 1, paramAppRuntime.toString());
      return str;
    }
    str = loadShowQzoneABTest(paramAppRuntime);
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("getExpContentInSimpleUI from local expValue=");
    paramAppRuntime.append(str);
    QLog.i("QZoneApiProxyImpl", 1, paramAppRuntime.toString());
    paramAppRuntime = str;
    if (TextUtils.isEmpty(str)) {
      paramAppRuntime = "exp_shouq_dongtai_jianjie_A";
    }
    return paramAppRuntime;
  }
  
  public AppRuntime getLastRuntime()
  {
    if (sLastRuntimeRef == null) {
      return null;
    }
    return (AppRuntime)sLastRuntimeRef.get();
  }
  
  public boolean getShowQzoneInSimpleUI()
  {
    return MobileQQ.getContext().getSharedPreferences("switch_show_qzone_in_simple_ui", 0).getBoolean("enabled", false);
  }
  
  public boolean initEnv(@NonNull Context paramContext, @NonNull AppRuntime paramAppRuntime)
  {
    long l1 = System.nanoTime();
    QZLog.e("QZoneApiProxyImpl", "initEnv: start");
    if (sIsEnvInit) {
      return true;
    }
    if (ENV_CLASS == null) {
      ENV_CLASS = loadQZoneClass(paramContext, "com.qzone.app.QZoneRunInQQEnv");
    }
    QZLog.e("QZoneApiProxyImpl", "initEnv: loadQZoneClass");
    paramContext = ENV_CLASS;
    boolean bool1 = false;
    if (paramContext == null) {
      return false;
    }
    try
    {
      paramContext = ENV_CLASS.getMethod("init", new Class[] { AppRuntime.class });
    }
    catch (Throwable paramContext)
    {
      QZLog.w("QZoneApiProxyImpl", "initEnv: failed to get init env method", paramContext);
      paramContext = null;
    }
    if (paramContext == null) {
      return false;
    }
    try
    {
      boolean bool2 = ((Boolean)paramContext.invoke(null, new Object[] { paramAppRuntime })).booleanValue();
      bool1 = bool2;
    }
    catch (Throwable paramContext)
    {
      QZLog.w("QZoneApiProxyImpl", "initEnv: failed to init", paramContext);
    }
    sIsEnvInit = bool1;
    long l2 = System.nanoTime();
    paramContext = new StringBuilder();
    paramContext.append("initEnv: end ");
    paramContext.append(sIsEnvInit);
    paramContext.append(" ");
    paramContext.append(l2 - l1);
    QZLog.e("QZoneApiProxyImpl", paramContext.toString());
    return sIsEnvInit;
  }
  
  public void initSchoolExtendListCreator()
  {
    PublicFragmentActivity.a("com.qzone.feed.ui.activity.QQSchoolExtendFeedsListView", new QZoneApiProxyImpl.SchoolExtendListCreator(null));
  }
  
  public boolean initServlet(@NonNull Context paramContext, @NonNull AppRuntime paramAppRuntime)
  {
    long l1 = System.nanoTime();
    QZLog.e("QZoneApiProxyImpl", "initServlet: start");
    if (sIsInit) {
      return true;
    }
    ((IPluginManager)paramAppRuntime.getManager(QQManagerFactory.MGR_PLUGIN)).e("qzone_plugin.apk");
    paramContext = loadQZoneClass(paramContext, "com.qzone.common.servlet.QZoneServlet");
    int j = 0;
    if (paramContext == null) {
      return false;
    }
    Object localObject4 = null;
    Object localObject1;
    try
    {
      localObject1 = (MSFServlet)paramContext.newInstance();
    }
    catch (Throwable paramContext)
    {
      QZLog.w("QZoneApiProxyImpl", "initServlet: failed to get servlet instance", paramContext);
      localObject1 = null;
    }
    if (localObject1 == null) {
      return false;
    }
    ServletContainer localServletContainer;
    try
    {
      paramContext = AppRuntime.class.getDeclaredField("mServletContainer");
      paramContext.setAccessible(true);
      localServletContainer = (ServletContainer)paramContext.get(paramAppRuntime);
    }
    catch (Throwable paramContext)
    {
      QZLog.w("QZoneApiProxyImpl", "initServlet: failed to get container", paramContext);
      localServletContainer = null;
    }
    if (localServletContainer == null) {
      return false;
    }
    try
    {
      paramContext = ServletContainer.class.getDeclaredField("managedServlet");
      paramContext.setAccessible(true);
      paramContext = (Map)paramContext.get(localServletContainer);
      try
      {
        Object localObject2 = ServletContainer.class.getDeclaredField("actionMap");
        ((Field)localObject2).setAccessible(true);
        localObject2 = (Map)((Field)localObject2).get(localServletContainer);
      }
      catch (Throwable localThrowable2) {}
      QZLog.w("QZoneApiProxyImpl", "initServlet: failed to get container field", localThrowable3);
    }
    catch (Throwable localThrowable3)
    {
      paramContext = null;
    }
    Object localObject3 = localObject4;
    if (paramContext != null)
    {
      if (localObject3 == null) {
        return false;
      }
      Method localMethod;
      int i;
      try
      {
        localObject4 = Servlet.class.getDeclaredMethod("init", new Class[] { AppRuntime.class, ServletContainer.class });
        ((Method)localObject4).setAccessible(true);
        localMethod = Servlet.class.getDeclaredMethod("onCreate", new Class[0]);
        localMethod.setAccessible(true);
        ((Method)localObject4).invoke(localObject1, new Object[] { paramAppRuntime, localServletContainer });
        localMethod.invoke(localObject1, new Object[0]);
        i = 1;
      }
      catch (Throwable localThrowable1)
      {
        QZLog.w("QZoneApiProxyImpl", "initServlet: failed to get init method", localThrowable1);
        i = 0;
      }
      if (i == 0) {
        return false;
      }
      try
      {
        paramContext.put("com.qzone.common.servlet.QZoneServlet", localObject1);
        localObject4 = ((MSFServlet)localObject1).getPreferSSOCommands();
        if (localObject4 != null)
        {
          int k = localObject4.length;
          i = j;
          while (i < k)
          {
            localMethod = localObject4[i];
            Set localSet = (Set)localObject3.get(localMethod);
            localObject1 = localSet;
            if (localSet == null)
            {
              localObject1 = new HashSet();
              localObject3.put(localMethod, localObject1);
            }
            ((Set)localObject1).add("com.qzone.common.servlet.QZoneServlet");
            i += 1;
          }
        }
        recordRuntime(paramAppRuntime);
        long l2 = System.nanoTime();
        paramContext = new StringBuilder();
        paramContext.append("initServlet: ok ");
        paramContext.append(paramAppRuntime.getCurrentUin());
        paramContext.append(" ");
        paramContext.append(l2 - l1);
        QZLog.i("QZoneApiProxyImpl", paramContext.toString());
        sIsInit = true;
        return true;
      }
      finally {}
    }
    return false;
  }
  
  public boolean isInQZoneEnvironment()
  {
    return sIsInit ^ true;
  }
  
  public boolean isIsQzoneInstalled()
  {
    return sIsQzoneInstalled;
  }
  
  public boolean isQzoneInstalled()
  {
    if (sIsQzoneInstalled) {
      return true;
    }
    PluginManagerClient localPluginManagerClient = (PluginManagerClient)sPluginClientRef.get();
    if (localPluginManagerClient != null)
    {
      boolean bool = localPluginManagerClient.isPluginInstalled("qzone_plugin.apk");
      if (bool)
      {
        QZLog.i("QZoneApiProxyImpl", " isQzoneInstalled = true");
        sIsQzoneInstalled = true;
      }
      return bool;
    }
    PluginManagerHelper.getPluginInterface(BaseApplicationImpl.getApplication(), new QZoneApiProxyImpl.2(this));
    return false;
  }
  
  public boolean isQzonePluginInstalledAndVersionRight(@Nullable QZoneApiProxy.QZoneLoadCallback paramQZoneLoadCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("isQzonePluginInstalledAndVersionRight: sIsQzoneVInstalled=");
    ((StringBuilder)localObject).append(sIsQzoneInstalled);
    ((StringBuilder)localObject).append("    isQzoneVersionRight=");
    ((StringBuilder)localObject).append(sIsQzoneVersionRight);
    QZLog.i("QZoneApiProxyImpl", ((StringBuilder)localObject).toString());
    boolean bool2 = sIsQzoneInstalled;
    boolean bool1 = true;
    if ((bool2) && (isQzoneVersionRight(BaseApplicationImpl.getApplication())))
    {
      if (paramQZoneLoadCallback != null) {
        paramQZoneLoadCallback.onLoadOver(true);
      }
      return true;
    }
    localObject = (PluginManagerClient)sPluginClientRef.get();
    if (localObject != null)
    {
      bool2 = ((PluginManagerClient)localObject).isPluginInstalled("qzone_plugin.apk");
      if (bool2)
      {
        QZLog.i("QZoneApiProxyImpl", " sIsQzoneVInstalled = true");
        sIsQzoneInstalled = true;
      }
      if ((!bool2) || (!isQzoneVersionRight(BaseApplicationImpl.getApplication()))) {
        bool1 = false;
      }
      if (paramQZoneLoadCallback != null) {
        paramQZoneLoadCallback.onLoadOver(bool1);
      }
      return bool1;
    }
    long l = System.nanoTime();
    PluginManagerHelper.getPluginInterface(BaseApplicationImpl.getApplication(), new QZoneApiProxyImpl.1(this, l, paramQZoneLoadCallback));
    return false;
  }
  
  public boolean isQzoneVersionRight()
  {
    return sIsQzoneVersionRight;
  }
  
  public boolean isRightAndroidVersionForStickyNote()
  {
    return Build.VERSION.SDK_INT > 19;
  }
  
  boolean isShowQzoneFrameEnabled(AppRuntime paramAppRuntime)
  {
    if ("exp_shouq_dongtai_jianjie_C".equals(getExpContentInSimpleUI(paramAppRuntime)))
    {
      QZLog.i("QZoneApiProxyImpl", "isShowQzoneFrameEnabled, EXP_QQ_LEBA_CONCISE_THEME_CONTENT_C, show-qzone is false");
      return false;
    }
    int i = LocalMultiProcConfig.getInt4Uin("qzone_feed_gray_mask", 0, paramAppRuntime.getLongAccountUin());
    if ((0x10000 & i) == 0)
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("grayMask no");
      paramAppRuntime.append(i);
      QZLog.e("QZoneApiProxyImpl", paramAppRuntime.toString());
      return false;
    }
    return true;
  }
  
  String loadShowQzoneABTest(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {
      return "";
    }
    SharedPreferences localSharedPreferences = paramAppRuntime.getApplicationContext().getSharedPreferences("SP_AB_TEST_SHOW_QZONE_STATE", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("KEY_EXPERIMENT_TYPE");
    localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
    return localSharedPreferences.getString(localStringBuilder.toString(), "");
  }
  
  public boolean needLoadQZoneEnv()
  {
    return needLoadQZoneEnv(null);
  }
  
  public boolean needLoadQZoneEnv(@Nullable QZoneApiProxy.QZoneLoadCallback paramQZoneLoadCallback)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("needLoadQZoneEnv: is launch ? ");
    localStringBuilder.append(AutomatorHelper.b);
    QZLog.i("QZoneApiProxyImpl", localStringBuilder.toString());
    if (!isRightAndroidVersion())
    {
      if (paramQZoneLoadCallback != null) {
        paramQZoneLoadCallback.onLoadOver(false);
      }
      return false;
    }
    if (sIsInit)
    {
      if (paramQZoneLoadCallback != null) {
        paramQZoneLoadCallback.onLoadOver(true);
      }
      return true;
    }
    return isQzonePluginInstalledAndVersionRight(paramQZoneLoadCallback);
  }
  
  public boolean needShowAioFeedList(@Nullable Activity paramActivity, @Nullable AppRuntime paramAppRuntime)
  {
    if (paramActivity != null)
    {
      if (paramAppRuntime == null) {
        return false;
      }
      if (QzoneConfig.getInstance().getConfig("QZoneSetting", "AioShowFeedList", 1) == 0) {
        return false;
      }
      return isQZonePluginValid(paramActivity, paramAppRuntime);
    }
    return false;
  }
  
  public boolean needShowMsgFeedList(@Nullable Activity paramActivity, @Nullable AppRuntime paramAppRuntime)
  {
    if (paramActivity != null)
    {
      if (paramAppRuntime == null) {
        return false;
      }
      if (QzoneConfig.getInstance().getConfig("OfficialAccount", "OfficialAccountCanShowFeedsList", 0) == 0) {
        return false;
      }
      return isQZonePluginValid(paramActivity, paramAppRuntime);
    }
    return false;
  }
  
  public boolean needShowQzoneFrame(@Nullable Context paramContext, @Nullable AppRuntime paramAppRuntime)
  {
    if (paramContext != null)
    {
      if (paramAppRuntime == null) {
        return false;
      }
      if (!QQTheme.isNowSimpleUI())
      {
        QZLog.e("QZoneApiProxyImpl", "isNowSimpleUI no");
        return false;
      }
      if (!isShowQzoneFrameEnabled(paramAppRuntime))
      {
        QZLog.i("QZoneApiProxyImpl", "isShowQzoneFrameEnabled no");
        return false;
      }
      if (!isQZonePluginValid(paramContext, paramAppRuntime)) {
        return false;
      }
      if (paramAppRuntime != QZoneApiProxy.getLastRuntime()) {
        onAccountChange(paramContext, paramAppRuntime);
      }
      return true;
    }
    return false;
  }
  
  public boolean needShowSchoolExtendFeed(@Nullable Activity paramActivity, @Nullable AppRuntime paramAppRuntime)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramActivity != null)
    {
      if (paramAppRuntime == null) {
        return false;
      }
      boolean bool3 = isQZonePluginValid(paramActivity, paramAppRuntime);
      if ((bool3) && (paramAppRuntime != QZoneApiProxy.getLastRuntime())) {
        onAccountChange(paramActivity, paramAppRuntime);
      }
      if (sSchoolExtendListConstructor == null)
      {
        paramAppRuntime = loadQZoneClass(paramActivity, "com.qzone.feed.ui.activity.QQSchoolExtendFeedsListView");
        if (paramAppRuntime != null) {
          try
          {
            sSchoolExtendListConstructor = paramAppRuntime.getConstructor(new Class[] { Context.class, AttributeSet.class });
          }
          catch (Throwable paramAppRuntime)
          {
            QZLog.w("QZoneApiProxyImpl", "needShowSchoolExtendFeed: failed to get school extend list view constructor", paramAppRuntime);
          }
        }
      }
      int i;
      try
      {
        paramActivity.getLayoutInflater().inflate(2131627411, null);
        i = 1;
      }
      catch (Throwable paramActivity)
      {
        QZLog.w("QZoneApiProxyImpl", "needShowSchoolExtendFeed: inflate failed", paramActivity);
        i = 0;
      }
      bool1 = bool2;
      if (bool3)
      {
        bool1 = bool2;
        if (sSchoolExtendListConstructor != null)
        {
          bool1 = bool2;
          if (i != 0) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public boolean needShowSubFeedList(@Nullable Activity paramActivity, @Nullable AppRuntime paramAppRuntime)
  {
    if (paramActivity != null)
    {
      if (paramAppRuntime == null) {
        return false;
      }
      if (QzoneConfig.getInstance().getConfig("QZoneSetting", "SubShowFeedList", 1) == 0) {
        return false;
      }
      if (!getSelfSharedPreferences(paramActivity).getBoolean("show_sub_feeds", false)) {
        QZLog.i("QZoneApiProxyImpl", "needShowSubFeedList: close by server");
      }
      return isQZonePluginValid(paramActivity, paramAppRuntime);
    }
    return false;
  }
  
  public void onAccountChange(@NonNull Context paramContext, @NonNull AppRuntime paramAppRuntime)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAccountChange: ");
    localStringBuilder.append(paramAppRuntime.getCurrentUin());
    localStringBuilder.append(" ");
    localStringBuilder.append(sIsEnvInit);
    localStringBuilder.append(" ");
    localStringBuilder.append(sIsInit);
    QZLog.i("QZoneApiProxyImpl", localStringBuilder.toString());
    if (!sIsEnvInit)
    {
      initEnv(paramContext, paramAppRuntime);
      return;
    }
    if (ENV_CLASS == null) {
      ENV_CLASS = loadQZoneClass(paramContext, "com.qzone.app.QZoneRunInQQEnv");
    }
    if (ENV_CLASS == null) {
      return;
    }
    if (ENV_CHANGE_METHOD == null) {
      try
      {
        ENV_CHANGE_METHOD = ENV_CLASS.getMethod("onAccountChange", new Class[] { QQAppInterface.class });
      }
      catch (Throwable localThrowable1)
      {
        QZLog.w("QZoneApiProxyImpl", "onAccountChange: failed to get change account method", localThrowable1);
      }
    }
    Method localMethod = ENV_CHANGE_METHOD;
    if (localMethod == null) {
      return;
    }
    try
    {
      localMethod.invoke(null, new Object[] { paramAppRuntime });
    }
    catch (Throwable localThrowable2)
    {
      QZLog.w("QZoneApiProxyImpl", "onAccountChange: failed to call change account method", localThrowable2);
    }
    if (sIsInit)
    {
      sIsInit = false;
      initServlet(paramContext, paramAppRuntime);
    }
  }
  
  void saveShowQzoneABTest(AppRuntime paramAppRuntime, String paramString)
  {
    if (paramAppRuntime == null) {
      return;
    }
    SharedPreferences.Editor localEditor = paramAppRuntime.getApplicationContext().getSharedPreferences("SP_AB_TEST_SHOW_QZONE_STATE", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("KEY_EXPERIMENT_TYPE");
    localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
    localEditor.putString(localStringBuilder.toString(), paramString).apply();
  }
  
  public void setShowQzoneInSimpleUI(boolean paramBoolean)
  {
    MobileQQ.getContext().getSharedPreferences("switch_show_qzone_in_simple_ui", 0).edit().putBoolean("enabled", paramBoolean).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qzonehub.api.impl.QZoneApiProxyImpl
 * JD-Core Version:    0.7.0.1
 */