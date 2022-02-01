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
  protected LayoutInflater a;
  protected AppInterface a;
  protected InnerFrameManager a;
  protected SelectMemberActivity a;
  
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
  
  public abstract ContactSearchFragment a();
  
  public abstract String a();
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity = ((SelectMemberActivity)a());
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager = a();
    if ((a() instanceof AppInterface))
    {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = a();
    }
    else
    {
      paramBundle = MobileQQ.sMobileQQ.waitAppRuntime(null);
      if ((paramBundle instanceof AppInterface)) {
        this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)paramBundle);
      }
    }
    this.jdField_a_of_type_AndroidViewLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getLayoutInflater();
  }
  
  public void a(ResultRecord paramResultRecord, int paramInt) {}
  
  public abstract void f();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.SelectMemberInnerFrame
 * JD-Core Version:    0.7.0.1
 */