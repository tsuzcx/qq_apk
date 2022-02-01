package com.tencent.upload.network.session.cache;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.task.UploadTask;
import com.tencent.upload.uinterface.IUploadConfig;

public class CacheUtil
{
  public static void cacheSessionId(UploadTask paramUploadTask, String paramString)
  {
    long l = UploadGlobalConfig.getConfig().getCurrentUin();
    Context localContext = UploadGlobalConfig.getContext();
    String str = paramUploadTask.getFilePath();
    if ((localContext != null) && (l != 0L) && (!TextUtils.isEmpty(str)))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      paramUploadTask = generateKey(str, paramUploadTask.flowId);
      new SessionDbHelper(localContext).insert(l, paramUploadTask, paramString);
    }
  }
  
  public static void clearAllCache()
  {
    long l = UploadGlobalConfig.getConfig().getCurrentUin();
    Context localContext = UploadGlobalConfig.getContext();
    if (localContext != null)
    {
      if (l == 0L) {
        return;
      }
      new SessionDbHelper(localContext).clearUserData(l);
    }
  }
  
  public static void deleteSessionId(UploadTask paramUploadTask, String paramString)
  {
    long l = UploadGlobalConfig.getConfig().getCurrentUin();
    Context localContext = UploadGlobalConfig.getContext();
    String str = paramUploadTask.getFilePath();
    if ((localContext != null) && (l != 0L) && (!TextUtils.isEmpty(str)))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      paramUploadTask = generateKey(str, paramUploadTask.flowId);
      new SessionDbHelper(localContext).delete(l, paramUploadTask, paramString);
    }
  }
  
  public static String generateKey(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(Math.abs(paramInt));
    return localStringBuilder.toString();
  }
  
  public static void setCachedSessionId(UploadTask paramUploadTask)
  {
    String str = paramUploadTask.getFilePath();
    long l = UploadGlobalConfig.getConfig().getCurrentUin();
    Object localObject = UploadGlobalConfig.getContext();
    if ((localObject != null) && (l != 0L))
    {
      if (TextUtils.isEmpty(str)) {
        return;
      }
      str = generateKey(str, paramUploadTask.flowId);
      localObject = new SessionDbHelper((Context)localObject).query(l, str);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramUploadTask.setSessionId((String)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.network.session.cache.CacheUtil
 * JD-Core Version:    0.7.0.1
 */