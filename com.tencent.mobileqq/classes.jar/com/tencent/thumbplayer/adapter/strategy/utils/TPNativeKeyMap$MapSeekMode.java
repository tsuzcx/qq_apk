package com.tencent.thumbplayer.adapter.strategy.utils;

import com.tencent.thumbplayer.api.TPCommonEnum.NativeSeekMode;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface TPNativeKeyMap$MapSeekMode
{
  @TPCommonEnum.NativeSeekMode
  int value();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapSeekMode
 * JD-Core Version:    0.7.0.1
 */