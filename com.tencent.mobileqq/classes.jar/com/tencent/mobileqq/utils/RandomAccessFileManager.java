package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.app.ThreadManager;
import java.util.HashMap;
import java.util.Map;

public class RandomAccessFileManager
{
  private static RandomAccessFileManager jdField_a_of_type_ComTencentMobileqqUtilsRandomAccessFileManager = new RandomAccessFileManager();
  private Runnable jdField_a_of_type_JavaLangRunnable = null;
  private Map<String, RandomAccessFileManager.FileEntry> jdField_a_of_type_JavaUtilMap = new HashMap();
  private byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private Map<String, RandomAccessFileManager.FileEntry> jdField_b_of_type_JavaUtilMap = new HashMap();
  private byte[] jdField_b_of_type_ArrayOfByte = new byte[0];
  
  private RandomAccessFileManager.FileEntry a(String paramString, Map<String, RandomAccessFileManager.FileEntry> paramMap)
  {
    paramMap = (RandomAccessFileManager.FileEntry)paramMap.get(paramString);
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
        RandomAccessFileManager.FileEntry localFileEntry = paramString.jdField_a_of_type_ComTencentMobileqqUtilsRandomAccessFileManager$FileEntry;
        paramString = localFileEntry;
        if (localFileEntry != paramMap) {
          break;
        }
        paramString = localFileEntry;
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
  
  private void a(RandomAccessFileManager.FileEntry paramFileEntry1, RandomAccessFileManager.FileEntry paramFileEntry2, String paramString, Map<String, RandomAccessFileManager.FileEntry> paramMap)
  {
    if (paramFileEntry1 == null) {
      paramFileEntry1 = (RandomAccessFileManager.FileEntry)paramMap.get(paramString);
    }
    for (;;)
    {
      if ((paramFileEntry1 == null) || (paramFileEntry2 == null)) {
        return;
      }
      if (paramFileEntry2 == paramFileEntry1)
      {
        if ((paramFileEntry1.jdField_a_of_type_ComTencentMobileqqUtilsRandomAccessFileManager$FileEntry != paramFileEntry1) && (paramFileEntry1.jdField_a_of_type_ComTencentMobileqqUtilsRandomAccessFileManager$FileEntry != null)) {
          break label87;
        }
        paramMap.remove(paramString);
      }
      for (;;)
      {
        paramFileEntry2.jdField_b_of_type_ComTencentMobileqqUtilsRandomAccessFileManager$FileEntry.jdField_a_of_type_ComTencentMobileqqUtilsRandomAccessFileManager$FileEntry = paramFileEntry2.jdField_a_of_type_ComTencentMobileqqUtilsRandomAccessFileManager$FileEntry;
        paramFileEntry2.jdField_a_of_type_ComTencentMobileqqUtilsRandomAccessFileManager$FileEntry.jdField_b_of_type_ComTencentMobileqqUtilsRandomAccessFileManager$FileEntry = paramFileEntry2.jdField_b_of_type_ComTencentMobileqqUtilsRandomAccessFileManager$FileEntry;
        paramFileEntry2.jdField_a_of_type_ComTencentMobileqqUtilsRandomAccessFileManager$FileEntry = null;
        paramFileEntry2.jdField_b_of_type_ComTencentMobileqqUtilsRandomAccessFileManager$FileEntry = null;
        return;
        label87:
        paramMap.put(paramString, paramFileEntry1.jdField_a_of_type_ComTencentMobileqqUtilsRandomAccessFileManager$FileEntry);
      }
    }
  }
  
  private void a(RandomAccessFileManager.FileEntry paramFileEntry, String paramString, Map<String, RandomAccessFileManager.FileEntry> paramMap)
  {
    RandomAccessFileManager.FileEntry localFileEntry = (RandomAccessFileManager.FileEntry)paramMap.get(paramString);
    if (paramFileEntry == null) {
      return;
    }
    if (localFileEntry == null)
    {
      paramFileEntry.jdField_b_of_type_ComTencentMobileqqUtilsRandomAccessFileManager$FileEntry = paramFileEntry;
      paramFileEntry.jdField_a_of_type_ComTencentMobileqqUtilsRandomAccessFileManager$FileEntry = paramFileEntry;
      paramMap.put(paramString, paramFileEntry);
      return;
    }
    paramFileEntry.jdField_a_of_type_ComTencentMobileqqUtilsRandomAccessFileManager$FileEntry = localFileEntry;
    paramFileEntry.jdField_b_of_type_ComTencentMobileqqUtilsRandomAccessFileManager$FileEntry = localFileEntry.jdField_b_of_type_ComTencentMobileqqUtilsRandomAccessFileManager$FileEntry;
    localFileEntry.jdField_b_of_type_ComTencentMobileqqUtilsRandomAccessFileManager$FileEntry.jdField_a_of_type_ComTencentMobileqqUtilsRandomAccessFileManager$FileEntry = paramFileEntry;
    localFileEntry.jdField_b_of_type_ComTencentMobileqqUtilsRandomAccessFileManager$FileEntry = paramFileEntry;
  }
  
  private void a(String arg1, RandomAccessFileManager.FileEntry paramFileEntry)
  {
    paramFileEntry.jdField_b_of_type_Long = System.currentTimeMillis();
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      a(paramFileEntry, ???, this.jdField_b_of_type_JavaUtilMap);
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
    //   8: invokespecial 104	com/tencent/mobileqq/utils/RandomAccessFileManager:a	(Ljava/lang/String;Ljava/util/Map;)Lcom/tencent/mobileqq/utils/RandomAccessFileManager$FileEntry;
    //   11: astore_3
    //   12: aload_3
    //   13: astore_2
    //   14: aload_3
    //   15: ifnonnull +55 -> 70
    //   18: aload_0
    //   19: getfield 31	com/tencent/mobileqq/utils/RandomAccessFileManager:jdField_a_of_type_ArrayOfByte	[B
    //   22: astore_2
    //   23: aload_2
    //   24: monitorenter
    //   25: aload_0
    //   26: aload_1
    //   27: aload_0
    //   28: getfield 27	com/tencent/mobileqq/utils/RandomAccessFileManager:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   31: invokespecial 104	com/tencent/mobileqq/utils/RandomAccessFileManager:a	(Ljava/lang/String;Ljava/util/Map;)Lcom/tencent/mobileqq/utils/RandomAccessFileManager$FileEntry;
    //   34: astore_3
    //   35: aload_3
    //   36: ifnull +14 -> 50
    //   39: aload_0
    //   40: aconst_null
    //   41: aload_3
    //   42: aload_1
    //   43: aload_0
    //   44: getfield 27	com/tencent/mobileqq/utils/RandomAccessFileManager:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   47: invokespecial 79	com/tencent/mobileqq/utils/RandomAccessFileManager:a	(Lcom/tencent/mobileqq/utils/RandomAccessFileManager$FileEntry;Lcom/tencent/mobileqq/utils/RandomAccessFileManager$FileEntry;Ljava/lang/String;Ljava/util/Map;)V
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
    //   65: invokespecial 89	com/tencent/mobileqq/utils/RandomAccessFileManager:a	(Lcom/tencent/mobileqq/utils/RandomAccessFileManager$FileEntry;Ljava/lang/String;Ljava/util/Map;)V
    //   68: aload_3
    //   69: astore_2
    //   70: aload_2
    //   71: astore_3
    //   72: aload_2
    //   73: ifnonnull +86 -> 159
    //   76: new 42	com/tencent/mobileqq/utils/RandomAccessFileManager$FileEntry
    //   79: dup
    //   80: aload_0
    //   81: invokespecial 105	com/tencent/mobileqq/utils/RandomAccessFileManager$FileEntry:<init>	(Lcom/tencent/mobileqq/utils/RandomAccessFileManager;)V
    //   84: astore_3
    //   85: aload_3
    //   86: new 107	java/io/RandomAccessFile
    //   89: dup
    //   90: aload_1
    //   91: ldc 109
    //   93: invokespecial 112	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: putfield 115	com/tencent/mobileqq/utils/RandomAccessFileManager$FileEntry:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   99: aload_3
    //   100: invokestatic 51	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   103: invokevirtual 55	java/lang/Thread:getId	()J
    //   106: putfield 45	com/tencent/mobileqq/utils/RandomAccessFileManager$FileEntry:jdField_a_of_type_Long	J
    //   109: invokestatic 121	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   112: ifeq +37 -> 149
    //   115: ldc 123
    //   117: iconst_2
    //   118: iconst_4
    //   119: anewarray 4	java/lang/Object
    //   122: dup
    //   123: iconst_0
    //   124: ldc 125
    //   126: aastore
    //   127: dup
    //   128: iconst_1
    //   129: aload_1
    //   130: aastore
    //   131: dup
    //   132: iconst_2
    //   133: ldc 127
    //   135: aastore
    //   136: dup
    //   137: iconst_3
    //   138: aload_3
    //   139: getfield 45	com/tencent/mobileqq/utils/RandomAccessFileManager$FileEntry:jdField_a_of_type_Long	J
    //   142: invokestatic 133	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   145: aastore
    //   146: invokestatic 137	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   149: aload_0
    //   150: aload_3
    //   151: aload_1
    //   152: aload_0
    //   153: getfield 25	com/tencent/mobileqq/utils/RandomAccessFileManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   156: invokespecial 89	com/tencent/mobileqq/utils/RandomAccessFileManager:a	(Lcom/tencent/mobileqq/utils/RandomAccessFileManager$FileEntry;Ljava/lang/String;Ljava/util/Map;)V
    //   159: aload_3
    //   160: aload_3
    //   161: getfield 140	com/tencent/mobileqq/utils/RandomAccessFileManager$FileEntry:jdField_a_of_type_Int	I
    //   164: iconst_1
    //   165: iadd
    //   166: putfield 140	com/tencent/mobileqq/utils/RandomAccessFileManager$FileEntry:jdField_a_of_type_Int	I
    //   169: aload_3
    //   170: getfield 115	com/tencent/mobileqq/utils/RandomAccessFileManager$FileEntry:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   173: astore_1
    //   174: aload_0
    //   175: monitorexit
    //   176: aload_1
    //   177: areturn
    //   178: astore_1
    //   179: aload_2
    //   180: monitorexit
    //   181: aload_1
    //   182: athrow
    //   183: astore_1
    //   184: aload_0
    //   185: monitorexit
    //   186: aload_1
    //   187: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	this	RandomAccessFileManager
    //   0	188	1	paramString	String
    //   11	159	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   25	35	178	finally
    //   39	50	178	finally
    //   50	52	178	finally
    //   179	181	178	finally
    //   2	12	183	finally
    //   18	25	183	finally
    //   58	68	183	finally
    //   76	149	183	finally
    //   149	159	183	finally
    //   159	174	183	finally
    //   181	183	183	finally
  }
  
  public void a(String paramString)
  {
    try
    {
      RandomAccessFileManager.FileEntry localFileEntry = a(paramString, this.jdField_a_of_type_JavaUtilMap);
      if (localFileEntry != null)
      {
        localFileEntry.jdField_a_of_type_Int -= 1;
        if (localFileEntry.jdField_a_of_type_Int == 0)
        {
          a(null, localFileEntry, paramString, this.jdField_a_of_type_JavaUtilMap);
          a(paramString, localFileEntry);
        }
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.RandomAccessFileManager
 * JD-Core Version:    0.7.0.1
 */