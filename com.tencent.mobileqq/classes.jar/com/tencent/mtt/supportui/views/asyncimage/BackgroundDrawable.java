package com.tencent.mtt.supportui.views.asyncimage;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import com.tencent.mtt.supportui.utils.CommonTool;

public class BackgroundDrawable
  extends Drawable
{
  private int mBackgroundColor;
  private Canvas mBitmapCanvas = null;
  private Paint mBitmapPaint = null;
  private int[] mBorderColorArray;
  private float[] mBorderRadiusArray;
  private int mBorderStyle = 0;
  private float[] mBorderWidthArray;
  private Bitmap mCanvasBitmap = null;
  private DashPathEffect mDashPathEffect = null;
  private DashPathEffect mDotPathEffect = new DashPathEffect(new float[] { 2.0F, 2.0F }, 0.0F);
  private boolean mNeedUpdateBorderPath = false;
  private Paint mPaint = new Paint(1);
  private Path mPathForBorderRadius;
  private Path mPathWithBorder;
  private RectF mTempRectForBorderRadius;
  
  private void drawBG(Canvas paramCanvas)
  {
    if (this.mBackgroundColor != 0)
    {
      this.mPaint.setColor(this.mBackgroundColor);
      this.mPaint.setStyle(Paint.Style.FILL);
      paramCanvas.drawRect(getBounds(), this.mPaint);
    }
    Rect localRect;
    int j;
    int k;
    int m;
    int n;
    int i1;
    label276:
    int i2;
    label322:
    int i3;
    if (CommonTool.hasPositiveItem(this.mBorderWidthArray))
    {
      localRect = getBounds();
      i = Math.round(this.mBorderWidthArray[1]);
      j = i;
      if (i == 0)
      {
        j = i;
        if (this.mBorderWidthArray[0] > 0.0F) {
          j = Math.round(this.mBorderWidthArray[0]);
        }
      }
      i = Math.round(this.mBorderWidthArray[2]);
      k = i;
      if (i == 0)
      {
        k = i;
        if (this.mBorderWidthArray[0] > 0.0F) {
          k = Math.round(this.mBorderWidthArray[0]);
        }
      }
      i = Math.round(this.mBorderWidthArray[3]);
      m = i;
      if (i == 0)
      {
        m = i;
        if (this.mBorderWidthArray[0] > 0.0F) {
          m = Math.round(this.mBorderWidthArray[0]);
        }
      }
      i = Math.round(this.mBorderWidthArray[4]);
      n = i;
      if (i == 0)
      {
        n = i;
        if (this.mBorderWidthArray[0] > 0.0F) {
          n = Math.round(this.mBorderWidthArray[0]);
        }
      }
      if (this.mBorderColorArray != null) {
        break label956;
      }
      i = 0;
      i1 = i;
      if (i == 0)
      {
        i1 = i;
        if (this.mBorderColorArray != null)
        {
          i1 = i;
          if (this.mBorderColorArray[0] != 0) {
            i1 = this.mBorderColorArray[0];
          }
        }
      }
      if (this.mBorderColorArray != null) {
        break label966;
      }
      i = 0;
      i2 = i;
      if (i == 0)
      {
        i2 = i;
        if (this.mBorderColorArray != null)
        {
          i2 = i;
          if (this.mBorderColorArray[0] != 0) {
            i2 = this.mBorderColorArray[0];
          }
        }
      }
      if (this.mBorderColorArray != null) {
        break label976;
      }
      i = 0;
      i3 = i;
      if (i == 0)
      {
        i3 = i;
        if (this.mBorderColorArray != null)
        {
          i3 = i;
          if (this.mBorderColorArray[0] != 0) {
            i3 = this.mBorderColorArray[0];
          }
        }
      }
      if (this.mBorderColorArray != null) {
        break label986;
      }
    }
    label956:
    label966:
    label976:
    label986:
    for (int i = 0;; i = this.mBorderColorArray[4])
    {
      int i4 = i;
      if (i == 0)
      {
        i4 = i;
        if (this.mBorderColorArray != null)
        {
          i4 = i;
          if (this.mBorderColorArray[0] != 0) {
            i4 = this.mBorderColorArray[0];
          }
        }
      }
      i = localRect.top;
      int i5 = localRect.left;
      int i6 = localRect.width();
      int i7 = localRect.height();
      this.mPaint.setAntiAlias(false);
      if (this.mPathWithBorder == null) {
        this.mPathWithBorder = new Path();
      }
      if ((j > 0) && (i1 != 0))
      {
        this.mPaint.setColor(i1);
        this.mPathWithBorder.reset();
        this.mPathWithBorder.moveTo(i5, i);
        this.mPathWithBorder.lineTo(i5 + j, i + k);
        this.mPathWithBorder.lineTo(i5 + j, i + i7 - n);
        this.mPathWithBorder.lineTo(i5, i + i7);
        this.mPathWithBorder.lineTo(i5, i);
        paramCanvas.drawPath(this.mPathWithBorder, this.mPaint);
      }
      if ((k > 0) && (i2 != 0))
      {
        this.mPaint.setColor(i2);
        this.mPathWithBorder.reset();
        this.mPathWithBorder.moveTo(i5, i);
        this.mPathWithBorder.lineTo(i5 + j, i + k);
        this.mPathWithBorder.lineTo(i5 + i6 - m, i + k);
        this.mPathWithBorder.lineTo(i5 + i6, i);
        this.mPathWithBorder.lineTo(i5, i);
        paramCanvas.drawPath(this.mPathWithBorder, this.mPaint);
      }
      if ((m > 0) && (i3 != 0))
      {
        this.mPaint.setColor(i3);
        this.mPathWithBorder.reset();
        this.mPathWithBorder.moveTo(i5 + i6, i);
        this.mPathWithBorder.lineTo(i5 + i6, i + i7);
        this.mPathWithBorder.lineTo(i5 + i6 - m, i + i7 - n);
        this.mPathWithBorder.lineTo(i5 + i6 - m, k + i);
        this.mPathWithBorder.lineTo(i5 + i6, i);
        paramCanvas.drawPath(this.mPathWithBorder, this.mPaint);
      }
      if ((n > 0) && (i4 != 0))
      {
        this.mPaint.setColor(i4);
        this.mPathWithBorder.reset();
        this.mPathWithBorder.moveTo(i5, i + i7);
        this.mPathWithBorder.lineTo(i5 + i6, i + i7);
        this.mPathWithBorder.lineTo(i5 + i6 - m, i + i7 - n);
        this.mPathWithBorder.lineTo(j + i5, i + i7 - n);
        this.mPathWithBorder.lineTo(i5, i + i7);
        paramCanvas.drawPath(this.mPathWithBorder, this.mPaint);
      }
      this.mPaint.setAntiAlias(true);
      return;
      i = this.mBorderColorArray[1];
      break;
      i = this.mBorderColorArray[2];
      break label276;
      i = this.mBorderColorArray[3];
      break label322;
    }
  }
  
  private void drawBGWithRadius(Canvas paramCanvas)
  {
    updatePath();
    if (this.mBackgroundColor != 0)
    {
      this.mPaint.setColor(this.mBackgroundColor);
      this.mPaint.setStyle(Paint.Style.FILL);
      paramCanvas.drawPath(this.mPathForBorderRadius, this.mPaint);
    }
    int i;
    if ((CommonTool.hasPositiveItem(this.mBorderWidthArray)) && (this.mBorderWidthArray[0] > 0.0F) && (this.mBorderColorArray != null))
    {
      if ((this.mBorderColorArray[0] == 0) && ((this.mBorderColorArray[1] != this.mBorderColorArray[2]) || (this.mBorderColorArray[2] != this.mBorderColorArray[3]) || (this.mBorderColorArray[3] != this.mBorderColorArray[4]))) {
        break label198;
      }
      i = this.mBorderColorArray[0];
      if (this.mBorderColorArray[0] == 0) {
        i = this.mBorderColorArray[1];
      }
      if (i != 0) {}
    }
    else
    {
      return;
    }
    this.mPaint.setColor(i);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setStrokeWidth(this.mBorderWidthArray[0]);
    paramCanvas.drawPath(this.mPathForBorderRadius, this.mPaint);
    return;
    label198:
    drawBGWithRadiusWithSingleColor(paramCanvas);
  }
  
  private void drawBGWithRadiusWithSingleColor(Canvas paramCanvas)
  {
    Rect localRect;
    int n;
    int i;
    int j;
    if (CommonTool.hasPositiveItem(this.mBorderWidthArray))
    {
      localRect = getBounds();
      n = Math.round(this.mBorderWidthArray[0]);
      if (this.mBorderColorArray != null) {
        break label1121;
      }
      i = 0;
      j = i;
      if (i == 0)
      {
        j = i;
        if (this.mBorderColorArray != null)
        {
          j = i;
          if (this.mBorderColorArray[0] != 0) {
            j = this.mBorderColorArray[0];
          }
        }
      }
      if (this.mBorderColorArray != null) {
        break label1132;
      }
      i = 0;
      label88:
      if ((i != 0) || (this.mBorderColorArray == null) || (this.mBorderColorArray[0] == 0)) {
        break label1327;
      }
    }
    label166:
    label1320:
    label1327:
    for (int k = this.mBorderColorArray[0];; k = i)
    {
      if (this.mBorderColorArray == null)
      {
        i = 0;
        label127:
        if ((i != 0) || (this.mBorderColorArray == null) || (this.mBorderColorArray[0] == 0)) {
          break label1320;
        }
      }
      for (int m = this.mBorderColorArray[0];; m = i)
      {
        if (this.mBorderColorArray == null)
        {
          i = 0;
          if ((i != 0) || (this.mBorderColorArray == null) || (this.mBorderColorArray[0] == 0)) {
            break label1317;
          }
          i = this.mBorderColorArray[0];
        }
        for (;;)
        {
          float f1 = this.mBorderRadiusArray[1];
          if ((f1 == 0.0F) && (this.mBorderRadiusArray[0] > 0.0F)) {
            f1 = this.mBorderRadiusArray[0];
          }
          for (;;)
          {
            float f2 = this.mBorderRadiusArray[2];
            if ((f2 == 0.0F) && (this.mBorderRadiusArray[0] > 0.0F)) {
              f2 = this.mBorderRadiusArray[0];
            }
            for (;;)
            {
              float f3 = this.mBorderRadiusArray[3];
              if ((f3 == 0.0F) && (this.mBorderRadiusArray[0] > 0.0F)) {
                f3 = this.mBorderRadiusArray[0];
              }
              for (;;)
              {
                float f4 = this.mBorderRadiusArray[4];
                if ((f4 == 0.0F) && (this.mBorderRadiusArray[0] > 0.0F)) {
                  f4 = this.mBorderRadiusArray[0];
                }
                for (;;)
                {
                  int i1 = localRect.top;
                  int i2 = localRect.left;
                  int i3 = localRect.bottom;
                  int i4 = localRect.right;
                  localRect.width();
                  localRect.height();
                  this.mPaint.setAntiAlias(false);
                  this.mPaint.setStrokeWidth(n);
                  this.mPaint.setStyle(Paint.Style.STROKE);
                  if (this.mPathWithBorder == null) {
                    this.mPathWithBorder = new Path();
                  }
                  n /= 2;
                  if (j != 0)
                  {
                    this.mPaint.setColor(j);
                    this.mPathWithBorder.reset();
                    if (Build.VERSION.SDK_INT >= 21)
                    {
                      this.mPathWithBorder.moveTo(i2 + n, i1 + f1);
                      this.mPathWithBorder.lineTo(i2 + n, i3 - f4);
                      this.mPathWithBorder.addArc(i2 + n, i1 + n, i2 + 2.0F * f1 - n, i1 + 2.0F * f1 - n, -180.0F, 45.0F);
                      this.mPathWithBorder.addArc(i2 + n, i3 - 2.0F * f4 + n, i2 + 2.0F * f4 - n, i3 - n, 135.0F, 45.0F);
                      label579:
                      paramCanvas.drawPath(this.mPathWithBorder, this.mPaint);
                    }
                  }
                  else
                  {
                    if (k != 0)
                    {
                      this.mPaint.setColor(k);
                      this.mPathWithBorder.reset();
                      if (Build.VERSION.SDK_INT < 21) {
                        break label1200;
                      }
                      this.mPathWithBorder.moveTo(i2 + f1, i1 + n);
                      this.mPathWithBorder.lineTo(i4 - f2, i1 + n);
                      this.mPathWithBorder.addArc(i2 + n, i1 + n, i2 + 2.0F * f1 - n, i1 + 2.0F * f1 - n, -135.0F, 45.0F);
                      this.mPathWithBorder.addArc(i4 - 2.0F * f2 + n, i1 + n, i4 - n, i1 + 2.0F * f2 - n, -90.0F, 45.0F);
                      label750:
                      paramCanvas.drawPath(this.mPathWithBorder, this.mPaint);
                    }
                    if (m != 0)
                    {
                      this.mPaint.setColor(m);
                      this.mPathWithBorder.reset();
                      if (Build.VERSION.SDK_INT < 21) {
                        break label1235;
                      }
                      this.mPathWithBorder.moveTo(i4 - n, i1 + f2);
                      this.mPathWithBorder.lineTo(i4 - n, i3 - f3);
                      this.mPathWithBorder.addArc(i4 - 2.0F * f3 + n, i3 - 2.0F * f3 + n, i4 - n, i3 - n, 0.0F, 45.0F);
                      this.mPathWithBorder.addArc(i4 - 2.0F * f2 + n, i1 + n, i4 - n, i1 + 2.0F * f2 - n, -45.0F, 45.0F);
                      paramCanvas.drawPath(this.mPathWithBorder, this.mPaint);
                    }
                    if (i != 0)
                    {
                      this.mPaint.setColor(i);
                      this.mPathWithBorder.reset();
                      if (Build.VERSION.SDK_INT < 21) {
                        break label1270;
                      }
                      this.mPathWithBorder.moveTo(i2 + f4, i3 - n);
                      this.mPathWithBorder.lineTo(i4 - f3, i3 - n);
                      this.mPathWithBorder.addArc(i4 - 2.0F * f3 + n, i3 - 2.0F * f3 + n, i4 - n, i3 - n, 45.0F, 45.0F);
                      this.mPathWithBorder.addArc(i2 + n, i3 - 2.0F * f4 + n, i2 + 2.0F * f4 - n, i3 - n, 90.0F, 45.0F);
                    }
                  }
                  for (;;)
                  {
                    paramCanvas.drawPath(this.mPathWithBorder, this.mPaint);
                    this.mPaint.setAntiAlias(true);
                    return;
                    label1121:
                    i = this.mBorderColorArray[1];
                    break;
                    label1132:
                    i = this.mBorderColorArray[2];
                    break label88;
                    i = this.mBorderColorArray[3];
                    break label127;
                    i = this.mBorderColorArray[4];
                    break label166;
                    this.mPathWithBorder.moveTo(i2 + n, i1);
                    this.mPathWithBorder.lineTo(i2 + n, i3);
                    break label579;
                    label1200:
                    this.mPathWithBorder.moveTo(i2, i1 + n);
                    this.mPathWithBorder.lineTo(i4, i1 + n);
                    break label750;
                    label1235:
                    this.mPathWithBorder.moveTo(i4 - n, i1);
                    this.mPathWithBorder.lineTo(i4 - n, i3);
                    break label923;
                    label1270:
                    this.mPathWithBorder.moveTo(i2, i3 - n);
                    this.mPathWithBorder.lineTo(i4, i3 - n);
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  private void updatePath()
  {
    if (!this.mNeedUpdateBorderPath) {
      return;
    }
    this.mNeedUpdateBorderPath = false;
    if (this.mPathForBorderRadius == null)
    {
      this.mPathForBorderRadius = new Path();
      this.mTempRectForBorderRadius = new RectF();
    }
    this.mPathForBorderRadius.reset();
    this.mTempRectForBorderRadius.set(getBounds());
    if (this.mBorderWidthArray == null) {}
    for (float f1 = 0.0F;; f1 = this.mBorderWidthArray[0])
    {
      if (f1 > 1.0F) {
        this.mTempRectForBorderRadius.inset(f1 * 0.5F, f1 * 0.5F);
      }
      float f2 = this.mBorderRadiusArray[1];
      f1 = f2;
      if (f2 == 0.0F)
      {
        f1 = f2;
        if (this.mBorderRadiusArray[0] > 0.0F) {
          f1 = this.mBorderRadiusArray[0];
        }
      }
      float f3 = this.mBorderRadiusArray[2];
      f2 = f3;
      if (f3 == 0.0F)
      {
        f2 = f3;
        if (this.mBorderRadiusArray[0] > 0.0F) {
          f2 = this.mBorderRadiusArray[0];
        }
      }
      float f4 = this.mBorderRadiusArray[3];
      f3 = f4;
      if (f4 == 0.0F)
      {
        f3 = f4;
        if (this.mBorderRadiusArray[0] > 0.0F) {
          f3 = this.mBorderRadiusArray[0];
        }
      }
      float f5 = this.mBorderRadiusArray[4];
      f4 = f5;
      if (f5 == 0.0F)
      {
        f4 = f5;
        if (this.mBorderRadiusArray[0] > 0.0F) {
          f4 = this.mBorderRadiusArray[0];
        }
      }
      Path localPath = this.mPathForBorderRadius;
      RectF localRectF = this.mTempRectForBorderRadius;
      Path.Direction localDirection = Path.Direction.CW;
      localPath.addRoundRect(localRectF, new float[] { f1, f1, f2, f2, f3, f3, f4, f4 }, localDirection);
      return;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    if ((paramCanvas.getWidth() == 0) || (paramCanvas.getHeight() == 0)) {
      return;
    }
    boolean bool = CommonTool.hasPositiveItem(this.mBorderRadiusArray);
    if ((this.mBorderStyle == 1) && (2.0F > 0.0F))
    {
      if (this.mDashPathEffect == null) {
        this.mDashPathEffect = new DashPathEffect(new float[] { 4.0F * 2.0F, 2.0F * 2.0F }, 0.0F);
      }
      this.mPaint.setPathEffect(this.mDashPathEffect);
    }
    for (;;)
    {
      int i;
      int j;
      if ((Build.VERSION.SDK_INT < 21) && (CommonTool.hasPositiveItem(this.mBorderWidthArray)))
      {
        i = paramCanvas.getWidth();
        j = paramCanvas.getHeight();
        if (this.mCanvasBitmap != null) {}
      }
      try
      {
        this.mCanvasBitmap = generateBitmap(paramCanvas.getWidth(), paramCanvas.getHeight());
        this.mBitmapCanvas = new Canvas(this.mCanvasBitmap);
        this.mBitmapPaint = new Paint();
        if ((i != this.mCanvasBitmap.getWidth()) || (j != this.mCanvasBitmap.getHeight())) {}
        try
        {
          this.mCanvasBitmap = generateBitmap(paramCanvas.getWidth(), paramCanvas.getHeight());
          this.mBitmapCanvas = new Canvas(this.mCanvasBitmap);
          this.mBitmapCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
          if (!bool) {
            drawBG(this.mBitmapCanvas);
          }
          for (;;)
          {
            paramCanvas.drawBitmap(this.mCanvasBitmap, 0.0F, 0.0F, this.mBitmapPaint);
            return;
            if ((this.mBorderStyle == 2) && (2.0F > 0.0F))
            {
              if (this.mDotPathEffect == null) {
                this.mDotPathEffect = new DashPathEffect(new float[] { 2.0F * 2.0F, 2.0F * 2.0F }, 0.0F);
              }
              this.mPaint.setPathEffect(this.mDotPathEffect);
              break;
            }
            this.mPaint.setPathEffect(null);
            break;
            drawBGWithRadius(this.mBitmapCanvas);
          }
          if (!bool)
          {
            drawBG(paramCanvas);
            return;
          }
          drawBGWithRadius(paramCanvas);
          return;
        }
        catch (NullPointerException paramCanvas) {}catch (OutOfMemoryError paramCanvas) {}
        return;
      }
      catch (NullPointerException paramCanvas)
      {
        return;
      }
      catch (OutOfMemoryError paramCanvas) {}
    }
  }
  
  public Bitmap generateBitmap(int paramInt1, int paramInt2)
  {
    return Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
  }
  
  public float[] getBorderRadiusArray()
  {
    return this.mBorderRadiusArray;
  }
  
  public float[] getBorderWidthArray()
  {
    return this.mBorderWidthArray;
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.mNeedUpdateBorderPath = true;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setBackgroundColor(int paramInt)
  {
    this.mBackgroundColor = paramInt;
    invalidateSelf();
  }
  
  public void setBorderColor(int paramInt1, int paramInt2)
  {
    if (this.mBorderColorArray == null) {
      this.mBorderColorArray = new int[5];
    }
    this.mBorderColorArray[paramInt2] = paramInt1;
    invalidateSelf();
  }
  
  public void setBorderRadius(float paramFloat, int paramInt)
  {
    if (this.mBorderRadiusArray == null) {
      this.mBorderRadiusArray = new float[5];
    }
    this.mBorderRadiusArray[paramInt] = paramFloat;
    this.mNeedUpdateBorderPath = true;
    invalidateSelf();
  }
  
  public void setBorderStyle(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 2)) {}
    for (this.mBorderStyle = 0;; this.mBorderStyle = paramInt)
    {
      invalidateSelf();
      return;
    }
  }
  
  public void setBorderWidth(float paramFloat, int paramInt)
  {
    if (this.mBorderWidthArray == null) {
      this.mBorderWidthArray = new float[5];
    }
    this.mBorderWidthArray[paramInt] = paramFloat;
    this.mNeedUpdateBorderPath = true;
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.asyncimage.BackgroundDrawable
 * JD-Core Version:    0.7.0.1
 */