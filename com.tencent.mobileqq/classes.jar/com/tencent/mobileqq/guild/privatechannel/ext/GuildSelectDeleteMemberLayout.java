package com.tencent.mobileqq.guild.privatechannel.ext;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.privatechannel.GuildPrivateMemberListAdapter.UserInfoUIData;
import com.tencent.mobileqq.guild.privatechannel.GuildSelectMemberLayout;
import com.tencent.mobileqq.guild.privatechannel.GuildSelectMemberLayout.ISelectMemberCallback;
import com.tencent.mobileqq.guild.privatechannel.data.GuildPrivateDeleteViewModel;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SwipListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class GuildSelectDeleteMemberLayout
  extends GuildSelectMemberLayout
{
  ArrayList<GuildPrivateMemberListAdapter.UserInfoUIData> a = new ArrayList();
  ArrayList<GuildPrivateMemberListAdapter.UserInfoUIData> b = new ArrayList();
  HashMap<String, GuildPrivateMemberListAdapter.UserInfoUIData> c = new HashMap();
  private GuildPrivateDeleteViewModel n;
  private ArrayList<GuildPrivateMemberListAdapter.UserInfoUIData> o;
  private Fragment p;
  private GuildSelectMemberLayout.ISelectMemberCallback q;
  private View r;
  private String s;
  private String t;
  private IGProGuildInfo u;
  
  public GuildSelectDeleteMemberLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public GuildSelectDeleteMemberLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public GuildSelectDeleteMemberLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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
  
  private void d()
  {
    this.o = new ArrayList();
    GuildPrivateMemberListAdapter.UserInfoUIData localUserInfoUIData1 = new GuildPrivateMemberListAdapter.UserInfoUIData(0);
    localUserInfoUIData1.mName = "管理员";
    localUserInfoUIData1.mSelectable = false;
    GuildPrivateMemberListAdapter.UserInfoUIData localUserInfoUIData2 = new GuildPrivateMemberListAdapter.UserInfoUIData(1);
    this.o.add(localUserInfoUIData2);
    this.o.add(localUserInfoUIData1);
    this.o.add(localUserInfoUIData2);
    a(this.o);
    if ((!this.n.c()) && (this.n.f())) {
      this.n.b();
    }
    a();
    e();
    super.setSelectMemberCallback(new GuildSelectDeleteMemberLayout.1(this));
  }
  
  private void e()
  {
    this.n.d().observe(this.p.getViewLifecycleOwner(), new GuildSelectDeleteMemberLayout.2(this));
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
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if (paramView.getId() == 2131435897) {
      GuildPrivateAddMemberFragment.a(this.p.getActivity(), getAppInterface(), this.s, this.t, "", 0, 2);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setDataModel(GuildPrivateDeleteViewModel paramGuildPrivateDeleteViewModel, Fragment paramFragment, String paramString1, String paramString2, IGProGuildInfo paramIGProGuildInfo)
  {
    this.p = paramFragment;
    this.n = paramGuildPrivateDeleteViewModel;
    this.s = paramString1;
    this.t = paramString2;
    this.u = paramIGProGuildInfo;
    d();
  }
  
  public void setInitData(AppInterface paramAppInterface, int paramInt)
  {
    this.r = LayoutInflater.from(this.d).inflate(2131625112, null);
    this.r.setOnClickListener(this);
    this.e.addHeaderView(this.r);
    super.setInitData(paramAppInterface, paramInt);
    this.j.findViewById(2131434693).setVisibility(8);
    this.h.setVisibility(8);
  }
  
  public void setSelectMemberCallback(GuildSelectMemberLayout.ISelectMemberCallback paramISelectMemberCallback)
  {
    this.q = paramISelectMemberCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.privatechannel.ext.GuildSelectDeleteMemberLayout
 * JD-Core Version:    0.7.0.1
 */