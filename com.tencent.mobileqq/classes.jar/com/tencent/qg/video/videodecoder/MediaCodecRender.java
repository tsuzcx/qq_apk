package com.tencent.qg.video.videodecoder;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.qg.video.VideoPerformanceMonitor;
import java.io.IOException;
import java.nio.ByteBuffer;

@TargetApi(16)
public abstract class MediaCodecRender
{
  protected long a;
  protected MediaCodec.BufferInfo a;
  protected MediaCodec a;
  protected MediaExtractor a;
  protected MediaFormat a;
  protected MediaCodecRender.MediaCodecInfo a;
  protected MediaCodecRender.MediaContext a;
  protected MediaDecoder.DecodeListener a;
  protected boolean a;
  protected ByteBuffer[] a;
  protected long b;
  protected boolean b;
  protected ByteBuffer[] b;
  protected long c;
  
  public long a()
  {
    MediaCodec.BufferInfo localBufferInfo = this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo;
    if (localBufferInfo != null) {
      return localBufferInfo.presentationTimeUs;
    }
    return 0L;
  }
  
  public long a(long paramLong)
  {
    long l1 = System.currentTimeMillis();
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaCodec.flush();
    }
    catch (RuntimeException localRuntimeException)
    {
      SLog.c(a(), "decoder flush error %s", localRuntimeException);
    }
    this.jdField_a_of_type_AndroidMediaMediaExtractor.seekTo(paramLong, 0);
    long l2 = this.jdField_a_of_type_AndroidMediaMediaExtractor.getSampleTime();
    Object localObject = this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaDecoder$DecodeListener;
    if (localObject != null) {
      ((MediaDecoder.DecodeListener)localObject).b(l2 / 1000L);
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Long = l2;
    this.c = l2;
    this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo = new MediaCodec.BufferInfo();
    this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs = l2;
    this.jdField_a_of_type_Long = (System.currentTimeMillis() - l2 / 1000L);
    localObject = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("end seekTo timecost=");
    localStringBuilder.append(System.currentTimeMillis() - l1);
    localStringBuilder.append(" seekTargetTimeUs:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" realStartTime:");
    localStringBuilder.append(l2);
    SLog.b((String)localObject, localStringBuilder.toString());
    return l2;
  }
  
  protected abstract String a();
  
  public void a()
  {
    this.jdField_a_of_type_Long = (System.currentTimeMillis() - this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs / 1000L);
  }
  
  protected abstract void a(MediaCodec paramMediaCodec, MediaCodec.BufferInfo paramBufferInfo);
  
  protected abstract void a(MediaCodecRender.MediaCodecInfo paramMediaCodecInfo, MediaCodec paramMediaCodec, MediaFormat paramMediaFormat);
  
  public boolean a()
  {
    long l = this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaCodecRender$MediaContext.jdField_a_of_type_Long;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(a());
    ((StringBuilder)localObject).append("] init now");
    VideoPerformanceMonitor.a(l, ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_AndroidMediaMediaCodec = null;
    this.jdField_a_of_type_AndroidMediaMediaExtractor = new MediaExtractor();
    boolean bool2 = false;
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaExtractor.setDataSource(this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaCodecRender$MediaCodecInfo.b);
      l = this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaCodecRender$MediaContext.jdField_a_of_type_Long;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(a());
      ((StringBuilder)localObject).append("] extractor setDataSource");
      VideoPerformanceMonitor.a(l, ((StringBuilder)localObject).toString());
      int i = 0;
      boolean bool1;
      for (;;)
      {
        bool1 = bool2;
        if (i >= this.jdField_a_of_type_AndroidMediaMediaExtractor.getTrackCount()) {
          break;
        }
        this.jdField_a_of_type_AndroidMediaMediaFormat = this.jdField_a_of_type_AndroidMediaMediaExtractor.getTrackFormat(i);
        localObject = this.jdField_a_of_type_AndroidMediaMediaFormat.getString("mime");
        if (((String)localObject).startsWith(this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaCodecRender$MediaCodecInfo.a))
        {
          this.jdField_a_of_type_AndroidMediaMediaExtractor.selectTrack(i);
          l = this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaCodecRender$MediaContext.jdField_a_of_type_Long;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[");
          localStringBuilder.append(a());
          localStringBuilder.append("] find and selectTrack");
          VideoPerformanceMonitor.a(l, localStringBuilder.toString());
          try
          {
            this.jdField_a_of_type_AndroidMediaMediaCodec = MediaCodec.createDecoderByType((String)localObject);
            l = this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaCodecRender$MediaContext.jdField_a_of_type_Long;
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("[");
            ((StringBuilder)localObject).append(a());
            ((StringBuilder)localObject).append("] create codec");
            VideoPerformanceMonitor.a(l, ((StringBuilder)localObject).toString());
            a(this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaCodecRender$MediaCodecInfo, this.jdField_a_of_type_AndroidMediaMediaCodec, this.jdField_a_of_type_AndroidMediaMediaFormat);
            l = this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaCodecRender$MediaContext.jdField_a_of_type_Long;
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("[");
            ((StringBuilder)localObject).append(a());
            ((StringBuilder)localObject).append("] configureCodec");
            VideoPerformanceMonitor.a(l, ((StringBuilder)localObject).toString());
            bool1 = true;
          }
          catch (Throwable localThrowable)
          {
            SLog.b(a(), "init createDecoderByType error :%s", localThrowable);
            bool1 = bool2;
          }
        }
        i += 1;
      }
      if (bool1)
      {
        SLog.b(a(), "create media decoder success!");
        return bool1;
      }
      SLog.d(a(), "create media decoder error!");
      return bool1;
    }
    catch (IOException localIOException)
    {
      SLog.b(a(), "init set data source error :%s", localIOException);
    }
    return false;
  }
  
  public long b()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void b()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidMediaMediaCodec != null)
      {
        this.jdField_a_of_type_AndroidMediaMediaCodec.stop();
        this.jdField_a_of_type_AndroidMediaMediaCodec.release();
        this.jdField_a_of_type_AndroidMediaMediaCodec = null;
      }
      if (this.jdField_a_of_type_AndroidMediaMediaExtractor != null)
      {
        this.jdField_a_of_type_AndroidMediaMediaExtractor.release();
        this.jdField_a_of_type_AndroidMediaMediaExtractor = null;
        return;
      }
    }
    catch (Exception localException)
    {
      SLog.c(a(), "onRelease error :%s ", localException);
    }
  }
  
  public boolean b()
  {
    SLog.a(a(), "start ! %s", this.jdField_a_of_type_ComTencentQgVideoVideodecoderMediaCodecRender$MediaCodecInfo);
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaCodec.start();
      try
      {
        this.jdField_a_of_type_ArrayOfJavaNioByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getInputBuffers();
        this.jdField_b_of_type_ArrayOfJavaNioByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
        this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo = new MediaCodec.BufferInfo();
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        return true;
      }
      catch (Exception localException)
      {
        SLog.c(a(), "decode start error :%s", localException);
        return false;
      }
      return false;
    }
    catch (Throwable localThrowable)
    {
      SLog.c(a(), "decode start error", localThrowable);
    }
  }
  
  public void c()
  {
    if (!this.jdField_a_of_type_Boolean) {
      d();
    }
    if (!this.jdField_b_of_type_Boolean) {
      a(this.jdField_a_of_type_AndroidMediaMediaCodec, this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo);
    }
    boolean bool = this.jdField_b_of_type_Boolean;
  }
  
  public boolean c()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  protected void d()
  {
    int i = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueInputBuffer(10000L);
    if (i >= 0)
    {
      ByteBuffer localByteBuffer = this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[i];
      int j = this.jdField_a_of_type_AndroidMediaMediaExtractor.readSampleData(localByteBuffer, 0);
      long l1 = this.jdField_a_of_type_AndroidMediaMediaExtractor.getSampleTime();
      if (j < 0)
      {
        this.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(i, 0, 0, 0L, 4);
        this.jdField_a_of_type_Boolean = true;
        return;
      }
      long l2 = this.jdField_b_of_type_Long;
      this.jdField_b_of_type_Long = l1;
      this.c += l1 - l2;
      this.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(i, 0, j, this.c, 0);
      this.jdField_a_of_type_AndroidMediaMediaExtractor.advance();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qg.video.videodecoder.MediaCodecRender
 * JD-Core Version:    0.7.0.1
 */