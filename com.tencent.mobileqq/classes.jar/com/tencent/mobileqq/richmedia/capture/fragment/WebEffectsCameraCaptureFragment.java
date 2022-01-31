package com.tencent.mobileqq.richmedia.capture.fragment;

import agwi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCameraCaptureActivity;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverVideoActivity;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.richmedia.FlowComponentInterface;
import com.tencent.mobileqq.activity.richmedia.MediaCodecSendTask;
import com.tencent.mobileqq.activity.richmedia.MediaCodecSendTask.VideoSendPublicParam;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager;
import com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager;
import com.tencent.mobileqq.richmedia.capture.data.DanceMachineVideoParam;
import com.tencent.mobileqq.richmedia.capture.data.FilterCategoryItem;
import com.tencent.mobileqq.richmedia.capture.data.TemplateGroupItem;
import com.tencent.mobileqq.richmedia.capture.data.VideoBusinessParam;
import com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.mobileqq.richmedia.capture.util.JumpUtil;
import com.tencent.mobileqq.richmedia.capture.util.ReportBadCase;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureButtonLayout;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.CaptureParam;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.PhotoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.ProviderContainerView;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import java.io.File;
import java.util.ArrayList;

public class WebEffectsCameraCaptureFragment
  extends AIOEffectsCameraCaptureFragment
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new agwi(this);
  private View jdField_a_of_type_AndroidViewView;
  private String jdField_a_of_type_JavaLangString;
  private int c;
  private int d;
  private String f;
  private String g;
  private String h;
  private String jdField_i_of_type_JavaLangString;
  private boolean jdField_i_of_type_Boolean;
  private String jdField_j_of_type_JavaLangString;
  private boolean jdField_j_of_type_Boolean;
  private String jdField_k_of_type_JavaLangString;
  private boolean jdField_k_of_type_Boolean;
  private String jdField_l_of_type_JavaLangString;
  private boolean jdField_l_of_type_Boolean;
  private boolean m;
  private boolean n;
  private boolean o;
  private boolean p;
  private boolean q;
  
  public static Bundle a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, String paramString1, String paramString2, boolean paramBoolean6, boolean paramBoolean7, String paramString3, String paramString4, boolean paramBoolean8, int paramInt2, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("ARG_SUPPORT_VIDEO", paramBoolean1);
    localBundle.putBoolean("ARG_SUPPORT_PHOTO", paramBoolean2);
    localBundle.putInt("ARG_CAMERA_MODE", paramInt1);
    localBundle.putBoolean("ARG_BEAUTY", paramBoolean3);
    localBundle.putBoolean("ARG_SUPPORT_DD", paramBoolean4);
    localBundle.putBoolean("ARG_UNFOLD_DD", paramBoolean5);
    localBundle.putString("ARG_DD_CATEGORY_NAME", paramString1);
    localBundle.putString("ARG_DD_ITEM_ID", paramString2);
    localBundle.putBoolean("ARG_SUPPORT_FILTER", paramBoolean6);
    localBundle.putBoolean("ARG_UNFOLD_FILTER", paramBoolean7);
    localBundle.putString("ARG_FILTER_CATEGORY_NAME", paramString3);
    localBundle.putString("ARG_FILTER_ITEM_ID", paramString4);
    localBundle.putInt("ARG_DEAL_TYPE", paramInt2);
    localBundle.putString("ARG_ACTIVITY_ID", paramString6);
    localBundle.putString("ARG_ACTIVITY_TYPE", paramString5);
    localBundle.putString("ARG_WEB_CALLBACK", paramString7);
    localBundle.putBoolean("ARG_SUPPORT_SUBTITLE", paramBoolean8);
    localBundle.putString("ARG_CALLER_TYPE", paramString8);
    localBundle.putString("arg_topic_id", paramString9);
    localBundle.putString("arg_topic_name", paramString10);
    localBundle.putString("arg_ad_tag", paramString11);
    localBundle.putString("arg_callback", paramString7);
    return localBundle;
  }
  
  private void a(Activity paramActivity)
  {
    AppInterface localAppInterface = ((BaseActivity)paramActivity).getAppInterface();
    Intent localIntent = new Intent();
    localIntent.putExtra("newflag", true);
    localIntent.putExtra("refer", "schemeActiveFeeds");
    QzonePluginProxyActivity.a(localIntent, "com.qzone.feed.ui.activity.QZoneFriendFeedActivity");
    localIntent.addFlags(805306368);
    QZoneHelper.b(paramActivity, localAppInterface.getCurrentAccountUin(), localIntent, -1);
  }
  
  private void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOEffectsCameraCaptureFragment", 2, "jumpToKandianVideoUploadActivity result: " + paramVideoCaptureResult.toString() + ", localMediaInfo: " + paramLocalMediaInfo.toString() + ", coverPath:" + paramString);
    }
    Intent localIntent = new Intent(getActivity(), ReadInJoyDeliverVideoActivity.class);
    localIntent.putExtras(getArguments());
    localIntent.putExtra("arg_video_source", 2);
    localIntent.putExtra("arg_video_duration", paramLocalMediaInfo.mDuration);
    localIntent.putExtra("arg_video_path", paramVideoCaptureResult.videoMp4FilePath);
    localIntent.putExtra("arg_video_cover", paramString);
    localIntent.putExtra("arg_video_width", paramLocalMediaInfo.mediaWidth);
    localIntent.putExtra("arg_video_height", paramLocalMediaInfo.mediaHeight);
    startActivityForResult(localIntent, 101);
  }
  
  protected CameraCaptureView.CaptureParam a()
  {
    CameraCaptureView.CaptureParam localCaptureParam = super.a();
    localCaptureParam.c(this.jdField_c_of_type_Int);
    return localCaptureParam;
  }
  
  protected void a(SessionInfo paramSessionInfo, PublishParam paramPublishParam, FlowComponentInterface paramFlowComponentInterface, String paramString1, int paramInt, ArrayList paramArrayList, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
  {
    PtvFilterUtils.a(new File(paramPublishParam.jdField_j_of_type_JavaLangString).getParent(), paramPublishParam.jdField_b_of_type_JavaLangString);
    b(paramSessionInfo, paramPublishParam, paramFlowComponentInterface, paramString1, paramInt, paramArrayList, paramBoolean1, paramString2, paramBoolean2);
  }
  
  public void a(CameraCaptureView.PhotoCaptureResult paramPhotoCaptureResult)
  {
    i();
    JumpUtil.a(this, paramPhotoCaptureResult, 6, 10007, null, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a(), null, 0L, this.jdField_d_of_type_Int, this.jdField_a_of_type_JavaLangString);
  }
  
  protected void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult = paramVideoCaptureResult;
    if (this.jdField_l_of_type_JavaLangString.equals("kandian"))
    {
      a(paramVideoCaptureResult, paramLocalMediaInfo, ReadInJoyCameraCaptureActivity.a(ShortVideoUtils.a(getActivity(), paramVideoCaptureResult.videoMp4FilePath)));
      return;
    }
    Object localObject1;
    if ("DanceMachine".equals(this.jdField_f_of_type_JavaLangString))
    {
      localObject1 = CapturePtvTemplateManager.a().a();
      if ((localObject1 == null) || ((((PtvTemplateManager.PtvTemplateInfo)localObject1).kind != 3) && (((PtvTemplateManager.PtvTemplateInfo)localObject1).kind != 4))) {}
    }
    for (;;)
    {
      try
      {
        DanceMachineVideoParam localDanceMachineVideoParam = new DanceMachineVideoParam();
        localDanceMachineVideoParam.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
        localDanceMachineVideoParam.jdField_a_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
        localDanceMachineVideoParam.jdField_g_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
        localDanceMachineVideoParam.jdField_f_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
        TemplateGroupItem localTemplateGroupItem = CapturePtvTemplateManager.a().a(((PtvTemplateManager.PtvTemplateInfo)localObject1).categoryId);
        if (localTemplateGroupItem == null) {
          continue;
        }
        localDanceMachineVideoParam.jdField_b_of_type_JavaLangString = localTemplateGroupItem.jdField_a_of_type_JavaLangString;
        localDanceMachineVideoParam.jdField_c_of_type_JavaLangString = ((PtvTemplateManager.PtvTemplateInfo)localObject1).id;
        localDanceMachineVideoParam.jdField_a_of_type_Boolean = true;
        localObject1 = localDanceMachineVideoParam;
        if (QLog.isColorLevel())
        {
          QLog.d("AIOEffectsCameraCaptureFragment", 2, "param : " + localDanceMachineVideoParam.toString());
          localObject1 = localDanceMachineVideoParam;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localObject2 = null;
        continue;
        continue;
      }
      a(paramLocalMediaInfo);
      if (localObject1 == null)
      {
        localObject1 = new DanceMachineVideoParam();
        ((DanceMachineVideoParam)localObject1).jdField_a_of_type_Int = this.jdField_b_of_type_Int;
        JumpUtil.a(this, paramVideoCaptureResult, paramLocalMediaInfo, a(true), 6, 10007, this.jdField_d_of_type_Int, this.jdField_a_of_type_JavaLangString, (VideoBusinessParam)localObject1, null);
        return;
        throw new IllegalStateException();
      }
      Object localObject2 = null;
    }
  }
  
  public int b()
  {
    return 10007;
  }
  
  protected void b(SessionInfo paramSessionInfo, PublishParam paramPublishParam, FlowComponentInterface paramFlowComponentInterface, String paramString1, int paramInt, ArrayList paramArrayList, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
  {
    MediaCodecSendTask.VideoSendPublicParam localVideoSendPublicParam = new MediaCodecSendTask.VideoSendPublicParam();
    localVideoSendPublicParam.jdField_a_of_type_AndroidAppActivity = getActivity();
    localVideoSendPublicParam.jdField_a_of_type_JavaLangString = new File(paramPublishParam.jdField_j_of_type_JavaLangString).getParent();
    localVideoSendPublicParam.jdField_b_of_type_JavaLangString = paramPublishParam.jdField_k_of_type_JavaLangString;
    int i1;
    if (paramPublishParam.f <= 5)
    {
      i1 = paramPublishParam.f;
      localVideoSendPublicParam.jdField_a_of_type_Int = i1;
      localVideoSendPublicParam.jdField_c_of_type_JavaLangString = paramPublishParam.jdField_j_of_type_JavaLangString;
      localVideoSendPublicParam.jdField_f_of_type_JavaLangString = paramPublishParam.jdField_c_of_type_JavaLangString;
      localVideoSendPublicParam.jdField_c_of_type_Int = 0;
      localVideoSendPublicParam.jdField_d_of_type_Int = 0;
      localVideoSendPublicParam.jdField_k_of_type_JavaLangString = paramPublishParam.jdField_b_of_type_JavaLangString;
      localVideoSendPublicParam.i = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.videoFrameCount;
      localVideoSendPublicParam.jdField_j_of_type_Int = ((int)paramPublishParam.jdField_a_of_type_Long);
      localVideoSendPublicParam.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface = paramFlowComponentInterface;
      localVideoSendPublicParam.jdField_g_of_type_JavaLangString = paramString1;
      localVideoSendPublicParam.jdField_e_of_type_Int = paramInt;
      localVideoSendPublicParam.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
      localVideoSendPublicParam.jdField_a_of_type_Boolean = paramBoolean1;
      localVideoSendPublicParam.jdField_j_of_type_JavaLangString = paramString2;
      localVideoSendPublicParam.jdField_b_of_type_Boolean = paramBoolean2;
      paramPublishParam = "";
      if (paramSessionInfo == null) {
        break label243;
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
      i1 = 0;
      break;
      label243:
      paramFlowComponentInterface = "";
      paramInt = 0;
      paramSessionInfo = paramPublishParam;
      paramPublishParam = paramFlowComponentInterface;
    }
  }
  
  protected void d()
  {
    super.d();
    Object localObject;
    boolean bool;
    if (this.jdField_l_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView.a(102, this.h, this.jdField_i_of_type_JavaLangString);
      localObject = CapturePtvTemplateManager.a().a();
      if (localObject != null)
      {
        CaptureReportUtil.jdField_b_of_type_JavaLangString = ((PtvTemplateManager.PtvTemplateInfo)localObject).categoryId + "";
        CaptureReportUtil.jdField_c_of_type_JavaLangString = ((PtvTemplateManager.PtvTemplateInfo)localObject).id;
        CaptureReportUtil.jdField_a_of_type_Boolean = ((PtvTemplateManager.PtvTemplateInfo)localObject).hasGesture();
        if (((PtvTemplateManager.PtvTemplateInfo)localObject).kind != 3) {
          break label94;
        }
        bool = true;
        CaptureReportUtil.jdField_b_of_type_Boolean = bool;
      }
    }
    label94:
    do
    {
      do
      {
        return;
        bool = false;
        break;
      } while (!this.m);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView.a(101, this.jdField_j_of_type_JavaLangString, this.jdField_k_of_type_JavaLangString);
      localObject = CaptureVideoFilterManager.a().a;
    } while (localObject == null);
    CaptureReportUtil.jdField_d_of_type_JavaLangString = ((FilterCategoryItem)localObject).jdField_b_of_type_Int + "";
    CaptureReportUtil.jdField_e_of_type_JavaLangString = ((FilterCategoryItem)localObject).jdField_a_of_type_JavaLangString;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject2 = getActivity();
    if ((localObject2 == null) || (((Activity)localObject2).isFinishing())) {}
    PublishParam localPublishParam;
    Object localObject1;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            switch (paramInt1)
            {
            default: 
              return;
            case 101: 
              ((Activity)localObject2).setResult(paramInt2, paramIntent);
              ((Activity)localObject2).finish();
              return;
            }
            if (QLog.isColorLevel()) {
              QLog.d("AIOEffectsCameraCaptureFragment", 2, "aio onActivityResult:requestCode=" + paramInt1 + "  resultCode=" + paramInt2);
            }
          } while ((paramInt2 != -1) || (paramIntent == null));
          if (!paramIntent.getBooleanExtra("result_from_dance_machine", false)) {
            break;
          }
          localPublishParam = (PublishParam)paramIntent.getParcelableExtra(PublishParam.jdField_a_of_type_JavaLangString);
        } while (localPublishParam == null);
        localObject1 = (ViewGroup)getView();
        if (localObject1 != null) {
          ((ViewGroup)localObject1).removeAllViews();
        }
      } while (localPublishParam.jdField_j_of_type_Int != 1);
      localObject1 = localPublishParam.jdField_c_of_type_JavaLangString;
      if (QLog.isColorLevel())
      {
        QLog.d("AIOEffectsCameraCaptureFragment", 2, "hwEncodeVideo videoMergeThumbPath =" + (String)localObject1);
        QLog.d("AIOEffectsCameraCaptureFragment", 2, "publishParam =" + localPublishParam.toString());
      }
      ((Activity)localObject2).getIntent().putExtra("ab_test_send_btn_click_time", SystemClock.uptimeMillis());
      paramInt1 = paramIntent.getIntExtra("forward_to_someplace_from_shoot_quick", 0);
      if (paramInt1 != 1002) {
        break;
      }
      ReportBadCase.a(getActivity().getAppInterface());
      CaptureReportUtil.c("qzone");
      a((Activity)localObject2);
      localObject2 = paramIntent.getStringExtra("forward_source_to_qzone");
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label806;
      }
      localObject1 = paramIntent.getStringExtra("set_user_callback");
    } while (localObject1 == null);
    for (;;)
    {
      try
      {
        localObject1 = Class.forName((String)localObject1).newInstance();
        if (!(localObject1 instanceof FlowComponentInterface)) {
          break label800;
        }
        localObject1 = (FlowComponentInterface)localObject1;
        ((FlowComponentInterface)localObject1).b((String)localObject2);
        a(null, localPublishParam, (FlowComponentInterface)localObject1, paramIntent.getStringExtra("key_content"), 1, null, paramIntent.getBooleanExtra("forward_to_qzone_to_enable_edit", false), null, false);
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
        ReportBadCase.a(getActivity().getAppInterface());
        CaptureReportUtil.c("diary");
        paramIntent = new Intent((Context)localObject2, QQStoryMainActivity.class);
        paramIntent.putExtra("new_video_extra_info", (String)localObject1);
        ((Activity)localObject2).startActivity(paramIntent);
        ((Activity)localObject2).finish();
        return;
      }
      ReportBadCase.a();
      CaptureReportUtil.c("qq_friends");
      localObject1 = (SessionInfo)paramIntent.getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
      if (localObject1 != null) {}
      for (localObject1 = new AIOEffectsCameraCaptureFragment.Session(((SessionInfo)localObject1).jdField_a_of_type_JavaLangString, ((SessionInfo)localObject1).jdField_d_of_type_JavaLangString, ((SessionInfo)localObject1).jdField_a_of_type_Int, ((SessionInfo)localObject1).jdField_b_of_type_JavaLangString);; localObject1 = null)
      {
        a((AIOEffectsCameraCaptureFragment.Session)localObject1, localPublishParam);
        RecentUtil.a(getActivity(), paramIntent);
        ((Activity)localObject2).setResult(-1, paramIntent);
        ((Activity)localObject2).finish();
        return;
        paramIntent = (PublishParam)paramIntent.getParcelableExtra(PublishParam.jdField_a_of_type_JavaLangString);
        if (paramIntent == null) {
          break;
        }
        if (this.jdField_a_of_type_AndroidViewView == null)
        {
          this.jdField_a_of_type_AndroidViewView = new ImageView((Context)localObject2);
          this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-16777216);
          ((ViewGroup)getView()).addView(this.jdField_a_of_type_AndroidViewView, -1, -1);
        }
        if (paramIntent.jdField_j_of_type_Int != 1) {
          break;
        }
        localObject1 = paramIntent.jdField_c_of_type_JavaLangString;
        if (QLog.isColorLevel())
        {
          QLog.d("AIOEffectsCameraCaptureFragment", 2, "hwEncodeVideo videoMergeThumbPath =" + (String)localObject1);
          QLog.d("AIOEffectsCameraCaptureFragment", 2, "publishParam =" + paramIntent.toString());
        }
        ((Activity)localObject2).getIntent().putExtra("ab_test_send_btn_click_time", SystemClock.uptimeMillis());
        localObject1 = new AIOEffectsCameraCaptureFragment.Session("0", "", 0, "");
        ((Activity)localObject2).getIntent().putExtra("param_entrance", 32);
        ((Activity)localObject2).getIntent().putExtra("fake_id", paramIntent.jdField_b_of_type_JavaLangString);
        a((AIOEffectsCameraCaptureFragment.Session)localObject1, paramIntent);
        return;
      }
      label800:
      localObject1 = null;
      continue;
      label806:
      localObject1 = null;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    this.jdField_i_of_type_Boolean = paramBundle.getBoolean("ARG_SUPPORT_VIDEO");
    this.jdField_j_of_type_Boolean = paramBundle.getBoolean("ARG_SUPPORT_PHOTO");
    this.jdField_c_of_type_Int = paramBundle.getInt("ARG_CAMERA_MODE");
    this.jdField_k_of_type_Boolean = paramBundle.getBoolean("ARG_BEAUTY");
    this.o = paramBundle.getBoolean("ARG_SUPPORT_DD");
    this.jdField_l_of_type_Boolean = paramBundle.getBoolean("ARG_UNFOLD_DD");
    this.h = paramBundle.getString("ARG_DD_CATEGORY_NAME");
    this.jdField_i_of_type_JavaLangString = paramBundle.getString("ARG_DD_ITEM_ID");
    this.n = paramBundle.getBoolean("ARG_SUPPORT_FILTER");
    this.m = paramBundle.getBoolean("ARG_UNFOLD_FILTER");
    this.jdField_j_of_type_JavaLangString = paramBundle.getString("ARG_FILTER_CATEGORY_NAME");
    this.jdField_k_of_type_JavaLangString = paramBundle.getString("ARG_FILTER_ITEM_ID");
    this.jdField_d_of_type_Int = paramBundle.getInt("ARG_DEAL_TYPE");
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("ARG_WEB_CALLBACK");
    this.jdField_g_of_type_JavaLangString = paramBundle.getString("ARG_ACTIVITY_ID");
    this.jdField_f_of_type_JavaLangString = paramBundle.getString("ARG_ACTIVITY_TYPE");
    this.jdField_a_of_type_Int = 10007;
    this.p = paramBundle.getBoolean("ARG_SUPPORT_SUBTITLE");
    this.jdField_l_of_type_JavaLangString = paramBundle.getString("ARG_CALLER_TYPE");
    this.jdField_d_of_type_Boolean = this.jdField_k_of_type_Boolean;
    this.jdField_e_of_type_Boolean = this.n;
    this.jdField_f_of_type_Boolean = this.o;
    this.jdField_g_of_type_Boolean = this.p;
    paramBundle = new IntentFilter();
    paramBundle.addAction("tencent.video.q2v.startUploadPTV");
    getActivity().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    CaptureReportUtil.jdField_a_of_type_JavaLangString = this.jdField_g_of_type_JavaLangString;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    getActivity().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.q)
    {
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        ((ViewGroup)getView()).removeView(this.jdField_a_of_type_AndroidViewView);
        this.jdField_a_of_type_AndroidViewView = null;
      }
      this.q = false;
    }
    CaptureUtil.a(false, true);
    CaptureUtil.jdField_b_of_type_Boolean = true;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    int i2 = 1;
    super.onViewCreated(paramView, paramBundle);
    int i1;
    if ((this.jdField_i_of_type_Boolean) && (this.jdField_j_of_type_Boolean)) {
      i1 = i2;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout.setFunctionFlag(i1);
      return;
      if ((this.jdField_i_of_type_Boolean) && (!this.jdField_j_of_type_Boolean))
      {
        i1 = 3;
      }
      else
      {
        i1 = i2;
        if (!this.jdField_i_of_type_Boolean)
        {
          i1 = i2;
          if (this.jdField_j_of_type_Boolean) {
            i1 = 2;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.fragment.WebEffectsCameraCaptureFragment
 * JD-Core Version:    0.7.0.1
 */