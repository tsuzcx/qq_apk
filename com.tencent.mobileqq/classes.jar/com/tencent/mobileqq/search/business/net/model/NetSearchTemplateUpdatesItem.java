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
  public int a;
  public CharSequence b;
  public String c;
  public CharSequence d;
  public CharSequence e;
  public List<ImageItem> f;
  public double t;
  public int u;
  public double v;
  public boolean w;
  public boolean x;
  
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
  
  public boolean i()
  {
    return true;
  }
  
  public void o_(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        this.s = paramString.optString("leftImageURL");
        boolean bool2 = true;
        this.a = paramString.optInt("leftImageType", 1);
        this.a = a(this.a);
        this.b = SearchUtils.b(paramString.optString("headText"));
        this.c = paramString.optString("headLineIconURL");
        this.d = SearchUtils.b(paramString.optString("descLineText"));
        this.e = SearchUtils.b(paramString.optString("firstLineText"));
        JSONArray localJSONArray = paramString.optJSONArray("imageList");
        if (localJSONArray != null)
        {
          this.f = new ArrayList(localJSONArray.length());
          int i = 0;
          if (i < localJSONArray.length())
          {
            Object localObject = localJSONArray.optJSONObject(i);
            localObject = new ImageItem(((JSONObject)localObject).optString("url"), ((JSONObject)localObject).optInt("type"));
            this.f.add(localObject);
            i += 1;
            continue;
          }
        }
        this.t = paramString.optDouble("imageAspectRatio", 1.0D);
        this.v = paramString.optDouble("singleImageScale", 1.0D);
        this.u = paramString.optInt("imageTotalCount");
        if (paramString.optInt("topNeedHigherMargin", 0) == 1)
        {
          bool1 = true;
          this.w = bool1;
          if (paramString.optInt("needCornerRadius", 0) != 1) {
            break label271;
          }
          bool1 = bool2;
          this.x = bool1;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.net.model.NetSearchTemplateUpdatesItem
 * JD-Core Version:    0.7.0.1
 */