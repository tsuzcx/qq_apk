import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.concurrent.ExecutorService;

public abstract class qii
{
  public final Handler a;
  public final AppInterface a;
  public final EntityManager a;
  protected final ExecutorService a;
  public final qep a;
  protected final qxn a;
  
  public qii(qep paramqep, Handler paramHandler, AppInterface paramAppInterface, EntityManager paramEntityManager, qxn paramqxn, ExecutorService paramExecutorService)
  {
    this.jdField_a_of_type_Qep = paramqep;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramEntityManager;
    this.jdField_a_of_type_Qxn = paramqxn;
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = paramExecutorService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qii
 * JD-Core Version:    0.7.0.1
 */