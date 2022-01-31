package com.tencent.mobileqq.freshnews;

import ajya;
import android.widget.ImageView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;

class QQInputView$3
  implements Runnable
{
  QQInputView$3(QQInputView paramQQInputView) {}
  
  public void run()
  {
    QQInputView.a(this.this$0).setVisibility(0);
    QQInputView.a(this.this$0).setImageResource(2130846989);
    if (AppSetting.d) {
      QQInputView.a(this.this$0).setContentDescription(ajya.a(2131710401));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.freshnews.QQInputView.3
 * JD-Core Version:    0.7.0.1
 */