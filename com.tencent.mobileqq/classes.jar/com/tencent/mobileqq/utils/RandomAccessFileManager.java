package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;

public class RandomAccessFileManager
{
  private static RandomAccessFileManager f = new RandomAccessFileManager();
  private Map<String, RandomAccessFileManager.FileEntry> a = new HashMap();
  private Map<String, RandomAccessFileManager.FileEntry> b = new HashMap();
  private Runnable c = null;
  private byte[] d = new byte[0];
  private byte[] e = new byte[0];
  
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
        if (paramString.c == Thread.currentThread().getId())
        {
          i = 1;
          break;
        }
        localFileEntry = paramString.d;
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
      RandomAccessFileManager localRandomAccessFileManager = f;
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
        if ((localFileEntry.d != localFileEntry) && (localFileEntry.d != null)) {
          paramMap.put(paramString, localFileEntry.d);
        } else {
          paramMap.remove(paramString);
        }
      }
      paramFileEntry2.e.d = paramFileEntry2.d;
      paramFileEntry2.d.e = paramFileEntry2.e;
      paramFileEntry2.d = null;
      paramFileEntry2.e = null;
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
      paramFileEntry.e = paramFileEntry;
      paramFileEntry.d = paramFileEntry;
      paramMap.put(paramString, paramFileEntry);
      return;
    }
    paramFileEntry.d = localFileEntry;
    paramFileEntry.e = localFileEntry.e;
    localFileEntry.e.d = paramFileEntry;
    localFileEntry.e = paramFileEntry;
  }
  
  private void a(String arg1, RandomAccessFileManager.FileEntry paramFileEntry)
  {
    paramFileEntry.f = System.currentTimeMillis();
    synchronized (this.d)
    {
      a(paramFileEntry, ???, this.b);
      synchronized (this.e)
      {
        if (this.c == null)
        {
          this.c = new RandomAccessFileManager.CloseThread(this);
          ThreadManager.post(this.c, 8, null, false);
        }
        return;
      }
    }
  }
  
  public RandomAccessFile a(String paramString)
  {
    try
    {
      ??? = a(paramString, this.a);
      Object localObject1 = ???;
      if (??? == null) {
        synchronized (this.d)
        {
          localObject1 = a(paramString, this.b);
          if (localObject1 != null) {
            a(null, (RandomAccessFileManager.FileEntry)localObject1, paramString, this.b);
          }
          if (localObject1 != null) {
            a((RandomAccessFileManager.FileEntry)localObject1, paramString, this.a);
          }
        }
      }
      ??? = localObject1;
      if (localObject1 == null)
      {
        ??? = new RandomAccessFileManager.FileEntry(this);
        ((RandomAccessFileManager.FileEntry)???).a = new RandomAccessFile(paramString, "r");
        ((RandomAccessFileManager.FileEntry)???).c = Thread.currentThread().getId();
        if (QLog.isColorLevel()) {
          QLog.d("AppleMojiHandler", 2, new Object[] { "open file:", paramString, " threadID:", Long.valueOf(((RandomAccessFileManager.FileEntry)???).c) });
        }
        a((RandomAccessFileManager.FileEntry)???, paramString, this.a);
      }
      ((RandomAccessFileManager.FileEntry)???).b += 1;
      paramString = ((RandomAccessFileManager.FileEntry)???).a;
      return paramString;
    }
    finally {}
  }
  
  public void b(String paramString)
  {
    try
    {
      RandomAccessFileManager.FileEntry localFileEntry = a(paramString, this.a);
      if (localFileEntry != null)
      {
        localFileEntry.b -= 1;
        if (localFileEntry.b == 0)
        {
          a(null, localFileEntry, paramString, this.a);
          a(paramString, localFileEntry);
        }
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.RandomAccessFileManager
 * JD-Core Version:    0.7.0.1
 */