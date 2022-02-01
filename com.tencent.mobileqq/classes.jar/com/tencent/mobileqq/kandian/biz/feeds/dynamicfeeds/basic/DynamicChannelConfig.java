package com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.basic;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DynamicChannelConfig
{
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<DynamicChannelConfig.HeadData> jdField_a_of_type_JavaUtilList = new ArrayList();
  private HashMap<String, String> b = new HashMap();
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public DynamicChannelConfig.HeadData a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (DynamicChannelConfig.HeadData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public String a(int paramInt, String paramString)
  {
    DynamicChannelConfig.HeadData localHeadData = a(paramInt);
    if ((localHeadData != null) && (!TextUtils.isEmpty(paramString)))
    {
      if ("style_ID".equalsIgnoreCase(paramString)) {
        return localHeadData.jdField_a_of_type_JavaLangString;
      }
      return (String)localHeadData.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    }
    return "";
  }
  
  public String a(String paramString)
  {
    return (String)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public String b(String paramString)
  {
    return (String)this.b.get(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.basic.DynamicChannelConfig
 * JD-Core Version:    0.7.0.1
 */