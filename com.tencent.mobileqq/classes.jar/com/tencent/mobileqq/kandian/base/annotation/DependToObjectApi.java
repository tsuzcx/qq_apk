package com.tencent.mobileqq.kandian.base.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Inherited
@Retention(RetentionPolicy.SOURCE)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface DependToObjectApi {}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.annotation.DependToObjectApi
 * JD-Core Version:    0.7.0.1
 */