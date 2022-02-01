package com.tencent.mobileqq.config.business.qvip;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.QVipUtils;
import mqq.app.AppRuntime;

class QVipTroopFileConfig$2
  extends ClickableSpan
{
  QVipTroopFileConfig$2(QVipTroopFileConfig paramQVipTroopFileConfig, String paramString) {}
  
  public void onClick(View paramView)
  {
    QVipUtils.a(QVipTroopFileConfig.a(this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQvipQVipTroopFileConfig), BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramView.getContext());
    QVipTroopFileConfig.a("0X800AE6D", this.jdField_a_of_type_JavaLangString, "");
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(Color.parseColor("#4D94FF"));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qvip.QVipTroopFileConfig.2
 * JD-Core Version:    0.7.0.1
 */