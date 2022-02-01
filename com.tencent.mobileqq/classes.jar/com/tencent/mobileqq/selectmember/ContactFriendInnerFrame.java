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
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  public TroopDiscussionBaseV a;
  private TabBarView jdField_a_of_type_ComTencentMobileqqWidgetTabBarView;
  private TroopDiscussionBaseV b;
  private TroopDiscussionBaseV c;
  
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
  
  private void g()
  {
    if (this.b == null)
    {
      this.b = new PhoneContactTabView(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity, this);
      this.b.a(null);
    }
    a(this.b);
  }
  
  private void h()
  {
    if (this.c == null)
    {
      this.c = new FriendTabView(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity);
      this.c.a(null);
    }
    a(this.c);
  }
  
  public ContactSearchFragment a()
  {
    return null;
  }
  
  public String a()
  {
    return "-1";
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 100) && (paramInt2 == -1)) {
      ((PhoneContactTabView)this.b).d();
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    paramBundle = a();
    setContentView(2131560459);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView = ((TabBarView)findViewById(2131378217));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setOnTabChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0, paramBundle.getString(2131691094));
    RedDotTextView localRedDotTextView = this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131702643));
    localStringBuilder.append(paramBundle.getString(2131691094));
    localRedDotTextView.setContentDescription(localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1, paramBundle.getString(2131691095));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1).setContentDescription(paramBundle.getString(2131691095));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131368866));
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.setupTitleBar(false, this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getString(2131718706), this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mTitleString);
  }
  
  public void d()
  {
    TroopDiscussionBaseV localTroopDiscussionBaseV = this.c;
    if (localTroopDiscussionBaseV != null) {
      localTroopDiscussionBaseV.b();
    }
    localTroopDiscussionBaseV = this.b;
    if (localTroopDiscussionBaseV != null) {
      localTroopDiscussionBaseV.b();
    }
    super.d();
  }
  
  public void f()
  {
    TroopDiscussionBaseV localTroopDiscussionBaseV = this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopDiscussionBaseV;
    if ((localTroopDiscussionBaseV instanceof FriendTabView))
    {
      ((FriendTabView)localTroopDiscussionBaseV).c();
      return;
    }
    if ((localTroopDiscussionBaseV instanceof PhoneContactTabView)) {
      ((PhoneContactTabView)localTroopDiscussionBaseV).c();
    }
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
 * Qualified Name:     com.tencent.mobileqq.selectmember.ContactFriendInnerFrame
 * JD-Core Version:    0.7.0.1
 */