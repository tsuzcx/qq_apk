package com.tencent.mobileqq.guild.audio.data;

import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserInfo
{
  public static int f = 1;
  public static int g = 2;
  public String h = "";
  public String i = "";
  public String j = "";
  public int k = 0;
  public int l = f;
  public boolean m = false;
  public int n = 0;
  public boolean o = false;
  public boolean p = false;
  
  public static void a(List<IGProUserInfo> paramList, List<UserInfo> paramList1)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      IGProUserInfo localIGProUserInfo = (IGProUserInfo)paramList.next();
      UserInfo localUserInfo1 = new UserInfo();
      Iterator localIterator = paramList1.iterator();
      while (localIterator.hasNext())
      {
        UserInfo localUserInfo2 = (UserInfo)localIterator.next();
        if (localIGProUserInfo.a().equals(localUserInfo2.h)) {
          localUserInfo1.a(localUserInfo2);
        }
      }
      localUserInfo1.a(localIGProUserInfo);
      localArrayList.add(localUserInfo1);
    }
    paramList1.clear();
    paramList1.addAll(localArrayList);
  }
  
  public static void a(List<UserInfo> paramList, boolean paramBoolean)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((UserInfo)paramList.next()).m = paramBoolean;
    }
  }
  
  public void a(TRTCUserInfo paramTRTCUserInfo)
  {
    this.h = paramTRTCUserInfo.a;
    this.m = paramTRTCUserInfo.b;
  }
  
  public void a(UserInfo paramUserInfo)
  {
    this.h = String.copyValueOf(paramUserInfo.h.toCharArray());
    this.i = paramUserInfo.i;
    this.j = paramUserInfo.j;
    this.k = paramUserInfo.k;
    this.l = paramUserInfo.l;
    this.m = paramUserInfo.m;
    this.n = paramUserInfo.n;
    this.o = paramUserInfo.o;
    this.p = paramUserInfo.p;
  }
  
  public void a(IGProUserInfo paramIGProUserInfo)
  {
    this.h = paramIGProUserInfo.a();
    this.i = QQGuildUtil.a(paramIGProUserInfo);
    this.k = paramIGProUserInfo.d();
    this.p = paramIGProUserInfo.g();
    this.o = paramIGProUserInfo.h();
  }
  
  public void a(List<IGProUserInfo> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      IGProUserInfo localIGProUserInfo = (IGProUserInfo)paramList.next();
      if (localIGProUserInfo.a().equals(this.h)) {
        a(localIGProUserInfo);
      }
    }
  }
  
  public void b()
  {
    this.h = "";
    this.i = "";
    this.j = "";
    this.k = 0;
    this.l = f;
    this.m = false;
    this.n = 0;
    this.o = false;
    this.p = false;
  }
  
  public UserInfo c()
  {
    UserInfo localUserInfo = new UserInfo();
    localUserInfo.h = this.h;
    localUserInfo.i = this.i;
    localUserInfo.j = this.j;
    localUserInfo.k = this.k;
    localUserInfo.l = this.l;
    localUserInfo.m = this.m;
    localUserInfo.n = this.n;
    localUserInfo.o = this.o;
    localUserInfo.p = this.p;
    return localUserInfo;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UserInfo{id='");
    localStringBuilder.append(this.h);
    localStringBuilder.append('\'');
    localStringBuilder.append(", userType=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", Role=");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", isMicOn=");
    localStringBuilder.append(this.m);
    localStringBuilder.append(", volume=");
    localStringBuilder.append(this.n);
    localStringBuilder.append(", muteToMe=");
    localStringBuilder.append(this.o);
    localStringBuilder.append(", globalMute=");
    localStringBuilder.append(this.p);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.data.UserInfo
 * JD-Core Version:    0.7.0.1
 */