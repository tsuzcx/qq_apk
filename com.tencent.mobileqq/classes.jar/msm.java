import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.redbag.OtherBtnController.2;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class msm
  extends mta
{
  int jdField_a_of_type_Int = 2130841652;
  Runnable jdField_a_of_type_JavaLangRunnable = null;
  WeakReference<AVActivity> jdField_a_of_type_JavaLangRefWeakReference = null;
  public meu a;
  
  msm(mrt parammrt)
  {
    super(parammrt);
    this.jdField_a_of_type_Meu = null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
  }
  
  public void a(boolean paramBoolean)
  {
    AVActivity localAVActivity = a();
    QLog.w(this.i, 1, "setBtnsStyle, lightStyle[" + paramBoolean + "], avActivity[" + localAVActivity + "]");
    if (localAVActivity == null) {}
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {}
    for (AVActivity localAVActivity = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(); localAVActivity == null; localAVActivity = null) {
      return false;
    }
    if (localAVActivity == a()) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  void b()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {}
    boolean bool;
    do
    {
      return;
      if (this.jdField_a_of_type_Meu == null) {
        this.jdField_a_of_type_Meu = new msn(this);
      }
      if (this.jdField_a_of_type_JavaLangRunnable != null)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        this.jdField_a_of_type_JavaLangRunnable = null;
      }
      bool = a();
      QLog.w(this.i, 1, "hook, mHook[" + bool + "]");
      if (!bool) {
        this.jdField_a_of_type_Int = 2130841652;
      }
      a(false);
    } while (bool);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(a());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Meu);
  }
  
  void c()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      this.jdField_a_of_type_JavaLangRunnable = new OtherBtnController.2(this);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(this.jdField_a_of_type_JavaLangRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     msm
 * JD-Core Version:    0.7.0.1
 */