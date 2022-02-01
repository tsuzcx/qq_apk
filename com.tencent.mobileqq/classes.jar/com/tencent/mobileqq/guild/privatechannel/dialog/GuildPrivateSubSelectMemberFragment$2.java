package com.tencent.mobileqq.guild.privatechannel.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.guild.privatechannel.GuildSelectGuildMemberLayout;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class GuildPrivateSubSelectMemberFragment$2
  implements View.OnClickListener
{
  GuildPrivateSubSelectMemberFragment$2(GuildPrivateSubSelectMemberFragment paramGuildPrivateSubSelectMemberFragment) {}
  
  public void onClick(View paramView)
  {
    if (!QQGuildUIUtil.a())
    {
      Object localObject = this.a.e.getSelectedPositionList().keySet();
      String[] arrayOfString = new String[((Set)localObject).size()];
      localObject = ((Set)localObject).iterator();
      int i = 0;
      while (((Iterator)localObject).hasNext())
      {
        arrayOfString[i] = ((String)((Iterator)localObject).next());
        i += 1;
      }
      if (GuildPrivateSubSelectMemberFragment.b(this.a) != null) {
        GuildPrivateSubSelectMemberFragment.b(this.a).a(arrayOfString, this.a.e.getSelectedUIDataList());
      }
      GuildPrivateSubSelectMemberFragment.a(this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.privatechannel.dialog.GuildPrivateSubSelectMemberFragment.2
 * JD-Core Version:    0.7.0.1
 */