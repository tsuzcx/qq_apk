package com.tencent.mobileqq.mutualmark.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.mutualmark.MutualMarkIconProxyDrawable;
import com.tencent.mobileqq.mutualmark.info.MutualMarkForDisplayInfo;

public class MutualMarkIconItemView
  extends ImageView
{
  MutualMarkForDisplayInfo a;
  MutualMarkIconProxyDrawable b;
  
  public MutualMarkIconItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  public MutualMarkIconItemView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MutualMarkIconItemView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a()
  {
    MutualMarkIconProxyDrawable localMutualMarkIconProxyDrawable = this.b;
    if (localMutualMarkIconProxyDrawable != null) {
      localMutualMarkIconProxyDrawable.c();
    }
  }
  
  public void a(String paramString)
  {
    MutualMarkIconProxyDrawable localMutualMarkIconProxyDrawable = this.b;
    if (localMutualMarkIconProxyDrawable != null) {
      localMutualMarkIconProxyDrawable.a(paramString);
    }
  }
  
  public int getMaybeWidth()
  {
    MutualMarkIconProxyDrawable localMutualMarkIconProxyDrawable = this.b;
    if (localMutualMarkIconProxyDrawable != null) {
      return localMutualMarkIconProxyDrawable.getIntrinsicWidth();
    }
    return getMeasuredWidth();
  }
  
  public long getMutualMarkType()
  {
    MutualMarkForDisplayInfo localMutualMarkForDisplayInfo = this.a;
    if (localMutualMarkForDisplayInfo != null) {
      return localMutualMarkForDisplayInfo.a;
    }
    return 0L;
  }
  
  public void setIconAlpha(float paramFloat)
  {
    a();
    setAlpha(paramFloat);
  }
  
  public void setIconResource(MutualMarkForDisplayInfo paramMutualMarkForDisplayInfo)
  {
    if (this.a == paramMutualMarkForDisplayInfo) {
      return;
    }
    this.a = paramMutualMarkForDisplayInfo;
    if (!TextUtils.isEmpty(paramMutualMarkForDisplayInfo.s))
    {
      this.b = new MutualMarkIconProxyDrawable(getContext(), paramMutualMarkForDisplayInfo.s);
      setImageDrawable(this.b);
      return;
    }
    if (paramMutualMarkForDisplayInfo.q != 0)
    {
      this.b = new MutualMarkIconProxyDrawable(getContext(), paramMutualMarkForDisplayInfo.q);
      setImageDrawable(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.view.MutualMarkIconItemView
 * JD-Core Version:    0.7.0.1
 */