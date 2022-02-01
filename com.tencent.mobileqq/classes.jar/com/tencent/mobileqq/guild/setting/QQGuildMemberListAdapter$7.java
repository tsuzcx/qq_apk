package com.tencent.mobileqq.guild.setting;

import android.view.View;
import com.tencent.mobileqq.qqguildsdk.data.GuildUserAvatar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SwipListView;
import mqq.util.WeakReference;

class QQGuildMemberListAdapter$7
  implements Runnable
{
  QQGuildMemberListAdapter$7(QQGuildMemberListAdapter paramQQGuildMemberListAdapter, String paramString, GuildUserAvatar paramGuildUserAvatar) {}
  
  public void run()
  {
    int i = 0;
    while (i < ((QQGuildMemberFragment)QQGuildMemberListAdapter.e(this.this$0).get()).o.getChildCount())
    {
      View localView = ((QQGuildMemberFragment)QQGuildMemberListAdapter.e(this.this$0).get()).o.getChildAt(i);
      if (QQGuildMemberListAdapter.a(this.this$0, localView, this.a, this.b))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("QQGuildMemberListAdapter", 2, new Object[] { "checkRefreshAvatar tinyId:", this.a });
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuildMemberListAdapter.7
 * JD-Core Version:    0.7.0.1
 */