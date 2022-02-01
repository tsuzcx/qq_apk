package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class DtVideoReportConfProcessor$DtVideoReportConfBean
{
  public boolean a = false;
  
  public static DtVideoReportConfBean a(String paramString)
  {
    DtVideoReportConfBean localDtVideoReportConfBean = new DtVideoReportConfBean();
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      try
      {
        if (new JSONObject(paramString).optInt("DTVideoSwitch") != 1) {
          break label85;
        }
        bool = true;
        localDtVideoReportConfBean.a = bool;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("DtVideoReportConfProcessor", 1, "[parse] parse error: ", localThrowable);
      }
      if (QLog.isColorLevel()) {
        QLog.d("DtVideoReportConfProcessor", 2, new Object[] { "[parse] config: ", paramString });
      }
      return localDtVideoReportConfBean;
      label85:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.DtVideoReportConfProcessor.DtVideoReportConfBean
 * JD-Core Version:    0.7.0.1
 */