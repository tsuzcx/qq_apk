import com.tencent.biz.webviewplugin.OfflineWebResManager;
import com.tencent.mobileqq.data.OfflineWebRes;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class pcd
  implements Runnable
{
  public pcd(OfflineWebResManager paramOfflineWebResManager, int paramInt) {}
  
  public void run()
  {
    try
    {
      Thread.sleep(this.jdField_a_of_type_Int * 1000);
      if (!OfflineWebResManager.jdField_a_of_type_Boolean)
      {
        OfflineWebResManager.c();
        if (!OfflineWebResManager.b)
        {
          this.jdField_a_of_type_ComTencentBizWebviewpluginOfflineWebResManager.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(OfflineWebRes.class.getSimpleName());
          return;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
      OfflineWebResManager.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentBizWebviewpluginOfflineWebResManager.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.d(OfflineWebRes.class.getSimpleName());
      Object localObject;
      if (!OfflineWebResManager.jdField_a_of_type_Boolean)
      {
        localObject = new OfflineWebRes();
        ((OfflineWebRes)localObject).fileName = "test";
        ((OfflineWebRes)localObject).hashName = "test";
        ((OfflineWebRes)localObject).md5 = "test_md5";
        this.jdField_a_of_type_ComTencentBizWebviewpluginOfflineWebResManager.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a((Entity)localObject);
      }
      while (!OfflineWebResManager.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty())
      {
        localObject = (String)OfflineWebResManager.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
        this.jdField_a_of_type_ComTencentBizWebviewpluginOfflineWebResManager.b((String)localObject);
      }
      this.jdField_a_of_type_ComTencentBizWebviewpluginOfflineWebResManager.a();
      this.jdField_a_of_type_ComTencentBizWebviewpluginOfflineWebResManager.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pcd
 * JD-Core Version:    0.7.0.1
 */