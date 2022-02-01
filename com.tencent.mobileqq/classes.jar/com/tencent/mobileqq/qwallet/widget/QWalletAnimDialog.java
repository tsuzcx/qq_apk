package com.tencent.mobileqq.qwallet.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.widget.AnimationView;
import com.tencent.mobileqq.widget.AnimationView.AnimationInfo;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;

public class QWalletAnimDialog
  extends ReportDialog
{
  protected long a;
  protected Activity a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new QWalletAnimDialog.2(this);
  private AnimationView.AnimationInfo jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo;
  private AnimationView jdField_a_of_type_ComTencentMobileqqWidgetAnimationView;
  protected String a;
  protected boolean a;
  protected String b;
  protected String c;
  
  public QWalletAnimDialog(Activity paramActivity, int paramInt, AnimationView.AnimationInfo paramAnimationInfo, long paramLong)
  {
    super(paramActivity, paramInt);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo = paramAnimationInfo;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    a();
  }
  
  private void a()
  {
    super.requestWindowFeature(1);
    Object localObject = getWindow();
    setContentView(2131562065);
    ((Window)localObject).setLayout(-1, -1);
    ((Window)localObject).setBackgroundDrawable(new ColorDrawable(0));
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      ((Window)localObject).addFlags(67108864);
    }
    setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView = ((AnimationView)findViewById(2131364399));
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView.setAnimationFromInfo(this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView.setAnimationListener(new QWalletAnimDialog.1(this));
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("qwallet.facetoface");
    getContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
  }
  
  public void dismiss()
  {
    super.dismiss();
    getContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView.stop();
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView.setImageDrawable(null);
    AnimationView.AnimationInfo localAnimationInfo = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo;
    if (localAnimationInfo != null)
    {
      localAnimationInfo.destoryBitmaps();
      this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo = null;
    }
    this.jdField_a_of_type_AndroidAppActivity = null;
    VACDReportUtil.a(this.jdField_a_of_type_Long, null, "animDialogDismiss", null, 0, null);
  }
  
  public void show()
  {
    super.show();
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView.play();
    VACDReportUtil.a(this.jdField_a_of_type_Long, null, "animDialogShow", null, 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.widget.QWalletAnimDialog
 * JD-Core Version:    0.7.0.1
 */