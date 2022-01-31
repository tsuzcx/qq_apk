package com.tencent.mobileqq.ocr;

import afor;
import afot;
import afou;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.CameraFocusView;
import com.tencent.biz.qqstory.takevideo.EditPicActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaInfoScannerListener;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.richmedia.capture.gesture.CameraFocusGesture;
import com.tencent.mobileqq.richmedia.capture.gesture.CameraZoomGesture;
import com.tencent.mobileqq.richmedia.capture.gesture.GLGestureProxy;
import com.tencent.mobileqq.richmedia.capture.util.CameraHelper;
import com.tencent.mobileqq.richmedia.capture.util.SVParamManager;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.CaptureListener;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.CaptureParam;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.PhotoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

@TargetApi(11)
public class SearchQuestionCameraFragment
  extends PublicBaseFragment
  implements Handler.Callback, View.OnClickListener, View.OnTouchListener, MediaScanner.OnMediaInfoScannerListener, CameraCaptureView.CaptureListener
{
  private int jdField_a_of_type_Int = -1;
  public long a;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(this);
  public TextView a;
  public CameraFocusView a;
  public CameraFocusGesture a;
  public CameraZoomGesture a;
  public CameraCaptureView.VideoCaptureResult a;
  public CameraCaptureView a;
  public CircleProgress a;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  public String a;
  
  public SearchQuestionCameraFragment()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  private void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SearchQuestionFragment", 2, "showWaitingDialog, dlgType=" + paramInt + ",currWaitingDlgType=" + this.jdField_a_of_type_Int);
    }
    if ((getActivity() == null) || (getActivity().isFinishing()) || ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SearchQuestionFragment", 2, "showWaitingDialog, activity is finishing or dlg showing");
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getActivity(), getResources().getDimensionPixelSize(2131558448));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setOnDismissListener(new afou(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(false);
    if (paramInt == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(true);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 10000L);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView = ((CameraCaptureView)paramView.findViewById(2131366903));
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setCaptureParam(a());
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setDarkModeEnable(false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setOnTouchListener(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setCaptureListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress = ((CircleProgress)paramView.findViewById(2131370767));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setBgAndProgressColor(100, getResources().getColor(2131492968), 100, getResources().getColor(2131493307));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setStrokeWidth(4.5F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView = ((CameraFocusView)paramView.findViewById(2131366904));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363969));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    ((TextView)paramView.findViewById(2131362857)).setShadowLayer(AIOUtils.a(4.5F, getResources()), 0.0F, 0.0F, 872415232);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraZoomGesture = new CameraZoomGesture(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraFocusGesture = new CameraFocusGesture(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView);
    GLGestureProxy.a().a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraZoomGesture);
    GLGestureProxy.a().a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureCameraFocusGesture);
  }
  
  private void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SearchQuestionFragment", 2, "dismissWaittingDialog, dlgType=" + paramInt + ",currWaitingDlgType=" + this.jdField_a_of_type_Int);
    }
    if ((getActivity() != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) && (!getActivity().isFinishing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  private void b(String paramString)
  {
    if (getActivity() == null) {
      return;
    }
    paramString = EditPicActivity.a(getActivity(), paramString, false, false, false, true, false, 2, 99, 9);
    paramString.setFlags(0);
    paramString.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", this.jdField_a_of_type_JavaLangString);
    paramString.putExtra("babyq_ability", 2L);
    paramString.putExtra("sub_business_id", 105);
    startActivity(paramString);
    getActivity().finish();
  }
  
  @TargetApi(12)
  private void g()
  {
    this.jdField_a_of_type_JavaLangString = getArguments().getString("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME");
  }
  
  private void h()
  {
    if (getActivity() == null) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClassName(getActivity().getPackageName(), this.jdField_a_of_type_JavaLangString);
    localIntent.addFlags(603979776);
    startActivity(localIntent);
    getActivity().finish();
  }
  
  public void L_()
  {
    if ((this.jdField_a_of_type_Long != -1L) && (QLog.isColorLevel())) {
      QLog.d("SearchQuestionFragment", 2, "(NEW)LaunchActivity to FirstFrameShown cost : " + (System.currentTimeMillis() - this.jdField_a_of_type_Long) + "ms");
    }
  }
  
  protected int a()
  {
    return 2130970463;
  }
  
  protected CameraCaptureView.CaptureParam a()
  {
    int i = CameraHelper.a();
    Size localSize = SVParamManager.a().a(i);
    CameraCaptureView.CaptureParam localCaptureParam = new CameraCaptureView.CaptureParam();
    localCaptureParam.a(localSize.a());
    localCaptureParam.b(localSize.b());
    localCaptureParam.a(SVParamManager.a().a(i));
    i = SVParamManager.a().a(i) * 1000;
    localCaptureParam.d(i);
    com.tencent.mobileqq.shortvideo.mediadevice.CodecParam.r = i;
    localCaptureParam.e(1);
    localCaptureParam.c(2);
    return localCaptureParam;
  }
  
  public void a(int paramInt)
  {
    QLog.e("SearchQuestionFragment", 2, "onCaptureError. errorCode = " + paramInt);
    ThreadManager.getUIHandler().post(new afot(this, paramInt));
  }
  
  public void a(Activity paramActivity)
  {
    paramActivity.requestWindowFeature(1);
  }
  
  public void a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      a(101);
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult, paramLocalMediaInfo);
  }
  
  public void a(CameraCaptureView.PhotoCaptureResult paramPhotoCaptureResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SearchQuestionFragment", 2, "onPhotoCaptured, filePath=" + paramPhotoCaptureResult.jdField_a_of_type_JavaLangString);
    }
    a(paramPhotoCaptureResult.jdField_a_of_type_JavaLangString);
    ReportController.b(null, "dc00898", "", "", "0X80085D4", "0X80085D4", 0, 0, "", "", "", "");
  }
  
  public void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult) {}
  
  protected void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo) {}
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SearchQuestionFragment", 2, "launchPeak, path=" + paramString);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    if ((TextUtils.isEmpty(paramString)) || (!FileUtils.a(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SearchQuestionFragment", 2, "launchPeak, file is not exist");
      }
      QQToast.a(BaseApplicationImpl.getContext(), 1, 2131439020, 0).a();
      return;
    }
    b(paramString);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 1000L);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean) {
      ThreadManager.getUIHandler().post(new afor(this, paramString));
    }
    com.tencent.mobileqq.richmedia.capture.util.ReportUtil.b = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a();
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void ag_() {}
  
  public void ah_() {}
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return false;
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(0);
  }
  
  public boolean d()
  {
    h();
    return true;
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SearchQuestionFragment", 2, "capturePhoto!");
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.i();
  }
  
  public void f() {}
  
  public void g_(boolean paramBoolean) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 0: 
      a(1, "正在加载...");
      return true;
    }
    b(1);
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      e();
      return;
    } while (getActivity() == null);
    getActivity().doOnBackPressed();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Long = getArguments().getLong("ACTIVITY_START_TIME", -1L);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(a(), paramViewGroup, false);
    a(paramLayoutInflater);
    g();
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
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
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.onResume();
    d();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    GLGestureProxy.a().a(paramMotionEvent, false, null, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.SearchQuestionCameraFragment
 * JD-Core Version:    0.7.0.1
 */