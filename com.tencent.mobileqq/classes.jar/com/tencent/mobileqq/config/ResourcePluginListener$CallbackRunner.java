package com.tencent.mobileqq.config;

import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;

public class ResourcePluginListener$CallbackRunner
  implements Runnable
{
  private byte jdField_a_of_type_Byte;
  private int jdField_a_of_type_Int;
  private SoftReference<ResourcePluginListener> jdField_a_of_type_JavaLangRefSoftReference;
  
  public ResourcePluginListener$CallbackRunner(ResourcePluginListener paramResourcePluginListener, byte paramByte, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramResourcePluginListener);
    this.jdField_a_of_type_Byte = paramByte;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void run()
  {
    ResourcePluginListener localResourcePluginListener = (ResourcePluginListener)this.jdField_a_of_type_JavaLangRefSoftReference.get();
    if ((localResourcePluginListener == null) && (QLog.isColorLevel())) {
      QLog.d("LebaHelper", 2, "ResourcePluginListener is null");
    }
    if (localResourcePluginListener != null)
    {
      if (this.jdField_a_of_type_Int != 2) {
        break label50;
      }
      localResourcePluginListener.b(this.jdField_a_of_type_Byte);
    }
    label50:
    while (this.jdField_a_of_type_Int != 1) {
      return;
    }
    localResourcePluginListener.a(this.jdField_a_of_type_Byte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.ResourcePluginListener.CallbackRunner
 * JD-Core Version:    0.7.0.1
 */