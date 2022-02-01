package dov.com.qq.im;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.richmedia.FlowComponentInterface;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.setting.ICameraEntrance;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.activity.richmedia.MediaCodecSendTask;
import dov.com.tencent.mobileqq.activity.richmedia.MediaCodecSendTask.VideoSendPublicParam;
import dov.com.tencent.mobileqq.richmedia.capture.util.JumpUtil;
import dov.com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import java.io.File;
import java.util.ArrayList;

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
    String str = paramIntent.getStringExtra("widgetinfo");
    paramIntent = paramIntent.getStringExtra("key_camera_material_name");
    if (!TextUtils.isEmpty(str))
    {
      localBundle.putString("widgetinfo", str);
      if (!TextUtils.isEmpty(paramIntent)) {
        localBundle.putString("key_camera_material_name", paramIntent);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getBundle templateId:" + str + ", name:" + paramIntent);
    }
    return localBundle;
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, ICameraEntrance paramICameraEntrance, ShortVideoProcessUtil.MediaCodecEditCallback paramMediaCodecEditCallback)
  {
    a(paramActivity, paramIntent, paramICameraEntrance, paramMediaCodecEditCallback, null, "", 1, null, false, "", false);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, ICameraEntrance paramICameraEntrance, ShortVideoProcessUtil.MediaCodecEditCallback paramMediaCodecEditCallback, FlowComponentInterface paramFlowComponentInterface, String paramString1, int paramInt, ArrayList<String> paramArrayList, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
  {
    if ((paramActivity == null) || (paramIntent == null) || (paramICameraEntrance == null)) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "handleVideoFromEditVideoActivity params are wrong");
      }
    }
    do
    {
      PublishParam localPublishParam;
      do
      {
        return;
        paramActivity.getIntent().putExtra("forward_source_from_shoot_quick", true);
        localPublishParam = (PublishParam)paramIntent.getParcelableExtra(PublishParam.jdField_a_of_type_JavaLangString);
      } while ((localPublishParam == null) || (localPublishParam.jdField_j_of_type_Int != 1));
      Object localObject = localPublishParam.jdField_c_of_type_JavaLangString;
      paramActivity.getIntent().putExtra("ab_test_send_btn_click_time", SystemClock.uptimeMillis());
      if (QLog.isColorLevel())
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "hwEncodeVideo videoMergeThumbPath =" + (String)localObject);
        QLog.d(jdField_a_of_type_JavaLangString, 2, "publishParam =" + localPublishParam.toString());
      }
      PtvFilterUtils.a(new File(localPublishParam.jdField_j_of_type_JavaLangString).getParent(), localPublishParam.jdField_b_of_type_JavaLangString);
      Bundle localBundle = a(paramIntent);
      localObject = (SessionInfo)paramIntent.getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
      boolean bool = paramIntent.getBooleanExtra("gotoAIO", false);
      a(paramActivity, (SessionInfo)localObject, localPublishParam, localBundle, paramMediaCodecEditCallback, paramFlowComponentInterface, paramString1, paramInt, paramArrayList, paramBoolean1, paramString2, paramBoolean2);
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
  
  public static void a(Activity paramActivity, SessionInfo paramSessionInfo, PublishParam paramPublishParam, Bundle paramBundle, ShortVideoProcessUtil.MediaCodecEditCallback paramMediaCodecEditCallback)
  {
    a(paramActivity, paramSessionInfo, paramPublishParam, paramBundle, paramMediaCodecEditCallback, null, "", 1, null, false, "", false);
  }
  
  public static void a(Activity paramActivity, SessionInfo paramSessionInfo, PublishParam paramPublishParam, Bundle paramBundle, ShortVideoProcessUtil.MediaCodecEditCallback paramMediaCodecEditCallback, FlowComponentInterface paramFlowComponentInterface, String paramString1, int paramInt, ArrayList<String> paramArrayList, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
  {
    MediaCodecSendTask.VideoSendPublicParam localVideoSendPublicParam = new MediaCodecSendTask.VideoSendPublicParam();
    localVideoSendPublicParam.jdField_a_of_type_AndroidAppActivity = paramActivity;
    localVideoSendPublicParam.jdField_a_of_type_JavaLangString = new File(paramPublishParam.jdField_j_of_type_JavaLangString).getParent();
    localVideoSendPublicParam.jdField_b_of_type_JavaLangString = paramPublishParam.k;
    int i;
    boolean bool;
    if (paramPublishParam.f <= 5)
    {
      i = paramPublishParam.f;
      localVideoSendPublicParam.jdField_a_of_type_Int = i;
      localVideoSendPublicParam.jdField_c_of_type_JavaLangString = paramPublishParam.jdField_j_of_type_JavaLangString;
      localVideoSendPublicParam.f = paramPublishParam.jdField_c_of_type_JavaLangString;
      localVideoSendPublicParam.jdField_c_of_type_Int = 0;
      localVideoSendPublicParam.jdField_d_of_type_Int = 0;
      localVideoSendPublicParam.jdField_j_of_type_JavaLangString = paramPublishParam.jdField_b_of_type_JavaLangString;
      localVideoSendPublicParam.h = paramPublishParam.o;
      localVideoSendPublicParam.jdField_i_of_type_Int = paramPublishParam.p;
      if (paramPublishParam.jdField_i_of_type_Int != 1) {
        break label318;
      }
      bool = true;
      label132:
      localVideoSendPublicParam.jdField_c_of_type_Boolean = bool;
      localVideoSendPublicParam.jdField_j_of_type_Int = paramPublishParam.f;
      localVideoSendPublicParam.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface = paramFlowComponentInterface;
      localVideoSendPublicParam.g = paramString1;
      localVideoSendPublicParam.jdField_e_of_type_Int = paramInt;
      localVideoSendPublicParam.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
      localVideoSendPublicParam.jdField_a_of_type_Boolean = paramBoolean1;
      localVideoSendPublicParam.jdField_i_of_type_JavaLangString = paramString2;
      localVideoSendPublicParam.jdField_b_of_type_Boolean = paramBoolean2;
      localVideoSendPublicParam.k = paramBundle.getString("dynamic_text");
      localVideoSendPublicParam.l = paramBundle.getString("widgetinfo");
      localVideoSendPublicParam.m = paramBundle.getString("key_camera_material_name");
      paramBundle = "";
      paramInt = 0;
      paramActivity = "";
      if (paramSessionInfo != null)
      {
        paramBundle = paramSessionInfo.jdField_a_of_type_JavaLangString;
        paramInt = paramSessionInfo.jdField_a_of_type_Int;
        paramActivity = paramSessionInfo.jdField_b_of_type_JavaLangString;
      }
      localVideoSendPublicParam.jdField_d_of_type_JavaLangString = paramBundle;
      localVideoSendPublicParam.jdField_b_of_type_Int = paramInt;
      localVideoSendPublicParam.jdField_e_of_type_JavaLangString = paramActivity;
      if (paramPublishParam.jdField_e_of_type_Int != 1) {
        break label324;
      }
    }
    label318:
    label324:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      new MediaCodecSendTask(localVideoSendPublicParam, false, paramBoolean1, paramMediaCodecEditCallback).execute(new Void[0]);
      return;
      i = 0;
      break;
      bool = false;
      break label132;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ShortVideoProcessUtil
 * JD-Core Version:    0.7.0.1
 */