package com.tencent.thumbplayer.adapter.strategy.utils;

import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.TPCommonEnum.NativeSwitchDefMode;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@TPNativeKeyMap.SearchConfig(nativeDefValue=0L, searchClass=ITPPlayer.class, tpDefValue=1L, valueClass=int.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface TPNativeKeyMap$MapSwitchDefMode
{
  @TPCommonEnum.NativeSwitchDefMode
  int value();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapSwitchDefMode
 * JD-Core Version:    0.7.0.1
 */