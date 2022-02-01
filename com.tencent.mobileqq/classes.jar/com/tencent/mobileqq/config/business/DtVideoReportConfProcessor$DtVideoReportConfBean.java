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
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DtVideoReportConfProcessor", 2, new Object[] { "[parse] config: ", paramString });
      }
      return localDtVideoReportConfBean;
    }
    for (;;)
    {
      try
      {
        if (new JSONObject(paramString).optInt("DTVideoSwitch") != 1) {
          break label82;
        }
        bool = true;
        localDtVideoReportConfBean.a = bool;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("DtVideoReportConfProcessor", 1, "[parse] parse error: ", localThrowable);
      }
      break;
      label82:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.DtVideoReportConfProcessor.DtVideoReportConfBean
 * JD-Core Version:    0.7.0.1
 */