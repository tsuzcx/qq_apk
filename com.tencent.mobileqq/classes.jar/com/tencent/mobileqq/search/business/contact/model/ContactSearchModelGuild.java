package com.tencent.mobileqq.search.business.contact.model;

import android.view.View;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.util.SearchUtils;

public class ContactSearchModelGuild
  extends IContactSearchModel
{
  private IGProGuildInfo a;
  private String b;
  private long c;
  
  public CharSequence a()
  {
    return null;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    ((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).openGuild(this.m, paramView.getContext(), false, null, this.a.getGuildID());
    SearchUtils.a("Sgrp", "search_result2", "clk", 0, 0, new String[] { this.a.getGuildID() });
  }
  
  public int b()
  {
    return 117;
  }
  
  public String c()
  {
    return this.a.getGuildID();
  }
  
  public CharSequence f()
  {
    return null;
  }
  
  public String g()
  {
    return this.b;
  }
  
  public boolean h()
  {
    return false;
  }
  
  public Object i()
  {
    return this.a.getGuildID();
  }
  
  public int j()
  {
    return 10014;
  }
  
  public String m()
  {
    return this.a.getGuildName();
  }
  
  public String n()
  {
    return this.a.getShowNumber();
  }
  
  protected long n_(String paramString)
  {
    this.b = paramString;
    this.c = -9223372036854775808L;
    long l = SearchUtils.b(paramString, this.a.getGuildName(), IContactSearchable.j);
    if (l > this.c) {
      this.c = l;
    }
    l = SearchUtils.a(paramString, this.a.getShowNumber(), IContactSearchable.s, false);
    if (l > this.c) {
      this.c = l;
    }
    return this.c;
  }
  
  public int o()
  {
    return 8;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.model.ContactSearchModelGuild
 * JD-Core Version:    0.7.0.1
 */