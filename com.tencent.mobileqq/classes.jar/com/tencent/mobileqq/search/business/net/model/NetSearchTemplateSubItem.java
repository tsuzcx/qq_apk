package com.tencent.mobileqq.search.business.net.model;

import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import unify.search.UnifySearchCommon.ResultItem;
import unite.DynamicSearch.ResultItem;

public class NetSearchTemplateSubItem
  extends NetSearchTemplateBaseItem
{
  public CharSequence a;
  public CharSequence b;
  public String c;
  public boolean d;
  
  public NetSearchTemplateSubItem(String paramString, long paramLong, List<String> paramList, UnifySearchCommon.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public NetSearchTemplateSubItem(String paramString, long paramLong, List<String> paramList, DynamicSearch.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public void o_(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        this.a = SearchUtils.a(paramString.optJSONArray("leftText"));
        this.b = SearchUtils.a(paramString.optJSONArray("rightText"));
        this.c = paramString.optString("bgColor");
        int i = paramString.optInt("needCenter");
        bool = true;
        if (i == 1)
        {
          this.d = bool;
          return;
        }
      }
      catch (JSONException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d(NetSearchTemplateBaseItem.g, 2, paramString.toString());
        }
        return;
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.net.model.NetSearchTemplateSubItem
 * JD-Core Version:    0.7.0.1
 */