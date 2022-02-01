package com.tencent.mobileqq.dinifly;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Parcelable;
import android.support.annotation.FloatRange;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RawRes;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.dinifly.model.KeyPath;
import com.tencent.mobileqq.dinifly.value.LottieValueCallback;
import com.tencent.mobileqq.dinifly.value.SimpleLottieValueCallback;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class DiniFlyAnimationView
  extends ImageView
{
  private static final String TAG = DiniFlyAnimationView.class.getSimpleName();
  public static int inDensity = 320;
  public static int inTargetDensity;
  private String animationName;
  @RawRes
  private int animationResId;
  private boolean autoPlay = false;
  @Nullable
  private LottieComposition composition;
  @Nullable
  private LottieTask<LottieComposition> compositionTask;
  private final LottieListener<Throwable> failureListener = new DiniFlyAnimationView.2(this);
  private boolean fobiddenLayer;
  private final LottieListener<LottieComposition> loadedListener = new DiniFlyAnimationView.1(this);
  private final LottieDrawable lottieDrawable = new LottieDrawable();
  private Set<LottieOnCompositionLoadedListener> lottieOnCompositionLoadedListeners = new HashSet();
  private RenderMode renderMode = RenderMode.AUTOMATIC;
  private boolean wasAnimatingWhenDetached = false;
  private boolean wasAnimatingWhenVisibilityChanged = false;
  
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
    if (this.compositionTask != null)
    {
      this.compositionTask.removeListener(this.loadedListener);
      this.compositionTask.removeFailureListener(this.failureListener);
    }
  }
  
  private void clearComposition()
  {
    this.composition = null;
    this.lottieDrawable.clearComposition();
  }
  
  private void enableOrDisableHardwareLayer()
  {
    int j = 2;
    int i = 0;
    if (this.fobiddenLayer) {
      setLayerType(0, null);
    }
    for (;;)
    {
      if (getLayerType() == 1) {
        DiniFlyLog.i("DiniFlyAnimationView", 1, "enableOrDisableHardwareLayer software", null);
      }
      return;
      switch (DiniFlyAnimationView.4.$SwitchMap$com$tencent$mobileqq$dinifly$RenderMode[this.renderMode.ordinal()])
      {
      default: 
        break;
      case 1: 
        setLayerType(2, null);
        break;
      case 2: 
        setLayerType(1, null);
      }
    }
    if ((this.composition != null) && (this.composition.hasDashPattern()) && (Build.VERSION.SDK_INT < 28)) {
      label118:
      if (i == 0) {
        break label156;
      }
    }
    label156:
    for (i = j;; i = 1)
    {
      setLayerType(i, null);
      break;
      if ((this.composition != null) && (this.composition.getMaskAndMatteCount() > 4)) {
        break label118;
      }
      i = 1;
      break label118;
    }
  }
  
  private void init(@Nullable AttributeSet paramAttributeSet)
  {
    DiniFlyLog.i("DiniFlyAnimationView", 1, getContext().toString(), null);
    inTargetDensity = getContext().getResources().getDisplayMetrics().densityDpi;
    if (getContext().getResources().getDisplayMetrics().density < 320.0F) {}
    boolean bool1;
    boolean bool2;
    boolean bool3;
    for (inDensity = 160;; inDensity = 320)
    {
      inTargetDensity = getContext().getResources().getDisplayMetrics().densityDpi;
      if (inDensity < inTargetDensity) {
        inDensity = inTargetDensity;
      }
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.DiniFlyAnimationView);
      if (isInEditMode()) {
        break label181;
      }
      bool1 = paramAttributeSet.hasValue(R.styleable.DiniFlyAnimationView_dinifly_rawRes);
      bool2 = paramAttributeSet.hasValue(R.styleable.DiniFlyAnimationView_dinifly_fileName);
      bool3 = paramAttributeSet.hasValue(R.styleable.DiniFlyAnimationView_dinifly_url);
      if ((!bool1) || (!bool2)) {
        break;
      }
      throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
    }
    if (bool1)
    {
      int i = paramAttributeSet.getResourceId(R.styleable.DiniFlyAnimationView_dinifly_rawRes, 0);
      if (i != 0) {
        setAnimation(i);
      }
    }
    for (;;)
    {
      label181:
      if (paramAttributeSet.getBoolean(R.styleable.DiniFlyAnimationView_dinifly_autoPlay, false))
      {
        this.wasAnimatingWhenDetached = true;
        this.autoPlay = true;
      }
      if (paramAttributeSet.getBoolean(R.styleable.DiniFlyAnimationView_dinifly_loop, false)) {
        this.lottieDrawable.setRepeatCount(-1);
      }
      if (paramAttributeSet.hasValue(R.styleable.DiniFlyAnimationView_dinifly_repeatMode)) {
        setRepeatMode(paramAttributeSet.getInt(R.styleable.DiniFlyAnimationView_dinifly_repeatMode, 1));
      }
      if (paramAttributeSet.hasValue(R.styleable.DiniFlyAnimationView_dinifly_repeatCount)) {
        setRepeatCount(paramAttributeSet.getInt(R.styleable.DiniFlyAnimationView_dinifly_repeatCount, -1));
      }
      if (paramAttributeSet.hasValue(R.styleable.DiniFlyAnimationView_dinifly_speed)) {
        setSpeed(paramAttributeSet.getFloat(R.styleable.DiniFlyAnimationView_dinifly_speed, 1.0F));
      }
      setImageAssetsFolder(paramAttributeSet.getString(R.styleable.DiniFlyAnimationView_dinifly_imageAssetsFolder));
      setProgress(paramAttributeSet.getFloat(R.styleable.DiniFlyAnimationView_dinifly_progress, 0.0F));
      enableMergePathsForKitKatAndAbove(paramAttributeSet.getBoolean(R.styleable.DiniFlyAnimationView_dinifly_enableMergePathsForKitKatAndAbove, false));
      Object localObject1;
      if (paramAttributeSet.hasValue(R.styleable.DiniFlyAnimationView_dinifly_colorFilter))
      {
        Object localObject2 = new SimpleColorFilter(paramAttributeSet.getColor(R.styleable.DiniFlyAnimationView_dinifly_colorFilter, 0));
        localObject1 = new KeyPath(new String[] { "**" });
        localObject2 = new LottieValueCallback(localObject2);
        addValueCallback((KeyPath)localObject1, LottieProperty.COLOR_FILTER, (LottieValueCallback)localObject2);
      }
      if (paramAttributeSet.hasValue(R.styleable.DiniFlyAnimationView_dinifly_scale)) {
        this.lottieDrawable.setScale(paramAttributeSet.getFloat(R.styleable.DiniFlyAnimationView_dinifly_scale, 1.0F), paramAttributeSet.getFloat(R.styleable.DiniFlyAnimationView_dinifly_scale, 1.0F));
      }
      paramAttributeSet.recycle();
      enableOrDisableHardwareLayer();
      return;
      if (bool2)
      {
        localObject1 = paramAttributeSet.getString(R.styleable.DiniFlyAnimationView_dinifly_fileName);
        if (localObject1 != null) {
          setAnimation((String)localObject1);
        }
      }
      else if (bool3)
      {
        localObject1 = paramAttributeSet.getString(R.styleable.DiniFlyAnimationView_dinifly_url);
        if (localObject1 != null) {
          setAnimationFromUrl((String)localObject1);
        }
      }
    }
  }
  
  private void setCompositionTask(LottieTask<LottieComposition> paramLottieTask)
  {
    clearComposition();
    cancelLoaderTask();
    this.compositionTask = paramLottieTask.addListener(this.loadedListener).addFailureListener(this.failureListener);
  }
  
  public void addAnimatorListener(Animator.AnimatorListener paramAnimatorListener)
  {
    this.lottieDrawable.addAnimatorListener(paramAnimatorListener);
  }
  
  public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener)
  {
    this.lottieDrawable.addAnimatorUpdateListener(paramAnimatorUpdateListener);
  }
  
  public boolean addLottieOnCompositionLoadedListener(@NonNull LottieOnCompositionLoadedListener paramLottieOnCompositionLoadedListener)
  {
    return this.lottieOnCompositionLoadedListeners.add(paramLottieOnCompositionLoadedListener);
  }
  
  public <T> void addValueCallback(KeyPath paramKeyPath, T paramT, LottieValueCallback<T> paramLottieValueCallback)
  {
    this.lottieDrawable.addValueCallback(paramKeyPath, paramT, paramLottieValueCallback);
  }
  
  public <T> void addValueCallback(KeyPath paramKeyPath, T paramT, SimpleLottieValueCallback<T> paramSimpleLottieValueCallback)
  {
    this.lottieDrawable.addValueCallback(paramKeyPath, paramT, new DiniFlyAnimationView.3(this, paramSimpleLottieValueCallback));
  }
  
  @MainThread
  public void cancelAnimation()
  {
    this.lottieDrawable.cancelAnimation();
    enableOrDisableHardwareLayer();
  }
  
  public void enableMergePathsForKitKatAndAbove(boolean paramBoolean)
  {
    this.lottieDrawable.enableMergePathsForKitKatAndAbove(paramBoolean);
  }
  
  @MainThread
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
  
  @Nullable
  public LottieComposition getComposition()
  {
    return this.composition;
  }
  
  public long getDuration()
  {
    if (this.composition != null) {
      return this.composition.getDuration();
    }
    return 0L;
  }
  
  public int getFrame()
  {
    return this.lottieDrawable.getFrame();
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
  
  public float getMaxFrame()
  {
    return this.lottieDrawable.getMaxFrame();
  }
  
  public float getMinFrame()
  {
    return this.lottieDrawable.getMinFrame();
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
  
  public int getRepeatCount()
  {
    return this.lottieDrawable.getRepeatCount();
  }
  
  public int getRepeatMode()
  {
    return this.lottieDrawable.getRepeatMode();
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
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      if (getDrawable() == this.lottieDrawable) {
        super.invalidateDrawable(this.lottieDrawable);
      }
    }
    else {
      return;
    }
    super.invalidateDrawable(paramDrawable);
  }
  
  public boolean isAnimating()
  {
    return this.lottieDrawable.isAnimating();
  }
  
  public boolean isMergePathsEnabledForKitKatAndAbove()
  {
    return this.lottieDrawable.isMergePathsEnabledForKitKatAndAbove();
  }
  
  @Deprecated
  public void loop(boolean paramBoolean)
  {
    LottieDrawable localLottieDrawable = this.lottieDrawable;
    if (paramBoolean) {}
    for (int i = -1;; i = 0)
    {
      localLottieDrawable.setRepeatCount(i);
      return;
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((this.autoPlay) && (this.wasAnimatingWhenDetached)) {
      playAnimation();
    }
    DiniFlyLog.i("DiniFlyAnimationView", 1, "onAttachedToWindow playAnimation" + getContext().toString(), null);
  }
  
  protected void onDetachedFromWindow()
  {
    if (isAnimating())
    {
      cancelAnimation();
      this.wasAnimatingWhenDetached = true;
    }
    super.onDetachedFromWindow();
    DiniFlyLog.i("DiniFlyAnimationView", 1, "onDetachedFromWindow cancelAnimation" + getContext().toString(), null);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof DiniFlyAnimationView.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (DiniFlyAnimationView.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.animationName = paramParcelable.animationName;
    if (!TextUtils.isEmpty(this.animationName)) {
      setAnimation(this.animationName);
    }
    this.animationResId = paramParcelable.animationResId;
    if (this.animationResId != 0) {
      setAnimation(this.animationResId);
    }
    setProgress(paramParcelable.progress);
    if (paramParcelable.isAnimating) {
      playAnimation();
    }
    this.lottieDrawable.setImagesAssetsFolder(paramParcelable.imageAssetsFolder);
    setRepeatMode(paramParcelable.repeatMode);
    setRepeatCount(paramParcelable.repeatCount);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    DiniFlyAnimationView.SavedState localSavedState = new DiniFlyAnimationView.SavedState(super.onSaveInstanceState());
    localSavedState.animationName = this.animationName;
    localSavedState.animationResId = this.animationResId;
    localSavedState.progress = this.lottieDrawable.getProgress();
    localSavedState.isAnimating = this.lottieDrawable.isAnimating();
    localSavedState.imageAssetsFolder = this.lottieDrawable.getImageAssetsFolder();
    localSavedState.repeatMode = this.lottieDrawable.getRepeatMode();
    localSavedState.repeatCount = this.lottieDrawable.getRepeatCount();
    return localSavedState;
  }
  
  protected void onVisibilityChanged(@NonNull View paramView, int paramInt)
  {
    if (this.lottieDrawable == null) {}
    do
    {
      do
      {
        return;
        if (paramInt != 0) {
          break;
        }
      } while (!this.wasAnimatingWhenVisibilityChanged);
      resumeAnimation();
      return;
      this.wasAnimatingWhenVisibilityChanged = isAnimating();
    } while (!isAnimating());
    pauseAnimation();
  }
  
  @MainThread
  public void pauseAnimation()
  {
    this.lottieDrawable.pauseAnimation();
    enableOrDisableHardwareLayer();
  }
  
  @MainThread
  public void playAnimation()
  {
    this.lottieDrawable.playAnimation();
    enableOrDisableHardwareLayer();
  }
  
  public void removeAllAnimatorListener()
  {
    this.lottieDrawable.removeAllAnimatorListeners();
  }
  
  public void removeAllLottieOnCompositionLoadedListener()
  {
    this.lottieOnCompositionLoadedListeners.clear();
  }
  
  public void removeAllUpdateListeners()
  {
    this.lottieDrawable.removeAllUpdateListeners();
  }
  
  public void removeAnimatorListener(Animator.AnimatorListener paramAnimatorListener)
  {
    this.lottieDrawable.removeAnimatorListener(paramAnimatorListener);
  }
  
  public boolean removeLottieOnCompositionLoadedListener(@NonNull LottieOnCompositionLoadedListener paramLottieOnCompositionLoadedListener)
  {
    return this.lottieOnCompositionLoadedListeners.remove(paramLottieOnCompositionLoadedListener);
  }
  
  public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener)
  {
    this.lottieDrawable.removeAnimatorUpdateListener(paramAnimatorUpdateListener);
  }
  
  public List<KeyPath> resolveKeyPath(KeyPath paramKeyPath)
  {
    return this.lottieDrawable.resolveKeyPath(paramKeyPath);
  }
  
  @MainThread
  public void resumeAnimation()
  {
    this.lottieDrawable.resumeAnimation();
    enableOrDisableHardwareLayer();
  }
  
  public void reverseAnimationSpeed()
  {
    this.lottieDrawable.reverseAnimationSpeed();
  }
  
  public void setAnimation(@RawRes int paramInt)
  {
    this.animationResId = paramInt;
    this.animationName = null;
    setCompositionTask(LottieCompositionFactory.fromRawRes(getContext(), paramInt));
  }
  
  public void setAnimation(JsonReader paramJsonReader, @Nullable String paramString)
  {
    setCompositionTask(LottieCompositionFactory.fromJsonReader(paramJsonReader, paramString));
  }
  
  public void setAnimation(String paramString)
  {
    this.animationName = paramString;
    this.animationResId = 0;
    setCompositionTask(LottieCompositionFactory.fromAsset(getContext(), paramString));
  }
  
  @Deprecated
  public void setAnimationFromJson(String paramString)
  {
    setAnimationFromJson(paramString, null);
  }
  
  public void setAnimationFromJson(String paramString1, @Nullable String paramString2)
  {
    setAnimation(new JsonReader(new StringReader(paramString1)), paramString2);
  }
  
  public void setAnimationFromUrl(String paramString)
  {
    setCompositionTask(LottieCompositionFactory.fromUrl(getContext(), paramString));
  }
  
  public void setComposition(@NonNull LottieComposition paramLottieComposition)
  {
    if (L.DBG) {
      Log.v(TAG, "Set Composition \n" + paramLottieComposition);
    }
    this.lottieDrawable.setCallback(this);
    this.composition = paramLottieComposition;
    boolean bool = this.lottieDrawable.setComposition(paramLottieComposition);
    enableOrDisableHardwareLayer();
    if ((getDrawable() == this.lottieDrawable) && (!bool)) {}
    for (;;)
    {
      return;
      setImageDrawable(null);
      setImageDrawable(this.lottieDrawable);
      requestLayout();
      Iterator localIterator = this.lottieOnCompositionLoadedListeners.iterator();
      while (localIterator.hasNext()) {
        ((LottieOnCompositionLoadedListener)localIterator.next()).onCompositionLoaded(paramLottieComposition);
      }
    }
  }
  
  public void setFitFullScreenXY()
  {
    setScaleType(ImageView.ScaleType.FIT_XY);
  }
  
  public void setFontAssetDelegate(FontAssetDelegate paramFontAssetDelegate)
  {
    this.lottieDrawable.setFontAssetDelegate(paramFontAssetDelegate);
  }
  
  public void setFrame(int paramInt)
  {
    this.lottieDrawable.setFrame(paramInt);
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
    cancelLoaderTask();
    super.setImageBitmap(paramBitmap);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    cancelLoaderTask();
    super.setImageDrawable(paramDrawable);
  }
  
  public void setImageResource(int paramInt)
  {
    cancelLoaderTask();
    super.setImageResource(paramInt);
  }
  
  public void setMaxFrame(int paramInt)
  {
    this.lottieDrawable.setMaxFrame(paramInt);
  }
  
  public void setMaxFrame(String paramString)
  {
    this.lottieDrawable.setMaxFrame(paramString);
  }
  
  public void setMaxProgress(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    this.lottieDrawable.setMaxProgress(paramFloat);
  }
  
  public void setMinAndMaxFrame(int paramInt1, int paramInt2)
  {
    this.lottieDrawable.setMinAndMaxFrame(paramInt1, paramInt2);
  }
  
  public void setMinAndMaxFrame(String paramString)
  {
    this.lottieDrawable.setMinAndMaxFrame(paramString);
  }
  
  public void setMinAndMaxProgress(@FloatRange(from=0.0D, to=1.0D) float paramFloat1, @FloatRange(from=0.0D, to=1.0D) float paramFloat2)
  {
    this.lottieDrawable.setMinAndMaxProgress(paramFloat1, paramFloat2);
  }
  
  public void setMinFrame(int paramInt)
  {
    this.lottieDrawable.setMinFrame(paramInt);
  }
  
  public void setMinFrame(String paramString)
  {
    this.lottieDrawable.setMinFrame(paramString);
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
  
  public void setRenderMode(RenderMode paramRenderMode)
  {
    this.renderMode = paramRenderMode;
    enableOrDisableHardwareLayer();
  }
  
  public void setRepeatCount(int paramInt)
  {
    this.lottieDrawable.setRepeatCount(paramInt);
  }
  
  public void setRepeatMode(int paramInt)
  {
    this.lottieDrawable.setRepeatMode(paramInt);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.DiniFlyAnimationView
 * JD-Core Version:    0.7.0.1
 */