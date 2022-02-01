package com.tencent.mobileqq.guild.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.guild.impl.R.styleable;

@RequiresApi(api=21)
public class RadiusFrameLayout
  extends FrameLayout
{
  private RadiusFrameLayout.CanvasRounder a;
  
  public RadiusFrameLayout(@NonNull Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public RadiusFrameLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RadiusFrameLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  public RadiusFrameLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a(paramContext, paramAttributeSet);
  }
  
  private static RadiusFrameLayout.CornersHolder a(TypedArray paramTypedArray)
  {
    float f = paramTypedArray.getDimension(R.styleable.bA, 0.0F);
    return RadiusFrameLayout.CornersHolder.a(paramTypedArray.getDimension(R.styleable.bB, f), paramTypedArray.getDimension(R.styleable.bC, f), paramTypedArray.getDimension(R.styleable.by, f), paramTypedArray.getDimension(R.styleable.bz, f));
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.bx, 0, 0);
    paramAttributeSet = a(paramContext);
    paramContext.recycle();
    this.a = RadiusFrameLayout.CanvasRounder.a(paramAttributeSet);
    setOutlineProvider(RadiusFrameLayout.RoundOutlineProvider.a(paramAttributeSet));
    setClipToOutline(true);
  }
  
  public void a(float paramFloat)
  {
    RadiusFrameLayout.CornersHolder.a(paramFloat);
    this.a.a(paramFloat);
    invalidate();
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    int i = paramCanvas.save();
    this.a.a(paramCanvas);
    super.dispatchDraw(paramCanvas);
    paramCanvas.restoreToCount(i);
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i = paramCanvas.save();
    this.a.a(paramCanvas);
    super.draw(paramCanvas);
    paramCanvas.restoreToCount(i);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.a.a(paramInt1, paramInt2);
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.widget.RadiusFrameLayout
 * JD-Core Version:    0.7.0.1
 */