package com.tencent.oskplayer.proxy;

import android.text.TextUtils;
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
      HashSet localHashSet = getTcDataId(paramString1);
      Object localObject = localHashSet;
      if (localHashSet == null) {
        localObject = new HashSet(10, 0.75F);
      }
      ((HashSet)localObject).add(paramString2);
      uuidTCIdMap.put(paramString1, localObject);
      playidUuidMap.put(paramString2, paramString1);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addPlayId uuid=");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", playId=");
      ((StringBuilder)localObject).append(paramString2);
      PlayerUtils.log(4, "UuidPlayIdMap", ((StringBuilder)localObject).toString());
      if (PlayerConfig.g().isDebugVersion())
      {
        paramString2 = new StringBuilder();
        paramString2.append("playIdListForUuid ");
        paramString2.append(paramString1);
        paramString2.append(" -> ");
        paramString2.append(getPlayIdListByUuid(paramString1));
        PlayerUtils.log(3, "UuidPlayIdMap", paramString2.toString());
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
    try
    {
      Object localObject = getTcDataId(paramString);
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
      else if (localObject == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("associate playid not exists, data cached? uuid=");
        ((StringBuilder)localObject).append(paramString);
        PlayerUtils.log(4, "UuidPlayIdMap", ((StringBuilder)localObject).toString());
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("deleteItem uuid=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramBoolean);
      PlayerUtils.log(4, "UuidPlayIdMap", ((StringBuilder)localObject).toString());
      deletedUuid.add(paramString);
      return;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public static String getPlayIdListByUuid(String paramString)
  {
    Object localObject2 = getTcDataId(paramString);
    paramString = "";
    Object localObject1 = paramString;
    if (localObject2 != null)
    {
      localObject2 = ((HashSet)localObject2).iterator();
      for (;;)
      {
        localObject1 = paramString;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = (String)((Iterator)localObject2).next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append((String)localObject1);
        paramString = localStringBuilder.toString();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(",");
        paramString = ((StringBuilder)localObject1).toString();
      }
    }
    return localObject1;
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
      HashSet localHashSet = deletedUuid;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append("");
      boolean bool = localHashSet.contains(getUuid(localStringBuilder.toString()));
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean isUuidDeleted(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        boolean bool = deletedUuid.contains(paramString);
        return bool;
      }
      PlayerUtils.log(6, "UuidPlayIdMap", "isUuidDeleted uuid is null");
      return true;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.oskplayer.proxy.UuidPlayIdMap
 * JD-Core Version:    0.7.0.1
 */