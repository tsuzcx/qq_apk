package com.tencent.mobileqq.filemanager.util;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

final class QQFileManagerUtilImpl$3
  extends ClickableSpan
{
  QQFileManagerUtilImpl$3(QQFileManagerUtil.TipsClickedInterface paramTipsClickedInterface) {}
  
  public void onClick(View paramView)
  {
    QQFileManagerUtil.TipsClickedInterface localTipsClickedInterface = this.a;
    if (localTipsClickedInterface != null) {
      localTipsClickedInterface.onClick(paramView);
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-12541697);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl.3
 * JD-Core Version:    0.7.0.1
 */