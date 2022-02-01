package com.tencent.tavcut.timeline;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.tavcut.util.FloatUtils;
import com.tencent.tavcut.util.Logger;
import com.tencent.tavcut.util.Util;
import java.util.Locale;

public class SliderView
  extends FrameLayout
{
  private static final String TAG = "SliderView";
  private boolean canAdjust;
  private int frameColor = Color.parseColor("#ffffffff");
  private int mBarWidth;
  private boolean mDragging;
  private String mDuration = "00:00";
  private Bitmap mDurationBgBitmap;
  private Paint mDurationBgPaint;
  private float mDurationBgRadius;
  private Paint mDurationTextPaint;
  private float mDurationTextSize;
  private Paint mFramePaint;
  private int mFrameRadius;
  private int mFrameStrokeWidth;
  private Drawable mImgLockLeft;
  private Drawable mImgLockRight;
  private Drawable mImgRangeLeft;
  private Drawable mImgRangeRight;
  private Bitmap mIndicatorBitmap;
  private boolean mIndicatorMoved;
  private Paint mIndicatorPaint;
  private boolean mIndicatorPressed;
  private float mIndicatorProgress;
  private float mIndicatorWidth;
  private int mLastX;
  private boolean mLeftBarHandle;
  private ImageView mLeftBarIv;
  private boolean mLeftBarMoved;
  private boolean mLeftBarPressed;
  private boolean mLockMode;
  private String mMaxDurationTips;
  private int mMaxSelectAreaWidth;
  private long mMaxSelectDurationMs;
  private int mMinSelectAreaWidth;
  private int mOriginX;
  private int mPaddingBottom;
  private int mPaddingTop;
  private ImageView mRightBarIv;
  private boolean mRightBarMoved;
  private boolean mRightBarPressed;
  private Paint mSelectAreaPaint;
  private Rect mSelectAreaRect;
  private boolean mShowDuration = true;
  private boolean mSliderBarMode = true;
  private SliderChangeListener mSliderChangeListener;
  private long mTotalDurationMs;
  private int mTouchSlop;
  private boolean showIndicator = true;
  
  public SliderView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SliderView(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramContext, null, 0);
    this.mImgLockLeft = paramContext.getResources().getDrawable(paramInt1);
    this.mImgLockRight = paramContext.getResources().getDrawable(paramInt2);
    this.mImgRangeLeft = paramContext.getResources().getDrawable(paramInt3);
    this.mImgRangeRight = paramContext.getResources().getDrawable(paramInt4);
    init();
  }
  
  public SliderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SliderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void drawDuration(Canvas paramCanvas)
  {
    if (!this.mShowDuration) {
      return;
    }
    Object localObject1 = new Rect();
    Object localObject2 = this.mDurationTextPaint;
    String str = this.mDuration;
    ((Paint)localObject2).getTextBounds(str, 0, str.length(), (Rect)localObject1);
    int i = ((Rect)localObject1).width();
    int j = ((Rect)localObject1).height();
    float f1 = (int)Util.dp2px(getContext(), 4.5F);
    f1 = i + f1 * 2.0F;
    float f2 = j + 0.0F;
    localObject1 = new RectF();
    if (f1 < this.mSelectAreaRect.width()) {
      ((RectF)localObject1).set(this.mSelectAreaRect.left + Util.dp2px(getContext(), 3.0F), this.mSelectAreaRect.bottom - Util.dp2px(getContext(), 5.0F) - f2, this.mSelectAreaRect.left + Util.dp2px(getContext(), 3.0F) + f1, this.mSelectAreaRect.bottom - Util.dp2px(getContext(), 5.0F));
    } else if (this.mSelectAreaRect.centerX() * 2 < getWidth()) {
      ((RectF)localObject1).set(this.mSelectAreaRect.right + this.mBarWidth, this.mSelectAreaRect.bottom - Util.dp2px(getContext(), 5.0F) - f2, this.mSelectAreaRect.right + this.mBarWidth + f1, this.mSelectAreaRect.bottom - Util.dp2px(getContext(), 5.0F));
    } else {
      ((RectF)localObject1).set(this.mSelectAreaRect.left - this.mBarWidth - f1, this.mSelectAreaRect.bottom - Util.dp2px(getContext(), 5.0F) - f2, this.mSelectAreaRect.left - this.mBarWidth, this.mSelectAreaRect.bottom - Util.dp2px(getContext(), 5.0F));
    }
    localObject2 = this.mDurationTextPaint.getFontMetrics();
    f1 = (((RectF)localObject1).bottom + ((RectF)localObject1).top - ((Paint.FontMetrics)localObject2).bottom - ((Paint.FontMetrics)localObject2).top) / 2.0F;
    paramCanvas.drawText(this.mDuration, ((RectF)localObject1).centerX(), f1, this.mDurationTextPaint);
  }
  
  private void drawFrame(Canvas paramCanvas)
  {
    if (this.mSelectAreaRect == null) {
      this.mSelectAreaRect = new Rect();
    }
    if (this.mSliderBarMode)
    {
      this.mFramePaint.setColor(this.frameColor);
      this.mFramePaint.setStrokeWidth(0.0F);
      this.mFramePaint.setStyle(Paint.Style.FILL);
      this.mSelectAreaRect.set((int)(this.mLeftBarIv.getX() + this.mBarWidth), this.mPaddingTop, (int)this.mRightBarIv.getX(), getMeasuredHeight() - this.mPaddingBottom);
      paramCanvas.drawRect(this.mSelectAreaRect.left - (this.mBarWidth >> 1), this.mSelectAreaRect.top, this.mSelectAreaRect.right + (this.mBarWidth >> 1), this.mSelectAreaRect.top + this.mFrameStrokeWidth, this.mFramePaint);
      paramCanvas.drawRect(this.mSelectAreaRect.left - (this.mBarWidth >> 1), this.mSelectAreaRect.bottom - this.mFrameStrokeWidth, this.mSelectAreaRect.right + (this.mBarWidth >> 1), this.mSelectAreaRect.bottom, this.mFramePaint);
      return;
    }
    this.mFramePaint.setColor(this.frameColor);
    this.mFramePaint.setStrokeWidth(this.mFrameStrokeWidth);
    this.mFramePaint.setStyle(Paint.Style.STROKE);
    this.mSelectAreaRect.set(getPaddingLeft(), this.mPaddingTop, getMeasuredWidth() - getPaddingRight(), getMeasuredHeight() - this.mPaddingBottom);
    RectF localRectF = new RectF();
    localRectF.set(this.mSelectAreaRect.left, this.mSelectAreaRect.top, this.mSelectAreaRect.right, this.mSelectAreaRect.bottom);
    int i = this.mFrameRadius;
    paramCanvas.drawRoundRect(localRectF, i, i, this.mFramePaint);
  }
  
  private void drawIndicator(Canvas paramCanvas)
  {
    float f = this.mSelectAreaRect.left - Util.dp2px(getContext(), 8.0F) + (this.mSelectAreaRect.width() - Util.dp2px(getContext(), 4.0F)) * this.mIndicatorProgress;
    Object localObject = this.mIndicatorBitmap;
    if (localObject != null)
    {
      localObject = new Rect(0, 0, ((Bitmap)localObject).getWidth(), this.mIndicatorBitmap.getHeight());
      Rect localRect = new Rect((int)f, 0, (int)(f + this.mIndicatorWidth), getMeasuredHeight());
      paramCanvas.drawBitmap(this.mIndicatorBitmap, (Rect)localObject, localRect, this.mIndicatorPaint);
      return;
    }
    paramCanvas.drawRect(f, 0.0F, f + this.mIndicatorWidth, getMeasuredHeight(), this.mIndicatorPaint);
  }
  
  private void init()
  {
    initConfig();
    initView();
  }
  
  private void initConfig()
  {
    this.mPaddingTop = ((int)Util.dp2px(getContext(), 12.5F));
    this.mPaddingBottom = ((int)Util.dp2px(getContext(), 11.5F));
    this.mBarWidth = ((int)Util.dp2px(getContext(), 17.0F));
    this.mFrameStrokeWidth = ((int)Util.dp2px(getContext(), 1.0F));
    this.mFrameRadius = ((int)Util.dp2px(getContext(), 4.0F));
    this.mIndicatorWidth = ((int)Util.dp2px(getContext(), 3.0F));
    this.mSelectAreaPaint = new Paint();
    this.mSelectAreaPaint.setColor(Color.parseColor("#33FFFFFF"));
    this.mFramePaint = new Paint();
    Object localObject = this.mFramePaint;
    int i;
    if (this.mSliderBarMode) {
      i = Color.parseColor("#FFFFFFFF");
    } else {
      i = Color.parseColor("#66FFFFFF");
    }
    ((Paint)localObject).setColor(i);
    Paint localPaint = this.mFramePaint;
    if (this.mSliderBarMode) {
      localObject = Paint.Style.FILL;
    } else {
      localObject = Paint.Style.STROKE;
    }
    localPaint.setStyle((Paint.Style)localObject);
    localObject = this.mFramePaint;
    float f;
    if (this.mSliderBarMode) {
      f = 0.0F;
    } else {
      f = this.mFrameStrokeWidth;
    }
    ((Paint)localObject).setStrokeWidth(f);
    this.mIndicatorPaint = new Paint();
    this.mIndicatorPaint.setColor(Color.parseColor("#FFFFFFFF"));
    this.mMaxDurationTips = "已达到模板最大时长";
    this.mDurationTextSize = ((int)Util.sp2px(getContext(), 12.0F));
    this.mDurationTextPaint = new Paint();
    this.mDurationTextPaint.setColor(Color.parseColor("#FFFFFFFF"));
    this.mDurationTextPaint.setAntiAlias(true);
    this.mDurationTextPaint.setTextAlign(Paint.Align.CENTER);
    this.mDurationTextPaint.setTextSize(this.mDurationTextSize);
    this.mDurationBgRadius = ((int)Util.dp2px(getContext(), 1.0F));
    this.mDurationBgPaint = new Paint();
    this.mDurationBgPaint.setColor(Color.parseColor("#80000000"));
    this.mDurationBgPaint.setAntiAlias(true);
    this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  }
  
  private void initSliderBar()
  {
    this.mLeftBarIv = new ImageView(getContext());
    this.mLeftBarIv.setImageDrawable(this.mImgLockLeft);
    this.mLeftBarIv.setPadding(0, this.mPaddingTop, 0, this.mPaddingBottom);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.mBarWidth, -1);
    localLayoutParams.gravity = 8388611;
    this.mLeftBarIv.setLayoutParams(localLayoutParams);
    this.mLeftBarIv.setScaleType(ImageView.ScaleType.FIT_XY);
    addView(this.mLeftBarIv);
    this.mRightBarIv = new ImageView(getContext());
    this.mRightBarIv.setPadding(0, this.mPaddingTop, 0, this.mPaddingBottom);
    this.mRightBarIv.setImageDrawable(this.mImgLockRight);
    localLayoutParams = new FrameLayout.LayoutParams(this.mBarWidth, -1);
    localLayoutParams.gravity = 8388613;
    this.mRightBarIv.setLayoutParams(localLayoutParams);
    this.mRightBarIv.setScaleType(ImageView.ScaleType.FIT_XY);
    addView(this.mRightBarIv);
  }
  
  private void initView()
  {
    initSliderBar();
    setWillNotDraw(false);
  }
  
  private boolean isPressBar(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Rect localRect = new Rect();
    if (paramBoolean) {
      this.mLeftBarIv.getHitRect(localRect);
    } else {
      this.mRightBarIv.getHitRect(localRect);
    }
    localRect.left -= this.mTouchSlop;
    localRect.top -= this.mTouchSlop;
    localRect.right += this.mTouchSlop;
    localRect.bottom += this.mTouchSlop;
    return localRect.contains(paramInt1, paramInt2);
  }
  
  private boolean isPressIndicator(int paramInt)
  {
    float f2 = this.mSelectAreaRect.left;
    float f3 = this.mSelectAreaRect.width();
    float f4 = this.mIndicatorProgress;
    float f1 = this.mIndicatorWidth;
    f2 = f2 + f3 * f4 - f1 / 2.0F;
    f3 = paramInt;
    return (f3 >= f2 - f1 * 2.0F) && (f3 <= f2 + f1 * 2.0F);
  }
  
  private void moveIndicator(int paramInt)
  {
    float f1 = this.mSelectAreaRect.left;
    float f2 = this.mSelectAreaRect.width();
    float f4 = this.mIndicatorProgress;
    float f3 = this.mIndicatorWidth;
    f2 = f1 + f2 * f4 - f3 / 2.0F + paramInt;
    f1 = f2;
    if (f3 / 2.0F + f2 > this.mSelectAreaRect.left + this.mSelectAreaRect.width()) {
      f1 = this.mSelectAreaRect.left + this.mSelectAreaRect.width() - this.mIndicatorWidth / 2.0F;
    }
    this.mIndicatorProgress = Math.max(0.0F, (f1 - this.mSelectAreaRect.left + this.mIndicatorWidth / 2.0F) / this.mSelectAreaRect.width());
    this.mIndicatorMoved = true;
  }
  
  private void moveLeftBar(int paramInt)
  {
    if ((!this.canAdjust) && (paramInt > 0)) {
      return;
    }
    float f2 = this.mLeftBarIv.getX() + paramInt;
    float f1 = f2;
    if (f2 < 0.0F) {
      f1 = 0.0F;
    }
    f2 = f1;
    if (this.mRightBarIv.getX() - f1 - this.mBarWidth < this.mMinSelectAreaWidth) {
      f2 = this.mRightBarIv.getX() - this.mBarWidth - this.mMinSelectAreaWidth;
    }
    f1 = f2;
    if (this.mRightBarIv.getX() - f2 - this.mBarWidth > this.mMaxSelectAreaWidth) {
      f1 = this.mRightBarIv.getX() - this.mBarWidth - this.mMaxSelectAreaWidth;
    }
    if (FloatUtils.isEquals(f1, this.mLeftBarIv.getX())) {
      return;
    }
    this.mLeftBarIv.setX(f1);
    this.mLeftBarMoved = true;
    this.mIndicatorProgress = 0.0F;
    notifySliderBarMove();
  }
  
  private void moveRightBar(int paramInt)
  {
    if ((!this.canAdjust) && (paramInt < 0)) {
      return;
    }
    float f2 = this.mRightBarIv.getX() + paramInt;
    float f1 = getMeasuredWidth() - this.mBarWidth;
    if (f2 > f1) {
      f2 = f1;
    }
    f1 = f2;
    if (f2 - this.mLeftBarIv.getX() - this.mBarWidth < this.mMinSelectAreaWidth) {
      f1 = this.mLeftBarIv.getX() + this.mBarWidth + this.mMinSelectAreaWidth;
    }
    f2 = f1;
    if (f1 - this.mLeftBarIv.getX() - this.mBarWidth > this.mMaxSelectAreaWidth) {
      f2 = this.mLeftBarIv.getX() + this.mBarWidth + this.mMaxSelectAreaWidth;
    }
    if (FloatUtils.isEquals(f2, this.mRightBarIv.getX())) {
      return;
    }
    this.mRightBarIv.setX(f2);
    this.mRightBarMoved = true;
    this.mIndicatorProgress = 1.0F;
    notifySliderBarMove();
  }
  
  private void notifyIndicatorMove()
  {
    if (this.mSliderChangeListener != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyIndicatorMove: indicatorProgress is ");
      localStringBuilder.append(this.mIndicatorProgress);
      Logger.d("SliderView", localStringBuilder.toString());
      this.mSliderChangeListener.onIndicatorMove(this.mIndicatorProgress);
    }
  }
  
  private void notifyIndicatorPress()
  {
    SliderChangeListener localSliderChangeListener = this.mSliderChangeListener;
    if (localSliderChangeListener != null) {
      localSliderChangeListener.onIndicatorPress();
    }
  }
  
  private void notifyIndicatorRelease()
  {
    SliderChangeListener localSliderChangeListener = this.mSliderChangeListener;
    if (localSliderChangeListener != null) {
      localSliderChangeListener.onIndicatorRelease();
    }
  }
  
  private void notifySliderBarMove()
  {
    SliderChangeListener localSliderChangeListener = this.mSliderChangeListener;
    if (localSliderChangeListener != null) {
      localSliderChangeListener.onSliderBarMove(this.mLeftBarHandle, this.mLeftBarIv.getX() + this.mLeftBarIv.getWidth(), this.mRightBarIv.getX());
    }
  }
  
  private void notifySliderBarRelease()
  {
    SliderChangeListener localSliderChangeListener = this.mSliderChangeListener;
    if (localSliderChangeListener != null) {
      localSliderChangeListener.onSliderBarRelease(this.mLeftBarHandle);
    }
  }
  
  private String translateDuration(long paramLong)
  {
    double d = Math.round((float)paramLong / 100.0F);
    Double.isNaN(d);
    d /= 10.0D;
    return String.format(Locale.US, "%.1fs", new Object[] { Double.valueOf(d) });
  }
  
  private void updateSliderBarSource()
  {
    ImageView localImageView = this.mLeftBarIv;
    Drawable localDrawable;
    if (localImageView != null)
    {
      if (this.mLockMode) {
        localDrawable = this.mImgLockLeft;
      } else {
        localDrawable = this.mImgRangeLeft;
      }
      localImageView.setImageDrawable(localDrawable);
      this.mLeftBarIv.setEnabled(this.mLockMode ^ true);
    }
    localImageView = this.mRightBarIv;
    if (localImageView != null)
    {
      if (this.mLockMode) {
        localDrawable = this.mImgLockRight;
      } else {
        localDrawable = this.mImgRangeRight;
      }
      localImageView.setImageDrawable(localDrawable);
      this.mRightBarIv.setEnabled(this.mLockMode ^ true);
    }
  }
  
  private void updateSliderBarVisible()
  {
    ImageView localImageView = this.mLeftBarIv;
    int j = 0;
    int i;
    if (localImageView != null)
    {
      if (this.mSliderBarMode) {
        i = 0;
      } else {
        i = 8;
      }
      localImageView.setVisibility(i);
    }
    localImageView = this.mRightBarIv;
    if (localImageView != null)
    {
      if (this.mSliderBarMode) {
        i = j;
      } else {
        i = 8;
      }
      localImageView.setVisibility(i);
    }
  }
  
  public float getIndicatorProgress()
  {
    return this.mIndicatorProgress;
  }
  
  public ImageView getLeftBarIv()
  {
    return this.mLeftBarIv;
  }
  
  public ImageView getRightBarIv()
  {
    return this.mRightBarIv;
  }
  
  public int getSelectAreaWidth()
  {
    if (this.mSelectAreaRect == null) {
      this.mSelectAreaRect = new Rect();
    }
    if (this.mSliderBarMode) {
      this.mSelectAreaRect.set(this.mLeftBarIv.getWidth(), this.mPaddingTop, getMeasuredWidth() - this.mRightBarIv.getWidth(), getMeasuredHeight() - this.mPaddingBottom);
    } else {
      this.mSelectAreaRect.set(getPaddingLeft(), this.mPaddingTop, getMeasuredWidth() - getPaddingRight(), getMeasuredHeight() - this.mPaddingBottom);
    }
    return this.mSelectAreaRect.width();
  }
  
  public boolean isDragging()
  {
    return this.mDragging;
  }
  
  public boolean isIndicatorMoving()
  {
    return this.mIndicatorMoved;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.save();
    drawFrame(paramCanvas);
    drawDuration(paramCanvas);
    paramCanvas.restore();
    if (this.showIndicator) {
      drawIndicator(paramCanvas);
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    boolean bool = true;
    int j;
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            break label480;
          }
        }
        else
        {
          this.mLeftBarMoved = false;
          this.mRightBarMoved = false;
          this.mIndicatorMoved = false;
          i = (int)paramMotionEvent.getX();
          if ((!this.mDragging) && (Math.abs(i - this.mOriginX) > this.mTouchSlop)) {
            this.mDragging = true;
          }
          if (this.mDragging)
          {
            j = i - this.mLastX;
            if ((!this.mLeftBarPressed) && (!this.mRightBarPressed))
            {
              if (this.mIndicatorPressed)
              {
                getParent().requestDisallowInterceptTouchEvent(true);
                moveIndicator(j);
                invalidate();
                break label206;
              }
            }
            else
            {
              getParent().requestDisallowInterceptTouchEvent(true);
              if (this.mLeftBarPressed)
              {
                this.mLeftBarMoved = true;
                this.mLeftBarHandle = true;
                moveLeftBar(j);
              }
              else if (this.mRightBarPressed)
              {
                this.mRightBarMoved = true;
                this.mLeftBarHandle = false;
                moveRightBar(j);
              }
              invalidate();
              break label206;
            }
          }
          bool = false;
          label206:
          if ((!this.mLeftBarMoved) && (!this.mRightBarMoved))
          {
            if (this.mIndicatorMoved) {
              notifyIndicatorMove();
            }
          }
          else {
            notifySliderBarMove();
          }
          this.mLastX = i;
          return bool;
        }
      }
      this.mDragging = false;
      this.mOriginX = 0;
      this.mLastX = 0;
      if ((!this.mLeftBarMoved) && (!this.mRightBarMoved))
      {
        if ((this.mIndicatorMoved) || (this.mIndicatorPressed))
        {
          this.mIndicatorPressed = false;
          this.mIndicatorMoved = false;
          getParent().requestDisallowInterceptTouchEvent(false);
          invalidate();
          notifyIndicatorRelease();
          return true;
        }
      }
      else
      {
        this.mLeftBarMoved = false;
        this.mRightBarMoved = false;
        this.mLeftBarPressed = false;
        this.mRightBarPressed = false;
        getParent().requestDisallowInterceptTouchEvent(false);
        invalidate();
        notifySliderBarRelease();
        return true;
      }
    }
    else
    {
      i = (int)paramMotionEvent.getX();
      j = (int)paramMotionEvent.getY();
      this.mLeftBarPressed = false;
      this.mRightBarPressed = false;
      this.mIndicatorPressed = false;
      this.mOriginX = i;
      this.mLastX = i;
      this.mDragging = false;
      if ((isPressBar(true, i, j)) && (this.mLeftBarIv.isEnabled()))
      {
        this.mLeftBarPressed = true;
        return true;
      }
      if ((isPressBar(false, i, j)) && (this.mRightBarIv.isEnabled()))
      {
        this.mRightBarPressed = true;
        return true;
      }
      if (isPressIndicator(i))
      {
        this.mIndicatorPressed = true;
        notifyIndicatorPress();
        return true;
      }
    }
    label480:
    return false;
  }
  
  public void release()
  {
    this.mSliderChangeListener = null;
  }
  
  public void setCanAdjust(boolean paramBoolean)
  {
    this.canAdjust = paramBoolean;
  }
  
  public void setDurationBgRes(int paramInt)
  {
    this.mDurationBgBitmap = BitmapFactory.decodeResource(getResources(), paramInt);
  }
  
  public void setFrameColor(int paramInt)
  {
    this.frameColor = paramInt;
    invalidate();
  }
  
  public void setIndicatorProgress(float paramFloat)
  {
    if (FloatUtils.isEquals(paramFloat, this.mIndicatorProgress)) {
      return;
    }
    this.mIndicatorProgress = paramFloat;
    invalidate();
  }
  
  public void setIndicatorRes(int paramInt)
  {
    this.mIndicatorBitmap = BitmapFactory.decodeResource(getResources(), paramInt);
    this.mIndicatorWidth = this.mIndicatorBitmap.getWidth();
  }
  
  public void setLockMode(boolean paramBoolean)
  {
    this.mLockMode = paramBoolean;
    updateSliderBarSource();
  }
  
  public void setMaxDurationTips(String paramString)
  {
    this.mMaxDurationTips = paramString;
  }
  
  public void setMaxSelectAreaWidth(int paramInt)
  {
    this.mMaxSelectAreaWidth = paramInt;
  }
  
  public void setMaxSelectDuration(long paramLong)
  {
    this.mMaxSelectDurationMs = paramLong;
  }
  
  public void setMinSelectAreaWidth(int paramInt)
  {
    this.mMinSelectAreaWidth = paramInt;
  }
  
  public void setSelectDuration(Long paramLong)
  {
    if (paramLong == null) {
      return;
    }
    this.mDuration = translateDuration(paramLong.longValue());
    int i;
    if ((paramLong.equals(Long.valueOf(this.mMaxSelectDurationMs))) && ((this.mLeftBarMoved) || (this.mRightBarMoved)) && (this.mTotalDurationMs != this.mMaxSelectDurationMs) && (!TextUtils.isEmpty(this.mMaxDurationTips))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      this.mDuration = this.mMaxDurationTips;
    }
    invalidate();
  }
  
  @Deprecated
  public void setSelectDuration(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.mDuration = translateDuration(Long.parseLong(paramString));
    int i;
    if ((Long.parseLong(paramString) == this.mMaxSelectDurationMs) && ((this.mLeftBarMoved) || (this.mRightBarMoved)) && (this.mTotalDurationMs != this.mMaxSelectDurationMs) && (!TextUtils.isEmpty(this.mMaxDurationTips))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      this.mDuration = this.mMaxDurationTips;
    }
    invalidate();
  }
  
  public void setShowDuration(boolean paramBoolean)
  {
    this.mShowDuration = paramBoolean;
  }
  
  public void setShowIndicator(boolean paramBoolean)
  {
    this.showIndicator = paramBoolean;
  }
  
  public void setSliderBarMode(boolean paramBoolean)
  {
    this.mSliderBarMode = paramBoolean;
    updateSliderBarVisible();
    invalidate();
  }
  
  public void setSliderBarPosition(float paramFloat1, float paramFloat2)
  {
    ImageView localImageView = this.mLeftBarIv;
    if (localImageView != null) {
      localImageView.setX(paramFloat1);
    }
    localImageView = this.mRightBarIv;
    if (localImageView != null) {
      localImageView.setX(paramFloat2);
    }
  }
  
  public void setSliderChangeListener(SliderChangeListener paramSliderChangeListener)
  {
    this.mSliderChangeListener = paramSliderChangeListener;
  }
  
  public void setTotalDurationMs(long paramLong)
  {
    this.mTotalDurationMs = paramLong;
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    this.mDurationTextPaint.setTypeface(paramTypeface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.timeline.SliderView
 * JD-Core Version:    0.7.0.1
 */