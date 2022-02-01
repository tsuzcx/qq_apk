import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class qws
  implements Application.ActivityLifecycleCallbacks
{
  qws(qwn paramqwn, Activity paramActivity) {}
  
  private void a(Activity paramActivity, boolean paramBoolean)
  {
    if (paramActivity != this.jdField_a_of_type_AndroidAppActivity) {}
    do
    {
      return;
      QLog.d("RvPolymericContainer", 1, "visibility changed, visible :  " + paramBoolean);
      if (paramBoolean)
      {
        qwn.c(this.jdField_a_of_type_Qwn);
        return;
      }
    } while (qwn.a(this.jdField_a_of_type_Qwn) == null);
    qwn.a(this.jdField_a_of_type_Qwn).b();
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    if ((paramActivity == this.jdField_a_of_type_AndroidAppActivity) && (BaseApplication.getContext() != null)) {
      BaseApplication.getContext().unregisterActivityLifecycleCallbacks(this);
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    a(paramActivity, false);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    a(paramActivity, true);
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    a(paramActivity, true);
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    a(paramActivity, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qws
 * JD-Core Version:    0.7.0.1
 */