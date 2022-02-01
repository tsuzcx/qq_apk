import android.os.AsyncTask;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.util.WeakReference;

public class nws
{
  adjt jdField_a_of_type_Adjt;
  WeakReference<AccountDetailActivity> jdField_a_of_type_MqqUtilWeakReference;
  nwu jdField_a_of_type_Nwu;
  
  public nws(QQAppInterface paramQQAppInterface, AccountDetailActivity paramAccountDetailActivity)
  {
    this.jdField_a_of_type_Adjt = new adjt(paramQQAppInterface);
    this.jdField_a_of_type_Adjt.b = paramAccountDetailActivity.e;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramAccountDetailActivity);
    this.jdField_a_of_type_Nwu = new nwu(paramAccountDetailActivity);
  }
  
  public void a()
  {
    adjx localadjx = new adjx();
    localadjx.d = this.jdField_a_of_type_Adjt.b;
    localadjx.a = null;
    if (this.jdField_a_of_type_MqqUtilWeakReference.get() == null) {
      return;
    }
    this.jdField_a_of_type_Adjt.a((BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get(), localadjx);
    this.jdField_a_of_type_Adjt.a(this.jdField_a_of_type_Nwu);
    this.jdField_a_of_type_Adjt.b((BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get());
    new nwt(this, localadjx).execute(new Void[0]);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference.get() != null)
    {
      this.jdField_a_of_type_Adjt.a(null);
      this.jdField_a_of_type_Adjt.a((BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nws
 * JD-Core Version:    0.7.0.1
 */