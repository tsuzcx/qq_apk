package dov.com.tencent.biz.qqstory.takevideo.multivideo;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import bnaa;
import bnab;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class CodecDecodeRunnable
  extends DecodeRunnable
{
  MediaCodec.BufferInfo jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo;
  private MediaCodec jdField_a_of_type_AndroidMediaMediaCodec;
  private MediaExtractor jdField_a_of_type_AndroidMediaMediaExtractor = new MediaExtractor();
  private bnaa jdField_a_of_type_Bnaa;
  private ArrayList<Long> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  ByteBuffer[] jdField_a_of_type_ArrayOfJavaNioByteBuffer;
  private boolean jdField_b_of_type_Boolean;
  ByteBuffer[] jdField_b_of_type_ArrayOfJavaNioByteBuffer;
  private boolean c;
  private long d;
  private long e;
  private long f = 200000L;
  
  public CodecDecodeRunnable(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2, bnab parambnab)
  {
    super(paramString, paramInt1, paramInt2, paramInt3, paramInt4, paramLong1, paramLong2, parambnab);
    this.jdField_e_of_type_Long = -1L;
  }
  
  private int a()
  {
    int j = 0;
    if (this.jdField_a_of_type_AndroidMediaMediaExtractor == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VFLDecodeRunnable", 2, "mExtractor is null");
      }
      return 0;
    }
    Object localObject1 = new ArrayList();
    long l = 1000L;
    ((ArrayList)localObject1).add(Long.valueOf(0L));
    while (l >= 0L)
    {
      this.jdField_a_of_type_AndroidMediaMediaExtractor.seekTo(l, 1);
      l = this.jdField_a_of_type_AndroidMediaMediaExtractor.getSampleTime();
      if (l < 0L) {
        break label237;
      }
      if (l > 0L)
      {
        ((ArrayList)localObject1).add(Long.valueOf(l));
        l += 1000L;
        if (((ArrayList)localObject1).size() >= this.jdField_c_of_type_Int)
        {
          this.jdField_a_of_type_JavaUtilArrayList.clear();
          if (QLog.isColorLevel()) {
            QLog.d("VFLDecodeRunnable", 2, "IFrame is enough");
          }
          return 2;
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("VFLDecodeRunnable", 2, "seektime = 0, error pos, break");
      }
    }
    int i;
    for (;;)
    {
      a((List)localObject1);
      this.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(0L));
      this.jdField_e_of_type_Int = 0;
      i = 0;
      if (this.jdField_e_of_type_Int >= this.jdField_c_of_type_Int - 1) {
        break label430;
      }
      l = a();
      for (;;)
      {
        if (i >= ((ArrayList)localObject1).size()) {
          break label305;
        }
        if (i + 1 >= ((ArrayList)localObject1).size()) {
          break label342;
        }
        if (l <= ((Long)((ArrayList)localObject1).get(i + 1)).longValue()) {
          break;
        }
        i += 1;
      }
      label237:
      if (QLog.isColorLevel()) {
        QLog.d("VFLDecodeRunnable", 2, "keytime = -1, end seek");
      }
    }
    if (l >= ((Long)((ArrayList)localObject1).get(i)).longValue()) {
      if (b() < ((Long)((ArrayList)localObject1).get(i)).longValue()) {
        this.jdField_a_of_type_JavaUtilArrayList.add(((ArrayList)localObject1).get(i));
      }
    }
    for (;;)
    {
      label305:
      break;
      this.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(-1L));
      continue;
      QLog.e("VFLDecodeRunnable", 2, "init seektimelist error!!");
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      return 0;
      label342:
      if (l < ((Long)((ArrayList)localObject1).get(i)).longValue()) {
        break label413;
      }
      if (b() < ((Long)((ArrayList)localObject1).get(i)).longValue()) {
        this.jdField_a_of_type_JavaUtilArrayList.add(((ArrayList)localObject1).get(i));
      } else {
        this.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(-1L));
      }
    }
    label413:
    QLog.e("VFLDecodeRunnable", 2, "init seektimelist error!!!");
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    return 0;
    label430:
    if (QLog.isColorLevel())
    {
      QLog.d("VFLDecodeRunnable", 2, new Object[] { "mSeekTimeList size:" + this.jdField_a_of_type_JavaUtilArrayList.size(), " framecount:" + this.jdField_c_of_type_Int });
      localObject1 = "SeekTimeList:";
      Object localObject2 = localObject1;
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        i = j;
        for (;;)
        {
          localObject2 = localObject1;
          if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
            break;
          }
          localObject1 = (String)localObject1 + this.jdField_a_of_type_JavaUtilArrayList.get(i);
          localObject1 = (String)localObject1 + ";";
          i += 1;
        }
      }
      QLog.d("VFLDecodeRunnable", 2, localObject2);
    }
    return 1;
  }
  
  private boolean a(long paramLong1, long paramLong2)
  {
    if (paramLong2 > this.jdField_c_of_type_Long - this.f) {
      if (paramLong1 <= paramLong2 - this.f) {}
    }
    while (paramLong1 > paramLong2)
    {
      return true;
      return false;
    }
    return false;
  }
  
  private long b()
  {
    int i = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
    long l = 0L;
    for (;;)
    {
      if (i >= 0)
      {
        l = ((Long)this.jdField_a_of_type_JavaUtilArrayList.get(i)).longValue();
        if (l < 0L) {}
      }
      else
      {
        return l;
      }
      i -= 1;
    }
  }
  
  private boolean b()
  {
    label133:
    label149:
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_AndroidMediaMediaExtractor.setDataSource(this.jdField_a_of_type_JavaLangString);
        int i = 0;
        MediaFormat localMediaFormat;
        String str;
        if (i < this.jdField_a_of_type_AndroidMediaMediaExtractor.getTrackCount())
        {
          localMediaFormat = this.jdField_a_of_type_AndroidMediaMediaExtractor.getTrackFormat(i);
          str = localMediaFormat.getString("mime");
          if (!str.startsWith("video/")) {
            break label149;
          }
          this.jdField_a_of_type_AndroidMediaMediaExtractor.selectTrack(i);
        }
        i += 1;
      }
      catch (IOException localIOException)
      {
        try
        {
          this.jdField_a_of_type_AndroidMediaMediaCodec = MediaCodec.createDecoderByType(str);
          this.jdField_a_of_type_Bnaa = new bnaa(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
          this.jdField_a_of_type_AndroidMediaMediaCodec.configure(localMediaFormat, this.jdField_a_of_type_Bnaa.a(), null, 0);
          return true;
        }
        catch (Throwable localThrowable)
        {
          if (!Thread.interrupted()) {
            break label133;
          }
          QLog.e("VFLDecodeRunnable", 2, "Thread is interrupted.", localThrowable);
          return false;
          QLog.e("VFLDecodeRunnable", 2, "decode configure error", localThrowable);
          a(2);
          return false;
        }
        localIOException = localIOException;
        localIOException.printStackTrace();
        a(2);
        return false;
      }
    }
  }
  
  private boolean c()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaCodec == null)
    {
      QLog.e("VFLDecodeRunnable", 2, "Can't find video info!");
      a(3);
      return false;
    }
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaCodec.start();
      return false;
    }
    catch (Throwable localThrowable)
    {
      try
      {
        this.jdField_a_of_type_ArrayOfJavaNioByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getInputBuffers();
        this.jdField_b_of_type_ArrayOfJavaNioByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
        this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo = new MediaCodec.BufferInfo();
        return true;
      }
      catch (Exception localException)
      {
        QLog.e("VFLDecodeRunnable", 2, "decode start error2", localException);
        a(3);
      }
      localThrowable = localThrowable;
      if (Thread.interrupted())
      {
        QLog.e("VFLDecodeRunnable", 2, "Thread is interrupted.", localThrowable);
        return false;
      }
      QLog.e("VFLDecodeRunnable", 2, "decode start error", localThrowable);
      a(3);
      return false;
    }
  }
  
  private boolean d()
  {
    int i = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueInputBuffer(10000L);
    if (i >= 0)
    {
      ByteBuffer localByteBuffer = this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[i];
      int j = this.jdField_a_of_type_AndroidMediaMediaExtractor.readSampleData(localByteBuffer, 0);
      this.d = this.jdField_a_of_type_AndroidMediaMediaExtractor.getSampleTime();
      if ((j < 0) || ((this.jdField_c_of_type_Long > 0L) && (this.d >= this.jdField_c_of_type_Long)))
      {
        this.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(i, 0, 0, 0L, 4);
        this.jdField_b_of_type_Boolean = true;
      }
      for (;;)
      {
        return true;
        this.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(i, 0, j, this.d, 0);
        this.jdField_a_of_type_AndroidMediaMediaExtractor.advance();
      }
    }
    QLog.w("VFLDecodeRunnable", 2, "queueSampleToCodec inIndex = " + i);
    return false;
  }
  
  private boolean e()
  {
    int i = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueOutputBuffer(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo, 10000L);
    switch (i)
    {
    default: 
      if ((this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.flags & 0x4) != 0)
      {
        QLog.d("VFLDecodeRunnable", 2, "output EOS");
        this.jdField_c_of_type_Boolean = true;
      }
      if ((!a(this.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo.presentationTimeUs, this.jdField_e_of_type_Long)) && (!this.jdField_c_of_type_Boolean)) {
        this.jdField_a_of_type_AndroidMediaMediaCodec.releaseOutputBuffer(i, false);
      }
      break;
    }
    do
    {
      return false;
      QLog.d("VFLDecodeRunnable", 2, "INFO_OUTPUT_BUFFERS_CHANGED");
      this.jdField_b_of_type_ArrayOfJavaNioByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
      return false;
      QLog.d("VFLDecodeRunnable", 2, "New format " + this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputFormat());
      return false;
      QLog.d("VFLDecodeRunnable", 2, "dequeueOutputBuffer timed out!");
      return false;
      this.jdField_e_of_type_Long = -1L;
      this.jdField_a_of_type_AndroidMediaMediaCodec.releaseOutputBuffer(i, true);
    } while (this.jdField_c_of_type_Boolean);
    return true;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 53
    //   8: iconst_2
    //   9: ldc_w 315
    //   12: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_0
    //   16: invokevirtual 317	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:b	()V
    //   19: aload_0
    //   20: invokespecial 319	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:b	()Z
    //   23: ifne +19 -> 42
    //   26: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   29: ifeq +12 -> 41
    //   32: ldc 53
    //   34: iconst_2
    //   35: ldc_w 321
    //   38: invokestatic 113	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   41: return
    //   42: aload_0
    //   43: invokespecial 323	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:c	()Z
    //   46: ifne +19 -> 65
    //   49: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   52: ifeq -11 -> 41
    //   55: ldc 53
    //   57: iconst_2
    //   58: ldc_w 325
    //   61: invokestatic 113	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: return
    //   65: aload_0
    //   66: invokespecial 327	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:a	()I
    //   69: istore_2
    //   70: aload_0
    //   71: iconst_m1
    //   72: putfield 96	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:jdField_e_of_type_Int	I
    //   75: aload_0
    //   76: getfield 30	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:jdField_a_of_type_AndroidMediaMediaExtractor	Landroid/media/MediaExtractor;
    //   79: lconst_0
    //   80: iconst_0
    //   81: invokevirtual 74	android/media/MediaExtractor:seekTo	(JI)V
    //   84: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   87: ifeq +29 -> 116
    //   90: ldc 53
    //   92: iconst_2
    //   93: new 119	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   100: ldc_w 329
    //   103: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: iload_2
    //   107: invokevirtual 129	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   110: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   116: invokestatic 222	java/lang/Thread:interrupted	()Z
    //   119: ifne +121 -> 240
    //   122: aload_0
    //   123: invokevirtual 331	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:a	()Z
    //   126: ifne +114 -> 240
    //   129: aload_0
    //   130: getfield 34	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:jdField_e_of_type_Long	J
    //   133: lconst_0
    //   134: lcmp
    //   135: ifge +15 -> 150
    //   138: aload_0
    //   139: aload_0
    //   140: invokevirtual 98	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:a	()J
    //   143: putfield 34	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:jdField_e_of_type_Long	J
    //   146: iload_2
    //   147: ifne +160 -> 307
    //   150: aload_0
    //   151: getfield 274	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:jdField_b_of_type_Boolean	Z
    //   154: ifne +8 -> 162
    //   157: aload_0
    //   158: invokespecial 333	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:d	()Z
    //   161: pop
    //   162: aload_0
    //   163: getfield 293	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:jdField_c_of_type_Boolean	Z
    //   166: ifne +67 -> 233
    //   169: aload_0
    //   170: invokespecial 335	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:e	()Z
    //   173: istore_3
    //   174: iload_3
    //   175: ifeq +58 -> 233
    //   178: iconst_2
    //   179: istore_1
    //   180: iload_1
    //   181: ifle +10 -> 191
    //   184: aload_0
    //   185: getfield 205	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:jdField_a_of_type_Bnaa	Lbnaa;
    //   188: invokevirtual 337	bnaa:c	()V
    //   191: aload_0
    //   192: getfield 205	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:jdField_a_of_type_Bnaa	Lbnaa;
    //   195: iconst_0
    //   196: invokevirtual 340	bnaa:a	(Z)V
    //   199: aload_0
    //   200: aload_0
    //   201: getfield 205	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:jdField_a_of_type_Bnaa	Lbnaa;
    //   204: invokevirtual 343	bnaa:a	()Landroid/graphics/Bitmap;
    //   207: invokevirtual 346	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:a	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   210: astore 4
    //   212: aload_0
    //   213: aload_0
    //   214: getfield 96	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:jdField_e_of_type_Int	I
    //   217: aload_0
    //   218: getfield 252	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   221: getfield 296	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   224: ldc2_w 59
    //   227: ldiv
    //   228: aload 4
    //   230: invokevirtual 349	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:a	(IJLandroid/graphics/Bitmap;)V
    //   233: aload_0
    //   234: getfield 293	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:jdField_c_of_type_Boolean	Z
    //   237: ifeq -121 -> 116
    //   240: aload_0
    //   241: getfield 194	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   244: invokevirtual 352	android/media/MediaCodec:stop	()V
    //   247: aload_0
    //   248: getfield 194	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   251: invokevirtual 355	android/media/MediaCodec:release	()V
    //   254: aload_0
    //   255: getfield 30	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:jdField_a_of_type_AndroidMediaMediaExtractor	Landroid/media/MediaExtractor;
    //   258: invokevirtual 356	android/media/MediaExtractor:release	()V
    //   261: aload_0
    //   262: getfield 205	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:jdField_a_of_type_Bnaa	Lbnaa;
    //   265: invokevirtual 358	bnaa:a	()V
    //   268: aload_0
    //   269: aconst_null
    //   270: putfield 252	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo	Landroid/media/MediaCodec$BufferInfo;
    //   273: aload_0
    //   274: aconst_null
    //   275: putfield 242	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:jdField_a_of_type_ArrayOfJavaNioByteBuffer	[Ljava/nio/ByteBuffer;
    //   278: aload_0
    //   279: aconst_null
    //   280: putfield 247	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:jdField_b_of_type_ArrayOfJavaNioByteBuffer	[Ljava/nio/ByteBuffer;
    //   283: aload_0
    //   284: aload_0
    //   285: getfield 293	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:jdField_c_of_type_Boolean	Z
    //   288: invokevirtual 359	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:a	(Z)V
    //   291: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   294: ifeq -253 -> 41
    //   297: ldc 53
    //   299: iconst_2
    //   300: ldc_w 361
    //   303: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   306: return
    //   307: iload_2
    //   308: iconst_1
    //   309: if_icmpne +151 -> 460
    //   312: aload_0
    //   313: getfield 96	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:jdField_e_of_type_Int	I
    //   316: iflt -166 -> 150
    //   319: aload_0
    //   320: getfield 96	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:jdField_e_of_type_Int	I
    //   323: aload_0
    //   324: getfield 43	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   327: invokevirtual 81	java/util/ArrayList:size	()I
    //   330: if_icmpge -180 -> 150
    //   333: aload_0
    //   334: getfield 43	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   337: aload_0
    //   338: getfield 96	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:jdField_e_of_type_Int	I
    //   341: invokevirtual 102	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   344: checkcast 62	java/lang/Long
    //   347: invokevirtual 105	java/lang/Long:longValue	()J
    //   350: lconst_0
    //   351: lcmp
    //   352: iflt -202 -> 150
    //   355: aload_0
    //   356: aload_0
    //   357: getfield 43	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   360: aload_0
    //   361: getfield 96	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:jdField_e_of_type_Int	I
    //   364: invokevirtual 102	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   367: checkcast 62	java/lang/Long
    //   370: invokevirtual 105	java/lang/Long:longValue	()J
    //   373: putfield 34	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:jdField_e_of_type_Long	J
    //   376: aload_0
    //   377: getfield 30	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:jdField_a_of_type_AndroidMediaMediaExtractor	Landroid/media/MediaExtractor;
    //   380: aload_0
    //   381: getfield 34	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:jdField_e_of_type_Long	J
    //   384: iconst_0
    //   385: invokevirtual 74	android/media/MediaExtractor:seekTo	(JI)V
    //   388: aload_0
    //   389: aload_0
    //   390: getfield 30	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:jdField_a_of_type_AndroidMediaMediaExtractor	Landroid/media/MediaExtractor;
    //   393: invokevirtual 78	android/media/MediaExtractor:getSampleTime	()J
    //   396: putfield 268	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:d	J
    //   399: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   402: ifeq +45 -> 447
    //   405: ldc 53
    //   407: iconst_2
    //   408: new 119	java/lang/StringBuilder
    //   411: dup
    //   412: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   415: ldc_w 363
    //   418: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: aload_0
    //   422: getfield 34	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:jdField_e_of_type_Long	J
    //   425: invokevirtual 366	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   428: ldc_w 368
    //   431: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: aload_0
    //   435: getfield 268	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:d	J
    //   438: invokevirtual 366	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   441: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   444: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   447: aload_0
    //   448: iconst_0
    //   449: putfield 274	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:jdField_b_of_type_Boolean	Z
    //   452: aload_0
    //   453: iconst_0
    //   454: putfield 293	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:jdField_c_of_type_Boolean	Z
    //   457: goto -307 -> 150
    //   460: aload_0
    //   461: getfield 30	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:jdField_a_of_type_AndroidMediaMediaExtractor	Landroid/media/MediaExtractor;
    //   464: aload_0
    //   465: getfield 34	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:jdField_e_of_type_Long	J
    //   468: iconst_0
    //   469: invokevirtual 74	android/media/MediaExtractor:seekTo	(JI)V
    //   472: aload_0
    //   473: aload_0
    //   474: getfield 30	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:jdField_a_of_type_AndroidMediaMediaExtractor	Landroid/media/MediaExtractor;
    //   477: invokevirtual 78	android/media/MediaExtractor:getSampleTime	()J
    //   480: putfield 268	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:d	J
    //   483: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   486: ifeq +45 -> 531
    //   489: ldc 53
    //   491: iconst_2
    //   492: new 119	java/lang/StringBuilder
    //   495: dup
    //   496: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   499: ldc_w 363
    //   502: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: aload_0
    //   506: getfield 34	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:jdField_e_of_type_Long	J
    //   509: invokevirtual 366	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   512: ldc_w 368
    //   515: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: aload_0
    //   519: getfield 268	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:d	J
    //   522: invokevirtual 366	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   525: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   528: invokestatic 113	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   531: aload_0
    //   532: iconst_0
    //   533: putfield 274	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:jdField_b_of_type_Boolean	Z
    //   536: aload_0
    //   537: iconst_0
    //   538: putfield 293	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:jdField_c_of_type_Boolean	Z
    //   541: goto -391 -> 150
    //   544: astore 4
    //   546: aload 4
    //   548: invokevirtual 369	java/lang/Exception:printStackTrace	()V
    //   551: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   554: ifeq +30 -> 584
    //   557: ldc 53
    //   559: iconst_2
    //   560: new 119	java/lang/StringBuilder
    //   563: dup
    //   564: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   567: ldc_w 371
    //   570: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: aload 4
    //   575: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   578: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   581: invokestatic 58	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   584: iload_1
    //   585: iconst_1
    //   586: isub
    //   587: istore_1
    //   588: goto -408 -> 180
    //   591: astore 4
    //   593: invokestatic 222	java/lang/Thread:interrupted	()Z
    //   596: ifeq +16 -> 612
    //   599: ldc 53
    //   601: iconst_2
    //   602: ldc 224
    //   604: aload 4
    //   606: invokestatic 227	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   609: goto -376 -> 233
    //   612: aload_0
    //   613: iconst_4
    //   614: invokevirtual 217	dov/com/tencent/biz/qqstory/takevideo/multivideo/CodecDecodeRunnable:a	(I)V
    //   617: ldc 53
    //   619: iconst_2
    //   620: ldc_w 373
    //   623: aload 4
    //   625: invokestatic 227	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   628: goto -388 -> 240
    //   631: astore 4
    //   633: ldc 53
    //   635: iconst_2
    //   636: new 119	java/lang/StringBuilder
    //   639: dup
    //   640: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   643: ldc_w 375
    //   646: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: aload 4
    //   651: invokevirtual 376	java/lang/Exception:toString	()Ljava/lang/String;
    //   654: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   657: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   660: invokestatic 113	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   663: goto -380 -> 283
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	666	0	this	CodecDecodeRunnable
    //   179	409	1	i	int
    //   69	241	2	j	int
    //   173	2	3	bool	boolean
    //   210	19	4	localBitmap	android.graphics.Bitmap
    //   544	30	4	localException1	Exception
    //   591	33	4	localThrowable	Throwable
    //   631	19	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   184	191	544	java/lang/Exception
    //   150	162	591	java/lang/Throwable
    //   162	174	591	java/lang/Throwable
    //   184	191	591	java/lang/Throwable
    //   191	233	591	java/lang/Throwable
    //   546	584	591	java/lang/Throwable
    //   240	283	631	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.multivideo.CodecDecodeRunnable
 * JD-Core Version:    0.7.0.1
 */