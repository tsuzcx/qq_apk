package com.tencent.mobileqq.nearby.profilecard;

import asfc;
import assc;
import java.lang.ref.WeakReference;

public final class InterestGuide$1
  implements Runnable
{
  public void run()
  {
    if (((Boolean)asfc.a(this.jdField_a_of_type_JavaLangString, "interest_guide_key", Boolean.TRUE)).booleanValue())
    {
      assc.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(new assc(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Int));
      assc.jdField_a_of_type_JavaLangBoolean = Boolean.TRUE;
      return;
    }
    assc.jdField_a_of_type_JavaLangBoolean = Boolean.FALSE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.InterestGuide.1
 * JD-Core Version:    0.7.0.1
 */