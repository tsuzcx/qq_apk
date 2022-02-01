package com.tencent.mobileqq.guild.setting;

import com.tencent.qphone.base.util.BaseApplication;

class GuildMemberListModel
{
  private int a = 0;
  private int b = 0;
  private int c = 0;
  private int d = 0;
  private QQGuildMemberListAdapter.UserInfoItem e = null;
  private QQGuildMemberListAdapter.UserInfoItem f = null;
  private QQGuildMemberListAdapter.UserInfoItem g = null;
  
  public void a()
  {
    this.a = 0;
    this.b = 0;
    this.d = 0;
    this.e = null;
    this.f = null;
    this.g = null;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    if (!d()) {
      return;
    }
    String str;
    if (paramBoolean)
    {
      int j = this.c;
      int i = j;
      if (j == 0) {
        i = this.d;
      }
      str = String.format(BaseApplication.getContext().getString(2131890509), new Object[] { Integer.valueOf(i) });
    }
    else
    {
      str = BaseApplication.getContext().getString(2131890508);
    }
    this.g.b = str;
  }
  
  public boolean b()
  {
    return this.e != null;
  }
  
  public boolean c()
  {
    return this.f != null;
  }
  
  public boolean d()
  {
    return this.g != null;
  }
  
  public QQGuildMemberListAdapter.UserInfoItem e()
  {
    this.e = new QQGuildMemberListAdapter.UserInfoItem();
    return this.e;
  }
  
  public QQGuildMemberListAdapter.UserInfoItem f()
  {
    this.f = new QQGuildMemberListAdapter.UserInfoItem();
    return this.f;
  }
  
  public QQGuildMemberListAdapter.UserInfoItem g()
  {
    this.g = new QQGuildMemberListAdapter.UserInfoItem();
    return this.g;
  }
  
  public void h()
  {
    this.f = null;
  }
  
  public void i()
  {
    this.g = null;
  }
  
  public QQGuildMemberListAdapter.UserInfoItem j()
  {
    return this.f;
  }
  
  public QQGuildMemberListAdapter.UserInfoItem k()
  {
    return this.g;
  }
  
  public void l()
  {
    if (!b()) {
      return;
    }
    this.e.b = String.format(BaseApplication.getContext().getString(2131890507), new Object[] { Integer.valueOf(this.a) });
  }
  
  public void m()
  {
    if (!c()) {
      return;
    }
    this.f.b = String.format(BaseApplication.getContext().getString(2131890510), new Object[] { Integer.valueOf(this.b) });
  }
  
  public int n()
  {
    return this.a;
  }
  
  public int o()
  {
    return this.b;
  }
  
  public int p()
  {
    return this.d;
  }
  
  public void q()
  {
    this.c += 1;
  }
  
  public void r()
  {
    this.c -= 1;
  }
  
  public void s()
  {
    this.a += 1;
  }
  
  public void t()
  {
    this.a -= 1;
  }
  
  public void u()
  {
    this.b += 1;
  }
  
  public void v()
  {
    this.b -= 1;
  }
  
  public void w()
  {
    this.d += 1;
  }
  
  public void x()
  {
    this.d -= 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.GuildMemberListModel
 * JD-Core Version:    0.7.0.1
 */