package com.tencent.videocut.render;

import android.util.SparseArray;
import com.tencent.tavcut.composition.model.component.InputSource;
import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import com.tencent.tavcut.rendermodel.entity.Entity;
import com.tencent.tavcut.session.ICutSession;
import com.tencent.videocut.model.BackgroundModel;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.PipModel;
import com.tencent.videocut.model.SizeF;
import com.tencent.videocut.render.extension.PipModelExtKt;
import com.tencent.videocut.render.extension.PipRenderTargetData;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/render/PipRenderTargetRender;", "Lcom/tencent/videocut/render/AbsListRender;", "Lcom/tencent/videocut/model/PipModel;", "Lcom/tencent/videocut/render/extension/PipRenderTargetData;", "tavCutSession", "Lcom/tencent/tavcut/session/ICutSession;", "(Lcom/tencent/tavcut/session/ICutSession;)V", "renderSize", "Lcom/tencent/videocut/model/SizeF;", "rtIds", "Landroid/util/SparseArray;", "", "addEntity", "data", "getItemIdentity", "", "model", "isContentTheSame", "", "newModel", "oldModel", "prepareRenderData", "removeEntity", "", "entityId", "selector", "", "Lcom/tencent/videocut/model/MediaModel;", "updateEntity", "originalEntityId", "oldData", "newData", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class PipRenderTargetRender
  extends AbsListRender<PipModel, PipRenderTargetData>
{
  private final SparseArray<Integer> a;
  private SizeF b;
  private final ICutSession c;
  
  public PipRenderTargetRender(@NotNull ICutSession paramICutSession)
  {
    this.c = paramICutSession;
    this.a = new SparseArray();
  }
  
  public int a(@NotNull PipRenderTargetData paramPipRenderTargetData)
  {
    Intrinsics.checkParameterIsNotNull(paramPipRenderTargetData, "data");
    Object localObject = ((Iterable)paramPipRenderTargetData.c()).iterator();
    while (((Iterator)localObject).hasNext())
    {
      InputSource localInputSource = (InputSource)((Iterator)localObject).next();
      this.c.a(localInputSource);
    }
    localObject = this.c.d(paramPipRenderTargetData.a(), 0);
    paramPipRenderTargetData = this.c.a(((Entity)localObject).getId(), paramPipRenderTargetData.b());
    this.a.put(paramPipRenderTargetData.getId(), Integer.valueOf(((Entity)localObject).getId()));
    return paramPipRenderTargetData.getId();
  }
  
  @NotNull
  public PipRenderTargetData a(@NotNull PipModel paramPipModel)
  {
    Intrinsics.checkParameterIsNotNull(paramPipModel, "model");
    return PipModelExtKt.a(paramPipModel, this.b);
  }
  
  @NotNull
  public List<PipModel> a(@NotNull MediaModel paramMediaModel)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaModel, "model");
    Object localObject = paramMediaModel.backgroundModel;
    if (localObject != null) {
      localObject = ((BackgroundModel)localObject).renderSize;
    } else {
      localObject = null;
    }
    this.b = ((SizeF)localObject);
    return CollectionsKt.toList((Iterable)paramMediaModel.pips.values());
  }
  
  public void a(int paramInt)
  {
    Object localObject = (Integer)this.a.get(paramInt);
    if (localObject != null)
    {
      int i = ((Number)localObject).intValue();
      this.c.a(i);
      if (localObject != null) {
        return;
      }
    }
    this.c.a(paramInt);
    localObject = Unit.INSTANCE;
  }
  
  public void a(int paramInt, @Nullable PipRenderTargetData paramPipRenderTargetData1, @NotNull PipRenderTargetData paramPipRenderTargetData2)
  {
    Intrinsics.checkParameterIsNotNull(paramPipRenderTargetData2, "newData");
    Iterator localIterator = ((Iterable)paramPipRenderTargetData2.c()).iterator();
    while (localIterator.hasNext())
    {
      InputSource localInputSource = (InputSource)localIterator.next();
      ICutSession localICutSession = this.c;
      paramPipRenderTargetData1 = localInputSource.key;
      if (paramPipRenderTargetData1 == null) {
        paramPipRenderTargetData1 = "";
      }
      if ((Intrinsics.areEqual(localInputSource, localICutSession.a(paramPipRenderTargetData1)) ^ true)) {
        this.c.a(localInputSource);
      }
    }
    paramPipRenderTargetData1 = ((Iterable)paramPipRenderTargetData2.b().getComponents()).iterator();
    while (paramPipRenderTargetData1.hasNext())
    {
      paramPipRenderTargetData2 = (IdentifyComponent)paramPipRenderTargetData1.next();
      this.c.b(paramInt, paramPipRenderTargetData2);
    }
  }
  
  public boolean a(@NotNull PipModel paramPipModel1, @NotNull PipModel paramPipModel2)
  {
    Intrinsics.checkParameterIsNotNull(paramPipModel1, "newModel");
    Intrinsics.checkParameterIsNotNull(paramPipModel2, "oldModel");
    Object localObject1 = paramPipModel1.mediaClip;
    Object localObject3 = null;
    if (localObject1 != null) {
      localObject1 = ((MediaClip)localObject1).resource;
    } else {
      localObject1 = null;
    }
    Object localObject2 = paramPipModel2.mediaClip;
    if (localObject2 != null) {
      localObject2 = ((MediaClip)localObject2).resource;
    } else {
      localObject2 = null;
    }
    if (Intrinsics.areEqual(localObject1, localObject2))
    {
      localObject1 = paramPipModel1.mediaClip;
      if (localObject1 != null) {
        localObject1 = ((MediaClip)localObject1).transform;
      } else {
        localObject1 = null;
      }
      MediaClip localMediaClip = paramPipModel2.mediaClip;
      localObject2 = localObject3;
      if (localMediaClip != null) {
        localObject2 = localMediaClip.transform;
      }
      if ((Intrinsics.areEqual(localObject1, localObject2)) && (paramPipModel1.startOffset == paramPipModel2.startOffset)) {
        return true;
      }
    }
    return false;
  }
  
  @NotNull
  public String b(@NotNull PipModel paramPipModel)
  {
    Intrinsics.checkParameterIsNotNull(paramPipModel, "model");
    return PipModelExtKt.a(paramPipModel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.render.PipRenderTargetRender
 * JD-Core Version:    0.7.0.1
 */