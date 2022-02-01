package com.tencent.mobileqq.search.business.net.model;

import com.tencent.mobileqq.search.util.SearchUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import unify.search.UnifySearchCommon.ResultItem;
import unite.DynamicSearch.ResultItem;

public class NetSearchTemplateUpdatesItem
  extends NetSearchTemplateBaseItem
{
  public double a;
  public int a;
  public CharSequence a;
  public String a;
  public List<ImageItem> a;
  public double b;
  public int b;
  public CharSequence b;
  public boolean b;
  public CharSequence c;
  public boolean c;
  
  public NetSearchTemplateUpdatesItem(String paramString, long paramLong, List<String> paramList, UnifySearchCommon.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public NetSearchTemplateUpdatesItem(String paramString, long paramLong, List<String> paramList, DynamicSearch.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public int a(int paramInt)
  {
    int i = paramInt;
    if (paramInt != 1)
    {
      i = paramInt;
      if (paramInt != 5) {
        i = 1;
      }
    }
    return i;
  }
  
  public void a(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        this.i = paramString.optString("leftImageURL");
        boolean bool2 = true;
        this.jdField_a_of_type_Int = paramString.optInt("leftImageType", 1);
        this.jdField_a_of_type_Int = a(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_JavaLangCharSequence = SearchUtils.a(paramString.optString("headText"));
        this.jdField_a_of_type_JavaLangString = paramString.optString("headLineIconURL");
        this.jdField_b_of_type_JavaLangCharSequence = SearchUtils.a(paramString.optString("descLineText"));
        this.jdField_c_of_type_JavaLangCharSequence = SearchUtils.a(paramString.optString("firstLineText"));
        JSONArray localJSONArray = paramString.optJSONArray("imageList");
        if (localJSONArray != null)
        {
          this.jdField_a_of_type_JavaUtilList = new ArrayList(localJSONArray.length());
          int i = 0;
          if (i < localJSONArray.length())
          {
            Object localObject = localJSONArray.optJSONObject(i);
            localObject = new ImageItem(((JSONObject)localObject).optString("url"), ((JSONObject)localObject).optInt("type"));
            this.jdField_a_of_type_JavaUtilList.add(localObject);
            i += 1;
            continue;
          }
        }
        this.jdField_a_of_type_Double = paramString.optDouble("imageAspectRatio", 1.0D);
        this.jdField_b_of_type_Double = paramString.optDouble("singleImageScale", 1.0D);
        this.jdField_b_of_type_Int = paramString.optInt("imageTotalCount");
        if (paramString.optInt("topNeedHigherMargin", 0) == 1)
        {
          bool1 = true;
          this.jdField_b_of_type_Boolean = bool1;
          if (paramString.optInt("needCornerRadius", 0) != 1) {
            break label271;
          }
          bool1 = bool2;
          this.jdField_c_of_type_Boolean = bool1;
          return;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      boolean bool1 = false;
      continue;
      label271:
      bool1 = false;
    }
  }
  
  public boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.net.model.NetSearchTemplateUpdatesItem
 * JD-Core Version:    0.7.0.1
 */