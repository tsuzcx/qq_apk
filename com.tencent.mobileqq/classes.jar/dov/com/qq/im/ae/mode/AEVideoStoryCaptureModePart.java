package dov.com.qq.im.ae.mode;

import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.view.PagerAdapter;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import dov.com.qq.im.ae.AEPituCameraUnit;
import dov.com.qq.im.ae.AEViewModelProviders;
import dov.com.qq.im.ae.data.AEMaterialManager;
import dov.com.qq.im.ae.data.AEMaterialMetaData;
import dov.com.qq.im.ae.part.AEVideoStoryStateViewModel;
import dov.com.qq.im.ae.part.VideoStoryBasePart;
import dov.com.qq.im.ae.part.VideoStoryCapturePartManager;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.capture.QIMManager;
import dov.com.tencent.mobileqq.shortvideo.util.ScreenUtil;

public class AEVideoStoryCaptureModePart
  extends VideoStoryBasePart
{
  private PagerAdapter jdField_a_of_type_AndroidSupportV4ViewPagerAdapter;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private AEPituCameraUnit jdField_a_of_type_DovComQqImAeAEPituCameraUnit;
  private AECaptureMode jdField_a_of_type_DovComQqImAeModeAECaptureMode;
  private AECaptureModeSelectPager jdField_a_of_type_DovComQqImAeModeAECaptureModeSelectPager;
  private AEVideoStoryCaptureModeViewModel jdField_a_of_type_DovComQqImAeModeAEVideoStoryCaptureModeViewModel;
  private AEVideoStoryStateViewModel jdField_a_of_type_DovComQqImAePartAEVideoStoryStateViewModel;
  private boolean jdField_a_of_type_Boolean;
  private AECaptureMode[] jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode;
  private boolean b;
  
  public AEVideoStoryCaptureModePart(Activity paramActivity, View paramView, VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    super(paramActivity, paramView, paramVideoStoryCapturePartManager);
    this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit = ((AEPituCameraUnit)paramVideoStoryCapturePartManager.a(65537, new Object[0]));
  }
  
  private AEMaterialManager a()
  {
    return (AEMaterialManager)QIMManager.a().c(18);
  }
  
  private void a()
  {
    this.jdField_a_of_type_DovComQqImAeModeAEVideoStoryCaptureModeViewModel = ((AEVideoStoryCaptureModeViewModel)AEViewModelProviders.a(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit).get(AEVideoStoryCaptureModeViewModel.class));
    this.jdField_a_of_type_DovComQqImAeModeAEVideoStoryCaptureModeViewModel.a.observe(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit, new AEVideoStoryCaptureModePart.2(this));
    this.jdField_a_of_type_DovComQqImAePartAEVideoStoryStateViewModel = ((AEVideoStoryStateViewModel)AEViewModelProviders.a(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit).get(AEVideoStoryStateViewModel.class));
    this.jdField_a_of_type_DovComQqImAePartAEVideoStoryStateViewModel.a().observe(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit, new AEVideoStoryCaptureModePart.3(this));
  }
  
  private void a(AECaptureMode paramAECaptureMode)
  {
    if (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode == paramAECaptureMode) {}
    while (this.jdField_a_of_type_DovComQqImAeModeAEVideoStoryCaptureModeViewModel.d()) {
      return;
    }
    this.jdField_a_of_type_DovComQqImAeModeAEVideoStoryCaptureModeViewModel.a.postValue(new AECaptureModeChangingEvent(this.jdField_a_of_type_DovComQqImAeModeAECaptureMode, paramAECaptureMode, 0));
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {}
    do
    {
      do
      {
        return;
        this.b = paramBoolean;
        if (!paramBoolean) {
          break;
        }
      } while (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    } while (this.jdField_a_of_type_AndroidViewView.getVisibility() != 0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void initView()
  {
    ViewStub localViewStub = (ViewStub)this.mRootView.findViewById(2131378587);
    if (localViewStub != null)
    {
      localViewStub.inflate();
      AEQLog.b("AEVideoStoryCaptureModePart", "AEPartAction--inflate captureMode");
    }
    this.jdField_a_of_type_AndroidViewView = this.mRootView.findViewById(2131377202);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369596));
    this.jdField_a_of_type_DovComQqImAeModeAECaptureModeSelectPager = ((AECaptureModeSelectPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131381781));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.mRootView.findViewById(2131367256));
    int j = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
    int k = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
    int i = j;
    if (ScreenUtil.a(j, k)) {
      i = k * 9 / 16;
    }
    i = (i - ViewUtils.a(53.0F)) / 2;
    this.jdField_a_of_type_DovComQqImAeModeAECaptureModeSelectPager.setPadding(i, 0, i, 0);
    this.jdField_a_of_type_DovComQqImAeModeAECaptureModeSelectPager.setDisableScroll(true);
    this.jdField_a_of_type_DovComQqImAeModeAECaptureModeSelectPager.setOnPageChangeListener(new AEVideoStoryCaptureModePart.1(this));
    this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode = ((AECaptureMode[])((AEVideoStoryCaptureModeViewModel)AEViewModelProviders.a(this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit).get(AEVideoStoryCaptureModeViewModel.class)).b.getValue());
    if (this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode != null) {
      if (this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode.length <= 1) {
        break label269;
      }
    }
    label269:
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter = new AEVideoStoryCaptureModePart.AECaptureModeAdapter(this, this.mRootView.getContext());
      this.jdField_a_of_type_DovComQqImAeModeAECaptureModeSelectPager.setAdapter(this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter);
      a();
      return;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((this.mActivity != null) && (paramInt1 == 101) && (paramInt2 == 201)) {
      this.mActivity.finish();
    }
  }
  
  public void onActivityResume()
  {
    super.onActivityResume();
    if ((AECaptureMode.NORMAL == this.jdField_a_of_type_DovComQqImAeModeAECaptureMode) && (this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit != null)) {
      this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.f(true);
    }
  }
  
  public void send(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      if ((paramVarArgs == null) || (paramVarArgs.length != 1) || (!(paramVarArgs[0] instanceof AEMaterialMetaData))) {
        break;
      }
    } while (this.jdField_a_of_type_DovComQqImAeModeAECaptureMode != AECaptureMode.PLAY);
    a().a((AEMaterialMetaData)paramVarArgs[0], true);
    if (this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit != null) {
      this.jdField_a_of_type_DovComQqImAeAEPituCameraUnit.a().getIntent().putExtra("widgetinfo", "camera^" + ((AEMaterialMetaData)paramVarArgs[0]).a);
    }
    a(AECaptureMode.NORMAL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.mode.AEVideoStoryCaptureModePart
 * JD-Core Version:    0.7.0.1
 */