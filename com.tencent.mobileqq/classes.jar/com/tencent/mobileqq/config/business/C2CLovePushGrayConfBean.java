package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class C2CLovePushGrayConfBean
{
  public JSONObject a = new JSONObject();
  public int b = 1;
  public String c = "https://h5.qzone.qq.com/mood/lover?_wv=16777219&from=common&qzUseTransparentNavBar=1&_proxy=1";
  
  public static C2CLovePushGrayConfBean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      localObject = new C2CLovePushGrayConfBean();
      ((C2CLovePushGrayConfBean)localObject).a = new JSONObject(paramString).optJSONObject("loverAIOPush");
      return localObject;
    }
    catch (Exception paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("C2CLovePushGrayConfBean onParsed erro ");
      ((StringBuilder)localObject).append(paramString.toString());
      QLog.e("C2CLovePushGrayConfBean", 2, ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  public C2CLovePushGrayConfBean b(String paramString)
  {
    C2CLovePushGrayConfBean localC2CLovePushGrayConfBean = new C2CLovePushGrayConfBean();
    try
    {
      if (this.a != null)
      {
        paramString = this.a.optJSONObject(paramString);
        if (paramString != null)
        {
          localC2CLovePushGrayConfBean.b = paramString.optInt("linkType", 1);
          localC2CLovePushGrayConfBean.c = paramString.optString("linkURL", "https://h5.qzone.qq.com/mood/lover?_wv=16777219&from=common&qzUseTransparentNavBar=1&_proxy=1");
          return localC2CLovePushGrayConfBean;
        }
        localC2CLovePushGrayConfBean.b = 1;
        localC2CLovePushGrayConfBean.c = "https://h5.qzone.qq.com/mood/lover?_wv=16777219&from=common&qzUseTransparentNavBar=1&_proxy=1";
        return localC2CLovePushGrayConfBean;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("C2CLovePushGrayProcessor", 2, "getC2CLovePushGrayConfBean Exception :", paramString);
      }
      localC2CLovePushGrayConfBean.b = 1;
      localC2CLovePushGrayConfBean.c = "https://h5.qzone.qq.com/mood/lover?_wv=16777219&from=common&qzUseTransparentNavBar=1&_proxy=1";
    }
    return localC2CLovePushGrayConfBean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.C2CLovePushGrayConfBean
 * JD-Core Version:    0.7.0.1
 */