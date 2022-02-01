package com.tencent.mobileqq.guild.privatechannel.ext;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.guild.privatechannel.data.GuildPrivateAddViewModel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class GuildPrivateAddMemberFragment$2
  implements View.OnClickListener
{
  GuildPrivateAddMemberFragment$2(GuildPrivateAddMemberFragment paramGuildPrivateAddMemberFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.a.p.getSelectedPositionList().keySet();
    String[] arrayOfString = new String[((Set)localObject).size()];
    localObject = ((Set)localObject).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      arrayOfString[i] = ((String)((Iterator)localObject).next());
      i += 1;
    }
    GuildPrivateAddMemberFragment.a(this.a).a(Arrays.asList(arrayOfString), new GuildPrivateAddMemberFragment.2.1(this, arrayOfString));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.privatechannel.ext.GuildPrivateAddMemberFragment.2
 * JD-Core Version:    0.7.0.1
 */