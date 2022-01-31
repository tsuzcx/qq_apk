package com.tencent.mobileqq.dalvik;

import java.io.File;
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
    return new IllegalArgumentException("Invalid /proc/self/maps line: '" + paramString + "'");
  }
  
  /* Error */
  private void getMapsFromFile(File paramFile)
  {
    // Byte code:
    //   0: new 50	java/io/FileReader
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 52	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   8: astore_1
    //   9: new 54	java/io/BufferedReader
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 57	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   17: astore_2
    //   18: new 13	java/util/ArrayList
    //   21: dup
    //   22: invokespecial 14	java/util/ArrayList:<init>	()V
    //   25: astore_3
    //   26: aload_2
    //   27: invokevirtual 60	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   30: astore 4
    //   32: aload 4
    //   34: ifnonnull +22 -> 56
    //   37: aload_3
    //   38: invokeinterface 66 1 0
    //   43: ifle +8 -> 51
    //   46: aload_0
    //   47: aload_3
    //   48: invokespecial 70	com/tencent/mobileqq/dalvik/MappingReader:getMapsFromMapLines	(Ljava/util/List;)V
    //   51: aload_1
    //   52: invokevirtual 73	java/io/FileReader:close	()V
    //   55: return
    //   56: aload_3
    //   57: aload 4
    //   59: invokeinterface 77 2 0
    //   64: pop
    //   65: goto -39 -> 26
    //   68: astore_2
    //   69: aload_1
    //   70: invokevirtual 73	java/io/FileReader:close	()V
    //   73: aload_2
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	MappingReader
    //   0	75	1	paramFile	File
    //   17	10	2	localBufferedReader	java.io.BufferedReader
    //   68	6	2	localObject	Object
    //   25	32	3	localArrayList	ArrayList
    //   30	28	4	str	String
    // Exception table:
    //   from	to	target	type
    //   9	26	68	finally
    //   26	32	68	finally
    //   37	51	68	finally
    //   56	65	68	finally
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
    long l1 = -1L;
    int i;
    if (!paramList.hasNext())
    {
      if (l2 != -1L)
      {
        localArrayList.add(Long.valueOf(l2));
        localArrayList.add(Long.valueOf(l1));
      }
      paramList = new long[localArrayList.size()];
      i = 0;
    }
    for (;;)
    {
      if (i >= localArrayList.size())
      {
        return paramList;
        Mapping localMapping = (Mapping)paramList.next();
        if (l2 == -1L)
        {
          l2 = localMapping.beginAddr;
          l1 = localMapping.endAddr;
          break;
        }
        if (localMapping.beginAddr == l1)
        {
          l1 = localMapping.endAddr;
          break;
        }
        localArrayList.add(Long.valueOf(l2));
        localArrayList.add(Long.valueOf(l1));
        l2 = localMapping.beginAddr;
        l1 = localMapping.endAddr;
        break;
      }
      paramList[i] = ((Long)localArrayList.get(i)).longValue();
      i += 1;
    }
  }
  
  private Mapping getRwMap(String paramString)
  {
    String[] arrayOfString1 = paramString.split(" +", 6);
    if (arrayOfString1.length != 6) {
      throw createIAE(paramString);
    }
    String[] arrayOfString2 = arrayOfString1[0].split("-");
    if (arrayOfString2.length != 2) {
      throw createIAE(paramString);
    }
    long l1;
    long l2;
    try
    {
      l1 = Long.parseLong(arrayOfString2[0], 16);
      l2 = Long.parseLong(arrayOfString2[1], 16);
      if (arrayOfString1[1].length() != 4) {
        throw createIAE(paramString);
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw createIAE(paramString);
    }
    boolean bool1 = isEquals(localNumberFormatException[1].charAt(0), 'r', paramString);
    boolean bool2 = isEquals(localNumberFormatException[1].charAt(1), 'w', paramString);
    localNumberFormatException[1].charAt(3);
    return new Mapping(l1, l2, bool1, bool2, true, localNumberFormatException[5]);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.dalvik.MappingReader
 * JD-Core Version:    0.7.0.1
 */