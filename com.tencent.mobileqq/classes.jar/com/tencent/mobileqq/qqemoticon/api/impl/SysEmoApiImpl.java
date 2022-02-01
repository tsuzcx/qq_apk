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
    if (paramInt1 == 1) {
      return QQSysFaceUtil.getFaceDrawable(paramInt2);
    }
    if (paramInt1 == 2) {
      return QQEmojiUtil.getEmojiDrawable(paramInt2);
    }
    return null;
  }
  
  public Drawable getEmoDrawableFromEMCode(String paramString)
  {
    int i = QQSysFaceUtil.getLocalIdFromEMCode(paramString);
    if (i != -1) {
      return QQSysFaceUtil.getFaceDrawable(i);
    }
    i = QQEmojiUtil.getLocalIdFromEMCode(paramString);
    if (i != -1) {
      return QQEmojiUtil.getEmojiDrawable(i);
    }
    return null;
  }
  
  public String getEmoString(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      return QQSysFaceUtil.getFaceString(paramInt2);
    }
    if (paramInt1 == 2) {
      return TextUtils.getEmojiString(paramInt2);
    }
    return null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqemoticon.api.impl.SysEmoApiImpl
 * JD-Core Version:    0.7.0.1
 */