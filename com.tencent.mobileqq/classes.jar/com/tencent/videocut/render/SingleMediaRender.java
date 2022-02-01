package com.tencent.videocut.render;

import com.tencent.tavcut.TavCut;
import com.tencent.tavcut.creator.IComponentCreator;
import com.tencent.tavcut.creator.IEntityCreator;
import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import com.tencent.tavcut.rendermodel.entity.Entity;
import com.tencent.tavcut.session.ICutSession;
import com.tencent.videocut.model.BackgroundModel;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.PhotoClipInfo;
import com.tencent.videocut.model.Rect;
import com.tencent.videocut.model.SizeF;
import com.tencent.videocut.model.Transform;
import com.tencent.videocut.render.extension.MediaClipExtensionKt;
import com.tencent.videocut.render.extension.TransformExtKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/render/SingleMediaRender;", "Lcom/tencent/videocut/render/AbsListRender;", "Lcom/tencent/videocut/model/MediaClip;", "Lcom/tencent/videocut/render/SingleMediaRender$RenderData;", "tavCutSession", "Lcom/tencent/tavcut/session/ICutSession;", "(Lcom/tencent/tavcut/session/ICutSession;)V", "mediaClipList", "", "renderSizeF", "Lcom/tencent/videocut/model/SizeF;", "addEntity", "", "data", "detectMoves", "", "getItemIdentity", "", "model", "isContentTheSame", "newModel", "oldModel", "prepareRenderData", "removeEntity", "", "entityId", "selector", "Lcom/tencent/videocut/model/MediaModel;", "updateEntity", "originalEntityId", "oldData", "newData", "RenderData", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class SingleMediaRender
  extends AbsListRender<MediaClip, SingleMediaRender.RenderData>
{
  private List<MediaClip> a;
  private SizeF b;
  private final ICutSession c;
  
  public SingleMediaRender(@NotNull ICutSession paramICutSession)
  {
    this.c = paramICutSession;
    this.a = CollectionsKt.emptyList();
  }
  
  public int a(@NotNull SingleMediaRender.RenderData paramRenderData)
  {
    Intrinsics.checkParameterIsNotNull(paramRenderData, "data");
    return this.c.b(paramRenderData.a(), paramRenderData.b()).getId();
  }
  
  @NotNull
  public SingleMediaRender.RenderData a(@NotNull MediaClip paramMediaClip)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaClip, "model");
    Object localObject1 = paramMediaClip.transform;
    if (localObject1 == null) {
      localObject1 = TransformFuncKt.a();
    }
    SizeF localSizeF = MediaClipExtensionKt.b(paramMediaClip);
    Object localObject2 = this.a.iterator();
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      if (Intrinsics.areEqual(MediaClipExtensionKt.a((MediaClip)((Iterator)localObject2).next()), MediaClipExtensionKt.a(paramMediaClip))) {
        break label89;
      }
      i += 1;
    }
    i = -1;
    label89:
    localObject2 = paramMediaClip.photoClip;
    if (localObject2 != null) {
      localObject2 = ((PhotoClipInfo)localObject2).picClipRect;
    } else {
      localObject2 = null;
    }
    if ((Intrinsics.areEqual(localObject2, new Rect(0, 0, 0, 0, null, 31, null)) ^ true))
    {
      paramMediaClip = paramMediaClip.photoClip;
      if (paramMediaClip != null)
      {
        paramMediaClip = paramMediaClip.picClipRect;
        if (paramMediaClip != null)
        {
          int j = paramMediaClip.right;
          int k = paramMediaClip.left;
          int m = paramMediaClip.bottom;
          int n = paramMediaClip.top;
          paramMediaClip = new SizeF(j - k, m - n, null, 4, null);
          break label207;
        }
      }
    }
    paramMediaClip = localSizeF;
    label207:
    localObject2 = TavCut.a.e().a(i);
    paramMediaClip = TransformExtKt.b((Transform)localObject1, this.b, paramMediaClip);
    localObject1 = TavCut.a.e().a("singleMedia");
    paramMediaClip = CollectionsKt.arrayListOf(new IdentifyComponent[] { new IdentifyComponent(localObject2), new IdentifyComponent(paramMediaClip), new IdentifyComponent(localObject1) });
    return new SingleMediaRender.RenderData(TavCut.a.d().a("singleMedia", (List)paramMediaClip), i);
  }
  
  @NotNull
  public List<MediaClip> a(@NotNull MediaModel paramMediaModel)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaModel, "model");
    Object localObject = paramMediaModel.backgroundModel;
    if (localObject != null) {
      localObject = ((BackgroundModel)localObject).renderSize;
    } else {
      localObject = null;
    }
    this.b = ((SizeF)localObject);
    paramMediaModel = paramMediaModel.videos;
    this.a = paramMediaModel;
    return paramMediaModel;
  }
  
  public void a(int paramInt)
  {
    this.c.a(paramInt);
  }
  
  public void a(int paramInt, @Nullable SingleMediaRender.RenderData paramRenderData1, @NotNull SingleMediaRender.RenderData paramRenderData2)
  {
    Intrinsics.checkParameterIsNotNull(paramRenderData2, "newData");
    paramRenderData1 = ((Iterable)paramRenderData2.a().getComponents()).iterator();
    while (paramRenderData1.hasNext())
    {
      paramRenderData2 = (IdentifyComponent)paramRenderData1.next();
      this.c.b(paramInt, paramRenderData2);
    }
  }
  
  public boolean a(@NotNull MediaClip paramMediaClip1, @NotNull MediaClip paramMediaClip2)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaClip1, "newModel");
    Intrinsics.checkParameterIsNotNull(paramMediaClip2, "oldModel");
    return (Intrinsics.areEqual(paramMediaClip1.transform, paramMediaClip2.transform)) && (Intrinsics.areEqual(MediaClipExtensionKt.b(paramMediaClip1), MediaClipExtensionKt.b(paramMediaClip2)));
  }
  
  @NotNull
  public String b(@NotNull MediaClip paramMediaClip)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaClip, "model");
    return MediaClipExtensionKt.a(paramMediaClip);
  }
  
  public boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.render.SingleMediaRender
 * JD-Core Version:    0.7.0.1
 */