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
  private static final String TAG = RealTimePcmPacker.class.getSimpleName();
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
    this.frameByteLength = ((int)(paramInt2 * 0.02D * 2.0D));
  }
  
  private void handleEndOfStream()
  {
    if (this.mediaCodec == null) {}
    int i;
    do
    {
      return;
      i = this.mediaCodec.dequeueInputBuffer(5000L);
    } while (i <= 0);
    this.mediaCodec.queueInputBuffer(i, 0, 0, this.presentationTimeUs, 4);
    writeOutputs();
  }
  
  private void tryStartMediaMuxer()
  {
    if ((!this.isMediaMuxerStart) && (this.mediaCodec != null) && (this.mediaMuxer != null))
    {
      this.mediaFormat = this.mediaCodec.getOutputFormat();
      this.audioTrackId = this.mediaMuxer.addTrack(this.mediaFormat);
      this.mediaMuxer.start();
      this.isMediaMuxerStart = true;
    }
  }
  
  private void writeOutputs()
  {
    if (this.mediaCodec == null) {
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        this.codecOutputBuffers = this.mediaCodec.getOutputBuffers();
        i = this.mediaCodec.dequeueOutputBuffer(this.bufferInfo, 0L);
        LogUtils.d(TAG, "dequeue & queue - dequeueOutput(" + i + ")");
        if (i == -1)
        {
          LogUtils.e(TAG, "获得编码器输出缓存区超时");
          return;
        }
      }
      catch (Exception localException)
      {
        LogUtils.e(TAG, localException);
        Log.e(TAG, "合成时发生异常：" + localException.getMessage());
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
        ByteBuffer localByteBuffer;
        if (!ApiHelper.hasLollipop()) {
          localByteBuffer = this.codecOutputBuffers[i];
        }
        for (;;)
        {
          if (this.bufferInfo.size != 0)
          {
            if (!this.isMediaMuxerStart)
            {
              LogUtils.e(TAG, "muxer hasn't started");
              this.mediaCodec.releaseOutputBuffer(i, false);
              break;
              localByteBuffer = this.mediaCodec.getOutputBuffer(i);
              continue;
            }
            if (ApiHelper.hasKitkat())
            {
              localByteBuffer.position(this.bufferInfo.offset);
              localByteBuffer.limit(this.bufferInfo.offset + this.bufferInfo.size);
            }
            this.mediaMuxer.writeSampleData(this.audioTrackId, this.codecOutputBuffers[i], this.bufferInfo);
            this.mediaCodec.releaseOutputBuffer(i, false);
            LogUtils.d(TAG, "dequeue & queue - releaseOutput(" + i + ")");
          }
        }
        if ((this.bufferInfo.flags & 0x2) != 0) {
          break;
        }
        LogUtils.d(TAG, "writeOutputs:() - while - index = " + i);
      }
    }
  }
  
  public void encodeBytes(byte[] paramArrayOfByte)
  {
    LogUtils.d(TAG, "Starting encoding 1 batch: length = " + paramArrayOfByte.length + "; timestamp = " + this.presentationTimeUs);
    if ((this.mediaCodec == null) || (this.mediaMuxer == null)) {
      return;
    }
    this.codecInputBuffers = this.mediaCodec.getInputBuffers();
    int i = this.mediaCodec.dequeueInputBuffer(0L);
    LogUtils.d(TAG, "dequeue & queue - dequeueInput(" + i + ")");
    if (i >= 0) {
      if (ApiHelper.hasLollipop()) {
        break label224;
      }
    }
    label224:
    for (ByteBuffer localByteBuffer = this.codecInputBuffers[i];; localByteBuffer = this.mediaCodec.getInputBuffer(i))
    {
      localByteBuffer.clear();
      localByteBuffer.put(paramArrayOfByte);
      this.mediaCodec.queueInputBuffer(i, 0, paramArrayOfByte.length, this.presentationTimeUs, 0);
      writeOutputs();
      LogUtils.d(TAG, "dequeue & queue - queueInput(" + i + ")");
      this.totalBytesRead += paramArrayOfByte.length;
      this.presentationTimeUs = (1000000L * (this.totalBytesRead / 2) / this.sampleRate);
      LogUtils.d(TAG, "Finished encoding 1 frame");
      return;
    }
  }
  
  public void prepare()
  {
    if (this.outputPath == null) {
      throw new IllegalStateException("The output path must be set first!");
    }
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
    }
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
      }
      return;
    }
    catch (Exception localException)
    {
      LogUtils.e(TAG, "Stop audio mediaCodec & mediaMuxer ERROR: " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.voicechanger.common.audio.RealTimePcmPacker
 * JD-Core Version:    0.7.0.1
 */