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
  private int jdField_a_of_type_Int;
  private MediaCodec.BufferInfo jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo = new MediaCodec.BufferInfo();
  private MediaCodec jdField_a_of_type_AndroidMediaMediaCodec;
  public MediaFormat a;
  private MediaMuxer jdField_a_of_type_AndroidMediaMediaMuxer;
  private Surface jdField_a_of_type_AndroidViewSurface;
  private MuxerDataListener jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderMuxerDataListener;
  private MediaMuxerWrapper jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderMediaMuxerWrapper;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
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
      this.jdField_a_of_type_AndroidMediaMediaCodec.signalEndOfInputStream();
    }
    Object localObject = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
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
            if (!QLog.isColorLevel()) {
              break label482;
            }
            QLog.d("HWVideoEncoder", 2, "no output available yet");
            break label482;
          }
          if (QLog.isColorLevel()) {
            QLog.d("HWVideoEncoder", 2, "no output available, spinning to await EOS");
          }
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
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("encoder output format changed: ");
            localStringBuilder.append(this.jdField_a_of_type_AndroidMediaMediaFormat);
            QLog.d("HWVideoEncoder", 2, localStringBuilder.toString());
          }
        }
        else
        {
          if (j >= 0) {
            break;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("unexpected result from encoder.dequeueOutputBuffer: ");
          localStringBuilder.append(j);
          QLog.w("HWVideoEncoder", 2, localStringBuilder.toString());
        }
      }
      StringBuilder localStringBuilder = localObject[j];
      if (localStringBuilder == null) {
        break label505;
      }
      if ((this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags & 0x2) != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("HWVideoEncoder", 2, "ignoring BUFFER_FLAG_CODEC_CONFIG");
        }
        this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size = 0;
      }
      if (this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size != 0)
      {
        a(localStringBuilder, this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("sent ");
          localStringBuilder.append(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size);
          localStringBuilder.append(" bytes to muxer, ts=");
          localStringBuilder.append(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs * 1000L);
          QLog.d("HWVideoEncoder", 2, localStringBuilder.toString());
        }
      }
      this.jdField_a_of_type_AndroidMediaMediaCodec.releaseOutputBuffer(j, false);
    } while ((this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags & 0x4) == 0);
    if (!paramBoolean) {
      QLog.w("HWVideoEncoder", 2, "reached end of stream unexpectedly");
    } else if (QLog.isColorLevel()) {
      QLog.d("HWVideoEncoder", 2, "end of stream reached");
    }
    label482:
    if (paramBoolean)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderMuxerDataListener;
      if (localObject != null) {
        ((MuxerDataListener)localObject).a();
      }
    }
    return;
    label505:
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
    if (QLog.isColorLevel())
    {
      boolean bool;
      if (this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderMediaMuxerWrapper == null) {
        bool = true;
      } else {
        bool = false;
      }
      QLog.d("HWVideoEncoder", 2, new Object[] { "setOutputFormat, ", Boolean.valueOf(bool) });
    }
    MediaMuxerWrapper localMediaMuxerWrapper = this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderMediaMuxerWrapper;
    if (localMediaMuxerWrapper == null)
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaMuxer.addTrack(this.jdField_a_of_type_AndroidMediaMediaFormat);
        this.jdField_a_of_type_AndroidMediaMediaMuxer.start();
        this.jdField_a_of_type_Boolean = true;
        paramMediaFormat = this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderMuxerDataListener;
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
      localMediaMuxerWrapper.a(0, paramMediaFormat);
    }
  }
  
  public void a(EncodeConfig paramEncodeConfig)
  {
    this.jdField_a_of_type_JavaLangString = paramEncodeConfig.jdField_a_of_type_JavaLangString;
    Object localObject = MediaFormat.createVideoFormat("video/avc", paramEncodeConfig.jdField_a_of_type_Int, paramEncodeConfig.jdField_b_of_type_Int);
    ((MediaFormat)localObject).setInteger("color-format", 2130708361);
    ((MediaFormat)localObject).setInteger("bitrate", paramEncodeConfig.c);
    ((MediaFormat)localObject).setInteger("frame-rate", paramEncodeConfig.d);
    ((MediaFormat)localObject).setInteger("i-frame-interval", paramEncodeConfig.e);
    if (paramEncodeConfig.i != -1) {
      ((MediaFormat)localObject).setInteger("bitrate-mode", paramEncodeConfig.i);
    }
    if (paramEncodeConfig.j != -1)
    {
      ((MediaFormat)localObject).setInteger("profile", 8);
      ((MediaFormat)localObject).setInteger("level", 32768);
    }
    if (paramEncodeConfig.jdField_b_of_type_Boolean)
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
    this.jdField_a_of_type_AndroidMediaMediaCodec = MediaCodec.createEncoderByType("video/avc");
    this.jdField_a_of_type_AndroidMediaMediaCodec.configure((MediaFormat)localObject, null, null, 1);
    this.jdField_a_of_type_AndroidViewSurface = this.jdField_a_of_type_AndroidMediaMediaCodec.createInputSurface();
    this.jdField_a_of_type_AndroidMediaMediaCodec.start();
    localObject = new File(paramEncodeConfig.jdField_a_of_type_JavaLangString);
    if (!((File)localObject).exists()) {
      FileUtils.createFileIfNotExits(((File)localObject).getAbsolutePath());
    }
    if (paramEncodeConfig.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderMediaMuxerWrapper == null)
    {
      this.jdField_a_of_type_AndroidMediaMediaMuxer = new MediaMuxer(paramEncodeConfig.jdField_a_of_type_JavaLangString, 0);
      this.jdField_a_of_type_AndroidMediaMediaMuxer.setOrientationHint(paramEncodeConfig.g);
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderMediaMuxerWrapper = paramEncodeConfig.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderMediaMuxerWrapper;
      this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderMediaMuxerWrapper.jdField_a_of_type_AndroidMediaMediaMuxer.setOrientationHint(paramEncodeConfig.g);
    }
    if (paramEncodeConfig.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderMuxerDataListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderMuxerDataListener = paramEncodeConfig.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderMuxerDataListener;
    }
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderMediaMuxerWrapper;
    if (localObject == null)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        paramByteBuffer.position(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.offset);
        paramByteBuffer.limit(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.offset + this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size);
        if (this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderMuxerDataListener != null)
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
          this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecEncoderMuxerDataListener.a(paramBufferInfo);
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
    MediaCodec localMediaCodec = this.jdField_a_of_type_AndroidMediaMediaCodec;
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
        this.jdField_a_of_type_AndroidMediaMediaCodec.release();
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
      this.jdField_a_of_type_AndroidMediaMediaCodec = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderMediaMuxerWrapper == null)
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
            if (QLog.isColorLevel()) {
              QLog.d("HWVideoEncoder", 2, "MediaMuxer stop.");
            }
          }
          this.jdField_a_of_type_AndroidMediaMediaMuxer.release();
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
        this.jdField_a_of_type_AndroidMediaMediaMuxer = null;
        return;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderMediaMuxerWrapper != null)
    {
      QLog.d("HWVideoEncoder", 1, "HWVideoEncoder release");
      this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderMediaMuxerWrapper.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.mediacodec.encoder.HWVideoEncoder
 * JD-Core Version:    0.7.0.1
 */