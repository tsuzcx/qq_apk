package com.tencent.oskplayer.proxy;

import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.util.PlayerUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class UuidPlayIdMap
{
  private static final String LOG_TAG = "UuidPlayIdMap";
  private static HashSet<String> deletedUuid = new HashSet(10, 0.75F);
  private static Map<String, String> playidUuidMap;
  private static Map<String, HashSet<String>> uuidTCIdMap = new HashMap(10, 0.75F);
  
  static
  {
    playidUuidMap = new HashMap(10, 0.75F);
  }
  
  public static void addPlayId(String paramString1, String paramString2)
  {
    try
    {
      HashSet localHashSet2 = getTcDataId(paramString1);
      HashSet localHashSet1 = localHashSet2;
      if (localHashSet2 == null) {
        localHashSet1 = new HashSet(10, 0.75F);
      }
      localHashSet1.add(paramString2);
      uuidTCIdMap.put(paramString1, localHashSet1);
      playidUuidMap.put(paramString2, paramString1);
      PlayerUtils.log(4, "UuidPlayIdMap", "addPlayId uuid=" + paramString1 + ", playId=" + paramString2);
      if (PlayerConfig.g().isDebugVersion()) {
        PlayerUtils.log(3, "UuidPlayIdMap", "playIdListForUuid " + paramString1 + " -> " + getPlayIdListByUuid(paramString1));
      }
      return;
    }
    finally {}
  }
  
  public static void deleteItem(String paramString)
  {
    try
    {
      deleteItem(paramString, false);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void deleteItem(String paramString, boolean paramBoolean)
  {
    Object localObject;
    try
    {
      localObject = getTcDataId(paramString);
      if ((localObject != null) && (paramBoolean))
      {
        localObject = ((HashSet)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          playidUuidMap.remove(str);
        }
        uuidTCIdMap.remove(paramString);
      }
    }
    finally {}
    for (;;)
    {
      PlayerUtils.log(4, "UuidPlayIdMap", "deleteItem uuid=" + paramString + "," + paramBoolean);
      deletedUuid.add(paramString);
      return;
      if (localObject == null) {
        PlayerUtils.log(4, "UuidPlayIdMap", "associate playid not exists, data cached? uuid=" + paramString);
      }
    }
  }
  
  public static String getPlayIdListByUuid(String paramString)
  {
    paramString = getTcDataId(paramString);
    if (paramString != null)
    {
      Iterator localIterator = paramString.iterator();
      for (paramString = "";; paramString = paramString + ",")
      {
        str = paramString;
        if (!localIterator.hasNext()) {
          break;
        }
        str = (String)localIterator.next();
        paramString = paramString + str;
      }
    }
    String str = "";
    return str;
  }
  
  public static HashSet<String> getTcDataId(String paramString)
  {
    try
    {
      paramString = (HashSet)uuidTCIdMap.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static String getUuid(String paramString)
  {
    try
    {
      paramString = (String)playidUuidMap.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static boolean isTcPlayIdShouldStopped(int paramInt)
  {
    try
    {
      boolean bool = deletedUuid.contains(getUuid(paramInt + ""));
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public static boolean isUuidDeleted(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifne +16 -> 23
    //   10: getstatic 34	com/tencent/oskplayer/proxy/UuidPlayIdMap:deletedUuid	Ljava/util/HashSet;
    //   13: aload_0
    //   14: invokevirtual 143	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   17: istore_1
    //   18: ldc 2
    //   20: monitorexit
    //   21: iload_1
    //   22: ireturn
    //   23: bipush 6
    //   25: ldc 8
    //   27: ldc 153
    //   29: invokestatic 74	com/tencent/oskplayer/util/PlayerUtils:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   32: iconst_1
    //   33: istore_1
    //   34: goto -16 -> 18
    //   37: astore_0
    //   38: ldc 2
    //   40: monitorexit
    //   41: aload_0
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	paramString	String
    //   17	17	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	18	37	finally
    //   23	32	37	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.oskplayer.proxy.UuidPlayIdMap
 * JD-Core Version:    0.7.0.1
 */