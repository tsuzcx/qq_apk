package com.tencent.mobileqq.config;

public class ResourcePluginListener$CallbackRunner
  implements Runnable
{
  private byte jdField_a_of_type_Byte;
  private int jdField_a_of_type_Int;
  private ResourcePluginListener jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener;
  
  public ResourcePluginListener$CallbackRunner(ResourcePluginListener paramResourcePluginListener, byte paramByte, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener = paramResourcePluginListener;
    this.jdField_a_of_type_Byte = paramByte;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener != null)
    {
      if (this.jdField_a_of_type_Int != 2) {
        break label27;
      }
      this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener.b(this.jdField_a_of_type_Byte);
    }
    label27:
    while (this.jdField_a_of_type_Int != 1) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener.a(this.jdField_a_of_type_Byte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.ResourcePluginListener.CallbackRunner
 * JD-Core Version:    0.7.0.1
 */