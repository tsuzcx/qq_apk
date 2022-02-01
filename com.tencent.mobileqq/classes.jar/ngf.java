import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPCOnGetConnectionListener;
import eipc.EIPClientConnectListener;
import java.util.concurrent.atomic.AtomicInteger;

class ngf
  implements EIPCOnGetConnectionListener, EIPClientConnectListener
{
  AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  
  private ngf(ngd paramngd) {}
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2;
  }
  
  public void connectFailed()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(3);
    QLog.i("AVGameClientQIPCModule", 1, "connectFailed");
  }
  
  public void connectSuccess(EIPCConnection paramEIPCConnection)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
    QLog.i("AVGameClientQIPCModule", 1, "connectSuccess, server[" + paramEIPCConnection.procName + "]");
  }
  
  public void onConnectBind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection == null) {}
    do
    {
      return;
      QLog.i("AVGameClientQIPCModule", 1, "onConnectBind, [" + paramEIPCConnection.procName + "]");
    } while (!TextUtils.equals("com.tencent.mobileqq", paramEIPCConnection.procName));
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
  }
  
  public void onConnectUnbind(EIPCConnection paramEIPCConnection)
  {
    if (paramEIPCConnection == null) {}
    do
    {
      return;
      QLog.i("AVGameClientQIPCModule", 1, "onConnectUnbind, [" + paramEIPCConnection.procName + "]");
    } while (!TextUtils.equals("com.tencent.mobileqq", paramEIPCConnection.procName));
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ngf
 * JD-Core Version:    0.7.0.1
 */