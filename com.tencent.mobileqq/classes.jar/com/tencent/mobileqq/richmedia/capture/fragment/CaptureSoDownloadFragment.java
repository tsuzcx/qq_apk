package com.tencent.mobileqq.richmedia.capture.fragment;

import ahii;
import ahij;
import ahik;
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
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class CaptureSoDownloadFragment
  extends Fragment
  implements View.OnClickListener, ShortVideoResourceManager.INet_ShortVideoResource, ShortVideoResourceStatus.ISVConfig
{
  private int jdField_a_of_type_Int;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private CameraCaptureView jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView;
  private CircleProgress jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress;
  
  private void a(String paramString)
  {
    ThreadManager.getUIHandler().post(new ahij(this, paramString));
  }
  
  private void b(String paramString)
  {
    ThreadManager.getUIHandler().post(new ahik(this, paramString));
  }
  
  private void c()
  {
    boolean bool = NetworkUtil.g(null);
    VideoEnvironment.a("CaptureSoDownloadFragment", "startDownloadConfig netUsable=" + bool, null);
    if (bool)
    {
      VideoEnvironment.a("CaptureSoDownloadFragment", "短视频配置下载中...", null);
      ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      return;
    }
    b("请连接网络后,重新进入短视频重试");
  }
  
  public void C_()
  {
    b("网络已断,请连接网络后继续下载");
    VideoEnvironment.a("CaptureSoDownloadFragment", "网络已断,请连接网络后继续下载", null);
    ShortVideoErrorReport.a(3, -1500);
  }
  
  protected int a()
  {
    return 2130970269;
  }
  
  public void a()
  {
    CaptureSoDownloadFragment.CaptureSoDownloadListener localCaptureSoDownloadListener = (CaptureSoDownloadFragment.CaptureSoDownloadListener)getActivity();
    if (localCaptureSoDownloadListener != null) {
      localCaptureSoDownloadListener.a();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    VideoEnvironment.a("CaptureSoDownloadFragment", "result=" + paramInt1 + ",serverError=" + paramInt2, null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0)
      {
        VideoEnvironment.a("CaptureSoDownloadFragment", "短视频配置解压失败[" + paramInt2 + "]", null);
        ShortVideoResourceManager.a("资源下载失败，请稍后重试。");
        ShortVideoErrorReport.a(1, paramInt2);
        return;
      }
      ArrayList localArrayList = new ArrayList(1);
      paramInt1 = ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList);
      if (paramInt1 == 0)
      {
        VideoEnvironment.a("CaptureSoDownloadFragment", "配置下载成功,插件资源下载中...", null);
        ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, this);
        paramInt1 = PtvFilterSoLoad.a(VideoEnvironment.a());
        VideoEnvironment.a("CaptureSoDownloadFragment", "PtvFilterSoLoad.getFilterSoState resultCode=" + paramInt1, null);
        if (paramInt1 == 2)
        {
          ShortVideoResourceManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, this);
          return;
        }
        if (paramInt1 == 1) {
          ShortVideoResourceManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, this);
        }
        VideoEnvironment.a("CaptureSoDownloadFragment", "onConfigResult| supportSVFilterDownloadSo=false", null);
        return;
      }
      VideoEnvironment.a("CaptureSoDownloadFragment", "短视频配置校验失败[" + paramInt1 + "]", null);
      ShortVideoResourceManager.a("资源下载失败，请稍后重试。");
      ShortVideoErrorReport.a(1, paramInt1);
      return;
    }
    VideoEnvironment.a("CaptureSoDownloadFragment", "短视频配置下载失败[" + paramInt2 + "]", null);
    ShortVideoResourceManager.a("资源下载失败，请稍后重试。");
    ShortVideoErrorReport.a(1, paramInt2);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1.startsWith("new_qq_android_native_short_video_"))
    {
      if (paramInt == 0) {
        break label97;
      }
      VideoEnvironment.a("CaptureSoDownloadFragment", "短视频插件下载失败[" + paramInt + "]", null);
      ShortVideoResourceManager.a("资源下载失败，请稍后重试。");
      ShortVideoErrorReport.a(2, paramInt);
    }
    for (;;)
    {
      VideoEnvironment.a("CaptureSoDownloadFragment", "name=" + paramString1 + ",result=" + paramInt + ",filePath=" + paramString2, null);
      return;
      label97:
      a();
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    if (paramString.startsWith("new_qq_android_native_short_video_"))
    {
      this.jdField_a_of_type_Int = i;
      a("doUserDownloadResourceAVCodec:");
      b("正在启动拍摄" + this.jdField_a_of_type_Int + "%");
    }
    VideoEnvironment.a("CaptureSoDownloadFragment", "name=" + paramString + ",totalLen=" + paramLong2 + ",curOffset=" + paramLong1 + ",localProgress=" + i, null);
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
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView = ((CameraCaptureView)paramLayoutInflater.findViewById(2131366945));
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
    ((Button)paramLayoutInflater.findViewById(2131363993)).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress = ((CircleProgress)paramLayoutInflater.findViewById(2131369008));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setBgAndProgressColor(100, getResources().getColor(2131492969), 100, getResources().getColor(2131493308));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setStrokeWidth(6.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(0.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131369521));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getActivity().getAppInterface());
    if (!VideoEnvironment.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      QQToast.a(VideoEnvironment.a(), "系统版本过低，不支持短视频功能", 1);
      return paramLayoutInflater;
    }
    if (!VideoEnvironment.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      ShortVideoErrorReport.a(2);
      c();
      return paramLayoutInflater;
    }
    VideoEnvironment.a("CaptureSoDownloadFragment", "checkAVCodecLoadIsOK loaded=true", null);
    ThreadManager.getUIHandler().postDelayed(new ahii(this), 5L);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.fragment.CaptureSoDownloadFragment
 * JD-Core Version:    0.7.0.1
 */