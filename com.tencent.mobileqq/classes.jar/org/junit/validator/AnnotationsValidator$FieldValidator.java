package org.junit.validator;

import java.util.List;
import org.junit.runners.model.FrameworkField;
import org.junit.runners.model.TestClass;

class AnnotationsValidator$FieldValidator
  extends AnnotationsValidator.AnnotatableValidator<FrameworkField>
{
  private AnnotationsValidator$FieldValidator()
  {
    super(null);
  }
  
  Iterable<FrameworkField> getAnnotatablesForTestClass(TestClass paramTestClass)
  {
    return paramTestClass.getAnnotatedFields();
  }
  
  List<Exception> validateAnnotatable(AnnotationValidator paramAnnotationValidator, FrameworkField paramFrameworkField)
  {
    return paramAnnotationValidator.validateAnnotatedField(paramFrameworkField);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.junit.validator.AnnotationsValidator.FieldValidator
 * JD-Core Version:    0.7.0.1
 */