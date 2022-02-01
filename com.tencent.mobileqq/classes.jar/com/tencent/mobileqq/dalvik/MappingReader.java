package com.tencent.mobileqq.dalvik;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MappingReader
{
  private List<Mapping> mMappings = new ArrayList();
  
  public MappingReader()
  {
    getMapsFromFile(new File("/proc/self/maps"));
  }
  
  private IllegalArgumentException createIAE(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("Invalid /proc/self/maps line: '");
    localStringBuilder.append(paramString);
    localStringBuilder.append("'");
    return new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private void getMapsFromFile(File paramFile)
  {
    paramFile = new FileReader(paramFile);
    try
    {
      BufferedReader localBufferedReader = new BufferedReader(paramFile);
      ArrayList localArrayList = new ArrayList();
      for (;;)
      {
        String str = localBufferedReader.readLine();
        if (str == null)
        {
          if (localArrayList.size() > 0) {
            getMapsFromMapLines(localArrayList);
          }
          paramFile.close();
          return;
        }
        localArrayList.add(str);
      }
      throw localObject;
    }
    finally
    {
      paramFile.close();
    }
    for (;;) {}
  }
  
  private void getMapsFromMapLines(List<String> paramList)
  {
    paramList = paramList.iterator();
    for (;;)
    {
      if (!paramList.hasNext()) {
        return;
      }
      this.mMappings.add(getRwMap((String)paramList.next()));
    }
  }
  
  private final long[] getMergedIntervals(List<Mapping> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    long l2 = -1L;
    long l1 = l2;
    for (;;)
    {
      if (!paramList.hasNext())
      {
        if (l2 != -1L)
        {
          localArrayList.add(Long.valueOf(l2));
          localArrayList.add(Long.valueOf(l1));
        }
        paramList = new long[localArrayList.size()];
        int i = 0;
        for (;;)
        {
          if (i >= localArrayList.size()) {
            return paramList;
          }
          paramList[i] = ((Long)localArrayList.get(i)).longValue();
          i += 1;
        }
      }
      Mapping localMapping = (Mapping)paramList.next();
      if (l2 == -1L)
      {
        l2 = localMapping.beginAddr;
        l1 = localMapping.endAddr;
      }
      else if (localMapping.beginAddr == l1)
      {
        l1 = localMapping.endAddr;
      }
      else
      {
        localArrayList.add(Long.valueOf(l2));
        localArrayList.add(Long.valueOf(l1));
        l2 = localMapping.beginAddr;
        l1 = localMapping.endAddr;
      }
    }
  }
  
  private Mapping getRwMap(String paramString)
  {
    String[] arrayOfString1 = paramString.split(" +", 6);
    String[] arrayOfString2;
    if (arrayOfString1.length == 6)
    {
      arrayOfString2 = arrayOfString1[0].split("-");
      if (arrayOfString2.length != 2) {}
    }
    try
    {
      long l1 = Long.parseLong(arrayOfString2[0], 16);
      long l2 = Long.parseLong(arrayOfString2[1], 16);
      int i = arrayOfString1[1].length();
      if (i == 4)
      {
        boolean bool1 = isEquals(arrayOfString1[1].charAt(0), 'r', paramString);
        boolean bool2 = isEquals(arrayOfString1[1].charAt(1), 'w', paramString);
        arrayOfString1[1].charAt(3);
        return new Mapping(l1, l2, bool1, bool2, true, arrayOfString1[5]);
      }
      throw createIAE(paramString);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label139:
      break label139;
    }
    throw createIAE(paramString);
    throw createIAE(paramString);
    throw createIAE(paramString);
  }
  
  private boolean isEquals(char paramChar1, char paramChar2, String paramString)
  {
    if (paramChar1 == paramChar2) {
      return true;
    }
    if (paramChar1 == '-') {
      return false;
    }
    throw createIAE(paramString);
  }
  
  public final Mapping findMappingByName(String paramString)
  {
    Iterator localIterator = this.mMappings.iterator();
    Mapping localMapping;
    do
    {
      if (!localIterator.hasNext()) {
        return null;
      }
      localMapping = (Mapping)localIterator.next();
    } while (!localMapping.pathName.contains(paramString));
    return localMapping;
  }
  
  public final long[] getReadableMaps()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mMappings.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return getMergedIntervals(localArrayList);
      }
      Mapping localMapping = (Mapping)localIterator.next();
      if (localMapping.readable) {
        localArrayList.add(localMapping);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dalvik.MappingReader
 * JD-Core Version:    0.7.0.1
 */