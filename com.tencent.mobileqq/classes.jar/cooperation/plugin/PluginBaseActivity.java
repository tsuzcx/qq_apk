package cooperation.plugin;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.MotionEvent;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class PluginBaseActivity
  extends BasePluginActivity
{
  public boolean aM = true;
  
  public int L()
  {
    return getResources().getDimensionPixelSize(2131299920);
  }
  
  protected boolean bB_()
  {
    return false;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected String f()
  {
    return getString(2131887625);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.plugin.PluginBaseActivity
 * JD-Core Version:    0.7.0.1
 */