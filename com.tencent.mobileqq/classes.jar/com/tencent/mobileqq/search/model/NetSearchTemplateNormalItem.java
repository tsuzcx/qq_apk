package com.tencent.mobileqq.search.model;

import com.tencent.mobileqq.search.util.SearchUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unite.search.DynamicSearch.ResultItem;

public class NetSearchTemplateNormalItem
  extends NetSearchTemplateBaseItem
{
  public int a;
  public CharSequence a;
  public String a;
  public CharSequence b;
  public String b;
  public boolean b;
  public CharSequence c;
  public CharSequence d;
  public String j;
  public String k;
  public String l;
  
  public NetSearchTemplateNormalItem(String paramString, long paramLong, List paramList, DynamicSearch.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public int a(int paramInt)
  {
    int i = paramInt;
    switch (paramInt)
    {
    default: 
      i = 1;
    }
    return i;
  }
  
  public void a(String paramString)
  {
    boolean bool = true;
    try
    {
      paramString = new JSONObject(paramString);
      this.i = paramString.optString("leftImageURL");
      this.jdField_a_of_type_Int = paramString.optInt("leftImageType", 1);
      this.jdField_a_of_type_Int = a(this.jdField_a_of_type_Int);
      this.l = SearchUtils.a(paramString.optString("leftImageTagText"));
      this.jdField_a_of_type_JavaLangCharSequence = SearchUtils.a(paramString.optString("firstLineText"));
      this.jdField_b_of_type_JavaLangCharSequence = SearchUtils.a(paramString.optString("secondLineText"));
      this.jdField_a_of_type_JavaLangString = paramString.optString("headLineIconURL");
      JSONObject localJSONObject = paramString.optJSONObject("headLineTag");
      if (localJSONObject != null)
      {
        this.j = localJSONObject.optString("word");
        this.k = localJSONObject.optString("color");
      }
      this.jdField_b_of_type_JavaLangString = paramString.optString("titleRightText");
      this.c = SearchUtils.a(paramString.optJSONArray("thirdLineLeftText"));
      this.d = SearchUtils.a(paramString.optJSONArray("thirdLineRightText"));
      if (paramString.optInt("needRightCenter", 0) == 1) {}
      for (;;)
      {
        this.jdField_b_of_type_Boolean = bool;
        return;
        bool = false;
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.NetSearchTemplateNormalItem
 * JD-Core Version:    0.7.0.1
 */