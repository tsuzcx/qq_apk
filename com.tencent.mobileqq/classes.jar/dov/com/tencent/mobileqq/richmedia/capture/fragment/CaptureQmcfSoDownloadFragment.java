package dov.com.tencent.mobileqq.richmedia.capture.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.biz.subscribe.utils.NavigationBarUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.CameraPermissionListener;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.CaptureParam;
import com.tencent.mobileqq.shortvideo.ShortVideoErrorReport;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.INet_ShortVideoResource;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceStatus.ISVConfig;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgr;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgr.GestureStatusListener;
import com.tencent.mobileqq.utils.DialogUtil;
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
import dov.com.tencent.mobileqq.richmedia.capture.activity.CaptureQmcfSoDownloadActivity;
import dov.com.tencent.mobileqq.richmedia.capture.util.DovSVParamManager;
import java.util.ArrayList;
import java.util.List;
import mqq.app.QQPermissionDenied;
import mqq.os.MqqHandler;

public class CaptureQmcfSoDownloadFragment
  extends ReportV4Fragment
  implements View.OnClickListener, CameraCaptureView.CameraPermissionListener, ShortVideoResourceManager.INet_ShortVideoResource, ShortVideoResourceStatus.ISVConfig, GestureMgr.GestureStatusListener, AEResManager.AEDownloadCallBack
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
  private int jdField_d_of_type_Int = 0;
  private volatile boolean jdField_d_of_type_Boolean = false;
  private volatile int jdField_e_of_type_Int = 0;
  private volatile boolean jdField_e_of_type_Boolean = false;
  private volatile boolean f = false;
  
  private void a(ShortVideoResourceManager.SVConfigItem paramSVConfigItem)
  {
    paramSVConfigItem.name = "new_qq_android_native_short_video_66";
    paramSVConfigItem.arm_url = "https://d.url.cn/myapp/qq_desk/shortvideo/test/new_qq_android_native_short_video_66_test.zip";
    paramSVConfigItem.armv7a_url = "https://d.url.cn/myapp/qq_desk/shortvideo/test/new_qq_android_native_short_video_66_test.zip";
    paramSVConfigItem.x86_url = "https://d.url.cn/myapp/qq_desk/shortvideo/test/new_qq_android_native_short_video_66_test.zip";
    paramSVConfigItem.arm64v8a_url = "https://d.url.cn/myapp/qq_desk/shortvideo/test/new_qq_android_native_short_video_for64bit_66_test_1.zip";
    paramSVConfigItem.arm_md5 = "f600cf0bb06c8c529b625f2ee5f4cdb9";
    paramSVConfigItem.armv7a_md5 = "f600cf0bb06c8c529b625f2ee5f4cdb9";
    paramSVConfigItem.x86_md5 = "f600cf0bb06c8c529b625f2ee5f4cdb9";
    paramSVConfigItem.arm64v8a_md5 = "480b96a75193cee3979c62fea8018768";
    paramSVConfigItem.versionCode = 66;
    paramSVConfigItem.predownload = false;
  }
  
  private void a(String paramString)
  {
    g();
    ThreadManager.getUIHandler().post(new CaptureQmcfSoDownloadFragment.2(this, paramString));
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = NetworkUtil.g(null);
    VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", "startDownloadConfig netUsable=" + bool, null);
    if (bool)
    {
      if (!paramBoolean1) {
        AEResManager.a().a(AEResInfo.b, this, false);
      }
      if (!paramBoolean2) {
        AEResManager.a().a(AEResInfo.c, this, false);
      }
      return;
    }
    AEQLog.d("CaptureQmcfSoDownloadFragment", "【END】startDownloadGyBase:" + HardCodeUtil.a(2131701447));
    b(HardCodeUtil.a(2131701447));
  }
  
  private boolean a()
  {
    return false;
  }
  
  private void b(String paramString)
  {
    ThreadManager.getUIHandler().post(new CaptureQmcfSoDownloadFragment.3(this, paramString));
  }
  
  private void e()
  {
    boolean bool = NetworkUtil.g(null);
    VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", "startDownloadConfig netUsable=" + bool, null);
    if (bool)
    {
      VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", HardCodeUtil.a(2131701454), null);
      ShortVideoResourceManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      return;
    }
    b(HardCodeUtil.a(2131701466));
  }
  
  private void f()
  {
    if (a()) {
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_e_of_type_Int > 100) && (this.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Boolean)) {
        c();
      }
    }
    do
    {
      return;
      AEQLog.b("CaptureQmcfSoDownloadFragment", "[isAvCodecDownloaded]" + this.jdField_a_of_type_Boolean);
      AEQLog.b("CaptureQmcfSoDownloadFragment", "[isAEKitBaseDownloaded]" + this.jdField_b_of_type_Boolean);
    } while ((!this.jdField_a_of_type_Boolean) || (!this.jdField_b_of_type_Boolean) || (!this.jdField_c_of_type_Boolean));
    c();
  }
  
  private void g()
  {
    if (a())
    {
      int i = (this.jdField_d_of_type_Int + this.jdField_e_of_type_Int) / 2;
      b(HardCodeUtil.a(2131701468) + i + "%");
      return;
    }
    b(HardCodeUtil.a(2131701477) + this.jdField_d_of_type_Int + "%");
  }
  
  protected int a()
  {
    return 2131561140;
  }
  
  public void a()
  {
    if (Build.VERSION.SDK_INT < 23) {}
    while (!(getActivity() instanceof CaptureQmcfSoDownloadActivity)) {
      return;
    }
    CaptureQmcfSoDownloadActivity localCaptureQmcfSoDownloadActivity = (CaptureQmcfSoDownloadActivity)getActivity();
    int i;
    if (localCaptureQmcfSoDownloadActivity.checkSelfPermission("android.permission.CAMERA") != 0)
    {
      i = 1;
      if (localCaptureQmcfSoDownloadActivity.checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
        break label88;
      }
    }
    label88:
    for (int j = 1;; j = 0)
    {
      if ((i == 0) || (j == 0)) {
        break label93;
      }
      this.jdField_d_of_type_Boolean = true;
      localCaptureQmcfSoDownloadActivity.requestPermissions(this, 1, new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO" });
      return;
      i = 0;
      break;
    }
    label93:
    if (i != 0)
    {
      this.jdField_d_of_type_Boolean = true;
      localCaptureQmcfSoDownloadActivity.requestPermissions(this, 1, new String[] { "android.permission.CAMERA" });
      return;
    }
    this.jdField_d_of_type_Boolean = true;
    localCaptureQmcfSoDownloadActivity.requestPermissions(this, 1, new String[] { "android.permission.RECORD_AUDIO" });
  }
  
  public void a(int paramInt)
  {
    ThreadManager.getUIHandler().post(new CaptureQmcfSoDownloadFragment.6(this, paramInt));
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    ThreadManager.getUIHandler().post(new CaptureQmcfSoDownloadFragment.5(this, paramBoolean1, paramInt));
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      ShortVideoResourceManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    }
    AEResManager.a().a(this);
  }
  
  protected void c()
  {
    try
    {
      this.f = true;
      if ((!this.jdField_d_of_type_Boolean) || (this.jdField_e_of_type_Boolean))
      {
        CaptureQmcfSoDownloadFragment.CaptureSoDownloadListener localCaptureSoDownloadListener = (CaptureQmcfSoDownloadFragment.CaptureSoDownloadListener)getActivity();
        if (localCaptureSoDownloadListener != null) {
          localCaptureSoDownloadListener.a();
        }
      }
      return;
    }
    finally {}
  }
  
  public void d()
  {
    this.jdField_e_of_type_Int = 0;
    GestureMgr.a().a(true, this);
    boolean bool = GestureMgr.a().a();
    if (QLog.isColorLevel()) {
      QLog.d("CaptureQmcfSoDownloadFragment", 2, "preDownloadGestureRes:" + bool);
    }
    if (!bool)
    {
      ThreadManager.getUIHandler().post(new CaptureQmcfSoDownloadFragment.4(this));
      return;
    }
    this.jdField_e_of_type_Int = 101;
  }
  
  @QQPermissionDenied(1)
  public void denied()
  {
    if (Build.VERSION.SDK_INT < 23) {
      return;
    }
    this.jdField_e_of_type_Boolean = false;
    Object localObject = getActivity();
    int i;
    int j;
    if (((Activity)localObject).checkSelfPermission("android.permission.CAMERA") != 0)
    {
      i = 1;
      if (((Activity)localObject).checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
        break label89;
      }
      j = 1;
      label41:
      if ((i == 0) || (j == 0)) {
        break label94;
      }
      localObject = DialogUtil.a(new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO" });
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new CaptureQmcfSoDownloadFragment.7(this, (String)localObject));
      return;
      i = 0;
      break;
      label89:
      j = 0;
      break label41;
      label94:
      if (i != 0) {
        localObject = DialogUtil.a(new String[] { "android.permission.CAMERA" });
      } else {
        localObject = DialogUtil.a(new String[] { "android.permission.RECORD_AUDIO" });
      }
    }
  }
  
  /* Error */
  @mqq.app.QQPermissionGrant(1)
  public void grant()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield 53	dov/com/tencent/mobileqq/richmedia/capture/fragment/CaptureQmcfSoDownloadFragment:jdField_e_of_type_Boolean	Z
    //   7: aload_0
    //   8: getfield 55	dov/com/tencent/mobileqq/richmedia/capture/fragment/CaptureQmcfSoDownloadFragment:f	Z
    //   11: ifeq +24 -> 35
    //   14: aload_0
    //   15: invokevirtual 241	dov/com/tencent/mobileqq/richmedia/capture/fragment/CaptureQmcfSoDownloadFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   18: checkcast 277	dov/com/tencent/mobileqq/richmedia/capture/fragment/CaptureQmcfSoDownloadFragment$CaptureSoDownloadListener
    //   21: astore_1
    //   22: aload_1
    //   23: ifnull +9 -> 32
    //   26: aload_1
    //   27: invokeinterface 279 1 0
    //   32: aload_0
    //   33: monitorexit
    //   34: return
    //   35: aload_0
    //   36: getfield 64	dov/com/tencent/mobileqq/richmedia/capture/fragment/CaptureQmcfSoDownloadFragment:jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView	Lcom/tencent/mobileqq/richmedia/capture/view/CameraCaptureView;
    //   39: iconst_1
    //   40: invokevirtual 326	com/tencent/mobileqq/richmedia/capture/view/CameraCaptureView:setCameraPermissionResult	(Z)V
    //   43: goto -11 -> 32
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	CaptureQmcfSoDownloadFragment
    //   21	6	1	localCaptureSoDownloadListener	CaptureQmcfSoDownloadFragment.CaptureSoDownloadListener
    //   46	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	22	46	finally
    //   26	32	46	finally
    //   35	43	46	finally
  }
  
  public void onAEDownloadFinish(AEResInfo paramAEResInfo, String paramString, boolean paramBoolean, int paramInt)
  {
    AEQLog.b("CaptureQmcfSoDownloadFragment", "【onAEResDownloadResult】[packageIdx] :" + paramAEResInfo.jdField_a_of_type_Int + "[isDownloaded] :" + paramBoolean + "[errorType] :" + paramInt);
    if (paramAEResInfo == AEResInfo.b) {
      if (paramBoolean)
      {
        AEQLog.d("CaptureQmcfSoDownloadFragment", "[onAEDownloadFinish] success, package=" + paramAEResInfo.jdField_a_of_type_JavaLangString);
        this.jdField_b_of_type_Int = 100;
        this.jdField_d_of_type_Int = ((this.jdField_a_of_type_Int + this.jdField_b_of_type_Int + this.jdField_c_of_type_Int) / 3);
        a("doUserDownloadResource:");
        this.jdField_b_of_type_Boolean = true;
        f();
      }
    }
    while (paramAEResInfo != AEResInfo.c)
    {
      return;
      AEQLog.d("CaptureQmcfSoDownloadFragment", "[onAEDownloadFinish] error:" + paramInt);
      VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", HardCodeUtil.a(2131701446) + paramInt + "]", null);
      ShortVideoResourceManager.a(HardCodeUtil.a(2131701462));
      ShortVideoErrorReport.a(2, paramInt);
      return;
    }
    if (paramBoolean)
    {
      AEQLog.d("CaptureQmcfSoDownloadFragment", "[onAEDownloadFinish] success, package=" + paramAEResInfo.jdField_a_of_type_JavaLangString);
      this.jdField_c_of_type_Int = 100;
      this.jdField_d_of_type_Int = ((this.jdField_a_of_type_Int + this.jdField_b_of_type_Int + this.jdField_c_of_type_Int) / 3);
      a("doUserDownloadResource:");
      this.jdField_c_of_type_Boolean = true;
      f();
      return;
    }
    AEQLog.d("CaptureQmcfSoDownloadFragment", "[onAEDownloadFinish] error:" + paramInt);
    VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", HardCodeUtil.a(2131701446) + paramInt + "]", null);
    ShortVideoResourceManager.a(HardCodeUtil.a(2131701462));
    ShortVideoErrorReport.a(2, paramInt);
  }
  
  public void onAEProgressUpdate(AEResInfo paramAEResInfo, long paramLong1, long paramLong2)
  {
    int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    if (paramAEResInfo == AEResInfo.b) {
      this.jdField_b_of_type_Int = i;
    }
    for (;;)
    {
      this.jdField_d_of_type_Int = ((this.jdField_a_of_type_Int + this.jdField_b_of_type_Int + this.jdField_c_of_type_Int) / 3);
      a("doUserDownloadResource:");
      VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", "packageIdx=" + paramAEResInfo.jdField_a_of_type_Int + ",totalLen=" + paramLong2 + ",curOffset=" + paramLong1 + ",localProgress=" + i, null);
      return;
      if (paramAEResInfo == AEResInfo.c) {
        this.jdField_c_of_type_Int = i;
      }
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
    VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", "result=" + paramInt1 + ",serverError=" + paramInt2, null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0)
      {
        AEQLog.d("CaptureQmcfSoDownloadFragment", "[onConfigResult]:serverError" + paramInt2);
        VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", HardCodeUtil.a(2131701443) + paramInt2 + "]", null);
        ShortVideoResourceManager.a(HardCodeUtil.a(2131701459) + "serverError" + paramInt2);
        ShortVideoErrorReport.a(1, paramInt2);
        ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
        return;
      }
      ArrayList localArrayList = new ArrayList(1);
      paramInt1 = ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList);
      if (paramInt1 == 0)
      {
        AEQLog.d("CaptureQmcfSoDownloadFragment", "[onConfigResult]:success");
        VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", HardCodeUtil.a(2131701474), null);
        ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, this);
        return;
      }
      if (paramInt1 == -2)
      {
        paramInt1 = 0;
        while (paramInt1 < localArrayList.size())
        {
          a((ShortVideoResourceManager.SVConfigItem)localArrayList.get(paramInt1));
          paramInt1 += 1;
        }
        AEQLog.d("CaptureQmcfSoDownloadFragment", HardCodeUtil.a(2131689804));
        ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, this);
        return;
      }
      if (paramInt1 == -101)
      {
        ShortVideoResourceManager.SVConfigItem localSVConfigItem = new ShortVideoResourceManager.SVConfigItem();
        a(localSVConfigItem);
        localArrayList.add(localSVConfigItem);
        AEQLog.d("CaptureQmcfSoDownloadFragment", HardCodeUtil.a(2131689805));
        ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, this);
        return;
      }
      AEQLog.d("CaptureQmcfSoDownloadFragment", "[onConfigResult]:errCode" + paramInt1);
      VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", HardCodeUtil.a(2131701458) + paramInt1 + "]", null);
      ShortVideoResourceManager.a(HardCodeUtil.a(2131701445) + "errorCode:" + paramInt1);
      ShortVideoErrorReport.a(1, paramInt1);
      return;
    }
    AEQLog.d("CaptureQmcfSoDownloadFragment", "[onConfigResult]result:" + paramInt1);
    VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", HardCodeUtil.a(2131701472) + paramInt2 + "]", null);
    ShortVideoResourceManager.a(HardCodeUtil.a(2131701464) + "result:" + paramInt1);
    ShortVideoErrorReport.a(1, paramInt2);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    boolean bool2 = false;
    paramLayoutInflater = paramLayoutInflater.inflate(a(), paramViewGroup, false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView = ((CameraCaptureView)paramLayoutInflater.findViewById(2131364338));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setDarkModeEnable(false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setCameraPermissionListener(this);
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
      QQToast.a(VideoEnvironment.getContext(), HardCodeUtil.a(2131701460), 1);
    }
    for (;;)
    {
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      if (a())
      {
        d();
        label251:
        boolean bool3 = VideoEnvironment.checkAndLoadAVCodec();
        if (AEResUtil.a(AEResInfo.b) == 2) {
          break label376;
        }
        bool1 = true;
        label269:
        if (AEResUtil.a(AEResInfo.c) != 2) {
          bool2 = true;
        }
        if ((bool3) && (bool1) && (bool2)) {
          break label431;
        }
        if (bool3) {
          break label382;
        }
        ShortVideoErrorReport.a(2);
        AEQLog.d("CaptureQmcfSoDownloadFragment", "【START】startDownloadConfig");
        e();
      }
      for (;;)
      {
        if ((bool1) && (bool2)) {
          break label404;
        }
        AEQLog.d("CaptureQmcfSoDownloadFragment", "【START】startDownloadAEKitBase / LightBase");
        if (bool1) {
          this.jdField_b_of_type_Boolean = true;
        }
        if (bool2) {
          this.jdField_c_of_type_Boolean = true;
        }
        a(bool1, bool2);
        break;
        this.jdField_e_of_type_Int = 101;
        break label251;
        label376:
        bool1 = false;
        break label269;
        label382:
        AEQLog.d("CaptureQmcfSoDownloadFragment", "【START】AVcodec isReady");
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Int = 100;
      }
      label404:
      AEQLog.d("CaptureQmcfSoDownloadFragment", "【START】isAEKitBaseDownloaded=true, isLightBaseDownloaded=true");
      this.jdField_b_of_type_Boolean = true;
      this.jdField_c_of_type_Boolean = true;
      this.jdField_b_of_type_Int = 100;
      continue;
      label431:
      AEQLog.d("CaptureQmcfSoDownloadFragment", "【START】onSoDownloadCompleted()");
      VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", "checkAVCodecLoadIsOK loaded=true, activityId=" + this.jdField_a_of_type_JavaLangString, null);
      ThreadManager.getUIHandler().postDelayed(new CaptureQmcfSoDownloadFragment.1(this), 5L);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    GestureMgr.a().a(false, this);
    if (QLog.isDevelopLevel()) {
      QLog.d("CaptureQmcfSoDownloadFragment", 4, "in CaptureQmcfSoDownloadFragment onDestroy");
    }
    b();
  }
  
  public void onDownloadFinish(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1.startsWith("new_qq_android_native_short_video_"))
    {
      if (paramInt == 0) {
        break label135;
      }
      AEQLog.d("CaptureQmcfSoDownloadFragment", "[onDownloadFinish] error result" + paramInt);
      VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", HardCodeUtil.a(2131701478) + paramInt + "]", null);
      ShortVideoResourceManager.a(HardCodeUtil.a(2131701455));
      ShortVideoErrorReport.a(2, paramInt);
    }
    for (;;)
    {
      VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", "name=" + paramString1 + ",result=" + paramInt + ",filePath=" + paramString2, null);
      return;
      label135:
      AEQLog.d("CaptureQmcfSoDownloadFragment", "[onDownloadFinish] success");
      this.jdField_a_of_type_Int = 100;
      this.jdField_a_of_type_Boolean = true;
      f();
    }
  }
  
  public void onNetWorkNone()
  {
    b(HardCodeUtil.a(2131701456));
    VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", HardCodeUtil.a(2131701444), null);
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
    if (Build.VERSION.SDK_INT >= 29) {
      NavigationBarUtil.a(getActivity().getWindow());
    }
  }
  
  public void onUpdateProgress(String paramString, long paramLong1, long paramLong2)
  {
    int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    if (paramString.startsWith("new_qq_android_native_short_video_")) {
      this.jdField_a_of_type_Int = i;
    }
    this.jdField_d_of_type_Int = ((this.jdField_a_of_type_Int + this.jdField_b_of_type_Int + this.jdField_c_of_type_Int) / 3);
    a("doUserDownloadResource:");
    VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", "name=" + paramString + ",totalLen=" + paramLong2 + ",curOffset=" + paramLong1 + ",localProgress=" + i, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.fragment.CaptureQmcfSoDownloadFragment
 * JD-Core Version:    0.7.0.1
 */