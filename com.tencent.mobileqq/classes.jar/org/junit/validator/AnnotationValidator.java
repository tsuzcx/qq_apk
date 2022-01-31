package org.junit.validator;

import java.util.Collections;
import java.util.List;
import org.junit.runners.model.FrameworkField;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.TestClass;

public abstract class AnnotationValidator
{
  private static final List<Exception> NO_VALIDATION_ERRORS = ;
  
  public List<Exception> validateAnnotatedClass(TestClass paramTestClass)
  {
    return NO_VALIDATION_ERRORS;
  }
  
  public List<Exception> validateAnnotatedField(FrameworkField paramFrameworkField)
  {
    return NO_VALIDATION_ERRORS;
  }
  
  public List<Exception> validateAnnotatedMethod(FrameworkMethod paramFrameworkMethod)
  {
    return NO_VALIDATION_ERRORS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     org.junit.validator.AnnotationValidator
 * JD-Core Version:    0.7.0.1
 */