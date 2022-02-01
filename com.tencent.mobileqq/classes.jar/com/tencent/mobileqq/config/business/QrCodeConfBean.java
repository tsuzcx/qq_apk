package com.tencent.mobileqq.config.business;

import com.tencent.mobileqq.jsonconverter.JSONConverter;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class QrCodeConfBean
{
  public List<QrCodeConfBean.QrCodeList> a = new ArrayList();
  
  public static QrCodeConfBean a(String paramString)
  {
    QrCodeConfBean localQrCodeConfBean = new QrCodeConfBean();
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("QRCodeList"))
      {
        paramString = paramString.optJSONArray("QRCodeList");
        Type localType = new QrCodeConfBean.1().getClass().getGenericSuperclass();
        localQrCodeConfBean.a.addAll(JSONConverter.a(paramString, localType));
        if (localQrCodeConfBean.a.size() > 0)
        {
          paramString = new QrCodeConfBean.QrCodeList();
          paramString.a = "default_bg";
          paramString.e = 1;
          paramString.c = 0;
          paramString.b = 0;
          paramString.d = "";
          localQrCodeConfBean.a.add(paramString);
        }
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("parse: ");
      paramString.append(localQrCodeConfBean.a.size());
      QLog.d("QrCodeDisplay.QrCodeConfBean", 2, paramString.toString());
    }
    return localQrCodeConfBean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.QrCodeConfBean
 * JD-Core Version:    0.7.0.1
 */