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
    if (paramClass.isAnnotationPresent(QPlugin.class)) {
      return apiImpl(paramClass, true);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(QPlugin.class.getName());
    localStringBuilder.append(" need add to your api class");
    localStringBuilder.append(paramClass.getSimpleName());
    throw new QRoutePluginException(localStringBuilder.toString());
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
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getQRemoteProxy null, class=");
      ((StringBuilder)localObject).append(paramClass);
      localObject = ((StringBuilder)localObject).toString();
      logger.warning("QRoute", (String)localObject);
      throw new IllegalStateException((String)localObject);
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ClassNotFoundException error, class= ");
      localStringBuilder.append(paramClass.getName());
      localStringBuilder.append("target Class= ");
      localStringBuilder.append(str);
      paramClass = localStringBuilder.toString();
      logger.warning("QRoute", paramClass, localClassNotFoundException);
      throw new IllegalStateException(paramClass, localClassNotFoundException);
    }
  }
  
  @NonNull
  private static <T extends QRouteApi> T apiImpl(Class<T> paramClass, boolean paramBoolean)
  {
    Object localObject1 = QRouteUtil.convertApiToImplClass(paramClass);
    if (mConfig.isForceCheck())
    {
      QRouteUtil.isAnnotationQAPI(paramClass);
      processCheck(paramClass);
      RemoteProxyUtil.verifyClass(paramClass);
    }
    if (QRouteUtil.isSingleton(paramClass)) {
      return (QRouteApi)SingletonPool.get(paramClass, (String)localObject1, paramBoolean);
    }
    try
    {
      if (APICycleInitCheckUtil.checkAndSet((String)localObject1))
      {
        localObject2 = Class.forName((String)localObject1);
        QRouteApi localQRouteApi = (QRouteApi)((Class)localObject2).newInstance();
        if (localQRouteApi != null)
        {
          APICycleInitCheckUtil.checkAndRemove((String)localObject1);
          return localQRouteApi;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getInstance null! @");
        ((StringBuilder)localObject1).append(((Class)localObject2).getName());
        throw new IllegalStateException(((StringBuilder)localObject1).toString());
      }
      APICycleInitCheckUtil.removeOnException();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("find cycle init from:");
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject1 = ((StringBuilder)localObject2).toString();
      logger.warning("QRoute", (String)localObject1);
      throw new IllegalStateException((String)localObject1);
    }
    catch (Exception localException)
    {
      APICycleInitCheckUtil.removeOnException();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("build API fatal:");
      ((StringBuilder)localObject2).append(paramClass.getSimpleName());
      ((StringBuilder)localObject2).append(" ");
      ((StringBuilder)localObject2).append(localException.toString());
      paramClass = ((StringBuilder)localObject2).toString();
      logger.warning("QRoute", paramClass, localException);
      throw new IllegalStateException(paramClass, localException);
    }
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
    if (mConfig.getProcessCheck() != null)
    {
      if (mConfig.getProcessCheck().check(paramClass, mConfig.getProcessName(), mConfig.isForceCheck())) {
        return;
      }
      Object localObject = logger;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkProcessName failed api:");
      localStringBuilder.append(paramClass.getSimpleName());
      ((ILogger)localObject).warning("QRoute", localStringBuilder.toString());
      localObject = new StringBuilder(50);
      ((StringBuilder)localObject).append("QRouteApi: ");
      ((StringBuilder)localObject).append(paramClass.getSimpleName());
      ((StringBuilder)localObject).append(" can not run on this process: ");
      ((StringBuilder)localObject).append(mConfig.getProcessName());
      ((StringBuilder)localObject).append("，请联系API开发者沟通处理。\n");
      throw new IllegalStateException(((StringBuilder)localObject).toString());
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
  
  public static void startUri(URIRequest paramURIRequest)
  {
    startUri(paramURIRequest, null);
  }
  
  public static void startUri(URIRequest paramURIRequest, Router.OnCompleteListener paramOnCompleteListener)
  {
    Router.getInstance().start(paramURIRequest, paramOnCompleteListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.QRoute
 * JD-Core Version:    0.7.0.1
 */