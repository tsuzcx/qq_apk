package com.tencent.mobileqq.richmedia.capture.fragment;

import ahov;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.richmedia.FlowComponentInterface;
import com.tencent.mobileqq.activity.richmedia.MediaCodecSendTask;
import com.tencent.mobileqq.activity.richmedia.MediaCodecSendTask.VideoSendPublicParam;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.ProviderContainerView;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import java.io.File;
import java.util.ArrayList;

public class QuickShootEffectsCameraCaptureFragment
  extends AIOEffectsCameraCaptureFragment
{
  private int c;
  private String e;
  private boolean i;
  
  private void a(Activity paramActivity)
  {
    AppInterface localAppInterface = ((BaseActivity)paramActivity).getAppInterface();
    Intent localIntent = new Intent();
    localIntent.putExtra("newflag", true);
    localIntent.putExtra("refer", "schemeActiveFeeds");
    QzonePluginProxyActivity.a(localIntent, "com.qzone.feed.ui.activity.QZoneFriendFeedActivity");
    localIntent.addFlags(805306368);
    QZoneHelper.c(paramActivity, localAppInterface.getCurrentAccountUin(), localIntent, -1);
  }
  
  public int a()
  {
    return 10004;
  }
  
  protected void a(SessionInfo paramSessionInfo, PublishParam paramPublishParam, FlowComponentInterface paramFlowComponentInterface, String paramString1, int paramInt, ArrayList paramArrayList, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
  {
    PtvFilterUtils.a(new File(paramPublishParam.jdField_j_of_type_JavaLangString).getParent(), paramPublishParam.jdField_b_of_type_JavaLangString);
    b(paramSessionInfo, paramPublishParam, paramFlowComponentInterface, paramString1, paramInt, paramArrayList, paramBoolean1, paramString2, paramBoolean2);
  }
  
  protected void b(SessionInfo paramSessionInfo, PublishParam paramPublishParam, FlowComponentInterface paramFlowComponentInterface, String paramString1, int paramInt, ArrayList paramArrayList, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
  {
    MediaCodecSendTask.VideoSendPublicParam localVideoSendPublicParam = new MediaCodecSendTask.VideoSendPublicParam();
    localVideoSendPublicParam.jdField_a_of_type_AndroidAppActivity = getActivity();
    localVideoSendPublicParam.jdField_a_of_type_JavaLangString = new File(paramPublishParam.jdField_j_of_type_JavaLangString).getParent();
    localVideoSendPublicParam.jdField_b_of_type_JavaLangString = paramPublishParam.k;
    int j;
    if (paramPublishParam.f <= 5)
    {
      j = paramPublishParam.f;
      localVideoSendPublicParam.jdField_a_of_type_Int = j;
      localVideoSendPublicParam.jdField_c_of_type_JavaLangString = paramPublishParam.jdField_j_of_type_JavaLangString;
      localVideoSendPublicParam.f = paramPublishParam.jdField_c_of_type_JavaLangString;
      localVideoSendPublicParam.jdField_c_of_type_Int = 0;
      localVideoSendPublicParam.jdField_d_of_type_Int = 0;
      localVideoSendPublicParam.k = paramPublishParam.jdField_b_of_type_JavaLangString;
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult != null) {
        localVideoSendPublicParam.i = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.videoFrameCount;
      }
      localVideoSendPublicParam.jdField_j_of_type_Int = ((int)paramPublishParam.jdField_a_of_type_Long);
      localVideoSendPublicParam.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface = paramFlowComponentInterface;
      localVideoSendPublicParam.g = paramString1;
      localVideoSendPublicParam.jdField_e_of_type_Int = paramInt;
      localVideoSendPublicParam.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
      localVideoSendPublicParam.jdField_a_of_type_Boolean = paramBoolean1;
      localVideoSendPublicParam.jdField_j_of_type_JavaLangString = paramString2;
      localVideoSendPublicParam.jdField_b_of_type_Boolean = paramBoolean2;
      paramPublishParam = "";
      if (paramSessionInfo == null) {
        break label249;
      }
      paramPublishParam = paramSessionInfo.jdField_a_of_type_JavaLangString;
      paramInt = paramSessionInfo.jdField_a_of_type_Int;
      paramSessionInfo = paramSessionInfo.jdField_b_of_type_JavaLangString;
    }
    for (;;)
    {
      localVideoSendPublicParam.jdField_d_of_type_JavaLangString = paramPublishParam;
      localVideoSendPublicParam.jdField_b_of_type_Int = paramInt;
      localVideoSendPublicParam.jdField_e_of_type_JavaLangString = paramSessionInfo;
      new MediaCodecSendTask(localVideoSendPublicParam).execute(new Void[0]);
      return;
      j = 0;
      break;
      label249:
      paramFlowComponentInterface = "";
      paramInt = 0;
      paramSessionInfo = paramPublishParam;
      paramPublishParam = paramFlowComponentInterface;
    }
  }
  
  protected void d()
  {
    super.d();
    if (this.i)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView.a(102, this.jdField_c_of_type_Int, this.jdField_e_of_type_JavaLangString);
      PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = CapturePtvTemplateManager.a().a();
      if (localPtvTemplateInfo != null)
      {
        com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil.jdField_b_of_type_JavaLangString = localPtvTemplateInfo.categoryId + "";
        com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil.jdField_c_of_type_JavaLangString = localPtvTemplateInfo.id;
        com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil.jdField_a_of_type_Boolean = localPtvTemplateInfo.hasGesture();
        if (localPtvTemplateInfo.kind != 3) {
          break label93;
        }
      }
    }
    label93:
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
    label107:
    do
    {
      do
      {
        return;
        switch (paramInt1)
        {
        default: 
          return;
        }
      } while ((paramInt2 != -1) || (paramIntent == null));
      paramInt1 = paramIntent.getIntExtra("forward_to_someplace_from_shoot_quick", 0);
      if (paramInt1 != 1002) {
        break;
      }
      a(localFragmentActivity);
      paramIntent.putExtra("open_leba_tab_fragment", true);
      localFragmentActivity.setResult(-1, paramIntent);
      localFragmentActivity.finish();
    } while (!paramIntent.getBooleanExtra("go_publish_activity", false));
    Object localObject2 = paramIntent.getStringExtra("key_content");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    paramInt1 = paramIntent.getIntExtra("key_priv", 1);
    localObject2 = (ArrayList)paramIntent.getSerializableExtra("key_priv_uin_list");
    if (localObject2 == null) {
      localObject2 = new ArrayList();
    }
    for (;;)
    {
      paramInt2 = paramIntent.getIntExtra("key_font_id", -1);
      int j = paramIntent.getIntExtra("key_font_format_type", 0);
      Object localObject3 = paramIntent.getStringExtra("key_font_url");
      int k = paramIntent.getIntExtra("key_super_font_id", -1);
      String str = paramIntent.getStringExtra("key_super_font_info");
      QZoneHelper.a((String)localObject1, paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS"), paramInt1, (ArrayList)localObject2, paramInt2, j, (String)localObject3, false, k, str);
      localFragmentActivity.finish();
      return;
      if (paramInt1 != 1003) {
        break label107;
      }
      localObject1 = ((PublishParam)paramIntent.getParcelableExtra(PublishParam.jdField_a_of_type_JavaLangString)).jdField_c_of_type_JavaLangString;
      localObject2 = new Intent(localFragmentActivity, QQStoryMainActivity.class);
      ((Intent)localObject2).putExtra("new_video_extra_info", (String)localObject1);
      localFragmentActivity.startActivity((Intent)localObject2);
      localFragmentActivity.finish();
      break label107;
      if ((paramInt2 != -1) || (paramIntent == null)) {
        break;
      }
      localObject3 = (PublishParam)paramIntent.getParcelableExtra(PublishParam.jdField_a_of_type_JavaLangString);
      if (localObject3 == null) {
        break;
      }
      localObject1 = (ViewGroup)getView();
      if (localObject1 != null) {
        ((ViewGroup)localObject1).removeAllViews();
      }
      if (((PublishParam)localObject3).jdField_j_of_type_Int != 1) {
        break;
      }
      localObject1 = ((PublishParam)localObject3).jdField_c_of_type_JavaLangString;
      if (QLog.isColorLevel())
      {
        QLog.d("AIOEffectsCameraCaptureFragment", 2, "hwEncodeVideo videoMergeThumbPath =" + (String)localObject1);
        QLog.d("AIOEffectsCameraCaptureFragment", 2, "publishParam =" + ((PublishParam)localObject3).toString());
      }
      localFragmentActivity.getIntent().putExtra("ab_test_send_btn_click_time", SystemClock.uptimeMillis());
      paramInt1 = paramIntent.getIntExtra("forward_to_someplace_from_shoot_quick", 0);
      if (paramInt1 == 1002)
      {
        a(localFragmentActivity);
        localObject2 = paramIntent.getStringExtra("forward_source_to_qzone");
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label741;
        }
        localObject1 = paramIntent.getStringExtra("set_user_callback");
        if (localObject1 == null) {
          break;
        }
      }
      for (;;)
      {
        try
        {
          localObject1 = Class.forName((String)localObject1).newInstance();
          if (!(localObject1 instanceof FlowComponentInterface)) {
            break label735;
          }
          localObject1 = (FlowComponentInterface)localObject1;
          ((FlowComponentInterface)localObject1).c_((String)localObject2);
          a(null, (PublishParam)localObject3, (FlowComponentInterface)localObject1, paramIntent.getStringExtra("key_content"), 1, null, paramIntent.getBooleanExtra("forward_to_qzone_to_enable_edit", false), null, false);
          return;
        }
        catch (Throwable localThrowable)
        {
          localObject2 = null;
          localObject1 = localObject2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("AIOEffectsCameraCaptureFragment", 2, "initComponentParamData:exp =" + localThrowable);
          localObject1 = localObject2;
          continue;
        }
        if (paramInt1 == 1003)
        {
          paramIntent = new Intent(localThrowable, QQStoryMainActivity.class);
          paramIntent.putExtra("new_video_extra_info", (String)localObject1);
          localThrowable.startActivity(paramIntent);
          localThrowable.finish();
          return;
        }
        localObject1 = (SessionInfo)paramIntent.getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
        if (localObject1 != null) {}
        for (localObject1 = new AIOEffectsCameraCaptureFragment.Session(((SessionInfo)localObject1).jdField_a_of_type_JavaLangString, ((SessionInfo)localObject1).jdField_d_of_type_JavaLangString, ((SessionInfo)localObject1).jdField_a_of_type_Int, ((SessionInfo)localObject1).jdField_b_of_type_JavaLangString);; localObject1 = null)
        {
          a((AIOEffectsCameraCaptureFragment.Session)localObject1, (PublishParam)localObject3, new ahov(this, localThrowable, paramIntent));
          return;
        }
        label735:
        localObject1 = null;
        continue;
        label741:
        localObject1 = null;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    this.i = paramBundle.getBoolean("ARG_UNFOLD_DD", false);
    this.jdField_c_of_type_Int = paramBundle.getInt("ARG_DD_CATEGORY_ID");
    this.jdField_e_of_type_JavaLangString = paramBundle.getString("ARG_DD_ITEM_ID");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.fragment.QuickShootEffectsCameraCaptureFragment
 * JD-Core Version:    0.7.0.1
 */