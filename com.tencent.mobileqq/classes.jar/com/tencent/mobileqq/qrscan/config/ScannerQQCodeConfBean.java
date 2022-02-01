package com.tencent.mobileqq.qrscan.config;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ScannerQQCodeConfBean
{
  public boolean a = true;
  
  public static ScannerQQCodeConfBean a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScannerQQCodeConfBean", 2, "defaultBean");
    }
    return new ScannerQQCodeConfBean();
  }
  
  public static ScannerQQCodeConfBean a(String paramString)
  {
    ScannerQQCodeConfBean localScannerQQCodeConfBean = new ScannerQQCodeConfBean();
    StringBuilder localStringBuilder;
    if (!TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("parse content: ");
        localStringBuilder.append(paramString);
        QLog.d("ScannerQQCodeConfBean", 2, localStringBuilder.toString());
      }
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("useQBarAIModel"))
        {
          if (paramString.optInt("useQBarAIModel") != 1) {
            break label129;
          }
          bool = true;
          localScannerQQCodeConfBean.a = bool;
          return localScannerQQCodeConfBean;
        }
      }
      catch (JSONException paramString)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("parse error->");
        localStringBuilder.append(paramString.toString());
        QLog.e("ScannerQQCodeConfBean", 1, localStringBuilder.toString());
      }
      return localScannerQQCodeConfBean;
      label129:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.config.ScannerQQCodeConfBean
 * JD-Core Version:    0.7.0.1
 */