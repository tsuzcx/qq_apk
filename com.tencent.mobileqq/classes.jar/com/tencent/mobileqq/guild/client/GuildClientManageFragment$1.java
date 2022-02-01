package com.tencent.mobileqq.guild.client;

import android.text.TextUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;

class GuildClientManageFragment$1
  implements Runnable
{
  GuildClientManageFragment$1(GuildClientManageFragment paramGuildClientManageFragment) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(GuildClientManageFragment.a(this.this$0).i())) {
      GuildClientManageFragment.b(this.this$0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.GuildClientManageFragment.1
 * JD-Core Version:    0.7.0.1
 */