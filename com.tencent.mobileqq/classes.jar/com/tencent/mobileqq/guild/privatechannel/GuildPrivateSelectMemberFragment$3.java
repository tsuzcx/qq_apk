package com.tencent.mobileqq.guild.privatechannel;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.tencent.widget.AbsListView;
import java.util.HashMap;

class GuildPrivateSelectMemberFragment$3
  implements GuildSelectMemberLayout.ISelectMemberCallback
{
  GuildPrivateSelectMemberFragment$3(GuildPrivateSelectMemberFragment paramGuildPrivateSelectMemberFragment) {}
  
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
    if (this.a.p.getSelectedPositionList().size() == 0)
    {
      this.a.a(false);
      paramArrayOfUserInfoUIData = this.a;
      paramArrayOfUserInfoUIData.a(paramArrayOfUserInfoUIData.o, -2130706433);
      return true;
    }
    this.a.a(true);
    paramArrayOfUserInfoUIData = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.o);
    localStringBuilder.append("(");
    localStringBuilder.append(this.a.p.getSelectedPositionList().size());
    localStringBuilder.append(")");
    paramArrayOfUserInfoUIData.a(localStringBuilder.toString(), -16777216);
    return true;
  }
  
  public void b(GuildPrivateMemberListAdapter.UserInfoUIData paramUserInfoUIData) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.privatechannel.GuildPrivateSelectMemberFragment.3
 * JD-Core Version:    0.7.0.1
 */