package com.tencent.mobileqq.emosm.control;

public class EmoParallGroup
  extends EmoStepGroup
  implements IEmoResultListener
{
  protected int d;
  
  protected int a()
  {
    this.d = this.jdField_a_of_type_ArrayOfJavaLangString.length;
    for (;;)
    {
      EmoAsyncStep localEmoAsyncStep = a();
      if ((localEmoAsyncStep == null) || (this.jdField_a_of_type_Int == 8)) {
        break;
      }
      localEmoAsyncStep.a = this;
      this.jdField_a_of_type_ComTencentMobileqqEmosmControlEmoAutomator.a(localEmoAsyncStep);
    }
    return 2;
  }
  
  public void a(EmoAsyncStep paramEmoAsyncStep, int paramInt)
  {
    try
    {
      paramInt = this.d - 1;
      this.d = paramInt;
      if (paramInt == 0)
      {
        a(7);
        this.jdField_a_of_type_ArrayOfComTencentMobileqqEmosmControlEmoAsyncStep = null;
      }
      this.jdField_a_of_type_ComTencentMobileqqEmosmControlEmoAutomator.a(this.jdField_a_of_type_ArrayOfComTencentMobileqqEmosmControlEmoAsyncStep);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.control.EmoParallGroup
 * JD-Core Version:    0.7.0.1
 */