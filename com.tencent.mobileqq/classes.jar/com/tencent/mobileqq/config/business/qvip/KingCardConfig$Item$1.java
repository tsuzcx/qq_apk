package com.tencent.mobileqq.config.business.qvip;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QVipUtils;
import mqq.app.AppRuntime;

class KingCardConfig$Item$1
  extends ClickableSpan
{
  KingCardConfig$Item$1(KingCardConfig.Item paramItem, String paramString, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    QVipUtils.a(this.jdField_a_of_type_JavaLangString, BaseApplicationImpl.getApplication().getRuntime().getAccount(), (Activity)this.jdField_a_of_type_AndroidContentContext);
    ReportController.b(null, "dc00898", "", "", KingCardConfig.Item.a(this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQvipKingCardConfig$Item), KingCardConfig.Item.a(this.jdField_a_of_type_ComTencentMobileqqConfigBusinessQvipKingCardConfig$Item), 2, 0, "", "", "", "");
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(Color.parseColor("#4D94FF"));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qvip.KingCardConfig.Item.1
 * JD-Core Version:    0.7.0.1
 */