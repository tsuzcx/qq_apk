package org.junit.validator;

import java.util.concurrent.ConcurrentHashMap;

public class AnnotationValidatorFactory
{
  private static final ConcurrentHashMap<ValidateWith, AnnotationValidator> VALIDATORS_FOR_ANNOTATION_TYPES = new ConcurrentHashMap();
  
  public AnnotationValidator createAnnotationValidator(ValidateWith paramValidateWith)
  {
    Object localObject1 = (AnnotationValidator)VALIDATORS_FOR_ANNOTATION_TYPES.get(paramValidateWith);
    if (localObject1 != null) {
      return localObject1;
    }
    localObject1 = paramValidateWith.value();
    if (localObject1 != null) {
      try
      {
        localObject2 = (AnnotationValidator)((Class)localObject1).newInstance();
        VALIDATORS_FOR_ANNOTATION_TYPES.putIfAbsent(paramValidateWith, localObject2);
        paramValidateWith = (AnnotationValidator)VALIDATORS_FOR_ANNOTATION_TYPES.get(paramValidateWith);
        return paramValidateWith;
      }
      catch (Exception paramValidateWith)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Exception received when creating AnnotationValidator class ");
        ((StringBuilder)localObject2).append(((Class)localObject1).getName());
        throw new RuntimeException(((StringBuilder)localObject2).toString(), paramValidateWith);
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Can't create validator, value is null in annotation ");
    ((StringBuilder)localObject1).append(paramValidateWith.getClass().getName());
    throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.junit.validator.AnnotationValidatorFactory
 * JD-Core Version:    0.7.0.1
 */