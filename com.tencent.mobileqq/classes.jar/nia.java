import android.os.AsyncTask;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.util.WeakReference;

public class nia
{
  abge jdField_a_of_type_Abge;
  WeakReference<AccountDetailActivity> jdField_a_of_type_MqqUtilWeakReference;
  nic jdField_a_of_type_Nic;
  
  public nia(QQAppInterface paramQQAppInterface, AccountDetailActivity paramAccountDetailActivity)
  {
    this.jdField_a_of_type_Abge = new abge(paramQQAppInterface);
    this.jdField_a_of_type_Abge.b = paramAccountDetailActivity.d;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramAccountDetailActivity);
    this.jdField_a_of_type_Nic = new nic(paramAccountDetailActivity);
  }
  
  public void a()
  {
    abgi localabgi = new abgi();
    localabgi.d = this.jdField_a_of_type_Abge.b;
    localabgi.a = null;
    if (this.jdField_a_of_type_MqqUtilWeakReference.get() == null) {
      return;
    }
    this.jdField_a_of_type_Abge.a((BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get(), localabgi);
    this.jdField_a_of_type_Abge.a(this.jdField_a_of_type_Nic);
    this.jdField_a_of_type_Abge.b((BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get());
    new nib(this, localabgi).execute(new Void[0]);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference.get() != null)
    {
      this.jdField_a_of_type_Abge.a(null);
      this.jdField_a_of_type_Abge.a((BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nia
 * JD-Core Version:    0.7.0.1
 */