package com.tencent.mobileqq.dinifly;

import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;

public class TextDelegate
{
  @Nullable
  private final DiniFlyAnimationView animationView;
  private boolean cacheText = true;
  @Nullable
  private final LottieDrawable drawable;
  private final Map<String, String> stringMap = new HashMap();
  
  @VisibleForTesting
  TextDelegate()
  {
    this.animationView = null;
    this.drawable = null;
  }
  
  public TextDelegate(DiniFlyAnimationView paramDiniFlyAnimationView)
  {
    this.animationView = paramDiniFlyAnimationView;
    this.drawable = null;
  }
  
  public TextDelegate(LottieDrawable paramLottieDrawable)
  {
    this.drawable = paramLottieDrawable;
    this.animationView = null;
  }
  
  private String getText(String paramString)
  {
    return paramString;
  }
  
  private void invalidate()
  {
    if (this.animationView != null) {
      this.animationView.invalidate();
    }
    if (this.drawable != null) {
      this.drawable.invalidateSelf();
    }
  }
  
  public final String getTextInternal(String paramString)
  {
    Object localObject;
    if ((this.cacheText) && (this.stringMap.containsKey(paramString))) {
      localObject = (String)this.stringMap.get(paramString);
    }
    String str;
    do
    {
      return localObject;
      str = getText(paramString);
      localObject = str;
    } while (!this.cacheText);
    this.stringMap.put(paramString, str);
    return str;
  }
  
  public void invalidateAllText()
  {
    this.stringMap.clear();
    invalidate();
  }
  
  public void invalidateText(String paramString)
  {
    this.stringMap.remove(paramString);
    invalidate();
  }
  
  public void setCacheText(boolean paramBoolean)
  {
    this.cacheText = paramBoolean;
  }
  
  public void setText(String paramString1, String paramString2)
  {
    this.stringMap.put(paramString1, paramString2);
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.TextDelegate
 * JD-Core Version:    0.7.0.1
 */