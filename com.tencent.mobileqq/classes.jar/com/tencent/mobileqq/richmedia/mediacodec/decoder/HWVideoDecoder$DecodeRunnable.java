package com.tencent.mobileqq.richmedia.mediacodec.decoder;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.os.Build;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.Surface;
import baej;
import bael;
import baem;
import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicLong;
import xvv;

class HWVideoDecoder$DecodeRunnable
  implements Runnable
{
  private int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = System.currentTimeMillis();
  MediaCodec.BufferInfo jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo;
  private MediaCodec jdField_a_of_type_AndroidMediaMediaCodec;
  private MediaExtractor jdField_a_of_type_AndroidMediaMediaExtractor;
  private Surface jdField_a_of_type_AndroidViewSurface;
  private final baej jdField_a_of_type_Baej;
  @NonNull
  private final baem jdField_a_of_type_Baem;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString = "HWVideoDecoder.DecodeRunnable";
  private final AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(-1L);
  boolean jdField_a_of_type_Boolean = false;
  ByteBuffer[] jdField_a_of_type_ArrayOfJavaNioByteBuffer;
  private int jdField_b_of_type_Int;
  public final long b;
  private final baej jdField_b_of_type_Baej;
  private final String jdField_b_of_type_JavaLangString;
  private final AtomicLong jdField_b_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(-1L);
  private boolean jdField_b_of_type_Boolean;
  ByteBuffer[] jdField_b_of_type_ArrayOfJavaNioByteBuffer;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  private long jdField_d_of_type_Long;
  private boolean jdField_d_of_type_Boolean;
  private volatile boolean e;
  
  public HWVideoDecoder$DecodeRunnable(@NonNull String paramString, Surface paramSurface, baem parambaem)
  {
    xvv.b("HWVideoDecoder.DecodeRunnable", "create DecodeRunnable filePath: %s", paramString);
    this.jdField_a_of_type_AndroidViewSurface = paramSurface;
    if (parambaem != null) {}
    for (;;)
    {
      this.jdField_a_of_type_Baem = parambaem;
      this.jdField_b_of_type_JavaLangString = paramString;
      this.jdField_b_of_type_Long = VideoCompositeHelper.getDurationOfVideo(paramString);
      this.jdField_a_of_type_Baej = new baej(paramString, 0, true, false, 0L, this.jdField_b_of_type_Long);
      this.jdField_b_of_type_Baej = new baej(paramString, 0, true, false, 0L, this.jdField_b_of_type_Long);
      return;
      parambaem = new bael();
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
      this.jdField_a_of_type_Baem.b(l2 / 1000L);
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
    if (this.jdField_b_of_type_Baej.jdField_a_of_type_Int == 3)
    {
      this.jdField_c_of_type_Long = (this.jdField_b_of_type_Baej.jdField_b_of_type_Long * 1000L);
      return;
    }
    this.jdField_c_of_type_Long = 0L;
  }
  
  /* Error */
  private boolean a()
  {
    // Byte code:
    //   0: aload_0
    //   1: new 129	android/media/MediaExtractor
    //   4: dup
    //   5: invokespecial 188	android/media/MediaExtractor:<init>	()V
    //   8: putfield 127	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_AndroidMediaMediaExtractor	Landroid/media/MediaExtractor;
    //   11: aload_0
    //   12: getfield 127	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_AndroidMediaMediaExtractor	Landroid/media/MediaExtractor;
    //   15: aload_0
    //   16: getfield 90	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   19: invokevirtual 192	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   22: iconst_0
    //   23: istore_1
    //   24: iload_1
    //   25: aload_0
    //   26: getfield 127	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_AndroidMediaMediaExtractor	Landroid/media/MediaExtractor;
    //   29: invokevirtual 195	android/media/MediaExtractor:getTrackCount	()I
    //   32: if_icmpge +211 -> 243
    //   35: aload_0
    //   36: getfield 127	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_AndroidMediaMediaExtractor	Landroid/media/MediaExtractor;
    //   39: iload_1
    //   40: invokevirtual 199	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   43: astore_2
    //   44: aload_2
    //   45: ldc 201
    //   47: invokevirtual 207	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   50: astore_3
    //   51: aload_3
    //   52: ldc 209
    //   54: invokevirtual 215	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   57: ifeq +229 -> 286
    //   60: aload_0
    //   61: aload_2
    //   62: ldc 217
    //   64: invokevirtual 221	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   67: putfield 222	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_Int	I
    //   70: aload_0
    //   71: aload_2
    //   72: ldc 224
    //   74: invokevirtual 221	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   77: putfield 226	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_b_of_type_Int	I
    //   80: aload_0
    //   81: getfield 127	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_AndroidMediaMediaExtractor	Landroid/media/MediaExtractor;
    //   84: iload_1
    //   85: invokevirtual 230	android/media/MediaExtractor:selectTrack	(I)V
    //   88: aload_0
    //   89: getfield 107	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_b_of_type_Baej	Lbaej;
    //   92: getfield 231	baej:jdField_c_of_type_Boolean	Z
    //   95: ifeq +129 -> 224
    //   98: aload_0
    //   99: getfield 107	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_b_of_type_Baej	Lbaej;
    //   102: getfield 232	baej:jdField_b_of_type_Int	I
    //   105: istore_1
    //   106: aload_2
    //   107: ldc 234
    //   109: iload_1
    //   110: invokevirtual 238	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   113: aload_0
    //   114: aload_3
    //   115: invokestatic 242	android/media/MediaCodec:createDecoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   118: putfield 120	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   121: aload_0
    //   122: getfield 86	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_AndroidViewSurface	Landroid/view/Surface;
    //   125: invokevirtual 247	android/view/Surface:isValid	()Z
    //   128: ifne +101 -> 229
    //   131: new 118	java/lang/RuntimeException
    //   134: dup
    //   135: ldc 249
    //   137: invokespecial 251	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   140: athrow
    //   141: astore_2
    //   142: invokestatic 256	java/lang/Thread:interrupted	()Z
    //   145: ifeq +100 -> 245
    //   148: aload_0
    //   149: getfield 34	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   152: iconst_2
    //   153: ldc_w 258
    //   156: aload_2
    //   157: invokestatic 261	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   160: iconst_0
    //   161: ireturn
    //   162: astore_2
    //   163: aload_2
    //   164: invokevirtual 264	java/io/IOException:printStackTrace	()V
    //   167: iconst_0
    //   168: ireturn
    //   169: astore_2
    //   170: invokestatic 256	java/lang/Thread:interrupted	()Z
    //   173: ifeq +17 -> 190
    //   176: aload_0
    //   177: getfield 34	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   180: iconst_2
    //   181: ldc_w 258
    //   184: aload_2
    //   185: invokestatic 261	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   188: iconst_0
    //   189: ireturn
    //   190: new 118	java/lang/RuntimeException
    //   193: dup
    //   194: aload_2
    //   195: invokespecial 267	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   198: astore_3
    //   199: aload_0
    //   200: getfield 88	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_Baem	Lbaem;
    //   203: iconst_1
    //   204: aload_3
    //   205: invokeinterface 270 3 0
    //   210: aload_0
    //   211: getfield 34	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   214: iconst_2
    //   215: ldc_w 272
    //   218: aload_2
    //   219: invokestatic 261	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   222: iconst_0
    //   223: ireturn
    //   224: iconst_0
    //   225: istore_1
    //   226: goto -120 -> 106
    //   229: aload_0
    //   230: getfield 120	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   233: aload_2
    //   234: aload_0
    //   235: getfield 86	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_AndroidViewSurface	Landroid/view/Surface;
    //   238: aconst_null
    //   239: iconst_0
    //   240: invokevirtual 276	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   243: iconst_1
    //   244: ireturn
    //   245: new 118	java/lang/RuntimeException
    //   248: dup
    //   249: aload_2
    //   250: invokespecial 267	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   253: astore_3
    //   254: aload_0
    //   255: getfield 36	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_Boolean	Z
    //   258: ifne +14 -> 272
    //   261: aload_0
    //   262: getfield 88	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_Baem	Lbaem;
    //   265: iconst_1
    //   266: aload_3
    //   267: invokeinterface 270 3 0
    //   272: aload_0
    //   273: getfield 34	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   276: iconst_2
    //   277: ldc_w 278
    //   280: aload_2
    //   281: invokestatic 261	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   284: iconst_0
    //   285: ireturn
    //   286: iload_1
    //   287: iconst_1
    //   288: iadd
    //   289: istore_1
    //   290: goto -266 -> 24
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	293	0	this	DecodeRunnable
    //   23	267	1	i	int
    //   43	64	2	localMediaFormat	android.media.MediaFormat
    //   141	16	2	localThrowable	Throwable
    //   162	2	2	localIOException	java.io.IOException
    //   169	112	2	localIllegalArgumentException	IllegalArgumentException
    //   50	217	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   113	141	141	java/lang/Throwable
    //   229	243	141	java/lang/Throwable
    //   11	22	162	java/io/IOException
    //   35	44	169	java/lang/IllegalArgumentException
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
      if ((this.jdField_b_of_type_Baej.jdField_a_of_type_Boolean) || (!paramBoolean)) {
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
        this.jdField_a_of_type_Baem.a(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs * 1000L);
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
      if ((l > this.jdField_b_of_type_Baej.jdField_a_of_type_Long) && (l < this.jdField_b_of_type_Baej.jdField_b_of_type_Long)) {
        break;
      }
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicLong.compareAndSet(l, -1L);
    } while (!QLog.isColorLevel());
    QLog.d("HWVideoDecoder.DecodeRunnable", 2, "checkToRender, not in playrange, pos:" + l + ": [" + this.jdField_b_of_type_Baej.jdField_a_of_type_Long + "-" + this.jdField_b_of_type_Baej.jdField_b_of_type_Long + "]");
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
    this.jdField_a_of_type_Baem.g();
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
        if (this.jdField_b_of_type_Baej.jdField_a_of_type_Int == 3) {
          this.jdField_c_of_type_Long = (this.jdField_b_of_type_Baej.jdField_b_of_type_Long * 1000L);
        }
        return true;
      }
      catch (Exception localException)
      {
        if (this.jdField_a_of_type_Boolean) {
          break label185;
        }
        this.jdField_a_of_type_Baem.a(2, localException);
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
        this.jdField_a_of_type_Baem.a(2, localRuntimeException);
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
      if (this.jdField_b_of_type_Baej.jdField_a_of_type_Int == 3)
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
        l2 = 1000L * this.jdField_b_of_type_Baej.jdField_a_of_type_Long;
        long l4 = 1000L * this.jdField_b_of_type_Baej.jdField_b_of_type_Long;
        if (QLog.isColorLevel()) {
          QLog.d("HWVideoDecoder.DecodeRunnable", 2, "intput sampleTime = " + l3 + " sampleSize = " + j + " endTime = " + l4);
        }
        if ((j >= 0) && ((l4 <= 0L) || (l3 <= l4)))
        {
          if (this.jdField_b_of_type_Baej.jdField_a_of_type_Int != 3) {
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
        this.jdField_d_of_type_Long = a(this.jdField_b_of_type_Baej.jdField_a_of_type_Int, this.jdField_d_of_type_Long, l3 - l1);
        this.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(i, 0, j, this.jdField_d_of_type_Long, 0);
        this.jdField_a_of_type_AndroidMediaMediaExtractor.advance();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 2, "queueSampleToCodec inIndex = " + i);
    }
    return false;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Baej.jdField_a_of_type_Int = paramInt;
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
      xvv.e("HWVideoDecoder.DecodeRunnable", "setPlayRange ignore, startTimeMs=%d, videoDuration=%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(this.jdField_b_of_type_Long) });
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
      if ((paramLong1 == this.jdField_a_of_type_Baej.jdField_a_of_type_Long) && (l == this.jdField_a_of_type_Baej.jdField_b_of_type_Long))
      {
        xvv.d("HWVideoDecoder.DecodeRunnable", "segment not changed, setPlayRange ignore, startTimeMs=%d, endTimeMs=%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(l) });
        return;
      }
      this.jdField_a_of_type_Baej.jdField_a_of_type_Long = paramLong1;
      this.jdField_a_of_type_Baej.jdField_b_of_type_Long = l;
      if (this.jdField_a_of_type_Baej.jdField_a_of_type_Int == 3)
      {
        a(l);
        return;
      }
      a(paramLong1);
      return;
    }
  }
  
  public void a(@NonNull baej parambaej)
  {
    if (!TextUtils.equals(this.jdField_b_of_type_JavaLangString, parambaej.jdField_a_of_type_JavaLangString)) {
      xvv.d("HWVideoDecoder.DecodeRunnable", "DecodeRunnable does not support changing the file");
    }
    a(parambaej.jdField_a_of_type_Int);
    a(parambaej.jdField_a_of_type_Long, parambaej.jdField_b_of_type_Long);
    b(parambaej.jdField_b_of_type_Boolean);
    a(parambaej.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Baej.jdField_b_of_type_Int = parambaej.jdField_b_of_type_Int;
    this.jdField_a_of_type_Baej.jdField_c_of_type_Boolean = parambaej.jdField_c_of_type_Boolean;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Baej.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Baej.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 42	java/lang/System:currentTimeMillis	()J
    //   3: lstore_3
    //   4: aload_0
    //   5: getfield 107	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_b_of_type_Baej	Lbaej;
    //   8: aload_0
    //   9: getfield 105	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_Baej	Lbaej;
    //   12: invokevirtual 498	baej:a	(Lbaej;)Z
    //   15: pop
    //   16: aload_0
    //   17: invokespecial 500	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:a	()Z
    //   20: ifne +4 -> 24
    //   23: return
    //   24: aload_0
    //   25: invokespecial 502	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:b	()Z
    //   28: ifeq -5 -> 23
    //   31: invokestatic 158	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   34: ifeq +35 -> 69
    //   37: aload_0
    //   38: getfield 34	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   41: iconst_2
    //   42: new 59	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   49: ldc_w 504
    //   52: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokestatic 42	java/lang/System:currentTimeMillis	()J
    //   58: lload_3
    //   59: lsub
    //   60: invokevirtual 165	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   63: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 172	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   69: invokestatic 256	java/lang/Thread:interrupted	()Z
    //   72: ifne +416 -> 488
    //   75: aload_0
    //   76: getfield 36	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_Boolean	Z
    //   79: ifne +409 -> 488
    //   82: aload_0
    //   83: getfield 105	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_Baej	Lbaej;
    //   86: getfield 180	baej:jdField_a_of_type_Int	I
    //   89: aload_0
    //   90: getfield 107	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_b_of_type_Baej	Lbaej;
    //   93: getfield 180	baej:jdField_a_of_type_Int	I
    //   96: if_icmpeq +29 -> 125
    //   99: aload_0
    //   100: getfield 105	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_Baej	Lbaej;
    //   103: getfield 180	baej:jdField_a_of_type_Int	I
    //   106: iconst_3
    //   107: if_icmpne +18 -> 125
    //   110: aload_0
    //   111: aload_0
    //   112: getfield 107	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_b_of_type_Baej	Lbaej;
    //   115: getfield 181	baej:jdField_b_of_type_Long	J
    //   118: ldc2_w 137
    //   121: lmul
    //   122: putfield 150	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_c_of_type_Long	J
    //   125: aload_0
    //   126: getfield 107	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_b_of_type_Baej	Lbaej;
    //   129: aload_0
    //   130: getfield 105	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_Baej	Lbaej;
    //   133: invokevirtual 498	baej:a	(Lbaej;)Z
    //   136: pop
    //   137: aload_0
    //   138: getfield 107	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_b_of_type_Baej	Lbaej;
    //   141: getfield 355	baej:jdField_a_of_type_Long	J
    //   144: ldc2_w 137
    //   147: lmul
    //   148: lstore_3
    //   149: ldc2_w 137
    //   152: aload_0
    //   153: getfield 107	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_b_of_type_Baej	Lbaej;
    //   156: getfield 181	baej:jdField_b_of_type_Long	J
    //   159: lmul
    //   160: lstore 5
    //   162: iconst_0
    //   163: istore_2
    //   164: aload_0
    //   165: getfield 53	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong	Ljava/util/concurrent/atomic/AtomicLong;
    //   168: invokevirtual 354	java/util/concurrent/atomic/AtomicLong:get	()J
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
    //   204: invokespecial 506	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:a	(J)J
    //   207: pop2
    //   208: iconst_1
    //   209: istore_1
    //   210: aload_0
    //   211: getfield 53	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong	Ljava/util/concurrent/atomic/AtomicLong;
    //   214: lload 7
    //   216: ldc2_w 47
    //   219: invokevirtual 359	java/util/concurrent/atomic/AtomicLong:compareAndSet	(JJ)Z
    //   222: pop
    //   223: invokestatic 42	java/lang/System:currentTimeMillis	()J
    //   226: lstore 7
    //   228: aload_0
    //   229: iconst_1
    //   230: invokespecial 508	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:c	(Z)V
    //   233: iload_1
    //   234: ifeq +42 -> 276
    //   237: invokestatic 158	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   240: ifeq +36 -> 276
    //   243: aload_0
    //   244: getfield 34	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   247: iconst_2
    //   248: new 59	java/lang/StringBuilder
    //   251: dup
    //   252: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   255: ldc_w 504
    //   258: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: invokestatic 42	java/lang/System:currentTimeMillis	()J
    //   264: lload 7
    //   266: lsub
    //   267: invokevirtual 165	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   270: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: invokestatic 172	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   276: aload_0
    //   277: getfield 146	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_c_of_type_Boolean	Z
    //   280: ifeq +59 -> 339
    //   283: invokestatic 158	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   286: ifeq +14 -> 300
    //   289: aload_0
    //   290: getfield 34	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   293: iconst_2
    //   294: ldc_w 510
    //   297: invokestatic 172	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   300: aload_0
    //   301: getfield 107	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_b_of_type_Baej	Lbaej;
    //   304: getfield 490	baej:jdField_b_of_type_Boolean	Z
    //   307: ifeq +181 -> 488
    //   310: aload_0
    //   311: getfield 107	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_b_of_type_Baej	Lbaej;
    //   314: getfield 180	baej:jdField_a_of_type_Int	I
    //   317: iconst_3
    //   318: if_icmpne +159 -> 477
    //   321: lload 5
    //   323: lstore_3
    //   324: aload_0
    //   325: lload_3
    //   326: invokespecial 506	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:a	(J)J
    //   329: pop2
    //   330: aload_0
    //   331: getfield 88	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_Baem	Lbaem;
    //   334: invokeinterface 513 1 0
    //   339: aload_0
    //   340: getfield 281	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:e	Z
    //   343: ifeq -274 -> 69
    //   346: aload_0
    //   347: getfield 57	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   350: astore 9
    //   352: aload 9
    //   354: monitorenter
    //   355: aload_0
    //   356: getfield 36	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_Boolean	Z
    //   359: ifne +10 -> 369
    //   362: aload_0
    //   363: getfield 57	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   366: invokevirtual 516	java/lang/Object:wait	()V
    //   369: aload 9
    //   371: monitorexit
    //   372: aload_0
    //   373: invokestatic 42	java/lang/System:currentTimeMillis	()J
    //   376: aload_0
    //   377: getfield 286	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   380: getfield 312	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   383: ldc2_w 137
    //   386: ldiv
    //   387: lsub
    //   388: putfield 44	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_Long	J
    //   391: goto -322 -> 69
    //   394: astore 9
    //   396: aload 9
    //   398: invokevirtual 321	java/lang/InterruptedException:printStackTrace	()V
    //   401: aload_0
    //   402: iconst_1
    //   403: putfield 36	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_Boolean	Z
    //   406: goto -337 -> 69
    //   409: astore 9
    //   411: invokestatic 256	java/lang/Thread:interrupted	()Z
    //   414: ifeq +19 -> 433
    //   417: aload_0
    //   418: getfield 34	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   421: iconst_2
    //   422: ldc_w 258
    //   425: aload 9
    //   427: invokestatic 261	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   430: goto -197 -> 233
    //   433: new 118	java/lang/RuntimeException
    //   436: dup
    //   437: aload 9
    //   439: invokespecial 267	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   442: astore 10
    //   444: aload_0
    //   445: getfield 36	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_Boolean	Z
    //   448: ifne +15 -> 463
    //   451: aload_0
    //   452: getfield 88	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_Baem	Lbaem;
    //   455: iconst_3
    //   456: aload 10
    //   458: invokeinterface 270 3 0
    //   463: aload_0
    //   464: getfield 34	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   467: iconst_2
    //   468: ldc_w 278
    //   471: aload 9
    //   473: invokestatic 261	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   476: return
    //   477: goto -153 -> 324
    //   480: astore 10
    //   482: aload 9
    //   484: monitorexit
    //   485: aload 10
    //   487: athrow
    //   488: aload_0
    //   489: getfield 120	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   492: invokevirtual 519	android/media/MediaCodec:stop	()V
    //   495: aload_0
    //   496: getfield 120	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   499: invokevirtual 522	android/media/MediaCodec:release	()V
    //   502: aload_0
    //   503: getfield 127	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_AndroidMediaMediaExtractor	Landroid/media/MediaExtractor;
    //   506: invokevirtual 523	android/media/MediaExtractor:release	()V
    //   509: aload_0
    //   510: getfield 146	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_c_of_type_Boolean	Z
    //   513: ifeq +48 -> 561
    //   516: aload_0
    //   517: getfield 88	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_Baem	Lbaem;
    //   520: invokeinterface 526 1 0
    //   525: return
    //   526: astore 9
    //   528: ldc 32
    //   530: iconst_1
    //   531: new 59	java/lang/StringBuilder
    //   534: dup
    //   535: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   538: ldc_w 528
    //   541: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: aload 9
    //   546: invokevirtual 529	java/lang/Exception:toString	()Ljava/lang/String;
    //   549: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   555: invokestatic 177	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   558: goto -49 -> 509
    //   561: aload_0
    //   562: getfield 88	com/tencent/mobileqq/richmedia/mediacodec/decoder/HWVideoDecoder$DecodeRunnable:jdField_a_of_type_Baem	Lbaem;
    //   565: invokeinterface 532 1 0
    //   570: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	571	0	this	DecodeRunnable
    //   174	60	1	i	int
    //   163	29	2	j	int
    //   3	323	3	l1	long
    //   160	162	5	l2	long
    //   171	94	7	l3	long
    //   394	3	9	localInterruptedException	InterruptedException
    //   409	74	9	localThrowable	Throwable
    //   526	19	9	localException	Exception
    //   442	15	10	localRuntimeException	RuntimeException
    //   480	6	10	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   346	355	394	java/lang/InterruptedException
    //   372	391	394	java/lang/InterruptedException
    //   485	488	394	java/lang/InterruptedException
    //   228	233	409	java/lang/Throwable
    //   355	369	480	finally
    //   369	372	480	finally
    //   482	485	480	finally
    //   488	509	526	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.decoder.HWVideoDecoder.DecodeRunnable
 * JD-Core Version:    0.7.0.1
 */