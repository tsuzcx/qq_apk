package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.tencent.image.URLImageView;

public class MosaicURLImageView
  extends URLImageView
  implements MosaicEffect.IMosaicEffect
{
  private MosaicEffect a;
  
  public MosaicURLImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public MosaicURLImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MosaicURLImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void draw(Canvas paramCanvas)
  {
    MosaicEffect localMosaicEffect = this.a;
    if (localMosaicEffect != null)
    {
      localMosaicEffect.a(paramCanvas);
      return;
    }
    super.draw(paramCanvas);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    MosaicEffect localMosaicEffect = this.a;
    if (localMosaicEffect != null)
    {
      localMosaicEffect.b(paramCanvas);
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  public void setMosaicEffect(MosaicEffect paramMosaicEffect)
  {
    MosaicEffect localMosaicEffect = this.a;
    if (localMosaicEffect != null) {
      localMosaicEffect.a(null);
    }
    this.a = paramMosaicEffect;
    paramMosaicEffect = this.a;
    if (paramMosaicEffect != null) {
      paramMosaicEffect.a(this);
    }
    invalidate();
  }
  
  public void superDrawMosaic(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
  
  public void superOnDrawMosaic(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.MosaicURLImageView
 * JD-Core Version:    0.7.0.1
 */