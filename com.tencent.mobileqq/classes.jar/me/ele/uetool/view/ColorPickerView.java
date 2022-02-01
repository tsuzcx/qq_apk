package me.ele.uetool.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import me.ele.uetool.util.Util;
import me.ele.uetool.util.ViewKnife;

public class ColorPickerView
  extends View
{
  public static final int PIX_INTERVAL = 16;
  public static final String TEXT_FOCUS_INFO = "%s   %d,%d";
  private Matrix mBitmapMatrix = new Matrix();
  private Paint mBitmapPaint;
  private Path mCClipPath = new Path();
  private Bitmap mCircleBitmap;
  private Path mClipPath = new Path();
  private Paint mFocusPaint;
  private RoundedBitmapDrawable mGridDrawable;
  private Paint mGridPaint;
  private Rect mGridRect = new Rect();
  private Paint mGridShadowPaint;
  private Paint mRingPaint;
  private String mText;
  private TextPaint mTextPaint;
  private int rotation;
  
  public ColorPickerView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ColorPickerView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public ColorPickerView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private Bitmap createGridBitmap(int paramInt, Canvas paramCanvas)
  {
    int k = 0;
    int m = getWidth();
    int n = getHeight();
    paramCanvas.getClipBounds(this.mGridRect);
    paramCanvas = Bitmap.createBitmap(m, n, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(paramCanvas);
    if (paramInt >= 4)
    {
      int i = Math.min(paramInt * 36, 255);
      this.mGridPaint.setAlpha(i);
      this.mGridShadowPaint.setAlpha(i);
      localCanvas.save();
      i = 0;
      int j;
      float f2;
      float f1;
      for (;;)
      {
        j = k;
        if (i > getWidth()) {
          break;
        }
        f2 = i - 1;
        f1 = n;
        localCanvas.drawLine(f2, 0.0F, f2, f1, this.mGridPaint);
        f2 = i;
        localCanvas.drawLine(f2, 0.0F, f2, f1, this.mGridShadowPaint);
        i += paramInt;
      }
      while (j <= getHeight())
      {
        f2 = j - 1;
        f1 = m;
        localCanvas.drawLine(0.0F, f2, f1, f2, this.mGridPaint);
        f2 = j;
        localCanvas.drawLine(0.0F, f2, f1, f2, this.mGridShadowPaint);
        j += paramInt;
      }
      localCanvas.restore();
    }
    return paramCanvas;
  }
  
  private void drawBitmap(Canvas paramCanvas)
  {
    if ((this.mCircleBitmap == null) || (this.mCircleBitmap.isRecycled())) {
      return;
    }
    paramCanvas.save();
    paramCanvas.clipPath(this.mClipPath);
    this.mBitmapMatrix.reset();
    this.mBitmapMatrix.postScale(getWidth() / this.mCircleBitmap.getWidth(), getHeight() / this.mCircleBitmap.getHeight());
    paramCanvas.drawBitmap(this.mCircleBitmap, this.mBitmapMatrix, this.mBitmapPaint);
    paramCanvas.restore();
  }
  
  private void drawFocus(Canvas paramCanvas)
  {
    paramCanvas.drawRect(getWidth() / 2 - 2, getWidth() / 2 - 2, getWidth() / 2 + 20.0F - 2.0F, 20.0F + getWidth() / 2 - 2.0F, this.mFocusPaint);
  }
  
  private void drawGrid(Canvas paramCanvas)
  {
    if (this.mGridDrawable == null)
    {
      Bitmap localBitmap = createGridBitmap(16, paramCanvas);
      this.mGridDrawable = RoundedBitmapDrawableFactory.create(getResources(), localBitmap);
      this.mGridDrawable.setBounds(0, 0, getRight(), getBottom());
      this.mGridDrawable.setCircular(true);
    }
    this.mGridDrawable.draw(paramCanvas);
  }
  
  private void drawRing(Canvas paramCanvas)
  {
    paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
    this.mRingPaint.setStrokeWidth(36.0F);
    paramCanvas.drawCircle(getWidth() / 2, getWidth() / 2, getWidth() / 2 - 36.0F / 2.0F, this.mRingPaint);
    this.mRingPaint.setColor(Color.parseColor("#333333"));
    this.mRingPaint.setStrokeWidth(0.5F);
    paramCanvas.drawCircle(getWidth() / 2, getWidth() / 2, getWidth() / 2, this.mRingPaint);
    paramCanvas.drawCircle(getWidth() / 2, getWidth() / 2, getWidth() / 2 - 36.0F, this.mRingPaint);
  }
  
  private void drawText(Canvas paramCanvas)
  {
    float f;
    if (!TextUtils.isEmpty(this.mText))
    {
      paramCanvas.save();
      f = (float)(getWidth() * 3.141592653589793D * 0.25D);
      if (this.rotation != 180) {
        break label72;
      }
      paramCanvas.drawTextOnPath(this.mText, this.mCClipPath, f, 36.0F - 15.0F, this.mTextPaint);
    }
    for (;;)
    {
      paramCanvas.setDrawFilter(null);
      paramCanvas.restore();
      return;
      label72:
      paramCanvas.rotate(this.rotation, getWidth() / 2, getWidth() / 2);
      paramCanvas.drawTextOnPath(this.mText, this.mClipPath, f, 36.0F - 5.0F, this.mTextPaint);
    }
  }
  
  private void init()
  {
    this.mRingPaint = new Paint();
    this.mRingPaint.setAntiAlias(true);
    this.mRingPaint.setColor(-1);
    this.mRingPaint.setStyle(Paint.Style.STROKE);
    this.mFocusPaint = new Paint();
    this.mFocusPaint.setAntiAlias(true);
    this.mFocusPaint.setStyle(Paint.Style.STROKE);
    this.mFocusPaint.setStrokeWidth(3.0F);
    this.mFocusPaint.setColor(-16777216);
    this.mBitmapPaint = new Paint();
    this.mBitmapPaint.setFilterBitmap(false);
    this.mGridPaint = new Paint();
    this.mGridPaint.setStrokeWidth(1.0F);
    this.mGridPaint.setStyle(Paint.Style.STROKE);
    this.mGridPaint.setColor(-3355444);
    this.mGridShadowPaint = new Paint(this.mGridPaint);
    this.mGridShadowPaint.setColor(-12303292);
    this.mTextPaint = new TextPaint();
    this.mTextPaint.setAntiAlias(true);
    this.mTextPaint.setTextAlign(Paint.Align.CENTER);
    this.mTextPaint.setTypeface(Typeface.MONOSPACE);
    this.mTextPaint.setTextSize(ViewKnife.dip2px(12.0F));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    drawBitmap(paramCanvas);
    drawGrid(paramCanvas);
    drawRing(paramCanvas);
    drawText(paramCanvas);
    drawFocus(paramCanvas);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mClipPath.rewind();
    this.mClipPath.moveTo(0.0F, 0.0F);
    this.mClipPath.addCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2, Path.Direction.CW);
    this.mCClipPath.rewind();
    this.mCClipPath.moveTo(0.0F, 0.0F);
    this.mCClipPath.addCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2 - 32 + 4, Path.Direction.CCW);
  }
  
  public void setBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mCircleBitmap = paramBitmap;
    this.mText = String.format("%s   %d,%d", new Object[] { Util.intToHexColor(paramInt1), Integer.valueOf(paramInt2 + 16), Integer.valueOf(paramInt3 + 16) });
    this.mRingPaint.setColor(paramInt1);
    if (Util.isColdColor(paramInt1))
    {
      this.mFocusPaint.setColor(-1);
      this.mTextPaint.setColor(-1);
    }
    for (;;)
    {
      invalidate();
      return;
      this.mFocusPaint.setColor(-16777216);
      this.mTextPaint.setColor(-16777216);
    }
  }
  
  public void setRotation(int paramInt)
  {
    this.rotation = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     me.ele.uetool.view.ColorPickerView
 * JD-Core Version:    0.7.0.1
 */