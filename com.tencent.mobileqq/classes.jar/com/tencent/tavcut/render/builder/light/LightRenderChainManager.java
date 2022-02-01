package com.tencent.tavcut.render.builder.light;

import com.tencent.tavcut.composition.model.component.Size;
import com.tencent.tavcut.composition.model.component.TimeOffset;
import com.tencent.tavcut.composition.model.component.Timeline;
import com.tencent.tavcut.model.Painting;
import com.tencent.tavcut.render.EffectDispatcher;
import com.tencent.tavcut.render.EffectDispatcher.EffectDispatchListener;
import com.tencent.tavcut.render.IRenderChainManager;
import com.tencent.tavcut.render.LightAiManager;
import com.tencent.tavcut.render.RenderConfig;
import com.tencent.tavcut.render.log.TavLogger;
import com.tencent.tavcut.render.rendernode.LightRenderNode;
import com.tencent.tavcut.render.rendernode.audio.LightAudioNode;
import com.tencent.tavcut.rendermodel.RenderModel;
import com.tencent.tavcut.rendermodel.VoiceEnum;
import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import com.tencent.tavcut.rendermodel.parser.TemplateParser;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.AudioOutput;
import org.light.AudioOutputConfig;
import org.light.ClipAsset;
import org.light.FontAsset;
import org.light.LightAsset;
import org.light.LightEngine;
import org.light.MovieController;
import org.light.RendererConfig;
import org.light.TimeLine;
import org.light.TimeRange;
import org.light.VideoOutputConfig;
import org.light.utils.LightLogUtil;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/render/builder/light/LightRenderChainManager;", "Lcom/tencent/tavcut/render/IRenderChainManager;", "()V", "afterEventQueue", "Ljava/util/Queue;", "Ljava/lang/Runnable;", "beforeEventQueue", "currentVoice", "Lcom/tencent/tavcut/rendermodel/VoiceEnum;", "getCurrentVoice", "()Lcom/tencent/tavcut/rendermodel/VoiceEnum;", "setCurrentVoice", "(Lcom/tencent/tavcut/rendermodel/VoiceEnum;)V", "effectDispatcher", "Lcom/tencent/tavcut/render/EffectDispatcher;", "lightAsset", "Lorg/light/LightAsset;", "getLightAsset", "()Lorg/light/LightAsset;", "setLightAsset", "(Lorg/light/LightAsset;)V", "lightAudiNode", "Lcom/tencent/tavcut/render/rendernode/audio/LightAudioNode;", "getLightAudiNode", "()Lcom/tencent/tavcut/render/rendernode/audio/LightAudioNode;", "setLightAudiNode", "(Lcom/tencent/tavcut/render/rendernode/audio/LightAudioNode;)V", "lightEngine", "Lorg/light/LightEngine;", "getLightEngine", "()Lorg/light/LightEngine;", "setLightEngine", "(Lorg/light/LightEngine;)V", "lightRenderNode", "Lcom/tencent/tavcut/render/rendernode/LightRenderNode;", "getLightRenderNode", "()Lcom/tencent/tavcut/render/rendernode/LightRenderNode;", "setLightRenderNode", "(Lcom/tencent/tavcut/render/rendernode/LightRenderNode;)V", "movieController", "Lorg/light/MovieController;", "getMovieController", "()Lorg/light/MovieController;", "setMovieController", "(Lorg/light/MovieController;)V", "voiceChanger", "Lcom/tencent/tavcut/render/audio/voicechanger/VoiceChanger;", "getVoiceChanger", "()Lcom/tencent/tavcut/render/audio/voicechanger/VoiceChanger;", "setVoiceChanger", "(Lcom/tencent/tavcut/render/audio/voicechanger/VoiceChanger;)V", "accessTotalDuration", "", "timeLines", "", "Lorg/light/TimeLine;", "([Lorg/light/TimeLine;)J", "addEntity", "", "parentId", "", "entity", "Lcom/tencent/tavcut/rendermodel/entity/Entity;", "afterAllNodeRelease", "checkIsNeedRebuild", "", "component", "Lcom/tencent/tavcut/rendermodel/component/IdentifyComponent;", "entityId", "", "findTimelineByEntityId", "(I[Lorg/light/TimeLine;)Lorg/light/TimeLine;", "getEditableTextByEntityId", "", "Lcom/tencent/tavcut/model/TextPlaceInfo;", "getEditableTextUnderPoint", "x", "", "y", "getEntitiesUnderPoint", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getLightSdkBaseFileDir", "initEngine", "seekTolerance", "initLightAsset", "templatePath", "renderModel", "Lcom/tencent/tavcut/rendermodel/RenderModel;", "initLightAudioNode", "initLightNode", "registerFont", "fontFamily", "fontPath", "release", "reloadAsset", "templateDir", "updatedTimeLines", "Lkotlin/Function2;", "Lcom/tencent/tavcut/composition/model/component/Timeline;", "Lkotlin/ParameterName;", "name", "updatePlayer", "removeEntity", "runAll", "queue", "runOnAfterApply", "runnable", "runOnBeforeApply", "setClipAssets", "clipAssets", "Lorg/light/ClipAsset;", "backgroundPagPath", "modifyClipsDuration", "setEffectDispatcher", "setRenderTimeRange", "renderTimeRange", "Lcom/tencent/tav/coremedia/CMTimeRange;", "setVoiceChangerConfig", "config", "updateComponent", "rebuild", "Lkotlin/Function1;", "convertToInfo", "Lorg/light/TextPlaceHolder;", "Companion", "EffectDispatchListener", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public final class LightRenderChainManager
  implements IRenderChainManager
{
  public static final LightRenderChainManager.Companion a = new LightRenderChainManager.Companion(null);
  private static final CopyOnWriteArraySet<MovieController> j = new CopyOnWriteArraySet();
  @Nullable
  private LightEngine b;
  @Nullable
  private LightAsset c;
  @Nullable
  private MovieController d;
  @Nullable
  private LightRenderNode e;
  @Nullable
  private LightAudioNode f;
  private EffectDispatcher g;
  private final Queue<Runnable> h = (Queue)new LinkedList();
  private final Queue<Runnable> i = (Queue)new LinkedList();
  
  public LightRenderChainManager()
  {
    int k;
    if (((CharSequence)RenderConfig.a.a()).length() == 0) {
      k = 1;
    } else {
      k = 0;
    }
    if (k == 0)
    {
      if (LightSDKUtils.a.a()) {
        return;
      }
      throw ((Throwable)new IllegalStateException("so still not install, please load V8Jni and lightsdk so first"));
    }
    throw ((Throwable)new IllegalStateException("light_assets still not install, Use TavCut must install light_assets first !!!!"));
  }
  
  private final long a(TimeLine[] paramArrayOfTimeLine)
  {
    long l1 = 0L;
    long l2 = l1;
    if (paramArrayOfTimeLine != null)
    {
      int m = paramArrayOfTimeLine.length;
      int k = 0;
      for (;;)
      {
        l2 = l1;
        if (k >= m) {
          break;
        }
        TimeLine localTimeLine = paramArrayOfTimeLine[k];
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("timeline ");
        localStringBuilder.append(localTimeLine.range.startTime);
        localStringBuilder.append(" , ");
        localStringBuilder.append(localTimeLine.range.duration);
        TavLogger.b("LightRenderChainManager", localStringBuilder.toString());
        l1 = Math.max(l1, localTimeLine.range.duration);
        k += 1;
      }
    }
    return l2;
  }
  
  private final TimeLine a(int paramInt, TimeLine[] paramArrayOfTimeLine)
  {
    if (paramArrayOfTimeLine != null)
    {
      int n = paramArrayOfTimeLine.length;
      int k = 0;
      while (k < n)
      {
        TimeLine localTimeLine = paramArrayOfTimeLine[k];
        int m;
        if (localTimeLine.entityID == paramInt) {
          m = 1;
        } else {
          m = 0;
        }
        if (m != 0) {
          return localTimeLine;
        }
        k += 1;
      }
    }
    return null;
  }
  
  private final void a(Queue<Runnable> paramQueue)
  {
    if (paramQueue.isEmpty()) {
      return;
    }
    try
    {
      while ((((Collection)paramQueue).isEmpty() ^ true)) {
        ((Runnable)paramQueue.poll()).run();
      }
      Unit localUnit = Unit.INSTANCE;
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  private final boolean a(IdentifyComponent paramIdentifyComponent, int paramInt)
  {
    if ((paramIdentifyComponent.getData() instanceof TimeOffset))
    {
      Object localObject = this.d;
      if (localObject != null) {
        localObject = ((MovieController)localObject).timeLine();
      } else {
        localObject = null;
      }
      long l3 = a((TimeLine[])localObject);
      localObject = a(paramInt, (TimeLine[])localObject);
      long l1 = 0L;
      if (localObject != null)
      {
        localObject = ((TimeLine)localObject).range;
        if (localObject != null) {}
      }
      else
      {
        localObject = new TimeRange(0L, 0L);
      }
      long l4 = ((TimeRange)localObject).startTime + ((TimeRange)localObject).duration;
      paramIdentifyComponent = paramIdentifyComponent.getData();
      if (paramIdentifyComponent != null)
      {
        paramIdentifyComponent = (TimeOffset)paramIdentifyComponent;
        localObject = paramIdentifyComponent.startOffset;
        long l2 = l1;
        if (localObject != null)
        {
          l2 = ((Long)localObject).longValue();
          paramIdentifyComponent = paramIdentifyComponent.duration;
          if (paramIdentifyComponent != null) {
            l1 = paramIdentifyComponent.longValue();
          }
          l2 = l1 + l2;
        }
        paramIdentifyComponent = new StringBuilder();
        paramIdentifyComponent.append("beforeTotalDuration ");
        paramIdentifyComponent.append(l3);
        paramIdentifyComponent.append(" beforeEndTime ");
        paramIdentifyComponent.append(l4);
        paramIdentifyComponent.append(' ');
        paramIdentifyComponent.append("afterEndTime ");
        paramIdentifyComponent.append(l2);
        TavLogger.b("LightRenderChainManager", paramIdentifyComponent.toString());
        boolean bool = true;
        if ((l4 == l3) && (l2 != l3)) {
          paramInt = 1;
        } else {
          paramInt = 0;
        }
        int k;
        if ((l4 + 1L <= l3) && (l2 > l3)) {
          k = 1;
        } else {
          k = 0;
        }
        if (paramInt == 0)
        {
          if (k != 0) {
            return true;
          }
          bool = false;
        }
        return bool;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.tavcut.composition.model.component.TimeOffset");
    }
    return false;
  }
  
  private final String g()
  {
    return RenderConfig.a.a();
  }
  
  private final void h()
  {
    TavLogger.b("LightRenderChainManager", "afterAllNodeRelease");
    Object localObject = this.d;
    if (localObject != null) {
      ((MovieController)localObject).resetAsset();
    }
    this.d = ((MovieController)null);
    localObject = this.b;
    if (localObject != null) {
      ((LightEngine)localObject).release();
    }
    this.b = ((LightEngine)null);
    this.c = ((LightAsset)null);
    localObject = this.g;
    if (localObject != null) {
      ((EffectDispatcher)localObject).a((EffectDispatcher.EffectDispatchListener)null);
    }
    this.g = ((EffectDispatcher)null);
  }
  
  private final void i()
  {
    a(this.h);
  }
  
  private final void j()
  {
    a(this.i);
  }
  
  public void a()
  {
    LightRenderNode localLightRenderNode = this.e;
    if (localLightRenderNode != null) {
      localLightRenderNode.d();
    }
    this.e = ((LightRenderNode)null);
  }
  
  public void a(int paramInt, @NotNull IdentifyComponent paramIdentifyComponent, @NotNull Function1<? super Boolean, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramIdentifyComponent, "component");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "rebuild");
    MovieController localMovieController = this.d;
    if (localMovieController != null) {
      localMovieController.updateComponent(paramInt, TemplateParser.INSTANCE.dumpJson(paramIdentifyComponent));
    }
    paramFunction1.invoke(Boolean.valueOf(a(paramIdentifyComponent, paramInt)));
  }
  
  public final void a(@NotNull EffectDispatcher paramEffectDispatcher)
  {
    Intrinsics.checkParameterIsNotNull(paramEffectDispatcher, "effectDispatcher");
    this.g = paramEffectDispatcher;
    paramEffectDispatcher.a((EffectDispatcher.EffectDispatchListener)new LightRenderChainManager.EffectDispatchListener(this));
  }
  
  public void a(@NotNull Runnable paramRunnable)
  {
    Intrinsics.checkParameterIsNotNull(paramRunnable, "runnable");
    synchronized (this.h)
    {
      this.h.add(paramRunnable);
      return;
    }
  }
  
  public void a(@NotNull String paramString, @NotNull RenderModel paramRenderModel, @NotNull Function2<? super List<Timeline>, ? super Boolean, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "templateDir");
    Intrinsics.checkParameterIsNotNull(paramRenderModel, "renderModel");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "updatedTimeLines");
    Object localObject1 = this.c;
    Integer localInteger = Integer.valueOf(0);
    if (localObject1 != null) {
      localObject1 = Integer.valueOf(((LightAsset)localObject1).width());
    } else {
      localObject1 = localInteger;
    }
    Object localObject2 = this.c;
    if (localObject2 != null) {
      localInteger = Integer.valueOf(((LightAsset)localObject2).height());
    }
    localObject1 = new Size((Integer)localObject1, localInteger, null, 4, null);
    if (a(paramString, paramRenderModel))
    {
      paramString = this.d;
      localInteger = null;
      if (paramString != null) {
        paramString = paramString.timeLine();
      } else {
        paramString = null;
      }
      long l1 = a(paramString);
      j.remove(this.d);
      paramString = this.b;
      if (paramString != null) {
        paramString = paramString.setAssetForMovie(this.c);
      } else {
        paramString = null;
      }
      this.d = paramString;
      j.add(this.d);
      a(LightEntityTransHelper.a(paramRenderModel.getClipsAssets()), paramRenderModel.getPainting().pagPath, paramRenderModel.getModifyClipsDuration());
      localObject2 = this.d;
      paramString = localInteger;
      if (localObject2 != null) {
        paramString = ((MovieController)localObject2).timeLine();
      }
      long l2 = a(paramString);
      boolean bool2 = true;
      boolean bool1 = bool2;
      if (l1 == l2) {
        if ((Intrinsics.areEqual(localObject1, paramRenderModel.getPainting().renderSize) ^ true)) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
      }
      if (paramString != null) {
        paramFunction2.invoke(LightEntityTransHelper.a(paramString), Boolean.valueOf(bool1));
      }
    }
  }
  
  public void a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "fontFamily");
    Intrinsics.checkParameterIsNotNull(paramString2, "fontPath");
    LightEngine.RegisterFont(new FontAsset(paramString1, ""), paramString2);
  }
  
  public void a(@Nullable List<? extends VoiceEnum> paramList) {}
  
  public final void a(@NotNull List<? extends ClipAsset> paramList, @Nullable String paramString, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "clipAssets");
    MovieController localMovieController = this.d;
    if (localMovieController != null)
    {
      paramList = ((Collection)paramList).toArray(new ClipAsset[0]);
      if (paramList != null)
      {
        localMovieController.setClipAssets((ClipAsset[])paramList, paramString, paramBoolean);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }
  }
  
  public final boolean a(int paramInt)
  {
    Object localObject = new VideoOutputConfig(30.0F, paramInt);
    AudioOutputConfig localAudioOutputConfig = new AudioOutputConfig();
    localAudioOutputConfig.sampleRate = 44100;
    localAudioOutputConfig.sampleCount = 2646;
    localAudioOutputConfig.channels = 1;
    RendererConfig localRendererConfig = new RendererConfig(g());
    LightLogUtil.initLogger();
    LightLogUtil.setMinPriority(5);
    localObject = LightEngine.Make((VideoOutputConfig)localObject, localAudioOutputConfig, localRendererConfig);
    if (localObject != null)
    {
      this.b = ((LightEngine)localObject);
      localObject = this.b;
      if (localObject != null) {
        ((LightEngine)localObject).setConfig(LightAiManager.a.a());
      }
      localObject = this.b;
      if (localObject != null) {
        ((LightEngine)localObject).setBGMusicHidden(false);
      }
      localObject = this.b;
      if (localObject != null) {
        localObject = ((LightEngine)localObject).setAssetForMovie(this.c);
      } else {
        localObject = null;
      }
      this.d = ((MovieController)localObject);
      return true;
    }
    return false;
  }
  
  public final boolean a(@NotNull String paramString, @NotNull RenderModel paramRenderModel)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "templatePath");
    Intrinsics.checkParameterIsNotNull(paramRenderModel, "renderModel");
    LightAsset localLightAsset = this.c;
    if (localLightAsset != null) {
      localLightAsset.nativeFinalize();
    }
    paramRenderModel = TemplateParser.INSTANCE.dumpJson(paramRenderModel);
    boolean bool = false;
    this.c = LightAsset.LoadFromString(paramString, paramRenderModel, 0);
    if (this.c != null) {
      bool = true;
    }
    return bool;
  }
  
  @Nullable
  public final MovieController b()
  {
    return this.d;
  }
  
  @Nullable
  public final LightRenderNode c()
  {
    return this.e;
  }
  
  @Nullable
  public final LightAudioNode d()
  {
    return this.f;
  }
  
  public final boolean e()
  {
    LightEngine localLightEngine = this.b;
    if (localLightEngine != null)
    {
      LightAsset localLightAsset = this.c;
      if (localLightAsset != null) {
        this.e = new LightRenderNode(localLightEngine, localLightAsset);
      }
    }
    return this.e != null;
  }
  
  public final boolean f()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = ((LightEngine)localObject).audioOutput();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "it.audioOutput()");
      this.f = new LightAudioNode((AudioOutput)localObject);
    }
    return this.f != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.builder.light.LightRenderChainManager
 * JD-Core Version:    0.7.0.1
 */