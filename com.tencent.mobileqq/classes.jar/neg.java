import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.res.Resources;
import android.os.Handler;
import com.tencent.avgame.gameroom.video.AVGameLaunchWebHelper.1;
import com.tencent.qphone.base.util.QLog;

public class neg
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Application.ActivityLifecycleCallbacks jdField_a_of_type_AndroidAppApplication$ActivityLifecycleCallbacks = new neh(this);
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bjbs jdField_a_of_type_Bjbs;
  private final Runnable jdField_a_of_type_JavaLangRunnable = new AVGameLaunchWebHelper.1(this);
  private zyc jdField_a_of_type_Zyc;
  private boolean jdField_a_of_type_Boolean;
  
  public neg(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    b();
  }
  
  private void a(Runnable paramRunnable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVGameLaunchWebHelper", 2, "executeCallable");
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(paramRunnable);
    }
  }
  
  private void b()
  {
    ((Application)this.jdField_a_of_type_AndroidAppActivity.getApplicationContext()).registerActivityLifecycleCallbacks(this.jdField_a_of_type_AndroidAppApplication$ActivityLifecycleCallbacks);
  }
  
  private void c()
  {
    ((Application)this.jdField_a_of_type_AndroidAppActivity.getApplicationContext()).unregisterActivityLifecycleCallbacks(this.jdField_a_of_type_AndroidAppApplication$ActivityLifecycleCallbacks);
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVGameLaunchWebHelper", 2, "showProgress mProgressShowing:" + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      try
      {
        if (this.jdField_a_of_type_Bjbs == null)
        {
          this.jdField_a_of_type_Bjbs = new bjbs(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299011));
          this.jdField_a_of_type_Bjbs.a(anzj.a(2131707821));
          this.jdField_a_of_type_Bjbs.c(false);
        }
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Bjbs.show();
        return;
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    QLog.d("AVGameLaunchWebHelper", 2, "");
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVGameLaunchWebHelper", 2, "hideProgress  mProgressShowing:" + this.jdField_a_of_type_Boolean);
    }
    try
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
      if ((this.jdField_a_of_type_Bjbs != null) && (this.jdField_a_of_type_Bjbs.isShowing())) {
        this.jdField_a_of_type_Bjbs.dismiss();
      }
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AVGameLaunchWebHelper", 2, "hide init check progress:" + localException.getMessage());
      }
      localException.printStackTrace();
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVGameLaunchWebHelper", 2, "release");
    }
    e();
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_a_of_type_Zyc != null)
    {
      this.jdField_a_of_type_Zyc.a();
      this.jdField_a_of_type_Zyc = null;
    }
  }
  
  public void a(Activity paramActivity, Runnable paramRunnable)
  {
    QLog.d("AVGameLaunchWebHelper", 2, "preLoadToolProcAndExecuteCallable");
    if (mvd.a(this.jdField_a_of_type_AndroidAppActivity))
    {
      a(paramRunnable);
      return;
    }
    long l = System.currentTimeMillis();
    if (this.jdField_a_of_type_Zyc == null) {
      this.jdField_a_of_type_Zyc = new zyc(paramActivity);
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
    }
    this.jdField_a_of_type_Zyc.a("preLoadToolProc", 5000L, new nei(this, paramRunnable, l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     neg
 * JD-Core Version:    0.7.0.1
 */