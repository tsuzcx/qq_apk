package org.junit.validator;

import java.util.List;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.TestClass;

class AnnotationsValidator$MethodValidator
  extends AnnotationsValidator.AnnotatableValidator<FrameworkMethod>
{
  private AnnotationsValidator$MethodValidator()
  {
    super(null);
  }
  
  Iterable<FrameworkMethod> getAnnotatablesForTestClass(TestClass paramTestClass)
  {
    return paramTestClass.getAnnotatedMethods();
  }
  
  List<Exception> validateAnnotatable(AnnotationValidator paramAnnotationValidator, FrameworkMethod paramFrameworkMethod)
  {
    return paramAnnotationValidator.validateAnnotatedMethod(paramFrameworkMethod);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.junit.validator.AnnotationsValidator.MethodValidator
 * JD-Core Version:    0.7.0.1
 */