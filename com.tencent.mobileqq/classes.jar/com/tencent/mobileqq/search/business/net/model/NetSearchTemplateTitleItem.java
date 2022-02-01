package com.tencent.mobileqq.search.business.net.model;

import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import unify.search.UnifySearchCommon.ResultItem;
import unite.DynamicSearch.ResultItem;

public class NetSearchTemplateTitleItem
  extends NetSearchTemplateBaseItem
{
  public static final String a = "NetSearchTemplateTitleItem";
  public String b;
  public String j;
  public String k;
  public String l;
  public String m;
  
  public NetSearchTemplateTitleItem(String paramString, long paramLong, List<String> paramList, UnifySearchCommon.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public NetSearchTemplateTitleItem(String paramString, long paramLong, List<String> paramList, DynamicSearch.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public void a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.b = paramString.optString("leftIcon");
      this.j = paramString.optString("firstTitle");
      this.k = paramString.optString("secondTitle");
      this.l = paramString.optString("moreText");
      this.m = paramString.optString("jumpUrl");
      return;
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, paramString.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.net.model.NetSearchTemplateTitleItem
 * JD-Core Version:    0.7.0.1
 */