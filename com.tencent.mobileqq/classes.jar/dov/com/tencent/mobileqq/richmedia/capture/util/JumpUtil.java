package dov.com.tencent.mobileqq.richmedia.capture.util;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.utils.StoryIntentUtils;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.PhotoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.shortvideo.util.MediaCodecDPC;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMAIOEffectCameraCaptureUnit.Session;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.music.QimMusicPlayer;
import dov.com.qq.im.setting.CaptureEntranceParams;
import dov.com.qq.im.setting.CapturePicParams;
import dov.com.qq.im.setting.CaptureVideoParams;
import dov.com.qq.im.setting.ICameraEntrance;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoSyncStorySwitchEntry;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoSyncStorySwitchEntry.SwitchEntryData;
import dov.com.tencent.biz.qqstory.takevideo.EditWebVideoActivity;
import dov.com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import dov.com.tencent.mobileqq.activity.richmedia.NewFlowCameraReporter;
import dov.com.tencent.mobileqq.richmedia.capture.activity.EditWebDanceMachineVideoActivity;
import dov.com.tencent.mobileqq.richmedia.capture.data.BusinessVideoParam;

public class JumpUtil
{
  private static Intent a(BusinessVideoParam paramBusinessVideoParam, boolean paramBoolean, int paramInt, Context paramContext)
  {
    if ((paramBusinessVideoParam != null) && (paramBusinessVideoParam.jdField_a_of_type_Boolean)) {
      return new Intent(paramContext, EditWebDanceMachineVideoActivity.class);
    }
    if ((paramBoolean) && (paramInt != 0))
    {
      paramBusinessVideoParam = new Intent(paramContext, EditWebVideoActivity.class);
      paramBusinessVideoParam.putExtra("videoId", paramInt);
      return paramBusinessVideoParam;
    }
    return new Intent(paramContext, EditVideoActivity.class);
  }
  
  public static void a(Activity paramActivity, CameraCaptureView.PhotoCaptureResult paramPhotoCaptureResult, CaptureEntranceParams paramCaptureEntranceParams, Bundle paramBundle, int paramInt)
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
    boolean bool1 = localCapturePicParams.a();
    int i = paramCaptureEntranceParams.c;
    int j = localCapturePicParams.c();
    int k = paramCaptureEntranceParams.b();
    int m = localCapturePicParams.a();
    String str = localCapturePicParams.b();
    boolean bool2 = localCapturePicParams.b();
    Object localObject = EditPicActivity.a(paramActivity, paramPhotoCaptureResult.jdField_a_of_type_JavaLangString, true, true, true, bool1, true, bool2, true, true, localCapturePicParams.e(), localCapturePicParams.c(), localCapturePicParams.d(), i, k, j);
    ((Intent)localObject).putExtra("edit_video_call_back", str);
    ((Intent)localObject).putExtra("qcamera_photo_filepath", paramPhotoCaptureResult.jdField_a_of_type_JavaLangString);
    ((Intent)localObject).putExtra("qcamera_rotate", paramPhotoCaptureResult.c);
    ((Intent)localObject).putExtra("camera_type", 103);
    ((Intent)localObject).putExtra("camera_front_back", m);
    ((Intent)localObject).putExtra("camera_capture_method", paramPhotoCaptureResult.jdField_a_of_type_Int);
    ((Intent)localObject).putExtra("state", paramBundle);
    FlowCameraMqqAction.a(paramCaptureEntranceParams.jdField_a_of_type_Int, "", "0X8007818", null);
    paramBundle = localCapturePicParams.a();
    paramCaptureEntranceParams = (CaptureEntranceParams)localObject;
    if (paramBundle != null)
    {
      ((Intent)localObject).putExtra("uin", paramBundle.curFriendUin);
      ((Intent)localObject).putExtra("uintype", paramBundle.curType);
      ((Intent)localObject).putExtra("troop_uin", paramBundle.troopUin);
      ((Intent)localObject).putExtra("uinname", paramBundle.curFriendNick);
      paramCaptureEntranceParams = AIOUtils.a((Intent)localObject, null);
    }
    paramCaptureEntranceParams.putExtra("edit_video_way", paramInt);
    paramCaptureEntranceParams.putExtra("sub_business_id", localCapturePicParams.d());
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
      if (paramPhotoCaptureResult.jdField_a_of_type_Int == 1) {
        paramCaptureEntranceParams.putExtra("editpic_cameratype", 1);
      }
      for (;;)
      {
        paramActivity.startActivityForResult(paramCaptureEntranceParams, 1012);
        FlowCameraMqqAction.a("", "0X80075C1", "", "", "", "");
        return;
        if (paramPhotoCaptureResult.jdField_a_of_type_Int == 0) {
          paramCaptureEntranceParams.putExtra("editpic_cameratype", 2);
        }
      }
    }
  }
  
  public static void a(Activity paramActivity, CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo, CaptureEntranceParams paramCaptureEntranceParams, Bundle paramBundle, int paramInt)
  {
    a(paramActivity, paramVideoCaptureResult, paramLocalMediaInfo, paramCaptureEntranceParams, paramBundle, paramInt, null);
  }
  
  public static void a(Activity paramActivity, CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo, CaptureEntranceParams paramCaptureEntranceParams, Bundle paramBundle1, int paramInt, @Nullable Bundle paramBundle2)
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
    int i;
    if ((localCaptureVideoParams.jdField_c_of_type_Boolean) && (MediaCodecDPC.o()))
    {
      j = -1879047874;
      i = j;
      if (localCaptureVideoParams.a()) {
        i = j | 0x2000;
      }
      j = i;
      if (localCaptureVideoParams.c()) {
        j = i | 0x400000;
      }
      i = j;
      if (localCaptureVideoParams.f()) {
        i = j | 0x20000000;
      }
      j = i;
      if (localCaptureVideoParams.b()) {
        j = i | 0x40000000;
      }
      i = j;
      if (localCaptureVideoParams.d()) {
        i = j | 0x8000000;
      }
      j = i;
      if (localCaptureVideoParams.e()) {
        j = i | 0x20000;
      }
      i = j;
      if (paramCaptureEntranceParams.b() == 102) {
        i = j | 0x1000000;
      }
      if (!MediaCodecDPC.l()) {
        break label830;
      }
    }
    label808:
    label830:
    for (int j = i & 0xFFFFFFDF & 0xFFFFFFFD & 0xFFFFFEFF & 0xFFFFFFEF & 0xFFFFFFFE;; j = i)
    {
      Bundle localBundle = paramBundle2;
      if (paramBundle2 == null) {
        localBundle = new Bundle();
      }
      paramBundle2 = (SessionInfo)paramActivity.getIntent().getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
      if (paramBundle2 != null) {
        localBundle.putParcelable("edit_send_session_info", paramBundle2);
      }
      i = j;
      if (paramBundle2 != null)
      {
        i = j;
        if (a(paramActivity, paramBundle2.jdField_a_of_type_Int))
        {
          i = j | 0x4000;
          localBundle.putInt("curType", paramBundle2.jdField_a_of_type_Int);
          localBundle.putBoolean("sync_story_checked", b(paramActivity, paramBundle2.jdField_a_of_type_Int));
          if (paramBundle2.jdField_a_of_type_Int != 1) {
            break label808;
          }
          paramBundle2 = "1";
          label345:
          StoryReportor.a("aio_shoot", "exp_sync", 0, 0, new String[] { paramBundle2 });
        }
      }
      localBundle.putInt("qq_sub_business_id", localCaptureVideoParams.b());
      localBundle.putInt("entrance_type", paramCaptureEntranceParams.jdField_b_of_type_Int);
      boolean bool = localCaptureVideoParams.g();
      paramVideoCaptureResult = new EditTakeVideoSource(paramVideoCaptureResult.videoMp4FilePath, paramVideoCaptureResult.audioDataFilePath, paramLocalMediaInfo);
      int k = paramCaptureEntranceParams.c;
      int m = localCaptureVideoParams.c();
      VideoEditReport.b(m);
      paramLocalMediaInfo = ((QimMusicPlayer)QIMManager.a().c(8)).b();
      if (paramLocalMediaInfo != null)
      {
        j = i;
        if (paramLocalMediaInfo.d != 2) {}
      }
      else
      {
        j = i | 0x2000000;
      }
      localBundle.putString("video_tag_info", paramActivity.getIntent().getStringExtra("video_tag_info"));
      SegmentKeeper.b(0L);
      paramLocalMediaInfo = new EditVideoParams(k, j, paramVideoCaptureResult, localBundle);
      paramLocalMediaInfo.a.putBoolean("enable_hw_encode", true);
      if (QLog.isColorLevel()) {
        QLog.d("JumpUtil", 2, "EditVideoParams params:" + paramLocalMediaInfo.toString());
      }
      paramLocalMediaInfo.a.putInt("type", localCaptureVideoParams.jdField_a_of_type_Int);
      paramLocalMediaInfo.a.putInt("WebSceneType", localCaptureVideoParams.jdField_b_of_type_Int);
      paramLocalMediaInfo.a.putString("failedUrl", localCaptureVideoParams.jdField_b_of_type_JavaLangString);
      paramLocalMediaInfo.a.putString("succUrl", localCaptureVideoParams.jdField_a_of_type_JavaLangString);
      paramLocalMediaInfo.a.putInt("extra_transiton_src_from", localBundle.getInt("extra_transiton_src_from", -1));
      if ((bool) && (localCaptureVideoParams.a() != 0))
      {
        paramVideoCaptureResult = new Intent(paramActivity, EditWebVideoActivity.class);
        paramVideoCaptureResult.putExtra("videoId", localCaptureVideoParams.a());
      }
      for (;;)
      {
        long l = paramActivity.getIntent().getLongExtra("troop_uin", 0L);
        if (l != 0L) {
          paramLocalMediaInfo.a.putLong("troop_uin", l);
        }
        StoryIntentUtils.a(paramVideoCaptureResult, paramActivity.getIntent().getExtras());
        paramVideoCaptureResult.putExtra("short_video_entrance_type", m);
        paramVideoCaptureResult.putExtra(EditVideoParams.class.getName(), paramLocalMediaInfo);
        paramVideoCaptureResult.putExtra("op_department", "grp_qq");
        paramVideoCaptureResult.putExtra("op_type", "video_edit");
        paramVideoCaptureResult.putExtra("stop_record_time", System.currentTimeMillis());
        paramVideoCaptureResult.putExtra("state", paramBundle1);
        paramVideoCaptureResult.putExtra("edit_video_way", paramInt);
        paramActivity.startActivityForResult(paramVideoCaptureResult, paramCaptureEntranceParams.jdField_a_of_type_Int);
        paramActivity.overridePendingTransition(0, 0);
        return;
        j = 268435775;
        break;
        paramBundle2 = "2";
        break label345;
        paramVideoCaptureResult = new Intent(paramActivity, EditVideoActivity.class);
      }
    }
  }
  
  public static void a(Activity paramActivity, CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo, CaptureEntranceParams paramCaptureEntranceParams, Bundle paramBundle, int paramInt, BusinessVideoParam paramBusinessVideoParam)
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
    int i;
    if ((localCaptureVideoParams.jdField_c_of_type_Boolean) && (MediaCodecDPC.o()))
    {
      j = -1879047874;
      i = j;
      if (localCaptureVideoParams.a()) {
        i = j | 0x2000;
      }
      j = i;
      if (localCaptureVideoParams.c()) {
        j = i | 0x400000;
      }
      i = j;
      if (localCaptureVideoParams.d()) {
        i = j | 0x8000000;
      }
      if (!MediaCodecDPC.l()) {
        break label926;
      }
    }
    label259:
    label926:
    for (int j = i & 0xFFFFFFDF & 0xFFFFFFFD & 0xFFFFFEFF & 0xFFFFFFEF & 0xFFFFFFFE;; j = i)
    {
      Bundle localBundle = new Bundle();
      Object localObject = (SessionInfo)paramActivity.getIntent().getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
      if (localObject != null) {
        localBundle.putParcelable("edit_send_session_info", (Parcelable)localObject);
      }
      i = j;
      if (localObject != null)
      {
        i = j;
        if (a(paramActivity, ((SessionInfo)localObject).jdField_a_of_type_Int))
        {
          i = j | 0x4000;
          localBundle.putInt("curType", ((SessionInfo)localObject).jdField_a_of_type_Int);
          localBundle.putBoolean("sync_story_checked", b(paramActivity, ((SessionInfo)localObject).jdField_a_of_type_Int));
          if (((SessionInfo)localObject).jdField_a_of_type_Int != 1) {
            break label715;
          }
          localObject = "1";
          StoryReportor.a("aio_shoot", "exp_sync", 0, 0, new String[] { localObject });
        }
      }
      localBundle.putInt("qq_sub_business_id", localCaptureVideoParams.b());
      localBundle.putInt("entrance_type", paramCaptureEntranceParams.jdField_b_of_type_Int);
      boolean bool = localCaptureVideoParams.g();
      paramVideoCaptureResult = new EditTakeVideoSource(paramVideoCaptureResult.videoMp4FilePath, paramVideoCaptureResult.audioDataFilePath, paramLocalMediaInfo);
      int k = paramCaptureEntranceParams.c;
      int m = localCaptureVideoParams.c();
      VideoEditReport.b(m);
      paramLocalMediaInfo = ((QimMusicPlayer)QIMManager.a().c(8)).b();
      if (paramLocalMediaInfo != null)
      {
        j = i;
        if (paramLocalMediaInfo.d != 2) {}
      }
      else
      {
        j = i | 0x2000000;
      }
      localBundle.putString("video_tag_info", paramActivity.getIntent().getStringExtra("video_tag_info"));
      paramLocalMediaInfo = a(paramBusinessVideoParam, bool, localCaptureVideoParams.a(), paramActivity);
      if (paramLocalMediaInfo.getComponent().getClassName().equals(EditWebVideoActivity.class.getName()))
      {
        paramLocalMediaInfo.putExtra("videoId", localCaptureVideoParams.a());
        i = j;
      }
      for (;;)
      {
        paramVideoCaptureResult = new EditVideoParams(k, i, paramVideoCaptureResult, localBundle);
        paramVideoCaptureResult.a.putBoolean("enable_hw_encode", true);
        if (QLog.isColorLevel()) {
          QLog.d("JumpUtil", 2, "EditVideoParams params:" + paramVideoCaptureResult.toString());
        }
        paramVideoCaptureResult.a.putInt("type", localCaptureVideoParams.jdField_a_of_type_Int);
        paramVideoCaptureResult.a.putInt("WebSceneType", localCaptureVideoParams.jdField_b_of_type_Int);
        paramVideoCaptureResult.a.putString("failedUrl", localCaptureVideoParams.jdField_b_of_type_JavaLangString);
        paramVideoCaptureResult.a.putString("succUrl", localCaptureVideoParams.jdField_a_of_type_JavaLangString);
        long l = paramActivity.getIntent().getLongExtra("troop_uin", 0L);
        if (l != 0L) {
          paramVideoCaptureResult.a.putLong("troop_uin", l);
        }
        StoryIntentUtils.a(paramLocalMediaInfo, paramActivity.getIntent().getExtras());
        paramLocalMediaInfo.putExtra("short_video_entrance_type", m);
        paramLocalMediaInfo.putExtra(EditVideoParams.class.getName(), paramVideoCaptureResult);
        paramLocalMediaInfo.putExtra("op_department", "grp_qq");
        paramLocalMediaInfo.putExtra("op_type", "video_edit");
        paramLocalMediaInfo.putExtra("stop_record_time", System.currentTimeMillis());
        paramLocalMediaInfo.putExtra("state", paramBundle);
        paramLocalMediaInfo.putExtra("edit_video_way", paramInt);
        SegmentKeeper.b(0L);
        paramActivity.startActivityForResult(paramLocalMediaInfo, paramCaptureEntranceParams.jdField_a_of_type_Int);
        paramActivity.overridePendingTransition(0, 0);
        return;
        j = 268435775;
        break;
        label715:
        localObject = "2";
        break label259;
        i = j;
        if (paramLocalMediaInfo.getComponent().getClassName().equals(EditWebDanceMachineVideoActivity.class.getName()))
        {
          localBundle.putString("dance_machine_score_rate", paramBusinessVideoParam.jdField_a_of_type_JavaLangString);
          localBundle.putInt("dance_machine_score", paramBusinessVideoParam.jdField_a_of_type_Int);
          localBundle.putString("dance_machine_ptv_category", paramBusinessVideoParam.jdField_b_of_type_JavaLangString);
          localBundle.putString("dance_machine_ptv_id", paramBusinessVideoParam.jdField_c_of_type_JavaLangString);
          localBundle.putString("web_share_url", paramBusinessVideoParam.g);
          localBundle.putString("over_percent", paramBusinessVideoParam.f);
          localBundle.putBoolean("shook_head_count", paramBusinessVideoParam.jdField_b_of_type_Boolean);
          localBundle.putInt("shook_head_count_value", paramBusinessVideoParam.jdField_b_of_type_Int);
          localBundle.putBoolean("random_fortune", paramBusinessVideoParam.jdField_c_of_type_Boolean);
          localBundle.putBoolean("fools_day", paramBusinessVideoParam.d);
          j &= 0xF7FFFFFF;
          if ((!paramBusinessVideoParam.jdField_b_of_type_Boolean) && (!paramBusinessVideoParam.jdField_c_of_type_Boolean))
          {
            i = j;
            if (!paramBusinessVideoParam.d) {}
          }
          else
          {
            i = j & 0xFFFFDFFF & 0xFFBFFFFF;
          }
        }
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
      paramActivity.overridePendingTransition(2131034125, 2131034126);
      return;
    }
    paramICameraEntrance.putExtra("main_tab_id", 1);
    paramICameraEntrance.setFlags(335544320);
    paramActivity.startActivity(paramICameraEntrance);
  }
  
  protected static boolean a(Activity paramActivity, int paramInt)
  {
    boolean bool = true;
    if ((paramInt != 1) && (paramInt != 3000)) {
      return false;
    }
    paramActivity = new EditVideoSyncStorySwitchEntry(SharedPreUtils.l(paramActivity));
    if (paramInt == 3000)
    {
      paramActivity = paramActivity.b;
      if ((paramActivity == null) || (!paramActivity.jdField_a_of_type_Boolean)) {
        break label93;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("JumpUtil", 2, "showSyncStoryButton-> " + bool);
      }
      return bool;
      paramActivity = paramActivity.a;
      break;
      label93:
      bool = false;
    }
  }
  
  protected static boolean b(Activity paramActivity, int paramInt)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if ((paramInt != 1) && (paramInt != 3000)) {
      return bool2;
    }
    Object localObject = new EditVideoSyncStorySwitchEntry(SharedPreUtils.l(paramActivity));
    if (paramInt == 3000)
    {
      localObject = ((EditVideoSyncStorySwitchEntry)localObject).b;
      label45:
      if ((localObject == null) || (!((EditVideoSyncStorySwitchEntry.SwitchEntryData)localObject).jdField_c_of_type_Boolean)) {
        break label110;
      }
      bool1 = ((EditVideoSyncStorySwitchEntry.SwitchEntryData)localObject).jdField_b_of_type_Boolean;
    }
    for (;;)
    {
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("JumpUtil", 2, "isSyncStoryButtonChecked ->" + bool1);
      return bool1;
      localObject = ((EditVideoSyncStorySwitchEntry)localObject).a;
      break label45;
      label110:
      if (SharedPreUtils.c(paramActivity)) {
        bool1 = SharedPreUtils.c(paramActivity);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.util.JumpUtil
 * JD-Core Version:    0.7.0.1
 */