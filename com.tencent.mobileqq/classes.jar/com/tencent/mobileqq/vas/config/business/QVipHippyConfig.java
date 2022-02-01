package com.tencent.mobileqq.vas.config.business;

import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.internal.LinkedTreeMap;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

@Keep
public class QVipHippyConfig
{
  private static final String TAG = "QVipHippyConfig";
  public LinkedTreeMap<String, QVipHippyConfig.HippyInfo> map;
  
  public QVipHippyConfig(@NonNull LinkedTreeMap<String, QVipHippyConfig.HippyInfo> paramLinkedTreeMap)
  {
    this.map = paramLinkedTreeMap;
  }
  
  public static boolean isCanOpenGxhHippyPage()
  {
    return isCanOpenHippyPage("qqgxh");
  }
  
  public static boolean isCanOpenHippyPage(String paramString)
  {
    Object localObject = QVipHippyProcessor.a().map;
    if ((!TextUtils.isEmpty(paramString)) && (localObject != null))
    {
      if (!((LinkedTreeMap)localObject).containsKey(paramString)) {
        return false;
      }
      paramString = (QVipHippyConfig.HippyInfo)((LinkedTreeMap)localObject).get(paramString);
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      return (paramString != null) && (paramString.enable == 1) && (isEnableUinSpace(paramString, (QQAppInterface)localObject));
    }
    return false;
  }
  
  public static boolean isCanOpenQQVipHippyPage()
  {
    return isCanOpenHippyPage("QQVip");
  }
  
  public static boolean isContainsModule(String paramString)
  {
    LinkedTreeMap localLinkedTreeMap = QVipHippyProcessor.a().map;
    return (!TextUtils.isEmpty(paramString)) && (localLinkedTreeMap != null) && (localLinkedTreeMap.containsKey(paramString));
  }
  
  public static boolean isEnableUin(QVipHippyConfig.HippyInfo paramHippyInfo, QQAppInterface paramQQAppInterface)
  {
    if (paramHippyInfo != null)
    {
      if (paramHippyInfo.enableUinList == null) {
        return false;
      }
      paramQQAppInterface = paramQQAppInterface.getCurrentUin();
      paramHippyInfo = paramHippyInfo.enableUinList;
      int j = paramHippyInfo.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramHippyInfo[i];
        if ((localObject != null) && (localObject.equals(paramQQAppInterface))) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public static boolean isEnableUinSpace(QVipHippyConfig.HippyInfo paramHippyInfo, QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = false;
    if (paramHippyInfo == null) {
      return false;
    }
    if (isEnableUin(paramHippyInfo, paramQQAppInterface)) {
      return true;
    }
    paramHippyInfo = paramHippyInfo.enableUinSpace;
    if (TextUtils.isEmpty(paramHippyInfo)) {
      return true;
    }
    try
    {
      paramHippyInfo = paramHippyInfo.split("-");
      boolean bool1 = bool2;
      if (paramHippyInfo.length == 2)
      {
        int i = Integer.parseInt(paramHippyInfo[0]);
        int j = Integer.parseInt(paramHippyInfo[1]);
        long l = paramQQAppInterface.getLongAccountUin() % 100L;
        bool1 = bool2;
        if (l >= i)
        {
          bool1 = bool2;
          if (l <= j) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    catch (Exception paramHippyInfo)
    {
      QLog.e("QVipHippyConfig", 2, paramHippyInfo, new Object[0]);
    }
    return false;
  }
  
  @Nullable
  public QVipHippyConfig.HippyInfo getHippyInfoFromKey(String paramString)
  {
    if (this.map.containsKey(paramString)) {
      return (QVipHippyConfig.HippyInfo)this.map.get(paramString);
    }
    return null;
  }
  
  public boolean isEnableGetAuth(String paramString1, String paramString2)
  {
    paramString1 = getHippyInfoFromKey(paramString1);
    if ((paramString1 != null) && (paramString1.enableDomain != null))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return false;
      }
      paramString1 = paramString1.enableDomain;
      int j = paramString1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString1[i];
        if ((localObject != null) && (localObject.equals(paramString2))) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.QVipHippyConfig
 * JD-Core Version:    0.7.0.1
 */