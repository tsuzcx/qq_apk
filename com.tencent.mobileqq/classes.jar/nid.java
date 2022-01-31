import android.os.AsyncTask;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.util.WeakReference;

public class nid
{
  abgi jdField_a_of_type_Abgi;
  WeakReference<AccountDetailActivity> jdField_a_of_type_MqqUtilWeakReference;
  nif jdField_a_of_type_Nif;
  
  public nid(QQAppInterface paramQQAppInterface, AccountDetailActivity paramAccountDetailActivity)
  {
    this.jdField_a_of_type_Abgi = new abgi(paramQQAppInterface);
    this.jdField_a_of_type_Abgi.b = paramAccountDetailActivity.d;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramAccountDetailActivity);
    this.jdField_a_of_type_Nif = new nif(paramAccountDetailActivity);
  }
  
  public void a()
  {
    abgm localabgm = new abgm();
    localabgm.d = this.jdField_a_of_type_Abgi.b;
    localabgm.a = null;
    if (this.jdField_a_of_type_MqqUtilWeakReference.get() == null) {
      return;
    }
    this.jdField_a_of_type_Abgi.a((BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get(), localabgm);
    this.jdField_a_of_type_Abgi.a(this.jdField_a_of_type_Nif);
    this.jdField_a_of_type_Abgi.b((BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get());
    new nie(this, localabgm).execute(new Void[0]);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference.get() != null)
    {
      this.jdField_a_of_type_Abgi.a(null);
      this.jdField_a_of_type_Abgi.a((BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nid
 * JD-Core Version:    0.7.0.1
 */