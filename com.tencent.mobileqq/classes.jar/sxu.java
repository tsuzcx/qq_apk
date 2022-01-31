import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class sxu
  implements slx<tar, tcc>
{
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Queue<ssm> jdField_a_of_type_JavaUtilQueue;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AtomicBoolean b = new AtomicBoolean(false);
  
  public sxu(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    b();
  }
  
  private void a(tar paramtar, tcc paramtcc)
  {
    sgj localsgj = (sgj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(197);
    List localList = paramtcc.a();
    localsgj.a(paramtcc.a());
    if (paramtar.a() == 3)
    {
      paramtar = localList.iterator();
      while (paramtar.hasNext())
      {
        paramtcc = (ssm)paramtar.next();
        localsgj.b(paramtcc);
        localsgj.c(paramtcc);
        localsgj.d(paramtcc);
      }
    }
    localsgj.a(localList);
    localsgj.a(localList, true);
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilQueue = new ConcurrentLinkedQueue();
  }
  
  private void c()
  {
    Object localObject = (sgj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(197);
    if (!this.b.get()) {}
    for (;;)
    {
      ssm localssm = (ssm)this.jdField_a_of_type_JavaUtilQueue.poll();
      if (localssm == null)
      {
        localObject = new sxv(true);
        sgi.a().dispatch((Dispatcher.Dispatchable)localObject);
        return;
      }
      ((sgj)localObject).a(localssm);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public void a(@NonNull tar paramtar, @Nullable tcc paramtcc, @NonNull ErrorMessage paramErrorMessage)
  {
    if (a()) {}
    do
    {
      return;
      this.b.set(true);
      if ((paramtcc != null) && (!paramErrorMessage.isFail())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("RecentTabHaloBatchLoader", 2, "onEvent: failed. Message: exception: " + paramErrorMessage);
    return;
    a(paramtar, paramtcc);
    this.b.set(false);
    c();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sxu
 * JD-Core Version:    0.7.0.1
 */