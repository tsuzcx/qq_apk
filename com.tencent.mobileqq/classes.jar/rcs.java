import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

class rcs
  implements Application.ActivityLifecycleCallbacks
{
  private rcs(rcp paramrcp) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    if ((!rcp.b(this.a)) && ((paramActivity instanceof VideoFeedsPlayActivity))) {
      this.a.f();
    }
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    if (((paramActivity instanceof SplashActivity)) || ((paramActivity instanceof ReadInJoyNewFeedsActivity)))
    {
      this.a.f();
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsFloatWindowManager", 2, "onDestroyFloatingWindow");
      }
    }
  }
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsFloatWindowManager", 2, "onActivityResumed: ");
    }
    if (((rcp.a(this.a, paramActivity)) && (rcp.c(this.a))) || (rcp.b(this.a, paramActivity)) || (rcp.c(this.a, paramActivity)))
    {
      this.a.d();
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsFloatWindowManager", 2, "onShowFloatingWindow");
      }
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsFloatWindowManager", 2, "onActivityStopped: ");
    }
    if ((rcp.a(this.a, paramActivity)) || (rcp.b(this.a, paramActivity)) || ((!BaseActivity.mAppForground) && (rcp.c(this.a))))
    {
      this.a.e();
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsFloatWindowManager", 2, "onHideFloatingWindow");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rcs
 * JD-Core Version:    0.7.0.1
 */