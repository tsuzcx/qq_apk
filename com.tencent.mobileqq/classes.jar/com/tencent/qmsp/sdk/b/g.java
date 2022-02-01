package com.tencent.qmsp.sdk.b;

import android.text.TextUtils;
import com.tencent.qmsp.sdk.f.k;
import org.json.JSONObject;

public class g
{
  private static g c;
  private String a = "Qp.netImp";
  private f b = null;
  
  private JSONObject a(int paramInt, JSONObject paramJSONObject)
  {
    if ((paramJSONObject instanceof JSONObject))
    {
      if (paramJSONObject == null) {
        return null;
      }
      if (paramInt != 8) {}
    }
    try
    {
      paramJSONObject = paramJSONObject.toString();
      paramJSONObject = com.tencent.qmsp.sdk.c.f.a(paramInt, 0, 0, 0, paramJSONObject, "");
      if (paramJSONObject == null) {
        break label124;
      }
      if (TextUtils.isEmpty(paramJSONObject)) {
        return null;
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put(com.tencent.qmsp.sdk.a.e.a(17), paramJSONObject);
      return localJSONObject;
    }
    catch (Exception paramJSONObject)
    {
      label118:
      break label118;
    }
    if (paramInt == 9)
    {
      paramJSONObject = a(paramJSONObject);
      paramJSONObject = com.tencent.qmsp.sdk.c.f.a(paramInt, 0, 0, 0, paramJSONObject, "");
      if (paramJSONObject != null)
      {
        if (TextUtils.isEmpty(paramJSONObject)) {
          return null;
        }
        paramJSONObject = new JSONObject(paramJSONObject);
        return paramJSONObject;
      }
      return null;
      paramJSONObject.printStackTrace();
    }
    return null;
    label124:
    return null;
  }
  
  public static g b()
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new g();
        }
      }
      finally {}
    }
    return c;
  }
  
  private JSONObject b(int paramInt, JSONObject paramJSONObject)
  {
    if (((paramJSONObject instanceof JSONObject)) && (paramJSONObject != null)) {
      return a(paramInt, paramJSONObject);
    }
    return null;
  }
  
  public String a(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = paramJSONObject.optString(com.tencent.qmsp.sdk.a.e.a(17));
      return paramJSONObject;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return null;
  }
  
  public void a()
  {
    this.b = new g.a(this);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, JSONObject paramJSONObject, e parame)
  {
    if (((paramJSONObject instanceof JSONObject)) && (paramJSONObject != null) && (parame != null))
    {
      f localf = this.b;
      if (localf != null)
      {
        localf.a(paramInt1, paramString, paramInt2, paramJSONObject, parame);
        return;
      }
    }
    com.tencent.qmsp.sdk.f.g.d(this.a, 0, k.a(k.a));
  }
  
  public void a(f paramf)
  {
    if ((paramf != null) && ((paramf instanceof f)))
    {
      this.b = paramf;
      return;
    }
    com.tencent.qmsp.sdk.f.g.d(this.a, 0, k.a(k.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qmsp.sdk.b.g
 * JD-Core Version:    0.7.0.1
 */