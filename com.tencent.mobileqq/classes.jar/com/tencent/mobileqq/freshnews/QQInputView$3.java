package com.tencent.mobileqq.freshnews;

import android.widget.ImageView;
import anni;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;

class QQInputView$3
  implements Runnable
{
  QQInputView$3(QQInputView paramQQInputView) {}
  
  public void run()
  {
    QQInputView.a(this.this$0).setVisibility(0);
    QQInputView.a(this.this$0).setImageResource(2130847888);
    if (AppSetting.c) {
      QQInputView.a(this.this$0).setContentDescription(anni.a(2131709161));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.freshnews.QQInputView.3
 * JD-Core Version:    0.7.0.1
 */