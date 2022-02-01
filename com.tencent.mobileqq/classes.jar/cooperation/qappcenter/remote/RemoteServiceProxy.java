package cooperation.qappcenter.remote;

import android.content.Intent;
import android.content.ServiceConnection;
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
    if ((this.jdField_a_of_type_Long != -1L) && (l - this.jdField_a_of_type_Long <= 1000L))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("wait start ");
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        localStringBuilder.append(" service result, skiped...");
        QLog.d("RemoteServiceProxy", 2, localStringBuilder.toString());
      }
    }
    else
    {
      this.jdField_a_of_type_Long = l;
      c();
    }
  }
  
  /* Error */
  public void b(SendMsg paramSendMsg)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 30	cooperation/qappcenter/remote/RemoteServiceProxy:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 182	cooperation/qappcenter/remote/RemoteServiceProxy:a	()Z
    //   11: ifeq +11 -> 22
    //   14: aload_0
    //   15: aload_1
    //   16: invokevirtual 183	cooperation/qappcenter/remote/RemoteServiceProxy:a	(Lcooperation/qappcenter/remote/SendMsg;)V
    //   19: goto +12 -> 31
    //   22: aload_0
    //   23: aload_1
    //   24: invokevirtual 185	cooperation/qappcenter/remote/RemoteServiceProxy:c	(Lcooperation/qappcenter/remote/SendMsg;)V
    //   27: aload_0
    //   28: invokevirtual 187	cooperation/qappcenter/remote/RemoteServiceProxy:b	()V
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
    //   41: getfield 121	cooperation/qappcenter/remote/RemoteServiceProxy:jdField_a_of_type_CooperationQappcenterRemoteIServiceHandler	Lcooperation/qappcenter/remote/IServiceHandler;
    //   44: ifnonnull +9 -> 53
    //   47: aload_0
    //   48: aload_1
    //   49: invokevirtual 185	cooperation/qappcenter/remote/RemoteServiceProxy:c	(Lcooperation/qappcenter/remote/SendMsg;)V
    //   52: return
    //   53: aload_2
    //   54: invokevirtual 188	java/lang/Exception:printStackTrace	()V
    //   57: return
    //   58: aload_0
    //   59: aload_1
    //   60: invokevirtual 185	cooperation/qappcenter/remote/RemoteServiceProxy:c	(Lcooperation/qappcenter/remote/SendMsg;)V
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
  
  void c()
  {
    try
    {
      Intent localIntent = new Intent(BaseApplicationImpl.getApplication(), QAppCenterPluginProxyService.class);
      IPluginManager.PluginParams localPluginParams = new IPluginManager.PluginParams(1);
      localPluginParams.b = "qappcenter_plugin.apk";
      localPluginParams.e = HardCodeUtil.a(2131713316);
      localPluginParams.jdField_a_of_type_JavaLangString = this.b;
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        localPluginParams.f = "com.tencent.plugin.qappcenter.remote.RemoteService";
      } else {
        localPluginParams.f = this.jdField_a_of_type_JavaLangString;
      }
      localPluginParams.jdField_a_of_type_AndroidContentIntent = localIntent;
      localPluginParams.jdField_a_of_type_AndroidContentServiceConnection = this.jdField_a_of_type_AndroidContentServiceConnection;
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
  
  protected void c(SendMsg paramSendMsg)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(paramSendMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qappcenter.remote.RemoteServiceProxy
 * JD-Core Version:    0.7.0.1
 */