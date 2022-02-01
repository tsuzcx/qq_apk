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
  public String c;
  public String d;
  public String e;
  public String f;
  
  public NetSearchTemplateTitleItem(String paramString, long paramLong, List<String> paramList, UnifySearchCommon.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public NetSearchTemplateTitleItem(String paramString, long paramLong, List<String> paramList, DynamicSearch.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public void o_(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.b = paramString.optString("leftIcon");
      this.c = paramString.optString("firstTitle");
      this.d = paramString.optString("secondTitle");
      this.e = paramString.optString("moreText");
      this.f = paramString.optString("jumpUrl");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.net.model.NetSearchTemplateTitleItem
 * JD-Core Version:    0.7.0.1
 */