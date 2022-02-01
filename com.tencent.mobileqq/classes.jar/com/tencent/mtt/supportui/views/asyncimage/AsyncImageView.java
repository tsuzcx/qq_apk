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
import com.tencent.mtt.supportui.views.IShadow;

public class AsyncImageView
  extends ViewGroup
  implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener, IBorder, IShadow
{
  public static final int FADE_DURATION = 150;
  public static final int IMAGE_LOADED = 2;
  public static final int IMAGE_LOADING = 1;
  public static final int IMAGE_UNLOAD = 0;
  protected static final int SOURCE_TYPE_DEFAULT_SRC = 2;
  protected static final int SOURCE_TYPE_SRC = 1;
  private ValueAnimator mAlphaAnimator;
  protected BackgroundDrawable mBGDrawable;
  protected Drawable mContentDrawable;
  private IDrawableTarget mDefaultSourceDrawable;
  protected String mDefaultSourceUrl = null;
  private long mFadeDuration;
  private boolean mFadeEnable;
  protected IImageLoaderAdapter mImageAdapter;
  private int mImagePositionX;
  private int mImagePositionY;
  protected String mImageType = null;
  private boolean mIsAttached;
  protected AsyncImageView.ScaleType mScaleType;
  protected IDrawableTarget mSourceDrawable;
  protected int mTintColor;
  protected String mUrl = null;
  protected int mUrlFetchState = 0;
  
  public AsyncImageView(Context paramContext)
  {
    super(paramContext);
    setFadeEnabled(false);
    setFadeDuration(150L);
  }
  
  private void fetchImageByUrl(String paramString, int paramInt)
  {
    if (paramString == null) {
      return;
    }
    if (this.mImageAdapter != null)
    {
      if (shouldUseFetchImageMode(paramString))
      {
        paramString = paramString.trim().replaceAll(" ", "%20");
        if (paramInt == 1)
        {
          if (!shouldFetchImage()) {
            return;
          }
          this.mUrlFetchState = 1;
        }
        onFetchImage(paramString);
        handleGetImageStart();
        doFetchImage(getFetchParam(), paramInt);
        return;
      }
      handleGetImageStart();
      handleImageRequest(this.mImageAdapter.getImage(paramString, null), paramInt, null);
    }
  }
  
  private BackgroundDrawable getBackGround()
  {
    if (this.mBGDrawable == null)
    {
      this.mBGDrawable = generateBackgroundDrawable();
      Drawable localDrawable = getBackground();
      super.setBackgroundDrawable(null);
      if (localDrawable == null) {
        super.setBackgroundDrawable(this.mBGDrawable);
      } else {
        super.setBackgroundDrawable(new LayerDrawable(new Drawable[] { this.mBGDrawable, localDrawable }));
      }
    }
    return this.mBGDrawable;
  }
  
  protected void afterSetContent(String paramString) {}
  
  protected void applyTintColor(int paramInt)
  {
    Drawable localDrawable = this.mContentDrawable;
    if ((localDrawable instanceof ContentDrawable))
    {
      ((ContentDrawable)localDrawable).setTintColor(paramInt);
      invalidate();
    }
  }
  
  protected void doFetchImage(Object paramObject, int paramInt)
  {
    if (this.mImageAdapter != null)
    {
      String str;
      if (paramInt == 1) {
        str = this.mUrl;
      } else {
        str = this.mDefaultSourceUrl;
      }
      this.mImageAdapter.fetchImage(str, new AsyncImageView.1(this, paramInt), paramObject);
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
    IDrawableTarget localIDrawableTarget = this.mSourceDrawable;
    if (localIDrawableTarget != null) {
      return localIDrawableTarget.getBitmap();
    }
    return null;
  }
  
  protected Object getFetchParam()
  {
    IDrawableTarget localIDrawableTarget = this.mSourceDrawable;
    if (localIDrawableTarget != null) {
      return localIDrawableTarget.getExtraData();
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
      paramIDrawableTarget = null;
      if (paramInt == 1)
      {
        this.mSourceDrawable = null;
        if (this.mDefaultSourceDrawable != null)
        {
          if (this.mContentDrawable == null) {
            this.mContentDrawable = generateContentDrawable();
          }
          setContent(2);
        }
        else
        {
          this.mContentDrawable = null;
        }
        if ((paramObject instanceof Throwable)) {
          paramIDrawableTarget = (Throwable)paramObject;
        }
        handleGetImageFail(paramIDrawableTarget);
        return;
      }
      if (paramInt == 2) {
        this.mDefaultSourceDrawable = null;
      }
    }
    else
    {
      this.mContentDrawable = generateContentDrawable();
      if (paramInt == 1)
      {
        this.mSourceDrawable = paramIDrawableTarget;
        handleGetImageSuccess();
      }
      else if (paramInt == 2)
      {
        this.mDefaultSourceDrawable = paramIDrawableTarget;
      }
      setContent(paramInt);
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
      paramAnimator = this.mContentDrawable;
      if (paramAnimator != null) {
        paramAnimator.setAlpha(255);
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
      if (!isAttached())
      {
        localObject = this.mAlphaAnimator;
        if (localObject != null) {
          ((ValueAnimator)localObject).cancel();
        }
      }
      Object localObject = this.mContentDrawable;
      if (localObject != null) {
        ((Drawable)localObject).setAlpha(((Integer)paramValueAnimator.getAnimatedValue()).intValue());
      }
    }
  }
  
  protected void onAttachedToWindow()
  {
    this.mIsAttached = true;
    super.onAttachedToWindow();
    if ((this.mDefaultSourceDrawable != null) && (shouldFetchImage()))
    {
      this.mDefaultSourceDrawable.onDrawableAttached();
      setContent(2);
    }
    fetchImageByUrl(this.mUrl, 1);
    onDrawableAttached();
  }
  
  protected void onDetachedFromWindow()
  {
    this.mIsAttached = false;
    if (this.mFadeEnable)
    {
      localObject = this.mAlphaAnimator;
      if (localObject != null) {
        ((ValueAnimator)localObject).cancel();
      }
    }
    super.onDetachedFromWindow();
    onDrawableDetached();
    Object localObject = this.mDefaultSourceDrawable;
    if (localObject != null) {
      ((IDrawableTarget)localObject).onDrawableDetached();
    }
  }
  
  protected void onDrawableAttached()
  {
    IDrawableTarget localIDrawableTarget = this.mSourceDrawable;
    if (localIDrawableTarget != null) {
      localIDrawableTarget.onDrawableAttached();
    }
  }
  
  protected void onDrawableDetached()
  {
    IDrawableTarget localIDrawableTarget = this.mSourceDrawable;
    if (localIDrawableTarget != null) {
      localIDrawableTarget.onDrawableDetached();
    }
  }
  
  protected void onFetchImage(String paramString) {}
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  protected void onSetContent(String paramString) {}
  
  protected void performFetchImage()
  {
    fetchImageByUrl(this.mUrl, 1);
  }
  
  protected void performSetContent()
  {
    setContent(1);
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
      ValueAnimator localValueAnimator = this.mAlphaAnimator;
      if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
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
    Drawable localDrawable = this.mContentDrawable;
    if ((localDrawable instanceof ContentDrawable))
    {
      ((ContentDrawable)localDrawable).setBorder(this.mBGDrawable.getBorderRadiusArray(), this.mBGDrawable.getBorderWidthArray());
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
    Drawable localDrawable = this.mContentDrawable;
    if ((localDrawable instanceof ContentDrawable))
    {
      ((ContentDrawable)localDrawable).setBorder(this.mBGDrawable.getBorderRadiusArray(), this.mBGDrawable.getBorderWidthArray());
      invalidate();
    }
  }
  
  protected void setContent(int paramInt)
  {
    if (this.mContentDrawable != null)
    {
      if (!shouldSetContent()) {
        return;
      }
      onSetContent(this.mUrl);
      updateContentDrawableProperty(paramInt);
      Object localObject = this.mBGDrawable;
      if (localObject != null)
      {
        Drawable localDrawable = this.mContentDrawable;
        if ((localDrawable instanceof ContentDrawable))
        {
          ((ContentDrawable)localDrawable).setBorder(((BackgroundDrawable)localObject).getBorderRadiusArray(), this.mBGDrawable.getBorderWidthArray());
          ((ContentDrawable)this.mContentDrawable).setShadowOffsetX(this.mBGDrawable.getShadowOffsetX());
          ((ContentDrawable)this.mContentDrawable).setShadowOffsetY(this.mBGDrawable.getShadowOffsetY());
          ((ContentDrawable)this.mContentDrawable).setShadowRadius(this.mBGDrawable.getShadowRadius());
        }
        localObject = new LayerDrawable(new Drawable[] { this.mBGDrawable, this.mContentDrawable });
      }
      else
      {
        localObject = this.mContentDrawable;
      }
      setBackgroundDrawable((Drawable)localObject);
      afterSetContent(this.mUrl);
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
      fetchImageByUrl(this.mDefaultSourceUrl, 2);
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
  
  public void setShadowColor(int paramInt)
  {
    getBackGround().setShadowColor(paramInt);
  }
  
  public void setShadowOffsetX(float paramFloat)
  {
    getBackGround().setShadowOffsetX(paramFloat);
  }
  
  public void setShadowOffsetY(float paramFloat)
  {
    getBackGround().setShadowOffsetY(paramFloat);
  }
  
  public void setShadowOpacity(float paramFloat)
  {
    getBackGround().setShadowOpacity(paramFloat);
  }
  
  public void setShadowRadius(float paramFloat)
  {
    getBackGround().setShadowRadius(Math.abs(paramFloat));
    if (paramFloat != 0.0F) {
      setLayerType(1, null);
    }
  }
  
  public void setShadowSpread(float paramFloat) {}
  
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
      this.mUrlFetchState = 0;
      if (isAttached())
      {
        onDrawableDetached();
        fetchImageByUrl(this.mUrl, 1);
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
      ValueAnimator localValueAnimator = this.mAlphaAnimator;
      if (localValueAnimator != null)
      {
        if (localValueAnimator.isRunning()) {
          this.mAlphaAnimator.cancel();
        }
        this.mAlphaAnimator.setCurrentPlayTime(0L);
        this.mAlphaAnimator.start();
      }
    }
  }
  
  protected void updateContentDrawableProperty(int paramInt)
  {
    if (!(this.mContentDrawable instanceof ContentDrawable)) {
      return;
    }
    Object localObject2 = null;
    Object localObject1;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        localObject1 = localObject2;
      }
      else
      {
        localObject1 = localObject2;
        if (this.mDefaultSourceDrawable != null) {
          if (this.mUrlFetchState == 2)
          {
            localObject1 = localObject2;
            if (this.mSourceDrawable != null) {}
          }
          else
          {
            localObject1 = this.mDefaultSourceDrawable.getBitmap();
          }
        }
      }
    }
    else
    {
      IDrawableTarget localIDrawableTarget = this.mSourceDrawable;
      localObject1 = localObject2;
      if (localIDrawableTarget != null) {
        localObject1 = localIDrawableTarget.getBitmap();
      }
    }
    if (localObject1 != null)
    {
      ((ContentDrawable)this.mContentDrawable).setSourceType(paramInt);
      ((ContentDrawable)this.mContentDrawable).setBitmap((Bitmap)localObject1);
      ((ContentDrawable)this.mContentDrawable).setTintColor(getTintColor());
      ((ContentDrawable)this.mContentDrawable).setScaleType(this.mScaleType);
      ((ContentDrawable)this.mContentDrawable).setImagePositionX(this.mImagePositionX);
      ((ContentDrawable)this.mContentDrawable).setImagePositionY(this.mImagePositionY);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.asyncimage.AsyncImageView
 * JD-Core Version:    0.7.0.1
 */