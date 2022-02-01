package com.tencent.thumbplayer.adapter.strategy.utils;

import com.tencent.thumbplayer.api.TPCommonEnum.NativeErrorType;
import com.tencent.thumbplayer.api.TPErrorCode;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@TPNativeKeyMap.SearchConfig(nativeDefValue=1001L, searchClass=TPErrorCode.class, tpDefValue=1001L, valueClass=int.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface TPNativeKeyMap$MapErrorType
{
  @TPCommonEnum.NativeErrorType
  int value();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapErrorType
 * JD-Core Version:    0.7.0.1
 */