package com.tencent.thumbplayer.adapter.strategy.utils;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.ANNOTATION_TYPE})
@interface TPNativeKeyMap$SearchConfig
{
  long nativeDefValue();
  
  Class<?> searchClass();
  
  long tpDefValue();
  
  Class<? extends Number> valueClass();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.SearchConfig
 * JD-Core Version:    0.7.0.1
 */