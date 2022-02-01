package com.tencent.thumbplayer.adapter.strategy.utils;

import com.tencent.thumbplayer.api.TPCommonEnum.NativeConnectionConfig;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface TPNativeKeyMap$MapConnectionConfig
{
  @TPCommonEnum.NativeConnectionConfig
  int value();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapConnectionConfig
 * JD-Core Version:    0.7.0.1
 */