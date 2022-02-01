package com.tencent.mobileqq.selectmember;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.search.business.contact.fragment.ContactSearchFragment;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;

public class ContactFriendInnerFrame
  extends SelectMemberInnerFrame
  implements TabBarView.OnTabChangeListener
{
  public TroopDiscussionBaseV a;
  private TabBarView b;
  private FrameLayout c;
  private TroopDiscussionBaseV d;
  private TroopDiscussionBaseV e;
  
  public ContactFriendInnerFrame(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public ContactFriendInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ContactFriendInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(TroopDiscussionBaseV paramTroopDiscussionBaseV)
  {
    QBaseActivity localQBaseActivity = (QBaseActivity)getActivity();
    TroopDiscussionBaseV localTroopDiscussionBaseV = this.a;
    if (localTroopDiscussionBaseV != paramTroopDiscussionBaseV)
    {
      if (localTroopDiscussionBaseV != null)
      {
        if (localQBaseActivity.isResume()) {
          this.a.e();
        }
        this.a.f();
      }
      this.a = paramTroopDiscussionBaseV;
      paramTroopDiscussionBaseV = this.a;
      if (paramTroopDiscussionBaseV != null)
      {
        paramTroopDiscussionBaseV.b(null);
        if (localQBaseActivity.isResume()) {
          this.a.a();
        }
        this.c.removeAllViews();
        this.c.addView(this.a);
      }
    }
  }
  
  private void g()
  {
    if (this.d == null)
    {
      this.d = new PhoneContactTabView(this.f, this);
      this.d.a(null);
    }
    a(this.d);
  }
  
  private void h()
  {
    if (this.e == null)
    {
      this.e = new FriendTabView(this.f);
      this.e.a(null);
    }
    a(this.e);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 100) && (paramInt2 == -1)) {
      ((PhoneContactTabView)this.d).d();
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    paramBundle = getActivity();
    setContentView(2131626504);
    this.b = ((TabBarView)findViewById(2131446735));
    this.b.setOnTabChangeListener(this);
    this.b.a(0, paramBundle.getString(2131888040));
    RedDotTextView localRedDotTextView = this.b.b(0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131900633));
    localStringBuilder.append(paramBundle.getString(2131888040));
    localRedDotTextView.setContentDescription(localStringBuilder.toString());
    this.b.a(1, paramBundle.getString(2131888041));
    this.b.b(1).setContentDescription(paramBundle.getString(2131888041));
    this.c = ((FrameLayout)findViewById(2131435800));
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.f.setupTitleBar(false, this.f.getString(2131916208), this.f.mTitleString);
  }
  
  public void d()
  {
    TroopDiscussionBaseV localTroopDiscussionBaseV = this.e;
    if (localTroopDiscussionBaseV != null) {
      localTroopDiscussionBaseV.b();
    }
    localTroopDiscussionBaseV = this.d;
    if (localTroopDiscussionBaseV != null) {
      localTroopDiscussionBaseV.b();
    }
    super.d();
  }
  
  public void f()
  {
    TroopDiscussionBaseV localTroopDiscussionBaseV = this.a;
    if ((localTroopDiscussionBaseV instanceof FriendTabView))
    {
      ((FriendTabView)localTroopDiscussionBaseV).c();
      return;
    }
    if ((localTroopDiscussionBaseV instanceof PhoneContactTabView)) {
      ((PhoneContactTabView)localTroopDiscussionBaseV).c();
    }
  }
  
  public ContactSearchFragment getContactSearchFragment()
  {
    return null;
  }
  
  public String getGroupUin()
  {
    return "-1";
  }
  
  public void onTabSelected(int paramInt1, int paramInt2)
  {
    if (paramInt2 != 0)
    {
      if (paramInt2 != 1) {
        return;
      }
      h();
      return;
    }
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.ContactFriendInnerFrame
 * JD-Core Version:    0.7.0.1
 */