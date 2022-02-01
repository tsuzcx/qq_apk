package org.aspectj.lang.annotation.control;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface CodeGenerationHint
{
  String ifNameSuffix() default "";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.lang.annotation.control.CodeGenerationHint
 * JD-Core Version:    0.7.0.1
 */