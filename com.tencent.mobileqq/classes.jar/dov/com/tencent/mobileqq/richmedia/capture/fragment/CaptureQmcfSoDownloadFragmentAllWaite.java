package dov.com.tencent.mobileqq.richmedia.capture.fragment;

import amtj;
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
import babz;
import bbqi;
import bbrg;
import bbri;
import bbtd;
import bbte;
import bbxj;
import blvn;
import blvp;
import bmbx;
import bnxq;
import bnxr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import dov.com.qq.im.ae.download.AEResInfo;
import dov.com.qq.im.ae.download.AEResUtil;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class CaptureQmcfSoDownloadFragmentAllWaite
  extends ReportV4Fragment
  implements View.OnClickListener, bbrg, bbri, bbte, blvp
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
    e();
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
    boolean bool = NetworkUtil.isNetworkAvailable(null);
    VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", "startDownloadConfig netUsable=" + bool, null);
    if (bool)
    {
      VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", amtj.a(2131700550), null);
      ShortVideoResourceManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      return;
    }
    b(amtj.a(2131700549));
  }
  
  private void d()
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
  
  private void e()
  {
    if (a())
    {
      int i = (this.d + this.e) / 2;
      b(amtj.a(2131700543) + i + "%");
      return;
    }
    b(amtj.a(2131700527) + this.d + "%");
  }
  
  protected int a()
  {
    return 2131560991;
  }
  
  protected void a()
  {
    bnxq localbnxq = (bnxq)getActivity();
    if (localbnxq != null) {
      localbnxq.a();
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
    bbtd.a().a(true, this);
    boolean bool = bbtd.a().a();
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
    if ((paramAEResInfo != null) && (paramAEResInfo.resPrefix != null) && (paramAEResInfo.resPrefix.equals(AEResInfo.AE_RES_BASE_PACKAGE.resPrefix)))
    {
      if (paramInt != 0)
      {
        bmbx.d("CaptureSoDownloadFragmentAllWaite", "[onAEDownloadFinish] error:" + paramInt);
        VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", amtj.a(2131700523) + paramInt + "]", null);
        ShortVideoResourceManager.a(amtj.a(2131700515));
        bbqi.a(2, paramInt);
      }
    }
    else {
      return;
    }
    bmbx.d("CaptureSoDownloadFragmentAllWaite", "[onAEDownloadFinish] mFilterState:100");
    this.jdField_b_of_type_Int = 100;
    this.jdField_b_of_type_Boolean = true;
    d();
  }
  
  public void onAEProgressUpdate(AEResInfo paramAEResInfo, long paramLong1, long paramLong2)
  {
    int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    if ((paramAEResInfo != null) && (paramAEResInfo.resPrefix != null) && (paramAEResInfo.resPrefix.equals(AEResInfo.AE_RES_BASE_PACKAGE.resPrefix))) {
      this.jdField_b_of_type_Int = i;
    }
    StringBuilder localStringBuilder;
    if (b())
    {
      this.d = ((this.jdField_a_of_type_Int + this.jdField_b_of_type_Int + this.jdField_c_of_type_Int) / 3);
      a("doUserDownloadResourceAVCodec:");
      localStringBuilder = new StringBuilder().append("name=");
      if (paramAEResInfo != null) {
        break label162;
      }
    }
    label162:
    for (paramAEResInfo = "null";; paramAEResInfo = paramAEResInfo.resPrefix)
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
        VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", amtj.a(2131700539) + paramInt2 + "]", null);
        ShortVideoResourceManager.a(amtj.a(2131700525));
        bbqi.a(1, paramInt2);
        return;
      }
      ArrayList localArrayList = new ArrayList(1);
      paramInt1 = ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList);
      if (paramInt1 == 0)
      {
        VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", amtj.a(2131700531), null);
        ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, this);
        paramInt1 = AEResUtil.getAEResStatus(AEResInfo.AE_RES_BASE_PACKAGE);
        VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", "PtvFilterSoLoad.getFilterSoState resultCode=" + paramInt1, null);
        if (paramInt1 == 2) {
          blvn.a().a(AEResInfo.AE_RES_BASE_PACKAGE, this, false);
        }
        for (;;)
        {
          paramInt1 = bbxj.a();
          if ((b()) && (paramInt1 != 0)) {
            break;
          }
          this.jdField_c_of_type_Int = 100;
          this.jdField_c_of_type_Boolean = true;
          VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", "onConfigResult| supportQmcfDownloadSo=false", null);
          return;
          if (paramInt1 == 1) {
            blvn.a().a(AEResInfo.AE_RES_BASE_PACKAGE, null, false);
          }
          this.jdField_b_of_type_Int = 100;
          this.jdField_b_of_type_Boolean = true;
          VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", "onConfigResult| supportSVFilterDownloadSo=false", null);
        }
        ShortVideoResourceManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, this);
        return;
      }
      VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", amtj.a(2131700516) + paramInt1 + "]", null);
      ShortVideoResourceManager.a(amtj.a(2131700541));
      bbqi.a(1, paramInt1);
      return;
    }
    VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", amtj.a(2131700524) + paramInt2 + "]", null);
    ShortVideoResourceManager.a(amtj.a(2131700537));
    bbqi.a(1, paramInt2);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    int j = 0;
    paramLayoutInflater = paramLayoutInflater.inflate(a(), paramViewGroup, false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView = ((CameraCaptureView)paramLayoutInflater.findViewById(2131364156));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setDarkModeEnable(false);
    paramViewGroup = bnxr.a().a(paramLayoutInflater.getContext());
    paramViewGroup.a(false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.c(false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setCaptureParam(paramViewGroup);
    ((Button)paramLayoutInflater.findViewById(2131364175)).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress = ((CircleProgress)paramLayoutInflater.findViewById(2131365212));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setBgAndProgressColor(100, getResources().getColor(2131167337), 100, getResources().getColor(2131165375));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setStrokeWidth(6.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(0.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131366943));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getActivity().getAppInterface());
    boolean bool = VideoEnvironment.supportShortVideoRecordAndPlay(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_JavaLangString = getActivity().getIntent().getExtras().getString("ARG_ACTIVITY_ID");
    if (!bool) {
      QQToast.a(VideoEnvironment.getContext(), amtj.a(2131700545), 1);
    }
    for (;;)
    {
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      if (a())
      {
        b();
        label247:
        bool = VideoEnvironment.checkAVCodecLoadIsOK(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (AEResUtil.getAEResStatus(AEResInfo.AE_RES_BASE_PACKAGE) == 2) {
          break label321;
        }
      }
      label321:
      for (int i = 1;; i = 0)
      {
        if ((!b()) || (bbxj.a() != 2)) {
          j = 1;
        }
        if ((bool) && (i != 0) && (j != 0)) {
          break label327;
        }
        bbqi.a(2);
        c();
        break;
        this.e = 101;
        break label247;
      }
      label327:
      VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", "checkAVCodecLoadIsOK loaded=true, activityId=" + this.jdField_a_of_type_JavaLangString, null);
      ThreadManager.getUIHandler().postDelayed(new CaptureQmcfSoDownloadFragmentAllWaite.1(this), 5L);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      blvn.a().a(this);
      ShortVideoResourceManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    }
    bbtd.a().a(false, this);
  }
  
  public void onDownloadFinish(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1.startsWith("new_qq_android_native_short_video_")) {
      if (paramInt != 0)
      {
        VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", amtj.a(2131700514) + paramInt + "]", null);
        ShortVideoResourceManager.a(amtj.a(2131700526));
        bbqi.a(2, paramInt);
      }
    }
    for (;;)
    {
      VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", "name=" + paramString1 + ",result=" + paramInt + ",filePath=" + paramString2, null);
      return;
      this.jdField_a_of_type_Int = 100;
      this.jdField_a_of_type_Boolean = true;
      d();
      continue;
      if (paramString1.startsWith("new_qq_android_native_art_filter_")) {
        if (paramInt != 0)
        {
          VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", amtj.a(2131700547) + paramInt + "]", null);
          ShortVideoResourceManager.a(amtj.a(2131700535));
          bbqi.a(2, paramInt);
        }
        else
        {
          this.jdField_c_of_type_Int = 100;
          this.jdField_c_of_type_Boolean = true;
          d();
        }
      }
    }
  }
  
  public void onNetWorkNone()
  {
    b(amtj.a(2131700544));
    VideoEnvironment.LogDownLoad("CaptureSoDownloadFragmentAllWaite", amtj.a(2131700522), null);
    bbqi.a(3, -1500);
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
        break label135;
      }
    }
    label135:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.fragment.CaptureQmcfSoDownloadFragmentAllWaite
 * JD-Core Version:    0.7.0.1
 */