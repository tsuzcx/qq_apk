package com.tencent.mobileqq.richmedia.capture.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.richmedia.MediaCodecSendTask;
import com.tencent.mobileqq.activity.richmedia.MediaCodecSendTask.VideoSendPublicParam;
import com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager;
import com.tencent.mobileqq.richmedia.capture.data.DanceMachineVideoParam;
import com.tencent.mobileqq.richmedia.capture.data.TemplateGroupItem;
import com.tencent.mobileqq.richmedia.capture.util.JumpUtil;
import com.tencent.mobileqq.richmedia.capture.util.ReportUtil;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.PhotoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.ProviderContainerView;
import com.tencent.mobileqq.richmedia.mediacodec.utils.ShortVideoExceptionReporter;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class AIOEffectsCameraCaptureFragment
  extends EffectsCameraCaptureFragment
{
  protected int a;
  private AIOEffectsCameraCaptureFragment.Session jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentAIOEffectsCameraCaptureFragment$Session;
  protected CameraCaptureView.VideoCaptureResult a;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private String f;
  private boolean i;
  private boolean j;
  
  public AIOEffectsCameraCaptureFragment()
  {
    this.jdField_a_of_type_Int = 10000;
  }
  
  public static Bundle a(AIOEffectsCameraCaptureFragment.Session paramSession, int paramInt, String paramString, long paramLong, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("ARG_SESSION_INFO", paramSession);
    localBundle.putInt("ARG_EDIT_VIDEO_TYPE", paramInt);
    localBundle.putString("ARG_AIO_CLASS", paramString);
    localBundle.putLong("ARG_BABYQ_ABILITY", paramLong);
    localBundle.putBoolean("ARG_SHOW_GUIDE_VIEW", paramBoolean);
    return localBundle;
  }
  
  public static Bundle a(AIOEffectsCameraCaptureFragment.Session paramSession, int paramInt1, String paramString1, long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("ARG_SESSION_INFO", paramSession);
    localBundle.putInt("ARG_EDIT_VIDEO_TYPE", paramInt1);
    localBundle.putString("ARG_AIO_CLASS", paramString1);
    localBundle.putLong("ARG_BABYQ_ABILITY", paramLong);
    localBundle.putBoolean("ARG_SHOW_GUIDE_VIEW", paramBoolean1);
    localBundle.putBoolean("ARG_UNFOLD_DD", paramBoolean2);
    localBundle.putInt("ARG_DD_CATEGORY_ID", paramInt2);
    localBundle.putString("ARG_DD_ITEM_ID", paramString2);
    return localBundle;
  }
  
  protected void a(AIOEffectsCameraCaptureFragment.Session paramSession, PublishParam paramPublishParam)
  {
    a(paramSession, paramPublishParam, null);
  }
  
  protected void a(AIOEffectsCameraCaptureFragment.Session paramSession, PublishParam paramPublishParam, AIOEffectsCameraCaptureFragment.MediaCodecEditCallback paramMediaCodecEditCallback)
  {
    PtvFilterUtils.a(new File(paramPublishParam.jdField_j_of_type_JavaLangString).getParent(), paramPublishParam.jdField_b_of_type_JavaLangString);
    b(paramSession, paramPublishParam, paramMediaCodecEditCallback);
  }
  
  public void a(CameraCaptureView.PhotoCaptureResult paramPhotoCaptureResult)
  {
    i();
    JumpUtil.a(this, paramPhotoCaptureResult, 2, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentAIOEffectsCameraCaptureFragment$Session, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a(), this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_Long);
  }
  
  protected void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult = paramVideoCaptureResult;
    a(paramLocalMediaInfo);
    DanceMachineVideoParam localDanceMachineVideoParam = new DanceMachineVideoParam();
    localDanceMachineVideoParam.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    localDanceMachineVideoParam.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    localDanceMachineVideoParam.jdField_a_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    localDanceMachineVideoParam.g = this.e;
    localDanceMachineVideoParam.f = this.jdField_d_of_type_JavaLangString;
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = CapturePtvTemplateManager.a().a();
    if (localPtvTemplateInfo != null)
    {
      TemplateGroupItem localTemplateGroupItem = CapturePtvTemplateManager.a().a(localPtvTemplateInfo.categoryId);
      if (localTemplateGroupItem != null)
      {
        localDanceMachineVideoParam.jdField_b_of_type_JavaLangString = localTemplateGroupItem.jdField_a_of_type_JavaLangString;
        localDanceMachineVideoParam.jdField_c_of_type_JavaLangString = localPtvTemplateInfo.id;
      }
    }
    else
    {
      JumpUtil.a(this, paramVideoCaptureResult, paramLocalMediaInfo, a(true), 2, this.jdField_a_of_type_Int, 0, null, localDanceMachineVideoParam, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentAIOEffectsCameraCaptureFragment$Session);
      return;
    }
    throw new IllegalStateException();
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  protected void b(AIOEffectsCameraCaptureFragment.Session paramSession, PublishParam paramPublishParam, AIOEffectsCameraCaptureFragment.MediaCodecEditCallback paramMediaCodecEditCallback)
  {
    MediaCodecSendTask.VideoSendPublicParam localVideoSendPublicParam = new MediaCodecSendTask.VideoSendPublicParam();
    localVideoSendPublicParam.jdField_a_of_type_AndroidAppActivity = getActivity();
    localVideoSendPublicParam.jdField_a_of_type_JavaLangString = new File(paramPublishParam.jdField_j_of_type_JavaLangString).getParent();
    localVideoSendPublicParam.jdField_b_of_type_JavaLangString = paramPublishParam.k;
    int k;
    if (paramPublishParam.f <= 5)
    {
      k = paramPublishParam.f;
      localVideoSendPublicParam.jdField_a_of_type_Int = k;
      localVideoSendPublicParam.jdField_c_of_type_JavaLangString = paramPublishParam.jdField_j_of_type_JavaLangString;
      localVideoSendPublicParam.f = paramPublishParam.jdField_c_of_type_JavaLangString;
      localVideoSendPublicParam.jdField_c_of_type_Int = 0;
      localVideoSendPublicParam.jdField_d_of_type_Int = 0;
      localVideoSendPublicParam.k = paramPublishParam.jdField_b_of_type_JavaLangString;
      localVideoSendPublicParam.l = paramPublishParam.m;
      localVideoSendPublicParam.m = paramPublishParam.n;
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult != null) {
        break label250;
      }
      ShortVideoExceptionReporter.a(new RuntimeException("videoCaptureResult == null"));
      QLog.e("AIOEffectsCameraCaptureFragment", 2, "videoCaptureResult == null");
      localVideoSendPublicParam.i = 0;
      label157:
      localVideoSendPublicParam.jdField_j_of_type_Int = ((int)paramPublishParam.jdField_a_of_type_Long);
      if (this.jdField_a_of_type_Int == 10007) {
        localVideoSendPublicParam.jdField_d_of_type_Boolean = true;
      }
      paramPublishParam = "";
      if (paramSession == null) {
        break label265;
      }
      paramPublishParam = paramSession.curFriendUin;
      k = paramSession.curType;
      paramSession = paramSession.troopUin;
    }
    for (;;)
    {
      localVideoSendPublicParam.jdField_d_of_type_JavaLangString = paramPublishParam;
      localVideoSendPublicParam.jdField_b_of_type_Int = k;
      localVideoSendPublicParam.e = paramSession;
      new MediaCodecSendTask(localVideoSendPublicParam, paramMediaCodecEditCallback).execute(new Void[0]);
      return;
      k = 0;
      break;
      label250:
      localVideoSendPublicParam.i = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.videoFrameCount;
      break label157;
      label265:
      String str = "";
      k = 0;
      paramSession = paramPublishParam;
      paramPublishParam = str;
    }
  }
  
  protected void d()
  {
    super.d();
    if ((b() == 10000) && (this.j))
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView.a(102, this.jdField_c_of_type_Int, this.f);
      PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = CapturePtvTemplateManager.a().a();
      if (localPtvTemplateInfo != null)
      {
        com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil.jdField_b_of_type_JavaLangString = localPtvTemplateInfo.categoryId + "";
        com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil.jdField_c_of_type_JavaLangString = localPtvTemplateInfo.id;
        com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil.a = localPtvTemplateInfo.hasGesture();
        if (localPtvTemplateInfo.kind != 3) {
          break label103;
        }
      }
    }
    label103:
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil.jdField_b_of_type_Boolean = bool;
      return;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing())) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            ReportUtil.a(localFragmentActivity, paramInt1, paramInt2);
            switch (paramInt1)
            {
            default: 
              return;
            }
            if (QLog.isColorLevel()) {
              QLog.d("AIOEffectsCameraCaptureFragment", 2, "aio onActivityResult:requestCode=" + paramInt1 + "  resultCode=" + paramInt2);
            }
            if (paramInt2 != -1) {
              break;
            }
          } while (paramIntent == null);
          paramIntent = (PublishParam)paramIntent.getParcelableExtra(PublishParam.jdField_a_of_type_JavaLangString);
        } while (paramIntent == null);
        localObject = (ViewGroup)getView();
        if (localObject != null) {
          ((ViewGroup)localObject).removeAllViews();
        }
      } while (paramIntent.jdField_j_of_type_Int != 1);
      Object localObject = paramIntent.jdField_c_of_type_JavaLangString;
      if (QLog.isColorLevel())
      {
        QLog.d("AIOEffectsCameraCaptureFragment", 2, "hwEncodeVideo videoMergeThumbPath =" + (String)localObject);
        QLog.d("AIOEffectsCameraCaptureFragment", 2, "publishParam =" + paramIntent.toString());
      }
      localFragmentActivity.getIntent().putExtra("ab_test_send_btn_click_time", SystemClock.uptimeMillis());
      a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentAIOEffectsCameraCaptureFragment$Session, paramIntent);
      return;
    } while (paramInt2 != 0);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Bundle localBundle = getArguments();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentAIOEffectsCameraCaptureFragment$Session = ((AIOEffectsCameraCaptureFragment.Session)localBundle.getSerializable("ARG_SESSION_INFO"));
    this.jdField_a_of_type_Int = localBundle.getInt("ARG_EDIT_VIDEO_TYPE", 10000);
    this.jdField_a_of_type_JavaLangString = localBundle.getString("ARG_AIO_CLASS");
    this.jdField_c_of_type_Long = localBundle.getLong("ARG_BABYQ_ABILITY", 0L);
    this.i = localBundle.getBoolean("ARG_SHOW_GUIDE_VIEW", false);
    this.j = localBundle.getBoolean("ARG_UNFOLD_DD", false);
    this.jdField_c_of_type_Int = localBundle.getInt("ARG_DD_CATEGORY_ID");
    this.f = localBundle.getString("ARG_DD_ITEM_ID");
    if (paramBundle != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult = ((CameraCaptureView.VideoCaptureResult)paramBundle.getSerializable("KEY_VIDEO_RESULT"));
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putSerializable("KEY_VIDEO_RESULT", this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.fragment.AIOEffectsCameraCaptureFragment
 * JD-Core Version:    0.7.0.1
 */