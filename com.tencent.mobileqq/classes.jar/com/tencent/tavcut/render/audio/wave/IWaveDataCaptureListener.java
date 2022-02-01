package com.tencent.tavcut.render.audio.wave;

import androidx.annotation.WorkerThread;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/render/audio/wave/IWaveDataCaptureListener;", "", "onCaptureError", "", "errCode", "", "errMsg", "", "onWaveFormDataCapture", "data", "", "", "onWaveFormDataCaptureFinished", "allData", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public abstract interface IWaveDataCaptureListener
{
  @WorkerThread
  public abstract void a(int paramInt, @NotNull String paramString);
  
  @WorkerThread
  public abstract void a(@NotNull List<Float> paramList);
  
  @WorkerThread
  public abstract void b(@NotNull List<Float> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.audio.wave.IWaveDataCaptureListener
 * JD-Core Version:    0.7.0.1
 */