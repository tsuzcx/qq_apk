package org.junit.experimental.categories;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Categories$ExcludeCategory
{
  boolean matchAny() default true;
  
  Class<?>[] value() default {};
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     org.junit.experimental.categories.Categories.ExcludeCategory
 * JD-Core Version:    0.7.0.1
 */