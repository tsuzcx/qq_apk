package com.tencent.mobileqq.cmshow.crossengine;

import android.content.Context;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import com.tencent.crossengine.CEApplication;
import com.tencent.crossengine.offscreen.CEOffscreenGLSurfaceView;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/crossengine/CECMShowOffscreenView;", "Lcom/tencent/crossengine/offscreen/CEOffscreenGLSurfaceView;", "Lcom/tencent/mobileqq/cmshow/engine/render/ICMShowView;", "context", "Landroid/content/Context;", "ceApplication", "Lcom/tencent/crossengine/CEApplication;", "worldName", "", "renderConfig", "Lcom/tencent/mobileqq/cmshow/engine/model/RenderConfig;", "viewListener", "Lcom/tencent/mobileqq/apollo/listener/OnApolloViewListener;", "(Landroid/content/Context;Lcom/tencent/crossengine/CEApplication;Ljava/lang/String;Lcom/tencent/mobileqq/cmshow/engine/model/RenderConfig;Lcom/tencent/mobileqq/apollo/listener/OnApolloViewListener;)V", "TAG", "actionTouchManager", "Lcom/tencent/mobileqq/apollo/touch/CMActionTouchManager;", "hasCallbackSurfaceReady", "", "getRenderConfig", "()Lcom/tencent/mobileqq/cmshow/engine/model/RenderConfig;", "getViewListener", "()Lcom/tencent/mobileqq/apollo/listener/OnApolloViewListener;", "getRenderHeight", "", "getRenderWidth", "getTouchManager", "Lcom/tencent/mobileqq/apollo/touch/ICMTouchManager;", "getView", "Landroid/view/View;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "pause", "", "resume", "surfaceChanged", "holder", "Landroid/view/SurfaceHolder;", "format", "width", "height", "surfaceCreated", "surfaceDestroyed", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CECMShowOffscreenView
  extends CEOffscreenGLSurfaceView
  implements ICMShowView
{
  @NotNull
  private final OnApolloViewListener jdField_a_of_type_ComTencentMobileqqApolloListenerOnApolloViewListener;
  private CMActionTouchManager jdField_a_of_type_ComTencentMobileqqApolloTouchCMActionTouchManager;
  @Nullable
  private final RenderConfig jdField_a_of_type_ComTencentMobileqqCmshowEngineModelRenderConfig;
  private final String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public CECMShowOffscreenView(@NotNull Context paramContext, @NotNull CEApplication paramCEApplication, @NotNull String paramString, @Nullable RenderConfig paramRenderConfig, @NotNull OnApolloViewListener paramOnApolloViewListener)
  {
    super(paramContext, paramCEApplication, paramString);
    this.jdField_a_of_type_ComTencentMobileqqCmshowEngineModelRenderConfig = paramRenderConfig;
    this.jdField_a_of_type_ComTencentMobileqqApolloListenerOnApolloViewListener = paramOnApolloViewListener;
    this.jdField_a_of_type_JavaLangString = "[cmshow][CECMShowOffscreenEngine][CERenderService][CECMShowOffscreenView]";
    paramContext = this.jdField_a_of_type_ComTencentMobileqqCmshowEngineModelRenderConfig;
    boolean bool;
    if (paramContext != null) {
      bool = paramContext.e;
    } else {
      bool = true;
    }
    setZOrderOnTop(bool);
    getHolder().setFormat(-3);
    this.jdField_a_of_type_ComTencentMobileqqApolloTouchCMActionTouchManager = new CMActionTouchManager((View)this, this.jdField_a_of_type_ComTencentMobileqqApolloListenerOnApolloViewListener);
  }
  
  public int getInitHeight()
  {
    return ICMShowView.DefaultImpls.a(this);
  }
  
  public int getRenderHeight()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqCmshowEngineModelRenderConfig;
    if (localObject != null) {
      localObject = ((RenderConfig)localObject).jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderRenderMode;
    } else {
      localObject = null;
    }
    if (localObject == RenderMode.OFF_SCREEN)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqCmshowEngineModelRenderConfig.jdField_a_of_type_AndroidUtilPair.second;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "renderConfig.offScreenSize.second");
      return ((Number)localObject).intValue();
    }
    return getView().getHeight();
  }
  
  public int getRenderWidth()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqCmshowEngineModelRenderConfig;
    if (localObject != null) {
      localObject = ((RenderConfig)localObject).jdField_a_of_type_ComTencentMobileqqCmshowEngineRenderRenderMode;
    } else {
      localObject = null;
    }
    if (localObject == RenderMode.OFF_SCREEN)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqCmshowEngineModelRenderConfig.jdField_a_of_type_AndroidUtilPair.first;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "renderConfig.offScreenSize.first");
      return ((Number)localObject).intValue();
    }
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
    QLog.i(str, 1, localStringBuilder.toString());
    return bool;
  }
  
  public void pause()
  {
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "pause");
    setVisibility(8);
    super.onPause();
  }
  
  public void resume()
  {
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "resume");
    setVisibility(0);
    super.onResume();
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
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.CECMShowOffscreenView
 * JD-Core Version:    0.7.0.1
 */