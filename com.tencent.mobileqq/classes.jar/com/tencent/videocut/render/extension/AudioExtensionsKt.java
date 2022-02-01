package com.tencent.videocut.render.extension;

import com.tencent.tavcut.TavCut;
import com.tencent.tavcut.composition.model.component.AudioSource;
import com.tencent.tavcut.composition.model.component.InputSource;
import com.tencent.tavcut.composition.model.component.TimeRange;
import com.tencent.tavcut.composition.model.component.VolumeEffect;
import com.tencent.tavcut.creator.IComponentCreator;
import com.tencent.tavcut.creator.IEntityCreator;
import com.tencent.tavcut.creator.IInputSourceCreator;
import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import com.tencent.videocut.model.AudioModel;
import com.tencent.videocut.model.AudioModel.VolumeEffect;
import com.tencent.videocut.render.RenderData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"TIME_INVALID", "", "durationInTimeline", "Lcom/tencent/videocut/model/AudioModel;", "getDurationInTimeline", "(Lcom/tencent/videocut/model/AudioModel;)J", "toRenderData", "Lcom/tencent/videocut/render/RenderData;", "qq-wink-impl_release"}, k=2, mv={1, 1, 16})
public final class AudioExtensionsKt
{
  @NotNull
  public static final RenderData a(@NotNull AudioModel paramAudioModel)
  {
    Intrinsics.checkParameterIsNotNull(paramAudioModel, "$this$toRenderData");
    List localList1 = (List)new ArrayList();
    IComponentCreator localIComponentCreator = TavCut.a.e();
    InputSource localInputSource = TavCut.a.f().a(paramAudioModel.id, paramAudioModel.path, new TimeRange(paramAudioModel.selectStartTime, paramAudioModel.selectDuration, null, 4, null));
    List localList2 = (List)new ArrayList();
    long l1 = paramAudioModel.fadeInDuration;
    Object localObject1 = Float.valueOf(0.0F);
    Object localObject2 = Long.valueOf(-2147483648L);
    Long localLong = Long.valueOf(0L);
    float f1;
    if (l1 > 0L)
    {
      f1 = paramAudioModel.volume;
      localList2.add(new VolumeEffect(localLong, (Long)localObject2, Long.valueOf(paramAudioModel.fadeInDuration), (Float)localObject1, Float.valueOf(f1), null, null, 96, null));
    }
    if (paramAudioModel.fadeOutDuration > 0L)
    {
      f1 = paramAudioModel.volume;
      localList2.add(new VolumeEffect((Long)localObject2, localLong, Long.valueOf(paramAudioModel.fadeOutDuration), Float.valueOf(f1), (Float)localObject1, null, null, 96, null));
    }
    localObject1 = ((Iterable)paramAudioModel.volumeEffects).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (AudioModel.VolumeEffect)((Iterator)localObject1).next();
      l1 = ((AudioModel.VolumeEffect)localObject2).startOffsetUs;
      long l2 = ((AudioModel.VolumeEffect)localObject2).endOffsetUs;
      f1 = ((AudioModel.VolumeEffect)localObject2).startVolume;
      float f2 = ((AudioModel.VolumeEffect)localObject2).endVolume;
      localList2.add(new VolumeEffect(Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(((AudioModel.VolumeEffect)localObject2).durationUs), Float.valueOf(f1), Float.valueOf(f2), null, null, 96, null));
    }
    localObject1 = localInputSource.key;
    if (localObject1 == null) {
      localObject1 = "";
    }
    localObject1 = AudioSource.copy$default(localIComponentCreator.a((String)localObject1, paramAudioModel.volume, paramAudioModel.speed), null, null, null, null, null, null, null, null, localList2, null, null, null, 3839, null);
    paramAudioModel = localIComponentCreator.a(paramAudioModel.startTimeInTimeline, b(paramAudioModel));
    localList1.add(new IdentifyComponent(localIComponentCreator.a()));
    localList1.add(new IdentifyComponent(paramAudioModel));
    localList1.add(new IdentifyComponent(localObject1));
    localList1.add(new IdentifyComponent(localIComponentCreator.a("bgm")));
    return new RenderData(TavCut.a.d().a("bgm", localList1), localInputSource, null, 4, null);
  }
  
  public static final long b(@NotNull AudioModel paramAudioModel)
  {
    Intrinsics.checkParameterIsNotNull(paramAudioModel, "$this$durationInTimeline");
    return ((float)paramAudioModel.selectDuration / paramAudioModel.speed);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.render.extension.AudioExtensionsKt
 * JD-Core Version:    0.7.0.1
 */