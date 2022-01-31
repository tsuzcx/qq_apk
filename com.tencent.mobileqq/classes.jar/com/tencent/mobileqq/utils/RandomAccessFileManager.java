package com.tencent.mobileqq.utils;

import bdmk;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.HashMap;
import java.util.Map;

public class RandomAccessFileManager
{
  private static RandomAccessFileManager jdField_a_of_type_ComTencentMobileqqUtilsRandomAccessFileManager = new RandomAccessFileManager();
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private Map<String, bdmk> jdField_a_of_type_JavaUtilMap = new HashMap();
  private byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private Map<String, bdmk> jdField_b_of_type_JavaUtilMap = new HashMap();
  private byte[] jdField_b_of_type_ArrayOfByte = new byte[0];
  
  private bdmk a(String paramString, Map<String, bdmk> paramMap)
  {
    paramMap = (bdmk)paramMap.get(paramString);
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
        bdmk localbdmk = paramString.jdField_a_of_type_Bdmk;
        paramString = localbdmk;
        if (localbdmk != paramMap) {
          break;
        }
        paramString = localbdmk;
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
  
  private void a(bdmk parambdmk1, bdmk parambdmk2, String paramString, Map<String, bdmk> paramMap)
  {
    if (parambdmk1 == null) {
      parambdmk1 = (bdmk)paramMap.get(paramString);
    }
    for (;;)
    {
      if ((parambdmk1 == null) || (parambdmk2 == null)) {
        return;
      }
      if (parambdmk2 == parambdmk1)
      {
        if ((parambdmk1.jdField_a_of_type_Bdmk != parambdmk1) && (parambdmk1.jdField_a_of_type_Bdmk != null)) {
          break label87;
        }
        paramMap.remove(paramString);
      }
      for (;;)
      {
        parambdmk2.jdField_b_of_type_Bdmk.jdField_a_of_type_Bdmk = parambdmk2.jdField_a_of_type_Bdmk;
        parambdmk2.jdField_a_of_type_Bdmk.jdField_b_of_type_Bdmk = parambdmk2.jdField_b_of_type_Bdmk;
        parambdmk2.jdField_a_of_type_Bdmk = null;
        parambdmk2.jdField_b_of_type_Bdmk = null;
        return;
        label87:
        paramMap.put(paramString, parambdmk1.jdField_a_of_type_Bdmk);
      }
    }
  }
  
  private void a(bdmk parambdmk, String paramString, Map<String, bdmk> paramMap)
  {
    bdmk localbdmk = (bdmk)paramMap.get(paramString);
    if (parambdmk == null) {
      return;
    }
    if (localbdmk == null)
    {
      parambdmk.jdField_b_of_type_Bdmk = parambdmk;
      parambdmk.jdField_a_of_type_Bdmk = parambdmk;
      paramMap.put(paramString, parambdmk);
      return;
    }
    parambdmk.jdField_a_of_type_Bdmk = localbdmk;
    parambdmk.jdField_b_of_type_Bdmk = localbdmk.jdField_b_of_type_Bdmk;
    localbdmk.jdField_b_of_type_Bdmk.jdField_a_of_type_Bdmk = parambdmk;
    localbdmk.jdField_b_of_type_Bdmk = parambdmk;
  }
  
  private void a(String arg1, bdmk parambdmk)
  {
    parambdmk.jdField_b_of_type_Long = System.currentTimeMillis();
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      a(parambdmk, ???, this.jdField_b_of_type_JavaUtilMap);
    }
    synchronized (this.jdField_b_of_type_ArrayOfByte)
    {
      if (this.jdField_a_of_type_JavaLangRunnable == null)
      {
        this.jdField_a_of_type_JavaLangRunnable = new RandomAccessFileManager.CloseThread(this);
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
    //   5: getfield 25	com/tencent/mobileqq/utils/RandomAccessFileManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   8: invokespecial 104	com/tencent/mobileqq/utils/RandomAccessFileManager:a	(Ljava/lang/String;Ljava/util/Map;)Lbdmk;
    //   11: astore_3
    //   12: aload_3
    //   13: astore_2
    //   14: aload_3
    //   15: ifnonnull +55 -> 70
    //   18: aload_0
    //   19: getfield 29	com/tencent/mobileqq/utils/RandomAccessFileManager:jdField_a_of_type_ArrayOfByte	[B
    //   22: astore_2
    //   23: aload_2
    //   24: monitorenter
    //   25: aload_0
    //   26: aload_1
    //   27: aload_0
    //   28: getfield 27	com/tencent/mobileqq/utils/RandomAccessFileManager:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   31: invokespecial 104	com/tencent/mobileqq/utils/RandomAccessFileManager:a	(Ljava/lang/String;Ljava/util/Map;)Lbdmk;
    //   34: astore_3
    //   35: aload_3
    //   36: ifnull +14 -> 50
    //   39: aload_0
    //   40: aconst_null
    //   41: aload_3
    //   42: aload_1
    //   43: aload_0
    //   44: getfield 27	com/tencent/mobileqq/utils/RandomAccessFileManager:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   47: invokespecial 79	com/tencent/mobileqq/utils/RandomAccessFileManager:a	(Lbdmk;Lbdmk;Ljava/lang/String;Ljava/util/Map;)V
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
    //   62: getfield 25	com/tencent/mobileqq/utils/RandomAccessFileManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   65: invokespecial 89	com/tencent/mobileqq/utils/RandomAccessFileManager:a	(Lbdmk;Ljava/lang/String;Ljava/util/Map;)V
    //   68: aload_3
    //   69: astore_2
    //   70: aload_2
    //   71: astore_3
    //   72: aload_2
    //   73: ifnonnull +85 -> 158
    //   76: new 40	bdmk
    //   79: dup
    //   80: aload_0
    //   81: invokespecial 105	bdmk:<init>	(Lcom/tencent/mobileqq/utils/RandomAccessFileManager;)V
    //   84: astore_3
    //   85: aload_3
    //   86: new 107	java/io/RandomAccessFile
    //   89: dup
    //   90: aload_1
    //   91: ldc 109
    //   93: invokespecial 112	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: putfield 115	bdmk:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   99: aload_3
    //   100: invokestatic 49	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   103: invokevirtual 53	java/lang/Thread:getId	()J
    //   106: putfield 43	bdmk:jdField_a_of_type_Long	J
    //   109: invokestatic 121	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   112: ifeq +36 -> 148
    //   115: ldc 123
    //   117: iconst_2
    //   118: invokestatic 128	aepi:a	()Ljava/lang/StringBuilder;
    //   121: ldc 130
    //   123: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload_1
    //   127: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: ldc 138
    //   132: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload_3
    //   136: getfield 43	bdmk:jdField_a_of_type_Long	J
    //   139: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   142: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokestatic 149	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   148: aload_0
    //   149: aload_3
    //   150: aload_1
    //   151: aload_0
    //   152: getfield 25	com/tencent/mobileqq/utils/RandomAccessFileManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   155: invokespecial 89	com/tencent/mobileqq/utils/RandomAccessFileManager:a	(Lbdmk;Ljava/lang/String;Ljava/util/Map;)V
    //   158: aload_3
    //   159: aload_3
    //   160: getfield 152	bdmk:jdField_a_of_type_Int	I
    //   163: iconst_1
    //   164: iadd
    //   165: putfield 152	bdmk:jdField_a_of_type_Int	I
    //   168: aload_3
    //   169: getfield 115	bdmk:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
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
      bdmk localbdmk = a(paramString, this.jdField_a_of_type_JavaUtilMap);
      if (localbdmk != null)
      {
        localbdmk.jdField_a_of_type_Int -= 1;
        if (localbdmk.jdField_a_of_type_Int == 0)
        {
          a(null, localbdmk, paramString, this.jdField_a_of_type_JavaUtilMap);
          a(paramString, localbdmk);
        }
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.RandomAccessFileManager
 * JD-Core Version:    0.7.0.1
 */