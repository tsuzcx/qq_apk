package com.tencent.mobileqq.qqemoticon.api.impl;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.qqemoticon.api.ISysEmoApi;
import com.tencent.mobileqq.text.TextUtils;

public class SysEmoApiImpl
  implements ISysEmoApi
{
  public Drawable getEmoDrawable(int paramInt1, int paramInt2)
  {
    Drawable localDrawable = null;
    if (paramInt1 == 1) {
      localDrawable = QQSysFaceUtil.getFaceDrawable(paramInt2);
    }
    while (paramInt1 != 2) {
      return localDrawable;
    }
    return QQEmojiUtil.getEmojiDrawable(paramInt2);
  }
  
  public Drawable getEmoDrawableFromEMCode(String paramString)
  {
    Object localObject = null;
    int i = QQSysFaceUtil.getLocalIdFromEMCode(paramString);
    if (i != -1) {
      paramString = QQSysFaceUtil.getFaceDrawable(i);
    }
    do
    {
      return paramString;
      i = QQEmojiUtil.getLocalIdFromEMCode(paramString);
      paramString = localObject;
    } while (i == -1);
    return QQEmojiUtil.getEmojiDrawable(i);
  }
  
  public String getEmoString(int paramInt1, int paramInt2)
  {
    String str = null;
    if (paramInt1 == 1) {
      str = QQSysFaceUtil.getFaceString(paramInt2);
    }
    while (paramInt1 != 2) {
      return str;
    }
    return TextUtils.getEmojiString(paramInt2);
  }
  
  public Drawable getEmojiDrawable(int paramInt)
  {
    return QQEmojiUtil.getEmojiDrawable(paramInt);
  }
  
  public Drawable getSysFaceDrawable(int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return QQSysFaceUtil.getFaceDrawable(paramInt);
    }
    return QQSysFaceUtil.getFaceGifDrawable(paramInt);
  }
  
  public boolean isSysFaceStatic(int paramInt)
  {
    return QQSysFaceUtil.isStaticFace(paramInt);
  }
  
  public boolean isSysFaceValid(int paramInt)
  {
    return QQSysFaceUtil.isValidFaceId(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qqemoticon.api.impl.SysEmoApiImpl
 * JD-Core Version:    0.7.0.1
 */