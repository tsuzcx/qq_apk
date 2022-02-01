import android.os.AsyncTask;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.util.WeakReference;

public class ods
{
  aeaz jdField_a_of_type_Aeaz;
  WeakReference<AccountDetailActivity> jdField_a_of_type_MqqUtilWeakReference;
  odu jdField_a_of_type_Odu;
  
  public ods(QQAppInterface paramQQAppInterface, AccountDetailActivity paramAccountDetailActivity)
  {
    this.jdField_a_of_type_Aeaz = new aeaz(paramQQAppInterface);
    this.jdField_a_of_type_Aeaz.b = paramAccountDetailActivity.e;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramAccountDetailActivity);
    this.jdField_a_of_type_Odu = new odu(paramAccountDetailActivity);
  }
  
  public void a()
  {
    aebd localaebd = new aebd();
    localaebd.d = this.jdField_a_of_type_Aeaz.b;
    localaebd.a = null;
    if (this.jdField_a_of_type_MqqUtilWeakReference.get() == null) {
      return;
    }
    this.jdField_a_of_type_Aeaz.a((BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get(), localaebd);
    this.jdField_a_of_type_Aeaz.a(this.jdField_a_of_type_Odu);
    this.jdField_a_of_type_Aeaz.b((BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get());
    new odt(this, localaebd).execute(new Void[0]);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference.get() != null)
    {
      this.jdField_a_of_type_Aeaz.a(null);
      this.jdField_a_of_type_Aeaz.a((BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ods
 * JD-Core Version:    0.7.0.1
 */