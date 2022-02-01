package com.tencent.open.agent;

import android.support.v4.app.FragmentActivity;
import anvx;
import aoep;
import aofu;
import bjdi;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Set;

public class JoinTroopPreVerificationFragment
  extends TroopAbilityPreVerificationFragment
{
  private aofu a;
  
  public JoinTroopPreVerificationFragment()
  {
    this.jdField_a_of_type_Aofu = new bjdi(this);
  }
  
  protected void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aofu);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ((aoep)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).b(Integer.valueOf(this.c).intValue(), Integer.valueOf(this.g).intValue());
      return;
    }
    d();
    a(anvx.a(2131705361));
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
  }
  
  protected boolean a(Set<Integer> paramSet)
  {
    if ((paramSet == null) || (paramSet.isEmpty())) {
      return false;
    }
    return paramSet.contains(Integer.valueOf(15));
  }
  
  protected void b()
  {
    super.b();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aofu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.agent.JoinTroopPreVerificationFragment
 * JD-Core Version:    0.7.0.1
 */