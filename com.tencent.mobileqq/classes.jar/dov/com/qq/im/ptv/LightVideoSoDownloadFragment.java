package dov.com.qq.im.ptv;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anni;
import baos;
import baou;
import bceg;
import bcfe;
import bcfg;
import bgnt;
import bnpt;
import bnpu;
import bnpw;
import bnpy;
import bnzb;
import bows;
import bqcb;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureSegmentView;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import java.util.ArrayList;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;
import mqq.os.MqqHandler;

public class LightVideoSoDownloadFragment
  extends PublicBaseFragment
  implements View.OnClickListener, baos, bcfe, bcfg, bnpw
{
  private int jdField_a_of_type_Int;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  protected View a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  protected RelativeLayout a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public CameraCaptureSegmentView a;
  protected CircleProgress a;
  protected LightWeightProgress a;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  
  private void a(String paramString)
  {
    ThreadManager.getUIHandler().post(new LightVideoSoDownloadFragment.2(this, paramString));
  }
  
  private void b(String paramString)
  {
    ThreadManager.getUIHandler().post(new LightVideoSoDownloadFragment.3(this, paramString));
  }
  
  private void d()
  {
    this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getBooleanExtra("flow_camera_show_panel", false);
    if (!this.jdField_d_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().setBackgroundDrawableResource(2130844582);
    }
    this.e = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isInMultiWindow();
    VideoEnvironment.a("LightVideoSoDownloadFragment", "initParam : mIsMultiWindowMode=" + this.e, null);
    if (this.e)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, anni.a(2131704856), 0).a();
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
    }
    do
    {
      return;
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("PTV_SO_ARG_FRAGMENT_CLASS");
      this.jdField_c_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().hasExtra("PTV_pendingIntentRequest");
      if (this.jdField_c_of_type_Boolean) {
        this.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getIntExtra("PTV_pendingIntentRequest", 0);
      }
      this.jdField_a_of_type_AndroidOsBundle = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getExtras();
    } while (!QLog.isColorLevel());
    QLog.i("LightVideoSoDownloadFragment", 2, "fragmentName:" + this.jdField_a_of_type_JavaLangString + " hasRequest:" + this.jdField_c_of_type_Boolean + "pendingIntentRequest" + this.jdField_d_of_type_Int);
  }
  
  private void e()
  {
    boolean bool = bgnt.g(null);
    VideoEnvironment.a("LightVideoSoDownloadFragment", "startDownloadConfig netUsable=" + bool, null);
    if (bool)
    {
      VideoEnvironment.a("LightVideoSoDownloadFragment", anni.a(2131704850), null);
      ShortVideoResourceManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      return;
    }
    a(anni.a(2131704866));
  }
  
  public void B_()
  {
    a(anni.a(2131704868));
    VideoEnvironment.a("LightVideoSoDownloadFragment", anni.a(2131704855), null);
    bceg.a(3, -1500);
  }
  
  public void C_()
  {
    if (Build.VERSION.SDK_INT < 23) {}
    while (!(getActivity() instanceof PublicTransFragmentActivity)) {
      return;
    }
    PublicTransFragmentActivity localPublicTransFragmentActivity = (PublicTransFragmentActivity)getActivity();
    int i;
    if (localPublicTransFragmentActivity.checkSelfPermission("android.permission.CAMERA") != 0)
    {
      i = 1;
      if (localPublicTransFragmentActivity.checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
        break label83;
      }
    }
    label83:
    for (int j = 1;; j = 0)
    {
      if ((i == 0) || (j == 0)) {
        break label88;
      }
      localPublicTransFragmentActivity.requestPermissions(this, 1, new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO" });
      return;
      i = 0;
      break;
    }
    label88:
    if (i != 0)
    {
      localPublicTransFragmentActivity.requestPermissions(this, 1, new String[] { "android.permission.CAMERA" });
      return;
    }
    localPublicTransFragmentActivity.requestPermissions(this, 1, new String[] { "android.permission.RECORD_AUDIO" });
  }
  
  protected int a()
  {
    return 2131560935;
  }
  
  protected baou a()
  {
    return bqcb.a().c(getActivity());
  }
  
  protected void a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean)) {
      c();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    VideoEnvironment.a("LightVideoSoDownloadFragment", "result=" + paramInt1 + ",serverError=" + paramInt2, null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0)
      {
        VideoEnvironment.a("LightVideoSoDownloadFragment", anni.a(2131704865) + paramInt2 + "]", null);
        ShortVideoResourceManager.a(anni.a(2131704859));
        bceg.a(1, paramInt2);
        return;
      }
      ArrayList localArrayList = new ArrayList(1);
      paramInt1 = ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList);
      if (paramInt1 == 0)
      {
        VideoEnvironment.a("LightVideoSoDownloadFragment", anni.a(2131704862), null);
        ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, this);
        paramInt1 = bnpy.a(bnpt.jdField_b_of_type_Bnpt);
        VideoEnvironment.a("LightVideoSoDownloadFragment", "PtvFilterSoLoad.getFilterSoState resultCode=" + paramInt1, null);
        if (paramInt1 == 2)
        {
          bnpu.a().a(bnpt.jdField_b_of_type_Bnpt, this, false);
          return;
        }
        if (paramInt1 == 1) {
          bnpu.a().a(bnpt.jdField_b_of_type_Bnpt, this, false);
        }
        this.jdField_b_of_type_Int = 100;
        this.jdField_b_of_type_Boolean = true;
        VideoEnvironment.a("LightVideoSoDownloadFragment", "onConfigResult| supportSVFilterDownloadSo=false", null);
        return;
      }
      VideoEnvironment.a("LightVideoSoDownloadFragment", anni.a(2131704848) + paramInt1 + "]", null);
      ShortVideoResourceManager.a(anni.a(2131704837));
      bceg.a(1, paramInt1);
      return;
    }
    VideoEnvironment.a("LightVideoSoDownloadFragment", anni.a(2131704843) + paramInt2 + "]", null);
    ShortVideoResourceManager.a(anni.a(2131704839));
    bceg.a(1, paramInt2);
  }
  
  public void a(bnpt parambnpt, long paramLong1, long paramLong2)
  {
    int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    if ((parambnpt != null) && (parambnpt.jdField_b_of_type_JavaLangString != null) && (parambnpt.jdField_b_of_type_JavaLangString.equals(bnpt.jdField_b_of_type_Bnpt.jdField_b_of_type_JavaLangString))) {
      this.jdField_b_of_type_Int = i;
    }
    this.jdField_c_of_type_Int = ((this.jdField_a_of_type_Int + this.jdField_b_of_type_Int) / 2);
    b("doUserDownloadResourceAVCodec:");
    a(anni.a(2131704852) + this.jdField_c_of_type_Int + "%");
    VideoEnvironment.a("LightVideoSoDownloadFragment", "name=" + parambnpt.jdField_b_of_type_JavaLangString + ",totalLen=" + paramLong2 + ",curOffset=" + paramLong1 + ",localProgress=" + i, null);
  }
  
  public void a(bnpt parambnpt, String paramString, boolean paramBoolean, int paramInt)
  {
    if ((parambnpt != null) && (parambnpt.jdField_b_of_type_JavaLangString != null) && (parambnpt.jdField_b_of_type_JavaLangString.equals(bnpt.jdField_b_of_type_Bnpt.jdField_b_of_type_JavaLangString)))
    {
      if (paramInt != 0)
      {
        bnzb.d("LightVideoSoDownloadFragment", "[onAEDownloadFinish] error:" + paramInt);
        VideoEnvironment.a("LightVideoSoDownloadFragment", anni.a(2131704857) + paramInt + "]", null);
        ShortVideoResourceManager.a(anni.a(2131704842));
        bceg.a(2, paramInt);
      }
    }
    else {
      return;
    }
    bnzb.b("LightVideoSoDownloadFragment", "[onAEDownloadFinish] mFilterState 100");
    this.jdField_b_of_type_Int = 100;
    this.jdField_b_of_type_Boolean = true;
    a();
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1.startsWith("new_qq_android_native_short_video_"))
    {
      if (paramInt == 0) {
        break label110;
      }
      VideoEnvironment.a("LightVideoSoDownloadFragment", anni.a(2131704853) + paramInt + "]", null);
      ShortVideoResourceManager.a(anni.a(2131704838));
      bceg.a(2, paramInt);
    }
    for (;;)
    {
      VideoEnvironment.a("LightVideoSoDownloadFragment", "name=" + paramString1 + ",result=" + paramInt + ",filePath=" + paramString2, null);
      return;
      label110:
      this.jdField_a_of_type_Int = 100;
      this.jdField_a_of_type_Boolean = true;
      a();
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    if (paramString.startsWith("new_qq_android_native_short_video_")) {
      this.jdField_a_of_type_Int = i;
    }
    this.jdField_c_of_type_Int = ((this.jdField_a_of_type_Int + this.jdField_b_of_type_Int) / 2);
    b("doUserDownloadResourceAVCodec:");
    a(anni.a(2131704852) + this.jdField_c_of_type_Int + "%");
    VideoEnvironment.a("LightVideoSoDownloadFragment", "name=" + paramString + ",totalLen=" + paramLong2 + ",curOffset=" + paramLong1 + ",localProgress=" + i, null);
  }
  
  public void c()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = bows.class.getName();
    }
    if (this.jdField_a_of_type_AndroidOsBundle != null) {
      if (getActivity() == null) {
        QLog.d("LightVideoSoDownloadFragment", 1, "activity is null");
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidOsBundle.putBoolean("flow_camera_download_light", true);
        PtvCameraCaptureActivity.a(getActivity(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle, this.jdField_d_of_type_Int);
        return;
      }
      PtvCameraCaptureActivity.a(getActivity(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle);
      getActivity().finish();
      return;
    }
    QLog.i("LightVideoSoDownloadFragment", 2, "fragmentName:" + this.jdField_a_of_type_JavaLangString + " hasRequest:" + this.jdField_c_of_type_Boolean + "pendingIntentRequest" + this.jdField_d_of_type_Int + " mIsMultiWindowMode: " + this.e + " args=null error.");
  }
  
  @QQPermissionDenied(1)
  public void denied()
  {
    int j = 1;
    if (Build.VERSION.SDK_INT < 23) {
      return;
    }
    Object localObject = getActivity();
    int i;
    if (((Activity)localObject).checkSelfPermission("android.permission.CAMERA") != 0)
    {
      i = 1;
      if (((Activity)localObject).checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
        break label73;
      }
      label36:
      if ((i == 0) || (j == 0)) {
        break label78;
      }
      localObject = anni.a(2131704851);
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new LightVideoSoDownloadFragment.4(this, (String)localObject));
      return;
      i = 0;
      break;
      label73:
      j = 0;
      break label36;
      label78:
      if (i != 0) {
        localObject = anni.a(2131704864);
      } else {
        localObject = anni.a(2131704846);
      }
    }
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureSegmentView.setCameraPermissionResult(true);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return true;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    VideoEnvironment.a("LightVideoSoDownloadFragment", "onActivityResult : hasRequest=" + this.jdField_c_of_type_Boolean, null);
    if (this.jdField_c_of_type_Boolean)
    {
      getActivity().setResult(paramInt2, paramIntent);
      getActivity().finish();
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = getActivity();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      getActivity().doOnBackPressed();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    d();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = new RelativeLayout(getActivity());
    paramViewGroup.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    paramLayoutInflater = paramLayoutInflater.inflate(a(), paramViewGroup, false);
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131366871);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364157));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureSegmentView = ((CameraCaptureSegmentView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364093));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureSegmentView.d(false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureSegmentView.setCaptureParam(a());
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureSegmentView.setDarkModeEnable(false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureSegmentView.setCameraPermissionListener(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureSegmentView.setUseVideoOrientation(false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureSegmentView.setDynamicResolutionMode(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress = ((CircleProgress)paramLayoutInflater.findViewById(2131365143));
    paramViewGroup = getResources();
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setBgAndProgressColor(100, paramViewGroup.getColor(2131167279), 100, paramViewGroup.getColor(2131165368));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setStrokeWidth(6.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(0.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setOnClickListener(this);
    this.jdField_a_of_type_DovComQqImPtvLightWeightProgress = ((LightWeightProgress)this.jdField_a_of_type_AndroidViewView.findViewById(2131372961));
    this.jdField_a_of_type_DovComQqImPtvLightWeightProgress.setStrokeWidth(3.0F);
    this.jdField_a_of_type_DovComQqImPtvLightWeightProgress.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363210));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131366869));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getActivity().getAppInterface());
    if (!VideoEnvironment.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      QQToast.a(VideoEnvironment.a(), anni.a(2131704849), 1);
    }
    for (;;)
    {
      paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      boolean bool = VideoEnvironment.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (bnpy.a(bnpt.jdField_b_of_type_Bnpt) != 2) {}
      for (int i = 1;; i = 0)
      {
        if ((bool) && (i != 0)) {
          break label383;
        }
        bceg.a(2);
        e();
        break;
      }
      label383:
      this.jdField_a_of_type_Int = 100;
      this.jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_Int = 100;
      this.jdField_b_of_type_Boolean = true;
      VideoEnvironment.a("LightVideoSoDownloadFragment", "checkAVCodecLoadIsOK loaded=true", null);
      ThreadManager.getUIHandler().postDelayed(new LightVideoSoDownloadFragment.1(this), 5L);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    GLGestureProxy.getInstance().removeAllListener();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      bnpu.a().a(this);
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    getActivity().getIntent().putExtras(paramIntent);
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureSegmentView.onPause();
    VideoEnvironment.a("LightVideoSoDownloadFragment", "onPause", null);
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureSegmentView.onResume();
    VideoEnvironment.a("LightVideoSoDownloadFragment", "onResume", null);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ptv.LightVideoSoDownloadFragment
 * JD-Core Version:    0.7.0.1
 */