package cooperation.qzone;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Environment;
import android.view.MotionEvent;
import com.tencent.mm.hardcoder.HardCoderManager;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;

public class QzoneFeedsPluginProxyActivity
  extends QzonePluginProxyActivity
{
  private static final String TAG = "traceview";
  
  private static boolean isDebugTrace()
  {
    boolean bool;
    if (new File(Environment.getExternalStorageDirectory().getPath(), "traceview_switch").exists()) {
      bool = true;
    } else {
      bool = false;
    }
    Object localObject;
    if (bool)
    {
      localObject = new File(VFSAssistantUtils.getSDKPrivatePath("qzonetrace"));
      if (((File)localObject).exists())
      {
        if (((File)localObject).isFile()) {
          ((File)localObject).delete();
        }
      }
      else {
        ((File)localObject).mkdirs();
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isDebugTrace:");
      ((StringBuilder)localObject).append(bool);
      QLog.d("traceview", 2, ((StringBuilder)localObject).toString());
    }
    return bool;
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
    super.onCreate(paramBundle);
  }
  
  protected void onResume()
  {
    super.onResume();
    if (getIntent().getIntExtra("hc_code", 0) != 0) {
      HardCoderManager.getInstance().stop(getIntent().getIntExtra("hc_code", 0), true);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.QzoneFeedsPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */