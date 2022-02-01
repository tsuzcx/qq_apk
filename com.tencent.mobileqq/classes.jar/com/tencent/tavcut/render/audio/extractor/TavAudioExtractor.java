package com.tencent.tavcut.render.audio.extractor;

import com.tencent.tav.asset.Asset;
import com.tencent.tav.core.audio.ExportCallback;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavcut.composition.model.component.TimeRange;
import com.tencent.tavcut.composition.model.component.Timeline;
import com.tencent.tavcut.model.ClipSource;
import com.tencent.tavcut.model.ClipSource.ClipType;
import com.tencent.tavcut.render.util.TavExtractAudioHelper;
import com.tencent.tavcut.utils.TavAssetCreatorKt;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.resource.TAVAssetTrackResource;
import com.tencent.tavkit.composition.resource.TAVImageTrackResource;
import com.tencent.tavkit.composition.resource.TAVResource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.math.MathKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/render/audio/extractor/TavAudioExtractor;", "Lcom/tencent/tavcut/render/audio/extractor/IAudioExtractor;", "()V", "extractorListener", "Lcom/tencent/tavcut/render/audio/extractor/OnAudioExtractorListener;", "tavExtractAudioHelper", "Lcom/tencent/tavcut/render/util/TavExtractAudioHelper;", "cancelExtractAudio", "", "createTavComposition", "Lcom/tencent/tavkit/composition/TAVComposition;", "clipSourceList", "", "Lcom/tencent/tavcut/model/ClipSource;", "listTimeLine", "Lcom/tencent/tavcut/composition/model/component/Timeline;", "extractAudioFromClipSources", "timelineList", "outputAudioPath", "", "listener", "handleExporting", "progress", "", "startExtract", "composition", "Companion", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public final class TavAudioExtractor
  implements IAudioExtractor
{
  public static final TavAudioExtractor.Companion a = new TavAudioExtractor.Companion(null);
  private TavExtractAudioHelper b = new TavExtractAudioHelper();
  private OnAudioExtractorListener c;
  
  private final TAVComposition a(List<ClipSource> paramList, List<Timeline> paramList1)
  {
    List localList = (List)new ArrayList();
    TAVComposition localTAVComposition = new TAVComposition();
    paramList1 = ((Iterable)CollectionsKt.zip((Iterable)paramList, (Iterable)paramList1)).iterator();
    while (paramList1.hasNext())
    {
      paramList = (Pair)paramList1.next();
      Object localObject2 = (ClipSource)paramList.component1();
      Object localObject1 = (Timeline)paramList.component2();
      paramList = ((ClipSource)localObject2).type;
      Object localObject3 = ClipSource.ClipType.VIDEO;
      long l1 = 0L;
      if (paramList == localObject3)
      {
        paramList = ((ClipSource)localObject2).path;
        if (paramList == null) {
          paramList = "";
        }
        paramList = TavAssetCreatorKt.a(paramList);
        if (paramList != null)
        {
          paramList = new TAVAssetTrackResource((Asset)paramList);
          localObject3 = ((ClipSource)localObject2).startOffset;
          long l2;
          if (localObject3 != null) {
            l2 = ((Long)localObject3).longValue();
          } else {
            l2 = 0L;
          }
          paramList.setSourceTimeRange(new CMTimeRange(CMTime.fromUs(l2), CMTime.fromUs(((ClipSource)localObject2).duration)));
          float f2 = (float)((ClipSource)localObject2).duration;
          localObject2 = ((ClipSource)localObject2).speed;
          float f1;
          if (localObject2 != null) {
            f1 = ((Float)localObject2).floatValue();
          } else {
            f1 = 1.0F;
          }
          paramList.setScaledDuration(CMTime.fromUs(MathKt.roundToLong(f2 / f1)));
          paramList = new TAVClip((TAVResource)paramList);
          localObject1 = ((Timeline)localObject1).range;
          if (localObject1 != null) {
            l1 = ((TimeRange)localObject1).startTime;
          }
          paramList.setStartTime(CMTime.fromUs(l1));
          localList.add(paramList);
        }
      }
      else if (((ClipSource)localObject2).type == ClipSource.ClipType.PHOTO)
      {
        paramList = new TAVClip((TAVResource)new TAVImageTrackResource(((ClipSource)localObject2).path, CMTime.fromUs(((ClipSource)localObject2).duration)));
        localObject1 = ((Timeline)localObject1).range;
        if (localObject1 != null) {
          l1 = ((TimeRange)localObject1).startTime;
        }
        paramList.setStartTime(CMTime.fromUs(l1));
        localList.add(paramList);
      }
    }
    localTAVComposition.setOverlays(localList);
    localTAVComposition.setAudios(localList);
    return localTAVComposition;
  }
  
  private final void a(float paramFloat, OnAudioExtractorListener paramOnAudioExtractorListener)
  {
    if (paramFloat < 0)
    {
      if (paramOnAudioExtractorListener != null) {
        paramOnAudioExtractorListener.a(2, "Extractor audio fail");
      }
    }
    else if (paramOnAudioExtractorListener != null) {
      paramOnAudioExtractorListener.a((int)(paramFloat * 100));
    }
  }
  
  private final void a(TAVComposition paramTAVComposition, String paramString)
  {
    this.b.a(paramTAVComposition, paramString, (ExportCallback)new TavAudioExtractor.startExtract.1(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.audio.extractor.TavAudioExtractor
 * JD-Core Version:    0.7.0.1
 */