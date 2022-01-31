package com.tencent.mobileqq.shortvideo.hwcodec;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import azgr;
import azgt;
import azgy;
import azgz;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@TargetApi(18)
public class SVHwEncoder
{
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private static boolean jdField_e_of_type_Boolean;
  private double jdField_a_of_type_Double;
  private volatile float jdField_a_of_type_Float = 30.0F;
  public int a;
  private azgz jdField_a_of_type_Azgz;
  private SVHwEncoder.HwEncode jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<azgy> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt = new int[4];
  private double jdField_b_of_type_Double;
  private int jdField_b_of_type_Int;
  private ArrayList<azgy> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private volatile boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private ArrayList<azgy> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  private volatile boolean jdField_c_of_type_Boolean;
  private volatile int jdField_d_of_type_Int = 480000;
  private volatile boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = 44100;
  private int f = 1;
  private int g = 128000;
  private int h = 2;
  private int i = -1;
  private int j = -1;
  private int k;
  private int l;
  private int m;
  
  public SVHwEncoder()
  {
    this.jdField_a_of_type_Int = 21;
  }
  
  private native boolean adjustDstresolution(int[] paramArrayOfInt);
  
  int a(ArrayList<azgy> paramArrayList)
  {
    try
    {
      int n = paramArrayList.size();
      return n;
    }
    finally
    {
      paramArrayList = finally;
      throw paramArrayList;
    }
  }
  
  int a(List<MediaCodecInfo> paramList, String paramString)
  {
    if (paramList.size() <= 0) {
      return -1;
    }
    int n = 0;
    MediaCodecInfo.CodecCapabilities localCodecCapabilities;
    int i2;
    for (int i1 = -1;; i1 = i2)
    {
      if (n < paramList.size())
      {
        localCodecCapabilities = azgr.a((MediaCodecInfo)paramList.get(n), paramString);
        if (localCodecCapabilities != null) {}
      }
      else
      {
        return i1;
      }
      a("selectAudioCodec", "name=" + ((MediaCodecInfo)paramList.get(n)).getName());
      i2 = i1;
      if (localCodecCapabilities.profileLevels != null)
      {
        if (localCodecCapabilities.profileLevels.length > 0) {
          break;
        }
        i2 = i1;
      }
      n += 1;
    }
    int i3 = 0;
    for (;;)
    {
      i2 = i1;
      if (i3 >= localCodecCapabilities.profileLevels.length) {
        break;
      }
      if (localCodecCapabilities.profileLevels[i3].profile == 2)
      {
        i2 = n;
        break;
      }
      i3 += 1;
    }
  }
  
  /* Error */
  public azgy a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_1
    //   3: astore_2
    //   4: aload_0
    //   5: getfield 103	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:jdField_b_of_type_Boolean	Z
    //   8: ifne +133 -> 141
    //   11: aload_1
    //   12: astore_2
    //   13: aload_0
    //   14: getfield 74	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   17: ifnull +124 -> 141
    //   20: aload_0
    //   21: getfield 74	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   24: invokevirtual 118	java/util/ArrayList:size	()I
    //   27: ifle +192 -> 219
    //   30: aload_0
    //   31: getfield 69	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   34: astore_2
    //   35: aload_2
    //   36: monitorenter
    //   37: aload_0
    //   38: getfield 74	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   41: invokevirtual 118	java/util/ArrayList:size	()I
    //   44: ifle +170 -> 214
    //   47: aload_0
    //   48: getfield 74	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   51: iconst_0
    //   52: invokevirtual 172	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   55: checkcast 174	azgy
    //   58: astore_1
    //   59: aload_0
    //   60: getfield 74	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   63: iconst_0
    //   64: invokevirtual 177	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   67: pop
    //   68: aload_2
    //   69: monitorexit
    //   70: aload_1
    //   71: ifnull +10 -> 81
    //   74: aload_1
    //   75: getfield 180	azgy:jdField_a_of_type_ArrayOfByte	[B
    //   78: ifnonnull +112 -> 190
    //   81: aload_0
    //   82: getfield 101	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:jdField_b_of_type_Int	I
    //   85: aload_0
    //   86: getfield 105	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:jdField_c_of_type_Int	I
    //   89: imul
    //   90: iconst_3
    //   91: imul
    //   92: iconst_2
    //   93: idiv
    //   94: newarray byte
    //   96: astore_3
    //   97: new 174	azgy
    //   100: dup
    //   101: invokespecial 181	azgy:<init>	()V
    //   104: astore_2
    //   105: aload_2
    //   106: aload_3
    //   107: putfield 180	azgy:jdField_a_of_type_ArrayOfByte	[B
    //   110: aload_2
    //   111: ldc 182
    //   113: putfield 183	azgy:jdField_a_of_type_Float	F
    //   116: aload_2
    //   117: iconst_m1
    //   118: putfield 184	azgy:jdField_c_of_type_Int	I
    //   121: aload_2
    //   122: astore_1
    //   123: aload_1
    //   124: astore_2
    //   125: invokestatic 190	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   128: ifeq +13 -> 141
    //   131: ldc 192
    //   133: iconst_2
    //   134: ldc 194
    //   136: invokestatic 197	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   139: aload_1
    //   140: astore_2
    //   141: aload_2
    //   142: areturn
    //   143: astore_1
    //   144: aload_2
    //   145: monitorexit
    //   146: aload_1
    //   147: athrow
    //   148: astore_2
    //   149: invokestatic 190	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   152: ifeq +12 -> 164
    //   155: ldc 192
    //   157: iconst_2
    //   158: ldc 199
    //   160: aload_2
    //   161: invokestatic 202	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   164: aload_0
    //   165: getfield 204	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:jdField_a_of_type_Azgz	Lazgz;
    //   168: ifnull +15 -> 183
    //   171: aload_0
    //   172: getfield 204	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:jdField_a_of_type_Azgz	Lazgz;
    //   175: bipush 229
    //   177: iconst_0
    //   178: invokeinterface 209 3 0
    //   183: aload_0
    //   184: invokevirtual 211	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:c	()V
    //   187: goto -64 -> 123
    //   190: invokestatic 190	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   193: ifeq +11 -> 204
    //   196: ldc 192
    //   198: iconst_2
    //   199: ldc 213
    //   201: invokestatic 197	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   204: aload_1
    //   205: areturn
    //   206: astore_3
    //   207: aload_2
    //   208: astore_1
    //   209: aload_3
    //   210: astore_2
    //   211: goto -62 -> 149
    //   214: aconst_null
    //   215: astore_1
    //   216: goto -148 -> 68
    //   219: aconst_null
    //   220: astore_1
    //   221: goto -151 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	this	SVHwEncoder
    //   1	139	1	localObject1	Object
    //   143	62	1	localazgy	azgy
    //   208	13	1	localObject2	Object
    //   3	142	2	localObject3	Object
    //   148	60	2	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   210	1	2	localObject4	Object
    //   96	11	3	arrayOfByte	byte[]
    //   206	4	3	localOutOfMemoryError2	java.lang.OutOfMemoryError
    // Exception table:
    //   from	to	target	type
    //   37	68	143	finally
    //   68	70	143	finally
    //   144	146	143	finally
    //   81	105	148	java/lang/OutOfMemoryError
    //   105	121	206	java/lang/OutOfMemoryError
  }
  
  azgy a(ArrayList<azgy> paramArrayList)
  {
    azgy localazgy = null;
    try
    {
      if (paramArrayList.size() > 0) {
        localazgy = (azgy)paramArrayList.get(0);
      }
      return localazgy;
    }
    finally
    {
      paramArrayList = finally;
      throw paramArrayList;
    }
  }
  
  void a()
  {
    this.jdField_a_of_type_ArrayOfInt[0] = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_ArrayOfInt[1] = this.jdField_c_of_type_Int;
    this.jdField_a_of_type_ArrayOfInt[2] = 0;
    this.jdField_a_of_type_ArrayOfInt[3] = 0;
    try
    {
      bool = adjustDstresolution(this.jdField_a_of_type_ArrayOfInt);
      if (!bool)
      {
        this.jdField_b_of_type_Int -= this.jdField_b_of_type_Int % 16;
        this.jdField_c_of_type_Int -= this.jdField_c_of_type_Int % 16;
        return;
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        localUnsatisfiedLinkError.printStackTrace();
        boolean bool = false;
      }
      this.jdField_b_of_type_Int = this.jdField_a_of_type_ArrayOfInt[2];
      this.jdField_c_of_type_Int = this.jdField_a_of_type_ArrayOfInt[3];
    }
  }
  
  public void a(double paramDouble1, double paramDouble2, float paramFloat, int paramInt)
  {
    this.jdField_a_of_type_Double = paramDouble1;
    this.jdField_b_of_type_Double = paramDouble2;
    this.l = 320;
    if (RMVideoStateMgr.jdField_a_of_type_Boolean) {
      this.l = paramInt;
    }
    this.m = ((int)(this.l / paramFloat));
    if (this.m % 2 > 0) {
      this.m -= 1;
    }
  }
  
  public void a(float paramFloat, int paramInt)
  {
    azgy localazgy = new azgy();
    localazgy.jdField_a_of_type_Boolean = true;
    localazgy.jdField_b_of_type_Boolean = true;
    localazgy.jdField_a_of_type_Float = paramFloat;
    localazgy.jdField_c_of_type_Int = paramInt;
    a(localazgy, true);
    localazgy = new azgy();
    localazgy.jdField_a_of_type_Boolean = true;
    localazgy.jdField_b_of_type_Boolean = false;
    a(localazgy, false);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0) {
      this.jdField_a_of_type_Float = paramInt1;
    }
    if (paramInt2 > 0) {
      this.jdField_d_of_type_Int = paramInt2;
    }
    a("hw_video_bitrate_set", "configVideoBitrate mVideoBitrate=" + this.jdField_d_of_type_Int);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 == 8000) || (paramInt1 == 16000) || (paramInt1 == 44100)) {
      this.jdField_e_of_type_Int = paramInt1;
    }
    if ((paramInt2 == 1) || (paramInt2 == 2)) {
      this.f = paramInt2;
    }
    if ((paramInt3 == 64000) || (paramInt3 == 128000)) {
      this.g = paramInt3;
    }
    if ((paramInt4 == 1) || (paramInt4 == 2)) {
      this.h = paramInt4;
    }
  }
  
  /* Error */
  public void a(azgy paramazgy, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 103	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:jdField_b_of_type_Boolean	Z
    //   6: ifne +63 -> 69
    //   9: iload_2
    //   10: ifeq +62 -> 72
    //   13: aload_0
    //   14: getfield 76	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   17: ifnull +55 -> 72
    //   20: aload_0
    //   21: getfield 76	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   24: aload_1
    //   25: invokevirtual 245	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   28: pop
    //   29: aload_0
    //   30: ldc 247
    //   32: new 139	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   39: ldc 249
    //   41: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_1
    //   45: getfield 228	azgy:jdField_a_of_type_Boolean	Z
    //   48: invokevirtual 252	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   51: ldc 254
    //   53: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_1
    //   57: getfield 255	azgy:jdField_b_of_type_Int	I
    //   60: invokevirtual 239	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   63: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokevirtual 156	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: aload_0
    //   70: monitorexit
    //   71: return
    //   72: aload_0
    //   73: getfield 78	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   76: ifnull -7 -> 69
    //   79: aload_0
    //   80: getfield 78	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:jdField_c_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   83: aload_1
    //   84: invokevirtual 245	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   87: pop
    //   88: aload_0
    //   89: ldc_w 257
    //   92: new 139	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   99: ldc 249
    //   101: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload_1
    //   105: getfield 228	azgy:jdField_a_of_type_Boolean	Z
    //   108: invokevirtual 252	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   111: ldc 254
    //   113: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload_1
    //   117: getfield 255	azgy:jdField_b_of_type_Int	I
    //   120: invokevirtual 239	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   123: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokevirtual 156	com/tencent/mobileqq/shortvideo/hwcodec/SVHwEncoder:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   129: goto -60 -> 69
    //   132: astore_1
    //   133: aload_0
    //   134: monitorexit
    //   135: aload_1
    //   136: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	this	SVHwEncoder
    //   0	137	1	paramazgy	azgy
    //   0	137	2	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   2	9	132	finally
    //   13	69	132	finally
    //   72	129	132	finally
  }
  
  public void a(azgz paramazgz, azgt paramazgt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Azgz = paramazgz;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode = new SVHwEncoder.HwEncode(this, this.jdField_a_of_type_JavaLangString, paramazgz, paramazgt, paramBoolean, 99000);
    ThreadManagerV2.executeOnSubThread(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    a();
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((!jdField_e_of_type_Boolean) && (QLog.isColorLevel())) {
      QLog.d("SVHwEncoder", 2, paramString1 + ":" + paramString2);
    }
  }
  
  void a(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo, String paramString, int paramInt)
  {
    if (paramByteBuffer == null) {
      a(paramString, "Configdata buferData=null");
    }
    do
    {
      return;
      if (paramBufferInfo.size != 0) {
        a(paramString, "Configdata size=" + paramBufferInfo.size);
      }
    } while (paramBufferInfo.size >= paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    paramInt = 0;
    while (paramInt < paramBufferInfo.size)
    {
      paramByteBuffer.position(paramBufferInfo.offset + paramInt);
      localStringBuilder.append(paramByteBuffer.get()).append(',');
      paramInt += 1;
    }
    a(paramString, "Configdata =" + localStringBuilder.toString());
  }
  
  void a(ArrayList<azgy> paramArrayList)
  {
    try
    {
      if (paramArrayList.size() > 0) {
        paramArrayList.remove(0);
      }
      return;
    }
    finally
    {
      paramArrayList = finally;
      throw paramArrayList;
    }
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Boolean = true;
    this.i = paramInt1;
    this.j = paramInt2;
    paramInt1 = paramInt3;
    if (paramInt3 != 0)
    {
      paramInt1 = paramInt3;
      if (paramInt3 != 90)
      {
        paramInt1 = paramInt3;
        if (paramInt3 != 180)
        {
          paramInt1 = paramInt3;
          if (paramInt3 != 270) {
            paramInt1 = 0;
          }
        }
      }
    }
    this.k = paramInt1;
    if (this.j <= 0)
    {
      this.j = 1000;
      return false;
    }
    if (this.i <= 0)
    {
      this.i = 1;
      return false;
    }
    return true;
  }
  
  boolean a(azgy paramazgy)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() < 3) {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.size() < 3)
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(paramazgy);
          bool = true;
        }
        return bool;
      }
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void b(azgz paramazgz, azgt paramazgt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Azgz = paramazgz;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode = new SVHwEncoder.HwEncode(this, this.jdField_a_of_type_JavaLangString, paramazgz, paramazgt, paramBoolean, 0);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode.run();
  }
  
  void b(ArrayList<azgy> paramArrayList)
  {
    try
    {
      paramArrayList.clear();
      return;
    }
    finally
    {
      paramArrayList = finally;
      throw paramArrayList;
    }
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
  }
  
  void d()
  {
    try
    {
      azgy localazgy = new azgy();
      localazgy.jdField_a_of_type_Boolean = true;
      localazgy.jdField_b_of_type_Boolean = true;
      localazgy.jdField_a_of_type_Float = 30.0F;
      localazgy.jdField_c_of_type_Int = 480000;
      this.jdField_b_of_type_JavaUtilArrayList.add(localazgy);
      localazgy = new azgy();
      localazgy.jdField_a_of_type_Boolean = true;
      localazgy.jdField_b_of_type_Boolean = false;
      this.jdField_c_of_type_JavaUtilArrayList.add(localazgy);
      a("hw_video_write_frame", "addMediaEndFrame finish...");
      a("hw_audio_write_frame", "addMediaEndFrame finish...");
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void e()
  {
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode.f();
  }
  
  public void f()
  {
    this.jdField_d_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder
 * JD-Core Version:    0.7.0.1
 */