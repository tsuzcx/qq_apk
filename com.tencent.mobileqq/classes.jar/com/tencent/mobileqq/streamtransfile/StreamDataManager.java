package com.tencent.mobileqq.streamtransfile;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class StreamDataManager
{
  public static int a(String paramString)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (StreamFileInfo)localHashMap.get(paramString);
      if (paramString != null) {
        return paramString.a().size();
      }
    }
    return 0;
  }
  
  public static int a(String paramString, short paramShort)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (StreamFileInfo)localHashMap.get(paramString);
      if (paramString != null)
      {
        if (paramShort <= paramString.a().size()) {
          return ((StreamDataInfo)paramString.a().get(paramShort - 1)).a();
        }
        QLog.w("StreamDataManager", 2, "getRecordedSize error shPackSeq: " + paramShort + "sfi.getStreamData().size(): " + paramString.a().size());
      }
    }
    return 0;
  }
  
  public static File a(String paramString)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (StreamFileInfo)localHashMap.get(paramString);
      if (paramString != null) {
        return paramString.a();
      }
    }
    return null;
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    if ((localHashMap != null) && (localHashMap.size() > 0))
    {
      Iterator localIterator = localHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        StreamFileInfo localStreamFileInfo = (StreamFileInfo)localHashMap.get(str);
        if ((localStreamFileInfo.b() == paramInt1) && (localStreamFileInfo.a() == paramInt2)) {
          return str;
        }
      }
    }
    return null;
  }
  
  public static Map.Entry a(long paramLong1, long paramLong2)
  {
    Object localObject = StreamMemoryPool.a();
    if (QLog.isColorLevel()) {
      QLog.d("StreamDataManager", 2, "getStreamFileInfoEntryByMsg  try get random is:" + paramLong1 + ",msgSeq is:" + paramLong2);
    }
    if ((localObject != null) && (((HashMap)localObject).size() > 0))
    {
      localObject = ((HashMap)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        StreamFileInfo localStreamFileInfo = (StreamFileInfo)localEntry.getValue();
        if (QLog.isColorLevel()) {
          QLog.d("StreamDataManager", 2, "getStreamFileInfoEntryByMsg  random is:" + MessageUtils.a((int)localStreamFileInfo.b) + ",msgSeq is:" + localStreamFileInfo.jdField_a_of_type_Long);
        }
        if ((MessageUtils.a((int)localStreamFileInfo.b) == paramLong1) && (paramLong2 == localStreamFileInfo.jdField_a_of_type_Long)) {
          return localEntry;
        }
      }
    }
    return null;
  }
  
  public static short a(String paramString)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (StreamFileInfo)localHashMap.get(paramString);
      if (paramString != null) {
        return paramString.c();
      }
    }
    return -1;
  }
  
  public static void a(String paramString)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (StreamFileInfo)localHashMap.get(paramString);
      if (paramString != null)
      {
        int i = paramString.a().size();
        paramString.a((short)i);
        if (i >= 1) {
          ((StreamDataInfo)paramString.a().get(paramString.a().size() - 1)).a(true);
        }
      }
    }
  }
  
  public static void a(String paramString, long paramLong)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (StreamFileInfo)localHashMap.get(paramString);
      if (paramString != null) {
        paramString.jdField_a_of_type_Long = paramLong;
      }
    }
  }
  
  public static void a(String paramString1, QQAppInterface paramQQAppInterface, String paramString2, long paramLong1, int paramInt1, int paramInt2, long paramLong2, Bundle paramBundle)
  {
    a(paramString1, paramQQAppInterface, paramString2, paramLong1, false, paramInt1, paramInt2, paramLong2, paramBundle);
  }
  
  public static void a(String paramString1, QQAppInterface paramQQAppInterface, String paramString2, long paramLong1, boolean paramBoolean, int paramInt1, int paramInt2, long paramLong2, Bundle paramBundle)
  {
    short s1 = -1;
    Object localObject = StreamMemoryPool.a();
    paramInt1 = RecordParams.a(paramInt1);
    short s2;
    StreamDataInfo localStreamDataInfo;
    if ((localObject != null) && (((HashMap)localObject).containsKey(paramString1)))
    {
      localObject = (StreamFileInfo)((HashMap)localObject).get(paramString1);
      ((StreamFileInfo)localObject).jdField_a_of_type_Boolean = paramBoolean;
      if (localObject != null)
      {
        s2 = s1;
        if (((StreamFileInfo)localObject).a() == 0)
        {
          localObject = ((StreamFileInfo)localObject).a();
          s2 = s1;
          if (localObject != null)
          {
            s2 = s1;
            if (((List)localObject).size() > 0)
            {
              localObject = ((List)localObject).iterator();
              s2 = s1;
              if (((Iterator)localObject).hasNext())
              {
                localStreamDataInfo = (StreamDataInfo)((Iterator)localObject).next();
                if ((localStreamDataInfo.a() == localStreamDataInfo.a().length) && (!localStreamDataInfo.b()))
                {
                  s1 = localStreamDataInfo.a();
                  localStreamDataInfo.b(true);
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      break;
      if ((!localStreamDataInfo.b()) && (localStreamDataInfo.a()))
      {
        s1 = localStreamDataInfo.a();
        localStreamDataInfo.b(true);
        continue;
        if ((s2 != -1) && (paramLong1 != 0L)) {
          paramQQAppInterface.a().a(paramString2, paramString1, paramLong1, s2, paramInt1, paramInt2, paramLong2, paramBundle);
        }
        return;
      }
    }
  }
  
  public static void a(String paramString, short paramShort)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (StreamFileInfo)localHashMap.get(paramString);
      if (paramString != null) {
        paramString.c(paramShort);
      }
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (StreamFileInfo)localHashMap.get(paramString);
      if (paramString != null) {
        paramString.a(paramBoolean);
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    if ((localHashMap != null) && (!localHashMap.containsKey(paramString)))
    {
      paramQQAppInterface = new StreamFileInfo(paramQQAppInterface, paramInt1, paramString, paramInt2);
      paramQQAppInterface.a(paramInt3);
      try
      {
        localHashMap.put(paramString, paramQQAppInterface);
        return true;
      }
      finally {}
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString))) {
      try
      {
        localHashMap.remove(paramString);
        return true;
      }
      finally {}
    }
    return false;
  }
  
  public static boolean a(String paramString, short paramShort)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    return (localHashMap == null) || (!localHashMap.containsKey(paramString)) || (((StreamFileInfo)localHashMap.get(paramString)).b() != paramShort);
  }
  
  public static boolean a(String paramString, byte[] paramArrayOfByte, int paramInt, short paramShort)
  {
    return a(paramString, paramArrayOfByte, paramInt, paramShort, false);
  }
  
  public static boolean a(String paramString, byte[] paramArrayOfByte, int paramInt, short paramShort, boolean paramBoolean)
  {
    Object localObject1 = StreamMemoryPool.a();
    if ((localObject1 != null) && (((HashMap)localObject1).containsKey(paramString)))
    {
      StreamFileInfo localStreamFileInfo = (StreamFileInfo)((HashMap)localObject1).get(paramString);
      if (!paramBoolean) {}
      try
      {
        localStreamFileInfo.a(paramArrayOfByte, paramInt);
        if (localStreamFileInfo.a() == 0)
        {
          paramString = localStreamFileInfo.a();
          if (paramString.size() == 0)
          {
            localObject1 = new StreamDataInfo(localStreamFileInfo.jdField_a_of_type_Int);
            System.arraycopy(paramArrayOfByte, 0, ((StreamDataInfo)localObject1).a(), 0, paramInt);
            ((StreamDataInfo)localObject1).a(paramInt);
            paramShort = localStreamFileInfo.b();
            s = (short)(paramShort + 1);
            ((StreamDataInfo)localObject1).a(paramShort);
            paramString.add(localObject1);
            localStreamFileInfo.b(s);
            return true;
          }
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          short s;
          if (QLog.isColorLevel())
          {
            QLog.d("StreamDataManager", 2, "write fail", paramString);
            continue;
            localObject1 = (StreamDataInfo)paramString.get(paramString.size() - 1);
            Object localObject2 = ((StreamDataInfo)localObject1).a();
            int i;
            if (((StreamDataInfo)localObject1).a() < localObject2.length)
            {
              i = localObject2.length - ((StreamDataInfo)localObject1).a();
              if (i >= paramInt)
              {
                System.arraycopy(paramArrayOfByte, 0, ((StreamDataInfo)localObject1).a(), ((StreamDataInfo)localObject1).a(), paramInt);
                ((StreamDataInfo)localObject1).a(((StreamDataInfo)localObject1).a() + paramInt);
              }
              else
              {
                if (paramInt <= i)
                {
                  System.arraycopy(paramArrayOfByte, 0, ((StreamDataInfo)localObject1).a(), ((StreamDataInfo)localObject1).a(), paramInt);
                  ((StreamDataInfo)localObject1).a(((StreamDataInfo)localObject1).a() + paramInt);
                  return true;
                }
                System.arraycopy(paramArrayOfByte, 0, ((StreamDataInfo)localObject1).a(), ((StreamDataInfo)localObject1).a(), i);
                ((StreamDataInfo)localObject1).a(((StreamDataInfo)localObject1).a().length);
                paramInt -= i;
                localObject1 = new StreamDataInfo(localStreamFileInfo.jdField_a_of_type_Int);
                System.arraycopy(paramArrayOfByte, i, ((StreamDataInfo)localObject1).a(), 0, paramInt);
                ((StreamDataInfo)localObject1).a(paramInt);
                paramShort = localStreamFileInfo.b();
                s = (short)(paramShort + 1);
                ((StreamDataInfo)localObject1).a(paramShort);
                paramString.add(localObject1);
                localStreamFileInfo.b(s);
              }
            }
            else
            {
              localObject1 = new StreamDataInfo(localStreamFileInfo.jdField_a_of_type_Int);
              System.arraycopy(paramArrayOfByte, 0, ((StreamDataInfo)localObject1).a(), 0, paramInt);
              ((StreamDataInfo)localObject1).a(paramInt);
              paramShort = localStreamFileInfo.b();
              s = (short)(paramShort + 1);
              ((StreamDataInfo)localObject1).a(paramShort);
              paramString.add(localObject1);
              localStreamFileInfo.b(s);
              continue;
              if (localStreamFileInfo.a() == 1)
              {
                localObject2 = localStreamFileInfo.a();
                paramInt = paramArrayOfByte.length;
                i = 0;
                if (paramInt > 0)
                {
                  if (((List)localObject2).size() == 0)
                  {
                    paramString = new StreamDataInfo(localStreamFileInfo.jdField_a_of_type_Int);
                    ((List)localObject2).add(paramString);
                  }
                  for (;;)
                  {
                    int k = paramString.a().length - paramString.a();
                    int j = k;
                    if (k >= paramInt) {
                      j = paramInt;
                    }
                    System.arraycopy(paramArrayOfByte, i, paramString.a(), paramString.a(), j);
                    i += j;
                    paramInt -= j;
                    paramString.a(j + paramString.a());
                    paramString.a(paramShort);
                    break;
                    localObject1 = (StreamDataInfo)((List)localObject2).get(((List)localObject2).size() - 1);
                    paramString = (String)localObject1;
                    if (((StreamDataInfo)localObject1).a().length - ((StreamDataInfo)localObject1).a() <= 0)
                    {
                      paramString = new StreamDataInfo(localStreamFileInfo.jdField_a_of_type_Int);
                      ((List)localObject2).add(paramString);
                    }
                  }
                }
                localStreamFileInfo.b((short)(paramShort + 1));
              }
            }
          }
        }
      }
    }
    return false;
  }
  
  public static byte[] a(String paramString, short paramShort)
  {
    Object localObject = StreamMemoryPool.a();
    if ((localObject != null) && (((HashMap)localObject).containsKey(paramString)))
    {
      paramString = (StreamFileInfo)((HashMap)localObject).get(paramString);
      if (paramString != null)
      {
        localObject = (StreamDataInfo)paramString.a().get(paramShort - 1);
        paramString = ((StreamDataInfo)localObject).a();
        paramShort = ((StreamDataInfo)localObject).a();
        if (paramShort != paramString.length)
        {
          localObject = new byte[paramShort];
          System.arraycopy(paramString, 0, localObject, 0, paramShort);
          return localObject;
        }
        return paramString;
      }
    }
    return null;
  }
  
  public static int b(String paramString)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (StreamFileInfo)localHashMap.get(paramString);
      if (paramString != null) {
        return paramString.b();
      }
    }
    return -1;
  }
  
  public static short b(String paramString)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (StreamFileInfo)localHashMap.get(paramString);
      if (paramString != null) {
        return paramString.a();
      }
    }
    return 0;
  }
  
  public static void b(String paramString)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (StreamFileInfo)localHashMap.get(paramString);
      if (paramString != null) {
        paramString.a();
      }
    }
  }
  
  public static void b(String paramString, long paramLong)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (StreamFileInfo)localHashMap.get(paramString);
      if (paramString != null) {
        paramString.b = paramLong;
      }
    }
  }
  
  public static boolean b(String paramString)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (StreamFileInfo)localHashMap.get(paramString);
      if (paramString != null) {
        return paramString.jdField_a_of_type_Boolean;
      }
    }
    return false;
  }
  
  public static int c(String paramString)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    int i;
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (StreamFileInfo)localHashMap.get(paramString);
      if (paramString != null)
      {
        i = paramString.a().size();
        if ((i < 1) || (((StreamDataInfo)paramString.a().get(i - 1)).b())) {
          return i;
        }
        return i - 1;
      }
    }
    return 0;
    return i;
  }
  
  public static short c(String paramString)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (StreamFileInfo)localHashMap.get(paramString);
      if (paramString != null) {
        return paramString.b();
      }
    }
    return 0;
  }
  
  public static void c(String paramString, long paramLong)
  {
    HashMap localHashMap = StreamMemoryPool.a();
    if ((localHashMap != null) && (localHashMap.containsKey(paramString)))
    {
      paramString = (StreamFileInfo)localHashMap.get(paramString);
      if (paramString != null) {
        paramString.a(paramLong);
      }
    }
  }
  
  public static boolean c(String paramString)
  {
    List localList = StreamMemoryPool.a();
    if ((localList != null) && (!localList.contains(paramString)))
    {
      localList.add(paramString);
      return true;
    }
    return false;
  }
  
  public static boolean d(String paramString)
  {
    List localList = StreamMemoryPool.a();
    if ((localList != null) && (localList.contains(paramString)))
    {
      localList.remove(paramString);
      return true;
    }
    return false;
  }
  
  public static boolean e(String paramString)
  {
    List localList = StreamMemoryPool.a();
    return (localList != null) && (localList.contains(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.streamtransfile.StreamDataManager
 * JD-Core Version:    0.7.0.1
 */