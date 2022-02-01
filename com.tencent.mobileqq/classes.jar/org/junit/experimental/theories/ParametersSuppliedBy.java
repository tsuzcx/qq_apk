package org.junit.experimental.theories;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.ANNOTATION_TYPE, java.lang.annotation.ElementType.PARAMETER})
public @interface ParametersSuppliedBy
{
  Class<? extends ParameterSupplier> value();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.junit.experimental.theories.ParametersSuppliedBy
 * JD-Core Version:    0.7.0.1
 */