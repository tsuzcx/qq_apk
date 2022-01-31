package com.tencent.mobileqq.nearby.profilecard;

import atbi;
import atoi;
import java.lang.ref.WeakReference;

public final class InterestGuide$1
  implements Runnable
{
  public void run()
  {
    if (((Boolean)atbi.a(this.jdField_a_of_type_JavaLangString, "interest_guide_key", Boolean.TRUE)).booleanValue())
    {
      atoi.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(new atoi(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Int));
      atoi.jdField_a_of_type_JavaLangBoolean = Boolean.TRUE;
      return;
    }
    atoi.jdField_a_of_type_JavaLangBoolean = Boolean.FALSE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.InterestGuide.1
 * JD-Core Version:    0.7.0.1
 */