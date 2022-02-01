package cooperation.groupvideo;

import android.content.res.Configuration;
import android.view.MotionEvent;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.groupvideo.api.IGVideoSmallScreenDialog;

public class GVideoSmallScreenDialog
  extends PluginProxyActivity
{
  private static final IGVideoSmallScreenDialog a = (IGVideoSmallScreenDialog)QRoute.api(IGVideoSmallScreenDialog.class);
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public String getPluginID()
  {
    return a.getPluginID();
  }
  
  public Class<? extends PluginProxyActivity> getProxyActivity(String paramString)
  {
    return GVideoSmallScreenDialog.class;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.groupvideo.GVideoSmallScreenDialog
 * JD-Core Version:    0.7.0.1
 */