package cooperation.qzone.remote;

import android.content.Intent;
import android.content.ServiceConnection;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.RemoteException;
import anfv;
import anfw;
import anfx;
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
  private Class clazz;
  protected ServiceConnection conn = new anfv(this);
  protected volatile long lastStartSerivceTime = -1L;
  private IActionListener mActionListener;
  private String mUin;
  protected Object sendLock = new Object();
  public ConcurrentLinkedQueue sendMsgQueue = new ConcurrentLinkedQueue();
  public volatile IServiceHandler serviceHandler;
  private String serviceName;
  
  public RemoteServiceProxy(String paramString1, Class paramClass, String paramString2)
  {
    this.serviceName = paramString1;
    this.clazz = paramClass;
    this.mUin = paramString2;
  }
  
  protected void addMsgToSendQueue(SendMsg paramSendMsg)
  {
    this.sendMsgQueue.add(paramSendMsg);
  }
  
  public RecvMsg createWaiteRespTimeout(SendMsg paramSendMsg, String paramString)
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
    anfw localanfw = new anfw(this);
    localanfw.setName("handleWaitSendProxyMsgThread");
    localanfw.start();
  }
  
  public void sendFailedRespToApp(SendMsg paramSendMsg, RecvMsg paramRecvMsg)
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
  
  public void sendMsgToService(SendMsg paramSendMsg)
  {
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      ThreadManager.post(new anfx(this, paramSendMsg), 10, null, false);
      return;
    }
    this.serviceHandler.sendMsg(paramSendMsg);
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
      localPluginParams.b = QzonePluginProxyActivity.a();
      localPluginParams.d = "QQ空间";
      localPluginParams.jdField_a_of_type_JavaLangString = this.mUin;
      localPluginParams.e = this.serviceName;
      localPluginParams.jdField_a_of_type_AndroidContentIntent = localIntent;
      localPluginParams.jdField_a_of_type_AndroidContentServiceConnection = this.conn;
      IPluginManager.b(BaseApplicationImpl.getApplication(), localPluginParams);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.remote.RemoteServiceProxy
 * JD-Core Version:    0.7.0.1
 */