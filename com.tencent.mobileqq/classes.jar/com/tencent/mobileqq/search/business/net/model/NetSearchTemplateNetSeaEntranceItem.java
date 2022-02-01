package com.tencent.mobileqq.search.business.net.model;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import unify.search.UnifySearchCommon.ResultItem;
import unite.DynamicSearch.ResultItem;

public class NetSearchTemplateNetSeaEntranceItem
  extends NetSearchTemplateBaseItem
{
  public static final String a = "NetSearchTemplateNetSeaEntranceItem";
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public List<NetSearchSubItem> t;
  
  public NetSearchTemplateNetSeaEntranceItem(String paramString, long paramLong, List<String> paramList, UnifySearchCommon.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public NetSearchTemplateNetSeaEntranceItem(String paramString, long paramLong, List<String> paramList, DynamicSearch.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public void o_(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.b = paramString.optString("leftIconUrl");
      this.c = paramString.optString("title");
      this.d = paramString.optString("summary");
      this.e = paramString.optString("rightIconUrl");
      this.f = paramString.optString("jumpUrl");
      paramString = paramString.optJSONArray("pageInfo");
      if (paramString != null)
      {
        this.t = new ArrayList(paramString.length());
        int i = 0;
        while (i < paramString.length())
        {
          Object localObject = paramString.optJSONObject(i);
          localObject = new NetSearchSubItem(((JSONObject)localObject).optString("leftIconUrl"), ((JSONObject)localObject).optString("wording"));
          this.t.add(localObject);
          i += 1;
        }
      }
      return;
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, QLog.getStackTraceString(paramString));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.net.model.NetSearchTemplateNetSeaEntranceItem
 * JD-Core Version:    0.7.0.1
 */