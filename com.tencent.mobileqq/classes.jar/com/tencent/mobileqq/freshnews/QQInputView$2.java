package com.tencent.mobileqq.freshnews;

import android.widget.ImageView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.util.InputMethodUtil;

class QQInputView$2
  implements Runnable
{
  QQInputView$2(QQInputView paramQQInputView) {}
  
  public void run()
  {
    QQInputView.d(this.this$0).setVisibility(8);
    QQInputView.e(this.this$0).setImageResource(2130849798);
    if (AppSetting.e) {
      QQInputView.e(this.this$0).setContentDescription(HardCodeUtil.a(2131908038));
    }
    InputMethodUtil.a(QQInputView.b(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.freshnews.QQInputView.2
 * JD-Core Version:    0.7.0.1
 */