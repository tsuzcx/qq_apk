package dov.com.qq.im.ae.entry;

import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.MobileQQ;

public class AECameraLaunchServer
  extends QIPCModule
{
  private AECameraLaunchServer()
  {
    super("AECameraLaunchServer");
  }
  
  public static AECameraLaunchServer a()
  {
    return AECameraLaunchServer.Holder.a();
  }
  
  private void a(Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT < 21)
    {
      QQToast.a(MobileQQ.sMobileQQ, MobileQQ.sMobileQQ.getResources().getString(2131717521), 1).a();
      return;
    }
    int i = paramBundle.getInt("VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a());
    if (i == AECameraEntry.a.a()) {
      paramBundle.putInt("VIDEO_STORY_JUMP_TO_TYPE", 1);
    }
    paramBundle.putInt("AECAMERA_MODE", 200);
    paramBundle.putInt("VIDEO_STORY_FROM_TYPE", i);
    paramBundle.putString("KEY_CURRENT_SELECT_ID", paramBundle.getString("widgetid"));
    AECameraLauncher.a(MobileQQ.sMobileQQ, paramBundle);
  }
  
  private void b(Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT < 21)
    {
      QQToast.a(MobileQQ.sMobileQQ, MobileQQ.sMobileQQ.getResources().getString(2131717521), 1).a();
      return;
    }
    int i = paramBundle.getInt("VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a());
    if (i == AECameraEntry.a.a()) {
      paramBundle.putInt("VIDEO_STORY_JUMP_TO_TYPE", 1);
    }
    paramBundle.putInt("AECAMERA_MODE", 200);
    paramBundle.putInt("VIDEO_STORY_FROM_TYPE", i);
    paramBundle.putString("KEY_CURRENT_SELECT_ID", paramBundle.getString("widgetid"));
    paramBundle.putInt("key_camera_photo_edit_type", -2);
    paramBundle.putInt("key_camera_video_edit_type", -2);
    AECameraLauncher.a(MobileQQ.sMobileQQ, paramBundle);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    QLog.i("AECameraLaunchServer", 1, "onCall. action=" + paramString);
    if (MobileQQ.sMobileQQ != null) {
      if ("ACTION_MINI_LAUNCH_CAMERA_FOR_SIGN_IN".equals(paramString)) {
        a(paramBundle);
      }
    }
    for (;;)
    {
      return null;
      if ("ACTION_MINI_LAUNCH_CAMERA_FOR_PLAY".equals(paramString))
      {
        b(paramBundle);
        continue;
        QLog.e("AECameraLaunchServer", 1, "no mobile qq.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.entry.AECameraLaunchServer
 * JD-Core Version:    0.7.0.1
 */