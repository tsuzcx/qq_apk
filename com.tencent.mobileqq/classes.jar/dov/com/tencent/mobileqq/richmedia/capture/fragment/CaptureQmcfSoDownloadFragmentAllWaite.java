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
import anvr;
import anvs;
import anvt;
import anvu;
import anvv;
import anvw;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.util.CameraHelper;
import com.tencent.mobileqq.richmedia.capture.util.SVParamManager;
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
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class CaptureQmcfSoDownloadFragmentAllWaite
  extends Fragment
  implements View.OnClickListener, ShortVideoResourceManager.INet_ShortVideoResource, ShortVideoResourceStatus.ISVConfig, GestureMgr.GestureStatusListener
{
  private int jdField_a_of_type_Int;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private CameraCaptureView jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView;
  private CircleProgress jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  private volatile int d;
  
  private void a(String paramString)
  {
    f();
    ThreadManager.getUIHandler().post(new anvs(this, paramString));
  }
  
  private boolean a()
  {
    return false;
  }
  
  private void b(String paramString)
  {
    ThreadManager.getUIHandler().post(new anvt(this, paramString));
  }
  
  private void d()
  {
    boolean bool = NetworkUtil.g(null);
    VideoEnvironment.a("CaptureSoDownloadFragmentAllWaite", "startDownloadConfig netUsable=" + bool, null);
    if (bool)
    {
      VideoEnvironment.a("CaptureSoDownloadFragmentAllWaite", "短视频配置下载中...", null);
      ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      return;
    }
    b("请连接网络后,重新进入短视频重试");
  }
  
  private void e()
  {
    if (a()) {
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean) && (this.d > 100)) {
        a();
      }
    }
    while ((!this.jdField_a_of_type_Boolean) || (!this.jdField_b_of_type_Boolean)) {
      return;
    }
    a();
  }
  
  private void f()
  {
    if (a())
    {
      int i = (this.c + this.d) / 2;
      b("正在启动拍摄" + i + "%");
      return;
    }
    b("正在启动拍摄" + this.c + "%");
  }
  
  protected int a()
  {
    return 2130970253;
  }
  
  public void a()
  {
    CaptureQmcfSoDownloadFragment.CaptureSoDownloadListener localCaptureSoDownloadListener = (CaptureQmcfSoDownloadFragment.CaptureSoDownloadListener)getActivity();
    if (localCaptureSoDownloadListener != null) {
      localCaptureSoDownloadListener.a();
    }
  }
  
  public void a(int paramInt)
  {
    ThreadManager.getUIHandler().post(new anvw(this, paramInt));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    VideoEnvironment.a("CaptureSoDownloadFragmentAllWaite", "result=" + paramInt1 + ",serverError=" + paramInt2, null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0)
      {
        VideoEnvironment.a("CaptureSoDownloadFragmentAllWaite", "短视频配置解压失败[" + paramInt2 + "]", null);
        ShortVideoResourceManager.a("资源下载失败，请稍后重试。");
        ShortVideoErrorReport.a(1, paramInt2);
        return;
      }
      ArrayList localArrayList = new ArrayList(1);
      paramInt1 = ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList);
      if (paramInt1 == 0)
      {
        VideoEnvironment.a("CaptureSoDownloadFragmentAllWaite", "配置下载成功,插件资源下载中...", null);
        ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, this);
        paramInt1 = PtvFilterSoLoad.a(VideoEnvironment.a());
        VideoEnvironment.a("CaptureSoDownloadFragmentAllWaite", "PtvFilterSoLoad.getFilterSoState resultCode=" + paramInt1, null);
        if (paramInt1 == 2)
        {
          ShortVideoResourceManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, this);
          return;
        }
        if (paramInt1 == 1) {
          ShortVideoResourceManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, null);
        }
        VideoEnvironment.a("CaptureSoDownloadFragmentAllWaite", "onConfigResult| supportSVFilterDownloadSo=false", null);
        return;
      }
      VideoEnvironment.a("CaptureSoDownloadFragmentAllWaite", "短视频配置校验失败[" + paramInt1 + "]", null);
      ShortVideoResourceManager.a("资源下载失败，请稍后重试。");
      ShortVideoErrorReport.a(1, paramInt1);
      return;
    }
    VideoEnvironment.a("CaptureSoDownloadFragmentAllWaite", "短视频配置下载失败[" + paramInt2 + "]", null);
    ShortVideoResourceManager.a("资源下载失败，请稍后重试。");
    ShortVideoErrorReport.a(1, paramInt2);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1.startsWith("new_qq_android_native_short_video_")) {
      if (paramInt != 0)
      {
        VideoEnvironment.a("CaptureSoDownloadFragmentAllWaite", "短视频插件下载失败[" + paramInt + "]", null);
        ShortVideoResourceManager.a("资源下载失败，请稍后重试。");
        ShortVideoErrorReport.a(2, paramInt);
      }
    }
    for (;;)
    {
      VideoEnvironment.a("CaptureSoDownloadFragmentAllWaite", "name=" + paramString1 + ",result=" + paramInt + ",filePath=" + paramString2, null);
      return;
      this.jdField_a_of_type_Int = 100;
      this.jdField_a_of_type_Boolean = true;
      e();
      continue;
      if (paramString1.startsWith("new_qq_android_native_short_filter_")) {
        if (paramInt != 0)
        {
          VideoEnvironment.a("CaptureSoDownloadFragmentAllWaite", "挂件频插件下载失败[" + paramInt + "]", null);
          ShortVideoResourceManager.a("资源下载失败，请稍后重试。");
          ShortVideoErrorReport.a(2, paramInt);
        }
        else
        {
          this.jdField_b_of_type_Int = 100;
          this.jdField_b_of_type_Boolean = true;
          e();
        }
      }
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    if (paramString.startsWith("new_qq_android_native_short_video_")) {
      this.jdField_a_of_type_Int = i;
    }
    for (;;)
    {
      this.c = ((this.jdField_a_of_type_Int + this.jdField_b_of_type_Int) / 2);
      a("doUserDownloadResourceAVCodec:");
      VideoEnvironment.a("CaptureSoDownloadFragmentAllWaite", "name=" + paramString + ",totalLen=" + paramLong2 + ",curOffset=" + paramLong1 + ",localProgress=" + i, null);
      return;
      if (paramString.startsWith("new_qq_android_native_short_filter_")) {
        this.jdField_b_of_type_Int = i;
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    ThreadManager.getUIHandler().post(new anvv(this, paramBoolean1, paramInt));
  }
  
  public void c()
  {
    this.d = 0;
    GestureMgr.a().a(true, this);
    boolean bool = GestureMgr.a().a();
    if (QLog.isColorLevel()) {
      QLog.d("CaptureSoDownloadFragmentAllWaite", 2, "preDownloadGestureRes:" + bool);
    }
    if (!bool)
    {
      ThreadManager.getUIHandler().post(new anvu(this));
      return;
    }
    this.d = 101;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    getActivity().doOnBackPressed();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(a(), paramViewGroup, false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView = ((CameraCaptureView)paramLayoutInflater.findViewById(2131366903));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setDarkModeEnable(false);
    int i = CameraHelper.a();
    paramViewGroup = SVParamManager.a().a(i);
    paramBundle = new CameraCaptureView.CaptureParam();
    paramBundle.a(paramViewGroup.a());
    paramBundle.b(paramViewGroup.b());
    paramBundle.a(SVParamManager.a().a(i));
    paramBundle.d(SVParamManager.a().a(i) * 1000);
    paramBundle.e(1);
    paramBundle.c(i);
    paramBundle.a(false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setCaptureParam(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setSyncStopCamera(true);
    ((Button)paramLayoutInflater.findViewById(2131363969)).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress = ((CircleProgress)paramLayoutInflater.findViewById(2131368942));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setBgAndProgressColor(100, getResources().getColor(2131492968), 100, getResources().getColor(2131493307));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setStrokeWidth(6.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(0.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131369444));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getActivity().getAppInterface());
    boolean bool = VideoEnvironment.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    getActivity().getIntent().getExtras();
    this.jdField_a_of_type_JavaLangString = getActivity().getIntent().getExtras().getString("ARG_ACTIVITY_ID");
    if (!bool)
    {
      QQToast.a(VideoEnvironment.a(), "系统版本过低，不支持短视频功能", 1);
      return paramLayoutInflater;
    }
    if (a())
    {
      c();
      bool = VideoEnvironment.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (PtvFilterSoLoad.a(getActivity()) == 2) {
        break label365;
      }
    }
    label365:
    for (i = 1;; i = 0)
    {
      if ((bool) && (i != 0)) {
        break label371;
      }
      ShortVideoErrorReport.a(2);
      d();
      return paramLayoutInflater;
      this.d = 101;
      break;
    }
    label371:
    VideoEnvironment.a("CaptureSoDownloadFragmentAllWaite", "checkAVCodecLoadIsOK loaded=true, activityId=" + this.jdField_a_of_type_JavaLangString, null);
    ThreadManager.getUIHandler().postDelayed(new anvr(this), 5L);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      ShortVideoResourceManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    }
    GestureMgr.a().a(false, this);
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
  
  public void y_()
  {
    b("网络已断,请连接网络后继续下载");
    VideoEnvironment.a("CaptureSoDownloadFragmentAllWaite", "网络已断,请连接网络后继续下载", null);
    ShortVideoErrorReport.a(3, -1500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.fragment.CaptureQmcfSoDownloadFragmentAllWaite
 * JD-Core Version:    0.7.0.1
 */