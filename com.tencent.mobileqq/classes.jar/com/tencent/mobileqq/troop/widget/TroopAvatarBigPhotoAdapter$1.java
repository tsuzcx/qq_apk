package com.tencent.mobileqq.troop.widget;

import android.view.View;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.ImageProgressCircle;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.net.URL;

class TroopAvatarBigPhotoAdapter$1
  implements URLDrawableDownListener
{
  TroopAvatarBigPhotoAdapter$1(TroopAvatarBigPhotoAdapter paramTroopAvatarBigPhotoAdapter, ImageProgressCircle paramImageProgressCircle, URLImageView paramURLImageView) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    String str = "";
    paramView = str;
    if (paramURLDrawable != null)
    {
      paramView = str;
      if (paramURLDrawable.getURL() != null) {
        paramView = paramURLDrawable.getURL().toString();
      }
    }
    QLog.e("TroopAvatarBigPhotoAdapter", 1, "onLoadCancelled urlStr : " + paramView);
    ReportController.b(null, "dc00899", "BizTechReport", "", "Grp_avatar", "load_cancel", 0, 1, 0, paramView, "", "", "");
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    String str = "";
    paramView = str;
    if (paramURLDrawable != null)
    {
      paramView = str;
      if (paramURLDrawable.getURL() != null) {
        paramView = paramURLDrawable.getURL().toString();
      }
    }
    if (paramThrowable == null) {}
    for (paramURLDrawable = "";; paramURLDrawable = paramThrowable.getMessage())
    {
      QLog.e("TroopAvatarBigPhotoAdapter", 1, "onLoadFailed urlStr : " + paramView + "; errorMsg : " + paramURLDrawable);
      ReportController.b(null, "dc00899", "BizTechReport", "", "Grp_avatar", "load_failed", 0, 1, 0, paramView, paramURLDrawable, "", "");
      return;
    }
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    String str = "";
    paramView = str;
    if (paramURLDrawable != null)
    {
      paramView = str;
      if (paramURLDrawable.getURL() != null) {
        paramView = paramURLDrawable.getURL().toString();
      }
    }
    if (paramInterruptedException == null) {}
    for (paramURLDrawable = "";; paramURLDrawable = paramInterruptedException.getMessage())
    {
      QLog.e("TroopAvatarBigPhotoAdapter", 1, "onLoadInterrupted urlStr : " + paramView + "; errorMsg : " + paramURLDrawable);
      ReportController.b(null, "dc00899", "BizTechReport", "", "Grp_avatar", "load_interrupt", 0, 1, 0, paramView, paramURLDrawable, "", "");
      return;
    }
  }
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle.getVisibility() != 0) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle.setProgress(paramInt / 100);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.a != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.a.get() != null)) {
      ((TextView)this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.a.get()).setText(this.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle.a());
    }
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.a(this.jdField_a_of_type_ComTencentMobileqqWidgetImageProgressCircle);
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramURLDrawable);
    String str = "";
    paramView = str;
    if (paramURLDrawable != null)
    {
      paramView = str;
      if (paramURLDrawable.getURL() != null) {
        paramView = paramURLDrawable.getURL().toString();
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.a != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.a.get() != null)) {
      ((TextView)this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.a.get()).setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.a = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.c = false;
    ReportController.b(null, "dc00899", "BizTechReport", "", "Grp_avatar", "load_success", 0, 1, 0, paramView, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopAvatarBigPhotoAdapter.1
 * JD-Core Version:    0.7.0.1
 */