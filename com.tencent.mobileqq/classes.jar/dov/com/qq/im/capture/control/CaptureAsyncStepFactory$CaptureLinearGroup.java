package dov.com.qq.im.capture.control;

import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.LinearGroup;

public class CaptureAsyncStepFactory$CaptureLinearGroup
  extends LinearGroup
{
  public AsyncStep a()
  {
    if (this.e < this.jdField_a_of_type_ArrayOfJavaLangString.length)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqAppAutomatorAsyncStep[this.e] = CaptureAsyncStepFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator, this.jdField_a_of_type_ArrayOfJavaLangString[this.e]);
      this.jdField_a_of_type_ArrayOfComTencentMobileqqAppAutomatorAsyncStep[this.e].jdField_a_of_type_ArrayOfJavaLangObject = this.jdField_a_of_type_ArrayOfJavaLangObject;
      AsyncStep[] arrayOfAsyncStep = this.jdField_a_of_type_ArrayOfComTencentMobileqqAppAutomatorAsyncStep;
      int i = this.e;
      this.e = (i + 1);
      return arrayOfAsyncStep[i];
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.control.CaptureAsyncStepFactory.CaptureLinearGroup
 * JD-Core Version:    0.7.0.1
 */