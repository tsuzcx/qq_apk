package com.tencent.thumbplayer.adapter.strategy.utils;

import com.tencent.thumbplayer.api.TPCommonEnum.NativeOptionalId;
import com.tencent.thumbplayer.api.TPCommonEnum.OptionalIdType;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface TPNativeKeyMap$MapOptionalId
{
  String keyName();
  
  @TPCommonEnum.OptionalIdType
  int type();
  
  @TPCommonEnum.NativeOptionalId
  int value();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapOptionalId
 * JD-Core Version:    0.7.0.1
 */