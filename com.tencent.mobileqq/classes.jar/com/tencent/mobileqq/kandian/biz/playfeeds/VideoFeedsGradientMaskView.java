package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.R.styleable;

public class VideoFeedsGradientMaskView
  extends View
{
  LinearGradient a;
  private Paint b = new Paint();
  private int c = 1;
  private int d = 0;
  
  public VideoFeedsGradientMaskView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoFeedsGradientMaskView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VideoFeedsGradientMaskView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.VideoFeedsGradientMaskView);
    this.d = paramContext.getInt(0, 0);
    paramContext.recycle();
    this.c = ((int)(getAlpha() * 255.0F));
  }
  
  public int getMaskAlpha()
  {
    return this.c;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    float f;
    Shader.TileMode localTileMode;
    switch (this.d)
    {
    default: 
      break;
    case 11: 
      if (this.a == null) {
        this.a = new LinearGradient(0.0F, 0.0F, getWidth(), 0.0F, 0, -16777216, Shader.TileMode.CLAMP);
      }
      break;
    case 10: 
      if (this.a == null)
      {
        f = getHeight();
        localTileMode = Shader.TileMode.CLAMP;
        this.a = new LinearGradient(0.0F, 0.0F, 0.0F, f, new int[] { 0, -16777216 }, new float[] { 0.0F, 1.0F }, localTileMode);
      }
      break;
    case 9: 
      if (this.a == null)
      {
        this.c = 255;
        f = getHeight();
        localTileMode = Shader.TileMode.CLAMP;
        this.a = new LinearGradient(0.0F, 0.0F, 0.0F, f, new int[] { 1711276032, 0 }, new float[] { 0.0F, 1.0F }, localTileMode);
      }
      break;
    case 8: 
      if (this.a == null)
      {
        this.c = 255;
        f = getHeight();
        localTileMode = Shader.TileMode.CLAMP;
        this.a = new LinearGradient(0.0F, 0.0F, 0.0F, f, new int[] { 0, 855638016 }, new float[] { 0.0F, 1.0F }, localTileMode);
      }
      break;
    case 7: 
      if (this.a == null)
      {
        this.c = 255;
        f = getWidth();
        localTileMode = Shader.TileMode.CLAMP;
        this.a = new LinearGradient(0.0F, 0.0F, f, 0.0F, new int[] { 0, -1728053248 }, new float[] { 0.0F, 1.0F }, localTileMode);
      }
      break;
    case 6: 
      if (this.a == null)
      {
        this.c = 255;
        f = getWidth();
        localTileMode = Shader.TileMode.CLAMP;
        this.a = new LinearGradient(0.0F, 0.0F, f, 0.0F, new int[] { -1728053248, 0 }, new float[] { 0.0F, 1.0F }, localTileMode);
      }
      break;
    case 5: 
      if (this.a == null)
      {
        this.c = 255;
        f = getHeight();
        localTileMode = Shader.TileMode.CLAMP;
        this.a = new LinearGradient(0.0F, 0.0F, 0.0F, f, new int[] { -1728053248, 0 }, new float[] { 0.0F, 1.0F }, localTileMode);
      }
      break;
    case 4: 
      this.c = 255;
      f = getHeight();
      localTileMode = Shader.TileMode.CLAMP;
      this.a = new LinearGradient(0.0F, 0.0F, 0.0F, f, new int[] { 0, 1711276032, -872415232 }, new float[] { 0.0F, 0.6F, 1.0F }, localTileMode);
      break;
    case 3: 
      if (this.a == null)
      {
        this.c = 255;
        f = getHeight();
        localTileMode = Shader.TileMode.CLAMP;
        this.a = new LinearGradient(0.0F, 0.0F, 0.0F, f, new int[] { -872415232, 1711276032, 0 }, new float[] { 0.0F, 0.4F, 1.0F }, localTileMode);
      }
      break;
    case 2: 
      if (this.a == null)
      {
        f = getHeight();
        localTileMode = Shader.TileMode.CLAMP;
        this.a = new LinearGradient(0.0F, 0.0F, 0.0F, f, new int[] { 1118482, -1508830958, -1508830958 }, new float[] { 0.0F, 0.5F, 1.0F }, localTileMode);
      }
      break;
    case 1: 
      if (this.a == null)
      {
        f = getHeight();
        localTileMode = Shader.TileMode.CLAMP;
        this.a = new LinearGradient(0.0F, 0.0F, 0.0F, f, new int[] { -1508830958, -1508830958, 1118482 }, new float[] { 0.0F, 0.5F, 1.0F }, localTileMode);
      }
      break;
    }
    if (this.a != null)
    {
      this.b.setAlpha(this.c);
      this.b.setShader(this.a);
      paramCanvas.drawRect(0.0F, 0.0F, getWidth(), getHeight(), this.b);
    }
  }
  
  public void setMaskAlpha(int paramInt)
  {
    this.c = paramInt;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsGradientMaskView
 * JD-Core Version:    0.7.0.1
 */