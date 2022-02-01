package com.tencent.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.onlinestatus.R.styleable;
import com.tencent.mobileqq.utils.ViewUtils;

public class OnlineStatusCircleView
  extends LinearLayout
{
  private ImageView a;
  
  public OnlineStatusCircleView(Context paramContext, int paramInt)
  {
    this(paramContext, null, paramInt);
  }
  
  public OnlineStatusCircleView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0.0F);
  }
  
  public OnlineStatusCircleView(Context paramContext, @Nullable AttributeSet paramAttributeSet, float paramFloat)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet, paramFloat);
  }
  
  public OnlineStatusCircleView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(Context paramContext, @Nullable AttributeSet paramAttributeSet, float paramFloat)
  {
    if (paramAttributeSet != null)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.aC);
      paramFloat = paramAttributeSet.getInt(R.styleable.aD, 16);
      paramAttributeSet.recycle();
    }
    float f = paramFloat;
    if (paramFloat == 0.0F) {
      f = 16.0F;
    }
    this.a = new ImageView(paramContext);
    paramContext = new LinearLayout.LayoutParams(ViewUtils.dip2px(f), ViewUtils.dip2px(f));
    setGravity(17);
    addView(this.a, paramContext);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    Drawable localDrawable = getBackground();
    Object localObject = localDrawable;
    if (localDrawable == null) {
      localObject = getContext().getResources().getDrawable(2130847811);
    }
    if ((localObject instanceof GradientDrawable))
    {
      localObject = (GradientDrawable)localObject;
      ((GradientDrawable)localObject).setColor(paramInt);
      setBackgroundDrawable((Drawable)localObject);
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    ImageView localImageView = this.a;
    if (localImageView != null) {
      localImageView.setImageDrawable(paramDrawable);
    }
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    this.a.setScaleType(paramScaleType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.OnlineStatusCircleView
 * JD-Core Version:    0.7.0.1
 */