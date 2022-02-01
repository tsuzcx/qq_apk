package com.tencent.mobileqq.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public abstract class RecordParams
{
  public static final int a;
  private static RecordParams.RecorderParam jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam;
  private static boolean jdField_a_of_type_Boolean;
  public static final int b;
  private static RecordParams.RecorderParam b;
  
  static
  {
    jdField_a_of_type_Int = QQAudioUtils.a[0];
    jdField_b_of_type_Int = QQAudioUtils.a[2];
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam = new RecordParams.RecorderParam(jdField_b_of_type_Int, 16000, 1);
    jdField_b_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam = new RecordParams.RecorderParam(jdField_b_of_type_Int, 16000, 1);
  }
  
  public static byte a(int paramInt)
  {
    int j;
    for (int i = 0; i < QQAudioUtils.a.length; j = (byte)(i + 1)) {
      if (paramInt == QQAudioUtils.a[i]) {
        return i;
      }
    }
    return -1;
  }
  
  public static int a()
  {
    return a().length;
  }
  
  /* Error */
  public static int a(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore_3
    //   5: iconst_0
    //   6: istore_2
    //   7: iconst_0
    //   8: istore 5
    //   10: iconst_0
    //   11: istore_1
    //   12: aconst_null
    //   13: astore 8
    //   15: aconst_null
    //   16: astore 7
    //   18: aconst_null
    //   19: astore 9
    //   21: new 45	java/io/FileInputStream
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 48	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   29: astore_0
    //   30: new 50	java/io/DataInputStream
    //   33: dup
    //   34: aload_0
    //   35: invokespecial 53	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   38: astore 6
    //   40: iload_3
    //   41: istore_2
    //   42: bipush 10
    //   44: newarray byte
    //   46: astore 8
    //   48: iload_3
    //   49: istore_2
    //   50: aload 6
    //   52: aload 8
    //   54: invokevirtual 57	java/io/DataInputStream:read	([B)I
    //   57: aload 8
    //   59: arraylength
    //   60: if_icmpne +37 -> 97
    //   63: iload_3
    //   64: istore_2
    //   65: aload 8
    //   67: invokestatic 60	com/tencent/mobileqq/qqaudio/QQAudioUtils:a	([B)Z
    //   70: ifeq +5 -> 75
    //   73: iconst_1
    //   74: istore_1
    //   75: iload_1
    //   76: istore_2
    //   77: aload 6
    //   79: invokevirtual 63	java/io/DataInputStream:close	()V
    //   82: iload_1
    //   83: istore_2
    //   84: aload_0
    //   85: invokevirtual 64	java/io/FileInputStream:close	()V
    //   88: aconst_null
    //   89: astore 6
    //   91: aload 9
    //   93: astore_0
    //   94: goto +6 -> 100
    //   97: iload 4
    //   99: istore_1
    //   100: aload_0
    //   101: ifnull +7 -> 108
    //   104: aload_0
    //   105: invokevirtual 64	java/io/FileInputStream:close	()V
    //   108: aload 6
    //   110: ifnull +8 -> 118
    //   113: aload 6
    //   115: invokevirtual 63	java/io/DataInputStream:close	()V
    //   118: iload_1
    //   119: ireturn
    //   120: astore 8
    //   122: aload_0
    //   123: astore 7
    //   125: aload 8
    //   127: astore_0
    //   128: goto +104 -> 232
    //   131: astore 8
    //   133: aload 6
    //   135: astore 7
    //   137: aload 8
    //   139: astore 6
    //   141: goto +23 -> 164
    //   144: astore 8
    //   146: aload 7
    //   148: astore 6
    //   150: aload_0
    //   151: astore 7
    //   153: aload 8
    //   155: astore_0
    //   156: goto +76 -> 232
    //   159: astore 6
    //   161: aconst_null
    //   162: astore 7
    //   164: aload_0
    //   165: astore 8
    //   167: aload 7
    //   169: astore_0
    //   170: goto +25 -> 195
    //   173: astore_0
    //   174: aconst_null
    //   175: astore 8
    //   177: aload 7
    //   179: astore 6
    //   181: aload 8
    //   183: astore 7
    //   185: goto +47 -> 232
    //   188: astore 6
    //   190: aconst_null
    //   191: astore_0
    //   192: iload 5
    //   194: istore_2
    //   195: aload 6
    //   197: invokevirtual 67	java/lang/Exception:printStackTrace	()V
    //   200: aload 8
    //   202: ifnull +8 -> 210
    //   205: aload 8
    //   207: invokevirtual 64	java/io/FileInputStream:close	()V
    //   210: aload_0
    //   211: ifnull +7 -> 218
    //   214: aload_0
    //   215: invokevirtual 63	java/io/DataInputStream:close	()V
    //   218: iload_2
    //   219: ireturn
    //   220: astore 9
    //   222: aload 8
    //   224: astore 7
    //   226: aload_0
    //   227: astore 6
    //   229: aload 9
    //   231: astore_0
    //   232: aload 7
    //   234: ifnull +8 -> 242
    //   237: aload 7
    //   239: invokevirtual 64	java/io/FileInputStream:close	()V
    //   242: aload 6
    //   244: ifnull +8 -> 252
    //   247: aload 6
    //   249: invokevirtual 63	java/io/DataInputStream:close	()V
    //   252: aload_0
    //   253: athrow
    //   254: astore_0
    //   255: iload_1
    //   256: ireturn
    //   257: astore_0
    //   258: iload_2
    //   259: ireturn
    //   260: astore 6
    //   262: goto -10 -> 252
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	265	0	paramString	String
    //   11	245	1	i	int
    //   6	253	2	j	int
    //   4	60	3	k	int
    //   1	97	4	m	int
    //   8	185	5	n	int
    //   38	111	6	localObject1	Object
    //   159	1	6	localException1	Exception
    //   179	1	6	localObject2	Object
    //   188	8	6	localException2	Exception
    //   227	21	6	str1	String
    //   260	1	6	localException3	Exception
    //   16	222	7	localObject3	Object
    //   13	53	8	arrayOfByte	byte[]
    //   120	6	8	localObject4	Object
    //   131	7	8	localException4	Exception
    //   144	10	8	localObject5	Object
    //   165	58	8	str2	String
    //   19	73	9	localObject6	Object
    //   220	10	9	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   42	48	120	finally
    //   50	63	120	finally
    //   65	73	120	finally
    //   77	82	120	finally
    //   42	48	131	java/lang/Exception
    //   50	63	131	java/lang/Exception
    //   65	73	131	java/lang/Exception
    //   77	82	131	java/lang/Exception
    //   30	40	144	finally
    //   84	88	144	finally
    //   30	40	159	java/lang/Exception
    //   84	88	159	java/lang/Exception
    //   21	30	173	finally
    //   21	30	188	java/lang/Exception
    //   195	200	220	finally
    //   104	108	254	java/lang/Exception
    //   113	118	254	java/lang/Exception
    //   205	210	257	java/lang/Exception
    //   214	218	257	java/lang/Exception
    //   237	242	260	java/lang/Exception
    //   247	252	260	java/lang/Exception
  }
  
  public static RecordParams.RecorderParam a(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    a(paramAppRuntime, false);
    if (paramBoolean) {
      paramAppRuntime = jdField_b_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam;
    } else {
      paramAppRuntime = jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam;
    }
    return new RecordParams.RecorderParam(paramAppRuntime.jdField_a_of_type_Int, paramAppRuntime.jdField_b_of_type_Int, paramAppRuntime.c);
  }
  
  private static String a(AppRuntime paramAppRuntime)
  {
    Object localObject = BaseApplication.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RecordParams_");
    localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
    paramAppRuntime = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).getString("SilkCfg", null);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getSavedSilkCfg: ");
      ((StringBuilder)localObject).append(paramAppRuntime);
      QLog.d("RecordParams", 2, ((StringBuilder)localObject).toString());
    }
    return paramAppRuntime;
  }
  
  public static void a()
  {
    jdField_a_of_type_Boolean = false;
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString)
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RecordParams_");
    localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
    localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).edit().putString("SilkCfg", paramString).commit();
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append(" ");
      paramAppRuntime.append(paramString);
      QLog.d("RecordParams", 2, paramAppRuntime.toString());
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    if ((jdField_a_of_type_Boolean) && (!paramBoolean)) {
      return;
    }
    jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("RecordParams", 2, "init: false");
    }
    try
    {
      paramAppRuntime = a(paramAppRuntime);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("init from sp:");
        localStringBuilder.append(paramAppRuntime);
        QLog.d("RecordParams", 2, localStringBuilder.toString());
      }
      if ((paramAppRuntime != null) && (paramAppRuntime.length() != 0))
      {
        paramAppRuntime = paramAppRuntime.split("\\|");
        if ((paramAppRuntime != null) && (paramAppRuntime.length >= 3))
        {
          int i = Integer.valueOf(paramAppRuntime[0]).intValue();
          int j = Integer.valueOf(paramAppRuntime[1]).intValue();
          int k = Integer.valueOf(paramAppRuntime[2]).intValue();
          jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam = new RecordParams.RecorderParam(QQAudioUtils.a[j], k, i);
          if (paramAppRuntime.length >= 6)
          {
            i = Integer.valueOf(paramAppRuntime[3]).intValue();
            j = Integer.valueOf(paramAppRuntime[4]).intValue();
            k = Integer.valueOf(paramAppRuntime[5]).intValue();
            jdField_b_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam = new RecordParams.RecorderParam(QQAudioUtils.a[j], k, i);
          }
        }
      }
    }
    catch (Exception paramAppRuntime)
    {
      label217:
      break label217;
    }
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("init params: ");
      paramAppRuntime.append(jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam.c);
      paramAppRuntime.append("-");
      paramAppRuntime.append(jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam.jdField_a_of_type_Int);
      paramAppRuntime.append("-");
      paramAppRuntime.append(jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam.jdField_b_of_type_Int);
      QLog.d("RecordParams", 2, paramAppRuntime.toString());
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("init changer params: ");
      paramAppRuntime.append(jdField_b_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam.c);
      paramAppRuntime.append("-");
      paramAppRuntime.append(jdField_b_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam.jdField_a_of_type_Int);
      paramAppRuntime.append("-");
      paramAppRuntime.append(jdField_b_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam.jdField_b_of_type_Int);
      QLog.d("RecordParams", 2, paramAppRuntime.toString());
    }
  }
  
  public static byte[] a()
  {
    return a(0, jdField_a_of_type_Int);
  }
  
  public static byte[] a(int paramInt)
  {
    byte[] arrayOfByte = new byte[10];
    arrayOfByte[0] = a(paramInt);
    System.arraycopy("#!SILK_V3".getBytes(), 0, arrayOfByte, 1, 9);
    return arrayOfByte;
  }
  
  public static byte[] a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      return a(paramInt2);
    }
    return "#!AMR\n".getBytes();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.RecordParams
 * JD-Core Version:    0.7.0.1
 */