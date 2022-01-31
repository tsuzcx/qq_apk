package dov.com.tencent.mobileqq.richmedia.capture.fragment;

import alpo;
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
import axmk;
import ayyy;
import ayzw;
import ayzy;
import azbx;
import azby;
import azgk;
import bdee;
import bngp;
import bngq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class CaptureQmcfSoDownloadFragmentAllWaite
  extends Fragment
  implements View.OnClickListener, ayzw, ayzy, azby
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
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int d;
  private volatile int e;
  
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
  
  private void d()
  {
    boolean bool = bdee.g(null);
    VideoEnvironment.a("CaptureSoDownloadFragmentAllWaite", "startDownloadConfig netUsable=" + bool, null);
    if (bool)
    {
      VideoEnvironment.a("CaptureSoDownloadFragmentAllWaite", alpo.a(2131701776), null);
      ShortVideoResourceManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      return;
    }
    b(alpo.a(2131701775));
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
      b(alpo.a(2131701769) + i + "%");
      return;
    }
    b(alpo.a(2131701753) + this.d + "%");
  }
  
  public void G_()
  {
    b(alpo.a(2131701770));
    VideoEnvironment.a("CaptureSoDownloadFragmentAllWaite", alpo.a(2131701748), null);
    ayyy.a(3, -1500);
  }
  
  protected int a()
  {
    return 2131560858;
  }
  
  protected void a()
  {
    bngp localbngp = (bngp)getActivity();
    if (localbngp != null) {
      localbngp.a();
    }
  }
  
  public void a(int paramInt)
  {
    ThreadManager.getUIHandler().post(new CaptureQmcfSoDownloadFragmentAllWaite.6(this, paramInt));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    VideoEnvironment.a("CaptureSoDownloadFragmentAllWaite", "result=" + paramInt1 + ",serverError=" + paramInt2, null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0)
      {
        VideoEnvironment.a("CaptureSoDownloadFragmentAllWaite", alpo.a(2131701765) + paramInt2 + "]", null);
        ShortVideoResourceManager.a(alpo.a(2131701751));
        ayyy.a(1, paramInt2);
        return;
      }
      ArrayList localArrayList = new ArrayList(1);
      paramInt1 = ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList);
      if (paramInt1 == 0)
      {
        VideoEnvironment.a("CaptureSoDownloadFragmentAllWaite", alpo.a(2131701757), null);
        ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, this);
        paramInt1 = azgk.a(VideoEnvironment.a());
        VideoEnvironment.a("CaptureSoDownloadFragmentAllWaite", "PtvFilterSoLoad.getFilterSoState resultCode=" + paramInt1, null);
        if (paramInt1 == 2) {
          ShortVideoResourceManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, this);
        }
        for (;;)
        {
          paramInt1 = azgk.a();
          if ((b()) && (paramInt1 != 0)) {
            break;
          }
          this.jdField_c_of_type_Int = 100;
          this.jdField_c_of_type_Boolean = true;
          VideoEnvironment.a("CaptureSoDownloadFragmentAllWaite", "onConfigResult| supportQmcfDownloadSo=false", null);
          return;
          if (paramInt1 == 1) {
            ShortVideoResourceManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, null);
          }
          this.jdField_b_of_type_Int = 100;
          this.jdField_b_of_type_Boolean = true;
          VideoEnvironment.a("CaptureSoDownloadFragmentAllWaite", "onConfigResult| supportSVFilterDownloadSo=false", null);
        }
        ShortVideoResourceManager.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, this);
        return;
      }
      VideoEnvironment.a("CaptureSoDownloadFragmentAllWaite", alpo.a(2131701742) + paramInt1 + "]", null);
      ShortVideoResourceManager.a(alpo.a(2131701767));
      ayyy.a(1, paramInt1);
      return;
    }
    VideoEnvironment.a("CaptureSoDownloadFragmentAllWaite", alpo.a(2131701750) + paramInt2 + "]", null);
    ShortVideoResourceManager.a(alpo.a(2131701763));
    ayyy.a(1, paramInt2);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1.startsWith("new_qq_android_native_short_video_")) {
      if (paramInt != 0)
      {
        VideoEnvironment.a("CaptureSoDownloadFragmentAllWaite", alpo.a(2131701740) + paramInt + "]", null);
        ShortVideoResourceManager.a(alpo.a(2131701752));
        ayyy.a(2, paramInt);
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
      if (paramString1.startsWith("new_qq_android_native_short_filter_"))
      {
        if (paramInt != 0)
        {
          VideoEnvironment.a("CaptureSoDownloadFragmentAllWaite", alpo.a(2131701749) + paramInt + "]", null);
          ShortVideoResourceManager.a(alpo.a(2131701741));
          ayyy.a(2, paramInt);
        }
        else
        {
          this.jdField_b_of_type_Int = 100;
          this.jdField_b_of_type_Boolean = true;
          e();
        }
      }
      else if (paramString1.startsWith("new_qq_android_native_art_filter_")) {
        if (paramInt != 0)
        {
          VideoEnvironment.a("CaptureSoDownloadFragmentAllWaite", alpo.a(2131701773) + paramInt + "]", null);
          ShortVideoResourceManager.a(alpo.a(2131701761));
          ayyy.a(2, paramInt);
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
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    if (paramString.startsWith("new_qq_android_native_short_video_"))
    {
      this.jdField_a_of_type_Int = i;
      if (!b()) {
        break label151;
      }
    }
    label151:
    for (this.d = ((this.jdField_a_of_type_Int + this.jdField_b_of_type_Int + this.jdField_c_of_type_Int) / 3);; this.d = ((this.jdField_a_of_type_Int + this.jdField_b_of_type_Int) / 2))
    {
      a("doUserDownloadResourceAVCodec:");
      VideoEnvironment.a("CaptureSoDownloadFragmentAllWaite", "name=" + paramString + ",totalLen=" + paramLong2 + ",curOffset=" + paramLong1 + ",localProgress=" + i, null);
      return;
      if (paramString.startsWith("new_qq_android_native_short_filter_"))
      {
        this.jdField_b_of_type_Int = i;
        break;
      }
      if (!paramString.startsWith("new_qq_android_native_art_filter_")) {
        break;
      }
      this.jdField_c_of_type_Int = i;
      break;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    ThreadManager.getUIHandler().post(new CaptureQmcfSoDownloadFragmentAllWaite.5(this, paramBoolean1, paramInt));
  }
  
  public void c()
  {
    this.e = 0;
    azbx.a().a(true, this);
    boolean bool = azbx.a().a();
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
    int j = 0;
    paramLayoutInflater = paramLayoutInflater.inflate(a(), paramViewGroup, false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView = ((CameraCaptureView)paramLayoutInflater.findViewById(2131363888));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setDarkModeEnable(false);
    paramViewGroup = bngq.a().a(paramLayoutInflater.getContext());
    paramViewGroup.a(false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.d(false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setCaptureParam(paramViewGroup);
    ((Button)paramLayoutInflater.findViewById(2131363907)).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress = ((CircleProgress)paramLayoutInflater.findViewById(2131364906));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setBgAndProgressColor(100, getResources().getColor(2131167192), 100, getResources().getColor(2131165332));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setStrokeWidth(6.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(0.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131366597));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getActivity().getAppInterface());
    boolean bool = VideoEnvironment.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_JavaLangString = getActivity().getIntent().getExtras().getString("ARG_ACTIVITY_ID");
    if (!bool)
    {
      QQToast.a(VideoEnvironment.a(), alpo.a(2131701771), 1);
      return paramLayoutInflater;
    }
    if (a())
    {
      c();
      bool = VideoEnvironment.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (azgk.a(getActivity()) == 2) {
        break label316;
      }
    }
    label316:
    for (int i = 1;; i = 0)
    {
      if ((!b()) || (azgk.a() != 2)) {
        j = 1;
      }
      if ((bool) && (i != 0) && (j != 0)) {
        break label322;
      }
      ayyy.a(2);
      d();
      return paramLayoutInflater;
      this.e = 101;
      break;
    }
    label322:
    VideoEnvironment.a("CaptureSoDownloadFragmentAllWaite", "checkAVCodecLoadIsOK loaded=true, activityId=" + this.jdField_a_of_type_JavaLangString, null);
    ThreadManager.getUIHandler().postDelayed(new CaptureQmcfSoDownloadFragmentAllWaite.1(this), 5L);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      ShortVideoResourceManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      ShortVideoResourceManager.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    }
    azbx.a().a(false, this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.fragment.CaptureQmcfSoDownloadFragmentAllWaite
 * JD-Core Version:    0.7.0.1
 */