package com.tencent.mobileqq.dinifly;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.os.Build.VERSION;
import android.support.annotation.FloatRange;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.SparseArrayCompat;
import android.util.Log;
import android.view.View;
import com.tencent.mobileqq.dinifly.manager.FontAssetManager;
import com.tencent.mobileqq.dinifly.manager.ImageAssetManager;
import com.tencent.mobileqq.dinifly.model.layer.CompositionLayer;
import com.tencent.mobileqq.dinifly.utils.LottieValueAnimator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LottieDrawable
  extends Drawable
  implements Drawable.Callback
{
  private static final String TAG = "LottieDrawable";
  private int alpha = 255;
  private final LottieValueAnimator animator = new LottieValueAnimator();
  private final Set<ColorFilterData> colorFilterData = new HashSet();
  private LottieComposition composition;
  @Nullable
  private CompositionLayer compositionLayer;
  private boolean enableMergePaths;
  @Nullable
  FontAssetDelegate fontAssetDelegate;
  @Nullable
  private FontAssetManager fontAssetManager;
  @Nullable
  private ImageAssetDelegate imageAssetDelegate;
  @Nullable
  private ImageAssetManager imageAssetManager;
  @Nullable
  private String imageAssetsFolder;
  private final ArrayList<LazyCompositionTask> lazyCompositionTasks = new ArrayList();
  private final Matrix matrix = new Matrix();
  private boolean performanceTrackingEnabled;
  private float scale = 1.0F;
  private float scaleX = 1.0F;
  private float scaleY = 1.0F;
  @Nullable
  TextDelegate textDelegate;
  
  public LottieDrawable()
  {
    this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        if (LottieDrawable.this.compositionLayer != null) {
          LottieDrawable.this.compositionLayer.setProgress(LottieDrawable.this.animator.getValue());
        }
      }
    });
  }
  
  private void addColorFilterInternal(@Nullable String paramString1, @Nullable String paramString2, @Nullable ColorFilter paramColorFilter)
  {
    ColorFilterData localColorFilterData = new ColorFilterData(paramString1, paramString2, paramColorFilter);
    if ((paramColorFilter == null) && (this.colorFilterData.contains(localColorFilterData))) {
      this.colorFilterData.remove(localColorFilterData);
    }
    while (this.compositionLayer == null)
    {
      return;
      this.colorFilterData.add(new ColorFilterData(paramString1, paramString2, paramColorFilter));
    }
    this.compositionLayer.addColorFilter(paramString1, paramString2, paramColorFilter);
  }
  
  private void applyColorFilters()
  {
    if (this.compositionLayer == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.colorFilterData.iterator();
      while (localIterator.hasNext())
      {
        ColorFilterData localColorFilterData = (ColorFilterData)localIterator.next();
        this.compositionLayer.addColorFilter(localColorFilterData.layerName, localColorFilterData.contentName, localColorFilterData.colorFilter);
      }
    }
  }
  
  /* Error */
  private void buildCompositionLayer()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 161	android/os/SystemClock:uptimeMillis	()J
    //   5: lstore_1
    //   6: aload_0
    //   7: getfield 163	com/tencent/mobileqq/dinifly/LottieDrawable:composition	Lcom/tencent/mobileqq/dinifly/LottieComposition;
    //   10: getfield 166	com/tencent/mobileqq/dinifly/LottieComposition:compositionLayer	Lcom/tencent/mobileqq/dinifly/model/layer/CompositionLayer;
    //   13: ifnull +32 -> 45
    //   16: aload_0
    //   17: aload_0
    //   18: getfield 163	com/tencent/mobileqq/dinifly/LottieDrawable:composition	Lcom/tencent/mobileqq/dinifly/LottieComposition;
    //   21: getfield 166	com/tencent/mobileqq/dinifly/LottieComposition:compositionLayer	Lcom/tencent/mobileqq/dinifly/model/layer/CompositionLayer;
    //   24: putfield 105	com/tencent/mobileqq/dinifly/LottieDrawable:compositionLayer	Lcom/tencent/mobileqq/dinifly/model/layer/CompositionLayer;
    //   27: aload_0
    //   28: getfield 163	com/tencent/mobileqq/dinifly/LottieDrawable:composition	Lcom/tencent/mobileqq/dinifly/LottieComposition;
    //   31: getfield 170	com/tencent/mobileqq/dinifly/LottieComposition:layerInfo	Lcom/tencent/mobileqq/dinifly/LayerInfo;
    //   34: invokestatic 161	android/os/SystemClock:uptimeMillis	()J
    //   37: lload_1
    //   38: lsub
    //   39: putfield 176	com/tencent/mobileqq/dinifly/LayerInfo:buildLayerTime	J
    //   42: aload_0
    //   43: monitorexit
    //   44: return
    //   45: aload_0
    //   46: new 125	com/tencent/mobileqq/dinifly/model/layer/CompositionLayer
    //   49: dup
    //   50: aload_0
    //   51: aload_0
    //   52: getfield 163	com/tencent/mobileqq/dinifly/LottieDrawable:composition	Lcom/tencent/mobileqq/dinifly/LottieComposition;
    //   55: invokestatic 182	com/tencent/mobileqq/dinifly/model/layer/Layer$Factory:newInstance	(Lcom/tencent/mobileqq/dinifly/LottieComposition;)Lcom/tencent/mobileqq/dinifly/model/layer/Layer;
    //   58: aload_0
    //   59: getfield 163	com/tencent/mobileqq/dinifly/LottieDrawable:composition	Lcom/tencent/mobileqq/dinifly/LottieComposition;
    //   62: invokevirtual 186	com/tencent/mobileqq/dinifly/LottieComposition:getLayers	()Ljava/util/List;
    //   65: aload_0
    //   66: getfield 163	com/tencent/mobileqq/dinifly/LottieDrawable:composition	Lcom/tencent/mobileqq/dinifly/LottieComposition;
    //   69: invokespecial 189	com/tencent/mobileqq/dinifly/model/layer/CompositionLayer:<init>	(Lcom/tencent/mobileqq/dinifly/LottieDrawable;Lcom/tencent/mobileqq/dinifly/model/layer/Layer;Ljava/util/List;Lcom/tencent/mobileqq/dinifly/LottieComposition;)V
    //   72: putfield 105	com/tencent/mobileqq/dinifly/LottieDrawable:compositionLayer	Lcom/tencent/mobileqq/dinifly/model/layer/CompositionLayer;
    //   75: goto -48 -> 27
    //   78: astore_3
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_3
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	LottieDrawable
    //   5	33	1	l	long
    //   78	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	27	78	finally
    //   27	42	78	finally
    //   45	75	78	finally
  }
  
  @Nullable
  private Context getContext()
  {
    Drawable.Callback localCallback = getCallback();
    if (localCallback == null) {}
    while (!(localCallback instanceof View)) {
      return null;
    }
    return ((View)localCallback).getContext();
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
    if (getCallback() == null) {
      return null;
    }
    if ((this.imageAssetManager != null) && (!this.imageAssetManager.hasSameContext(getContext())))
    {
      this.imageAssetManager.recycleBitmaps();
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
    if (this.composition == null) {
      return;
    }
    getScale();
    setBounds(0, 0, (int)(this.composition.getBounds().width() * this.scaleX), (int)(this.composition.getBounds().height() * this.scaleY));
  }
  
  public void addAnimatorListener(Animator.AnimatorListener paramAnimatorListener)
  {
    this.animator.addListener(paramAnimatorListener);
  }
  
  public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener)
  {
    this.animator.addUpdateListener(paramAnimatorUpdateListener);
  }
  
  public void addColorFilter(ColorFilter paramColorFilter)
  {
    addColorFilterInternal(null, null, paramColorFilter);
  }
  
  public void addColorFilterToContent(String paramString1, String paramString2, @Nullable ColorFilter paramColorFilter)
  {
    addColorFilterInternal(paramString1, paramString2, paramColorFilter);
  }
  
  public void addColorFilterToLayer(String paramString, @Nullable ColorFilter paramColorFilter)
  {
    addColorFilterInternal(paramString, null, paramColorFilter);
  }
  
  public void cancelAnimation()
  {
    this.lazyCompositionTasks.clear();
    this.animator.cancel();
  }
  
  public void clearColorFilters()
  {
    this.colorFilterData.clear();
    addColorFilterInternal(null, null, null);
  }
  
  public void clearComposition()
  {
    recycleBitmaps();
    if (this.animator.isRunning()) {
      this.animator.cancel();
    }
    this.composition = null;
    this.compositionLayer = null;
    this.imageAssetManager = null;
    invalidateSelf();
  }
  
  public LayerInfo collectLayerInfo()
  {
    if ((this.composition == null) || (this.compositionLayer == null)) {
      return null;
    }
    this.compositionLayer.collectLayers(this.composition.layerInfo);
    return this.composition.layerInfo;
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    L.beginSection("Drawable#draw");
    if (this.compositionLayer == null) {}
    float f2;
    float f5;
    do
    {
      return;
      float f4 = this.scaleX;
      float f6 = this.scaleY;
      f2 = 1.0F;
      f5 = 1.0F;
      float f3 = getMaxScale(paramCanvas);
      float f1 = f4;
      if (f4 > f3)
      {
        f1 = f3;
        f2 = this.scaleX / f1;
      }
      f4 = f6;
      if (f6 > f3)
      {
        f5 = this.scaleY / f3;
        f4 = f3;
      }
      if ((f2 > 1.0F) || (f5 > 1.0F))
      {
        paramCanvas.save();
        f3 = this.composition.getBounds().width() / 2.0F;
        f6 = this.composition.getBounds().height() / 2.0F;
        float f7 = f3 * f1;
        float f8 = f6 * f4;
        paramCanvas.translate(getScale() * f3 - f7, getScale() * f6 - f8);
        paramCanvas.scale(f2, f5, f7, f8);
      }
      this.matrix.reset();
      this.matrix.preScale(f1, f4);
      this.compositionLayer.draw(paramCanvas, this.matrix, this.alpha);
      L.endSection("Drawable#draw");
    } while ((f2 <= 1.0F) && (f5 <= 1.0F));
    paramCanvas.restore();
  }
  
  public void enableMergePathsForKitKatAndAbove(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 19) {
      Log.w("LottieDrawable", "Merge paths are not supported pre-Kit Kat.");
    }
    do
    {
      return;
      this.enableMergePaths = paramBoolean;
    } while (this.composition == null);
    buildCompositionLayer();
  }
  
  public boolean enableMergePathsForKitKatAndAbove()
  {
    return this.enableMergePaths;
  }
  
  public void endAnimation()
  {
    this.lazyCompositionTasks.clear();
    this.animator.end();
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
    if (this.composition == null) {
      return -1;
    }
    return (int)(this.composition.getBounds().height() * this.scaleY);
  }
  
  public int getIntrinsicWidth()
  {
    if (this.composition == null) {
      return -1;
    }
    return (int)(this.composition.getBounds().width() * this.scaleX);
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  @Nullable
  public PerformanceTracker getPerformanceTracker()
  {
    if (this.composition != null) {
      return this.composition.getPerformanceTracker();
    }
    return null;
  }
  
  @FloatRange(from=0.0D, to=1.0D)
  public float getProgress()
  {
    return this.animator.getValue();
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
    return (this.compositionLayer != null) && (this.compositionLayer.hasMasks());
  }
  
  public boolean hasMatte()
  {
    return (this.compositionLayer != null) && (this.compositionLayer.hasMatte());
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
    Drawable.Callback localCallback = getCallback();
    if (localCallback != null) {
      localCallback.invalidateDrawable(this);
    }
  }
  
  public boolean isAnimating()
  {
    return this.animator.isRunning();
  }
  
  public boolean isLooping()
  {
    return this.animator.getRepeatCount() == -1;
  }
  
  public void loop(boolean paramBoolean)
  {
    LottieValueAnimator localLottieValueAnimator = this.animator;
    if (paramBoolean) {}
    for (int i = -1;; i = 0)
    {
      localLottieValueAnimator.setRepeatCount(i);
      return;
    }
  }
  
  public void pauseAnimation()
  {
    this.lazyCompositionTasks.clear();
    this.animator.pauseAnimation();
  }
  
  public void playAnimation()
  {
    if (this.compositionLayer == null)
    {
      this.lazyCompositionTasks.add(new LazyCompositionTask()
      {
        public void run(LottieComposition paramAnonymousLottieComposition)
        {
          LottieDrawable.this.playAnimation();
        }
      });
      return;
    }
    this.animator.playAnimation();
  }
  
  public void recycleBitmaps()
  {
    if (this.imageAssetManager != null) {
      this.imageAssetManager.recycleBitmaps();
    }
  }
  
  public void removeAllAnimatorListener()
  {
    this.animator.removeAllListeners();
  }
  
  public void removeAnimatorListener(Animator.AnimatorListener paramAnimatorListener)
  {
    this.animator.removeListener(paramAnimatorListener);
  }
  
  public void removeAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener)
  {
    this.animator.removeUpdateListener(paramAnimatorUpdateListener);
  }
  
  public void resumeAnimation()
  {
    if (this.compositionLayer == null)
    {
      this.lazyCompositionTasks.add(new LazyCompositionTask()
      {
        public void run(LottieComposition paramAnonymousLottieComposition)
        {
          LottieDrawable.this.resumeAnimation();
        }
      });
      return;
    }
    this.animator.resumeAnimation();
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
  }
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter)
  {
    throw new UnsupportedOperationException("Use addColorFilter instead.");
  }
  
  public boolean setComposition(LottieComposition paramLottieComposition)
  {
    if (this.composition == paramLottieComposition) {
      return false;
    }
    clearComposition();
    this.composition = paramLottieComposition;
    this.animator.setCompositionDuration(paramLottieComposition.getDuration());
    setProgress(this.animator.getMinValue());
    setScale(this.scaleX, this.scaleY);
    updateBounds();
    buildCompositionLayer();
    applyColorFilters();
    Iterator localIterator = new ArrayList(this.lazyCompositionTasks).iterator();
    while (localIterator.hasNext())
    {
      ((LazyCompositionTask)localIterator.next()).run(paramLottieComposition);
      localIterator.remove();
    }
    this.lazyCompositionTasks.clear();
    paramLottieComposition.setPerformanceTrackingEnabled(this.performanceTrackingEnabled);
    return true;
  }
  
  public void setFontAssetDelegate(FontAssetDelegate paramFontAssetDelegate)
  {
    this.fontAssetDelegate = paramFontAssetDelegate;
    if (this.fontAssetManager != null) {
      this.fontAssetManager.setDelegate(paramFontAssetDelegate);
    }
  }
  
  public void setImageAssetDelegate(ImageAssetDelegate paramImageAssetDelegate)
  {
    this.imageAssetDelegate = paramImageAssetDelegate;
    if (this.imageAssetManager != null) {
      this.imageAssetManager.setDelegate(paramImageAssetDelegate);
    }
  }
  
  public void setImagesAssetsFolder(@Nullable String paramString)
  {
    this.imageAssetsFolder = paramString;
  }
  
  public void setMaxFrame(final int paramInt)
  {
    if (this.composition == null)
    {
      this.lazyCompositionTasks.add(new LazyCompositionTask()
      {
        public void run(LottieComposition paramAnonymousLottieComposition)
        {
          LottieDrawable.this.setMaxFrame(paramInt);
        }
      });
      return;
    }
    setMaxProgress(paramInt / this.composition.getDurationFrames());
  }
  
  public void setMaxProgress(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    this.animator.setMaxValue(paramFloat);
  }
  
  public void setMinAndMaxFrame(int paramInt1, int paramInt2)
  {
    setMinFrame(paramInt1);
    setMaxFrame(paramInt2);
  }
  
  public void setMinAndMaxProgress(@FloatRange(from=0.0D, to=1.0D) float paramFloat1, @FloatRange(from=0.0D, to=1.0D) float paramFloat2)
  {
    setMinProgress(paramFloat1);
    setMaxProgress(paramFloat2);
  }
  
  public void setMinFrame(final int paramInt)
  {
    if (this.composition == null)
    {
      this.lazyCompositionTasks.add(new LazyCompositionTask()
      {
        public void run(LottieComposition paramAnonymousLottieComposition)
        {
          LottieDrawable.this.setMinFrame(paramInt);
        }
      });
      return;
    }
    setMinProgress(paramInt / this.composition.getDurationFrames());
  }
  
  public void setMinProgress(float paramFloat)
  {
    this.animator.setMinValue(paramFloat);
  }
  
  public void setPerformanceTrackingEnabled(boolean paramBoolean)
  {
    this.performanceTrackingEnabled = paramBoolean;
    if (this.composition != null) {
      this.composition.setPerformanceTrackingEnabled(paramBoolean);
    }
  }
  
  public void setProgress(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    this.animator.setValue(paramFloat);
    if (this.compositionLayer != null) {
      this.compositionLayer.setProgress(paramFloat);
    }
  }
  
  public void setRepeatCount(int paramInt)
  {
    this.animator.setRepeatCount(paramInt);
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
  
  public void setTextDelegate(TextDelegate paramTextDelegate)
  {
    this.textDelegate = paramTextDelegate;
  }
  
  void systemAnimationsAreDisabled()
  {
    this.animator.systemAnimationsAreDisabled();
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
      Log.w("LOTTIE", "Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
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
  
  private static class ColorFilterData
  {
    @Nullable
    final ColorFilter colorFilter;
    @Nullable
    final String contentName;
    final String layerName;
    
    ColorFilterData(@Nullable String paramString1, @Nullable String paramString2, @Nullable ColorFilter paramColorFilter)
    {
      this.layerName = paramString1;
      this.contentName = paramString2;
      this.colorFilter = paramColorFilter;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof ColorFilterData)) {
          return false;
        }
        paramObject = (ColorFilterData)paramObject;
      } while ((hashCode() == paramObject.hashCode()) && (this.colorFilter == paramObject.colorFilter));
      return false;
    }
    
    public int hashCode()
    {
      int i = 17;
      if (this.layerName != null) {
        i = this.layerName.hashCode() * 527;
      }
      int j = i;
      if (this.contentName != null) {
        j = i * 31 * this.contentName.hashCode();
      }
      return j;
    }
  }
  
  private static abstract interface LazyCompositionTask
  {
    public abstract void run(LottieComposition paramLottieComposition);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.LottieDrawable
 * JD-Core Version:    0.7.0.1
 */