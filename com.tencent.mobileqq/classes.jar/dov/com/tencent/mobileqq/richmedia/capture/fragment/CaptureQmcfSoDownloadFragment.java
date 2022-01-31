package dov.com.tencent.mobileqq.richmedia.capture.fragment;

import ajya;
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
import avuj;
import avul;
import axdu;
import axeq;
import axes;
import axgr;
import axgs;
import axle;
import bbdj;
import bbfj;
import bcql;
import birq;
import birs;
import bjah;
import bkvf;
import bkvg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.richmedia.capture.activity.CaptureQmcfSoDownloadActivity;
import java.util.ArrayList;
import java.util.List;
import mqq.app.QQPermissionDenied;
import mqq.os.MqqHandler;
import wsr;

public class CaptureQmcfSoDownloadFragment
  extends Fragment
  implements View.OnClickListener, avuj, axeq, axes, axgs, birs
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
  private volatile boolean jdField_c_of_type_Boolean;
  private volatile int jdField_d_of_type_Int;
  private volatile boolean jdField_d_of_type_Boolean;
  private volatile boolean e;
  
  private void a(ShortVideoResourceManager.SVConfigItem paramSVConfigItem)
  {
    paramSVConfigItem.name = "new_qq_android_native_short_video_66";
    paramSVConfigItem.arm_url = "http://d.url.cn/myapp/qq_desk/shortvideo/test/new_qq_android_native_short_video_66_test.zip";
    paramSVConfigItem.armv7a_url = "http://d.url.cn/myapp/qq_desk/shortvideo/test/new_qq_android_native_short_video_66_test.zip";
    paramSVConfigItem.x86_url = "http://d.url.cn/myapp/qq_desk/shortvideo/test/new_qq_android_native_short_video_66_test.zip";
    paramSVConfigItem.arm64v8a_url = "http://d.url.cn/myapp/qq_desk/shortvideo/test/new_qq_android_native_short_video_for64bit_66_test_1.zip";
    paramSVConfigItem.arm_md5 = "f600cf0bb06c8c529b625f2ee5f4cdb9";
    paramSVConfigItem.armv7a_md5 = "f600cf0bb06c8c529b625f2ee5f4cdb9";
    paramSVConfigItem.x86_md5 = "f600cf0bb06c8c529b625f2ee5f4cdb9";
    paramSVConfigItem.arm64v8a_md5 = "480b96a75193cee3979c62fea8018768";
    paramSVConfigItem.versionCode = 66;
    paramSVConfigItem.predownload = false;
  }
  
  private void a(String paramString)
  {
    h();
    ThreadManager.getUIHandler().post(new CaptureQmcfSoDownloadFragment.2(this, paramString));
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
    boolean bool = bbfj.g(null);
    VideoEnvironment.a("CaptureQmcfSoDownloadFragment", "startDownloadConfig netUsable=" + bool, null);
    if (bool)
    {
      VideoEnvironment.a("CaptureQmcfSoDownloadFragment", ajya.a(2131701381), null);
      ShortVideoResourceManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      return;
    }
    b(ajya.a(2131701393));
  }
  
  private void f()
  {
    boolean bool = bbfj.g(null);
    VideoEnvironment.a("CaptureQmcfSoDownloadFragment", "startDownloadConfig netUsable=" + bool, null);
    if (bool)
    {
      birq.a().a(0, this, false);
      return;
    }
    bjah.d("CaptureQmcfSoDownloadFragment", "【END】startDownloadAEKitBase:" + ajya.a(2131701374));
    b(ajya.a(2131701374));
  }
  
  private void g()
  {
    if (a()) {
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_d_of_type_Int > 100) && (this.jdField_b_of_type_Boolean)) {
        c();
      }
    }
    do
    {
      return;
      bjah.b("CaptureQmcfSoDownloadFragment", "【isAvCodecDownloaded】" + this.jdField_a_of_type_Boolean);
    } while ((!this.jdField_a_of_type_Boolean) || (!this.jdField_b_of_type_Boolean));
    c();
  }
  
  private void h()
  {
    if (a())
    {
      int i = (this.jdField_c_of_type_Int + this.jdField_d_of_type_Int) / 2;
      b(ajya.a(2131701395) + i + "%");
      return;
    }
    b(ajya.a(2131701404) + this.jdField_c_of_type_Int + "%");
  }
  
  public void G_()
  {
    b(ajya.a(2131701383));
    VideoEnvironment.a("CaptureQmcfSoDownloadFragment", ajya.a(2131701371), null);
    axdu.a(3, -1500);
  }
  
  public void H_()
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
      this.jdField_c_of_type_Boolean = true;
      localCaptureQmcfSoDownloadActivity.requestPermissions(this, 1, new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO" });
      return;
      i = 0;
      break;
    }
    label93:
    if (i != 0)
    {
      this.jdField_c_of_type_Boolean = true;
      localCaptureQmcfSoDownloadActivity.requestPermissions(this, 1, new String[] { "android.permission.CAMERA" });
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    localCaptureQmcfSoDownloadActivity.requestPermissions(this, 1, new String[] { "android.permission.RECORD_AUDIO" });
  }
  
  protected int a()
  {
    return 2131560682;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    }
    birq.a().b(this);
  }
  
  public void a(int paramInt)
  {
    ThreadManager.getUIHandler().post(new CaptureQmcfSoDownloadFragment.6(this, paramInt));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    VideoEnvironment.a("CaptureQmcfSoDownloadFragment", "result=" + paramInt1 + ",serverError=" + paramInt2, null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0)
      {
        VideoEnvironment.a("CaptureQmcfSoDownloadFragment", ajya.a(2131701370) + paramInt2 + "]", null);
        ShortVideoResourceManager.a(ajya.a(2131701386) + "serverError" + paramInt2);
        axdu.a(1, paramInt2);
        return;
      }
      ArrayList localArrayList = new ArrayList(1);
      paramInt1 = ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList);
      if (paramInt1 == 0)
      {
        VideoEnvironment.a("CaptureQmcfSoDownloadFragment", ajya.a(2131701401), null);
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
        bjah.d("CaptureQmcfSoDownloadFragment", ajya.a(2131689792));
        ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, this);
        return;
      }
      if (paramInt1 == -101)
      {
        ShortVideoResourceManager.SVConfigItem localSVConfigItem = new ShortVideoResourceManager.SVConfigItem();
        a(localSVConfigItem);
        localArrayList.add(localSVConfigItem);
        bjah.d("CaptureQmcfSoDownloadFragment", ajya.a(2131689793));
        ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, this);
        return;
      }
      VideoEnvironment.a("CaptureQmcfSoDownloadFragment", ajya.a(2131701385) + paramInt1 + "]", null);
      ShortVideoResourceManager.a(ajya.a(2131701372) + "errorCode:" + paramInt1);
      axdu.a(1, paramInt1);
      return;
    }
    VideoEnvironment.a("CaptureQmcfSoDownloadFragment", ajya.a(2131701399) + paramInt2 + "]", null);
    ShortVideoResourceManager.a(ajya.a(2131701391) + "result:" + paramInt1);
    axdu.a(1, paramInt2);
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2)
  {
    if (paramInt == 0)
    {
      int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
      this.jdField_b_of_type_Int = i;
      this.jdField_c_of_type_Int = ((this.jdField_a_of_type_Int + this.jdField_b_of_type_Int) / 2);
      a("doUserDownloadResource:");
      VideoEnvironment.a("CaptureQmcfSoDownloadFragment", "packageIdx=" + paramInt + ",totalLen=" + paramLong2 + ",curOffset=" + paramLong1 + ",localProgress=" + i, null);
    }
  }
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    bjah.b("CaptureQmcfSoDownloadFragment", "【onAEResDownloadResult】[packageIdx] :" + paramInt1 + "[isDownloaded] :" + paramBoolean + "[errorType] :" + paramInt2);
    if (paramInt1 == 0)
    {
      if (paramBoolean)
      {
        this.jdField_b_of_type_Int = 100;
        this.jdField_b_of_type_Boolean = true;
        g();
      }
    }
    else {
      return;
    }
    VideoEnvironment.a("CaptureQmcfSoDownloadFragment", ajya.a(2131701373) + paramInt2 + "]", null);
    ShortVideoResourceManager.a(ajya.a(2131701389));
    axdu.a(2, paramInt2);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1.startsWith("new_qq_android_native_short_video_"))
    {
      if (paramInt == 0) {
        break label110;
      }
      VideoEnvironment.a("CaptureQmcfSoDownloadFragment", ajya.a(2131701405) + paramInt + "]", null);
      ShortVideoResourceManager.a(ajya.a(2131701382));
      axdu.a(2, paramInt);
    }
    for (;;)
    {
      VideoEnvironment.a("CaptureQmcfSoDownloadFragment", "name=" + paramString1 + ",result=" + paramInt + ",filePath=" + paramString2, null);
      return;
      label110:
      this.jdField_a_of_type_Int = 100;
      this.jdField_a_of_type_Boolean = true;
      g();
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    if (paramString.startsWith("new_qq_android_native_short_video_")) {
      this.jdField_a_of_type_Int = i;
    }
    this.jdField_c_of_type_Int = ((this.jdField_a_of_type_Int + this.jdField_b_of_type_Int) / 2);
    a("doUserDownloadResource:");
    VideoEnvironment.a("CaptureQmcfSoDownloadFragment", "name=" + paramString + ",totalLen=" + paramLong2 + ",curOffset=" + paramLong1 + ",localProgress=" + i, null);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    ThreadManager.getUIHandler().post(new CaptureQmcfSoDownloadFragment.5(this, paramBoolean1, paramInt));
  }
  
  protected void c()
  {
    try
    {
      this.e = true;
      if ((!this.jdField_c_of_type_Boolean) || (this.jdField_d_of_type_Boolean))
      {
        bkvf localbkvf = (bkvf)getActivity();
        if (localbkvf != null) {
          localbkvf.a();
        }
      }
      return;
    }
    finally {}
  }
  
  public void d()
  {
    this.jdField_d_of_type_Int = 0;
    axgr.a().a(true, this);
    boolean bool = axgr.a().a();
    if (QLog.isColorLevel()) {
      QLog.d("CaptureQmcfSoDownloadFragment", 2, "preDownloadGestureRes:" + bool);
    }
    if (!bool)
    {
      ThreadManager.getUIHandler().post(new CaptureQmcfSoDownloadFragment.4(this));
      return;
    }
    this.jdField_d_of_type_Int = 101;
  }
  
  @QQPermissionDenied(1)
  public void denied()
  {
    if (Build.VERSION.SDK_INT < 23) {
      return;
    }
    this.jdField_d_of_type_Boolean = false;
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
      localObject = bbdj.a(new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO" });
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
        localObject = bbdj.a(new String[] { "android.permission.CAMERA" });
      } else {
        localObject = bbdj.a(new String[] { "android.permission.RECORD_AUDIO" });
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
    //   4: putfield 358	dov/com/tencent/mobileqq/richmedia/capture/fragment/CaptureQmcfSoDownloadFragment:jdField_d_of_type_Boolean	Z
    //   7: aload_0
    //   8: getfield 356	dov/com/tencent/mobileqq/richmedia/capture/fragment/CaptureQmcfSoDownloadFragment:e	Z
    //   11: ifeq +24 -> 35
    //   14: aload_0
    //   15: invokevirtual 226	dov/com/tencent/mobileqq/richmedia/capture/fragment/CaptureQmcfSoDownloadFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   18: checkcast 360	bkvf
    //   21: astore_1
    //   22: aload_1
    //   23: ifnull +9 -> 32
    //   26: aload_1
    //   27: invokeinterface 362 1 0
    //   32: aload_0
    //   33: monitorexit
    //   34: return
    //   35: aload_0
    //   36: getfield 45	dov/com/tencent/mobileqq/richmedia/capture/fragment/CaptureQmcfSoDownloadFragment:jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView	Lcom/tencent/mobileqq/richmedia/capture/view/CameraCaptureView;
    //   39: iconst_1
    //   40: invokevirtual 408	com/tencent/mobileqq/richmedia/capture/view/CameraCaptureView:setCameraPermissionResult	(Z)V
    //   43: goto -11 -> 32
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	CaptureQmcfSoDownloadFragment
    //   21	6	1	localbkvf	bkvf
    //   46	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	22	46	finally
    //   26	32	46	finally
    //   35	43	46	finally
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
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView = ((CameraCaptureView)paramLayoutInflater.findViewById(2131363832));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setDarkModeEnable(false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setCameraPermissionListener(this);
    paramViewGroup = bkvg.a().a(paramLayoutInflater.getContext());
    paramViewGroup.a(false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.d(false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setCaptureParam(paramViewGroup);
    ((Button)paramLayoutInflater.findViewById(2131363851)).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress = ((CircleProgress)paramLayoutInflater.findViewById(2131364821));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setBgAndProgressColor(100, getResources().getColor(2131167134), 100, getResources().getColor(2131165297));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setStrokeWidth(6.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(0.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131366491));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getActivity().getAppInterface());
    boolean bool = VideoEnvironment.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_JavaLangString = getActivity().getIntent().getExtras().getString("ARG_ACTIVITY_ID");
    if (!bool)
    {
      bcql.a(VideoEnvironment.a(), ajya.a(2131701387), 1);
      return paramLayoutInflater;
    }
    int i;
    if (a())
    {
      d();
      bool = VideoEnvironment.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (axle.a(BaseApplicationImpl.getContext()) == 2) {
        break label328;
      }
      i = 1;
      label269:
      if ((bool) && (i != 0)) {
        break label361;
      }
      if (bool) {
        break label334;
      }
      axdu.a(2);
      bjah.b("CaptureQmcfSoDownloadFragment", "【START】startDownloadConfig");
      e();
    }
    for (;;)
    {
      if (i != 0) {
        break label348;
      }
      bjah.b("CaptureQmcfSoDownloadFragment", "【START】startDownloadAEKitBase");
      f();
      return paramLayoutInflater;
      this.jdField_d_of_type_Int = 101;
      break;
      label328:
      i = 0;
      break label269;
      label334:
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Int = 100;
    }
    label348:
    this.jdField_b_of_type_Boolean = true;
    this.jdField_b_of_type_Int = 100;
    return paramLayoutInflater;
    label361:
    VideoEnvironment.a("CaptureQmcfSoDownloadFragment", "checkAVCodecLoadIsOK loaded=true, activityId=" + this.jdField_a_of_type_JavaLangString, null);
    ThreadManager.getUIHandler().postDelayed(new CaptureQmcfSoDownloadFragment.1(this), 5L);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    axgr.a().a(false, this);
    if (QLog.isDevelopLevel()) {
      QLog.d("CaptureQmcfSoDownloadFragment", 4, "in CaptureQmcfSoDownloadFragment onDestroy");
    }
    a();
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
      wsr.a(getActivity().getWindow());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.fragment.CaptureQmcfSoDownloadFragment
 * JD-Core Version:    0.7.0.1
 */