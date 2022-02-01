package com.tencent.mobileqq.pushdialog;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.DisplayUtil;

class AIOPushDialogHelper$2
  extends ClickableSpan
{
  AIOPushDialogHelper$2(AIOPushDialogHelper paramAIOPushDialogHelper, String paramString1, String paramString2, String paramString3) {}
  
  public void onClick(View paramView)
  {
    new HttpMqqJumper(AIOPushDialogHelper.a(this.d).e).a(this.a).a();
    AIOPushDialogHelper.b(this.d);
    ReportController.b(AIOPushDialogHelper.a(this.d).i(), "dc00898", "", "", "0X800A4BB", "0X800A4BB", 0, 0, "", "", "", "");
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.setTextSize(DisplayUtil.a(AIOPushDialogHelper.a(this.d).e, 14.0F));
    paramTextPaint.setColor(Color.parseColor("#4D94FF"));
    if (!TextUtils.isEmpty(this.b)) {
      paramTextPaint.setColor(Color.parseColor(this.b));
    }
    if (!TextUtils.isEmpty(this.c)) {
      paramTextPaint.setTextSize(Float.valueOf(this.c).floatValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.pushdialog.AIOPushDialogHelper.2
 * JD-Core Version:    0.7.0.1
 */