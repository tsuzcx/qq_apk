package com.tencent.mobileqq.search.model;

import com.tencent.mobileqq.search.util.SearchUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unite.search.DynamicSearch.ResultItem;

public class NetSearchTemplateAvatarsItem
  extends NetSearchTemplateBaseItem
{
  public int a;
  public CharSequence a;
  public String a;
  public List a;
  
  public NetSearchTemplateAvatarsItem(String paramString, long paramLong, List paramList, DynamicSearch.ResultItem paramResultItem, int paramInt)
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
      JSONArray localJSONArray = paramString.optJSONArray("imageList");
      if (localJSONArray != null)
      {
        this.jdField_a_of_type_JavaUtilList = new ArrayList(localJSONArray.length());
        int i = 0;
        while (i < localJSONArray.length())
        {
          Object localObject = localJSONArray.optJSONObject(i);
          localObject = new ImageItem(((JSONObject)localObject).optString("url"), ((JSONObject)localObject).optInt("type"));
          this.jdField_a_of_type_JavaUtilList.add(localObject);
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
    boolean bool = true;
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      bool = false;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.NetSearchTemplateAvatarsItem
 * JD-Core Version:    0.7.0.1
 */