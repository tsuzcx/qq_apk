package com.tencent.richframework.text.rich;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.tencent.qphone.base.util.QLog;

class RFWTailExpandText$1
  extends ClickableSpan
{
  RFWTailExpandText$1(RFWTailExpandText paramRFWTailExpandText) {}
  
  @RequiresApi(api=16)
  public void onClick(@NonNull View paramView)
  {
    paramView = new StringBuilder();
    paramView.append("mIsOpen : ");
    paramView.append(RFWTailExpandText.a(this.a));
    QLog.d("QCircleTailExpandText", 1, paramView.toString());
    paramView = this.a;
    RFWTailExpandText.a(paramView, true ^ RFWTailExpandText.a(paramView));
  }
  
  public void updateDrawState(@NonNull TextPaint paramTextPaint)
  {
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.setFakeBoldText(RFWTailExpandText.b(this.a));
    paramTextPaint.clearShadowLayer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richframework.text.rich.RFWTailExpandText.1
 * JD-Core Version:    0.7.0.1
 */