package com.tencent.mobileqq.freshnews;

import alud;
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
    QQInputView.a(this.this$0).setImageResource(2130847429);
    if (AppSetting.c) {
      QQInputView.a(this.this$0).setContentDescription(alud.a(2131710789));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.freshnews.QQInputView.4
 * JD-Core Version:    0.7.0.1
 */