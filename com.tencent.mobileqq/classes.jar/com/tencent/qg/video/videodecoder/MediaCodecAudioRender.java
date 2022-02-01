package com.tencent.qg.video.videodecoder;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AudioSampleRateExtract;
import com.tencent.mobileqq.editor.composite.step.AudioDataUtil;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder.AudioData;
import com.tencent.mobileqq.videocodec.audio.AudioDecodeConfig;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportAudioTrack;
import com.tencent.util.Pair;
import java.nio.ByteBuffer;

@TargetApi(16)
public class MediaCodecAudioRender
  extends MediaCodecRender
{
  public AudioDecodeConfig a;
  private AudioTrack p;
  private HandlerThread q;
  private MediaCodecAudioRender.AudioDecodeHandler r;
  
  private void a(AudioTrack paramAudioTrack, byte[] paramArrayOfByte, int paramInt)
  {
    int j = this.a.d;
    int i = 1;
    byte[] arrayOfByte;
    if (j != 1)
    {
      if (j != 2)
      {
        if (j != 3)
        {
          if (j != 4)
          {
            if (!this.l.a) {
              paramAudioTrack.write(paramArrayOfByte, 0, paramInt);
            }
            paramArrayOfByte = null;
            j = 0;
            paramInt = i;
            i = j;
            break label179;
          }
          paramInt = paramArrayOfByte.length * 4;
          arrayOfByte = new byte[paramInt];
          AudioDataUtil.a(paramArrayOfByte, 0, arrayOfByte, paramInt, 4);
          paramArrayOfByte = arrayOfByte;
        }
        else
        {
          paramInt = paramArrayOfByte.length * 2 / 3;
          arrayOfByte = new byte[paramInt];
          AudioDataUtil.b(paramArrayOfByte, 0, arrayOfByte, paramInt);
          paramArrayOfByte = arrayOfByte;
        }
      }
      else
      {
        paramInt = paramArrayOfByte.length * 2;
        arrayOfByte = new byte[paramInt];
        AudioDataUtil.a(paramArrayOfByte, 0, arrayOfByte, paramInt, 2);
        paramArrayOfByte = arrayOfByte;
      }
    }
    else
    {
      paramInt = paramArrayOfByte.length / 2;
      arrayOfByte = new byte[paramInt];
      AudioDataUtil.a(paramArrayOfByte, 0, arrayOfByte, paramInt);
      paramArrayOfByte = arrayOfByte;
    }
    j = 0;
    i = paramInt;
    paramInt = j;
    label179:
    if ((!this.l.a) && (paramInt == 0) && (paramArrayOfByte != null)) {
      paramAudioTrack.write(paramArrayOfByte, 0, i);
    }
  }
  
  private AudioTrack k()
  {
    Object localObject = null;
    for (;;)
    {
      try
      {
        if (this.a.b.g != 1) {
          break label113;
        }
        i = 4;
        if (this.a.b.d != 16) {
          break label119;
        }
        j = 2;
        int k = AudioTrack.getMinBufferSize(this.a.b.f, i, j);
        ReportAudioTrack localReportAudioTrack = new ReportAudioTrack(3, this.a.b.f, i, j, k, 1);
        try
        {
          localReportAudioTrack.play();
          return localReportAudioTrack;
        }
        catch (Throwable localThrowable1)
        {
          localObject = localReportAudioTrack;
        }
        SLog.c("Q.qqstory.mediadecoderMediaCodecAudioRender", "AudioTrack init fail :%s", localThrowable2);
      }
      catch (Throwable localThrowable2) {}
      return localObject;
      label113:
      int i = 12;
      continue;
      label119:
      int j = 3;
    }
  }
  
  public long a(long paramLong)
  {
    this.p.flush();
    return super.a(paramLong);
  }
  
  protected String a()
  {
    return "Q.qqstory.mediadecoderMediaCodecAudioRender";
  }
  
  protected void a(MediaCodec paramMediaCodec, MediaCodec.BufferInfo paramBufferInfo)
  {
    int i = paramMediaCodec.dequeueOutputBuffer(paramBufferInfo, 10000L);
    if (i != -3)
    {
      if (i != -2)
      {
        if (i != -1)
        {
          if ((paramBufferInfo.flags & 0x4) != 0)
          {
            SLog.b("Q.qqstory.mediadecoderMediaCodecAudioRender", "output EOS");
            this.h = true;
          }
          try
          {
            Object localObject = this.e[i];
            if (localObject == null)
            {
              SLog.e("Q.qqstory.mediadecoderMediaCodecAudioRender", "find no data");
              return;
            }
            if (paramBufferInfo.size != 0)
            {
              ((ByteBuffer)localObject).position(paramBufferInfo.offset);
              ((ByteBuffer)localObject).limit(paramBufferInfo.offset + paramBufferInfo.size);
            }
            int j = ((ByteBuffer)localObject).remaining();
            paramBufferInfo = new byte[j];
            ((ByteBuffer)localObject).get(paramBufferInfo, 0, j);
            localObject = Message.obtain();
            ((Message)localObject).what = 1;
            ((Message)localObject).obj = new Pair(paramBufferInfo, Integer.valueOf(j));
            this.r.sendMessage((Message)localObject);
            paramMediaCodec.releaseOutputBuffer(i, false);
            return;
          }
          catch (Exception paramMediaCodec)
          {
            SLog.c("Q.qqstory.mediadecoderMediaCodecAudioRender", "handle data error :%s", paramMediaCodec);
            return;
          }
        }
        SLog.b("Q.qqstory.mediadecoderMediaCodecAudioRender", "dequeueOutputBuffer timed out!");
        return;
      }
      paramBufferInfo = new StringBuilder();
      paramBufferInfo.append("New format ");
      paramBufferInfo.append(paramMediaCodec.getOutputFormat());
      SLog.b("Q.qqstory.mediadecoderMediaCodecAudioRender", paramBufferInfo.toString());
      return;
    }
    SLog.b("Q.qqstory.mediadecoderMediaCodecAudioRender", "INFO_OUTPUT_BUFFERS_CHANGED");
    this.e = paramMediaCodec.getOutputBuffers();
  }
  
  protected void a(MediaCodecRender.MediaCodecInfo paramMediaCodecInfo, MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
  {
    try
    {
      this.a.b.g = paramMediaFormat.getInteger("channel-count");
      this.a.b.f = AudioSampleRateExtract.a(paramMediaFormat);
    }
    catch (Throwable paramMediaCodecInfo)
    {
      paramMediaCodecInfo.printStackTrace();
    }
    paramMediaCodecInfo = new StringBuilder();
    paramMediaCodecInfo.append("config after b=");
    paramMediaCodecInfo.append(this.a.b.e);
    paramMediaCodecInfo.append(" c=");
    paramMediaCodecInfo.append(this.a.b.g);
    paramMediaCodecInfo.append(" sc=");
    paramMediaCodecInfo.append(this.a.b.f);
    SLog.b("Q.qqstory.mediadecoderMediaCodecAudioRender", paramMediaCodecInfo.toString());
    paramMediaCodec.configure(paramMediaFormat, null, null, 0);
    this.p = k();
    this.q = new HandlerThread("mc_audio_thread");
    this.q.start();
    this.r = new MediaCodecAudioRender.AudioDecodeHandler(this, this.q.getLooper());
  }
  
  public void b()
  {
    super.b();
    this.p.play();
  }
  
  public void c()
  {
    super.c();
    Object localObject = this.p;
    if (localObject != null)
    {
      ((AudioTrack)localObject).stop();
      this.p.release();
      this.p = null;
    }
    localObject = this.q;
    if (localObject != null)
    {
      ((HandlerThread)localObject).getLooper().quit();
      this.q = null;
      this.r = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qg.video.videodecoder.MediaCodecAudioRender
 * JD-Core Version:    0.7.0.1
 */