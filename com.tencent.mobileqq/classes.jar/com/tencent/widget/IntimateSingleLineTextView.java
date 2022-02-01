package com.tencent.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.tencent.mobileqq.mutualmark.MutualMarkIconProxyDrawable;

public class IntimateSingleLineTextView
  extends SingleLineTextView
{
  public IntimateSingleLineTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public IntimateSingleLineTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IntimateSingleLineTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected Drawable getIconDrawableWithStatus(Context paramContext, SingleLineTextView.IconDrawableInfo paramIconDrawableInfo)
  {
    Object localObject2 = null;
    MutualMarkIconProxyDrawable localMutualMarkIconProxyDrawable = null;
    Object localObject1 = localObject2;
    if (paramContext != null)
    {
      localObject1 = localObject2;
      if (paramIconDrawableInfo != null)
      {
        if (TextUtils.isEmpty(paramIconDrawableInfo.iconDynamicUrl)) {
          break label91;
        }
        localMutualMarkIconProxyDrawable = new MutualMarkIconProxyDrawable(paramContext, paramIconDrawableInfo.iconDynamicUrl, this);
      }
    }
    for (;;)
    {
      localObject1 = localMutualMarkIconProxyDrawable;
      if (localMutualMarkIconProxyDrawable != null)
      {
        localObject1 = localMutualMarkIconProxyDrawable.mutate();
        ((Drawable)localObject1).setAlpha((int)(paramIconDrawableInfo.icon_status_alpha * 255.0F));
        ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
      }
      return localObject1;
      label91:
      if (!TextUtils.isEmpty(paramIconDrawableInfo.icon_static_url)) {
        localMutualMarkIconProxyDrawable = new MutualMarkIconProxyDrawable(paramContext, paramIconDrawableInfo.icon_static_url, this);
      } else if (paramIconDrawableInfo.iconResId != 0) {
        localMutualMarkIconProxyDrawable = new MutualMarkIconProxyDrawable(paramContext, paramIconDrawableInfo.iconResId);
      }
    }
  }
  
  protected boolean isSameDrawable(Drawable paramDrawable, SingleLineTextView.IconDrawable paramIconDrawable)
  {
    return (paramDrawable == paramIconDrawable.mDrawable) || (((paramIconDrawable.mDrawable instanceof MutualMarkIconProxyDrawable)) && (((MutualMarkIconProxyDrawable)paramIconDrawable.mDrawable).a() == paramDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.IntimateSingleLineTextView
 * JD-Core Version:    0.7.0.1
 */