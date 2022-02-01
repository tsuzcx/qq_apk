package com.tencent.mobileqq.vas.config.business.qvip;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasH5PayUtil;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class QVipTroopFileConfig$2
  extends ClickableSpan
{
  QVipTroopFileConfig$2(QVipTroopFileConfig paramQVipTroopFileConfig, String paramString) {}
  
  public void onClick(View paramView)
  {
    ((IVasH5PayUtil)QRoute.api(IVasH5PayUtil.class)).openH5Page(QVipTroopFileConfig.a(this.jdField_a_of_type_ComTencentMobileqqVasConfigBusinessQvipQVipTroopFileConfig), MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount(), paramView.getContext());
    QVipTroopFileConfig.a("0X800AE6D", this.jdField_a_of_type_JavaLangString, "");
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(Color.parseColor("#4D94FF"));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.QVipTroopFileConfig.2
 * JD-Core Version:    0.7.0.1
 */