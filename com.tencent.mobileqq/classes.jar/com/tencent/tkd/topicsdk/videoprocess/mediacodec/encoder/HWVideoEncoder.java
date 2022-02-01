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
  private int jdField_a_of_type_Int;
  private MediaCodec.BufferInfo jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo = new MediaCodec.BufferInfo();
  private MediaCodec jdField_a_of_type_AndroidMediaMediaCodec;
  public MediaFormat a;
  private MediaMuxer jdField_a_of_type_AndroidMediaMediaMuxer;
  private Surface jdField_a_of_type_AndroidViewSurface;
  private MuxerDataListener jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderMuxerDataListener;
  private MediaMuxerWrapper jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderMediaMuxerWrapper;
  private boolean jdField_a_of_type_Boolean;
  
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
      this.jdField_a_of_type_AndroidMediaMediaCodec.signalEndOfInputStream();
    }
    localObject = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
    int j;
    do
    {
      int i = 0;
      for (;;)
      {
        j = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueOutputBuffer(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo, 10000L);
        if (j == -1)
        {
          if (!paramBoolean)
          {
            TLog.b("HWVideoEncoder", "no output available yet");
            break label424;
          }
          TLog.b("HWVideoEncoder", "no output available, spinning to await EOS");
          i += 1;
          if (i > 100) {
            throw new RuntimeException("Encoder is not stopped after dequeue 100 times.");
          }
        }
        else if (j == -3)
        {
          localObject = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
        }
        else if (j == -2)
        {
          this.jdField_a_of_type_AndroidMediaMediaFormat = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputFormat();
          a(this.jdField_a_of_type_AndroidMediaMediaFormat);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("encoder output format changed: ");
          localStringBuilder.append(this.jdField_a_of_type_AndroidMediaMediaFormat);
          TLog.b("HWVideoEncoder", localStringBuilder.toString());
        }
        else
        {
          if (j >= 0) {
            break;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("unexpected result from encoder.dequeueOutputBuffer: ");
          localStringBuilder.append(j);
          TLog.c("HWVideoEncoder", localStringBuilder.toString());
        }
      }
      StringBuilder localStringBuilder = localObject[j];
      if (localStringBuilder == null) {
        break label447;
      }
      if ((this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags & 0x2) != 0)
      {
        TLog.b("HWVideoEncoder", "ignoring BUFFER_FLAG_CODEC_CONFIG");
        this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size = 0;
      }
      if (this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size != 0)
      {
        a(localStringBuilder, this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("sent ");
        localStringBuilder.append(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size);
        localStringBuilder.append(" bytes to muxer, ts=");
        localStringBuilder.append(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs * 1000L);
        TLog.b("HWVideoEncoder", localStringBuilder.toString());
      }
      this.jdField_a_of_type_AndroidMediaMediaCodec.releaseOutputBuffer(j, false);
    } while ((this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags & 0x4) == 0);
    if (!paramBoolean) {
      TLog.c("HWVideoEncoder", "reached end of stream unexpectedly");
    } else {
      TLog.b("HWVideoEncoder", "end of stream reached");
    }
    label424:
    if (paramBoolean)
    {
      localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderMuxerDataListener;
      if (localObject != null) {
        ((MuxerDataListener)localObject).a();
      }
    }
    return;
    label447:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("encoderOutputBuffer ");
    ((StringBuilder)localObject).append(j);
    ((StringBuilder)localObject).append(" was null");
    localObject = new RuntimeException(((StringBuilder)localObject).toString());
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public Surface a()
  {
    return this.jdField_a_of_type_AndroidViewSurface;
  }
  
  public void a()
  {
    a(false);
  }
  
  public void a(MediaFormat paramMediaFormat)
  {
    boolean bool;
    if (this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderMediaMuxerWrapper == null) {
      bool = true;
    } else {
      bool = false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setOutputFormat, ");
    ((StringBuilder)localObject).append(bool);
    TLog.b("HWVideoEncoder", ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderMediaMuxerWrapper;
    if (localObject == null)
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaMuxer.addTrack(this.jdField_a_of_type_AndroidMediaMediaFormat);
        this.jdField_a_of_type_AndroidMediaMediaMuxer.start();
        this.jdField_a_of_type_Boolean = true;
        paramMediaFormat = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderMuxerDataListener;
        if (paramMediaFormat != null) {
          paramMediaFormat.a(this.jdField_a_of_type_AndroidMediaMediaFormat);
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
    Object localObject = MediaFormat.createVideoFormat("video/avc", paramEncodeConfig.jdField_a_of_type_Int, paramEncodeConfig.b);
    ((MediaFormat)localObject).setInteger("color-format", 2130708361);
    ((MediaFormat)localObject).setInteger("bitrate", paramEncodeConfig.e);
    ((MediaFormat)localObject).setInteger("frame-rate", paramEncodeConfig.f);
    ((MediaFormat)localObject).setInteger("i-frame-interval", paramEncodeConfig.g);
    if (paramEncodeConfig.c != -1) {
      ((MediaFormat)localObject).setInteger("bitrate-mode", paramEncodeConfig.c);
    }
    if (paramEncodeConfig.d != -1)
    {
      ((MediaFormat)localObject).setInteger("profile", 8);
      ((MediaFormat)localObject).setInteger("level", 32768);
    }
    if (paramEncodeConfig.jdField_a_of_type_Boolean)
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
    this.jdField_a_of_type_AndroidMediaMediaCodec = MediaCodec.createEncoderByType("video/avc");
    this.jdField_a_of_type_AndroidMediaMediaCodec.configure((MediaFormat)localObject, null, null, 1);
    this.jdField_a_of_type_AndroidViewSurface = this.jdField_a_of_type_AndroidMediaMediaCodec.createInputSurface();
    this.jdField_a_of_type_AndroidMediaMediaCodec.start();
    localObject = new File(paramEncodeConfig.jdField_a_of_type_JavaLangString);
    if (!((File)localObject).exists()) {
      FileUtils.a(((File)localObject).getAbsolutePath());
    }
    if (paramEncodeConfig.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderMediaMuxerWrapper == null) {
      this.jdField_a_of_type_AndroidMediaMediaMuxer = new MediaMuxer(paramEncodeConfig.jdField_a_of_type_JavaLangString, 0);
    } else {
      this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderMediaMuxerWrapper = paramEncodeConfig.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderMediaMuxerWrapper;
    }
    if (paramEncodeConfig.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderMuxerDataListener != null) {
      this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderMuxerDataListener = paramEncodeConfig.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderMuxerDataListener;
    }
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderMediaMuxerWrapper;
    if (localObject == null)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        paramByteBuffer.position(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.offset);
        paramByteBuffer.limit(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.offset + this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size);
        if (this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderMuxerDataListener != null)
        {
          paramBufferInfo = new HWVideoEncoder.MuxerData(this);
          paramBufferInfo.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
          localObject = ByteBuffer.allocate(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size);
          ((ByteBuffer)localObject).put(paramByteBuffer);
          ((ByteBuffer)localObject).flip();
          paramBufferInfo.jdField_a_of_type_JavaNioByteBuffer = ((ByteBuffer)localObject);
          localObject = new MediaCodec.BufferInfo();
          ((MediaCodec.BufferInfo)localObject).flags = this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags;
          ((MediaCodec.BufferInfo)localObject).offset = 0;
          ((MediaCodec.BufferInfo)localObject).presentationTimeUs = this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs;
          ((MediaCodec.BufferInfo)localObject).size = this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size;
          paramBufferInfo.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo = ((MediaCodec.BufferInfo)localObject);
          this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderMuxerDataListener.a(paramBufferInfo);
          paramByteBuffer.rewind();
          paramByteBuffer.position(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.offset);
          paramByteBuffer.limit(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.offset + this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size);
        }
        this.jdField_a_of_type_AndroidMediaMediaMuxer.writeSampleData(this.jdField_a_of_type_Int, paramByteBuffer, this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo);
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
    MediaCodec localMediaCodec = this.jdField_a_of_type_AndroidMediaMediaCodec;
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
        this.jdField_a_of_type_AndroidMediaMediaCodec.release();
        TLog.b("HWVideoEncoder", "MediaCodec release.");
      }
      catch (Exception localException2)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("mEncoder release exception:");
        localStringBuilder.append(localException2);
        TLog.c("HWVideoEncoder", localStringBuilder.toString());
      }
      this.jdField_a_of_type_AndroidMediaMediaCodec = null;
    }
    if (this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderMediaMuxerWrapper == null)
    {
      MediaMuxer localMediaMuxer = this.jdField_a_of_type_AndroidMediaMediaMuxer;
      if (localMediaMuxer != null)
      {
        try
        {
          if (this.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_Boolean = false;
            localMediaMuxer.stop();
            TLog.b("HWVideoEncoder", "MediaMuxer stop.");
          }
          this.jdField_a_of_type_AndroidMediaMediaMuxer.release();
          TLog.b("HWVideoEncoder", "MediaMuxer release.");
        }
        catch (Exception localException3)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Muxer stop exception:");
          localStringBuilder.append(localException3);
          TLog.c("HWVideoEncoder", localStringBuilder.toString());
        }
        this.jdField_a_of_type_AndroidMediaMediaMuxer = null;
        return;
      }
    }
    if (this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderMediaMuxerWrapper != null)
    {
      TLog.b("HWVideoEncoder", "HWVideoEncoder release");
      this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderMediaMuxerWrapper.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.mediacodec.encoder.HWVideoEncoder
 * JD-Core Version:    0.7.0.1
 */