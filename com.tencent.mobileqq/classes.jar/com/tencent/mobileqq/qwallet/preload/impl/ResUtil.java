package com.tencent.mobileqq.qwallet.preload.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.commonsdk.util.MD5Coding;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import com.tencent.mobileqq.qwallet.preload.PreloadStaticApi;
import com.tencent.mobileqq.qwallet.preload.ResourceInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.MobileQQ;

public class ResUtil
{
  public static int a(String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = a(paramInt);
    if ((localSharedPreferences != null) && (!TextUtils.isEmpty(paramString)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("url_abnormal_retry_times");
      localStringBuilder.append(paramString);
      return localSharedPreferences.getInt(localStringBuilder.toString(), 0);
    }
    return 0;
  }
  
  public static long a(int paramInt)
  {
    SharedPreferences localSharedPreferences = a(paramInt);
    long l = 0L;
    if (localSharedPreferences != null) {
      l = localSharedPreferences.getLong("check_surplus_res_time", 0L);
    }
    return l;
  }
  
  public static long a(String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = a(paramInt);
    if ((localSharedPreferences != null) && (!TextUtils.isEmpty(paramString)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("url_abnormal_retry_last_time");
      localStringBuilder.append(paramString);
      return localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
    }
    return 0L;
  }
  
  public static long a(String paramString, long paramLong, int paramInt)
  {
    SharedPreferences localSharedPreferences = a(paramInt);
    if ((localSharedPreferences != null) && (!TextUtils.isEmpty(paramString)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("url_doneTime");
      localStringBuilder.append(paramString);
      return localSharedPreferences.getLong(localStringBuilder.toString(), paramLong);
    }
    return paramLong;
  }
  
  private static SharedPreferences a(int paramInt)
  {
    if (MobileQQ.sMobileQQ != null)
    {
      if (paramInt == 1) {
        return MobileQQ.sMobileQQ.getSharedPreferences("qwallet_res_utilinner", 4);
      }
      return MobileQQ.sMobileQQ.getSharedPreferences("qwallet_res_util", 4);
    }
    return null;
  }
  
  public static ResourceInfo a(String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    ResourceInfo localResourceInfo = new ResourceInfo();
    localResourceInfo.url = paramString;
    String str = PreloadStaticApi.a(paramString, paramInt2);
    if (!TextUtils.isEmpty(str))
    {
      localResourceInfo.filePath = str;
      localResourceInfo.fileMd5 = b(paramString, str, paramInt2);
      localResourceInfo.doneTime = a(paramString, 0L, paramInt2);
      if ((paramBoolean) || (PreloadStaticApi.a(paramString, paramInt1)))
      {
        paramString = PreloadResourceImpl.getFolderPathByMD5AndUrl(localResourceInfo.fileMd5, paramString, paramInt2);
        if (PreloadResourceImpl.checkFolderAndUnzip(localResourceInfo.filePath, paramString)) {
          localResourceInfo.folderPath = paramString;
        }
      }
    }
    return localResourceInfo;
  }
  
  public static String a(String paramString1, String paramString2, int paramInt)
  {
    SharedPreferences localSharedPreferences = a(paramInt);
    if ((localSharedPreferences != null) && (!TextUtils.isEmpty(paramString1)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("url_md5");
      localStringBuilder.append(paramString1);
      return localSharedPreferences.getString(localStringBuilder.toString(), paramString2);
    }
    return paramString2;
  }
  
  public static List<ResUtil.ResTimeInfo> a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = a(paramInt);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).getAll().entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        String str = (String)localEntry.getKey();
        if (str.startsWith("url_last_use_time")) {
          localArrayList.add(new ResUtil.ResTimeInfo(str.substring(17, str.length()), ((Long)localEntry.getValue()).longValue(), paramInt));
        }
      }
    }
    return localArrayList;
  }
  
  public static void a(int paramInt, PreloadConfig paramPreloadConfig)
  {
    if (paramPreloadConfig == null) {
      return;
    }
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    if (l1 - a(paramInt) < 86400000L)
    {
      if (QLog.isColorLevel())
      {
        paramPreloadConfig = new StringBuilder();
        paramPreloadConfig.append("removeSurplusRes already Check Today:");
        paramPreloadConfig.append(paramInt);
        QLog.d("ResUtil", 2, paramPreloadConfig.toString());
      }
      return;
    }
    Object localObject = PreloadStaticApi.a(paramInt);
    long l2 = System.currentTimeMillis();
    long l3 = FileUtils.getFileOrFolderSize((String)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("resFolderPathSize:");
      ((StringBuilder)localObject).append(l3);
      ((StringBuilder)localObject).append("|");
      ((StringBuilder)localObject).append(209715200L);
      ((StringBuilder)localObject).append("|");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - l2);
      QLog.d("ResUtil", 2, ((StringBuilder)localObject).toString());
    }
    if (l3 > 209715200L)
    {
      localObject = a(paramInt).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ResUtil.ResTimeInfo localResTimeInfo = (ResUtil.ResTimeInfo)((Iterator)localObject).next();
        if ((localResTimeInfo != null) && (!TextUtils.isEmpty(localResTimeInfo.jdField_a_of_type_JavaLangString)) && (l1 - localResTimeInfo.jdField_a_of_type_Long > 2592000000L) && (!paramPreloadConfig.isUrlInConfig(localResTimeInfo.jdField_a_of_type_JavaLangString)))
        {
          ResourceInfo localResourceInfo = a(localResTimeInfo.jdField_a_of_type_JavaLangString, false, 0, localResTimeInfo.jdField_a_of_type_Int);
          if (localResourceInfo != null)
          {
            b(localResTimeInfo.jdField_a_of_type_JavaLangString, localResTimeInfo.jdField_a_of_type_Int);
            QWalletTools.a(localResourceInfo.filePath);
            QWalletTools.a(localResourceInfo.folderPath);
            ResDownRecordUtil.a(localResTimeInfo.jdField_a_of_type_JavaLangString, 8, localResTimeInfo.jdField_a_of_type_Int);
          }
        }
      }
    }
    a(l1, paramInt);
  }
  
  public static void a(long paramLong, int paramInt)
  {
    SharedPreferences localSharedPreferences = a(paramInt);
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putLong("check_surplus_res_time", paramLong).apply();
    }
  }
  
  public static void a(String paramString, int paramInt)
  {
    int i = a(paramString, paramInt);
    Object localObject = a(paramInt);
    if ((localObject != null) && (!TextUtils.isEmpty(paramString)))
    {
      localObject = ((SharedPreferences)localObject).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("url_abnormal_retry_times");
      localStringBuilder.append(paramString);
      localObject = ((SharedPreferences.Editor)localObject).putInt(localStringBuilder.toString(), i + 1);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("url_abnormal_retry_last_time");
      localStringBuilder.append(paramString);
      ((SharedPreferences.Editor)localObject).putLong(localStringBuilder.toString(), NetConnInfoCenter.getServerTimeMillis()).apply();
    }
  }
  
  public static void a(String paramString, int paramInt, long paramLong)
  {
    Object localObject = a(paramInt);
    if ((localObject != null) && (!TextUtils.isEmpty(paramString)))
    {
      localObject = ((SharedPreferences)localObject).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("url_last_use_time");
      localStringBuilder.append(paramString);
      ((SharedPreferences.Editor)localObject).putLong(localStringBuilder.toString(), paramLong).apply();
    }
  }
  
  public static void a(String paramString, long paramLong, int paramInt)
  {
    Object localObject = a(paramInt);
    if (localObject != null) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (((true ^ TextUtils.isEmpty(paramString)) & paramInt))
    {
      localObject = ((SharedPreferences)localObject).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("url_doneTime");
      localStringBuilder.append(paramString);
      ((SharedPreferences.Editor)localObject).putLong(localStringBuilder.toString(), paramLong).apply();
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt)
  {
    Object localObject = a(paramInt);
    if ((localObject != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      localObject = ((SharedPreferences)localObject).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("url_md5");
      localStringBuilder.append(paramString1);
      ((SharedPreferences.Editor)localObject).putString(localStringBuilder.toString(), paramString2).apply();
    }
  }
  
  public static void a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    a(paramString1, paramString2, paramInt);
    a(paramString1, paramLong, paramInt);
    a(paramString1, paramInt, NetConnInfoCenter.getServerTimeMillis());
  }
  
  public static String b(String paramString1, String paramString2, int paramInt)
  {
    String str2 = a(paramString1, "", paramInt);
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (!TextUtils.isEmpty(paramString2))
      {
        str1 = str2;
        if (new File(paramString2).exists())
        {
          str1 = MD5Coding.encodeFile2HexStr(paramString2);
          a(paramString1, str1, paramInt);
        }
      }
    }
    return str1;
  }
  
  public static void b(String paramString, int paramInt)
  {
    Object localObject1 = a(paramInt);
    if ((localObject1 != null) && (!TextUtils.isEmpty(paramString)))
    {
      Object localObject2 = ((SharedPreferences)localObject1).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("url_doneTime");
      localStringBuilder.append(paramString);
      ((SharedPreferences.Editor)localObject2).remove(localStringBuilder.toString());
      localObject2 = ((SharedPreferences)localObject1).edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("url_md5");
      localStringBuilder.append(paramString);
      ((SharedPreferences.Editor)localObject2).remove(localStringBuilder.toString());
      localObject2 = ((SharedPreferences)localObject1).edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("url_last_use_time");
      localStringBuilder.append(paramString);
      ((SharedPreferences.Editor)localObject2).remove(localStringBuilder.toString());
      localObject1 = ((SharedPreferences)localObject1).edit();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("url_abnormal_retry_times");
      ((StringBuilder)localObject2).append(paramString);
      ((SharedPreferences.Editor)localObject1).remove(((StringBuilder)localObject2).toString()).apply();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.ResUtil
 * JD-Core Version:    0.7.0.1
 */