package com.tencent.thumbplayer.adapter.strategy.utils;

import com.tencent.thumbplayer.api.TPCommonEnum.InnerVideoHevcSeiType;
import com.tencent.thumbplayer.api.TPVideoSeiHevcType;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@TPNativeKeyMap.SearchConfig(nativeDefValue=-1L, searchClass=TPVideoSeiHevcType.class, tpDefValue=-1L, valueClass=int.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface TPNativeKeyMap$MapVideoHevcSeiType
{
  @TPCommonEnum.InnerVideoHevcSeiType
  int value();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapVideoHevcSeiType
 * JD-Core Version:    0.7.0.1
 */