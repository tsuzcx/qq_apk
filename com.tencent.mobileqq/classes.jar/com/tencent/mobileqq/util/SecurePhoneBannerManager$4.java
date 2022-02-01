package com.tencent.mobileqq.util;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SecurePhoneBannerManager$4
  implements View.OnClickListener
{
  SecurePhoneBannerManager$4(SecurePhoneBannerManager paramSecurePhoneBannerManager, Context paramContext, QQAppInterface paramQQAppInterface, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    SecurePhoneBannerManager.a(this.d, this.a);
    SecurePhoneBannerManager.a(this.d, this.b, this.a, 2);
    SecurePhoneBannerManager.b(this.d, this.a, this.c);
    ReportController.b(this.b, "dc00898", "", "", "0X800B0C6", "0X800B0C6", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.SecurePhoneBannerManager.4
 * JD-Core Version:    0.7.0.1
 */