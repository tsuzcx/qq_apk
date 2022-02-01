import android.os.AsyncTask;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.util.WeakReference;

public class nvj
{
  aeqv jdField_a_of_type_Aeqv;
  WeakReference<AccountDetailActivity> jdField_a_of_type_MqqUtilWeakReference;
  nvl jdField_a_of_type_Nvl;
  
  public nvj(QQAppInterface paramQQAppInterface, AccountDetailActivity paramAccountDetailActivity)
  {
    this.jdField_a_of_type_Aeqv = new aeqv(paramQQAppInterface);
    this.jdField_a_of_type_Aeqv.b = paramAccountDetailActivity.e;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramAccountDetailActivity);
    this.jdField_a_of_type_Nvl = new nvl(paramAccountDetailActivity);
  }
  
  public void a()
  {
    aeqz localaeqz = new aeqz();
    localaeqz.d = this.jdField_a_of_type_Aeqv.b;
    localaeqz.a = null;
    if (this.jdField_a_of_type_MqqUtilWeakReference.get() == null) {
      return;
    }
    this.jdField_a_of_type_Aeqv.a((BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get(), localaeqz);
    this.jdField_a_of_type_Aeqv.a(this.jdField_a_of_type_Nvl);
    this.jdField_a_of_type_Aeqv.b((BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get());
    new nvk(this, localaeqz).execute(new Void[0]);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference.get() != null)
    {
      this.jdField_a_of_type_Aeqv.a(null);
      this.jdField_a_of_type_Aeqv.a((BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nvj
 * JD-Core Version:    0.7.0.1
 */