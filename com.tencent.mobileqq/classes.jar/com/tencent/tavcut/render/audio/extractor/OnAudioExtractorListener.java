package com.tencent.tavcut.render.audio.extractor;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/render/audio/extractor/OnAudioExtractorListener;", "", "onExtractError", "", "errCode", "", "errMsg", "", "onExtractFinish", "audioPath", "onExtractStart", "onExtracting", "progress", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public abstract interface OnAudioExtractorListener
{
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt, @NotNull String paramString);
  
  public abstract void a(@NotNull String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.audio.extractor.OnAudioExtractorListener
 * JD-Core Version:    0.7.0.1
 */