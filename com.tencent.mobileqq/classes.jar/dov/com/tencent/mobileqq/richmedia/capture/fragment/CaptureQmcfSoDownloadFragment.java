package dov.com.tencent.mobileqq.richmedia.capture.fragment;

import amtj;
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
import babx;
import babz;
import bbqi;
import bbrg;
import bbri;
import bbtd;
import bbte;
import bfur;
import blvn;
import blvp;
import bmbx;
import bnxq;
import bnxr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.SVConfigItem;
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
import dov.com.tencent.mobileqq.richmedia.capture.activity.CaptureQmcfSoDownloadActivity;
import java.util.ArrayList;
import java.util.List;
import mqq.app.QQPermissionDenied;
import mqq.os.MqqHandler;
import zjv;

public class CaptureQmcfSoDownloadFragment
  extends ReportV4Fragment
  implements View.OnClickListener, babx, bbrg, bbri, bbte, blvp
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
  
  private boolean a()
  {
    return false;
  }
  
  private void b(String paramString)
  {
    ThreadManager.getUIHandler().post(new CaptureQmcfSoDownloadFragment.3(this, paramString));
  }
  
  private void d()
  {
    boolean bool = NetworkUtil.isNetworkAvailable(null);
    VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", "startDownloadConfig netUsable=" + bool, null);
    if (bool)
    {
      VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", amtj.a(2131700528), null);
      ShortVideoResourceManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      return;
    }
    b(amtj.a(2131700540));
  }
  
  private void e()
  {
    boolean bool = NetworkUtil.isNetworkAvailable(null);
    VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", "startDownloadConfig netUsable=" + bool, null);
    if (bool)
    {
      blvn.a().a(AEResInfo.AE_RES_BASE_PACKAGE, this, false);
      return;
    }
    bmbx.d("CaptureQmcfSoDownloadFragment", "【END】startDownloadAEKitBase:" + amtj.a(2131700521));
    b(amtj.a(2131700521));
  }
  
  private void f()
  {
    if (a()) {
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_d_of_type_Int > 100) && (this.jdField_b_of_type_Boolean)) {
        b();
      }
    }
    do
    {
      return;
      bmbx.b("CaptureQmcfSoDownloadFragment", "[isAvCodecDownloaded]" + this.jdField_a_of_type_Boolean);
      bmbx.b("CaptureQmcfSoDownloadFragment", "[isAEKitBaseDownloaded]" + this.jdField_b_of_type_Boolean);
    } while ((!this.jdField_a_of_type_Boolean) || (!this.jdField_b_of_type_Boolean));
    b();
  }
  
  private void g()
  {
    if (a())
    {
      int i = (this.jdField_c_of_type_Int + this.jdField_d_of_type_Int) / 2;
      b(amtj.a(2131700542) + i + "%");
      return;
    }
    b(amtj.a(2131700551) + this.jdField_c_of_type_Int + "%");
  }
  
  protected int a()
  {
    return 2131560991;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    }
    blvn.a().a(this);
  }
  
  public void a(int paramInt)
  {
    ThreadManager.getUIHandler().post(new CaptureQmcfSoDownloadFragment.6(this, paramInt));
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    ThreadManager.getUIHandler().post(new CaptureQmcfSoDownloadFragment.5(this, paramBoolean1, paramInt));
  }
  
  protected void b()
  {
    try
    {
      this.e = true;
      if ((!this.jdField_c_of_type_Boolean) || (this.jdField_d_of_type_Boolean))
      {
        bnxq localbnxq = (bnxq)getActivity();
        if (localbnxq != null) {
          localbnxq.a();
        }
      }
      return;
    }
    finally {}
  }
  
  public void c()
  {
    this.jdField_d_of_type_Int = 0;
    bbtd.a().a(true, this);
    boolean bool = bbtd.a().a();
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
        break label93;
      }
      j = 1;
      label43:
      if ((i == 0) || (j == 0)) {
        break label98;
      }
      localObject = bfur.a(new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO" });
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new CaptureQmcfSoDownloadFragment.7(this, (String)localObject));
      return;
      i = 0;
      break;
      label93:
      j = 0;
      break label43;
      label98:
      if (i != 0) {
        localObject = bfur.a(new String[] { "android.permission.CAMERA" });
      } else {
        localObject = bfur.a(new String[] { "android.permission.RECORD_AUDIO" });
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
    //   4: putfield 243	dov/com/tencent/mobileqq/richmedia/capture/fragment/CaptureQmcfSoDownloadFragment:jdField_d_of_type_Boolean	Z
    //   7: aload_0
    //   8: getfield 239	dov/com/tencent/mobileqq/richmedia/capture/fragment/CaptureQmcfSoDownloadFragment:e	Z
    //   11: ifeq +24 -> 35
    //   14: aload_0
    //   15: invokevirtual 247	dov/com/tencent/mobileqq/richmedia/capture/fragment/CaptureQmcfSoDownloadFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   18: checkcast 249	bnxq
    //   21: astore_1
    //   22: aload_1
    //   23: ifnull +9 -> 32
    //   26: aload_1
    //   27: invokeinterface 251 1 0
    //   32: aload_0
    //   33: monitorexit
    //   34: return
    //   35: aload_0
    //   36: getfield 45	dov/com/tencent/mobileqq/richmedia/capture/fragment/CaptureQmcfSoDownloadFragment:jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView	Lcom/tencent/mobileqq/richmedia/capture/view/CameraCaptureView;
    //   39: iconst_1
    //   40: invokevirtual 312	com/tencent/mobileqq/richmedia/capture/view/CameraCaptureView:setCameraPermissionResult	(Z)V
    //   43: goto -11 -> 32
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	CaptureQmcfSoDownloadFragment
    //   21	6	1	localbnxq	bnxq
    //   46	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	22	46	finally
    //   26	32	46	finally
    //   35	43	46	finally
  }
  
  public void l()
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
        break label92;
      }
    }
    label92:
    for (int j = 1;; j = 0)
    {
      if ((i == 0) || (j == 0)) {
        break label97;
      }
      this.jdField_c_of_type_Boolean = true;
      localCaptureQmcfSoDownloadActivity.requestPermissions(this, 1, new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO" });
      return;
      i = 0;
      break;
    }
    label97:
    if (i != 0)
    {
      this.jdField_c_of_type_Boolean = true;
      localCaptureQmcfSoDownloadActivity.requestPermissions(this, 1, new String[] { "android.permission.CAMERA" });
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    localCaptureQmcfSoDownloadActivity.requestPermissions(this, 1, new String[] { "android.permission.RECORD_AUDIO" });
  }
  
  public void onAEDownloadFinish(AEResInfo paramAEResInfo, String paramString, boolean paramBoolean, int paramInt)
  {
    bmbx.b("CaptureQmcfSoDownloadFragment", "【onAEResDownloadResult】[packageIdx] :" + paramAEResInfo.index + "[isDownloaded] :" + paramBoolean + "[errorType] :" + paramInt);
    if (paramAEResInfo == AEResInfo.AE_RES_BASE_PACKAGE)
    {
      if (paramBoolean)
      {
        bmbx.d("CaptureQmcfSoDownloadFragment", "[onAEDownloadFinish] success");
        this.jdField_b_of_type_Int = 100;
        this.jdField_c_of_type_Int = ((this.jdField_a_of_type_Int + this.jdField_b_of_type_Int) / 2);
        a("doUserDownloadResource:");
        this.jdField_b_of_type_Boolean = true;
        f();
      }
    }
    else {
      return;
    }
    bmbx.d("CaptureQmcfSoDownloadFragment", "[onAEDownloadFinish] error:" + paramInt);
    VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", amtj.a(2131700520) + paramInt + "]", null);
    ShortVideoResourceManager.a(amtj.a(2131700536));
    bbqi.a(2, paramInt);
  }
  
  public void onAEProgressUpdate(AEResInfo paramAEResInfo, long paramLong1, long paramLong2)
  {
    if (paramAEResInfo == AEResInfo.AE_RES_BASE_PACKAGE)
    {
      int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
      this.jdField_b_of_type_Int = i;
      this.jdField_c_of_type_Int = ((this.jdField_a_of_type_Int + this.jdField_b_of_type_Int) / 2);
      a("doUserDownloadResource:");
      VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", "packageIdx=" + paramAEResInfo.index + ",totalLen=" + paramLong2 + ",curOffset=" + paramLong1 + ",localProgress=" + i, null);
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
        bmbx.d("CaptureQmcfSoDownloadFragment", "[onConfigResult]:serverError" + paramInt2);
        VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", amtj.a(2131700517) + paramInt2 + "]", null);
        ShortVideoResourceManager.a(amtj.a(2131700533) + "serverError" + paramInt2);
        bbqi.a(1, paramInt2);
        return;
      }
      ArrayList localArrayList = new ArrayList(1);
      paramInt1 = ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList);
      if (paramInt1 == 0)
      {
        bmbx.d("CaptureQmcfSoDownloadFragment", "[onConfigResult]:success");
        VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", amtj.a(2131700548), null);
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
        bmbx.d("CaptureQmcfSoDownloadFragment", amtj.a(2131689755));
        ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, this);
        return;
      }
      if (paramInt1 == -101)
      {
        ShortVideoResourceManager.SVConfigItem localSVConfigItem = new ShortVideoResourceManager.SVConfigItem();
        a(localSVConfigItem);
        localArrayList.add(localSVConfigItem);
        bmbx.d("CaptureQmcfSoDownloadFragment", amtj.a(2131689756));
        ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, this);
        return;
      }
      bmbx.d("CaptureQmcfSoDownloadFragment", "[onConfigResult]:errCode" + paramInt1);
      VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", amtj.a(2131700532) + paramInt1 + "]", null);
      ShortVideoResourceManager.a(amtj.a(2131700519) + "errorCode:" + paramInt1);
      bbqi.a(1, paramInt1);
      return;
    }
    bmbx.d("CaptureQmcfSoDownloadFragment", "[onConfigResult]result:" + paramInt1);
    VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", amtj.a(2131700546) + paramInt2 + "]", null);
    ShortVideoResourceManager.a(amtj.a(2131700538) + "result:" + paramInt1);
    bbqi.a(1, paramInt2);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(a(), paramViewGroup, false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView = ((CameraCaptureView)paramLayoutInflater.findViewById(2131364156));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setDarkModeEnable(false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setCameraPermissionListener(this);
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
      QQToast.a(VideoEnvironment.getContext(), amtj.a(2131700534), 1);
    }
    for (;;)
    {
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      label252:
      int i;
      if (a())
      {
        c();
        bool = VideoEnvironment.checkAVCodecLoadIsOK(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (AEResUtil.getAEResStatus(AEResInfo.AE_RES_BASE_PACKAGE) == 2) {
          break label334;
        }
        i = 1;
        label274:
        if ((bool) && (i != 0)) {
          break label384;
        }
        if (bool) {
          break label340;
        }
        bbqi.a(2);
        bmbx.d("CaptureQmcfSoDownloadFragment", "【START】startDownloadConfig");
        d();
      }
      for (;;)
      {
        if (i != 0) {
          break label362;
        }
        bmbx.d("CaptureQmcfSoDownloadFragment", "【START】startDownloadAEKitBase");
        e();
        break;
        this.jdField_d_of_type_Int = 101;
        break label252;
        label334:
        i = 0;
        break label274;
        label340:
        bmbx.d("CaptureQmcfSoDownloadFragment", "【START】AVcodec isReady");
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Int = 100;
      }
      label362:
      bmbx.d("CaptureQmcfSoDownloadFragment", "【START】isAEKitBaseDownloaded true");
      this.jdField_b_of_type_Boolean = true;
      this.jdField_b_of_type_Int = 100;
      continue;
      label384:
      bmbx.d("CaptureQmcfSoDownloadFragment", "【START】onSoDownloadCompleted()");
      VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", "checkAVCodecLoadIsOK loaded=true, activityId=" + this.jdField_a_of_type_JavaLangString, null);
      ThreadManager.getUIHandler().postDelayed(new CaptureQmcfSoDownloadFragment.1(this), 5L);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    bbtd.a().a(false, this);
    if (QLog.isDevelopLevel()) {
      QLog.d("CaptureQmcfSoDownloadFragment", 4, "in CaptureQmcfSoDownloadFragment onDestroy");
    }
    a();
  }
  
  public void onDownloadFinish(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1.startsWith("new_qq_android_native_short_video_"))
    {
      if (paramInt == 0) {
        break label135;
      }
      bmbx.d("CaptureQmcfSoDownloadFragment", "[onDownloadFinish] error result" + paramInt);
      VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", amtj.a(2131700552) + paramInt + "]", null);
      ShortVideoResourceManager.a(amtj.a(2131700529));
      bbqi.a(2, paramInt);
    }
    for (;;)
    {
      VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", "name=" + paramString1 + ",result=" + paramInt + ",filePath=" + paramString2, null);
      return;
      label135:
      bmbx.d("CaptureQmcfSoDownloadFragment", "[onDownloadFinish] success");
      this.jdField_a_of_type_Int = 100;
      this.jdField_a_of_type_Boolean = true;
      f();
    }
  }
  
  public void onNetWorkNone()
  {
    b(amtj.a(2131700530));
    VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", amtj.a(2131700518), null);
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
    if (Build.VERSION.SDK_INT >= 29) {
      zjv.a(getActivity().getWindow());
    }
  }
  
  public void onUpdateProgress(String paramString, long paramLong1, long paramLong2)
  {
    int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    if (paramString.startsWith("new_qq_android_native_short_video_")) {
      this.jdField_a_of_type_Int = i;
    }
    this.jdField_c_of_type_Int = ((this.jdField_a_of_type_Int + this.jdField_b_of_type_Int) / 2);
    a("doUserDownloadResource:");
    VideoEnvironment.LogDownLoad("CaptureQmcfSoDownloadFragment", "name=" + paramString + ",totalLen=" + paramLong2 + ",curOffset=" + paramLong1 + ",localProgress=" + i, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.fragment.CaptureQmcfSoDownloadFragment
 * JD-Core Version:    0.7.0.1
 */