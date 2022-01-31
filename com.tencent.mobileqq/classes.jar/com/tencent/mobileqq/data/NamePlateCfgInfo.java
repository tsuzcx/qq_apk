package com.tencent.mobileqq.data;

import MQQ.ItemCfgInfo;
import ajxl;
import android.text.TextUtils;
import axqy;
import bhye;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
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
    if ((paramItemCfgInfo == null) || (paramItemCfgInfo.itemJumUrl == null)) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    HashMap localHashMap;
    try
    {
      localHashMap = new HashMap();
      Iterator localIterator = paramItemCfgInfo.itemJumUrl.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localHashMap.put(String.valueOf(((Long)localEntry.getKey()).longValue()), localEntry.getValue());
      }
      localJSONObject.put("vipType", paramItemCfgInfo.vipType);
    }
    catch (Exception paramItemCfgInfo)
    {
      paramItemCfgInfo.printStackTrace();
      QLog.e("QVIP.NamePlateCfgInfo", 1, "converItem2JsonObject exception message = " + paramItemCfgInfo.getMessage());
      return null;
    }
    localJSONObject.put("itemJumUrl", new JSONObject(localHashMap));
    return localJSONObject;
  }
  
  public static String convert2Json(ArrayList<ItemCfgInfo> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return null;
    }
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
  
  public static String getCfgJumpUrl(int paramInt, long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QVIP.NamePlateCfgInfo", 2, "getCfgJumpUrl type = " + paramInt + " nameplateId = " + paramLong + " json = \n" + paramString);
    }
    paramString = parseJsonArray2List(paramString);
    if (paramString == null) {
      return null;
    }
    Map.Entry localEntry;
    do
    {
      paramString = paramString.iterator();
      Object localObject;
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
    paramQQAppInterface = (ajxl)paramQQAppInterface.getManager(51);
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
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      localObject = bhye.a(paramString);
    } while (localObject == null);
    paramString = new HashMap(((Map)localObject).size());
    Object localObject = ((Map)localObject).entrySet().iterator();
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
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramString.length())
      {
        Object localObject = paramString.optJSONObject(i);
        if (localObject != null)
        {
          localObject = parseJsonObject2Item(((JSONObject)localObject).toString());
          if (localObject != null) {
            localArrayList.add(localObject);
          }
        }
        i += 1;
      }
      return localArrayList;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      QLog.e("QVIP.NamePlateCfgInfo", 1, "parseJsonArray2List exception message = " + paramString.getMessage());
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
      ItemCfgInfo localItemCfgInfo = new ItemCfgInfo();
      localItemCfgInfo.vipType = paramString.optInt("vipType");
      localItemCfgInfo.itemJumUrl = parseJson2Map(paramString.optString("itemJumUrl"));
      return localItemCfgInfo;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      QLog.e("QVIP.NamePlateCfgInfo", 1, "parseJsonObject2Item exception message = " + paramString.getMessage());
    }
    return null;
  }
  
  public static void vipNamePlateClickReport(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QVIP.NamePlateCfgInfo", 2, "NamePlate vipNamePlateClickReport namePlateId = " + paramLong);
    }
    axqy.b(paramQQAppInterface, "dc00898", "", "", "qq_vip", "0X800A59C", (int)paramLong, 0, "", "", "", "");
  }
  
  public static void vipNamePlateExposeReport(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (paramLong > 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QVIP.NamePlateCfgInfo", 2, "NamePlate vipNamePlateExposeReport namePlateId = " + paramLong);
      }
      axqy.b(paramQQAppInterface, "dc00898", "", "", "qq_vip", "0X800A59B", (int)paramLong, 0, "", "", "", "");
    }
  }
  
  public static void vipNamePlateExposeReport(QQAppInterface paramQQAppInterface, String paramString)
  {
    ajxl localajxl = (ajxl)paramQQAppInterface.getManager(51);
    if (localajxl != null)
    {
      paramString = localajxl.e(paramString);
      if (paramString == null) {}
    }
    for (long l = paramString.bigClubTemplateId;; l = 0L)
    {
      vipNamePlateExposeReport(paramQQAppInterface, l);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.NamePlateCfgInfo
 * JD-Core Version:    0.7.0.1
 */