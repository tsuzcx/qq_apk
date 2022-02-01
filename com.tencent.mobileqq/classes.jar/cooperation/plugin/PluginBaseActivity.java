package cooperation.plugin;

import Override;
import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.MotionEvent;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class PluginBaseActivity
  extends BasePluginActivity
{
  public boolean u = true;
  
  protected String a()
  {
    return getString(2131690559);
  }
  
  protected boolean a()
  {
    return false;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public int g()
  {
    return getResources().getDimensionPixelSize(2131299011);
  }
  
  public final Activity getActivity()
  {
    return this;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.plugin.PluginBaseActivity
 * JD-Core Version:    0.7.0.1
 */