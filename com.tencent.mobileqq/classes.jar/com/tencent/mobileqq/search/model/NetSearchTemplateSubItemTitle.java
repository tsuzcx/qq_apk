package com.tencent.mobileqq.search.model;

import com.tencent.TMG.utils.QLog;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unite.search.DynamicSearch.ResultItem;

public class NetSearchTemplateSubItemTitle
  extends NetSearchTemplateBaseItem
{
  public String a;
  
  public NetSearchTemplateSubItemTitle(String paramString, long paramLong, List paramList, DynamicSearch.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public void a(String paramString)
  {
    try
    {
      this.a = new JSONObject(paramString).optString("title");
      return;
    }
    catch (JSONException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(c, 0, paramString.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.NetSearchTemplateSubItemTitle
 * JD-Core Version:    0.7.0.1
 */