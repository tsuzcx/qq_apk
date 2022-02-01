package com.tencent.mobileqq.guild.main;

import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.widget.SwipPinnedHeaderExpandableListView;

class QQGuildChannelAdapterNew$1
  implements Runnable
{
  public void run()
  {
    if (QQGuildChannelAdapterNew.a(this.this$0) == null)
    {
      QQGuildChannelAdapterNew localQQGuildChannelAdapterNew = this.this$0;
      QQGuildChannelAdapterNew.a(localQQGuildChannelAdapterNew, new QQProgressDialog(QQGuildChannelAdapterNew.b(localQQGuildChannelAdapterNew).getContext()));
    }
    if (this.a)
    {
      QQGuildChannelAdapterNew.a(this.this$0).show();
      return;
    }
    QQGuildChannelAdapterNew.a(this.this$0).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.main.QQGuildChannelAdapterNew.1
 * JD-Core Version:    0.7.0.1
 */