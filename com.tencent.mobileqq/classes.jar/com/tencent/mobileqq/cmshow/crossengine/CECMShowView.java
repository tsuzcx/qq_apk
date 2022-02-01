package com.tencent.mobileqq.cmshow.crossengine;

import android.content.Context;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import com.tencent.crossengine.CESurfaceView;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/crossengine/CECMShowView;", "Lcom/tencent/crossengine/CESurfaceView;", "Lcom/tencent/mobileqq/cmshow/engine/render/ICMShowView;", "context", "Landroid/content/Context;", "renderContext", "Lcom/tencent/crossengine/RenderContext;", "touchEventManager", "Lcom/tencent/crossengine/TouchProcessor;", "viewListener", "Lcom/tencent/mobileqq/apollo/listener/OnApolloViewListener;", "(Landroid/content/Context;Lcom/tencent/crossengine/RenderContext;Lcom/tencent/crossengine/TouchProcessor;Lcom/tencent/mobileqq/apollo/listener/OnApolloViewListener;)V", "TAG", "", "actionTouchManager", "Lcom/tencent/mobileqq/apollo/touch/CMActionTouchManager;", "hasCallbackSurfaceReady", "", "getRenderContext", "()Lcom/tencent/crossengine/RenderContext;", "getTouchEventManager", "()Lcom/tencent/crossengine/TouchProcessor;", "getViewListener", "()Lcom/tencent/mobileqq/apollo/listener/OnApolloViewListener;", "getRenderHeight", "", "getRenderWidth", "getTouchManager", "Lcom/tencent/mobileqq/apollo/touch/ICMTouchManager;", "getView", "Landroid/view/View;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "pause", "", "resume", "surfaceChanged", "holder", "Landroid/view/SurfaceHolder;", "format", "width", "height", "surfaceCreated", "surfaceDestroyed", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CECMShowView
  extends CESurfaceView
  implements ICMShowView
{
  @NotNull
  private final RenderContext jdField_a_of_type_ComTencentCrossengineRenderContext;
  @NotNull
  private final TouchProcessor jdField_a_of_type_ComTencentCrossengineTouchProcessor;
  @NotNull
  private final OnApolloViewListener jdField_a_of_type_ComTencentMobileqqApolloListenerOnApolloViewListener;
  private CMActionTouchManager jdField_a_of_type_ComTencentMobileqqApolloTouchCMActionTouchManager;
  private final String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public CECMShowView(@NotNull Context paramContext, @NotNull RenderContext paramRenderContext, @NotNull TouchProcessor paramTouchProcessor, @NotNull OnApolloViewListener paramOnApolloViewListener)
  {
    super(paramContext, paramRenderContext, paramTouchProcessor);
    this.jdField_a_of_type_ComTencentCrossengineRenderContext = paramRenderContext;
    this.jdField_a_of_type_ComTencentCrossengineTouchProcessor = paramTouchProcessor;
    this.jdField_a_of_type_ComTencentMobileqqApolloListenerOnApolloViewListener = paramOnApolloViewListener;
    this.jdField_a_of_type_JavaLangString = "[cmshow][CECMShowOffscreenEngine][CERenderService][CECMShowView]";
    setZOrderOnTop(true);
    getHolder().setFormat(-3);
    this.jdField_a_of_type_ComTencentMobileqqApolloTouchCMActionTouchManager = new CMActionTouchManager((View)this, this.jdField_a_of_type_ComTencentMobileqqApolloListenerOnApolloViewListener);
  }
  
  public int getInitHeight()
  {
    return ICMShowView.DefaultImpls.a(this);
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
  public ICMTouchManager getTouchManager()
  {
    return (ICMTouchManager)this.jdField_a_of_type_ComTencentMobileqqApolloTouchCMActionTouchManager;
  }
  
  @NotNull
  public View getView()
  {
    return (View)this;
  }
  
  public boolean onTouchEvent(@NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "event");
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqApolloTouchCMActionTouchManager.a(paramMotionEvent);
    String str = this.jdField_a_of_type_JavaLangString;
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
    QLog.i(this.jdField_a_of_type_JavaLangString, 1, "pause");
  }
  
  public void resume()
  {
    QLog.i(this.jdField_a_of_type_JavaLangString, 1, "resume");
  }
  
  public void surfaceChanged(@Nullable SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    long l = System.currentTimeMillis();
    super.surfaceChanged(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqApolloListenerOnApolloViewListener.onSurfaceReady(paramInt2, paramInt3);
    }
    paramSurfaceHolder = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("surfaceChanged costTime:");
    localStringBuilder.append(System.currentTimeMillis() - l);
    QLog.i(paramSurfaceHolder, 1, localStringBuilder.toString());
  }
  
  public void surfaceCreated(@Nullable SurfaceHolder paramSurfaceHolder)
  {
    long l = System.currentTimeMillis();
    super.surfaceCreated(paramSurfaceHolder);
    paramSurfaceHolder = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("surfaceCreated costTime:");
    localStringBuilder.append(System.currentTimeMillis() - l);
    QLog.i(paramSurfaceHolder, 1, localStringBuilder.toString());
  }
  
  public void surfaceDestroyed(@Nullable SurfaceHolder paramSurfaceHolder)
  {
    long l = System.currentTimeMillis();
    super.surfaceDestroyed(paramSurfaceHolder);
    paramSurfaceHolder = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("surfaceDestroyed costTime:");
    localStringBuilder.append(System.currentTimeMillis() - l);
    QLog.i(paramSurfaceHolder, 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.CECMShowView
 * JD-Core Version:    0.7.0.1
 */