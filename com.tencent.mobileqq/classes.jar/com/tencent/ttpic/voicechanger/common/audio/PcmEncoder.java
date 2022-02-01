package com.tencent.ttpic.voicechanger.common.audio;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Build.VERSION;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

@TargetApi(18)
public class PcmEncoder
{
  private static final int CODEC_TIMEOUT = 5000;
  private static final String COMPRESSED_AUDIO_FILE_MIME_TYPE = "audio/mp4a-latm";
  private static final String TAG = "PcmEncoder";
  private int audioTrackId;
  private int bitrate;
  private MediaCodec.BufferInfo bufferInfo;
  private int channelCount;
  private ByteBuffer[] codecInputBuffers;
  private ByteBuffer[] codecOutputBuffers;
  private MediaCodec mediaCodec;
  private MediaFormat mediaFormat;
  private MediaMuxer mediaMuxer;
  private String outputPath;
  private double presentationTimeUs;
  private int sampleRate;
  private int totalBytesRead;
  
  public PcmEncoder(int paramInt1, int paramInt2, int paramInt3)
  {
    this.bitrate = paramInt1;
    this.sampleRate = paramInt2;
    this.channelCount = paramInt3;
  }
  
  private void handleEndOfStream()
  {
    int i = this.mediaCodec.dequeueInputBuffer(5000L);
    this.mediaCodec.queueInputBuffer(i, 0, 0, this.presentationTimeUs, 4);
    writeOutputs();
  }
  
  private boolean isKitkat()
  {
    return Build.VERSION.SDK_INT >= 19;
  }
  
  private boolean isLollipop()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
  
  private void writeOutputs()
  {
    int i = 0;
    while (i != -1)
    {
      int j = this.mediaCodec.dequeueOutputBuffer(this.bufferInfo, 5000L);
      if (j >= 0)
      {
        ByteBuffer localByteBuffer;
        if (!isLollipop()) {
          localByteBuffer = this.codecOutputBuffers[j];
        } else {
          localByteBuffer = this.mediaCodec.getOutputBuffer(j);
        }
        if (isKitkat())
        {
          localByteBuffer.position(this.bufferInfo.offset);
          localByteBuffer.limit(this.bufferInfo.offset + this.bufferInfo.size);
        }
        if (((this.bufferInfo.flags & 0x2) != 0) && (this.bufferInfo.size != 0))
        {
          this.mediaCodec.releaseOutputBuffer(j, false);
          i = j;
        }
        else
        {
          this.mediaMuxer.writeSampleData(this.audioTrackId, this.codecOutputBuffers[j], this.bufferInfo);
          this.mediaCodec.releaseOutputBuffer(j, false);
          i = j;
        }
      }
      else
      {
        i = j;
        if (j == -2)
        {
          this.mediaFormat = this.mediaCodec.getOutputFormat();
          this.audioTrackId = this.mediaMuxer.addTrack(this.mediaFormat);
          this.mediaMuxer.start();
          i = j;
        }
      }
    }
  }
  
  public void encode(InputStream paramInputStream, int paramInt)
  {
    LogUtils.d(TAG, "Starting encoding of InputStream");
    long l = System.currentTimeMillis();
    byte[] arrayOfByte = new byte[paramInt * 2];
    int i = 0;
    int j = 1;
    while (i == 0)
    {
      int m = 0;
      int k = 0;
      while ((m != -1) && (j != 0) && (k <= paramInt * 50))
      {
        int n = this.mediaCodec.dequeueInputBuffer(5000L);
        m = n;
        if (n >= 0)
        {
          if (!isLollipop()) {
            localObject = this.codecInputBuffers[n];
          } else {
            localObject = this.mediaCodec.getInputBuffer(n);
          }
          ((ByteBuffer)localObject).clear();
          m = paramInputStream.read(arrayOfByte, 0, ((ByteBuffer)localObject).limit());
          if (m == -1)
          {
            this.mediaCodec.queueInputBuffer(n, 0, 0, this.presentationTimeUs, 0);
            j = 0;
            i = 1;
            m = n;
          }
          else
          {
            this.totalBytesRead += m;
            k += m;
            ((ByteBuffer)localObject).put(arrayOfByte, 0, m);
            this.mediaCodec.queueInputBuffer(n, 0, m, this.presentationTimeUs, 0);
            this.presentationTimeUs = (this.totalBytesRead / 2 * 1000000L / paramInt);
            m = n;
          }
        }
      }
      writeOutputs();
    }
    paramInputStream.close();
    LogUtils.d(TAG, "Finished encoding of InputStream");
    paramInputStream = TAG;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("pcm 2 m4a: ");
    ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
    ((StringBuilder)localObject).append(" ms");
    LogUtils.d(paramInputStream, ((StringBuilder)localObject).toString());
  }
  
  public void prepare()
  {
    if (this.outputPath != null) {
      try
      {
        this.mediaFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", this.sampleRate, this.channelCount);
        this.mediaFormat.setInteger("aac-profile", 2);
        this.mediaFormat.setInteger("bitrate", this.bitrate);
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
    this.mediaCodec.stop();
    this.mediaCodec.release();
    this.mediaMuxer.stop();
    this.mediaMuxer.release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.voicechanger.common.audio.PcmEncoder
 * JD-Core Version:    0.7.0.1
 */