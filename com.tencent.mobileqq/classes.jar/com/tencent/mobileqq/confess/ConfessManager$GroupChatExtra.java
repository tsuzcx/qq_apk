package com.tencent.mobileqq.confess;

import android.text.TextUtils;
import org.json.JSONObject;

class ConfessManager$GroupChatExtra
{
  public String a;
  public String b;
  public int c;
  public int d;
  public int e;
  public String f;
  public int g;
  public String h;
  public String i;
  public String j;
  public String k;
  public long l;
  public int m;
  public boolean n = false;
  
  public static GroupChatExtra a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    GroupChatExtra localGroupChatExtra = new GroupChatExtra();
    try
    {
      paramString = new JSONObject(paramString);
      localGroupChatExtra.a = paramString.optString("strGroupUin");
      localGroupChatExtra.b = paramString.optString("strSendUin");
      localGroupChatExtra.c = paramString.optInt("nTopicId");
      localGroupChatExtra.d = paramString.optInt("nBGType");
      localGroupChatExtra.e = paramString.optInt("nConfessorSex");
      localGroupChatExtra.f = paramString.optString("strRecNick");
      localGroupChatExtra.g = paramString.optInt("nRecNickType");
      localGroupChatExtra.h = paramString.optString("strRecUin");
      localGroupChatExtra.i = paramString.optString("strConfessorUin");
      localGroupChatExtra.j = paramString.optString("strConfessorDesc");
      localGroupChatExtra.k = paramString.optString("strConfessorNick");
      localGroupChatExtra.m = paramString.optInt("flag");
      localGroupChatExtra.l = paramString.optInt("confessTime");
      localGroupChatExtra.n = paramString.optBoolean("isRandomShmsgseq");
      return localGroupChatExtra;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public String a()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("strGroupUin", this.a);
      ((JSONObject)localObject).put("strSendUin", this.b);
      ((JSONObject)localObject).put("nTopicId", this.c);
      ((JSONObject)localObject).put("nBGType", this.d);
      ((JSONObject)localObject).put("nConfessorSex", this.e);
      ((JSONObject)localObject).put("strRecNick", this.f);
      ((JSONObject)localObject).put("nRecNickType", this.g);
      ((JSONObject)localObject).put("strRecUin", this.h);
      ((JSONObject)localObject).put("strConfessorUin", this.i);
      ((JSONObject)localObject).put("strConfessorDesc", this.j);
      ((JSONObject)localObject).put("strConfessorNick", this.k);
      ((JSONObject)localObject).put("flag", this.m);
      ((JSONObject)localObject).put("confessTime", this.l);
      ((JSONObject)localObject).put("isRandomShmsgseq", this.n);
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
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessManager.GroupChatExtra
 * JD-Core Version:    0.7.0.1
 */