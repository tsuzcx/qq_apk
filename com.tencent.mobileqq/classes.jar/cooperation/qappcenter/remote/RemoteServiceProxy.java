package cooperation.qappcenter.remote;

import android.content.Intent;
import android.content.ServiceConnection;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qappcenter.QAppCenterPluginProxyService;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class RemoteServiceProxy
{
  protected static ConcurrentHashMap<String, RemoteServiceProxy> a;
  protected volatile long a;
  protected ServiceConnection a;
  private IActionListener jdField_a_of_type_CooperationQappcenterRemoteIActionListener;
  protected volatile IServiceHandler a;
  protected Object a;
  private String jdField_a_of_type_JavaLangString;
  protected ConcurrentLinkedQueue<SendMsg> a;
  private String b;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public RemoteServiceProxy(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_AndroidContentServiceConnection = new RemoteServiceProxy.1(this);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  public static RemoteServiceProxy a(String paramString)
  {
    try
    {
      if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString) == null) {
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, new RemoteServiceProxy(null, paramString));
      }
      paramString = (RemoteServiceProxy)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      return paramString;
    }
    finally {}
  }
  
  protected RecvMsg a(SendMsg paramSendMsg, String paramString)
  {
    paramSendMsg = new RecvMsg(paramSendMsg.a(), paramSendMsg.a());
    paramSendMsg.a(1002, paramString);
    return paramSendMsg;
  }
  
  protected void a()
  {
    RemoteServiceProxy.2 local2 = new RemoteServiceProxy.2(this);
    local2.setName("handleWaitSendProxyMsgThread");
    local2.start();
  }
  
  protected void a(SendMsg paramSendMsg)
  {
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      ThreadManager.post(new RemoteServiceProxy.3(this, paramSendMsg), 10, null, false);
      return;
    }
    this.jdField_a_of_type_CooperationQappcenterRemoteIServiceHandler.a(paramSendMsg);
  }
  
  protected void a(SendMsg paramSendMsg, RecvMsg paramRecvMsg)
  {
    try
    {
      if (paramSendMsg.a() != null)
      {
        paramSendMsg.a().a(paramRecvMsg);
        return;
      }
      if (this.jdField_a_of_type_CooperationQappcenterRemoteIActionListener != null)
      {
        this.jdField_a_of_type_CooperationQappcenterRemoteIActionListener.a(paramRecvMsg);
        return;
      }
    }
    catch (RemoteException paramSendMsg)
    {
      paramSendMsg.printStackTrace();
    }
  }
  
  protected boolean a()
  {
    return this.jdField_a_of_type_CooperationQappcenterRemoteIServiceHandler != null;
  }
  
  public void b()
  {
    long l = System.currentTimeMillis();
    if ((this.jdField_a_of_type_Long == -1L) || (l - this.jdField_a_of_type_Long > 1000L))
    {
      this.jdField_a_of_type_Long = l;
      c();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("RemoteServiceProxy", 2, "wait start " + this.jdField_a_of_type_JavaLangString + " service result, skiped...");
  }
  
  public void b(SendMsg paramSendMsg)
  {
    try
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (a())
        {
          a(paramSendMsg);
          return;
        }
        c(paramSendMsg);
        b();
      }
      return;
    }
    catch (DeadObjectException localDeadObjectException)
    {
      c(paramSendMsg);
      return;
    }
    catch (Exception localException)
    {
      if (this.jdField_a_of_type_CooperationQappcenterRemoteIServiceHandler == null)
      {
        c(paramSendMsg);
        return;
      }
      localException.printStackTrace();
    }
  }
  
  void c()
  {
    try
    {
      Intent localIntent = new Intent(BaseApplicationImpl.getApplication(), QAppCenterPluginProxyService.class);
      IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(1);
      localPluginParams.b = "qappcenter_plugin.apk";
      localPluginParams.e = HardCodeUtil.a(2131713348);
      localPluginParams.jdField_a_of_type_JavaLangString = this.b;
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
      for (localPluginParams.f = "com.tencent.plugin.qappcenter.remote.RemoteService";; localPluginParams.f = this.jdField_a_of_type_JavaLangString)
      {
        localPluginParams.jdField_a_of_type_AndroidContentIntent = localIntent;
        localPluginParams.jdField_a_of_type_AndroidContentServiceConnection = this.jdField_a_of_type_AndroidContentServiceConnection;
        IPluginManager.c(BaseApplicationImpl.getApplication(), localPluginParams);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("RemoteServiceProxy", 2, " start service finish");
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void c(SendMsg paramSendMsg)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(paramSendMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qappcenter.remote.RemoteServiceProxy
 * JD-Core Version:    0.7.0.1
 */