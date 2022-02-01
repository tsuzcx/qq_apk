package org.junit.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.junit.runners.model.TestClass;

public final class AnnotationsValidator
  implements TestClassValidator
{
  private static final List<AnnotationsValidator.AnnotatableValidator<?>> VALIDATORS = Arrays.asList(new AnnotationsValidator.AnnotatableValidator[] { new AnnotationsValidator.ClassValidator(null), new AnnotationsValidator.MethodValidator(null), new AnnotationsValidator.FieldValidator(null) });
  
  public List<Exception> validateTestClass(TestClass paramTestClass)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = VALIDATORS.iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll(((AnnotationsValidator.AnnotatableValidator)localIterator.next()).validateTestClass(paramTestClass));
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.junit.validator.AnnotationsValidator
 * JD-Core Version:    0.7.0.1
 */