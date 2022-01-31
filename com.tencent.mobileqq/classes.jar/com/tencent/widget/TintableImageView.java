package com.tencent.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R.styleable;

public class TintableImageView
  extends URLImageView
{
  ColorStateList a;
  
  public TintableImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public TintableImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet, 0);
  }
  
  public TintableImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a()
  {
    setColorFilter(this.a.getColorForState(getDrawableState(), 0));
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.TintableImageView, paramInt, 0);
    this.a = paramContext.getColorStateList(0);
    paramContext.recycle();
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if ((this.a != null) && (this.a.isStateful())) {
      a();
    }
  }
  
  public void setColorFilter(ColorStateList paramColorStateList)
  {
    this.a = paramColorStateList;
    super.setColorFilter(paramColorStateList.getColorForState(getDrawableState(), 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.widget.TintableImageView
 * JD-Core Version:    0.7.0.1
 */