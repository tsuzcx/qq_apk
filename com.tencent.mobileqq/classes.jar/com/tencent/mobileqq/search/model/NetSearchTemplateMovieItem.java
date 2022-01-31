package com.tencent.mobileqq.search.model;

import com.tencent.mobileqq.search.util.SearchUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unite.search.DynamicSearch.ResultItem;

public class NetSearchTemplateMovieItem
  extends NetSearchTemplateBaseItem
{
  public static final String a;
  public int a;
  public CharSequence a;
  public CharSequence b;
  public CharSequence c;
  public CharSequence d;
  public CharSequence e;
  public CharSequence f;
  
  static
  {
    jdField_a_of_type_JavaLangString = "Q.uniteSearch." + NetSearchTemplateMovieItem.class.getSimpleName();
  }
  
  public NetSearchTemplateMovieItem(String paramString, long paramLong, List paramList, DynamicSearch.ResultItem paramResultItem, int paramInt)
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
      this.jdField_a_of_type_JavaLangCharSequence = SearchUtils.a(paramString.optString("firstLineText"));
      this.b = SearchUtils.a(paramString.optString("hotTagText"));
      this.c = SearchUtils.a(paramString.optString("secondLineText"));
      this.d = paramString.optString("thirdLineText");
      this.e = SearchUtils.a(paramString.optJSONArray("fourthLineText"));
      this.f = SearchUtils.a(paramString.optString("bottomButtonText"));
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
 * Qualified Name:     com.tencent.mobileqq.search.model.NetSearchTemplateMovieItem
 * JD-Core Version:    0.7.0.1
 */