package com.tencent.mobileqq.guild.mainframe.leftbar;

import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;

class GuildBaseItemAdapter$1
  implements Runnable
{
  GuildBaseItemAdapter$1(GuildBaseItemAdapter paramGuildBaseItemAdapter, int paramInt) {}
  
  public void run()
  {
    this.this$0.a.i().setSelection(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setSelection ");
    localStringBuilder.append(this.a);
    QLog.d("GuildBaseItemAdapter", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.leftbar.GuildBaseItemAdapter.1
 * JD-Core Version:    0.7.0.1
 */