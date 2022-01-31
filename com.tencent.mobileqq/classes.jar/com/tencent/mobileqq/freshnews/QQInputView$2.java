package com.tencent.mobileqq.freshnews;

import alud;
import android.widget.ImageView;
import bhsj;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;

class QQInputView$2
  implements Runnable
{
  QQInputView$2(QQInputView paramQQInputView) {}
  
  public void run()
  {
    QQInputView.a(this.this$0).setVisibility(8);
    QQInputView.a(this.this$0).setImageResource(2130847428);
    if (AppSetting.c) {
      QQInputView.a(this.this$0).setContentDescription(alud.a(2131710788));
    }
    bhsj.a(QQInputView.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.freshnews.QQInputView.2
 * JD-Core Version:    0.7.0.1
 */