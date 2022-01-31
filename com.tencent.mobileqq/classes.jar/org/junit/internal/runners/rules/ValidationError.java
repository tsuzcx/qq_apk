package org.junit.internal.runners.rules;

import java.lang.annotation.Annotation;
import org.junit.runners.model.FrameworkMember;

class ValidationError
  extends Exception
{
  public ValidationError(FrameworkMember<?> paramFrameworkMember, Class<? extends Annotation> paramClass, String paramString)
  {
    super(String.format("The @%s '%s' %s", new Object[] { paramClass.getSimpleName(), paramFrameworkMember.getName(), paramString }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     org.junit.internal.runners.rules.ValidationError
 * JD-Core Version:    0.7.0.1
 */