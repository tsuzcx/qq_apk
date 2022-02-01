package dov.com.qq.im.ae.camera.ui;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.widget.bubble.BubbleTextView;
import com.tencent.biz.videostory.capture.widgets.SquareRoundImageView;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.qcircle.utils.QCircleUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qcircle.api.IQCircleService;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.openapi.initializer.PagInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import dov.com.qq.im.AEReportUtils;
import dov.com.qq.im.ae.AECameraConfig;
import dov.com.qq.im.ae.AEPath.CAMERA.FILES;
import dov.com.qq.im.ae.AEPituCameraUnit;
import dov.com.qq.im.ae.AEPituCameraUnit.ViewStubHoldersViewModel;
import dov.com.qq.im.ae.AEViewModelProviders;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialPanel;
import dov.com.qq.im.ae.camera.ui.panel.AEWaterMarkPanel;
import dov.com.qq.im.ae.camera.ui.panel.BeautyAndFilterPanelViewStubHolder;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;
import dov.com.qq.im.ae.data.AEMaterialManager;
import dov.com.qq.im.ae.data.AEMaterialMetaData;
import dov.com.qq.im.ae.data.AEMaterialWrapper;
import dov.com.qq.im.ae.entry.AECameraEntry;
import dov.com.qq.im.ae.gif.AEVideoStoryGIFTplViewModel;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.mode.AEVideoStoryCaptureModeViewModel;
import dov.com.qq.im.ae.part.AEVideoStoryStateViewModel;
import dov.com.qq.im.ae.part.VideoStoryBasePart;
import dov.com.qq.im.ae.part.VideoStoryCapturePartManager;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.util.AECameraPrefsUtil;
import dov.com.qq.im.ae.util.AEFastClickThrottle;
import dov.com.qq.im.ae.util.AEPreviewSizeUtil;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.ae.util.AEThemeUtil;
import dov.com.qq.im.ae.view.AECircleCaptureStyle;
import dov.com.qq.im.ae.view.AECompoundButton;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.view.CountDownView;
import dov.com.tencent.mobileqq.richmedia.capture.view.AbsAECaptureButton;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import org.libpag.PAGFile;
import org.libpag.PAGView;

public class VideoStoryPiecesPart
  extends VideoStoryBasePart
  implements View.OnClickListener
{
  private static int jdField_a_of_type_Int = 20000;
  private static int jdField_b_of_type_Int = 4000;
  private static String h = "pendent_pag";
  private static final String i = AEPath.CAMERA.FILES.g + File.separator + "pendent.pag";
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BubbleTextView jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView;
  private SquareRoundImageView jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private AEPituCameraUnit jdField_a_of_type_DovComQqImAeAEPituCameraUnit;
  private AECameraGLSurfaceView jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView;
  private AEMaterialPanel jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel;
  private AEWaterMarkPanel jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel;
  private BeautyAndFilterPanelViewStubHolder jdField_a_of_type_DovComQqImAeCameraUiPanelBeautyAndFilterPanelViewStubHolder;
  private AEVideoStoryTopBarViewModel jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel;
  private AEVideoStoryGIFTplViewModel jdField_a_of_type_DovComQqImAeGifAEVideoStoryGIFTplViewModel;
  private AECaptureMode jdField_a_of_type_DovComQqImAeModeAECaptureMode;
  private AEVideoStoryCaptureModeViewModel jdField_a_of_type_DovComQqImAeModeAEVideoStoryCaptureModeViewModel;
  private AEVideoStoryStateViewModel jdField_a_of_type_DovComQqImAePartAEVideoStoryStateViewModel;
  private AECompoundButton jdField_a_of_type_DovComQqImAeViewAECompoundButton;
  private CountDownView jdField_a_of_type_DovComQqImCaptureViewCountDownView;
  private AbsAECaptureButton jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton;
  private String jdField_a_of_type_JavaLangString;
  private PAGView jdField_a_of_type_OrgLibpagPAGView;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private AECompoundButton jdField_b_of_type_DovComQqImAeViewAECompoundButton;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = AEThemeUtil.a();
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean = false;
  private String jdField_f_of_type_JavaLangString;
  private boolean jdField_f_of_type_Boolean;
  private String g;
  
  public VideoStoryPiecesPart(Activity paramActivity, View paramView, VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    super(paramActivity, paramView, paramVideoStoryCapturePartManager);
    this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit = ((AEPituCameraUnit)paramVideoStoryCapturePartManager.a(65537, new Object[0]));
    if (AECameraEntry.g(paramActivity.getIntent())) {
      jdField_a_of_type_Int = 20000;
    }
    this.jdField_c_of_type_Int = AECameraEntry.a(this.mActivity.getIntent());
  }
  
  private void A()
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelBeautyAndFilterPanelViewStubHolder != null)
    {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelBeautyAndFilterPanelViewStubHolder.b();
      this.jdField_a_of_type_DovComQqImAePartAEVideoStoryStateViewModel.c().postValue(Boolean.valueOf(true));
    }
  }
  
  private void B()
  {
    int j = UIUtils.a(this.mActivity, this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.getHeight());
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel, "translationY", new float[] { 0.0F, j });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator);
    localAnimatorSet.addListener(new VideoStoryPiecesPart.17(this));
    localAnimatorSet.setDuration(300L).start();
  }
  
  public static AECircleCaptureStyle a(AEVideoStoryTopBarViewModel.Ratio paramRatio)
  {
    if (paramRatio == AEVideoStoryTopBarViewModel.Ratio.R_1_1) {
      return AECircleCaptureStyle.a;
    }
    if (paramRatio == AEVideoStoryTopBarViewModel.Ratio.R_4_3)
    {
      int j = AEPreviewSizeUtil.a();
      if (j == 2) {
        return AECircleCaptureStyle.c;
      }
      if (j == 1) {
        return AECircleCaptureStyle.d;
      }
      return AECircleCaptureStyle.b;
    }
    return AECircleCaptureStyle.b;
  }
  
  private void a(@NonNull AECircleCaptureStyle paramAECircleCaptureStyle)
  {
    if (!this.jdField_d_of_type_Boolean) {}
    do
    {
      return;
      if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton != null) {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton.a(true, paramAECircleCaptureStyle);
      }
    } while (this.jdField_a_of_type_DovComQqImAeViewAECompoundButton == null);
    this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setForegroundAndBackgroundResource(paramAECircleCaptureStyle.r, paramAECircleCaptureStyle.q);
  }
  
  private void a(String paramString)
  {
    AEQLog.a("VideoStoryPiecesPart", "[GifAuthor]---showGifAuthor: author=" + paramString);
    if (this.jdField_a_of_type_AndroidWidgetTextView == null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((ViewStub)this.mRootView.findViewById(2131378592)).inflate());
      this.jdField_a_of_type_AndroidWidgetTextView.setTranslationY(this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.getY() - UIUtils.a(this.mActivity, 24.0F));
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.mActivity.getString(2131689775, new Object[] { paramString }));
  }
  
  private boolean a()
  {
    return (AECameraEntry.d(this.jdField_c_of_type_Int)) || (AECameraEntry.c(this.jdField_c_of_type_Int)) || (AECameraEntry.b(this.jdField_c_of_type_Int)) || (AECameraEntry.e(this.jdField_c_of_type_Int));
  }
  
  private void b(boolean paramBoolean)
  {
    if ((d()) && (paramBoolean))
    {
      this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setVisibility(8);
  }
  
  private boolean b()
  {
    return AECameraPrefsUtil.a().a(this.g, true, 4);
  }
  
  private void c()
  {
    String str;
    if (this.jdField_d_of_type_Boolean)
    {
      str = this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.a().getIntent().getStringExtra("KEY_CURRENT_SELECT_ID");
      if ((TextUtils.isEmpty(str)) || (!str.startsWith("http"))) {}
    }
    try
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.a(), QQBrowserActivity.class);
      localIntent.putExtra("url", URLDecoder.decode(str, "UTF-8"));
      localIntent.putExtra("loc_play_show_material_id", str);
      localIntent.putExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", AECameraEntry.x.a());
      localIntent.putExtra("VIDEO_STORY_FROM_TYPE", AECameraEntry.J.a());
      this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.a().startActivityForResult(localIntent, 1025);
      this.mActivity.getIntent().removeExtra("KEY_CURRENT_SELECT_ID");
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentImageURLImageView == null) || (!this.jdField_e_of_type_Boolean) || (!this.jdField_a_of_type_DovComQqImAeModeAEVideoStoryCaptureModeViewModel.b())) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
  }
  
  private boolean c()
  {
    return (this.mActivity != null) && (!AECameraEntry.e(this.mActivity.getIntent())) && (!AECameraEntry.f(this.mActivity.getIntent())) && (!AECameraEntry.g(this.mActivity.getIntent())) && (!AECameraEntry.i(this.mActivity.getIntent())) && (!AECameraEntry.j(this.mActivity.getIntent())) && (!AECameraEntry.k(this.mActivity.getIntent())) && (this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.b().b());
  }
  
  private void d()
  {
    if (this.mRootView == null) {}
    do
    {
      return;
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.mRootView.findViewById(2131380158));
    } while (this.jdField_b_of_type_AndroidWidgetTextView == null);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
  }
  
  private boolean d()
  {
    return (this.mActivity != null) && (!AECameraEntry.i(this.mActivity.getIntent())) && (!AECameraEntry.j(this.mActivity.getIntent())) && (this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.b().e());
  }
  
  private void e()
  {
    h();
    f();
  }
  
  private boolean e()
  {
    if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode != AECaptureMode.NORMAL) {
      return false;
    }
    Boolean localBoolean = (Boolean)this.jdField_a_of_type_DovComQqImAePartAEVideoStoryStateViewModel.a().getValue();
    if ((localBoolean != null) && (!localBoolean.booleanValue())) {
      return false;
    }
    localBoolean = (Boolean)this.jdField_a_of_type_DovComQqImAePartAEVideoStoryStateViewModel.b().getValue();
    if ((localBoolean != null) && (localBoolean.booleanValue())) {
      return false;
    }
    localBoolean = (Boolean)this.jdField_a_of_type_DovComQqImAePartAEVideoStoryStateViewModel.c().getValue();
    if ((localBoolean != null) && (localBoolean.booleanValue())) {
      return false;
    }
    int j = AECameraEntry.a(this.mActivity.getIntent());
    if ((AECameraEntry.e(j)) || (AECameraEntry.h(j)) || (AECameraEntry.c(j)) || (AECameraEntry.b(j))) {
      return false;
    }
    if (AECameraPrefsUtil.a().a("sp_key_ae_comics_gif_tips", false, 0))
    {
      AEQLog.b("VideoStoryPiecesPart", "[ComicsTips]--has shown");
      return false;
    }
    return true;
  }
  
  private void f()
  {
    try
    {
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.mRootView.findViewById(2131369462));
      if (this.jdField_e_of_type_Boolean)
      {
        g();
        a();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void g()
  {
    ViewStub localViewStub = (ViewStub)this.mRootView.findViewById(2131378601);
    if (localViewStub != null) {
      localViewStub.setOnInflateListener(new VideoStoryPiecesPart.1(this));
    }
    if (this.jdField_a_of_type_ComTencentImageURLImageView != null) {
      this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(new VideoStoryPiecesPart.2(this));
    }
  }
  
  private void h()
  {
    i();
    if (this.jdField_e_of_type_Boolean)
    {
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_b_of_type_JavaLangString = AECameraPrefsUtil.a().a("circle_camera_ad_icon_url", "", 4);
        this.jdField_c_of_type_JavaLangString = AECameraPrefsUtil.a().a("circle_camera_ad_schema", "", 4);
      }
    }
    else {
      return;
    }
    this.jdField_b_of_type_JavaLangString = AECameraPrefsUtil.a().a("camera_ad_icon_url", "", 4);
    this.jdField_c_of_type_JavaLangString = AECameraPrefsUtil.a().a("camera_ad_schema", "", 4);
  }
  
  private void i()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_e_of_type_Boolean = AECameraPrefsUtil.a().a("circle_camera_ad_show", false, 4);
      this.jdField_a_of_type_JavaLangString = AECameraPrefsUtil.a().a("circle_camera_ad_type", "", 4);
      AEQLog.b("VideoStoryPiecesPart", "isPresent: " + this.jdField_e_of_type_Boolean + " type: " + this.jdField_a_of_type_JavaLangString);
      if (("h5".equals(this.jdField_a_of_type_JavaLangString)) || ("widget".equals(this.jdField_a_of_type_JavaLangString))) {
        break label148;
      }
      this.jdField_e_of_type_Boolean = false;
    }
    label148:
    while (!a())
    {
      return;
      this.jdField_e_of_type_Boolean = AECameraPrefsUtil.a().a("camera_ad_show", false, 4);
      this.jdField_a_of_type_JavaLangString = AECameraPrefsUtil.a().a("camera_ad_type", "", 4);
      break;
    }
    this.jdField_e_of_type_Boolean = "h5".equals(this.jdField_a_of_type_JavaLangString);
  }
  
  private void j()
  {
    AEQLog.b("VideoStoryPiecesPart", "content entry present.");
    if ((this.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentImageURLImageView.getDrawable() != null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    if ((this.jdField_b_of_type_JavaLangString != null) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {
      try
      {
        AEQLog.b("VideoStoryPiecesPart", "in url drawable set：" + this.jdField_b_of_type_JavaLangString);
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.mActivity.getResources().getDrawable(2131167305);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.mActivity.getResources().getDrawable(2131167305);
        localObject = URLDrawable.getDrawable(this.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
        return;
      }
      catch (Exception localException)
      {
        AEQLog.d("VideoStoryPiecesPart", "url error url: " + this.jdField_b_of_type_JavaLangString);
        return;
      }
    }
    AEQLog.b("VideoStoryPiecesPart", "iconUrl is empty.");
  }
  
  private void k()
  {
    if ((this.jdField_a_of_type_ComTencentImageURLImageView != null) && (this.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() != 0)) {
      AEBaseDataReporter.a().Q();
    }
  }
  
  private void l()
  {
    this.jdField_a_of_type_AndroidViewView = this.mRootView.findViewById(2131367457);
    this.jdField_b_of_type_AndroidViewView = this.mRootView.findViewById(2131367171);
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView = ((AECameraGLSurfaceView)this.mRootView.findViewById(2131364338));
    if (((Long)VSConfigManager.a().a("ShootingResolution", Long.valueOf(0L))).longValue() > 0L) {
      QLog.d("Q.videostory.capture", 4, "intercept previewCheck use 720P");
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton = ((AbsAECaptureButton)this.mRootView.findViewById(2131364388));
    this.jdField_a_of_type_Boolean = ((String)VSConfigManager.a().a("enable_click_take_picture", "1")).equals("1");
    this.jdField_b_of_type_Boolean = this.mActivity.getIntent().getBooleanExtra("input_full_screen_mode", false);
    b();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton.setMaxDuration(a(AECaptureMode.NORMAL));
  }
  
  private void m()
  {
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel = ((AEWaterMarkPanel)this.mRootView.findViewById(2131373622));
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel == null) {
      return;
    }
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel.setCaptureController(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.a());
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel.setPartManager(this.mPartManager);
  }
  
  private void n()
  {
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView = ((SquareRoundImageView)this.mRootView.findViewById(2131370775));
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView.post(new VideoStoryPiecesPart.3(this));
    if (c())
    {
      this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView.setDrawChecked(false);
      this.jdField_a_of_type_DovComQqImAeViewAECompoundButton = ((AECompoundButton)this.mRootView.findViewById(2131364162));
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel = ((AEMaterialPanel)this.mRootView.findViewById(2131373621));
      o();
      if (!d()) {
        break label219;
      }
      if (this.jdField_d_of_type_Boolean) {
        break label191;
      }
      String str = this.jdField_d_of_type_JavaLangString;
      this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.post(new VideoStoryPiecesPart.4(this, str));
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setOnClickListener(this);
      this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setVisibility(0);
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setPartManager(this.mPartManager);
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setCaptureController(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.a());
      return;
      this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsSquareRoundImageView.setVisibility(4);
      break;
      label191:
      this.jdField_b_of_type_DovComQqImAeViewAECompoundButton = ((AECompoundButton)this.mRootView.findViewById(2131369471));
      this.jdField_b_of_type_DovComQqImAeViewAECompoundButton.setOnClickListener(this);
    }
    label219:
    this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.setVisibility(8);
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setVisibility(8);
  }
  
  private void o()
  {
    this.jdField_f_of_type_Boolean = AECameraPrefsUtil.a().a("camera_ad_pendent_show", false, 4);
    this.jdField_d_of_type_JavaLangString = AECameraPrefsUtil.a().a("camera_ad_pendent_icon_url", "", 4);
    this.jdField_f_of_type_JavaLangString = AECameraPrefsUtil.a().a("camera_ad_pendent_icon_type", "", 4);
    this.jdField_d_of_type_Int = AECameraPrefsUtil.a().a("camera_ad_pendent_categoryId", -1, 4);
    this.g = AECameraPrefsUtil.a().a("camera_ad_pendent_op_id", "", 4);
    this.jdField_e_of_type_JavaLangString = AECameraPrefsUtil.a().a("camera_ad_pendent_schema", "", 4);
    AEQLog.a("VideoStoryPiecesPart", "entry dynamics: icon type " + this.jdField_f_of_type_JavaLangString + " url:" + this.jdField_d_of_type_JavaLangString + " type :" + this.jdField_f_of_type_Boolean + " category id: " + this.jdField_d_of_type_Int + " OPID: " + this.g + " scheme: " + this.jdField_e_of_type_JavaLangString);
  }
  
  private void p()
  {
    if (FileUtils.b(i))
    {
      AEQLog.a("VideoStoryPiecesPart", "entry dynamics: not download ");
      q();
      return;
    }
    AEMaterialManager localAEMaterialManager = (AEMaterialManager)QIMManager.a(18);
    AEMaterialMetaData localAEMaterialMetaData = new AEMaterialMetaData();
    localAEMaterialMetaData.jdField_d_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    localAEMaterialMetaData.jdField_f_of_type_JavaLangString = "pendent.pag";
    localAEMaterialMetaData.jdField_a_of_type_JavaLangString = h;
    localAEMaterialManager.a(localAEMaterialManager.getApp(), AEPath.CAMERA.FILES.g, localAEMaterialMetaData, new VideoStoryPiecesPart.5(this));
  }
  
  private void q()
  {
    if (!FeatureManager.Features.PAG.init())
    {
      AEQLog.d("VideoStoryPiecesPart", "entry dynamics: pag not init");
      this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.a().setImageResource(2130837711);
    }
    do
    {
      PAGFile localPAGFile;
      do
      {
        return;
        localPAGFile = PAGFile.Load(i);
        this.jdField_a_of_type_OrgLibpagPAGView = new PAGView(BaseApplication.getContext());
        ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
        this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.addView(this.jdField_a_of_type_OrgLibpagPAGView, localLayoutParams);
        this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.a().setImageDrawable(this.mActivity.getResources().getDrawable(2131167305));
      } while ((this.jdField_a_of_type_OrgLibpagPAGView == null) || (localPAGFile == null));
      this.jdField_a_of_type_OrgLibpagPAGView.setFile(localPAGFile);
      this.jdField_a_of_type_OrgLibpagPAGView.setRepeatCount(0);
    } while (this.jdField_a_of_type_OrgLibpagPAGView.isPlaying());
    AEQLog.d("VideoStoryPiecesPart", "entry dynamics: pag  play");
    this.jdField_a_of_type_OrgLibpagPAGView.play();
  }
  
  private void r()
  {
    if ("pag".equals(this.jdField_f_of_type_JavaLangString)) {
      p();
    }
    for (;;)
    {
      AEBaseDataReporter.a().i(this.jdField_e_of_type_JavaLangString);
      return;
      if ("static".equals(this.jdField_f_of_type_JavaLangString))
      {
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.mActivity.getResources().getDrawable(2131167305);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.mActivity.getResources().getDrawable(2131167305);
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.getLayoutParams().width;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.getLayoutParams().height;
        ((URLDrawable.URLDrawableOptions)localObject).mUseAutoScaleParams = true;
        localObject = URLDrawable.getDrawable(this.jdField_d_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
        this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.a().setImageDrawable((Drawable)localObject);
      }
    }
  }
  
  private void s()
  {
    if (this.jdField_a_of_type_DovComQqImCaptureViewCountDownView != null) {
      return;
    }
    this.jdField_a_of_type_DovComQqImCaptureViewCountDownView = ((CountDownView)((ViewStub)this.mRootView.findViewById(2131362264)).inflate().findViewById(2131362266));
    this.jdField_a_of_type_DovComQqImCaptureViewCountDownView.setCountDownListener(new VideoStoryPiecesPart.6(this));
  }
  
  private void t()
  {
    this.jdField_a_of_type_DovComQqImAeGifAEVideoStoryGIFTplViewModel = ((AEVideoStoryGIFTplViewModel)AEViewModelProviders.a(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit).get(AEVideoStoryGIFTplViewModel.class));
    this.jdField_a_of_type_DovComQqImAeModeAEVideoStoryCaptureModeViewModel = ((AEVideoStoryCaptureModeViewModel)AEViewModelProviders.a(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit).get(AEVideoStoryCaptureModeViewModel.class));
    this.jdField_a_of_type_DovComQqImAePartAEVideoStoryStateViewModel = ((AEVideoStoryStateViewModel)AEViewModelProviders.a(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit).get(AEVideoStoryStateViewModel.class));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel = ((AEVideoStoryTopBarViewModel)AEViewModelProviders.a(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit).get(AEVideoStoryTopBarViewModel.class));
    this.jdField_a_of_type_DovComQqImAeGifAEVideoStoryGIFTplViewModel.b().observe(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit, new VideoStoryPiecesPart.7(this));
    this.jdField_a_of_type_DovComQqImAeModeAEVideoStoryCaptureModeViewModel.a.observe(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit, new VideoStoryPiecesPart.8(this));
    this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.a().observe(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit, new VideoStoryPiecesPart.9(this));
    if (this.jdField_d_of_type_Boolean) {
      this.jdField_a_of_type_DovComQqImAeCameraUiTopbarAEVideoStoryTopBarViewModel.a.observe(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit, new VideoStoryPiecesPart.10(this));
    }
    this.jdField_a_of_type_DovComQqImAePartAEVideoStoryStateViewModel.a().observe(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit, new VideoStoryPiecesPart.11(this));
    this.jdField_a_of_type_DovComQqImAePartAEVideoStoryStateViewModel.b().postValue(Boolean.valueOf(false));
    this.jdField_a_of_type_DovComQqImAePartAEVideoStoryStateViewModel.c().postValue(Boolean.valueOf(false));
    ((AEPituCameraUnit.ViewStubHoldersViewModel)AEViewModelProviders.a(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit).get(AEPituCameraUnit.ViewStubHoldersViewModel.class)).a.observe(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit, new VideoStoryPiecesPart.12(this));
    this.jdField_a_of_type_DovComQqImAePartAEVideoStoryStateViewModel.b().observe(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit, new VideoStoryPiecesPart.13(this));
    this.jdField_a_of_type_DovComQqImAePartAEVideoStoryStateViewModel.c().observe(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit, new VideoStoryPiecesPart.14(this));
  }
  
  private void u()
  {
    if (e()) {
      v();
    }
    while (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.clearAnimation();
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setVisibility(4);
  }
  
  private void v()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView = new BubbleTextView(this.mActivity);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setPadding(UIUtils.a(this.mActivity, 10.0F), UIUtils.a(this.mActivity, 11.0F), UIUtils.a(this.mActivity, 10.0F), UIUtils.a(this.mActivity, 11.0F));
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setIncludeFontPadding(false);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setTextSize(1, 14.0F);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setTextColor(Color.parseColor("#03081A"));
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.b = UIUtils.a(this.mActivity, 6.0F);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setText(this.mActivity.getString(2131689701));
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.a();
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.setVisibility(4);
      RelativeLayout localRelativeLayout = (RelativeLayout)this.mRootView.findViewById(2131377202);
      if (localRelativeLayout != null)
      {
        ViewParent localViewParent = localRelativeLayout.getParent();
        if ((localViewParent instanceof RelativeLayout))
        {
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.addRule(2, 2131377202);
          localLayoutParams.bottomMargin = UIUtils.a(this.mActivity, -8.0F);
          ((RelativeLayout)localViewParent).addView(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView, ((RelativeLayout)localViewParent).indexOfChild(localRelativeLayout), localLayoutParams);
        }
      }
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView.postDelayed(new VideoStoryPiecesPart.15(this), 200L);
  }
  
  private void w()
  {
    if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode != AECaptureMode.GIF)
    {
      x();
      AEQLog.a("VideoStoryPiecesPart", "[GifAuthor]---hideGifAuthor because not gif mode");
      return;
    }
    Object localObject = (Boolean)this.jdField_a_of_type_DovComQqImAePartAEVideoStoryStateViewModel.a().getValue();
    if ((localObject != null) && (!((Boolean)localObject).booleanValue()))
    {
      x();
      AEQLog.a("VideoStoryPiecesPart", "[GifAuthor]---hideGifAuthor because not allow show other buttons");
      return;
    }
    localObject = (AEMaterialWrapper)this.jdField_a_of_type_DovComQqImAeGifAEVideoStoryGIFTplViewModel.b().getValue();
    if ((localObject == null) || (((AEMaterialWrapper)localObject).a == null))
    {
      x();
      AEQLog.a("VideoStoryPiecesPart", "[GifAuthor]---hideGifAuthor because not apply material");
      return;
    }
    localObject = (String)((AEMaterialWrapper)localObject).a.additionalFields.get("gif_sponsor_name");
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      x();
      AEQLog.a("VideoStoryPiecesPart", "[GifAuthor]---hideGifAuthor because no author info");
      return;
    }
    a((String)localObject);
  }
  
  private void x()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  private void y()
  {
    ThreadManager.excute(new VideoStoryPiecesPart.16(this), 64, null, true);
  }
  
  private void z()
  {
    AEQLog.a("VideoStoryPiecesPart", "watermark openWaterMarkPanel");
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel == null) {}
    do
    {
      return;
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel.setVisibility(0);
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel.a();
    } while (!this.jdField_d_of_type_Boolean);
    AEReportUtils.a(8, null);
  }
  
  protected int a()
  {
    return this.mActivity.getResources().getDimensionPixelSize(2131296288);
  }
  
  protected int a(AECaptureMode paramAECaptureMode)
  {
    if ((this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit != null) && (this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.b().k() != -1)) {
      return this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.b().k();
    }
    if (paramAECaptureMode == AECaptureMode.GIF) {
      return jdField_b_of_type_Int;
    }
    return jdField_a_of_type_Int;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentImageURLImageView == null) {
      f();
    }
    if (!this.jdField_e_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() == 0) {
        this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      }
      AEQLog.a("VideoStoryPiecesPart", "hide camera content entry.");
      return;
    }
    if (AECameraEntry.h(this.jdField_c_of_type_Int))
    {
      j();
      return;
    }
    if (AECameraEntry.g(this.jdField_c_of_type_Int))
    {
      k();
      j();
      return;
    }
    if (a())
    {
      if ("h5".equals(AECameraPrefsUtil.a().a("camera_ad_type", "", 4)))
      {
        k();
        j();
        return;
      }
      if (this.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() == 0) {
        this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      }
      this.jdField_e_of_type_Boolean = false;
      return;
    }
    if (this.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() == 0) {
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    }
    this.jdField_e_of_type_Boolean = false;
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentImageURLImageView == null) || (!this.jdField_e_of_type_Boolean)) {
      return;
    }
    if (paramBoolean)
    {
      a();
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
  }
  
  protected void b()
  {
    int j = 1;
    if (this.mActivity != null)
    {
      if ((!AECameraEntry.i(this.mActivity.getIntent())) && (!AECameraEntry.j(this.mActivity.getIntent()))) {
        break label74;
      }
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton.setFunctionFlag(this.mActivity.getIntent().getIntExtra("ability_flag", 2));
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton.setFunctionFlag(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.b().b());
      return;
      label74:
      if (AECameraEntry.k(this.mActivity.getIntent()))
      {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton.setFunctionFlag(this.mActivity.getIntent().getIntExtra("ability_flag", 1));
      }
      else
      {
        if (!this.jdField_b_of_type_Boolean) {
          break;
        }
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton.setFunctionFlag(2);
      }
    }
    AbsAECaptureButton localAbsAECaptureButton = this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewAbsAECaptureButton;
    if (this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      localAbsAECaptureButton.setFunctionFlag(j);
      break;
      j = 3;
    }
  }
  
  public void initView()
  {
    this.jdField_d_of_type_Boolean = AECameraEntry.k(this.mActivity.getIntent());
    ViewStub localViewStub = (ViewStub)this.mRootView.findViewById(2131378585);
    if (localViewStub != null) {
      localViewStub.inflate();
    }
    l();
    n();
    m();
    t();
    c();
    e();
    d();
  }
  
  public void onActivityPause()
  {
    super.onActivityPause();
    if (this.jdField_a_of_type_DovComQqImCaptureViewCountDownView != null) {
      this.jdField_a_of_type_DovComQqImCaptureViewCountDownView.a();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (((paramInt1 == 10023) || (paramInt1 == 10006)) && (paramInt2 == -1))
    {
      if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel == null) {
        break label51;
      }
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.a(paramInt1, paramInt2, paramIntent);
    }
    for (;;)
    {
      if (this.mActivity != null) {
        this.mActivity.finish();
      }
      return;
      label51:
      if (QLog.isColorLevel()) {
        QLog.d("VideoStoryPiecesPart", 2, "onActivityResult() mPtvContainerView null!!!");
      }
    }
  }
  
  public void onActivityResume()
  {
    super.onActivityResume();
    y();
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = null;
    switch (paramView.getId())
    {
    }
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (this.mPartManager != null)
        {
          this.mPartManager.a(786436, new Object[0]);
          continue;
          AEBaseDataReporter.a().S();
          localObject1 = AEMaterialManager.a();
          if (localObject1 != null)
          {
            Object localObject2 = new HashMap();
            ((HashMap)localObject2).put("sourcetype", String.valueOf(20));
            ((HashMap)localObject2).put("filterid", ((AEMaterialMetaData)localObject1).jdField_a_of_type_JavaLangString);
            ((HashMap)localObject2).put("filtername", ((AEMaterialMetaData)localObject1).i);
            ((HashMap)localObject2).put("ext1from", "3");
            QCircleUtils.a().enterBySchemeAction(paramView.getContext(), "openpolymerize", (HashMap)localObject2);
            continue;
            if (this.mPartManager != null) {
              this.mPartManager.a(786433, new Object[0]);
            }
            if (this.jdField_d_of_type_Boolean)
            {
              localObject2 = AEMaterialManager.a();
              if (localObject2 != null)
              {
                localObject1 = new HashMap();
                ((HashMap)localObject1).put("ext2", ((AEMaterialMetaData)localObject2).jdField_a_of_type_JavaLangString);
              }
              AEReportUtils.c(2, (HashMap)localObject1);
              continue;
              this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.V();
              VSReporter.a("mystatus_shoot", "localentry_clk", 0, 0, new String[0]);
              AEBaseDataReporter.a().F();
            }
          }
        }
      }
      if (!this.jdField_d_of_type_Boolean) {
        break;
      }
    } while (AEFastClickThrottle.a(paramView));
    localObject1 = new Intent();
    ((Intent)localObject1).setAction("ae_editor_bottom_tab_show_hide");
    ((Intent)localObject1).putExtra("is_show", false);
    this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.a().sendBroadcast((Intent)localObject1);
    AEReportUtils.b(4, null);
    if ((AECameraEntry.g(this.jdField_c_of_type_Int)) && (this.jdField_f_of_type_Boolean) && (b()))
    {
      AEQLog.a("VideoStoryPiecesPart", "entry dynamics: need jump from ad pendent");
      this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.a(this.jdField_d_of_type_Int, this.jdField_e_of_type_JavaLangString);
      this.jdField_f_of_type_Boolean = false;
      this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.a().setImageResource(2130837711);
      if ((this.jdField_a_of_type_OrgLibpagPAGView != null) && (this.jdField_a_of_type_OrgLibpagPAGView.isPlaying()))
      {
        this.jdField_a_of_type_OrgLibpagPAGView.stop();
        this.jdField_a_of_type_DovComQqImAeViewAECompoundButton.removeView(this.jdField_a_of_type_OrgLibpagPAGView);
      }
      AECameraPrefsUtil.a().a(this.g, false, 4);
      if (FileUtils.b(i)) {
        FileUtils.e(i);
      }
      AEBaseDataReporter.a().j(this.jdField_e_of_type_JavaLangString);
    }
    for (;;)
    {
      VSReporter.a("mystatus_shoot", "beauty_clk", 0, 0, new String[0]);
      AEBaseDataReporter.a().I();
      break;
      if (this.mPartManager != null) {
        this.mPartManager.a(131076, new Object[0]);
      }
    }
  }
  
  public void send(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    case 327689: 
    case 327690: 
    case 327691: 
    case 327692: 
    case 327693: 
    case 327694: 
    case 327695: 
    case 327696: 
    default: 
    case 327687: 
    case 327688: 
    case 327683: 
    case 327684: 
    case 327686: 
    case 327685: 
      label151:
      do
      {
        return;
        a();
        return;
        i();
        return;
        if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel != null)
        {
          if ((paramVarArgs != null) && (paramVarArgs.length != 0)) {
            break label151;
          }
          this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setVisibility(0);
          this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.a(null, null, false);
          this.jdField_a_of_type_DovComQqImAePartAEVideoStoryStateViewModel.b().postValue(Boolean.valueOf(true));
        }
        for (;;)
        {
          VSReporter.a("mystatus_shoot", "lens_entry_clk", 0, 0, new String[0]);
          return;
          if ((paramVarArgs[0] instanceof AEMaterialMetaData))
          {
            paramVarArgs = (AEMaterialMetaData)paramVarArgs[0];
            this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.setVisibility(0);
            this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.a(paramVarArgs.jdField_b_of_type_JavaLangString, paramVarArgs.jdField_a_of_type_JavaLangString, true);
            this.jdField_a_of_type_DovComQqImAePartAEVideoStoryStateViewModel.b().postValue(Boolean.valueOf(true));
          }
        }
        A();
        return;
        B();
        return;
      } while (this.jdField_a_of_type_DovComQqImAeCameraUiPanelBeautyAndFilterPanelViewStubHolder == null);
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelBeautyAndFilterPanelViewStubHolder.h();
      return;
    }
    z();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart
 * JD-Core Version:    0.7.0.1
 */