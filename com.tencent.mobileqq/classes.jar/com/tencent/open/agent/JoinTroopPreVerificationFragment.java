package com.tencent.open.agent;

import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.TroopHandler;
import java.util.Set;

public class JoinTroopPreVerificationFragment
  extends TroopAbilityPreVerificationFragment
{
  private TroopBusinessObserver a;
  
  public JoinTroopPreVerificationFragment()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver = new JoinTroopPreVerificationFragment.1(this);
  }
  
  protected void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).b(Integer.valueOf(this.c).intValue(), Integer.valueOf(this.g).intValue());
      return;
    }
    d();
    a(HardCodeUtil.a(2131705904));
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.JoinTroopPreVerificationFragment
 * JD-Core Version:    0.7.0.1
 */