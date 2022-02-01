package com.tencent.mobileqq.qqgamepub.api.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.commonsdk.util.MD5Coding;
import com.tencent.mobileqq.ark.api.IArkHelper;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqgamepub.api.IQQGamePreDownloadService;
import com.tencent.mobileqq.qqgamepub.api.IQQGameResService;
import com.tencent.mobileqq.qqgamepub.config.QQGamePreDownloadConfigBean;
import com.tencent.mobileqq.qqgamepub.data.QQGameResInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadScheduleUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class QQGameResServiceImpl
  implements IQQGameResService
{
  private static final String KEY_ARK_RES_FILE_NAME = "url_res_file_name";
  private static final String KEY_CHECK_SURPLUS_RES_LAST_TIME = "check_surplus_res_time";
  private static final String KEY_RES_URL_DONETIME = "url_doneTime";
  private static final String KEY_RES_URL_LAST_USE_TIME = "url_last_use_time";
  private static final String KEY_RES_URL_MD5 = "url_md5";
  private static final long SIZE_TO_REMOVE_SURPLUS_RES = 104857600L;
  public static final String SP_QQ_GAME_RES_PRELOAD = "sp_qq_game_res_preload";
  private static final String TAG = "QQGamePub_QQGameResApiImpl";
  private static final long TIME_INTERVAL_TO_REMOVE_SURPLUS_RES = 1296000000L;
  private static final long TIME_INTERVAL_VALID_TO_CHECK = 86400000L;
  
  public static long getLastCheckSurplusTime(int paramInt)
  {
    return getPreference(paramInt).getLong("check_surplus_res_time", 0L);
  }
  
  public static long getLastUseTime(String paramString, long paramLong, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      SharedPreferences localSharedPreferences = getPreference(paramInt);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("url_last_use_time");
      localStringBuilder.append(paramString);
      return localSharedPreferences.getLong(localStringBuilder.toString(), paramLong);
    }
    return paramLong;
  }
  
  public static SharedPreferences getPreference(int paramInt)
  {
    if (paramInt == 1) {
      return BaseApplication.getContext().getSharedPreferences("sp_qq_game_res_preloadinner", 4);
    }
    return BaseApplication.getContext().getSharedPreferences("sp_qq_game_res_preload", 4);
  }
  
  public static List<QQGameResServiceImpl.ResTimeInfo> getResTimeInfoList(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = getPreference(paramInt).getAll().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = (String)localEntry.getKey();
      if (str.startsWith("url_last_use_time")) {
        localArrayList.add(new QQGameResServiceImpl.ResTimeInfo(str.substring(17, str.length()), ((Long)localEntry.getValue()).longValue(), paramInt));
      }
    }
    return localArrayList;
  }
  
  public static void updateCheckSurplusTime(long paramLong, int paramInt)
  {
    getPreference(paramInt).edit().putLong("check_surplus_res_time", paramLong).apply();
  }
  
  public static void updateLastUseTime(String paramString, int paramInt, long paramLong)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      SharedPreferences.Editor localEditor = getPreference(paramInt).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("url_last_use_time");
      localStringBuilder.append(paramString);
      localEditor.putLong(localStringBuilder.toString(), paramLong).apply();
    }
  }
  
  public static void updateUrlMd5(String paramString1, String paramString2, int paramInt)
  {
    Object localObject = getPreference(paramInt);
    if ((localObject != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      localObject = ((SharedPreferences)localObject).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("url_md5");
      localStringBuilder.append(paramString1);
      ((SharedPreferences.Editor)localObject).putString(localStringBuilder.toString(), paramString2).apply();
    }
  }
  
  public boolean IsOnlySupportInnerFilePos()
  {
    boolean bool;
    try
    {
      bool = "mounted".equals(Environment.getExternalStorageState());
    }
    catch (Exception localException)
    {
      QLog.e("QQGamePub_QQGameResApiImpl", 1, localException, new Object[0]);
      bool = false;
    }
    return !bool;
  }
  
  public void checkAndCleanExpireCache(int paramInt)
  {
    try
    {
      Object localObject1 = ((IQQGamePreDownloadService)QRoute.api(IQQGamePreDownloadService.class)).getConfig();
      long l1;
      if (((QQGamePreDownloadConfigBean)localObject1).c < 0L) {
        l1 = 86400000L;
      } else {
        l1 = ((QQGamePreDownloadConfigBean)localObject1).c;
      }
      long l3 = NetConnInfoCenter.getServerTimeMillis();
      if (l3 - getLastCheckSurplusTime(paramInt) < l1)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("removeSurplusRes already Check ，checkIntervalTime：");
        ((StringBuilder)localObject1).append(l1);
        QLog.d("QQGamePub_QQGameResApiImpl", 2, ((StringBuilder)localObject1).toString());
        return;
      }
      long l4 = FileUtils.getFileOrFolderSize(getResPathPrefix(paramInt));
      if (((QQGamePreDownloadConfigBean)localObject1).jdField_a_of_type_Long < 0L) {
        l1 = 104857600L;
      } else {
        l1 = ((QQGamePreDownloadConfigBean)localObject1).jdField_a_of_type_Long;
      }
      long l2;
      if (((QQGamePreDownloadConfigBean)localObject1).b < 0L) {
        l2 = 1296000000L;
      } else {
        l2 = ((QQGamePreDownloadConfigBean)localObject1).b;
      }
      if (l4 > l1)
      {
        localObject1 = getResTimeInfoList(paramInt).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (QQGameResServiceImpl.ResTimeInfo)((Iterator)localObject1).next();
          if (localObject2 != null)
          {
            String str = ((QQGameResServiceImpl.ResTimeInfo)localObject2).jdField_a_of_type_JavaLangString;
            if ((!TextUtils.isEmpty(str)) && (l3 - ((QQGameResServiceImpl.ResTimeInfo)localObject2).jdField_a_of_type_Long > l2))
            {
              QQGameResInfo localQQGameResInfo = getResInfoByUrl(str, ((QQGameResServiceImpl.ResTimeInfo)localObject2).jdField_a_of_type_Int);
              removeResInfo(str, ((QQGameResServiceImpl.ResTimeInfo)localObject2).jdField_a_of_type_Int);
              deleteFile(localQQGameResInfo.filePath);
              deleteFile(localQQGameResInfo.folderPath);
              deleteArkResRecordAndFile(str);
              if (QLog.isColorLevel())
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("checkAndCleanExpireCache: remove res url:");
                ((StringBuilder)localObject2).append(str);
                ((StringBuilder)localObject2).append(",filePath:");
                ((StringBuilder)localObject2).append(localQQGameResInfo.filePath);
                QLog.d("QQGamePub_QQGameResApiImpl", 2, ((StringBuilder)localObject2).toString());
              }
            }
          }
        }
      }
      updateCheckSurplusTime(l3, paramInt);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("checkAndCleanExpireCache:resFolderPathSize:");
        ((StringBuilder)localObject1).append(l4);
        ((StringBuilder)localObject1).append(",cleanResFolderMaxSize:");
        ((StringBuilder)localObject1).append(l1);
        ((StringBuilder)localObject1).append(",cleanIntervalTime:");
        ((StringBuilder)localObject1).append(l2);
        ((StringBuilder)localObject1).append(",cost:");
        ((StringBuilder)localObject1).append(NetConnInfoCenter.getServerTimeMillis() - l3);
        QLog.d("QQGamePub_QQGameResApiImpl", 2, ((StringBuilder)localObject1).toString());
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQGamePub_QQGameResApiImpl", 1, localThrowable, new Object[0]);
    }
    return;
  }
  
  public void deleteArkResRecordAndFile(String paramString)
  {
    Object localObject = getPreference(1);
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject).edit();
    localObject = ((SharedPreferences)localObject).getAll().entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Map.Entry)((Iterator)localObject).next()).getKey();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("url_res_file_name");
      localStringBuilder.append(paramString);
      if (str.contains(localStringBuilder.toString()))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("url_res_file_name");
        localStringBuilder.append(paramString);
        deleteFile(getArkResRecordPath(str.replace(localStringBuilder.toString(), ""), paramString));
        localEditor.remove(str);
      }
    }
    localEditor.apply();
  }
  
  public void deleteFile(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        FileUtils.delete(paramString, false);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("delete file:");
          localStringBuilder.append(paramString);
          QLog.d("QQGamePub_QQGameResApiImpl", 2, localStringBuilder.toString());
          return;
        }
      }
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public String getActivityDSL(String paramString, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("https://youxi.gamecenter.qq.com/dsl/");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(".json");
    localObject = getResPathByUrl(((StringBuilder)localObject).toString(), 0);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      return FileUtils.readFileContent(new File((String)localObject));
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getActivityDSL...activityId:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",");
      QLog.i("QQGamePub_QQGameResApiImpl", 2, ((StringBuilder)localObject).toString());
    }
    return "";
  }
  
  public String getArkResRecordName(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return "";
      }
      SharedPreferences localSharedPreferences = getPreference(1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("url_res_file_name");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(paramString1);
      return localSharedPreferences.getString(localStringBuilder.toString(), "");
    }
    return "";
  }
  
  public String getArkResRecordPath(String paramString1, String paramString2)
  {
    paramString2 = ((IQQGameResService)QRoute.api(IQQGameResService.class)).getArkResRecordName(paramString1, paramString2);
    if (!TextUtils.isEmpty(paramString2)) {
      return ((IArkHelper)QRoute.api(IArkHelper.class)).getCacheResPath(paramString1, paramString2);
    }
    return "";
  }
  
  public String getFilePath(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = MD5.toMD5(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getResPathPrefix(paramInt));
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public String getRealMd5(String paramString1, String paramString2, int paramInt)
  {
    String str2 = getResRecordMd5(paramString1, "", paramInt);
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
          updateUrlMd5(paramString1, str1, paramInt);
        }
      }
    }
    return str1;
  }
  
  public QQGameResInfo getResInfoByUrl(String paramString, int paramInt)
  {
    QQGameResInfo localQQGameResInfo = new QQGameResInfo();
    localQQGameResInfo.url = paramString;
    String str = getResPathByUrl(paramString, paramInt);
    if (!TextUtils.isEmpty(str))
    {
      localQQGameResInfo.filePath = str;
      localQQGameResInfo.fileMd5 = getRealMd5(paramString, str, paramInt);
      localQQGameResInfo.doneTime = getUrlDoneTime(paramString, 0L, paramInt);
    }
    return localQQGameResInfo;
  }
  
  public String getResPathByUrl(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      String str = getFilePath(paramString, paramInt);
      if ((!TextUtils.isEmpty(str)) && (new File(str).exists()))
      {
        updateLastUseTime(paramString, paramInt, NetConnInfoCenter.getServerTimeMillis());
        return str;
      }
    }
    return null;
  }
  
  public String getResPathPrefix(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(PreDownloadScheduleUtil.getPreDownloadPathStatic("qqgame_pubaccount", "sed", bool));
    localStringBuilder.append("/");
    return localStringBuilder.toString();
  }
  
  public String getResRealMd5(String paramString)
  {
    return MD5Coding.encodeFile2HexStr(paramString);
  }
  
  public String getResRecordMd5(String paramString1, String paramString2, int paramInt)
  {
    SharedPreferences localSharedPreferences = getPreference(paramInt);
    if ((localSharedPreferences != null) && (!TextUtils.isEmpty(paramString1)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("url_md5");
      localStringBuilder.append(paramString1);
      return localSharedPreferences.getString(localStringBuilder.toString(), paramString2);
    }
    return paramString2;
  }
  
  public long getUrlDoneTime(String paramString, long paramLong, int paramInt)
  {
    SharedPreferences localSharedPreferences = getPreference(paramInt);
    if ((localSharedPreferences != null) && (!TextUtils.isEmpty(paramString)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("url_doneTime");
      localStringBuilder.append(paramString);
      return localSharedPreferences.getLong(localStringBuilder.toString(), paramLong);
    }
    return paramLong;
  }
  
  public void removeResInfo(String paramString, int paramInt)
  {
    Object localObject = getPreference(paramInt);
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = ((SharedPreferences)localObject).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("url_doneTime");
      localStringBuilder.append(paramString);
      ((SharedPreferences.Editor)localObject).remove(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("url_md5");
      localStringBuilder.append(paramString);
      ((SharedPreferences.Editor)localObject).remove(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("url_last_use_time");
      localStringBuilder.append(paramString);
      ((SharedPreferences.Editor)localObject).remove(localStringBuilder.toString()).apply();
    }
  }
  
  public void saveArkResPreloadName(String paramString1, String paramString2, String paramString3)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (TextUtils.isEmpty(paramString3)) {
        return;
      }
      SharedPreferences.Editor localEditor = getPreference(1).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("url_res_file_name");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(paramString1);
      localEditor.putString(localStringBuilder.toString(), paramString3).apply();
    }
  }
  
  public void updateResInfo(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    updateUrlMd5(paramString1, paramString2, paramInt);
    updateUrlDoneTime(paramString1, paramLong, paramInt);
    updateLastUseTime(paramString1, paramInt, NetConnInfoCenter.getServerTimeMillis());
  }
  
  public void updateUrlDoneTime(String paramString, long paramLong, int paramInt)
  {
    Object localObject = getPreference(paramInt);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.impl.QQGameResServiceImpl
 * JD-Core Version:    0.7.0.1
 */