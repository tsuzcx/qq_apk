package org.junit.validator;

import java.util.concurrent.ConcurrentHashMap;

public class AnnotationValidatorFactory
{
  private static final ConcurrentHashMap<ValidateWith, AnnotationValidator> VALIDATORS_FOR_ANNOTATION_TYPES = new ConcurrentHashMap();
  
  public AnnotationValidator createAnnotationValidator(ValidateWith paramValidateWith)
  {
    Object localObject = (AnnotationValidator)VALIDATORS_FOR_ANNOTATION_TYPES.get(paramValidateWith);
    if (localObject != null) {
      return localObject;
    }
    localObject = paramValidateWith.value();
    if (localObject == null) {
      throw new IllegalArgumentException("Can't create validator, value is null in annotation " + paramValidateWith.getClass().getName());
    }
    try
    {
      AnnotationValidator localAnnotationValidator = (AnnotationValidator)((Class)localObject).newInstance();
      VALIDATORS_FOR_ANNOTATION_TYPES.putIfAbsent(paramValidateWith, localAnnotationValidator);
      paramValidateWith = (AnnotationValidator)VALIDATORS_FOR_ANNOTATION_TYPES.get(paramValidateWith);
      return paramValidateWith;
    }
    catch (Exception paramValidateWith)
    {
      throw new RuntimeException("Exception received when creating AnnotationValidator class " + ((Class)localObject).getName(), paramValidateWith);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     org.junit.validator.AnnotationValidatorFactory
 * JD-Core Version:    0.7.0.1
 */