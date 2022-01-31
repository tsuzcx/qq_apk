package com.tencent.pts.utils;

import android.graphics.Canvas;
import android.graphics.Paint;
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
import com.tencent.pts.ui.vnode.PTSNodeVirtual;

public final class PTSViewDecorationUtil$RoundedCorner
{
  private boolean hasSetOutline = false;
  private PTSNodeVirtual nodeVirtual;
  private Paint paint;
  private Path path;
  private float[] radii = new float[8];
  private RectF rectF;
  private Xfermode xfermode;
  
  public PTSViewDecorationUtil$RoundedCorner(PTSNodeVirtual paramPTSNodeVirtual)
  {
    this.nodeVirtual = paramPTSNodeVirtual;
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
      View localView = this.nodeVirtual.getView();
      this.rectF.set(0.0F, 0.0F, localView.getWidth(), localView.getHeight());
      this.path.addRoundRect(this.rectF, this.radii, Path.Direction.CW);
      paramCanvas.clipPath(this.path);
    }
  }
  
  public void drawCorner(Canvas paramCanvas, int paramInt)
  {
    if ((!hasRoundedCorner()) || (this.hasSetOutline) || (shouldClipPath())) {
      return;
    }
    this.path.reset();
    View localView = this.nodeVirtual.getView();
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
      paramPTSNodeInfo = paramPTSNodeInfo.getStyle().getBorderRadii();
      int i = 0;
      while (i < 4)
      {
        this.radii[(i * 2)] = paramPTSNodeInfo[i];
        this.radii[(i * 2 + 1)] = paramPTSNodeInfo[i];
        i += 1;
      }
      paramPTSNodeInfo = this.nodeVirtual.getView();
    } while ((!hasRoundedCorner()) || (!hasSameCorner()) || (Build.VERSION.SDK_INT < 21));
    paramPTSNodeInfo.setOutlineProvider(new PTSViewDecorationUtil.RoundedCorner.1(this));
    paramPTSNodeInfo.setClipToOutline(true);
    this.hasSetOutline = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pts.utils.PTSViewDecorationUtil.RoundedCorner
 * JD-Core Version:    0.7.0.1
 */