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
import com.tencent.richmediabrowser.listener.IBrowserFlingControlListener;
import com.tencent.richmediabrowser.listener.IBrowserFlingEventListener;
import com.tencent.richmediabrowser.listener.IBrowserItemEventListener;
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
  private int TURN_PAGE_MAX_DISTANCE;
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
  private IBrowserItemEventListener mItemEventListener;
  private int mLastPointerCount;
  private float mLastX;
  private float mLastY;
  private MainBrowserPresenter mMainBrowserPresenter;
  private float mMaxOverScale;
  private float mMaxScale;
  private float mMidScale;
  private float mMinScale;
  private float mNormalScale;
  private RegionRectHelper mRegionRectHelper;
  private ScaleGestureDetector mScaleGestureDetector;
  private Matrix mScaleMatrix;
  protected int mScrollDirection;
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
    this.TURN_PAGE_MAX_DISTANCE = ScreenUtils.dip2px(paramContext, 80.0F);
    this.mScaleGestureDetector = new ScaleGestureDetector(paramContext, this);
    setOnTouchListener(this);
    this.mGestureDetector = new GestureDetector(paramContext, new BrowserScaleView.1(this));
  }
  
  private boolean canUpdateRegionRect()
  {
    if (this.mDrawable == null) {
      return false;
    }
    int i = (int)(this.mDrawable.getIntrinsicWidth() * getScale());
    int j = (int)(this.mDrawable.getIntrinsicHeight() * getScale());
    return getRegionRectHelper().canUpdateRegionRect(i, j, this.mWidth, this.mHeight);
  }
  
  private void checkBorderAndCenterWhenScale()
  {
    float f2 = 0.0F;
    float f3 = 0.0F;
    if (this.mDrawable == null) {
      return;
    }
    RectF localRectF = getMatrixRectF();
    if (localRectF.width() >= this.mWidth) {
      if (localRectF.left > 0.0F)
      {
        f1 = -localRectF.left;
        if (localRectF.right >= this.mWidth) {}
      }
    }
    for (float f1 = this.mWidth - localRectF.right;; f1 = 0.0F)
    {
      if (localRectF.height() >= this.mHeight)
      {
        f2 = f3;
        if (localRectF.top > 0.0F) {
          f2 = -localRectF.top;
        }
        if (localRectF.bottom < this.mHeight) {
          f2 = this.mHeight - localRectF.bottom;
        }
      }
      if (localRectF.width() < this.mWidth) {
        f1 = this.mWidth / 2.0F - localRectF.right + localRectF.width() / 2.0F;
      }
      if (localRectF.height() < this.mHeight) {
        f2 = this.mHeight / 2.0F - localRectF.bottom + localRectF.height() / 2.0F;
      }
      this.mScaleMatrix.postTranslate(f1, f2);
      return;
      f1 = 0.0F;
      break;
    }
  }
  
  private void checkBorderWhenTranslate()
  {
    float f2 = 0.0F;
    float f3 = 0.0F;
    RectF localRectF = getMatrixRectF();
    if (this.isCheckLeftAndRight) {
      if (localRectF.left > 0.0F)
      {
        f1 = -localRectF.left;
        if (localRectF.right >= this.mWidth) {}
      }
    }
    for (float f1 = this.mWidth - localRectF.right;; f1 = 0.0F)
    {
      if (this.isCheckTopAndBottom)
      {
        f2 = f3;
        if (localRectF.top > 0.0F) {
          f2 = -localRectF.top;
        }
        if (localRectF.bottom < this.mHeight) {
          f2 = this.mHeight - localRectF.bottom;
        }
      }
      this.mScaleMatrix.postTranslate(f1, f2);
      return;
      f1 = 0.0F;
      break;
    }
  }
  
  private void dealScaleEvent()
  {
    if (!this.isAutoScale)
    {
      if (!isVerticalLongPhoto(this.degrees)) {
        break label88;
      }
      if (getScale() != this.mNormalScale) {
        break label53;
      }
      this.isCheckLeftAndRight = false;
      this.isCheckTopAndBottom = true;
      checkBorderWhenTranslate();
      setImageMatrix(this.mScaleMatrix);
    }
    label53:
    label88:
    do
    {
      return;
      if (getScale() < this.mNormalScale)
      {
        startScale(this.mNormalScale, this.mWidth / 2, this.mHeight / 2);
        return;
        if (getScale() < this.mDefaultScale) {
          startScale(this.mDefaultScale, this.mWidth / 2, this.mHeight / 2);
        }
      }
    } while (getScale() <= this.mMaxScale);
    startScale(this.mMaxScale, this.mWidth / 2, this.mHeight / 2);
  }
  
  private boolean enableScrollLeft()
  {
    return (this.mMainBrowserPresenter != null) && (this.mMainBrowserPresenter.enableScrollLeft());
  }
  
  private boolean enableScrollRight()
  {
    return (this.mMainBrowserPresenter != null) && (this.mMainBrowserPresenter.enableScrollRight());
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
    if (this.mScaleMatrix != null)
    {
      this.mScaleMatrix.getValues(arrayOfFloat);
      if (isHorizonRotate(this.degrees)) {
        return Math.abs(arrayOfFloat[1]);
      }
      return Math.abs(arrayOfFloat[0]);
    }
    return this.mDefaultScale;
  }
  
  private void initScaleValue(float paramFloat)
  {
    this.mDefaultScale = paramFloat;
    if (isHorizonLongPhoto()) {
      this.mMaxScale = (this.mDrawable.getIntrinsicWidth() * 1.0F / this.mWidth);
    }
    for (this.mMaxOverScale = (this.mMaxScale * 1.1F);; this.mMaxOverScale = (this.mMaxScale * 5.0F))
    {
      this.mMidScale = (this.mDefaultScale * 2.0F);
      this.mMinScale = (this.mDefaultScale * 0.6F);
      return;
      this.mMaxScale = (this.mDefaultScale * 4.0F);
    }
  }
  
  private boolean isHorizonLongPhoto()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mDrawable != null)
    {
      bool1 = bool2;
      if (this.mDrawable.getIntrinsicWidth() >= this.mDrawable.getIntrinsicHeight() * 3L) {
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
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mDrawable != null)
    {
      long l = this.mDrawable.getIntrinsicWidth();
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
    if (this.mMainBrowserPresenter != null) {
      this.mMainBrowserPresenter.requestDisallowInterceptDragEvent(paramBoolean);
    }
  }
  
  private void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    if (this.mMainBrowserPresenter != null) {
      this.mMainBrowserPresenter.requestDisallowInterceptTouchEvent(paramBoolean);
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
    paramFloat2 = this.mDrawable.getIntrinsicWidth() * (1.0F - paramFloat1) / 2.0F;
    paramFloat1 = this.mDrawable.getIntrinsicHeight() * (1.0F - paramFloat1) / 2.0F;
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
    BrowserLogHelper.getInstance().getGalleryLog().i("BrowserScaleView", 2, "startFling...velocityX = " + paramInt3 + ", velocityY = " + paramInt4);
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
    if (this.mDrawable == null) {
      return;
    }
    int j = this.mDrawable.getIntrinsicWidth();
    int i = this.mDrawable.getIntrinsicHeight();
    int k;
    if (isHorizonRotate(paramInt3))
    {
      i = this.mDrawable.getIntrinsicHeight();
      k = this.mDrawable.getIntrinsicWidth();
      j = i;
    }
    for (;;)
    {
      if ((j >= paramInt1) && (k <= paramInt2)) {}
      for (float f2 = paramInt1 * 1.0F / j;; f2 = 1.0F)
      {
        float f1 = f2;
        if (j <= paramInt1)
        {
          f1 = f2;
          if (k >= paramInt2)
          {
            if (!isVerticalLongPhoto(paramInt3)) {
              break label470;
            }
            f1 = paramInt1 * 1.0F / j;
          }
        }
        f2 = f1;
        if (j <= paramInt1)
        {
          f2 = f1;
          if (k <= paramInt2)
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
          if (k >= paramInt2) {
            if (!isVerticalLongPhoto(paramInt3)) {
              break label483;
            }
          }
        }
        label470:
        label483:
        for (f1 = paramInt1 * 1.0F / j;; f1 = Math.min(paramInt1 * 1.0F / j, paramInt2 * 1.0F / k))
        {
          BrowserLogHelper.getInstance().getGalleryLog().d("BrowserScaleView", 4, "dw = " + j + ", dh = " + k + "， width = " + paramInt1 + ", height" + paramInt2 + ", degrees = " + paramInt3 + ", scale = " + f1);
          this.defaultDx = (paramInt1 / 2 - this.mDrawable.getIntrinsicWidth() / 2);
          this.defaultDy = (paramInt2 / 2 - this.mDrawable.getIntrinsicHeight() / 2);
          this.privorX = (this.mDrawable.getIntrinsicWidth() / 2);
          this.privorY = (this.mDrawable.getIntrinsicHeight() / 2);
          showDefaultImage(this.defaultDx, this.defaultDy, paramInt3, f1, this.privorX, this.privorY);
          if (!isVerticalLongPhoto(paramInt3)) {
            break label507;
          }
          this.mDefaultScale = f1;
          this.mNormalScale = (paramInt2 * 1.0F / k);
          this.mMinScale = (this.mNormalScale * 0.6F);
          this.mMaxScale = (this.mDefaultScale * 4.0F);
          this.mMaxOverScale = (this.mMaxScale * 5.0F);
          return;
          f1 = paramInt2 * 1.0F / k;
          break;
        }
        label507:
        initScaleValue(f1);
        return;
      }
      k = i;
    }
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
    if (!this.isScaleEnable) {}
    while (this.mDrawable == null) {
      return false;
    }
    if (this.mMainBrowserPresenter != null) {
      this.mMainBrowserPresenter.onScale();
    }
    float f2 = paramScaleGestureDetector.getScaleFactor();
    float f3 = getScale();
    if (((f2 > 1.0F) && (f3 * f2 < this.mMaxOverScale)) || ((f2 < 1.0F) && (f3 * f2 > this.mMinScale)))
    {
      float f1 = f2;
      if (f3 * f2 > this.mMaxOverScale) {
        f1 = this.mMaxOverScale / f3;
      }
      f2 = f1;
      if (f3 * f1 < this.mMinScale) {
        f2 = this.mMinScale / f3;
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
    if (this.mMainBrowserPresenter != null) {
      this.mMainBrowserPresenter.onScaleBegin();
    }
    if (canUpdateRegionRect()) {
      getRegionRectHelper().updateShowArea(this.mDrawable, this.mScaleMatrix, this.mDefaultScale, getScale(), this, false, this.mScrollDirection);
    }
    return true;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (this.mMainBrowserPresenter != null) {
      this.mMainBrowserPresenter.onScaleEnd();
    }
    float f = getScale();
    if ((f > this.mDefaultScale) && (f <= this.mMaxScale))
    {
      if (canUpdateRegionRect()) {
        getRegionRectHelper().updateShowArea(this.mDrawable, this.mScaleMatrix, this.mDefaultScale, getScale(), this, true, this.mScrollDirection);
      }
      return;
    }
    getRegionRectHelper().updateShowArea(this.mDrawable, this.mScaleMatrix, this.mDefaultScale, getScale(), this, false, this.mScrollDirection);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.mGestureDetector.onTouchEvent(paramMotionEvent)) {}
    int j;
    float f2;
    float f6;
    float f7;
    do
    {
      return true;
      this.mScaleGestureDetector.onTouchEvent(paramMotionEvent);
      j = paramMotionEvent.getPointerCount();
      int i = 0;
      f1 = 0.0F;
      f2 = 0.0F;
      while (i < j)
      {
        f2 += paramMotionEvent.getX(i);
        f1 += paramMotionEvent.getY(i);
        i += 1;
      }
      f6 = f2 / j;
      f7 = f1 / j;
      if (this.mLastPointerCount != j)
      {
        this.mLastX = f6;
        this.mLastY = f7;
      }
      this.mLastPointerCount = j;
      paramView = getMatrixRectF();
      switch (paramMotionEvent.getAction())
      {
      default: 
        return true;
      case 0: 
        this.mVelocityTracker = VelocityTracker.obtain();
        if (this.mVelocityTracker != null) {
          this.mVelocityTracker.addMovement(paramMotionEvent);
        }
        if (this.mFlingAnimator != null)
        {
          this.mFlingAnimator.cancelFling();
          this.mFlingAnimator = null;
        }
        break;
      }
    } while ((paramView.width() <= this.mWidth) && (paramView.height() <= this.mHeight));
    requestDisallowInterceptTouchEvent(true);
    return true;
    float f4 = f6 - this.mLastX;
    float f5 = f7 - this.mLastY;
    if ((getScale() == this.mDefaultScale) && (!isVerticalLongPhoto(this.degrees)))
    {
      if (((f4 > 0.0F) && (enableScrollLeft())) || ((f4 < 0.0F) && (enableScrollRight())))
      {
        requestDisallowInterceptTouchEvent(false);
        return false;
      }
    }
    else if ((paramView.width() > this.mWidth) || (paramView.height() > this.mHeight)) {
      requestDisallowInterceptTouchEvent(true);
    }
    float f1 = f5;
    float f3 = f4;
    if (this.mDrawable != null)
    {
      if (this.mVelocityTracker != null) {
        this.mVelocityTracker.addMovement(paramMotionEvent);
      }
      this.isCheckLeftAndRight = true;
      this.isCheckTopAndBottom = true;
      f1 = f5;
      f2 = f4;
      if (paramView.width() < this.mWidth)
      {
        f1 = f5;
        f2 = f4;
        if (paramView.height() < this.mHeight)
        {
          this.isCheckLeftAndRight = false;
          this.isCheckTopAndBottom = false;
          f1 = 0.0F;
          f2 = 0.0F;
        }
      }
      f3 = f2;
      if (paramView.left > 0.0F)
      {
        if (!enableScrollLeft()) {
          break label689;
        }
        f3 = f2;
        if (Math.abs(paramView.left) > this.TURN_PAGE_MAX_DISTANCE)
        {
          requestDisallowInterceptTouchEvent(false);
          requestDisallowInterceptDragEvent(true);
          f3 = 0.0F;
        }
      }
      f2 = f3;
      if (paramView.right < this.mWidth)
      {
        if (!enableScrollRight()) {
          break label724;
        }
        f2 = f3;
        if (Math.abs(this.mWidth - paramView.right) > this.TURN_PAGE_MAX_DISTANCE)
        {
          requestDisallowInterceptTouchEvent(false);
          requestDisallowInterceptDragEvent(true);
          f2 = 0.0F;
        }
      }
      label545:
      if (getScale() != this.mDefaultScale) {
        break label765;
      }
      f3 = f2;
      if (!isVerticalLongPhoto(this.degrees))
      {
        f1 = 0.0F;
        f3 = f2;
      }
    }
    for (;;)
    {
      f2 = f3;
      if (!isVerticalLongPhoto(this.degrees)) {
        break label933;
      }
      if ((getScale() != this.mDefaultScale) && (getScale() != this.mNormalScale))
      {
        f2 = f3;
        if (getScale() <= this.mNormalScale) {
          break label933;
        }
        f2 = f3;
        if (getScale() >= this.mDefaultScale) {
          break label933;
        }
      }
      if ((Math.abs(f3) / Math.abs(f1) < 6.0F) || (Math.abs(f1) >= 10.0F)) {
        break label875;
      }
      requestDisallowInterceptTouchEvent(false);
      requestDisallowInterceptDragEvent(true);
      return false;
      label689:
      requestDisallowInterceptTouchEvent(true);
      f3 = f2;
      if (Math.abs(paramView.left) <= this.mWidth / 4.0F) {
        break;
      }
      f3 = 0.0F;
      break;
      label724:
      requestDisallowInterceptTouchEvent(true);
      f2 = f3;
      if (Math.abs(this.mWidth - paramView.right) <= this.mWidth / 4.0F) {
        break label545;
      }
      f2 = 0.0F;
      break label545;
      label765:
      f4 = f1;
      if (paramView.top > 0.0F)
      {
        f4 = f1;
        if (Math.abs(paramView.top) > this.mWidth / 4.0F)
        {
          requestDisallowInterceptDragEvent(false);
          f4 = 0.0F;
        }
      }
      f1 = f4;
      f3 = f2;
      if (paramView.bottom < this.mHeight)
      {
        f1 = f4;
        f3 = f2;
        if (Math.abs(this.mHeight - paramView.bottom) > this.mWidth / 4.0F)
        {
          requestDisallowInterceptDragEvent(true);
          f1 = 0.0F;
          f3 = f2;
        }
      }
    }
    label875:
    if ((j < 2) && (paramView.top > 0.0F) && (Math.abs(f1) / Math.abs(f3) >= 6.0F) && (Math.abs(f3) < 10.0F))
    {
      requestDisallowInterceptTouchEvent(true);
      requestDisallowInterceptDragEvent(false);
      f2 = f3;
      if (this.mScaleMatrix != null)
      {
        this.mScaleMatrix.postTranslate(f2, f1);
        setImageMatrix(this.mScaleMatrix);
      }
      if (canUpdateRegionRect())
      {
        if (f2 != 0.0F) {
          break label1028;
        }
        this.mScrollDirection = 0;
      }
    }
    for (;;)
    {
      label933:
      getRegionRectHelper().updateShowArea(this.mDrawable, this.mScaleMatrix, this.mDefaultScale, getScale(), this, true, 1, this.mScrollDirection);
      this.mLastX = f6;
      this.mLastY = f7;
      return true;
      f2 = 0.0F;
      break;
      label1028:
      if (f2 < 0.0F) {
        this.mScrollDirection = 1;
      } else {
        this.mScrollDirection = 2;
      }
    }
    this.mLastPointerCount = 0;
    BrowserLogHelper.getInstance().getGalleryLog().i("BrowserScaleView", 2, "onTouch...action = " + paramMotionEvent.getAction());
    dealScaleEvent();
    if ((isNeedRebound()) && (getScale() == this.mDefaultScale)) {
      if (isVerticalLongPhoto(this.degrees))
      {
        checkBorderWhenTranslate();
        setImageMatrix(this.mScaleMatrix);
      }
    }
    for (;;)
    {
      this.mScrollDirection = 0;
      if (canUpdateRegionRect()) {
        getRegionRectHelper().updateShowArea(this.mDrawable, this.mScaleMatrix, this.mDefaultScale, getScale(), this, true, this.mScrollDirection);
      }
      if (this.mVelocityTracker == null) {
        break;
      }
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
      return true;
      reset();
      continue;
      if (this.mVelocityTracker != null)
      {
        this.mVelocityTracker.addMovement(paramMotionEvent);
        this.mVelocityTracker.computeCurrentVelocity(1000);
        f1 = this.mVelocityTracker.getXVelocity();
        f2 = this.mVelocityTracker.getYVelocity();
        startFling(this.mWidth, this.mHeight, (int)-f1, (int)-f2);
      }
    }
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
  
  public void setOnItemEventListener(IBrowserItemEventListener paramIBrowserItemEventListener)
  {
    this.mItemEventListener = paramIBrowserItemEventListener;
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
    if (this.mScaleMatrix != null)
    {
      this.mScaleMatrix.postScale(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
      checkBorderAndCenterWhenScale();
      setImageMatrix(this.mScaleMatrix);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.recyclerview.BrowserScaleView
 * JD-Core Version:    0.7.0.1
 */