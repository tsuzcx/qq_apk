package com.tencent.videocut.render;

import com.tencent.tavcut.session.ICutSession;
import com.tencent.videocut.model.MediaModel;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/render/ComposeRenderLayer;", "", "tavCutSession", "Lcom/tencent/tavcut/session/ICutSession;", "current", "Lcom/tencent/videocut/model/MediaModel;", "renderScene", "Lcom/tencent/videocut/render/ComposeRenderLayer$RenderScene;", "(Lcom/tencent/tavcut/session/ICutSession;Lcom/tencent/videocut/model/MediaModel;Lcom/tencent/videocut/render/ComposeRenderLayer$RenderScene;)V", "needUpdateVideo", "", "getNeedUpdateVideo", "()Z", "setNeedUpdateVideo", "(Z)V", "renderLayers", "", "Lcom/tencent/videocut/render/IRender;", "getEditableTextByModelId", "", "Lcom/tencent/tavcut/model/TextPlaceInfo;", "modelId", "", "getTouchedModel", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "x", "", "y", "setCurrentModel", "", "newModel", "update", "RenderScene", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class ComposeRenderLayer
{
  private boolean a;
  private final List<IRender> b;
  private final ICutSession c;
  private MediaModel d;
  
  public ComposeRenderLayer(@NotNull ICutSession paramICutSession, @NotNull MediaModel paramMediaModel, @NotNull ComposeRenderLayer.RenderScene paramRenderScene)
  {
    this.c = paramICutSession;
    this.d = paramMediaModel;
    this.a = true;
    if (paramRenderScene == ComposeRenderLayer.RenderScene.VIDEO)
    {
      paramICutSession = new PipRenderTargetRender(this.c);
      paramICutSession = CollectionsKt.mutableListOf(new IRender[] { (IRender)new BackgroundModelRender(this.c), (IRender)new MediaClipProcessor(this.c), (IRender)new AudioModelRender(this.c), (IRender)new StickerRenderHelper(this.c), (IRender)new LutFilterModelRender(this.c), (IRender)new ColorFilterModelRender(this.c), (IRender)new VideoTrackLutFilterModelRender(this.c), (IRender)new VideoTrackColorFilterModelRender(this.c), (IRender)new SingleMediaRender(this.c), (IRender)new TransitionRender(this.c), (IRender)paramICutSession, (IRender)new PipRender(this.c), (IRender)new PipLutFilterModelRender(paramICutSession, this.c), (IRender)new PipColorFilterModelRender(paramICutSession, this.c) });
    }
    else
    {
      paramICutSession = CollectionsKt.mutableListOf(new IRender[] { (IRender)new BackgroundModelRender(this.c), (IRender)new MediaClipProcessor(this.c), (IRender)new SingleMediaRender(this.c), (IRender)new StickerRenderHelper(this.c), (IRender)new LutFilterModelRender(this.c), (IRender)new ColorFilterModelRender(this.c) });
    }
    this.b = paramICutSession;
  }
  
  public final void a(@NotNull MediaModel paramMediaModel)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaModel, "newModel");
    if (Intrinsics.areEqual(paramMediaModel, this.d)) {
      return;
    }
    Iterator localIterator = ((Iterable)this.b).iterator();
    while (localIterator.hasNext())
    {
      IRender localIRender = (IRender)localIterator.next();
      if ((!(localIRender instanceof MediaClipProcessor)) || (this.a)) {
        localIRender.b(paramMediaModel);
      }
    }
    this.d = paramMediaModel;
    this.c.h();
  }
  
  public final void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public final void b(@NotNull MediaModel paramMediaModel)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaModel, "newModel");
    if (Intrinsics.areEqual(paramMediaModel, this.d)) {
      return;
    }
    Iterator localIterator = ((Iterable)this.b).iterator();
    while (localIterator.hasNext()) {
      ((IRender)localIterator.next()).b(paramMediaModel);
    }
    this.d = paramMediaModel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.render.ComposeRenderLayer
 * JD-Core Version:    0.7.0.1
 */