package com.tencent.mobileqq.nearby.profilecard;

import axws;
import ayjv;
import java.lang.ref.WeakReference;

public final class InterestGuide$1
  implements Runnable
{
  public void run()
  {
    if (((Boolean)axws.a(this.jdField_a_of_type_JavaLangString, "interest_guide_key", Boolean.TRUE)).booleanValue())
    {
      ayjv.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(new ayjv(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Int));
      ayjv.jdField_a_of_type_JavaLangBoolean = Boolean.TRUE;
      return;
    }
    ayjv.jdField_a_of_type_JavaLangBoolean = Boolean.FALSE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.InterestGuide.1
 * JD-Core Version:    0.7.0.1
 */