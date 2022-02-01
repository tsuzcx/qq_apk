package com.tencent.tkd.topicsdk.videoprocess.mediacodec.encoder;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.view.Surface;
import com.tencent.tkd.topicsdk.common.FileUtils;
import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.topicsdk.videoprocess.mediacodec.recorder.MediaMuxerWrapper;
import java.io.File;
import java.nio.ByteBuffer;

@TargetApi(18)
public class HWVideoEncoder
{
  public MediaFormat a;
  private Surface b;
  private MediaMuxer c;
  private MediaMuxerWrapper d;
  private MuxerDataListener e;
  private MediaCodec f;
  private MediaCodec.BufferInfo g = new MediaCodec.BufferInfo();
  private int h;
  private boolean i;
  
  private void a(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("drainEncoder(");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(")");
    TLog.b("HWVideoEncoder", ((StringBuilder)localObject).toString());
    if (paramBoolean)
    {
      TLog.b("HWVideoEncoder", "sending EOS to encoder");
      this.f.signalEndOfInputStream();
    }
    localObject = this.f.getOutputBuffers();
    int k;
    do
    {
      int j = 0;
      for (;;)
      {
        k = this.f.dequeueOutputBuffer(this.g, 10000L);
        if (k == -1)
        {
          if (!paramBoolean)
          {
            TLog.b("HWVideoEncoder", "no output available yet");
            break label424;
          }
          TLog.b("HWVideoEncoder", "no output available, spinning to await EOS");
          j += 1;
          if (j > 100) {
            throw new RuntimeException("Encoder is not stopped after dequeue 100 times.");
          }
        }
        else if (k == -3)
        {
          localObject = this.f.getOutputBuffers();
        }
        else if (k == -2)
        {
          this.a = this.f.getOutputFormat();
          a(this.a);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("encoder output format changed: ");
          localStringBuilder.append(this.a);
          TLog.b("HWVideoEncoder", localStringBuilder.toString());
        }
        else
        {
          if (k >= 0) {
            break;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("unexpected result from encoder.dequeueOutputBuffer: ");
          localStringBuilder.append(k);
          TLog.c("HWVideoEncoder", localStringBuilder.toString());
        }
      }
      StringBuilder localStringBuilder = localObject[k];
      if (localStringBuilder == null) {
        break label447;
      }
      if ((this.g.flags & 0x2) != 0)
      {
        TLog.b("HWVideoEncoder", "ignoring BUFFER_FLAG_CODEC_CONFIG");
        this.g.size = 0;
      }
      if (this.g.size != 0)
      {
        a(localStringBuilder, this.g);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("sent ");
        localStringBuilder.append(this.g.size);
        localStringBuilder.append(" bytes to muxer, ts=");
        localStringBuilder.append(this.g.presentationTimeUs * 1000L);
        TLog.b("HWVideoEncoder", localStringBuilder.toString());
      }
      this.f.releaseOutputBuffer(k, false);
    } while ((this.g.flags & 0x4) == 0);
    if (!paramBoolean) {
      TLog.c("HWVideoEncoder", "reached end of stream unexpectedly");
    } else {
      TLog.b("HWVideoEncoder", "end of stream reached");
    }
    label424:
    if (paramBoolean)
    {
      localObject = this.e;
      if (localObject != null) {
        ((MuxerDataListener)localObject).a();
      }
    }
    return;
    label447:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("encoderOutputBuffer ");
    ((StringBuilder)localObject).append(k);
    ((StringBuilder)localObject).append(" was null");
    localObject = new RuntimeException(((StringBuilder)localObject).toString());
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public void a()
  {
    a(false);
  }
  
  public void a(MediaFormat paramMediaFormat)
  {
    boolean bool;
    if (this.d == null) {
      bool = true;
    } else {
      bool = false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setOutputFormat, ");
    ((StringBuilder)localObject).append(bool);
    TLog.b("HWVideoEncoder", ((StringBuilder)localObject).toString());
    localObject = this.d;
    if (localObject == null)
    {
      if (!this.i)
      {
        this.h = this.c.addTrack(this.a);
        this.c.start();
        this.i = true;
        paramMediaFormat = this.e;
        if (paramMediaFormat != null) {
          paramMediaFormat.a(this.a);
        }
      }
      else
      {
        throw new RuntimeException("format changed twice");
      }
    }
    else {
      ((MediaMuxerWrapper)localObject).a(0, paramMediaFormat);
    }
  }
  
  public void a(EncodeConfig paramEncodeConfig)
  {
    Object localObject = MediaFormat.createVideoFormat("video/avc", paramEncodeConfig.b, paramEncodeConfig.c);
    ((MediaFormat)localObject).setInteger("color-format", 2130708361);
    ((MediaFormat)localObject).setInteger("bitrate", paramEncodeConfig.g);
    ((MediaFormat)localObject).setInteger("frame-rate", paramEncodeConfig.h);
    ((MediaFormat)localObject).setInteger("i-frame-interval", paramEncodeConfig.i);
    if (paramEncodeConfig.d != -1) {
      ((MediaFormat)localObject).setInteger("bitrate-mode", paramEncodeConfig.d);
    }
    if (paramEncodeConfig.e != -1)
    {
      ((MediaFormat)localObject).setInteger("profile", 8);
      ((MediaFormat)localObject).setInteger("level", 32768);
    }
    if (paramEncodeConfig.j)
    {
      ((MediaFormat)localObject).setInteger("profile", 1);
      ((MediaFormat)localObject).setInteger("level", 512);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start : encodeConfig = + ");
    localStringBuilder.append(paramEncodeConfig.toString());
    localStringBuilder.append(" ; format: ");
    localStringBuilder.append(localObject);
    TLog.b("HWVideoEncoder", localStringBuilder.toString());
    this.f = MediaCodec.createEncoderByType("video/avc");
    this.f.configure((MediaFormat)localObject, null, null, 1);
    this.b = this.f.createInputSurface();
    this.f.start();
    localObject = new File(paramEncodeConfig.a);
    if (!((File)localObject).exists()) {
      FileUtils.c(((File)localObject).getAbsolutePath());
    }
    if (paramEncodeConfig.f == null) {
      this.c = new MediaMuxer(paramEncodeConfig.a, 0);
    } else {
      this.d = paramEncodeConfig.f;
    }
    if (paramEncodeConfig.k != null) {
      this.e = paramEncodeConfig.k;
    }
    this.h = -1;
    this.i = false;
  }
  
  public void a(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    Object localObject = this.d;
    if (localObject == null)
    {
      if (this.i)
      {
        paramByteBuffer.position(this.g.offset);
        paramByteBuffer.limit(this.g.offset + this.g.size);
        if (this.e != null)
        {
          paramBufferInfo = new HWVideoEncoder.MuxerData(this);
          paramBufferInfo.a = this.h;
          localObject = ByteBuffer.allocate(this.g.size);
          ((ByteBuffer)localObject).put(paramByteBuffer);
          ((ByteBuffer)localObject).flip();
          paramBufferInfo.b = ((ByteBuffer)localObject);
          localObject = new MediaCodec.BufferInfo();
          ((MediaCodec.BufferInfo)localObject).flags = this.g.flags;
          ((MediaCodec.BufferInfo)localObject).offset = 0;
          ((MediaCodec.BufferInfo)localObject).presentationTimeUs = this.g.presentationTimeUs;
          ((MediaCodec.BufferInfo)localObject).size = this.g.size;
          paramBufferInfo.c = ((MediaCodec.BufferInfo)localObject);
          this.e.a(paramBufferInfo);
          paramByteBuffer.rewind();
          paramByteBuffer.position(this.g.offset);
          paramByteBuffer.limit(this.g.offset + this.g.size);
        }
        this.c.writeSampleData(this.h, paramByteBuffer, this.g);
        return;
      }
      throw new RuntimeException("muxer hasn't started");
    }
    ((MediaMuxerWrapper)localObject).a(0, paramByteBuffer, paramBufferInfo);
  }
  
  public void b()
  {
    TLog.b("HWVideoEncoder", "HWVideoEncoder stop.");
    a(true);
    c();
  }
  
  public void c()
  {
    TLog.b("HWVideoEncoder", "HWVideoEncoder release.");
    MediaCodec localMediaCodec = this.f;
    StringBuilder localStringBuilder;
    if (localMediaCodec != null)
    {
      try
      {
        localMediaCodec.stop();
        TLog.b("HWVideoEncoder", "MediaCodec stop.");
      }
      catch (Exception localException1)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("mEncoder stop exception:");
        localStringBuilder.append(localException1);
        TLog.c("HWVideoEncoder", localStringBuilder.toString());
      }
      try
      {
        this.f.release();
        TLog.b("HWVideoEncoder", "MediaCodec release.");
      }
      catch (Exception localException2)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("mEncoder release exception:");
        localStringBuilder.append(localException2);
        TLog.c("HWVideoEncoder", localStringBuilder.toString());
      }
      this.f = null;
    }
    if (this.d == null)
    {
      MediaMuxer localMediaMuxer = this.c;
      if (localMediaMuxer != null)
      {
        try
        {
          if (this.i)
          {
            this.i = false;
            localMediaMuxer.stop();
            TLog.b("HWVideoEncoder", "MediaMuxer stop.");
          }
          this.c.release();
          TLog.b("HWVideoEncoder", "MediaMuxer release.");
        }
        catch (Exception localException3)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Muxer stop exception:");
          localStringBuilder.append(localException3);
          TLog.c("HWVideoEncoder", localStringBuilder.toString());
        }
        this.c = null;
        return;
      }
    }
    if (this.d != null)
    {
      TLog.b("HWVideoEncoder", "HWVideoEncoder release");
      this.d.a();
    }
  }
  
  public Surface d()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.mediacodec.encoder.HWVideoEncoder
 * JD-Core Version:    0.7.0.1
 */