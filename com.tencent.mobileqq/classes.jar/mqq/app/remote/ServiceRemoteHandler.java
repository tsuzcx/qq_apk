package mqq.app.remote;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.remote.RemoteProxyUtil;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import mqq.app.api.IRuntimeService;

public class ServiceRemoteHandler
  implements InvocationHandler
{
  private static final String TAG = "ServiceRemoteHandler";
  private final Class<? extends IRuntimeService> clazz;
  
  public ServiceRemoteHandler(Class<? extends IRuntimeService> paramClass)
  {
    this.clazz = paramClass;
  }
  
  private Object checkResult(@NonNull String paramString, EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult != null)
    {
      if ((paramEIPCResult.code != 0) || (paramEIPCResult.data == null))
      {
        paramString = new StringBuilder().append("Call ").append(this.clazz.getName()).append("$").append(paramString).append(" fail, code=").append(paramEIPCResult.code).append(" data=");
        if (paramEIPCResult.data == null) {}
        for (boolean bool = true;; bool = false)
        {
          paramString = bool;
          QLog.e("ServiceRemoteHandler", 1, paramString, paramEIPCResult.e);
          throw new IllegalStateException(paramString, paramEIPCResult.e);
        }
      }
      String str = paramEIPCResult.data.getString("resultType");
      if (str == null)
      {
        paramString = "Call " + this.clazz.getName() + "$" + paramString + " fail, resultType is null";
        QLog.e("ServiceRemoteHandler", 1, paramString);
        throw new IllegalStateException(paramString, paramEIPCResult.e);
      }
      return RemoteProxyUtil.getBundleParameter(paramEIPCResult.data, str, "result");
    }
    paramString = "callAPISync before init, " + this.clazz.getName() + "$" + paramString + " fail, result is null";
    QLog.e("ServiceRemoteHandler", 1, paramString);
    throw new IllegalStateException(paramString);
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    paramObject = new Bundle();
    paramObject.setClassLoader(getClass().getClassLoader());
    RemoteProxyUtil.checkMethodAndParameter(paramMethod, true, paramArrayOfObject);
    RemoteProxyUtil.setMethodAndParameter(paramMethod, paramArrayOfObject, paramObject);
    long l = System.currentTimeMillis();
    paramArrayOfObject = "callService$" + this.clazz.getName() + "$" + paramMethod.getName();
    paramObject = QIPCClientHelper.getInstance().callServer("QRouteIPCModule", paramArrayOfObject, paramObject);
    if (QLog.isColorLevel()) {
      QLog.d("ServiceRemoteHandler", 2, "action=" + paramArrayOfObject + " cost=" + (System.currentTimeMillis() - l));
    }
    return checkResult(paramMethod.getName(), paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.app.remote.ServiceRemoteHandler
 * JD-Core Version:    0.7.0.1
 */