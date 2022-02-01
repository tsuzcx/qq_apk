package com.tencent.tavcut.render.builder.light;

import com.tencent.tavcut.model.Painting;
import com.tencent.tavcut.render.EffectDispatcher;
import com.tencent.tavcut.render.IRenderChainManager;
import com.tencent.tavcut.render.builder.IMediaBuilder;
import com.tencent.tavcut.render.builder.IMediaBuilderListener;
import com.tencent.tavcut.render.builder.MediaBuilderOutput;
import com.tencent.tavcut.render.log.TavLogger;
import com.tencent.tavcut.render.rendernode.BaseEffectNode;
import com.tencent.tavcut.render.rendernode.LightRenderNode;
import com.tencent.tavcut.render.rendernode.audio.LightAudioNode;
import com.tencent.tavcut.render.util.CMTimeUtil;
import com.tencent.tavcut.rendermodel.RenderModel;
import com.tencent.tavcut.rendermodel.RenderScene;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.audio.TAVAudioProcessorNode;
import com.tencent.tavkit.composition.model.TAVAudioConfiguration;
import com.tencent.tavkit.composition.resource.TAVEmptyResource;
import com.tencent.tavkit.composition.resource.TAVResource;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import com.tencent.tavkit.utils.ListUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.MovieController;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/render/builder/light/LightMediaBuilder;", "Lcom/tencent/tavcut/render/builder/IMediaBuilder;", "()V", "TAG", "", "buildComposition", "", "templatePath", "renderModel", "Lcom/tencent/tavcut/rendermodel/RenderModel;", "builderListener", "Lcom/tencent/tavcut/render/builder/IMediaBuilderListener;", "getTAVClips", "", "Lcom/tencent/tavkit/composition/TAVClip;", "durationUs", "", "initAudioClip", "videoVolume", "", "audioDuration", "audioNode", "Lcom/tencent/tavcut/render/rendernode/audio/LightAudioNode;", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public final class LightMediaBuilder
  implements IMediaBuilder
{
  public static final LightMediaBuilder a = new LightMediaBuilder();
  
  private final List<TAVClip> a(float paramFloat, long paramLong, LightAudioNode paramLightAudioNode)
  {
    TAVClip localTAVClip = new TAVClip(CMTimeUtil.a(CMTimeUtil.a, paramLong, 0, 2, null), true);
    TAVAudioConfiguration localTAVAudioConfiguration = new TAVAudioConfiguration();
    localTAVAudioConfiguration.setVolume(paramFloat);
    localTAVAudioConfiguration.setAudioProcessorNodes(ListUtils.listWithObjects(new TAVAudioProcessorNode[] { (TAVAudioProcessorNode)paramLightAudioNode }));
    localTAVClip.setAudioConfiguration(localTAVAudioConfiguration);
    paramLightAudioNode = new ArrayList();
    paramLightAudioNode.add(localTAVClip);
    return (List)paramLightAudioNode;
  }
  
  private final List<TAVClip> a(long paramLong)
  {
    List localList = (List)new ArrayList();
    localList.add(new TAVClip((TAVResource)new TAVEmptyResource(CMTimeUtil.a(CMTimeUtil.a, paramLong, 0, 2, null))));
    return localList;
  }
  
  public void a(@NotNull String paramString, @NotNull RenderModel paramRenderModel, @Nullable IMediaBuilderListener paramIMediaBuilderListener)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "templatePath");
    Intrinsics.checkParameterIsNotNull(paramRenderModel, "renderModel");
    TavLogger.b("LightMediaBuilder", "start buildComposition...");
    LightRenderChainManager localLightRenderChainManager = new LightRenderChainManager();
    boolean bool = localLightRenderChainManager.a(paramString, paramRenderModel);
    Object localObject1 = null;
    if (!bool)
    {
      TavLogger.e("LightMediaBuilder", "initLightAsset failed. errorCode:-1");
      if (paramIMediaBuilderListener != null) {
        paramIMediaBuilderListener.a(-1, null);
      }
      return;
    }
    if (!localLightRenderChainManager.a(paramRenderModel.getSeekTolerance()))
    {
      TavLogger.e("LightMediaBuilder", "initEngine failed. errorCode:-2");
      if (paramIMediaBuilderListener != null) {
        paramIMediaBuilderListener.a(-2, null);
      }
      return;
    }
    if (!localLightRenderChainManager.e())
    {
      TavLogger.e("LightMediaBuilder", "initLightNode failed. errorCode:-3");
      if (paramIMediaBuilderListener != null) {
        paramIMediaBuilderListener.a(-3, null);
      }
      return;
    }
    localLightRenderChainManager.a(LightEntityTransHelper.a(paramRenderModel.getClipsAssets()), paramRenderModel.getPainting().pagPath, paramRenderModel.getModifyClipsDuration());
    paramString = localLightRenderChainManager.b();
    long l1;
    if (paramString != null) {
      l1 = paramString.duration();
    } else {
      l1 = 0L;
    }
    if (l1 == 0L)
    {
      TavLogger.e("LightMediaBuilder", "get total duration failed. errorCode:-4");
      if (paramIMediaBuilderListener != null) {
        paramIMediaBuilderListener.a(-4, null);
      }
      return;
    }
    long l2 = l1;
    if (paramRenderModel.getMaxDuration() != -1L) {
      l2 = Math.min(l1, paramRenderModel.getMaxDuration());
    }
    if (!localLightRenderChainManager.f())
    {
      TavLogger.e("LightMediaBuilder", "get total duration failed. errorCode:-5");
      if (paramIMediaBuilderListener != null) {
        paramIMediaBuilderListener.a(-5, null);
      }
      return;
    }
    paramString = localLightRenderChainManager.b();
    if (paramString != null) {
      paramString = paramString.timeLine();
    } else {
      paramString = null;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(", size:");
    if (paramString != null) {
      localObject1 = Integer.valueOf(paramString.length);
    }
    ((StringBuilder)localObject2).append(localObject1);
    TavLogger.b("LightMediaBuilder", ((StringBuilder)localObject2).toString());
    if (paramString != null)
    {
      paramString = RenderModel.copy$default(paramRenderModel, null, null, null, null, null, false, 0, null, null, LightEntityTransHelper.a(paramString), 0L, 0, null, 7679, null);
      if (paramString != null) {}
    }
    else
    {
      paramString = paramRenderModel;
    }
    localObject1 = new TAVComposition(a(l2), CollectionsKt.emptyList());
    localObject2 = new EffectDispatcher();
    ((TAVComposition)localObject1).setVideoMixEffect((TAVVideoMixEffect)localObject2);
    LightRenderNode localLightRenderNode = localLightRenderChainManager.c();
    if (localLightRenderNode == null) {
      Intrinsics.throwNpe();
    }
    ((EffectDispatcher)localObject2).a((BaseEffectNode)localLightRenderNode);
    localLightRenderChainManager.a((EffectDispatcher)localObject2);
    localObject2 = localLightRenderChainManager.d();
    if (localObject2 != null) {
      ((TAVComposition)localObject1).addAudioChannel(a(a, 0.0F, l2, (LightAudioNode)localObject2, 1, null));
    }
    if ((paramRenderModel.getRenderScene() == RenderScene.PLAY) || (paramRenderModel.getRenderScene() == RenderScene.EXPORTER)) {
      localLightRenderChainManager.a(paramRenderModel.getVoiceChangerConfig());
    }
    if (paramIMediaBuilderListener != null) {
      paramIMediaBuilderListener.a(0, new MediaBuilderOutput((IRenderChainManager)localLightRenderChainManager, paramString, (TAVComposition)localObject1, l2));
    }
    TavLogger.b("LightMediaBuilder", "buildComposition success.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.builder.light.LightMediaBuilder
 * JD-Core Version:    0.7.0.1
 */