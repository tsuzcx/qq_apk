package com.tencent.ttpic.voicechanger.common.audio;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import com.tencent.ttpic.baseutils.api.ApiHelper;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.io.IOException;
import java.nio.ByteBuffer;

@TargetApi(18)
public class RealTimePcmPacker
{
  private static final int CODEC_TIMEOUT = 5000;
  private static final String COMPRESSED_AUDIO_FILE_MIME_TYPE = "audio/mp4a-latm";
  private static final String TAG = "RealTimePcmPacker";
  private int audioTrackId;
  private int bitrate;
  private MediaCodec.BufferInfo bufferInfo;
  private int channelCount;
  private ByteBuffer[] codecInputBuffers;
  private ByteBuffer[] codecOutputBuffers;
  private int frameByteLength;
  private boolean isMediaMuxerStart = false;
  private MediaCodec mediaCodec;
  private MediaFormat mediaFormat;
  private MediaMuxer mediaMuxer;
  private String outputPath;
  private double presentationTimeUs;
  private int sampleRate;
  private int totalBytesRead;
  
  public RealTimePcmPacker(int paramInt1, int paramInt2, int paramInt3)
  {
    this.bitrate = paramInt1;
    this.sampleRate = paramInt2;
    this.channelCount = paramInt3;
    double d = paramInt2;
    Double.isNaN(d);
    this.frameByteLength = ((int)(d * 0.02D * 2.0D));
  }
  
  private void handleEndOfStream()
  {
    MediaCodec localMediaCodec = this.mediaCodec;
    if (localMediaCodec == null) {
      return;
    }
    int i = localMediaCodec.dequeueInputBuffer(5000L);
    if (i <= 0) {
      return;
    }
    this.mediaCodec.queueInputBuffer(i, 0, 0, this.presentationTimeUs, 4);
    writeOutputs();
  }
  
  private void tryStartMediaMuxer()
  {
    if (!this.isMediaMuxerStart)
    {
      MediaCodec localMediaCodec = this.mediaCodec;
      if ((localMediaCodec != null) && (this.mediaMuxer != null))
      {
        this.mediaFormat = localMediaCodec.getOutputFormat();
        this.audioTrackId = this.mediaMuxer.addTrack(this.mediaFormat);
        this.mediaMuxer.start();
        this.isMediaMuxerStart = true;
      }
    }
  }
  
  private void writeOutputs()
  {
    Object localObject1 = this.mediaCodec;
    if (localObject1 == null) {
      return;
    }
    try
    {
      this.codecOutputBuffers = ((MediaCodec)localObject1).getOutputBuffers();
      Object localObject2;
      for (;;)
      {
        int i = this.mediaCodec.dequeueOutputBuffer(this.bufferInfo, 0L);
        localObject1 = TAG;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("dequeue & queue - dequeueOutput(");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append(")");
        LogUtils.d((String)localObject1, ((StringBuilder)localObject2).toString());
        if (i == -1)
        {
          LogUtils.e(TAG, "获得编码器输出缓存区超时");
          return;
        }
        if (i == -3)
        {
          if (ApiHelper.hasLollipop()) {
            break;
          }
          this.codecOutputBuffers = this.mediaCodec.getOutputBuffers();
          return;
        }
        if (i == -2)
        {
          tryStartMediaMuxer();
          LogUtils.i(TAG, "编码器输出缓存区格式改变，添加视频轨道到混合器");
          return;
        }
        if (i >= 0)
        {
          if (!ApiHelper.hasLollipop()) {
            localObject1 = this.codecOutputBuffers[i];
          } else {
            localObject1 = this.mediaCodec.getOutputBuffer(i);
          }
          if (this.bufferInfo.size != 0)
          {
            if (!this.isMediaMuxerStart)
            {
              LogUtils.e(TAG, "muxer hasn't started");
              this.mediaCodec.releaseOutputBuffer(i, false);
            }
            else
            {
              if (ApiHelper.hasKitkat())
              {
                ((ByteBuffer)localObject1).position(this.bufferInfo.offset);
                ((ByteBuffer)localObject1).limit(this.bufferInfo.offset + this.bufferInfo.size);
              }
              this.mediaMuxer.writeSampleData(this.audioTrackId, this.codecOutputBuffers[i], this.bufferInfo);
              this.mediaCodec.releaseOutputBuffer(i, false);
              localObject1 = TAG;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("dequeue & queue - releaseOutput(");
              ((StringBuilder)localObject2).append(i);
              ((StringBuilder)localObject2).append(")");
              LogUtils.d((String)localObject1, ((StringBuilder)localObject2).toString());
            }
          }
          else
          {
            if ((this.bufferInfo.flags & 0x2) != 0) {
              return;
            }
            localObject1 = TAG;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("writeOutputs:() - while - index = ");
            ((StringBuilder)localObject2).append(i);
            LogUtils.d((String)localObject1, ((StringBuilder)localObject2).toString());
          }
        }
      }
      StringBuilder localStringBuilder;
      return;
    }
    catch (Exception localException)
    {
      LogUtils.e(TAG, localException);
      localObject2 = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("合成时发生异常：");
      localStringBuilder.append(localException.getMessage());
      Log.e((String)localObject2, localStringBuilder.toString());
    }
  }
  
  public void encodeBytes(byte[] paramArrayOfByte)
  {
    Object localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Starting encoding 1 batch: length = ");
    localStringBuilder.append(paramArrayOfByte.length);
    localStringBuilder.append("; timestamp = ");
    localStringBuilder.append(this.presentationTimeUs);
    LogUtils.d((String)localObject, localStringBuilder.toString());
    localObject = this.mediaCodec;
    if (localObject != null)
    {
      if (this.mediaMuxer == null) {
        return;
      }
      this.codecInputBuffers = ((MediaCodec)localObject).getInputBuffers();
      int i = this.mediaCodec.dequeueInputBuffer(0L);
      localObject = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("dequeue & queue - dequeueInput(");
      localStringBuilder.append(i);
      localStringBuilder.append(")");
      LogUtils.d((String)localObject, localStringBuilder.toString());
      if (i >= 0)
      {
        if (!ApiHelper.hasLollipop()) {
          localObject = this.codecInputBuffers[i];
        } else {
          localObject = this.mediaCodec.getInputBuffer(i);
        }
        ((ByteBuffer)localObject).clear();
        ((ByteBuffer)localObject).put(paramArrayOfByte);
        this.mediaCodec.queueInputBuffer(i, 0, paramArrayOfByte.length, this.presentationTimeUs, 0);
        writeOutputs();
        localObject = TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("dequeue & queue - queueInput(");
        localStringBuilder.append(i);
        localStringBuilder.append(")");
        LogUtils.d((String)localObject, localStringBuilder.toString());
      }
      this.totalBytesRead += paramArrayOfByte.length;
      this.presentationTimeUs = (this.totalBytesRead / 2 * 1000000L / this.sampleRate);
      LogUtils.d(TAG, "Finished encoding 1 frame");
    }
  }
  
  public void prepare()
  {
    if (this.outputPath != null) {
      try
      {
        this.mediaFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", this.sampleRate, this.channelCount);
        this.mediaFormat.setInteger("aac-profile", 2);
        this.mediaFormat.setInteger("bitrate", this.bitrate);
        this.mediaFormat.setInteger("max-input-size", 1048576);
        this.mediaCodec = MediaCodec.createEncoderByType("audio/mp4a-latm");
        this.mediaCodec.configure(this.mediaFormat, null, null, 1);
        this.mediaCodec.start();
        this.codecInputBuffers = this.mediaCodec.getInputBuffers();
        this.codecOutputBuffers = this.mediaCodec.getOutputBuffers();
        this.bufferInfo = new MediaCodec.BufferInfo();
        this.mediaMuxer = new MediaMuxer(this.outputPath, 0);
        this.totalBytesRead = 0;
        this.presentationTimeUs = 0.0D;
        return;
      }
      catch (IOException localIOException)
      {
        LogUtils.e(TAG, "Exception while initializing PCMEncoder", localIOException, new Object[0]);
        return;
      }
    }
    throw new IllegalStateException("The output path must be set first!");
  }
  
  public void setOutputPath(String paramString)
  {
    this.outputPath = paramString;
  }
  
  public void stop()
  {
    LogUtils.d(TAG, "Stopping PCMEncoder");
    handleEndOfStream();
    try
    {
      if (this.mediaCodec != null)
      {
        this.mediaCodec.stop();
        this.mediaCodec.release();
      }
      if (this.mediaMuxer != null)
      {
        this.mediaMuxer.stop();
        this.mediaMuxer.release();
        return;
      }
    }
    catch (Exception localException)
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Stop audio mediaCodec & mediaMuxer ERROR: ");
      localStringBuilder.append(localException.getMessage());
      LogUtils.e(str, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.voicechanger.common.audio.RealTimePcmPacker
 * JD-Core Version:    0.7.0.1
 */