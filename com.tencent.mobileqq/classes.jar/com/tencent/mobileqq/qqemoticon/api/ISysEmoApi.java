package com.tencent.mobileqq.qqemoticon.api;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ISysEmoApi
  extends QRouteApi
{
  public abstract Drawable getEmoDrawable(int paramInt1, int paramInt2);
  
  public abstract Drawable getEmoDrawableFromEMCode(String paramString);
  
  public abstract String getEmoString(int paramInt1, int paramInt2);
  
  public abstract Drawable getEmojiDrawable(int paramInt);
  
  public abstract Drawable getSysFaceDrawable(int paramInt, boolean paramBoolean);
  
  public abstract boolean isSysFaceStatic(int paramInt);
  
  public abstract boolean isSysFaceValid(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqemoticon.api.ISysEmoApi
 * JD-Core Version:    0.7.0.1
 */