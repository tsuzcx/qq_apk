package com.tencent.mobileqq.videocodec.mediacodec.encoder;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.view.Surface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.videocodec.mediacodec.recorder.MediaMuxerWrapper;
import com.tencent.qphone.base.util.QLog;
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
  private String h;
  private int i;
  private boolean j;
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("drainEncoder(");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(")");
      QLog.d("HWVideoEncoder", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HWVideoEncoder", 2, "sending EOS to encoder");
      }
      this.f.signalEndOfInputStream();
    }
    Object localObject = this.f.getOutputBuffers();
    int m;
    do
    {
      int k = 0;
      for (;;)
      {
        m = this.f.dequeueOutputBuffer(this.g, 10000L);
        if (m == -1)
        {
          if (!paramBoolean)
          {
            if (!QLog.isColorLevel()) {
              break label482;
            }
            QLog.d("HWVideoEncoder", 2, "no output available yet");
            break label482;
          }
          if (QLog.isColorLevel()) {
            QLog.d("HWVideoEncoder", 2, "no output available, spinning to await EOS");
          }
          k += 1;
          if (k > 100) {
            throw new RuntimeException("Encoder is not stopped after dequeue 100 times.");
          }
        }
        else if (m == -3)
        {
          localObject = this.f.getOutputBuffers();
        }
        else if (m == -2)
        {
          this.a = this.f.getOutputFormat();
          a(this.a);
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("encoder output format changed: ");
            localStringBuilder.append(this.a);
            QLog.d("HWVideoEncoder", 2, localStringBuilder.toString());
          }
        }
        else
        {
          if (m >= 0) {
            break;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("unexpected result from encoder.dequeueOutputBuffer: ");
          localStringBuilder.append(m);
          QLog.w("HWVideoEncoder", 2, localStringBuilder.toString());
        }
      }
      StringBuilder localStringBuilder = localObject[m];
      if (localStringBuilder == null) {
        break label505;
      }
      if ((this.g.flags & 0x2) != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("HWVideoEncoder", 2, "ignoring BUFFER_FLAG_CODEC_CONFIG");
        }
        this.g.size = 0;
      }
      if (this.g.size != 0)
      {
        a(localStringBuilder, this.g);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("sent ");
          localStringBuilder.append(this.g.size);
          localStringBuilder.append(" bytes to muxer, ts=");
          localStringBuilder.append(this.g.presentationTimeUs * 1000L);
          QLog.d("HWVideoEncoder", 2, localStringBuilder.toString());
        }
      }
      this.f.releaseOutputBuffer(m, false);
    } while ((this.g.flags & 0x4) == 0);
    if (!paramBoolean) {
      QLog.w("HWVideoEncoder", 2, "reached end of stream unexpectedly");
    } else if (QLog.isColorLevel()) {
      QLog.d("HWVideoEncoder", 2, "end of stream reached");
    }
    label482:
    if (paramBoolean)
    {
      localObject = this.e;
      if (localObject != null) {
        ((MuxerDataListener)localObject).a();
      }
    }
    return;
    label505:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("encoderOutputBuffer ");
    ((StringBuilder)localObject).append(m);
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
    if (QLog.isColorLevel())
    {
      boolean bool;
      if (this.d == null) {
        bool = true;
      } else {
        bool = false;
      }
      QLog.d("HWVideoEncoder", 2, new Object[] { "setOutputFormat, ", Boolean.valueOf(bool) });
    }
    MediaMuxerWrapper localMediaMuxerWrapper = this.d;
    if (localMediaMuxerWrapper == null)
    {
      if (!this.j)
      {
        this.i = this.c.addTrack(this.a);
        this.c.start();
        this.j = true;
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
      localMediaMuxerWrapper.a(0, paramMediaFormat);
    }
  }
  
  public void a(EncodeConfig paramEncodeConfig)
  {
    this.h = paramEncodeConfig.b;
    Object localObject = MediaFormat.createVideoFormat("video/avc", paramEncodeConfig.c, paramEncodeConfig.d);
    ((MediaFormat)localObject).setInteger("color-format", 2130708361);
    ((MediaFormat)localObject).setInteger("bitrate", paramEncodeConfig.e);
    ((MediaFormat)localObject).setInteger("frame-rate", paramEncodeConfig.f);
    ((MediaFormat)localObject).setInteger("i-frame-interval", paramEncodeConfig.g);
    if (paramEncodeConfig.p != -1) {
      ((MediaFormat)localObject).setInteger("bitrate-mode", paramEncodeConfig.p);
    }
    if (paramEncodeConfig.q != -1)
    {
      ((MediaFormat)localObject).setInteger("profile", 8);
      ((MediaFormat)localObject).setInteger("level", 32768);
    }
    if (paramEncodeConfig.n)
    {
      ((MediaFormat)localObject).setInteger("profile", 1);
      ((MediaFormat)localObject).setInteger("level", 512);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start : encodeConfig = + ");
      localStringBuilder.append(paramEncodeConfig.toString());
      localStringBuilder.append(" ; format: ");
      localStringBuilder.append(localObject);
      QLog.d("HWVideoEncoder", 2, localStringBuilder.toString());
    }
    this.f = MediaCodec.createEncoderByType("video/avc");
    this.f.configure((MediaFormat)localObject, null, null, 1);
    this.b = this.f.createInputSurface();
    this.f.start();
    localObject = new File(paramEncodeConfig.b);
    if (!((File)localObject).exists()) {
      FileUtils.createFileIfNotExits(((File)localObject).getAbsolutePath());
    }
    if (paramEncodeConfig.s == null)
    {
      this.c = new MediaMuxer(paramEncodeConfig.b, 0);
      this.c.setOrientationHint(paramEncodeConfig.l);
    }
    else
    {
      this.d = paramEncodeConfig.s;
      this.d.a.setOrientationHint(paramEncodeConfig.l);
    }
    if (paramEncodeConfig.t != null) {
      this.e = paramEncodeConfig.t;
    }
    this.i = -1;
    this.j = false;
  }
  
  public void a(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    Object localObject = this.d;
    if (localObject == null)
    {
      if (this.j)
      {
        paramByteBuffer.position(this.g.offset);
        paramByteBuffer.limit(this.g.offset + this.g.size);
        if (this.e != null)
        {
          paramBufferInfo = new HWVideoEncoder.MuxerData(this);
          paramBufferInfo.a = this.i;
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
        this.c.writeSampleData(this.i, paramByteBuffer, this.g);
        return;
      }
      throw new RuntimeException("muxer hasn't started");
    }
    ((MediaMuxerWrapper)localObject).a(0, paramByteBuffer, paramBufferInfo);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoEncoder", 2, "HWVideoEncoder stop.");
    }
    a(true);
    c();
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoEncoder", 2, "HWVideoEncoder release.");
    }
    MediaCodec localMediaCodec = this.f;
    StringBuilder localStringBuilder;
    if (localMediaCodec != null)
    {
      try
      {
        localMediaCodec.stop();
        if (QLog.isColorLevel()) {
          QLog.d("HWVideoEncoder", 2, "MediaCodec stop.");
        }
      }
      catch (Exception localException1)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("mEncoder stop exception:");
        localStringBuilder.append(localException1);
        QLog.w("HWVideoEncoder", 2, localStringBuilder.toString());
      }
      try
      {
        this.f.release();
        if (QLog.isColorLevel()) {
          QLog.d("HWVideoEncoder", 2, "MediaCodec release.");
        }
      }
      catch (Exception localException2)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("mEncoder release exception:");
        localStringBuilder.append(localException2);
        QLog.w("HWVideoEncoder", 2, localStringBuilder.toString());
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
          if (this.j)
          {
            this.j = false;
            localMediaMuxer.stop();
            if (QLog.isColorLevel()) {
              QLog.d("HWVideoEncoder", 2, "MediaMuxer stop.");
            }
          }
          this.c.release();
          if (QLog.isColorLevel()) {
            QLog.d("HWVideoEncoder", 2, "MediaMuxer release.");
          }
        }
        catch (Exception localException3)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Muxer stop exception:");
          localStringBuilder.append(localException3);
          QLog.w("HWVideoEncoder", 2, localStringBuilder.toString());
        }
        this.c = null;
        return;
      }
    }
    if (this.d != null)
    {
      QLog.d("HWVideoEncoder", 1, "HWVideoEncoder release");
      this.d.a();
    }
  }
  
  public Surface d()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.mediacodec.encoder.HWVideoEncoder
 * JD-Core Version:    0.7.0.1
 */