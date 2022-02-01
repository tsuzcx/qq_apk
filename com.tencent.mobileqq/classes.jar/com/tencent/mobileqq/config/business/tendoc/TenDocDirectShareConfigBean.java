package com.tencent.mobileqq.config.business.tendoc;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.config.QConfItem;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TenDocDirectShareConfigBean
{
  private String jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131714714);
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private String b = "";
  
  public static TenDocDirectShareConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    int i = 0;
    if ((paramArrayOfQConfItem == null) || (paramArrayOfQConfItem.length <= 0)) {
      return null;
    }
    TenDocDirectShareConfigBean localTenDocDirectShareConfigBean = new TenDocDirectShareConfigBean();
    try
    {
      paramArrayOfQConfItem = new JSONObject(paramArrayOfQConfItem[0].jdField_a_of_type_JavaLangString);
      JSONArray localJSONArray = paramArrayOfQConfItem.getJSONArray("suffix");
      while (i < localJSONArray.length())
      {
        localTenDocDirectShareConfigBean.jdField_a_of_type_JavaUtilList.add(localJSONArray.getString(i));
        i += 1;
      }
      localTenDocDirectShareConfigBean.jdField_a_of_type_JavaLangString = paramArrayOfQConfItem.getString("title");
      localTenDocDirectShareConfigBean.b = paramArrayOfQConfItem.getString("desc");
      return localTenDocDirectShareConfigBean;
    }
    catch (JSONException paramArrayOfQConfItem)
    {
      paramArrayOfQConfItem.printStackTrace();
    }
    return localTenDocDirectShareConfigBean;
  }
  
  public List<String> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TenDocDirectShareConfigBean
 * JD-Core Version:    0.7.0.1
 */