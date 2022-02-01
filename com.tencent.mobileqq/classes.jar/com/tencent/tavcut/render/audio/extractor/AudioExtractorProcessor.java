package com.tencent.tavcut.render.audio.extractor;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/render/audio/extractor/AudioExtractorProcessor;", "Lcom/tencent/tavcut/render/audio/extractor/IAudioExtractorProcessor;", "()V", "extractorMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/tavcut/render/audio/extractor/IAudioExtractor;", "cancelExtractAudio", "", "extractorId", "extractAudioFromRenderData", "clipSourceList", "", "Lcom/tencent/tavcut/model/ClipSource;", "timelineList", "Lcom/tencent/tavcut/composition/model/component/Timeline;", "outputAudioPath", "listener", "Lcom/tencent/tavcut/render/audio/extractor/OnAudioExtractorListener;", "extractAudioFromVideo", "inputVideoPath", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public final class AudioExtractorProcessor
  implements IAudioExtractorProcessor
{
  private final ConcurrentHashMap<String, IAudioExtractor> a = new ConcurrentHashMap();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.audio.extractor.AudioExtractorProcessor
 * JD-Core Version:    0.7.0.1
 */