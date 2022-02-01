package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class C2CLovePushGrayConfBean
{
  public int a;
  public String a;
  public JSONObject a;
  
  public C2CLovePushGrayConfBean()
  {
    this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject();
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_JavaLangString = "https://h5.qzone.qq.com/mood/lover?_wv=16777219&from=common&qzUseTransparentNavBar=1&_proxy=1";
  }
  
  public static C2CLovePushGrayConfBean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      C2CLovePushGrayConfBean localC2CLovePushGrayConfBean = new C2CLovePushGrayConfBean();
      localC2CLovePushGrayConfBean.jdField_a_of_type_OrgJsonJSONObject = new JSONObject(paramString).optJSONObject("loverAIOPush");
      return localC2CLovePushGrayConfBean;
    }
    catch (Exception paramString)
    {
      QLog.e("C2CLovePushGrayConfBean", 2, "C2CLovePushGrayConfBean onParsed erro " + paramString.toString());
    }
    return null;
  }
  
  public C2CLovePushGrayConfBean b(String paramString)
  {
    C2CLovePushGrayConfBean localC2CLovePushGrayConfBean = new C2CLovePushGrayConfBean();
    try
    {
      if (this.jdField_a_of_type_OrgJsonJSONObject != null)
      {
        paramString = this.jdField_a_of_type_OrgJsonJSONObject.optJSONObject(paramString);
        if (paramString != null)
        {
          localC2CLovePushGrayConfBean.jdField_a_of_type_Int = paramString.optInt("linkType", 1);
          localC2CLovePushGrayConfBean.jdField_a_of_type_JavaLangString = paramString.optString("linkURL", "https://h5.qzone.qq.com/mood/lover?_wv=16777219&from=common&qzUseTransparentNavBar=1&_proxy=1");
          return localC2CLovePushGrayConfBean;
        }
        localC2CLovePushGrayConfBean.jdField_a_of_type_Int = 1;
        localC2CLovePushGrayConfBean.jdField_a_of_type_JavaLangString = "https://h5.qzone.qq.com/mood/lover?_wv=16777219&from=common&qzUseTransparentNavBar=1&_proxy=1";
        return localC2CLovePushGrayConfBean;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("C2CLovePushGrayProcessor", 2, "getC2CLovePushGrayConfBean Exception :", paramString);
      }
      localC2CLovePushGrayConfBean.jdField_a_of_type_Int = 1;
      localC2CLovePushGrayConfBean.jdField_a_of_type_JavaLangString = "https://h5.qzone.qq.com/mood/lover?_wv=16777219&from=common&qzUseTransparentNavBar=1&_proxy=1";
    }
    return localC2CLovePushGrayConfBean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.C2CLovePushGrayConfBean
 * JD-Core Version:    0.7.0.1
 */