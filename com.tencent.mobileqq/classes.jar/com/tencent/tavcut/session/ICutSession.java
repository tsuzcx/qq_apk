package com.tencent.tavcut.session;

import com.tencent.tavcut.composition.model.component.InputSource;
import com.tencent.tavcut.composition.model.component.Size;
import com.tencent.tavcut.operator.IClipSourceOperator;
import com.tencent.tavcut.render.player.IPlayer;
import com.tencent.tavcut.rendermodel.RenderModel;
import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import com.tencent.tavcut.rendermodel.entity.Entity;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/session/ICutSession;", "", "accessInputSource", "Lcom/tencent/tavcut/composition/model/component/InputSource;", "sourceKey", "", "addBgm", "Lcom/tencent/tavcut/rendermodel/entity/Entity;", "entity", "addClipEffect", "index", "", "addEffect", "parentEntityId", "addInputSource", "", "inputSource", "addRenderTarget", "addSessionListener", "listener", "Lcom/tencent/tavcut/session/ISessionListener;", "bindPlayer", "player", "Lcom/tencent/tavcut/render/player/IPlayer;", "flush", "getClipSourceOperator", "Lcom/tencent/tavcut/operator/IClipSourceOperator;", "getEditableTextByEntityId", "", "Lcom/tencent/tavcut/model/TextPlaceInfo;", "entityId", "getEditableTextUnderPoint", "x", "", "y", "getEntitiesUnderPoint", "Ljava/util/ArrayList;", "getPlayer", "getRenderModel", "Lcom/tencent/tavcut/rendermodel/RenderModel;", "getTotalDurationUs", "", "queryEffectIndex", "", "entityIds", "registerFont", "fontFamily", "fontPath", "release", "removeEntity", "id", "removeInputSource", "removeSessionListener", "setRenderModel", "renderModel", "setTransition", "updateBackground", "backgroundFillMode", "backColor", "pagFilePath", "updateComponent", "identifyComponent", "Lcom/tencent/tavcut/rendermodel/component/IdentifyComponent;", "updateEffectIndex", "", "updateRenderSize", "renderSize", "Lcom/tencent/tavcut/composition/model/component/Size;", "fillScale", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public abstract interface ICutSession
{
  @Nullable
  public abstract InputSource a(@Nullable String paramString);
  
  @NotNull
  public abstract Entity a(int paramInt, @NotNull Entity paramEntity);
  
  @NotNull
  public abstract Entity a(@NotNull Entity paramEntity);
  
  @NotNull
  public abstract Entity a(@NotNull Entity paramEntity, int paramInt);
  
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt, @NotNull String paramString1, @Nullable String paramString2);
  
  public abstract void a(@NotNull InputSource paramInputSource);
  
  public abstract void a(@NotNull Size paramSize, float paramFloat);
  
  public abstract void a(@NotNull IPlayer paramIPlayer);
  
  public abstract void a(@NotNull RenderModel paramRenderModel);
  
  public abstract void a(@NotNull ISessionListener paramISessionListener);
  
  public abstract void a(@NotNull String paramString1, @NotNull String paramString2);
  
  @NotNull
  public abstract Entity b(@NotNull Entity paramEntity, int paramInt);
  
  public abstract void b(int paramInt, @NotNull IdentifyComponent paramIdentifyComponent);
  
  public abstract void b(@NotNull ISessionListener paramISessionListener);
  
  @NotNull
  public abstract Entity c(@NotNull Entity paramEntity, int paramInt);
  
  @Nullable
  public abstract RenderModel d();
  
  @NotNull
  public abstract Entity d(@NotNull Entity paramEntity, int paramInt);
  
  @NotNull
  public abstract IClipSourceOperator e();
  
  @Nullable
  public abstract IPlayer f();
  
  public abstract void g();
  
  public abstract void h();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.session.ICutSession
 * JD-Core Version:    0.7.0.1
 */