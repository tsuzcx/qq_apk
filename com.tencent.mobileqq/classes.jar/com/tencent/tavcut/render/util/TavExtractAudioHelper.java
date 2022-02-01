package com.tencent.tavcut.render.util;

import com.tencent.tav.core.audio.AudioExportSession;
import com.tencent.tav.core.audio.ExportCallback;
import com.tencent.tav.core.audio.IAudioExportTask;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavcut.render.log.TavLogger;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.tavkit.composition.builder.TAVCompositionBuilder;
import com.tencent.tavkit.composition.model.TAVVideo;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/render/util/TavExtractAudioHelper;", "", "()V", "exportTask", "Lcom/tencent/tav/core/audio/IAudioExportTask;", "cancelExtract", "", "configExtractAudioSegmentDuration", "composition", "Lcom/tencent/tavkit/composition/TAVComposition;", "extractSingleAudioByComposition", "exportPath", "", "exportListener", "Lcom/tencent/tav/core/audio/ExportCallback;", "Companion", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public final class TavExtractAudioHelper
{
  public static final TavExtractAudioHelper.Companion a = new TavExtractAudioHelper.Companion(null);
  private IAudioExportTask b;
  
  public TavExtractAudioHelper()
  {
    AudioExportSession.MAX_THREAD_COUNT = 3;
  }
  
  private final void a(TAVComposition paramTAVComposition)
  {
    paramTAVComposition = paramTAVComposition.getOverlays();
    Intrinsics.checkExpressionValueIsNotNull(paramTAVComposition, "composition.overlays");
    Iterator localIterator = ((Iterable)paramTAVComposition).iterator();
    Object localObject1;
    long l1;
    long l2;
    if (!localIterator.hasNext())
    {
      paramTAVComposition = null;
    }
    else
    {
      paramTAVComposition = localIterator.next();
      if (localIterator.hasNext())
      {
        localObject1 = (TAVVideo)paramTAVComposition;
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "it");
        Object localObject2 = ((TAVVideo)localObject1).getStartTime();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "it.startTime");
        l1 = ((CMTime)localObject2).getTimeUs();
        localObject1 = ((TAVVideo)localObject1).getDuration();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "it.duration");
        l1 += ((CMTime)localObject1).getTimeUs();
        localObject1 = paramTAVComposition;
        do
        {
          localObject2 = localIterator.next();
          paramTAVComposition = (TAVVideo)localObject2;
          Intrinsics.checkExpressionValueIsNotNull(paramTAVComposition, "it");
          CMTime localCMTime = paramTAVComposition.getStartTime();
          Intrinsics.checkExpressionValueIsNotNull(localCMTime, "it.startTime");
          l2 = localCMTime.getTimeUs();
          paramTAVComposition = paramTAVComposition.getDuration();
          Intrinsics.checkExpressionValueIsNotNull(paramTAVComposition, "it.duration");
          long l3 = l2 + paramTAVComposition.getTimeUs();
          paramTAVComposition = (TAVComposition)localObject1;
          l2 = l1;
          if (l1 < l3)
          {
            paramTAVComposition = (TAVComposition)localObject2;
            l2 = l3;
          }
          localObject1 = paramTAVComposition;
          l1 = l2;
        } while (localIterator.hasNext());
      }
    }
    paramTAVComposition = (TAVVideo)paramTAVComposition;
    if (paramTAVComposition != null)
    {
      localObject1 = paramTAVComposition.getDuration();
      l1 = 0L;
      l2 = l1;
      if (localObject1 != null)
      {
        l2 = ((CMTime)localObject1).getTimeUs();
        paramTAVComposition = paramTAVComposition.getStartTime();
        if (paramTAVComposition != null) {
          l1 = paramTAVComposition.getTimeUs();
        }
        l2 = l1 + l2;
      }
      if (l2 <= 5000000) {
        AudioExportSession.SEGMENT_DURATION_US = (int)l2;
      } else if (l2 < 50000000) {
        AudioExportSession.SEGMENT_DURATION_US = 5000000;
      } else {
        AudioExportSession.SEGMENT_DURATION_US = (int)(l2 / 10);
      }
      paramTAVComposition = new StringBuilder();
      paramTAVComposition.append("configExtractAudioSegmentDuration config:");
      paramTAVComposition.append(AudioExportSession.SEGMENT_DURATION_US);
      TavLogger.b("ExtractAudioUtils", paramTAVComposition.toString());
    }
  }
  
  public final void a(@NotNull TAVComposition paramTAVComposition, @NotNull String paramString, @NotNull ExportCallback paramExportCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramTAVComposition, "composition");
    Intrinsics.checkParameterIsNotNull(paramString, "exportPath");
    Intrinsics.checkParameterIsNotNull(paramExportCallback, "exportListener");
    a(paramTAVComposition);
    paramTAVComposition = new TAVCompositionBuilder(paramTAVComposition).buildSource();
    Intrinsics.checkExpressionValueIsNotNull(paramTAVComposition, "builder.buildSource()");
    this.b = AudioExportSession.generateAudioAssetExportTask(paramTAVComposition.getAsset(), paramString);
    paramTAVComposition = this.b;
    if (paramTAVComposition != null) {
      paramTAVComposition.setExportCallback(paramExportCallback);
    }
    paramTAVComposition = this.b;
    if (paramTAVComposition != null) {
      paramTAVComposition.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.util.TavExtractAudioHelper
 * JD-Core Version:    0.7.0.1
 */