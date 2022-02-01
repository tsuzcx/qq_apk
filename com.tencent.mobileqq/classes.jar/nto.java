import android.os.AsyncTask;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.util.WeakReference;

public class nto
{
  aehr jdField_a_of_type_Aehr;
  WeakReference<AccountDetailActivity> jdField_a_of_type_MqqUtilWeakReference;
  ntq jdField_a_of_type_Ntq;
  
  public nto(QQAppInterface paramQQAppInterface, AccountDetailActivity paramAccountDetailActivity)
  {
    this.jdField_a_of_type_Aehr = new aehr(paramQQAppInterface);
    this.jdField_a_of_type_Aehr.b = paramAccountDetailActivity.e;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramAccountDetailActivity);
    this.jdField_a_of_type_Ntq = new ntq(paramAccountDetailActivity);
  }
  
  public void a()
  {
    aehv localaehv = new aehv();
    localaehv.d = this.jdField_a_of_type_Aehr.b;
    localaehv.a = null;
    if (this.jdField_a_of_type_MqqUtilWeakReference.get() == null) {
      return;
    }
    this.jdField_a_of_type_Aehr.a((BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get(), localaehv);
    this.jdField_a_of_type_Aehr.a(this.jdField_a_of_type_Ntq);
    this.jdField_a_of_type_Aehr.b((BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get());
    new ntp(this, localaehv).execute(new Void[0]);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference.get() != null)
    {
      this.jdField_a_of_type_Aehr.a(null);
      this.jdField_a_of_type_Aehr.a((BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nto
 * JD-Core Version:    0.7.0.1
 */