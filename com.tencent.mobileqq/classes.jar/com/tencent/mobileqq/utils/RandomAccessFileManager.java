package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.RandomAccessFile;
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
    int i = 0;
    if (paramMap != null)
    {
      paramString = paramMap;
      RandomAccessFileManager.FileEntry localFileEntry;
      do
      {
        if (paramString.jdField_a_of_type_Long == Thread.currentThread().getId())
        {
          i = 1;
          break;
        }
        localFileEntry = paramString.jdField_a_of_type_ComTencentMobileqqUtilsRandomAccessFileManager$FileEntry;
        paramString = localFileEntry;
      } while (localFileEntry != paramMap);
      paramString = localFileEntry;
    }
    else
    {
      paramString = paramMap;
    }
    if (i != 0) {
      return paramString;
    }
    return null;
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
    RandomAccessFileManager.FileEntry localFileEntry = paramFileEntry1;
    if (paramFileEntry1 == null) {
      localFileEntry = (RandomAccessFileManager.FileEntry)paramMap.get(paramString);
    }
    if (localFileEntry != null)
    {
      if (paramFileEntry2 == null) {
        return;
      }
      if (paramFileEntry2 == localFileEntry) {
        if ((localFileEntry.jdField_a_of_type_ComTencentMobileqqUtilsRandomAccessFileManager$FileEntry != localFileEntry) && (localFileEntry.jdField_a_of_type_ComTencentMobileqqUtilsRandomAccessFileManager$FileEntry != null)) {
          paramMap.put(paramString, localFileEntry.jdField_a_of_type_ComTencentMobileqqUtilsRandomAccessFileManager$FileEntry);
        } else {
          paramMap.remove(paramString);
        }
      }
      paramFileEntry2.jdField_b_of_type_ComTencentMobileqqUtilsRandomAccessFileManager$FileEntry.jdField_a_of_type_ComTencentMobileqqUtilsRandomAccessFileManager$FileEntry = paramFileEntry2.jdField_a_of_type_ComTencentMobileqqUtilsRandomAccessFileManager$FileEntry;
      paramFileEntry2.jdField_a_of_type_ComTencentMobileqqUtilsRandomAccessFileManager$FileEntry.jdField_b_of_type_ComTencentMobileqqUtilsRandomAccessFileManager$FileEntry = paramFileEntry2.jdField_b_of_type_ComTencentMobileqqUtilsRandomAccessFileManager$FileEntry;
      paramFileEntry2.jdField_a_of_type_ComTencentMobileqqUtilsRandomAccessFileManager$FileEntry = null;
      paramFileEntry2.jdField_b_of_type_ComTencentMobileqqUtilsRandomAccessFileManager$FileEntry = null;
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
      synchronized (this.jdField_b_of_type_ArrayOfByte)
      {
        if (this.jdField_a_of_type_JavaLangRunnable == null)
        {
          this.jdField_a_of_type_JavaLangRunnable = new RandomAccessFileManager.CloseThread(this);
          ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 8, null, false);
        }
        return;
      }
    }
  }
  
  public RandomAccessFile a(String paramString)
  {
    try
    {
      ??? = a(paramString, this.jdField_a_of_type_JavaUtilMap);
      Object localObject1 = ???;
      if (??? == null) {
        synchronized (this.jdField_a_of_type_ArrayOfByte)
        {
          localObject1 = a(paramString, this.jdField_b_of_type_JavaUtilMap);
          if (localObject1 != null) {
            a(null, (RandomAccessFileManager.FileEntry)localObject1, paramString, this.jdField_b_of_type_JavaUtilMap);
          }
          if (localObject1 != null) {
            a((RandomAccessFileManager.FileEntry)localObject1, paramString, this.jdField_a_of_type_JavaUtilMap);
          }
        }
      }
      ??? = localObject1;
      if (localObject1 == null)
      {
        ??? = new RandomAccessFileManager.FileEntry(this);
        ((RandomAccessFileManager.FileEntry)???).jdField_a_of_type_JavaIoRandomAccessFile = new RandomAccessFile(paramString, "r");
        ((RandomAccessFileManager.FileEntry)???).jdField_a_of_type_Long = Thread.currentThread().getId();
        if (QLog.isColorLevel()) {
          QLog.d("AppleMojiHandler", 2, new Object[] { "open file:", paramString, " threadID:", Long.valueOf(((RandomAccessFileManager.FileEntry)???).jdField_a_of_type_Long) });
        }
        a((RandomAccessFileManager.FileEntry)???, paramString, this.jdField_a_of_type_JavaUtilMap);
      }
      ((RandomAccessFileManager.FileEntry)???).jdField_a_of_type_Int += 1;
      paramString = ((RandomAccessFileManager.FileEntry)???).jdField_a_of_type_JavaIoRandomAccessFile;
      return paramString;
    }
    finally {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.RandomAccessFileManager
 * JD-Core Version:    0.7.0.1
 */