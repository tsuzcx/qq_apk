package com.tencent.open.agent;

import android.content.Intent;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.util.Set;

public class BindTroopPreVerificationFragment
  extends TroopAbilityPreVerificationFragment
{
  private static final Integer a;
  
  static
  {
    jdField_a_of_type_JavaLangInteger = Integer.valueOf(16);
  }
  
  protected void a(boolean paramBoolean)
  {
    d();
    if (paramBoolean)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_params", this.jdField_a_of_type_AndroidOsBundle);
      PublicFragmentActivity.Launcher.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localIntent, PublicFragmentActivity.class, BindGroupFragment.class);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
      return;
    }
    a(HardCodeUtil.a(2131701358));
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
  }
  
  protected boolean a(Set<Integer> paramSet)
  {
    if ((paramSet != null) && (!paramSet.isEmpty())) {
      return paramSet.contains(jdField_a_of_type_JavaLangInteger);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.BindTroopPreVerificationFragment
 * JD-Core Version:    0.7.0.1
 */