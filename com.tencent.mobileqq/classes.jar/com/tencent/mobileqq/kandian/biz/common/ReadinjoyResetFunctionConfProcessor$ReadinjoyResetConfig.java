package com.tencent.mobileqq.kandian.biz.common;

import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.ResetAllConfigHandler;
import com.tencent.qphone.base.util.QLog;

public class ReadinjoyResetFunctionConfProcessor$ReadinjoyResetConfig
{
  public void a(QConfItem[] paramArrayOfQConfItem)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[handleReadInJoyResetAllConfig] ");
    localStringBuilder.append(paramArrayOfQConfItem);
    QLog.d("ReadinjoyResetFunctionConfProcessor", 2, localStringBuilder.toString());
    if (paramArrayOfQConfItem != null) {
      try
      {
        if (paramArrayOfQConfItem.length > 0)
        {
          new ResetAllConfigHandler();
          int j = paramArrayOfQConfItem.length;
          int i = 0;
          while (i < j)
          {
            TextUtils.isEmpty(paramArrayOfQConfItem[i].b);
            i += 1;
          }
        }
        return;
      }
      catch (Exception paramArrayOfQConfItem)
      {
        QLog.e("ReadinjoyResetFunctionConfProcessor", 1, "[handleReadInJoyResetAllConfig] ", paramArrayOfQConfItem);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.ReadinjoyResetFunctionConfProcessor.ReadinjoyResetConfig
 * JD-Core Version:    0.7.0.1
 */