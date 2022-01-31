package org.junit.validator;

import java.util.Collections;
import java.util.List;
import org.junit.runners.model.TestClass;

class AnnotationsValidator$ClassValidator
  extends AnnotationsValidator.AnnotatableValidator<TestClass>
{
  private AnnotationsValidator$ClassValidator()
  {
    super(null);
  }
  
  Iterable<TestClass> getAnnotatablesForTestClass(TestClass paramTestClass)
  {
    return Collections.singletonList(paramTestClass);
  }
  
  List<Exception> validateAnnotatable(AnnotationValidator paramAnnotationValidator, TestClass paramTestClass)
  {
    return paramAnnotationValidator.validateAnnotatedClass(paramTestClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     org.junit.validator.AnnotationsValidator.ClassValidator
 * JD-Core Version:    0.7.0.1
 */