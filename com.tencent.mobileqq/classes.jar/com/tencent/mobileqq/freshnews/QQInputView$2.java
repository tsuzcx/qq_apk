package com.tencent.mobileqq.freshnews;

import alpo;
import android.widget.ImageView;
import bhoc;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;

class QQInputView$2
  implements Runnable
{
  QQInputView$2(QQInputView paramQQInputView) {}
  
  public void run()
  {
    QQInputView.a(this.this$0).setVisibility(8);
    QQInputView.a(this.this$0).setImageResource(2130847355);
    if (AppSetting.c) {
      QQInputView.a(this.this$0).setContentDescription(alpo.a(2131710776));
    }
    bhoc.a(QQInputView.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.freshnews.QQInputView.2
 * JD-Core Version:    0.7.0.1
 */