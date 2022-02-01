package javax.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.meta.TypeQualifier;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@TypeQualifier(applicableTo=String.class)
public @interface MatchesPattern
{
  int flags() default 0;
  
  @RegEx
  String value();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     javax.annotation.MatchesPattern
 * JD-Core Version:    0.7.0.1
 */