package com.tencent.viola.ui.dom.style;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.util.SparseIntArray;
import com.tencent.viola.utils.ViolaUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class BorderDrawable
  extends Drawable
{
  public static final int ALL = 0;
  public static final int BORDER_BOTTOM_LEFT = 4;
  public static final int BORDER_BOTTOM_RIGHT = 3;
  public static final int BORDER_TOP_LEFT = 1;
  public static final int BORDER_TOP_RIGHT = 2;
  static final int DEFAULT_BORDER_COLOR = -16777216;
  private static final BorderStyle DEFAULT_BORDER_STYLE = BorderStyle.SOLID;
  public static final int POSITION_ALL = 0;
  public static final int POSITION_BOTTOM = 4;
  public static final int POSITION_LEFT = 1;
  public static final int POSITION_RIGHT = 3;
  public static final int POSITION_TOP = 2;
  private static final String TAG = "BorderDrawable";
  private static BorderStyle[] sBorderStyle = BorderStyle.values();
  private int mAlpha = 255;
  private SparseIntArray mBorderColor;
  private float[] mBorderRadius = new float[5];
  private SparseIntArray mBorderStyle;
  private float[] mBorderWidth = new float[5];
  private BottomLeftCorner mBottomLeftCorner;
  private BottomRightCorner mBottomRightCorner;
  private int mColor = 0;
  List<Float> mFactors = new ArrayList(4);
  private boolean mHasSetBorderRadius = false;
  private boolean mNeedUpdatePath = false;
  private float[] mOverlappingBorderRadius = new float[5];
  private final Paint mPaint = new Paint(1);
  private Path mPathForBorderOutline;
  private RectF mRectBounds;
  private Shader mShader = null;
  private TopLeftCorner mTopLeftCorner;
  private TopRightCorner mTopRightCorner;
  
  private void drawBorders(Canvas paramCanvas)
  {
    if (this.mRectBounds == null) {
      this.mRectBounds = new RectF(getBounds());
    }
    while (this.mBorderWidth == null)
    {
      return;
      this.mRectBounds.set(getBounds());
    }
    float f1 = this.mBorderWidth[1];
    float f2 = this.mBorderWidth[2];
    float f3 = this.mBorderWidth[4];
    float f4 = this.mBorderWidth[3];
    if (this.mTopLeftCorner == null) {
      this.mTopLeftCorner = new TopLeftCorner();
    }
    this.mTopLeftCorner.set(getBorderRadius(1), f1, f2, this.mRectBounds);
    if (this.mTopRightCorner == null) {
      this.mTopRightCorner = new TopRightCorner();
    }
    this.mTopRightCorner.set(getBorderRadius(2), f2, f4, this.mRectBounds);
    if (this.mBottomRightCorner == null) {
      this.mBottomRightCorner = new BottomRightCorner();
    }
    this.mBottomRightCorner.set(getBorderRadius(3), f4, f3, this.mRectBounds);
    if (this.mBottomLeftCorner == null) {
      this.mBottomLeftCorner = new BottomLeftCorner();
    }
    this.mBottomLeftCorner.set(getBorderRadius(4), f3, f1, this.mRectBounds);
    drawOneSide(paramCanvas, this.mTopLeftCorner, this.mTopRightCorner, 2);
    drawOneSide(paramCanvas, this.mTopRightCorner, this.mBottomRightCorner, 3);
    drawOneSide(paramCanvas, this.mBottomRightCorner, this.mBottomLeftCorner, 4);
    drawOneSide(paramCanvas, this.mBottomLeftCorner, this.mTopLeftCorner, 1);
  }
  
  private void drawEdge(@NonNull Canvas paramCanvas, BorderCorner paramBorderCorner1, BorderCorner paramBorderCorner2, @NonNull Paint paramPaint, int paramInt)
  {
    paramPaint.setStrokeWidth(this.mBorderWidth[paramInt]);
    paramBorderCorner1.drawRoundedCorner(paramCanvas, paramPaint, paramBorderCorner1.getAngleBisectorDegree());
    paramPaint.setStrokeWidth(this.mBorderWidth[paramInt]);
    paramCanvas.drawLine(paramBorderCorner1.getRoundCornerEndX(), paramBorderCorner1.getRoundCornerEndY(), paramBorderCorner2.getRoundCornerStartX(), paramBorderCorner2.getRoundCornerStartY(), paramPaint);
    paramBorderCorner2.drawRoundedCorner(paramCanvas, paramPaint, paramBorderCorner2.getAngleBisectorDegree() - 45.0F);
  }
  
  private void drawOneSide(Canvas paramCanvas, BorderCorner paramBorderCorner1, BorderCorner paramBorderCorner2, int paramInt)
  {
    if (0.0F != getBorderWidth(paramInt))
    {
      preparePaint(paramInt);
      drawEdge(paramCanvas, paramBorderCorner1, paramBorderCorner2, this.mPaint, paramInt);
    }
  }
  
  private float getBorderRadius(int paramInt)
  {
    if (this.mOverlappingBorderRadius != null) {
      return this.mOverlappingBorderRadius[paramInt];
    }
    return 0.0F;
  }
  
  private float getScaleFactor(@NonNull RectF paramRectF)
  {
    float f1 = this.mBorderRadius[1];
    float f2 = this.mBorderRadius[2];
    float f3 = this.mBorderRadius[2];
    float f4 = this.mBorderRadius[3];
    float f5 = this.mBorderRadius[3];
    float f6 = this.mBorderRadius[4];
    float f7 = this.mBorderRadius[4];
    float f8 = this.mBorderRadius[1];
    if (!this.mFactors.isEmpty()) {
      this.mFactors.clear();
    }
    updateFactor(this.mFactors, paramRectF.width(), f1 + f2);
    updateFactor(this.mFactors, paramRectF.height(), f3 + f4);
    updateFactor(this.mFactors, paramRectF.width(), f5 + f6);
    updateFactor(this.mFactors, paramRectF.height(), f7 + f8);
    if (this.mFactors.isEmpty()) {
      return (0.0F / 0.0F);
    }
    return ((Float)Collections.min(this.mFactors)).floatValue();
  }
  
  private void prepareBorderPath(int paramInt1, int paramInt2, int paramInt3, int paramInt4, @NonNull RectF paramRectF, @NonNull Path paramPath)
  {
    if (this.mBorderRadius != null)
    {
      prepareBorderRadius(paramRectF);
      float f1 = this.mOverlappingBorderRadius[1];
      float f2 = this.mOverlappingBorderRadius[2];
      float f3 = this.mOverlappingBorderRadius[3];
      float f4 = this.mOverlappingBorderRadius[4];
      float f5 = paramInt4;
      float f6 = paramInt1;
      float f7 = paramInt2;
      float f8 = paramInt1;
      float f9 = paramInt2;
      float f10 = paramInt3;
      float f11 = paramInt4;
      float f12 = paramInt3;
      Path.Direction localDirection = Path.Direction.CW;
      paramPath.addRoundRect(paramRectF, new float[] { f1 - f5, f1 - f6, f2 - f7, f2 - f8, f3 - f9, f3 - f10, f4 - f11, f4 - f12 }, localDirection);
      return;
    }
    paramPath.addRect(paramRectF, Path.Direction.CW);
  }
  
  private void prepareBorderRadius(@NonNull RectF paramRectF)
  {
    if (this.mBorderRadius != null)
    {
      float f = getScaleFactor(paramRectF);
      if ((!Float.isNaN(f)) && (f < 1.0F))
      {
        this.mOverlappingBorderRadius[1] = (this.mBorderRadius[1] * f);
        this.mOverlappingBorderRadius[2] = (this.mBorderRadius[2] * f);
        this.mOverlappingBorderRadius[3] = (this.mBorderRadius[3] * f);
        this.mOverlappingBorderRadius[4] = (f * this.mBorderRadius[4]);
      }
    }
    else
    {
      return;
    }
    this.mOverlappingBorderRadius[1] = this.mBorderRadius[1];
    this.mOverlappingBorderRadius[2] = this.mBorderRadius[2];
    this.mOverlappingBorderRadius[3] = this.mBorderRadius[3];
    this.mOverlappingBorderRadius[4] = this.mBorderRadius[4];
  }
  
  private void preparePaint(int paramInt)
  {
    float f = this.mBorderWidth[paramInt];
    int i = ViolaUtils.multiplyColorAlpha(getBorderColor(paramInt), this.mAlpha);
    Shader localShader = sBorderStyle[getBorderStyle(paramInt)].getLineShader(f, i, paramInt);
    this.mPaint.setShader(localShader);
    this.mPaint.setColor(i);
    this.mPaint.setStrokeCap(Paint.Cap.ROUND);
  }
  
  private void updateBorderOutline()
  {
    if (this.mNeedUpdatePath)
    {
      this.mNeedUpdatePath = false;
      if (this.mPathForBorderOutline == null) {
        this.mPathForBorderOutline = new Path();
      }
      this.mPathForBorderOutline.reset();
      prepareBorderPath(0, 0, 0, 0, new RectF(getBounds()), this.mPathForBorderOutline);
    }
  }
  
  private void updateFactor(@NonNull List<Float> paramList, float paramFloat1, float paramFloat2)
  {
    if (paramFloat2 != 0.0F) {
      paramList.add(Float.valueOf(paramFloat1 / paramFloat2));
    }
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    paramCanvas.save();
    updateBorderOutline();
    this.mPaint.setAlpha(255);
    int i;
    if (this.mPathForBorderOutline != null)
    {
      i = ViolaUtils.multiplyColorAlpha(this.mColor, this.mAlpha);
      if (this.mShader == null) {
        break label127;
      }
      this.mPaint.setShader(this.mShader);
      this.mPaint.setStyle(Paint.Style.FILL);
      paramCanvas.drawPath(this.mPathForBorderOutline, this.mPaint);
      this.mPaint.setShader(null);
    }
    for (;;)
    {
      this.mPaint.setStyle(Paint.Style.STROKE);
      this.mPaint.setStrokeJoin(Paint.Join.ROUND);
      drawBorders(paramCanvas);
      this.mPaint.setShader(null);
      paramCanvas.restore();
      return;
      label127:
      if (i >>> 24 != 0)
      {
        this.mPaint.setColor(i);
        this.mPaint.setStyle(Paint.Style.FILL);
        paramCanvas.drawPath(this.mPathForBorderOutline, this.mPaint);
        this.mPaint.setShader(null);
      }
    }
  }
  
  public int getAlpha()
  {
    return this.mAlpha;
  }
  
  int getBorderColor(int paramInt)
  {
    return ViolaUtils.fetchFromSparseArray(this.mBorderColor, paramInt, -16777216);
  }
  
  public float[] getBorderRadiusArray()
  {
    return this.mBorderRadius;
  }
  
  int getBorderStyle(int paramInt)
  {
    return ViolaUtils.fetchFromSparseArray(this.mBorderStyle, paramInt, BorderStyle.SOLID.ordinal());
  }
  
  float getBorderWidth(int paramInt)
  {
    return this.mBorderWidth[paramInt];
  }
  
  public int getColor()
  {
    return this.mColor;
  }
  
  public int getOpacity()
  {
    if (this.mShader != null) {
      return -1;
    }
    return ViolaUtils.getOpacityFromColor(ViolaUtils.multiplyColorAlpha(this.mColor, this.mAlpha));
  }
  
  public void getOutline(@NonNull Outline paramOutline)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (this.mPathForBorderOutline == null) {
        this.mNeedUpdatePath = true;
      }
      updateBorderOutline();
      paramOutline.setConvexPath(this.mPathForBorderOutline);
    }
  }
  
  public boolean hasSetBorderRadius()
  {
    return this.mHasSetBorderRadius;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.mNeedUpdatePath = true;
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.mAlpha)
    {
      this.mAlpha = paramInt;
      invalidateSelf();
    }
  }
  
  public void setBorderColor(int paramInt1, int paramInt2)
  {
    if (this.mBorderColor == null)
    {
      this.mBorderColor = new SparseIntArray(5);
      this.mBorderColor.put(0, -16777216);
    }
    if (getBorderColor(paramInt1) != paramInt2)
    {
      ViolaUtils.updateSparseArray(this.mBorderColor, paramInt1, paramInt2);
      invalidateSelf();
    }
  }
  
  public void setBorderRadius(int paramInt, float paramFloat)
  {
    if (this.mBorderRadius[paramInt] != paramFloat)
    {
      this.mHasSetBorderRadius = true;
      if (paramInt == 0)
      {
        paramInt = 0;
        while (paramInt < this.mBorderRadius.length)
        {
          if (this.mBorderRadius[paramInt] == 0.0F) {
            this.mBorderRadius[paramInt] = paramFloat;
          }
          paramInt += 1;
        }
      }
      this.mBorderRadius[paramInt] = paramFloat;
      this.mNeedUpdatePath = true;
      invalidateSelf();
    }
  }
  
  public void setBorderStyle(int paramInt, @NonNull String paramString)
  {
    if (this.mBorderStyle == null)
    {
      this.mBorderStyle = new SparseIntArray(5);
      this.mBorderStyle.put(0, DEFAULT_BORDER_STYLE.ordinal());
    }
    try
    {
      int i = BorderStyle.valueOf(paramString.toUpperCase(Locale.US)).ordinal();
      if (getBorderStyle(paramInt) != i)
      {
        ViolaUtils.updateSparseArray(this.mBorderStyle, paramInt, i);
        invalidateSelf();
      }
      return;
    }
    catch (IllegalArgumentException paramString) {}
  }
  
  public void setBorderWidth(int paramInt, float paramFloat)
  {
    if (this.mBorderWidth[paramInt] != paramFloat)
    {
      if (paramInt == 0)
      {
        paramInt = 0;
        while (paramInt < this.mBorderWidth.length)
        {
          if (this.mBorderWidth[paramInt] == 0.0F) {
            this.mBorderWidth[paramInt] = paramFloat;
          }
          paramInt += 1;
        }
      }
      this.mBorderWidth[paramInt] = paramFloat;
      this.mNeedUpdatePath = true;
      invalidateSelf();
    }
  }
  
  public void setColor(int paramInt)
  {
    this.mColor = paramInt;
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
  
  public void setImage(Shader paramShader)
  {
    this.mShader = paramShader;
    invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.dom.style.BorderDrawable
 * JD-Core Version:    0.7.0.1
 */