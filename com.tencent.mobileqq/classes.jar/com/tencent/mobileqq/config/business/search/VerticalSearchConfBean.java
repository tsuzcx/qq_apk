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
    if (paramQConfItem != null)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("parse taskid->");
        ((StringBuilder)localObject).append(paramQConfItem.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append(" content->");
        ((StringBuilder)localObject).append(paramQConfItem.jdField_a_of_type_JavaLangString);
        QLog.d("VerticalNavigationConfBean", 2, ((StringBuilder)localObject).toString());
      }
      try
      {
        paramQConfItem = new JSONObject(paramQConfItem.jdField_a_of_type_JavaLangString);
        boolean bool = paramQConfItem.has("emoji");
        if (bool)
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
            return localVerticalSearchConfBean;
          }
        }
      }
      catch (Exception paramQConfItem)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("parse error->");
          ((StringBuilder)localObject).append(paramQConfItem.toString());
          QLog.d("VerticalNavigationConfBean", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
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
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = (VerticalSearchConfBean.Data)this.a.get(paramString);
    if (paramString != null) {
      return paramString.jdField_a_of_type_Int == 1;
    }
    return false;
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
    Object localObject = this.a;
    if (localObject != null) {
      localObject = ((HashMap)localObject).toString();
    } else {
      localObject = "null";
    }
    return String.format("mConfigData:%s ", new Object[] { localObject });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.search.VerticalSearchConfBean
 * JD-Core Version:    0.7.0.1
 */