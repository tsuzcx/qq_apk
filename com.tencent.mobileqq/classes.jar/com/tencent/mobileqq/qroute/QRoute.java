package com.tencent.mobileqq.qroute;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qroute.annotation.QPlugin;
import com.tencent.mobileqq.qroute.exception.QRoutePluginException;
import com.tencent.mobileqq.qroute.module.IQRoutePlugin;
import com.tencent.mobileqq.qroute.module.IQRoutePluginFactory;
import com.tencent.mobileqq.qroute.remote.QRemoteProxy;
import com.tencent.mobileqq.qroute.remote.RemoteProxyUtil;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.ILogger;
import com.tencent.mobileqq.qroute.route.Router;
import com.tencent.mobileqq.qroute.route.Router.OnCompleteListener;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.qroute.utils.APICycleInitCheckUtil;
import com.tencent.mobileqq.qroute.utils.IProcessCheck;
import com.tencent.mobileqq.qroute.utils.QRouteUtil;

public class QRoute
{
  public static final String TAG = "QRoute";
  public static final String TAG_QROUTE_API = "QRouteApi: ";
  public static ILogger logger = mConfig.getLogger();
  static QRouteConfig mConfig = new QRouteConfigBuilder("").create();
  
  @NonNull
  public static <T extends QRouteApi> T api(Class<T> paramClass)
  {
    return apiImpl(paramClass, false);
  }
  
  public static <T extends QRouteApi> T apiFromPlugin(Class<T> paramClass)
  {
    if (!paramClass.isAnnotationPresent(QPlugin.class)) {
      throw new QRoutePluginException(QPlugin.class.getName() + " need add to your api class" + paramClass.getSimpleName());
    }
    return apiImpl(paramClass, true);
  }
  
  public static <T extends QRouteApi> T apiIPCSync(Class<T> paramClass)
  {
    if (TextUtils.isEmpty(mConfig.getProcessName())) {
      return api(paramClass);
    }
    if (mConfig.isForceCheck())
    {
      QRouteUtil.isAnnotationQAPI(paramClass);
      RemoteProxyUtil.verifyClass(paramClass);
    }
    String str = QRouteUtil.convertApiToImplClass(paramClass);
    try
    {
      Object localObject = QRemoteProxy.getProxy(paramClass, Class.forName(str));
      if ((localObject instanceof QRouteApi)) {
        return (QRouteApi)localObject;
      }
      localObject = "getQRemoteProxy null, class=" + paramClass;
      logger.warning("QRoute", (String)localObject);
      throw new IllegalStateException((String)localObject);
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      paramClass = "ClassNotFoundException error, class= " + paramClass.getName() + "target Class= " + str;
      logger.warning("QRoute", paramClass, localClassNotFoundException);
      throw new IllegalStateException(paramClass, localClassNotFoundException);
    }
  }
  
  @NonNull
  private static <T extends QRouteApi> T apiImpl(Class<T> paramClass, boolean paramBoolean)
  {
    String str = QRouteUtil.convertApiToImplClass(paramClass);
    if (mConfig.isForceCheck())
    {
      QRouteUtil.isAnnotationQAPI(paramClass);
      processCheck(paramClass);
      RemoteProxyUtil.verifyClass(paramClass);
    }
    if (QRouteUtil.isSingleton(paramClass)) {
      return (QRouteApi)SingletonPool.get(paramClass, str, paramBoolean);
    }
    try
    {
      if (!APICycleInitCheckUtil.checkAndSet(str))
      {
        APICycleInitCheckUtil.removeOnException();
        str = "find cycle init from:" + str;
        logger.warning("QRoute", str);
        throw new IllegalStateException(str);
      }
    }
    catch (Exception localException)
    {
      APICycleInitCheckUtil.removeOnException();
      paramClass = "build API fatal:" + paramClass.getSimpleName() + " " + localException.toString();
      logger.warning("QRoute", paramClass, localException);
      throw new IllegalStateException(paramClass, localException);
    }
    Class localClass = Class.forName(localException);
    QRouteApi localQRouteApi = (QRouteApi)localClass.newInstance();
    if (localQRouteApi == null) {
      throw new IllegalStateException("getInstance null! @" + localClass.getName());
    }
    APICycleInitCheckUtil.checkAndRemove(localException);
    return localQRouteApi;
  }
  
  public static QRouteConfig getConfig()
  {
    return mConfig;
  }
  
  public static void init(QRouteConfig paramQRouteConfig)
  {
    mConfig = paramQRouteConfig;
    logger = mConfig.getLogger();
    Router.getInstance().init(mConfig.getLogger());
    QRemoteProxy.init(mConfig.getRemoteProxy());
  }
  
  public static IQRoutePlugin plugin(String paramString)
  {
    return mConfig.getPluginFactory().createSingleton(paramString);
  }
  
  private static <T extends QRouteApi> void processCheck(Class<T> paramClass)
  {
    if ((mConfig.getProcessCheck() != null) && (!mConfig.getProcessCheck().check(paramClass, mConfig.getProcessName(), mConfig.isForceCheck())))
    {
      logger.warning("QRoute", "checkProcessName failed api:" + paramClass.getSimpleName());
      StringBuilder localStringBuilder = new StringBuilder(50);
      localStringBuilder.append("QRouteApi: ").append(paramClass.getSimpleName()).append(" can not run on this process: ").append(mConfig.getProcessName()).append("，请联系API开发者沟通处理。\n");
      throw new IllegalStateException(localStringBuilder.toString());
    }
  }
  
  public static void startUri(Context paramContext, String paramString)
  {
    Router.getInstance().start(paramContext, paramString);
  }
  
  public static void startUri(Context paramContext, String paramString, Router.OnCompleteListener paramOnCompleteListener)
  {
    Router.getInstance().start(new ActivityURIRequest(paramContext, paramString), paramOnCompleteListener);
  }
  
  public static void startUri(URIRequest paramURIRequest, Router.OnCompleteListener paramOnCompleteListener)
  {
    Router.getInstance().start(paramURIRequest, paramOnCompleteListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.QRoute
 * JD-Core Version:    0.7.0.1
 */