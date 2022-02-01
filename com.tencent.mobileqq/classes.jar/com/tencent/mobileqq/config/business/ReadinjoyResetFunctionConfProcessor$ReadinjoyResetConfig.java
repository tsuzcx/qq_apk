package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.ResetAllConfigHandler;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class ReadinjoyResetFunctionConfProcessor$ReadinjoyResetConfig
{
  public void a(QConfItem[] paramArrayOfQConfItem)
  {
    QLog.d("ReadinjoyResetFunctionConfProcessor", 2, "[handleReadInJoyResetAllConfig] " + paramArrayOfQConfItem);
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
            boolean bool = TextUtils.isEmpty(paramArrayOfQConfItem[i].a);
            if (bool) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.ReadinjoyResetFunctionConfProcessor.ReadinjoyResetConfig
 * JD-Core Version:    0.7.0.1
 */