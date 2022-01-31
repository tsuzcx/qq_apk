import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.concurrent.atomic.AtomicBoolean;

public class sxw
  implements IEventReceiver
{
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private sxx jdField_a_of_type_Sxx;
  private sxy jdField_a_of_type_Sxy;
  private sxz jdField_a_of_type_Sxz;
  
  public sxw(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_Sxy = new sxy(this);
    this.jdField_a_of_type_Sxz = new sxz(this);
    sgi.a().registerSubscriber(this.jdField_a_of_type_Sxy);
    sgi.a().registerSubscriber(this.jdField_a_of_type_Sxz);
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecentTabHaloPresenter", 2, "invalidateHalo: invoked.  mCallback: " + this.jdField_a_of_type_Sxx);
    }
    if (this.jdField_a_of_type_Sxx != null) {
      this.jdField_a_of_type_Sxx.a();
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecentTabHaloPresenter", 2, "destroy: invoked. ");
    }
    sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Sxy);
    sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Sxz);
    this.jdField_a_of_type_Sxx = null;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public void a(sxx paramsxx)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecentTabHaloPresenter", 2, "setCallback: invoked. Message: callback: " + paramsxx);
    }
    this.jdField_a_of_type_Sxx = paramsxx;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sxw
 * JD-Core Version:    0.7.0.1
 */