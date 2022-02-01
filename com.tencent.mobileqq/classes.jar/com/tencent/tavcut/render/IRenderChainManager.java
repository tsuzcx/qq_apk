package com.tencent.tavcut.render;

import com.tencent.tavcut.composition.model.component.Timeline;
import com.tencent.tavcut.rendermodel.RenderModel;
import com.tencent.tavcut.rendermodel.VoiceEnum;
import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/render/IRenderChainManager;", "", "addEntity", "", "parentId", "", "entity", "Lcom/tencent/tavcut/rendermodel/entity/Entity;", "getEditableTextByEntityId", "", "Lcom/tencent/tavcut/model/TextPlaceInfo;", "entityId", "", "getEditableTextUnderPoint", "x", "", "y", "getEntitiesUnderPoint", "Ljava/util/ArrayList;", "registerFont", "fontFamily", "fontPath", "release", "reloadAsset", "templateDir", "renderModel", "Lcom/tencent/tavcut/rendermodel/RenderModel;", "updatedTimeLines", "Lkotlin/Function2;", "Lcom/tencent/tavcut/composition/model/component/Timeline;", "", "Lkotlin/ParameterName;", "name", "durationChanged", "removeEntity", "runOnAfterApply", "runnable", "Ljava/lang/Runnable;", "runOnBeforeApply", "setRenderTimeRange", "renderTimeRange", "Lcom/tencent/tav/coremedia/CMTimeRange;", "setVoiceChangerConfig", "config", "Lcom/tencent/tavcut/rendermodel/VoiceEnum;", "updateComponent", "component", "Lcom/tencent/tavcut/rendermodel/component/IdentifyComponent;", "rebuild", "Lkotlin/Function1;", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public abstract interface IRenderChainManager
{
  public abstract void a();
  
  public abstract void a(int paramInt, @NotNull IdentifyComponent paramIdentifyComponent, @NotNull Function1<? super Boolean, Unit> paramFunction1);
  
  public abstract void a(@NotNull Runnable paramRunnable);
  
  public abstract void a(@NotNull String paramString, @NotNull RenderModel paramRenderModel, @NotNull Function2<? super List<Timeline>, ? super Boolean, Unit> paramFunction2);
  
  public abstract void a(@NotNull String paramString1, @NotNull String paramString2);
  
  public abstract void a(@Nullable List<? extends VoiceEnum> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.IRenderChainManager
 * JD-Core Version:    0.7.0.1
 */