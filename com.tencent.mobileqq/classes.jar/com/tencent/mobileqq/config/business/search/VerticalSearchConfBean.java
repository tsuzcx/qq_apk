package com.tencent.mobileqq.config.business.search;

import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONObject;

public class VerticalSearchConfBean
{
  private HashMap<String, VerticalSearchConfBean.Data> a = new HashMap();
  
  public static VerticalSearchConfBean a(QConfItem paramQConfItem)
  {
    VerticalSearchConfBean localVerticalSearchConfBean = new VerticalSearchConfBean();
    if (paramQConfItem != null) {
      if (QLog.isColorLevel()) {
        QLog.d("VerticalNavigationConfBean", 2, "parse taskid->" + paramQConfItem.jdField_a_of_type_Int + " content->" + paramQConfItem.jdField_a_of_type_JavaLangString);
      }
    }
    try
    {
      paramQConfItem = new JSONObject(paramQConfItem.jdField_a_of_type_JavaLangString);
      Object localObject;
      if (paramQConfItem.has("emoji"))
      {
        localObject = paramQConfItem.optJSONObject("emoji");
        if (localObject != null)
        {
          VerticalSearchConfBean.Data localData = new VerticalSearchConfBean.Data();
          localData.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("switch", 0);
          localData.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("iconUrl", "");
          localData.b = ((JSONObject)localObject).optString("url", "");
          localVerticalSearchConfBean.a.put("emoji", localData);
        }
      }
      if (paramQConfItem.has("heihua"))
      {
        paramQConfItem = paramQConfItem.optJSONObject("heihua");
        if (paramQConfItem != null)
        {
          localObject = new VerticalSearchConfBean.Data();
          ((VerticalSearchConfBean.Data)localObject).jdField_a_of_type_Int = paramQConfItem.optInt("switch", 0);
          ((VerticalSearchConfBean.Data)localObject).jdField_a_of_type_JavaLangString = paramQConfItem.optString("iconUrl", "");
          ((VerticalSearchConfBean.Data)localObject).b = paramQConfItem.optString("url", "");
          ((VerticalSearchConfBean.Data)localObject).c = paramQConfItem.optString("name", "");
          localVerticalSearchConfBean.a.put("heihua", localObject);
        }
      }
    }
    catch (Exception paramQConfItem)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("VerticalNavigationConfBean", 2, "parse error->" + paramQConfItem.toString());
    }
    return localVerticalSearchConfBean;
    return localVerticalSearchConfBean;
  }
  
  public String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = (VerticalSearchConfBean.Data)this.a.get(paramString);
    if (paramString != null) {
      return paramString.b;
    }
    return "";
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      paramString = (VerticalSearchConfBean.Data)this.a.get(paramString);
    } while (paramString == null);
    if (paramString.jdField_a_of_type_Int == 1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = (VerticalSearchConfBean.Data)this.a.get(paramString);
    if (paramString != null) {
      return paramString.jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  public String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = (VerticalSearchConfBean.Data)this.a.get(paramString);
    if (paramString != null) {
      return paramString.c;
    }
    return "";
  }
  
  public String toString()
  {
    if (this.a != null) {}
    for (String str = this.a.toString();; str = "null") {
      return String.format("mConfigData:%s ", new Object[] { str });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.search.VerticalSearchConfBean
 * JD-Core Version:    0.7.0.1
 */