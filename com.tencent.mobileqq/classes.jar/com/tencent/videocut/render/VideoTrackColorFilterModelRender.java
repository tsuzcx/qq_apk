package com.tencent.videocut.render;

import com.tencent.logger.Logger;
import com.tencent.tavcut.composition.model.component.InputSource;
import com.tencent.tavcut.rendermodel.entity.Entity;
import com.tencent.tavcut.session.ICutSession;
import com.tencent.videocut.model.FilterModel;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/render/VideoTrackColorFilterModelRender;", "Lcom/tencent/videocut/render/AbsColorFilterModelRender;", "tavCutSession", "Lcom/tencent/tavcut/session/ICutSession;", "(Lcom/tencent/tavcut/session/ICutSession;)V", "mediaModel", "Lcom/tencent/videocut/model/MediaModel;", "addEntity", "", "data", "Lcom/tencent/videocut/render/RenderData;", "removeEntity", "", "entityId", "selector", "", "Lcom/tencent/videocut/render/FilterRenderData;", "model", "updateEntity", "originalEntityId", "oldData", "newData", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class VideoTrackColorFilterModelRender
  extends AbsColorFilterModelRender
{
  public static final VideoTrackColorFilterModelRender.Companion a = new VideoTrackColorFilterModelRender.Companion(null);
  private MediaModel b;
  
  public VideoTrackColorFilterModelRender(@NotNull ICutSession paramICutSession)
  {
    super(paramICutSession);
  }
  
  public int a(@NotNull RenderData paramRenderData)
  {
    Intrinsics.checkParameterIsNotNull(paramRenderData, "data");
    Object localObject2 = VideoTrackLutFilterModelRender.a;
    MediaModel localMediaModel = this.b;
    Object localObject1 = paramRenderData.b().key;
    if (localObject1 == null) {
      localObject1 = "";
    }
    int j = ((VideoTrackLutFilterModelRender.Companion)localObject2).a(localMediaModel, (String)localObject1);
    int i = j;
    if (j < 0) {
      i = 0;
    }
    paramRenderData = a().b(paramRenderData.a(), i);
    localObject1 = Logger.a;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("add adjust id=");
    ((StringBuilder)localObject2).append(paramRenderData.getId());
    ((StringBuilder)localObject2).append(" index=");
    ((StringBuilder)localObject2).append(i);
    ((Logger)localObject1).b("VideoTrackColorFilterModelRender", ((StringBuilder)localObject2).toString());
    return paramRenderData.getId();
  }
  
  @NotNull
  public List<FilterRenderData> a(@NotNull MediaModel paramMediaModel)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaModel, "model");
    this.b = paramMediaModel;
    List localList = (List)new ArrayList();
    paramMediaModel = ((Iterable)paramMediaModel.videos).iterator();
    int i = 0;
    while (paramMediaModel.hasNext())
    {
      Object localObject = paramMediaModel.next();
      if (i < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      localObject = ((MediaClip)localObject).filter;
      if ((localObject != null) && (((FilterModel)localObject).color != null)) {
        localList.add(new FilterRenderData(i, (FilterModel)localObject, null, 4, null));
      }
      i += 1;
    }
    return localList;
  }
  
  public void a(int paramInt)
  {
    Logger localLogger = Logger.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("remove adjust ");
    localStringBuilder.append(paramInt);
    localLogger.b("VideoTrackColorFilterModelRender", localStringBuilder.toString());
    super.a(paramInt);
  }
  
  public void a(int paramInt, @Nullable RenderData paramRenderData1, @NotNull RenderData paramRenderData2)
  {
    Intrinsics.checkParameterIsNotNull(paramRenderData2, "newData");
    Logger localLogger = Logger.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("update adjust ");
    localStringBuilder.append(paramInt);
    localLogger.b("VideoTrackColorFilterModelRender", localStringBuilder.toString());
    super.a(paramInt, paramRenderData1, paramRenderData2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.render.VideoTrackColorFilterModelRender
 * JD-Core Version:    0.7.0.1
 */