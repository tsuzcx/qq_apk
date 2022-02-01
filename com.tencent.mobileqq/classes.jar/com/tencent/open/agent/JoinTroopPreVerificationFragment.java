package com.tencent.open.agent;

import android.support.v4.app.FragmentActivity;
import anzj;
import aoip;
import aojs;
import bjmx;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Set;

public class JoinTroopPreVerificationFragment
  extends TroopAbilityPreVerificationFragment
{
  private aojs a;
  
  public JoinTroopPreVerificationFragment()
  {
    this.jdField_a_of_type_Aojs = new bjmx(this);
  }
  
  protected void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aojs);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ((aoip)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).b(Integer.valueOf(this.c).intValue(), Integer.valueOf(this.g).intValue());
      return;
    }
    d();
    a(anzj.a(2131704780));
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aojs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.agent.JoinTroopPreVerificationFragment
 * JD-Core Version:    0.7.0.1
 */