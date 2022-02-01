package com.tencent.timi.game.ui.pag;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.timi.game.initer.api.IniterService;
import com.tencent.timi.game.initer.api.OnPAGLibraryLoadedListener;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.ui.IPAGView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGComposition;
import org.libpag.PAGView;
import org.libpag.PAGView.PAGViewListener;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/ui/pag/TimiGamePAGView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/timi/game/ui/IPAGView;", "ctx", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "def", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isPAGViewAdded", "", "()Z", "setPAGViewAdded", "(Z)V", "mPAGLibraryLoadedListener", "com/tencent/timi/game/ui/pag/TimiGamePAGView$mPAGLibraryLoadedListener$1", "Lcom/tencent/timi/game/ui/pag/TimiGamePAGView$mPAGLibraryLoadedListener$1;", "pagView", "Lorg/libpag/PAGView;", "addListener", "", "listener", "Lorg/libpag/PAGView$PAGViewListener;", "addPAGFlushListener", "Lorg/libpag/PAGView$PAGFlushListener;", "addPAGView", "cacheEnable", "cacheScale", "", "duration", "", "flush", "freeCache", "getComposition", "Lorg/libpag/PAGComposition;", "getLayersUnderPoint", "", "Lorg/libpag/PAGLayer;", "x", "y", "(FF)[Lorg/libpag/PAGLayer;", "getPath", "", "getProgress", "", "isPlaying", "matrix", "Landroid/graphics/Matrix;", "maxFrameRate", "onDetachedFromWindow", "onScreenOff", "onScreenOn", "onSurfaceTextureAvailable", "surface", "Landroid/graphics/SurfaceTexture;", "width", "height", "onSurfaceTextureDestroyed", "onSurfaceTextureSizeChanged", "onSurfaceUpdate", "play", "removeListener", "removePAGFlushListener", "scaleMode", "setCacheEnable", "value", "setCacheScale", "setComposition", "newComposition", "setMatrix", "setMaxFrameRate", "setPath", "path", "setProgress", "setRepeatCount", "setScaleMode", "mode", "setSurfaceTextureListener", "Landroid/view/TextureView$SurfaceTextureListener;", "setVideoEnable", "enable", "stop", "videoEnable", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TimiGamePAGView
  extends FrameLayout
  implements IPAGView
{
  private final TimiGamePAGView.mPAGLibraryLoadedListener.1 a = new TimiGamePAGView.mPAGLibraryLoadedListener.1(this);
  private PAGView b;
  private boolean c;
  
  @JvmOverloads
  public TimiGamePAGView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public TimiGamePAGView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public TimiGamePAGView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = ServiceCenter.a(IniterService.class);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "ServiceCenter.getService…niterService::class.java)");
    if (((IniterService)paramContext).c())
    {
      e();
      return;
    }
    ((IniterService)ServiceCenter.a(IniterService.class)).a((OnPAGLibraryLoadedListener)this.a);
  }
  
  private final void e()
  {
    if (this.c) {
      return;
    }
    this.c = true;
    PAGView localPAGView = new PAGView(getContext());
    this.b = localPAGView;
    addView((View)localPAGView, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
  }
  
  public void a(@NotNull PAGView.PAGViewListener paramPAGViewListener)
  {
    Intrinsics.checkParameterIsNotNull(paramPAGViewListener, "listener");
    PAGView localPAGView = this.b;
    if (localPAGView != null) {
      localPAGView.addListener(paramPAGViewListener);
    }
  }
  
  public final boolean a()
  {
    return this.c;
  }
  
  public boolean b()
  {
    PAGView localPAGView = this.b;
    if (localPAGView != null) {
      return localPAGView.isPlaying();
    }
    return false;
  }
  
  public void c()
  {
    PAGView localPAGView = this.b;
    if (localPAGView != null) {
      localPAGView.play();
    }
  }
  
  public void d()
  {
    PAGView localPAGView = this.b;
    if (localPAGView != null) {
      localPAGView.stop();
    }
  }
  
  @Nullable
  public PAGComposition getComposition()
  {
    PAGView localPAGView = this.b;
    if (localPAGView != null) {
      return localPAGView.getComposition();
    }
    return null;
  }
  
  @NotNull
  public String getPath()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = ((PAGView)localObject).getPath();
      if (localObject != null) {
        return localObject;
      }
    }
    return "";
  }
  
  public double getProgress()
  {
    PAGView localPAGView = this.b;
    if (localPAGView != null) {
      return localPAGView.getProgress();
    }
    return 0.0D;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    ((IniterService)ServiceCenter.a(IniterService.class)).b((OnPAGLibraryLoadedListener)this.a);
  }
  
  public void setCacheEnable(boolean paramBoolean)
  {
    PAGView localPAGView = this.b;
    if (localPAGView != null) {
      localPAGView.setCacheEnabled(paramBoolean);
    }
  }
  
  public void setCacheScale(float paramFloat)
  {
    PAGView localPAGView = this.b;
    if (localPAGView != null) {
      localPAGView.setCacheScale(paramFloat);
    }
  }
  
  public void setComposition(@NotNull PAGComposition paramPAGComposition)
  {
    Intrinsics.checkParameterIsNotNull(paramPAGComposition, "newComposition");
    PAGView localPAGView = this.b;
    if (localPAGView != null) {
      localPAGView.setComposition(paramPAGComposition);
    }
  }
  
  public void setMatrix(@NotNull Matrix paramMatrix)
  {
    Intrinsics.checkParameterIsNotNull(paramMatrix, "matrix");
    PAGView localPAGView = this.b;
    if (localPAGView != null) {
      localPAGView.setMatrix(paramMatrix);
    }
  }
  
  public void setMaxFrameRate(float paramFloat)
  {
    PAGView localPAGView = this.b;
    if (localPAGView != null) {
      localPAGView.setMaxFrameRate(paramFloat);
    }
  }
  
  public final void setPAGViewAdded(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void setPath(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "path");
    PAGView localPAGView = this.b;
    if (localPAGView != null) {
      localPAGView.setPath(paramString);
    }
  }
  
  public void setProgress(double paramDouble)
  {
    PAGView localPAGView = this.b;
    if (localPAGView != null) {
      localPAGView.setProgress(paramDouble);
    }
  }
  
  public void setRepeatCount(int paramInt)
  {
    PAGView localPAGView = this.b;
    if (localPAGView != null) {
      localPAGView.setRepeatCount(paramInt);
    }
  }
  
  public void setScaleMode(int paramInt)
  {
    PAGView localPAGView = this.b;
    if (localPAGView != null) {
      localPAGView.setScaleMode(paramInt);
    }
  }
  
  public void setSurfaceTextureListener(@NotNull TextureView.SurfaceTextureListener paramSurfaceTextureListener)
  {
    Intrinsics.checkParameterIsNotNull(paramSurfaceTextureListener, "listener");
    PAGView localPAGView = this.b;
    if (localPAGView != null) {
      localPAGView.setSurfaceTextureListener(paramSurfaceTextureListener);
    }
  }
  
  public void setVideoEnable(boolean paramBoolean)
  {
    PAGView localPAGView = this.b;
    if (localPAGView != null) {
      localPAGView.setVideoEnabled(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.pag.TimiGamePAGView
 * JD-Core Version:    0.7.0.1
 */