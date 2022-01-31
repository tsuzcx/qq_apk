package com.tencent.mobileqq.utils;

import ajrp;
import ajrq;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.HashMap;
import java.util.Map;

public class RandomAccessFileManager
{
  private static RandomAccessFileManager jdField_a_of_type_ComTencentMobileqqUtilsRandomAccessFileManager = new RandomAccessFileManager();
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  private byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private Map jdField_b_of_type_JavaUtilMap = new HashMap();
  private byte[] jdField_b_of_type_ArrayOfByte = new byte[0];
  
  private ajrq a(String paramString, Map paramMap)
  {
    paramMap = (ajrq)paramMap.get(paramString);
    int i;
    if (paramMap != null)
    {
      paramString = paramMap;
      if (paramString.jdField_a_of_type_Long == Thread.currentThread().getId()) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        return paramString;
        ajrq localajrq = paramString.jdField_a_of_type_Ajrq;
        paramString = localajrq;
        if (localajrq != paramMap) {
          break;
        }
        paramString = localajrq;
        i = 0;
        continue;
      }
      return null;
      i = 0;
      paramString = paramMap;
    }
  }
  
  public static RandomAccessFileManager a()
  {
    try
    {
      RandomAccessFileManager localRandomAccessFileManager = jdField_a_of_type_ComTencentMobileqqUtilsRandomAccessFileManager;
      return localRandomAccessFileManager;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void a(ajrq paramajrq1, ajrq paramajrq2, String paramString, Map paramMap)
  {
    if (paramajrq1 == null) {
      paramajrq1 = (ajrq)paramMap.get(paramString);
    }
    for (;;)
    {
      if ((paramajrq1 == null) || (paramajrq2 == null)) {
        return;
      }
      if (paramajrq2 == paramajrq1)
      {
        if ((paramajrq1.jdField_a_of_type_Ajrq != paramajrq1) && (paramajrq1.jdField_a_of_type_Ajrq != null)) {
          break label87;
        }
        paramMap.remove(paramString);
      }
      for (;;)
      {
        paramajrq2.jdField_b_of_type_Ajrq.jdField_a_of_type_Ajrq = paramajrq2.jdField_a_of_type_Ajrq;
        paramajrq2.jdField_a_of_type_Ajrq.jdField_b_of_type_Ajrq = paramajrq2.jdField_b_of_type_Ajrq;
        paramajrq2.jdField_a_of_type_Ajrq = null;
        paramajrq2.jdField_b_of_type_Ajrq = null;
        return;
        label87:
        paramMap.put(paramString, paramajrq1.jdField_a_of_type_Ajrq);
      }
    }
  }
  
  private void a(ajrq paramajrq, String paramString, Map paramMap)
  {
    ajrq localajrq = (ajrq)paramMap.get(paramString);
    if (paramajrq == null) {
      return;
    }
    if (localajrq == null)
    {
      paramajrq.jdField_b_of_type_Ajrq = paramajrq;
      paramajrq.jdField_a_of_type_Ajrq = paramajrq;
      paramMap.put(paramString, paramajrq);
      return;
    }
    paramajrq.jdField_a_of_type_Ajrq = localajrq;
    paramajrq.jdField_b_of_type_Ajrq = localajrq.jdField_b_of_type_Ajrq;
    localajrq.jdField_b_of_type_Ajrq.jdField_a_of_type_Ajrq = paramajrq;
    localajrq.jdField_b_of_type_Ajrq = paramajrq;
  }
  
  private void a(String arg1, ajrq paramajrq)
  {
    paramajrq.jdField_b_of_type_Long = System.currentTimeMillis();
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      a(paramajrq, ???, this.jdField_b_of_type_JavaUtilMap);
    }
    synchronized (this.jdField_b_of_type_ArrayOfByte)
    {
      if (this.jdField_a_of_type_JavaLangRunnable == null)
      {
        this.jdField_a_of_type_JavaLangRunnable = new ajrp(this);
        ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 8, null, false);
      }
      return;
      ??? = finally;
      throw ???;
    }
  }
  
  /* Error */
  public java.io.RandomAccessFile a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: aload_0
    //   5: getfield 24	com/tencent/mobileqq/utils/RandomAccessFileManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   8: invokespecial 99	com/tencent/mobileqq/utils/RandomAccessFileManager:a	(Ljava/lang/String;Ljava/util/Map;)Lajrq;
    //   11: astore_3
    //   12: aload_3
    //   13: astore_2
    //   14: aload_3
    //   15: ifnonnull +55 -> 70
    //   18: aload_0
    //   19: getfield 28	com/tencent/mobileqq/utils/RandomAccessFileManager:jdField_a_of_type_ArrayOfByte	[B
    //   22: astore_2
    //   23: aload_2
    //   24: monitorenter
    //   25: aload_0
    //   26: aload_1
    //   27: aload_0
    //   28: getfield 26	com/tencent/mobileqq/utils/RandomAccessFileManager:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   31: invokespecial 99	com/tencent/mobileqq/utils/RandomAccessFileManager:a	(Ljava/lang/String;Ljava/util/Map;)Lajrq;
    //   34: astore_3
    //   35: aload_3
    //   36: ifnull +14 -> 50
    //   39: aload_0
    //   40: aconst_null
    //   41: aload_3
    //   42: aload_1
    //   43: aload_0
    //   44: getfield 26	com/tencent/mobileqq/utils/RandomAccessFileManager:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   47: invokespecial 74	com/tencent/mobileqq/utils/RandomAccessFileManager:a	(Lajrq;Lajrq;Ljava/lang/String;Ljava/util/Map;)V
    //   50: aload_2
    //   51: monitorexit
    //   52: aload_3
    //   53: astore_2
    //   54: aload_3
    //   55: ifnull +15 -> 70
    //   58: aload_0
    //   59: aload_3
    //   60: aload_1
    //   61: aload_0
    //   62: getfield 24	com/tencent/mobileqq/utils/RandomAccessFileManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   65: invokespecial 84	com/tencent/mobileqq/utils/RandomAccessFileManager:a	(Lajrq;Ljava/lang/String;Ljava/util/Map;)V
    //   68: aload_3
    //   69: astore_2
    //   70: aload_2
    //   71: astore_3
    //   72: aload_2
    //   73: ifnonnull +85 -> 158
    //   76: new 39	ajrq
    //   79: dup
    //   80: aload_0
    //   81: invokespecial 100	ajrq:<init>	(Lcom/tencent/mobileqq/utils/RandomAccessFileManager;)V
    //   84: astore_3
    //   85: aload_3
    //   86: new 102	java/io/RandomAccessFile
    //   89: dup
    //   90: aload_1
    //   91: ldc 104
    //   93: invokespecial 107	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: putfield 110	ajrq:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   99: aload_3
    //   100: invokestatic 48	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   103: invokevirtual 52	java/lang/Thread:getId	()J
    //   106: putfield 42	ajrq:jdField_a_of_type_Long	J
    //   109: invokestatic 116	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   112: ifeq +36 -> 148
    //   115: ldc 118
    //   117: iconst_2
    //   118: invokestatic 123	com/tencent/mobileqq/activity/aio/AIOUtils:a	()Ljava/lang/StringBuilder;
    //   121: ldc 125
    //   123: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload_1
    //   127: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: ldc 133
    //   132: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload_3
    //   136: getfield 42	ajrq:jdField_a_of_type_Long	J
    //   139: invokevirtual 136	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   142: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokestatic 144	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   148: aload_0
    //   149: aload_3
    //   150: aload_1
    //   151: aload_0
    //   152: getfield 24	com/tencent/mobileqq/utils/RandomAccessFileManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   155: invokespecial 84	com/tencent/mobileqq/utils/RandomAccessFileManager:a	(Lajrq;Ljava/lang/String;Ljava/util/Map;)V
    //   158: aload_3
    //   159: aload_3
    //   160: getfield 147	ajrq:jdField_a_of_type_Int	I
    //   163: iconst_1
    //   164: iadd
    //   165: putfield 147	ajrq:jdField_a_of_type_Int	I
    //   168: aload_3
    //   169: getfield 110	ajrq:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   172: astore_1
    //   173: aload_0
    //   174: monitorexit
    //   175: aload_1
    //   176: areturn
    //   177: astore_1
    //   178: aload_2
    //   179: monitorexit
    //   180: aload_1
    //   181: athrow
    //   182: astore_1
    //   183: aload_0
    //   184: monitorexit
    //   185: aload_1
    //   186: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	187	0	this	RandomAccessFileManager
    //   0	187	1	paramString	String
    //   11	158	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   25	35	177	finally
    //   39	50	177	finally
    //   50	52	177	finally
    //   178	180	177	finally
    //   2	12	182	finally
    //   18	25	182	finally
    //   58	68	182	finally
    //   76	148	182	finally
    //   148	158	182	finally
    //   158	173	182	finally
    //   180	182	182	finally
  }
  
  public void a(String paramString)
  {
    try
    {
      ajrq localajrq = a(paramString, this.jdField_a_of_type_JavaUtilMap);
      if (localajrq != null)
      {
        localajrq.jdField_a_of_type_Int -= 1;
        if (localajrq.jdField_a_of_type_Int == 0)
        {
          a(null, localajrq, paramString, this.jdField_a_of_type_JavaUtilMap);
          a(paramString, localajrq);
        }
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.RandomAccessFileManager
 * JD-Core Version:    0.7.0.1
 */