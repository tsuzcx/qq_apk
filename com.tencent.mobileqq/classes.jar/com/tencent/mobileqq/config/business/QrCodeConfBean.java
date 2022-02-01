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
          paramString.jdField_a_of_type_JavaLangString = "default_bg";
          paramString.c = 1;
          paramString.jdField_b_of_type_Int = 0;
          paramString.jdField_a_of_type_Int = 0;
          paramString.jdField_b_of_type_JavaLangString = "";
          localQrCodeConfBean.a.add(paramString);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("QrCodeDisplay.QrCodeConfBean", 2, "parse: " + localQrCodeConfBean.a.size());
      }
      return localQrCodeConfBean;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.QrCodeConfBean
 * JD-Core Version:    0.7.0.1
 */