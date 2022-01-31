package cooperation.qlink;

import alxn;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

public class QlinkServiceManager
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private QlinkServiceProxy jdField_a_of_type_CooperationQlinkQlinkServiceProxy;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  
  public QlinkServiceManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
    this.jdField_a_of_type_CooperationQlinkQlinkServiceProxy = new QlinkServiceProxy(paramQQAppInterface);
  }
  
  private int a(String paramString, Bundle paramBundle, Handler paramHandler, long paramLong)
  {
    paramHandler = new SendMsg(paramString);
    paramString = paramBundle;
    if (paramBundle == null) {
      paramString = new Bundle();
    }
    if ((paramString != null) && (paramString.size() > 0)) {
      paramHandler.a.putAll(paramString);
    }
    int i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
    paramHandler.a(i);
    if (paramLong > 0L) {
      paramHandler.a(paramLong);
    }
    try
    {
      this.jdField_a_of_type_CooperationQlinkQlinkServiceProxy.a(paramHandler);
      return i;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      throw new RuntimeException("sendMsg is fail", paramString);
    }
  }
  
  public int a(String paramString, Bundle paramBundle)
  {
    try
    {
      int i = a(paramString, paramBundle, null, 0L);
      return i;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  public void a()
  {
    PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
    if (localPluginCommunicationHandler == null)
    {
      QLog.e("QlinkServiceManager", 1, "[QLINK] QQ - PluginCommunicationHandler.getInstance failed");
      return;
    }
    localPluginCommunicationHandler.register(new alxn(this, "qlink.notify"));
  }
  
  public void a(long paramLong) {}
  
  public boolean a(long paramLong1, int paramInt, long paramLong2, long paramLong3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return true;
  }
  
  public boolean a(byte[] paramArrayOfByte)
  {
    return true;
  }
  
  public void b(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     cooperation.qlink.QlinkServiceManager
 * JD-Core Version:    0.7.0.1
 */