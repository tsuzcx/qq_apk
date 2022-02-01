package cooperation.qqreader.shadow;

import Override;
import android.app.Activity;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.view.MotionEvent;
import bmgm;
import bmgp;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ReaderDefaultProxyActivity
  extends Activity
{
  private final String a = getClass().getName();
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT < 26) {
      setRequestedOrientation(1);
    }
    bmgm.c(this.a, "[ReaderPlugin] 异常分支：自动重启Reader插件Activity的场景，finish不做任何处理 ");
    bmgp.a(this, -1, "Recover failed activity=" + this.a);
    finish();
    Process.killProcess(Process.myPid());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqreader.shadow.ReaderDefaultProxyActivity
 * JD-Core Version:    0.7.0.1
 */