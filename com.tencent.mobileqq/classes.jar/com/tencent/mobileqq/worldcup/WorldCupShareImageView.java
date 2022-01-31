package com.tencent.mobileqq.worldcup;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;

public class WorldCupShareImageView
  extends ImageView
{
  private Paint a = new Paint();
  
  public WorldCupShareImageView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public WorldCupShareImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    this.a.setShadowLayer(5.0F, 0.0F, 6.0F, 1291845632);
    this.a.setColor(-1);
    setLayerType(1, null);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2 - 11, this.a);
    super.onDraw(paramCanvas);
  }
  
  public void setColor(int paramInt)
  {
    this.a.setColor(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.worldcup.WorldCupShareImageView
 * JD-Core Version:    0.7.0.1
 */