package cooperation.qappcenter;

import Override;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class QAppCenterPluginProxyActivityQzone
  extends PluginProxyActivity
{
  public static boolean a;
  
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
  
  public void onCreate(Bundle paramBundle)
  {
    QAppCenterPluginProxyActivityTools.a(this);
    Intent localIntent = getIntent();
    if (localIntent != null) {
      localIntent.putExtra("big_brother_source_key", "biz_src_yyb");
    }
    super.onCreate(paramBundle);
  }
  
  public void onPause()
  {
    super.onPause();
    a = false;
  }
  
  public void onResume()
  {
    super.onResume();
    a = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qappcenter.QAppCenterPluginProxyActivityQzone
 * JD-Core Version:    0.7.0.1
 */