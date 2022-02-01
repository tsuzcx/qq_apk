package dov.com.tencent.mobileqq.richmedia.capture.util;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.biz.qqstory.utils.StoryIntentUtils;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForPeak;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.richmedia.QzoneSlideShowPreparingFragment;
import com.tencent.mobileqq.richmediabrowser.ParamsManager;
import com.tencent.mobileqq.shortvideo.util.MediaCodecDPC;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.SessionWrap;
import dov.com.qq.im.ae.camera.AEPhotoCaptureResult;
import dov.com.qq.im.ae.camera.BaseVideoCaptureResult;
import dov.com.qq.im.ae.entry.AECameraEntry;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.setting.CaptureEntranceParams;
import dov.com.qq.im.setting.CapturePicParams;
import dov.com.qq.im.setting.CaptureVideoParams;
import dov.com.qq.im.setting.ICameraEntrance;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import dov.com.tencent.biz.qqstory.takevideo.EditWebVideoActivity;
import dov.com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import dov.com.tencent.mobileqq.activity.richmedia.NewFlowCameraReporter;
import dov.com.tencent.mobileqq.activity.richmedia.QzoneEditVideoActivity;
import org.jetbrains.annotations.NotNull;

public class JumpUtil
{
  public static Bundle a(Bundle paramBundle, String paramString)
  {
    Object localObject1 = paramBundle.getString("KEY_CURRENT_SELECT_ID");
    String str = "";
    Object localObject2 = str;
    Object localObject3 = localObject1;
    if (!TextUtils.isEmpty(paramString))
    {
      String[] arrayOfString = paramString.split("\\^");
      paramString = str;
      if (arrayOfString.length > 0) {
        paramString = arrayOfString[0];
      }
      if (arrayOfString.length == 1)
      {
        localObject1 = arrayOfString[0];
        paramString = AECaptureMode.NORMAL.name;
      }
      if (arrayOfString.length > 1) {
        localObject1 = arrayOfString[1];
      }
      localObject2 = paramString;
      localObject3 = localObject1;
      if (arrayOfString.length > 2)
      {
        localObject3 = arrayOfString[2];
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label147;
        }
        paramBundle.putString("KEY_CURRENT_TYPE", (String)localObject1);
      }
      for (;;)
      {
        paramBundle.putString("KEY_CURRENT_TAB", AECameraEntry.a(paramString));
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          paramBundle.putString("KEY_CURRENT_SELECT_ID", (String)localObject2);
        }
        return paramBundle;
        label147:
        paramBundle.putString("KEY_CURRENT_TYPE", " ");
      }
      localObject1 = "";
      paramString = (String)localObject2;
      localObject2 = localObject3;
    }
  }
  
  @NotNull
  private static EditVideoParams a(Activity paramActivity, LocalMediaInfo paramLocalMediaInfo, CaptureVideoParams paramCaptureVideoParams, int paramInt1, Bundle paramBundle, EditVideoParams.EditSource paramEditSource, int paramInt2)
  {
    paramBundle = new EditVideoParams(paramInt2, paramInt1, paramEditSource, paramBundle);
    if (paramCaptureVideoParams != null) {
      paramBundle.b = paramCaptureVideoParams.jdField_a_of_type_Int;
    }
    paramBundle.f = paramActivity.getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a());
    paramBundle.a.putBoolean("enable_hw_encode", true);
    if (QLog.isColorLevel()) {
      QLog.d("JumpUtil", 2, "EditVideoParams params:" + paramBundle.toString());
    }
    if (paramLocalMediaInfo.redBagType == LocalMediaInfo.REDBAG_TYPE_GET) {
      paramBundle.a.putInt("video_redbag_get", paramLocalMediaInfo.redBagType);
    }
    paramBundle.a.putInt("special_video_type", paramLocalMediaInfo.specialVideoType);
    long l = paramActivity.getIntent().getLongExtra("troop_uin", 0L);
    if (l != 0L) {
      paramBundle.a.putLong("troop_uin", l);
    }
    return paramBundle;
  }
  
  public static String a(@Nullable String paramString)
  {
    String str;
    if (paramString == null) {
      str = null;
    }
    do
    {
      return str;
      str = paramString;
    } while (paramString.startsWith("mqqapi://"));
    return "mqqapi://videostory/takevideo?from=qzoneTail&widgetinfo=" + paramString + "&cmode=all";
  }
  
  public static String a(String paramString1, String paramString2)
  {
    paramString2 = "mqqapi://qcircle/opencamera?activity_id=circle_takesame";
    if (!TextUtils.isEmpty(paramString1)) {
      paramString2 = "mqqapi://qcircle/opencamera?activity_id=circle_takesame" + "&tab=camera&widgetinfo=" + paramString1;
    }
    return paramString2;
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle)
  {
    if ((paramActivity == null) || (paramActivity.isFinishing())) {
      return;
    }
    paramBundle.putInt("qq_sub_business_id", 3);
    paramBundle.putInt("entrance_type", 10001);
    paramBundle.putLong("qzone_slide_enable_mask", 99195L);
    paramBundle.putBoolean("from_qzone_slideshow", true);
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    localIntent.addFlags(268435456);
    QLog.e("QzoneSlideShowPreparingFragment", 2, "jumpToSlideShowEditVideoActivityForQzone start!");
    PublicFragmentActivityForPeak.b(paramActivity.getApplicationContext(), localIntent, QzoneSlideShowPreparingFragment.class);
    paramActivity.overridePendingTransition(2130771999, 2130772003);
  }
  
  public static void a(Activity paramActivity, AEPhotoCaptureResult paramAEPhotoCaptureResult, CaptureEntranceParams paramCaptureEntranceParams, Bundle paramBundle, int paramInt)
  {
    if ((paramActivity == null) || (paramActivity.isFinishing()) || (paramCaptureEntranceParams == null)) {}
    CapturePicParams localCapturePicParams;
    do
    {
      return;
      localCapturePicParams = paramCaptureEntranceParams.a();
      if (localCapturePicParams != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("JumpUtil", 2, "jumpToEditPicActivity picParams is null");
    return;
    boolean bool = localCapturePicParams.a();
    int i = paramCaptureEntranceParams.c;
    int j = localCapturePicParams.c();
    int k = paramCaptureEntranceParams.b();
    int m = localCapturePicParams.a();
    paramCaptureEntranceParams = localCapturePicParams.b();
    Object localObject = EditPicActivity.a(paramActivity, paramAEPhotoCaptureResult.jdField_a_of_type_JavaLangString, true, localCapturePicParams.jdField_a_of_type_Boolean, true, bool, true, false, false, false, i, k, j, false, null);
    ((Intent)localObject).putExtra("edit_video_call_back", paramCaptureEntranceParams);
    ((Intent)localObject).putExtra("qcamera_photo_filepath", paramAEPhotoCaptureResult.jdField_a_of_type_JavaLangString);
    ((Intent)localObject).putExtra("qcamera_rotate", paramAEPhotoCaptureResult.c);
    ((Intent)localObject).putExtra("shareto_web_mode", localCapturePicParams.d());
    ((Intent)localObject).putExtra("camera_type", 103);
    ((Intent)localObject).putExtra("camera_front_back", m);
    ((Intent)localObject).putExtra("camera_capture_method", paramAEPhotoCaptureResult.jdField_a_of_type_Int);
    ((Intent)localObject).putExtra("camera_mode", localCapturePicParams.jdField_a_of_type_Int);
    ((Intent)localObject).putExtra("state", paramBundle);
    paramBundle = localCapturePicParams.a();
    paramCaptureEntranceParams = (CaptureEntranceParams)localObject;
    if (paramBundle != null)
    {
      ((Intent)localObject).putExtra("uin", paramBundle.jdField_a_of_type_JavaLangString);
      ((Intent)localObject).putExtra("uintype", paramBundle.jdField_a_of_type_Int);
      ((Intent)localObject).putExtra("troop_uin", paramBundle.c);
      ((Intent)localObject).putExtra("uinname", paramBundle.b);
      paramCaptureEntranceParams = AIOUtils.a((Intent)localObject, null);
    }
    paramCaptureEntranceParams.putExtra("edit_video_way", paramInt);
    paramCaptureEntranceParams.putExtra("sub_business_id", localCapturePicParams.e());
    paramBundle = SplashActivity.class.getName();
    localObject = localCapturePicParams.a();
    if ((localObject != null) && (((String)localObject).equals(ChatActivity.class.getName()))) {
      paramBundle = (Bundle)localObject;
    }
    for (;;)
    {
      NewFlowCameraReporter.a("finish");
      NewFlowCameraReporter.a(paramCaptureEntranceParams);
      paramCaptureEntranceParams.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", paramBundle);
      if (paramAEPhotoCaptureResult.jdField_a_of_type_Int == 1) {
        paramCaptureEntranceParams.putExtra("editpic_cameratype", 1);
      }
      for (;;)
      {
        paramActivity.startActivityForResult(paramCaptureEntranceParams, 1012);
        FlowCameraMqqAction.a("", "0X80075C1", "", "", "", "");
        return;
        if (paramAEPhotoCaptureResult.jdField_a_of_type_Int == 0) {
          paramCaptureEntranceParams.putExtra("editpic_cameratype", 2);
        }
      }
    }
  }
  
  public static void a(Activity paramActivity, BaseVideoCaptureResult paramBaseVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo, CaptureEntranceParams paramCaptureEntranceParams, Bundle paramBundle1, int paramInt, @Nullable Bundle paramBundle2)
  {
    if ((paramActivity == null) || (paramActivity.isFinishing()) || (paramCaptureEntranceParams == null)) {}
    CaptureVideoParams localCaptureVideoParams;
    do
    {
      return;
      localCaptureVideoParams = paramCaptureEntranceParams.a();
      if (localCaptureVideoParams != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("JumpUtil", 2, "jumpToEditVideoActivity videoParams is null");
    return;
    long l = paramActivity.getIntent().getLongExtra("qzone_slide_enable_mask", -1L);
    int j;
    if ((paramActivity.getIntent() != null) && (l != -1L))
    {
      i = (int)l;
      if ((!localCaptureVideoParams.jdField_a_of_type_Boolean) || (!MediaCodecDPC.m())) {
        break label738;
      }
      j = i | 0x10;
      label99:
      i = j;
      if (localCaptureVideoParams.b()) {
        i = j | 0x4000;
      }
      j = i;
      if (localCaptureVideoParams.a()) {
        j = i | 0x200;
      }
      i = j;
      if (localCaptureVideoParams.c()) {
        i = j | 0x100;
      }
      j = i;
      if (paramCaptureEntranceParams.jdField_a_of_type_Int != 10013)
      {
        j = i;
        if (paramCaptureEntranceParams.jdField_a_of_type_Int != 10012)
        {
          j = i;
          if (paramCaptureEntranceParams.jdField_a_of_type_Int != 10007) {
            j = i | 0x1000;
          }
        }
      }
      if (localCaptureVideoParams.c) {
        break label980;
      }
    }
    label339:
    label980:
    for (int i = j & 0xFFFFFFFE;; i = j)
    {
      if (paramBundle2 == null) {}
      for (Bundle localBundle = new Bundle();; localBundle = paramBundle2)
      {
        boolean bool1;
        boolean bool2;
        if (paramCaptureEntranceParams.jdField_a_of_type_Int == 10012)
        {
          if ((paramLocalMediaInfo.mDuration > 20000L) || (paramLocalMediaInfo.mTotalDuration > 20000L))
          {
            localBundle.putBoolean("extra_enable_revert", false);
            localBundle.putBoolean("extra_enable_slow", false);
          }
          bool1 = localBundle.getBoolean("needVideoDoodle", false);
          bool2 = localBundle.getBoolean("needVideoWording", false);
          if (bool1) {
            break label970;
          }
          i &= 0xFFFFFBFF;
        }
        for (;;)
        {
          j = i;
          if (!bool2) {
            j = i & 0xFFFFFFFE;
          }
          if (paramLocalMediaInfo.mDuration > 80000L) {
            localBundle.putBoolean("extra_enable_slow", false);
          }
          Object localObject = (SessionWrap)paramActivity.getIntent().getParcelableExtra("ARG_SESSION_INFO");
          if (localObject != null)
          {
            localBundle.putString("uin", ((SessionWrap)localObject).jdField_a_of_type_JavaLangString);
            localBundle.putInt("uintype", ((SessionWrap)localObject).jdField_a_of_type_Int);
            localBundle.putString("troop_uin", ((SessionWrap)localObject).c);
            localBundle.putString("uinname", ((SessionWrap)localObject).b);
          }
          localObject = (SessionInfo)paramActivity.getIntent().getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
          if (localObject != null) {
            localBundle.putParcelable("edit_send_session_info", (Parcelable)localObject);
          }
          localBundle.putInt("qq_sub_business_id", localCaptureVideoParams.a());
          localBundle.putInt("entrance_type", paramCaptureEntranceParams.b);
          bool1 = localCaptureVideoParams.d();
          paramBaseVideoCaptureResult = new EditTakeVideoSource(paramBaseVideoCaptureResult.videoMp4FilePath, paramBaseVideoCaptureResult.audioDataFilePath, paramLocalMediaInfo);
          i = paramCaptureEntranceParams.c;
          int k = localCaptureVideoParams.b();
          VideoEditReport.b(k);
          localBundle.putString("video_tag_info", paramActivity.getIntent().getStringExtra("video_tag_info"));
          paramLocalMediaInfo = a(paramActivity, paramLocalMediaInfo, localCaptureVideoParams, j, localBundle, paramBaseVideoCaptureResult, i);
          if (bool1)
          {
            paramBaseVideoCaptureResult = new Intent(paramActivity, EditWebVideoActivity.class);
            StoryIntentUtils.a(paramBaseVideoCaptureResult, paramActivity.getIntent().getExtras(), paramActivity);
            paramBaseVideoCaptureResult.putExtra("edit_video_call_back", localCaptureVideoParams.jdField_a_of_type_JavaLangString);
            paramBaseVideoCaptureResult.putExtra("short_video_entrance_type", k);
            paramBaseVideoCaptureResult.putExtra(EditVideoParams.class.getName(), paramLocalMediaInfo);
            if (paramCaptureEntranceParams.jdField_a_of_type_Int != 10012) {
              break label916;
            }
            paramBaseVideoCaptureResult.putExtra("op_department", "grp_tribe");
          }
          for (;;)
          {
            paramBaseVideoCaptureResult.putExtra("op_type", "video_edit");
            paramBaseVideoCaptureResult.putExtra("stop_record_time", System.currentTimeMillis());
            paramBaseVideoCaptureResult.putExtra("state", paramBundle1);
            paramBaseVideoCaptureResult.putExtra("edit_video_way", paramInt);
            paramBaseVideoCaptureResult.putExtra("VIDEO_STORY_JUMP_TO_TYPE", AECameraEntry.b(paramActivity.getIntent()));
            paramBaseVideoCaptureResult.putExtra("VIDEO_STORY_FROM_TYPE", AECameraEntry.a(paramActivity.getIntent()));
            if (!(paramActivity instanceof QzoneEditVideoActivity)) {
              break label954;
            }
            ((QzoneEditVideoActivity)paramActivity).a(paramBaseVideoCaptureResult);
            return;
            i = 1099;
            break;
            label738:
            j = i | 0x20;
            break label99;
            if (paramCaptureEntranceParams.jdField_a_of_type_Int == 10013)
            {
              if (paramLocalMediaInfo.mDuration <= 20000L)
              {
                j = i;
                if (paramLocalMediaInfo.mTotalDuration <= 20000L) {
                  break label339;
                }
              }
              localBundle.putBoolean("extra_enable_revert", false);
              localBundle.putBoolean("extra_enable_slow", false);
              j = i;
              break label339;
            }
            if (paramCaptureEntranceParams.jdField_a_of_type_Int != 10000)
            {
              j = i;
              if (paramCaptureEntranceParams.jdField_a_of_type_Int != 10007) {
                break label339;
              }
            }
            j = i & 0xFFFFFFDF;
            break label339;
            if ((paramBundle2 != null) && (paramBundle2.getBoolean("from_qzone_slideshow")))
            {
              paramBaseVideoCaptureResult = new Intent(paramActivity, QzoneEditVideoActivity.class);
              paramBaseVideoCaptureResult.putExtra("qqstory_slide_show_scene", SlideShowPhotoListManager.a().b());
              paramBaseVideoCaptureResult.putExtra("qqstory_slide_show_entrance", SlideShowPhotoListManager.a().a());
              break label575;
            }
            paramBaseVideoCaptureResult = new Intent(paramActivity, EditVideoActivity.class);
            break label575;
            if (paramCaptureEntranceParams.jdField_a_of_type_Int == 10013) {
              paramBaseVideoCaptureResult.putExtra("op_department", "grp_readinjoy");
            } else {
              paramBaseVideoCaptureResult.putExtra("op_department", "grp_qq");
            }
          }
          paramActivity.startActivityForResult(paramBaseVideoCaptureResult, paramCaptureEntranceParams.jdField_a_of_type_Int);
          paramActivity.overridePendingTransition(0, 0);
          return;
        }
      }
    }
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent();
    int i = ParamsManager.a().a();
    String str = "mqqapi://videostory/takevideo?from=aioChats&widgetinfo=" + paramString + "&cmode=all";
    if (i == 1) {
      paramString = str + "&activity_id=aio_n_takesame";
    }
    for (;;)
    {
      localIntent.setData(Uri.parse(paramString));
      JumpActivity.f(localIntent);
      JumpActivity.a(paramActivity, localIntent);
      paramActivity.startActivity(localIntent);
      return;
      paramString = str;
      if (i == 0) {
        paramString = str + "&activity_id=aio_1_takesame";
      }
    }
  }
  
  public static void a(Activity paramActivity, boolean paramBoolean, ICameraEntrance paramICameraEntrance)
  {
    paramICameraEntrance = new Intent(paramActivity, SplashActivity.class);
    paramICameraEntrance.putExtra("fragment_id", 1);
    if (paramBoolean)
    {
      paramICameraEntrance.putExtra("main_tab_id", 6);
      paramICameraEntrance.putExtra("open_now_tab_fragment", true);
      paramICameraEntrance.putExtra("extra_from_share", true);
      paramICameraEntrance.setFlags(335544320);
      paramActivity.startActivity(paramICameraEntrance);
      paramActivity.overridePendingTransition(2130771983, 2130771985);
      return;
    }
    paramICameraEntrance.putExtra("main_tab_id", 1);
    paramICameraEntrance.setFlags(335544320);
    paramActivity.startActivity(paramICameraEntrance);
  }
  
  public static void b(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setData(Uri.parse("mqqapi://videostory/takevideo?from=aioGifCameraTail&widgetinfo=" + paramString + "&cmode=singlegif"));
    JumpActivity.f(localIntent);
    JumpActivity.a(paramActivity, localIntent);
    paramActivity.startActivity(localIntent);
  }
  
  public static void c(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setData(Uri.parse(paramString));
    JumpActivity.f(localIntent);
    JumpActivity.a(paramActivity, localIntent);
    paramActivity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.util.JumpUtil
 * JD-Core Version:    0.7.0.1
 */