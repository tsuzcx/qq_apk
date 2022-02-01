package com.tencent.tavcut.render.audio.wave;

import androidx.collection.LruCache;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tavcut/render/audio/wave/AudioWaveDataManager$decodeForWaveData$2", "Lcom/tencent/tavcut/render/audio/wave/IWaveDataCaptureListener;", "onCaptureError", "", "errCode", "", "errMsg", "", "onWaveFormDataCapture", "data", "", "", "onWaveFormDataCaptureFinished", "allData", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public final class AudioWaveDataManager$decodeForWaveData$2
  implements IWaveDataCaptureListener
{
  public void a(int paramInt, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errMsg");
    AudioWaveDataManager.c(AudioWaveDataManager.a).remove(this.b);
    synchronized (AudioWaveDataManager.a(AudioWaveDataManager.a))
    {
      Object localObject2 = (List)AudioWaveDataManager.b(AudioWaveDataManager.a).remove(this.a);
      if (localObject2 != null)
      {
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((IWaveDataCaptureListener)((Iterator)localObject2).next()).a(paramInt, paramString);
        }
        paramString = Unit.INSTANCE;
      }
      return;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void a(@NotNull List<Float> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "data");
    synchronized (AudioWaveDataManager.a(AudioWaveDataManager.a))
    {
      Object localObject2 = (List)AudioWaveDataManager.b(AudioWaveDataManager.a).get(this.a);
      if (localObject2 != null)
      {
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((IWaveDataCaptureListener)((Iterator)localObject2).next()).a(paramList);
        }
        paramList = Unit.INSTANCE;
      }
      return;
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void b(@NotNull List<Float> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "allData");
    AudioWaveDataManager.c(AudioWaveDataManager.a).remove(this.b);
    synchronized (AudioWaveDataManager.a(AudioWaveDataManager.a))
    {
      Object localObject2 = (List)AudioWaveDataManager.b(AudioWaveDataManager.a).remove(this.a);
      if (localObject2 != null)
      {
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((IWaveDataCaptureListener)((Iterator)localObject2).next()).b(paramList);
        }
      }
      paramList = (Pair)AudioWaveDataManager.d(AudioWaveDataManager.a).put(this.b, new Pair(Integer.valueOf(this.c), paramList));
      return;
    }
    for (;;)
    {
      throw paramList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.audio.wave.AudioWaveDataManager.decodeForWaveData.2
 * JD-Core Version:    0.7.0.1
 */