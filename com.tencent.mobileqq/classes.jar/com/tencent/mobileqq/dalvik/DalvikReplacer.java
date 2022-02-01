package com.tencent.mobileqq.dalvik;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build.VERSION;

public class DalvikReplacer
{
  public static final int ERR_ART = 15;
  private static final int ERR_FIND = 6;
  private static final int ERR_FIND_EXC = 7;
  private static final int ERR_GC_HEAP = 18;
  private static final int ERR_HEAP_0 = 20;
  private static final int ERR_HEAP_EXC = 16;
  private static final int ERR_HEAP_SOURCE = 19;
  private static final int ERR_ING = 2;
  private static final int ERR_MAP_EMPTY = 5;
  private static final int ERR_MAP_EXC = 4;
  private static final int ERR_MATCH_LA = 17;
  public static final int ERR_OK = 21;
  private static final int ERR_REP_ALLOC = 8;
  private static final int ERR_REP_EXP = 10;
  private static final int ERR_REP_MMAP = 9;
  private static final int ERR_SO_LOAD = 3;
  private static final int ERR_VER_EXC = 14;
  private static final int ERR_VER_HIT = 12;
  private static final int ERR_VER_MODE = 13;
  public static final int ERR_VIRGIN = 1;
  public static final int SIZE_LINEARALLOC_GINGERBREAD = 5242880;
  public static final int SIZE_LINEARALLOC_ICS = 8388608;
  public static final int SIZE_LINEARALLOC_JB = 16777216;
  private static final int SYSTEM_PAGE_SIZE = 4096;
  public static int sArtHackResult = 1;
  public static int sHeapResult = 1;
  public static int sLaResult = 1;
  public static int sVerifyResult = 1;
  
  public static void artHack(Context paramContext, long paramLong1, long paramLong2)
  {
    if (sArtHackResult == 1)
    {
      int i;
      if ((paramLong2 > paramLong1) && (Build.VERSION.SDK_INT == 23)) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        sArtHackResult = 2;
        Object localObject = null;
        if (DalvikInternals.loadLib(paramContext))
        {
          try
          {
            long[] arrayOfLong = new MappingReader().getReadableMaps();
            localObject = arrayOfLong;
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
          }
          if ((localObject != null) && (localObject.length > 1))
          {
            i = ((ActivityManager)paramContext.getSystemService("activity")).getLargeMemoryClass();
            i = DalvikInternals.modArtHeap(localObject, (int)paramLong1, i * 1024 * 1024, (int)paramLong2);
            if (i == 0)
            {
              sArtHackResult = 21;
              return;
            }
            sArtHackResult = i;
            return;
          }
          sArtHackResult = 5;
          return;
        }
        sArtHackResult = 3;
      }
    }
  }
  
  public static void dvmHack(Context paramContext, int paramInt, boolean paramBoolean, long paramLong)
  {
    int k;
    int i;
    int j;
    if ((sLaResult == 1) && (sVerifyResult == 1))
    {
      sLaResult = 2;
      sVerifyResult = 2;
      k = 0;
      if ((paramBoolean) && (Build.VERSION.SDK_INT <= 20)) {
        i = 1;
      } else {
        i = 0;
      }
      if ((paramLong > Runtime.getRuntime().maxMemory()) && (Build.VERSION.SDK_INT <= 20)) {
        j = 1;
      } else {
        j = 0;
      }
      if ((i == 0) && (j == 0)) {}
    }
    try
    {
      localObject1 = System.getProperty("java.vm.version");
      if (localObject1 != null)
      {
        paramBoolean = ((String)localObject1).startsWith("2");
        if (paramBoolean)
        {
          i = 0;
          j = 0;
        }
      }
    }
    catch (Throwable localThrowable1)
    {
      Object localObject1;
      label117:
      Object localObject3;
      Object localObject2;
      long l1;
      long l2;
      break label117;
    }
    if (getLinearAllocLimit() < paramInt) {
      k = 1;
    }
    if ((i == 0) && (k == 0) && (j == 0))
    {
      sHeapResult = 21;
      sVerifyResult = 21;
      sLaResult = 21;
      return;
    }
    paramBoolean = DalvikInternals.loadLib(paramContext);
    localObject3 = null;
    if (paramBoolean)
    {
      try
      {
        localObject1 = new MappingReader();
        try
        {
          long[] arrayOfLong = ((MappingReader)localObject1).getReadableMaps();
        }
        catch (Throwable localThrowable2) {}
        localThrowable3.printStackTrace();
      }
      catch (Throwable localThrowable3)
      {
        localObject1 = null;
      }
      localObject2 = localObject3;
    }
    else
    {
      localObject1 = null;
      localObject2 = localObject3;
    }
    if (k != 0)
    {
      if (paramBoolean)
      {
        if ((localObject2 != null) && (localObject2.length > 1)) {
          try
          {
            l1 = findLinearAllocHeader((MappingReader)localObject1, localObject2);
            if (l1 <= 0L) {
              try
              {
                sLaResult = 6;
              }
              catch (Throwable localThrowable4)
              {
                break label320;
              }
            } else {
              try
              {
                paramInt = DalvikInternals.replace(l1, paramInt, 4096);
                if (paramInt == 0) {
                  sLaResult = 21;
                } else {
                  sLaResult = paramInt;
                }
              }
              catch (Throwable localThrowable5)
              {
                localThrowable5.printStackTrace();
                sLaResult = 10;
              }
            }
            label320:
            sLaResult = 5;
          }
          catch (Throwable localThrowable6)
          {
            l1 = 0L;
            localThrowable6.printStackTrace();
            sLaResult = 7;
          }
        }
      }
      else {
        sLaResult = 3;
      }
    }
    else {
      sLaResult = 21;
    }
    l1 = 0L;
    if (j != 0)
    {
      if (paramBoolean) {
        if ((localObject2 != null) && (localObject2.length > 1))
        {
          l2 = l1;
          try
          {
            if (sLaResult == 21)
            {
              l2 = l1;
              if (l1 == 0L) {
                l2 = findLinearAllocHeader((MappingReader)localObject1, localObject2);
              }
            }
            if (l2 <= 0L)
            {
              sHeapResult = 6;
            }
            else
            {
              paramInt = ((ActivityManager)paramContext.getSystemService("activity")).getLargeMemoryClass() * 1024 * 1024;
              paramLong = Math.min(paramLong, paramInt);
              paramInt = DalvikInternals.modheap(localObject2, (int)l2, (int)Runtime.getRuntime().maxMemory(), paramInt, (int)paramLong);
              if (paramInt == 0) {
                sHeapResult = 21;
              } else {
                sHeapResult = paramInt;
              }
            }
          }
          catch (Throwable paramContext)
          {
            paramContext.printStackTrace();
            sVerifyResult = 16;
          }
        }
        else
        {
          sHeapResult = 5;
        }
      }
    }
    else {
      sHeapResult = 21;
    }
    if (i != 0)
    {
      if (paramBoolean)
      {
        if ((localObject2 != null) && (localObject2.length > 1)) {
          try
          {
            paramInt = DalvikInternals.preverify(localObject2);
            if (paramInt == 0)
            {
              sVerifyResult = 21;
              return;
            }
            sVerifyResult = paramInt;
            return;
          }
          catch (Throwable paramContext)
          {
            paramContext.printStackTrace();
            sVerifyResult = 14;
            return;
          }
        }
        sVerifyResult = 5;
        return;
      }
      sVerifyResult = 3;
      return;
    }
    sVerifyResult = 21;
  }
  
  private static long findLinearAllocHeader(MappingReader paramMappingReader, long[] paramArrayOfLong)
  {
    Mapping localMapping = paramMappingReader.findMappingByName("LinearAlloc");
    if (localMapping != null)
    {
      paramMappingReader = paramMappingReader.findMappingByName("[heap]");
      long l1;
      long l2;
      if ((paramMappingReader != null) && (paramMappingReader.readable))
      {
        l1 = paramMappingReader.beginAddr;
        l2 = paramMappingReader.endAddr;
      }
      else
      {
        l1 = 0L;
        l2 = l1;
      }
      int i;
      switch (Build.VERSION.SDK_INT)
      {
      default: 
        i = 0;
        break;
      case 9: 
      case 10: 
        i = 24;
        break;
      case 8: 
        i = 20;
      }
      return DalvikInternals.find(paramArrayOfLong, 704, 1480, i, 3, 524288, 16777216, l1, l2, 5242880, 16777216, 4100, localMapping.beginAddr);
    }
    return 0L;
  }
  
  public static int getLinearAllocLimit()
  {
    int i = Build.VERSION.SDK_INT;
    if (i < 11) {
      return 5242880;
    }
    if (i < 16) {
      return 8388608;
    }
    return 16777216;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dalvik.DalvikReplacer
 * JD-Core Version:    0.7.0.1
 */