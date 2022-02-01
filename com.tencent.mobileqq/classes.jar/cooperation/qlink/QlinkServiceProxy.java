package cooperation.qlink;

import android.content.ServiceConnection;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.app.AppRuntime;

public class QlinkServiceProxy
{
  private volatile long jdField_a_of_type_Long = -1L;
  private ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = new QlinkServiceProxy.1(this);
  private volatile IQlinkService jdField_a_of_type_CooperationQlinkIQlinkService;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ConcurrentLinkedQueue<SendMsg> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private boolean jdField_a_of_type_Boolean = false;
  
  public QlinkServiceProxy(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_CooperationQlinkIQlinkService != null;
  }
  
  private void b()
  {
    QlinkServiceProxy.2 local2 = new QlinkServiceProxy.2(this);
    local2.setName("handleWaitSendProxyMsgThread");
    local2.start();
  }
  
  private void b(SendMsg paramSendMsg)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(paramSendMsg);
  }
  
  private void c(SendMsg paramSendMsg)
  {
    this.jdField_a_of_type_CooperationQlinkIQlinkService.a(paramSendMsg);
  }
  
  public void a()
  {
    long l = System.currentTimeMillis();
    if ((this.jdField_a_of_type_Long != -1L) && (l - this.jdField_a_of_type_Long <= 10000L))
    {
      QLog.d("QlinkServiceProxy", 1, "wait start qlink service result, skiped...");
      return;
    }
    this.jdField_a_of_type_Long = l;
    QlinkPluginProxyService.a(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_AndroidContentServiceConnection);
  }
  
  /* Error */
  public void a(SendMsg paramSendMsg)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 20	cooperation/qlink/QlinkServiceProxy:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_0
    //   8: invokespecial 108	cooperation/qlink/QlinkServiceProxy:a	()Z
    //   11: ifeq +11 -> 22
    //   14: aload_0
    //   15: aload_1
    //   16: invokespecial 55	cooperation/qlink/QlinkServiceProxy:c	(Lcooperation/qlink/SendMsg;)V
    //   19: goto +32 -> 51
    //   22: aload_0
    //   23: getfield 31	cooperation/qlink/QlinkServiceProxy:jdField_a_of_type_Boolean	Z
    //   26: ifeq +11 -> 37
    //   29: aload_0
    //   30: aload_1
    //   31: invokespecial 110	cooperation/qlink/QlinkServiceProxy:b	(Lcooperation/qlink/SendMsg;)V
    //   34: goto +17 -> 51
    //   37: aload_0
    //   38: iconst_1
    //   39: putfield 31	cooperation/qlink/QlinkServiceProxy:jdField_a_of_type_Boolean	Z
    //   42: aload_0
    //   43: aload_1
    //   44: invokespecial 110	cooperation/qlink/QlinkServiceProxy:b	(Lcooperation/qlink/SendMsg;)V
    //   47: aload_0
    //   48: invokevirtual 112	cooperation/qlink/QlinkServiceProxy:a	()V
    //   51: aload_2
    //   52: monitorexit
    //   53: return
    //   54: astore_3
    //   55: aload_2
    //   56: monitorexit
    //   57: aload_3
    //   58: athrow
    //   59: astore_2
    //   60: aload_0
    //   61: getfield 45	cooperation/qlink/QlinkServiceProxy:jdField_a_of_type_CooperationQlinkIQlinkService	Lcooperation/qlink/IQlinkService;
    //   64: ifnonnull +9 -> 73
    //   67: aload_0
    //   68: aload_1
    //   69: invokespecial 110	cooperation/qlink/QlinkServiceProxy:b	(Lcooperation/qlink/SendMsg;)V
    //   72: return
    //   73: aload_2
    //   74: invokevirtual 115	java/lang/Exception:printStackTrace	()V
    //   77: return
    //   78: aload_0
    //   79: aload_1
    //   80: invokespecial 110	cooperation/qlink/QlinkServiceProxy:b	(Lcooperation/qlink/SendMsg;)V
    //   83: return
    //   84: astore_2
    //   85: goto -7 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	QlinkServiceProxy
    //   0	88	1	paramSendMsg	SendMsg
    //   59	15	2	localException	java.lang.Exception
    //   84	1	2	localDeadObjectException	android.os.DeadObjectException
    //   54	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   7	19	54	finally
    //   22	34	54	finally
    //   37	51	54	finally
    //   51	53	54	finally
    //   55	57	54	finally
    //   0	7	59	java/lang/Exception
    //   57	59	59	java/lang/Exception
    //   0	7	84	android/os/DeadObjectException
    //   57	59	84	android/os/DeadObjectException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qlink.QlinkServiceProxy
 * JD-Core Version:    0.7.0.1
 */