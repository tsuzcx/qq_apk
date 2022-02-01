package cooperation.qappcenter;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class QAppCenterPluginProxyActivityTools
  extends PluginProxyActivity
{
  public static boolean a = false;
  
  public static void a(Activity paramActivity)
  {
    try
    {
      paramActivity = paramActivity.getIntent();
      if ((paramActivity != null) && (paramActivity.getExtras() != null)) {
        paramActivity.putExtra("fling_action_key", 0);
      }
      return;
    }
    catch (Exception paramActivity) {}
  }
  
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
    a(this);
    Intent localIntent = getIntent();
    if (localIntent != null) {
      localIntent.putExtra("big_brother_source_key", "biz_src_yyb");
    }
    super.onCreate(paramBundle);
  }
  
  protected void onPause()
  {
    super.onPause();
    a = false;
  }
  
  protected void onResume()
  {
    super.onResume();
    a = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qappcenter.QAppCenterPluginProxyActivityTools
 * JD-Core Version:    0.7.0.1
 */