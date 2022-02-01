package com.tencent.mobileqq.cmshow.crossengine;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.crossengine.CEApplication;
import com.tencent.crossengine.offscreen.CEOffscreenRenderView;
import com.tencent.mobileqq.apollo.listener.OnApolloViewListener;
import com.tencent.mobileqq.apollo.touch.CMActionTouchManager;
import com.tencent.mobileqq.apollo.touch.ICMTouchManager;
import com.tencent.mobileqq.cmshow.engine.model.RenderConfig;
import com.tencent.mobileqq.cmshow.engine.render.ICMShowView;
import com.tencent.mobileqq.cmshow.engine.render.ICMShowView.DefaultImpls;
import com.tencent.mobileqq.cmshow.engine.render.RenderMode;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenView;", "Lcom/tencent/crossengine/offscreen/CEOffscreenRenderView;", "Lcom/tencent/mobileqq/cmshow/engine/render/ICMShowView;", "context", "Landroid/content/Context;", "ceApplication", "Lcom/tencent/crossengine/CEApplication;", "worldName", "", "renderConfig", "Lcom/tencent/mobileqq/cmshow/engine/model/RenderConfig;", "viewListener", "Lcom/tencent/mobileqq/apollo/listener/OnApolloViewListener;", "(Landroid/content/Context;Lcom/tencent/crossengine/CEApplication;Ljava/lang/String;Lcom/tencent/mobileqq/cmshow/engine/model/RenderConfig;Lcom/tencent/mobileqq/apollo/listener/OnApolloViewListener;)V", "TAG", "TAG$1", "actionTouchManager", "Lcom/tencent/mobileqq/apollo/touch/CMActionTouchManager;", "hasCallbackSurfaceReady", "", "getRenderConfig", "()Lcom/tencent/mobileqq/cmshow/engine/model/RenderConfig;", "getViewListener", "()Lcom/tencent/mobileqq/apollo/listener/OnApolloViewListener;", "getRenderHeight", "", "getRenderWidth", "getTouchManager", "Lcom/tencent/mobileqq/apollo/touch/ICMTouchManager;", "getView", "Landroid/view/View;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "height", "onSurfaceTextureDestroyed", "onSurfaceTextureSizeChanged", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "pause", "resume", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CECMShowOffscreenView
  extends CEOffscreenRenderView
  implements ICMShowView
{
  public static final CECMShowOffscreenView.Companion a = new CECMShowOffscreenView.Companion(null);
  private final String b;
  private boolean c;
  private CMActionTouchManager d;
  @Nullable
  private final RenderConfig e;
  @NotNull
  private final OnApolloViewListener f;
  
  public CECMShowOffscreenView(@NotNull Context paramContext, @NotNull CEApplication paramCEApplication, @NotNull String paramString, @Nullable RenderConfig paramRenderConfig, @NotNull OnApolloViewListener paramOnApolloViewListener)
  {
    super(paramContext, paramCEApplication, paramString);
    this.e = paramRenderConfig;
    this.f = paramOnApolloViewListener;
    this.b = "[cmshow][CECMShowOffscreenEngine][CERenderService][CECMShowOffscreenView]";
    this.d = new CMActionTouchManager((View)this, this.f);
  }
  
  public int getInitHeight()
  {
    return ICMShowView.DefaultImpls.a(this);
  }
  
  @Nullable
  public final RenderConfig getRenderConfig()
  {
    return this.e;
  }
  
  public int getRenderHeight()
  {
    Object localObject = this.e;
    if (localObject != null) {
      localObject = ((RenderConfig)localObject).f;
    } else {
      localObject = null;
    }
    if (localObject == RenderMode.OFF_SCREEN)
    {
      localObject = this.e.g.second;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "renderConfig.offScreenSize.second");
      return ((Number)localObject).intValue();
    }
    return getView().getHeight();
  }
  
  public int getRenderWidth()
  {
    Object localObject = this.e;
    if (localObject != null) {
      localObject = ((RenderConfig)localObject).f;
    } else {
      localObject = null;
    }
    if (localObject == RenderMode.OFF_SCREEN)
    {
      localObject = this.e.g.first;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "renderConfig.offScreenSize.first");
      return ((Number)localObject).intValue();
    }
    return getView().getWidth();
  }
  
  @NotNull
  public ICMTouchManager getTouchManager()
  {
    return (ICMTouchManager)this.d;
  }
  
  @NotNull
  public View getView()
  {
    return (View)this;
  }
  
  @NotNull
  public final OnApolloViewListener getViewListener()
  {
    return this.f;
  }
  
  public void onSurfaceTextureAvailable(@Nullable SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    long l = System.currentTimeMillis();
    super.onSurfaceTextureAvailable(paramSurfaceTexture, paramInt1, paramInt2);
    if (!this.c)
    {
      this.c = true;
      this.f.a(paramInt1, paramInt2);
    }
    paramSurfaceTexture = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSurfaceTextureAvailable costTime:");
    localStringBuilder.append(System.currentTimeMillis() - l);
    QLog.i(paramSurfaceTexture, 1, localStringBuilder.toString());
  }
  
  public boolean onSurfaceTextureDestroyed(@Nullable SurfaceTexture paramSurfaceTexture)
  {
    long l = System.currentTimeMillis();
    boolean bool = super.onSurfaceTextureDestroyed(paramSurfaceTexture);
    paramSurfaceTexture = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSurfaceTextureDestroyed costTime:");
    localStringBuilder.append(System.currentTimeMillis() - l);
    QLog.i(paramSurfaceTexture, 1, localStringBuilder.toString());
    return bool;
  }
  
  public void onSurfaceTextureSizeChanged(@Nullable SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    long l = System.currentTimeMillis();
    super.onSurfaceTextureSizeChanged(paramSurfaceTexture, paramInt1, paramInt2);
    paramSurfaceTexture = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSurfaceTextureSizeChanged costTime:");
    localStringBuilder.append(System.currentTimeMillis() - l);
    QLog.i(paramSurfaceTexture, 1, localStringBuilder.toString());
  }
  
  public boolean onTouchEvent(@NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "event");
    boolean bool = this.d.a(paramMotionEvent);
    String str = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onTouchEvent, event:");
    localStringBuilder.append(paramMotionEvent.getAction());
    localStringBuilder.append(", ret: ");
    localStringBuilder.append(bool);
    QLog.i(str, 1, localStringBuilder.toString());
    return bool;
  }
  
  public void pause()
  {
    QLog.d(this.b, 1, "pause");
    super.b();
    setVisibility(8);
  }
  
  public void resume()
  {
    QLog.d(this.b, 1, "resume");
    super.a();
    setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.CECMShowOffscreenView
 * JD-Core Version:    0.7.0.1
 */