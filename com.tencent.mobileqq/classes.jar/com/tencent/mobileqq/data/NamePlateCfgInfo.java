package com.tencent.mobileqq.data;

import MQQ.ItemCfgInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.JsonUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class NamePlateCfgInfo
{
  public long mNamePlateId;
  public int mVipType;
  
  public NamePlateCfgInfo() {}
  
  public NamePlateCfgInfo(int paramInt, long paramLong)
  {
    this.mVipType = paramInt;
    this.mNamePlateId = paramLong;
  }
  
  public static JSONObject converItem2JsonObject(ItemCfgInfo paramItemCfgInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QVIP.NamePlateCfgInfo", 2, "NamePlate converItem2JsonObject");
    }
    if (paramItemCfgInfo != null)
    {
      if (paramItemCfgInfo.itemJumUrl == null) {
        return null;
      }
      Object localObject = new JSONObject();
      try
      {
        HashMap localHashMap = new HashMap();
        Iterator localIterator = paramItemCfgInfo.itemJumUrl.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          localHashMap.put(String.valueOf(((Long)localEntry.getKey()).longValue()), localEntry.getValue());
        }
        ((JSONObject)localObject).put("vipType", paramItemCfgInfo.vipType);
        ((JSONObject)localObject).put("itemJumUrl", new JSONObject(localHashMap));
        return localObject;
      }
      catch (Exception paramItemCfgInfo)
      {
        paramItemCfgInfo.printStackTrace();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("converItem2JsonObject exception message = ");
        ((StringBuilder)localObject).append(paramItemCfgInfo.getMessage());
        QLog.e("QVIP.NamePlateCfgInfo", 1, ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  public static String convert2Json(ArrayList<ItemCfgInfo> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      JSONArray localJSONArray = new JSONArray();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        JSONObject localJSONObject = converItem2JsonObject((ItemCfgInfo)paramArrayList.next());
        if (localJSONObject != null) {
          localJSONArray.put(localJSONObject);
        }
      }
      return localJSONArray.toString();
    }
    return null;
  }
  
  public static String getCfgJumpUrl(int paramInt, long paramLong, String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getCfgJumpUrl type = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" nameplateId = ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" json = \n");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("QVIP.NamePlateCfgInfo", 2, ((StringBuilder)localObject).toString());
    }
    paramString = parseJsonArray2List(paramString);
    if (paramString == null) {
      return null;
    }
    Map.Entry localEntry;
    do
    {
      paramString = paramString.iterator();
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          do
          {
            if (!paramString.hasNext()) {
              break;
            }
            localObject = (ItemCfgInfo)paramString.next();
          } while ((localObject == null) || (((ItemCfgInfo)localObject).vipType != paramInt));
          localObject = ((ItemCfgInfo)localObject).itemJumUrl;
        } while (localObject == null);
        localObject = ((Map)localObject).entrySet().iterator();
      }
      localEntry = (Map.Entry)((Iterator)localObject).next();
    } while ((localEntry == null) || (localEntry.getKey() == null) || (((Long)localEntry.getKey()).longValue() != paramLong));
    return (String)localEntry.getValue();
    return null;
  }
  
  public static String getVipNamePlateCfgInfo(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.e(paramString);
      if (paramQQAppInterface != null) {
        return paramQQAppInterface.nameplateCfgInfo;
      }
    }
    return null;
  }
  
  public static String getVipNamePlateJumUrl(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QVIP.NamePlateCfgInfo", 2, "getVipNamePlateJumUrl");
    }
    paramQQAppInterface = getVipNamePlateCfgInfo(paramQQAppInterface, paramString);
    if (!TextUtils.isEmpty(paramQQAppInterface)) {
      return getCfgJumpUrl(paramInt, paramLong, paramQQAppInterface);
    }
    return null;
  }
  
  public static Map<Long, String> parseJson2Map(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = JsonUtil.a(paramString);
    if (localObject == null) {
      return null;
    }
    paramString = new HashMap(((Map)localObject).size());
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      if (localEntry != null) {
        paramString.put(Long.valueOf(Long.parseLong((String)localEntry.getKey())), (String)localEntry.getValue());
      }
    }
    return paramString;
  }
  
  public static ArrayList<ItemCfgInfo> parseJsonArray2List(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = new JSONArray(paramString);
      localObject1 = new ArrayList();
      int i = 0;
      while (i < paramString.length())
      {
        Object localObject2 = paramString.optJSONObject(i);
        if (localObject2 != null)
        {
          localObject2 = parseJsonObject2Item(((JSONObject)localObject2).toString());
          if (localObject2 != null) {
            ((ArrayList)localObject1).add(localObject2);
          }
        }
        i += 1;
      }
      return localObject1;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("parseJsonArray2List exception message = ");
      ((StringBuilder)localObject1).append(paramString.getMessage());
      QLog.e("QVIP.NamePlateCfgInfo", 1, ((StringBuilder)localObject1).toString());
    }
    return null;
  }
  
  public static ItemCfgInfo parseJsonObject2Item(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString);
      localObject = new ItemCfgInfo();
      ((ItemCfgInfo)localObject).vipType = paramString.optInt("vipType");
      ((ItemCfgInfo)localObject).itemJumUrl = parseJson2Map(paramString.optString("itemJumUrl"));
      return localObject;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parseJsonObject2Item exception message = ");
      ((StringBuilder)localObject).append(paramString.getMessage());
      QLog.e("QVIP.NamePlateCfgInfo", 1, ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  public static void vipNamePlateClickReport(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("NamePlate vipNamePlateClickReport namePlateId = ");
      localStringBuilder.append(paramLong);
      QLog.i("QVIP.NamePlateCfgInfo", 2, localStringBuilder.toString());
    }
    ReportController.b(paramQQAppInterface, "dc00898", "", "", "qq_vip", "0X800A59C", (int)paramLong, 0, "", "", "", "");
  }
  
  public static void vipNamePlateExposeReport(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (paramLong > 0L)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("NamePlate vipNamePlateExposeReport namePlateId = ");
        localStringBuilder.append(paramLong);
        QLog.i("QVIP.NamePlateCfgInfo", 2, localStringBuilder.toString());
      }
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "qq_vip", "0X800A59B", (int)paramLong, 0, "", "", "", "");
    }
  }
  
  public static void vipNamePlateExposeReport(QQAppInterface paramQQAppInterface, String paramString)
  {
    FriendsManager localFriendsManager = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localFriendsManager != null)
    {
      paramString = localFriendsManager.e(paramString);
      if (paramString != null)
      {
        l = paramString.bigClubTemplateId;
        break label39;
      }
    }
    long l = 0L;
    label39:
    vipNamePlateExposeReport(paramQQAppInterface, l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.NamePlateCfgInfo
 * JD-Core Version:    0.7.0.1
 */