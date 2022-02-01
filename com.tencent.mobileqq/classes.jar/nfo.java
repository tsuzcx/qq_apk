import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

class nfo
  implements Application.ActivityLifecycleCallbacks
{
  nfo(nfn paramnfn) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    if (paramActivity == nfn.a(this.a))
    {
      nfn.c(this.a);
      this.a.a();
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    if (paramActivity == nfn.a(this.a)) {
      nfn.b(this.a);
    }
  }
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nfo
 * JD-Core Version:    0.7.0.1
 */