package cooperation.qzone.api;

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
import anvx;
import bdfk;
import bdhu;
import blvy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper;
import com.tencent.mobileqq.startup.step.InstallPlugins;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QzonePluginProxyActivity;
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
import mqq.app.Servlet;
import mqq.app.ServletContainer;
import mqq.util.WeakReference;

public class QZoneApiProxy
{
  private static Method ENV_CHANGE_METHOD;
  private static final String ENV_CHANGE_METHOD_NAME = "onAccountChange";
  private static volatile Class<?> ENV_CLASS;
  private static final String ENV_CLASS_NAME = "com.qzone.app.QZoneRunInQQEnv";
  private static final String ENV_INIT_METHOD_NAME = "init";
  private static final String ENV_QZONE_VERSION_NAME = "isQzoneVersionRight";
  public static final String EXTEND_FRAGMENT_CLASS_NAME = "com.qzone.feed.ui.activity.QQLebaExtendFeedFragment";
  public static final String FRIEND_FRAGMENT_CLASS_NAME = "com.qzone.feed.ui.activity.QQLebaFriendFeedFragment";
  private static final String MSG_FEED_HOLDER_CLASS_NAME = "com.qzone.feed.ui.activity.QZoneMsgFeedViewHolder";
  private static final String QZONE_CONFIG_KEY_MSG_PAGE_TITLE = "msg_page_title";
  private static final String QZONE_CONFIG_KEY_SHOW_SUB_FEEDS = "show_sub_feeds";
  private static final AtomicReference<SharedPreferences> QZONE_SP = new AtomicReference();
  private static final String QZONE_SP_NAME = "qzone_api_proxy_sp_name";
  public static final String SCHOOL_LIST_CLASS_NAME = "com.qzone.feed.ui.activity.QQSchoolExtendFeedsListView";
  private static final String SERVLET_CLASS_NAME = "com.qzone.common.servlet.QZoneServlet";
  private static final String TAG = "QZoneApiProxy";
  private static volatile boolean sIsEnvInit;
  private static volatile boolean sIsInit;
  public static volatile boolean sIsQzoneInstalled;
  public static volatile boolean sIsQzoneVersionRight;
  private static volatile WeakReference<QQAppInterface> sLastRuntimeRef;
  private static volatile WeakReference<PluginManagerClient> sPluginClientRef = new WeakReference(null);
  private static volatile Constructor<?> sSchoolExtendListConstructor;
  
  @Nullable
  public static Fragment createLebaFragment(@NonNull Activity paramActivity, @NonNull QQAppInterface paramQQAppInterface, @NonNull String paramString)
  {
    if (!sIsInit) {
      QZLog.w("QZoneApiProxy", "createLebaFragment: not init yet");
    }
    for (;;)
    {
      return null;
      paramString = loadQZoneClass(paramQQAppInterface.getApp(), paramString);
      if (paramString == null)
      {
        QZLog.e("QZoneApiProxy", "clazz==null");
        return null;
      }
      try
      {
        paramString = (Fragment)paramString.newInstance();
        if (paramString == null) {
          continue;
        }
        if ((paramString instanceof QzoneFragmentImpl))
        {
          try
          {
            ((QzoneFragmentImpl)paramString).attachQQContext(paramActivity, paramQQAppInterface);
            i = 1;
          }
          catch (Throwable paramActivity)
          {
            for (;;)
            {
              QZLog.w("QZoneApiProxy", "createLebaFragment: failed to init instance", paramActivity);
              i = 0;
              continue;
              paramString = null;
            }
          }
          if (i != 0) {
            return paramString;
          }
        }
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          QZLog.w("QZoneApiProxy", "createLebaFragment: failed to create instance", paramString);
          paramString = null;
          continue;
          int i = 1;
        }
      }
    }
  }
  
  @Nullable
  public static FeedViewHolderInterface createMsgFeedViewHolder(@NonNull Activity paramActivity)
  {
    if (!sIsInit) {
      QZLog.w("QZoneApiProxy", "createMsgFeedViewHolder: not init yet");
    }
    for (;;)
    {
      return null;
      Object localObject1 = loadQZoneClass(paramActivity, "com.qzone.feed.ui.activity.QZoneMsgFeedViewHolder");
      if (localObject1 == null)
      {
        QZLog.w("QZoneApiProxy", "createMsgFeedViewHolder: failed to get class");
        return null;
      }
      try
      {
        localObject1 = ((Class)localObject1).getConstructor(new Class[] { Activity.class });
        if (localObject1 == null) {
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        try
        {
          paramActivity = (FeedViewHolderInterface)((Constructor)localObject1).newInstance(new Object[] { paramActivity });
          return paramActivity;
          localThrowable = localThrowable;
          QZLog.w("QZoneApiProxy", "createMsgFeedViewHolder failed to get constructor", localThrowable);
          Object localObject2 = null;
        }
        catch (Throwable paramActivity)
        {
          for (;;)
          {
            QZLog.w("QZoneApiProxy", "createMsgFeedViewHolder failed to create instance", paramActivity);
            paramActivity = null;
          }
        }
      }
    }
  }
  
  public static View createSchoolExtendList(Context paramContext, AttributeSet paramAttributeSet)
  {
    boolean bool = true;
    StringBuilder localStringBuilder = new StringBuilder().append("createSchoolExtendList: ");
    if (sSchoolExtendListConstructor != null) {}
    for (;;)
    {
      QZLog.i("QZoneApiProxy", bool);
      if (sSchoolExtendListConstructor != null) {
        break;
      }
      return null;
      bool = false;
    }
    try
    {
      paramContext = (View)sSchoolExtendListConstructor.newInstance(new Object[] { paramContext, paramAttributeSet });
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      QZLog.w("QZoneApiProxy", "onCreateView: failed", paramContext);
    }
    return null;
  }
  
  public static QQAppInterface getLastRuntime()
  {
    if (sLastRuntimeRef == null) {
      return null;
    }
    return (QQAppInterface)sLastRuntimeRef.get();
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
      paramContext = anvx.a(2131719159);
    }
    return paramContext;
  }
  
  public static boolean initEnv(@NonNull Context paramContext, @NonNull QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = false;
    long l1 = System.nanoTime();
    QZLog.e("QZoneApiProxy", "initEnv: start");
    boolean bool1;
    if (sIsEnvInit) {
      bool1 = true;
    }
    for (;;)
    {
      return bool1;
      if (ENV_CLASS == null) {
        ENV_CLASS = loadQZoneClass(paramContext, "com.qzone.app.QZoneRunInQQEnv");
      }
      QZLog.e("QZoneApiProxy", "initEnv: loadQZoneClass");
      bool1 = bool2;
      if (ENV_CLASS == null) {
        continue;
      }
      try
      {
        paramContext = ENV_CLASS.getMethod("init", new Class[] { QQAppInterface.class });
        bool1 = bool2;
        if (paramContext == null) {
          continue;
        }
      }
      catch (Throwable paramContext)
      {
        try
        {
          bool1 = ((Boolean)paramContext.invoke(null, new Object[] { paramQQAppInterface })).booleanValue();
          sIsEnvInit = bool1;
          long l2 = System.nanoTime();
          QZLog.e("QZoneApiProxy", "initEnv: end " + sIsEnvInit + " " + (l2 - l1));
          return sIsEnvInit;
          paramContext = paramContext;
          QZLog.w("QZoneApiProxy", "initEnv: failed to get init env method", paramContext);
          paramContext = null;
        }
        catch (Throwable paramContext)
        {
          for (;;)
          {
            QZLog.w("QZoneApiProxy", "initEnv: failed to init", paramContext);
            bool1 = false;
          }
        }
      }
    }
  }
  
  public static void initSchoolExtendListCreator()
  {
    PublicFragmentActivity.a("com.qzone.feed.ui.activity.QQSchoolExtendFeedsListView", new QZoneApiProxy.SchoolExtendListCreator(null));
  }
  
  public static boolean initServlet(@NonNull Context paramContext, @NonNull QQAppInterface paramQQAppInterface)
  {
    j = 0;
    l1 = System.nanoTime();
    QZLog.e("QZoneApiProxy", "initServlet: start");
    if (sIsInit) {
      return true;
    }
    ((blvy)paramQQAppInterface.getManager(QQManagerFactory.MGR_PLUGIN)).a("qzone_plugin.apk");
    paramContext = loadQZoneClass(paramContext, "com.qzone.common.servlet.QZoneServlet");
    if (paramContext == null) {
      return false;
    }
    ServletContainer localServletContainer;
    try
    {
      localObject1 = (MSFServlet)paramContext.newInstance();
      if (localObject1 == null) {
        return false;
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        QZLog.w("QZoneApiProxy", "initServlet: failed to get servlet instance", paramContext);
        localObject1 = null;
      }
      try
      {
        paramContext = AppRuntime.class.getDeclaredField("mServletContainer");
        paramContext.setAccessible(true);
        localServletContainer = (ServletContainer)paramContext.get(paramQQAppInterface);
        if (localServletContainer == null) {
          return false;
        }
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          QZLog.w("QZoneApiProxy", "initServlet: failed to get container", paramContext);
          localServletContainer = null;
        }
      }
    }
    for (;;)
    {
      try
      {
        paramContext = ServletContainer.class.getDeclaredField("managedServlet");
        paramContext.setAccessible(true);
        paramContext = (Map)paramContext.get(localServletContainer);
        Object localObject2;
        QZLog.w("QZoneApiProxy", "initServlet: failed to get container field", localThrowable2);
      }
      catch (Throwable localThrowable2)
      {
        try
        {
          localObject2 = ServletContainer.class.getDeclaredField("actionMap");
          ((Field)localObject2).setAccessible(true);
          localObject2 = (Map)((Field)localObject2).get(localServletContainer);
          if ((paramContext != null) && (localObject2 != null)) {
            break;
          }
          return false;
        }
        catch (Throwable localThrowable3)
        {
          Object localObject3;
          Object localObject4;
          Method localMethod;
          int i;
          int k;
          Set localSet;
          long l2;
          break label201;
        }
        localThrowable2 = localThrowable2;
        paramContext = null;
      }
      label201:
      localObject3 = null;
    }
    try
    {
      localObject4 = Servlet.class.getDeclaredMethod("init", new Class[] { AppRuntime.class, ServletContainer.class });
      ((Method)localObject4).setAccessible(true);
      localMethod = Servlet.class.getDeclaredMethod("onCreate", new Class[0]);
      localMethod.setAccessible(true);
      ((Method)localObject4).invoke(localObject1, new Object[] { paramQQAppInterface, localServletContainer });
      localMethod.invoke(localObject1, new Object[0]);
      i = 1;
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        QZLog.w("QZoneApiProxy", "initServlet: failed to get init method", localThrowable1);
        i = 0;
      }
      try
      {
        paramContext.put("com.qzone.common.servlet.QZoneServlet", localObject1);
        localObject4 = ((MSFServlet)localObject1).getPreferSSOCommands();
        if (localObject4 == null) {
          break label433;
        }
        k = localObject4.length;
        i = j;
        while (i < k)
        {
          localMethod = localObject4[i];
          localSet = (Set)localObject3.get(localMethod);
          localObject1 = localSet;
          if (localSet == null)
          {
            localObject1 = new HashSet();
            localObject3.put(localMethod, localObject1);
          }
          ((Set)localObject1).add("com.qzone.common.servlet.QZoneServlet");
          i += 1;
        }
        recordRuntime(paramQQAppInterface);
        l2 = System.nanoTime();
        QZLog.i("QZoneApiProxy", "initServlet: ok " + paramQQAppInterface.getCurrentUin() + " " + (l2 - l1));
        sIsInit = true;
        return true;
      }
      finally {}
    }
    if (i == 0) {
      return false;
    }
  }
  
  public static boolean isInQZoneEnvironment()
  {
    return !sIsInit;
  }
  
  private static boolean isQZonePluginValid(@NonNull Activity paramActivity, @NonNull QQAppInterface paramQQAppInterface)
  {
    boolean bool = true;
    int i = LocalMultiProcConfig.getInt4Uin("creditlevel", 0, paramQQAppInterface.getLongAccountUin());
    if (i == 8)
    {
      QZLog.e("QZoneApiProxy", "creditLevel" + i);
      return false;
    }
    if ((sIsInit) && (sIsEnvInit)) {
      return true;
    }
    if (!isQzonePluginInstalledAndVersionRight(null))
    {
      QZLog.e("QZoneApiProxy", "file not exists");
      return false;
    }
    if (BaseApplicationImpl.isCurrentVersionFirstLaunch)
    {
      if (InstallPlugins.a == null)
      {
        i = Build.VERSION.SDK_INT;
        if ((i == 21) || (i == 22))
        {
          QZLog.e("QZoneApiProxy", "isQZonePluginValid null install result");
          return false;
        }
      }
      else if (!InstallPlugins.a.a)
      {
        QZLog.i("QZoneApiProxy", "isQZonePluginValid qzone install failed");
        return false;
      }
      try
      {
        QzonePluginProxyActivity.getQZonePluginClassLoader(BaseApplicationImpl.getApplication());
        if ((!initServlet(paramActivity, paramQQAppInterface)) || (!initEnv(paramActivity, paramQQAppInterface)))
        {
          QZLog.e("QZoneApiProxy", "initServlet erro");
          return false;
        }
      }
      catch (Throwable paramActivity)
      {
        QLog.e("QZoneApiProxy", 1, "needShowQzoneFrame", paramActivity);
        return false;
      }
      return true;
    }
    if ((initServlet(paramActivity, paramQQAppInterface)) && (initEnv(paramActivity, paramQQAppInterface))) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean isQzoneInstalled()
  {
    boolean bool1;
    if (sIsQzoneInstalled) {
      bool1 = true;
    }
    boolean bool2;
    do
    {
      return bool1;
      PluginManagerClient localPluginManagerClient = (PluginManagerClient)sPluginClientRef.get();
      if (localPluginManagerClient == null) {
        break;
      }
      bool2 = localPluginManagerClient.isPluginInstalled("qzone_plugin.apk");
      bool1 = bool2;
    } while (!bool2);
    QZLog.i("QZoneApiProxy", " isQzoneInstalled = true");
    sIsQzoneInstalled = true;
    return bool2;
    PluginManagerHelper.getPluginInterface(BaseApplicationImpl.getApplication(), new QZoneApiProxy.2());
    return false;
  }
  
  public static boolean isQzonePluginInstalledAndVersionRight(@Nullable QZoneApiProxy.QZoneLoadCallback paramQZoneLoadCallback)
  {
    QZLog.i("QZoneApiProxy", "isQzonePluginInstalledAndVersionRight: sIsQzoneVInstalled=" + sIsQzoneInstalled + "    isQzoneVersionRight=" + sIsQzoneVersionRight);
    boolean bool2;
    if ((sIsQzoneInstalled) && (isQzoneVersionRight(BaseApplicationImpl.getApplication())))
    {
      if (paramQZoneLoadCallback != null) {
        paramQZoneLoadCallback.onLoadOver(true);
      }
      bool2 = true;
      return bool2;
    }
    PluginManagerClient localPluginManagerClient = (PluginManagerClient)sPluginClientRef.get();
    if (localPluginManagerClient != null)
    {
      boolean bool1 = localPluginManagerClient.isPluginInstalled("qzone_plugin.apk");
      if (bool1)
      {
        QZLog.i("QZoneApiProxy", " sIsQzoneVInstalled = true");
        sIsQzoneInstalled = true;
      }
      if ((bool1) && (isQzoneVersionRight(BaseApplicationImpl.getApplication()))) {}
      for (bool1 = true;; bool1 = false)
      {
        bool2 = bool1;
        if (paramQZoneLoadCallback == null) {
          break;
        }
        paramQZoneLoadCallback.onLoadOver(bool1);
        return bool1;
      }
    }
    long l = System.nanoTime();
    PluginManagerHelper.getPluginInterface(BaseApplicationImpl.getApplication(), new QZoneApiProxy.1(l, paramQZoneLoadCallback));
    return false;
  }
  
  private static boolean isQzoneVersionRight(@NonNull Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1;
    if (sIsQzoneVersionRight) {
      bool1 = true;
    }
    for (;;)
    {
      return bool1;
      if (ENV_CLASS == null) {
        ENV_CLASS = loadQZoneClass(paramContext, "com.qzone.app.QZoneRunInQQEnv");
      }
      QZLog.e("QZoneApiProxy", "isQzoneVersionRight: loadQZoneClass");
      bool1 = bool2;
      if (ENV_CLASS == null) {
        continue;
      }
      try
      {
        paramContext = ENV_CLASS.getMethod("isQzoneVersionRight", new Class[0]);
        bool1 = bool2;
        if (paramContext == null) {
          continue;
        }
      }
      catch (Throwable paramContext)
      {
        try
        {
          bool1 = ((Boolean)paramContext.invoke(null, new Object[0])).booleanValue();
          sIsQzoneVersionRight = bool1;
          return bool1;
          paramContext = paramContext;
          QZLog.w("QZoneApiProxy", "isQzoneVersionRight: failed to get init env method", paramContext);
          paramContext = null;
        }
        catch (Throwable paramContext)
        {
          for (;;)
          {
            QZLog.w("QZoneApiProxy", "isQzoneVersionRight: failed to init", paramContext);
            bool1 = false;
          }
        }
      }
    }
  }
  
  public static boolean isRightAndroidVersion()
  {
    return Build.VERSION.SDK_INT != 19;
  }
  
  public static boolean isRightAndroidVersionForStickyNote()
  {
    return Build.VERSION.SDK_INT > 19;
  }
  
  @Nullable
  private static <T> Class<T> loadQZoneClass(@NonNull Context paramContext, @NonNull String paramString)
  {
    Object localObject1 = null;
    try
    {
      localObject2 = Class.forName(paramString);
      localObject1 = localObject2;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        try
        {
          Object localObject2 = QzonePluginProxyActivity.getQZonePluginClassLoader(paramContext).loadClass(paramString);
          return localObject2;
        }
        catch (Throwable paramContext)
        {
          QZLog.w("QZoneApiProxy", "createAdapter: failed to get class by qzone plugin class loader", paramContext);
        }
        localThrowable = localThrowable;
        QZLog.d("QZoneApiProxy", 2, "createAdapter: failed to get class by normal class loader", localThrowable);
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {}
    return localObject1;
  }
  
  public static boolean needLoadQZoneEnv()
  {
    return needLoadQZoneEnv(null);
  }
  
  public static boolean needLoadQZoneEnv(@Nullable QZoneApiProxy.QZoneLoadCallback paramQZoneLoadCallback)
  {
    QZLog.i("QZoneApiProxy", "needLoadQZoneEnv: is launch ? " + BaseApplicationImpl.isCurrentVersionFirstLaunch);
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
  
  public static boolean needShowAioFeedList(@Nullable Activity paramActivity, @Nullable QQAppInterface paramQQAppInterface)
  {
    if ((paramActivity == null) || (paramQQAppInterface == null)) {}
    while (QzoneConfig.getInstance().getConfig("QZoneSetting", "AioShowFeedList", 1) == 0) {
      return false;
    }
    return isQZonePluginValid(paramActivity, paramQQAppInterface);
  }
  
  public static boolean needShowQzoneFrame(@Nullable Activity paramActivity, @Nullable QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramActivity != null)
    {
      if (paramQQAppInterface != null) {
        break label19;
      }
      bool1 = bool2;
    }
    label19:
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (!needLoadQZoneEnv());
        if (!bdfk.a())
        {
          QZLog.e("QZoneApiProxy", "isNowSimpleUI no");
          return false;
        }
        int i = LocalMultiProcConfig.getInt4Uin("qzone_feed_gray_mask", 0, paramQQAppInterface.getLongAccountUin());
        if ((0x10000 & i) == 0)
        {
          QZLog.e("QZoneApiProxy", "grayMask no" + i);
          return false;
        }
        bool2 = isQZonePluginValid(paramActivity, paramQQAppInterface);
        bool1 = bool2;
      } while (!bool2);
      bool1 = bool2;
    } while (paramQQAppInterface == getLastRuntime());
    onAccountChange(paramActivity, paramQQAppInterface);
    return bool2;
  }
  
  public static boolean needShowSchoolExtendFeed(@Nullable Activity paramActivity, @Nullable QQAppInterface paramQQAppInterface)
  {
    boolean bool1 = true;
    if ((paramActivity == null) || (paramQQAppInterface == null)) {
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      boolean bool2 = isQZonePluginValid(paramActivity, paramQQAppInterface);
      if ((bool2) && (paramQQAppInterface != getLastRuntime())) {
        onAccountChange(paramActivity, paramQQAppInterface);
      }
      if (sSchoolExtendListConstructor == null)
      {
        paramQQAppInterface = loadQZoneClass(paramActivity, "com.qzone.feed.ui.activity.QQSchoolExtendFeedsListView");
        if (paramQQAppInterface == null) {}
      }
      try
      {
        sSchoolExtendListConstructor = paramQQAppInterface.getConstructor(new Class[] { Context.class, AttributeSet.class });
        try
        {
          paramActivity.getLayoutInflater().inflate(2131561112, null);
          i = 1;
        }
        catch (Throwable paramActivity)
        {
          for (;;)
          {
            QZLog.w("QZoneApiProxy", "needShowSchoolExtendFeed: inflate failed", paramActivity);
            int i = 0;
          }
        }
        if ((bool2) && (sSchoolExtendListConstructor != null) && (i != 0)) {
          continue;
        }
        return false;
      }
      catch (Throwable paramQQAppInterface)
      {
        for (;;)
        {
          QZLog.w("QZoneApiProxy", "needShowSchoolExtendFeed: failed to get school extend list view constructor", paramQQAppInterface);
        }
      }
    }
  }
  
  public static boolean needShowSubFeedList(@Nullable Activity paramActivity, @Nullable QQAppInterface paramQQAppInterface)
  {
    if ((paramActivity == null) || (paramQQAppInterface == null)) {}
    while (QzoneConfig.getInstance().getConfig("QZoneSetting", "SubShowFeedList", 1) == 0) {
      return false;
    }
    if (!getSelfSharedPreferences(paramActivity).getBoolean("show_sub_feeds", false)) {
      QZLog.i("QZoneApiProxy", "needShowSubFeedList: close by server");
    }
    return isQZonePluginValid(paramActivity, paramQQAppInterface);
  }
  
  public static void onAccountChange(@NonNull Context paramContext, @NonNull QQAppInterface paramQQAppInterface)
  {
    QZLog.i("QZoneApiProxy", "onAccountChange: " + paramQQAppInterface.getCurrentUin() + " " + sIsEnvInit + " " + sIsInit);
    if (!sIsEnvInit) {
      initEnv(paramContext, paramQQAppInterface);
    }
    for (;;)
    {
      return;
      if (ENV_CLASS == null) {
        ENV_CLASS = loadQZoneClass(paramContext, "com.qzone.app.QZoneRunInQQEnv");
      }
      if (ENV_CLASS == null) {
        continue;
      }
      if (ENV_CHANGE_METHOD == null) {}
      try
      {
        ENV_CHANGE_METHOD = ENV_CLASS.getMethod("onAccountChange", new Class[] { QQAppInterface.class });
        if (ENV_CHANGE_METHOD == null) {
          continue;
        }
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          ENV_CHANGE_METHOD.invoke(null, new Object[] { paramQQAppInterface });
          if (!sIsInit) {
            continue;
          }
          sIsInit = false;
          initServlet(paramContext, paramQQAppInterface);
          return;
          localThrowable1 = localThrowable1;
          QZLog.w("QZoneApiProxy", "onAccountChange: failed to get change account method", localThrowable1);
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            QZLog.w("QZoneApiProxy", "onAccountChange: failed to call change account method", localThrowable2);
          }
        }
      }
    }
  }
  
  public static void recordRuntime(QQAppInterface paramQQAppInterface)
  {
    sLastRuntimeRef = new WeakReference(paramQQAppInterface);
  }
  
  public static void recordSubFeedConfig(@NonNull Context paramContext, boolean paramBoolean, @Nullable String paramString)
  {
    QZLog.i("QZoneApiProxy", "recordShowSubFeedConfig: " + paramBoolean + " " + paramString);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    getSelfSharedPreferences(paramContext).edit().putBoolean("show_sub_feeds", paramBoolean).putString("msg_page_title", str).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.api.QZoneApiProxy
 * JD-Core Version:    0.7.0.1
 */