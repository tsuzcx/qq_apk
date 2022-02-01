package com.tencent.mobileqq.cmshow.crossengine;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.crossengine.CERenderView;
import com.tencent.crossengine.RenderContext;
import com.tencent.crossengine.TouchProcessor;
import com.tencent.mobileqq.apollo.listener.OnApolloViewListener;
import com.tencent.mobileqq.apollo.touch.CMActionTouchManager;
import com.tencent.mobileqq.apollo.touch.ICMTouchManager;
import com.tencent.mobileqq.cmshow.engine.render.ICMShowView;
import com.tencent.mobileqq.cmshow.engine.render.ICMShowView.DefaultImpls;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/crossengine/CECMShowView;", "Lcom/tencent/crossengine/CERenderView;", "Lcom/tencent/mobileqq/cmshow/engine/render/ICMShowView;", "context", "Landroid/content/Context;", "renderContext", "Lcom/tencent/crossengine/RenderContext;", "touchEventManager", "Lcom/tencent/crossengine/TouchProcessor;", "viewListener", "Lcom/tencent/mobileqq/apollo/listener/OnApolloViewListener;", "(Landroid/content/Context;Lcom/tencent/crossengine/RenderContext;Lcom/tencent/crossengine/TouchProcessor;Lcom/tencent/mobileqq/apollo/listener/OnApolloViewListener;)V", "TAG", "", "actionTouchManager", "Lcom/tencent/mobileqq/apollo/touch/CMActionTouchManager;", "hasCallbackSurfaceReady", "", "getRenderContext", "()Lcom/tencent/crossengine/RenderContext;", "getTouchEventManager", "()Lcom/tencent/crossengine/TouchProcessor;", "getViewListener", "()Lcom/tencent/mobileqq/apollo/listener/OnApolloViewListener;", "getRenderHeight", "", "getRenderWidth", "getTouchManager", "Lcom/tencent/mobileqq/apollo/touch/ICMTouchManager;", "getView", "Landroid/view/View;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "height", "onSurfaceTextureDestroyed", "onSurfaceTextureSizeChanged", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "pause", "resume", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CECMShowView
  extends CERenderView
  implements ICMShowView
{
  private final String a;
  private boolean b;
  private CMActionTouchManager c;
  @NotNull
  private final RenderContext d;
  @NotNull
  private final TouchProcessor e;
  @NotNull
  private final OnApolloViewListener f;
  
  public CECMShowView(@NotNull Context paramContext, @NotNull RenderContext paramRenderContext, @NotNull TouchProcessor paramTouchProcessor, @NotNull OnApolloViewListener paramOnApolloViewListener)
  {
    super(paramContext, paramRenderContext, paramTouchProcessor);
    this.d = paramRenderContext;
    this.e = paramTouchProcessor;
    this.f = paramOnApolloViewListener;
    this.a = "[cmshow][CECMShowOffscreenEngine][CERenderService][CECMShowView]";
    this.c = new CMActionTouchManager((View)this, this.f);
  }
  
  public int getInitHeight()
  {
    return ICMShowView.DefaultImpls.a(this);
  }
  
  @NotNull
  public final RenderContext getRenderContext()
  {
    return this.d;
  }
  
  public int getRenderHeight()
  {
    return getView().getHeight();
  }
  
  public int getRenderWidth()
  {
    return getView().getWidth();
  }
  
  @NotNull
  public final TouchProcessor getTouchEventManager()
  {
    return this.e;
  }
  
  @NotNull
  public ICMTouchManager getTouchManager()
  {
    return (ICMTouchManager)this.c;
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
    if (!this.b)
    {
      this.b = true;
      this.f.a(paramInt1, paramInt2);
    }
    paramSurfaceTexture = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSurfaceTextureAvailable costTime:");
    localStringBuilder.append(System.currentTimeMillis() - l);
    QLog.i(paramSurfaceTexture, 1, localStringBuilder.toString());
  }
  
  public boolean onSurfaceTextureDestroyed(@Nullable SurfaceTexture paramSurfaceTexture)
  {
    long l = System.currentTimeMillis();
    boolean bool = super.onSurfaceTextureDestroyed(paramSurfaceTexture);
    paramSurfaceTexture = this.a;
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
    paramSurfaceTexture = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSurfaceTextureSizeChanged costTime:");
    localStringBuilder.append(System.currentTimeMillis() - l);
    QLog.i(paramSurfaceTexture, 1, localStringBuilder.toString());
  }
  
  public boolean onTouchEvent(@NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "event");
    boolean bool = this.c.a(paramMotionEvent);
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onTouchEvent, event:");
    localStringBuilder.append(paramMotionEvent.getAction());
    localStringBuilder.append(", ret: ");
    localStringBuilder.append(bool);
    QLog.d(str, 1, localStringBuilder.toString());
    return bool;
  }
  
  public void pause()
  {
    QLog.i(this.a, 1, "pause");
  }
  
  public void resume()
  {
    QLog.i(this.a, 1, "resume");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.CECMShowView
 * JD-Core Version:    0.7.0.1
 */