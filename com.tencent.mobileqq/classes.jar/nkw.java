import android.os.AsyncTask;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.util.WeakReference;

public class nkw
{
  adbt jdField_a_of_type_Adbt;
  WeakReference<AccountDetailActivity> jdField_a_of_type_MqqUtilWeakReference;
  nky jdField_a_of_type_Nky;
  
  public nkw(QQAppInterface paramQQAppInterface, AccountDetailActivity paramAccountDetailActivity)
  {
    this.jdField_a_of_type_Adbt = new adbt(paramQQAppInterface);
    this.jdField_a_of_type_Adbt.b = paramAccountDetailActivity.d;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramAccountDetailActivity);
    this.jdField_a_of_type_Nky = new nky(paramAccountDetailActivity);
  }
  
  public void a()
  {
    adbx localadbx = new adbx();
    localadbx.d = this.jdField_a_of_type_Adbt.b;
    localadbx.a = null;
    if (this.jdField_a_of_type_MqqUtilWeakReference.get() == null) {
      return;
    }
    this.jdField_a_of_type_Adbt.a((BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get(), localadbx);
    this.jdField_a_of_type_Adbt.a(this.jdField_a_of_type_Nky);
    this.jdField_a_of_type_Adbt.b((BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get());
    new nkx(this, localadbx).execute(new Void[0]);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference.get() != null)
    {
      this.jdField_a_of_type_Adbt.a(null);
      this.jdField_a_of_type_Adbt.a((BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nkw
 * JD-Core Version:    0.7.0.1
 */