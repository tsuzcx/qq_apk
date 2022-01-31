package org.junit.validator;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.runners.model.Annotatable;
import org.junit.runners.model.TestClass;

abstract class AnnotationsValidator$AnnotatableValidator<T extends Annotatable>
{
  private static final AnnotationValidatorFactory ANNOTATION_VALIDATOR_FACTORY = new AnnotationValidatorFactory();
  
  private List<Exception> validateAnnotatable(T paramT)
  {
    ArrayList localArrayList = new ArrayList();
    Annotation[] arrayOfAnnotation = paramT.getAnnotations();
    int j = arrayOfAnnotation.length;
    int i = 0;
    while (i < j)
    {
      ValidateWith localValidateWith = (ValidateWith)arrayOfAnnotation[i].annotationType().getAnnotation(ValidateWith.class);
      if (localValidateWith != null) {
        localArrayList.addAll(validateAnnotatable(ANNOTATION_VALIDATOR_FACTORY.createAnnotationValidator(localValidateWith), paramT));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  abstract Iterable<T> getAnnotatablesForTestClass(TestClass paramTestClass);
  
  abstract List<Exception> validateAnnotatable(AnnotationValidator paramAnnotationValidator, T paramT);
  
  public List<Exception> validateTestClass(TestClass paramTestClass)
  {
    ArrayList localArrayList = new ArrayList();
    paramTestClass = getAnnotatablesForTestClass(paramTestClass).iterator();
    while (paramTestClass.hasNext()) {
      localArrayList.addAll(validateAnnotatable((Annotatable)paramTestClass.next()));
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     org.junit.validator.AnnotationsValidator.AnnotatableValidator
 * JD-Core Version:    0.7.0.1
 */