package com.tencent.mobileqq.utils;

import com.tencent.qphone.base.util.QLog;
import com.wx.voice.vad.Utils;
import com.wx.voice.vad.WXVad;
import com.wx.voice.vad.WXVadData;
import com.wx.voice.vad.WXVadParam;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class VadHelper
{
  private WXVad jdField_a_of_type_ComWxVoiceVadWXVad;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean();
  public boolean a;
  
  static
  {
    System.loadLibrary("wx-asr-vad");
  }
  
  public VadHelper()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  private WXVadParam a()
  {
    WXVadParam localWXVadParam = new WXVadParam();
    localWXVadParam.mode = 0;
    localWXVadParam.sample_rate = 16000;
    localWXVadParam.opt_spk_time = 3000;
    localWXVadParam.online_begin_win = 300;
    localWXVadParam.online_begin_confirm_time = 225;
    localWXVadParam.online_sil_timeout = 10;
    localWXVadParam.online_energy_thresh = 10.0F;
    localWXVadParam.online_cross_zero_thresh = 0.01F;
    localWXVadParam.online_max_spk_time = 30000;
    localWXVadParam.online_begin_padding_ms = 150;
    localWXVadParam.online_rtcmode = 3;
    localWXVadParam.online_output_data_size = 3200;
    localWXVadParam.online_end_sil_decrease_slope = -0.01F;
    return localWXVadParam;
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2);
    }
  }
  
  private WXVadParam b()
  {
    WXVadParam localWXVadParam = new WXVadParam();
    localWXVadParam.mode = 1;
    localWXVadParam.sample_rate = 16000;
    localWXVadParam.opt_spk_time = 3000;
    localWXVadParam.offline_min_spk_time = 80;
    localWXVadParam.offline_max_spk_time = 50000;
    localWXVadParam.offline_min_nspk_time = 50;
    localWXVadParam.offline_min_process_time = 10000;
    localWXVadParam.offline_remove_sil = true;
    localWXVadParam.offline_padding_btime = 100;
    localWXVadParam.offline_padding_etime = 150;
    localWXVadParam.offline_min_sil_time = 600;
    localWXVadParam.offline_rtcmode = 3;
    return localWXVadParam;
  }
  
  public WXVadData a(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      a("VadHelper", "vadOnlineProcess isError ");
      return null;
    }
    short[] arrayOfShort = Utils.toShortArray(paramArrayOfByte);
    return this.jdField_a_of_type_ComWxVoiceVadWXVad.OnlineProcess(arrayOfShort, paramArrayOfByte.length / 2, 0);
  }
  
  /* Error */
  public java.util.List<com.wx.voice.vad.WXVadSeg> a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 27	com/tencent/mobileqq/utils/VadHelper:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   4: invokevirtual 144	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   7: ifne +252 -> 259
    //   10: aload_0
    //   11: getfield 29	com/tencent/mobileqq/utils/VadHelper:jdField_a_of_type_Boolean	Z
    //   14: ifeq +5 -> 19
    //   17: aconst_null
    //   18: areturn
    //   19: aload_0
    //   20: getfield 27	com/tencent/mobileqq/utils/VadHelper:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   23: iconst_1
    //   24: invokevirtual 148	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   27: new 150	java/util/ArrayList
    //   30: dup
    //   31: invokespecial 151	java/util/ArrayList:<init>	()V
    //   34: astore 8
    //   36: new 153	java/io/File
    //   39: dup
    //   40: aload_1
    //   41: invokespecial 155	java/io/File:<init>	(Ljava/lang/String;)V
    //   44: astore 7
    //   46: new 157	java/io/FileInputStream
    //   49: dup
    //   50: aload 7
    //   52: invokespecial 160	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   55: astore 6
    //   57: aload 6
    //   59: astore_1
    //   60: aload 7
    //   62: invokevirtual 164	java/io/File:length	()J
    //   65: lstore_2
    //   66: iconst_0
    //   67: i2l
    //   68: lstore 4
    //   70: aload 6
    //   72: astore_1
    //   73: aload 6
    //   75: lload 4
    //   77: invokevirtual 168	java/io/FileInputStream:skip	(J)J
    //   80: pop2
    //   81: aload 6
    //   83: astore_1
    //   84: lload_2
    //   85: lload 4
    //   87: lsub
    //   88: l2i
    //   89: newarray byte
    //   91: astore 7
    //   93: aload 6
    //   95: astore_1
    //   96: aload 6
    //   98: aload 7
    //   100: invokevirtual 172	java/io/FileInputStream:read	([B)I
    //   103: pop
    //   104: aload 6
    //   106: astore_1
    //   107: aload 7
    //   109: invokestatic 130	com/wx/voice/vad/Utils:toShortArray	([B)[S
    //   112: astore 7
    //   114: aload 6
    //   116: astore_1
    //   117: aload_0
    //   118: getfield 132	com/tencent/mobileqq/utils/VadHelper:jdField_a_of_type_ComWxVoiceVadWXVad	Lcom/wx/voice/vad/WXVad;
    //   121: aload 7
    //   123: aload 7
    //   125: arraylength
    //   126: i2l
    //   127: invokevirtual 176	com/wx/voice/vad/WXVad:OfflineProcess	([SJ)Lcom/wx/voice/vad/WXVadData;
    //   130: astore 7
    //   132: aload 6
    //   134: astore_1
    //   135: aload 7
    //   137: getfield 181	com/wx/voice/vad/WXVadData:RET_STATE	I
    //   140: iconst_1
    //   141: if_icmpeq +19 -> 160
    //   144: aload 6
    //   146: astore_1
    //   147: aload 8
    //   149: aload 7
    //   151: getfield 185	com/wx/voice/vad/WXVadData:offline_odata	Ljava/util/ArrayList;
    //   154: invokeinterface 191 2 0
    //   159: pop
    //   160: aload 6
    //   162: astore_1
    //   163: aload_0
    //   164: getfield 132	com/tencent/mobileqq/utils/VadHelper:jdField_a_of_type_ComWxVoiceVadWXVad	Lcom/wx/voice/vad/WXVad;
    //   167: invokevirtual 195	com/wx/voice/vad/WXVad:Reset	()I
    //   170: pop
    //   171: aload 6
    //   173: astore_1
    //   174: aload_0
    //   175: getfield 27	com/tencent/mobileqq/utils/VadHelper:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   178: iconst_0
    //   179: invokevirtual 148	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   182: aload 6
    //   184: invokevirtual 198	java/io/FileInputStream:close	()V
    //   187: aload 8
    //   189: areturn
    //   190: astore 7
    //   192: goto +15 -> 207
    //   195: astore 6
    //   197: aconst_null
    //   198: astore_1
    //   199: goto +45 -> 244
    //   202: astore 7
    //   204: aconst_null
    //   205: astore 6
    //   207: aload 6
    //   209: astore_1
    //   210: aload 7
    //   212: invokevirtual 201	java/lang/Exception:printStackTrace	()V
    //   215: aload 6
    //   217: astore_1
    //   218: aload_0
    //   219: getfield 27	com/tencent/mobileqq/utils/VadHelper:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   222: iconst_0
    //   223: invokevirtual 148	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   226: aload 6
    //   228: invokevirtual 198	java/io/FileInputStream:close	()V
    //   231: aload 8
    //   233: areturn
    //   234: astore_1
    //   235: aload_1
    //   236: invokevirtual 201	java/lang/Exception:printStackTrace	()V
    //   239: aload 8
    //   241: areturn
    //   242: astore 6
    //   244: aload_1
    //   245: invokevirtual 198	java/io/FileInputStream:close	()V
    //   248: goto +8 -> 256
    //   251: astore_1
    //   252: aload_1
    //   253: invokevirtual 201	java/lang/Exception:printStackTrace	()V
    //   256: aload 6
    //   258: athrow
    //   259: aconst_null
    //   260: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	this	VadHelper
    //   0	261	1	paramString	String
    //   65	20	2	l1	long
    //   68	18	4	l2	long
    //   55	128	6	localFileInputStream	java.io.FileInputStream
    //   195	1	6	localObject1	Object
    //   205	22	6	localObject2	Object
    //   242	15	6	localObject3	Object
    //   44	106	7	localObject4	Object
    //   190	1	7	localException1	java.lang.Exception
    //   202	9	7	localException2	java.lang.Exception
    //   34	206	8	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   60	66	190	java/lang/Exception
    //   73	81	190	java/lang/Exception
    //   84	93	190	java/lang/Exception
    //   96	104	190	java/lang/Exception
    //   107	114	190	java/lang/Exception
    //   117	132	190	java/lang/Exception
    //   135	144	190	java/lang/Exception
    //   147	160	190	java/lang/Exception
    //   163	171	190	java/lang/Exception
    //   174	182	190	java/lang/Exception
    //   46	57	195	finally
    //   46	57	202	java/lang/Exception
    //   182	187	234	java/lang/Exception
    //   226	231	234	java/lang/Exception
    //   60	66	242	finally
    //   73	81	242	finally
    //   84	93	242	finally
    //   96	104	242	finally
    //   107	114	242	finally
    //   117	132	242	finally
    //   135	144	242	finally
    //   147	160	242	finally
    //   163	171	242	finally
    //   174	182	242	finally
    //   210	215	242	finally
    //   218	226	242	finally
    //   244	248	251	java/lang/Exception
  }
  
  public void a()
  {
    WXVad localWXVad = this.jdField_a_of_type_ComWxVoiceVadWXVad;
    if (localWXVad != null) {
      localWXVad.Reset();
    }
  }
  
  public boolean a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    boolean bool3 = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
    boolean bool2 = true;
    boolean bool1 = true;
    if ((!bool3) && (paramArrayOfByte != null) && (paramArrayOfByte.length >= 1))
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      paramArrayOfByte = Utils.toShortArray(paramArrayOfByte);
      StringBuilder localStringBuilder;
      if (paramBoolean)
      {
        paramArrayOfByte = this.jdField_a_of_type_ComWxVoiceVadWXVad.OnlineProcess(paramArrayOfByte, paramArrayOfByte.length, 0);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("vadSession online RET_STATE:");
        localStringBuilder.append(paramArrayOfByte.RET_STATE);
        a("VadHelper", localStringBuilder.toString());
        if (paramArrayOfByte.RET_STATE != 2) {
          paramBoolean = bool2;
        } else {
          paramBoolean = false;
        }
      }
      else
      {
        paramArrayOfByte = this.jdField_a_of_type_ComWxVoiceVadWXVad.OfflineProcess(paramArrayOfByte, paramArrayOfByte.length);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("vadSession offline RET_STATE:");
        localStringBuilder.append(paramArrayOfByte.RET_STATE);
        a("VadHelper", localStringBuilder.toString());
        paramBoolean = bool1;
        if (paramArrayOfByte.RET_STATE != 1) {
          paramBoolean = paramArrayOfByte.offline_odata.isEmpty();
        }
        a();
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      return paramBoolean;
    }
    a("VadHelper", "vadSession, input empty, skipped");
    return true;
  }
  
  public void b()
  {
    WXVad localWXVad = this.jdField_a_of_type_ComWxVoiceVadWXVad;
    if (localWXVad != null) {
      localWXVad.Release();
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComWxVoiceVadWXVad = new WXVad();
    this.jdField_a_of_type_Boolean = false;
    if (1 == this.jdField_a_of_type_ComWxVoiceVadWXVad.Init(a()))
    {
      this.jdField_a_of_type_Boolean = true;
      a("VadHelper", "WXVad Error reading configure");
    }
    else
    {
      a("VadHelper", "WXVad Success init");
    }
    WXVadData localWXVadData = this.jdField_a_of_type_ComWxVoiceVadWXVad.GetOnlineProcessDataSize();
    if (1 == localWXVadData.RET_STATE)
    {
      this.jdField_a_of_type_Boolean = true;
      a("VadHelper", "WXVad Error reading blocksize");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WXVad success get blocksize ：");
    localStringBuilder.append(localWXVadData.blocksize);
    a("VadHelper", localStringBuilder.toString());
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComWxVoiceVadWXVad = new WXVad();
    if (1 == this.jdField_a_of_type_ComWxVoiceVadWXVad.Init(b()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VadHelper", 2, "WXVad Error reading configure");
      }
      return;
    }
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VadHelper
 * JD-Core Version:    0.7.0.1
 */