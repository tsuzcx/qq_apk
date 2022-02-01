package com.tencent.mobileqq.qroute.remote;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.QRouteConfig;
import com.tencent.mobileqq.qroute.route.ILogger;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class QRouteRemoteHandler
  implements InvocationHandler
{
  private static final String TAG = "QRouteRemoteHandler";
  private final Class<? extends QRouteApi> clazz;
  
  public QRouteRemoteHandler(Class<? extends QRouteApi> paramClass)
  {
    this.clazz = paramClass;
  }
  
  @Nullable
  private Object checkResult(@NonNull String paramString, QRemoteResult paramQRemoteResult)
  {
    if (paramQRemoteResult != null)
    {
      if ((paramQRemoteResult.code == 0) && (paramQRemoteResult.data != null))
      {
        localObject = paramQRemoteResult.data.getString("resultType");
        if (localObject != null) {
          return RemoteProxyUtil.getBundleParameter(paramQRemoteResult.data, (String)localObject, "result");
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Call ");
        ((StringBuilder)localObject).append(this.clazz.getName());
        ((StringBuilder)localObject).append("$");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" fail, resultType is null");
        paramString = ((StringBuilder)localObject).toString();
        QRoute.logger.warning("QRouteRemoteHandler", paramString);
        throw new IllegalStateException(paramString, paramQRemoteResult.throwable);
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Call ");
      ((StringBuilder)localObject).append(this.clazz.getName());
      ((StringBuilder)localObject).append("$");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" fail, code=");
      ((StringBuilder)localObject).append(paramQRemoteResult.code);
      ((StringBuilder)localObject).append(" data=");
      boolean bool;
      if (paramQRemoteResult.data == null) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject).append(bool);
      paramString = ((StringBuilder)localObject).toString();
      QRoute.logger.warning("QRouteRemoteHandler", paramString, paramQRemoteResult.throwable);
      throw new IllegalStateException(paramString, paramQRemoteResult.throwable);
    }
    paramQRemoteResult = new StringBuilder();
    paramQRemoteResult.append("callAPISync before init, ");
    paramQRemoteResult.append(this.clazz.getName());
    paramQRemoteResult.append("$");
    paramQRemoteResult.append(paramString);
    paramQRemoteResult.append(" fail, result is null");
    paramString = paramQRemoteResult.toString();
    QRoute.logger.warning("QRouteRemoteHandler", paramString);
    throw new IllegalStateException(paramString);
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    if (QRoute.getConfig().isForceCheck()) {
      RemoteProxyUtil.checkCurrentThread(this.clazz, paramMethod);
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).setClassLoader(getClass().getClassLoader());
    RemoteProxyUtil.checkMethodAndParameter(paramMethod, true, paramArrayOfObject);
    RemoteProxyUtil.setMethodAndParameter(paramMethod, paramArrayOfObject, (Bundle)localObject);
    long l = System.currentTimeMillis();
    paramObject = new StringBuilder();
    paramObject.append("callApi$");
    paramObject.append(this.clazz.getName());
    paramObject.append("$");
    paramObject.append(paramMethod.getName());
    paramObject = paramObject.toString();
    paramArrayOfObject = QRemoteProxy.callServerSync(paramObject, (Bundle)localObject);
    if (QRoute.logger.isColorLevel())
    {
      localObject = QRoute.logger;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("action=");
      localStringBuilder.append(paramObject);
      localStringBuilder.append(" cost=");
      localStringBuilder.append(System.currentTimeMillis() - l);
      ((ILogger)localObject).debug("QRouteRemoteHandler", localStringBuilder.toString());
    }
    return checkResult(paramMethod.getName(), paramArrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.remote.QRouteRemoteHandler
 * JD-Core Version:    0.7.0.1
 */