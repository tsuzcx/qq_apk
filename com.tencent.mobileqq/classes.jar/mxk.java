import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.MobileQQ;

public class mxk
{
  private static Boolean jdField_a_of_type_JavaLangBoolean;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  private mxn jdField_a_of_type_Mxn;
  private myh jdField_a_of_type_Myh;
  private boolean jdField_a_of_type_Boolean;
  
  public mxk(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_Mxn = new mxn(this, null);
  }
  
  private void a(boolean paramBoolean)
  {
    jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(paramBoolean);
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.j();
    c();
  }
  
  private void c()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.video.q2v.avReceiveRealNameMsg");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().registerReceiver(this.jdField_a_of_type_Mxn, localIntentFilter);
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.i("WTogetherRealNameVideoProcessHelper", 2, "register");
    }
  }
  
  private void d()
  {
    try
    {
      QLog.d("WTogetherRealNameVideoProcessHelper", 1, "unRegister start ");
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().unregisterReceiver(this.jdField_a_of_type_Mxn);
        this.jdField_a_of_type_Boolean = false;
      }
      if (QLog.isColorLevel()) {
        QLog.i("WTogetherRealNameVideoProcessHelper", 2, "unRegister");
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("WTogetherRealNameVideoProcessHelper", 1, new Object[] { "unregisterReceiver error : ", localException.getMessage() });
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("WTogetherRealNameVideoProcessHelper", 2, "showRealNameDialog");
    }
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {}
    for (localObject = (Activity)((WeakReference)localObject).get(); localObject == null; localObject = null) {
      return;
    }
    localObject = bhdj.a((Context)localObject, 230, ((Activity)localObject).getString(2131690495), ((Activity)localObject).getString(2131690494), ((Activity)localObject).getString(2131698775), ((Activity)localObject).getString(2131698777), new mxl(this, (Activity)localObject), new mxm(this));
    ((QQCustomDialog)localObject).setCancelable(false);
    ((QQCustomDialog)localObject).show();
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WTogetherRealNameVideoProcessHelper", 2, "onActivityResult");
    }
    if (this.jdField_a_of_type_Myh != null) {
      this.jdField_a_of_type_Myh.a(jdField_a_of_type_JavaLangBoolean.booleanValue());
    }
  }
  
  public void a(Activity paramActivity)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
  }
  
  public void a(myh parammyh)
  {
    this.jdField_a_of_type_Myh = parammyh;
  }
  
  public boolean a()
  {
    if ((jdField_a_of_type_JavaLangBoolean != null) && (jdField_a_of_type_JavaLangBoolean.booleanValue() == true)) {
      return true;
    }
    jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.i());
    return jdField_a_of_type_JavaLangBoolean.booleanValue();
  }
  
  public void b(myh parammyh)
  {
    if (a())
    {
      parammyh.a(true);
      return;
    }
    a(parammyh);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mxk
 * JD-Core Version:    0.7.0.1
 */