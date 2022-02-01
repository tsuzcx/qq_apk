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
  private CopyOnWriteArrayList<AudioExportRunner> mEncoderList;
  private String mOutSavePath;
  private HashMap<Integer, AudioExportTask.SegmentStatus> mProgressMap;
  private int mSegmentCount = 0;
  private String mSessionId;
  
  public AudioExportTask(IAudioSource<? extends IDecoderTrack> paramIAudioSource, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(new Random().nextLong());
    localStringBuilder.append("");
    this.mSessionId = localStringBuilder.toString();
    this.mEncoderList = new CopyOnWriteArrayList();
    this.mProgressMap = new HashMap();
    this.mAsset = paramIAudioSource;
    this.mOutSavePath = paramString;
  }
  
  public AudioExportTask(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(new Random().nextLong());
    localStringBuilder.append("");
    this.mSessionId = localStringBuilder.toString();
    this.mEncoderList = new CopyOnWriteArrayList();
    this.mProgressMap = new HashMap();
    this.mOutSavePath = paramString;
  }
  
  private AudioExportTask.SegmentStatus createOrUpdateSegmentStatus(int paramInt1, int paramInt2, float paramFloat)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("createOrUpdateSegmentStatus index = ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" mStatus = ");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(" mProgress = ");
    ((StringBuilder)localObject).append(paramFloat);
    Logger.d("AudioEncoderTask", ((StringBuilder)localObject).toString());
    if (this.mProgressMap.containsKey(Integer.valueOf(paramInt1)))
    {
      localObject = (AudioExportTask.SegmentStatus)this.mProgressMap.get(Integer.valueOf(paramInt1));
      AudioExportTask.SegmentStatus.access$302((AudioExportTask.SegmentStatus)localObject, paramFloat);
      AudioExportTask.SegmentStatus.access$402((AudioExportTask.SegmentStatus)localObject, paramInt2);
      return localObject;
    }
    localObject = new AudioExportTask.SegmentStatus(paramInt2, paramFloat);
    this.mProgressMap.put(Integer.valueOf(paramInt1), localObject);
    return localObject;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("exportAudio timeRange = ");
    localStringBuilder.append(paramCMTimeRange);
    localStringBuilder.append(" index = ");
    localStringBuilder.append(paramInt);
    Logger.d("AudioEncoderTask", localStringBuilder.toString());
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
    catch (Exception paramCMTimeRange)
    {
      Logger.e("AudioEncoderTask", "exportAudio: 未知异常，请留意", paramCMTimeRange);
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
    float f1 = 0.0F;
    float f2 = this.mSegmentCount;
    Object localObject = this.mProgressMap.entrySet().iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      f1 += AudioExportTask.SegmentStatus.access$300((AudioExportTask.SegmentStatus)localEntry.getValue());
      i |= AudioExportTask.SegmentStatus.access$400((AudioExportTask.SegmentStatus)localEntry.getValue());
    }
    f1 /= f2;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" mStatus = ");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(" mProgress = ");
    ((StringBuilder)localObject).append(f1);
    Logger.i("AudioEncoderTask", ((StringBuilder)localObject).toString());
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
      } else {
        onProgress(255, 1.0F);
      }
      EncoderUtils.deleteAllTmpFiles(this.mOutSavePath, this.mSegmentCount, this.mSessionId);
      return;
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
    ExportCallback localExportCallback = this.mCallback;
    if (localExportCallback != null) {
      localExportCallback.onProgress(paramInt, paramFloat);
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
    IAudioSource localIAudioSource = this.mAsset;
    if (localIAudioSource != null) {
      return localIAudioSource.getDuration();
    }
    return CMTime.CMTimeZero;
  }
  
  public void setExportCallback(ExportCallback paramExportCallback)
  {
    this.mCallback = paramExportCallback;
  }
  
  public void start()
  {
    this.mProgressMap.clear();
    this.mEncoderList.clear();
    long l5 = getDuration().getTimeUs();
    long l1 = AudioExportSession.SEGMENT_DURATION_US;
    this.mSegmentCount = ((int)((l5 + l1 - 1L) / l1));
    if (this.mSegmentCount > AudioExportSession.MAX_THREAD_COUNT)
    {
      this.mSegmentCount = AudioExportSession.MAX_THREAD_COUNT;
      l1 = getDuration().getTimeUs() / this.mSegmentCount;
    }
    long l2 = 0L;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    ((StringBuilder)localObject).append("");
    this.mSessionId = ((StringBuilder)localObject).toString();
    int i = 0;
    int j = 1;
    while (i < this.mSegmentCount)
    {
      long l4 = l2 + l1;
      long l3;
      if (l4 > l5) {
        l3 = l5 - l2;
      } else {
        l3 = l1;
      }
      createSegmentStatus(j, new CMTimeRange(CMTime.fromUs(l2), CMTime.fromUs(l3)));
      j += 1;
      i += 1;
      l2 = l4;
    }
    localObject = this.mProgressMap.entrySet().iterator();
    i = 1;
    while (((Iterator)localObject).hasNext())
    {
      exportAudio(AudioExportTask.SegmentStatus.access$000((AudioExportTask.SegmentStatus)((Map.Entry)((Iterator)localObject).next()).getValue()), i);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tav.core.audio.AudioExportTask
 * JD-Core Version:    0.7.0.1
 */