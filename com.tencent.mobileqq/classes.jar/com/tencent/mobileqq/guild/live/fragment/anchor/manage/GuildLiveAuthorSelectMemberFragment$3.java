package com.tencent.mobileqq.guild.live.fragment.anchor.manage;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.guild.privatechannel.GuildPrivateMemberListAdapter.UserInfoUIData;
import com.tencent.mobileqq.guild.privatechannel.GuildSelectGuildMemberLayout;
import com.tencent.mobileqq.guild.privatechannel.GuildSelectMemberLayout.ISelectMemberCallback;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.AbsListView;
import java.util.HashMap;

class GuildLiveAuthorSelectMemberFragment$3
  implements GuildSelectMemberLayout.ISelectMemberCallback
{
  GuildLiveAuthorSelectMemberFragment$3(GuildLiveAuthorSelectMemberFragment paramGuildLiveAuthorSelectMemberFragment) {}
  
  public void a() {}
  
  public void a(GuildPrivateMemberListAdapter.UserInfoUIData paramUserInfoUIData)
  {
    paramUserInfoUIData = paramUserInfoUIData.mTinyId;
    Intent localIntent = new Intent();
    localIntent.putExtra("select_member_list", new String[] { paramUserInfoUIData });
    this.a.getActivity().setResult(-1, localIntent);
    this.a.getActivity().finish();
  }
  
  public void a(AbsListView paramAbsListView, int paramInt) {}
  
  public void a(String paramString) {}
  
  public boolean a(GuildPrivateMemberListAdapter.UserInfoUIData[] paramArrayOfUserInfoUIData, boolean paramBoolean)
  {
    if (this.a.p.getSelectedPositionList().size() > GuildLiveAuthorSelectMemberFragment.a(this.a))
    {
      QQToast.makeText(this.a.getContext(), 0, this.a.getString(2131890470), 0).show();
      return false;
    }
    return true;
  }
  
  public void b(GuildPrivateMemberListAdapter.UserInfoUIData paramUserInfoUIData) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.anchor.manage.GuildLiveAuthorSelectMemberFragment.3
 * JD-Core Version:    0.7.0.1
 */