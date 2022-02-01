package com.tencent.mobileqq.qqgamepub.config;

import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class QQGamePreDownloadConfigBean
{
  public int a;
  public long a;
  public String a;
  public int b;
  public long b;
  public long c = -1L;
  
  public QQGamePreDownloadConfigBean()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_b_of_type_Long = -1L;
  }
  
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
          JSONObject localJSONObject = new JSONObject(paramArrayOfQConfItem[i].jdField_a_of_type_JavaLangString);
          if (localJSONObject.has((String)localObject)) {
            localQQGamePreDownloadConfigBean.jdField_a_of_type_Int = localJSONObject.optInt((String)localObject);
          }
          if (localJSONObject.has(str)) {
            localQQGamePreDownloadConfigBean.jdField_a_of_type_JavaLangString = localJSONObject.optString(str);
          }
          if (!localJSONObject.has("cleanResFolderMaxSize")) {
            break label262;
          }
          localQQGamePreDownloadConfigBean.jdField_a_of_type_Long = localJSONObject.optLong("cleanResFolderMaxSize", -1L);
          if (localJSONObject.has("cleanIntervalTime")) {
            localQQGamePreDownloadConfigBean.jdField_b_of_type_Long = localJSONObject.optLong("cleanIntervalTime", -1L);
          }
          if (localJSONObject.has("checkIntervalTime")) {
            localQQGamePreDownloadConfigBean.c = localJSONObject.optLong("checkIntervalTime", -1L);
          }
          if (!localJSONObject.has("downOfflineSwitch")) {
            break label265;
          }
          localQQGamePreDownloadConfigBean.jdField_b_of_type_Int = localJSONObject.optInt("downOfflineSwitch");
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
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", mPreDownloadNetType='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mCleanResFolderMaxSize=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", mCleanIntervalTime=");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append(", mCheckIntervalTime=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", mDownOfflineSwitch=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.config.QQGamePreDownloadConfigBean
 * JD-Core Version:    0.7.0.1
 */