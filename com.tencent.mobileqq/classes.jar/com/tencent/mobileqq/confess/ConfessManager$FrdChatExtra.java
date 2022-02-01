package com.tencent.mobileqq.confess;

import android.text.TextUtils;
import org.json.JSONObject;

class ConfessManager$FrdChatExtra
{
  public int a;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public long l;
  public int m;
  
  public static FrdChatExtra a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    FrdChatExtra localFrdChatExtra = new FrdChatExtra();
    try
    {
      paramString = new JSONObject(paramString);
      localFrdChatExtra.a = paramString.optInt("nTopicId");
      localFrdChatExtra.b = paramString.optInt("nBGType");
      localFrdChatExtra.c = paramString.optInt("nConfessorSex");
      localFrdChatExtra.g = paramString.optString("strRecNick");
      localFrdChatExtra.h = paramString.optString("strRecUin");
      localFrdChatExtra.i = paramString.optString("strConfessorUin");
      localFrdChatExtra.j = paramString.optString("strConfessorDesc");
      localFrdChatExtra.k = paramString.optString("strConfessorNick");
      localFrdChatExtra.m = paramString.optInt("flag");
      localFrdChatExtra.l = paramString.optInt("confessTime");
      localFrdChatExtra.d = paramString.optInt("nConfessNum");
      localFrdChatExtra.e = paramString.optInt("nGetConfessSex");
      localFrdChatExtra.f = paramString.optInt("nBizType");
      return localFrdChatExtra;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public String a()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("nTopicId", this.a);
      ((JSONObject)localObject).put("nBGType", this.b);
      ((JSONObject)localObject).put("nConfessorSex", this.c);
      ((JSONObject)localObject).put("strRecNick", this.g);
      ((JSONObject)localObject).put("strRecUin", this.h);
      ((JSONObject)localObject).put("strConfessorUin", this.i);
      ((JSONObject)localObject).put("strConfessorDesc", this.j);
      ((JSONObject)localObject).put("strConfessorNick", this.k);
      ((JSONObject)localObject).put("flag", this.m);
      ((JSONObject)localObject).put("confessTime", this.l);
      ((JSONObject)localObject).put("nConfessNum", this.d);
      ((JSONObject)localObject).put("nGetConfessSex", this.e);
      ((JSONObject)localObject).put("nBizType", this.f);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessManager.FrdChatExtra
 * JD-Core Version:    0.7.0.1
 */