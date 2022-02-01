package com.tencent.mobileqq.onlinestatus;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQCustomDialog;
import mqq.app.AppRuntime.Status;

class AccountPanel$2
  extends ClickableSpan
{
  AccountPanel$2(AccountPanel paramAccountPanel, AppRuntime.Status paramStatus, long paramLong) {}
  
  public void onClick(@NonNull View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("KEY_ONLINE_STATUS", this.jdField_a_of_type_MqqAppAppRuntime$Status);
    paramView.putExtra("KEY_ONLINE_EXT_STATUS", this.jdField_a_of_type_Long);
    PublicFragmentActivity.a(AccountPanel.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel), paramView, AccountOnlineStateActivity.class, 234);
    if ((AccountPanel.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel) != null) && (AccountPanel.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel).isShowing()))
    {
      AccountPanel.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel).dismiss();
      AccountPanel.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel, null);
    }
    ReportController.b(AccountPanel.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusAccountPanel), "dc00898", "", "", "0X8009DE2", "0X8009DE2", 0, 0, "", "", "", "");
  }
  
  public void updateDrawState(@NonNull TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.setColor(Color.parseColor("#40A0FF"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountPanel.2
 * JD-Core Version:    0.7.0.1
 */