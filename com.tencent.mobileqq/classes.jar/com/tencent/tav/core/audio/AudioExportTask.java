package com.tencent.tav.core.audio;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.logger.Logger;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class AudioExportTask
  implements IAudioExportTask
{
  private static final String TAG = "AudioEncoderTask";
  private IAudioSource<? extends IDecoderTrack> mAsset;
  private ExportCallback mCallback;
  private CopyOnWriteArrayList<AudioExportRunner> mEncoderList = new CopyOnWriteArrayList();
  private String mOutSavePath;
  private HashMap<Integer, AudioExportTask.SegmentStatus> mProgressMap = new HashMap();
  private int mSegmentCount = 0;
  private String mSessionId = new Random().nextLong() + "";
  
  public AudioExportTask(IAudioSource<? extends IDecoderTrack> paramIAudioSource, String paramString)
  {
    this.mAsset = paramIAudioSource;
    this.mOutSavePath = paramString;
  }
  
  public AudioExportTask(String paramString)
  {
    this.mOutSavePath = paramString;
  }
  
  private AudioExportTask.SegmentStatus createOrUpdateSegmentStatus(int paramInt1, int paramInt2, float paramFloat)
  {
    Logger.d("AudioEncoderTask", "createOrUpdateSegmentStatus index = " + paramInt1 + " mStatus = " + paramInt2 + " mProgress = " + paramFloat);
    if (this.mProgressMap.containsKey(Integer.valueOf(paramInt1)))
    {
      localSegmentStatus = (AudioExportTask.SegmentStatus)this.mProgressMap.get(Integer.valueOf(paramInt1));
      AudioExportTask.SegmentStatus.access$302(localSegmentStatus, paramFloat);
      AudioExportTask.SegmentStatus.access$402(localSegmentStatus, paramInt2);
      return localSegmentStatus;
    }
    AudioExportTask.SegmentStatus localSegmentStatus = new AudioExportTask.SegmentStatus(paramInt2, paramFloat);
    this.mProgressMap.put(Integer.valueOf(paramInt1), localSegmentStatus);
    return localSegmentStatus;
  }
  
  private AudioExportTask.SegmentStatus createSegmentStatus(int paramInt, CMTimeRange paramCMTimeRange)
  {
    AudioExportTask.SegmentStatus localSegmentStatus = new AudioExportTask.SegmentStatus(0, 0.0F);
    AudioExportTask.SegmentStatus.access$002(localSegmentStatus, paramCMTimeRange);
    this.mProgressMap.put(Integer.valueOf(paramInt), localSegmentStatus);
    return localSegmentStatus;
  }
  
  private void exportAudio(CMTimeRange paramCMTimeRange, int paramInt)
  {
    Logger.d("AudioEncoderTask", "exportAudio timeRange = " + paramCMTimeRange + " index = " + paramInt);
    paramCMTimeRange = new AudioExportRunner(this.mAsset, paramCMTimeRange);
    paramCMTimeRange.setSavePath(EncoderUtils.getAudioOutSaveFilePath(this.mOutSavePath, paramInt, this.mSessionId));
    paramCMTimeRange.setCallback(new AudioExportTask.1(this, paramInt));
    try
    {
      paramCMTimeRange.prepare();
      paramCMTimeRange.start();
      this.mEncoderList.add(paramCMTimeRange);
      return;
    }
    catch (IOException paramCMTimeRange)
    {
      Logger.e("AudioEncoderTask", "exportAudio: ", paramCMTimeRange);
    }
  }
  
  private void notifyProgressAndStatusUpdate()
  {
    if (this.mProgressMap.size() == 0) {
      return;
    }
    float f2 = this.mSegmentCount;
    Iterator localIterator = this.mProgressMap.entrySet().iterator();
    int i = 0;
    float f3;
    for (float f1 = 0.0F; localIterator.hasNext(); f1 = f3 + f1)
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      f3 = AudioExportTask.SegmentStatus.access$300((AudioExportTask.SegmentStatus)localEntry.getValue());
      i = AudioExportTask.SegmentStatus.access$400((AudioExportTask.SegmentStatus)localEntry.getValue()) | i;
    }
    f1 /= f2;
    Logger.i("AudioEncoderTask", " mStatus = " + i + " mProgress = " + f1);
    if (i == 255)
    {
      onProgress(255, f1);
      EncoderUtils.deleteAllTmpFiles(this.mOutSavePath, this.mSegmentCount, this.mSessionId);
      new File(this.mOutSavePath).delete();
      return;
    }
    if (i >= 4)
    {
      onProgress(4, f1);
      EncoderUtils.deleteAllTmpFiles(this.mOutSavePath, this.mSegmentCount, this.mSessionId);
      new File(this.mOutSavePath).delete();
      return;
    }
    if (i == 2)
    {
      if (EncoderUtils.mergeAllFiles(this.mOutSavePath, this.mSegmentCount, this.mSessionId)) {
        onProgress(2, 1.0F);
      }
      for (;;)
      {
        EncoderUtils.deleteAllTmpFiles(this.mOutSavePath, this.mSegmentCount, this.mSessionId);
        return;
        onProgress(255, 1.0F);
      }
    }
    if (i >= 1)
    {
      onProgress(1, f1);
      return;
    }
    onProgress(0, f1);
  }
  
  private void onProgress(int paramInt, float paramFloat)
  {
    if (this.mCallback != null) {
      this.mCallback.onProgress(paramInt, paramFloat);
    }
  }
  
  public void cancel()
  {
    Iterator localIterator = this.mEncoderList.iterator();
    while (localIterator.hasNext()) {
      ((AudioExportRunner)localIterator.next()).cancel();
    }
  }
  
  protected CMTime getDuration()
  {
    if (this.mAsset != null) {
      return this.mAsset.getDuration();
    }
    return CMTime.CMTimeZero;
  }
  
  public void setExportCallback(ExportCallback paramExportCallback)
  {
    this.mCallback = paramExportCallback;
  }
  
  public void start()
  {
    int k = 1;
    this.mProgressMap.clear();
    this.mEncoderList.clear();
    long l4 = getDuration().getTimeUs();
    long l1 = AudioExportSession.SEGMENT_DURATION_US;
    this.mSegmentCount = ((int)((l4 + l1 - 1L) / l1));
    if (this.mSegmentCount > AudioExportSession.MAX_THREAD_COUNT)
    {
      this.mSegmentCount = AudioExportSession.MAX_THREAD_COUNT;
      l1 = getDuration().getTimeUs() / this.mSegmentCount;
    }
    long l2 = 0L;
    this.mSessionId = (System.currentTimeMillis() + "");
    int i = 0;
    int j = 1;
    if (i < this.mSegmentCount)
    {
      if (l2 + l1 > l4) {}
      for (long l3 = l4 - l2;; l3 = l1)
      {
        createSegmentStatus(j, new CMTimeRange(CMTime.fromUs(l2), CMTime.fromUs(l3)));
        l2 += l1;
        j += 1;
        i += 1;
        break;
      }
    }
    Iterator localIterator = this.mProgressMap.entrySet().iterator();
    i = k;
    while (localIterator.hasNext())
    {
      exportAudio(AudioExportTask.SegmentStatus.access$000((AudioExportTask.SegmentStatus)((Map.Entry)localIterator.next()).getValue()), i);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.core.audio.AudioExportTask
 * JD-Core Version:    0.7.0.1
 */