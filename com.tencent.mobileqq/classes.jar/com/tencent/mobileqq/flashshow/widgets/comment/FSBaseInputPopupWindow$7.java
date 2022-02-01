package com.tencent.mobileqq.flashshow.widgets.comment;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.StyleSpan;
import com.tencent.mobileqq.flashshow.utils.FSTransUtils;

class FSBaseInputPopupWindow$7
  extends StyleSpan
{
  FSBaseInputPopupWindow$7(FSBaseInputPopupWindow paramFSBaseInputPopupWindow, int paramInt)
  {
    super(paramInt);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(FSTransUtils.f().getResources().getColor(2131166099));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.comment.FSBaseInputPopupWindow.7
 * JD-Core Version:    0.7.0.1
 */