package com.tencent.videocut.render;

import com.tencent.tavcut.composition.model.component.InputSource;
import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import com.tencent.tavcut.rendermodel.entity.Entity;
import com.tencent.tavcut.session.ICutSession;
import com.tencent.tavcut.session.ICutSession.DefaultImpls;
import com.tencent.videocut.model.BackgroundModel;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.PipModel;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.model.SizeF;
import com.tencent.videocut.render.extension.PipModelExtKt;
import com.tencent.videocut.render.extension.PipRenderData;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/render/PipRender;", "Lcom/tencent/videocut/render/AbsListRender;", "Lcom/tencent/videocut/model/PipModel;", "Lcom/tencent/videocut/render/extension/PipRenderData;", "tavCutSession", "Lcom/tencent/tavcut/session/ICutSession;", "(Lcom/tencent/tavcut/session/ICutSession;)V", "pips", "", "", "renderSize", "Lcom/tencent/videocut/model/SizeF;", "addEntity", "", "data", "findTargetEntityId", "Lkotlin/Triple;", "", "getItemIdentity", "model", "isContentTheSame", "", "newModel", "oldModel", "prepareRenderData", "removeEntity", "", "entityId", "selector", "", "Lcom/tencent/videocut/model/MediaModel;", "updateEntity", "originalEntityId", "oldData", "newData", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class PipRender
  extends AbsListRender<PipModel, PipRenderData>
{
  private SizeF a;
  private Map<String, PipModel> b;
  private final ICutSession c;
  
  public PipRender(@NotNull ICutSession paramICutSession)
  {
    this.c = paramICutSession;
    this.b = MapsKt.emptyMap();
  }
  
  private final Triple<List<PipModel>, Integer, Integer> b(PipRenderData paramPipRenderData)
  {
    List localList = CollectionsKt.sortedWith((Iterable)this.b.values(), (Comparator)new PipRender.findTargetEntityId..inlined.sortedBy.1());
    Iterator localIterator = localList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      if (Intrinsics.areEqual(PipModelExtKt.a((PipModel)localIterator.next()), paramPipRenderData.c())) {
        break label81;
      }
      i += 1;
    }
    i = -1;
    label81:
    localList = CollectionsKt.toMutableList((Collection)localList);
    localList.remove(i);
    paramPipRenderData = (PipModel)CollectionsKt.getOrNull(localList, i);
    if (paramPipRenderData != null) {
      paramPipRenderData = a(PipModelExtKt.a(paramPipRenderData));
    } else {
      paramPipRenderData = null;
    }
    return new Triple(localList, paramPipRenderData, Integer.valueOf(i));
  }
  
  public int a(@NotNull PipRenderData paramPipRenderData)
  {
    Intrinsics.checkParameterIsNotNull(paramPipRenderData, "data");
    Iterator localIterator = ((Iterable)paramPipRenderData.b()).iterator();
    while (localIterator.hasNext())
    {
      InputSource localInputSource = (InputSource)localIterator.next();
      this.c.a(localInputSource);
    }
    if ((Integer)b(paramPipRenderData).component2() == null)
    {
      ICutSession.DefaultImpls.a(this.c, paramPipRenderData.a(), 0, 2, null);
      return 0;
    }
    paramPipRenderData = Unit.INSTANCE;
    return 0;
  }
  
  @NotNull
  public PipRenderData a(@NotNull PipModel paramPipModel)
  {
    Intrinsics.checkParameterIsNotNull(paramPipModel, "model");
    return PipModelExtKt.b(paramPipModel, this.a);
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
    this.a = ((SizeF)localObject);
    this.b = paramMediaModel.pips;
    return CollectionsKt.toList((Iterable)paramMediaModel.pips.values());
  }
  
  public void a(int paramInt)
  {
    this.c.a(paramInt);
  }
  
  public void a(int paramInt, @Nullable PipRenderData paramPipRenderData1, @NotNull PipRenderData paramPipRenderData2)
  {
    Intrinsics.checkParameterIsNotNull(paramPipRenderData2, "newData");
    Iterator localIterator = ((Iterable)paramPipRenderData2.b()).iterator();
    while (localIterator.hasNext())
    {
      InputSource localInputSource = (InputSource)localIterator.next();
      ICutSession localICutSession = this.c;
      paramPipRenderData1 = localInputSource.key;
      if (paramPipRenderData1 == null) {
        paramPipRenderData1 = "";
      }
      if ((Intrinsics.areEqual(localInputSource, localICutSession.a(paramPipRenderData1)) ^ true)) {
        this.c.a(localInputSource);
      }
    }
    paramPipRenderData1 = ((Iterable)paramPipRenderData2.a().getComponents()).iterator();
    while (paramPipRenderData1.hasNext())
    {
      paramPipRenderData2 = (IdentifyComponent)paramPipRenderData1.next();
      this.c.b(paramInt, paramPipRenderData2);
    }
  }
  
  public boolean a(@NotNull PipModel paramPipModel1, @NotNull PipModel paramPipModel2)
  {
    Intrinsics.checkParameterIsNotNull(paramPipModel1, "newModel");
    Intrinsics.checkParameterIsNotNull(paramPipModel2, "oldModel");
    Object localObject = paramPipModel1.mediaClip;
    ResourceModel localResourceModel = null;
    if (localObject != null) {
      localObject = ((MediaClip)localObject).resource;
    } else {
      localObject = null;
    }
    MediaClip localMediaClip = paramPipModel2.mediaClip;
    if (localMediaClip != null) {
      localResourceModel = localMediaClip.resource;
    }
    return (Intrinsics.areEqual(localObject, localResourceModel)) && (paramPipModel1.startOffset == paramPipModel2.startOffset) && (paramPipModel1.timelineIndex == paramPipModel2.timelineIndex);
  }
  
  @NotNull
  public String b(@NotNull PipModel paramPipModel)
  {
    Intrinsics.checkParameterIsNotNull(paramPipModel, "model");
    return PipModelExtKt.a(paramPipModel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.render.PipRender
 * JD-Core Version:    0.7.0.1
 */