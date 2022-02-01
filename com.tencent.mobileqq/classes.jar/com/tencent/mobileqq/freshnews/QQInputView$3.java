package com.tencent.mobileqq.freshnews;

import android.widget.ImageView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;

class QQInputView$3
  implements Runnable
{
  QQInputView$3(QQInputView paramQQInputView) {}
  
  public void run()
  {
    QQInputView.d(this.this$0).setVisibility(0);
    QQInputView.e(this.this$0).setImageResource(2130849799);
    if (AppSetting.e) {
      QQInputView.e(this.this$0).setContentDescription(HardCodeUtil.a(2131908035));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.freshnews.QQInputView.3
 * JD-Core Version:    0.7.0.1
 */