package com.tencent.mobileqq.dinifly;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.FloatRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.BaseSavedState;
import android.widget.ImageView;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.dinifly.utils.Utils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class DiniFlyAnimationView
  extends ImageView
{
  private static final Map<String, LottieComposition> STRONG_REF_CACHE = new HashMap();
  private static final String TAG = "DiniFlyAnimationView";
  private static final Map<String, WeakReference<LottieComposition>> WEAK_REF_CACHE = new HashMap();
  private String animationName;
  private boolean autoPlay = false;
  @Nullable
  private LottieComposition composition;
  @Nullable
  private Cancellable compositionLoader;
  private int defaultCacheStrategy;
  private boolean fitFullscreenXY = false;
  private boolean fobiddenLayer;
  private final OnCompositionLoadedListener loadedListener = new OnCompositionLoadedListener()
  {
    public void onCompositionLoaded(@Nullable LottieComposition paramAnonymousLottieComposition)
    {
      if (paramAnonymousLottieComposition != null) {
        DiniFlyAnimationView.this.setComposition(paramAnonymousLottieComposition);
      }
      DiniFlyAnimationView.access$002(DiniFlyAnimationView.this, null);
    }
  };
  private final LottieDrawable lottieDrawable = new LottieDrawable();
  private boolean useHardwareLayer = false;
  private boolean wasAnimatingWhenDetached = false;
  
  public DiniFlyAnimationView(Context paramContext)
  {
    super(paramContext);
    init(null);
  }
  
  public DiniFlyAnimationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramAttributeSet);
  }
  
  public DiniFlyAnimationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramAttributeSet);
  }
  
  private void cancelLoaderTask()
  {
    if (this.compositionLoader != null)
    {
      this.compositionLoader.cancel();
      this.compositionLoader = null;
    }
  }
  
  private void enableOrDisableHardwareLayer()
  {
    int j = 1;
    int k = 0;
    if (this.fobiddenLayer)
    {
      setLayerType(0, null);
      return;
    }
    int i = k;
    if (this.useHardwareLayer)
    {
      i = k;
      if (this.lottieDrawable.isAnimating()) {
        i = 1;
      }
    }
    if (i != 0) {
      j = 2;
    }
    setLayerType(j, null);
  }
  
  private void init(@Nullable AttributeSet paramAttributeSet)
  {
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.DiniFlyAnimationView);
    this.defaultCacheStrategy = paramAttributeSet.getInt(R.styleable.DiniFlyAnimationView_dinifly_cacheStrategy, 1);
    String str = paramAttributeSet.getString(R.styleable.DiniFlyAnimationView_dinifly_fileName);
    if ((!isInEditMode()) && (str != null)) {
      setAnimation(str);
    }
    if (paramAttributeSet.getBoolean(R.styleable.DiniFlyAnimationView_dinifly_autoPlay, false))
    {
      this.lottieDrawable.playAnimation();
      this.autoPlay = true;
    }
    this.lottieDrawable.loop(paramAttributeSet.getBoolean(R.styleable.DiniFlyAnimationView_dinifly_loop, false));
    setImageAssetsFolder(paramAttributeSet.getString(R.styleable.DiniFlyAnimationView_dinifly_imageAssetsFolder));
    setProgress(paramAttributeSet.getFloat(R.styleable.DiniFlyAnimationView_dinifly_progress, 0.0F));
    enableMergePathsForKitKatAndAbove(paramAttributeSet.getBoolean(R.styleable.DiniFlyAnimationView_dinifly_enableMergePathsForKitKatAndAbove, false));
    if (paramAttributeSet.hasValue(R.styleable.DiniFlyAnimationView_dinifly_colorFilter)) {
      addColorFilter(new SimpleColorFilter(paramAttributeSet.getColor(R.styleable.DiniFlyAnimationView_dinifly_colorFilter, 0)));
    }
    if (paramAttributeSet.hasValue(R.styleable.DiniFlyAnimationView_dinifly_scale)) {
      this.lottieDrawable.setScale(paramAttributeSet.getFloat(R.styleable.DiniFlyAnimationView_dinifly_scale, 1.0F), paramAttributeSet.getFloat(R.styleable.DiniFlyAnimationView_dinifly_scale, 1.0F));
    }
    paramAttributeSet.recycle();
    if (Utils.getAnimationScale(getContext()) == 0.0F) {
      this.lottieDrawable.systemAnimationsAreDisabled();
    }
    enableOrDisableHardwareLayer();
  }
  
  public void addAnimatorListener(Animator.AnimatorListener paramAnimatorListener)
  {
    this.lottieDrawable.addAnimatorListener(paramAnimatorListener);
  }
  
  public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener)
  {
    this.lottieDrawable.addAnimatorUpdateListener(paramAnimatorUpdateListener);
  }
  
  public void addColorFilter(@Nullable ColorFilter paramColorFilter)
  {
    this.lottieDrawable.addColorFilter(paramColorFilter);
  }
  
  public void addColorFilterToContent(String paramString1, String paramString2, @Nullable ColorFilter paramColorFilter)
  {
    this.lottieDrawable.addColorFilterToContent(paramString1, paramString2, paramColorFilter);
  }
  
  public void addColorFilterToLayer(String paramString, @Nullable ColorFilter paramColorFilter)
  {
    this.lottieDrawable.addColorFilterToLayer(paramString, paramColorFilter);
  }
  
  public void cancelAnimation()
  {
    this.lottieDrawable.cancelAnimation();
    enableOrDisableHardwareLayer();
  }
  
  public void clearColorFilters()
  {
    this.lottieDrawable.clearColorFilters();
  }
  
  public void enableMergePathsForKitKatAndAbove(boolean paramBoolean)
  {
    this.lottieDrawable.enableMergePathsForKitKatAndAbove(paramBoolean);
  }
  
  public void endAnimation()
  {
    this.lottieDrawable.endAnimation();
    enableOrDisableHardwareLayer();
  }
  
  public void forbiddenLayer()
  {
    this.fobiddenLayer = true;
  }
  
  public Rect getCompRect()
  {
    return this.composition.getBounds();
  }
  
  public long getDuration()
  {
    if (this.composition != null) {
      return this.composition.getDuration();
    }
    return 0L;
  }
  
  @Nullable
  public String getImageAssetsFolder()
  {
    return this.lottieDrawable.getImageAssetsFolder();
  }
  
  public LottieDrawable getLottieDrawable()
  {
    return this.lottieDrawable;
  }
  
  @Nullable
  public PerformanceTracker getPerformanceTracker()
  {
    return this.lottieDrawable.getPerformanceTracker();
  }
  
  @FloatRange(from=0.0D, to=1.0D)
  public float getProgress()
  {
    return this.lottieDrawable.getProgress();
  }
  
  public float getScale()
  {
    return this.lottieDrawable.getScale();
  }
  
  public float getSpeed()
  {
    return this.lottieDrawable.getSpeed();
  }
  
  public boolean hasMasks()
  {
    return this.lottieDrawable.hasMasks();
  }
  
  public boolean hasMatte()
  {
    return this.lottieDrawable.hasMatte();
  }
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    if (getDrawable() == this.lottieDrawable)
    {
      super.invalidateDrawable(this.lottieDrawable);
      return;
    }
    super.invalidateDrawable(paramDrawable);
  }
  
  public boolean isAnimating()
  {
    return this.lottieDrawable.isAnimating();
  }
  
  public void loop(boolean paramBoolean)
  {
    this.lottieDrawable.loop(paramBoolean);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((this.autoPlay) && (this.wasAnimatingWhenDetached)) {
      playAnimation();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    if (isAnimating())
    {
      cancelAnimation();
      this.wasAnimatingWhenDetached = true;
    }
    recycleBitmaps();
    super.onDetachedFromWindow();
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.animationName = paramParcelable.animationName;
    if (!TextUtils.isEmpty(this.animationName)) {
      setAnimation(this.animationName);
    }
    setProgress(paramParcelable.progress);
    loop(paramParcelable.isLooping);
    if (paramParcelable.isAnimating) {
      playAnimation();
    }
    this.lottieDrawable.setImagesAssetsFolder(paramParcelable.imageAssetsFolder);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.animationName = this.animationName;
    localSavedState.progress = this.lottieDrawable.getProgress();
    localSavedState.isAnimating = this.lottieDrawable.isAnimating();
    localSavedState.isLooping = this.lottieDrawable.isLooping();
    localSavedState.imageAssetsFolder = this.lottieDrawable.getImageAssetsFolder();
    return localSavedState;
  }
  
  public void pauseAnimation()
  {
    this.lottieDrawable.pauseAnimation();
    enableOrDisableHardwareLayer();
  }
  
  public void playAnimation()
  {
    this.lottieDrawable.playAnimation();
    enableOrDisableHardwareLayer();
  }
  
  @VisibleForTesting
  void recycleBitmaps()
  {
    if (this.lottieDrawable != null) {
      this.lottieDrawable.recycleBitmaps();
    }
  }
  
  public void removeAllAnimatorListener()
  {
    this.lottieDrawable.removeAllAnimatorListener();
  }
  
  public void removeAnimatorListener(Animator.AnimatorListener paramAnimatorListener)
  {
    this.lottieDrawable.removeAnimatorListener(paramAnimatorListener);
  }
  
  public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener)
  {
    this.lottieDrawable.removeAnimatorUpdateListener(paramAnimatorUpdateListener);
  }
  
  public void resumeAnimation()
  {
    this.lottieDrawable.resumeAnimation();
    enableOrDisableHardwareLayer();
  }
  
  public void reverseAnimationSpeed()
  {
    this.lottieDrawable.reverseAnimationSpeed();
  }
  
  public void setAnimation(String paramString)
  {
    setAnimation(paramString, this.defaultCacheStrategy);
  }
  
  public void setAnimation(final String paramString, final int paramInt)
  {
    this.animationName = paramString;
    if (WEAK_REF_CACHE.containsKey(paramString))
    {
      LottieComposition localLottieComposition = (LottieComposition)((WeakReference)WEAK_REF_CACHE.get(paramString)).get();
      if (localLottieComposition != null) {
        setComposition(localLottieComposition);
      }
    }
    else if (STRONG_REF_CACHE.containsKey(paramString))
    {
      setComposition((LottieComposition)STRONG_REF_CACHE.get(paramString));
      return;
    }
    this.lottieDrawable.cancelAnimation();
    cancelLoaderTask();
    this.compositionLoader = LottieComposition.Factory.fromAssetFileName(getContext(), paramString, new OnCompositionLoadedListener()
    {
      public void onCompositionLoaded(LottieComposition paramAnonymousLottieComposition)
      {
        if (paramInt == 2) {
          DiniFlyAnimationView.STRONG_REF_CACHE.put(paramString, paramAnonymousLottieComposition);
        }
        for (;;)
        {
          DiniFlyAnimationView.this.setComposition(paramAnonymousLottieComposition);
          return;
          if (paramInt == 1) {
            DiniFlyAnimationView.WEAK_REF_CACHE.put(paramString, new WeakReference(paramAnonymousLottieComposition));
          }
        }
      }
    });
  }
  
  public void setAnimation(JSONObject paramJSONObject)
  {
    cancelLoaderTask();
    this.compositionLoader = LottieComposition.Factory.fromJson(getResources(), paramJSONObject, this.loadedListener);
  }
  
  public void setComposition(@NonNull LottieComposition paramLottieComposition)
  {
    this.lottieDrawable.setCallback(this);
    boolean bool = this.lottieDrawable.setComposition(paramLottieComposition);
    enableOrDisableHardwareLayer();
    if (!bool) {
      return;
    }
    int i = Utils.getScreenWidth(getContext());
    int j = Utils.getScreenHeight(getContext());
    int k = paramLottieComposition.getBounds().width();
    int m = paramLottieComposition.getBounds().height();
    if ((k > i) || (m > j))
    {
      float f1 = i / k;
      float f2 = j / m;
      if ((this.fitFullscreenXY) && (!hasMatte())) {
        setScaleXY(f1, f2);
      }
    }
    setImageDrawable(null);
    setImageDrawable(this.lottieDrawable);
    this.composition = paramLottieComposition;
    requestLayout();
  }
  
  public void setFitFullScreenXY()
  {
    this.fitFullscreenXY = true;
  }
  
  public void setFontAssetDelegate(FontAssetDelegate paramFontAssetDelegate)
  {
    this.lottieDrawable.setFontAssetDelegate(paramFontAssetDelegate);
  }
  
  public void setImageAssetDelegate(ImageAssetDelegate paramImageAssetDelegate)
  {
    this.lottieDrawable.setImageAssetDelegate(paramImageAssetDelegate);
  }
  
  public void setImageAssetsFolder(String paramString)
  {
    this.lottieDrawable.setImagesAssetsFolder(paramString);
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    recycleBitmaps();
    cancelLoaderTask();
    super.setImageBitmap(paramBitmap);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    if (paramDrawable != this.lottieDrawable) {
      recycleBitmaps();
    }
    cancelLoaderTask();
    super.setImageDrawable(paramDrawable);
  }
  
  public void setImageResource(int paramInt)
  {
    recycleBitmaps();
    cancelLoaderTask();
    super.setImageResource(paramInt);
  }
  
  public void setMaxFrame(int paramInt)
  {
    this.lottieDrawable.setMaxFrame(paramInt);
  }
  
  public void setMaxProgress(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    this.lottieDrawable.setMaxProgress(paramFloat);
  }
  
  public void setMinAndMaxFrame(int paramInt1, int paramInt2)
  {
    this.lottieDrawable.setMinAndMaxFrame(paramInt1, paramInt2);
  }
  
  public void setMinAndMaxProgress(@FloatRange(from=0.0D, to=1.0D) float paramFloat1, @FloatRange(from=0.0D, to=1.0D) float paramFloat2)
  {
    this.lottieDrawable.setMinAndMaxProgress(paramFloat1, paramFloat2);
  }
  
  public void setMinFrame(int paramInt)
  {
    this.lottieDrawable.setMinFrame(paramInt);
  }
  
  public void setMinProgress(float paramFloat)
  {
    this.lottieDrawable.setMinProgress(paramFloat);
  }
  
  public void setPerformanceTrackingEnabled(boolean paramBoolean)
  {
    this.lottieDrawable.setPerformanceTrackingEnabled(paramBoolean);
  }
  
  public void setProgress(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    this.lottieDrawable.setProgress(paramFloat);
  }
  
  public void setRepeatCount(int paramInt)
  {
    this.lottieDrawable.setRepeatCount(paramInt);
  }
  
  public void setScale(float paramFloat)
  {
    setScaleXY(paramFloat, paramFloat);
  }
  
  public void setScaleXY(float paramFloat1, float paramFloat2)
  {
    this.lottieDrawable.setScale(paramFloat1, paramFloat2);
    if (getDrawable() == this.lottieDrawable)
    {
      setImageDrawable(null);
      setImageDrawable(this.lottieDrawable);
    }
  }
  
  public void setSpeed(float paramFloat)
  {
    this.lottieDrawable.setSpeed(paramFloat);
  }
  
  public void setTextDelegate(TextDelegate paramTextDelegate)
  {
    this.lottieDrawable.setTextDelegate(paramTextDelegate);
  }
  
  @Nullable
  public Bitmap updateBitmap(String paramString, @Nullable Bitmap paramBitmap)
  {
    return this.lottieDrawable.updateBitmap(paramString, paramBitmap);
  }
  
  @Deprecated
  public void useExperimentalHardwareAcceleration()
  {
    useHardwareAcceleration(true);
  }
  
  @Deprecated
  public void useExperimentalHardwareAcceleration(boolean paramBoolean)
  {
    useHardwareAcceleration(paramBoolean);
  }
  
  public void useHardwareAcceleration()
  {
    useHardwareAcceleration(true);
  }
  
  public void useHardwareAcceleration(boolean paramBoolean)
  {
    this.useHardwareLayer = paramBoolean;
    enableOrDisableHardwareLayer();
  }
  
  public class CacheStrategy
  {
    public static final int None = 0;
    public static final int Strong = 2;
    public static final int Weak = 1;
    
    public CacheStrategy() {}
  }
  
  private static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public DiniFlyAnimationView.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new DiniFlyAnimationView.SavedState(paramAnonymousParcel, null);
      }
      
      public DiniFlyAnimationView.SavedState[] newArray(int paramAnonymousInt)
      {
        return new DiniFlyAnimationView.SavedState[paramAnonymousInt];
      }
    };
    String animationName;
    String imageAssetsFolder;
    boolean isAnimating;
    boolean isLooping;
    float progress;
    
    private SavedState(Parcel paramParcel)
    {
      super();
      this.animationName = paramParcel.readString();
      this.progress = paramParcel.readFloat();
      if (paramParcel.readInt() == 1)
      {
        bool1 = true;
        this.isAnimating = bool1;
        if (paramParcel.readInt() != 1) {
          break label67;
        }
      }
      label67:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.isLooping = bool1;
        this.imageAssetsFolder = paramParcel.readString();
        return;
        bool1 = false;
        break;
      }
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.animationName);
      paramParcel.writeFloat(this.progress);
      if (this.isAnimating)
      {
        paramInt = 1;
        paramParcel.writeInt(paramInt);
        if (!this.isLooping) {
          break label66;
        }
      }
      label66:
      for (paramInt = i;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.imageAssetsFolder);
        return;
        paramInt = 0;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.DiniFlyAnimationView
 * JD-Core Version:    0.7.0.1
 */