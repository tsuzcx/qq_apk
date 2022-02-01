package com.tencent.mobileqq.tritonaudio.webaudio;

import android.media.AudioAttributes.Builder;
import android.media.AudioFormat.Builder;
import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import androidx.annotation.RequiresApi;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

class AudioDecoder
{
  private static final long DEFAULT_TIMEOUT = 2000L;
  private static final String TAG = "AudioDecoder";
  private int decodeId = -1;
  private boolean isFirst = true;
  private MediaCodec mediaCodec;
  private MediaExtractor mediaExtractor;
  private MediaFormat oformat;
  private AudioDecoder.OnDecodeProcessListener onDecodeProcessListener;
  
  @RequiresApi(api=16)
  private byte[] doDecode()
  {
    int k = 0;
    int i = 0;
    ByteBuffer[] arrayOfByteBuffer = this.mediaCodec.getInputBuffers();
    Object localObject1 = this.mediaCodec.getOutputBuffers();
    MediaCodec.BufferInfo localBufferInfo = new MediaCodec.BufferInfo();
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    int j = 0;
    if ((k != 0) || (j == 0)) {}
    label465:
    label468:
    label471:
    for (;;)
    {
      try
      {
        int m = this.mediaCodec.dequeueInputBuffer(2000L);
        if (m < 0) {
          break label471;
        }
        ByteBuffer localByteBuffer = arrayOfByteBuffer[m];
        int n = this.mediaExtractor.readSampleData(localByteBuffer, 0);
        if (n < 0)
        {
          this.mediaCodec.queueInputBuffer(m, 0, 0, 0L, 4);
          j = 1;
          m = this.mediaCodec.dequeueOutputBuffer(localBufferInfo, 2000L);
          if (m < 0) {
            continue;
          }
          if ((localBufferInfo.flags & 0x2) == 0) {
            continue;
          }
          this.mediaCodec.releaseOutputBuffer(m, false);
          break;
        }
        long l = this.mediaExtractor.getSampleTime();
        this.mediaCodec.queueInputBuffer(m, 0, n, l, 0);
        this.mediaExtractor.advance();
        break label471;
        if (localBufferInfo.size == 0) {
          break label468;
        }
        localByteBuffer = localObject1[m];
        byte[] arrayOfByte = new byte[localBufferInfo.size];
        localByteBuffer.get(arrayOfByte);
        if (this.onDecodeProcessListener != null)
        {
          this.onDecodeProcessListener.onDecodeProcess(arrayOfByte, this.oformat, this.isFirst, false);
          this.isFirst = false;
        }
        i = arrayOfByte.length + i;
        localByteArrayOutputStream.write(arrayOfByte);
        this.mediaCodec.releaseOutputBuffer(m, false);
        if ((localBufferInfo.flags & 0x4) == 0) {
          break label465;
        }
        k = 1;
        break label474;
        if (m == -3)
        {
          localObject1 = this.mediaCodec.getOutputBuffers();
        }
        else
        {
          if (m != -2) {
            break label477;
          }
          this.oformat = this.mediaCodec.getOutputFormat();
        }
      }
      catch (Exception localException1)
      {
        localException1 = localException1;
        localException1.printStackTrace();
      }
      finally
      {
        try
        {
          localByteArrayOutputStream.close();
          this.mediaCodec.stop();
          this.mediaCodec.release();
          this.mediaExtractor.release();
          return null;
          localObject2 = finally;
          try
          {
            localByteArrayOutputStream.close();
            this.mediaCodec.stop();
            this.mediaCodec.release();
            this.mediaExtractor.release();
            throw localObject2;
          }
          catch (Exception localException3)
          {
            continue;
          }
        }
        catch (Exception localException2)
        {
          continue;
        }
      }
      if (this.onDecodeProcessListener != null) {
        this.onDecodeProcessListener.onDecodeProcess(null, this.oformat, false, true);
      }
      localObject1 = localByteArrayOutputStream.toByteArray();
      break label474;
    }
    label474:
    label477:
    for (;;)
    {
      break;
    }
  }
  
  @RequiresApi(api=16)
  private boolean initMediaCodec()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.mediaExtractor.getTrackCount())
        {
          MediaFormat localMediaFormat = this.mediaExtractor.getTrackFormat(i);
          String str = localMediaFormat.getString("mime");
          if (str.startsWith("audio"))
          {
            this.mediaExtractor.selectTrack(i);
            this.mediaCodec = MediaCodec.createDecoderByType(str);
            this.mediaCodec.configure(localMediaFormat, null, null, 0);
          }
        }
        else
        {
          if (this.mediaCodec == null) {
            return false;
          }
          this.mediaCodec.start();
          return true;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return false;
      }
      i += 1;
    }
  }
  
  @RequiresApi(api=16)
  private boolean initMediaExtractor(String paramString)
  {
    try
    {
      this.mediaExtractor = new MediaExtractor();
      this.mediaExtractor.setDataSource(paramString);
      return true;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  @RequiresApi(api=23)
  private boolean initMediaExtractor(byte[] paramArrayOfByte)
  {
    try
    {
      this.mediaExtractor = new MediaExtractor();
      this.mediaExtractor.setDataSource(new AudioDecoder.MyMediaDataSource(this, paramArrayOfByte));
      return true;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return false;
  }
  
  @RequiresApi(api=21)
  private void testRawData(byte[] paramArrayOfByte)
  {
    if (this.oformat.getInteger("channel-count") == 1) {}
    for (int i = 4;; i = 12)
    {
      AudioTrack localAudioTrack = new AudioTrack(new AudioAttributes.Builder().setUsage(1).setContentType(2).build(), new AudioFormat.Builder().setSampleRate(this.oformat.getInteger("sample-rate")).setChannelMask(i).setEncoding(this.oformat.getInteger("pcm-encoding")).build(), paramArrayOfByte.length, 0, 0);
      localAudioTrack.write(paramArrayOfByte, 0, paramArrayOfByte.length);
      localAudioTrack.play();
      return;
    }
  }
  
  @RequiresApi(api=16)
  public byte[] decodeByPath(String paramString, int paramInt)
  {
    this.decodeId = paramInt;
    if ((initMediaExtractor(paramString)) && (initMediaCodec())) {
      return doDecode();
    }
    return null;
  }
  
  @RequiresApi(api=23)
  public byte[] decodeInMemory(byte[] paramArrayOfByte, int paramInt)
  {
    this.decodeId = paramInt;
    if ((initMediaExtractor(paramArrayOfByte)) && (initMediaCodec())) {
      return doDecode();
    }
    return null;
  }
  
  @RequiresApi(api=16)
  public int getBitsPerChannel()
  {
    if (this.oformat == null) {
      return 0;
    }
    if (Build.VERSION.SDK_INT >= 24)
    {
      if (this.oformat.containsKey("pcm-encoding")) {}
      for (int i = this.oformat.getInteger("pcm-encoding"); i == 3; i = 2) {
        return 8;
      }
      return 16;
    }
    return this.oformat.getInteger("bit-width");
  }
  
  @RequiresApi(api=16)
  public int getChannelCount()
  {
    if (this.oformat == null) {
      return 0;
    }
    return this.oformat.getInteger("channel-count");
  }
  
  @RequiresApi(api=16)
  public int getSampleRate()
  {
    if (this.oformat == null) {
      return 0;
    }
    return this.oformat.getInteger("sample-rate");
  }
  
  public void setOnDecodeProcessListener(AudioDecoder.OnDecodeProcessListener paramOnDecodeProcessListener)
  {
    this.onDecodeProcessListener = paramOnDecodeProcessListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tritonaudio.webaudio.AudioDecoder
 * JD-Core Version:    0.7.0.1
 */