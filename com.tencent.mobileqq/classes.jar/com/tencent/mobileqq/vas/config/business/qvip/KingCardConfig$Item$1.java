package com.tencent.mobileqq.vas.config.business.qvip;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.api.IVasH5PayUtil;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class KingCardConfig$Item$1
  extends ClickableSpan
{
  KingCardConfig$Item$1(KingCardConfig.Item paramItem, String paramString, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    ((IVasH5PayUtil)QRoute.api(IVasH5PayUtil.class)).openH5Page(this.a, MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount(), (Activity)this.b);
    ReportController.b(null, "dc00898", "", "", KingCardConfig.Item.a(this.c), KingCardConfig.Item.a(this.c), 2, 0, "", "", "", "");
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(Color.parseColor("#4D94FF"));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.KingCardConfig.Item.1
 * JD-Core Version:    0.7.0.1
 */