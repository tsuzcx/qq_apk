package com.tencent.mobileqq.qqgamepub.config;

import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class QQGamePreDownloadConfigBean
{
  public int a = 0;
  public int b = 0;
  public String c;
  public long d = -1L;
  public long e = -1L;
  public long f = -1L;
  
  public static QQGamePreDownloadConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    String str = "preDownloadNetType";
    Object localObject = "preDownloadSwitch";
    QQGamePreDownloadConfigBean localQQGamePreDownloadConfigBean = new QQGamePreDownloadConfigBean();
    for (;;)
    {
      int i;
      try
      {
        int j = paramArrayOfQConfItem.length;
        i = 0;
        if (i < j)
        {
          JSONObject localJSONObject = new JSONObject(paramArrayOfQConfItem[i].b);
          if (localJSONObject.has((String)localObject)) {
            localQQGamePreDownloadConfigBean.a = localJSONObject.optInt((String)localObject);
          }
          if (localJSONObject.has(str)) {
            localQQGamePreDownloadConfigBean.c = localJSONObject.optString(str);
          }
          if (!localJSONObject.has("cleanResFolderMaxSize")) {
            break label262;
          }
          localQQGamePreDownloadConfigBean.d = localJSONObject.optLong("cleanResFolderMaxSize", -1L);
          if (localJSONObject.has("cleanIntervalTime")) {
            localQQGamePreDownloadConfigBean.e = localJSONObject.optLong("cleanIntervalTime", -1L);
          }
          if (localJSONObject.has("checkIntervalTime")) {
            localQQGamePreDownloadConfigBean.f = localJSONObject.optLong("checkIntervalTime", -1L);
          }
          if (!localJSONObject.has("downOfflineSwitch")) {
            break label265;
          }
          localQQGamePreDownloadConfigBean.b = localJSONObject.optInt("downOfflineSwitch");
          break label265;
        }
        if (QLog.isColorLevel())
        {
          paramArrayOfQConfItem = new StringBuilder();
          paramArrayOfQConfItem.append("onParsed QQGamePreDownloadConfigBean=");
          paramArrayOfQConfItem.append(localQQGamePreDownloadConfigBean);
          QLog.d("QQGamePub_QQGamePreDownloadConfigBean", 2, paramArrayOfQConfItem.toString());
          return localQQGamePreDownloadConfigBean;
        }
      }
      catch (Throwable paramArrayOfQConfItem)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("parse error e=");
        ((StringBuilder)localObject).append(paramArrayOfQConfItem);
        QLog.e("QQGamePub_QQGamePreDownloadConfigBean", 1, ((StringBuilder)localObject).toString());
      }
      return localQQGamePreDownloadConfigBean;
      label262:
      continue;
      label265:
      i += 1;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQGamePreDownloadConfigBean{mPreDownloadSwitch=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mPreDownloadNetType='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mCleanResFolderMaxSize=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", mCleanIntervalTime=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", mCheckIntervalTime=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", mDownOfflineSwitch=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.config.QQGamePreDownloadConfigBean
 * JD-Core Version:    0.7.0.1
 */