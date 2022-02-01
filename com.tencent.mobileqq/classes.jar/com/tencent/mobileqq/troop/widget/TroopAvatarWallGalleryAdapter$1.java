package com.tencent.mobileqq.troop.widget;

import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.ImageProgressCircle;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

class TroopAvatarWallGalleryAdapter$1
  implements URLDrawableDownListener
{
  TroopAvatarWallGalleryAdapter$1(TroopAvatarWallGalleryAdapter paramTroopAvatarWallGalleryAdapter, ImageProgressCircle paramImageProgressCircle, URLImageView paramURLImageView) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopAvatarWallGalleryAdapter", 2, String.format("onLoadCancelled ", new Object[0]));
    }
    if ((paramURLDrawable != null) && (paramURLDrawable.getURL() != null)) {
      paramView = paramURLDrawable.getURL().toString();
    } else {
      paramView = "";
    }
    ReportController.b(null, "dc00899", "BizTechReport", "", "Grp_avatar", "load_cancel", 0, 1, 0, paramView, "", "", "");
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopAvatarWallGalleryAdapter", 2, String.format("onLoadFailed ", new Object[0]));
    }
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
    ReportController.b(null, "dc00899", "BizTechReport", "", "Grp_avatar", "load_interrupt", 0, 1, 0, paramView, paramURLDrawable, "", "");
  }
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopAvatarWallGalleryAdapter", 2, String.format("onLoadProgressed progress=%d", new Object[] { Integer.valueOf(paramInt) }));
    }
    if (this.a.getVisibility() != 0) {
      this.a.setVisibility(0);
    }
    this.a.setProgress(paramInt / 100);
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopAvatarWallGalleryAdapter", 2, String.format("onLoadSuccessed ", new Object[0]));
    }
    this.c.a(this.a);
    this.b.setImageDrawable(paramURLDrawable);
    if ((paramURLDrawable != null) && (paramURLDrawable.getURL() != null)) {
      paramView = paramURLDrawable.getURL().toString();
    } else {
      paramView = "";
    }
    ReportController.b(null, "dc00899", "BizTechReport", "", "Grp_avatar", "load_success", 0, 1, 0, paramView, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopAvatarWallGalleryAdapter.1
 * JD-Core Version:    0.7.0.1
 */