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
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private TroopDiscussionBaseV jdField_a_of_type_ComTencentMobileqqSelectmemberTroopDiscussionBaseV;
  private TabBarView jdField_a_of_type_ComTencentMobileqqWidgetTabBarView;
  private TroopDiscussionBaseV b;
  private TroopDiscussionBaseV c;
  
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
    QBaseActivity localQBaseActivity = (QBaseActivity)a();
    TroopDiscussionBaseV localTroopDiscussionBaseV = this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopDiscussionBaseV;
    if (localTroopDiscussionBaseV != paramTroopDiscussionBaseV)
    {
      if (localTroopDiscussionBaseV != null)
      {
        if (localQBaseActivity.isResume()) {
          this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopDiscussionBaseV.e();
        }
        this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopDiscussionBaseV.f();
      }
      this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopDiscussionBaseV = paramTroopDiscussionBaseV;
      paramTroopDiscussionBaseV = this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopDiscussionBaseV;
      if (paramTroopDiscussionBaseV != null)
      {
        paramTroopDiscussionBaseV.b(null);
        if (localQBaseActivity.isResume()) {
          this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopDiscussionBaseV.a();
        }
        this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopDiscussionBaseV);
      }
    }
  }
  
  public ContactSearchFragment a()
  {
    int i;
    if (!this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mOnlyFriends)
    {
      i = 4194309;
      if (!this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mDonotNeedContacts) {
        i = 4194565;
      }
    }
    else
    {
      i = 1;
    }
    return ContactSearchFragment.a(-1, i | 0x8 | 0x200000 | 0x10, null, this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mUinsToHide, this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity);
  }
  
  public String a()
  {
    return "-1";
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    paramBundle = a();
    setContentView(2131560459);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)findViewById(2131378217));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0, paramBundle.getString(2131691099));
    RedDotTextView localRedDotTextView = this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131715067));
    localStringBuilder.append(paramBundle.getString(2131691099));
    localRedDotTextView.setContentDescription(localStringBuilder.toString());
    if (!this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mDonotNeedDiscussion)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1, paramBundle.getString(2131691098));
      this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1).setContentDescription(paramBundle.getString(2131691098));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131368866));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, false);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mOnlySelectTroopOrDiscussionMember) {
      this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.setupTitleBar(false, this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getString(2131718706), this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getString(2131718730));
    } else {
      this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.setupTitleBar(true, "", this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getString(2131718730));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mSelectedAndSearchBar.a())
    {
      this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mSelectedAndSearchBar.b();
      this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.quitSearchState();
    }
  }
  
  public void c()
  {
    super.c();
  }
  
  public void d()
  {
    TroopDiscussionBaseV localTroopDiscussionBaseV = this.b;
    if (localTroopDiscussionBaseV != null) {
      localTroopDiscussionBaseV.b();
    }
    localTroopDiscussionBaseV = this.c;
    if (localTroopDiscussionBaseV != null) {
      localTroopDiscussionBaseV.b();
    }
    super.d();
  }
  
  public void f() {}
  
  public void g()
  {
    if (this.b == null)
    {
      this.b = new TroopDiscussionTroop(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity);
      this.b.a(null);
    }
    a(this.b);
  }
  
  public void h()
  {
    if (this.c == null)
    {
      this.c = new TroopDiscussionDiscussion(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity);
      this.c.a(null);
    }
    a(this.c);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopDiscussionListInnerFrame
 * JD-Core Version:    0.7.0.1
 */