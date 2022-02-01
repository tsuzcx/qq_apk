package com.tencent.mobileqq.utils.abtest;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ExpMgrListProcessor$ExpMgrListData
{
  public int a = -1;
  public String b = "";
  
  public ExpMgrListProcessor$ExpMgrListData() {}
  
  public ExpMgrListProcessor$ExpMgrListData(int paramInt, String paramString)
  {
    this.a = paramInt;
    this.b = paramString;
  }
  
  private void b()
  {
    if (TextUtils.isEmpty(this.b)) {
      return;
    }
    try
    {
      JSONArray localJSONArray = new JSONArray(this.b);
      int j = localJSONArray.length();
      int i = 0;
      while (i < j)
      {
        Object localObject = localJSONArray.getJSONObject(i);
        int k = ((JSONObject)localObject).optInt("mgrTypeId");
        localObject = ((JSONObject)localObject).optString("tabExprId");
        ExpMgrListProcessor.c().put(Integer.valueOf(k), localObject);
        i += 1;
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      ABTestUtil.a("QQExpListProcessor", ExpMgrListProcessor.c().toString());
    }
  }
  
  public String a()
  {
    return String.format("[taskId:%s, content:%s]", new Object[] { Integer.valueOf(this.a), this.b });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.abtest.ExpMgrListProcessor.ExpMgrListData
 * JD-Core Version:    0.7.0.1
 */