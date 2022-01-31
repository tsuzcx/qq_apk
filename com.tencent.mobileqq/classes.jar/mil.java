import android.app.Activity;
import android.content.res.Resources;
import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.QavSharpnessSVIPHelper.1;
import com.tencent.qphone.base.util.QLog;

public final class mil
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bcqf jdField_a_of_type_Bcqf;
  private VideoController jdField_a_of_type_ComTencentAvVideoController;
  private Boolean jdField_a_of_type_JavaLangBoolean;
  private final Runnable jdField_a_of_type_JavaLangRunnable = new QavSharpnessSVIPHelper.1(this);
  private who jdField_a_of_type_Who;
  private boolean jdField_a_of_type_Boolean;
  
  public mil(VideoController paramVideoController, AVActivity paramAVActivity)
  {
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
    this.jdField_a_of_type_AndroidAppActivity = paramAVActivity;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  public void a() {}
  
  public void a(Activity paramActivity)
  {
    QLog.d("QavSharpnessSVIPHelper", 2, "launchQQPayFunction");
    long l = System.currentTimeMillis();
    if (this.jdField_a_of_type_Who == null) {
      this.jdField_a_of_type_Who = new who(paramActivity);
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
    }
    this.jdField_a_of_type_Who.a("doubleVideo", 5000L, new mim(this, paramActivity, l));
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_JavaLangBoolean == null)
    {
      this.jdField_a_of_type_JavaLangBoolean = new Boolean(false);
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.n());
      if (QLog.isColorLevel()) {
        QLog.w("QavSharpnessSVIPHelper", 1, "isSVIP:= " + this.jdField_a_of_type_JavaLangBoolean);
      }
    }
    return this.jdField_a_of_type_JavaLangBoolean.booleanValue();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.w("QavSharpnessSVIPHelper", 1, "promotionSVIPSuccess");
    }
    this.jdField_a_of_type_JavaLangBoolean = new Boolean(true);
  }
  
  public void b(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.w("QavSharpnessSVIPHelper", 1, "doRealLaunchQQPayFuntion");
    }
    if (this.jdField_a_of_type_Who != null)
    {
      this.jdField_a_of_type_Who.a();
      this.jdField_a_of_type_Who = null;
    }
    bbrk.a(this.jdField_a_of_type_AndroidAppActivity, "https://h5.vip.qq.com/proxy/domain/imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=17301507&aid=mvip.n.a.hdvcall&type=!svip&isAskFriendPay=0&isSend=0");
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavSharpnessSVIPHelper", 2, "showProgress mProgressShowing:" + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      try
      {
        if (this.jdField_a_of_type_Bcqf == null)
        {
          this.jdField_a_of_type_Bcqf = new bcqf(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298865));
          this.jdField_a_of_type_Bcqf.a(ajya.a(2131708952));
          this.jdField_a_of_type_Bcqf.c(false);
        }
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Bcqf.show();
        return;
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    QLog.d("QavSharpnessSVIPHelper", 2, "");
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavSharpnessSVIPHelper", 2, "hideProgress  mProgressShowing:" + this.jdField_a_of_type_Boolean);
    }
    try
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
      if ((this.jdField_a_of_type_Bcqf != null) && (this.jdField_a_of_type_Bcqf.isShowing())) {
        this.jdField_a_of_type_Bcqf.dismiss();
      }
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QavSharpnessSVIPHelper", 2, "hide init check progress:" + localException.getMessage());
      }
      localException.printStackTrace();
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_JavaLangBoolean = null;
    this.jdField_a_of_type_AndroidAppActivity = null;
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_a_of_type_Who != null)
    {
      this.jdField_a_of_type_Who.a();
      this.jdField_a_of_type_Who = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mil
 * JD-Core Version:    0.7.0.1
 */