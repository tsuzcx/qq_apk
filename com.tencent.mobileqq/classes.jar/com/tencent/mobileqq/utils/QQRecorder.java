package com.tencent.mobileqq.utils;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import avcr;
import avcv;
import axrl;
import bbdj;
import bbik;
import bbim;
import bbis;
import bfni;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Random;

public class QQRecorder
{
  public static int a;
  private static int[] jdField_a_of_type_ArrayOfInt = { 13, 14, 16, 18, 20, 21, 27, 32 };
  private static String jdField_b_of_type_JavaLangString;
  private Context jdField_a_of_type_AndroidContentContext;
  AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private AudioRecord jdField_a_of_type_AndroidMediaAudioRecord;
  private avcv jdField_a_of_type_Avcv;
  private bbik jdField_a_of_type_Bbik;
  private bbim jdField_a_of_type_Bbim;
  public QQRecorder.RecordThread a;
  public QQRecorder.RecorderParam a;
  private String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 20480;
  public boolean b;
  private int jdField_c_of_type_Int = 800;
  private boolean jdField_c_of_type_Boolean = true;
  private int d;
  private int e = -1;
  private int f = -1;
  
  static
  {
    jdField_a_of_type_Int = 60000;
  }
  
  public QQRecorder(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)paramContext.getSystemService("audio"));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam = new QQRecorder.RecorderParam(bbis.jdField_a_of_type_Int, 0, 0);
    paramContext = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.qq_audio_record.name());
    if (QLog.isColorLevel()) {
      QLog.d("QQRecorder", 2, "Init | dpc config = " + paramContext);
    }
    if (!TextUtils.isEmpty(paramContext)) {
      try
      {
        paramContext = paramContext.split("\\|");
        this.e = Integer.parseInt(paramContext[0]);
        this.f = Integer.parseInt(paramContext[1]);
        if (paramContext.length > 4) {
          a(Integer.parseInt(paramContext[2]), Integer.parseInt(paramContext[3]), Integer.parseInt(paramContext[4]));
        }
        if ((!bfni.e()) && ((this.e == 3) || (this.f == 7))) {
          throw new RuntimeException("Illegal dpc config");
        }
      }
      catch (Exception paramContext)
      {
        this.e = -1;
        this.f = -1;
        if (QLog.isColorLevel()) {
          QLog.d("QQRecorder", 2, "QQRecord init error.", paramContext);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQRecorder", 2, "mMode = " + this.e + " | mAudioSource = " + this.f + " | recorderBufSize = " + this.jdField_b_of_type_Int + " | readLength = " + this.jdField_c_of_type_Int);
    }
  }
  
  public static double a(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    if (paramLong <= 0L) {
      return 0.0D;
    }
    return paramLong / b(paramInt1, paramInt2, paramInt3);
  }
  
  public static int a(byte paramByte, InputStream paramInputStream)
  {
    byte[] arrayOfByte = new byte[2];
    paramByte = 0;
    while (paramInputStream.read(arrayOfByte) > 0)
    {
      int i = bbis.a(arrayOfByte);
      byte b1 = paramByte + 20;
      paramByte = b1;
      if (i > 0)
      {
        paramInputStream.skip(i);
        paramByte = b1;
      }
    }
    return paramByte;
  }
  
  public static int a(double paramDouble)
  {
    return b(paramDouble / 1000.0D);
  }
  
  public static int a(int paramInt)
  {
    String str1 = Build.MANUFACTURER + "-" + Build.MODEL;
    String str2 = Build.MANUFACTURER;
    int i;
    if ((str1.equalsIgnoreCase("Xiaomi-MI NOTE Pro")) || (str2.equalsIgnoreCase("OPPO"))) {
      i = paramInt + 100;
    }
    do
    {
      return i;
      i = paramInt;
    } while (!str2.equalsIgnoreCase("vivo"));
    return paramInt + 130;
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 2;
    switch (paramInt2)
    {
    default: 
      throw new RuntimeException("channel Illegal");
    }
    for (paramInt2 = 1;; paramInt2 = 2) {
      switch (paramInt3)
      {
      default: 
        throw new RuntimeException("format Illegal");
      }
    }
    i = 1;
    return i * paramInt1 * paramInt2;
  }
  
  public static int a(MessageRecord paramMessageRecord)
  {
    String str = null;
    if ((paramMessageRecord instanceof MessageForPtt))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQRecorder", 2, "voiceLength getFilePlayTime " + ((MessageForPtt)paramMessageRecord).voiceLength);
      }
      if (((MessageForPtt)paramMessageRecord).voiceLength > 1) {
        return ((MessageForPtt)paramMessageRecord).voiceLength;
      }
      str = ((MessageForPtt)paramMessageRecord).getLocalFilePath();
    }
    while (str != null)
    {
      return a(str);
      if ((paramMessageRecord instanceof QQMessageFacade.Message)) {
        str = ((QQMessageFacade.Message)paramMessageRecord).pttUrl;
      }
    }
    return 0;
  }
  
  /* Error */
  public static int a(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aconst_null
    //   3: astore 7
    //   5: aconst_null
    //   6: astore 6
    //   8: new 234	java/io/FileInputStream
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 235	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   16: astore_0
    //   17: new 237	java/io/DataInputStream
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 240	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   25: astore 7
    //   27: aload_0
    //   28: invokevirtual 244	java/io/FileInputStream:available	()I
    //   31: istore 4
    //   33: bipush 10
    //   35: newarray byte
    //   37: astore 8
    //   39: aload 7
    //   41: aload 8
    //   43: invokevirtual 245	java/io/DataInputStream:read	([B)I
    //   46: aload 8
    //   48: arraylength
    //   49: if_icmpne +234 -> 283
    //   52: aload 8
    //   54: invokestatic 248	bbis:a	([B)Z
    //   57: ifeq +54 -> 111
    //   60: aload 8
    //   62: iconst_0
    //   63: baload
    //   64: aload 7
    //   66: invokestatic 250	com/tencent/mobileqq/utils/QQRecorder:a	(BLjava/io/InputStream;)I
    //   69: i2d
    //   70: ldc2_w 184
    //   73: ddiv
    //   74: dstore_1
    //   75: aload 7
    //   77: invokevirtual 253	java/io/DataInputStream:close	()V
    //   80: aload_0
    //   81: invokevirtual 254	java/io/FileInputStream:close	()V
    //   84: aconst_null
    //   85: astore_0
    //   86: aload_0
    //   87: ifnull +7 -> 94
    //   90: aload_0
    //   91: invokevirtual 254	java/io/FileInputStream:close	()V
    //   94: aload 6
    //   96: ifnull +8 -> 104
    //   99: aload 6
    //   101: invokevirtual 253	java/io/DataInputStream:close	()V
    //   104: dload_1
    //   105: invokestatic 187	com/tencent/mobileqq/utils/QQRecorder:b	(D)I
    //   108: istore_3
    //   109: iload_3
    //   110: ireturn
    //   111: aload 8
    //   113: bipush 6
    //   115: baload
    //   116: iconst_3
    //   117: ishr
    //   118: i2b
    //   119: bipush 7
    //   121: iand
    //   122: i2b
    //   123: istore 5
    //   125: iload 4
    //   127: i2d
    //   128: dstore_1
    //   129: getstatic 29	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ArrayOfInt	[I
    //   132: iload 5
    //   134: iaload
    //   135: istore 4
    //   137: dload_1
    //   138: ldc2_w 255
    //   141: dsub
    //   142: iload 4
    //   144: i2d
    //   145: ddiv
    //   146: ldc2_w 257
    //   149: ddiv
    //   150: dstore_1
    //   151: goto -76 -> 75
    //   154: astore 8
    //   156: aconst_null
    //   157: astore_0
    //   158: aload 7
    //   160: astore 6
    //   162: aload 8
    //   164: invokevirtual 261	java/lang/Exception:printStackTrace	()V
    //   167: aload 6
    //   169: ifnull +8 -> 177
    //   172: aload 6
    //   174: invokevirtual 254	java/io/FileInputStream:close	()V
    //   177: aload_0
    //   178: ifnull -69 -> 109
    //   181: aload_0
    //   182: invokevirtual 253	java/io/DataInputStream:close	()V
    //   185: iconst_0
    //   186: ireturn
    //   187: astore_0
    //   188: iconst_0
    //   189: ireturn
    //   190: astore 6
    //   192: aconst_null
    //   193: astore 7
    //   195: aconst_null
    //   196: astore_0
    //   197: aload_0
    //   198: ifnull +7 -> 205
    //   201: aload_0
    //   202: invokevirtual 254	java/io/FileInputStream:close	()V
    //   205: aload 7
    //   207: ifnull +8 -> 215
    //   210: aload 7
    //   212: invokevirtual 253	java/io/DataInputStream:close	()V
    //   215: aload 6
    //   217: athrow
    //   218: astore_0
    //   219: goto -4 -> 215
    //   222: astore 6
    //   224: aconst_null
    //   225: astore 7
    //   227: goto -30 -> 197
    //   230: astore 6
    //   232: goto -35 -> 197
    //   235: astore 7
    //   237: aload 6
    //   239: astore 8
    //   241: aload 7
    //   243: astore 6
    //   245: aload_0
    //   246: astore 7
    //   248: aload 8
    //   250: astore_0
    //   251: goto -54 -> 197
    //   254: astore 8
    //   256: aconst_null
    //   257: astore 7
    //   259: aload_0
    //   260: astore 6
    //   262: aload 7
    //   264: astore_0
    //   265: goto -103 -> 162
    //   268: astore 8
    //   270: aload_0
    //   271: astore 6
    //   273: aload 7
    //   275: astore_0
    //   276: goto -114 -> 162
    //   279: astore_0
    //   280: goto -176 -> 104
    //   283: aload 7
    //   285: astore 6
    //   287: dconst_0
    //   288: dstore_1
    //   289: goto -203 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	292	0	paramString	String
    //   74	215	1	d1	double
    //   1	109	3	i	int
    //   31	112	4	j	int
    //   123	10	5	k	int
    //   6	167	6	localDataInputStream1	java.io.DataInputStream
    //   190	26	6	localObject1	Object
    //   222	1	6	localObject2	Object
    //   230	8	6	localObject3	Object
    //   243	43	6	localObject4	Object
    //   3	223	7	localDataInputStream2	java.io.DataInputStream
    //   235	7	7	localObject5	Object
    //   246	38	7	str	String
    //   37	75	8	arrayOfByte	byte[]
    //   154	9	8	localException1	Exception
    //   239	10	8	localObject6	Object
    //   254	1	8	localException2	Exception
    //   268	1	8	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   8	17	154	java/lang/Exception
    //   172	177	187	java/lang/Exception
    //   181	185	187	java/lang/Exception
    //   8	17	190	finally
    //   201	205	218	java/lang/Exception
    //   210	215	218	java/lang/Exception
    //   17	27	222	finally
    //   80	84	222	finally
    //   27	75	230	finally
    //   75	80	230	finally
    //   129	137	230	finally
    //   162	167	235	finally
    //   17	27	254	java/lang/Exception
    //   80	84	254	java/lang/Exception
    //   27	75	268	java/lang/Exception
    //   75	80	268	java/lang/Exception
    //   129	137	268	java/lang/Exception
    //   90	94	279	java/lang/Exception
    //   99	104	279	java/lang/Exception
  }
  
  public static QQRecorder.RecorderParam a()
  {
    return new QQRecorder.RecorderParam(bbis.jdField_a_of_type_Int, 0, 0);
  }
  
  public static String a()
  {
    return jdField_b_of_type_JavaLangString;
  }
  
  public static boolean a(int paramInt)
  {
    if (paramInt == 0) {
      if (!AmrInputStreamWrapper.a()) {}
    }
    while ((SilkCodecWrapper.a()) || (bbdj.a() > 1310720.0F))
    {
      do
      {
        return true;
      } while (bbdj.a() > 327680.0F);
      return false;
    }
    return false;
  }
  
  private static double b(long paramLong, int paramInt)
  {
    return a(paramInt, 2, 2, paramLong);
  }
  
  public static int b(double paramDouble)
  {
    double d1 = paramDouble;
    if (paramDouble <= 0.5D)
    {
      d1 = paramDouble;
      if (paramDouble > 0.0D) {
        d1 = paramDouble + 0.5D;
      }
    }
    return (int)(d1 + 0.5D);
  }
  
  public static int b(int paramInt1, int paramInt2, int paramInt3)
  {
    return a(paramInt1, paramInt2, paramInt3) / 1000;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {}
    for (int i = this.jdField_a_of_type_AndroidMediaAudioManager.getMode();; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQRecorder", 2, "startRecording | audio mode = " + i);
      }
      if ((this.jdField_a_of_type_AndroidMediaAudioManager != null) && (this.e != -1)) {
        this.jdField_a_of_type_AndroidMediaAudioManager.setMode(this.e);
      }
      if ((this.jdField_a_of_type_AndroidMediaAudioRecord == null) || (this.jdField_a_of_type_AndroidMediaAudioRecord.getState() == 0) || (this.jdField_a_of_type_Boolean)) {
        if (this.f != -1) {
          break label203;
        }
      }
      label203:
      for (i = 0;; i = this.f)
      {
        this.jdField_a_of_type_AndroidMediaAudioRecord = new AudioRecord(i, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.jdField_a_of_type_Int, 2, 2, this.jdField_b_of_type_Int);
        this.jdField_a_of_type_Boolean = false;
        if (this.jdField_a_of_type_AndroidMediaAudioRecord.getState() == 1) {
          break;
        }
        i = this.jdField_a_of_type_AndroidMediaAudioRecord.getState();
        if (this.jdField_a_of_type_AndroidMediaAudioRecord != null) {
          this.jdField_a_of_type_AndroidMediaAudioRecord.release();
        }
        this.jdField_a_of_type_AndroidMediaAudioRecord = null;
        throw new QQRecorder.RecordInitException("mRecorder.getState is not STATE_INITIALIZED, state = " + i);
      }
      this.jdField_a_of_type_AndroidMediaAudioRecord.startRecording();
      if (this.jdField_a_of_type_Bbik != null) {
        this.jdField_a_of_type_Bbik.a();
      }
      return;
    }
  }
  
  private static void b(String paramString, boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    if (new Random().nextInt(1000) == 521)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQRecorder", 2, "real do report");
      }
      axrl.a(BaseApplication.getContext()).a("", paramString, paramBoolean, 0L, 0L, paramHashMap, "");
    }
  }
  
  private static int c(int paramInt)
  {
    return a(paramInt, 2, 2);
  }
  
  private void c()
  {
    this.jdField_a_of_type_Avcv = new avcv();
    Object localObject = new WechatNsWrapper(this.jdField_a_of_type_AndroidContentContext);
    if (WechatNsWrapper.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Avcv.a((avcr)localObject);
    }
    if (this.jdField_c_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.jdField_c_of_type_Int != 0) {
        break label219;
      }
      this.jdField_a_of_type_Avcv.a(new AmrInputStreamWrapper(this.jdField_a_of_type_AndroidContentContext));
    }
    for (;;)
    {
      this.jdField_a_of_type_Avcv.a(this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.jdField_c_of_type_Int);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("mAudioType=" + this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.jdField_c_of_type_Int + ", mSampleRate=" + this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.jdField_a_of_type_Int + " ,mBitRate=" + this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.jdField_b_of_type_Int + " ,Codec=" + this.jdField_a_of_type_Avcv).append(" ,processor = ").append(" ,time is :").append(System.currentTimeMillis());
        QLog.d("QQRecorder", 2, ((StringBuilder)localObject).toString());
      }
      return;
      label219:
      this.jdField_a_of_type_Avcv.a(new SilkCodecWrapper(this.jdField_a_of_type_AndroidContentContext));
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Avcv != null)
    {
      this.jdField_a_of_type_Avcv.a();
      this.jdField_a_of_type_Avcv = null;
    }
  }
  
  public static boolean d()
  {
    return new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() > 1;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecordThread != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecordThread.a())) {}
    synchronized (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecordThread)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecordThread.jdField_b_of_type_Boolean = false;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 != -1)
    {
      paramInt2 = AudioRecord.getMinBufferSize(this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.jdField_a_of_type_Int, 2, 2);
      if ((paramInt2 != -2) && (paramInt2 != -1)) {
        this.jdField_b_of_type_Int = (paramInt2 * paramInt1);
      }
    }
    for (;;)
    {
      if (paramInt3 != -1) {
        this.jdField_c_of_type_Int = paramInt3;
      }
      return;
      if (paramInt2 != -1) {
        this.jdField_b_of_type_Int = paramInt2;
      }
    }
  }
  
  public void a(bbik parambbik)
  {
    this.jdField_a_of_type_Bbik = parambbik;
  }
  
  public void a(bbim parambbim)
  {
    this.jdField_a_of_type_Bbim = parambbim;
  }
  
  public void a(QQRecorder.RecorderParam paramRecorderParam)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.jdField_a_of_type_Int != paramRecorderParam.jdField_a_of_type_Int) {
      this.jdField_a_of_type_Boolean = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam = paramRecorderParam;
    ThreadManager.excute(new QQRecorder.1(this), 16, null, false);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "thread is:" + this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecordThread + ", time is:" + System.currentTimeMillis());
    }
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {}
    try
    {
      if (this.jdField_a_of_type_AndroidMediaAudioManager.isMicrophoneMute())
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQRecorder", 2, "mic is mute, set mute false.");
        }
        this.jdField_a_of_type_AndroidMediaAudioManager.setMicrophoneMute(false);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQRecorder", 2, "setMicrophoneMute error.", localException);
        }
      }
      if (!QLog.isColorLevel()) {
        break label199;
      }
      QLog.d("QQRecorder", 2, "start, RecordThread exist , notify ");
      synchronized (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecordThread)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecordThread.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecordThread.jdField_a_of_type_JavaLangString = paramString;
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecordThread.a();
        try
        {
          notifyAll();
          return;
        }
        finally {}
      }
    }
    this.jdField_c_of_type_Boolean = paramBoolean;
    jdField_b_of_type_JavaLangString = paramString;
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecordThread == null) || (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecordThread.a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQRecorder", 2, "QQRecorder.start, new RecordThread ");
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecordThread = new QQRecorder.RecordThread(this);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecordThread.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecordThread.a();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecordThread.start();
      return;
    }
  }
  
  void a(Throwable paramThrowable)
  {
    int i = 7;
    try
    {
      String str = paramThrowable.toString();
      if ((paramThrowable instanceof RuntimeException)) {
        if (str.contains("STATE_INITIALIZED")) {
          i = 2;
        }
      }
      for (;;)
      {
        paramThrowable = new HashMap();
        paramThrowable.put("exceptionType", i + "");
        paramThrowable.put("osVersion", Build.VERSION.SDK_INT + "");
        paramThrowable.put("deviceName", Build.MANUFACTURER + "_" + Build.MODEL);
        paramThrowable.put("exceptionMsg", str);
        b("actPttRecordException", false, paramThrowable);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("QQRecorder", 2, "report exception(catch exception) | exceptionType = " + i + " | exceptionMessage = " + str);
        return;
        if ((paramThrowable instanceof UnsatisfiedLinkError)) {
          if (str.contains("Native method not found"))
          {
            i = 4;
          }
          else
          {
            boolean bool = str.contains("Library not found");
            if (bool) {
              i = 5;
            } else {
              i = 6;
            }
          }
        }
      }
      return;
    }
    catch (Exception paramThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQRecorder", 2, "Report exception error.", paramThrowable);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean != paramBoolean)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecordThread != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecordThread.jdField_a_of_type_Boolean);
  }
  
  public void b(String paramString)
  {
    a(paramString, true);
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecordThread == null) || (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecordThread.jdField_a_of_type_Boolean);
  }
  
  public boolean c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "thread is:" + this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecordThread + ",time is:" + System.currentTimeMillis());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecordThread != null)
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecordThread.jdField_a_of_type_Boolean;
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecordThread.jdField_a_of_type_Boolean = false;
      return bool;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQRecorder
 * JD-Core Version:    0.7.0.1
 */