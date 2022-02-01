package com.tencent.mobileqq.dinifly;

import android.animation.Animator.AnimatorListener;
import android.animation.Animator.AnimatorPauseListener;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.SparseArrayCompat;
import com.tencent.mobileqq.dinifly.manager.FontAssetManager;
import com.tencent.mobileqq.dinifly.manager.ImageAssetManager;
import com.tencent.mobileqq.dinifly.model.KeyPath;
import com.tencent.mobileqq.dinifly.model.KeyPathElement;
import com.tencent.mobileqq.dinifly.model.LottieCompositionCache;
import com.tencent.mobileqq.dinifly.model.Marker;
import com.tencent.mobileqq.dinifly.model.layer.CompositionLayer;
import com.tencent.mobileqq.dinifly.parser.LayerParser;
import com.tencent.mobileqq.dinifly.utils.Logger;
import com.tencent.mobileqq.dinifly.utils.LottieValueAnimator;
import com.tencent.mobileqq.dinifly.utils.MiscUtils;
import com.tencent.mobileqq.dinifly.value.LottieValueCallback;
import com.tencent.mobileqq.dinifly.value.SimpleLottieValueCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class LottieDrawable
  extends Drawable
  implements Animatable, Drawable.Callback
{
  public static final int INFINITE = -1;
  public static final int RESTART = 1;
  public static final int REVERSE = 2;
  private int alpha = 255;
  private final LottieValueAnimator animator = new LottieValueAnimator();
  private LottieComposition composition;
  @Nullable
  private CompositionLayer compositionLayer;
  private boolean enableMergePaths;
  @Nullable
  FontAssetDelegate fontAssetDelegate;
  @Nullable
  private FontAssetManager fontAssetManager;
  private boolean ignoreSystemAnimationsDisabled = false;
  @Nullable
  private ImageAssetDelegate imageAssetDelegate;
  @Nullable
  private ImageAssetManager imageAssetManager;
  @Nullable
  private ImageAssetManager imageAssetManagerOverride;
  @Nullable
  private String imageAssetsFolder;
  private boolean isApplyingOpacityToLayersEnabled;
  private boolean isDirty = false;
  private boolean isExtraScaleEnabled = true;
  private final ArrayList<LottieDrawable.LazyCompositionTask> lazyCompositionTasks = new ArrayList();
  private final Matrix matrix = new Matrix();
  private boolean outlineMasksAndMattes;
  private boolean performanceTrackingEnabled;
  private final ValueAnimator.AnimatorUpdateListener progressUpdateListener = new LottieDrawable.1(this);
  private boolean safeMode = false;
  private float scaleX = 1.0F;
  private float scaleY = 1.0F;
  private boolean systemAnimationsEnabled = true;
  @Nullable
  TextDelegate textDelegate;
  
  public LottieDrawable()
  {
    this.animator.addUpdateListener(this.progressUpdateListener);
  }
  
  private boolean animationsEnabled()
  {
    return (this.systemAnimationsEnabled) || (this.ignoreSystemAnimationsDisabled);
  }
  
  private float aspectRatio(Rect paramRect)
  {
    return paramRect.width() / paramRect.height();
  }
  
  private boolean boundsMatchesCompositionAspectRatio()
  {
    LottieComposition localLottieComposition = this.composition;
    boolean bool = true;
    if (localLottieComposition != null)
    {
      if (getBounds().isEmpty()) {
        return true;
      }
      if (aspectRatio(getBounds()) == aspectRatio(localLottieComposition.getBounds())) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  private void buildCompositionLayer()
  {
    long l = SystemClock.uptimeMillis();
    if (this.composition.compositionLayer != null) {
      this.compositionLayer = this.composition.compositionLayer;
    } else {
      this.compositionLayer = new CompositionLayer(this, LayerParser.parse(this.composition), this.composition.getLayers(), this.composition);
    }
    this.composition.layerInfo.buildLayerTime = (SystemClock.uptimeMillis() - l);
    if (this.outlineMasksAndMattes) {
      this.compositionLayer.setOutlineMasksAndMattes(true);
    }
  }
  
  private void drawInternal(@NonNull Canvas paramCanvas)
  {
    if (!boundsMatchesCompositionAspectRatio())
    {
      drawWithNewAspectRatio(paramCanvas);
      return;
    }
    drawWithOriginalAspectRatio(paramCanvas);
  }
  
  private void drawWithNewAspectRatio(Canvas paramCanvas)
  {
    if (this.compositionLayer == null) {
      return;
    }
    int j = -1;
    Rect localRect = getBounds();
    float f1 = localRect.width() / this.composition.getBounds().width();
    float f2 = localRect.height() / this.composition.getBounds().height();
    int i = j;
    float f4 = f1;
    float f5 = f2;
    if (this.isExtraScaleEnabled)
    {
      float f6 = Math.min(f1, f2);
      float f3;
      if (f6 < 1.0F)
      {
        f3 = 1.0F / f6;
        f1 /= f3;
        f2 /= f3;
      }
      else
      {
        f3 = 1.0F;
      }
      i = j;
      f4 = f1;
      f5 = f2;
      if (f3 > 1.0F)
      {
        i = paramCanvas.save();
        f4 = localRect.width() / 2.0F;
        f5 = localRect.height() / 2.0F;
        float f7 = f4 * f6;
        f6 *= f5;
        paramCanvas.translate(f4 - f7, f5 - f6);
        paramCanvas.scale(f3, f3, f7, f6);
        f5 = f2;
        f4 = f1;
      }
    }
    this.matrix.reset();
    this.matrix.preScale(f4, f5);
    this.compositionLayer.draw(paramCanvas, this.matrix, this.alpha);
    if (i > 0) {
      paramCanvas.restoreToCount(i);
    }
  }
  
  private void drawWithOriginalAspectRatio(Canvas paramCanvas)
  {
    if (this.compositionLayer == null) {
      return;
    }
    float f3 = this.scaleX;
    float f4 = this.scaleY;
    float f1 = getMaxScale(paramCanvas);
    float f2;
    if (f3 > f1)
    {
      f2 = this.scaleX / f1;
      f3 = f1;
    }
    else
    {
      f2 = 1.0F;
    }
    if (f4 > f1)
    {
      f4 = this.scaleY / f1;
    }
    else
    {
      f1 = f4;
      f4 = 1.0F;
    }
    int i = -1;
    if ((f2 > 1.0F) || (f4 > 1.0F))
    {
      i = paramCanvas.save();
      paramCanvas.scale(f2, f4);
    }
    this.matrix.reset();
    this.matrix.preScale(f3, f1);
    this.compositionLayer.draw(paramCanvas, this.matrix, this.alpha);
    if (i > 0) {
      paramCanvas.restoreToCount(i);
    }
  }
  
  @Nullable
  private Context getContext()
  {
    Drawable.Callback localCallback = getCallback();
    if (localCallback == null) {
      return null;
    }
    if ((localCallback instanceof View)) {
      return ((View)localCallback).getContext();
    }
    return null;
  }
  
  private FontAssetManager getFontAssetManager()
  {
    if (getCallback() == null) {
      return null;
    }
    if (this.fontAssetManager == null) {
      this.fontAssetManager = new FontAssetManager(getCallback(), this.fontAssetDelegate);
    }
    return this.fontAssetManager;
  }
  
  private ImageAssetManager getImageAssetManager()
  {
    ImageAssetManager localImageAssetManager = this.imageAssetManagerOverride;
    if (localImageAssetManager != null) {
      return localImageAssetManager;
    }
    if (getCallback() == null) {
      return null;
    }
    localImageAssetManager = this.imageAssetManager;
    if ((localImageAssetManager != null) && (!localImageAssetManager.hasSameContext(getContext()))) {
      this.imageAssetManager = null;
    }
    if (this.imageAssetManager == null) {
      this.imageAssetManager = new ImageAssetManager(getCallback(), this.imageAssetsFolder, this.imageAssetDelegate, this.composition.getImages());
    }
    return this.imageAssetManager;
  }
  
  private float getMaxScale(@NonNull Canvas paramCanvas)
  {
    return Math.min(paramCanvas.getWidth() / this.composition.getBounds().width(), paramCanvas.getHeight() / this.composition.getBounds().height());
  }
  
  private void updateBounds()
  {
    LottieComposition localLottieComposition = this.composition;
    if (localLottieComposition == null) {
      return;
    }
    setBounds(0, 0, (int)(localLottieComposition.getBounds().width() * this.scaleX), (int)(this.composition.getBounds().height() * this.scaleY));
  }
  
  public void addAnimatorListener(Animator.AnimatorListener paramAnimatorListener)
  {
    this.animator.addListener(paramAnimatorListener);
  }
  
  @RequiresApi(api=19)
  public void addAnimatorPauseListener(Animator.AnimatorPauseListener paramAnimatorPauseListener)
  {
    this.animator.addPauseListener(paramAnimatorPauseListener);
  }
  
  public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener)
  {
    this.animator.addUpdateListener(paramAnimatorUpdateListener);
  }
  
  public <T> void addValueCallback(KeyPath paramKeyPath, T paramT, LottieValueCallback<T> paramLottieValueCallback)
  {
    if (this.compositionLayer == null)
    {
      this.lazyCompositionTasks.add(new LottieDrawable.16(this, paramKeyPath, paramT, paramLottieValueCallback));
      return;
    }
    KeyPath localKeyPath = KeyPath.COMPOSITION;
    int i = 1;
    boolean bool;
    if (paramKeyPath == localKeyPath)
    {
      this.compositionLayer.addValueCallback(paramT, paramLottieValueCallback);
    }
    else if (paramKeyPath.getResolvedElement() != null)
    {
      paramKeyPath.getResolvedElement().addValueCallback(paramT, paramLottieValueCallback);
    }
    else
    {
      paramKeyPath = resolveKeyPath(paramKeyPath);
      i = 0;
      while (i < paramKeyPath.size())
      {
        ((KeyPath)paramKeyPath.get(i)).getResolvedElement().addValueCallback(paramT, paramLottieValueCallback);
        i += 1;
      }
      bool = true ^ paramKeyPath.isEmpty();
    }
    if (bool)
    {
      invalidateSelf();
      if (paramT == LottieProperty.TIME_REMAP) {
        setProgress(getProgress());
      }
    }
  }
  
  public <T> void addValueCallback(KeyPath paramKeyPath, T paramT, SimpleLottieValueCallback<T> paramSimpleLottieValueCallback)
  {
    addValueCallback(paramKeyPath, paramT, new LottieDrawable.17(this, paramSimpleLottieValueCallback));
  }
  
  public void cancelAnimation()
  {
    this.lazyCompositionTasks.clear();
    this.animator.cancel();
  }
  
  public void clearComposition()
  {
    if (this.animator.isRunning()) {
      this.animator.cancel();
    }
    this.composition = null;
    this.compositionLayer = null;
    this.imageAssetManager = null;
    this.animator.clearComposition();
    invalidateSelf();
  }
  
  public void clearCompositionAndCache(String paramString)
  {
    LottieCompositionCache.getInstance().removeCacheByKey(paramString);
    LottieCompositionFactory.removeCacheByKey(paramString);
    clearComposition();
  }
  
  public LayerInfo collectLayerInfo()
  {
    LottieComposition localLottieComposition = this.composition;
    if (localLottieComposition != null)
    {
      CompositionLayer localCompositionLayer = this.compositionLayer;
      if (localCompositionLayer != null)
      {
        localCompositionLayer.collectLayers(localLottieComposition.layerInfo);
        return this.composition.layerInfo;
      }
    }
    return null;
  }
  
  public void disableExtraScaleModeInFitXY()
  {
    this.isExtraScaleEnabled = false;
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    this.isDirty = false;
    L.beginSection("Drawable#draw");
    if (this.safeMode) {
      try
      {
        drawInternal(paramCanvas);
      }
      catch (Throwable paramCanvas)
      {
        Logger.error("Lottie crashed in draw!", paramCanvas);
      }
    } else {
      drawInternal(paramCanvas);
    }
    L.endSection("Drawable#draw");
  }
  
  public void enableMergePathsForKitKatAndAbove(boolean paramBoolean)
  {
    if (this.enableMergePaths == paramBoolean) {
      return;
    }
    if (Build.VERSION.SDK_INT < 19)
    {
      Logger.warning("Merge paths are not supported pre-Kit Kat.");
      return;
    }
    this.enableMergePaths = paramBoolean;
    if (this.composition != null) {
      buildCompositionLayer();
    }
  }
  
  public boolean enableMergePathsForKitKatAndAbove()
  {
    return this.enableMergePaths;
  }
  
  @MainThread
  public void endAnimation()
  {
    this.lazyCompositionTasks.clear();
    this.animator.endAnimation();
  }
  
  public int getAlpha()
  {
    return this.alpha;
  }
  
  public LottieComposition getComposition()
  {
    return this.composition;
  }
  
  @Nullable
  public CompositionLayer getCompositionLayer()
  {
    return this.compositionLayer;
  }
  
  public int getFrame()
  {
    return (int)this.animator.getFrame();
  }
  
  @Nullable
  public Bitmap getImageAsset(String paramString)
  {
    ImageAssetManager localImageAssetManager = getImageAssetManager();
    if (localImageAssetManager != null) {
      return localImageAssetManager.bitmapForId(paramString);
    }
    return null;
  }
  
  @Nullable
  public String getImageAssetsFolder()
  {
    return this.imageAssetsFolder;
  }
  
  public int getIntrinsicHeight()
  {
    LottieComposition localLottieComposition = this.composition;
    if (localLottieComposition == null) {
      return -1;
    }
    return (int)(localLottieComposition.getBounds().height() * this.scaleY);
  }
  
  public int getIntrinsicWidth()
  {
    LottieComposition localLottieComposition = this.composition;
    if (localLottieComposition == null) {
      return -1;
    }
    return (int)(localLottieComposition.getBounds().width() * this.scaleX);
  }
  
  public float getMaxFrame()
  {
    return this.animator.getMaxFrame();
  }
  
  public float getMinFrame()
  {
    return this.animator.getMinFrame();
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  @Nullable
  public PerformanceTracker getPerformanceTracker()
  {
    LottieComposition localLottieComposition = this.composition;
    if (localLottieComposition != null) {
      return localLottieComposition.getPerformanceTracker();
    }
    return null;
  }
  
  @FloatRange(from=0.0D, to=1.0D)
  public float getProgress()
  {
    return this.animator.getAnimatedValueAbsolute();
  }
  
  public int getRepeatCount()
  {
    return this.animator.getRepeatCount();
  }
  
  public int getRepeatMode()
  {
    return this.animator.getRepeatMode();
  }
  
  public float getScale()
  {
    return Math.min(this.scaleX, this.scaleY);
  }
  
  public float getSpeed()
  {
    return this.animator.getSpeed();
  }
  
  @Nullable
  public TextDelegate getTextDelegate()
  {
    return this.textDelegate;
  }
  
  @Nullable
  public Typeface getTypeface(String paramString1, String paramString2)
  {
    FontAssetManager localFontAssetManager = getFontAssetManager();
    if (localFontAssetManager != null) {
      return localFontAssetManager.getTypeface(paramString1, paramString2);
    }
    return null;
  }
  
  public boolean hasMasks()
  {
    CompositionLayer localCompositionLayer = this.compositionLayer;
    return (localCompositionLayer != null) && (localCompositionLayer.hasMasks());
  }
  
  public boolean hasMatte()
  {
    CompositionLayer localCompositionLayer = this.compositionLayer;
    return (localCompositionLayer != null) && (localCompositionLayer.hasMatte());
  }
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    paramDrawable = getCallback();
    if (paramDrawable == null) {
      return;
    }
    paramDrawable.invalidateDrawable(this);
  }
  
  public void invalidateSelf()
  {
    if (this.isDirty) {
      return;
    }
    this.isDirty = true;
    Drawable.Callback localCallback = getCallback();
    if (localCallback != null) {
      localCallback.invalidateDrawable(this);
    }
  }
  
  public boolean isAnimating()
  {
    LottieValueAnimator localLottieValueAnimator = this.animator;
    if (localLottieValueAnimator == null) {
      return false;
    }
    return localLottieValueAnimator.isRunning();
  }
  
  public boolean isApplyingOpacityToLayersEnabled()
  {
    return this.isApplyingOpacityToLayersEnabled;
  }
  
  public boolean isLooping()
  {
    return this.animator.getRepeatCount() == -1;
  }
  
  public boolean isMergePathsEnabledForKitKatAndAbove()
  {
    return this.enableMergePaths;
  }
  
  public boolean isRunning()
  {
    return isAnimating();
  }
  
  @Deprecated
  public void loop(boolean paramBoolean)
  {
    LottieValueAnimator localLottieValueAnimator = this.animator;
    int i;
    if (paramBoolean) {
      i = -1;
    } else {
      i = 0;
    }
    localLottieValueAnimator.setRepeatCount(i);
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    if ((this.composition != null) && (!hasMatte()))
    {
      int i = paramRect.width();
      int j = paramRect.height();
      int k = this.composition.getBounds().width();
      int m = this.composition.getBounds().height();
      this.scaleX = (i / k);
      this.scaleY = (j / m);
    }
  }
  
  public void pauseAnimation()
  {
    this.lazyCompositionTasks.clear();
    this.animator.pauseAnimation();
  }
  
  @MainThread
  public void playAnimation()
  {
    if (this.compositionLayer == null)
    {
      this.lazyCompositionTasks.add(new LottieDrawable.2(this));
      return;
    }
    if ((animationsEnabled()) || (getRepeatCount() == 0)) {
      this.animator.playAnimation();
    }
    if (!animationsEnabled())
    {
      float f;
      if (getSpeed() < 0.0F) {
        f = getMinFrame();
      } else {
        f = getMaxFrame();
      }
      setFrame((int)f);
      this.animator.endAnimation();
    }
  }
  
  public void recycleBitmaps()
  {
    ImageAssetManager localImageAssetManager = this.imageAssetManager;
    if (localImageAssetManager != null) {
      localImageAssetManager.recycleBitmaps();
    }
  }
  
  public void removeAllAnimatorListeners()
  {
    this.animator.removeAllListeners();
  }
  
  public void removeAllUpdateListeners()
  {
    this.animator.removeAllUpdateListeners();
    this.animator.addUpdateListener(this.progressUpdateListener);
  }
  
  public void removeAnimatorListener(Animator.AnimatorListener paramAnimatorListener)
  {
    this.animator.removeListener(paramAnimatorListener);
  }
  
  @RequiresApi(api=19)
  public void removeAnimatorPauseListener(Animator.AnimatorPauseListener paramAnimatorPauseListener)
  {
    this.animator.removePauseListener(paramAnimatorPauseListener);
  }
  
  public void removeAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener)
  {
    this.animator.removeUpdateListener(paramAnimatorUpdateListener);
  }
  
  public List<KeyPath> resolveKeyPath(KeyPath paramKeyPath)
  {
    if (this.compositionLayer == null)
    {
      Logger.warning("Cannot resolve KeyPath. Composition is not set yet.");
      return Collections.emptyList();
    }
    ArrayList localArrayList = new ArrayList();
    this.compositionLayer.resolveKeyPath(paramKeyPath, 0, localArrayList, new KeyPath(new String[0]));
    return localArrayList;
  }
  
  @MainThread
  public void resumeAnimation()
  {
    if (this.compositionLayer == null)
    {
      this.lazyCompositionTasks.add(new LottieDrawable.3(this));
      return;
    }
    if ((animationsEnabled()) || (getRepeatCount() == 0)) {
      this.animator.resumeAnimation();
    }
    if (!animationsEnabled())
    {
      float f;
      if (getSpeed() < 0.0F) {
        f = getMinFrame();
      } else {
        f = getMaxFrame();
      }
      setFrame((int)f);
      this.animator.endAnimation();
    }
  }
  
  public void reverseAnimationSpeed()
  {
    this.animator.reverseAnimationSpeed();
  }
  
  public void scheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable, long paramLong)
  {
    paramDrawable = getCallback();
    if (paramDrawable == null) {
      return;
    }
    paramDrawable.scheduleDrawable(this, paramRunnable, paramLong);
  }
  
  public void setAlpha(@IntRange(from=0L, to=255L) int paramInt)
  {
    this.alpha = paramInt;
    invalidateSelf();
  }
  
  public void setApplyingOpacityToLayersEnabled(boolean paramBoolean)
  {
    this.isApplyingOpacityToLayersEnabled = paramBoolean;
  }
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter)
  {
    Logger.warning("Use addColorFilter instead.");
  }
  
  public boolean setComposition(LottieComposition paramLottieComposition)
  {
    if (this.composition == paramLottieComposition) {
      return false;
    }
    this.isDirty = false;
    clearComposition();
    this.composition = paramLottieComposition;
    buildCompositionLayer();
    this.animator.setComposition(paramLottieComposition);
    setProgress(this.animator.getAnimatedFraction());
    setScale(this.scaleX, this.scaleY);
    Iterator localIterator = new ArrayList(this.lazyCompositionTasks).iterator();
    while (localIterator.hasNext())
    {
      LottieDrawable.LazyCompositionTask localLazyCompositionTask = (LottieDrawable.LazyCompositionTask)localIterator.next();
      if (localLazyCompositionTask != null) {
        localLazyCompositionTask.run(paramLottieComposition);
      }
      localIterator.remove();
    }
    this.lazyCompositionTasks.clear();
    paramLottieComposition.setPerformanceTrackingEnabled(this.performanceTrackingEnabled);
    paramLottieComposition = getCallback();
    if ((paramLottieComposition instanceof ImageView))
    {
      paramLottieComposition = (ImageView)paramLottieComposition;
      paramLottieComposition.setImageDrawable(null);
      paramLottieComposition.setImageDrawable(this);
    }
    return true;
  }
  
  public void setFontAssetDelegate(FontAssetDelegate paramFontAssetDelegate)
  {
    this.fontAssetDelegate = paramFontAssetDelegate;
    FontAssetManager localFontAssetManager = this.fontAssetManager;
    if (localFontAssetManager != null) {
      localFontAssetManager.setDelegate(paramFontAssetDelegate);
    }
  }
  
  public void setFrame(int paramInt)
  {
    if (this.composition == null)
    {
      this.lazyCompositionTasks.add(new LottieDrawable.14(this, paramInt));
      return;
    }
    this.animator.setFrame(paramInt);
  }
  
  public void setIgnoreDisabledSystemAnimations(boolean paramBoolean)
  {
    this.ignoreSystemAnimationsDisabled = paramBoolean;
  }
  
  public void setImageAssetDelegate(ImageAssetDelegate paramImageAssetDelegate)
  {
    this.imageAssetDelegate = paramImageAssetDelegate;
    ImageAssetManager localImageAssetManager = this.imageAssetManager;
    if (localImageAssetManager != null) {
      localImageAssetManager.setDelegate(paramImageAssetDelegate);
    }
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  void setImageAssetManager(@Nullable ImageAssetManager paramImageAssetManager)
  {
    this.imageAssetManagerOverride = paramImageAssetManager;
  }
  
  public void setImagesAssetsFolder(@Nullable String paramString)
  {
    this.imageAssetsFolder = paramString;
  }
  
  public void setMaxFrame(int paramInt)
  {
    if (this.composition == null)
    {
      this.lazyCompositionTasks.add(new LottieDrawable.6(this, paramInt));
      return;
    }
    this.animator.setMaxFrame(paramInt + 0.99F);
  }
  
  public void setMaxFrame(String paramString)
  {
    Object localObject = this.composition;
    if (localObject == null)
    {
      this.lazyCompositionTasks.add(new LottieDrawable.9(this, paramString));
      return;
    }
    localObject = ((LottieComposition)localObject).getMarker(paramString);
    if (localObject != null)
    {
      setMaxFrame((int)(((Marker)localObject).startFrame + ((Marker)localObject).durationFrames));
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Cannot find marker with name ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(".");
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public void setMaxProgress(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    LottieComposition localLottieComposition = this.composition;
    if (localLottieComposition == null)
    {
      this.lazyCompositionTasks.add(new LottieDrawable.7(this, paramFloat));
      return;
    }
    setMaxFrame((int)MiscUtils.lerp(localLottieComposition.getStartFrame(), this.composition.getEndFrame(), paramFloat));
  }
  
  public void setMinAndMaxFrame(int paramInt1, int paramInt2)
  {
    if (this.composition == null)
    {
      this.lazyCompositionTasks.add(new LottieDrawable.12(this, paramInt1, paramInt2));
      return;
    }
    this.animator.setMinAndMaxFrames(paramInt1, paramInt2 + 0.99F);
  }
  
  public void setMinAndMaxFrame(String paramString)
  {
    Object localObject = this.composition;
    if (localObject == null)
    {
      this.lazyCompositionTasks.add(new LottieDrawable.10(this, paramString));
      return;
    }
    localObject = ((LottieComposition)localObject).getMarker(paramString);
    if (localObject != null)
    {
      int i = (int)((Marker)localObject).startFrame;
      setMinAndMaxFrame(i, (int)((Marker)localObject).durationFrames + i);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Cannot find marker with name ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(".");
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public void setMinAndMaxFrame(String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject = this.composition;
    if (localObject == null)
    {
      this.lazyCompositionTasks.add(new LottieDrawable.11(this, paramString1, paramString2, paramBoolean));
      return;
    }
    localObject = ((LottieComposition)localObject).getMarker(paramString1);
    if (localObject != null)
    {
      int i = (int)((Marker)localObject).startFrame;
      paramString1 = this.composition.getMarker(paramString2);
      if (paramString1 != null)
      {
        float f2 = paramString1.startFrame;
        float f1;
        if (paramBoolean) {
          f1 = 1.0F;
        } else {
          f1 = 0.0F;
        }
        setMinAndMaxFrame(i, (int)(f2 + f1));
        return;
      }
      paramString1 = new StringBuilder();
      paramString1.append("Cannot find marker with name ");
      paramString1.append(paramString2);
      paramString1.append(".");
      throw new IllegalArgumentException(paramString1.toString());
    }
    paramString2 = new StringBuilder();
    paramString2.append("Cannot find marker with name ");
    paramString2.append(paramString1);
    paramString2.append(".");
    throw new IllegalArgumentException(paramString2.toString());
  }
  
  public void setMinAndMaxProgress(@FloatRange(from=0.0D, to=1.0D) float paramFloat1, @FloatRange(from=0.0D, to=1.0D) float paramFloat2)
  {
    LottieComposition localLottieComposition = this.composition;
    if (localLottieComposition == null)
    {
      this.lazyCompositionTasks.add(new LottieDrawable.13(this, paramFloat1, paramFloat2));
      return;
    }
    setMinAndMaxFrame((int)MiscUtils.lerp(localLottieComposition.getStartFrame(), this.composition.getEndFrame(), paramFloat1), (int)MiscUtils.lerp(this.composition.getStartFrame(), this.composition.getEndFrame(), paramFloat2));
  }
  
  public void setMinFrame(int paramInt)
  {
    if (this.composition == null)
    {
      this.lazyCompositionTasks.add(new LottieDrawable.4(this, paramInt));
      return;
    }
    this.animator.setMinFrame(paramInt);
  }
  
  public void setMinFrame(String paramString)
  {
    Object localObject = this.composition;
    if (localObject == null)
    {
      this.lazyCompositionTasks.add(new LottieDrawable.8(this, paramString));
      return;
    }
    localObject = ((LottieComposition)localObject).getMarker(paramString);
    if (localObject != null)
    {
      setMinFrame((int)((Marker)localObject).startFrame);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Cannot find marker with name ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(".");
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public void setMinProgress(float paramFloat)
  {
    LottieComposition localLottieComposition = this.composition;
    if (localLottieComposition == null)
    {
      this.lazyCompositionTasks.add(new LottieDrawable.5(this, paramFloat));
      return;
    }
    setMinFrame((int)MiscUtils.lerp(localLottieComposition.getStartFrame(), this.composition.getEndFrame(), paramFloat));
  }
  
  public void setOutlineMasksAndMattes(boolean paramBoolean)
  {
    if (this.outlineMasksAndMattes == paramBoolean) {
      return;
    }
    this.outlineMasksAndMattes = paramBoolean;
    CompositionLayer localCompositionLayer = this.compositionLayer;
    if (localCompositionLayer != null) {
      localCompositionLayer.setOutlineMasksAndMattes(paramBoolean);
    }
  }
  
  public void setPerformanceTrackingEnabled(boolean paramBoolean)
  {
    this.performanceTrackingEnabled = paramBoolean;
    LottieComposition localLottieComposition = this.composition;
    if (localLottieComposition != null) {
      localLottieComposition.setPerformanceTrackingEnabled(paramBoolean);
    }
  }
  
  public void setProgress(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    if (this.composition == null)
    {
      this.lazyCompositionTasks.add(new LottieDrawable.15(this, paramFloat));
      return;
    }
    L.beginSection("Drawable#setProgress");
    this.animator.setFrame(MiscUtils.lerp(this.composition.getStartFrame(), this.composition.getEndFrame(), paramFloat));
    L.endSection("Drawable#setProgress");
  }
  
  public void setRepeatCount(int paramInt)
  {
    this.animator.setRepeatCount(paramInt);
  }
  
  public void setRepeatMode(int paramInt)
  {
    this.animator.setRepeatMode(paramInt);
  }
  
  public void setSafeMode(boolean paramBoolean)
  {
    this.safeMode = paramBoolean;
  }
  
  public void setScale(float paramFloat1, float paramFloat2)
  {
    this.scaleX = paramFloat1;
    this.scaleY = paramFloat2;
    updateBounds();
  }
  
  public void setSpeed(float paramFloat)
  {
    this.animator.setSpeed(paramFloat);
  }
  
  void setSystemAnimationsAreEnabled(Boolean paramBoolean)
  {
    this.systemAnimationsEnabled = paramBoolean.booleanValue();
  }
  
  public void setTextDelegate(TextDelegate paramTextDelegate)
  {
    this.textDelegate = paramTextDelegate;
  }
  
  @MainThread
  public void start()
  {
    Drawable.Callback localCallback = getCallback();
    if (((localCallback instanceof View)) && (!((View)localCallback).isInEditMode())) {
      playAnimation();
    }
  }
  
  @MainThread
  public void stop()
  {
    endAnimation();
  }
  
  public void unscheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable)
  {
    paramDrawable = getCallback();
    if (paramDrawable == null) {
      return;
    }
    paramDrawable.unscheduleDrawable(this, paramRunnable);
  }
  
  @Nullable
  public Bitmap updateBitmap(String paramString, @Nullable Bitmap paramBitmap)
  {
    ImageAssetManager localImageAssetManager = getImageAssetManager();
    if (localImageAssetManager == null)
    {
      Logger.warning("Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
      return null;
    }
    paramString = localImageAssetManager.updateBitmap(paramString, paramBitmap);
    invalidateSelf();
    return paramString;
  }
  
  public boolean useTextGlyphs()
  {
    return (this.textDelegate == null) && (this.composition.getCharacters().size() > 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.LottieDrawable
 * JD-Core Version:    0.7.0.1
 */