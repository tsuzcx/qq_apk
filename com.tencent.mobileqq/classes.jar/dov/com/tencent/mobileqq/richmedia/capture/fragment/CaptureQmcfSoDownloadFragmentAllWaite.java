package dov.com.tencent.mobileqq.richmedia.capture.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.CaptureParam;
import com.tencent.mobileqq.shortvideo.ShortVideoErrorReport;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.INet_ShortVideoResource;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceStatus.ISVConfig;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgr;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgr.GestureStatusListener;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import dov.com.qq.im.ae.download.AEResInfo;
import dov.com.qq.im.ae.download.AEResManager;
import dov.com.qq.im.ae.download.AEResManager.AEDownloadCallBack;
import dov.com.qq.im.ae.download.AEResUtil;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.tencent.mobileqq.richmedia.capture.util.DovSVParamManager;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class CaptureQmcfSoDownloadFragmentAllWaite
  extends ReportV4Fragment
  implements View.OnClickListener, ShortVideoResourceManager.INet_ShortVideoResource, ShortVideoResourceStatus.ISVConfig, GestureMgr.GestureStatusListener, AEResManager.AEDownloadCallBack
{
  private int jdField_a_of_type_Int = 0;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private CameraCaptureView jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView;
  private CircleProgress jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean = false;
  private int d = 0;
  private volatile int e = 0;
  
  private void a(AEResInfo paramAEResInfo)
  {
    int i = AEResUtil.a(paramAEResInfo);
    if (i == 2) {
      AEResManager.a().a(paramAEResInfo, this, false);
    }
    while (i != 1) {
      return;
    }
    AEResManager.a().a(paramAEResInfo, null, false);
  }
  
  private void a(String paramString)
  {
    f();
    ThreadManager.getUIHandler().post(new CaptureQmcfSoDownloadFragmentAllWaite.2(this, paramString));
  }
  
  private boolean a()
  {
    return false;
  }
  
  private void b(String paramString)
  {
    ThreadManager.getUIHandler().post(new CaptureQmcfSoDownloadFragmentAllWaite.3(this, paramString));
  }
  
  private boolean b()
  {
    return true;
  }
  
  private void c()
  {
    boolean bool = NetworkUtil.g(null);
    VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", "startDownloadConfig netUsable=" + bool, null);
    if (bool)
    {
      VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", HardCodeUtil.a(2131701476), null);
      ShortVideoResourceManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      return;
    }
    b(HardCodeUtil.a(2131701475));
  }
  
  private void d()
  {
    int i = AEResUtil.a(AEResInfo.jdField_b_of_type_DovComQqImAeDownloadAEResInfo);
    int j = AEResUtil.a(AEResInfo.c);
    VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", "PtvFilterSoLoad.getFilterSoState aeBaseCode=" + i + " lightBaseCode= " + j, null);
    a(AEResInfo.jdField_b_of_type_DovComQqImAeDownloadAEResInfo);
    a(AEResInfo.c);
    if ((i == 1) && (j == 1))
    {
      this.jdField_b_of_type_Int = 100;
      this.jdField_b_of_type_Boolean = true;
      VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", "onConfigResult| supportSVFilterDownloadSo=false", null);
    }
  }
  
  private void e()
  {
    if (a()) {
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Boolean) && (this.e > 100)) {
        a();
      }
    }
    while ((!this.jdField_a_of_type_Boolean) || (!this.jdField_b_of_type_Boolean) || (!this.jdField_c_of_type_Boolean)) {
      return;
    }
    a();
  }
  
  private void f()
  {
    if (a())
    {
      int i = (this.d + this.e) / 2;
      b(HardCodeUtil.a(2131701469) + i + "%");
      return;
    }
    b(HardCodeUtil.a(2131701453) + this.d + "%");
  }
  
  protected int a()
  {
    return 2131561140;
  }
  
  protected void a()
  {
    CaptureQmcfSoDownloadFragment.CaptureSoDownloadListener localCaptureSoDownloadListener = (CaptureQmcfSoDownloadFragment.CaptureSoDownloadListener)getActivity();
    if (localCaptureSoDownloadListener != null) {
      localCaptureSoDownloadListener.a();
    }
  }
  
  public void a(int paramInt)
  {
    ThreadManager.getUIHandler().post(new CaptureQmcfSoDownloadFragmentAllWaite.6(this, paramInt));
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    ThreadManager.getUIHandler().post(new CaptureQmcfSoDownloadFragmentAllWaite.5(this, paramBoolean1, paramInt));
  }
  
  public void b()
  {
    this.e = 0;
    GestureMgr.a().a(true, this);
    boolean bool = GestureMgr.a().a();
    if (QLog.isColorLevel()) {
      QLog.d("CaptureSoDownloadFragmentAllWaite", 2, "preDownloadGestureRes:" + bool);
    }
    if (!bool)
    {
      ThreadManager.getUIHandler().post(new CaptureQmcfSoDownloadFragmentAllWaite.4(this));
      return;
    }
    this.e = 101;
  }
  
  public void onAEDownloadFinish(AEResInfo paramAEResInfo, String paramString, boolean paramBoolean, int paramInt)
  {
    if ((paramAEResInfo != null) && (paramAEResInfo.jdField_b_of_type_JavaLangString != null) && (paramAEResInfo.jdField_b_of_type_JavaLangString.equals(AEResInfo.jdField_b_of_type_DovComQqImAeDownloadAEResInfo.jdField_b_of_type_JavaLangString)))
    {
      if (paramInt != 0)
      {
        AEQLog.d("CaptureSoDownloadFragmentAllWaite", "[onAEDownloadFinish] error:" + paramInt);
        VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", HardCodeUtil.a(2131701449) + paramInt + "]", null);
        ShortVideoResourceManager.a(HardCodeUtil.a(2131701441));
        ShortVideoErrorReport.a(2, paramInt);
      }
    }
    else {
      return;
    }
    AEQLog.d("CaptureSoDownloadFragmentAllWaite", "[onAEDownloadFinish] mFilterState:100");
    this.jdField_b_of_type_Int = 100;
    this.jdField_b_of_type_Boolean = true;
    e();
  }
  
  public void onAEProgressUpdate(AEResInfo paramAEResInfo, long paramLong1, long paramLong2)
  {
    int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    if ((paramAEResInfo != null) && (paramAEResInfo.jdField_b_of_type_JavaLangString != null) && (paramAEResInfo.jdField_b_of_type_JavaLangString.equals(AEResInfo.jdField_b_of_type_DovComQqImAeDownloadAEResInfo.jdField_b_of_type_JavaLangString))) {
      this.jdField_b_of_type_Int = i;
    }
    StringBuilder localStringBuilder;
    if (b())
    {
      this.d = ((this.jdField_a_of_type_Int + this.jdField_b_of_type_Int + this.jdField_c_of_type_Int) / 3);
      a("doUserDownloadResourceAVCodec:");
      localStringBuilder = new StringBuilder().append("name=");
      if (paramAEResInfo != null) {
        break label166;
      }
    }
    label166:
    for (paramAEResInfo = "null";; paramAEResInfo = paramAEResInfo.jdField_b_of_type_JavaLangString)
    {
      VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", paramAEResInfo + ",totalLen=" + paramLong2 + ",curOffset=" + paramLong1 + ",localProgress=" + i, null);
      return;
      this.d = ((this.jdField_a_of_type_Int + this.jdField_b_of_type_Int) / 2);
      break;
    }
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
  
  public void onConfigResult(int paramInt1, int paramInt2)
  {
    VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", "result=" + paramInt1 + ",serverError=" + paramInt2, null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0)
      {
        VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", HardCodeUtil.a(2131701465) + paramInt2 + "]", null);
        ShortVideoResourceManager.a(HardCodeUtil.a(2131701451));
        ShortVideoErrorReport.a(1, paramInt2);
        ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
        d();
        return;
      }
      ArrayList localArrayList = new ArrayList(1);
      paramInt1 = ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList);
      if (paramInt1 == 0)
      {
        VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", HardCodeUtil.a(2131701457), null);
        ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, this);
        d();
        paramInt1 = PtvFilterSoLoad.a();
        if ((!b()) || (paramInt1 == 0))
        {
          this.jdField_c_of_type_Int = 100;
          this.jdField_c_of_type_Boolean = true;
          VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", "onConfigResult| supportQmcfDownloadSo=false", null);
          return;
        }
        ShortVideoResourceManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, this);
        return;
      }
      VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", HardCodeUtil.a(2131701442) + paramInt1 + "]", null);
      ShortVideoResourceManager.a(HardCodeUtil.a(2131701467));
      ShortVideoErrorReport.a(1, paramInt1);
      d();
      return;
    }
    VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", HardCodeUtil.a(2131701450) + paramInt2 + "]", null);
    ShortVideoResourceManager.a(HardCodeUtil.a(2131701463));
    ShortVideoErrorReport.a(1, paramInt2);
    d();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(a(), paramViewGroup, false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView = ((CameraCaptureView)paramLayoutInflater.findViewById(2131364338));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setDarkModeEnable(false);
    paramViewGroup = DovSVParamManager.a().a(paramLayoutInflater.getContext());
    paramViewGroup.a(false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.b(false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setCaptureParam(paramViewGroup);
    ((Button)paramLayoutInflater.findViewById(2131364357)).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress = ((CircleProgress)paramLayoutInflater.findViewById(2131365444));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setBgAndProgressColor(100, getResources().getColor(2131167374), 100, getResources().getColor(2131165381));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setStrokeWidth(6.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(0.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131367253));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getActivity().getAppInterface());
    boolean bool1 = VideoEnvironment.supportShortVideoRecordAndPlay();
    this.jdField_a_of_type_JavaLangString = getActivity().getIntent().getExtras().getString("ARG_ACTIVITY_ID");
    if (!bool1) {
      QQToast.a(VideoEnvironment.getContext(), HardCodeUtil.a(2131701471), 1);
    }
    for (;;)
    {
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      label240:
      boolean bool2;
      if (a())
      {
        b();
        bool1 = VideoEnvironment.checkAndLoadAVCodec();
        bool2 = AEResUtil.b();
        if ((b()) && (PtvFilterSoLoad.a() == 2)) {
          break label302;
        }
      }
      label302:
      for (int i = 1;; i = 0)
      {
        if ((bool1) && (bool2) && (i != 0)) {
          break label308;
        }
        ShortVideoErrorReport.a(2);
        c();
        break;
        this.e = 101;
        break label240;
      }
      label308:
      VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", "checkAVCodecLoadIsOK loaded=true, activityId=" + this.jdField_a_of_type_JavaLangString, null);
      ThreadManager.getUIHandler().postDelayed(new CaptureQmcfSoDownloadFragmentAllWaite.1(this), 5L);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      ShortVideoResourceManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      AEResManager.a().a(this);
      ShortVideoResourceManager.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    }
    GestureMgr.a().a(false, this);
  }
  
  public void onDownloadFinish(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1.startsWith("new_qq_android_native_short_video_")) {
      if (paramInt != 0)
      {
        VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", HardCodeUtil.a(2131701440) + paramInt + "]", null);
        ShortVideoResourceManager.a(HardCodeUtil.a(2131701452));
        ShortVideoErrorReport.a(2, paramInt);
      }
    }
    for (;;)
    {
      VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", "name=" + paramString1 + ",result=" + paramInt + ",filePath=" + paramString2, null);
      return;
      this.jdField_a_of_type_Int = 100;
      this.jdField_a_of_type_Boolean = true;
      e();
      continue;
      if (paramString1.startsWith("new_qq_android_native_art_filter_")) {
        if (paramInt != 0)
        {
          VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", HardCodeUtil.a(2131701473) + paramInt + "]", null);
          ShortVideoResourceManager.a(HardCodeUtil.a(2131701461));
          ShortVideoErrorReport.a(2, paramInt);
        }
        else
        {
          this.jdField_c_of_type_Int = 100;
          this.jdField_c_of_type_Boolean = true;
          e();
        }
      }
    }
  }
  
  public void onNetWorkNone()
  {
    b(HardCodeUtil.a(2131701470));
    VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", HardCodeUtil.a(2131701448), null);
    ShortVideoErrorReport.a(3, -1500);
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.onResume();
  }
  
  public void onUpdateProgress(String paramString, long paramLong1, long paramLong2)
  {
    int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    if (paramString.startsWith("new_qq_android_native_short_video_"))
    {
      this.jdField_a_of_type_Int = i;
      if (!b()) {
        break label138;
      }
    }
    label138:
    for (this.d = ((this.jdField_a_of_type_Int + this.jdField_b_of_type_Int + this.jdField_c_of_type_Int) / 3);; this.d = ((this.jdField_a_of_type_Int + this.jdField_b_of_type_Int) / 2))
    {
      a("doUserDownloadResourceAVCodec:");
      VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", "name=" + paramString + ",totalLen=" + paramLong2 + ",curOffset=" + paramLong1 + ",localProgress=" + i, null);
      return;
      if (!paramString.startsWith("new_qq_android_native_art_filter_")) {
        break;
      }
      this.jdField_c_of_type_Int = i;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.fragment.CaptureQmcfSoDownloadFragmentAllWaite
 * JD-Core Version:    0.7.0.1
 */