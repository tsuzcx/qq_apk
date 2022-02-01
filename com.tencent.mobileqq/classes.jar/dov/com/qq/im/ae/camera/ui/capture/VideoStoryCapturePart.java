package dov.com.qq.im.ae.camera.ui.capture;

import android.app.Activity;
import android.app.Dialog;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.videostory.animator.AnimationBuilder;
import com.tencent.biz.videostory.animator.ViewAnimator;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.biz.videostory.support.VideoStoryDataBean;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.shortvideo.util.MediaCodecDPC;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.tavcut.util.BitmapUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.SimpleObserver;
import com.tribe.async.reactive.Stream;
import dov.com.qq.im.ae.AECameraConfig;
import dov.com.qq.im.ae.AEPath.CAMERA.FILES;
import dov.com.qq.im.ae.AEPituCameraUnit;
import dov.com.qq.im.ae.AEViewModelProviders;
import dov.com.qq.im.ae.album.data.AEAlbumImageModel;
import dov.com.qq.im.ae.album.data.AEPhotoCropInfoWrapper;
import dov.com.qq.im.ae.camera.AEPhotoCaptureResult;
import dov.com.qq.im.ae.camera.AEVideoCaptureResult;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;
import dov.com.qq.im.ae.camera.ui.watermark.WatermarkDataManager;
import dov.com.qq.im.ae.camera.util.AEVoiceVideoMergeUtil;
import dov.com.qq.im.ae.data.AEMaterialManager;
import dov.com.qq.im.ae.data.AEMaterialMetaData;
import dov.com.qq.im.ae.entry.AECameraEntry;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.mode.AEVideoStoryCaptureModeViewModel;
import dov.com.qq.im.ae.part.VideoStoryBasePart;
import dov.com.qq.im.ae.part.VideoStoryCapturePartManager;
import dov.com.qq.im.ae.play.AETakeFacePhotoPreviewFragment;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.report.AEBaseReportParam;
import dov.com.qq.im.ae.util.AEGenerateThumbnailSegment;
import dov.com.qq.im.ae.util.AEPreviewSizeUtil;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.ae.util.AEThemeUtil;
import dov.com.qq.im.aeeditor.AEEditorLauncher;
import dov.com.qq.im.aeeditor.module.clip.image.EditorPicInfo;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.qq.im.setting.CaptureEntranceParams;
import dov.com.qq.im.setting.CaptureVideoParams;
import dov.com.qq.im.setting.CaptureVideoParams.CaptureVideoParamsBuilder;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateThumbArgs;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishFileManager;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishVideoSegment;
import dov.com.tencent.biz.qqstory.takevideo.sendpanel.SendPanelManager;
import dov.com.tencent.mobileqq.activity.richmedia.QQStoryFlowCallback;
import dov.com.tencent.mobileqq.activity.richmedia.SaveVideoActivity;
import dov.com.tencent.mobileqq.richmedia.capture.util.JumpUtil;
import dov.com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

public class VideoStoryCapturePart
  extends VideoStoryBasePart
{
  public static int a;
  private long jdField_a_of_type_Long = 0L;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private VideoStoryDataBean jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean;
  private AEPituCameraUnit jdField_a_of_type_DovComQqImAeAEPituCameraUnit;
  private AECameraGLSurfaceView jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView;
  private AEVideoStoryTopBarViewModel.Ratio jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio;
  private AEVideoStoryTopBarViewModel jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel;
  private AECaptureMode jdField_a_of_type_DovComQqImAeModeAECaptureMode = null;
  private AEVideoStoryCaptureModeViewModel jdField_a_of_type_DovComQqImAeModeAEVideoStoryCaptureModeViewModel;
  List<FrameVideoHelper.FrameBuffer> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = ((Long)VSConfigManager.a().a("SmartCutPicMaxByte", Long.valueOf(90000L))).longValue();
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = 0;
  private View jdField_d_of_type_AndroidViewView;
  private boolean jdField_d_of_type_Boolean;
  private View e;
  
  public VideoStoryCapturePart(Activity paramActivity, View paramView, VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    super(paramActivity, paramView, paramVideoStoryCapturePartManager);
    this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit = ((AEPituCameraUnit)paramVideoStoryCapturePartManager.a(65537, new Object[0]));
    this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean = new VideoStoryDataBean();
    jdField_a_of_type_Int = ViewUtils.a(60.0F) + ImmersiveUtils.getStatusBarHeight(paramActivity);
  }
  
  private int a()
  {
    int i = 0;
    int j = AEPreviewSizeUtil.a();
    int k = this.mActivity.getResources().getDimensionPixelSize(2131296290);
    int m = ImmersiveUtils.getStatusBarHeight(this.mActivity);
    if (j == 1) {
      i = k + m;
    }
    while (j != 2) {
      return i;
    }
    return 0;
  }
  
  private SimpleObserver<GenerateContext> a(int paramInt)
  {
    return new VideoStoryCapturePart.10(this, SystemClock.uptimeMillis(), paramInt);
  }
  
  @NotNull
  private static EditVideoParams a(Activity paramActivity, LocalMediaInfo paramLocalMediaInfo, CaptureVideoParams paramCaptureVideoParams, int paramInt1, Bundle paramBundle, EditVideoParams.EditSource paramEditSource, int paramInt2)
  {
    paramBundle = new EditVideoParams(paramInt2, paramInt1, paramEditSource, paramBundle);
    if (paramCaptureVideoParams != null) {
      paramBundle.jdField_b_of_type_Int = paramCaptureVideoParams.jdField_a_of_type_Int;
    }
    paramBundle.f = paramActivity.getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a());
    paramBundle.jdField_a_of_type_AndroidOsBundle.putBoolean("enable_hw_encode", true);
    if (QLog.isColorLevel()) {
      QLog.d("VideoStoryCapturePart", 2, "EditVideoParams params:" + paramBundle.toString());
    }
    if (paramLocalMediaInfo.redBagType == LocalMediaInfo.REDBAG_TYPE_GET) {
      paramBundle.jdField_a_of_type_AndroidOsBundle.putInt("video_redbag_get", paramLocalMediaInfo.redBagType);
    }
    paramBundle.jdField_a_of_type_AndroidOsBundle.putInt("special_video_type", paramLocalMediaInfo.specialVideoType);
    long l = paramActivity.getIntent().getLongExtra("troop_uin", 0L);
    if (l != 0L) {
      paramBundle.jdField_a_of_type_AndroidOsBundle.putLong("troop_uin", l);
    }
    return paramBundle;
  }
  
  @NotNull
  private GenerateContext a(EditVideoParams.EditSource paramEditSource, int paramInt1, int paramInt2, String paramString1, float paramFloat, int paramInt3, String paramString2, boolean paramBoolean, String paramString3, EditVideoParams paramEditVideoParams)
  {
    GenerateContext localGenerateContext = new GenerateContext(paramEditVideoParams);
    localGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMaxrate = CodecParam.mMaxrate;
    if (MediaCodecDPC.f())
    {
      localGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMaxrate = (MediaCodecDPC.b() * 1000);
      localGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("composite_key_bitrate_mode", Boolean.valueOf(MediaCodecDPC.f()));
    }
    localGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMinrate = CodecParam.mMinrate;
    localGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoUploadGroupTempDir = paramString3;
    localGenerateContext.b = PublishFileManager.a(paramEditVideoParams.jdField_a_of_type_Int);
    localGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGenerateThumbArgs = new GenerateThumbArgs(this.mActivity, paramInt1, paramInt2, paramString1, paramFloat, false, paramInt3, 0.0D, 0.0D, paramString2, paramBoolean);
    if (((paramEditSource instanceof EditTakeVideoSource)) || ((paramEditSource instanceof EditLocalVideoSource))) {
      localGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("is_hw_encode", Boolean.valueOf(true));
    }
    for (;;)
    {
      localGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("thumb_rotation", Integer.valueOf(paramInt3));
      paramEditSource = localGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a("extra_text_filter_text");
      if (!TextUtils.isEmpty(paramEditSource))
      {
        if (!TextUtils.isEmpty(localGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoDoodleDescription)) {
          break;
        }
        localGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoDoodleDescription = paramEditSource;
      }
      return localGenerateContext;
      localGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.putExtra("is_hw_encode", Boolean.valueOf(false));
    }
    paramString1 = new StringBuilder();
    paramString2 = localGenerateContext.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry;
    paramString2.videoDoodleDescription += paramEditSource;
    return localGenerateContext;
  }
  
  @Nullable
  private String a(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = null;
    }
    int i;
    do
    {
      return str;
      i = paramString.indexOf("^");
      str = paramString;
    } while (i < 0);
    return paramString.substring(i + 1);
  }
  
  private void a()
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    Object localObject = (ViewStub)this.mRootView.findViewById(2131378598);
    ViewStub localViewStub1 = (ViewStub)this.mRootView.findViewById(2131378594);
    ViewStub localViewStub2 = (ViewStub)this.mRootView.findViewById(2131378595);
    ViewStub localViewStub3 = (ViewStub)this.mRootView.findViewById(2131378596);
    ViewStub localViewStub4 = (ViewStub)this.mRootView.findViewById(2131378597);
    ViewStub localViewStub5 = (ViewStub)this.mRootView.findViewById(2131378593);
    ((ViewStub)localObject).inflate();
    localViewStub1.inflate();
    localViewStub2.inflate();
    localViewStub3.inflate();
    localViewStub4.inflate();
    localViewStub5.inflate();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.mRootView.findViewById(2131362263));
    this.jdField_a_of_type_AndroidViewView = this.mRootView.findViewById(2131364339);
    this.jdField_b_of_type_AndroidViewView = this.mRootView.findViewById(2131364335);
    this.jdField_b_of_type_AndroidViewView.setOnTouchListener(new VideoStoryCapturePart.1(this));
    this.jdField_c_of_type_AndroidViewView = this.mRootView.findViewById(2131364336);
    this.jdField_c_of_type_AndroidViewView.setOnTouchListener(new VideoStoryCapturePart.2(this));
    this.jdField_d_of_type_AndroidViewView = this.mRootView.findViewById(2131364337);
    this.jdField_d_of_type_AndroidViewView.setOnTouchListener(new VideoStoryCapturePart.3(this));
    this.e = this.mRootView.findViewById(2131364334);
    this.e.setOnTouchListener(new VideoStoryCapturePart.4(this));
    if (this.jdField_d_of_type_Boolean)
    {
      boolean bool = AEThemeUtil.a();
      localObject = this.mActivity.getResources();
      if (!bool) {
        break label350;
      }
    }
    label350:
    for (int i = 2131165213;; i = 2131165215)
    {
      i = ((Resources)localObject).getColor(i);
      this.jdField_d_of_type_AndroidViewView.setBackgroundColor(i);
      this.e.setBackgroundColor(i);
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(i);
      this.jdField_c_of_type_AndroidViewView.setBackgroundColor(i);
      this.jdField_c_of_type_Boolean = true;
      return;
    }
  }
  
  private void a(int paramInt, com.tencent.mobileqq.activity.richmedia.Size paramSize)
  {
    long l1 = paramSize.jdField_a_of_type_Int * paramSize.jdField_b_of_type_Int;
    long l2 = this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.getWidth() * this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.getHeight();
    AEQLog.a("VideoStoryCapturePart", "smooth2Size---oldArea=" + l2 + ", newArea=" + l1);
    if (l1 == l2) {
      return;
    }
    a();
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    Object localObject = ViewAnimator.a(new View[] { this.jdField_b_of_type_AndroidViewView, this.jdField_c_of_type_AndroidViewView }).d(new float[] { this.jdField_b_of_type_AndroidViewView.getWidth(), (int)Math.ceil((this.jdField_b_of_type_Int - paramSize.jdField_a_of_type_Int) / 2.0D) }).a(new View[] { this.jdField_d_of_type_AndroidViewView }).c(new float[] { this.jdField_d_of_type_AndroidViewView.getHeight(), paramInt }).a(new View[] { this.e }).c(new float[] { this.e.getHeight(), this.mRootView.getHeight() - paramInt - paramSize.jdField_b_of_type_Int });
    if (l1 > l2) {}
    for (localObject = ((AnimationBuilder)localObject).a().a(300L);; localObject = ((AnimationBuilder)localObject).a(1.5F).a(500L))
    {
      ((ViewAnimator)localObject).a(new VideoStoryCapturePart.8(this)).a();
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = paramSize.jdField_a_of_type_Int;
      ((RelativeLayout.LayoutParams)localObject).height = paramSize.jdField_b_of_type_Int;
      ((RelativeLayout.LayoutParams)localObject).topMargin = paramInt;
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
  }
  
  private void a(com.tencent.mobileqq.activity.richmedia.Size paramSize1, com.tencent.mobileqq.activity.richmedia.Size paramSize2)
  {
    if (this.jdField_d_of_type_Boolean)
    {
      int k = b();
      int j = this.mActivity.getResources().getDimensionPixelSize(2131296296);
      int m = this.mActivity.getResources().getDimensionPixelSize(2131296298);
      int i = j;
      if (this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio == AEVideoStoryTopBarViewModel.Ratio.R_4_3)
      {
        i = j;
        if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode == AECaptureMode.NORMAL) {
          i = Math.max(paramSize1.jdField_b_of_type_Int - k - paramSize2.jdField_b_of_type_Int + m, j);
        }
      }
      paramSize1 = this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      paramSize1.height = i;
      this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(paramSize1);
    }
  }
  
  private void a(AEPhotoCaptureResult paramAEPhotoCaptureResult)
  {
    a(false);
    Object localObject2 = this.mActivity.getIntent();
    if (AECameraEntry.f((Intent)localObject2))
    {
      AEQLog.b("VideoStoryCapturePart", "handleNoNeedEditPhoto---from playMiniApp");
      Intent localIntent = new Intent();
      localIntent.setAction("com.tencent.mobileqq.mini.out.nativePlugins.native_back");
      localIntent.putExtra("file_path", paramAEPhotoCaptureResult.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("is_video", false);
      Object localObject1 = this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.a();
      paramAEPhotoCaptureResult = (AEPhotoCaptureResult)localObject1;
      if (localObject1 == null) {
        paramAEPhotoCaptureResult = new HashMap();
      }
      localObject1 = ((Intent)localObject2).getStringExtra("widgetinfo");
      localObject2 = a((String)localObject1);
      AEQLog.a("VideoStoryCapturePart", "handleNoNeedEditPhoto---widgetId=" + (String)localObject2 + ", widgetInfo=" + (String)localObject1);
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        paramAEPhotoCaptureResult.put("extra_info_key_widget_id", localObject2);
      }
      localIntent.putExtra("extra_info", paramAEPhotoCaptureResult);
      this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.a().sendBroadcast(localIntent);
      this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.a().setResult(-1, localIntent);
      this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.a().finish();
    }
  }
  
  private void a(AEVideoCaptureResult paramAEVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo)
  {
    AEQLog.b("VideoStoryCapturePart", "[VideoEnd] ready to enter EditorActivity");
    Object localObject = AEPath.CAMERA.FILES.c + File.separator + System.currentTimeMillis() + ".mp4";
    localObject = AEVoiceVideoMergeUtil.a(paramAEVideoCaptureResult.audioDataFilePath, paramLocalMediaInfo.path, (String)localObject);
    paramAEVideoCaptureResult = (AEVideoCaptureResult)localObject;
    if (localObject == null) {
      paramAEVideoCaptureResult = paramLocalMediaInfo.path;
    }
    paramLocalMediaInfo = new Bundle();
    localObject = new ArrayList();
    ((ArrayList)localObject).add(paramAEVideoCaptureResult);
    paramLocalMediaInfo.putStringArrayList("PhotoConst.SELECTED_PATHS", (ArrayList)localObject);
    paramAEVideoCaptureResult = this.mActivity.getIntent().getStringExtra("material_id");
    if (!TextUtils.isEmpty(paramAEVideoCaptureResult))
    {
      paramLocalMediaInfo.putString("material_id", paramAEVideoCaptureResult);
      paramLocalMediaInfo.putString("material_topic", this.mActivity.getIntent().getStringExtra("material_topic"));
      paramLocalMediaInfo.putString("key_camera_material_name", this.mActivity.getIntent().getStringExtra("key_camera_material_name"));
      this.mActivity.getIntent().removeExtra("material_id");
      this.mActivity.getIntent().removeExtra("material_topic");
      this.mActivity.getIntent().removeExtra("key_camera_material_name");
    }
    paramLocalMediaInfo.putInt("ae_editor_is_show_take_same", this.mActivity.getIntent().getIntExtra("ae_editor_is_show_take_same", 0));
    this.mActivity.getIntent().removeExtra("ae_editor_is_show_take_same");
    int i;
    if (Build.VERSION.SDK_INT >= 23) {
      if (this.mActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        AEQLog.b("VideoStoryCapturePart", "updateWMProps onGetLocation");
        WatermarkDataManager.a().a(new VideoStoryCapturePart.11(this));
      }
      i = c();
      AEEditorLauncher.a(this.mActivity, 1, paramLocalMediaInfo, i);
      return;
      i = 0;
      continue;
      i = 1;
    }
  }
  
  private void a(AEVideoCaptureResult paramAEVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo, Integer paramInteger, CaptureEntranceParams paramCaptureEntranceParams, QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    int i = this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.b().e();
    if (i == 4)
    {
      a(paramAEVideoCaptureResult, paramLocalMediaInfo);
      return;
    }
    if (i == -2)
    {
      AEQLog.b("VideoStoryCapturePart", "enterVideoEditByConfig---no need edit");
      a(paramAEVideoCaptureResult, paramCaptureEntranceParams, paramLocalMediaInfo);
      return;
    }
    c(paramAEVideoCaptureResult, paramLocalMediaInfo, paramInteger, paramCaptureEntranceParams, paramQIMFilterCategoryItem);
  }
  
  private void a(AEVideoCaptureResult paramAEVideoCaptureResult, CaptureEntranceParams paramCaptureEntranceParams, LocalMediaInfo paramLocalMediaInfo)
  {
    AEQLog.b("VideoStoryCapturePart", "handleNoNeedEditVideo---");
    ThreadManager.getUIHandler().post(new VideoStoryCapturePart.9(this));
    paramAEVideoCaptureResult = new EditTakeVideoSource(paramAEVideoCaptureResult.videoMp4FilePath, paramAEVideoCaptureResult.audioDataFilePath, paramLocalMediaInfo);
    Bundle localBundle = new Bundle();
    int i = paramCaptureEntranceParams.a();
    paramCaptureEntranceParams = a(this.mActivity, paramLocalMediaInfo, null, 0, localBundle, paramAEVideoCaptureResult, i);
    paramLocalMediaInfo = paramCaptureEntranceParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
    int j = paramAEVideoCaptureResult.a();
    int k = paramAEVideoCaptureResult.b();
    Stream.of(a(paramLocalMediaInfo, j, k, paramAEVideoCaptureResult.a(), j * 1.0F / k, paramAEVideoCaptureResult.a.rotation, "", false, paramCaptureEntranceParams.a("extra_upload_temp_directory"), paramCaptureEntranceParams)).map(new ThreadOffFunction("VideoStoryCapturePart", 2)).map(new AEGenerateThumbnailSegment()).map(new PublishVideoSegment(paramCaptureEntranceParams)).subscribe(a(i));
  }
  
  private void a(@NonNull AECaptureMode paramAECaptureMode)
  {
    int j;
    float f;
    int i;
    if ((paramAECaptureMode == AECaptureMode.GIF) || (paramAECaptureMode == AECaptureMode.NORMAL))
    {
      j = 0;
      if (paramAECaptureMode != AECaptureMode.GIF) {
        break label152;
      }
      if (this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit == null) {
        break label109;
      }
      if ((!this.jdField_a_of_type_Boolean) || (this.jdField_d_of_type_Int == 0)) {
        break label91;
      }
      f = this.jdField_d_of_type_Int;
      i = (int)f;
    }
    for (;;)
    {
      paramAECaptureMode = AEPreviewSizeUtil.a();
      com.tencent.mobileqq.activity.richmedia.Size localSize = AEPreviewSizeUtil.a(this.jdField_a_of_type_DovComQqImAeModeAECaptureMode, paramAECaptureMode, this.jdField_d_of_type_Boolean, this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio);
      a(i, localSize);
      a(paramAECaptureMode, localSize);
      return;
      label91:
      f = DisplayUtil.a(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.a(), 147.0F);
      break;
      label109:
      if (this.jdField_a_of_type_Boolean)
      {
        f = (int)(0.0724138F * this.mRootView.getHeight());
        break;
      }
      f = (int)(0.1810345F * this.mRootView.getHeight());
      break;
      label152:
      i = j;
      if (this.jdField_d_of_type_Boolean) {
        if (this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio == AEVideoStoryTopBarViewModel.Ratio.R_4_3)
        {
          i = a();
        }
        else
        {
          i = j;
          if (this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio == AEVideoStoryTopBarViewModel.Ratio.R_1_1) {
            i = jdField_a_of_type_Int;
          }
        }
      }
    }
  }
  
  private void a(GenerateContext paramGenerateContext, int paramInt)
  {
    boolean bool = false;
    Activity localActivity = this.mActivity;
    Object localObject;
    int j;
    int i;
    if (localActivity != null)
    {
      AEQLog.a("VideoStoryCapturePart", "Q.videostory.publish.upload[peak process]  sendBroadcast notify publish start(to read info from db)");
      localObject = paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishPublishParam;
      AEQLog.a("VideoStoryCapturePart", "publishParam = " + localObject);
      paramGenerateContext = localActivity.getIntent();
      if (paramGenerateContext == null) {
        break label270;
      }
      j = paramGenerateContext.getIntExtra("sv_total_frame_count", 0);
      i = paramGenerateContext.getIntExtra("sv_total_record_time", 0);
    }
    for (;;)
    {
      Intent localIntent = SaveVideoActivity.a(localActivity, ((PublishParam)localObject).b, i, j, paramInt);
      if (paramGenerateContext != null) {}
      for (paramInt = paramGenerateContext.getIntExtra("VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a());; paramInt = 0)
      {
        localIntent.putExtra("mediacodec_encode_enable", true);
        if (((PublishParam)localObject).e != 0) {
          bool = true;
        }
        localIntent.putExtra("video_edit_flag", bool);
        localIntent.putExtra("thumbfile_send_path", ((PublishParam)localObject).c);
        localIntent.putExtra("VIDEO_STORY_FROM_TYPE", paramInt);
        if (paramGenerateContext != null)
        {
          localIntent.putExtra("widgetinfo", paramGenerateContext.getStringExtra("widgetinfo"));
          localObject = paramGenerateContext.getStringExtra("key_camera_material_name");
          AEQLog.b("VideoStoryCapturePart", "start SaveVideoActivity---takeSameName=" + (String)localObject);
          localIntent.putExtra("key_camera_material_name", (String)localObject);
          localIntent.putExtra("qqstory_slide_show_scene", paramGenerateContext.getIntExtra("qqstory_slide_show_scene", -1));
        }
        localActivity.startActivityForResult(localIntent, 1026);
        return;
      }
      label270:
      i = 0;
      j = 0;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      if ((this.mActivity != null) && (!this.mActivity.isFinishing()))
      {
        if (this.jdField_a_of_type_AndroidAppDialog == null)
        {
          this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this.mActivity, 2131755842);
          this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
          this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
          this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559683);
        }
        this.jdField_a_of_type_AndroidAppDialog.show();
      }
    }
    while ((this.jdField_a_of_type_AndroidAppDialog == null) || (!this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      return;
    }
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
  }
  
  private void a(Object[] paramArrayOfObject)
  {
    AEVideoCaptureResult localAEVideoCaptureResult;
    LocalMediaInfo localLocalMediaInfo;
    Integer localInteger;
    CaptureEntranceParams localCaptureEntranceParams;
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length == 5))
    {
      localAEVideoCaptureResult = (AEVideoCaptureResult)paramArrayOfObject[0];
      localLocalMediaInfo = (LocalMediaInfo)paramArrayOfObject[1];
      localInteger = (Integer)paramArrayOfObject[2];
      localCaptureEntranceParams = (CaptureEntranceParams)paramArrayOfObject[3];
      paramArrayOfObject = (QIMFilterCategoryItem)paramArrayOfObject[4];
      if (!b()) {
        break label70;
      }
      a(localAEVideoCaptureResult, localLocalMediaInfo, localInteger, localCaptureEntranceParams, paramArrayOfObject);
    }
    for (;;)
    {
      e();
      return;
      label70:
      b(localAEVideoCaptureResult, localLocalMediaInfo, localInteger, localCaptureEntranceParams, paramArrayOfObject);
    }
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.b() != null) && (this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.b().f() != -1);
  }
  
  private int b()
  {
    int j = AEPreviewSizeUtil.a();
    int i = this.mActivity.getResources().getDimensionPixelSize(2131296288);
    int k = this.mActivity.getResources().getDimensionPixelSize(2131296290);
    int m = ImmersiveUtils.getStatusBarHeight(this.mActivity);
    if (j == 1) {
      i = i + m + k;
    }
    while (j == 2) {
      return i;
    }
    return 0;
  }
  
  private void b()
  {
    this.jdField_a_of_type_DovComQqImAeModeAEVideoStoryCaptureModeViewModel = ((AEVideoStoryCaptureModeViewModel)AEViewModelProviders.a(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit).get(AEVideoStoryCaptureModeViewModel.class));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel = ((AEVideoStoryTopBarViewModel)AEViewModelProviders.a(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit).get(AEVideoStoryTopBarViewModel.class));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel$Ratio = ((AEVideoStoryTopBarViewModel.Ratio)this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.a.getValue());
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.b().observe(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit, new VideoStoryCapturePart.5(this));
    this.jdField_a_of_type_DovComQqImAeModeAEVideoStoryCaptureModeViewModel.a.observe(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit, new VideoStoryCapturePart.6(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.a.observe(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit, new VideoStoryCapturePart.7(this));
    this.jdField_a_of_type_DovComQqImAeModeAEVideoStoryCaptureModeViewModel.c.postValue(Boolean.valueOf(this.jdField_b_of_type_Boolean));
  }
  
  private void b(AEVideoCaptureResult paramAEVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo, Integer paramInteger, CaptureEntranceParams paramCaptureEntranceParams, QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    if (paramInteger.intValue() == 13)
    {
      a(paramAEVideoCaptureResult, paramLocalMediaInfo);
      return;
    }
    c(paramAEVideoCaptureResult, paramLocalMediaInfo, paramInteger, paramCaptureEntranceParams, paramQIMFilterCategoryItem);
  }
  
  private void b(Object[] paramArrayOfObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("camera_log_tag_photo", 2, "in photo end.");
    }
    if (a())
    {
      c(paramArrayOfObject);
      return;
    }
    d(paramArrayOfObject);
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.b() != null) && (this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.b().e() != -1);
  }
  
  private int c()
  {
    int i = AECameraEntry.x.a();
    if (this.mActivity.getIntent() != null)
    {
      int j = this.mActivity.getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", AECameraEntry.x.a());
      i = j;
      if (j == AECameraEntry.A.a()) {
        i = AECameraEntry.z.a();
      }
    }
    return i;
  }
  
  private void c()
  {
    a(true);
  }
  
  private void c(AEVideoCaptureResult paramAEVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo, Integer paramInteger, CaptureEntranceParams paramCaptureEntranceParams, QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    Bundle localBundle = this.mActivity.getIntent().getExtras();
    Object localObject1 = new CaptureVideoParams.CaptureVideoParamsBuilder().a(paramCaptureEntranceParams.jdField_c_of_type_Int).c(10);
    if (AECameraEntry.g(this.mActivity.getIntent())) {
      ((CaptureVideoParams.CaptureVideoParamsBuilder)localObject1).c(0);
    }
    paramCaptureEntranceParams.a(((CaptureVideoParams.CaptureVideoParamsBuilder)localObject1).a());
    this.mActivity.getIntent().putExtra("extra_transiton_src_from", -1);
    localObject1 = new Bundle();
    ((Bundle)localObject1).putSerializable("KEY_VIDEO_STORY_CAPTYRE_FRAMES", (Serializable)this.jdField_a_of_type_JavaUtilList);
    ((Bundle)localObject1).putLong("KEY_VIDEO_STORY_CAPTYRE_FRAMES_SIZE", this.jdField_a_of_type_Long);
    ((Bundle)localObject1).putInt("KEY_VIDEO_STORY_CAMERA_TYPE", paramInteger.intValue());
    Object localObject2 = WatermarkDataManager.a().a();
    paramInteger = "";
    if (localObject2 != null) {
      paramInteger = ((AEMaterialMetaData)localObject2).f;
    }
    localObject2 = this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean;
    if (!TextUtils.isEmpty(paramInteger))
    {
      ((VideoStoryDataBean)localObject2).setWatermarkId(paramInteger);
      localObject2 = this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean;
      if (paramQIMFilterCategoryItem == null) {
        break label311;
      }
      paramInteger = paramQIMFilterCategoryItem.b;
      label186:
      ((VideoStoryDataBean)localObject2).setFilterId(paramInteger);
      paramQIMFilterCategoryItem = this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean;
      if (AEMaterialManager.a() != null) {
        break label318;
      }
      paramInteger = "empty";
      label208:
      paramQIMFilterCategoryItem.setLensId(paramInteger);
      paramQIMFilterCategoryItem = this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean;
      if (AEMaterialManager.a() != null) {
        break label328;
      }
    }
    label311:
    label318:
    label328:
    for (paramInteger = "empty";; paramInteger = Integer.valueOf(AEMaterialManager.a().jdField_a_of_type_Int))
    {
      paramQIMFilterCategoryItem.setLensTabId(String.valueOf(paramInteger));
      ((Bundle)localObject1).putSerializable("KEY_VIDEO_STORY_CAMERA_TYPE", this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean);
      this.mActivity.getIntent().putExtra("VIDEO_STORY_MEDIA_TYPE", 100);
      AEQLog.b("VideoStoryCapturePart", "[VideoEnd] jumpToEditVideoActivity");
      JumpUtil.a(this.mActivity, paramAEVideoCaptureResult, paramLocalMediaInfo, paramCaptureEntranceParams, (Bundle)localObject1, this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.b().b().intValue(), localBundle);
      return;
      paramInteger = "empty";
      break;
      paramInteger = "empty";
      break label186;
      paramInteger = AEMaterialManager.a().jdField_a_of_type_JavaLangString;
      break label208;
    }
  }
  
  private void c(Object[] paramArrayOfObject)
  {
    AECameraConfig localAECameraConfig = this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.b();
    AEQLog.a("VideoStoryCapturePart", "enterPhotoEditByConfig:  editType = " + localAECameraConfig.f() + " args = " + paramArrayOfObject);
    switch (localAECameraConfig.f())
    {
    default: 
      return;
    case 0: 
      g(paramArrayOfObject);
      a(false);
      return;
    case 3: 
      f(paramArrayOfObject);
      a(false);
      return;
    case 1: 
      h(paramArrayOfObject);
      a(false);
      return;
    case 2: 
      e(paramArrayOfObject);
      a(false);
      return;
    case -1: 
      AEQLog.d("VideoStoryCapturePart", "【onPhotoEnd】editType undefined");
      return;
    }
    AEQLog.b("VideoStoryCapturePart", "enterPhotoEditByConfig: no need edit");
    a((AEPhotoCaptureResult)paramArrayOfObject[0]);
  }
  
  private void d()
  {
    e();
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setCaptureRequest(new VideoStoryCapturePart.12(this));
  }
  
  private void d(Object[] paramArrayOfObject)
  {
    Object localObject = this.mActivity.getIntent();
    int i;
    if (AECameraEntry.g((Intent)localObject))
    {
      localObject = new StringBuilder().append("enterPhotoEditByEntry:  fromAIO args = ");
      if (paramArrayOfObject != null) {}
      for (i = paramArrayOfObject.length;; i = 0)
      {
        AEQLog.a("VideoStoryCapturePart", i);
        h(paramArrayOfObject);
        a(false);
        return;
      }
    }
    if (AECameraEntry.k((Intent)localObject))
    {
      localObject = new StringBuilder().append("enterPhotoEditByEntry:  fromCircle args = ");
      if (paramArrayOfObject != null) {}
      for (i = paramArrayOfObject.length;; i = 0)
      {
        AEQLog.a("VideoStoryCapturePart", i);
        g(paramArrayOfObject);
        a(false);
        return;
      }
    }
    if (AECameraEntry.m((Intent)localObject))
    {
      h(paramArrayOfObject);
      a(false);
      return;
    }
    if ((AECameraEntry.e((Intent)localObject)) || (!AECameraEntry.a((Intent)localObject)))
    {
      localObject = new StringBuilder().append("enterPhotoEditByEntry:  isFromCheckEntry args = ");
      if (paramArrayOfObject != null) {}
      for (i = paramArrayOfObject.length;; i = 0)
      {
        AEQLog.a("VideoStoryCapturePart", i);
        e(paramArrayOfObject);
        a(false);
        return;
      }
    }
    if ((AECameraEntry.i((Intent)localObject)) || (AECameraEntry.j((Intent)localObject)))
    {
      localObject = new StringBuilder().append("enterPhotoEditByEntry:  isFromQudongTakeFace args = ");
      if (paramArrayOfObject != null) {}
      for (i = paramArrayOfObject.length;; i = 0)
      {
        AEQLog.a("VideoStoryCapturePart", i);
        f(paramArrayOfObject);
        a(false);
        return;
      }
    }
    AEQLog.d("VideoStoryCapturePart", "【enterPhotoEditByEntry】: wrong entry: " + AECameraEntry.a((Intent)localObject));
    ((Intent)localObject).putExtra("VIDEO_STORY_JUMP_TO_TYPE", 1);
    e(paramArrayOfObject);
    a(false);
  }
  
  private void e()
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setCaptureRequest(null);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Long = 0L;
  }
  
  private void e(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length < 3))
    {
      AEQLog.d("VideoStoryCapturePart", "【openVideoEditorWithPhoto】args is null or args.length is less than 3");
      return;
    }
    AEPhotoCaptureResult localAEPhotoCaptureResult = (AEPhotoCaptureResult)paramArrayOfObject[0];
    Integer localInteger = (Integer)paramArrayOfObject[1];
    paramArrayOfObject = (Integer)paramArrayOfObject[2];
    if (QLog.isColorLevel()) {
      QLog.d("camera_log_tag_photo", 2, "in normal photo end.");
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("KEY_PIC_TO_VIDEO_LOCAL_PIC_PATH", localAEPhotoCaptureResult.jdField_a_of_type_JavaLangString);
    LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
    localLocalMediaInfo.mMimeType = "pic";
    this.mActivity.getIntent().putExtra("VIDEO_STORY_MEDIA_TYPE", 101);
    QQStoryFlowCallback.a(this.mActivity, localAEPhotoCaptureResult.jdField_a_of_type_JavaLangString, localLocalMediaInfo, 0, (int)localLocalMediaInfo.mDuration, -1, 10023, 0, null, null, false, localInteger.intValue(), paramArrayOfObject.intValue(), localBundle);
  }
  
  private void f(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length < 1))
    {
      AEQLog.d("VideoStoryCapturePart", "[openPhotoPreview] args must not be null or length < 1!");
      return;
    }
    paramArrayOfObject = (AEPhotoCaptureResult)paramArrayOfObject[0];
    Intent localIntent = new Intent();
    localIntent.putExtra("VIDEO_STORY_FROM_TYPE", AECameraEntry.a(this.mActivity.getIntent()));
    localIntent.putExtra("photo_path", paramArrayOfObject.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("key_disable_face_detect", this.mActivity.getIntent().getBooleanExtra("key_disable_face_detect", false));
    localIntent.putExtra("key_need_check_sensitive", this.mActivity.getIntent().getBooleanExtra("key_need_check_sensitive", false));
    AETakeFacePhotoPreviewFragment.jumpToMeForResult(this.mActivity, localIntent, 1024);
  }
  
  private void g(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length < 1))
    {
      AEQLog.d("VideoStoryCapturePart", "[openAEEditorWithPhoto]: args must not be null or length < 1!");
      return;
    }
    AEQLog.b("VideoStoryCapturePart", "[PhotoEnd] ready to enter EditorActivity");
    paramArrayOfObject = (AEPhotoCaptureResult)paramArrayOfObject[0];
    Bundle localBundle = new Bundle();
    Object localObject2 = new ArrayList();
    Object localObject1 = new EditorPicInfo();
    Object localObject3 = BitmapUtil.getImageSize(paramArrayOfObject.jdField_a_of_type_JavaLangString);
    ((EditorPicInfo)localObject1).picPath = paramArrayOfObject.jdField_a_of_type_JavaLangString;
    ((EditorPicInfo)localObject1).originPicHeight = ((com.tencent.tavcut.bean.Size)localObject3).getHeight();
    ((EditorPicInfo)localObject1).originPicWidth = ((com.tencent.tavcut.bean.Size)localObject3).getWidth();
    ((EditorPicInfo)localObject1).x = 0.0D;
    ((EditorPicInfo)localObject1).y = 0.0D;
    ((EditorPicInfo)localObject1).h = 1.0D;
    ((EditorPicInfo)localObject1).w = 1.0D;
    ((ArrayList)localObject2).add(localObject1);
    localBundle.putSerializable("AEEditorConstants_CLIPPED_PIC_INFOS", (Serializable)localObject2);
    localBundle.putBoolean("BUNDLE_KEY_CIRCLE_CAN_PICK_VIDEO", this.mActivity.getIntent().getBooleanExtra("BUNDLE_KEY_CIRCLE_CAN_PICK_VIDEO", true));
    localObject2 = this.mActivity.getIntent().getStringExtra("material_id");
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localBundle.putString("material_id", (String)localObject2);
      localBundle.putString("material_topic", this.mActivity.getIntent().getStringExtra("material_topic"));
      localBundle.putString("key_camera_material_name", this.mActivity.getIntent().getStringExtra("key_camera_material_name"));
      this.mActivity.getIntent().removeExtra("material_id");
      this.mActivity.getIntent().removeExtra("material_topic");
      this.mActivity.getIntent().removeExtra("key_camera_material_name");
    }
    localBundle.putInt("ae_editor_is_show_take_same", this.mActivity.getIntent().getIntExtra("ae_editor_is_show_take_same", 0));
    localObject2 = new ArrayList();
    localObject3 = new AEPhotoCropInfoWrapper();
    ((AEPhotoCropInfoWrapper)localObject3).a = ((EditorPicInfo)localObject1);
    localObject1 = new AEAlbumImageModel(paramArrayOfObject.jdField_a_of_type_JavaLangString, ((AEPhotoCropInfoWrapper)localObject3).a);
    ((AEAlbumImageModel)localObject1).setOriginPath(paramArrayOfObject.jdField_a_of_type_JavaLangString);
    ((ArrayList)localObject2).add(localObject1);
    localBundle.putSerializable("ae_album_selected_media_models", (Serializable)localObject2);
    this.mActivity.getIntent().removeExtra("ae_editor_is_show_take_same");
    if (AECameraEntry.n(this.mActivity.getIntent()))
    {
      paramArrayOfObject = new Intent();
      paramArrayOfObject.putExtra("ae_album_selected_media_models", (Serializable)localObject2);
      this.mActivity.setResult(-1, paramArrayOfObject);
      this.mActivity.finish();
      return;
    }
    int i = c();
    AEEditorLauncher.a(this.mActivity, 0, localBundle, i);
    AEBaseReportParam.a().a().jdField_b_of_type_Long = AEBaseReportParam.b.longValue();
    AEBaseReportParam.a().a().jdField_a_of_type_JavaLangString = AEBaseReportParam.a().b();
    AEBaseDataReporter.a().a(1);
  }
  
  private void h(Object[] paramArrayOfObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("camera_log_tag_photo", 2, "in aio photo end.");
    }
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length >= 3))
    {
      AEPhotoCaptureResult localAEPhotoCaptureResult = (AEPhotoCaptureResult)paramArrayOfObject[0];
      CaptureEntranceParams localCaptureEntranceParams = (CaptureEntranceParams)paramArrayOfObject[1];
      paramArrayOfObject = (Integer)paramArrayOfObject[2];
      AEQLog.d("VideoStoryCapturePart", "[openPicEditor]: result = " + localAEPhotoCaptureResult + " editFrom = " + paramArrayOfObject + " entranceParams.businessType = " + localCaptureEntranceParams.jdField_c_of_type_Int);
      JumpUtil.a(this.mActivity, localAEPhotoCaptureResult, localCaptureEntranceParams, null, paramArrayOfObject.intValue());
      return;
    }
    AEQLog.d("VideoStoryCapturePart", "[openPicEditor]:args == null or args.length < 3!");
  }
  
  public <T> T get(int paramInt, Object... paramVarArgs)
  {
    return super.get(paramInt, paramVarArgs);
  }
  
  public void initView()
  {
    this.jdField_d_of_type_Boolean = AECameraEntry.k(this.mActivity.getIntent());
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView = ((AECameraGLSurfaceView)this.mRootView.findViewById(2131364338));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.mRootView.findViewById(2131367171));
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_ComTencentBizVideostorySupportVideoStoryDataBean = new VideoStoryDataBean();
    this.jdField_b_of_type_Int = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
    this.jdField_c_of_type_Int = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
    if (ScreenUtil.a(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int)) {
      this.jdField_b_of_type_Int = (this.jdField_c_of_type_Int * 9 / 16);
    }
    int i = DisplayUtil.a(this.mActivity, 700.0F);
    if (this.jdField_c_of_type_Int < i)
    {
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_Boolean)
      {
        int j = DisplayUtil.a(this.mActivity, 600.0F);
        if (this.jdField_c_of_type_Int >= j) {
          break label265;
        }
      }
    }
    label265:
    float f;
    for (this.jdField_d_of_type_Int = DisplayUtil.a(this.mActivity, 58.799999F);; this.jdField_d_of_type_Int = DisplayUtil.a(this.mActivity, 147.0F - f * 88.199997F))
    {
      if (this.jdField_d_of_type_Int < DisplayUtil.a(this.mActivity, 110.0F))
      {
        this.jdField_b_of_type_Boolean = true;
        if (this.jdField_d_of_type_Int < DisplayUtil.a(this.mActivity, 92.0F)) {
          this.jdField_d_of_type_Int += DisplayUtil.a(this.mActivity, 12.0F);
        }
      }
      b();
      return;
      this.jdField_a_of_type_Boolean = false;
      break;
      f = (i - this.jdField_c_of_type_Int) / DisplayUtil.a(this.mActivity, 100.0F);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1026)
    {
      AEQLog.b("VideoStoryCapturePart", "onActivityResult--REQUEST_CODE_SKIP_EDIT_SAVE_VIDEO--resultCode=" + paramInt2);
      a(false);
      if (paramInt2 == -1)
      {
        Object localObject2 = this.mActivity.getIntent();
        if (AECameraEntry.f((Intent)localObject2))
        {
          AEQLog.b("VideoStoryCapturePart", "onActivityResult---success--from playMiniApp");
          Object localObject1 = paramIntent.getStringExtra("key_video_save_path");
          paramIntent = paramIntent.getStringExtra("thumbfile_send_path");
          Intent localIntent = new Intent();
          localIntent.setAction("com.tencent.mobileqq.mini.out.nativePlugins.native_back");
          localIntent.putExtra("file_path", (String)localObject1);
          localIntent.putExtra("video_thumb_path", paramIntent);
          localIntent.putExtra("is_video", true);
          localObject1 = this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.a();
          paramIntent = (Intent)localObject1;
          if (localObject1 == null) {
            paramIntent = new HashMap();
          }
          localObject1 = ((Intent)localObject2).getStringExtra("widgetinfo");
          localObject2 = a((String)localObject1);
          AEQLog.a("VideoStoryCapturePart", "handleNoNeedEditVideo---widgetId=" + (String)localObject2 + ", widgetInfo=" + (String)localObject1);
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            paramIntent.put("extra_info_key_widget_id", localObject2);
          }
          localIntent.putExtra("extra_info", paramIntent);
          this.mActivity.sendBroadcast(localIntent);
          this.mActivity.setResult(-1, localIntent);
          this.mActivity.finish();
        }
      }
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.e("VideoStoryCapturePart", 2, "onDestroy()");
    }
    SendPanelManager.a().onDestroy();
    super.onDestroy();
    a(false);
  }
  
  public void send(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 262145: 
      d();
      return;
    case 262146: 
      a(paramVarArgs);
      return;
    case 262147: 
      c();
      return;
    }
    b(paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.capture.VideoStoryCapturePart
 * JD-Core Version:    0.7.0.1
 */