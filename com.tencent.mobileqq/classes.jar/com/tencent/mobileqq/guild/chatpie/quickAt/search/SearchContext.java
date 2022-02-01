package com.tencent.mobileqq.guild.chatpie.quickAt.search;

import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import java.util.List;

public abstract class SearchContext
{
  protected int c = 0;
  protected SearchContext.IHandler d;
  
  public abstract String a();
  
  public void a(SearchContext.IHandler paramIHandler)
  {
    if (this.c != 0) {
      return;
    }
    this.c = 1;
    this.d = paramIHandler;
    d();
  }
  
  public void a(SearchException paramSearchException)
  {
    if (this.c != 1) {
      return;
    }
    this.c = 4;
    SearchContext.IHandler localIHandler = this.d;
    if (localIHandler != null) {
      localIHandler.onResult(this, paramSearchException);
    }
  }
  
  public abstract String b();
  
  public abstract List<IGProUserInfo> c();
  
  public abstract void d();
  
  public boolean e()
  {
    return this.c == 2;
  }
  
  public boolean f()
  {
    return this.c == 3;
  }
  
  public void g()
  {
    if (this.c != 1) {
      return;
    }
    this.c = 3;
    SearchContext.IHandler localIHandler = this.d;
    if (localIHandler != null) {
      localIHandler.onResult(this, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.quickAt.search.SearchContext
 * JD-Core Version:    0.7.0.1
 */