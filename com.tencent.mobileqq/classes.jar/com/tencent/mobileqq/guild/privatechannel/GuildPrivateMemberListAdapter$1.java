package com.tencent.mobileqq.guild.privatechannel;

import android.view.View;
import com.tencent.mobileqq.qqguildsdk.data.GuildUserAvatar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SwipListView;

class GuildPrivateMemberListAdapter$1
  implements Runnable
{
  GuildPrivateMemberListAdapter$1(GuildPrivateMemberListAdapter paramGuildPrivateMemberListAdapter, String paramString, GuildUserAvatar paramGuildUserAvatar) {}
  
  public void run()
  {
    int i = 0;
    View localView;
    while (i < this.this$0.a.e.getChildCount())
    {
      localView = this.this$0.a.e.getChildAt(i);
      if (GuildPrivateMemberListAdapter.a(this.this$0, localView, this.a, this.b))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("GuildPrivateMemberListAdapter", 2, new Object[] { "checkRefreshAvatar tinyId:", this.a });
        break;
      }
      i += 1;
    }
    i = 0;
    while (i < this.this$0.a.k.getChildCount())
    {
      localView = this.this$0.a.k.getChildAt(i);
      if (GuildPrivateMemberListAdapter.b(this.this$0, localView, this.a, this.b))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("GuildPrivateMemberListAdapter", 2, new Object[] { "checkRefreshGridAvatar tinyId:", this.a });
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.privatechannel.GuildPrivateMemberListAdapter.1
 * JD-Core Version:    0.7.0.1
 */