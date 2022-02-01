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
      if ((paramQRemoteResult.code != 0) || (paramQRemoteResult.data == null))
      {
        paramString = new StringBuilder().append("Call ").append(this.clazz.getName()).append("$").append(paramString).append(" fail, code=").append(paramQRemoteResult.code).append(" data=");
        if (paramQRemoteResult.data == null) {}
        for (boolean bool = true;; bool = false)
        {
          paramString = bool;
          QRoute.logger.warning("QRouteRemoteHandler", paramString, paramQRemoteResult.throwable);
          throw new IllegalStateException(paramString, paramQRemoteResult.throwable);
        }
      }
      String str = paramQRemoteResult.data.getString("resultType");
      if (str == null)
      {
        paramString = "Call " + this.clazz.getName() + "$" + paramString + " fail, resultType is null";
        QRoute.logger.warning("QRouteRemoteHandler", paramString);
        throw new IllegalStateException(paramString, paramQRemoteResult.throwable);
      }
      return RemoteProxyUtil.getBundleParameter(paramQRemoteResult.data, str, "result");
    }
    paramString = "callAPISync before init, " + this.clazz.getName() + "$" + paramString + " fail, result is null";
    QRoute.logger.warning("QRouteRemoteHandler", paramString);
    throw new IllegalStateException(paramString);
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    if (QRoute.getConfig().isForceCheck()) {
      RemoteProxyUtil.checkCurrentThread(this.clazz, paramMethod);
    }
    paramObject = new Bundle();
    paramObject.setClassLoader(getClass().getClassLoader());
    RemoteProxyUtil.checkMethodAndParameter(paramMethod, true, paramArrayOfObject);
    RemoteProxyUtil.setMethodAndParameter(paramMethod, paramArrayOfObject, paramObject);
    long l = System.currentTimeMillis();
    paramArrayOfObject = "callApi$" + this.clazz.getName() + "$" + paramMethod.getName();
    paramObject = QRemoteProxy.callServerSync(paramArrayOfObject, paramObject);
    if (QRoute.logger.isColorLevel()) {
      QRoute.logger.debug("QRouteRemoteHandler", "action=" + paramArrayOfObject + " cost=" + (System.currentTimeMillis() - l));
    }
    return checkResult(paramMethod.getName(), paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.remote.QRouteRemoteHandler
 * JD-Core Version:    0.7.0.1
 */