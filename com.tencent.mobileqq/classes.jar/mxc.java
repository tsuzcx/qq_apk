import android.os.AsyncTask;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.util.WeakReference;

public class mxc
{
  aawl jdField_a_of_type_Aawl;
  WeakReference<AccountDetailActivity> jdField_a_of_type_MqqUtilWeakReference;
  mxe jdField_a_of_type_Mxe;
  
  public mxc(QQAppInterface paramQQAppInterface, AccountDetailActivity paramAccountDetailActivity)
  {
    this.jdField_a_of_type_Aawl = new aawl(paramQQAppInterface);
    this.jdField_a_of_type_Aawl.b = paramAccountDetailActivity.d;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramAccountDetailActivity);
    this.jdField_a_of_type_Mxe = new mxe(paramAccountDetailActivity);
  }
  
  public void a()
  {
    aawp localaawp = new aawp();
    localaawp.d = this.jdField_a_of_type_Aawl.b;
    localaawp.a = null;
    if (this.jdField_a_of_type_MqqUtilWeakReference.get() == null) {
      return;
    }
    this.jdField_a_of_type_Aawl.a((BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get(), localaawp);
    this.jdField_a_of_type_Aawl.a(this.jdField_a_of_type_Mxe);
    this.jdField_a_of_type_Aawl.b((BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get());
    new mxd(this, localaawp).execute(new Void[0]);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference.get() != null)
    {
      this.jdField_a_of_type_Aawl.a(null);
      this.jdField_a_of_type_Aawl.a((BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mxc
 * JD-Core Version:    0.7.0.1
 */