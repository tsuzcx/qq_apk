package com.tencent.videocut.render.extension;

import com.tencent.tavcut.TavCut;
import com.tencent.tavcut.composition.model.component.InputSource;
import com.tencent.tavcut.composition.model.component.TimeRange;
import com.tencent.tavcut.creator.IComponentCreator;
import com.tencent.tavcut.creator.IComponentCreator.DefaultImpls;
import com.tencent.tavcut.creator.IEntityCreator;
import com.tencent.tavcut.creator.IInputSourceCreator;
import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import com.tencent.tavcut.rendermodel.entity.Entity;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaType;
import com.tencent.videocut.model.PipModel;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.model.SizeF;
import com.tencent.videocut.model.Transform;
import com.tencent.videocut.render.FrameFuncKt;
import com.tencent.videocut.render.TransformFuncKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"SUFFIX_AUDIO", "", "SUFFIX_IMG", "SUFFIX_RT", "SUFFIX_VIDEO", "duration", "", "Lcom/tencent/videocut/model/PipModel;", "getDuration", "(Lcom/tencent/videocut/model/PipModel;)J", "endTime", "getEndTime", "filterId", "getFilterId", "(Lcom/tencent/videocut/model/PipModel;)Ljava/lang/String;", "id", "getId", "renderTargetKey", "getRenderTargetKey", "selectDuration", "getSelectDuration", "selectStart", "getSelectStart", "sourceDuration", "getSourceDuration", "speed", "", "getSpeed", "(Lcom/tencent/videocut/model/PipModel;)F", "Lcom/tencent/videocut/model/ResourceModel;", "(Lcom/tencent/videocut/model/ResourceModel;)F", "volume", "getVolume", "emptyRenderData", "Lcom/tencent/videocut/render/extension/PipRenderData;", "creator", "Lcom/tencent/tavcut/creator/IEntityCreator;", "emptyRenderTargetData", "Lcom/tencent/videocut/render/extension/PipRenderTargetData;", "toAudioInputSource", "Lcom/tencent/tavcut/composition/model/component/InputSource;", "key", "resource", "toAudioSourceComponent", "Lcom/tencent/tavcut/rendermodel/component/IdentifyComponent;", "inputSourceKey", "toCamera", "toDefaultScreenTransform", "toEntityIdentifier", "name", "toImageComponent", "toImageInputSource", "toScreenTransformComponent", "clip", "Lcom/tencent/videocut/model/MediaClip;", "renderSize", "Lcom/tencent/videocut/model/SizeF;", "toTimeOffsetComponent", "startOffset", "scaleDuration", "toVideoInputSource", "copies", "newId", "newFilterId", "startOffsetUs", "newTimelineIndex", "", "durationUs", "selectStartUs", "selectDurationUs", "newVolume", "toRenderData", "toRenderTargetData", "qq-wink-impl_release"}, k=2, mv={1, 1, 16})
public final class PipModelExtKt
{
  public static final float a(@NotNull ResourceModel paramResourceModel)
  {
    Intrinsics.checkParameterIsNotNull(paramResourceModel, "$this$speed");
    if (paramResourceModel.scaleDuration == 0L) {
      return 1.0F;
    }
    return (float)paramResourceModel.selectDuration / (float)paramResourceModel.scaleDuration;
  }
  
  private static final InputSource a(String paramString, ResourceModel paramResourceModel)
  {
    return TavCut.a.f().c(paramString, paramResourceModel.path);
  }
  
  private static final IdentifyComponent a()
  {
    return new IdentifyComponent(TavCut.a.e().a());
  }
  
  private static final IdentifyComponent a(long paramLong1, long paramLong2)
  {
    return new IdentifyComponent(TavCut.a.e().a(paramLong1, paramLong2));
  }
  
  private static final IdentifyComponent a(MediaClip paramMediaClip, SizeF paramSizeF)
  {
    Transform localTransform = paramMediaClip.transform;
    if (localTransform == null) {
      localTransform = TransformFuncKt.a();
    }
    if (paramSizeF != null)
    {
      SizeF localSizeF = FrameFuncKt.a(paramSizeF, MediaClipExtensionKt.b(paramMediaClip));
      if (localSizeF != null)
      {
        paramMediaClip = localSizeF;
        break label43;
      }
    }
    paramMediaClip = MediaClipExtensionKt.b(paramMediaClip);
    label43:
    return new IdentifyComponent(TransformExtKt.a(localTransform, paramSizeF, paramMediaClip));
  }
  
  private static final IdentifyComponent a(String paramString)
  {
    return new IdentifyComponent(IComponentCreator.DefaultImpls.a(TavCut.a.e(), paramString, 0L, null, 6, null));
  }
  
  private static final PipRenderTargetData a(IEntityCreator paramIEntityCreator)
  {
    return new PipRenderTargetData(paramIEntityCreator.a("pipRenderTarget", CollectionsKt.emptyList()), paramIEntityCreator.a("pipRenderTargetImg", CollectionsKt.emptyList()), CollectionsKt.emptyList());
  }
  
  @NotNull
  public static final PipRenderTargetData a(@NotNull PipModel paramPipModel, @Nullable SizeF paramSizeF)
  {
    Intrinsics.checkParameterIsNotNull(paramPipModel, "$this$toRenderTargetData");
    IEntityCreator localIEntityCreator = TavCut.a.d();
    MediaClip localMediaClip = paramPipModel.mediaClip;
    if (localMediaClip != null)
    {
      ResourceModel localResourceModel = localMediaClip.resource;
      if (localResourceModel != null)
      {
        Object localObject4 = TavCut.a.f();
        String str = a(paramPipModel);
        Object localObject3 = b(paramPipModel);
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(str);
        ((StringBuilder)localObject1).append("-video");
        localObject1 = ((StringBuilder)localObject1).toString();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append("-img");
        str = ((StringBuilder)localObject2).toString();
        int i;
        if (MediaType.VIDEO == localResourceModel.type) {
          i = 1;
        } else {
          i = 0;
        }
        localObject2 = (List)new ArrayList();
        ((List)localObject2).add(((IInputSourceCreator)localObject4).d("EmptyTexture", "EmptyTexture.tex"));
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject3);
        localStringBuilder.append(".rdt");
        ((List)localObject2).add(((IInputSourceCreator)localObject4).a((String)localObject3, localStringBuilder.toString(), "EmptyTexture"));
        if (i != 0) {
          ((List)localObject2).add(b((String)localObject1, localResourceModel));
        } else {
          ((List)localObject2).add(a(str, localResourceModel));
        }
        localObject4 = (List)new ArrayList();
        ((List)localObject4).add(b("pipRenderTarget"));
        ((List)localObject4).add(a());
        ((List)localObject4).add(c((String)localObject3));
        localObject3 = localIEntityCreator.a("pipRenderTarget", (List)localObject4);
        localObject4 = (List)new ArrayList();
        ((List)localObject4).add(b("pipRenderTargetImg"));
        ((List)localObject4).add(a(localMediaClip, paramSizeF));
        paramSizeF = str;
        if (i != 0) {
          paramSizeF = (SizeF)localObject1;
        }
        ((List)localObject4).add(a(paramSizeF));
        ((List)localObject4).add(a(paramPipModel.startOffset, localResourceModel.scaleDuration));
        return new PipRenderTargetData((Entity)localObject3, localIEntityCreator.a("pipRenderTargetImg", (List)localObject4), (List)localObject2);
      }
      return a(localIEntityCreator);
    }
    return a(localIEntityCreator);
  }
  
  @NotNull
  public static final String a(@NotNull PipModel paramPipModel)
  {
    Intrinsics.checkParameterIsNotNull(paramPipModel, "$this$id");
    paramPipModel = paramPipModel.mediaClip;
    if (paramPipModel != null)
    {
      paramPipModel = MediaClipExtensionKt.a(paramPipModel);
      if (paramPipModel != null) {
        return paramPipModel;
      }
    }
    return "";
  }
  
  private static final InputSource b(String paramString, ResourceModel paramResourceModel)
  {
    return TavCut.a.f().b(paramString, paramResourceModel.path, new TimeRange(paramResourceModel.selectStart, paramResourceModel.selectDuration, null, 4, null));
  }
  
  private static final IdentifyComponent b(String paramString)
  {
    return new IdentifyComponent(TavCut.a.e().a(paramString));
  }
  
  private static final PipRenderData b(IEntityCreator paramIEntityCreator)
  {
    return new PipRenderData(paramIEntityCreator.a("pip", CollectionsKt.emptyList()), CollectionsKt.emptyList(), 0, "");
  }
  
  @NotNull
  public static final PipRenderData b(@NotNull PipModel paramPipModel, @Nullable SizeF paramSizeF)
  {
    Intrinsics.checkParameterIsNotNull(paramPipModel, "$this$toRenderData");
    paramSizeF = TavCut.a.d();
    Object localObject1 = paramPipModel.mediaClip;
    if (localObject1 != null)
    {
      localObject1 = ((MediaClip)localObject1).resource;
      if (localObject1 != null)
      {
        String str = a(paramPipModel);
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append("-audio");
        str = ((StringBuilder)localObject2).toString();
        int i;
        if (MediaType.VIDEO == ((ResourceModel)localObject1).type) {
          i = 1;
        } else {
          i = 0;
        }
        localObject2 = (List)new ArrayList();
        if (i != 0) {
          ((List)localObject2).add(c(str, (ResourceModel)localObject1));
        }
        List localList = (List)new ArrayList();
        localList.add(b("pip"));
        localList.add(a(b(paramPipModel)));
        localList.add(a(paramPipModel.startOffset, ((ResourceModel)localObject1).scaleDuration));
        localList.add(a());
        if (i != 0) {
          localList.add(d(str, (ResourceModel)localObject1));
        }
        return new PipRenderData(paramSizeF.a("pip", localList), (List)localObject2, paramPipModel.timelineIndex, a(paramPipModel));
      }
      return b(paramSizeF);
    }
    return b(paramSizeF);
  }
  
  @NotNull
  public static final String b(@NotNull PipModel paramPipModel)
  {
    Intrinsics.checkParameterIsNotNull(paramPipModel, "$this$renderTargetKey");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramPipModel));
    localStringBuilder.append("-rt");
    return localStringBuilder.toString();
  }
  
  private static final InputSource c(String paramString, ResourceModel paramResourceModel)
  {
    return TavCut.a.f().a(paramString, paramResourceModel.path, new TimeRange(paramResourceModel.selectStart, paramResourceModel.selectDuration, null, 4, null));
  }
  
  private static final IdentifyComponent c(String paramString)
  {
    return new IdentifyComponent(TavCut.a.e().b(paramString));
  }
  
  private static final IdentifyComponent d(String paramString, ResourceModel paramResourceModel)
  {
    return new IdentifyComponent(TavCut.a.e().a(paramString, paramResourceModel.volume, a(paramResourceModel)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.render.extension.PipModelExtKt
 * JD-Core Version:    0.7.0.1
 */