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
  public CharSequence a;
  public String b;
  public int c;
  public List<ImageItem> d;
  public ImageItem e;
  public int f;
  
  public NetSearchTemplateAvatarsItem(String paramString, long paramLong, List<String> paramList, UnifySearchCommon.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public NetSearchTemplateAvatarsItem(String paramString, long paramLong, List<String> paramList, DynamicSearch.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public boolean i()
  {
    List localList = this.d;
    return (localList != null) && (localList.size() != 0);
  }
  
  public void o_(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.a = SearchUtils.b(paramString.optString("firstLineText"));
      this.b = paramString.optString("firstLineTextPostfix");
      Object localObject1 = paramString.optJSONObject("leftImage");
      if (localObject1 != null) {
        this.e = new ImageItem(((JSONObject)localObject1).optString("url"), ((JSONObject)localObject1).optInt("type"));
      }
      this.f = paramString.optInt("allHeight");
      localObject1 = paramString.optJSONArray("imageList");
      if (localObject1 != null)
      {
        this.d = new ArrayList(((JSONArray)localObject1).length());
        int i = 0;
        while (i < ((JSONArray)localObject1).length())
        {
          Object localObject2 = ((JSONArray)localObject1).optJSONObject(i);
          localObject2 = new ImageItem(((JSONObject)localObject2).optString("url"), ((JSONObject)localObject2).optInt("type"));
          this.d.add(localObject2);
          i += 1;
        }
      }
      this.c = paramString.optInt("imageTotalCount");
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.net.model.NetSearchTemplateAvatarsItem
 * JD-Core Version:    0.7.0.1
 */