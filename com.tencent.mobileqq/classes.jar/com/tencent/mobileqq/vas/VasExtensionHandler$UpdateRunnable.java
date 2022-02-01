package com.tencent.mobileqq.vas;

import anil;

class VasExtensionHandler$UpdateRunnable
  implements Runnable
{
  anil jdField_a_of_type_Anil;
  Object jdField_a_of_type_JavaLangObject;
  boolean jdField_a_of_type_Boolean;
  
  public VasExtensionHandler$UpdateRunnable(anil paramanil, boolean paramBoolean, Object paramObject)
  {
    this.jdField_a_of_type_Anil = paramanil;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Anil != null) {
      this.jdField_a_of_type_Anil.onUpdate(0, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasExtensionHandler.UpdateRunnable
 * JD-Core Version:    0.7.0.1
 */