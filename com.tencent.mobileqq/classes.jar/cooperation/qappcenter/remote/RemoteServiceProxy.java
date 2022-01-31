package cooperation.qappcenter.remote;

import alws;
import alwt;
import alwu;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qappcenter.QAppCenterPluginProxyService;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class RemoteServiceProxy
{
  protected static ConcurrentHashMap a;
  protected volatile long a;
  protected ServiceConnection a;
  private IActionListener jdField_a_of_type_CooperationQappcenterRemoteIActionListener;
  public volatile IServiceHandler a;
  protected Object a;
  private String jdField_a_of_type_JavaLangString;
  public ConcurrentLinkedQueue a;
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
    this.jdField_a_of_type_AndroidContentServiceConnection = new alws(this);
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
  
  public RecvMsg a(SendMsg paramSendMsg, String paramString)
  {
    paramSendMsg = new RecvMsg(paramSendMsg.a(), paramSendMsg.a());
    paramSendMsg.a(1002, paramString);
    return paramSendMsg;
  }
  
  public void a()
  {
    alwt localalwt = new alwt(this);
    localalwt.setName("handleWaitSendProxyMsgThread");
    localalwt.start();
  }
  
  public void a(SendMsg paramSendMsg)
  {
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      ThreadManager.post(new alwu(this, paramSendMsg), 10, null, false);
      return;
    }
    this.jdField_a_of_type_CooperationQappcenterRemoteIServiceHandler.a(paramSendMsg);
  }
  
  public void a(SendMsg paramSendMsg, RecvMsg paramRecvMsg)
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
      localPluginParams.d = "应用宝";
      localPluginParams.jdField_a_of_type_JavaLangString = this.b;
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
      for (localPluginParams.e = "com.tencent.plugin.qappcenter.remote.RemoteService";; localPluginParams.e = this.jdField_a_of_type_JavaLangString)
      {
        localPluginParams.jdField_a_of_type_AndroidContentIntent = localIntent;
        localPluginParams.jdField_a_of_type_AndroidContentServiceConnection = this.jdField_a_of_type_AndroidContentServiceConnection;
        IPluginManager.b(BaseApplicationImpl.getApplication(), localPluginParams);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qappcenter.remote.RemoteServiceProxy
 * JD-Core Version:    0.7.0.1
 */