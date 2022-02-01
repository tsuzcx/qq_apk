package com.tencent.mobileqq.qwallet.hb;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.widget.AnimationView;
import com.tencent.mobileqq.widget.AnimationView.AnimationInfo;
import com.tencent.mobileqq.widget.AnimationView.MyAnimationListener;
import com.tencent.qphone.base.util.QLog;

public class FrameAnimHelper
{
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private AnimationView.AnimationInfo jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo;
  private AnimationView jdField_a_of_type_ComTencentMobileqqWidgetAnimationView;
  
  public FrameAnimHelper(Context paramContext, LinearLayout paramLinearLayout, int paramInt, boolean paramBoolean, AnimationView.MyAnimationListener paramMyAnimationListener)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = paramLinearLayout;
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView = new AnimationView(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView.setmRadius(paramInt, paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView.setAnimationListener(paramMyAnimationListener);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView, new LinearLayout.LayoutParams(-1, -1));
  }
  
  public FrameAnimHelper(AnimationView paramAnimationView, int paramInt, boolean paramBoolean, AnimationView.MyAnimationListener paramMyAnimationListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView = paramAnimationView;
    paramAnimationView.setmRadius(paramInt, paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView.setAnimationListener(paramMyAnimationListener);
  }
  
  public static void a(AnimationView paramAnimationView, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FrameAnimHelper", 2, "anim stoped...");
    }
    if (paramAnimationView == null) {
      return;
    }
    paramAnimationView.stop();
    paramAnimationView.setImageDrawable(null);
    paramAnimationView = paramAnimationView.getAnimationFromInfo();
    if ((paramBoolean) && (paramAnimationView != null)) {
      paramAnimationView.destoryBitmaps();
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FrameAnimHelper", 2, "anim stoped...");
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView.stop();
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView.setImageDrawable(null);
    AnimationView.AnimationInfo localAnimationInfo = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo;
    if (localAnimationInfo != null)
    {
      localAnimationInfo.destoryBitmaps();
      this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo = null;
    }
  }
  
  public void a(AnimationView.AnimationInfo paramAnimationInfo)
  {
    AnimationView localAnimationView = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView;
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo = paramAnimationInfo;
    localAnimationView.setAnimationFromInfo(paramAnimationInfo);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView.play();
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("task in thread runs isFolder = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.i("FrameAnimHelper", 2, ((StringBuilder)localObject).toString());
    }
    FrameAnimHelper.ZipLoadingTask localZipLoadingTask = new FrameAnimHelper.ZipLoadingTask(this, null);
    if (paramBoolean) {
      localObject = "0";
    } else {
      localObject = "1";
    }
    localZipLoadingTask.execute(new String[] { paramString, localObject });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.FrameAnimHelper
 * JD-Core Version:    0.7.0.1
 */