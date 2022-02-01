package com.tencent.mobileqq.search.model;

import com.tencent.mobileqq.search.util.SearchUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unify.search.UnifySearchCommon.ResultItem;
import pb.unite.search.DynamicSearch.ResultItem;

public class NetSearchTemplateBannerTitleItem
  extends NetSearchTemplateBaseItem
{
  public static final String a;
  public int a;
  public CharSequence a;
  public CharSequence b;
  public String b;
  public CharSequence c;
  
  static
  {
    jdField_a_of_type_JavaLangString = "Q.uniteSearch." + NetSearchTemplateBannerTitleItem.class.getSimpleName();
  }
  
  public NetSearchTemplateBannerTitleItem(String paramString, long paramLong, List<String> paramList, UnifySearchCommon.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public NetSearchTemplateBannerTitleItem(String paramString, long paramLong, List<String> paramList, DynamicSearch.ResultItem paramResultItem, int paramInt)
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
    try
    {
      paramString = new JSONObject(paramString);
      this.i = paramString.optString("leftImageURL");
      this.jdField_a_of_type_Int = paramString.optInt("leftImageType", 1);
      this.jdField_a_of_type_Int = a(this.jdField_a_of_type_Int);
      this.jdField_b_of_type_JavaLangString = SearchUtils.a(paramString.optString("leftImageTagText"));
      this.jdField_a_of_type_JavaLangCharSequence = SearchUtils.a(paramString.optString("firstLineText"));
      this.jdField_b_of_type_JavaLangCharSequence = SearchUtils.a(paramString.optString("secondLineText"));
      this.c = SearchUtils.a(paramString.optJSONArray("thirdLineText"));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.NetSearchTemplateBannerTitleItem
 * JD-Core Version:    0.7.0.1
 */