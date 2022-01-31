package com.tencent.mobileqq.freshnews;

import ajjy;
import android.widget.ImageView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;

class QQInputView$4
  implements Runnable
{
  QQInputView$4(QQInputView paramQQInputView) {}
  
  public void run()
  {
    QQInputView.a(this.this$0).setVisibility(0);
    QQInputView.a(this.this$0).setImageResource(2130846793);
    if (AppSetting.c) {
      QQInputView.a(this.this$0).setContentDescription(ajjy.a(2131644609));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.freshnews.QQInputView.4
 * JD-Core Version:    0.7.0.1
 */