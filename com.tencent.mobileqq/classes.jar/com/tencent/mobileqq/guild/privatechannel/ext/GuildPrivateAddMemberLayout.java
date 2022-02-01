package com.tencent.mobileqq.guild.privatechannel.ext;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.guild.privatechannel.GuildPrivateMemberListAdapter.UserInfoUIData;
import com.tencent.mobileqq.guild.privatechannel.GuildPrivateSearchGridAdapter;
import com.tencent.mobileqq.guild.privatechannel.GuildSelectMemberLayout;
import com.tencent.mobileqq.guild.privatechannel.GuildSelectMemberLayout.ISelectMemberCallback;
import com.tencent.mobileqq.guild.privatechannel.data.GuildPrivateAddViewModel;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class GuildPrivateAddMemberLayout
  extends GuildSelectMemberLayout
{
  ArrayList<GuildPrivateMemberListAdapter.UserInfoUIData> a = new ArrayList();
  ArrayList<GuildPrivateMemberListAdapter.UserInfoUIData> b = new ArrayList();
  HashMap<String, GuildPrivateMemberListAdapter.UserInfoUIData> c = new HashMap();
  private GuildPrivateAddViewModel n;
  private ArrayList<GuildPrivateMemberListAdapter.UserInfoUIData> o;
  private Fragment p;
  private GuildSelectMemberLayout.ISelectMemberCallback q;
  private IGProGuildInfo r;
  private boolean s = false;
  
  public GuildPrivateAddMemberLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public GuildPrivateAddMemberLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public GuildPrivateAddMemberLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(IGProUserInfo paramIGProUserInfo, ArrayList<GuildPrivateMemberListAdapter.UserInfoUIData> paramArrayList)
  {
    if (this.c.containsKey(paramIGProUserInfo.a()))
    {
      paramArrayList.add(this.c.get(paramIGProUserInfo.a()));
      return;
    }
    GuildPrivateMemberListAdapter.UserInfoUIData localUserInfoUIData = new GuildPrivateMemberListAdapter.UserInfoUIData(0);
    localUserInfoUIData.mName = QQGuildUtil.a(paramIGProUserInfo);
    localUserInfoUIData.mTinyId = paramIGProUserInfo.a();
    localUserInfoUIData.mSelectable = a(paramIGProUserInfo);
    this.c.put(paramIGProUserInfo.a(), localUserInfoUIData);
    paramArrayList.add(localUserInfoUIData);
  }
  
  private boolean a(IGProUserInfo paramIGProUserInfo)
  {
    if (paramIGProUserInfo.d() == 2) {
      return false;
    }
    return paramIGProUserInfo.d() != 1;
  }
  
  private void b(List<IGProUserInfo> paramList)
  {
    if ((TextUtils.isEmpty(this.i.getText())) && (this.l.c == null)) {
      return;
    }
    if ((TextUtils.isEmpty(this.i.getText())) && (this.l.c != null) && (TextUtils.isEmpty(this.l.c.getText()))) {
      return;
    }
    this.s = true;
    this.b.clear();
    a(paramList, this.b);
    setSelectData(this.b);
  }
  
  private void d()
  {
    this.o = new ArrayList();
    GuildPrivateMemberListAdapter.UserInfoUIData localUserInfoUIData = new GuildPrivateMemberListAdapter.UserInfoUIData(2);
    if (this.r.getVisibleChannelMaxNum() > 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("最多支持");
      localStringBuilder.append(this.r.getVisibleChannelMaxNum());
      localStringBuilder.append("人查看看此子频道");
      localUserInfoUIData.mTitleName = localStringBuilder.toString();
    }
    else
    {
      localUserInfoUIData.mTitleName = "";
    }
    localUserInfoUIData = new GuildPrivateMemberListAdapter.UserInfoUIData(0);
    localUserInfoUIData.mName = "管理员";
    localUserInfoUIData.mSelectable = false;
    localUserInfoUIData = new GuildPrivateMemberListAdapter.UserInfoUIData(1);
    this.o.add(localUserInfoUIData);
    a(this.o);
    this.n.a();
    a();
    e();
    super.setSelectMemberCallback(new GuildPrivateAddMemberLayout.1(this));
  }
  
  private void e()
  {
    this.n.d().observe(this.p.getViewLifecycleOwner(), new GuildPrivateAddMemberLayout.2(this));
    this.n.b().observe(this.p.getViewLifecycleOwner(), new GuildPrivateAddMemberLayout.3(this));
  }
  
  public void a(List<IGProUserInfo> paramList, ArrayList<GuildPrivateMemberListAdapter.UserInfoUIData> paramArrayList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      IGProUserInfo localIGProUserInfo = (IGProUserInfo)paramList.next();
      if (a(localIGProUserInfo) == true) {
        a(localIGProUserInfo, paramArrayList);
      }
    }
  }
  
  public void setDataModel(GuildPrivateAddViewModel paramGuildPrivateAddViewModel, Fragment paramFragment, IGProGuildInfo paramIGProGuildInfo)
  {
    this.p = paramFragment;
    this.n = paramGuildPrivateAddViewModel;
    this.r = paramIGProGuildInfo;
    d();
  }
  
  public void setSelectMemberCallback(GuildSelectMemberLayout.ISelectMemberCallback paramISelectMemberCallback)
  {
    this.q = paramISelectMemberCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.privatechannel.ext.GuildPrivateAddMemberLayout
 * JD-Core Version:    0.7.0.1
 */