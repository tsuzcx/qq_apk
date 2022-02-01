package com.tencent.mobileqq.filemanager.util;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

final class FileManagerUtil$10
  extends ClickableSpan
{
  FileManagerUtil$10(FileManagerUtil.TipsClickedInterface paramTipsClickedInterface) {}
  
  public void onClick(View paramView)
  {
    if (this.a != null) {
      this.a.onClick(paramView);
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-12541697);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileManagerUtil.10
 * JD-Core Version:    0.7.0.1
 */