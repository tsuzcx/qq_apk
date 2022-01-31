package dov.com.qq.im;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.biz.qqstory.storyHome.QQStoryTakeVideoHelper;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.richmedia.mediacodec.utils.ShortVideoExceptionReporter;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.setting.ICameraEntrance;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.activity.richmedia.MediaCodecSendTask;
import dov.com.tencent.mobileqq.activity.richmedia.MediaCodecSendTask.VideoSendPublicParam;
import dov.com.tencent.mobileqq.richmedia.capture.util.JumpUtil;
import dov.com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import java.io.File;

public class ShortVideoProcessUtil
{
  public static String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "ShortVideoProcessUtil";
  }
  
  private static Bundle a(Intent paramIntent)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("dynamic_text", paramIntent.getStringExtra("dynamic_text"));
    return localBundle;
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, QQStoryTakeVideoHelper paramQQStoryTakeVideoHelper, ICameraEntrance paramICameraEntrance)
  {
    if ((paramActivity == null) || (paramIntent == null) || (paramQQStoryTakeVideoHelper == null) || (paramICameraEntrance == null)) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "handlePicfromEditPicActivity params are wrong");
      }
    }
    while (paramIntent.getIntExtra("forward_to_someplace_from_shoot_quick", 0) != 1003) {
      return;
    }
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, QQStoryTakeVideoHelper paramQQStoryTakeVideoHelper, ICameraEntrance paramICameraEntrance)
  {
    if ((paramActivity == null) || (paramIntent == null) || (paramQQStoryTakeVideoHelper == null) || (paramICameraEntrance == null)) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "handleVideofromEditVideoActivity params are wrong");
      }
    }
    do
    {
      do
      {
        return;
        paramActivity.getIntent().putExtra("forward_source_from_shoot_quick", true);
        paramQQStoryTakeVideoHelper = (PublishParam)paramIntent.getParcelableExtra(PublishParam.jdField_a_of_type_JavaLangString);
      } while ((paramIntent.getIntExtra("forward_to_someplace_from_shoot_quick", 0) == 1003) || (paramQQStoryTakeVideoHelper == null) || (paramQQStoryTakeVideoHelper.jdField_j_of_type_Int != 1));
      paramActivity.getIntent().putExtra("ab_test_send_btn_click_time", SystemClock.uptimeMillis());
      Object localObject = paramQQStoryTakeVideoHelper.jdField_c_of_type_JavaLangString;
      if (QLog.isColorLevel())
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "hwEncodeVideo videoMergeThumbPath =" + (String)localObject);
        QLog.d(jdField_a_of_type_JavaLangString, 2, "publishParam =" + paramQQStoryTakeVideoHelper.toString());
      }
      PtvFilterUtils.a(new File(paramQQStoryTakeVideoHelper.jdField_j_of_type_JavaLangString).getParent(), paramQQStoryTakeVideoHelper.jdField_b_of_type_JavaLangString);
      Bundle localBundle = a(paramIntent);
      localObject = (SessionInfo)paramIntent.getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
      boolean bool = paramIntent.getBooleanExtra("gotoAIO", false);
      a(paramActivity, (SessionInfo)localObject, paramQQStoryTakeVideoHelper, paramVideoCaptureResult, localBundle);
      if ((localObject != null) && (bool))
      {
        paramIntent = AIOUtils.a(new Intent(paramActivity, SplashActivity.class), new int[] { 2 });
        paramIntent.putExtra("uin", ((SessionInfo)localObject).jdField_a_of_type_JavaLangString);
        paramIntent.putExtra("uintype", ((SessionInfo)localObject).jdField_a_of_type_Int);
        paramIntent.putExtra("troop_uin", ((SessionInfo)localObject).jdField_b_of_type_JavaLangString);
        paramActivity.startActivity(paramIntent);
        return;
      }
    } while (!paramIntent.getBooleanExtra("short_video_multi_share", false));
    JumpUtil.a(paramActivity, paramIntent.getBooleanExtra("quick_shoot_jump_story", true), paramICameraEntrance);
  }
  
  public static void a(Activity paramActivity, SessionInfo paramSessionInfo, PublishParam paramPublishParam, CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, Bundle paramBundle)
  {
    MediaCodecSendTask.VideoSendPublicParam localVideoSendPublicParam = new MediaCodecSendTask.VideoSendPublicParam();
    localVideoSendPublicParam.jdField_a_of_type_AndroidAppActivity = paramActivity;
    localVideoSendPublicParam.jdField_a_of_type_JavaLangString = new File(paramPublishParam.jdField_j_of_type_JavaLangString).getParent();
    localVideoSendPublicParam.jdField_b_of_type_JavaLangString = paramPublishParam.k;
    int i;
    if (paramPublishParam.f <= 5)
    {
      i = paramPublishParam.f;
      localVideoSendPublicParam.jdField_a_of_type_Int = i;
      localVideoSendPublicParam.jdField_c_of_type_JavaLangString = paramPublishParam.jdField_j_of_type_JavaLangString;
      localVideoSendPublicParam.f = paramPublishParam.jdField_c_of_type_JavaLangString;
      localVideoSendPublicParam.jdField_c_of_type_Int = 0;
      localVideoSendPublicParam.jdField_d_of_type_Int = 0;
      localVideoSendPublicParam.jdField_j_of_type_JavaLangString = paramPublishParam.jdField_b_of_type_JavaLangString;
      if (paramVideoCaptureResult != null) {
        break label240;
      }
      ShortVideoExceptionReporter.a(new RuntimeException("videoCaptureResult == null"));
      QLog.e(jdField_a_of_type_JavaLangString, 2, "videoCaptureResult == null");
      localVideoSendPublicParam.h = 0;
      label134:
      localVideoSendPublicParam.i = ((int)paramPublishParam.jdField_a_of_type_Long);
      localVideoSendPublicParam.k = paramBundle.getString("dynamic_text");
      paramActivity = "";
      if (paramSessionInfo == null) {
        break label258;
      }
      paramActivity = paramSessionInfo.jdField_a_of_type_JavaLangString;
      i = paramSessionInfo.jdField_a_of_type_Int;
      paramVideoCaptureResult = paramSessionInfo.jdField_b_of_type_JavaLangString;
      paramSessionInfo = paramActivity;
      paramActivity = paramVideoCaptureResult;
    }
    for (;;)
    {
      localVideoSendPublicParam.jdField_d_of_type_JavaLangString = paramSessionInfo;
      localVideoSendPublicParam.jdField_b_of_type_Int = i;
      localVideoSendPublicParam.e = paramActivity;
      if (paramPublishParam.e == 1) {}
      for (boolean bool = true;; bool = false)
      {
        new MediaCodecSendTask(localVideoSendPublicParam, false, bool).execute(new Void[0]);
        return;
        i = 0;
        break;
        label240:
        localVideoSendPublicParam.h = paramVideoCaptureResult.videoFrameCount;
        break label134;
      }
      label258:
      paramSessionInfo = "";
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ShortVideoProcessUtil
 * JD-Core Version:    0.7.0.1
 */