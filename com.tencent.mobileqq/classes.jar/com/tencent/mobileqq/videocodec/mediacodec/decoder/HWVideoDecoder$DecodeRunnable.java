package com.tencent.mobileqq.videocodec.mediacodec.decoder;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.editor.composite.util.CompositeUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicLong;

class HWVideoDecoder$DecodeRunnable
  implements Runnable
{
  private int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = System.currentTimeMillis();
  MediaCodec.BufferInfo jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo;
  private MediaCodec jdField_a_of_type_AndroidMediaMediaCodec;
  private MediaExtractor jdField_a_of_type_AndroidMediaMediaExtractor;
  private Surface jdField_a_of_type_AndroidViewSurface;
  private final DecodeConfig jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecDecoderDecodeConfig;
  @NonNull
  private final HWDecodeListener jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecDecoderHWDecodeListener;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString = "HWVideoDecoder.DecodeRunnable";
  private final AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(-1L);
  boolean jdField_a_of_type_Boolean = false;
  ByteBuffer[] jdField_a_of_type_ArrayOfJavaNioByteBuffer;
  private int jdField_b_of_type_Int;
  public final long b;
  private final DecodeConfig jdField_b_of_type_ComTencentMobileqqVideocodecMediacodecDecoderDecodeConfig;
  private final String jdField_b_of_type_JavaLangString;
  private final AtomicLong jdField_b_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(-1L);
  private boolean jdField_b_of_type_Boolean = false;
  ByteBuffer[] jdField_b_of_type_ArrayOfJavaNioByteBuffer;
  private long jdField_c_of_type_Long = 0L;
  private boolean jdField_c_of_type_Boolean = false;
  private long jdField_d_of_type_Long = 0L;
  private boolean jdField_d_of_type_Boolean = false;
  private volatile boolean e = false;
  
  public HWVideoDecoder$DecodeRunnable(@NonNull String paramString, Surface paramSurface, HWDecodeListener paramHWDecodeListener)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("HWVideoDecoder.DecodeRunnable.");
    localStringBuilder.append(hashCode());
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    SLog.b("HWVideoDecoder.DecodeRunnable", "create DecodeRunnable filePath: %s", paramString);
    this.jdField_a_of_type_AndroidViewSurface = paramSurface;
    if (paramHWDecodeListener == null) {
      paramHWDecodeListener = new EmptyHWDecodeListener();
    }
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecDecoderHWDecodeListener = paramHWDecodeListener;
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Long = CompositeUtil.a(paramString);
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecDecoderDecodeConfig = new DecodeConfig(paramString, 0, true, false, 0L, this.jdField_b_of_type_Long);
    this.jdField_b_of_type_ComTencentMobileqqVideocodecMediacodecDecoderDecodeConfig = new DecodeConfig(paramString, 0, true, false, 0L, this.jdField_b_of_type_Long);
  }
  
  private long a(int paramInt, long paramLong1, long paramLong2)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return paramLong1 + paramLong2;
        }
        return paramLong1 - paramLong2;
      }
      Long.signum(paramLong2);
    }
    for (paramLong2 *= 2L;; paramLong2 /= 2L) {
      return paramLong1 + paramLong2;
    }
  }
  
  private long a(long paramLong)
  {
    long l1 = System.currentTimeMillis();
    StringBuilder localStringBuilder;
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaCodec.flush();
    }
    catch (RuntimeException localRuntimeException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("decoder flush error ");
      localStringBuilder.append(localRuntimeException.toString());
      QLog.e("HWVideoDecoder.DecodeRunnable", 1, localStringBuilder.toString());
    }
    this.jdField_a_of_type_AndroidMediaMediaExtractor.seekTo(paramLong, 0);
    long l2 = this.jdField_a_of_type_AndroidMediaMediaExtractor.getSampleTime();
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecDecoderHWDecodeListener.b(l2 / 1000L);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    if (l2 == -1L) {
      a();
    }
    this.jdField_c_of_type_Long = l2;
    this.jdField_d_of_type_Long = 0L;
    if (QLog.isColorLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("end seekTo seekTime=");
      localStringBuilder.append(0);
      localStringBuilder.append(" timecost=");
      localStringBuilder.append(System.currentTimeMillis() - l1);
      localStringBuilder.append(" seekTargetTimeUs:");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" realStartTime:");
      localStringBuilder.append(l2);
      QLog.d(str, 4, localStringBuilder.toString());
    }
    return l2;
  }
  
  private void a()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqVideocodecMediacodecDecoderDecodeConfig.jdField_a_of_type_Int == 3)
    {
      this.jdField_c_of_type_Long = (this.jdField_b_of_type_ComTencentMobileqqVideocodecMediacodecDecoderDecodeConfig.jdField_b_of_type_Long * 1000L);
      return;
    }
    this.jdField_c_of_type_Long = 0L;
  }
  
  private boolean a()
  {
    this.jdField_a_of_type_AndroidMediaMediaExtractor = new MediaExtractor();
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaExtractor.setDataSource(this.jdField_b_of_type_JavaLangString);
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
            if (this.jdField_b_of_type_ComTencentMobileqqVideocodecMediacodecDecoderDecodeConfig.jdField_c_of_type_Boolean) {
              i = this.jdField_b_of_type_ComTencentMobileqqVideocodecMediacodecDecoderDecodeConfig.jdField_b_of_type_Int;
            } else {
              i = 0;
            }
            localMediaFormat.setInteger("rotation-degrees", i);
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
                QLog.e(this.jdField_a_of_type_JavaLangString, 2, "Thread is interrupted.", localThrowable);
                return false;
              }
              localObject = new RuntimeException(localThrowable);
              if (!this.jdField_a_of_type_Boolean) {
                this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecDecoderHWDecodeListener.a(1, (Throwable)localObject);
              }
              QLog.e(this.jdField_a_of_type_JavaLangString, 2, "decode configure error", localThrowable);
              return false;
            }
          }
          i += 1;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          if (Thread.interrupted())
          {
            QLog.e(this.jdField_a_of_type_JavaLangString, 2, "Thread is interrupted.", localIllegalArgumentException);
            return false;
          }
          Object localObject = new RuntimeException(localIllegalArgumentException);
          this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecDecoderHWDecodeListener.a(1, (Throwable)localObject);
          QLog.e(this.jdField_a_of_type_JavaLangString, 2, "decode configure getTrackFormat error", localIllegalArgumentException);
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
  
  private boolean a(boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueOutputBuffer(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo, 10000L);
    if (i != -3)
    {
      StringBuilder localStringBuilder;
      if (i != -2)
      {
        if (i != -1)
        {
          if ((this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags & 0x4) != 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "output EOS");
            }
            this.jdField_c_of_type_Boolean = true;
          }
          paramBoolean = a(paramBoolean, this.jdField_c_of_type_Long / 1000L);
          if (QLog.isColorLevel())
          {
            String str1 = this.jdField_a_of_type_JavaLangString;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("checkToRender, render :");
            localStringBuilder.append(paramBoolean);
            localStringBuilder.append(" info.presentationTimeUs:");
            localStringBuilder.append(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs / 1000L);
            localStringBuilder.append(" - ");
            localStringBuilder.append(System.currentTimeMillis() - this.jdField_a_of_type_Long);
            QLog.d(str1, 2, localStringBuilder.toString());
          }
          if ((!this.jdField_b_of_type_ComTencentMobileqqVideocodecMediacodecDecoderDecodeConfig.jdField_a_of_type_Boolean) && (paramBoolean)) {
            while (this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs / 1000L > System.currentTimeMillis() - this.jdField_a_of_type_Long) {
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
          if ((paramBoolean) && (this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size != 0)) {
            paramBoolean = true;
          } else {
            paramBoolean = false;
          }
          this.jdField_a_of_type_AndroidMediaMediaCodec.releaseOutputBuffer(i, paramBoolean);
          if (!paramBoolean) {
            break label403;
          }
          try
          {
            this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecDecoderHWDecodeListener.a(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs * 1000L);
            return true;
          }
          catch (InterruptedException localInterruptedException2)
          {
            localInterruptedException2.printStackTrace();
            this.jdField_a_of_type_Boolean = true;
            return true;
          }
        }
        if (QLog.isColorLevel())
        {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "dequeueOutputBuffer timed out!");
          return true;
        }
      }
      else if (QLog.isColorLevel())
      {
        String str2 = this.jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("New format ");
        localStringBuilder.append(this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputFormat());
        QLog.d(str2, 2, localStringBuilder.toString());
        return true;
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "INFO_OUTPUT_BUFFERS_CHANGED");
      }
      this.jdField_b_of_type_ArrayOfJavaNioByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
    }
    label403:
    return true;
  }
  
  private boolean a(boolean paramBoolean, long paramLong)
  {
    if (!this.jdField_d_of_type_Boolean) {
      return paramBoolean;
    }
    if (!paramBoolean) {
      return paramBoolean;
    }
    if (this.jdField_c_of_type_Boolean) {
      return false;
    }
    long l = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicLong.get();
    if (l <= 0L) {
      return paramBoolean;
    }
    StringBuilder localStringBuilder;
    if ((l > this.jdField_b_of_type_ComTencentMobileqqVideocodecMediacodecDecoderDecodeConfig.jdField_a_of_type_Long) && (l < this.jdField_b_of_type_ComTencentMobileqqVideocodecMediacodecDecoderDecodeConfig.jdField_b_of_type_Long))
    {
      if (l > paramLong)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("checkToRender, do not render, renderpos:");
          localStringBuilder.append(l);
          localStringBuilder.append(" sampletime:");
          localStringBuilder.append(paramLong);
          QLog.d("HWVideoDecoder.DecodeRunnable", 2, localStringBuilder.toString());
        }
        return false;
      }
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicLong.compareAndSet(l, -1L);
      return paramBoolean;
    }
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicLong.compareAndSet(l, -1L);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkToRender, not in playrange, pos:");
      localStringBuilder.append(l);
      localStringBuilder.append(": [");
      localStringBuilder.append(this.jdField_b_of_type_ComTencentMobileqqVideocodecMediacodecDecoderDecodeConfig.jdField_a_of_type_Long);
      localStringBuilder.append("-");
      localStringBuilder.append(this.jdField_b_of_type_ComTencentMobileqqVideocodecMediacodecDecoderDecodeConfig.jdField_b_of_type_Long);
      localStringBuilder.append("]");
      QLog.d("HWVideoDecoder.DecodeRunnable", 2, localStringBuilder.toString());
    }
    return paramBoolean;
  }
  
  private boolean b()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaCodec == null)
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 2, "Can't find video info!");
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecDecoderHWDecodeListener.a();
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaCodec.start();
      try
      {
        this.jdField_a_of_type_ArrayOfJavaNioByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getInputBuffers();
        this.jdField_b_of_type_ArrayOfJavaNioByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
        this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo = new MediaCodec.BufferInfo();
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        if (this.jdField_b_of_type_ComTencentMobileqqVideocodecMediacodecDecoderDecodeConfig.jdField_a_of_type_Int == 3) {
          this.jdField_c_of_type_Long = (this.jdField_b_of_type_ComTencentMobileqqVideocodecMediacodecDecoderDecodeConfig.jdField_b_of_type_Long * 1000L);
        }
        return true;
      }
      catch (Exception localException)
      {
        if (!this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecDecoderHWDecodeListener.a(2, localException);
        }
        QLog.e(this.jdField_a_of_type_JavaLangString, 2, "decode start error2", localException);
        return false;
      }
      RuntimeException localRuntimeException;
      return false;
    }
    catch (Throwable localThrowable)
    {
      if (Thread.interrupted())
      {
        QLog.e(this.jdField_a_of_type_JavaLangString, 2, "Thread is interrupted.", localThrowable);
        return false;
      }
      localRuntimeException = new RuntimeException(localThrowable);
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecDecoderHWDecodeListener.a(2, localRuntimeException);
      }
      QLog.e(this.jdField_a_of_type_JavaLangString, 2, "decode start error", localThrowable);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (!this.jdField_b_of_type_Boolean) {
      c();
    }
    if (!this.jdField_c_of_type_Boolean) {
      a(paramBoolean);
    }
  }
  
  private boolean c()
  {
    int i = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueInputBuffer(10000L);
    Object localObject1;
    Object localObject2;
    if (i >= 0)
    {
      localObject1 = this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[i];
      long l1;
      if (this.jdField_b_of_type_ComTencentMobileqqVideocodecMediacodecDecoderDecodeConfig.jdField_a_of_type_Int == 3)
      {
        l1 = this.jdField_c_of_type_Long - 1000;
        if (("xiaomi".equalsIgnoreCase(Build.MANUFACTURER)) && ("MI 6".equalsIgnoreCase(Build.MODEL)))
        {
          localObject2 = this.jdField_a_of_type_AndroidMediaMediaExtractor;
          l2 = l1;
          if (l1 < 0L) {
            l2 = 0L;
          }
          ((MediaExtractor)localObject2).seekTo(l2, 1);
        }
        else
        {
          localObject2 = this.jdField_a_of_type_AndroidMediaMediaExtractor;
          l2 = l1;
          if (l1 < 0L) {
            l2 = 0L;
          }
          ((MediaExtractor)localObject2).seekTo(l2, 0);
        }
      }
      int j = this.jdField_a_of_type_AndroidMediaMediaExtractor.readSampleData((ByteBuffer)localObject1, 0);
      long l3 = this.jdField_a_of_type_AndroidMediaMediaExtractor.getSampleTime();
      long l2 = this.jdField_b_of_type_ComTencentMobileqqVideocodecMediacodecDecoderDecodeConfig.jdField_a_of_type_Long * 1000L;
      long l4 = this.jdField_b_of_type_ComTencentMobileqqVideocodecMediacodecDecoderDecodeConfig.jdField_b_of_type_Long * 1000L;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("intput sampleTime = ");
        ((StringBuilder)localObject1).append(l3);
        ((StringBuilder)localObject1).append(" sampleSize = ");
        ((StringBuilder)localObject1).append(j);
        ((StringBuilder)localObject1).append(" endTime = ");
        ((StringBuilder)localObject1).append(l4);
        QLog.d("HWVideoDecoder.DecodeRunnable", 2, ((StringBuilder)localObject1).toString());
      }
      if ((j >= 0) && ((l4 <= 0L) || (l3 <= l4))) {
        if (this.jdField_b_of_type_ComTencentMobileqqVideocodecMediacodecDecoderDecodeConfig.jdField_a_of_type_Int == 3)
        {
          if (l2 > 0L) {
            l1 = l2;
          } else {
            l1 = 10000;
          }
          if (l3 < l1) {}
        }
        else
        {
          l1 = this.jdField_c_of_type_Long;
          this.jdField_c_of_type_Long = l3;
          this.jdField_d_of_type_Long = a(this.jdField_b_of_type_ComTencentMobileqqVideocodecMediacodecDecoderDecodeConfig.jdField_a_of_type_Int, this.jdField_d_of_type_Long, l3 - l1);
          this.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(i, 0, j, this.jdField_d_of_type_Long, 0);
          this.jdField_a_of_type_AndroidMediaMediaExtractor.advance();
          return true;
        }
      }
      if (QLog.isColorLevel())
      {
        localObject1 = this.jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("InputBuffer BUFFER_FLAG_END_OF_STREAM sampleTime=");
        ((StringBuilder)localObject2).append(l3);
        ((StringBuilder)localObject2).append(" endTime=");
        ((StringBuilder)localObject2).append(l4);
        ((StringBuilder)localObject2).append(" startTime=");
        ((StringBuilder)localObject2).append(l2);
        ((StringBuilder)localObject2).append(" sampleSize=");
        ((StringBuilder)localObject2).append(j);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      this.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(i, 0, 0, 0L, 4);
      this.jdField_b_of_type_Boolean = true;
      return true;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("queueSampleToCodec inIndex = ");
      ((StringBuilder)localObject2).append(i);
      QLog.w((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    return false;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecDecoderDecodeConfig.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(paramLong * 1000L);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if ((paramLong1 >= 0L) && (paramLong2 >= 0L))
    {
      if (paramLong2 >= paramLong1)
      {
        long l2 = this.jdField_b_of_type_Long;
        if (paramLong1 >= l2)
        {
          SLog.e("HWVideoDecoder.DecodeRunnable", "setPlayRange ignore, startTimeMs=%d, videoDuration=%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(this.jdField_b_of_type_Long) });
          return;
        }
        long l1 = paramLong2;
        if (paramLong2 > l2) {
          l1 = l2;
        }
        paramLong2 = l1;
        if (l1 == 0L) {
          paramLong2 = this.jdField_b_of_type_Long;
        }
        if ((paramLong1 == this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecDecoderDecodeConfig.jdField_a_of_type_Long) && (paramLong2 == this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecDecoderDecodeConfig.jdField_b_of_type_Long))
        {
          SLog.d("HWVideoDecoder.DecodeRunnable", "segment not changed, setPlayRange ignore, startTimeMs=%d, endTimeMs=%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
          return;
        }
        DecodeConfig localDecodeConfig = this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecDecoderDecodeConfig;
        localDecodeConfig.jdField_a_of_type_Long = paramLong1;
        localDecodeConfig.jdField_b_of_type_Long = paramLong2;
        if (localDecodeConfig.jdField_a_of_type_Int == 3)
        {
          a(paramLong2);
          return;
        }
        a(paramLong1);
        return;
      }
      throw new IllegalArgumentException("end time should not less than start time");
    }
    throw new IllegalArgumentException("both start time and end time should not less than 0");
  }
  
  public void a(@NonNull DecodeConfig paramDecodeConfig)
  {
    if (!TextUtils.equals(this.jdField_b_of_type_JavaLangString, paramDecodeConfig.jdField_a_of_type_JavaLangString)) {
      SLog.d("HWVideoDecoder.DecodeRunnable", "DecodeRunnable does not support changing the file");
    }
    a(paramDecodeConfig.jdField_a_of_type_Int);
    a(paramDecodeConfig.jdField_a_of_type_Long, paramDecodeConfig.jdField_b_of_type_Long);
    b(paramDecodeConfig.jdField_b_of_type_Boolean);
    a(paramDecodeConfig.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecDecoderDecodeConfig.jdField_b_of_type_Int = paramDecodeConfig.jdField_b_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecDecoderDecodeConfig.jdField_c_of_type_Boolean = paramDecodeConfig.jdField_c_of_type_Boolean;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecDecoderDecodeConfig.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecDecoderDecodeConfig.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    this.jdField_b_of_type_ComTencentMobileqqVideocodecMediacodecDecoderDecodeConfig.a(this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecDecoderDecodeConfig);
    if (!a()) {
      return;
    }
    if (!b()) {
      return;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("decode ready time cost=");
      localStringBuilder.append(System.currentTimeMillis() - l1);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    for (;;)
    {
      if ((Thread.interrupted()) || (this.jdField_a_of_type_Boolean)) {
        break label514;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecDecoderDecodeConfig.jdField_a_of_type_Int != this.jdField_b_of_type_ComTencentMobileqqVideocodecMediacodecDecoderDecodeConfig.jdField_a_of_type_Int) && (this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecDecoderDecodeConfig.jdField_a_of_type_Int == 3)) {
        this.jdField_c_of_type_Long = (this.jdField_b_of_type_ComTencentMobileqqVideocodecMediacodecDecoderDecodeConfig.jdField_b_of_type_Long * 1000L);
      }
      this.jdField_b_of_type_ComTencentMobileqqVideocodecMediacodecDecoderDecodeConfig.a(this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecDecoderDecodeConfig);
      l1 = this.jdField_b_of_type_ComTencentMobileqqVideocodecMediacodecDecoderDecodeConfig.jdField_a_of_type_Long * 1000L;
      long l2 = this.jdField_b_of_type_ComTencentMobileqqVideocodecMediacodecDecoderDecodeConfig.jdField_b_of_type_Long * 1000L;
      int j = 0;
      long l3 = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get();
      int i = j;
      if (l3 >= 0L)
      {
        i = j;
        if (l3 >= l1)
        {
          i = j;
          if (l3 <= l2)
          {
            a(l3);
            i = 1;
          }
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.compareAndSet(l3, -1L);
      l3 = System.currentTimeMillis();
      try
      {
        c(true);
      }
      catch (Throwable localThrowable)
      {
        if (!Thread.interrupted()) {
          break label470;
        }
      }
      QLog.e(this.jdField_a_of_type_JavaLangString, 2, "Thread is interrupted.", localThrowable);
      if ((i != 0) && (QLog.isColorLevel()))
      {
        ??? = this.jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("decode ready time cost=");
        localStringBuilder.append(System.currentTimeMillis() - l3);
        QLog.d((String)???, 2, localStringBuilder.toString());
      }
      if (this.jdField_c_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "OutputBuffer BUFFER_FLAG_END_OF_STREAM");
        }
        if (!this.jdField_b_of_type_ComTencentMobileqqVideocodecMediacodecDecoderDecodeConfig.jdField_b_of_type_Boolean) {
          break label514;
        }
        if (this.jdField_b_of_type_ComTencentMobileqqVideocodecMediacodecDecoderDecodeConfig.jdField_a_of_type_Int == 3) {
          l1 = l2;
        }
        a(l1);
        this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecDecoderHWDecodeListener.d();
      }
      if (this.e) {
        try
        {
          synchronized (this.jdField_a_of_type_JavaLangObject)
          {
            if (!this.jdField_a_of_type_Boolean) {
              this.jdField_a_of_type_JavaLangObject.wait();
            }
            this.jdField_a_of_type_Long = (System.currentTimeMillis() - this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs / 1000L);
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
          this.jdField_a_of_type_Boolean = true;
        }
      }
    }
    label470:
    Object localObject3 = new RuntimeException(localInterruptedException);
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecDecoderHWDecodeListener.a(3, (Throwable)localObject3);
    }
    QLog.e(this.jdField_a_of_type_JavaLangString, 2, "decode configure error", localInterruptedException);
    return;
    try
    {
      label514:
      this.jdField_a_of_type_AndroidMediaMediaCodec.stop();
      this.jdField_a_of_type_AndroidMediaMediaCodec.release();
      this.jdField_a_of_type_AndroidMediaMediaExtractor.release();
    }
    catch (Exception localException)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("decoder stop error ");
      ((StringBuilder)localObject3).append(localException.toString());
      QLog.e("HWVideoDecoder.DecodeRunnable", 1, ((StringBuilder)localObject3).toString());
    }
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecDecoderHWDecodeListener.b();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecDecoderHWDecodeListener.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.mediacodec.decoder.HWVideoDecoder.DecodeRunnable
 * JD-Core Version:    0.7.0.1
 */