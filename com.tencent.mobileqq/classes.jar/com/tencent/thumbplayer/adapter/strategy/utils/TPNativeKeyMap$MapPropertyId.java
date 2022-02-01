package com.tencent.thumbplayer.adapter.strategy.utils;

import com.tencent.thumbplayer.api.TPCommonEnum.NativePropertyId;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface TPNativeKeyMap$MapPropertyId
{
  @TPCommonEnum.NativePropertyId
  int value();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapPropertyId
 * JD-Core Version:    0.7.0.1
 */