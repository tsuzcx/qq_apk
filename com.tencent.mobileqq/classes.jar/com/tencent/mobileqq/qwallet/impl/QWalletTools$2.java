package com.tencent.mobileqq.qwallet.impl;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

final class QWalletTools$2
  extends ClickableSpan
{
  QWalletTools$2(QWalletTools.TextUrlClickListener paramTextUrlClickListener, String paramString) {}
  
  public void onClick(View paramView)
  {
    this.a.a(this.b);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.impl.QWalletTools.2
 * JD-Core Version:    0.7.0.1
 */