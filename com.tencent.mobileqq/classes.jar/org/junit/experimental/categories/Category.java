package org.junit.experimental.categories;

import java.lang.annotation.Annotation;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.junit.validator.ValidateWith;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@ValidateWith(CategoryValidator.class)
public @interface Category
{
  Class<?>[] value();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     org.junit.experimental.categories.Category
 * JD-Core Version:    0.7.0.1
 */