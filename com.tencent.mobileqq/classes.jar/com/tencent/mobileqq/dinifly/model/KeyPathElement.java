package com.tencent.mobileqq.dinifly.model;

import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import com.tencent.mobileqq.dinifly.value.LottieValueCallback;
import java.util.List;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
public abstract interface KeyPathElement
{
  public abstract <T> void addValueCallback(T paramT, @Nullable LottieValueCallback<T> paramLottieValueCallback);
  
  public abstract void resolveKeyPath(KeyPath paramKeyPath1, int paramInt, List<KeyPath> paramList, KeyPath paramKeyPath2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.KeyPathElement
 * JD-Core Version:    0.7.0.1
 */