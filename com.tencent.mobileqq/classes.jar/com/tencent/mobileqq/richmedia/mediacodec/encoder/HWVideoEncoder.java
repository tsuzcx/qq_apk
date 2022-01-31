package com.tencent.mobileqq.richmedia.mediacodec.encoder;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.view.Surface;
import com.tencent.mobileqq.utils.FileUtils;
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
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoEncoder", 2, "drainEncoder(" + paramBoolean + ")");
    }
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HWVideoEncoder", 2, "sending EOS to encoder");
      }
      this.jdField_a_of_type_AndroidMediaMediaCodec.signalEndOfInputStream();
    }
    ByteBuffer[] arrayOfByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
    int i = 0;
    for (;;)
    {
      if ((this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo == null) && (QLog.isColorLevel())) {
        QLog.w("HWVideoEncoder", 2, "buffer info i null");
      }
      int j = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueOutputBuffer(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo, 10000L);
      if (j == -1) {
        if (!paramBoolean) {
          if (QLog.isColorLevel()) {
            QLog.d("HWVideoEncoder", 2, "no output available yet");
          }
        }
      }
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("HWVideoEncoder", 2, "no output available, spinning to await EOS");
        }
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
          if (this.jdField_a_of_type_Boolean) {
            throw new RuntimeException("format changed twice");
          }
          this.jdField_a_of_type_AndroidMediaMediaFormat = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputFormat();
          if (QLog.isColorLevel()) {
            QLog.d("HWVideoEncoder", 2, "encoder output format changed: " + this.jdField_a_of_type_AndroidMediaMediaFormat);
          }
          this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaMuxer.addTrack(this.jdField_a_of_type_AndroidMediaMediaFormat);
          this.jdField_a_of_type_AndroidMediaMediaMuxer.start();
          this.jdField_a_of_type_Boolean = true;
          break;
        }
        if (j < 0)
        {
          QLog.w("HWVideoEncoder", 2, "unexpected result from encoder.dequeueOutputBuffer: " + j);
          break;
        }
        ByteBuffer localByteBuffer = arrayOfByteBuffer[j];
        if (localByteBuffer == null) {
          throw new RuntimeException("encoderOutputBuffer " + j + " was null");
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
          if (!this.jdField_a_of_type_Boolean) {
            throw new RuntimeException("muxer hasn't started");
          }
          localByteBuffer.position(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.offset);
          localByteBuffer.limit(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.offset + this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size);
          this.jdField_a_of_type_AndroidMediaMediaMuxer.writeSampleData(this.jdField_a_of_type_Int, localByteBuffer, this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo);
          if (QLog.isColorLevel()) {
            QLog.d("HWVideoEncoder", 2, "sent " + this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size + " bytes to muxer, ts=" + this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs * 1000L);
          }
        }
        this.jdField_a_of_type_AndroidMediaMediaCodec.releaseOutputBuffer(j, false);
        if ((this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags & 0x4) == 0) {
          break label576;
        }
        if (!paramBoolean)
        {
          QLog.w("HWVideoEncoder", 2, "reached end of stream unexpectedly");
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("HWVideoEncoder", 2, "end of stream reached");
      return;
      label576:
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
  
  public void a(EncodeConfig paramEncodeConfig)
  {
    this.jdField_a_of_type_JavaLangString = paramEncodeConfig.jdField_a_of_type_JavaLangString;
    Object localObject = MediaFormat.createVideoFormat("video/avc", paramEncodeConfig.jdField_a_of_type_Int, paramEncodeConfig.jdField_b_of_type_Int);
    ((MediaFormat)localObject).setInteger("color-format", 2130708361);
    ((MediaFormat)localObject).setInteger("bitrate", paramEncodeConfig.c);
    ((MediaFormat)localObject).setInteger("frame-rate", paramEncodeConfig.d);
    ((MediaFormat)localObject).setInteger("i-frame-interval", paramEncodeConfig.e);
    if (paramEncodeConfig.j != -1) {
      ((MediaFormat)localObject).setInteger("bitrate-mode", paramEncodeConfig.j);
    }
    if (paramEncodeConfig.k != -1)
    {
      ((MediaFormat)localObject).setInteger("profile", 8);
      ((MediaFormat)localObject).setInteger("level", 32768);
    }
    if (paramEncodeConfig.jdField_b_of_type_Boolean)
    {
      ((MediaFormat)localObject).setInteger("profile", 1);
      ((MediaFormat)localObject).setInteger("level", 512);
    }
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoEncoder", 2, "start : encodeConfig = + " + paramEncodeConfig.toString() + " ; format: " + localObject);
    }
    this.jdField_a_of_type_AndroidMediaMediaCodec = MediaCodec.createEncoderByType("video/avc");
    this.jdField_a_of_type_AndroidMediaMediaCodec.configure((MediaFormat)localObject, null, null, 1);
    this.jdField_a_of_type_AndroidViewSurface = this.jdField_a_of_type_AndroidMediaMediaCodec.createInputSurface();
    this.jdField_a_of_type_AndroidMediaMediaCodec.start();
    localObject = new File(paramEncodeConfig.jdField_a_of_type_JavaLangString);
    if (!((File)localObject).exists()) {
      FileUtils.c(((File)localObject).getAbsolutePath());
    }
    this.jdField_a_of_type_AndroidMediaMediaMuxer = new MediaMuxer(paramEncodeConfig.jdField_a_of_type_JavaLangString, 0);
    this.jdField_a_of_type_AndroidMediaMediaMuxer.setOrientationHint(paramEncodeConfig.g);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HWVideoEncoder", 2, "HWVideoEncoder release.");
    }
    a(true);
    c();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaCodec != null) {}
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaCodec.stop();
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          this.jdField_a_of_type_AndroidMediaMediaCodec.release();
          this.jdField_a_of_type_AndroidMediaMediaCodec = null;
          if (this.jdField_a_of_type_AndroidMediaMediaMuxer != null) {}
          try
          {
            if (this.jdField_a_of_type_Boolean)
            {
              this.jdField_a_of_type_Boolean = false;
              this.jdField_a_of_type_AndroidMediaMediaMuxer.stop();
            }
            this.jdField_a_of_type_AndroidMediaMediaMuxer.release();
          }
          catch (Exception localException3)
          {
            for (;;)
            {
              QLog.w("HWVideoEncoder", 2, "Muxer stop exception:" + localException3);
            }
          }
          this.jdField_a_of_type_AndroidMediaMediaMuxer = null;
          return;
          localException1 = localException1;
          QLog.w("HWVideoEncoder", 2, "mEncoder stop exception:" + localException1);
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          QLog.w("HWVideoEncoder", 2, "mEncoder release exception:" + localException2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.encoder.HWVideoEncoder
 * JD-Core Version:    0.7.0.1
 */