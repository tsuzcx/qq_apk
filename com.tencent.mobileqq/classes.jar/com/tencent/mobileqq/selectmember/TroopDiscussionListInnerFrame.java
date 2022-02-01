package com.tencent.mobileqq.selectmember;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.search.business.contact.fragment.ContactSearchFragment;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;

public class TroopDiscussionListInnerFrame
  extends SelectMemberInnerFrame
  implements TabBarView.OnTabChangeListener
{
  private TabBarView a;
  private FrameLayout b;
  private TroopDiscussionBaseV c;
  private TroopDiscussionBaseV d;
  private TroopDiscussionBaseV e;
  
  public TroopDiscussionListInnerFrame(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public TroopDiscussionListInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TroopDiscussionListInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(TroopDiscussionBaseV paramTroopDiscussionBaseV)
  {
    QBaseActivity localQBaseActivity = (QBaseActivity)getActivity();
    TroopDiscussionBaseV localTroopDiscussionBaseV = this.c;
    if (localTroopDiscussionBaseV != paramTroopDiscussionBaseV)
    {
      if (localTroopDiscussionBaseV != null)
      {
        if (localQBaseActivity.isResume()) {
          this.c.e();
        }
        this.c.f();
      }
      this.c = paramTroopDiscussionBaseV;
      paramTroopDiscussionBaseV = this.c;
      if (paramTroopDiscussionBaseV != null)
      {
        paramTroopDiscussionBaseV.b(null);
        if (localQBaseActivity.isResume()) {
          this.c.a();
        }
        this.b.removeAllViews();
        this.b.addView(this.c);
      }
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    paramBundle = getActivity();
    setContentView(2131626504);
    this.a = ((TabBarView)findViewById(2131446735));
    this.a.setOnTabChangeListener(this);
    this.a.a(0, paramBundle.getString(2131888045));
    RedDotTextView localRedDotTextView = this.a.b(0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131912555));
    localStringBuilder.append(paramBundle.getString(2131888045));
    localRedDotTextView.setContentDescription(localStringBuilder.toString());
    if (!this.f.mDonotNeedDiscussion)
    {
      this.a.a(1, paramBundle.getString(2131888044));
      this.a.b(1).setContentDescription(paramBundle.getString(2131888044));
    }
    this.a.setVisibility(8);
    this.b = ((FrameLayout)findViewById(2131435800));
    this.a.setSelectedTab(0, false);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    if (this.f.mOnlySelectTroopOrDiscussionMember) {
      this.f.setupTitleBar(false, this.f.getString(2131916208), this.f.getString(2131916232));
    } else {
      this.f.setupTitleBar(true, "", this.f.getString(2131916232));
    }
    if (this.f.mSelectedAndSearchBar.a())
    {
      this.f.mSelectedAndSearchBar.c();
      this.f.quitSearchState();
    }
  }
  
  public void c()
  {
    super.c();
  }
  
  public void d()
  {
    TroopDiscussionBaseV localTroopDiscussionBaseV = this.d;
    if (localTroopDiscussionBaseV != null) {
      localTroopDiscussionBaseV.b();
    }
    localTroopDiscussionBaseV = this.e;
    if (localTroopDiscussionBaseV != null) {
      localTroopDiscussionBaseV.b();
    }
    super.d();
  }
  
  public void f() {}
  
  public void g()
  {
    if (this.d == null)
    {
      this.d = new TroopDiscussionTroop(this.f);
      this.d.a(null);
    }
    a(this.d);
  }
  
  public ContactSearchFragment getContactSearchFragment()
  {
    int i;
    if (!this.f.mOnlyFriends)
    {
      i = 4194309;
      if (!this.f.mDonotNeedContacts) {
        i = 4194565;
      }
    }
    else
    {
      i = 1;
    }
    return ContactSearchFragment.a(-1, i | 0x8 | 0x200000 | 0x10, null, this.f.mUinsToHide, this.f);
  }
  
  public String getGroupUin()
  {
    return "-1";
  }
  
  public void h()
  {
    if (this.e == null)
    {
      this.e = new TroopDiscussionDiscussion(this.f);
      this.e.a(null);
    }
    a(this.e);
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
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopDiscussionListInnerFrame
 * JD-Core Version:    0.7.0.1
 */