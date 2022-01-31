package com.tencent.plato.sdk.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.support.v4.util.LruCache;
import android.text.BoringLayout;
import android.text.BoringLayout.Metrics;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.plato.sdk.element.text.StaticLayoutWithMaxLines;
import com.tencent.plato.sdk.utils.DeviceInfo;

public class CustomTextView
  extends View
{
  private static final int ELLIPSIZE_DEFAULT = 0;
  private static final int ELLIPSIZE_END = 3;
  private static final int ELLIPSIZE_END_SMALL = 5;
  private static final int ELLIPSIZE_MARQUEE = 4;
  private static final int ELLIPSIZE_MIDDLE = 2;
  private static final int ELLIPSIZE_START = 1;
  private static final int LRU_MAX_SIZE = 2048;
  private static final BoringLayout.Metrics UNKNOWN_BORING = new BoringLayout.Metrics();
  private static LruCache<String, Object> mAreaCache = new LruCache(2048);
  BoringLayout.Metrics mBoring;
  private TextCache mCacheText = null;
  private int mCurTextColor;
  private float mCurrTextSize;
  private TextUtils.TruncateAt mEllipsize;
  private int mEllipsizeType;
  private boolean mIncludeFontPadding = true;
  private Layout.Alignment mLayoutAlignment = Layout.Alignment.ALIGN_NORMAL;
  private float mLineSpacingAdd = 0.0F;
  private float mLineSpacingMult = 1.0F;
  private int mMaxLines = 2147483647;
  private boolean mMeasureDirty = false;
  private final TextPaint mPaint = new TextPaint(1);
  private CharSequence mText = "";
  private int mTypeface;
  
  public CustomTextView(Context paramContext)
  {
    super(paramContext);
    this.mPaint.density = DeviceInfo.mDensity;
  }
  
  private int getDesiredHeight()
  {
    if ((this.mCacheText == null) || (this.mCacheText.mLayout == null)) {
      return 0;
    }
    int i = getPaddingTop();
    int j = getPaddingBottom();
    int k = Math.min(this.mMaxLines, this.mCacheText.mLayout.getLineCount());
    return this.mCacheText.mLayout.getLineTop(k) + (i + j);
  }
  
  private Layout makeNewLayout(int paramInt1, BoringLayout.Metrics paramMetrics, int paramInt2, boolean paramBoolean)
  {
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 0;
    }
    if (this.mEllipsize != null) {}
    for (boolean bool = true;; bool = false) {
      return makeSingleLayout(i, paramMetrics, paramInt2, this.mLayoutAlignment, bool, this.mEllipsize, paramBoolean);
    }
  }
  
  private Layout makeSingleLayout(int paramInt1, BoringLayout.Metrics paramMetrics, int paramInt2, Layout.Alignment paramAlignment, boolean paramBoolean1, TextUtils.TruncateAt paramTruncateAt, boolean paramBoolean2)
  {
    BoringLayout.Metrics localMetrics = paramMetrics;
    if (paramMetrics == UNKNOWN_BORING)
    {
      paramMetrics = BoringLayout.isBoring(this.mText, this.mPaint, this.mBoring);
      localMetrics = paramMetrics;
      if (paramMetrics != null)
      {
        this.mBoring = paramMetrics;
        localMetrics = paramMetrics;
      }
    }
    if (localMetrics != null)
    {
      if ((localMetrics.width <= paramInt1) && ((paramTruncateAt == null) || (localMetrics.width <= paramInt2))) {
        return BoringLayout.make(this.mText, this.mPaint, paramInt1, paramAlignment, this.mLineSpacingMult, this.mLineSpacingAdd, localMetrics, this.mIncludeFontPadding);
      }
      if ((paramBoolean1) && (localMetrics.width <= paramInt1)) {
        return BoringLayout.make(this.mText, this.mPaint, paramInt1, paramAlignment, this.mLineSpacingMult, this.mLineSpacingAdd, localMetrics, this.mIncludeFontPadding, paramTruncateAt, paramInt2);
      }
      if (paramBoolean1) {
        return StaticLayoutWithMaxLines.create(this.mText, 0, this.mText.length(), this.mPaint, paramInt1, paramAlignment, this.mLineSpacingMult, this.mLineSpacingAdd, this.mIncludeFontPadding, paramTruncateAt, paramInt2, this.mMaxLines);
      }
      return new StaticLayout(this.mText, this.mPaint, paramInt1, paramAlignment, this.mLineSpacingMult, this.mLineSpacingAdd, this.mIncludeFontPadding);
    }
    if (paramBoolean1) {
      return StaticLayoutWithMaxLines.create(this.mText, 0, this.mText.length(), this.mPaint, paramInt1, paramAlignment, this.mLineSpacingMult, this.mLineSpacingAdd, this.mIncludeFontPadding, paramTruncateAt, paramInt2, this.mMaxLines);
    }
    return new StaticLayout(this.mText, this.mPaint, paramInt1, paramAlignment, this.mLineSpacingMult, this.mLineSpacingAdd, this.mIncludeFontPadding);
  }
  
  protected final void addAreaCache(String paramString, Object paramObject)
  {
    if (!TextUtils.isEmpty(paramString)) {
      mAreaCache.put(paramString, paramObject);
    }
  }
  
  protected String generateCacheKey()
  {
    return this.mText.toString() + "_" + this.mCurTextColor + "_" + this.mCurrTextSize + "_" + this.mTypeface + "_" + this.mMaxLines + "_" + this.mEllipsizeType;
  }
  
  protected final Object getAreaCache(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return mAreaCache.get(paramString);
    }
    return mAreaCache.get(paramString);
  }
  
  public int getMaxLines()
  {
    return this.mMaxLines;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.mCacheText = ((TextCache)getAreaCache(generateCacheKey()));
    if ((this.mCacheText != null) && (this.mCacheText.mBitmap != null))
    {
      paramCanvas.drawBitmap(this.mCacheText.mBitmap, 0.0F, 0.0F, null);
      return;
    }
    Bitmap localBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_4444);
    Canvas localCanvas = new Canvas(localBitmap);
    if ((this.mCacheText != null) && (this.mCacheText.mLayout != null))
    {
      this.mCacheText.mLayout.draw(localCanvas);
      TextCache.access$002(this.mCacheText, localBitmap);
    }
    paramCanvas.drawBitmap(this.mCacheText.mBitmap, 0.0F, 0.0F, null);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    String str = generateCacheKey();
    this.mCacheText = ((TextCache)getAreaCache(str));
    if ((this.mCacheText != null) && (this.mCacheText.mLayout != null) && (!this.mMeasureDirty))
    {
      setMeasuredDimension(this.mCacheText.measuredWidth, this.mCacheText.measuredHeight);
      return;
    }
    this.mCacheText = new TextCache(null);
    addAreaCache(str, this.mCacheText);
    int j = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (j == 1073741824)
    {
      TextCache.access$202(this.mCacheText, paramInt1);
      paramInt1 = this.mCacheText.measuredWidth;
      TextCache.access$102(this.mCacheText, makeNewLayout(paramInt1, this.mBoring, paramInt1, false));
      if (i != 1073741824) {
        break label292;
      }
      TextCache.access$302(this.mCacheText, paramInt2);
    }
    for (;;)
    {
      setMeasuredDimension(this.mCacheText.measuredWidth, this.mCacheText.measuredHeight);
      return;
      this.mBoring = BoringLayout.isBoring(this.mText, this.mPaint, UNKNOWN_BORING);
      if ((this.mBoring == null) || (this.mBoring == UNKNOWN_BORING)) {
        TextCache.access$202(this.mCacheText, (int)Math.ceil(Layout.getDesiredWidth(this.mText, this.mPaint)));
      }
      for (;;)
      {
        if (j != -2147483648) {
          break label290;
        }
        TextCache.access$202(this.mCacheText, Math.min(paramInt1, this.mCacheText.measuredWidth));
        break;
        TextCache.access$202(this.mCacheText, this.mBoring.width);
      }
      label290:
      break;
      label292:
      TextCache.access$302(this.mCacheText, getDesiredHeight());
      if (i == -2147483648) {
        TextCache.access$302(this.mCacheText, Math.min(paramInt2, this.mCacheText.measuredHeight));
      }
    }
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    if (this.mEllipsize == paramTruncateAt) {
      return;
    }
    this.mEllipsize = paramTruncateAt;
    switch (1.$SwitchMap$android$text$TextUtils$TruncateAt[paramTruncateAt.ordinal()])
    {
    default: 
      this.mEllipsizeType = 0;
      return;
    case 1: 
      this.mEllipsizeType = 1;
      return;
    case 2: 
      this.mEllipsizeType = 2;
      return;
    case 3: 
      this.mEllipsizeType = 3;
      return;
    }
    this.mEllipsizeType = 4;
  }
  
  public void setMaxLines(int paramInt)
  {
    this.mMaxLines = paramInt;
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    this.mText = paramCharSequence;
    requestLayout();
  }
  
  public void setTextColor(int paramInt)
  {
    this.mCurTextColor = paramInt;
    this.mPaint.setColor(paramInt);
  }
  
  public void setTextSize(float paramFloat)
  {
    setTextSize(2, paramFloat);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    paramFloat = TypedValue.applyDimension(paramInt, paramFloat, getContext().getResources().getDisplayMetrics());
    if (this.mPaint.getTextSize() == paramFloat) {
      return;
    }
    this.mPaint.setTextSize(paramFloat);
    this.mCurrTextSize = paramFloat;
    requestLayout();
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    if (this.mPaint.getTypeface() == paramTypeface) {
      return;
    }
    this.mPaint.setTypeface(paramTypeface);
    requestLayout();
  }
  
  public void setTypeface(Typeface paramTypeface, int paramInt)
  {
    boolean bool = false;
    this.mTypeface = paramInt;
    if (paramInt > 0)
    {
      int i;
      if (paramTypeface == null)
      {
        paramTypeface = Typeface.defaultFromStyle(paramInt);
        setTypeface(paramTypeface);
        if (paramTypeface == null) {
          break label93;
        }
        i = paramTypeface.getStyle();
        label36:
        paramInt &= (i ^ 0xFFFFFFFF);
        paramTypeface = this.mPaint;
        if ((paramInt & 0x1) != 0) {
          bool = true;
        }
        paramTypeface.setFakeBoldText(bool);
        paramTypeface = this.mPaint;
        if ((paramInt & 0x2) == 0) {
          break label99;
        }
      }
      label93:
      label99:
      for (float f = -0.25F;; f = 0.0F)
      {
        paramTypeface.setTextSkewX(f);
        return;
        paramTypeface = Typeface.create(paramTypeface, paramInt);
        break;
        i = 0;
        break label36;
      }
    }
    this.mPaint.setFakeBoldText(false);
    this.mPaint.setTextSkewX(0.0F);
    setTypeface(paramTypeface);
  }
  
  private class TextCache
  {
    private Bitmap mBitmap;
    private Layout mLayout;
    private int measuredHeight;
    private int measuredWidth;
    
    private TextCache() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.sdk.widget.CustomTextView
 * JD-Core Version:    0.7.0.1
 */