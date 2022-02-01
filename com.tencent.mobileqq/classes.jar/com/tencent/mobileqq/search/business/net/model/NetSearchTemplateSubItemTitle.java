package com.tencent.mobileqq.search.business.net.model;

import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import unify.search.UnifySearchCommon.ResultItem;
import unite.DynamicSearch.ResultItem;

public class NetSearchTemplateSubItemTitle
  extends NetSearchTemplateBaseItem
{
  public String a;
  
  public NetSearchTemplateSubItemTitle(String paramString, long paramLong, List<String> paramList, UnifySearchCommon.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public NetSearchTemplateSubItemTitle(String paramString, long paramLong, List<String> paramList, DynamicSearch.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public void o_(String paramString)
  {
    try
    {
      this.a = new JSONObject(paramString).optString("title");
      return;
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d(g, 2, paramString.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.net.model.NetSearchTemplateSubItemTitle
 * JD-Core Version:    0.7.0.1
 */