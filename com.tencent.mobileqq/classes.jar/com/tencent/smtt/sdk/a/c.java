package com.tencent.smtt.sdk.a;

import android.text.TextUtils;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c
{
  private String a;
  private String b;
  private Integer c;
  private String d;
  private String e;
  private Integer f;
  private Integer g;
  private List<Integer> h;
  
  public String a()
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject = new JSONObject();
    try
    {
      if (!TextUtils.isEmpty(this.a)) {
        ((JSONObject)localObject).put("PP", this.a);
      }
      if (!TextUtils.isEmpty(this.b)) {
        ((JSONObject)localObject).put("PPVN", this.b);
      }
      if (this.c != null) {
        ((JSONObject)localObject).put("ADRV", this.c);
      }
      if (!TextUtils.isEmpty(this.d)) {
        ((JSONObject)localObject).put("MODEL", this.d);
      }
      if (!TextUtils.isEmpty(this.e)) {
        ((JSONObject)localObject).put("NAME", this.e);
      }
      if (this.f != null) {
        ((JSONObject)localObject).put("SDKVC", this.f);
      }
      if (this.g != null) {
        ((JSONObject)localObject).put("COMPVC", this.g);
      }
      localJSONObject.put("terminal_params", localObject);
      if (this.h != null)
      {
        localObject = new JSONArray();
        int i = 0;
        while (i < this.h.size())
        {
          ((JSONArray)localObject).put(this.h.get(i));
          i += 1;
        }
        localJSONObject.put("ids", localObject);
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    return localJSONObject.toString();
  }
  
  public void a(Integer paramInteger)
  {
    this.c = paramInteger;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(List<Integer> paramList)
  {
    this.h = paramList;
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
  }
  
  public void c(String paramString)
  {
    this.d = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.a.c
 * JD-Core Version:    0.7.0.1
 */