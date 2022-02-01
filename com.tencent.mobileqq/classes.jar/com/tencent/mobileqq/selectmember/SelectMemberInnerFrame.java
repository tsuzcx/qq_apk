package com.tencent.mobileqq.selectmember;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.InnerFrame;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.search.business.contact.fragment.ContactSearchFragment;
import mqq.app.MobileQQ;

public abstract class SelectMemberInnerFrame
  extends InnerFrame
{
  protected SelectMemberActivity f;
  protected InnerFrameManager g;
  protected AppInterface h;
  protected LayoutInflater i;
  
  public SelectMemberInnerFrame(Context paramContext)
  {
    super(paramContext);
  }
  
  public SelectMemberInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SelectMemberInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.f = ((SelectMemberActivity)getActivity());
    this.g = getInnerFrameManager();
    if ((getAppIntf() instanceof AppInterface))
    {
      this.h = getAppIntf();
    }
    else
    {
      paramBundle = MobileQQ.sMobileQQ.waitAppRuntime(null);
      if ((paramBundle instanceof AppInterface)) {
        this.h = ((AppInterface)paramBundle);
      }
    }
    this.i = this.f.getLayoutInflater();
  }
  
  public void a(ResultRecord paramResultRecord, int paramInt) {}
  
  public abstract void f();
  
  public abstract ContactSearchFragment getContactSearchFragment();
  
  public abstract String getGroupUin();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.SelectMemberInnerFrame
 * JD-Core Version:    0.7.0.1
 */