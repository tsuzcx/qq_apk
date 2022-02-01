package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class AudioInfo
  extends UploadEditItemInfo
{
  public String a;
  public String b;
  public int c;
  public int d;
  public String e;
  public boolean f = false;
  
  public AudioInfo(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramString3;
    if (TextUtils.isEmpty(this.b)) {
      this.o = 0;
    } else {
      this.o = 3;
    }
    this.h = new JSONObject();
    try
    {
      this.h.put("type", "voice");
      if (!TextUtils.isEmpty(this.a)) {
        this.h.put("path", this.a);
      }
      if (!TextUtils.isEmpty(this.b)) {
        this.h.put("url", this.b);
      }
      if (this.c > 0) {
        this.h.put("time", this.c);
      }
      if (this.d > 0)
      {
        this.h.put("size", this.d);
        return;
      }
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public AudioInfo(JSONObject paramJSONObject)
  {
    a(paramJSONObject);
  }
  
  public int a()
  {
    return 0;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
    try
    {
      this.h.put("path", paramString);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.h = paramJSONObject;
    this.a = paramJSONObject.optString("path");
    this.b = paramJSONObject.optString("url");
    this.c = paramJSONObject.optInt("time");
    this.d = paramJSONObject.optInt("size");
    if (TextUtils.isEmpty(this.b))
    {
      this.o = 0;
      return;
    }
    this.o = 3;
  }
  
  public int b()
  {
    return 3;
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
    try
    {
      this.h.put("url", paramString);
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    if (TextUtils.isEmpty(this.b))
    {
      this.o = 0;
      return;
    }
    this.o = 3;
  }
  
  public boolean c()
  {
    return HttpUtil.isValidUrl(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.AudioInfo
 * JD-Core Version:    0.7.0.1
 */