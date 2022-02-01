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
    TLog.b("HWVideoEncoder", "drainEncoder(" + paramBoolean + ")");
    if (paramBoolean)
    {
      TLog.b("HWVideoEncoder", "sending EOS to encoder");
      this.jdField_a_of_type_AndroidMediaMediaCodec.signalEndOfInputStream();
    }
    ByteBuffer[] arrayOfByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
    int i = 0;
    for (;;)
    {
      int j = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueOutputBuffer(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo, 10000L);
      if (j == -1) {
        if (!paramBoolean) {
          TLog.b("HWVideoEncoder", "no output available yet");
        }
      }
      for (;;)
      {
        if ((paramBoolean) && (this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderMuxerDataListener != null)) {
          this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderMuxerDataListener.a();
        }
        return;
        TLog.b("HWVideoEncoder", "no output available, spinning to await EOS");
        j = i + 1;
        i = j;
        if (j <= 100) {
          break;
        }
        throw new RuntimeException("Encoder is not stopped after dequeue 100 times.");
        if (j == -3)
        {
          arrayOfByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
          break;
        }
        if (j == -2)
        {
          this.jdField_a_of_type_AndroidMediaMediaFormat = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputFormat();
          a(this.jdField_a_of_type_AndroidMediaMediaFormat);
          TLog.b("HWVideoEncoder", "encoder output format changed: " + this.jdField_a_of_type_AndroidMediaMediaFormat);
          break;
        }
        if (j < 0)
        {
          TLog.c("HWVideoEncoder", "unexpected result from encoder.dequeueOutputBuffer: " + j);
          break;
        }
        ByteBuffer localByteBuffer = arrayOfByteBuffer[j];
        if (localByteBuffer == null) {
          throw new RuntimeException("encoderOutputBuffer " + j + " was null");
        }
        if ((this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags & 0x2) != 0)
        {
          TLog.b("HWVideoEncoder", "ignoring BUFFER_FLAG_CODEC_CONFIG");
          this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size = 0;
        }
        if (this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size != 0)
        {
          a(localByteBuffer, this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo);
          TLog.b("HWVideoEncoder", "sent " + this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size + " bytes to muxer, ts=" + this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs * 1000L);
        }
        this.jdField_a_of_type_AndroidMediaMediaCodec.releaseOutputBuffer(j, false);
        if ((this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags & 0x4) == 0) {
          break label427;
        }
        if (!paramBoolean) {
          TLog.c("HWVideoEncoder", "reached end of stream unexpectedly");
        } else {
          TLog.b("HWVideoEncoder", "end of stream reached");
        }
      }
      label427:
      i = 0;
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
    if (this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderMediaMuxerWrapper == null) {}
    for (boolean bool = true;; bool = false)
    {
      TLog.b("HWVideoEncoder", "setOutputFormat, " + bool);
      if (this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderMediaMuxerWrapper != null) {
        break label110;
      }
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      throw new RuntimeException("format changed twice");
    }
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaMuxer.addTrack(this.jdField_a_of_type_AndroidMediaMediaFormat);
    this.jdField_a_of_type_AndroidMediaMediaMuxer.start();
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderMuxerDataListener != null) {
      this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderMuxerDataListener.a(this.jdField_a_of_type_AndroidMediaMediaFormat);
    }
    return;
    label110:
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderMediaMuxerWrapper.a(0, paramMediaFormat);
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
    TLog.b("HWVideoEncoder", "start : encodeConfig = + " + paramEncodeConfig.toString() + " ; format: " + localObject);
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
    }
    for (;;)
    {
      if (paramEncodeConfig.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderMuxerDataListener != null) {
        this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderMuxerDataListener = paramEncodeConfig.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderMuxerDataListener;
      }
      this.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_Boolean = false;
      return;
      this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderMediaMuxerWrapper = paramEncodeConfig.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderMediaMuxerWrapper;
    }
  }
  
  public void a(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    if (this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderMediaMuxerWrapper == null)
    {
      if (!this.jdField_a_of_type_Boolean) {
        throw new RuntimeException("muxer hasn't started");
      }
      paramByteBuffer.position(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.offset);
      paramByteBuffer.limit(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.offset + this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size);
      if (this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderMuxerDataListener != null)
      {
        paramBufferInfo = new HWVideoEncoder.MuxerData(this);
        paramBufferInfo.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        Object localObject = ByteBuffer.allocate(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size);
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
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderMediaMuxerWrapper.a(0, paramByteBuffer, paramBufferInfo);
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
    if (this.jdField_a_of_type_AndroidMediaMediaCodec != null) {}
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaCodec.stop();
      TLog.b("HWVideoEncoder", "MediaCodec stop.");
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          this.jdField_a_of_type_AndroidMediaMediaCodec.release();
          TLog.b("HWVideoEncoder", "MediaCodec release.");
          this.jdField_a_of_type_AndroidMediaMediaCodec = null;
          if ((this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderMediaMuxerWrapper != null) || (this.jdField_a_of_type_AndroidMediaMediaMuxer == null)) {
            break label199;
          }
          try
          {
            if (this.jdField_a_of_type_Boolean)
            {
              this.jdField_a_of_type_Boolean = false;
              this.jdField_a_of_type_AndroidMediaMediaMuxer.stop();
              TLog.b("HWVideoEncoder", "MediaMuxer stop.");
            }
            this.jdField_a_of_type_AndroidMediaMediaMuxer.release();
            TLog.b("HWVideoEncoder", "MediaMuxer release.");
          }
          catch (Exception localException3)
          {
            for (;;)
            {
              TLog.c("HWVideoEncoder", "Muxer stop exception:" + localException3);
            }
          }
          this.jdField_a_of_type_AndroidMediaMediaMuxer = null;
          return;
          localException1 = localException1;
          TLog.c("HWVideoEncoder", "mEncoder stop exception:" + localException1);
        }
      }
      catch (Exception localException2)
      {
        label199:
        do
        {
          for (;;)
          {
            TLog.c("HWVideoEncoder", "mEncoder release exception:" + localException2);
          }
        } while (this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderMediaMuxerWrapper == null);
        TLog.b("HWVideoEncoder", "HWVideoEncoder release");
        this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecRecorderMediaMuxerWrapper.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.mediacodec.encoder.HWVideoEncoder
 * JD-Core Version:    0.7.0.1
 */