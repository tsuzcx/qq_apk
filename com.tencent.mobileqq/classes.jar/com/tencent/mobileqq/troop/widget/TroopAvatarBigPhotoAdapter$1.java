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
    if ((paramURLDrawable != null) && (paramURLDrawable.getURL() != null)) {
      paramView = paramURLDrawable.getURL().toString();
    } else {
      paramView = "";
    }
    paramURLDrawable = new StringBuilder();
    paramURLDrawable.append("onLoadCancelled urlStr : ");
    paramURLDrawable.append(paramView);
    QLog.e("TroopAvatarBigPhotoAdapter", 1, paramURLDrawable.toString());
    ReportController.b(null, "dc00899", "BizTechReport", "", "Grp_avatar", "load_cancel", 0, 1, 0, paramView, "", "", "");
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    String str = "";
    if ((paramURLDrawable != null) && (paramURLDrawable.getURL() != null)) {
      paramView = paramURLDrawable.getURL().toString();
    } else {
      paramView = "";
    }
    if (paramThrowable == null) {
      paramURLDrawable = str;
    } else {
      paramURLDrawable = paramThrowable.getMessage();
    }
    paramThrowable = new StringBuilder();
    paramThrowable.append("onLoadFailed urlStr : ");
    paramThrowable.append(paramView);
    paramThrowable.append("; errorMsg : ");
    paramThrowable.append(paramURLDrawable);
    QLog.e("TroopAvatarBigPhotoAdapter", 1, paramThrowable.toString());
    ReportController.b(null, "dc00899", "BizTechReport", "", "Grp_avatar", "load_failed", 0, 1, 0, paramView, paramURLDrawable, "", "");
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    String str = "";
    if ((paramURLDrawable != null) && (paramURLDrawable.getURL() != null)) {
      paramView = paramURLDrawable.getURL().toString();
    } else {
      paramView = "";
    }
    if (paramInterruptedException == null) {
      paramURLDrawable = str;
    } else {
      paramURLDrawable = paramInterruptedException.getMessage();
    }
    paramInterruptedException = new StringBuilder();
    paramInterruptedException.append("onLoadInterrupted urlStr : ");
    paramInterruptedException.append(paramView);
    paramInterruptedException.append("; errorMsg : ");
    paramInterruptedException.append(paramURLDrawable);
    QLog.e("TroopAvatarBigPhotoAdapter", 1, paramInterruptedException.toString());
    ReportController.b(null, "dc00899", "BizTechReport", "", "Grp_avatar", "load_interrupt", 0, 1, 0, paramView, paramURLDrawable, "", "");
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
    if ((paramURLDrawable != null) && (paramURLDrawable.getURL() != null)) {
      paramView = paramURLDrawable.getURL().toString();
    } else {
      paramView = "";
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.a != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.a.get() != null)) {
      ((TextView)this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.a.get()).setVisibility(8);
    }
    paramURLDrawable = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter;
    paramURLDrawable.a = null;
    paramURLDrawable.c = false;
    ReportController.b(null, "dc00899", "BizTechReport", "", "Grp_avatar", "load_success", 0, 1, 0, paramView, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopAvatarBigPhotoAdapter.1
 * JD-Core Version:    0.7.0.1
 */