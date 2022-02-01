package com.tencent.tavcut.render.audio.extractor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tavcut/render/audio/extractor/AudioExtractorProcessor$extractAudioFromVideo$1", "Lcom/tencent/tavcut/render/audio/extractor/OnAudioExtractorListener;", "onExtractError", "", "errCode", "", "errMsg", "", "onExtractFinish", "audioPath", "onExtractStart", "onExtracting", "progress", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public final class AudioExtractorProcessor$extractAudioFromVideo$1
  implements OnAudioExtractorListener
{
  public void a()
  {
    ((Map)AudioExtractorProcessor.a(this.a)).put(this.b, this.d);
    this.c.a();
  }
  
  public void a(int paramInt)
  {
    if (AudioExtractorProcessor.a(this.a).containsKey(this.b)) {
      this.c.a(paramInt);
    }
  }
  
  public void a(int paramInt, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errMsg");
    AudioExtractorProcessor.a(this.a).remove(this.b);
    this.c.a(paramInt, paramString);
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "audioPath");
    AudioExtractorProcessor.a(this.a).remove(this.b);
    this.c.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.audio.extractor.AudioExtractorProcessor.extractAudioFromVideo.1
 * JD-Core Version:    0.7.0.1
 */