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
    File localFile = new File(Environment.getExternalStorageDirectory().getPath(), "traceview_switch");
    boolean bool;
    if ((localFile != null) && (localFile.exists()))
    {
      bool = true;
      if (bool)
      {
        localFile = new File(VFSAssistantUtils.getSDKPrivatePath("qzonetrace"));
        if (!localFile.exists()) {
          break label103;
        }
        if (localFile.isFile()) {
          localFile.delete();
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("traceview", 2, "isDebugTrace:" + bool);
      }
      return bool;
      bool = false;
      break;
      label103:
      localFile.mkdirs();
    }
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
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onResume()
  {
    super.onResume();
    if (getIntent().getIntExtra("hc_code", 0) != 0) {
      HardCoderManager.a().a(getIntent().getIntExtra("hc_code", 0), true);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.QzoneFeedsPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */