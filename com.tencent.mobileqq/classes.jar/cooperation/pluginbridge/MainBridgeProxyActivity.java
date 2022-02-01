package cooperation.pluginbridge;

import android.content.res.Configuration;
import android.view.MotionEvent;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class MainBridgeProxyActivity
  extends PluginProxyActivity
{
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public Class<? extends PluginProxyActivity> getProxyActivity(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.w("MainBridgeProxyActivity", 2, "getProxyActivity:" + paramString);
    }
    return super.getProxyActivity(paramString);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.pluginbridge.MainBridgeProxyActivity
 * JD-Core Version:    0.7.0.1
 */