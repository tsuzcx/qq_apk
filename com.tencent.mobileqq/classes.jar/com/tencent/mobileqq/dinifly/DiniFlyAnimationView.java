package com.tencent.mobileqq.dinifly;

import android.animation.Animator.AnimatorListener;
import android.animation.Animator.AnimatorPauseListener;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ImageView.ScaleType;
import androidx.annotation.AttrRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.RequiresApi;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;
import com.tencent.mobileqq.dinifly.model.KeyPath;
import com.tencent.mobileqq.dinifly.utils.Utils;
import com.tencent.mobileqq.dinifly.value.LottieValueCallback;
import com.tencent.mobileqq.dinifly.value.SimpleLottieValueCallback;
import com.tencent.xaction.log.QLog;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class DiniFlyAnimationView
  extends AppCompatImageView
{
  private static final LottieListener<Throwable> DEFAULT_FAILURE_LISTENER = new DiniFlyAnimationView.1();
  private static final String TAG = "DiniFlyAnimationView";
  public static int inDensity = 320;
  public static int inTargetDensity;
  private String animationName;
  @RawRes
  private int animationResId;
  private boolean autoPlay = false;
  private int buildDrawingCacheDepth = 0;
  private boolean cacheComposition = true;
  @Nullable
  private LottieComposition composition;
  @Nullable
  private LottieTask<LottieComposition> compositionTask;
  @Nullable
  private LottieListener<Throwable> failureListener;
  @DrawableRes
  private int fallbackResource = 0;
  private boolean fobiddenLayer;
  private boolean ignoreUnschedule = false;
  private boolean isInitialized;
  private final LottieListener<LottieComposition> loadedListener = new DiniFlyAnimationView.2(this);
  private final LottieDrawable lottieDrawable = new LottieDrawable();
  private final Set<LottieOnCompositionLoadedListener> lottieOnCompositionLoadedListeners = new HashSet();
  private boolean playAnimationWhenShown = false;
  private RenderMode renderMode = RenderMode.AUTOMATIC;
  private boolean wasAnimatingWhenDetached = false;
  private boolean wasAnimatingWhenNotShown = false;
  private final LottieListener<Throwable> wrappedFailureListener = new DiniFlyAnimationView.3(this);
  
  public DiniFlyAnimationView(Context paramContext)
  {
    super(paramContext);
    init(null, 2131034121);
  }
  
  public DiniFlyAnimationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramAttributeSet, 2131034121);
  }
  
  public DiniFlyAnimationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramAttributeSet, paramInt);
  }
  
  private void cancelLoaderTask()
  {
    LottieTask localLottieTask = this.compositionTask;
    if (localLottieTask != null)
    {
      localLottieTask.removeListener(this.loadedListener);
      this.compositionTask.removeFailureListener(this.wrappedFailureListener);
    }
  }
  
  private void clearComposition()
  {
    this.composition = null;
    this.lottieDrawable.clearComposition();
  }
  
  private void enableOrDisableHardwareLayer()
  {
    int k = DiniFlyAnimationView.7.$SwitchMap$com$tencent$mobileqq$dinifly$RenderMode[this.renderMode.ordinal()];
    int j = 2;
    int i = j;
    if (k != 1)
    {
      if ((k == 2) || (k != 3)) {}
      do
      {
        i = 1;
        break;
        LottieComposition localLottieComposition = this.composition;
        k = 0;
        if ((localLottieComposition != null) && (localLottieComposition.hasDashPattern()) && (Build.VERSION.SDK_INT < 28))
        {
          i = k;
        }
        else
        {
          localLottieComposition = this.composition;
          if ((localLottieComposition != null) && (localLottieComposition.getMaskAndMatteCount() > 4))
          {
            i = k;
          }
          else if (Build.VERSION.SDK_INT < 21)
          {
            i = k;
          }
          else
          {
            i = k;
            if (Build.VERSION.SDK_INT != 24) {
              if (Build.VERSION.SDK_INT == 25) {
                i = k;
              } else {
                i = 1;
              }
            }
          }
        }
      } while (i == 0);
      i = j;
    }
    if (i != getLayerType()) {
      setLayerType(i, null);
    }
    if (getLayerType() == 1) {
      QLog.c("DiniFlyAnimationView", 1, "enableOrDisableHardwareLayer software", null);
    }
  }
  
  private LottieTask<LottieComposition> fromAssets(String paramString)
  {
    if (isInEditMode()) {
      return new LottieTask(new DiniFlyAnimationView.5(this, paramString), true);
    }
    if (this.cacheComposition) {
      return LottieCompositionFactory.fromAsset(getContext(), paramString);
    }
    return LottieCompositionFactory.fromAsset(getContext(), paramString, null);
  }
  
  private LottieTask<LottieComposition> fromRawRes(@RawRes int paramInt)
  {
    if (isInEditMode()) {
      return new LottieTask(new DiniFlyAnimationView.4(this, paramInt), true);
    }
    if (this.cacheComposition) {
      return LottieCompositionFactory.fromRawRes(getContext(), paramInt);
    }
    return LottieCompositionFactory.fromRawRes(getContext(), paramInt, null);
  }
  
  private void init(@Nullable AttributeSet paramAttributeSet, @AttrRes int paramInt)
  {
    QLog.c("DiniFlyAnimationView", 1, getContext().toString(), null);
    inTargetDensity = getContext().getResources().getDisplayMetrics().densityDpi;
    if (getContext().getResources().getDisplayMetrics().density < 320.0F) {
      inDensity = 160;
    } else {
      inDensity = 320;
    }
    inTargetDensity = getContext().getResources().getDisplayMetrics().densityDpi;
    int i = inDensity;
    int j = inTargetDensity;
    if (i < j) {
      inDensity = j;
    }
    Object localObject1 = getContext();
    Object localObject2 = R.styleable.DiniFlyAnimationView;
    boolean bool1 = false;
    paramAttributeSet = ((Context)localObject1).obtainStyledAttributes(paramAttributeSet, (int[])localObject2, paramInt, 0);
    this.cacheComposition = paramAttributeSet.getBoolean(R.styleable.DiniFlyAnimationView_dinifly_cacheComposition, true);
    boolean bool2 = paramAttributeSet.hasValue(R.styleable.DiniFlyAnimationView_dinifly_rawRes);
    boolean bool3 = paramAttributeSet.hasValue(R.styleable.DiniFlyAnimationView_dinifly_fileName);
    boolean bool4 = paramAttributeSet.hasValue(R.styleable.DiniFlyAnimationView_dinifly_url);
    if ((bool2) && (bool3)) {
      throw new IllegalArgumentException("dinifly_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
    }
    if (bool2)
    {
      paramInt = paramAttributeSet.getResourceId(R.styleable.DiniFlyAnimationView_dinifly_rawRes, 0);
      if (paramInt != 0) {
        setAnimation(paramInt);
      }
    }
    else if (bool3)
    {
      localObject1 = paramAttributeSet.getString(R.styleable.DiniFlyAnimationView_dinifly_fileName);
      if (localObject1 != null) {
        setAnimation((String)localObject1);
      }
    }
    else if (bool4)
    {
      localObject1 = paramAttributeSet.getString(R.styleable.DiniFlyAnimationView_dinifly_url);
      if (localObject1 != null) {
        setAnimationFromUrl((String)localObject1);
      }
    }
    setFallbackResource(paramAttributeSet.getResourceId(R.styleable.DiniFlyAnimationView_dinifly_fallbackRes, 0));
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
    if (paramAttributeSet.hasValue(R.styleable.DiniFlyAnimationView_dinifly_colorFilter))
    {
      paramInt = paramAttributeSet.getResourceId(R.styleable.DiniFlyAnimationView_dinifly_colorFilter, -1);
      localObject2 = new SimpleColorFilter(AppCompatResources.getColorStateList(getContext(), paramInt).getDefaultColor());
      localObject1 = new KeyPath(new String[] { "**" });
      localObject2 = new LottieValueCallback(localObject2);
      addValueCallback((KeyPath)localObject1, LottieProperty.COLOR_FILTER, (LottieValueCallback)localObject2);
    }
    if (paramAttributeSet.hasValue(R.styleable.DiniFlyAnimationView_dinifly_scale)) {
      this.lottieDrawable.setScale(paramAttributeSet.getFloat(R.styleable.DiniFlyAnimationView_dinifly_scale, 1.0F), paramAttributeSet.getFloat(R.styleable.DiniFlyAnimationView_dinifly_scale, 1.0F));
    }
    if (paramAttributeSet.hasValue(R.styleable.DiniFlyAnimationView_dinifly_renderMode))
    {
      i = paramAttributeSet.getInt(R.styleable.DiniFlyAnimationView_dinifly_renderMode, RenderMode.AUTOMATIC.ordinal());
      paramInt = i;
      if (i >= RenderMode.values().length) {
        paramInt = RenderMode.AUTOMATIC.ordinal();
      }
      setRenderMode(RenderMode.values()[paramInt]);
    }
    setIgnoreDisabledSystemAnimations(paramAttributeSet.getBoolean(R.styleable.DiniFlyAnimationView_dinifly_ignoreDisabledSystemAnimations, false));
    paramAttributeSet.recycle();
    paramAttributeSet = this.lottieDrawable;
    if (Utils.getAnimationScale(getContext()) != 0.0F) {
      bool1 = true;
    }
    paramAttributeSet.setSystemAnimationsAreEnabled(Boolean.valueOf(bool1));
    enableOrDisableHardwareLayer();
    this.isInitialized = true;
  }
  
  private void setCompositionTask(LottieTask<LottieComposition> paramLottieTask)
  {
    clearComposition();
    cancelLoaderTask();
    this.compositionTask = paramLottieTask.addListener(this.loadedListener).addFailureListener(this.wrappedFailureListener);
  }
  
  private void setLottieDrawable()
  {
    boolean bool = isAnimating();
    setImageDrawable(null);
    setImageDrawable(this.lottieDrawable);
    if (bool) {
      this.lottieDrawable.resumeAnimation();
    }
  }
  
  public void addAnimatorListener(Animator.AnimatorListener paramAnimatorListener)
  {
    this.lottieDrawable.addAnimatorListener(paramAnimatorListener);
  }
  
  @RequiresApi(api=19)
  public void addAnimatorPauseListener(Animator.AnimatorPauseListener paramAnimatorPauseListener)
  {
    this.lottieDrawable.addAnimatorPauseListener(paramAnimatorPauseListener);
  }
  
  public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener)
  {
    this.lottieDrawable.addAnimatorUpdateListener(paramAnimatorUpdateListener);
  }
  
  public boolean addLottieOnCompositionLoadedListener(@NonNull LottieOnCompositionLoadedListener paramLottieOnCompositionLoadedListener)
  {
    LottieComposition localLottieComposition = this.composition;
    if (localLottieComposition != null) {
      paramLottieOnCompositionLoadedListener.onCompositionLoaded(localLottieComposition);
    }
    return this.lottieOnCompositionLoadedListeners.add(paramLottieOnCompositionLoadedListener);
  }
  
  public <T> void addValueCallback(KeyPath paramKeyPath, T paramT, LottieValueCallback<T> paramLottieValueCallback)
  {
    this.lottieDrawable.addValueCallback(paramKeyPath, paramT, paramLottieValueCallback);
  }
  
  public <T> void addValueCallback(KeyPath paramKeyPath, T paramT, SimpleLottieValueCallback<T> paramSimpleLottieValueCallback)
  {
    this.lottieDrawable.addValueCallback(paramKeyPath, paramT, new DiniFlyAnimationView.6(this, paramSimpleLottieValueCallback));
  }
  
  public void buildDrawingCache(boolean paramBoolean)
  {
    L.beginSection("buildDrawingCache");
    this.buildDrawingCacheDepth += 1;
    super.buildDrawingCache(paramBoolean);
    if ((this.buildDrawingCacheDepth == 1) && (getWidth() > 0) && (getHeight() > 0) && (getLayerType() == 1) && (getDrawingCache(paramBoolean) == null)) {
      setRenderMode(RenderMode.HARDWARE);
    }
    this.buildDrawingCacheDepth -= 1;
    L.endSection("buildDrawingCache");
  }
  
  @MainThread
  public void cancelAnimation()
  {
    this.wasAnimatingWhenDetached = false;
    this.wasAnimatingWhenNotShown = false;
    this.playAnimationWhenShown = false;
    this.lottieDrawable.cancelAnimation();
    enableOrDisableHardwareLayer();
  }
  
  public void disableExtraScaleModeInFitXY()
  {
    this.lottieDrawable.disableExtraScaleModeInFitXY();
  }
  
  public void enableMergePathsForKitKatAndAbove(boolean paramBoolean)
  {
    this.lottieDrawable.enableMergePathsForKitKatAndAbove(paramBoolean);
  }
  
  @MainThread
  public void endAnimation()
  {
    this.wasAnimatingWhenDetached = false;
    this.wasAnimatingWhenNotShown = false;
    this.playAnimationWhenShown = false;
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
    LottieComposition localLottieComposition = this.composition;
    if (localLottieComposition != null) {
      return localLottieComposition.getDuration();
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
      Drawable localDrawable = getDrawable();
      LottieDrawable localLottieDrawable = this.lottieDrawable;
      if (localDrawable == localLottieDrawable)
      {
        super.invalidateDrawable(localLottieDrawable);
        return;
      }
      super.invalidateDrawable(paramDrawable);
    }
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
    int i;
    if (paramBoolean) {
      i = -1;
    } else {
      i = 0;
    }
    localLottieDrawable.setRepeatCount(i);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((!isInEditMode()) && ((this.autoPlay) || (this.wasAnimatingWhenDetached)))
    {
      playAnimation();
      this.autoPlay = false;
      this.wasAnimatingWhenDetached = false;
    }
    if (Build.VERSION.SDK_INT < 23) {
      onVisibilityChanged(this, getVisibility());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAttachedToWindow playAnimation");
    localStringBuilder.append(getContext().toString());
    QLog.c("DiniFlyAnimationView", 1, localStringBuilder.toString(), null);
  }
  
  protected void onDetachedFromWindow()
  {
    if (isAnimating())
    {
      cancelAnimation();
      this.wasAnimatingWhenDetached = true;
    }
    super.onDetachedFromWindow();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDetachedFromWindow cancelAnimation");
    localStringBuilder.append(getContext().toString());
    QLog.c("DiniFlyAnimationView", 1, localStringBuilder.toString(), null);
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
    int i = this.animationResId;
    if (i != 0) {
      setAnimation(i);
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
    boolean bool;
    if ((!this.lottieDrawable.isAnimating()) && ((ViewCompat.isAttachedToWindow(this)) || (!this.wasAnimatingWhenDetached))) {
      bool = false;
    } else {
      bool = true;
    }
    localSavedState.isAnimating = bool;
    localSavedState.imageAssetsFolder = this.lottieDrawable.getImageAssetsFolder();
    localSavedState.repeatMode = this.lottieDrawable.getRepeatMode();
    localSavedState.repeatCount = this.lottieDrawable.getRepeatCount();
    return localSavedState;
  }
  
  protected void onVisibilityChanged(@NonNull View paramView, int paramInt)
  {
    if (!this.isInitialized) {
      return;
    }
    if (isShown())
    {
      if (this.wasAnimatingWhenNotShown) {
        resumeAnimation();
      } else if (this.playAnimationWhenShown) {
        playAnimation();
      }
      this.wasAnimatingWhenNotShown = false;
      this.playAnimationWhenShown = false;
      return;
    }
    if (isAnimating())
    {
      pauseAnimation();
      this.wasAnimatingWhenNotShown = true;
    }
  }
  
  @MainThread
  public void pauseAnimation()
  {
    this.autoPlay = false;
    this.wasAnimatingWhenDetached = false;
    this.wasAnimatingWhenNotShown = false;
    this.playAnimationWhenShown = false;
    this.lottieDrawable.pauseAnimation();
    enableOrDisableHardwareLayer();
  }
  
  @MainThread
  public void playAnimation()
  {
    if (isShown())
    {
      this.lottieDrawable.playAnimation();
      enableOrDisableHardwareLayer();
      return;
    }
    this.playAnimationWhenShown = true;
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
  
  @RequiresApi(api=19)
  public void removeAnimatorPauseListener(Animator.AnimatorPauseListener paramAnimatorPauseListener)
  {
    this.lottieDrawable.removeAnimatorPauseListener(paramAnimatorPauseListener);
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
    if (isShown())
    {
      this.lottieDrawable.resumeAnimation();
      enableOrDisableHardwareLayer();
      return;
    }
    this.playAnimationWhenShown = false;
    this.wasAnimatingWhenNotShown = true;
  }
  
  public void reverseAnimationSpeed()
  {
    this.lottieDrawable.reverseAnimationSpeed();
  }
  
  public void setAnimation(@RawRes int paramInt)
  {
    this.animationResId = paramInt;
    this.animationName = null;
    setCompositionTask(fromRawRes(paramInt));
  }
  
  public void setAnimation(InputStream paramInputStream, @Nullable String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setAnimation cacheKey:");
    localStringBuilder.append(paramString);
    QLog.c("DiniFlyAnimationView", 1, localStringBuilder.toString(), null);
    setCompositionTask(LottieCompositionFactory.fromJsonInputStream(paramInputStream, paramString));
  }
  
  public void setAnimation(String paramString)
  {
    this.animationName = paramString;
    this.animationResId = 0;
    setCompositionTask(fromAssets(paramString));
  }
  
  @Deprecated
  public void setAnimationFromJson(String paramString)
  {
    setAnimationFromJson(paramString, null);
  }
  
  public void setAnimationFromJson(String paramString1, @Nullable String paramString2)
  {
    setAnimation(new ByteArrayInputStream(paramString1.getBytes()), paramString2);
  }
  
  public void setAnimationFromUrl(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setAnimation url:");
    localStringBuilder.append(paramString.split(""));
    QLog.c("DiniFlyAnimationView", 1, localStringBuilder.toString(), null);
    if (this.cacheComposition) {
      paramString = LottieCompositionFactory.fromUrl(getContext(), paramString);
    } else {
      paramString = LottieCompositionFactory.fromUrl(getContext(), paramString, null);
    }
    setCompositionTask(paramString);
  }
  
  public void setAnimationFromUrl(String paramString1, @Nullable String paramString2)
  {
    setCompositionTask(LottieCompositionFactory.fromUrl(getContext(), paramString1, paramString2));
  }
  
  public void setApplyingOpacityToLayersEnabled(boolean paramBoolean)
  {
    this.lottieDrawable.setApplyingOpacityToLayersEnabled(paramBoolean);
  }
  
  public void setCacheComposition(boolean paramBoolean)
  {
    this.cacheComposition = paramBoolean;
  }
  
  public void setComposition(@NonNull LottieComposition paramLottieComposition)
  {
    Object localObject;
    StringBuilder localStringBuilder;
    if (L.DBG)
    {
      localObject = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Set Composition \n");
      localStringBuilder.append(paramLottieComposition);
      Log.v((String)localObject, localStringBuilder.toString());
    }
    this.lottieDrawable.setCallback(this);
    try
    {
      this.composition = paramLottieComposition;
      this.ignoreUnschedule = true;
      boolean bool = this.lottieDrawable.setComposition(paramLottieComposition);
      this.ignoreUnschedule = false;
      enableOrDisableHardwareLayer();
      if ((getDrawable() == this.lottieDrawable) && (!bool)) {
        return;
      }
      if (!bool) {
        setLottieDrawable();
      }
      onVisibilityChanged(this, getVisibility());
      requestLayout();
      localObject = this.lottieOnCompositionLoadedListeners.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((LottieOnCompositionLoadedListener)((Iterator)localObject).next()).onCompositionLoaded(paramLottieComposition);
      }
      return;
    }
    catch (Exception localException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setComposition url:");
      localStringBuilder.append(paramLottieComposition.toString());
      QLog.c("DiniFlyAnimationView", 1, localStringBuilder.toString(), localException);
    }
  }
  
  public void setFailureListener(@Nullable LottieListener<Throwable> paramLottieListener)
  {
    this.failureListener = paramLottieListener;
  }
  
  public void setFallbackResource(@DrawableRes int paramInt)
  {
    this.fallbackResource = paramInt;
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
  
  public void setIgnoreDisabledSystemAnimations(boolean paramBoolean)
  {
    this.lottieDrawable.setIgnoreDisabledSystemAnimations(paramBoolean);
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
  
  public void setMinAndMaxFrame(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.lottieDrawable.setMinAndMaxFrame(paramString1, paramString2, paramBoolean);
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
  
  public void setOutlineMasksAndMattes(boolean paramBoolean)
  {
    this.lottieDrawable.setOutlineMasksAndMattes(paramBoolean);
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
  
  public void setSafeMode(boolean paramBoolean)
  {
    this.lottieDrawable.setSafeMode(paramBoolean);
  }
  
  public void setScale(float paramFloat)
  {
    setScaleXY(paramFloat, paramFloat);
  }
  
  public void setScaleXY(float paramFloat1, float paramFloat2)
  {
    this.lottieDrawable.setScale(paramFloat1, paramFloat2);
    if (getDrawable() == this.lottieDrawable) {
      setLottieDrawable();
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
  
  public void unscheduleDrawable(Drawable paramDrawable)
  {
    LottieDrawable localLottieDrawable;
    if (!this.ignoreUnschedule)
    {
      localLottieDrawable = this.lottieDrawable;
      if ((paramDrawable == localLottieDrawable) && (localLottieDrawable.isAnimating()))
      {
        pauseAnimation();
        break label61;
      }
    }
    if ((!this.ignoreUnschedule) && ((paramDrawable instanceof LottieDrawable)))
    {
      localLottieDrawable = (LottieDrawable)paramDrawable;
      if (localLottieDrawable.isAnimating()) {
        localLottieDrawable.pauseAnimation();
      }
    }
    label61:
    super.unscheduleDrawable(paramDrawable);
  }
  
  @Nullable
  public Bitmap updateBitmap(String paramString, @Nullable Bitmap paramBitmap)
  {
    return this.lottieDrawable.updateBitmap(paramString, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.DiniFlyAnimationView
 * JD-Core Version:    0.7.0.1
 */