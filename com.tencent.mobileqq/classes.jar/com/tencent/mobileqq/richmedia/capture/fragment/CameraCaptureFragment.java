package com.tencent.mobileqq.richmedia.capture.fragment;

import agtx;
import agty;
import agua;
import agub;
import aguc;
import agud;
import ague;
import aguf;
import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.biz.qqstory.takevideo.CameraFocusView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaInfoScannerListener;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.activity.richmedia.view.GLVideoClipUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.gesture.CameraFocusGesture;
import com.tencent.mobileqq.richmedia.capture.gesture.CameraSwitchGesture;
import com.tencent.mobileqq.richmedia.capture.gesture.CameraZoomGesture;
import com.tencent.mobileqq.richmedia.capture.gesture.GLGestureProxy;
import com.tencent.mobileqq.richmedia.capture.util.CameraHelper;
import com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil;
import com.tencent.mobileqq.richmedia.capture.util.DarkModeChecker.DarkModeListener;
import com.tencent.mobileqq.richmedia.capture.util.ReportUtil;
import com.tencent.mobileqq.richmedia.capture.util.SVParamManager;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureButtonLayout;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureButtonLayout.CaptureButtonListener;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.CaptureListener;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.CaptureParam;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.PhotoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraAbility;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

@TargetApi(11)
public class CameraCaptureFragment
  extends Fragment
  implements View.OnClickListener, View.OnTouchListener, MediaScanner.OnMediaInfoScannerListener, DarkModeChecker.DarkModeListener, CameraCaptureButtonLayout.CaptureButtonListener, CameraCaptureView.CaptureListener
{
  protected long a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new agtx(this);
  protected Button a;
  protected CameraFocusView a;
  private LocalMediaInfo jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
  private CameraFocusGesture jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraFocusGesture;
  private CameraSwitchGesture jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraSwitchGesture;
  private CameraZoomGesture jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraZoomGesture;
  public CameraCaptureButtonLayout a;
  public CameraCaptureView a;
  public boolean a;
  public long b;
  protected Button b;
  protected CameraCaptureView.VideoCaptureResult b;
  private boolean b;
  public Button c;
  private boolean c;
  public Button d;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  
  public CameraCaptureFragment()
  {
    this.jdField_b_of_type_Long = 3L;
  }
  
  public void K_()
  {
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    if (CameraAbility.c())
    {
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
      if (!GLVideoClipUtil.b()) {
        break label71;
      }
      this.jdField_d_of_type_AndroidWidgetButton.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout.b();
      return;
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(4);
      break;
      label71:
      if ((this.jdField_d_of_type_AndroidWidgetButton != null) && (this.jdField_c_of_type_Boolean))
      {
        this.jdField_d_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetButton.setSelected(false);
      }
    }
  }
  
  public void L_()
  {
    if (this.jdField_a_of_type_Long != -1L) {
      QLog.d("CameraCaptureFragment", 1, "(NEW)LaunchActivity to FirstFrameShown cost : " + (System.currentTimeMillis() - this.jdField_a_of_type_Long) + "ms");
    }
  }
  
  public int a()
  {
    return 2130970252;
  }
  
  public CameraCaptureView.CaptureParam a()
  {
    int i = CameraHelper.a();
    Size localSize = SVParamManager.a().a(i);
    CameraCaptureView.CaptureParam localCaptureParam = new CameraCaptureView.CaptureParam();
    localCaptureParam.a(localSize.a());
    localCaptureParam.b(localSize.b());
    localCaptureParam.a(SVParamManager.a().a(i));
    int j = SVParamManager.a().a(i) * 1000;
    localCaptureParam.d(j);
    com.tencent.mobileqq.shortvideo.mediadevice.CodecParam.r = j;
    localCaptureParam.e(1);
    localCaptureParam.c(i);
    return localCaptureParam;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView != null) {
      return this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a();
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Boolean = false;
    QLog.e("CameraCaptureFragment", 2, "onCaptureError. errorCode = " + paramInt);
    ThreadManager.getUIHandler().post(new ague(this, paramInt));
  }
  
  public void a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = false;
    if (!paramBoolean) {
      a(101);
    }
    while (this.e) {
      return;
    }
    a(this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult, paramLocalMediaInfo);
    this.jdField_d_of_type_Boolean = true;
  }
  
  public void a(CameraCaptureView.PhotoCaptureResult paramPhotoCaptureResult)
  {
    ThreadManager.getUIHandler().post(new agua(this, paramPhotoCaptureResult));
  }
  
  public void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult)
  {
    this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult = paramVideoCaptureResult;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = false;
      ThreadManager.getUIHandler().post(new agub(this));
      return;
    }
    if (paramVideoCaptureResult.videoFrameCount < this.jdField_b_of_type_Long)
    {
      this.jdField_b_of_type_Boolean = false;
      ThreadManager.getUIHandler().post(new aguc(this, paramVideoCaptureResult));
      return;
    }
    ThreadManager.getUIHandler().post(new agud(this));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.g();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = new LocalMediaInfo();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path = paramVideoCaptureResult.videoMp4FilePath;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mMimeType = "video";
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureFragment", 2, "onVideoCaptured. result = " + paramVideoCaptureResult.toString());
    }
    MediaScanner.a(BaseApplicationImpl.getContext()).a(this, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
  }
  
  public void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean) {
      ThreadManager.getUIHandler().post(new agty(this, paramString));
    }
    ReportUtil.b = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a();
  }
  
  public void ag_() {}
  
  public void ah_() {}
  
  public void b(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_d_of_type_AndroidWidgetButton == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new aguf(this, paramBoolean));
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureFragment", 2, "onCaptureButtonVideoStop!");
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.k();
  }
  
  protected void e()
  {
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetButton.setVisibility(8);
  }
  
  public void f() {}
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureFragment", 2, "onCaptureButtonPhoto!");
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.i();
  }
  
  public void g_(boolean paramBoolean) {}
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraCaptureFragment", 2, "onCaptureButtonVideoStart!");
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.j();
    e();
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    int j = 1;
    int i = 1;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131366913: 
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.h();
      if (this.jdField_b_of_type_AndroidWidgetButton != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a() != 1) {
          break label93;
        }
        getResources().getString(2131438142);
      }
      for (;;)
      {
        ReportUtil.f();
        return;
        getResources().getString(2131438141);
      }
    case 2131368945: 
      if (!this.jdField_c_of_type_AndroidWidgetButton.isSelected()) {
        bool = true;
      }
      this.jdField_c_of_type_AndroidWidgetButton.setSelected(bool);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.b(bool);
      ReportUtil.d();
      if (bool) {}
      for (;;)
      {
        CaptureReportUtil.d(i);
        return;
        i = 2;
      }
    case 2131368947: 
      label93:
      if (!this.jdField_d_of_type_AndroidWidgetButton.isSelected())
      {
        bool = true;
        this.jdField_d_of_type_AndroidWidgetButton.setSelected(bool);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.c(bool);
        if (bool) {
          break label220;
        }
        this.jdField_c_of_type_Boolean = true;
        ReportUtil.a(bool);
        if (!bool) {
          break label228;
        }
      }
      label197:
      label220:
      label228:
      for (i = j;; i = 2)
      {
        CaptureReportUtil.c(i);
        return;
        bool = false;
        break;
        this.jdField_c_of_type_Boolean = false;
        break label197;
      }
    }
    getActivity().doOnBackPressed();
    ReportUtil.e();
    CaptureReportUtil.f();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Long = getArguments().getLong("ACTIVITY_START_TIME", -1L);
    ReportUtil.a();
    paramBundle = new IntentFilter();
    paramBundle.addAction("tencent.av.v2q.StartVideoChat");
    getActivity().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    this.f = true;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(a(), paramViewGroup, false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView = ((CameraCaptureView)paramLayoutInflater.findViewById(2131366903));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setCaptureParam(a());
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setDarkModeEnable(true);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setCaptureListener(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setDarkModeListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)paramLayoutInflater.findViewById(2131366913));
    this.jdField_b_of_type_AndroidWidgetButton.setContentDescription(getResources().getString(2131438141));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    if (!CameraAbility.c())
    {
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
    }
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)paramLayoutInflater.findViewById(2131368945));
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetButton.setSelected(false);
    this.jdField_d_of_type_AndroidWidgetButton = ((Button)paramLayoutInflater.findViewById(2131368947));
    this.jdField_d_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetButton.setSelected(false);
    this.jdField_d_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout = ((CameraCaptureButtonLayout)paramLayoutInflater.findViewById(2131368888));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout.a(this, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView = ((CameraFocusView)paramLayoutInflater.findViewById(2131366904));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramLayoutInflater.findViewById(2131363969));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraZoomGesture = new CameraZoomGesture(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraFocusGesture = new CameraFocusGesture(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraSwitchGesture = new CameraSwitchGesture(getActivity());
    GLGestureProxy.a().a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraZoomGesture);
    GLGestureProxy.a().a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraFocusGesture);
    GLGestureProxy.a().a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraSwitchGesture);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.f)
    {
      getActivity().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.f = false;
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    GLGestureProxy.a().a();
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.onPause();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout.d();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.onResume();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout.c();
    K_();
    this.jdField_d_of_type_Boolean = false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    GLGestureProxy.a().a(paramMotionEvent, false, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout.a, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.fragment.CameraCaptureFragment
 * JD-Core Version:    0.7.0.1
 */