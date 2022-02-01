package com.tencent.pts.utils;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.os.Build.VERSION;
import android.view.View;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.ui.PTSNodeStyle;

public final class PTSViewDecorationUtil$RoundedCorner
{
  private Paint borderPaint;
  private float[] borderRadii = new float[4];
  private float borderWidth = 0.0F;
  private boolean hasSetOutline = false;
  private Paint paint;
  private Path path;
  private float[] radii = new float[8];
  private RectF rectF;
  private View view;
  private Xfermode xfermode;
  
  public PTSViewDecorationUtil$RoundedCorner(View paramView)
  {
    this.view = paramView;
    init();
  }
  
  private boolean hasRoundedCorner()
  {
    boolean bool2 = false;
    float[] arrayOfFloat = this.radii;
    int j = arrayOfFloat.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfFloat[i] > 0.0F) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private boolean hasSameCorner()
  {
    float f = this.radii[0];
    float[] arrayOfFloat = this.radii;
    int j = arrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      if (Float.compare(arrayOfFloat[i], f) != 0) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private void init()
  {
    this.path = new Path();
    this.rectF = new RectF();
    this.paint = new Paint(5);
    this.xfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    this.borderPaint = new Paint(1);
    this.borderPaint.setStyle(Paint.Style.STROKE);
  }
  
  private boolean shouldClipPath()
  {
    return (hasRoundedCorner()) && (!this.hasSetOutline) && (Build.VERSION.SDK_INT >= 28);
  }
  
  public void clipPath(Canvas paramCanvas)
  {
    if (shouldClipPath())
    {
      this.path.reset();
      View localView = this.view;
      this.rectF.set(0.0F, 0.0F, localView.getWidth(), localView.getHeight());
      this.path.addRoundRect(this.rectF, this.radii, Path.Direction.CW);
      paramCanvas.clipPath(this.path);
    }
  }
  
  public void drawBorder(Canvas paramCanvas)
  {
    if ((this.borderWidth <= 0.0F) || (paramCanvas == null) || (this.view == null)) {
      return;
    }
    int i = this.view.getWidth();
    int j = this.view.getHeight();
    PTSViewDecorationUtil.drawBorderImp(paramCanvas, this.borderPaint, i, j, this.borderWidth, this.borderRadii[0], this.borderRadii[1], this.borderRadii[2], this.borderRadii[3]);
  }
  
  public void drawCorner(Canvas paramCanvas, int paramInt)
  {
    if ((!hasRoundedCorner()) || (this.hasSetOutline) || (shouldClipPath())) {
      return;
    }
    this.path.reset();
    View localView = this.view;
    this.rectF.set(0.0F, 0.0F, localView.getWidth(), localView.getHeight());
    this.path.addRoundRect(this.rectF, this.radii, Path.Direction.CW);
    this.paint.setXfermode(this.xfermode);
    paramCanvas.drawPath(this.path, this.paint);
    this.paint.setXfermode(null);
    paramCanvas.restoreToCount(paramInt);
  }
  
  public int getSaveCount(Canvas paramCanvas)
  {
    if ((!hasRoundedCorner()) || (this.hasSetOutline) || (shouldClipPath())) {
      return -1;
    }
    return paramCanvas.saveLayer(null, null, 31);
  }
  
  public void onBindNodeInfo(PTSNodeInfo paramPTSNodeInfo)
  {
    if (paramPTSNodeInfo == null) {}
    do
    {
      return;
      paramPTSNodeInfo = paramPTSNodeInfo.getStyle();
      this.borderRadii = paramPTSNodeInfo.getBorderRadii();
      int i = 0;
      while (i < 4)
      {
        this.radii[(i * 2)] = this.borderRadii[i];
        this.radii[(i * 2 + 1)] = this.borderRadii[i];
        i += 1;
      }
      View localView = this.view;
      if ((hasRoundedCorner()) && (hasSameCorner()) && (Build.VERSION.SDK_INT >= 21))
      {
        localView.setOutlineProvider(new PTSViewDecorationUtil.RoundedCorner.1(this));
        localView.setClipToOutline(true);
        this.hasSetOutline = true;
      }
      this.borderWidth = PTSValueConvertUtil.getFloat(paramPTSNodeInfo.get("border-width"));
      paramPTSNodeInfo = PTSValueConvertUtil.getString(paramPTSNodeInfo.get("border-color"));
    } while (this.borderWidth <= 0.0F);
    this.borderPaint.setStrokeWidth(this.borderWidth);
    this.borderPaint.setColor(PTSValueConvertUtil.getColor(paramPTSNodeInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pts.utils.PTSViewDecorationUtil.RoundedCorner
 * JD-Core Version:    0.7.0.1
 */