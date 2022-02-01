package com.tencent.videocut.render;

import com.tencent.tavcut.composition.model.component.InputSource;
import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import com.tencent.tavcut.rendermodel.entity.Entity;
import com.tencent.tavcut.session.ICutSession;
import com.tencent.videocut.model.AudioModel;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.render.extension.AudioExtensionsKt;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/render/AudioModelRender;", "Lcom/tencent/videocut/render/AbsListRender;", "Lcom/tencent/videocut/model/AudioModel;", "Lcom/tencent/videocut/render/RenderData;", "iCutSession", "Lcom/tencent/tavcut/session/ICutSession;", "(Lcom/tencent/tavcut/session/ICutSession;)V", "addEntity", "", "data", "getItemIdentity", "", "model", "prepareRenderData", "removeEntity", "", "entityId", "selector", "", "Lcom/tencent/videocut/model/MediaModel;", "updateEntity", "originalEntityId", "oldData", "newData", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class AudioModelRender
  extends AbsListRender<AudioModel, RenderData>
{
  private final ICutSession a;
  
  public AudioModelRender(@NotNull ICutSession paramICutSession)
  {
    this.a = paramICutSession;
  }
  
  public int a(@NotNull RenderData paramRenderData)
  {
    Intrinsics.checkParameterIsNotNull(paramRenderData, "data");
    this.a.a(paramRenderData.b());
    return this.a.a(paramRenderData.a()).getId();
  }
  
  @NotNull
  public RenderData a(@NotNull AudioModel paramAudioModel)
  {
    Intrinsics.checkParameterIsNotNull(paramAudioModel, "model");
    return AudioExtensionsKt.a(paramAudioModel);
  }
  
  @NotNull
  public List<AudioModel> a(@NotNull MediaModel paramMediaModel)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaModel, "model");
    return CollectionsKt.toList((Iterable)paramMediaModel.audios.values());
  }
  
  public void a(int paramInt)
  {
    this.a.a(paramInt);
  }
  
  public void a(int paramInt, @Nullable RenderData paramRenderData1, @NotNull RenderData paramRenderData2)
  {
    Intrinsics.checkParameterIsNotNull(paramRenderData2, "newData");
    ICutSession localICutSession = this.a;
    paramRenderData1 = paramRenderData2.b().key;
    if (paramRenderData1 == null) {
      paramRenderData1 = "";
    }
    if ((Intrinsics.areEqual(localICutSession.a(paramRenderData1), paramRenderData2.b()) ^ true)) {
      this.a.a(paramRenderData2.b());
    }
    paramRenderData1 = ((Iterable)paramRenderData2.a().getComponents()).iterator();
    while (paramRenderData1.hasNext())
    {
      paramRenderData2 = (IdentifyComponent)paramRenderData1.next();
      this.a.b(paramInt, paramRenderData2);
    }
  }
  
  @NotNull
  public String b(@NotNull AudioModel paramAudioModel)
  {
    Intrinsics.checkParameterIsNotNull(paramAudioModel, "model");
    return paramAudioModel.id;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.render.AudioModelRender
 * JD-Core Version:    0.7.0.1
 */