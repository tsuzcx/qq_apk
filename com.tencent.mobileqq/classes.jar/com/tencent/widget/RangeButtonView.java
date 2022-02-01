package com.tencent.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetrics;
import android.graphics.Point;
import android.support.v4.view.ViewCompat;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.qqui.R.styleable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RangeButtonView
  extends View
{
  private int currentPosition = 0;
  private List<String> mContentDesc;
  private RangeButtonView.OnChangeListener mListener;
  private RangeButtonView.RangeButtonTouchHelper mTouchHelper;
  private TextPaint paint;
  RangeButtonView.RangeButtonParams params = new RangeButtonView.RangeButtonParams(this);
  private RangeButtonView.TitleDrawer tDrawer;
  private Bitmap thumbBmp;
  private RangeButtonView.ThumbDrawer thumbDrawer;
  private List<RangeButtonView.Title> titles;
  private RangeButtonView.UnitBar unitBar;
  
  public RangeButtonView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RangeButtonView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842868);
  }
  
  public RangeButtonView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.aN, 0, 0);
    this.params.barLeftPadding = paramContext.getDimension(R.styleable.ba, dp2px(26.0F));
    this.params.barRightPadding = paramContext.getDimension(R.styleable.bb, dp2px(26.0F));
    this.params.titleTopPadding = paramContext.getDimension(R.styleable.bi, dp2px(8.0F));
    this.params.titleColor = paramContext.getColor(R.styleable.bh, 17170446);
    this.params.lineOffset = paramContext.getDimension(R.styleable.be, dp2px(24.0F));
    this.params.lineColor = paramContext.getColor(R.styleable.bc, 17170446);
    this.params.lineHeight = paramContext.getDimension(R.styleable.bd, dp2px(8.0F));
    this.params.lineWeight = paramContext.getDimension(R.styleable.bf, dp2px(1.0F));
    this.params.thumbSrcId = paramContext.getResourceId(R.styleable.bg, 2130845211);
    paramContext.recycle();
    this.paint = new TextPaint();
    this.paint.setAntiAlias(true);
    this.thumbBmp = BitmapFactory.decodeResource(getResources(), this.params.thumbSrcId);
    if (AppSetting.d)
    {
      this.mTouchHelper = new RangeButtonView.RangeButtonTouchHelper(this, this);
      ViewCompat.setAccessibilityDelegate(this, this.mTouchHelper);
      ViewCompat.setImportantForAccessibility(this, 1);
    }
  }
  
  private float calculateMaxTextHeight()
  {
    if (this.titles != null)
    {
      TextPaint localTextPaint = new TextPaint();
      int i = 0;
      Iterator localIterator = this.titles.iterator();
      while (localIterator.hasNext())
      {
        localTextPaint.setTextSize(((RangeButtonView.Title)localIterator.next()).textSize);
        Paint.FontMetrics localFontMetrics = localTextPaint.getFontMetrics();
        if (i - Math.abs(localFontMetrics.top) < 0.0F) {
          i = (int)Math.abs(localFontMetrics.top);
        }
      }
      return i;
    }
    return dp2px(120.0F);
  }
  
  private float calculateMinViewHeight()
  {
    float f2 = calculateMaxTextHeight();
    float f3 = this.params.lineOffset;
    float f4 = this.params.lineHeight;
    Bitmap localBitmap = this.thumbBmp;
    float f1;
    if (localBitmap != null) {
      f1 = localBitmap.getHeight();
    } else {
      f1 = 0.0F;
    }
    return f2 + f3 + Math.max(f4, f1);
  }
  
  private float dp2px(float paramFloat)
  {
    return TypedValue.applyDimension(1, paramFloat, getResources().getDisplayMetrics());
  }
  
  public static float measureTextWidth(String paramString, float paramFloat)
  {
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setTextSize(paramFloat);
    return localTextPaint.measureText(paramString);
  }
  
  private int resetThumbPosition(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    ArrayList localArrayList = this.unitBar.getUnitPoints();
    int i = 0;
    while (i < localArrayList.size())
    {
      Point localPoint = (Point)localArrayList.get(i);
      int j = localPoint.y;
      int k = localPoint.y;
      if (paramInt2 < j - paramInt4) {
        break;
      }
      if (paramInt2 > k + paramInt4) {
        return -1;
      }
      j = localPoint.x;
      k = localPoint.x;
      if ((paramInt1 > j - paramInt3) && (paramInt1 < k + paramInt3))
      {
        if (paramBoolean) {
          this.thumbDrawer.calculatePosition(localPoint.x, localPoint.y);
        }
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  @TargetApi(14)
  protected boolean dispatchHoverEvent(MotionEvent paramMotionEvent)
  {
    if ((AppSetting.d) && (this.mTouchHelper.dispatchHoverEvent(paramMotionEvent))) {
      return true;
    }
    return super.dispatchHoverEvent(paramMotionEvent);
  }
  
  public int getThumbPosition()
  {
    return this.currentPosition;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.tDrawer == null)
    {
      this.params.unitCount = this.titles.size();
      this.unitBar = new RangeButtonView.UnitBar((int)(getPaddingLeft() + this.params.barLeftPadding), (int)(getWidth() - this.params.barRightPadding - getPaddingRight()), (int)(this.params.titleTopPadding + this.params.lineOffset + calculateMaxTextHeight()), this.params.unitCount);
      this.unitBar.setHeight(this.params.lineHeight);
      Object localObject2 = this.unitBar.getUnitPoints();
      Object localObject1 = new ArrayList(((ArrayList)localObject2).size());
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((ArrayList)localObject1).add(Integer.valueOf(((Point)((Iterator)localObject2).next()).x));
      }
      this.tDrawer = new RangeButtonView.TitleDrawer(this, this.titles);
      this.tDrawer.setTitlePoints((ArrayList)localObject1, (int)(this.params.titleTopPadding + calculateMaxTextHeight()));
      localObject1 = (Point)this.unitBar.getUnitPoints().get(this.currentPosition);
      this.thumbDrawer = new RangeButtonView.ThumbDrawer(((Point)localObject1).x, ((Point)localObject1).y, this.thumbBmp);
    }
    this.tDrawer.drawTitles(paramCanvas, this.paint);
    this.unitBar.drawBar(paramCanvas, this.paint, this.params);
    this.thumbDrawer.draw(paramCanvas, this.paint);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = (int)calculateMinViewHeight();
    int m = View.MeasureSpec.getMode(paramInt1);
    int k = View.MeasureSpec.getMode(paramInt2);
    int i = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt2);
    if (m == -2147483648) {
      paramInt2 = i;
    } else if (m == 1073741824) {
      paramInt2 = i;
    } else {
      paramInt2 = 0;
    }
    if (k == -2147483648) {
      paramInt1 = Math.min(j, paramInt1);
    } else if (k != 1073741824) {
      paramInt1 = (int)(j + getPaddingTop() + this.params.titleTopPadding);
    }
    setMeasuredDimension(paramInt2, paramInt1);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if ((i != 0) && (i != 1) && (i != 2) && (i != 3)) {
      return true;
    }
    paramMotionEvent = this.unitBar;
    if ((paramMotionEvent != null) && (this.thumbDrawer != null))
    {
      i = resetThumbPosition((int)f1, (int)f2, paramMotionEvent.getUintSpace() / 2, this.thumbDrawer.getThumbHeight() / 2, true);
      int j = this.currentPosition;
      if ((i != j) && (i != -1))
      {
        paramMotionEvent = this.mListener;
        if (paramMotionEvent != null) {
          paramMotionEvent.onChange(j, i);
        }
        this.currentPosition = i;
        invalidate();
      }
      return true;
    }
    return false;
  }
  
  public void setContentDescList(List<String> paramList)
  {
    this.mContentDesc = paramList;
  }
  
  public void setOnChangerListener(RangeButtonView.OnChangeListener paramOnChangeListener)
  {
    this.mListener = paramOnChangeListener;
  }
  
  public void setThumbPosition(int paramInt)
  {
    this.currentPosition = paramInt;
    Object localObject = this.unitBar;
    if (localObject == null) {
      return;
    }
    localObject = (Point)((RangeButtonView.UnitBar)localObject).getUnitPoints().get(paramInt);
    this.thumbDrawer.calculatePosition(((Point)localObject).x, ((Point)localObject).y);
    invalidate();
  }
  
  public void setTitleData(List<RangeButtonView.Title> paramList)
  {
    this.titles = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.RangeButtonView
 * JD-Core Version:    0.7.0.1
 */