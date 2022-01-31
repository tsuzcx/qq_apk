package cooperation.smartdevice;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.qphone.base.util.QLog;

public class SmartDevicePluginProxyActivity
  extends PluginProxyActivity
{
  public String getPluginID()
  {
    return "qqsmartdevice.apk";
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    if (getIntent().getIntExtra("KEY_OPENAV_ROOM_ID", 0) != 0) {
      getIntent().putExtra("fling_action_key", 0);
    }
    super.onCreate(paramBundle);
    if (!TextUtils.isEmpty(this.mCreateErrorInfo)) {
      if (paramBundle == null) {
        break label95;
      }
    }
    for (;;)
    {
      paramBundle = paramBundle.getString("pluginsdk_launchActivity");
      StringBuffer localStringBuffer = new StringBuffer("[插件Activity启动] ");
      localStringBuffer.append(paramBundle).append(" ").append(this.mCreateErrorInfo);
      if (QLog.isColorLevel()) {
        QLog.d("SmartDevicePluginProxyActivity", 2, localStringBuffer.toString());
      }
      return;
      label95:
      paramBundle = getIntent().getExtras();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.smartdevice.SmartDevicePluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */