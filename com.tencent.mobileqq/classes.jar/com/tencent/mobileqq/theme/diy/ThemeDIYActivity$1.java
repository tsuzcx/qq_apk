package com.tencent.mobileqq.theme.diy;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;

class ThemeDIYActivity$1
  implements Runnable
{
  ThemeDIYActivity$1(ThemeDIYActivity paramThemeDIYActivity, String paramString, ThemeBackground paramThemeBackground, int paramInt) {}
  
  public void run()
  {
    ThemeBackground.getThemeBackground(this.this$0.mContext, this.val$bgTpye, this.this$0.app.getCurrentAccountUin(), this.val$fThemeBackground);
    this.this$0.mHandler.sendMessage(Message.obtain(this.this$0.mHandler, 29, this.val$fIndex, 0, this.val$fThemeBackground));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeDIYActivity.1
 * JD-Core Version:    0.7.0.1
 */