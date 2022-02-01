package com.tencent.mobileqq.fragment;

import android.view.View.OnClickListener;

public class TitlebarStatus
{
  public boolean a;
  public boolean b = true;
  public String c;
  public String d;
  public String e;
  public boolean f = false;
  public String g;
  public int h;
  public String i;
  public View.OnClickListener j;
  public TitlebarBaseFragment k;
  
  public TitlebarStatus(TitlebarBaseFragment paramTitlebarBaseFragment)
  {
    this.k = paramTitlebarBaseFragment;
  }
  
  public TitlebarStatus a(View.OnClickListener paramOnClickListener)
  {
    this.j = paramOnClickListener;
    return this;
  }
  
  public TitlebarStatus a(String paramString)
  {
    this.g = paramString;
    return this;
  }
  
  public TitlebarStatus a(boolean paramBoolean)
  {
    this.f = paramBoolean;
    return this;
  }
  
  public void a()
  {
    TitlebarBaseFragment localTitlebarBaseFragment = this.k;
    if (localTitlebarBaseFragment != null) {
      localTitlebarBaseFragment.E();
    }
  }
  
  public TitlebarStatus b(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public TitlebarStatus b(boolean paramBoolean)
  {
    this.a = paramBoolean;
    return this;
  }
  
  public void c(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.TitlebarStatus
 * JD-Core Version:    0.7.0.1
 */