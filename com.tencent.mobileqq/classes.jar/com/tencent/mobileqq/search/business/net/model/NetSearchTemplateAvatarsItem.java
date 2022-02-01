package com.tencent.mobileqq.search.business.net.model;

import com.tencent.mobileqq.search.util.SearchUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import unify.search.UnifySearchCommon.ResultItem;
import unite.DynamicSearch.ResultItem;

public class NetSearchTemplateAvatarsItem
  extends NetSearchTemplateBaseItem
{
  public int a;
  public ImageItem a;
  public CharSequence a;
  public String a;
  public List<ImageItem> a;
  public int b;
  
  public NetSearchTemplateAvatarsItem(String paramString, long paramLong, List<String> paramList, UnifySearchCommon.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public NetSearchTemplateAvatarsItem(String paramString, long paramLong, List<String> paramList, DynamicSearch.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public void a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.jdField_a_of_type_JavaLangCharSequence = SearchUtils.a(paramString.optString("firstLineText"));
      this.jdField_a_of_type_JavaLangString = paramString.optString("firstLineTextPostfix");
      Object localObject1 = paramString.optJSONObject("leftImage");
      if (localObject1 != null) {
        this.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelImageItem = new ImageItem(((JSONObject)localObject1).optString("url"), ((JSONObject)localObject1).optInt("type"));
      }
      this.b = paramString.optInt("allHeight");
      localObject1 = paramString.optJSONArray("imageList");
      if (localObject1 != null)
      {
        this.jdField_a_of_type_JavaUtilList = new ArrayList(((JSONArray)localObject1).length());
        int i = 0;
        while (i < ((JSONArray)localObject1).length())
        {
          Object localObject2 = ((JSONArray)localObject1).optJSONObject(i);
          localObject2 = new ImageItem(((JSONObject)localObject2).optString("url"), ((JSONObject)localObject2).optInt("type"));
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
          i += 1;
        }
      }
      this.jdField_a_of_type_Int = paramString.optInt("imageTotalCount");
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public boolean b()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    return (localList != null) && (localList.size() != 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.net.model.NetSearchTemplateAvatarsItem
 * JD-Core Version:    0.7.0.1
 */