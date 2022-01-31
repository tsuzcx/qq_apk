package com.tencent.mobileqq.nearby.now.send;

import aeug;
import aeuh;
import aeui;
import aeul;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.utils.UITools;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager;
import com.tencent.biz.qqstory.takevideo.music.GetMusicInfoListHandler;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.biz.qqstory.takevideo2.StoryPublishParams;
import com.tencent.ilive_feeds.ShortVideo.CheckAuthReq;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.nearby.now.protocol.CsTask;
import com.tencent.mobileqq.nearby.now.send.capturepart.StoryCapturePart;
import com.tencent.mobileqq.nearby.now.send.capturepart.StoryLaunchEditPart;
import com.tencent.mobileqq.nearby.now.send.capturepart.StoryLocalPublishPart;
import com.tencent.mobileqq.nearby.now.send.capturepart.StoryLocalPublishPart.ICapturePartVisiableChangeListener;
import com.tencent.mobileqq.nearby.now.send.capturepart.StoryLocalPublishPart.LocalButtonListenerInterceptor;
import com.tencent.mobileqq.nearby.now.utils.NowSmallVideoRepotor;
import com.tencent.mobileqq.nearby.now.utils.NowVideoReporter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.richmedia.capture.fragment.EffectsCameraCaptureFragment;
import com.tencent.mobileqq.richmedia.capture.util.SVParamManager;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureButtonLayout;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.CaptureParam;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.PhotoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.ProviderContainerView;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public class SmallVideoCameraCaptureFragment
  extends EffectsCameraCaptureFragment
  implements StoryLocalPublishPart.ICapturePartVisiableChangeListener, StoryLocalPublishPart.LocalButtonListenerInterceptor
{
  public static String a;
  protected int a;
  public View a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private StoryLaunchEditPart jdField_a_of_type_ComTencentMobileqqNearbyNowSendCapturepartStoryLaunchEditPart = new StoryLaunchEditPart(this);
  private StoryLocalPublishPart jdField_a_of_type_ComTencentMobileqqNearbyNowSendCapturepartStoryLocalPublishPart = new StoryLocalPublishPart(this);
  protected CameraCaptureView.VideoCaptureResult a;
  private HashSet jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(4096);
  public View b;
  private String f = "操作失败，请稍后再试";
  private boolean i;
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
  }
  
  public SmallVideoCameraCaptureFragment()
  {
    this.jdField_a_of_type_Int = 10000;
    this.jdField_a_of_type_JavaUtilHashSet.add(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendCapturepartStoryLocalPublishPart);
    this.jdField_a_of_type_JavaUtilHashSet.add(this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendCapturepartStoryLaunchEditPart);
  }
  
  public void B_()
  {
    super.B_();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
    while (localIterator.hasNext()) {
      ((StoryCapturePart)localIterator.next()).b();
    }
    new NowVideoReporter().h("video_shoot").i("clk_shoot").d(jdField_a_of_type_JavaLangString).a(2).b(getActivity().app);
  }
  
  public int a()
  {
    return 10002;
  }
  
  public Bundle a()
  {
    Bundle localBundle = getArguments();
    if (localBundle != null) {
      return localBundle;
    }
    return new Bundle();
  }
  
  protected CameraCaptureView.CaptureParam a()
  {
    Object localObject = (StoryConfigManager)SuperManager.a(10);
    int k = ((Integer)((StoryConfigManager)localObject).b("NewStoryVideoWidth", Integer.valueOf(-1))).intValue();
    int m = ((Integer)((StoryConfigManager)localObject).b("NewStoryVideoHeight", Integer.valueOf(-1))).intValue();
    int j = ((Integer)((StoryConfigManager)localObject).b("NewStoryBitRate", Integer.valueOf(-1))).intValue();
    localObject = SVParamManager.a().a(2);
    CameraCaptureView.CaptureParam localCaptureParam = new CameraCaptureView.CaptureParam();
    localCaptureParam.a(((Size)localObject).a());
    localCaptureParam.b(((Size)localObject).b());
    float f1 = SVParamManager.a().a(2);
    if ((k > 0) && (m > 0))
    {
      float f2 = k / ((Size)localObject).a();
      float f3 = m / ((Size)localObject).b();
      localCaptureParam.a(Math.max(f2, f3));
      SLog.d("story.publish.CaptureFragment", "setVideoSizeRate=%s, defaultRatio=%s, storyVideoWidth=%d, storyVideoHeight=%d, previewWidth=%d, previewHeight=%d", new Object[] { Float.valueOf(Math.max(f2, f3)), Float.valueOf(f1), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(((Size)localObject).a()), Integer.valueOf(((Size)localObject).b()) });
      k = SVParamManager.a().a(2) * 1000;
      if (j <= 0) {
        break label330;
      }
      j *= 1000;
      localCaptureParam.d(j);
      com.tencent.mobileqq.shortvideo.mediadevice.CodecParam.r = j;
      SLog.d("story.publish.CaptureFragment", "setVideoBitRate=%d, defaultBitRate=%d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
    }
    for (;;)
    {
      localCaptureParam.e(1);
      localCaptureParam.c(2);
      return localCaptureParam;
      localCaptureParam.a(f1);
      SLog.d("story.publish.CaptureFragment", "setVideoSizeRate=%s as default", new Object[] { Float.valueOf(f1) });
      break;
      label330:
      localCaptureParam.d(k);
      com.tencent.mobileqq.shortvideo.mediadevice.CodecParam.r = k;
      SLog.d("story.publish.CaptureFragment", "setVideoBitRate=%d as default", new Object[] { Integer.valueOf(k) });
    }
  }
  
  public ProviderContainerView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    SLog.d("story.publish.CaptureFragment", "onCaptureError, errorCode=%d", new Object[] { Integer.valueOf(paramInt) });
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
    while (localIterator.hasNext()) {
      ((StoryCapturePart)localIterator.next()).a(paramInt);
    }
    if (paramInt == 102) {
      NowSmallVideoRepotor.a("exp_time_float", 0, new String[0]);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing())) {}
    label341:
    do
    {
      PublishParam localPublishParam;
      do
      {
        return;
        if (paramInt2 != -1) {
          break label341;
        }
        if (paramIntent == null) {
          break;
        }
        localPublishParam = (PublishParam)paramIntent.getParcelableExtra(PublishParam.jdField_a_of_type_JavaLangString);
        localFragmentActivity.getIntent().putExtra(PublishParam.jdField_a_of_type_JavaLangString, localPublishParam);
        paramIntent.putExtra("_from", localFragmentActivity.getIntent().getStringExtra("_from"));
      } while (localPublishParam == null);
      Object localObject = (ViewGroup)getView();
      if (localObject != null) {
        ((ViewGroup)localObject).removeAllViews();
      }
      if (localPublishParam.j == 1)
      {
        localObject = localPublishParam.c;
        if (QLog.isColorLevel()) {
          QLog.d("story.publish.CaptureFragment", 2, "hwEncodeVideo videoMergeThumbPath =" + (String)localObject);
        }
        if (QLog.isColorLevel()) {
          QLog.d("story.publish.CaptureFragment", 2, "publishParam =" + localPublishParam.toString());
        }
        PublicFragmentActivity.a(localFragmentActivity, new Intent(paramIntent), SmallVideoSendFragment.class, 1030);
        return;
      }
      if (localPublishParam.h == 1)
      {
        PublicFragmentActivity.a(localFragmentActivity, new Intent(paramIntent), SmallVideoSendFragment.class, 1030);
        new NowVideoReporter().h("video_shoot").i("suc_upload").d(jdField_a_of_type_JavaLangString).a(2).b(getActivity().app);
        return;
      }
      PublicFragmentActivity.a(localFragmentActivity, new Intent(paramIntent), SmallVideoSendFragment.class, 1030);
      new NowVideoReporter().h("video_shoot").i("suc_upload").d(jdField_a_of_type_JavaLangString).a(1).b(getActivity().app);
      return;
      localFragmentActivity.finish();
      return;
    } while (paramInt2 != 0);
  }
  
  public void a(CameraCaptureView.PhotoCaptureResult paramPhotoCaptureResult)
  {
    SLog.d("story.publish.CaptureFragment", "onPhotoCaptured, file=%s", new Object[] { paramPhotoCaptureResult.jdField_a_of_type_JavaLangString });
    if ((TextUtils.isEmpty(paramPhotoCaptureResult.jdField_a_of_type_JavaLangString)) || (!new File(paramPhotoCaptureResult.jdField_a_of_type_JavaLangString).exists())) {
      a(1000);
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
      while (localIterator.hasNext()) {
        ((StoryCapturePart)localIterator.next()).a(paramPhotoCaptureResult);
      }
    }
  }
  
  protected void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo)
  {
    SLog.d("story.publish.CaptureFragment", "onVideoCaptured, videoMp4FilePath=%s, audioDataFilePath=%s, localMediaInfo=%s", new Object[] { paramVideoCaptureResult.videoMp4FilePath, paramVideoCaptureResult.audioDataFilePath, paramLocalMediaInfo });
    if ((TextUtils.isEmpty(paramVideoCaptureResult.videoMp4FilePath)) || (!new File(paramVideoCaptureResult.videoMp4FilePath).exists()))
    {
      SLog.d("story.publish.CaptureFragment", "mp4 file invalid ! path = %s, exist=%s", new Object[] { paramVideoCaptureResult.videoMp4FilePath, Boolean.valueOf(new File(paramVideoCaptureResult.videoMp4FilePath).exists()) });
      a(1000);
    }
    for (;;)
    {
      return;
      if ((TextUtils.isEmpty(paramVideoCaptureResult.audioDataFilePath)) || (!new File(paramVideoCaptureResult.audioDataFilePath).exists()))
      {
        SLog.d("story.publish.CaptureFragment", "audio file invalid ! path = %s, exist=%s", new Object[] { paramVideoCaptureResult.audioDataFilePath, Boolean.valueOf(new File(paramVideoCaptureResult.audioDataFilePath).exists()) });
        a(1000);
        return;
      }
      if (paramLocalMediaInfo == null)
      {
        SLog.d("story.publish.CaptureFragment", "local media info is null !");
        a(1001);
        return;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
      while (localIterator.hasNext()) {
        ((StoryCapturePart)localIterator.next()).a(paramVideoCaptureResult, paramLocalMediaInfo);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (jdField_a_of_type_JavaLangString.equals("2")) && (this.jdField_a_of_type_AndroidWidgetTextView != null)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public boolean a()
  {
    if (!this.i) {
      QQToast.a(getActivity(), 1, this.f, 0).a();
    }
    return this.i;
  }
  
  public void aj_()
  {
    super.aj_();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
    while (localIterator.hasNext()) {
      ((StoryCapturePart)localIterator.next()).a();
    }
    new NowVideoReporter().h("video_shoot").i("press_shoot").d(jdField_a_of_type_JavaLangString).a(1).b(getActivity().app);
  }
  
  protected int b()
  {
    return 2130970456;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
  }
  
  public void d()
  {
    super.d();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    SLog.a("story.publish.CaptureFragment", "onActivityResult %d, %d, %s", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
    while (localIterator.hasNext()) {
      ((StoryCapturePart)localIterator.next()).a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      super.onClick(paramView);
      return;
      new NowVideoReporter().h("video_shoot").i("clk_left").d(jdField_a_of_type_JavaLangString).b(null);
      continue;
      if (!this.d.isSelected()) {}
      for (int j = 1;; j = 0)
      {
        if (j == 0) {
          break label112;
        }
        NowSmallVideoRepotor.a("open_flash", 0, new String[0]);
        break;
      }
      label112:
      NowSmallVideoRepotor.a("close_flash", 0, new String[0]);
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a() == 2) {
        NowSmallVideoRepotor.a("camera_front", 0, new String[0]);
      } else {
        NowSmallVideoRepotor.a("camera_back", 0, new String[0]);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Object localObject = a();
    jdField_a_of_type_JavaLangString = ((Bundle)localObject).getString("_from", "");
    ((Bundle)localObject).putBoolean("enable_multi_fragment", false);
    StoryPublishParams.a("story.publish.CaptureFragment", a());
    VideoEnvironment.a("AVCodec", getActivity().getApplicationContext());
    localObject = this.jdField_a_of_type_JavaUtilHashSet.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((StoryCapturePart)((Iterator)localObject).next()).a(paramBundle);
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendCapturepartStoryLocalPublishPart.a(this);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowSendCapturepartStoryLocalPublishPart.a(this);
    if (paramBundle != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult = ((CameraCaptureView.VideoCaptureResult)paramBundle.getSerializable("KEY_VIDEO_RESULT"));
    }
    new NowVideoReporter().h("video_shoot").i("exp_findview").d(jdField_a_of_type_JavaLangString).a(1).b(getActivity().app);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramViewGroup.setFocusable(true);
    paramViewGroup.setFocusableInTouchMode(true);
    paramViewGroup.requestFocus();
    paramViewGroup.setOnKeyListener(new aeul(this, null));
    this.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131368954);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout.setButtonListenerInterceptor(new aeug(this));
    ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams()).bottomMargin = ((int)UITools.a(getActivity(), 30.0F));
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView.setSubtitleEnable(false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView.b();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131370616));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new aeuh(this));
    if (jdField_a_of_type_JavaLangString.equals("2")) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
    while (localIterator.hasNext()) {
      ((StoryCapturePart)localIterator.next()).a(paramLayoutInflater, paramViewGroup, paramBundle);
    }
    return paramViewGroup;
  }
  
  public void onPause()
  {
    super.onPause();
    SLog.b("story.publish.CaptureFragment", "onPause");
    ((DoodleEmojiManager)SuperManager.a(8)).e();
  }
  
  public void onResume()
  {
    super.onResume();
    SLog.b("story.publish.CaptureFragment", "onResume");
    ((DoodleEmojiManager)SuperManager.a(8)).d();
    if ((a().getString("video_tag_info", null) != null) && (!GetMusicInfoListHandler.a(getActivity())))
    {
      SLog.b("story.publish.CaptureFragment", "fireGetMusicInfoList because use take video with video tag");
      GetMusicInfoListHandler.a(getActivity());
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putSerializable("KEY_VIDEO_RESULT", this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    Object localObject = a();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout.setMaxDuration(10000.0F);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout.setFunctionFlag(((Bundle)localObject).getInt("ability_flag", 1));
    localObject = this.jdField_a_of_type_JavaUtilHashSet.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((StoryCapturePart)((Iterator)localObject).next()).a(paramView, paramBundle);
    }
    this.b = paramView.findViewById(2131370614);
    this.b.setVisibility(4);
    paramView = new ShortVideo.CheckAuthReq();
    paramView.ver.set(0);
    new CsTask(getActivity().getAppInterface()).a(24592).b(3).a(new aeui(this)).a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.send.SmallVideoCameraCaptureFragment
 * JD-Core Version:    0.7.0.1
 */