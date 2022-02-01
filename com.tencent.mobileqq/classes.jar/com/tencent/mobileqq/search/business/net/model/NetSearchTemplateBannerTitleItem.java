package com.tencent.mobileqq.search.business.net.model;

import com.tencent.mobileqq.search.util.SearchUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import unify.search.UnifySearchCommon.ResultItem;
import unite.DynamicSearch.ResultItem;

public class NetSearchTemplateBannerTitleItem
  extends NetSearchTemplateBaseItem
{
  public static final String a;
  public CharSequence b;
  public int c;
  public CharSequence d;
  public CharSequence e;
  public String f;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Q.uniteSearch.");
    localStringBuilder.append(NetSearchTemplateBannerTitleItem.class.getSimpleName());
    a = localStringBuilder.toString();
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
  
  public boolean i()
  {
    return true;
  }
  
  public void o_(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.s = paramString.optString("leftImageURL");
      this.c = paramString.optInt("leftImageType", 1);
      this.c = a(this.c);
      this.f = SearchUtils.b(paramString.optString("leftImageTagText"));
      this.b = SearchUtils.b(paramString.optString("firstLineText"));
      this.d = SearchUtils.b(paramString.optString("secondLineText"));
      this.e = SearchUtils.a(paramString.optJSONArray("thirdLineText"));
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.net.model.NetSearchTemplateBannerTitleItem
 * JD-Core Version:    0.7.0.1
 */