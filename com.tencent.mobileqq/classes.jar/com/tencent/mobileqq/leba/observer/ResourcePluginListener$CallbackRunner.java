package com.tencent.mobileqq.leba.observer;

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
      QLog.d("ResourcePluginListener", 1, "ResourcePluginListener is null");
    }
    if (localResourcePluginListener != null)
    {
      int i = this.jdField_a_of_type_Int;
      if (i == 2)
      {
        localResourcePluginListener.b(this.jdField_a_of_type_Byte);
        return;
      }
      if (i == 1) {
        localResourcePluginListener.a(this.jdField_a_of_type_Byte);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.observer.ResourcePluginListener.CallbackRunner
 * JD-Core Version:    0.7.0.1
 */