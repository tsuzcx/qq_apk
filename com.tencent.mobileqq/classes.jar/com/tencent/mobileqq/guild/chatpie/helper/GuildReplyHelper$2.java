package com.tencent.mobileqq.guild.chatpie.helper;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditText;

class GuildReplyHelper$2
  implements View.OnKeyListener
{
  GuildReplyHelper$2(GuildReplyHelper paramGuildReplyHelper) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 67) && (paramKeyEvent.getAction() == 0))
    {
      paramView = new StringBuilder();
      paramView.append("onKey: ");
      paramView.append(System.currentTimeMillis());
      QLog.d("GuildReplyHelper", 4, paramView.toString());
      if (TextUtils.isEmpty(GuildReplyHelper.b(this.a).getText().toString()))
      {
        GuildReplyHelper.c(this.a);
        this.a.a(null);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.helper.GuildReplyHelper.2
 * JD-Core Version:    0.7.0.1
 */