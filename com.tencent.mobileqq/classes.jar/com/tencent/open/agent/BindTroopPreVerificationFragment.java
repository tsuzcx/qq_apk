package com.tencent.open.agent;

import adpn;
import alud;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
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
      adpn.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localIntent, PublicFragmentActivity.class, BindGroupFragment.class);
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
      return;
    }
    a(alud.a(2131701522));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.BindTroopPreVerificationFragment
 * JD-Core Version:    0.7.0.1
 */