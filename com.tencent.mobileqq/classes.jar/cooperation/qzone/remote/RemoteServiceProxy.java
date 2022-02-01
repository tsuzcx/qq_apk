package cooperation.qzone.remote;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Looper;
import android.os.RemoteException;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qzone.QzonePluginProxyActivity;
import java.util.concurrent.ConcurrentLinkedQueue;

public class RemoteServiceProxy
{
  private static final String tag = "RemoteServiceProxy";
  private Class<? extends Service> clazz;
  protected ServiceConnection conn = new RemoteServiceProxy.1(this);
  protected volatile long lastStartSerivceTime = -1L;
  private IActionListener mActionListener;
  private String mUin;
  protected Object sendLock = new Object();
  protected ConcurrentLinkedQueue<SendMsg> sendMsgQueue = new ConcurrentLinkedQueue();
  protected volatile IServiceHandler serviceHandler;
  private String serviceName;
  
  public RemoteServiceProxy(String paramString1, Class<? extends Service> paramClass, String paramString2)
  {
    this.serviceName = paramString1;
    this.clazz = paramClass;
    this.mUin = paramString2;
  }
  
  private void sendMsgToServiceInner(SendMsg paramSendMsg)
  {
    try
    {
      if (this.serviceHandler != null)
      {
        this.serviceHandler.sendMsg(paramSendMsg);
        return;
      }
      try
      {
        sendFailedRespToApp(paramSendMsg, createWaiteRespTimeout(paramSendMsg, "main thread sendMsgToServiceFailed. serviceHandler is null."));
        return;
      }
      catch (Throwable paramSendMsg)
      {
        QLog.e("RemoteServiceProxy", 1, "", paramSendMsg);
        return;
      }
      return;
    }
    catch (RemoteException paramSendMsg)
    {
      QLog.e("RemoteServiceProxy", 1, "", paramSendMsg);
    }
  }
  
  protected void addMsgToSendQueue(SendMsg paramSendMsg)
  {
    this.sendMsgQueue.add(paramSendMsg);
  }
  
  protected RecvMsg createWaiteRespTimeout(SendMsg paramSendMsg, String paramString)
  {
    paramSendMsg = new RecvMsg(paramSendMsg.getRequestId(), paramSendMsg.getServiceCmd());
    paramSendMsg.setBusinessFail(1002, paramString);
    return paramSendMsg;
  }
  
  protected boolean isConnected()
  {
    return this.serviceHandler != null;
  }
  
  protected void onBaseServiceConnected()
  {
    RemoteServiceProxy.2 local2 = new RemoteServiceProxy.2(this);
    local2.setName("handleWaitSendProxyMsgThread");
    local2.start();
  }
  
  protected void sendFailedRespToApp(SendMsg paramSendMsg, RecvMsg paramRecvMsg)
  {
    try
    {
      if (paramSendMsg.getActionListener() != null)
      {
        paramSendMsg.getActionListener().onRecvFromMsg(paramRecvMsg);
        return;
      }
      if (this.mActionListener != null)
      {
        this.mActionListener.onRecvFromMsg(paramRecvMsg);
        return;
      }
    }
    catch (RemoteException paramSendMsg)
    {
      paramSendMsg.printStackTrace();
    }
  }
  
  /* Error */
  public void sendMsg(SendMsg paramSendMsg)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 33	cooperation/qzone/remote/RemoteServiceProxy:sendLock	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 156	cooperation/qzone/remote/RemoteServiceProxy:isConnected	()Z
    //   11: ifeq +11 -> 22
    //   14: aload_0
    //   15: aload_1
    //   16: invokevirtual 159	cooperation/qzone/remote/RemoteServiceProxy:sendMsgToService	(Lcooperation/qzone/remote/SendMsg;)V
    //   19: goto +12 -> 31
    //   22: aload_0
    //   23: aload_1
    //   24: invokevirtual 161	cooperation/qzone/remote/RemoteServiceProxy:addMsgToSendQueue	(Lcooperation/qzone/remote/SendMsg;)V
    //   27: aload_0
    //   28: invokevirtual 164	cooperation/qzone/remote/RemoteServiceProxy:startBaseServiceConn	()V
    //   31: aload_2
    //   32: monitorexit
    //   33: return
    //   34: astore_3
    //   35: aload_2
    //   36: monitorexit
    //   37: aload_3
    //   38: athrow
    //   39: astore_2
    //   40: aload_0
    //   41: getfield 74	cooperation/qzone/remote/RemoteServiceProxy:serviceHandler	Lcooperation/qzone/remote/IServiceHandler;
    //   44: ifnonnull +9 -> 53
    //   47: aload_0
    //   48: aload_1
    //   49: invokevirtual 161	cooperation/qzone/remote/RemoteServiceProxy:addMsgToSendQueue	(Lcooperation/qzone/remote/SendMsg;)V
    //   52: return
    //   53: aload_2
    //   54: invokevirtual 165	java/lang/Exception:printStackTrace	()V
    //   57: return
    //   58: aload_0
    //   59: aload_1
    //   60: invokevirtual 161	cooperation/qzone/remote/RemoteServiceProxy:addMsgToSendQueue	(Lcooperation/qzone/remote/SendMsg;)V
    //   63: return
    //   64: astore_2
    //   65: goto -7 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	RemoteServiceProxy
    //   0	68	1	paramSendMsg	SendMsg
    //   39	15	2	localException	Exception
    //   64	1	2	localDeadObjectException	android.os.DeadObjectException
    //   34	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   7	19	34	finally
    //   22	31	34	finally
    //   31	33	34	finally
    //   35	37	34	finally
    //   0	7	39	java/lang/Exception
    //   37	39	39	java/lang/Exception
    //   0	7	64	android/os/DeadObjectException
    //   37	39	64	android/os/DeadObjectException
  }
  
  protected void sendMsgToService(SendMsg paramSendMsg)
  {
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      ThreadManager.post(new RemoteServiceProxy.3(this, paramSendMsg), 10, null, false);
      return;
    }
    sendMsgToServiceInner(paramSendMsg);
  }
  
  public void setActionListener(IActionListener paramIActionListener)
  {
    this.mActionListener = paramIActionListener;
  }
  
  void startBaseService()
  {
    try
    {
      Intent localIntent = new Intent(BaseApplicationImpl.getApplication(), this.clazz);
      localIntent.putExtra("useSkinEngine", 1);
      IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(0);
      localPluginParams.b = QzonePluginProxyActivity.getQZonePluginName();
      localPluginParams.e = "QQ空间";
      localPluginParams.jdField_a_of_type_JavaLangString = this.mUin;
      localPluginParams.f = this.serviceName;
      localPluginParams.jdField_a_of_type_AndroidContentIntent = localIntent;
      localPluginParams.jdField_a_of_type_AndroidContentServiceConnection = this.conn;
      IPluginManager.c(BaseApplicationImpl.getApplication(), localPluginParams);
      if (QLog.isColorLevel())
      {
        QLog.d("RemoteServiceProxy", 2, " start service finish");
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void startBaseServiceConn()
  {
    long l = System.currentTimeMillis();
    if ((this.lastStartSerivceTime != -1L) && (l - this.lastStartSerivceTime <= 1000L))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("wait start ");
        localStringBuilder.append(this.serviceName);
        localStringBuilder.append(" service result, skiped...");
        QLog.d("RemoteServiceProxy", 2, localStringBuilder.toString());
      }
    }
    else
    {
      this.lastStartSerivceTime = l;
      startBaseService();
    }
  }
  
  public void unbindBaseService()
  {
    try
    {
      BaseApplication.getContext().unbindService(this.conn);
      this.serviceHandler = null;
      if (QLog.isColorLevel())
      {
        QLog.d("RemoteServiceProxy", 2, " unbindService service finished");
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.remote.RemoteServiceProxy
 * JD-Core Version:    0.7.0.1
 */