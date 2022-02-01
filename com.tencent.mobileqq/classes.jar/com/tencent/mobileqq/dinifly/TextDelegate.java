package com.tencent.mobileqq.dinifly;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
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
  
  private void invalidate()
  {
    Object localObject = this.animationView;
    if (localObject != null) {
      ((DiniFlyAnimationView)localObject).invalidate();
    }
    localObject = this.drawable;
    if (localObject != null) {
      ((LottieDrawable)localObject).invalidateSelf();
    }
  }
  
  public String getText(String paramString)
  {
    return paramString;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public final String getTextInternal(String paramString)
  {
    if ((this.cacheText) && (this.stringMap.containsKey(paramString))) {
      return (String)this.stringMap.get(paramString);
    }
    String str = getText(paramString);
    if (this.cacheText) {
      this.stringMap.put(paramString, str);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.TextDelegate
 * JD-Core Version:    0.7.0.1
 */