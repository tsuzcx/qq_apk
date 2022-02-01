package com.tencent.mtt.supportui.views.asyncimage;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.IntEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.mtt.supportui.adapters.image.IDrawableTarget;
import com.tencent.mtt.supportui.adapters.image.IImageLoaderAdapter;
import com.tencent.mtt.supportui.views.IBorder;

public class AsyncImageView
  extends ViewGroup
  implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener, IBorder
{
  public static final int FADE_DURATION = 150;
  protected static int SOURCE_TYPE_DEFAULT_SRC = 2;
  public static int SOURCE_TYPE_SRC = 1;
  private ValueAnimator mAlphaAnimator;
  protected BackgroundDrawable mBGDrawable;
  protected int mBoxShadowSpreadSize;
  protected int mBoxShadowX;
  protected int mBoxShadowY;
  protected Drawable mContentDrawable;
  private IDrawableTarget mDefaultSourceDrawable;
  public String mDefaultSourceUrl = null;
  private long mFadeDuration;
  private boolean mFadeEnable;
  protected IImageLoaderAdapter mImageAdapter;
  private int mImagePositionX;
  private int mImagePositionY;
  protected String mImageType = null;
  private boolean mIsAttached;
  protected boolean mIsUrlFetchSucceed;
  protected AsyncImageView.ScaleType mScaleType;
  public IDrawableTarget mSourceDrawable;
  protected int mTintColor;
  public String mUrl = null;
  
  public AsyncImageView(Context paramContext)
  {
    super(paramContext);
    setFadeEnabled(false);
    setFadeDuration(150L);
  }
  
  private void fetchImageByUrl(String paramString, int paramInt)
  {
    if (paramString == null) {}
    do
    {
      do
      {
        return;
      } while (this.mImageAdapter == null);
      if (!shouldUseFetchImageMode(paramString)) {
        break;
      }
      paramString = paramString.trim().replaceAll(" ", "%20");
    } while (!shouldFetchImage());
    onFetchImage(paramString);
    handleGetImageStart();
    doFetchImage(getFetchParam(), paramInt);
    return;
    handleGetImageStart();
    handleImageRequest(this.mImageAdapter.getImage(paramString, null), paramInt, null);
  }
  
  private BackgroundDrawable getBackGround()
  {
    Drawable localDrawable;
    if (this.mBGDrawable == null)
    {
      this.mBGDrawable = generateBackgroundDrawable();
      localDrawable = getBackground();
      super.setBackgroundDrawable(null);
      if (localDrawable != null) {
        break label42;
      }
      super.setBackgroundDrawable(this.mBGDrawable);
    }
    for (;;)
    {
      return this.mBGDrawable;
      label42:
      super.setBackgroundDrawable(new LayerDrawable(new Drawable[] { this.mBGDrawable, localDrawable }));
    }
  }
  
  protected void afterSetContent(String paramString) {}
  
  protected void applyTintColor(int paramInt)
  {
    if ((this.mContentDrawable instanceof ContentDrawable))
    {
      ((ContentDrawable)this.mContentDrawable).setTintColor(paramInt);
      invalidate();
    }
  }
  
  protected void doFetchImage(Object paramObject, int paramInt)
  {
    if (this.mImageAdapter != null) {
      if (paramInt != SOURCE_TYPE_SRC) {
        break label40;
      }
    }
    label40:
    for (String str = this.mUrl;; str = this.mDefaultSourceUrl)
    {
      this.mImageAdapter.fetchImage(str, new AsyncImageView.1(this, paramInt), paramObject);
      return;
    }
  }
  
  protected BackgroundDrawable generateBackgroundDrawable()
  {
    return new BackgroundDrawable();
  }
  
  protected ContentDrawable generateContentDrawable()
  {
    return new ContentDrawable();
  }
  
  protected Bitmap getBitmap()
  {
    if (this.mSourceDrawable != null) {
      return this.mSourceDrawable.getBitmap();
    }
    return null;
  }
  
  protected Object getFetchParam()
  {
    if (this.mSourceDrawable != null) {
      return this.mSourceDrawable.getExtraData();
    }
    return null;
  }
  
  protected int getTintColor()
  {
    return this.mTintColor;
  }
  
  public String getUrl()
  {
    return this.mUrl;
  }
  
  protected void handleGetImageFail(Throwable paramThrowable) {}
  
  protected void handleGetImageStart() {}
  
  protected void handleGetImageSuccess() {}
  
  protected void handleImageRequest(IDrawableTarget paramIDrawableTarget, int paramInt, Object paramObject)
  {
    if (paramIDrawableTarget == null)
    {
      this.mContentDrawable = null;
      if (paramInt == SOURCE_TYPE_SRC)
      {
        this.mSourceDrawable = null;
        this.mIsUrlFetchSucceed = false;
        if ((paramObject instanceof Throwable))
        {
          paramIDrawableTarget = (Throwable)paramObject;
          handleGetImageFail(paramIDrawableTarget);
        }
      }
      while (paramInt != SOURCE_TYPE_DEFAULT_SRC) {
        for (;;)
        {
          return;
          paramIDrawableTarget = null;
        }
      }
      this.mDefaultSourceDrawable = null;
      return;
    }
    this.mContentDrawable = generateContentDrawable();
    if (paramInt == SOURCE_TYPE_SRC)
    {
      this.mSourceDrawable = paramIDrawableTarget;
      this.mIsUrlFetchSucceed = true;
      handleGetImageSuccess();
    }
    for (;;)
    {
      setContent(paramInt);
      return;
      if (paramInt == SOURCE_TYPE_DEFAULT_SRC) {
        this.mDefaultSourceDrawable = paramIDrawableTarget;
      }
    }
  }
  
  protected boolean isAttached()
  {
    return this.mIsAttached;
  }
  
  public boolean isFadeEnabled()
  {
    return this.mFadeEnable;
  }
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (this.mFadeEnable)
    {
      if (this.mContentDrawable != null) {
        this.mContentDrawable.setAlpha(255);
      }
      restoreBackgroundColorAfterSetContent();
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.mFadeEnable) {
      restoreBackgroundColorAfterSetContent();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (this.mFadeEnable)
    {
      if ((!isAttached()) && (this.mAlphaAnimator != null)) {
        this.mAlphaAnimator.cancel();
      }
      if (this.mContentDrawable != null) {
        this.mContentDrawable.setAlpha(((Integer)paramValueAnimator.getAnimatedValue()).intValue());
      }
    }
  }
  
  protected void onAttachedToWindow()
  {
    this.mIsAttached = true;
    super.onAttachedToWindow();
    if (this.mDefaultSourceDrawable != null)
    {
      this.mDefaultSourceDrawable.onDrawableAttached();
      setContent(SOURCE_TYPE_DEFAULT_SRC);
      setUrl(this.mUrl);
    }
    if ((getBitmap() == null) || (!this.mIsUrlFetchSucceed)) {
      fetchImageByUrl(this.mUrl, SOURCE_TYPE_SRC);
    }
    onDrawableAttached();
  }
  
  protected void onDetachedFromWindow()
  {
    this.mIsAttached = false;
    if ((this.mFadeEnable) && (this.mAlphaAnimator != null)) {
      this.mAlphaAnimator.cancel();
    }
    super.onDetachedFromWindow();
    onDrawableDetached();
    if (this.mDefaultSourceDrawable != null) {
      this.mDefaultSourceDrawable.onDrawableDetached();
    }
  }
  
  protected void onDrawableAttached()
  {
    if (this.mSourceDrawable != null) {
      this.mSourceDrawable.onDrawableAttached();
    }
  }
  
  protected void onDrawableDetached()
  {
    if (this.mSourceDrawable != null) {
      this.mSourceDrawable.onDrawableDetached();
    }
  }
  
  protected void onFetchImage(String paramString) {}
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  protected void onSetContent(String paramString) {}
  
  protected void performFetchImage()
  {
    fetchImageByUrl(this.mUrl, SOURCE_TYPE_SRC);
  }
  
  protected void performSetContent()
  {
    setContent(SOURCE_TYPE_SRC);
  }
  
  protected void resetContent()
  {
    this.mContentDrawable = null;
    this.mBGDrawable = null;
    super.setBackgroundDrawable(null);
  }
  
  protected void resetFadeAnimation()
  {
    if (this.mFadeEnable)
    {
      if ((this.mAlphaAnimator != null) && (this.mAlphaAnimator.isRunning())) {
        this.mAlphaAnimator.cancel();
      }
      this.mAlphaAnimator = null;
    }
  }
  
  protected void restoreBackgroundColorAfterSetContent()
  {
    setBackgroundColor(0);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    getBackGround().setBackgroundColor(paramInt);
  }
  
  public void setBorderColor(int paramInt1, int paramInt2)
  {
    getBackGround().setBorderColor(paramInt1, paramInt2);
  }
  
  public void setBorderRadius(float paramFloat, int paramInt)
  {
    getBackGround().setBorderRadius(paramFloat, paramInt);
    if ((this.mContentDrawable instanceof ContentDrawable))
    {
      ((ContentDrawable)this.mContentDrawable).setBorder(this.mBGDrawable.getBorderRadiusArray(), this.mBGDrawable.getBorderWidthArray());
      invalidate();
    }
  }
  
  public void setBorderStyle(int paramInt)
  {
    getBackGround().setBorderStyle(paramInt);
  }
  
  public void setBorderWidth(float paramFloat, int paramInt)
  {
    getBackGround().setBorderWidth(paramFloat, paramInt);
    if ((this.mContentDrawable instanceof ContentDrawable))
    {
      ((ContentDrawable)this.mContentDrawable).setBorder(this.mBGDrawable.getBorderRadiusArray(), this.mBGDrawable.getBorderWidthArray());
      invalidate();
    }
  }
  
  public void setBoxShadowSpreadSize(int paramInt)
  {
    this.mBoxShadowSpreadSize = paramInt;
  }
  
  public void setBoxShadowX(int paramInt)
  {
    this.mBoxShadowX = paramInt;
  }
  
  public void setBoxShadowY(int paramInt)
  {
    this.mBoxShadowY = paramInt;
  }
  
  protected void setContent(int paramInt)
  {
    if ((this.mContentDrawable == null) || (!shouldSetContent())) {
      return;
    }
    onSetContent(this.mUrl);
    if ((paramInt == SOURCE_TYPE_SRC) && (this.mSourceDrawable != null))
    {
      updateContentDrawableProperty();
      if (this.mBGDrawable == null) {
        break label166;
      }
      if ((this.mContentDrawable instanceof ContentDrawable)) {
        ((ContentDrawable)this.mContentDrawable).setBorder(this.mBGDrawable.getBorderRadiusArray(), this.mBGDrawable.getBorderWidthArray());
      }
      setBackgroundDrawable(new LayerDrawable(new Drawable[] { this.mBGDrawable, this.mContentDrawable }));
    }
    for (;;)
    {
      afterSetContent(this.mUrl);
      return;
      if ((paramInt != SOURCE_TYPE_DEFAULT_SRC) || (this.mDefaultSourceDrawable == null) || (!(this.mContentDrawable instanceof ContentDrawable))) {
        break;
      }
      ((ContentDrawable)this.mContentDrawable).setBitmap(this.mDefaultSourceDrawable.getBitmap());
      break;
      label166:
      setBackgroundDrawable(this.mContentDrawable);
    }
  }
  
  protected void setCustomBackgroundDrawable(BackgroundDrawable paramBackgroundDrawable)
  {
    this.mBGDrawable = paramBackgroundDrawable;
    super.setBackgroundDrawable(this.mBGDrawable);
  }
  
  public void setDefaultSource(String paramString)
  {
    if (!TextUtils.equals(this.mDefaultSourceUrl, paramString))
    {
      this.mDefaultSourceUrl = paramString;
      fetchImageByUrl(this.mDefaultSourceUrl, SOURCE_TYPE_DEFAULT_SRC);
    }
  }
  
  public void setFadeDuration(long paramLong)
  {
    this.mFadeDuration = paramLong;
  }
  
  public void setFadeEnabled(boolean paramBoolean)
  {
    this.mFadeEnable = paramBoolean;
  }
  
  public void setImageAdapter(IImageLoaderAdapter paramIImageLoaderAdapter)
  {
    this.mImageAdapter = paramIImageLoaderAdapter;
  }
  
  public void setImagePositionX(int paramInt)
  {
    this.mImagePositionX = paramInt;
  }
  
  public void setImagePositionY(int paramInt)
  {
    this.mImagePositionY = paramInt;
  }
  
  public void setImageType(String paramString)
  {
    this.mImageType = paramString;
  }
  
  public void setScaleType(AsyncImageView.ScaleType paramScaleType)
  {
    this.mScaleType = paramScaleType;
  }
  
  public void setTintColor(int paramInt)
  {
    this.mTintColor = paramInt;
    applyTintColor(this.mTintColor);
  }
  
  public void setUrl(String paramString)
  {
    if (!TextUtils.equals(paramString, this.mUrl))
    {
      this.mUrl = paramString;
      this.mIsUrlFetchSucceed = false;
      if (isAttached())
      {
        onDrawableDetached();
        fetchImageByUrl(this.mUrl, SOURCE_TYPE_SRC);
      }
    }
  }
  
  protected boolean shouldFetchImage()
  {
    return true;
  }
  
  protected boolean shouldSetContent()
  {
    return true;
  }
  
  protected boolean shouldUseFetchImageMode(String paramString)
  {
    return true;
  }
  
  protected void startFadeAnimation()
  {
    if (this.mFadeEnable)
    {
      if ((this.mFadeDuration > 0L) && (this.mAlphaAnimator == null))
      {
        this.mAlphaAnimator = ValueAnimator.ofInt(new int[] { 0, 255 });
        this.mAlphaAnimator.setEvaluator(new IntEvaluator());
        this.mAlphaAnimator.addUpdateListener(this);
        this.mAlphaAnimator.addListener(this);
        this.mAlphaAnimator.setDuration(this.mFadeDuration);
      }
      if (this.mAlphaAnimator != null)
      {
        if (this.mAlphaAnimator.isRunning()) {
          this.mAlphaAnimator.cancel();
        }
        this.mAlphaAnimator.setCurrentPlayTime(0L);
        this.mAlphaAnimator.start();
      }
    }
  }
  
  protected void updateContentDrawableProperty()
  {
    if ((this.mContentDrawable instanceof ContentDrawable))
    {
      ((ContentDrawable)this.mContentDrawable).setBitmap(getBitmap());
      ((ContentDrawable)this.mContentDrawable).setTintColor(getTintColor());
      ((ContentDrawable)this.mContentDrawable).setScaleType(this.mScaleType);
      ((ContentDrawable)this.mContentDrawable).setImagePositionX(this.mImagePositionX);
      ((ContentDrawable)this.mContentDrawable).setImagePositionY(this.mImagePositionY);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.asyncimage.AsyncImageView
 * JD-Core Version:    0.7.0.1
 */