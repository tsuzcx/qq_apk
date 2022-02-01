package cooperation.smartdevice;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class SmartDevicePluginProxyActivity
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
  
  public String getPluginID()
  {
    return "qqsmartdevice.apk";
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    if (getIntent().getIntExtra("KEY_OPENAV_ROOM_ID", 0) != 0) {
      getIntent().putExtra("fling_action_key", 0);
    }
    super.onCreate(paramBundle);
    if (!TextUtils.isEmpty(this.mCreateErrorInfo))
    {
      if (paramBundle == null) {
        paramBundle = getIntent().getExtras();
      }
      paramBundle = paramBundle.getString("pluginsdk_launchActivity");
      StringBuffer localStringBuffer = new StringBuffer("[插件Activity启动] ");
      localStringBuffer.append(paramBundle);
      localStringBuffer.append(" ");
      localStringBuffer.append(this.mCreateErrorInfo);
      if (QLog.isColorLevel()) {
        QLog.d("SmartDevicePluginProxyActivity", 2, localStringBuffer.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.smartdevice.SmartDevicePluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */