package cooperation.qzone.remote;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.RemoteException;
import biqn;
import biqw;
import bjqs;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzonePluginProxyActivity;
import java.util.concurrent.ConcurrentLinkedQueue;

public class RemoteServiceProxy
{
  private static final String tag = "RemoteServiceProxy";
  private Class<? extends Service> clazz;
  protected ServiceConnection conn = new bjqs(this);
  protected volatile long lastStartSerivceTime = -1L;
  private IActionListener mActionListener;
  private String mUin;
  protected Object sendLock = new Object();
  protected ConcurrentLinkedQueue<SendMsg> sendMsgQueue = new ConcurrentLinkedQueue();
  public volatile IServiceHandler serviceHandler;
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
  
  public void onBaseServiceConnected()
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
  
  public void sendMsg(SendMsg paramSendMsg)
  {
    try
    {
      synchronized (this.sendLock)
      {
        if (isConnected())
        {
          sendMsgToService(paramSendMsg);
          return;
        }
        addMsgToSendQueue(paramSendMsg);
        startBaseServiceConn();
      }
      return;
    }
    catch (DeadObjectException localDeadObjectException)
    {
      addMsgToSendQueue(paramSendMsg);
      return;
    }
    catch (Exception localException)
    {
      if (this.serviceHandler == null)
      {
        addMsgToSendQueue(paramSendMsg);
        return;
      }
      localException.printStackTrace();
    }
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
      biqw localbiqw = new biqw(0);
      localbiqw.b = QzonePluginProxyActivity.a();
      localbiqw.d = "QQ空间";
      localbiqw.jdField_a_of_type_JavaLangString = this.mUin;
      localbiqw.e = this.serviceName;
      localbiqw.jdField_a_of_type_AndroidContentIntent = localIntent;
      localbiqw.jdField_a_of_type_AndroidContentServiceConnection = this.conn;
      biqn.c(BaseApplicationImpl.getApplication(), localbiqw);
      if (QLog.isColorLevel()) {
        QLog.d("RemoteServiceProxy", 2, " start service finish");
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void startBaseServiceConn()
  {
    long l = System.currentTimeMillis();
    if ((this.lastStartSerivceTime == -1L) || (l - this.lastStartSerivceTime > 1000L))
    {
      this.lastStartSerivceTime = l;
      startBaseService();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("RemoteServiceProxy", 2, "wait start " + this.serviceName + " service result, skiped...");
  }
  
  public void unbindBaseService()
  {
    try
    {
      BaseApplication.getContext().unbindService(this.conn);
      this.serviceHandler = null;
      if (QLog.isColorLevel()) {
        QLog.d("RemoteServiceProxy", 2, " unbindService service finished");
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.remote.RemoteServiceProxy
 * JD-Core Version:    0.7.0.1
 */