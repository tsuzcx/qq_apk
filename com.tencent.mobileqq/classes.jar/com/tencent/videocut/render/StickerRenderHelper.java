package com.tencent.videocut.render;

import com.tencent.tavcut.composition.model.component.InputSource;
import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import com.tencent.tavcut.rendermodel.entity.Entity;
import com.tencent.tavcut.session.ICutSession;
import com.tencent.tavcut.session.ICutSession.DefaultImpls;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.StickerModel;
import com.tencent.videocut.model.TextItem;
import com.tencent.videocut.render.extension.StickerExtensionsKt;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/render/StickerRenderHelper;", "Lcom/tencent/videocut/render/AbsListRender;", "Lcom/tencent/videocut/model/StickerModel;", "Lcom/tencent/videocut/render/StickerRenderHelper$RenderData;", "tavCutSession", "Lcom/tencent/tavcut/session/ICutSession;", "(Lcom/tencent/tavcut/session/ICutSession;)V", "addEntity", "", "data", "getItemIdentity", "", "model", "isContentTheSame", "", "newModel", "oldModel", "prepareRenderData", "removeEntity", "", "entityId", "selector", "", "Lcom/tencent/videocut/model/MediaModel;", "updateEntity", "originalEntityId", "oldData", "newData", "Companion", "RenderData", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class StickerRenderHelper
  extends AbsListRender<StickerModel, StickerRenderHelper.RenderData>
{
  public static final StickerRenderHelper.Companion a = new StickerRenderHelper.Companion(null);
  private final ICutSession b;
  
  public StickerRenderHelper(@NotNull ICutSession paramICutSession)
  {
    this.b = paramICutSession;
  }
  
  public int a(@NotNull StickerRenderHelper.RenderData paramRenderData)
  {
    Intrinsics.checkParameterIsNotNull(paramRenderData, "data");
    this.b.a(paramRenderData.b());
    InputSource localInputSource = paramRenderData.c();
    if (localInputSource != null) {
      this.b.a(localInputSource);
    }
    return ICutSession.DefaultImpls.a(this.b, paramRenderData.a(), 0, 2, null).getId();
  }
  
  @NotNull
  public StickerRenderHelper.RenderData a(@NotNull StickerModel paramStickerModel)
  {
    Intrinsics.checkParameterIsNotNull(paramStickerModel, "model");
    Iterator localIterator = paramStickerModel.textItems.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (TextItem)localIterator.next();
      String str = ((TextItem)localObject).fontFamily;
      localObject = ((TextItem)localObject).fontPath;
      this.b.a(str, (String)localObject);
    }
    return StickerExtensionsKt.a(paramStickerModel);
  }
  
  @NotNull
  public List<StickerModel> a(@NotNull MediaModel paramMediaModel)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaModel, "model");
    return CollectionsKt.toList((Iterable)paramMediaModel.stickers.values());
  }
  
  public void a(int paramInt)
  {
    this.b.a(paramInt);
  }
  
  public void a(int paramInt, @Nullable StickerRenderHelper.RenderData paramRenderData1, @NotNull StickerRenderHelper.RenderData paramRenderData2)
  {
    Intrinsics.checkParameterIsNotNull(paramRenderData2, "newData");
    ICutSession localICutSession = this.b;
    paramRenderData1 = paramRenderData2.b().key;
    if (paramRenderData1 == null) {
      paramRenderData1 = "";
    }
    paramRenderData1 = localICutSession.a(paramRenderData1);
    if ((Intrinsics.areEqual(paramRenderData2.b(), paramRenderData1) ^ true)) {
      this.b.a(paramRenderData2.b());
    }
    paramRenderData1 = paramRenderData2.c();
    if (paramRenderData1 != null) {
      this.b.a(paramRenderData1);
    }
    paramRenderData1 = ((Iterable)paramRenderData2.a().getComponents()).iterator();
    while (paramRenderData1.hasNext())
    {
      paramRenderData2 = (IdentifyComponent)paramRenderData1.next();
      this.b.b(paramInt, paramRenderData2);
    }
  }
  
  public boolean a(@NotNull StickerModel paramStickerModel1, @NotNull StickerModel paramStickerModel2)
  {
    Intrinsics.checkParameterIsNotNull(paramStickerModel1, "newModel");
    Intrinsics.checkParameterIsNotNull(paramStickerModel2, "oldModel");
    return (paramStickerModel1.centerX == paramStickerModel2.centerX) && (paramStickerModel1.centerY == paramStickerModel2.centerY) && (paramStickerModel1.scale == paramStickerModel2.scale) && (paramStickerModel1.rotate == paramStickerModel2.rotate) && (paramStickerModel1.width == paramStickerModel2.width) && (paramStickerModel1.height == paramStickerModel2.height) && (paramStickerModel1.startTime == paramStickerModel2.startTime) && (paramStickerModel1.duration == paramStickerModel2.duration) && (Intrinsics.areEqual(paramStickerModel1.filePath, paramStickerModel2.filePath)) && (paramStickerModel1.layerIndex == paramStickerModel2.layerIndex) && (Intrinsics.areEqual(paramStickerModel1.textItems, paramStickerModel2.textItems));
  }
  
  @NotNull
  public String b(@NotNull StickerModel paramStickerModel)
  {
    Intrinsics.checkParameterIsNotNull(paramStickerModel, "model");
    return paramStickerModel.id;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.render.StickerRenderHelper
 * JD-Core Version:    0.7.0.1
 */