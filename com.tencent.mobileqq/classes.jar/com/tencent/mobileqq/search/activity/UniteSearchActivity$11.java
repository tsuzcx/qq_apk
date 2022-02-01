package com.tencent.mobileqq.search.activity;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

class UniteSearchActivity$11
  extends ClickableSpan
{
  UniteSearchActivity$11(UniteSearchActivity paramUniteSearchActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a;
    paramView.openContextMenu(paramView.a);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.UniteSearchActivity.11
 * JD-Core Version:    0.7.0.1
 */