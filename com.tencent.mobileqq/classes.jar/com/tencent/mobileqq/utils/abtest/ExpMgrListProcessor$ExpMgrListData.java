package com.tencent.mobileqq.utils.abtest;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ExpMgrListProcessor$ExpMgrListData
{
  public int a;
  public String a;
  
  public ExpMgrListProcessor$ExpMgrListData()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public ExpMgrListProcessor$ExpMgrListData(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    try
    {
      JSONArray localJSONArray = new JSONArray(this.jdField_a_of_type_JavaLangString);
      int j = localJSONArray.length();
      int i = 0;
      while (i < j)
      {
        Object localObject = localJSONArray.getJSONObject(i);
        int k = ((JSONObject)localObject).optInt("mgrTypeId");
        localObject = ((JSONObject)localObject).optString("tabExprId");
        ExpMgrListProcessor.b().put(Integer.valueOf(k), localObject);
        i += 1;
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      ABTestUtil.a("QQExpListProcessor", ExpMgrListProcessor.b().toString());
    }
  }
  
  public String a()
  {
    return String.format("[taskId:%s, content:%s]", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.abtest.ExpMgrListProcessor.ExpMgrListData
 * JD-Core Version:    0.7.0.1
 */