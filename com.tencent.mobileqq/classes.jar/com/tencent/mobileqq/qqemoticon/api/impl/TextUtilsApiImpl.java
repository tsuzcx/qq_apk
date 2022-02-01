package com.tencent.mobileqq.qqemoticon.api.impl;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qqemoticon.api.ITextUtilsApi;
import com.tencent.mobileqq.text.TextUtils;

public class TextUtilsApiImpl
  implements ITextUtilsApi
{
  public String emoticonToTextForTalkBack(String paramString)
  {
    return TextUtils.emoticonToTextForTalkBack(paramString);
  }
  
  public Drawable getResourceDrawableThroughImageCache(Resources paramResources, int paramInt)
  {
    return TextUtils.getResourceDrawableThroughImageCache(paramResources, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqemoticon.api.impl.TextUtilsApiImpl
 * JD-Core Version:    0.7.0.1
 */