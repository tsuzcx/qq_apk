package com.tencent.mobileqq.guild.privatechannel;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import com.tencent.mobileqq.guild.setting.QQGuildMemberListViewModel;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class GuildSelectGuildMemberLayout
  extends GuildSelectMemberLayout
{
  ArrayList<GuildPrivateMemberListAdapter.UserInfoUIData> a = new ArrayList();
  ArrayList<GuildPrivateMemberListAdapter.UserInfoUIData> b = new ArrayList();
  HashMap<String, GuildPrivateMemberListAdapter.UserInfoUIData> c = new HashMap();
  private QQGuildMemberListViewModel n;
  private ArrayList<GuildPrivateMemberListAdapter.UserInfoUIData> o;
  private Fragment p;
  private GuildSelectMemberLayout.ISelectMemberCallback q;
  private IGProGuildInfo r;
  private int s;
  private boolean t = false;
  private boolean u = false;
  
  public GuildSelectGuildMemberLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public GuildSelectGuildMemberLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public GuildSelectGuildMemberLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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
    if (this.f == 1) {
      return true;
    }
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
    this.u = true;
    this.b.clear();
    a(paramList, this.b);
    setSelectData(this.b);
  }
  
  private void d()
  {
    if (this.f != 1)
    {
      this.o = new ArrayList();
      GuildPrivateMemberListAdapter.UserInfoUIData localUserInfoUIData = new GuildPrivateMemberListAdapter.UserInfoUIData(2);
      if (this.s == 5)
      {
        localUserInfoUIData.mTitleName = "";
      }
      else if (this.r.getVisibleChannelMaxNum() > 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("最多支持");
        ((StringBuilder)localObject).append(this.r.getVisibleChannelMaxNum());
        ((StringBuilder)localObject).append("人查看看此子频道");
        localUserInfoUIData.mTitleName = ((StringBuilder)localObject).toString();
        this.o.add(localUserInfoUIData);
      }
      else
      {
        localUserInfoUIData.mTitleName = "";
      }
      localUserInfoUIData = new GuildPrivateMemberListAdapter.UserInfoUIData(0);
      localUserInfoUIData.mName = "管理员";
      localUserInfoUIData.mSelectable = false;
      Object localObject = new GuildPrivateMemberListAdapter.UserInfoUIData(1);
      this.o.add(localUserInfoUIData);
      this.o.add(localObject);
      a(this.o);
    }
    this.n.s();
    a();
    e();
    super.setSelectMemberCallback(new GuildSelectGuildMemberLayout.1(this));
  }
  
  private void e()
  {
    this.n.f().observe(this.p.getViewLifecycleOwner(), new GuildSelectGuildMemberLayout.2(this));
    this.n.e().observe(this.p.getViewLifecycleOwner(), new GuildSelectGuildMemberLayout.3(this));
    this.n.r().observe(this.p.getViewLifecycleOwner(), new GuildSelectGuildMemberLayout.4(this));
    this.n.b().observe(this.p.getViewLifecycleOwner(), new GuildSelectGuildMemberLayout.5(this));
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
  
  public void setDataModel(QQGuildMemberListViewModel paramQQGuildMemberListViewModel, Fragment paramFragment, IGProGuildInfo paramIGProGuildInfo)
  {
    this.p = paramFragment;
    this.n = paramQQGuildMemberListViewModel;
    this.r = paramIGProGuildInfo;
    d();
  }
  
  public void setIsFrom(int paramInt)
  {
    this.s = paramInt;
  }
  
  public void setSelectMemberCallback(GuildSelectMemberLayout.ISelectMemberCallback paramISelectMemberCallback)
  {
    this.q = paramISelectMemberCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.privatechannel.GuildSelectGuildMemberLayout
 * JD-Core Version:    0.7.0.1
 */