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
    TLog.a("HWVideoDecoder.DecodeRunnable", "create DecodeRunnable filePath: " + paramString);
    this.jdField_a_of_type_AndroidViewSurface = paramSurface;
    if (paramHWDecodeListener != null) {}
    for (;;)
    {
      this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderHWDecodeListener = paramHWDecodeListener;
      this.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_Long = FileUtils.b(paramString);
      this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderDecodeConfig = new DecodeConfig(paramString, 0, true, false, 0L, this.jdField_a_of_type_Long);
      this.jdField_b_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderDecodeConfig = new DecodeConfig(paramString, 0, true, false, 0L, this.jdField_a_of_type_Long);
      return;
      paramHWDecodeListener = new EmptyHWDecodeListener();
    }
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
    for (;;)
    {
      int i;
      try
      {
        this.jdField_a_of_type_AndroidMediaMediaExtractor.setDataSource(this.jdField_a_of_type_JavaLangString);
        i = 0;
        if (i < this.jdField_a_of_type_AndroidMediaMediaExtractor.getTrackCount())
        {
          MediaFormat localMediaFormat;
          this.jdField_a_of_type_AndroidMediaMediaCodec.configure(localIllegalArgumentException, this.jdField_a_of_type_AndroidViewSurface, null, 0);
        }
      }
      catch (IOException localIOException)
      {
        try
        {
          localMediaFormat = this.jdField_a_of_type_AndroidMediaMediaExtractor.getTrackFormat(i);
          localObject = localMediaFormat.getString("mime");
          if (!((String)localObject).startsWith("video/")) {
            break label240;
          }
          this.jdField_a_of_type_Int = localMediaFormat.getInteger("width");
          this.jdField_b_of_type_Int = localMediaFormat.getInteger("height");
          this.jdField_a_of_type_AndroidMediaMediaExtractor.selectTrack(i);
          try
          {
            this.jdField_a_of_type_AndroidMediaMediaCodec = MediaCodec.createDecoderByType((String)localObject);
            if (this.jdField_a_of_type_AndroidViewSurface.isValid()) {
              break label187;
            }
            throw new RuntimeException("surface is not valid.");
          }
          catch (Throwable localThrowable)
          {
            if (!Thread.interrupted()) {
              break label203;
            }
          }
          TLog.c("HWVideoDecoder.DecodeRunnable", "Thread is interrupted.", localThrowable);
          return false;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          if (!Thread.interrupted()) {
            break label157;
          }
          TLog.c("HWVideoDecoder.DecodeRunnable", "Thread is interrupted.", localIllegalArgumentException);
          return false;
          localObject = new RuntimeException(localIllegalArgumentException);
          this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderHWDecodeListener.a(1, (Throwable)localObject);
          TLog.c("HWVideoDecoder.DecodeRunnable", "decode configure getTrackFormat error", localIllegalArgumentException);
          return false;
        }
        localIOException = localIOException;
        localIOException.printStackTrace();
        return false;
      }
      label157:
      label187:
      return true;
      label203:
      Object localObject = new RuntimeException(localIllegalArgumentException);
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderHWDecodeListener.a(1, (Throwable)localObject);
      }
      TLog.c("HWVideoDecoder.DecodeRunnable", "decode configure error", localIllegalArgumentException);
      return false;
      label240:
      i += 1;
    }
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
      TLog.b("HWVideoDecoder.DecodeRunnable", "end seekTo timecost=" + (System.currentTimeMillis() - l1) + " seekTargetTimeUs:" + paramLong + " realStartTime:" + l2);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        TLog.d("HWVideoDecoder.DecodeRunnable", "decoder flush error " + localRuntimeException.toString());
      }
    }
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
      RuntimeException localRuntimeException;
      return false;
    }
    catch (Throwable localThrowable)
    {
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
        if (this.jdField_a_of_type_Boolean) {
          break label148;
        }
        this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderHWDecodeListener.a(2, localException);
        TLog.c("HWVideoDecoder.DecodeRunnable", "decode start error2", localException);
      }
      localThrowable = localThrowable;
      if (Thread.interrupted())
      {
        TLog.c("HWVideoDecoder.DecodeRunnable", "Thread is interrupted.", localThrowable);
        return false;
      }
      localRuntimeException = new RuntimeException(localThrowable);
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderHWDecodeListener.a(2, localRuntimeException);
      }
      TLog.c("HWVideoDecoder.DecodeRunnable", "decode start error", localThrowable);
      return false;
    }
  }
  
  private void c()
  {
    int i = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueInputBuffer(10000L);
    if (i >= 0)
    {
      ByteBuffer localByteBuffer = this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[i];
      int j = this.jdField_a_of_type_AndroidMediaMediaExtractor.readSampleData(localByteBuffer, 0);
      long l1 = this.jdField_a_of_type_AndroidMediaMediaExtractor.getSampleTime();
      long l2 = this.jdField_b_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderDecodeConfig.jdField_a_of_type_Long;
      long l3 = this.jdField_b_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderDecodeConfig.jdField_b_of_type_Long * 1000L;
      TLog.b("HWVideoDecoder.DecodeRunnable", "intput sampleTime = " + l1 + " sampleSize = " + j + " endTime = " + l3);
      if ((j < 0) || ((l3 > 0L) && (l1 > l3)))
      {
        TLog.b("HWVideoDecoder.DecodeRunnable", "InputBuffer BUFFER_FLAG_END_OF_STREAM sampleTime=" + l1 + " endTime=" + l3 + " startTime=" + l2 * 1000L + " sampleSize=" + j);
        this.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(i, 0, 0, 0L, 4);
        this.jdField_b_of_type_Boolean = true;
        return;
      }
      l2 = this.jdField_c_of_type_Long;
      this.jdField_c_of_type_Long = l1;
      this.d = a(this.d, l1 - l2);
      this.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(i, 0, j, this.d, 0);
      this.jdField_a_of_type_AndroidMediaMediaExtractor.advance();
      return;
    }
    TLog.c("HWVideoDecoder.DecodeRunnable", "queueSampleToCodec inIndex = " + i);
  }
  
  private void d()
  {
    int i = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueOutputBuffer(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo, 10000L);
    switch (i)
    {
    default: 
      if ((this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags & 0x4) != 0)
      {
        TLog.b("HWVideoDecoder.DecodeRunnable", "output EOS");
        this.jdField_c_of_type_Boolean = true;
      }
      if (this.jdField_b_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderDecodeConfig.jdField_a_of_type_Boolean) {
        break;
      }
    case -3: 
    case -2: 
    case -1: 
      while (this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs / 1000L > System.currentTimeMillis() - this.jdField_b_of_type_Long)
      {
        try
        {
          Thread.sleep(10L);
        }
        catch (InterruptedException localInterruptedException1)
        {
          localInterruptedException1.printStackTrace();
          this.jdField_a_of_type_Boolean = true;
        }
        continue;
        TLog.b("HWVideoDecoder.DecodeRunnable", "INFO_OUTPUT_BUFFERS_CHANGED");
        this.jdField_b_of_type_ArrayOfJavaNioByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
        return;
        TLog.b("HWVideoDecoder.DecodeRunnable", "New format " + this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputFormat());
        return;
        TLog.b("HWVideoDecoder.DecodeRunnable", "dequeueOutputBuffer timed out!");
        return;
      }
    }
    if (this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_AndroidMediaMediaCodec.releaseOutputBuffer(i, bool);
      if (!bool) {
        break;
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
  }
  
  void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderDecodeConfig.jdField_a_of_type_Int = paramInt;
  }
  
  void a(long paramLong)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(1000L * paramLong);
  }
  
  void a(long paramLong1, long paramLong2)
  {
    if ((paramLong1 < 0L) || (paramLong2 < 0L)) {
      throw new IllegalArgumentException("both start time and end time should not less than 0");
    }
    if (paramLong2 < paramLong1) {
      throw new IllegalArgumentException("end time should not less than start time");
    }
    if (paramLong1 >= this.jdField_a_of_type_Long)
    {
      TLog.d("HWVideoDecoder.DecodeRunnable", "setPlayRange ignore, startTimeMs=" + paramLong1 + ", videoDuration=" + this.jdField_a_of_type_Long);
      return;
    }
    if (paramLong2 > this.jdField_a_of_type_Long) {
      paramLong2 = this.jdField_a_of_type_Long;
    }
    for (;;)
    {
      long l = paramLong2;
      if (paramLong2 == 0L) {
        l = this.jdField_a_of_type_Long;
      }
      if ((paramLong1 == this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderDecodeConfig.jdField_a_of_type_Long) && (l == this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderDecodeConfig.jdField_b_of_type_Long))
      {
        TLog.c("HWVideoDecoder.DecodeRunnable", "segment not changed, setPlayRange ignore, startTimeMs=" + paramLong1 + ", endTimeMs=" + l);
        return;
      }
      this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderDecodeConfig.jdField_a_of_type_Long = paramLong1;
      this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderDecodeConfig.jdField_b_of_type_Long = l;
      a(paramLong1);
      return;
    }
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
    if (!a()) {}
    while (!b()) {
      return;
    }
    long l2 = System.currentTimeMillis();
    TLog.b("HWVideoDecoder.DecodeRunnable", "decode ready time cost=" + (l2 - l1));
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
        l3 = System.currentTimeMillis();
        if (i != 0) {
          TLog.b("HWVideoDecoder.DecodeRunnable", "decode ready time cost=" + (l3 - l2));
        }
        if (this.jdField_c_of_type_Boolean)
        {
          TLog.b("HWVideoDecoder.DecodeRunnable", "OutputBuffer BUFFER_FLAG_END_OF_STREAM");
          if (this.jdField_b_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderDecodeConfig.jdField_b_of_type_Boolean)
          {
            b(l1);
            this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderHWDecodeListener.d();
          }
        }
      }
      catch (Throwable localThrowable)
      {
        while (Thread.interrupted()) {
          TLog.c("HWVideoDecoder.DecodeRunnable", "Thread is interrupted.", localThrowable);
        }
        RuntimeException localRuntimeException = new RuntimeException(localThrowable);
        if (!this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderHWDecodeListener.a(3, localRuntimeException);
        }
        TLog.c("HWVideoDecoder.DecodeRunnable", "decode configure error", localThrowable);
        return;
      }
    }
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaCodec.stop();
      this.jdField_a_of_type_AndroidMediaMediaCodec.release();
      this.jdField_a_of_type_AndroidMediaMediaExtractor.release();
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderHWDecodeListener.b();
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        TLog.d("HWVideoDecoder.DecodeRunnable", "decoder stop error " + localException.toString());
      }
      this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecDecoderHWDecodeListener.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.mediacodec.decoder.HWVideoDecoder.DecodeRunnable
 * JD-Core Version:    0.7.0.1
 */