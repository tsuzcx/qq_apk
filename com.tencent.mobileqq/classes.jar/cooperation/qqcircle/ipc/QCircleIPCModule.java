package cooperation.qqcircle.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import cooperation.qqcircle.proxy.QCircleInvokeProxy;
import eipc.EIPCResult;

public class QCircleIPCModule
  extends QIPCModule
{
  public QCircleIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static QCircleIPCModule getInstance()
  {
    return QCircleIPCModule.InstanceHolder.INSTANCE;
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if ("action_clustering_local_photo".equals(paramString)) {
      QCircleInvokeProxy.invoke(2, 5, new Object[0]);
    } else if ("action_open_clustering_local_photo".equals(paramString)) {
      QCircleInvokeProxy.invoke(2, 6, new Object[0]);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.ipc.QCircleIPCModule
 * JD-Core Version:    0.7.0.1
 */