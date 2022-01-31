package dov.com.tencent.mobileqq.richmedia.capture.fragment;

import ajjy;
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
import auut;
import auuv;
import awek;
import awfg;
import awfi;
import awgh;
import awgj;
import awhj;
import awhk;
import awlw;
import babr;
import badq;
import bbmy;
import bhcs;
import bjec;
import bjef;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.richmedia.capture.activity.CaptureQmcfSoDownloadActivity;
import java.util.ArrayList;
import mqq.app.QQPermissionDenied;
import mqq.os.MqqHandler;
import wed;

public class CaptureQmcfSoDownloadFragment
  extends Fragment
  implements View.OnClickListener, auut, awfg, awfi, awgj, awhk
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
    boolean bool = badq.g(null);
    VideoEnvironment.a("CaptureQmcfSoDownloadFragment", "startDownloadConfig netUsable=" + bool, null);
    if (bool)
    {
      VideoEnvironment.a("CaptureQmcfSoDownloadFragment", ajjy.a(2131635586), null);
      ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      return;
    }
    b(ajjy.a(2131635598));
  }
  
  private void f()
  {
    boolean bool = badq.g(null);
    VideoEnvironment.a("CaptureQmcfSoDownloadFragment", "startDownloadConfig netUsable=" + bool, null);
    if (bool)
    {
      awgh.a().b(0, this);
      return;
    }
    bhcs.b("CaptureQmcfSoDownloadFragment", 1, "【END】startDownloadAEKitBase:" + ajjy.a(2131635579));
    b(ajjy.a(2131635579));
  }
  
  private void g()
  {
    if (a()) {
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_d_of_type_Int > 100) && (this.jdField_b_of_type_Boolean)) {
        c();
      }
    }
    while ((!this.jdField_a_of_type_Boolean) || (!this.jdField_b_of_type_Boolean)) {
      return;
    }
    c();
  }
  
  private void h()
  {
    if (a())
    {
      int i = (this.jdField_c_of_type_Int + this.jdField_d_of_type_Int) / 2;
      b(ajjy.a(2131635600) + i + "%");
      return;
    }
    b(ajjy.a(2131635609) + this.jdField_c_of_type_Int + "%");
  }
  
  public void I_()
  {
    b(ajjy.a(2131635588));
    VideoEnvironment.a("CaptureQmcfSoDownloadFragment", ajjy.a(2131635576), null);
    awek.a(3, -1500);
  }
  
  public void J_()
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
    return 2131495108;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    }
    awgh.a().a();
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
        VideoEnvironment.a("CaptureQmcfSoDownloadFragment", ajjy.a(2131635575) + paramInt2 + "]", null);
        ShortVideoResourceManager.a(ajjy.a(2131635591) + "serverError" + paramInt2);
        awek.a(1, paramInt2);
        return;
      }
      ArrayList localArrayList = new ArrayList(1);
      paramInt1 = ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList);
      if (paramInt1 == 0)
      {
        VideoEnvironment.a("CaptureQmcfSoDownloadFragment", ajjy.a(2131635606), null);
        ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, this);
        return;
      }
      VideoEnvironment.a("CaptureQmcfSoDownloadFragment", ajjy.a(2131635590) + paramInt1 + "]", null);
      ShortVideoResourceManager.a(ajjy.a(2131635577) + "errorCode:" + paramInt1);
      awek.a(1, paramInt1);
      return;
    }
    VideoEnvironment.a("CaptureQmcfSoDownloadFragment", ajjy.a(2131635604) + paramInt2 + "]", null);
    ShortVideoResourceManager.a(ajjy.a(2131635596) + "result:" + paramInt1);
    awek.a(1, paramInt2);
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
    VideoEnvironment.a("CaptureQmcfSoDownloadFragment", ajjy.a(2131635578) + paramInt2 + "]", null);
    ShortVideoResourceManager.a(ajjy.a(2131635594));
    awek.a(2, paramInt2);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1.startsWith("new_qq_android_native_short_video_"))
    {
      if (paramInt == 0) {
        break label109;
      }
      VideoEnvironment.a("CaptureQmcfSoDownloadFragment", ajjy.a(2131635610) + paramInt + "]", null);
      ShortVideoResourceManager.a(ajjy.a(2131635587));
      awek.a(2, paramInt);
    }
    for (;;)
    {
      VideoEnvironment.a("CaptureQmcfSoDownloadFragment", "name=" + paramString1 + ",result=" + paramInt + ",filePath=" + paramString2, null);
      return;
      label109:
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
        bjec localbjec = (bjec)getActivity();
        if (localbjec != null) {
          localbjec.a();
        }
      }
      return;
    }
    finally {}
  }
  
  public void d()
  {
    this.jdField_d_of_type_Int = 0;
    awhj.a().a(true, this);
    boolean bool = awhj.a().a();
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
      localObject = babr.a(new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO" });
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
        localObject = babr.a(new String[] { "android.permission.CAMERA" });
      } else {
        localObject = babr.a(new String[] { "android.permission.RECORD_AUDIO" });
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
    //   4: putfield 282	dov/com/tencent/mobileqq/richmedia/capture/fragment/CaptureQmcfSoDownloadFragment:jdField_d_of_type_Boolean	Z
    //   7: aload_0
    //   8: getfield 280	dov/com/tencent/mobileqq/richmedia/capture/fragment/CaptureQmcfSoDownloadFragment:e	Z
    //   11: ifeq +24 -> 35
    //   14: aload_0
    //   15: invokevirtual 176	dov/com/tencent/mobileqq/richmedia/capture/fragment/CaptureQmcfSoDownloadFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   18: checkcast 284	bjec
    //   21: astore_1
    //   22: aload_1
    //   23: ifnull +9 -> 32
    //   26: aload_1
    //   27: invokeinterface 285 1 0
    //   32: aload_0
    //   33: monitorexit
    //   34: return
    //   35: aload_0
    //   36: getfield 45	dov/com/tencent/mobileqq/richmedia/capture/fragment/CaptureQmcfSoDownloadFragment:jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView	Lcom/tencent/mobileqq/richmedia/capture/view/CameraCaptureView;
    //   39: iconst_1
    //   40: invokevirtual 331	com/tencent/mobileqq/richmedia/capture/view/CameraCaptureView:setCameraPermissionResult	(Z)V
    //   43: goto -11 -> 32
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	CaptureQmcfSoDownloadFragment
    //   21	6	1	localbjec	bjec
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
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView = ((CameraCaptureView)paramLayoutInflater.findViewById(2131298277));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setDarkModeEnable(false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setCameraPermissionListener(this);
    paramViewGroup = bjef.a().a(paramLayoutInflater.getContext());
    paramViewGroup.a(false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.d(false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setCaptureParam(paramViewGroup);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setSyncStopCamera(true);
    ((Button)paramLayoutInflater.findViewById(2131298297)).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress = ((CircleProgress)paramLayoutInflater.findViewById(2131299259));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setBgAndProgressColor(100, getResources().getColor(2131101537), 100, getResources().getColor(2131099760));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setStrokeWidth(6.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(0.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131300882));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getActivity().getAppInterface());
    boolean bool = VideoEnvironment.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_JavaLangString = getActivity().getIntent().getExtras().getString("ARG_ACTIVITY_ID");
    if (!bool)
    {
      bbmy.a(VideoEnvironment.a(), ajjy.a(2131635592), 1);
      return paramLayoutInflater;
    }
    int i;
    if (a())
    {
      d();
      bool = VideoEnvironment.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (awlw.a(BaseApplicationImpl.getContext()) == 2) {
        break label338;
      }
      i = 1;
      label277:
      if ((bool) && (i != 0)) {
        break label371;
      }
      if (bool) {
        break label344;
      }
      awek.a(2);
      e();
      bhcs.a("CaptureQmcfSoDownloadFragment", 1, "【START】startDownloadConfig");
    }
    for (;;)
    {
      if (i != 0) {
        break label358;
      }
      f();
      bhcs.a("CaptureQmcfSoDownloadFragment", 1, "【START】startDownloadAEKitBase");
      return paramLayoutInflater;
      this.jdField_d_of_type_Int = 101;
      break;
      label338:
      i = 0;
      break label277;
      label344:
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Int = 100;
    }
    label358:
    this.jdField_b_of_type_Boolean = true;
    this.jdField_b_of_type_Int = 100;
    return paramLayoutInflater;
    label371:
    VideoEnvironment.a("CaptureQmcfSoDownloadFragment", "checkAVCodecLoadIsOK loaded=true, activityId=" + this.jdField_a_of_type_JavaLangString, null);
    ThreadManager.getUIHandler().postDelayed(new CaptureQmcfSoDownloadFragment.1(this), 5L);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    awhj.a().a(false, this);
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
      wed.a(getActivity().getWindow());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.fragment.CaptureQmcfSoDownloadFragment
 * JD-Core Version:    0.7.0.1
 */