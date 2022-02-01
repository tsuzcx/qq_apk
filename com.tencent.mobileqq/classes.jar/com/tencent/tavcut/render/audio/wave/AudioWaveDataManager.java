package com.tencent.tavcut.render.audio.wave;

import androidx.collection.LruCache;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/render/audio/wave/AudioWaveDataManager;", "Lcom/tencent/tavcut/render/audio/wave/IAudioWaveDataManager;", "()V", "MAX_CACHE_SIZE", "", "decoderMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lkotlin/Pair;", "Lcom/tencent/tavcut/render/audio/wave/IAudioWaveDataProcessor;", "listenerMap", "", "Lcom/tencent/tavcut/render/audio/wave/IWaveDataCaptureListener;", "lock", "", "waveDataMemCache", "Landroidx/collection/LruCache;", "", "decodeForWaveData", "", "audioPath", "perSecondSampleCnt", "gapDurationUs", "", "listener", "getWaveData", "getWaveDataByCache", "removeListener", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public final class AudioWaveDataManager
  implements IAudioWaveDataManager
{
  public static final AudioWaveDataManager a = new AudioWaveDataManager();
  private static final LruCache<String, Pair<Integer, List<Float>>> c = new LruCache(20);
  private static final ConcurrentHashMap<Pair<String, Integer>, List<IWaveDataCaptureListener>> d = new ConcurrentHashMap();
  private static final ConcurrentHashMap<String, Pair<Integer, IAudioWaveDataProcessor>> e = new ConcurrentHashMap();
  private static final Object f = new Object();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.audio.wave.AudioWaveDataManager
 * JD-Core Version:    0.7.0.1
 */