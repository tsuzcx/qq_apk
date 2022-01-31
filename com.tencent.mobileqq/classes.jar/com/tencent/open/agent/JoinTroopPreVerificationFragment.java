package com.tencent.open.agent;

import alud;
import amdu;
import ameq;
import android.support.v4.app.FragmentActivity;
import bfeu;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Set;

public class JoinTroopPreVerificationFragment
  extends TroopAbilityPreVerificationFragment
{
  private ameq a;
  
  public JoinTroopPreVerificationFragment()
  {
    this.jdField_a_of_type_Ameq = new bfeu(this);
  }
  
  protected void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ameq);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ((amdu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).b(Integer.valueOf(this.c).intValue(), Integer.valueOf(this.g).intValue());
      return;
    }
    d();
    a(alud.a(2131706272));
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ameq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.JoinTroopPreVerificationFragment
 * JD-Core Version:    0.7.0.1
 */