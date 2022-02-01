package com.tencent.mobileqq.perf.rmonitor.config;

import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class QQRMonitorConfigBean
{
  public QQRMonitorConfig a;
  public QQRMonitorConfig b;
  public QQRMonitorConfig c;
  
  public static QQRMonitorConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    QQRMonitorConfigBean localQQRMonitorConfigBean = new QQRMonitorConfigBean();
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      paramArrayOfQConfItem = paramArrayOfQConfItem[0].b;
      QLog.d("QQRMonitorConfigBean", 2, new Object[] { "[config] parse: invoked. ", " content: ", paramArrayOfQConfItem });
      try
      {
        paramArrayOfQConfItem = new JSONObject(paramArrayOfQConfItem);
        localQQRMonitorConfigBean.a = QQRMonitorConfig.a(paramArrayOfQConfItem.getJSONObject("official"));
        localQQRMonitorConfigBean.b = QQRMonitorConfig.a(paramArrayOfQConfItem.getJSONObject("gray"));
        localQQRMonitorConfigBean.c = QQRMonitorConfig.a(paramArrayOfQConfItem.getJSONObject("develop"));
        return localQQRMonitorConfigBean;
      }
      catch (Throwable paramArrayOfQConfItem)
      {
        QLog.e("QQRMonitorConfigBean", 1, paramArrayOfQConfItem, new Object[0]);
      }
    }
    return localQQRMonitorConfigBean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.perf.rmonitor.config.QQRMonitorConfigBean
 * JD-Core Version:    0.7.0.1
 */