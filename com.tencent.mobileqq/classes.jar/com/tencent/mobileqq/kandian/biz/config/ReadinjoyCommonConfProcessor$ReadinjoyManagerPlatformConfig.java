package com.tencent.mobileqq.kandian.biz.config;

import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class ReadinjoyCommonConfProcessor$ReadinjoyManagerPlatformConfig
{
  public void a(QConfItem[] paramArrayOfQConfItem)
  {
    if (paramArrayOfQConfItem != null) {}
    for (;;)
    {
      try
      {
        if (paramArrayOfQConfItem.length > 0)
        {
          i = 0;
          if (i >= paramArrayOfQConfItem.length) {
            continue;
          }
          if (TextUtils.isEmpty(paramArrayOfQConfItem[i].a))
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("receive empty config content, skip ! index : ");
            localStringBuilder.append(i);
            QLog.e("ReadinjoyCommonConfProcessor", 1, localStringBuilder.toString());
            continue;
          }
          new RIJCommonConfigHandler().a(paramArrayOfQConfItem[i]);
          continue;
        }
        QLog.d("ReadinjoyCommonConfProcessor", 1, "receiveAllConfigs|type: 92,content_list is empty ");
        return;
      }
      catch (Exception localException)
      {
        int i;
        StringBuilder localStringBuilder;
        continue;
      }
      if (QLog.isColorLevel())
      {
        paramArrayOfQConfItem = new StringBuilder();
        paramArrayOfQConfItem.append("received readinjoy cropandgroup config error,cmd : 92");
        paramArrayOfQConfItem.append(localStringBuilder.toString());
        QLog.e("ReadinjoyCommonConfProcessor", 2, paramArrayOfQConfItem.toString());
      }
      return;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.config.ReadinjoyCommonConfProcessor.ReadinjoyManagerPlatformConfig
 * JD-Core Version:    0.7.0.1
 */