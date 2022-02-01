import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

class myf
  implements Application.ActivityLifecycleCallbacks
{
  myf(mya parammya) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FloatWindowController", 2, "onActivityDestroyed: " + paramActivity.getClass().getName());
    }
  }
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FloatWindowController", 2, "onActivityResumed: " + paramActivity.getClass().getName() + " mHoldByPermission: " + this.a.b + " mIsFloatWindowShowing: " + mya.b(this.a) + " mIgnoreByOpenSdkForeGround: " + mya.c(this.a));
    }
    if ((this.a.b) && (!mya.b(this.a)))
    {
      ThreadManager.getUIHandlerV2().removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
      ThreadManager.getUIHandlerV2().postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 1000L);
      paramActivity.finish();
    }
    while (!mya.c(this.a)) {
      return;
    }
    mya.a(this.a, false);
    this.a.jdField_a_of_type_Boolean = true;
    this.a.a(true);
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FloatWindowController", 2, "onActivityStarted: " + paramActivity.getClass().getName());
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FloatWindowController", 2, "onActivityStopped: " + paramActivity.getClass().getName());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     myf
 * JD-Core Version:    0.7.0.1
 */