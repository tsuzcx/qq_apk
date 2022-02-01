package com.tencent.videocut.render;

import com.tencent.tavcut.TavCut;
import com.tencent.tavcut.model.ClipSource;
import com.tencent.tavcut.operator.IClipSourceOperator;
import com.tencent.tavcut.rendermodel.RenderModel;
import com.tencent.tavcut.session.ICutSession;
import com.tencent.videocut.model.AudioModel;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.TemplateModel;
import com.tencent.videocut.model.TemplateModel.AiInfo;
import com.tencent.videocut.render.extension.AudioExtensionsKt;
import com.tencent.videocut.render.extension.MediaClipExtensionKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/render/TemplateRenderLayer;", "Lcom/tencent/videocut/render/AbsModelRender;", "Lcom/tencent/videocut/model/MediaModel;", "Lcom/tencent/videocut/render/TemplateRenderLayer$TemplateRenderData;", "tavCutSession", "Lcom/tencent/tavcut/session/ICutSession;", "(Lcom/tencent/tavcut/session/ICutSession;)V", "getTavCutSession", "()Lcom/tencent/tavcut/session/ICutSession;", "addEntity", "", "data", "getModelIdentity", "", "model", "prepareRenderData", "removeEntity", "", "entityId", "selector", "updateEntity", "originalEntityId", "oldData", "newData", "TemplateRenderData", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class TemplateRenderLayer
  extends AbsModelRender<MediaModel, TemplateRenderLayer.TemplateRenderData>
{
  @NotNull
  private final ICutSession a;
  
  public int a(@Nullable TemplateRenderLayer.TemplateRenderData paramTemplateRenderData)
  {
    a(0, null, paramTemplateRenderData);
    return -1;
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, @Nullable TemplateRenderLayer.TemplateRenderData paramTemplateRenderData1, @Nullable TemplateRenderLayer.TemplateRenderData paramTemplateRenderData2)
  {
    if (paramTemplateRenderData2 != null)
    {
      paramTemplateRenderData1 = paramTemplateRenderData2.a();
      if (paramTemplateRenderData1 != null)
      {
        this.a.a(RenderModel.copy$default(paramTemplateRenderData1, null, null, null, null, CollectionsKt.emptyList(), false, 0, null, null, null, 0L, 0, null, 8175, null));
        this.a.e().a(paramTemplateRenderData1.getClipsAssets());
      }
    }
    paramTemplateRenderData1 = this;
    if (paramTemplateRenderData2 != null)
    {
      paramTemplateRenderData2 = paramTemplateRenderData2.b();
      if (paramTemplateRenderData2 != null)
      {
        paramTemplateRenderData2 = ((Iterable)paramTemplateRenderData2).iterator();
        while (paramTemplateRenderData2.hasNext())
        {
          RenderData localRenderData = (RenderData)paramTemplateRenderData2.next();
          paramTemplateRenderData1.a.a(localRenderData.b());
          paramTemplateRenderData1.a.a(localRenderData.a());
        }
      }
    }
  }
  
  @NotNull
  public MediaModel c(@NotNull MediaModel paramMediaModel)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaModel, "model");
    return paramMediaModel;
  }
  
  @Nullable
  public String d(@Nullable MediaModel paramMediaModel)
  {
    if (paramMediaModel != null) {
      return paramMediaModel.id;
    }
    return null;
  }
  
  @NotNull
  public TemplateRenderLayer.TemplateRenderData e(@NotNull MediaModel paramMediaModel)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaModel, "model");
    RenderModel localRenderModel = TavCut.a.c("");
    Object localObject1 = null;
    if (localRenderModel == null) {
      localRenderModel = TavCut.a.c(null);
    }
    Object localObject3;
    if (localRenderModel != null)
    {
      localObject3 = (Iterable)paramMediaModel.videos;
      localObject2 = (Collection)new ArrayList();
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        ClipSource localClipSource = MediaClipExtensionKt.c((MediaClip)((Iterator)localObject3).next());
        if (localClipSource != null) {
          ((Collection)localObject2).add(localClipSource);
        }
      }
      localRenderModel = RenderModel.copy$default(localRenderModel, null, null, null, null, (List)localObject2, false, 0, null, null, null, 0L, 0, null, 8175, null);
    }
    else
    {
      localRenderModel = null;
    }
    Object localObject2 = paramMediaModel.templateModel;
    if (localObject2 != null)
    {
      localObject2 = ((Iterable)((TemplateModel)localObject2).aiInfo).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (TemplateModel.AiInfo)((Iterator)localObject2).next();
        TavCut.a.a(((TemplateModel.AiInfo)localObject3).agent, ((TemplateModel.AiInfo)localObject3).path);
      }
    }
    localRenderModel = TavCut.a.b(localRenderModel);
    localObject2 = paramMediaModel.templateModel;
    paramMediaModel = (MediaModel)localObject1;
    if (localObject2 != null)
    {
      localObject2 = ((TemplateModel)localObject2).audioModel;
      paramMediaModel = (MediaModel)localObject1;
      if (localObject2 != null)
      {
        localObject1 = (Iterable)localObject2;
        paramMediaModel = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject1, 10));
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          paramMediaModel.add(AudioExtensionsKt.a((AudioModel)((Iterator)localObject1).next()));
        }
        paramMediaModel = (List)paramMediaModel;
      }
    }
    if (paramMediaModel == null) {
      paramMediaModel = CollectionsKt.emptyList();
    }
    return new TemplateRenderLayer.TemplateRenderData(localRenderModel, paramMediaModel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.render.TemplateRenderLayer
 * JD-Core Version:    0.7.0.1
 */