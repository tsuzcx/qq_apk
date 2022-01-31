package com.tencent.tavkit.composition.builder;

import android.support.annotation.NonNull;
import com.tencent.tav.asset.CompositionTrack;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.video.TAVVideoCompositionInstruction;
import com.tencent.tavkit.composition.video.TAVVideoCompositionLayerInstruction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

class VideoInstructionsBuilder
{
  private final BuilderModel builderModel;
  private final List<TAVVideoCompositionInstruction> outputInstructions;
  
  VideoInstructionsBuilder(BuilderModel paramBuilderModel)
  {
    this.builderModel = paramBuilderModel;
    this.outputInstructions = new ArrayList();
  }
  
  @NonNull
  private TAVVideoCompositionInstruction buildInstruction(VideoInstructionsBuilder.Slice paramSlice, List<TAVVideoCompositionLayerInstruction> paramList, List<List<TAVVideoCompositionLayerInstruction>> paramList1)
  {
    TAVVideoCompositionInstruction localTAVVideoCompositionInstruction = new TAVVideoCompositionInstruction(trackIDsByLayers(VideoInstructionsBuilder.Slice.access$000(paramSlice)), VideoInstructionsBuilder.Slice.access$100(paramSlice));
    localTAVVideoCompositionInstruction.setChannelLayers(selectChannels(paramList1, VideoInstructionsBuilder.Slice.access$000(paramSlice)));
    localTAVVideoCompositionInstruction.setOverlayLayers(selectLayers(paramList, VideoInstructionsBuilder.Slice.access$000(paramSlice)));
    localTAVVideoCompositionInstruction.setBackgroundColor(this.builderModel.getBackgroundColor());
    localTAVVideoCompositionInstruction.setGlobalVideoEffect(this.builderModel.getTavComposition().getGlobalVideoEffect());
    localTAVVideoCompositionInstruction.setVideoMixEffect(this.builderModel.getTavComposition().getVideoMixEffect());
    localTAVVideoCompositionInstruction.setSourceVideoEffect(this.builderModel.getTavComposition().getSourceVideoEffect());
    return localTAVVideoCompositionInstruction;
  }
  
  private void buildInstructions(List<List<TAVVideoCompositionLayerInstruction>> paramList, List<TAVVideoCompositionLayerInstruction> paramList1, List<VideoInstructionsBuilder.Slice> paramList2)
  {
    paramList2 = paramList2.iterator();
    while (paramList2.hasNext())
    {
      TAVVideoCompositionInstruction localTAVVideoCompositionInstruction = buildInstruction((VideoInstructionsBuilder.Slice)paramList2.next(), paramList1, paramList);
      this.outputInstructions.add(localTAVVideoCompositionInstruction);
    }
  }
  
  private static List<VideoInstructionsBuilder.Slice> calculateSlicesForLayerInstructions(List<TAVVideoCompositionLayerInstruction> paramList)
  {
    Object localObject2 = new TreeSet(new VideoInstructionsBuilder.1());
    Object localObject1 = paramList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (TAVVideoCompositionLayerInstruction)((Iterator)localObject1).next();
      ((TreeSet)localObject2).add(((TAVVideoCompositionLayerInstruction)localObject3).getTimeRange().getStart());
      ((TreeSet)localObject2).add(((TAVVideoCompositionLayerInstruction)localObject3).getTimeRange().getEnd());
    }
    Object localObject3 = new ArrayList();
    localObject1 = (CMTime)((TreeSet)localObject2).pollFirst();
    Iterator localIterator1 = ((TreeSet)localObject2).iterator();
    while (localIterator1.hasNext())
    {
      localObject2 = (CMTime)localIterator1.next();
      CMTimeRange localCMTimeRange = new CMTimeRange((CMTime)localObject1, ((CMTime)localObject2).sub((CMTime)localObject1));
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator2 = paramList.iterator();
      while (localIterator2.hasNext())
      {
        TAVVideoCompositionLayerInstruction localTAVVideoCompositionLayerInstruction = (TAVVideoCompositionLayerInstruction)localIterator2.next();
        if ((localTAVVideoCompositionLayerInstruction.getTimeRange().getEnd().getTimeUs() >= ((CMTime)localObject1).getTimeUs()) && (localTAVVideoCompositionLayerInstruction.getTimeRange().getStart().getTimeUs() <= ((CMTime)localObject2).getTimeUs())) {
          localArrayList.add(localTAVVideoCompositionLayerInstruction);
        }
      }
      ((ArrayList)localObject3).add(new VideoInstructionsBuilder.Slice(localCMTimeRange, localArrayList));
      localObject1 = localObject2;
    }
    return localObject3;
  }
  
  @NonNull
  private List<TAVVideoCompositionLayerInstruction> concatAndSortLayers(List<List<TAVVideoCompositionLayerInstruction>> paramList, List<TAVVideoCompositionLayerInstruction> paramList1)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.addAll((List)paramList.next());
    }
    localArrayList.addAll(paramList1);
    Collections.sort(localArrayList, new VideoInstructionsBuilder.2(this));
    return localArrayList;
  }
  
  private void fixLastLayerDuration(List<List<TAVVideoCompositionLayerInstruction>> paramList)
  {
    if ((paramList == null) || (paramList.size() != 1)) {}
    do
    {
      return;
      paramList = (List)paramList.get(0);
    } while ((paramList == null) || (paramList.isEmpty()));
    TAVVideoCompositionLayerInstruction localTAVVideoCompositionLayerInstruction = (TAVVideoCompositionLayerInstruction)paramList.get(paramList.size() - 1);
    CMTime localCMTime = this.builderModel.getTavComposition().getFrameDuration();
    paramList = localCMTime;
    if (localCMTime == null) {
      paramList = new CMTime(1L, 30);
    }
    localTAVVideoCompositionLayerInstruction.setTimeRange(new CMTimeRange(localTAVVideoCompositionLayerInstruction.getTimeRange().getStart(), localTAVVideoCompositionLayerInstruction.getTimeRange().getDuration().add(paramList)));
  }
  
  @NonNull
  private List<List<TAVVideoCompositionLayerInstruction>> selectChannels(List<List<TAVVideoCompositionLayerInstruction>> paramList, List<TAVVideoCompositionLayerInstruction> paramList1)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      List localList = selectLayers(paramList1, (List)paramList.next());
      if (localList.size() > 0) {
        localArrayList.add(localList);
      }
    }
    return localArrayList;
  }
  
  @NonNull
  private List<TAVVideoCompositionLayerInstruction> selectLayers(List<TAVVideoCompositionLayerInstruction> paramList1, List<TAVVideoCompositionLayerInstruction> paramList2)
  {
    ArrayList localArrayList = new ArrayList();
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      TAVVideoCompositionLayerInstruction localTAVVideoCompositionLayerInstruction = (TAVVideoCompositionLayerInstruction)paramList1.next();
      if (paramList2.contains(localTAVVideoCompositionLayerInstruction)) {
        localArrayList.add(localTAVVideoCompositionLayerInstruction);
      }
    }
    return localArrayList;
  }
  
  @NonNull
  private List<Integer> trackIDsByLayers(List<TAVVideoCompositionLayerInstruction> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(Integer.valueOf(((TAVVideoCompositionLayerInstruction)paramList.next()).getTrackID()));
    }
    return localArrayList;
  }
  
  List<TAVVideoCompositionInstruction> build()
  {
    List localList1 = buildMainLayerInstructions();
    List localList2 = buildOverlayLayerInstructions();
    buildInstructions(localList1, localList2, calculateSlicesForLayerInstructions(concatAndSortLayers(localList1, localList2)));
    return this.outputInstructions;
  }
  
  List<List<TAVVideoCompositionLayerInstruction>> buildMainLayerInstructions()
  {
    ArrayList localArrayList1 = new ArrayList();
    Iterator localIterator = this.builderModel.getMainVideoTrackInfo().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (List)localIterator.next();
      ArrayList localArrayList2 = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        VideoInfo localVideoInfo = (VideoInfo)((Iterator)localObject).next();
        localArrayList2.add(new TAVVideoCompositionLayerInstruction(localVideoInfo.compositionTrack.getTrackID(), localVideoInfo.clip));
      }
      localArrayList1.add(localArrayList2);
    }
    fixLastLayerDuration(localArrayList1);
    return localArrayList1;
  }
  
  List<TAVVideoCompositionLayerInstruction> buildOverlayLayerInstructions()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.builderModel.getOverlayTrackInfo().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((VideoOverlayInfo)localIterator.next()).convertToLayerInstruction());
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavkit.composition.builder.VideoInstructionsBuilder
 * JD-Core Version:    0.7.0.1
 */