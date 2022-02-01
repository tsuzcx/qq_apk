package com.tencent.mobileqq.onlinestatus;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQCustomDialog;
import mqq.app.AppRuntime.Status;

class AccountPanel$1
  extends ClickableSpan
{
  AccountPanel$1(AccountPanel paramAccountPanel, AppRuntime.Status paramStatus, long paramLong) {}
  
  public void onClick(@NonNull View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("KEY_ONLINE_STATUS", this.a);
    paramView.putExtra("KEY_ONLINE_EXT_STATUS", this.b);
    QPublicFragmentActivity.startForResult(AccountPanel.a(this.c), paramView, AccountOnlineStateActivity.class, 234);
    if ((AccountPanel.b(this.c) != null) && (AccountPanel.b(this.c).isShowing()))
    {
      AccountPanel.b(this.c).dismiss();
      AccountPanel.a(this.c, null);
    }
    ReportController.b(AccountPanel.c(this.c), "dc00898", "", "", "0X8009DE2", "0X8009DE2", 0, 0, "", "", "", "");
  }
  
  public void updateDrawState(@NonNull TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.setColor(Color.parseColor("#40A0FF"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountPanel.1
 * JD-Core Version:    0.7.0.1
 */