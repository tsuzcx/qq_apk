package com.tencent.mobileqq.guild.live.fragment.anchor.manage;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.guild.privatechannel.GuildSelectGuildMemberLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class GuildLiveAuthorSelectMemberFragment$2
  implements View.OnClickListener
{
  GuildLiveAuthorSelectMemberFragment$2(GuildLiveAuthorSelectMemberFragment paramGuildLiveAuthorSelectMemberFragment) {}
  
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
    localObject = new Intent();
    ((Intent)localObject).putExtra("select_member_list", arrayOfString);
    this.a.getActivity().setResult(-1, (Intent)localObject);
    this.a.getActivity().finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.anchor.manage.GuildLiveAuthorSelectMemberFragment.2
 * JD-Core Version:    0.7.0.1
 */