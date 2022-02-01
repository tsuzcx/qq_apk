package org.junit.validator;

import java.util.Collections;
import java.util.List;
import org.junit.runners.model.TestClass;

public class PublicClassValidator
  implements TestClassValidator
{
  private static final List<Exception> NO_VALIDATION_ERRORS = ;
  
  public List<Exception> validateTestClass(TestClass paramTestClass)
  {
    if (paramTestClass.isPublic()) {
      return NO_VALIDATION_ERRORS;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("The class ");
    localStringBuilder.append(paramTestClass.getName());
    localStringBuilder.append(" is not public.");
    return Collections.singletonList(new Exception(localStringBuilder.toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.junit.validator.PublicClassValidator
 * JD-Core Version:    0.7.0.1
 */