package com.tencent.open.agent;

import aevv;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import anni;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
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
      aevv.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localIntent, PublicFragmentActivity.class, BindGroupFragment.class);
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
      return;
    }
    a(anni.a(2131699946));
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
  }
  
  protected boolean a(Set<Integer> paramSet)
  {
    if ((paramSet == null) || (paramSet.isEmpty())) {
      return false;
    }
    return paramSet.contains(jdField_a_of_type_JavaLangInteger);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.agent.BindTroopPreVerificationFragment
 * JD-Core Version:    0.7.0.1
 */