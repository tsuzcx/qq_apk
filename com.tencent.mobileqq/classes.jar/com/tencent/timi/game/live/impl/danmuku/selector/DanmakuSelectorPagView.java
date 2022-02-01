package com.tencent.timi.game.live.impl.danmuku.selector;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.util.AttributeSet;
import com.tencent.timi.game.ex.LayoutExKt;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGComposition;
import org.libpag.PAGFile;
import org.libpag.PAGLayer;
import org.libpag.PAGView;
import org.libpag.PAGView.PAGViewListener;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/live/impl/danmuku/selector/DanmakuSelectorPagView;", "Lorg/libpag/PAGView;", "ctx", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "def", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "assetLoaded", "Ljava/util/concurrent/atomic/AtomicBoolean;", "paused", "playRunnable", "Ljava/lang/Runnable;", "onDetachedFromWindow", "", "startPlay", "assetFileName", "", "stopPlay", "loadAsset", "width", "height", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class DanmakuSelectorPagView
  extends PAGView
{
  private final AtomicBoolean a = new AtomicBoolean(false);
  private final AtomicBoolean b = new AtomicBoolean(false);
  private final Runnable c = (Runnable)new DanmakuSelectorPagView.playRunnable.1(this);
  
  @JvmOverloads
  public DanmakuSelectorPagView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public DanmakuSelectorPagView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public DanmakuSelectorPagView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private final void a(@NotNull PAGView paramPAGView, String paramString, int paramInt1, int paramInt2)
  {
    if (this.b.get()) {
      return;
    }
    PAGComposition localPAGComposition = PAGComposition.Make(paramInt1, paramInt2);
    Object localObject = paramPAGView.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
    localObject = ((Context)localObject).getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context.resources");
    localObject = ((Resources)localObject).getAssets();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pag/");
    localStringBuilder.append(paramString);
    localObject = PAGFile.Load((AssetManager)localObject, localStringBuilder.toString());
    if (localObject != null) {
      paramString = ((PAGFile)localObject).getTotalMatrix();
    } else {
      paramString = null;
    }
    float f = LayoutExKt.a(39) / ((PAGFile)localObject).width();
    if (paramString != null) {
      paramString.setScale(f, f);
    }
    if (localObject != null) {
      ((PAGFile)localObject).setMatrix(paramString);
    }
    if (localPAGComposition != null) {
      localPAGComposition.addLayer((PAGLayer)localObject);
    }
    paramPAGView.setComposition(localPAGComposition);
    paramPAGView.setRepeatCount(1);
    paramPAGView.addListener((PAGView.PAGViewListener)new DanmakuSelectorPagView.loadAsset.1(this, paramPAGView));
  }
  
  public final void a()
  {
    stop();
    this.b.set(false);
    this.a.set(true);
    removeCallbacks(this.c);
    PAGComposition localPAGComposition = getComposition();
    if (localPAGComposition != null) {
      localPAGComposition.removeAllLayers();
    }
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "assetFileName");
    this.a.set(false);
    removeCallbacks(this.c);
    a(this, paramString, getWidth(), getHeight());
    if (!isPlaying()) {
      play();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.live.impl.danmuku.selector.DanmakuSelectorPagView
 * JD-Core Version:    0.7.0.1
 */