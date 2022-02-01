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
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build.VERSION;
import com.tencent.mtt.supportui.utils.CommonTool;

public class BackgroundDrawable
  extends BaseDrawable
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
  private final Paint mPaint = new Paint(1);
  private Path mPathForBorderRadius;
  private Path mPathWithBorder;
  protected int mShadowColor = -7829368;
  protected float mShadowOpacity = 0.8F;
  private final Paint mShadowPaint = new Paint();
  protected RectF mShadowRect;
  private RectF mTempRectForBorderRadius;
  
  private void drawBG(Canvas paramCanvas)
  {
    int i = this.mBackgroundColor;
    if (i != 0)
    {
      this.mPaint.setColor(i);
      this.mPaint.setStyle(Paint.Style.FILL);
      paramCanvas.drawRect(this.mRect, this.mPaint);
    }
    if (CommonTool.hasPositiveItem(this.mBorderWidthArray))
    {
      Object localObject1 = this.mRect;
      i = Math.round(this.mBorderWidthArray[1]);
      int k = i;
      if (i == 0)
      {
        localObject2 = this.mBorderWidthArray;
        k = i;
        if (localObject2[0] > 0.0F) {
          k = Math.round(localObject2[0]);
        }
      }
      i = Math.round(this.mBorderWidthArray[2]);
      int m = i;
      if (i == 0)
      {
        localObject2 = this.mBorderWidthArray;
        m = i;
        if (localObject2[0] > 0.0F) {
          m = Math.round(localObject2[0]);
        }
      }
      i = Math.round(this.mBorderWidthArray[3]);
      int n = i;
      if (i == 0)
      {
        localObject2 = this.mBorderWidthArray;
        n = i;
        if (localObject2[0] > 0.0F) {
          n = Math.round(localObject2[0]);
        }
      }
      i = Math.round(this.mBorderWidthArray[4]);
      int i1 = i;
      if (i == 0)
      {
        localObject2 = this.mBorderWidthArray;
        i1 = i;
        if (localObject2[0] > 0.0F) {
          i1 = Math.round(localObject2[0]);
        }
      }
      Object localObject2 = this.mBorderColorArray;
      if (localObject2 == null) {
        i = 0;
      } else {
        i = localObject2[1];
      }
      int i2 = i;
      if (i == 0)
      {
        localObject2 = this.mBorderColorArray;
        i2 = i;
        if (localObject2 != null)
        {
          i2 = i;
          if (localObject2[0] != 0) {
            i2 = localObject2[0];
          }
        }
      }
      localObject2 = this.mBorderColorArray;
      if (localObject2 == null) {
        i = 0;
      } else {
        i = localObject2[2];
      }
      int i3 = i;
      if (i == 0)
      {
        localObject2 = this.mBorderColorArray;
        i3 = i;
        if (localObject2 != null)
        {
          i3 = i;
          if (localObject2[0] != 0) {
            i3 = localObject2[0];
          }
        }
      }
      localObject2 = this.mBorderColorArray;
      if (localObject2 == null) {
        i = 0;
      } else {
        i = localObject2[3];
      }
      int i4 = i;
      if (i == 0)
      {
        localObject2 = this.mBorderColorArray;
        i4 = i;
        if (localObject2 != null)
        {
          i4 = i;
          if (localObject2[0] != 0) {
            i4 = localObject2[0];
          }
        }
      }
      localObject2 = this.mBorderColorArray;
      if (localObject2 == null) {
        i = 0;
      } else {
        i = localObject2[4];
      }
      int j = i;
      if (i == 0)
      {
        localObject2 = this.mBorderColorArray;
        j = i;
        if (localObject2 != null)
        {
          j = i;
          if (localObject2[0] != 0) {
            j = localObject2[0];
          }
        }
      }
      float f3 = ((RectF)localObject1).top;
      float f1 = ((RectF)localObject1).left;
      float f2 = ((RectF)localObject1).width();
      float f4 = ((RectF)localObject1).height();
      this.mPaint.setAntiAlias(false);
      if (this.mPathWithBorder == null) {
        this.mPathWithBorder = new Path();
      }
      float f5;
      float f6;
      if ((k > 0) && (i2 != 0))
      {
        this.mPaint.setColor(i2);
        this.mPathWithBorder.reset();
        this.mPathWithBorder.moveTo(f1, f3);
        localObject1 = this.mPathWithBorder;
        f5 = k + f1;
        ((Path)localObject1).lineTo(f5, m + f3);
        localObject1 = this.mPathWithBorder;
        f6 = f3 + f4;
        ((Path)localObject1).lineTo(f5, f6 - i1);
        this.mPathWithBorder.lineTo(f1, f6);
        this.mPathWithBorder.lineTo(f1, f3);
        paramCanvas.drawPath(this.mPathWithBorder, this.mPaint);
      }
      if ((m > 0) && (i3 != 0))
      {
        this.mPaint.setColor(i3);
        this.mPathWithBorder.reset();
        this.mPathWithBorder.moveTo(f1, f3);
        localObject1 = this.mPathWithBorder;
        f6 = k;
        f5 = m + f3;
        ((Path)localObject1).lineTo(f6 + f1, f5);
        localObject1 = this.mPathWithBorder;
        f6 = f1 + f2;
        ((Path)localObject1).lineTo(f6 - n, f5);
        this.mPathWithBorder.lineTo(f6, f3);
        this.mPathWithBorder.lineTo(f1, f3);
        paramCanvas.drawPath(this.mPathWithBorder, this.mPaint);
      }
      if ((n > 0) && (i4 != 0))
      {
        this.mPaint.setColor(i4);
        this.mPathWithBorder.reset();
        localObject1 = this.mPathWithBorder;
        f5 = f1 + f2;
        ((Path)localObject1).moveTo(f5, f3);
        localObject1 = this.mPathWithBorder;
        f6 = f3 + f4;
        ((Path)localObject1).lineTo(f5, f6);
        localObject1 = this.mPathWithBorder;
        float f7 = f5 - n;
        ((Path)localObject1).lineTo(f7, f6 - i1);
        this.mPathWithBorder.lineTo(f7, m + f3);
        this.mPathWithBorder.lineTo(f5, f3);
        paramCanvas.drawPath(this.mPathWithBorder, this.mPaint);
      }
      if ((i1 > 0) && (j != 0))
      {
        this.mPaint.setColor(j);
        this.mPathWithBorder.reset();
        localObject1 = this.mPathWithBorder;
        f3 += f4;
        ((Path)localObject1).moveTo(f1, f3);
        localObject1 = this.mPathWithBorder;
        f2 += f1;
        ((Path)localObject1).lineTo(f2, f3);
        localObject1 = this.mPathWithBorder;
        f4 = n;
        f5 = f3 - i1;
        ((Path)localObject1).lineTo(f2 - f4, f5);
        this.mPathWithBorder.lineTo(k + f1, f5);
        this.mPathWithBorder.lineTo(f1, f3);
        paramCanvas.drawPath(this.mPathWithBorder, this.mPaint);
      }
      this.mPaint.setAntiAlias(true);
    }
  }
  
  private void drawBGShadow(Canvas paramCanvas)
  {
    float f1 = this.mShadowRadius;
    float f2 = 0.0F;
    if (f1 != 0.0F)
    {
      f1 = this.mShadowOpacity;
      if (f1 <= 0.0F) {
        return;
      }
      int i;
      if (f1 >= 1.0F) {
        i = 255;
      } else {
        i = Math.round(f1 * 255.0F);
      }
      float[] arrayOfFloat = this.mBorderRadiusArray;
      f1 = f2;
      if (arrayOfFloat != null)
      {
        f1 = f2;
        if (arrayOfFloat.length > 0)
        {
          int j = 0;
          for (f1 = 0.0F;; f1 = f2)
          {
            arrayOfFloat = this.mBorderRadiusArray;
            if (j >= arrayOfFloat.length) {
              break;
            }
            f2 = f1;
            if (arrayOfFloat[j] > f1) {
              f2 = arrayOfFloat[j];
            }
            j += 1;
          }
        }
      }
      this.mShadowPaint.setColor(0);
      this.mShadowPaint.setAntiAlias(true);
      this.mShadowPaint.setAlpha(i);
      this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mShadowOffsetX, this.mShadowOffsetY, this.mShadowColor);
      this.mShadowPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
      paramCanvas.drawRoundRect(this.mShadowRect, f1, f1, this.mShadowPaint);
    }
  }
  
  private void drawBGWithRadius(Canvas paramCanvas)
  {
    updatePath();
    int i = this.mBackgroundColor;
    if (i != 0)
    {
      this.mPaint.setColor(i);
      this.mPaint.setStyle(Paint.Style.FILL);
      paramCanvas.drawPath(this.mPathForBorderRadius, this.mPaint);
    }
    if ((CommonTool.hasPositiveItem(this.mBorderWidthArray)) && (this.mBorderWidthArray[0] > 0.0F))
    {
      int[] arrayOfInt = this.mBorderColorArray;
      if (arrayOfInt != null)
      {
        if ((arrayOfInt[0] == 0) && ((arrayOfInt[1] != arrayOfInt[2]) || (arrayOfInt[2] != arrayOfInt[3]) || (arrayOfInt[3] != arrayOfInt[4])))
        {
          drawBGWithRadiusWithSingleColor(paramCanvas);
          return;
        }
        arrayOfInt = this.mBorderColorArray;
        i = arrayOfInt[0];
        if (arrayOfInt[0] == 0) {
          i = arrayOfInt[1];
        }
        if (i == 0) {
          return;
        }
        this.mPaint.setColor(i);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.mBorderWidthArray[0]);
        paramCanvas.drawPath(this.mPathForBorderRadius, this.mPaint);
      }
    }
  }
  
  private void drawBGWithRadiusWithSingleColor(Canvas paramCanvas)
  {
    if (CommonTool.hasPositiveItem(this.mBorderWidthArray))
    {
      Object localObject1 = this.mRect;
      int i1 = Math.round(this.mBorderWidthArray[0]);
      Object localObject2 = this.mBorderColorArray;
      if (localObject2 == null) {
        i = 0;
      } else {
        i = localObject2[1];
      }
      int k = i;
      if (i == 0)
      {
        localObject2 = this.mBorderColorArray;
        k = i;
        if (localObject2 != null)
        {
          k = i;
          if (localObject2[0] != 0) {
            k = localObject2[0];
          }
        }
      }
      localObject2 = this.mBorderColorArray;
      if (localObject2 == null) {
        i = 0;
      } else {
        i = localObject2[2];
      }
      int m = i;
      if (i == 0)
      {
        localObject2 = this.mBorderColorArray;
        m = i;
        if (localObject2 != null)
        {
          m = i;
          if (localObject2[0] != 0) {
            m = localObject2[0];
          }
        }
      }
      localObject2 = this.mBorderColorArray;
      if (localObject2 == null) {
        i = 0;
      } else {
        i = localObject2[3];
      }
      int n = i;
      if (i == 0)
      {
        localObject2 = this.mBorderColorArray;
        n = i;
        if (localObject2 != null)
        {
          n = i;
          if (localObject2[0] != 0) {
            n = localObject2[0];
          }
        }
      }
      localObject2 = this.mBorderColorArray;
      if (localObject2 == null) {
        j = 0;
      } else {
        j = localObject2[4];
      }
      int i = j;
      if (j == 0)
      {
        localObject2 = this.mBorderColorArray;
        i = j;
        if (localObject2 != null)
        {
          i = j;
          if (localObject2[0] != 0) {
            i = localObject2[0];
          }
        }
      }
      localObject2 = this.mBorderRadiusArray;
      float f1 = localObject2[1];
      float f4 = f1;
      if (f1 == 0.0F)
      {
        f4 = f1;
        if (localObject2[0] > 0.0F) {
          f4 = localObject2[0];
        }
      }
      localObject2 = this.mBorderRadiusArray;
      f1 = localObject2[2];
      float f3 = f1;
      if (f1 == 0.0F)
      {
        f3 = f1;
        if (localObject2[0] > 0.0F) {
          f3 = localObject2[0];
        }
      }
      localObject2 = this.mBorderRadiusArray;
      float f2 = localObject2[3];
      f1 = f2;
      if (f2 == 0.0F)
      {
        f1 = f2;
        if (localObject2[0] > 0.0F) {
          f1 = localObject2[0];
        }
      }
      localObject2 = this.mBorderRadiusArray;
      float f5 = localObject2[4];
      f2 = f5;
      if (f5 == 0.0F)
      {
        f2 = f5;
        if (localObject2[0] > 0.0F) {
          f2 = localObject2[0];
        }
      }
      float f8 = ((RectF)localObject1).top;
      f5 = ((RectF)localObject1).left;
      float f6 = ((RectF)localObject1).bottom;
      float f7 = ((RectF)localObject1).right;
      ((RectF)localObject1).width();
      ((RectF)localObject1).height();
      this.mPaint.setAntiAlias(false);
      this.mPaint.setStrokeWidth(i1);
      this.mPaint.setStyle(Paint.Style.STROKE);
      if (this.mPathWithBorder == null) {
        this.mPathWithBorder = new Path();
      }
      int j = i1 / 2;
      float f9;
      float f10;
      if (k != 0)
      {
        this.mPaint.setColor(k);
        this.mPathWithBorder.reset();
        if (Build.VERSION.SDK_INT >= 21)
        {
          localObject1 = this.mPathWithBorder;
          f9 = j;
          f10 = f5 + f9;
          ((Path)localObject1).moveTo(f10, f8 + f4);
          this.mPathWithBorder.lineTo(f10, f6 - f2);
          localObject1 = this.mPathWithBorder;
          float f11 = f4 * 2.0F;
          ((Path)localObject1).addArc(f10, f8 + f9, f5 + f11 - f9, f8 + f11 - f9, -180.0F, 45.0F);
          localObject1 = this.mPathWithBorder;
          f11 = f2 * 2.0F;
          ((Path)localObject1).addArc(f10, f6 - f11 + f9, f5 + f11 - f9, f6 - f9, 135.0F, 45.0F);
        }
        else
        {
          localObject1 = this.mPathWithBorder;
          f9 = j + f5;
          ((Path)localObject1).moveTo(f9, f8);
          this.mPathWithBorder.lineTo(f9, f6);
        }
        paramCanvas.drawPath(this.mPathWithBorder, this.mPaint);
      }
      if (m != 0)
      {
        this.mPaint.setColor(m);
        this.mPathWithBorder.reset();
        if (Build.VERSION.SDK_INT >= 21)
        {
          localObject1 = this.mPathWithBorder;
          f9 = j;
          f10 = f8 + f9;
          ((Path)localObject1).moveTo(f5 + f4, f10);
          this.mPathWithBorder.lineTo(f7 - f3, f10);
          localObject1 = this.mPathWithBorder;
          f4 *= 2.0F;
          ((Path)localObject1).addArc(f5 + f9, f10, f5 + f4 - f9, f4 + f8 - f9, -135.0F, 45.0F);
          localObject1 = this.mPathWithBorder;
          f4 = f3 * 2.0F;
          ((Path)localObject1).addArc(f7 - f4 + f9, f10, f7 - f9, f4 + f8 - f9, -90.0F, 45.0F);
        }
        else
        {
          localObject1 = this.mPathWithBorder;
          f4 = j + f8;
          ((Path)localObject1).moveTo(f5, f4);
          this.mPathWithBorder.lineTo(f7, f4);
        }
        paramCanvas.drawPath(this.mPathWithBorder, this.mPaint);
      }
      if (n != 0)
      {
        this.mPaint.setColor(n);
        this.mPathWithBorder.reset();
        if (Build.VERSION.SDK_INT >= 21)
        {
          localObject1 = this.mPathWithBorder;
          f4 = j;
          f9 = f7 - f4;
          ((Path)localObject1).moveTo(f9, f8 + f3);
          this.mPathWithBorder.lineTo(f9, f6 - f1);
          localObject1 = this.mPathWithBorder;
          f10 = f1 * 2.0F;
          ((Path)localObject1).addArc(f7 - f10 + f4, f6 - f10 + f4, f9, f6 - f4, 0.0F, 45.0F);
          localObject1 = this.mPathWithBorder;
          f3 *= 2.0F;
          ((Path)localObject1).addArc(f7 - f3 + f4, f8 + f4, f9, f8 + f3 - f4, -45.0F, 45.0F);
        }
        else
        {
          localObject1 = this.mPathWithBorder;
          f3 = f7 - j;
          ((Path)localObject1).moveTo(f3, f8);
          this.mPathWithBorder.lineTo(f3, f6);
        }
        paramCanvas.drawPath(this.mPathWithBorder, this.mPaint);
      }
      if (i != 0)
      {
        this.mPaint.setColor(i);
        this.mPathWithBorder.reset();
        if (Build.VERSION.SDK_INT >= 21)
        {
          localObject1 = this.mPathWithBorder;
          f3 = j;
          f4 = f6 - f3;
          ((Path)localObject1).moveTo(f5 + f2, f4);
          this.mPathWithBorder.lineTo(f7 - f1, f4);
          localObject1 = this.mPathWithBorder;
          f1 *= 2.0F;
          ((Path)localObject1).addArc(f7 - f1 + f3, f6 - f1 + f3, f7 - f3, f4, 45.0F, 45.0F);
          localObject1 = this.mPathWithBorder;
          f1 = f2 * 2.0F;
          ((Path)localObject1).addArc(f5 + f3, f6 - f1 + f3, f5 + f1 - f3, f4, 90.0F, 45.0F);
        }
        else
        {
          localObject1 = this.mPathWithBorder;
          f1 = f6 - j;
          ((Path)localObject1).moveTo(f5, f1);
          this.mPathWithBorder.lineTo(f7, f1);
        }
        paramCanvas.drawPath(this.mPathWithBorder, this.mPaint);
      }
      this.mPaint.setAntiAlias(true);
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
    this.mTempRectForBorderRadius.set(this.mRect);
    Object localObject = this.mBorderWidthArray;
    if (localObject == null) {
      f1 = 0.0F;
    } else {
      f1 = localObject[0];
    }
    if (f1 > 1.0F)
    {
      localObject = this.mTempRectForBorderRadius;
      f1 *= 0.5F;
      ((RectF)localObject).inset(f1, f1);
    }
    localObject = this.mBorderRadiusArray;
    float f2 = localObject[1];
    float f1 = f2;
    if (f2 == 0.0F)
    {
      f1 = f2;
      if (localObject[0] > 0.0F) {
        f1 = localObject[0];
      }
    }
    localObject = this.mBorderRadiusArray;
    float f3 = localObject[2];
    f2 = f3;
    if (f3 == 0.0F)
    {
      f2 = f3;
      if (localObject[0] > 0.0F) {
        f2 = localObject[0];
      }
    }
    localObject = this.mBorderRadiusArray;
    float f4 = localObject[3];
    f3 = f4;
    if (f4 == 0.0F)
    {
      f3 = f4;
      if (localObject[0] > 0.0F) {
        f3 = localObject[0];
      }
    }
    localObject = this.mBorderRadiusArray;
    float f5 = localObject[4];
    f4 = f5;
    if (f5 == 0.0F)
    {
      f4 = f5;
      if (localObject[0] > 0.0F) {
        f4 = localObject[0];
      }
    }
    localObject = this.mPathForBorderRadius;
    RectF localRectF = this.mTempRectForBorderRadius;
    Path.Direction localDirection = Path.Direction.CW;
    ((Path)localObject).addRoundRect(localRectF, new float[] { f1, f1, f2, f2, f3, f3, f4, f4 }, localDirection);
  }
  
  public void draw(Canvas paramCanvas)
  {
    boolean bool;
    int i;
    int j;
    if (paramCanvas.getWidth() != 0)
    {
      if (paramCanvas.getHeight() == 0) {
        return;
      }
      bool = CommonTool.hasPositiveItem(this.mBorderRadiusArray);
      i = this.mBorderStyle;
      Paint localPaint;
      DashPathEffect localDashPathEffect;
      if (i == 1)
      {
        if (this.mDashPathEffect == null) {
          this.mDashPathEffect = new DashPathEffect(new float[] { 8.0F, 4.0F }, 0.0F);
        }
        localPaint = this.mPaint;
        localDashPathEffect = this.mDashPathEffect;
      }
      else if (i == 2)
      {
        if (this.mDotPathEffect == null) {
          this.mDotPathEffect = new DashPathEffect(new float[] { 4.0F, 4.0F }, 0.0F);
        }
        localPaint = this.mPaint;
        localDashPathEffect = this.mDotPathEffect;
      }
      else
      {
        localPaint = this.mPaint;
        localDashPathEffect = null;
      }
      localPaint.setPathEffect(localDashPathEffect);
      if ((Build.VERSION.SDK_INT < 21) && (CommonTool.hasPositiveItem(this.mBorderWidthArray)))
      {
        i = paramCanvas.getWidth();
        j = paramCanvas.getHeight();
        if (this.mCanvasBitmap != null) {}
      }
    }
    try
    {
      this.mCanvasBitmap = generateBitmap(paramCanvas.getWidth(), paramCanvas.getHeight());
      this.mBitmapCanvas = new Canvas(this.mCanvasBitmap);
      this.mBitmapPaint = new Paint();
      if (i == this.mCanvasBitmap.getWidth()) {
        if (j == this.mCanvasBitmap.getHeight()) {
          break label287;
        }
      }
    }
    catch (OutOfMemoryError|NullPointerException paramCanvas)
    {
      label287:
      return;
    }
    try
    {
      this.mCanvasBitmap = generateBitmap(paramCanvas.getWidth(), paramCanvas.getHeight());
      this.mBitmapCanvas = new Canvas(this.mCanvasBitmap);
      this.mBitmapCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
      drawBGShadow(this.mBitmapCanvas);
      if (!bool) {
        drawBG(this.mBitmapCanvas);
      } else {
        drawBGWithRadius(this.mBitmapCanvas);
      }
      paramCanvas.drawBitmap(this.mCanvasBitmap, 0.0F, 0.0F, this.mBitmapPaint);
      return;
    }
    catch (OutOfMemoryError|NullPointerException paramCanvas) {}
    drawBGShadow(paramCanvas);
    if (!bool)
    {
      drawBG(paramCanvas);
      return;
    }
    drawBGWithRadius(paramCanvas);
    return;
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
  
  public float getShadowOffsetX()
  {
    return this.mShadowOffsetX;
  }
  
  public float getShadowOffsetY()
  {
    return this.mShadowOffsetY;
  }
  
  public float getShadowRadius()
  {
    return this.mShadowRadius;
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
    int i;
    if (paramInt >= 0)
    {
      i = paramInt;
      if (paramInt <= 2) {}
    }
    else
    {
      i = 0;
    }
    this.mBorderStyle = i;
    invalidateSelf();
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
  
  public void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mShadowRect = new RectF(paramInt1 + this.mShadowRadius - this.mShadowOffsetX, paramInt2 + this.mShadowRadius - this.mShadowOffsetY, paramInt3 - this.mShadowRadius - this.mShadowOffsetX, paramInt4 - this.mShadowRadius - this.mShadowOffsetY);
    updateContentRegion();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
  
  public void setShadowColor(int paramInt)
  {
    this.mShadowColor = paramInt;
    invalidateSelf();
  }
  
  public void setShadowOpacity(float paramFloat)
  {
    this.mShadowOpacity = paramFloat;
    invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.asyncimage.BackgroundDrawable
 * JD-Core Version:    0.7.0.1
 */