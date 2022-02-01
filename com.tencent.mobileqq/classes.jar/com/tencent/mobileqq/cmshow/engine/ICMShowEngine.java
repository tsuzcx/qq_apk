package com.tencent.mobileqq.cmshow.engine;

import com.tencent.mobileqq.cmshow.engine.model.BusinessConfig;
import com.tencent.mobileqq.cmshow.engine.render.IRenderService;
import com.tencent.mobileqq.cmshow.engine.resource.IResourceService;
import com.tencent.mobileqq.cmshow.engine.script.IScriptService;
import com.tencent.mobileqq.cmshow.engine.statistic.IStatisticService;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/engine/ICMShowEngine;", "", "businessConfig", "Lcom/tencent/mobileqq/cmshow/engine/model/BusinessConfig;", "getBusinessConfig", "()Lcom/tencent/mobileqq/cmshow/engine/model/BusinessConfig;", "renderService", "Lcom/tencent/mobileqq/cmshow/engine/render/IRenderService;", "getRenderService", "()Lcom/tencent/mobileqq/cmshow/engine/render/IRenderService;", "resourceService", "Lcom/tencent/mobileqq/cmshow/engine/resource/IResourceService;", "getResourceService", "()Lcom/tencent/mobileqq/cmshow/engine/resource/IResourceService;", "scriptService", "Lcom/tencent/mobileqq/cmshow/engine/script/IScriptService;", "getScriptService", "()Lcom/tencent/mobileqq/cmshow/engine/script/IScriptService;", "state", "Lcom/tencent/mobileqq/cmshow/engine/EngineState;", "getState", "()Lcom/tencent/mobileqq/cmshow/engine/EngineState;", "statisticService", "Lcom/tencent/mobileqq/cmshow/engine/statistic/IStatisticService;", "getStatisticService", "()Lcom/tencent/mobileqq/cmshow/engine/statistic/IStatisticService;", "destroy", "", "start", "stop", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public abstract interface ICMShowEngine
{
  @NotNull
  public abstract EngineState a();
  
  @NotNull
  public abstract IRenderService c();
  
  @NotNull
  public abstract IScriptService e();
  
  @NotNull
  public abstract IResourceService g();
  
  @NotNull
  public abstract IStatisticService i();
  
  @NotNull
  public abstract BusinessConfig j();
  
  public abstract void k();
  
  public abstract void l();
  
  public abstract void m();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.ICMShowEngine
 * JD-Core Version:    0.7.0.1
 */