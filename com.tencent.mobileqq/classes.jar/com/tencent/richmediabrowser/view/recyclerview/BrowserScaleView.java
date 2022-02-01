package com.tencent.richmediabrowser.view.recyclerview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView.ScaleType;
import com.tencent.richmediabrowser.api.event.IBrowserItemClickEvent;
import com.tencent.richmediabrowser.listener.IBrowserFlingControlListener;
import com.tencent.richmediabrowser.listener.IBrowserFlingEventListener;
import com.tencent.richmediabrowser.listener.IBrowserScaleControlListener;
import com.tencent.richmediabrowser.listener.IBrowserScaleEventListener;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;
import com.tencent.richmediabrowser.utils.ScreenUtils;
import com.tencent.richmediabrowser.view.GalleryUrlImageView;

public class BrowserScaleView
  extends GalleryUrlImageView
  implements ScaleGestureDetector.OnScaleGestureListener, View.OnTouchListener, IBrowserFlingControlListener, IBrowserFlingEventListener, IBrowserScaleControlListener, IBrowserScaleEventListener
{
  private static final String TAG = "BrowserScaleView";
  private int defaultDx;
  private int defaultDy;
  private int degrees;
  private volatile boolean isAutoScale;
  private boolean isCheckLeftAndRight;
  private boolean isCheckTopAndBottom;
  private boolean isDoubleTapEnable = true;
  private boolean isScaleEnable = true;
  private float mDefaultScale;
  private Drawable mDrawable;
  private BrowserFlingAnimator mFlingAnimator;
  private GestureDetector mGestureDetector;
  private int mHeight;
  private IBrowserItemClickEvent mItemEventListener;
  private int mLastPointerCount;
  private float mLastX;
  private float mLastY;
  private MainBrowserPresenter mMainBrowserPresenter;
  private float mMaxOverScale;
  private float mMaxScale;
  private float mMidScale;
  private float mMinScale;
  private RegionRectHelper mRegionRectHelper;
  private ScaleGestureDetector mScaleGestureDetector;
  private Matrix mScaleMatrix;
  protected int mScrollDirection;
  private int mTurnPageMaxDistance;
  private VelocityTracker mVelocityTracker;
  private int mWidth;
  private int privorX;
  private int privorY;
  
  public BrowserScaleView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BrowserScaleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setScaleType(ImageView.ScaleType.MATRIX);
    this.mTurnPageMaxDistance = ScreenUtils.dip2px(paramContext, 80.0F);
    this.mScaleGestureDetector = new ScaleGestureDetector(paramContext, this);
    setOnTouchListener(this);
    this.mGestureDetector = new GestureDetector(paramContext, new BrowserScaleView.1(this));
  }
  
  private boolean canUpdateRegionRect()
  {
    Drawable localDrawable = this.mDrawable;
    if (localDrawable == null) {
      return false;
    }
    int i = (int)(localDrawable.getIntrinsicWidth() * getScale());
    int j = (int)(this.mDrawable.getIntrinsicHeight() * getScale());
    return getRegionRectHelper().canUpdateRegionRect(i, j, this.mWidth, this.mHeight);
  }
  
  private void checkBorderAndCenterWhenScale()
  {
    if (this.mDrawable == null) {
      return;
    }
    RectF localRectF = getMatrixRectF();
    float f1 = localRectF.width();
    float f4 = this.mWidth;
    float f2 = 0.0F;
    float f3 = 0.0F;
    if (f1 >= f4)
    {
      if (localRectF.left > 0.0F) {
        f1 = -localRectF.left;
      } else {
        f1 = 0.0F;
      }
      f4 = localRectF.right;
      i = this.mWidth;
      if (f4 < i) {
        f1 = i - localRectF.right;
      }
    }
    else
    {
      f1 = 0.0F;
    }
    if (localRectF.height() >= this.mHeight)
    {
      f2 = f3;
      if (localRectF.top > 0.0F) {
        f2 = -localRectF.top;
      }
      f3 = localRectF.bottom;
      i = this.mHeight;
      if (f3 < i) {
        f2 = i - localRectF.bottom;
      }
    }
    f3 = localRectF.width();
    int i = this.mWidth;
    if (f3 < i) {
      f1 = i / 2.0F - localRectF.right + localRectF.width() / 2.0F;
    }
    f3 = localRectF.height();
    i = this.mHeight;
    if (f3 < i) {
      f2 = i / 2.0F - localRectF.bottom + localRectF.height() / 2.0F;
    }
    this.mScaleMatrix.postTranslate(f1, f2);
  }
  
  private void checkBorderWhenTranslate()
  {
    RectF localRectF = getMatrixRectF();
    boolean bool = this.isCheckLeftAndRight;
    float f2 = 0.0F;
    float f3 = 0.0F;
    float f1;
    int i;
    if (bool)
    {
      if (localRectF.left > 0.0F) {
        f1 = -localRectF.left;
      } else {
        f1 = 0.0F;
      }
      float f4 = localRectF.right;
      i = this.mWidth;
      if (f4 < i) {
        f1 = i - localRectF.right;
      }
    }
    else
    {
      f1 = 0.0F;
    }
    if (this.isCheckTopAndBottom)
    {
      f2 = f3;
      if (localRectF.top > 0.0F) {
        f2 = -localRectF.top;
      }
      f3 = localRectF.bottom;
      i = this.mHeight;
      if (f3 < i) {
        f2 = i - localRectF.bottom;
      }
    }
    this.mScaleMatrix.postTranslate(f1, f2);
  }
  
  private void dealScaleEvent()
  {
    if (!this.isAutoScale)
    {
      if (isVerticalLongPhoto(this.degrees))
      {
        f1 = getScale();
        f2 = this.mDefaultScale;
        if (f1 < f2) {
          startScale(f2, this.mWidth / 2, this.mHeight / 2);
        }
      }
      else
      {
        f1 = getScale();
        f2 = this.mDefaultScale;
        if (f1 < f2) {
          startScale(f2, this.mWidth / 2, this.mHeight / 2);
        }
      }
      float f1 = getScale();
      float f2 = this.mMaxScale;
      if (f1 > f2) {
        startScale(f2, this.mWidth / 2, this.mHeight / 2);
      }
    }
  }
  
  private boolean enableScrollLeft()
  {
    MainBrowserPresenter localMainBrowserPresenter = this.mMainBrowserPresenter;
    return (localMainBrowserPresenter != null) && (localMainBrowserPresenter.enableScrollLeft());
  }
  
  private boolean enableScrollRight()
  {
    MainBrowserPresenter localMainBrowserPresenter = this.mMainBrowserPresenter;
    return (localMainBrowserPresenter != null) && (localMainBrowserPresenter.enableScrollRight());
  }
  
  private RectF getMatrixRectF()
  {
    Matrix localMatrix = this.mScaleMatrix;
    RectF localRectF = new RectF();
    Drawable localDrawable = this.mDrawable;
    if ((localDrawable != null) && (localMatrix != null))
    {
      localRectF.set(0.0F, 0.0F, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      localMatrix.mapRect(localRectF);
    }
    return localRectF;
  }
  
  private RegionRectHelper getRegionRectHelper()
  {
    if (this.mRegionRectHelper == null) {
      this.mRegionRectHelper = new RegionRectHelper(this.mMainBrowserPresenter);
    }
    return this.mRegionRectHelper;
  }
  
  private float getScale()
  {
    float[] arrayOfFloat = new float[9];
    Matrix localMatrix = this.mScaleMatrix;
    if (localMatrix != null)
    {
      localMatrix.getValues(arrayOfFloat);
      if (isHorizonRotate(this.degrees)) {
        return Math.abs(arrayOfFloat[1]);
      }
      return Math.abs(arrayOfFloat[0]);
    }
    return this.mDefaultScale;
  }
  
  private void handleCancel(MotionEvent paramMotionEvent)
  {
    this.mLastPointerCount = 0;
    Object localObject = BrowserLogHelper.getInstance().getGalleryLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onTouch...action = ");
    localStringBuilder.append(paramMotionEvent.getAction());
    ((IBrowserLog)localObject).i("BrowserScaleView", 2, localStringBuilder.toString());
    dealScaleEvent();
    if ((isNeedRebound()) && (getScale() == this.mDefaultScale))
    {
      if (isVerticalLongPhoto(this.degrees))
      {
        checkBorderWhenTranslate();
        setImageMatrix(this.mScaleMatrix);
      }
      else
      {
        reset();
      }
    }
    else
    {
      localObject = this.mVelocityTracker;
      if (localObject != null)
      {
        ((VelocityTracker)localObject).addMovement(paramMotionEvent);
        this.mVelocityTracker.computeCurrentVelocity(1000);
        float f1 = this.mVelocityTracker.getXVelocity();
        float f2 = this.mVelocityTracker.getYVelocity();
        startFling(this.mWidth, this.mHeight, (int)-f1, (int)-f2);
      }
    }
    this.mScrollDirection = 0;
    if (canUpdateRegionRect()) {
      getRegionRectHelper().updateShowArea(this.mDrawable, this.mScaleMatrix, this.mDefaultScale, getScale(), this, true, this.mScrollDirection);
    }
    paramMotionEvent = this.mVelocityTracker;
    if (paramMotionEvent != null)
    {
      paramMotionEvent.recycle();
      this.mVelocityTracker = null;
    }
  }
  
  private void handleDown(MotionEvent paramMotionEvent, RectF paramRectF)
  {
    this.mVelocityTracker = VelocityTracker.obtain();
    VelocityTracker localVelocityTracker = this.mVelocityTracker;
    if (localVelocityTracker != null) {
      localVelocityTracker.addMovement(paramMotionEvent);
    }
    paramMotionEvent = this.mFlingAnimator;
    if (paramMotionEvent != null)
    {
      paramMotionEvent.cancelFling();
      this.mFlingAnimator = null;
    }
    if ((paramRectF.width() > this.mWidth) || (paramRectF.height() > this.mHeight)) {
      requestDisallowInterceptTouchEvent(true);
    }
  }
  
  private boolean handleInterceptEvent(RectF paramRectF, float paramFloat)
  {
    if ((getScale() == this.mDefaultScale) && (!isVerticalLongPhoto(this.degrees)))
    {
      if (((paramFloat > 0.0F) && (enableScrollLeft())) || ((paramFloat < 0.0F) && (enableScrollRight())))
      {
        requestDisallowInterceptTouchEvent(false);
        return true;
      }
    }
    else if ((paramRectF.width() > this.mWidth) || (paramRectF.height() > this.mHeight)) {
      requestDisallowInterceptTouchEvent(true);
    }
    return false;
  }
  
  private float handleLeftScroll(RectF paramRectF, float paramFloat)
  {
    if (paramRectF.left > 0.0F) {
      if (enableScrollLeft())
      {
        if (Math.abs(paramRectF.left) > this.mTurnPageMaxDistance)
        {
          requestDisallowInterceptTouchEvent(false);
          requestDisallowInterceptDragEvent(true);
          return 0.0F;
        }
      }
      else
      {
        requestDisallowInterceptTouchEvent(true);
        if (Math.abs(paramRectF.left) > this.mWidth / 4.0F) {
          return 0.0F;
        }
      }
    }
    return paramFloat;
  }
  
  private boolean handleMove(MotionEvent paramMotionEvent, float paramFloat1, float paramFloat2, int paramInt, RectF paramRectF)
  {
    float f2 = paramFloat1 - this.mLastX;
    float f3 = paramFloat2 - this.mLastY;
    if (handleInterceptEvent(paramRectF, f2)) {
      return true;
    }
    float f4 = f2;
    float f1 = f3;
    if (this.mDrawable != null)
    {
      VelocityTracker localVelocityTracker = this.mVelocityTracker;
      if (localVelocityTracker != null) {
        localVelocityTracker.addMovement(paramMotionEvent);
      }
      this.isCheckLeftAndRight = true;
      this.isCheckTopAndBottom = true;
      f4 = f2;
      f1 = f3;
      if (paramRectF.width() < this.mWidth)
      {
        f4 = f2;
        f1 = f3;
        if (paramRectF.height() < this.mHeight)
        {
          this.isCheckLeftAndRight = false;
          this.isCheckTopAndBottom = false;
          f4 = 0.0F;
          f1 = 0.0F;
        }
      }
      f2 = handleLeftScroll(paramRectF, f4);
      if (paramRectF.right < this.mWidth)
      {
        if (enableScrollRight())
        {
          if (Math.abs(this.mWidth - paramRectF.right) <= this.mTurnPageMaxDistance) {
            break label236;
          }
          requestDisallowInterceptTouchEvent(false);
          requestDisallowInterceptDragEvent(true);
        }
        else
        {
          requestDisallowInterceptTouchEvent(true);
          if (Math.abs(this.mWidth - paramRectF.right) <= this.mWidth / 4.0F) {
            break label236;
          }
        }
        f2 = 0.0F;
      }
      label236:
      if (getScale() == this.mDefaultScale)
      {
        f4 = f2;
        if (isVerticalLongPhoto(this.degrees)) {}
      }
      else
      {
        for (;;)
        {
          f1 = 0.0F;
          f4 = f2;
          break;
          f3 = f1;
          if (paramRectF.top > 0.0F)
          {
            f3 = f1;
            if (Math.abs(paramRectF.top) > this.mWidth / 4.0F)
            {
              requestDisallowInterceptDragEvent(false);
              f3 = 0.0F;
            }
          }
          float f5 = paramRectF.bottom;
          int i = this.mHeight;
          f4 = f2;
          f1 = f3;
          if (f5 >= i) {
            break;
          }
          f4 = f2;
          f1 = f3;
          if (Math.abs(i - paramRectF.bottom) <= this.mWidth / 4.0F) {
            break;
          }
          requestDisallowInterceptDragEvent(true);
        }
      }
    }
    if (handlePhotoTranslate(paramInt, paramRectF, f4, f1)) {
      return true;
    }
    this.mLastX = paramFloat1;
    this.mLastY = paramFloat2;
    return false;
  }
  
  private boolean handlePhotoTranslate(int paramInt, RectF paramRectF, float paramFloat1, float paramFloat2)
  {
    float f = paramFloat1;
    if (isVerticalLongPhoto(this.degrees))
    {
      f = paramFloat1;
      if (getScale() == this.mDefaultScale)
      {
        if ((Math.abs(paramFloat1) / Math.abs(paramFloat2) >= 6.0F) && (Math.abs(paramFloat2) < 10.0F))
        {
          requestDisallowInterceptTouchEvent(false);
          requestDisallowInterceptDragEvent(true);
          return true;
        }
        if ((paramInt < 2) && (paramRectF.top > 0.0F) && (Math.abs(paramFloat2) / Math.abs(paramFloat1) >= 6.0F) && (Math.abs(paramFloat1) < 10.0F))
        {
          requestDisallowInterceptTouchEvent(true);
          requestDisallowInterceptDragEvent(false);
          f = paramFloat1;
        }
        else
        {
          f = 0.0F;
        }
      }
    }
    paramRectF = this.mScaleMatrix;
    if (paramRectF != null)
    {
      paramRectF.postTranslate(f, paramFloat2);
      setImageMatrix(this.mScaleMatrix);
    }
    handleRegionRect(f);
    return false;
  }
  
  private void handleRegionRect(float paramFloat)
  {
    if (canUpdateRegionRect())
    {
      if (paramFloat == 0.0F) {
        this.mScrollDirection = 0;
      } else if (paramFloat < 0.0F) {
        this.mScrollDirection = 1;
      } else {
        this.mScrollDirection = 2;
      }
      getRegionRectHelper().updateShowArea(this.mDrawable, this.mScaleMatrix, this.mDefaultScale, getScale(), this, true, 1, this.mScrollDirection);
    }
  }
  
  private void initScaleValue(float paramFloat)
  {
    this.mDefaultScale = paramFloat;
    if (isHorizonLongPhoto())
    {
      this.mMaxScale = (this.mDrawable.getIntrinsicWidth() * 1.0F / this.mWidth);
      this.mMaxOverScale = (this.mMaxScale * 1.1F);
    }
    else
    {
      this.mMaxScale = Math.max(this.mDefaultScale * 4.0F, 1.0F);
      this.mMaxOverScale = (this.mMaxScale * 5.0F);
    }
    paramFloat = this.mDefaultScale;
    this.mMidScale = (2.0F * paramFloat);
    this.mMinScale = (paramFloat * 0.6F);
  }
  
  private boolean isHorizonLongPhoto()
  {
    Drawable localDrawable = this.mDrawable;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localDrawable != null)
    {
      bool1 = bool2;
      if (localDrawable.getIntrinsicWidth() >= this.mDrawable.getIntrinsicHeight() * 3L) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean isHorizonRotate(int paramInt)
  {
    return (paramInt == 90) || (paramInt == 270);
  }
  
  private boolean isLongPhoto()
  {
    Drawable localDrawable = this.mDrawable;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localDrawable != null)
    {
      long l = localDrawable.getIntrinsicWidth();
      bool1 = bool2;
      if (this.mDrawable.getIntrinsicHeight() >= l * 3L) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean isNeedRebound()
  {
    RectF localRectF = getMatrixRectF();
    return (localRectF.left > 0.0F) || (localRectF.right < this.mWidth) || (localRectF.top > 0.0F) || (localRectF.bottom < this.mHeight);
  }
  
  private boolean isVerticalLongPhoto(int paramInt)
  {
    return (!isHorizonRotate(paramInt)) && (isLongPhoto());
  }
  
  private void requestDisallowInterceptDragEvent(boolean paramBoolean)
  {
    MainBrowserPresenter localMainBrowserPresenter = this.mMainBrowserPresenter;
    if (localMainBrowserPresenter != null) {
      localMainBrowserPresenter.requestDisallowInterceptDragEvent(paramBoolean);
    }
  }
  
  private void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    MainBrowserPresenter localMainBrowserPresenter = this.mMainBrowserPresenter;
    if (localMainBrowserPresenter != null) {
      localMainBrowserPresenter.requestDisallowInterceptTouchEvent(paramBoolean);
    }
  }
  
  private void showDefaultImage(int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (isVerticalLongPhoto(paramInt3))
    {
      showLongImage(paramInt1, paramInt2, paramInt3, paramFloat1, paramFloat2, paramFloat3);
      return;
    }
    showNormalImage(paramInt1, paramInt2, paramInt3, paramFloat1, paramFloat2, paramFloat3);
  }
  
  private void showLongImage(int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.mScaleMatrix = new Matrix();
    if (paramFloat1 == 1.0F) {
      return;
    }
    this.mScaleMatrix.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
    setImageMatrix(this.mScaleMatrix);
    paramFloat2 = this.mDrawable.getIntrinsicWidth();
    paramFloat1 = 1.0F - paramFloat1;
    paramFloat2 = paramFloat2 * paramFloat1 / 2.0F;
    paramFloat1 = this.mDrawable.getIntrinsicHeight() * paramFloat1 / 2.0F;
    this.mScaleMatrix.postTranslate(-paramFloat2, -paramFloat1);
    setImageMatrix(this.mScaleMatrix);
  }
  
  private void showNormalImage(int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.mScaleMatrix = new Matrix();
    this.mScaleMatrix.postRotate(paramInt3, paramFloat2, paramFloat3);
    setImageMatrix(this.mScaleMatrix);
    this.mScaleMatrix.postTranslate(paramInt1, paramInt2);
    setImageMatrix(this.mScaleMatrix);
    this.mScaleMatrix.postScale(paramFloat1, paramFloat1, this.mWidth / 2, this.mHeight / 2);
    setImageMatrix(this.mScaleMatrix);
  }
  
  private void startFling(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    IBrowserLog localIBrowserLog = BrowserLogHelper.getInstance().getGalleryLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startFling...velocityX = ");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append(", velocityY = ");
    localStringBuilder.append(paramInt4);
    localIBrowserLog.i("BrowserScaleView", 2, localStringBuilder.toString());
    if (this.mFlingAnimator == null)
    {
      this.mFlingAnimator = new BrowserFlingAnimator(getContext());
      this.mFlingAnimator.setBrowserFlingControlListener(this);
      this.mFlingAnimator.setBrowserFlingEventListener(this);
    }
    this.mFlingAnimator.startFling(paramInt1, paramInt2, paramInt3, paramInt4, enableScrollLeft(), enableScrollRight());
  }
  
  private void startScale(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    BrowserScaleAnimator localBrowserScaleAnimator = new BrowserScaleAnimator(paramFloat1, paramFloat2, paramFloat3);
    localBrowserScaleAnimator.setBrowserScaleControlListener(this);
    localBrowserScaleAnimator.setBrowserScaleEventListener(this);
    localBrowserScaleAnimator.initAnimator();
    localBrowserScaleAnimator.start();
  }
  
  public RectF getCurrentMatrixRectF()
  {
    return getMatrixRectF();
  }
  
  public float getCurrentScale()
  {
    return getScale();
  }
  
  public void initDrawable(Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mDrawable = paramDrawable;
    this.degrees = paramInt3;
    this.mScaleMatrix = new Matrix();
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    paramDrawable = this.mDrawable;
    if (paramDrawable == null) {
      return;
    }
    int j = paramDrawable.getIntrinsicWidth();
    int i = this.mDrawable.getIntrinsicHeight();
    if (isHorizonRotate(paramInt3))
    {
      j = this.mDrawable.getIntrinsicHeight();
      i = this.mDrawable.getIntrinsicWidth();
    }
    if ((j >= paramInt1) && (i <= paramInt2)) {
      f2 = paramInt1 * 1.0F / j;
    } else {
      f2 = 1.0F;
    }
    float f1 = f2;
    if (j <= paramInt1)
    {
      f1 = f2;
      if (i >= paramInt2)
      {
        if (isVerticalLongPhoto(paramInt3))
        {
          f1 = paramInt1 * 1.0F;
          f2 = j;
        }
        else
        {
          f1 = paramInt2 * 1.0F;
          f2 = i;
        }
        f1 /= f2;
      }
    }
    float f2 = f1;
    if (j <= paramInt1)
    {
      f2 = f1;
      if (i <= paramInt2)
      {
        f2 = f1;
        if (isVerticalLongPhoto(paramInt3)) {
          f2 = paramInt1 * 1.0F / j;
        }
      }
    }
    f1 = f2;
    if (j >= paramInt1)
    {
      f1 = f2;
      if (i >= paramInt2) {
        if (isVerticalLongPhoto(paramInt3)) {
          f1 = paramInt1 * 1.0F / j;
        } else {
          f1 = Math.min(paramInt1 * 1.0F / j, paramInt2 * 1.0F / i);
        }
      }
    }
    paramDrawable = BrowserLogHelper.getInstance().getGalleryLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dw = ");
    localStringBuilder.append(j);
    localStringBuilder.append(", dh = ");
    localStringBuilder.append(i);
    localStringBuilder.append(", width = ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", height");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", degrees = ");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append(", scale = ");
    localStringBuilder.append(f1);
    paramDrawable.d("BrowserScaleView", 4, localStringBuilder.toString());
    this.defaultDx = (paramInt1 / 2 - this.mDrawable.getIntrinsicWidth() / 2);
    this.defaultDy = (paramInt2 / 2 - this.mDrawable.getIntrinsicHeight() / 2);
    this.privorX = (this.mDrawable.getIntrinsicWidth() / 2);
    this.privorY = (this.mDrawable.getIntrinsicHeight() / 2);
    showDefaultImage(this.defaultDx, this.defaultDy, paramInt3, f1, this.privorX, this.privorY);
    if (isVerticalLongPhoto(paramInt3))
    {
      this.mDefaultScale = f1;
      f1 = this.mDefaultScale;
      this.mMidScale = (2.0F * f1);
      this.mMinScale = (0.6F * f1);
      this.mMaxScale = Math.max(f1 * 4.0F, 1.0F);
      this.mMaxOverScale = (this.mMaxScale * 5.0F);
      return;
    }
    initScaleValue(f1);
  }
  
  public void onFlingAnimationCancel() {}
  
  public void onFlingAnimationEnd()
  {
    if (canUpdateRegionRect()) {
      getRegionRectHelper().updateShowArea(this.mDrawable, this.mScaleMatrix, this.mDefaultScale, getScale(), this, true, this.mScrollDirection);
    }
  }
  
  public void onFlingAnimationRepeat() {}
  
  public void onFlingAnimationStart() {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (!this.isScaleEnable) {
      return false;
    }
    if (this.mDrawable == null) {
      return false;
    }
    MainBrowserPresenter localMainBrowserPresenter = this.mMainBrowserPresenter;
    if (localMainBrowserPresenter != null) {
      localMainBrowserPresenter.onScale();
    }
    float f2 = paramScaleGestureDetector.getScaleFactor();
    float f3 = getScale();
    if (((f2 > 1.0F) && (f3 * f2 < this.mMaxOverScale)) || ((f2 < 1.0F) && (f3 * f2 > this.mMinScale)))
    {
      float f4 = this.mMaxOverScale;
      float f1 = f2;
      if (f3 * f2 > f4) {
        f1 = f4 / f3;
      }
      f4 = this.mMinScale;
      f2 = f1;
      if (f3 * f1 < f4) {
        f2 = f4 / f3;
      }
      this.mScaleMatrix.postScale(f2, f2, paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
      checkBorderAndCenterWhenScale();
      setImageMatrix(this.mScaleMatrix);
    }
    return true;
  }
  
  public void onScaleAnimationCancel()
  {
    this.isAutoScale = false;
  }
  
  public void onScaleAnimationEnd()
  {
    this.isAutoScale = false;
  }
  
  public void onScaleAnimationRepeat() {}
  
  public void onScaleAnimationStart()
  {
    this.isAutoScale = true;
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    paramScaleGestureDetector = this.mMainBrowserPresenter;
    if (paramScaleGestureDetector != null) {
      paramScaleGestureDetector.onScaleBegin();
    }
    if (canUpdateRegionRect()) {
      getRegionRectHelper().updateShowArea(this.mDrawable, this.mScaleMatrix, this.mDefaultScale, getScale(), this, false, this.mScrollDirection);
    }
    return true;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
  {
    paramScaleGestureDetector = this.mMainBrowserPresenter;
    if (paramScaleGestureDetector != null) {
      paramScaleGestureDetector.onScaleEnd();
    }
    float f = getScale();
    if ((f > this.mDefaultScale) && (f <= this.mMaxScale))
    {
      if (canUpdateRegionRect()) {
        getRegionRectHelper().updateShowArea(this.mDrawable, this.mScaleMatrix, this.mDefaultScale, getScale(), this, true, this.mScrollDirection);
      }
    }
    else {
      getRegionRectHelper().updateShowArea(this.mDrawable, this.mScaleMatrix, this.mDefaultScale, getScale(), this, false, this.mScrollDirection);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.mGestureDetector.onTouchEvent(paramMotionEvent)) {
      return true;
    }
    this.mScaleGestureDetector.onTouchEvent(paramMotionEvent);
    int j = paramMotionEvent.getPointerCount();
    int i = 0;
    float f2 = 0.0F;
    float f1 = 0.0F;
    while (i < j)
    {
      f2 += paramMotionEvent.getX(i);
      f1 += paramMotionEvent.getY(i);
      i += 1;
    }
    float f3 = j;
    f2 /= f3;
    f1 /= f3;
    if (this.mLastPointerCount != j)
    {
      this.mLastX = f2;
      this.mLastY = f1;
    }
    this.mLastPointerCount = j;
    paramView = getMatrixRectF();
    i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            return true;
          }
        }
        else
        {
          if (!handleMove(paramMotionEvent, f2, f1, j, paramView)) {
            break label180;
          }
          return false;
        }
      }
      handleCancel(paramMotionEvent);
      return true;
    }
    else
    {
      handleDown(paramMotionEvent, paramView);
    }
    label180:
    return true;
  }
  
  public void reset()
  {
    showDefaultImage(this.defaultDx, this.defaultDy, this.degrees, this.mDefaultScale, this.privorX, this.privorY);
  }
  
  public void setDoubleTapEnable(boolean paramBoolean)
  {
    this.isDoubleTapEnable = paramBoolean;
  }
  
  public void setMainBrowserPresenter(MainBrowserPresenter paramMainBrowserPresenter)
  {
    this.mMainBrowserPresenter = paramMainBrowserPresenter;
  }
  
  public void setOnItemEventListener(IBrowserItemClickEvent paramIBrowserItemClickEvent)
  {
    this.mItemEventListener = paramIBrowserItemClickEvent;
  }
  
  public void setScaleEnable(boolean paramBoolean)
  {
    this.isScaleEnable = paramBoolean;
  }
  
  public void startFling(float paramFloat1, float paramFloat2)
  {
    this.mScaleMatrix.postTranslate(paramFloat1, paramFloat2);
    setImageMatrix(this.mScaleMatrix);
  }
  
  public void startScale(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    Matrix localMatrix = this.mScaleMatrix;
    if (localMatrix != null)
    {
      localMatrix.postScale(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
      checkBorderAndCenterWhenScale();
      setImageMatrix(this.mScaleMatrix);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.recyclerview.BrowserScaleView
 * JD-Core Version:    0.7.0.1
 */