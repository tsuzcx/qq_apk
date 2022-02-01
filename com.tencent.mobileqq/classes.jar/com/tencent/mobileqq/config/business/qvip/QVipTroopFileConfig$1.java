package com.tencent.mobileqq.config.business.qvip;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.QVipUtils;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import mqq.app.AppRuntime;

class QVipTroopFileConfig$1
  extends ClickableSpan
{
  QVipTroopFileConfig$1(QVipTroopFileConfig paramQVipTroopFileConfig, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQvipQVipTroopFileConfig.d.c)) {
      QVipUtils.a(this.jdField_a_of_type_JavaLangString, BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramView.getContext());
    }
    for (;;)
    {
      QVipTroopFileConfig.a("0X800AE67", this.b, "");
      return;
      VasH5PayUtil.a(paramView.getContext(), this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(Color.parseColor("#4D94FF"));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qvip.QVipTroopFileConfig.1
 * JD-Core Version:    0.7.0.1
 */