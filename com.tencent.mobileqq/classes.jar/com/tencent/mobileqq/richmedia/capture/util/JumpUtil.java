package com.tencent.mobileqq.richmedia.capture.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.takevideo.EditPicActivity;
import com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import com.tencent.biz.qqstory.takevideo.EditVideoActivity;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditWebDanceMachineVideoActivity;
import com.tencent.biz.qqstory.takevideo.EditWebVideoActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraReporter;
import com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager;
import com.tencent.mobileqq.richmedia.capture.data.DanceMachineVideoParam;
import com.tencent.mobileqq.richmedia.capture.data.VideoBusinessParam;
import com.tencent.mobileqq.richmedia.capture.fragment.AIOEffectsCameraCaptureFragment.Session;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.PhotoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.tribe.fragment.TribeEffectsCameraCaptureFragment;
import com.tencent.qphone.base.util.QLog;

public class JumpUtil
{
  public static void a(Fragment paramFragment, CameraCaptureView.PhotoCaptureResult paramPhotoCaptureResult, int paramInt1, int paramInt2, AIOEffectsCameraCaptureFragment.Session paramSession, int paramInt3, String paramString, long paramLong)
  {
    a(paramFragment, paramPhotoCaptureResult, paramInt1, paramInt2, paramSession, paramInt3, paramString, paramLong, 1, null);
  }
  
  public static void a(Fragment paramFragment, CameraCaptureView.PhotoCaptureResult paramPhotoCaptureResult, int paramInt1, int paramInt2, AIOEffectsCameraCaptureFragment.Session paramSession, int paramInt3, String paramString1, long paramLong, int paramInt4, String paramString2)
  {
    Object localObject = paramFragment.getActivity();
    if ((localObject == null) || (((Activity)localObject).isFinishing())) {
      return;
    }
    int i = 1;
    int j;
    switch (paramInt2)
    {
    default: 
      j = 0;
      if (paramSession != null) {
        j = paramSession.curType;
      }
      switch (j)
      {
      default: 
        j = 11;
        label116:
        localObject = EditPicActivity.a((Activity)localObject, paramPhotoCaptureResult.jdField_a_of_type_JavaLangString, true, true, true, true, true, paramInt1, j, i);
        ((Intent)localObject).putExtra("shareto_web_mode", paramInt4);
        ((Intent)localObject).putExtra("edit_video_call_back", paramString2);
        ((Intent)localObject).putExtra("qcamera_photo_filepath", paramPhotoCaptureResult.jdField_a_of_type_JavaLangString);
        ((Intent)localObject).putExtra("qcamera_rotate", paramPhotoCaptureResult.c);
        if (paramInt3 == 2)
        {
          paramInt1 = 0;
          label189:
          ((Intent)localObject).putExtra("camera_type", 103);
          ((Intent)localObject).putExtra("camera_front_back", paramInt1);
          ((Intent)localObject).putExtra("camera_capture_method", paramPhotoCaptureResult.jdField_a_of_type_Int);
          ((Intent)localObject).putExtra("babyq_ability", paramLong);
          FlowCameraMqqAction.a(paramInt2, "", "0X8007818", null);
          paramString2 = (String)localObject;
          if (paramSession != null)
          {
            ((Intent)localObject).putExtra("uin", paramSession.curFriendUin);
            ((Intent)localObject).putExtra("uintype", paramSession.curType);
            ((Intent)localObject).putExtra("troop_uin", paramSession.troopUin);
            ((Intent)localObject).putExtra("uinname", paramSession.curFriendNick);
            paramString2 = AIOUtils.a((Intent)localObject, null);
          }
          if (paramInt2 == 10004) {
            paramString2.putExtra("sub_business_id", 101);
          }
          paramSession = SplashActivity.class.getName();
          if ((paramString1 == null) || (!paramString1.equals(ChatActivity.class.getName()))) {
            break label475;
          }
        }
        break;
      }
      break;
    }
    for (;;)
    {
      NewFlowCameraReporter.a("finish");
      NewFlowCameraReporter.a(paramString2);
      paramString2.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", paramString1);
      if (paramPhotoCaptureResult.jdField_a_of_type_Int == 1) {
        paramString2.putExtra("editpic_cameratype", 1);
      }
      for (;;)
      {
        paramFragment.startActivityForResult(paramString2, 1012);
        FlowCameraMqqAction.a("", "0X80075C1", "", "", "", "");
        return;
        i = 1;
        break;
        i = 2;
        break;
        i = 3;
        break;
        j = 11;
        break label116;
        j = 9;
        break label116;
        j = 10;
        break label116;
        paramInt1 = 1;
        break label189;
        if (paramPhotoCaptureResult.jdField_a_of_type_Int == 0) {
          paramString2.putExtra("editpic_cameratype", 2);
        }
      }
      label475:
      paramString1 = paramSession;
    }
  }
  
  public static void a(Fragment paramFragment, CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, String paramString, VideoBusinessParam paramVideoBusinessParam, AIOEffectsCameraCaptureFragment.Session paramSession)
  {
    FragmentActivity localFragmentActivity = paramFragment.getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing())) {
      return;
    }
    if (paramInt1 == 2) {}
    for (int i = 3181;; i = 1133)
    {
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("enable_hw_encode", true);
      int j = CapturePtvTemplateManager.a().b();
      if (j == 3)
      {
        localBundle.putInt("ptv_template_kind", j);
        if ((paramVideoBusinessParam instanceof DanceMachineVideoParam))
        {
          DanceMachineVideoParam localDanceMachineVideoParam = (DanceMachineVideoParam)paramVideoBusinessParam;
          localBundle.putInt("dance_machine_score", localDanceMachineVideoParam.jdField_a_of_type_Int);
          localBundle.putString("dance_machine_score_rate", localDanceMachineVideoParam.jdField_a_of_type_JavaLangString);
          localBundle.putInt("dance_machine_score", localDanceMachineVideoParam.jdField_a_of_type_Int);
          localBundle.putString("dance_machine_ptv_category", localDanceMachineVideoParam.b);
          localBundle.putString("dance_machine_ptv_id", localDanceMachineVideoParam.c);
          localBundle.putString("web_share_url", localDanceMachineVideoParam.g);
          localBundle.putString("over_percent", localDanceMachineVideoParam.f);
        }
      }
      if (paramArrayOfByte != null) {
        localBundle.putByteArray("extra_subtile_data", paramArrayOfByte);
      }
      VideoEditReport.b(1);
      if (paramInt2 == 10003)
      {
        j = 0;
        switch (CodecParam.o)
        {
        default: 
          localBundle.putInt("audio_samplerate", CodecParam.q);
          localBundle.putInt("audio_channel", j);
          i = (i | 0x200) & 0xFFFFFFDF;
        }
      }
      for (;;)
      {
        label290:
        int i1 = 0;
        int k = i1;
        int m = i;
        j = paramInt1;
        label495:
        int n;
        switch (paramInt2)
        {
        default: 
          j = paramInt1;
          m = i;
          k = i1;
        case 10001: 
        case 10002: 
        case 10005: 
        case 10006: 
        case 10000: 
        case 10004: 
          for (;;)
          {
            paramArrayOfByte = new EditVideoParams(j, m, new EditTakeVideoSource(paramVideoCaptureResult.videoMp4FilePath, paramVideoCaptureResult.audioDataFilePath, paramLocalMediaInfo), localBundle);
            if (paramLocalMediaInfo.redBagType == LocalMediaInfo.REDBAG_TYPE_GET) {
              paramArrayOfByte.a.putInt("video_redbag_get", paramLocalMediaInfo.redBagType);
            }
            paramArrayOfByte.a.putInt("special_video_type", paramLocalMediaInfo.specialVideoType);
            if (QLog.isColorLevel()) {
              QLog.d("JumpUtil", 2, "EditVideoParams params:" + paramArrayOfByte.toString());
            }
            if (k == 0) {
              break label1040;
            }
            paramVideoCaptureResult = new Intent(localFragmentActivity, EditWebVideoActivity.class);
            paramVideoCaptureResult.putExtra("edit_video_call_back", paramString);
            if (paramSession == null) {
              break label1091;
            }
            paramVideoCaptureResult.putExtra("uin", paramSession.curFriendUin);
            paramVideoCaptureResult.putExtra("uintype", paramSession.curType);
            paramVideoCaptureResult.putExtra("troop_uin", paramSession.troopUin);
            paramVideoCaptureResult.putExtra("uinname", paramSession.curFriendNick);
            paramVideoCaptureResult = AIOUtils.a(paramVideoCaptureResult, null);
            if ((paramFragment instanceof TribeEffectsCameraCaptureFragment))
            {
              paramVideoCaptureResult.putExtra("needTheme", ((TribeEffectsCameraCaptureFragment)paramFragment).i);
              paramVideoCaptureResult.putExtra("from", ((TribeEffectsCameraCaptureFragment)paramFragment).jdField_a_of_type_JavaLangString);
              paramVideoCaptureResult.putExtra("theme_id", ((TribeEffectsCameraCaptureFragment)paramFragment).c);
              paramVideoCaptureResult.putExtra("theme_name", ((TribeEffectsCameraCaptureFragment)paramFragment).f);
            }
            paramVideoCaptureResult.putExtra(EditVideoParams.class.getName(), paramArrayOfByte);
            paramVideoCaptureResult.putExtra("op_department", "grp_qq");
            paramVideoCaptureResult.putExtra("op_type", "video_edit");
            paramVideoCaptureResult.putExtra("stop_record_time", System.currentTimeMillis());
            paramFragment.startActivityForResult(paramVideoCaptureResult, paramInt2);
            localFragmentActivity.overridePendingTransition(0, 0);
            return;
            j = 1;
            break;
            j = 2;
            break;
            if ((paramInt2 == 10012) && ((paramFragment instanceof TribeEffectsCameraCaptureFragment)))
            {
              j = i;
              if (!((TribeEffectsCameraCaptureFragment)paramFragment).j) {
                j = i & 0xFFFFFFFE;
              }
              i = j;
              if (!((TribeEffectsCameraCaptureFragment)paramFragment).k) {
                i = j & 0xFFFFFFFB;
              }
              if (paramLocalMediaInfo.mDuration <= 10000L)
              {
                j = i;
                if (paramLocalMediaInfo.mTotalDuration <= 10000L) {
                  break label1104;
                }
              }
              localBundle.putBoolean("extra_enable_revert", false);
              localBundle.putBoolean("extra_enable_slow", false);
              break label290;
            }
            j = i;
            if (paramInt2 != 10013) {
              break label1104;
            }
            i &= 0xFFFFFFFE;
            break label290;
            j = 2;
            k = i1;
            m = i;
            continue;
            j = 2;
            localBundle.putInt("qq_sub_business_id", 101);
            k = i1;
            m = i;
          }
        case 10007: 
          label554:
          n = 6;
          if ((paramVideoBusinessParam instanceof DanceMachineVideoParam))
          {
            paramArrayOfByte = (DanceMachineVideoParam)paramVideoBusinessParam;
            if (paramArrayOfByte.jdField_a_of_type_Boolean)
            {
              localBundle.putInt("qq_sub_business_id", 106);
              localBundle.putString("dance_machine_score_rate", paramArrayOfByte.jdField_a_of_type_JavaLangString);
              localBundle.putInt("dance_machine_score", paramArrayOfByte.jdField_a_of_type_Int);
              localBundle.putString("dance_machine_ptv_category", paramArrayOfByte.b);
              localBundle.putString("dance_machine_ptv_id", paramArrayOfByte.c);
              localBundle.putString("web_share_url", paramArrayOfByte.g);
              localBundle.putString("over_percent", paramArrayOfByte.f);
              paramInt3 = 1024;
              paramInt1 = 0;
            }
          }
          break;
        }
        for (;;)
        {
          k = paramInt1;
          m = paramInt3;
          j = n;
          break;
          if (paramInt3 == 0)
          {
            paramInt1 = 1;
            paramInt3 = i;
            continue;
            k = i1;
            m = i;
            j = n;
            if (paramInt3 != 0) {
              break;
            }
            k = 1;
            m = i;
            j = n;
            break;
            j = 5;
            k = i1;
            m = i;
            break;
            label1040:
            if (((paramVideoBusinessParam instanceof DanceMachineVideoParam)) && (((DanceMachineVideoParam)paramVideoBusinessParam).jdField_a_of_type_Boolean))
            {
              paramVideoCaptureResult = new Intent(localFragmentActivity, EditWebDanceMachineVideoActivity.class);
              break label495;
            }
            paramVideoCaptureResult = new Intent(localFragmentActivity, EditVideoActivity.class);
            break label495;
            label1091:
            break label554;
          }
          paramInt1 = 0;
          paramInt3 = i;
        }
        label1104:
        i = j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.util.JumpUtil
 * JD-Core Version:    0.7.0.1
 */