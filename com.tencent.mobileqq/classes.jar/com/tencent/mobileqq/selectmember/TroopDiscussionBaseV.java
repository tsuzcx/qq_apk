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
  protected Context a;
  protected LayoutInflater a;
  protected AppInterface a;
  protected InnerFrameManager a;
  protected SelectMemberActivity a;
  
  public TroopDiscussionBaseV(SelectMemberActivity paramSelectMemberActivity)
  {
    super(paramSelectMemberActivity);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)paramSelectMemberActivity.getAppRuntime());
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity = paramSelectMemberActivity;
    this.jdField_a_of_type_AndroidContentContext = paramSelectMemberActivity;
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramSelectMemberActivity.getLayoutInflater();
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager = paramSelectMemberActivity.mInnerFrameManager;
  }
  
  protected void a() {}
  
  protected final void a(int paramInt)
  {
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(paramInt, this, true);
  }
  
  public void a(Bundle paramBundle) {}
  
  protected void b() {}
  
  public void b(Bundle paramBundle) {}
  
  protected void e() {}
  
  protected void f() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopDiscussionBaseV
 * JD-Core Version:    0.7.0.1
 */