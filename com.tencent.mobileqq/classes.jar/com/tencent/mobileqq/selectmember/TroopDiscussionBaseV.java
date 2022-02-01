package com.tencent.mobileqq.selectmember;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.InnerFrameManager;

public abstract class TroopDiscussionBaseV
  extends FrameLayout
{
  protected SelectMemberActivity d;
  protected Context e;
  protected AppInterface f;
  protected InnerFrameManager g;
  protected LayoutInflater h;
  
  public TroopDiscussionBaseV(SelectMemberActivity paramSelectMemberActivity)
  {
    super(paramSelectMemberActivity);
    this.f = ((AppInterface)paramSelectMemberActivity.getAppRuntime());
    this.d = paramSelectMemberActivity;
    this.e = paramSelectMemberActivity;
    this.h = paramSelectMemberActivity.getLayoutInflater();
    this.g = paramSelectMemberActivity.mInnerFrameManager;
  }
  
  protected void a() {}
  
  public void a(Bundle paramBundle) {}
  
  protected void b() {}
  
  public void b(Bundle paramBundle) {}
  
  protected void e() {}
  
  protected void f() {}
  
  protected final void setContentView(int paramInt)
  {
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(paramInt, this, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopDiscussionBaseV
 * JD-Core Version:    0.7.0.1
 */