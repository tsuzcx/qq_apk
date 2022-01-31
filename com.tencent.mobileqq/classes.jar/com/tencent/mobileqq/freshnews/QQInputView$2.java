package com.tencent.mobileqq.freshnews;

import ajjy;
import android.widget.ImageView;
import beex;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;

class QQInputView$2
  implements Runnable
{
  QQInputView$2(QQInputView paramQQInputView) {}
  
  public void run()
  {
    QQInputView.a(this.this$0).setVisibility(8);
    QQInputView.a(this.this$0).setImageResource(2130846792);
    if (AppSetting.c) {
      QQInputView.a(this.this$0).setContentDescription(ajjy.a(2131644608));
    }
    beex.a(QQInputView.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.freshnews.QQInputView.2
 * JD-Core Version:    0.7.0.1
 */