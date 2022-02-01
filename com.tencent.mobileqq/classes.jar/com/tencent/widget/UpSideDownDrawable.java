package com.tencent.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Scroller;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;

public class UpSideDownDrawable
  extends Drawable
  implements Handler.Callback
{
  private static final int DEFAULT_DURATION_MS = 12000;
  private static final int DEFAULT_TIME_SLOT_MS = 20;
  private static final int MSG_DEFAULT = 0;
  private static final int MSG_SCROLLER_DOWN = 2;
  private static final int MSG_SCROLLER_UP = 3;
  private static final int MSG_START = 1;
  private boolean isResume = false;
  private Bitmap mBitmap;
  private int mBottom;
  private int mCurX = 0;
  private int mCurY = 0;
  Rect mDesRect = new Rect();
  private int mDisplayHeight;
  private int mDisplayWidth;
  private int mHeight;
  private Paint mPaint = new Paint();
  private Scroller mScroller;
  private Handler mScrollerHandler;
  Rect mSrcRect = new Rect();
  private UpSideDownDrawable.State mState;
  private int mTop;
  private int mWidth;
  
  public UpSideDownDrawable(Context paramContext, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    this.mWidth = paramBitmap.getWidth();
    this.mHeight = paramBitmap.getHeight();
    this.mBitmap = paramBitmap;
    this.mDisplayWidth = paramInt1;
    if (this.mDisplayWidth <= 0) {
      if ((paramContext != null) && (paramContext.getResources() != null)) {
        this.mDisplayWidth = ScreenUtil.getInstantScreenWidth(paramContext);
      } else {
        this.mDisplayWidth = ScreenUtil.SCREEN_WIDTH;
      }
    }
    int i = paramInt2;
    if (paramInt2 <= 0) {
      i = ScreenUtil.dip2px(170.0F);
    }
    this.mDisplayHeight = (this.mWidth * i / this.mDisplayWidth);
    paramInt2 = this.mHeight;
    this.mTop = (paramInt2 * 15 / 100);
    this.mBottom = (paramInt2 * 85 / 100);
    if (QLog.isColorLevel()) {
      QLog.i("UpSideDownDrawable", 2, String.format("UpSideDownDrawable bw=%d bh=%d dw=%d dh=%d mDisplayHeight=%d mTop=%d mBot=%d", new Object[] { Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(this.mDisplayHeight), Integer.valueOf(this.mTop), Integer.valueOf(this.mBottom) }));
    }
    this.mScrollerHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    this.mScroller = new Scroller(paramContext, new AccelerateDecelerateInterpolator());
    this.mCurY = this.mTop;
    this.mState = new UpSideDownDrawable.State(this);
  }
  
  private void initMoveDown()
  {
    UpSideDownDrawable.State localState = this.mState;
    int i = this.mBottom;
    int j = this.mDisplayHeight;
    localState.fromY = (i - j);
    localState.toY = (-(i - this.mTop - j));
    localState.leftDurtion = 12000;
    localState.derection = 3;
  }
  
  private void initMoveUp()
  {
    UpSideDownDrawable.State localState = this.mState;
    int i = this.mTop;
    localState.fromY = i;
    localState.toY = (this.mBottom - i - this.mDisplayHeight);
    localState.leftDurtion = 12000;
    localState.derection = 2;
  }
  
  public void draw(Canvas paramCanvas)
  {
    this.mSrcRect.set(0, this.mCurY, this.mBitmap.getWidth(), this.mCurY + this.mDisplayHeight);
    this.mDesRect.set(0, 0, this.mBitmap.getWidth(), this.mDisplayHeight);
    paramCanvas.drawBitmap(this.mBitmap, this.mSrcRect, this.mDesRect, this.mPaint);
  }
  
  public Bitmap getBitmap()
  {
    return this.mBitmap;
  }
  
  public int getIntrinsicHeight()
  {
    return this.mDisplayHeight;
  }
  
  public int getIntrinsicWidth()
  {
    return this.mWidth;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3)
        {
          this.mScrollerHandler.removeMessages(3);
          if (this.mScroller.computeScrollOffset())
          {
            this.mCurY = this.mScroller.getCurrY();
            if (this.mCurY >= this.mTop)
            {
              invalidateSelf();
              this.mScrollerHandler.sendEmptyMessageDelayed(3, 20L);
            }
            else
            {
              initMoveUp();
              this.mScrollerHandler.sendEmptyMessage(1);
            }
          }
          else
          {
            initMoveUp();
            this.mScrollerHandler.sendEmptyMessage(1);
          }
        }
      }
      else
      {
        this.mScrollerHandler.removeMessages(2);
        if (this.mScroller.computeScrollOffset())
        {
          this.mCurY = this.mScroller.getCurrY();
          if (this.mCurY <= this.mBottom - this.mDisplayHeight)
          {
            invalidateSelf();
            this.mScrollerHandler.sendEmptyMessageDelayed(2, 20L);
          }
          else
          {
            initMoveDown();
            this.mScrollerHandler.sendEmptyMessage(1);
          }
        }
        else
        {
          initMoveDown();
          this.mScrollerHandler.sendEmptyMessage(1);
        }
      }
    }
    else
    {
      this.mScroller.startScroll(0, this.mState.fromY, 0, this.mState.toY, this.mState.leftDurtion);
      this.mScrollerHandler.sendEmptyMessage(this.mState.derection);
      this.isResume = true;
    }
    return false;
  }
  
  public void pause()
  {
    if (!this.isResume) {
      return;
    }
    if (this.mScrollerHandler.hasMessages(2))
    {
      localState = this.mState;
      localState.derection = 2;
      localState.toY = (this.mBottom - this.mTop - this.mDisplayHeight);
    }
    else if (this.mScrollerHandler.hasMessages(3))
    {
      localState = this.mState;
      localState.derection = 3;
      localState.toY = (-(this.mBottom - this.mTop - this.mDisplayHeight));
    }
    UpSideDownDrawable.State localState = this.mState;
    localState.fromY = this.mCurY;
    localState.leftDurtion = (this.mScroller.getDuration() - this.mScroller.timePassed());
    this.mScroller.abortAnimation();
    this.mScrollerHandler.removeMessages(2);
    this.mScrollerHandler.removeMessages(3);
    this.isResume = false;
  }
  
  public void resume()
  {
    if (this.isResume) {
      return;
    }
    this.mScrollerHandler.sendEmptyMessage(1);
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.mPaint.getAlpha())
    {
      this.mPaint.setAlpha(paramInt);
      super.invalidateSelf();
    }
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    this.mBitmap = paramBitmap;
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mPaint.setColorFilter(paramColorFilter);
    super.invalidateSelf();
  }
  
  public void start()
  {
    if (this.isResume) {
      return;
    }
    UpSideDownDrawable.State localState = this.mState;
    int i = this.mTop;
    localState.fromY = i;
    localState.toY = (this.mBottom - i - this.mDisplayHeight);
    localState.leftDurtion = 12000;
    localState.derection = 2;
    this.mScrollerHandler.sendEmptyMessage(1);
  }
  
  public void stop()
  {
    this.mScrollerHandler.removeMessages(1);
    this.mScrollerHandler.removeMessages(3);
    this.mScrollerHandler.removeMessages(2);
    UpSideDownDrawable.State localState = this.mState;
    int i = this.mTop;
    localState.fromY = i;
    localState.toY = (this.mBottom - i - this.mDisplayHeight);
    localState.leftDurtion = 12000;
    localState.derection = 2;
    this.mCurY = i;
    this.isResume = false;
    invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.UpSideDownDrawable
 * JD-Core Version:    0.7.0.1
 */