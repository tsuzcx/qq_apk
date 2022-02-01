package com.tencent.mobileqq.cmshow.engine.render;

import com.tencent.mobileqq.cmshow.engine.model.RenderConfig;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/engine/render/IRenderService;", "", "getRecordFrameListener", "Lcom/tencent/mobileqq/cmshow/engine/render/IRecordFrameListener;", "getRenderView", "Lcom/tencent/mobileqq/cmshow/engine/render/ICMShowView;", "setConfig", "", "renderConfig", "Lcom/tencent/mobileqq/cmshow/engine/model/RenderConfig;", "setRecordFrameListener", "listener", "setRecording", "isRecording", "", "setSurfaceListener", "Lcom/tencent/mobileqq/cmshow/engine/render/ISurfaceStateListener;", "setTouchListener", "Lcom/tencent/mobileqq/cmshow/engine/render/ITouchListener;", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IRenderService
{
  @NotNull
  public abstract ICMShowView a();
  
  public abstract void a(@NotNull RenderConfig paramRenderConfig);
  
  public abstract void a(@Nullable IRecordFrameListener paramIRecordFrameListener);
  
  public abstract void a(@Nullable ISurfaceStateListener paramISurfaceStateListener);
  
  public abstract void a(@Nullable ITouchListener paramITouchListener);
  
  public abstract void a(boolean paramBoolean);
  
  @Nullable
  public abstract IRecordFrameListener b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.render.IRenderService
 * JD-Core Version:    0.7.0.1
 */