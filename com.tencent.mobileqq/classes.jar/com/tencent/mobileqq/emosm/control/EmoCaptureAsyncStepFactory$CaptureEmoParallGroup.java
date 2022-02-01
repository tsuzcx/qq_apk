package com.tencent.mobileqq.emosm.control;

public class EmoCaptureAsyncStepFactory$CaptureEmoParallGroup
  extends EmoParallGroup
{
  public EmoAsyncStep a()
  {
    if (this.e < this.jdField_a_of_type_ArrayOfJavaLangString.length)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqEmosmControlEmoAsyncStep[this.e] = EmoCaptureAsyncStepFactory.a(this.jdField_a_of_type_ComTencentMobileqqEmosmControlEmoAutomator, this.jdField_a_of_type_ArrayOfJavaLangString[this.e]);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqEmosmControlEmoAsyncStep[this.e].jdField_a_of_type_ArrayOfJavaLangObject = this.jdField_a_of_type_ArrayOfJavaLangObject;
      EmoAsyncStep[] arrayOfEmoAsyncStep = this.jdField_a_of_type_ArrayOfComTencentMobileqqEmosmControlEmoAsyncStep;
      int i = this.e;
      this.e = (i + 1);
      return arrayOfEmoAsyncStep[i];
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.control.EmoCaptureAsyncStepFactory.CaptureEmoParallGroup
 * JD-Core Version:    0.7.0.1
 */