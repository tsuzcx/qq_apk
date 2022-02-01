package com.tencent.mobileqq.vas.config.business.qvip;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasH5PayUtil;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class QVipTroopFileConfig$1
  extends ClickableSpan
{
  QVipTroopFileConfig$1(QVipTroopFileConfig paramQVipTroopFileConfig, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    if (this.a.equals(this.c.d.c)) {
      ((IVasH5PayUtil)QRoute.api(IVasH5PayUtil.class)).openH5Page(this.a, MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount(), paramView.getContext());
    } else {
      ((IVasH5PayUtil)QRoute.api(IVasH5PayUtil.class)).openH5PayByURL(paramView.getContext(), this.a);
    }
    QVipTroopFileConfig.a("0X800AE67", this.b, "");
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(Color.parseColor("#4D94FF"));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.QVipTroopFileConfig.1
 * JD-Core Version:    0.7.0.1
 */