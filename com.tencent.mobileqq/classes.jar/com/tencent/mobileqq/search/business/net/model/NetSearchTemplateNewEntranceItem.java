package com.tencent.mobileqq.search.business.net.model;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import unify.search.UnifySearchCommon.ResultItem;

public class NetSearchTemplateNewEntranceItem
  extends NetSearchTemplateBaseItem
{
  public static final String a = NetSearchTemplateNetSeaEntranceItem.class.getSimpleName();
  public String b;
  public String c;
  public String d;
  public boolean e;
  public String f;
  public List<RelativeWord> t;
  public String u;
  
  public NetSearchTemplateNewEntranceItem(String paramString, long paramLong, List<String> paramList, UnifySearchCommon.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  private List<RelativeWord> a(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJSONArray != null)
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        Object localObject = paramJSONArray.optJSONObject(i);
        localObject = new RelativeWord(((JSONObject)localObject).optString("word"), ((JSONObject)localObject).optString("url"));
        if (((RelativeWord)localObject).a()) {
          localArrayList.add(localObject);
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public CharSequence d()
  {
    if (this.i == 1101L)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.c);
      localStringBuilder.append(this.m);
      return localStringBuilder.toString();
    }
    return super.d();
  }
  
  public void o_(String paramString)
  {
    this.ag = false;
    try
    {
      paramString = new JSONObject(paramString);
      this.b = paramString.optString("leftIconUrl");
      this.c = paramString.optString("title");
      this.d = paramString.optString("summary");
      this.e = paramString.optBoolean("isShowArrow");
      this.f = paramString.optString("jumpUrl");
      this.u = paramString.optString("subItemLeftIconUrl");
      paramString = paramString.optJSONArray("itemList");
      if (paramString != null)
      {
        this.t = a(paramString);
        return;
      }
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
 * Qualified Name:     com.tencent.mobileqq.search.business.net.model.NetSearchTemplateNewEntranceItem
 * JD-Core Version:    0.7.0.1
 */