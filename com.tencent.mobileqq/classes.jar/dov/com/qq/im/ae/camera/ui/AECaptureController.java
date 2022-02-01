package dov.com.qq.im.ae.camera.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.videostory.animator.AnimationBuilder;
import com.tencent.biz.videostory.animator.ViewAnimator;
import com.tencent.image.ApngImage;
import com.tencent.image.NativeGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.api.URLDrawableDepWrap;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.util.VideoPrefsUtil;
import dov.com.qq.im.ae.AEBaseCameraUnit;
import dov.com.qq.im.ae.AEPituCameraUnit;
import dov.com.qq.im.ae.AEPituCameraUnit.ViewStubHoldersViewModel;
import dov.com.qq.im.ae.AEViewModelProviders;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialPanel;
import dov.com.qq.im.ae.camera.ui.panel.AEWaterMarkPanel;
import dov.com.qq.im.ae.camera.ui.panel.BeautyAndFilterPanelViewStubHolder;
import dov.com.qq.im.ae.data.AEGifMaterialManager;
import dov.com.qq.im.ae.data.AEMaterialManager;
import dov.com.qq.im.ae.data.AEMaterialMetaData;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.report.AEBaseReportParam;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.data.CaptureComboManager;
import dov.com.qq.im.capture.data.CaptureComboManager.CaptureRecord;
import dov.com.qq.im.capture.data.CaptureComboObeserver;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;
import dov.com.tencent.mobileqq.activity.richmedia.view.GLVideoClipUtil;
import mqq.os.MqqHandler;

@TargetApi(17)
public class AECaptureController
  implements ICaptureController
{
  public View a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private AEBaseCameraUnit jdField_a_of_type_DovComQqImAeAEBaseCameraUnit;
  private final AECameraGLSurfaceView jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView;
  public AEMaterialPanel a;
  private AEWaterMarkPanel jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel;
  private BeautyAndFilterPanelViewStubHolder jdField_a_of_type_DovComQqImAeCameraUiPanelBeautyAndFilterPanelViewStubHolder;
  private CaptureComboObeserver jdField_a_of_type_DovComQqImCaptureDataCaptureComboObeserver = new AECaptureController.3(this);
  private VideoFilterViewPager jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager;
  public volatile boolean a;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean = true;
  private View c;
  private View d;
  private View e;
  private View f;
  
  public AECaptureController(View paramView, AEBaseCameraUnit paramAEBaseCameraUnit)
  {
    this.jdField_a_of_type_Boolean = true;
    if (paramView == null) {
      throw new IllegalStateException("rootView is null");
    }
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_DovComQqImAeAEBaseCameraUnit = paramAEBaseCameraUnit;
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView = ((AECameraGLSurfaceView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364338));
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel = ((AEMaterialPanel)this.jdField_a_of_type_AndroidViewView.findViewById(2131373621));
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel = ((AEWaterMarkPanel)this.jdField_a_of_type_AndroidViewView.findViewById(2131373622));
    this.e = this.jdField_a_of_type_AndroidViewView.findViewById(2131362300);
    this.f = this.jdField_a_of_type_AndroidViewView.findViewById(2131362301);
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager = ((VideoFilterViewPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131367180));
    j();
  }
  
  private void a(boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post(new AECaptureController.1(this, paramBoolean));
  }
  
  private void b(AEMaterialMetaData paramAEMaterialMetaData)
  {
    int i = 1;
    if (paramAEMaterialMetaData != null)
    {
      String str = AEBaseReportParam.a().a();
      if ((str == null) || (!str.equalsIgnoreCase(paramAEMaterialMetaData.a))) {
        break label120;
      }
    }
    label120:
    for (i = 0;; i = 1)
    {
      AEBaseReportParam.a().c(paramAEMaterialMetaData.a);
      AEBaseReportParam.a().b(paramAEMaterialMetaData.f);
      if (paramAEMaterialMetaData.f != 0) {
        a(true);
      }
      for (;;)
      {
        if (i != 0) {
          AEBaseDataReporter.a().R();
        }
        return;
        a(false);
        continue;
        if ("none".equalsIgnoreCase(AEBaseReportParam.a().a())) {
          i = 0;
        }
        AEBaseReportParam.a().c("none");
        AEBaseReportParam.a().b(0);
        a(false);
      }
    }
  }
  
  private void j()
  {
    ((AEPituCameraUnit.ViewStubHoldersViewModel)AEViewModelProviders.a(this.jdField_a_of_type_DovComQqImAeAEBaseCameraUnit).get(AEPituCameraUnit.ViewStubHoldersViewModel.class)).a.observe(this.jdField_a_of_type_DovComQqImAeAEBaseCameraUnit, new AECaptureController.2(this));
  }
  
  public void a()
  {
    AEQLog.b("CaptureController", "applyVideoMaterialAgain");
    if (AEMaterialManager.b() != null)
    {
      a(AEMaterialManager.b());
      return;
    }
    if (((this.jdField_a_of_type_DovComQqImAeAEBaseCameraUnit instanceof AEPituCameraUnit)) && (((AEPituCameraUnit)this.jdField_a_of_type_DovComQqImAeAEBaseCameraUnit).g()) && (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView != null)) {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setMaterial(AEGifMaterialManager.a().a());
    }
    a(AEMaterialManager.a());
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.getSmoothLevel() == paramInt) {
      return;
    }
    if (GLVideoClipUtil.b())
    {
      if (QLog.isColorLevel()) {
        QLog.d("CaptureController", 2, "onDrawBeautyFeature is in (back_camera && no template is selected) || NightMode is on");
      }
      paramInt = 0;
    }
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setBeautyLevel(paramInt);
  }
  
  public void a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("material id : ");
    Object localObject;
    if (paramAEMaterialMetaData == null)
    {
      localObject = "null";
      AEQLog.b("CaptureController", (String)localObject);
      if (VideoPrefsUtil.getDefaultPrefs() != null) {
        VideoPrefsUtil.setMaterialMute(false);
      }
      if (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView != null)
      {
        localObject = this.jdField_a_of_type_DovComQqImAeAEBaseCameraUnit.a();
        if ((b()) || (paramAEMaterialMetaData == null)) {
          break label203;
        }
        localObject = ((Activity)localObject).getIntent();
        ((Intent)localObject).putExtra("widgetinfo", "camera^" + paramAEMaterialMetaData.a);
        ((Intent)localObject).putExtra("material_id", paramAEMaterialMetaData.a);
        ((Intent)localObject).putExtra("material_topic", paramAEMaterialMetaData.l);
        AEQLog.b("CaptureController", "selectSpecificMaterial---塞拍同款名 takeSameName=" + paramAEMaterialMetaData.i);
        ((Intent)localObject).putExtra("key_camera_material_name", paramAEMaterialMetaData.i);
        ((Intent)localObject).putExtra("ae_editor_is_show_take_same", paramAEMaterialMetaData.f);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setMaterialMetaData(paramAEMaterialMetaData);
      b(paramAEMaterialMetaData);
      return;
      localObject = paramAEMaterialMetaData.a;
      break;
      label203:
      if (!b())
      {
        localObject = ((Activity)localObject).getIntent();
        if (localObject != null)
        {
          ((Intent)localObject).removeExtra("widgetinfo");
          ((Intent)localObject).removeExtra("material_id");
          ((Intent)localObject).removeExtra("material_topic");
          ((Intent)localObject).removeExtra("key_camera_material_name");
          ((Intent)localObject).removeExtra("ae_editor_is_show_take_same");
          ((Intent)localObject).removeExtra("KEY_SEND_ARK_MSG_ID");
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidViewViewGroup == null) || (this.jdField_b_of_type_AndroidViewView == null) || (this.d == null)) {
      return;
    }
    float f1 = this.jdField_a_of_type_AndroidViewViewGroup.getHeight() + this.d.getHeight();
    Object localObject = this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams)) {
      f1 = ((ViewGroup.MarginLayoutParams)localObject).bottomMargin + f1;
    }
    for (;;)
    {
      int i;
      int j;
      int k;
      if (paramBoolean)
      {
        ViewAnimator.a(new View[] { this.jdField_a_of_type_AndroidViewViewGroup, this.d }).a(new float[] { 0.0F, f1 }).a(paramInt).b();
        if ((this.e != null) && (this.e.getVisibility() == 0) && (this.f != null) && (this.f.getVisibility() == 0))
        {
          localObject = new int[2];
          this.e.getLocationOnScreen((int[])localObject);
          i = this.jdField_a_of_type_AndroidViewView.getHeight();
          j = localObject[1];
          k = UIUtils.a(this.jdField_a_of_type_AndroidViewView.getContext(), 100.0F);
          ViewAnimator.a(new View[] { this.e, this.f }).a(new float[] { 0.0F, i - j + k }).a(paramInt).b();
        }
      }
      for (localObject = new ScaleAnimation(1.0F, 0.7F, 1.0F, 0.7F, 1, 0.5F, 1, 0.5F);; localObject = new ScaleAnimation(0.7F, 1.0F, 0.7F, 1.0F, 1, 0.5F, 1, 0.5F))
      {
        ((ScaleAnimation)localObject).setDuration(paramInt);
        ((ScaleAnimation)localObject).setFillAfter(true);
        this.jdField_b_of_type_AndroidViewView.startAnimation((Animation)localObject);
        return;
        ViewAnimator.a(new View[] { this.jdField_a_of_type_AndroidViewViewGroup, this.d }).a(new float[] { f1, 0.0F }).a(paramInt).b();
        if ((this.e != null) && (this.e.getVisibility() == 0) && (this.f != null) && (this.f.getVisibility() == 0))
        {
          localObject = new int[2];
          this.e.getLocationOnScreen((int[])localObject);
          i = this.jdField_a_of_type_AndroidViewView.getHeight();
          j = localObject[1];
          k = UIUtils.a(this.jdField_a_of_type_AndroidViewView.getContext(), 100.0F);
          ViewAnimator.a(new View[] { this.e, this.f }).a(new float[] { i - j + k, 0.0F }).a(paramInt).b();
        }
      }
    }
  }
  
  public boolean a()
  {
    if (b()) {
      return true;
    }
    if (c())
    {
      e();
      return true;
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131367457));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365444);
    this.d = this.jdField_a_of_type_AndroidViewView.findViewById(2131377202);
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.setSharpFaceLevel(paramInt);
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView != null) && (this.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.isRecording());
  }
  
  public void c()
  {
    VideoFilterTools.a().a(0);
    CaptureComboManager localCaptureComboManager = (CaptureComboManager)QIMManager.a(5);
    if (this.jdField_b_of_type_Boolean) {
      localCaptureComboManager.a[0].a((Activity)this.jdField_a_of_type_AndroidViewView.getContext());
    }
  }
  
  public boolean c()
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if ((this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel != null) || (this.jdField_a_of_type_DovComQqImAeCameraUiPanelBeautyAndFilterPanelViewStubHolder != null))
    {
      if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel != null) {
        bool2 = false | this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.a();
      }
      bool1 = bool2;
      if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelBeautyAndFilterPanelViewStubHolder != null) {
        bool1 = bool2 | this.jdField_a_of_type_DovComQqImAeCameraUiPanelBeautyAndFilterPanelViewStubHolder.b();
      }
    }
    return bool1;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.b();
    }
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel.b();
    }
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelBeautyAndFilterPanelViewStubHolder != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelBeautyAndFilterPanelViewStubHolder.c();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.a(true);
    }
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelBeautyAndFilterPanelViewStubHolder != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelBeautyAndFilterPanelViewStubHolder.d();
    }
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel.a(true);
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    }
  }
  
  public void f()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView.findViewById(2131370761);
    if ((localObject != null) && ((localObject instanceof RelativeLayout)))
    {
      localObject = (RelativeLayout)localObject;
      if ((localObject != null) && (((RelativeLayout)localObject).isShown()))
      {
        ((RelativeLayout)localObject).setVisibility(8);
        if (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager != null) {
          this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.c();
        }
      }
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.c();
    }
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelBeautyAndFilterPanelViewStubHolder != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelBeautyAndFilterPanelViewStubHolder.e();
    }
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEWaterMarkPanel.c();
    }
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_Boolean;
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelBeautyAndFilterPanelViewStubHolder != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelBeautyAndFilterPanelViewStubHolder.f();
    }
    VideoFilterTools.a().a(0);
    NativeGifImage.resumeAll();
    if (URLDrawable.depImp.mLog != null) {
      ApngImage.playByTag(13);
    }
  }
  
  public void i()
  {
    e();
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelBeautyAndFilterPanelViewStubHolder != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelBeautyAndFilterPanelViewStubHolder.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.AECaptureController
 * JD-Core Version:    0.7.0.1
 */