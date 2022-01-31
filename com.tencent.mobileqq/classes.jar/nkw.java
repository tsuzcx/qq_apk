import android.os.AsyncTask;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.util.WeakReference;

public class nkw
{
  acxe jdField_a_of_type_Acxe;
  WeakReference<AccountDetailActivity> jdField_a_of_type_MqqUtilWeakReference;
  nky jdField_a_of_type_Nky;
  
  public nkw(QQAppInterface paramQQAppInterface, AccountDetailActivity paramAccountDetailActivity)
  {
    this.jdField_a_of_type_Acxe = new acxe(paramQQAppInterface);
    this.jdField_a_of_type_Acxe.b = paramAccountDetailActivity.d;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramAccountDetailActivity);
    this.jdField_a_of_type_Nky = new nky(paramAccountDetailActivity);
  }
  
  public void a()
  {
    acxi localacxi = new acxi();
    localacxi.d = this.jdField_a_of_type_Acxe.b;
    localacxi.a = null;
    if (this.jdField_a_of_type_MqqUtilWeakReference.get() == null) {
      return;
    }
    this.jdField_a_of_type_Acxe.a((BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get(), localacxi);
    this.jdField_a_of_type_Acxe.a(this.jdField_a_of_type_Nky);
    this.jdField_a_of_type_Acxe.b((BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get());
    new nkx(this, localacxi).execute(new Void[0]);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference.get() != null)
    {
      this.jdField_a_of_type_Acxe.a(null);
      this.jdField_a_of_type_Acxe.a((BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nkw
 * JD-Core Version:    0.7.0.1
 */