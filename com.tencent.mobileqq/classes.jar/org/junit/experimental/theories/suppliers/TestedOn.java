package org.junit.experimental.theories.suppliers;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.experimental.theories.ParametersSuppliedBy;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.PARAMETER})
@ParametersSuppliedBy(TestedOnSupplier.class)
public @interface TestedOn
{
  int[] ints();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     org.junit.experimental.theories.suppliers.TestedOn
 * JD-Core Version:    0.7.0.1
 */