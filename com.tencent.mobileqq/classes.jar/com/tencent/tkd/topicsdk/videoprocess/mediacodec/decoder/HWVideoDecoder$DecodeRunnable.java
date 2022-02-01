package com.tencent.tkd.topicsdk.videoprocess.mediacodec.decoder;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.tkd.topicsdk.common.FileUtils;
import com.tencent.tkd.topicsdk.framework.TLog;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicLong;

class HWVideoDecoder$DecodeRunnable
  implements Runnable
{
  private int jdField_a_of_type_Int;
  final long jdField_a_of_type_Long;
  MediaCodec.BufferInfo jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo;
  private MediaCodec jdField_a_of_type_AndroidMediaMediaCodec;
  private MediaExtractor jdField_a_of_type_AndroidMediaMediaExtractor;
  private Surface jdField_a_of_type_AndroidViewSurface;
  private final DecodeConfig jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderDecodeConfig;
  private final HWDecodeListener jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderHWDecodeListener;
  private final String jdField_a_of_type_JavaLangString;
  private final AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(-1L);
  boolean jdField_a_of_type_Boolean = false;
  ByteBuffer[] jdField_a_of_type_ArrayOfJavaNioByteBuffer;
  private int jdField_b_of_type_Int;
  long jdField_b_of_type_Long = System.currentTimeMillis();
  private final DecodeConfig jdField_b_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderDecodeConfig;
  private boolean jdField_b_of_type_Boolean = false;
  ByteBuffer[] jdField_b_of_type_ArrayOfJavaNioByteBuffer;
  private long jdField_c_of_type_Long = 0L;
  private boolean jdField_c_of_type_Boolean = false;
  private long d = 0L;
  
  HWVideoDecoder$DecodeRunnable(String paramString, Surface paramSurface, HWDecodeListener paramHWDecodeListener)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("create DecodeRunnable filePath: ");
    localStringBuilder.append(paramString);
    TLog.a("HWVideoDecoder.DecodeRunnable", localStringBuilder.toString());
    this.jdField_a_of_type_AndroidViewSurface = paramSurface;
    if (paramHWDecodeListener == null) {
      paramHWDecodeListener = new EmptyHWDecodeListener();
    }
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderHWDecodeListener = paramHWDecodeListener;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = FileUtils.b(paramString);
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderDecodeConfig = new DecodeConfig(paramString, 0, true, false, 0L, this.jdField_a_of_type_Long);
    this.jdField_b_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderDecodeConfig = new DecodeConfig(paramString, 0, true, false, 0L, this.jdField_a_of_type_Long);
  }
  
  private long a(long paramLong1, long paramLong2)
  {
    return paramLong1 + paramLong2;
  }
  
  private void a()
  {
    this.jdField_c_of_type_Long = 0L;
  }
  
  private boolean a()
  {
    this.jdField_a_of_type_AndroidMediaMediaExtractor = new MediaExtractor();
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaExtractor.setDataSource(this.jdField_a_of_type_JavaLangString);
      int i = 0;
      while (i < this.jdField_a_of_type_AndroidMediaMediaExtractor.getTrackCount()) {
        try
        {
          MediaFormat localMediaFormat = this.jdField_a_of_type_AndroidMediaMediaExtractor.getTrackFormat(i);
          localObject = localMediaFormat.getString("mime");
          if (((String)localObject).startsWith("video/"))
          {
            this.jdField_a_of_type_Int = localMediaFormat.getInteger("width");
            this.jdField_b_of_type_Int = localMediaFormat.getInteger("height");
            this.jdField_a_of_type_AndroidMediaMediaExtractor.selectTrack(i);
            try
            {
              this.jdField_a_of_type_AndroidMediaMediaCodec = MediaCodec.createDecoderByType((String)localObject);
              if (this.jdField_a_of_type_AndroidViewSurface.isValid())
              {
                this.jdField_a_of_type_AndroidMediaMediaCodec.configure(localMediaFormat, this.jdField_a_of_type_AndroidViewSurface, null, 0);
                return true;
              }
              throw new RuntimeException("surface is not valid.");
            }
            catch (Throwable localThrowable)
            {
              if (Thread.interrupted())
              {
                TLog.b("HWVideoDecoder.DecodeRunnable", "Thread is interrupted.", localThrowable);
                return false;
              }
              localObject = new RuntimeException(localThrowable);
              if (!this.jdField_a_of_type_Boolean) {
                this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderHWDecodeListener.a(1, (Throwable)localObject);
              }
              TLog.b("HWVideoDecoder.DecodeRunnable", "decode configure error", localThrowable);
              return false;
            }
          }
          i += 1;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          if (Thread.interrupted())
          {
            TLog.b("HWVideoDecoder.DecodeRunnable", "Thread is interrupted.", localIllegalArgumentException);
            return false;
          }
          Object localObject = new RuntimeException(localIllegalArgumentException);
          this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderHWDecodeListener.a(1, (Throwable)localObject);
          TLog.b("HWVideoDecoder.DecodeRunnable", "decode configure getTrackFormat error", localIllegalArgumentException);
          return false;
        }
      }
      return true;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return false;
  }
  
  private void b()
  {
    if (!this.jdField_b_of_type_Boolean) {
      c();
    }
    if (!this.jdField_c_of_type_Boolean) {
      d();
    }
  }
  
  private void b(long paramLong)
  {
    long l1 = System.currentTimeMillis();
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaCodec.flush();
    }
    catch (RuntimeException localRuntimeException)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("decoder flush error ");
      localStringBuilder2.append(localRuntimeException.toString());
      TLog.d("HWVideoDecoder.DecodeRunnable", localStringBuilder2.toString());
    }
    this.jdField_a_of_type_AndroidMediaMediaExtractor.seekTo(paramLong, 0);
    long l2 = this.jdField_a_of_type_AndroidMediaMediaExtractor.getSampleTime();
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderHWDecodeListener.b(l2 / 1000L);
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    if (l2 == -1L) {
      a();
    }
    this.jdField_c_of_type_Long = l2;
    this.d = 0L;
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("end seekTo timecost=");
    localStringBuilder1.append(System.currentTimeMillis() - l1);
    localStringBuilder1.append(" seekTargetTimeUs:");
    localStringBuilder1.append(paramLong);
    localStringBuilder1.append(" realStartTime:");
    localStringBuilder1.append(l2);
    TLog.b("HWVideoDecoder.DecodeRunnable", localStringBuilder1.toString());
  }
  
  private boolean b()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaCodec == null)
    {
      TLog.d("HWVideoDecoder.DecodeRunnable", "Can't find video info!");
      return false;
    }
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderHWDecodeListener.a();
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaCodec.start();
      try
      {
        this.jdField_a_of_type_ArrayOfJavaNioByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getInputBuffers();
        this.jdField_b_of_type_ArrayOfJavaNioByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
        this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo = new MediaCodec.BufferInfo();
        this.jdField_b_of_type_Long = System.currentTimeMillis();
        return true;
      }
      catch (Exception localException)
      {
        if (!this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderHWDecodeListener.a(2, localException);
        }
        TLog.b("HWVideoDecoder.DecodeRunnable", "decode start error2", localException);
        return false;
      }
      RuntimeException localRuntimeException;
      return false;
    }
    catch (Throwable localThrowable)
    {
      if (Thread.interrupted())
      {
        TLog.b("HWVideoDecoder.DecodeRunnable", "Thread is interrupted.", localThrowable);
        return false;
      }
      localRuntimeException = new RuntimeException(localThrowable);
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderHWDecodeListener.a(2, localRuntimeException);
      }
      TLog.b("HWVideoDecoder.DecodeRunnable", "decode start error", localThrowable);
    }
  }
  
  private void c()
  {
    int i = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueInputBuffer(10000L);
    if (i >= 0)
    {
      localObject = this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[i];
      int j = this.jdField_a_of_type_AndroidMediaMediaExtractor.readSampleData((ByteBuffer)localObject, 0);
      long l1 = this.jdField_a_of_type_AndroidMediaMediaExtractor.getSampleTime();
      long l2 = this.jdField_b_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderDecodeConfig.jdField_a_of_type_Long;
      long l3 = this.jdField_b_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderDecodeConfig.jdField_b_of_type_Long * 1000L;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("intput sampleTime = ");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append(" sampleSize = ");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(" endTime = ");
      ((StringBuilder)localObject).append(l3);
      TLog.b("HWVideoDecoder.DecodeRunnable", ((StringBuilder)localObject).toString());
      if ((j >= 0) && ((l3 <= 0L) || (l1 <= l3)))
      {
        l2 = this.jdField_c_of_type_Long;
        this.jdField_c_of_type_Long = l1;
        this.d = a(this.d, l1 - l2);
        this.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(i, 0, j, this.d, 0);
        this.jdField_a_of_type_AndroidMediaMediaExtractor.advance();
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("InputBuffer BUFFER_FLAG_END_OF_STREAM sampleTime=");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append(" endTime=");
      ((StringBuilder)localObject).append(l3);
      ((StringBuilder)localObject).append(" startTime=");
      ((StringBuilder)localObject).append(l2 * 1000L);
      ((StringBuilder)localObject).append(" sampleSize=");
      ((StringBuilder)localObject).append(j);
      TLog.b("HWVideoDecoder.DecodeRunnable", ((StringBuilder)localObject).toString());
      this.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(i, 0, 0, 0L, 4);
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("queueSampleToCodec inIndex = ");
    ((StringBuilder)localObject).append(i);
    TLog.c("HWVideoDecoder.DecodeRunnable", ((StringBuilder)localObject).toString());
  }
  
  private void d()
  {
    int i = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueOutputBuffer(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo, 10000L);
    if (i != -3)
    {
      if (i != -2)
      {
        if (i != -1)
        {
          if ((this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags & 0x4) != 0)
          {
            TLog.b("HWVideoDecoder.DecodeRunnable", "output EOS");
            this.jdField_c_of_type_Boolean = true;
          }
          if (!this.jdField_b_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderDecodeConfig.jdField_a_of_type_Boolean) {
            while (this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs / 1000L > System.currentTimeMillis() - this.jdField_b_of_type_Long) {
              try
              {
                Thread.sleep(10L);
              }
              catch (InterruptedException localInterruptedException1)
              {
                localInterruptedException1.printStackTrace();
                this.jdField_a_of_type_Boolean = true;
              }
            }
          }
          boolean bool;
          if (this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size != 0) {
            bool = true;
          } else {
            bool = false;
          }
          this.jdField_a_of_type_AndroidMediaMediaCodec.releaseOutputBuffer(i, bool);
          if (!bool) {
            return;
          }
          try
          {
            this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderHWDecodeListener.a(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs * 1000L);
            return;
          }
          catch (InterruptedException localInterruptedException2)
          {
            localInterruptedException2.printStackTrace();
            this.jdField_a_of_type_Boolean = true;
            return;
          }
        }
        TLog.b("HWVideoDecoder.DecodeRunnable", "dequeueOutputBuffer timed out!");
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("New format ");
        localStringBuilder.append(this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputFormat());
        TLog.b("HWVideoDecoder.DecodeRunnable", localStringBuilder.toString());
      }
    }
    else
    {
      TLog.b("HWVideoDecoder.DecodeRunnable", "INFO_OUTPUT_BUFFERS_CHANGED");
      this.jdField_b_of_type_ArrayOfJavaNioByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
    }
  }
  
  void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderDecodeConfig.jdField_a_of_type_Int = paramInt;
  }
  
  void a(long paramLong)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(paramLong * 1000L);
  }
  
  void a(long paramLong1, long paramLong2)
  {
    if ((paramLong1 >= 0L) && (paramLong2 >= 0L))
    {
      if (paramLong2 >= paramLong1)
      {
        long l2 = this.jdField_a_of_type_Long;
        if (paramLong1 >= l2)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("setPlayRange ignore, startTimeMs=");
          ((StringBuilder)localObject).append(paramLong1);
          ((StringBuilder)localObject).append(", videoDuration=");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
          TLog.d("HWVideoDecoder.DecodeRunnable", ((StringBuilder)localObject).toString());
          return;
        }
        long l1 = paramLong2;
        if (paramLong2 > l2) {
          l1 = l2;
        }
        paramLong2 = l1;
        if (l1 == 0L) {
          paramLong2 = this.jdField_a_of_type_Long;
        }
        if ((paramLong1 == this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderDecodeConfig.jdField_a_of_type_Long) && (paramLong2 == this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderDecodeConfig.jdField_b_of_type_Long))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("segment not changed, setPlayRange ignore, startTimeMs=");
          ((StringBuilder)localObject).append(paramLong1);
          ((StringBuilder)localObject).append(", endTimeMs=");
          ((StringBuilder)localObject).append(paramLong2);
          TLog.c("HWVideoDecoder.DecodeRunnable", ((StringBuilder)localObject).toString());
          return;
        }
        Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderDecodeConfig;
        ((DecodeConfig)localObject).jdField_a_of_type_Long = paramLong1;
        ((DecodeConfig)localObject).jdField_b_of_type_Long = paramLong2;
        a(paramLong1);
        return;
      }
      throw new IllegalArgumentException("end time should not less than start time");
    }
    throw new IllegalArgumentException("both start time and end time should not less than 0");
  }
  
  void a(DecodeConfig paramDecodeConfig)
  {
    if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramDecodeConfig.jdField_a_of_type_JavaLangString)) {
      TLog.c("HWVideoDecoder.DecodeRunnable", "DecodeRunnable does not support changing the file");
    }
    a(paramDecodeConfig.jdField_a_of_type_Int);
    a(paramDecodeConfig.jdField_a_of_type_Long, paramDecodeConfig.jdField_b_of_type_Long);
    b(paramDecodeConfig.jdField_b_of_type_Boolean);
    a(paramDecodeConfig.jdField_a_of_type_Boolean);
  }
  
  void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderDecodeConfig.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderDecodeConfig.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    this.jdField_b_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderDecodeConfig.a(this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderDecodeConfig);
    if (!a()) {
      return;
    }
    if (!b()) {
      return;
    }
    long l2 = System.currentTimeMillis();
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("decode ready time cost=");
    localStringBuilder1.append(l2 - l1);
    TLog.b("HWVideoDecoder.DecodeRunnable", localStringBuilder1.toString());
    label302:
    Object localObject;
    while ((!Thread.interrupted()) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_b_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderDecodeConfig.a(this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderDecodeConfig);
      l1 = this.jdField_b_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderDecodeConfig.jdField_a_of_type_Long * 1000L;
      l2 = this.jdField_b_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderDecodeConfig.jdField_b_of_type_Long;
      int j = 0;
      long l3 = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get();
      int i = j;
      if (l3 >= 0L)
      {
        i = j;
        if (l3 >= l1)
        {
          i = j;
          if (l3 <= l2 * 1000L)
          {
            b(l3);
            i = 1;
          }
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.compareAndSet(l3, -1L);
      l2 = System.currentTimeMillis();
      try
      {
        b();
      }
      catch (Throwable localThrowable)
      {
        if (!Thread.interrupted()) {
          break label302;
        }
      }
      TLog.b("HWVideoDecoder.DecodeRunnable", "Thread is interrupted.", localThrowable);
      l3 = System.currentTimeMillis();
      StringBuilder localStringBuilder2;
      if (i != 0)
      {
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("decode ready time cost=");
        localStringBuilder2.append(l3 - l2);
        TLog.b("HWVideoDecoder.DecodeRunnable", localStringBuilder2.toString());
      }
      if (this.jdField_c_of_type_Boolean)
      {
        TLog.b("HWVideoDecoder.DecodeRunnable", "OutputBuffer BUFFER_FLAG_END_OF_STREAM");
        if (this.jdField_b_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderDecodeConfig.jdField_b_of_type_Boolean)
        {
          b(l1);
          this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderHWDecodeListener.d();
          continue;
          localObject = new RuntimeException(localStringBuilder2);
          if (!this.jdField_a_of_type_Boolean) {
            this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderHWDecodeListener.a(3, (Throwable)localObject);
          }
          TLog.b("HWVideoDecoder.DecodeRunnable", "decode configure error", localStringBuilder2);
          return;
        }
      }
    }
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaCodec.stop();
      this.jdField_a_of_type_AndroidMediaMediaCodec.release();
      this.jdField_a_of_type_AndroidMediaMediaExtractor.release();
    }
    catch (Exception localException)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("decoder stop error ");
      ((StringBuilder)localObject).append(localException.toString());
      TLog.d("HWVideoDecoder.DecodeRunnable", ((StringBuilder)localObject).toString());
    }
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderHWDecodeListener.b();
      return;
    }
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderHWDecodeListener.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.mediacodec.decoder.HWVideoDecoder.DecodeRunnable
 * JD-Core Version:    0.7.0.1
 */