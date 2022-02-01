package com.tencent.mobileqq.troop.utils;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.webkit.URLUtil;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mtt.MttBrowerWrapper;

final class TroopRobotManager$3
  extends ClickableSpan
{
  TroopRobotManager$3(String paramString, MessageRecord paramMessageRecord) {}
  
  public void onClick(View paramView)
  {
    String str = URLUtil.guessUrl(this.a);
    MttBrowerWrapper.a(paramView.getContext(), str, true, true, true, false, this.b);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(paramTextPaint.linkColor);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopRobotManager.3
 * JD-Core Version:    0.7.0.1
 */