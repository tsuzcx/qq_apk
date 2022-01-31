package com.tencent.mobileqq.richmedia.mediacodec.decoder;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.os.Build;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.Surface;
import auxr;
import auxt;
import auxu;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicLong;
import sjj;
import urk;

class HWVideoDecoder$DecodeRunnable
  implements Runnable
{
  long jdField_a_of_type_Long = System.currentTimeMillis();
  MediaCodec.BufferInfo jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo;
  private MediaCodec jdField_a_of_type_AndroidMediaMediaCodec;
  private MediaExtractor jdField_a_of_type_AndroidMediaMediaExtractor;
  private Surface jdField_a_of_type_AndroidViewSurface;
  private final auxr jdField_a_of_type_Auxr;
  @NonNull
  private final auxu jdField_a_of_type_Auxu;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString = "HWVideoDecoder.DecodeRunnable";
  private final AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(-1L);
  boolean jdField_a_of_type_Boolean = false;
  ByteBuffer[] jdField_a_of_type_ArrayOfJavaNioByteBuffer;
  public final long b;
  private final auxr jdField_b_of_type_Auxr;
  private final String jdField_b_of_type_JavaLangString;
  private final AtomicLong jdField_b_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(-1L);
  private boolean jdField_b_of_type_Boolean;
  ByteBuffer[] jdField_b_of_type_ArrayOfJavaNioByteBuffer;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  private long jdField_d_of_type_Long;
  private boolean jdField_d_of_type_Boolean;
  private volatile boolean e;
  
  public HWVideoDecoder$DecodeRunnable(@NonNull String paramString, Surface paramSurface, auxu paramauxu)
  {
    urk.b("HWVideoDecoder.DecodeRunnable", "create DecodeRunnable filePath: %s", paramString);
    this.jdField_a_of_type_AndroidViewSurface = paramSurface;
    if (paramauxu != null) {}
    for (;;)
    {
      this.jdField_a_of_type_Auxu = paramauxu;
      this.jdField_b_of_type_JavaLangString = paramString;
      this.jdField_b_of_type_Long = sjj.a(paramString);
      this.jdField_a_of_type_Auxr = new auxr(paramString, 0, true, false, 0L, this.jdField_b_of_type_Long);
      this.jdField_b_of_type_Auxr = new auxr(paramString, 0, true, false, 0L, this.jdField_b_of_type_Long);
      return;
      paramauxu = new auxt();
    }
  }
  
  private long a(int paramInt, long paramLong1, long paramLong2)
  {
    switch (paramInt)
    {
    default: 
      return paramLong1 + paramLong2;
    case 1: 
      return paramLong2 / 2L + paramLong1;
    case 2: 
      return 2L * paramLong2 + paramLong1;
    }
    return paramLong1 - paramLong2;
  }
  
  private long a(long paramLong)
  {
    long l1 = System.currentTimeMillis();
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaCodec.flush();
      this.jdField_a_of_type_AndroidMediaMediaExtractor.seekTo(paramLong, 0);
      long l2 = this.jdField_a_of_type_AndroidMediaMediaExtractor.getSampleTime();
      this.jdField_a_of_type_Auxu.b(l2 / 1000L);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_b_of_type_Boolean = false;
      this.jdField_c_of_type_Boolean = false;
      if (l2 == -1L) {
        a();
      }
      this.jdField_c_of_type_Long = l2;
      this.jdField_d_of_type_Long = 0L;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 4, "end seekTo seekTime=" + 0 + " timecost=" + (System.currentTimeMillis() - l1) + " seekTargetTimeUs:" + paramLong + " realStartTime:" + l2);
      }
      return l2;
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        QLog.e("HWVideoDecoder.DecodeRunnable", 1, "decoder flush error " + localRuntimeException.toString());
      }
    }
  }
  
  private void a()
  {
    if (this.jdField_b_of_type_Auxr.jdField_a_of_type_Int == 3)
    {
      this.jdField_c_of_type_Long = (this.jdField_b_of_type_Auxr.jdField_b_of_type_Long * 1000L);
      return;
    }
    this.jdField_c_of_type_Long = 0L;
  }
  
  /* Error */
  private boolean a()
  {
    // Byte code:
    //   0: aload_0
    //   1: new 127	android/media/MediaExtractor
    //   4: dup
    //   5: invokespecial 187	android/media/MediaExtractor:<init>	()V
    //   8: putfield 125	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_AndroidMediaMediaExtractor	Landroid/media/MediaExtractor;
    //   11: aload_0
    //   12: getfield 125	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_AndroidMediaMediaExtractor	Landroid/media/MediaExtractor;
    //   15: aload_0
    //   16: getfield 89	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   19: invokevirtual 191	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   22: iconst_0
    //   23: istore_1
    //   24: iload_1
    //   25: aload_0
    //   26: getfield 125	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_AndroidMediaMediaExtractor	Landroid/media/MediaExtractor;
    //   29: invokevirtual 194	android/media/MediaExtractor:getTrackCount	()I
    //   32: if_icmpge +189 -> 221
    //   35: aload_0
    //   36: getfield 125	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_AndroidMediaMediaExtractor	Landroid/media/MediaExtractor;
    //   39: iload_1
    //   40: invokevirtual 198	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   43: astore_2
    //   44: aload_2
    //   45: ldc 200
    //   47: invokevirtual 206	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   50: astore_3
    //   51: aload_3
    //   52: ldc 208
    //   54: invokevirtual 214	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   57: ifeq +207 -> 264
    //   60: aload_0
    //   61: getfield 125	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_AndroidMediaMediaExtractor	Landroid/media/MediaExtractor;
    //   64: iload_1
    //   65: invokevirtual 218	android/media/MediaExtractor:selectTrack	(I)V
    //   68: aload_0
    //   69: getfield 105	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_b_of_type_Auxr	Lauxr;
    //   72: getfield 219	auxr:jdField_c_of_type_Boolean	Z
    //   75: ifeq +127 -> 202
    //   78: aload_0
    //   79: getfield 105	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_b_of_type_Auxr	Lauxr;
    //   82: getfield 221	auxr:jdField_b_of_type_Int	I
    //   85: istore_1
    //   86: aload_2
    //   87: ldc 223
    //   89: iload_1
    //   90: invokevirtual 227	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   93: aload_0
    //   94: aload_3
    //   95: invokestatic 231	android/media/MediaCodec:createDecoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   98: putfield 118	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   101: aload_0
    //   102: getfield 85	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_AndroidViewSurface	Landroid/view/Surface;
    //   105: invokevirtual 236	android/view/Surface:isValid	()Z
    //   108: ifne +99 -> 207
    //   111: new 116	java/lang/RuntimeException
    //   114: dup
    //   115: ldc 238
    //   117: invokespecial 240	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   120: athrow
    //   121: astore_2
    //   122: invokestatic 245	java/lang/Thread:interrupted	()Z
    //   125: ifeq +98 -> 223
    //   128: aload_0
    //   129: getfield 33	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   132: iconst_2
    //   133: ldc 247
    //   135: aload_2
    //   136: invokestatic 250	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   139: iconst_0
    //   140: ireturn
    //   141: astore_2
    //   142: aload_2
    //   143: invokevirtual 253	java/io/IOException:printStackTrace	()V
    //   146: iconst_0
    //   147: ireturn
    //   148: astore_2
    //   149: invokestatic 245	java/lang/Thread:interrupted	()Z
    //   152: ifeq +16 -> 168
    //   155: aload_0
    //   156: getfield 33	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   159: iconst_2
    //   160: ldc 247
    //   162: aload_2
    //   163: invokestatic 250	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   166: iconst_0
    //   167: ireturn
    //   168: new 116	java/lang/RuntimeException
    //   171: dup
    //   172: aload_2
    //   173: invokespecial 256	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   176: astore_3
    //   177: aload_0
    //   178: getfield 87	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_Auxu	Lauxu;
    //   181: iconst_1
    //   182: aload_3
    //   183: invokeinterface 259 3 0
    //   188: aload_0
    //   189: getfield 33	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   192: iconst_2
    //   193: ldc_w 261
    //   196: aload_2
    //   197: invokestatic 250	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   200: iconst_0
    //   201: ireturn
    //   202: iconst_0
    //   203: istore_1
    //   204: goto -118 -> 86
    //   207: aload_0
    //   208: getfield 118	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   211: aload_2
    //   212: aload_0
    //   213: getfield 85	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_AndroidViewSurface	Landroid/view/Surface;
    //   216: aconst_null
    //   217: iconst_0
    //   218: invokevirtual 265	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   221: iconst_1
    //   222: ireturn
    //   223: new 116	java/lang/RuntimeException
    //   226: dup
    //   227: aload_2
    //   228: invokespecial 256	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   231: astore_3
    //   232: aload_0
    //   233: getfield 35	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_Boolean	Z
    //   236: ifne +14 -> 250
    //   239: aload_0
    //   240: getfield 87	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_Auxu	Lauxu;
    //   243: iconst_1
    //   244: aload_3
    //   245: invokeinterface 259 3 0
    //   250: aload_0
    //   251: getfield 33	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   254: iconst_2
    //   255: ldc_w 267
    //   258: aload_2
    //   259: invokestatic 250	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   262: iconst_0
    //   263: ireturn
    //   264: iload_1
    //   265: iconst_1
    //   266: iadd
    //   267: istore_1
    //   268: goto -244 -> 24
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	271	0	this	DecodeRunnable
    //   23	245	1	i	int
    //   43	44	2	localMediaFormat	android.media.MediaFormat
    //   121	15	2	localThrowable	Throwable
    //   141	2	2	localIOException	java.io.IOException
    //   148	111	2	localIllegalArgumentException	IllegalArgumentException
    //   50	195	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   93	121	121	java/lang/Throwable
    //   207	221	121	java/lang/Throwable
    //   11	22	141	java/io/IOException
    //   35	44	148	java/lang/IllegalArgumentException
  }
  
  private boolean a(boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueOutputBuffer(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo, 10000L);
    switch (i)
    {
    default: 
      if ((this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags & 0x4) != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "output EOS");
        }
        this.jdField_c_of_type_Boolean = true;
      }
      paramBoolean = a(paramBoolean, this.jdField_c_of_type_Long / 1000L);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkToRender, render :" + paramBoolean + " info.presentationTimeUs:" + this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs / 1000L + " - " + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
      }
      if ((this.jdField_b_of_type_Auxr.jdField_a_of_type_Boolean) || (!paramBoolean)) {
        break;
      }
    case -3: 
    case -2: 
    case -1: 
      while (this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs / 1000L > System.currentTimeMillis() - this.jdField_a_of_type_Long)
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
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "INFO_OUTPUT_BUFFERS_CHANGED");
        }
        this.jdField_b_of_type_ArrayOfJavaNioByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
        do
        {
          do
          {
            return true;
          } while (!QLog.isColorLevel());
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "New format " + this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputFormat());
          return true;
        } while (!QLog.isColorLevel());
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "dequeueOutputBuffer timed out!");
        return true;
      }
    }
    if ((paramBoolean) && (this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.size != 0)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.jdField_a_of_type_AndroidMediaMediaCodec.releaseOutputBuffer(i, paramBoolean);
      if (!paramBoolean) {
        break;
      }
      try
      {
        this.jdField_a_of_type_Auxu.a(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs * 1000L);
        return true;
      }
      catch (InterruptedException localInterruptedException2)
      {
        localInterruptedException2.printStackTrace();
        this.jdField_a_of_type_Boolean = true;
        return true;
      }
    }
  }
  
  private boolean a(boolean paramBoolean, long paramLong)
  {
    if (!this.jdField_d_of_type_Boolean) {}
    long l;
    do
    {
      do
      {
        do
        {
          return paramBoolean;
        } while (!paramBoolean);
        if (this.jdField_c_of_type_Boolean) {
          return false;
        }
        l = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicLong.get();
      } while (l <= 0L);
      if ((l > this.jdField_b_of_type_Auxr.jdField_a_of_type_Long) && (l < this.jdField_b_of_type_Auxr.jdField_b_of_type_Long)) {
        break;
      }
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicLong.compareAndSet(l, -1L);
    } while (!QLog.isColorLevel());
    QLog.d("HWVideoDecoder.DecodeRunnable", 2, "checkToRender, not in playrange, pos:" + l + ": [" + this.jdField_b_of_type_Auxr.jdField_a_of_type_Long + "-" + this.jdField_b_of_type_Auxr.jdField_b_of_type_Long + "]");
    return paramBoolean;
    if (l > paramLong)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HWVideoDecoder.DecodeRunnable", 2, "checkToRender, do not render, renderpos:" + l + " sampletime:" + paramLong);
      }
      return false;
    }
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicLong.compareAndSet(l, -1L);
    return paramBoolean;
  }
  
  private boolean b()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaCodec == null)
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 2, "Can't find video info!");
      return false;
    }
    this.jdField_a_of_type_Auxu.f();
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
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        if (this.jdField_b_of_type_Auxr.jdField_a_of_type_Int == 3) {
          this.jdField_c_of_type_Long = (this.jdField_b_of_type_Auxr.jdField_b_of_type_Long * 1000L);
        }
        return true;
      }
      catch (Exception localException)
      {
        if (this.jdField_a_of_type_Boolean) {
          break label184;
        }
        this.jdField_a_of_type_Auxu.a(2, localException);
        QLog.e(this.jdField_a_of_type_JavaLangString, 2, "decode start error2", localException);
      }
      localThrowable = localThrowable;
      if (Thread.interrupted())
      {
        QLog.e(this.jdField_a_of_type_JavaLangString, 2, "Thread is interrupted.", localThrowable);
        return false;
      }
      localRuntimeException = new RuntimeException(localThrowable);
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Auxu.a(2, localRuntimeException);
      }
      QLog.e(this.jdField_a_of_type_JavaLangString, 2, "decode start error", localThrowable);
      return false;
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
    if (i >= 0)
    {
      ByteBuffer localByteBuffer = this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[i];
      long l1;
      MediaExtractor localMediaExtractor;
      long l2;
      int j;
      long l3;
      if (this.jdField_b_of_type_Auxr.jdField_a_of_type_Int == 3)
      {
        l1 = this.jdField_c_of_type_Long - 1000;
        if (("xiaomi".equalsIgnoreCase(Build.MANUFACTURER)) && ("MI 6".equalsIgnoreCase(Build.MODEL)))
        {
          localMediaExtractor = this.jdField_a_of_type_AndroidMediaMediaExtractor;
          l2 = l1;
          if (l1 < 0L) {
            l2 = 0L;
          }
          localMediaExtractor.seekTo(l2, 1);
        }
      }
      else
      {
        j = this.jdField_a_of_type_AndroidMediaMediaExtractor.readSampleData(localByteBuffer, 0);
        l3 = this.jdField_a_of_type_AndroidMediaMediaExtractor.getSampleTime();
        l2 = 1000L * this.jdField_b_of_type_Auxr.jdField_a_of_type_Long;
        long l4 = 1000L * this.jdField_b_of_type_Auxr.jdField_b_of_type_Long;
        if (QLog.isColorLevel()) {
          QLog.d("HWVideoDecoder.DecodeRunnable", 2, "intput sampleTime = " + l3 + " sampleSize = " + j + " endTime = " + l4);
        }
        if ((j >= 0) && ((l4 <= 0L) || (l3 <= l4)))
        {
          if (this.jdField_b_of_type_Auxr.jdField_a_of_type_Int != 3) {
            break label364;
          }
          if (l2 <= 0L) {
            break label356;
          }
          l1 = l2;
          label234:
          if (l3 >= l1) {
            break label364;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "InputBuffer BUFFER_FLAG_END_OF_STREAM sampleTime=" + l3 + " endTime=" + l4 + " startTime=" + l2 + " sampleSize=" + j);
        }
        this.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(i, 0, 0, 0L, 4);
        this.jdField_b_of_type_Boolean = true;
      }
      for (;;)
      {
        return true;
        localMediaExtractor = this.jdField_a_of_type_AndroidMediaMediaExtractor;
        l2 = l1;
        if (l1 < 0L) {
          l2 = 0L;
        }
        localMediaExtractor.seekTo(l2, 0);
        break;
        label356:
        l1 = 10000;
        break label234;
        label364:
        l1 = this.jdField_c_of_type_Long;
        this.jdField_c_of_type_Long = l3;
        this.jdField_d_of_type_Long = a(this.jdField_b_of_type_Auxr.jdField_a_of_type_Int, this.jdField_d_of_type_Long, l3 - l1);
        this.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(i, 0, j, this.jdField_d_of_type_Long, 0);
        this.jdField_a_of_type_AndroidMediaMediaExtractor.advance();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 2, "queueSampleToCodec inIndex = " + i);
    }
    return false;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Auxr.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(1000L * paramLong);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if ((paramLong1 < 0L) || (paramLong2 < 0L)) {
      throw new IllegalArgumentException("both start time and end time should not less than 0");
    }
    if (paramLong2 < paramLong1) {
      throw new IllegalArgumentException("end time should not less than start time");
    }
    if (paramLong1 >= this.jdField_b_of_type_Long)
    {
      urk.e("HWVideoDecoder.DecodeRunnable", "setPlayRange ignore, startTimeMs=%d, videoDuration=%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(this.jdField_b_of_type_Long) });
      return;
    }
    if (paramLong2 > this.jdField_b_of_type_Long) {
      paramLong2 = this.jdField_b_of_type_Long;
    }
    for (;;)
    {
      long l = paramLong2;
      if (paramLong2 == 0L) {
        l = this.jdField_b_of_type_Long;
      }
      if ((paramLong1 == this.jdField_a_of_type_Auxr.jdField_a_of_type_Long) && (l == this.jdField_a_of_type_Auxr.jdField_b_of_type_Long))
      {
        urk.d("HWVideoDecoder.DecodeRunnable", "segment not changed, setPlayRange ignore, startTimeMs=%d, endTimeMs=%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(l) });
        return;
      }
      this.jdField_a_of_type_Auxr.jdField_a_of_type_Long = paramLong1;
      this.jdField_a_of_type_Auxr.jdField_b_of_type_Long = l;
      if (this.jdField_a_of_type_Auxr.jdField_a_of_type_Int == 3)
      {
        a(l);
        return;
      }
      a(paramLong1);
      return;
    }
  }
  
  public void a(@NonNull auxr paramauxr)
  {
    if (!TextUtils.equals(this.jdField_b_of_type_JavaLangString, paramauxr.jdField_a_of_type_JavaLangString)) {
      urk.d("HWVideoDecoder.DecodeRunnable", "DecodeRunnable does not support changing the file");
    }
    a(paramauxr.jdField_a_of_type_Int);
    a(paramauxr.jdField_a_of_type_Long, paramauxr.jdField_b_of_type_Long);
    b(paramauxr.jdField_b_of_type_Boolean);
    a(paramauxr.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Auxr.jdField_b_of_type_Int = paramauxr.jdField_b_of_type_Int;
    this.jdField_a_of_type_Auxr.jdField_c_of_type_Boolean = paramauxr.jdField_c_of_type_Boolean;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Auxr.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Auxr.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 41	java/lang/System:currentTimeMillis	()J
    //   3: lstore_3
    //   4: aload_0
    //   5: getfield 105	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_b_of_type_Auxr	Lauxr;
    //   8: aload_0
    //   9: getfield 103	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_Auxr	Lauxr;
    //   12: invokevirtual 487	auxr:a	(Lauxr;)Z
    //   15: pop
    //   16: aload_0
    //   17: invokespecial 489	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:a	()Z
    //   20: ifne +4 -> 24
    //   23: return
    //   24: aload_0
    //   25: invokespecial 491	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:b	()Z
    //   28: ifeq -5 -> 23
    //   31: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   34: ifeq +35 -> 69
    //   37: aload_0
    //   38: getfield 33	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   41: iconst_2
    //   42: new 58	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   49: ldc_w 493
    //   52: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokestatic 41	java/lang/System:currentTimeMillis	()J
    //   58: lload_3
    //   59: lsub
    //   60: invokevirtual 163	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   63: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 170	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   69: invokestatic 245	java/lang/Thread:interrupted	()Z
    //   72: ifne +415 -> 487
    //   75: aload_0
    //   76: getfield 35	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_Boolean	Z
    //   79: ifne +408 -> 487
    //   82: aload_0
    //   83: getfield 103	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_Auxr	Lauxr;
    //   86: getfield 179	auxr:jdField_a_of_type_Int	I
    //   89: aload_0
    //   90: getfield 105	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_b_of_type_Auxr	Lauxr;
    //   93: getfield 179	auxr:jdField_a_of_type_Int	I
    //   96: if_icmpeq +29 -> 125
    //   99: aload_0
    //   100: getfield 103	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_Auxr	Lauxr;
    //   103: getfield 179	auxr:jdField_a_of_type_Int	I
    //   106: iconst_3
    //   107: if_icmpne +18 -> 125
    //   110: aload_0
    //   111: aload_0
    //   112: getfield 105	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_b_of_type_Auxr	Lauxr;
    //   115: getfield 180	auxr:jdField_b_of_type_Long	J
    //   118: ldc2_w 135
    //   121: lmul
    //   122: putfield 148	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_c_of_type_Long	J
    //   125: aload_0
    //   126: getfield 105	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_b_of_type_Auxr	Lauxr;
    //   129: aload_0
    //   130: getfield 103	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_Auxr	Lauxr;
    //   133: invokevirtual 487	auxr:a	(Lauxr;)Z
    //   136: pop
    //   137: aload_0
    //   138: getfield 105	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_b_of_type_Auxr	Lauxr;
    //   141: getfield 344	auxr:jdField_a_of_type_Long	J
    //   144: ldc2_w 135
    //   147: lmul
    //   148: lstore_3
    //   149: ldc2_w 135
    //   152: aload_0
    //   153: getfield 105	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_b_of_type_Auxr	Lauxr;
    //   156: getfield 180	auxr:jdField_b_of_type_Long	J
    //   159: lmul
    //   160: lstore 5
    //   162: iconst_0
    //   163: istore_2
    //   164: aload_0
    //   165: getfield 52	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong	Ljava/util/concurrent/atomic/AtomicLong;
    //   168: invokevirtual 343	java/util/concurrent/atomic/AtomicLong:get	()J
    //   171: lstore 7
    //   173: iload_2
    //   174: istore_1
    //   175: lload 7
    //   177: lconst_0
    //   178: lcmp
    //   179: iflt +31 -> 210
    //   182: iload_2
    //   183: istore_1
    //   184: lload 7
    //   186: lload_3
    //   187: lcmp
    //   188: iflt +22 -> 210
    //   191: iload_2
    //   192: istore_1
    //   193: lload 7
    //   195: lload 5
    //   197: lcmp
    //   198: ifgt +12 -> 210
    //   201: aload_0
    //   202: lload 7
    //   204: invokespecial 495	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:a	(J)J
    //   207: pop2
    //   208: iconst_1
    //   209: istore_1
    //   210: aload_0
    //   211: getfield 52	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong	Ljava/util/concurrent/atomic/AtomicLong;
    //   214: lload 7
    //   216: ldc2_w 46
    //   219: invokevirtual 348	java/util/concurrent/atomic/AtomicLong:compareAndSet	(JJ)Z
    //   222: pop
    //   223: invokestatic 41	java/lang/System:currentTimeMillis	()J
    //   226: lstore 7
    //   228: aload_0
    //   229: iconst_1
    //   230: invokespecial 497	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:c	(Z)V
    //   233: iload_1
    //   234: ifeq +42 -> 276
    //   237: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   240: ifeq +36 -> 276
    //   243: aload_0
    //   244: getfield 33	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   247: iconst_2
    //   248: new 58	java/lang/StringBuilder
    //   251: dup
    //   252: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   255: ldc_w 493
    //   258: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: invokestatic 41	java/lang/System:currentTimeMillis	()J
    //   264: lload 7
    //   266: lsub
    //   267: invokevirtual 163	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   270: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: invokestatic 170	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   276: aload_0
    //   277: getfield 144	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_c_of_type_Boolean	Z
    //   280: ifeq +59 -> 339
    //   283: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   286: ifeq +14 -> 300
    //   289: aload_0
    //   290: getfield 33	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   293: iconst_2
    //   294: ldc_w 499
    //   297: invokestatic 170	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   300: aload_0
    //   301: getfield 105	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_b_of_type_Auxr	Lauxr;
    //   304: getfield 479	auxr:jdField_b_of_type_Boolean	Z
    //   307: ifeq +180 -> 487
    //   310: aload_0
    //   311: getfield 105	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_b_of_type_Auxr	Lauxr;
    //   314: getfield 179	auxr:jdField_a_of_type_Int	I
    //   317: iconst_3
    //   318: if_icmpne +158 -> 476
    //   321: lload 5
    //   323: lstore_3
    //   324: aload_0
    //   325: lload_3
    //   326: invokespecial 495	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:a	(J)J
    //   329: pop2
    //   330: aload_0
    //   331: getfield 87	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_Auxu	Lauxu;
    //   334: invokeinterface 502 1 0
    //   339: aload_0
    //   340: getfield 270	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:e	Z
    //   343: ifeq -274 -> 69
    //   346: aload_0
    //   347: getfield 56	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   350: astore 9
    //   352: aload 9
    //   354: monitorenter
    //   355: aload_0
    //   356: getfield 35	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_Boolean	Z
    //   359: ifne +10 -> 369
    //   362: aload_0
    //   363: getfield 56	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   366: invokevirtual 505	java/lang/Object:wait	()V
    //   369: aload 9
    //   371: monitorexit
    //   372: aload_0
    //   373: invokestatic 41	java/lang/System:currentTimeMillis	()J
    //   376: aload_0
    //   377: getfield 275	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   380: getfield 301	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   383: ldc2_w 135
    //   386: ldiv
    //   387: lsub
    //   388: putfield 43	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_Long	J
    //   391: goto -322 -> 69
    //   394: astore 9
    //   396: aload 9
    //   398: invokevirtual 310	java/lang/InterruptedException:printStackTrace	()V
    //   401: aload_0
    //   402: iconst_1
    //   403: putfield 35	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_Boolean	Z
    //   406: goto -337 -> 69
    //   409: astore 9
    //   411: invokestatic 245	java/lang/Thread:interrupted	()Z
    //   414: ifeq +18 -> 432
    //   417: aload_0
    //   418: getfield 33	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   421: iconst_2
    //   422: ldc 247
    //   424: aload 9
    //   426: invokestatic 250	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   429: goto -196 -> 233
    //   432: new 116	java/lang/RuntimeException
    //   435: dup
    //   436: aload 9
    //   438: invokespecial 256	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   441: astore 10
    //   443: aload_0
    //   444: getfield 35	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_Boolean	Z
    //   447: ifne +15 -> 462
    //   450: aload_0
    //   451: getfield 87	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_Auxu	Lauxu;
    //   454: iconst_3
    //   455: aload 10
    //   457: invokeinterface 259 3 0
    //   462: aload_0
    //   463: getfield 33	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   466: iconst_2
    //   467: ldc_w 267
    //   470: aload 9
    //   472: invokestatic 250	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   475: return
    //   476: goto -152 -> 324
    //   479: astore 10
    //   481: aload 9
    //   483: monitorexit
    //   484: aload 10
    //   486: athrow
    //   487: aload_0
    //   488: getfield 118	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   491: invokevirtual 508	android/media/MediaCodec:stop	()V
    //   494: aload_0
    //   495: getfield 118	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   498: invokevirtual 511	android/media/MediaCodec:release	()V
    //   501: aload_0
    //   502: getfield 125	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_AndroidMediaMediaExtractor	Landroid/media/MediaExtractor;
    //   505: invokevirtual 512	android/media/MediaExtractor:release	()V
    //   508: aload_0
    //   509: getfield 144	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_c_of_type_Boolean	Z
    //   512: ifeq +48 -> 560
    //   515: aload_0
    //   516: getfield 87	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_Auxu	Lauxu;
    //   519: invokeinterface 515 1 0
    //   524: return
    //   525: astore 9
    //   527: ldc 31
    //   529: iconst_1
    //   530: new 58	java/lang/StringBuilder
    //   533: dup
    //   534: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   537: ldc_w 517
    //   540: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: aload 9
    //   545: invokevirtual 518	java/lang/Exception:toString	()Ljava/lang/String;
    //   548: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   554: invokestatic 175	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   557: goto -49 -> 508
    //   560: aload_0
    //   561: getfield 87	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_Auxu	Lauxu;
    //   564: invokeinterface 521 1 0
    //   569: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	570	0	this	DecodeRunnable
    //   174	60	1	i	int
    //   163	29	2	j	int
    //   3	323	3	l1	long
    //   160	162	5	l2	long
    //   171	94	7	l3	long
    //   394	3	9	localInterruptedException	InterruptedException
    //   409	73	9	localThrowable	Throwable
    //   525	19	9	localException	Exception
    //   441	15	10	localRuntimeException	RuntimeException
    //   479	6	10	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   346	355	394	java/lang/InterruptedException
    //   372	391	394	java/lang/InterruptedException
    //   484	487	394	java/lang/InterruptedException
    //   228	233	409	java/lang/Throwable
    //   355	369	479	finally
    //   369	372	479	finally
    //   481	484	479	finally
    //   487	508	525	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.decoder.HWVideoDecoder.DecodeRunnable
 * JD-Core Version:    0.7.0.1
 */