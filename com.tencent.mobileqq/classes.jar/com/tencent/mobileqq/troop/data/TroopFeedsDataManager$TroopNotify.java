package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class TroopFeedsDataManager$TroopNotify
{
  public int a = 1;
  public String b = null;
  public String c = null;
  public String d = null;
  public String e = null;
  public String f = null;
  public String g = null;
  public String h = null;
  public String i = null;
  public long j = 0L;
  public String k = null;
  public boolean l = false;
  public int m = 0;
  public boolean n = true;
  public boolean o = false;
  public String p = null;
  public boolean q = false;
  
  public static TroopNotify a(QQAppInterface paramQQAppInterface, String paramString, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      if (!paramJSONObject.has("msg")) {
        return null;
      }
      TroopNotify localTroopNotify = new TroopNotify();
      localTroopNotify.b = paramJSONObject.optString("fid");
      boolean bool1 = paramJSONObject.has("is_read");
      boolean bool2 = true;
      if (bool1)
      {
        if (paramJSONObject.optInt("is_read") != 0) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        localTroopNotify.q = bool1;
      }
      JSONObject localJSONObject = paramJSONObject.optJSONObject("msg");
      if (localJSONObject == null) {
        return null;
      }
      localTroopNotify.d = localJSONObject.optString("text_face");
      Object localObject = localTroopNotify.d;
      if (localObject != null) {
        localTroopNotify.d = ((String)localObject).replace("&#10;", "<br/>");
      }
      localTroopNotify.c = localJSONObject.optString("title");
      localObject = localTroopNotify.c;
      if (localObject != null) {
        localTroopNotify.c = ((String)localObject).replace("&#10;", "<br/>");
      }
      if (localTroopNotify.c != null)
      {
        if (localTroopNotify.d == null) {
          return null;
        }
        localTroopNotify.p = paramJSONObject.optString("fid");
        localObject = localJSONObject.optJSONArray("pics");
        if ((localObject != null) && (((JSONArray)localObject).length() > 0))
        {
          localObject = ((JSONArray)localObject).optJSONObject(0);
          if (localObject != null)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("https://gdynamic.qpic.cn/gdynamic/");
            localStringBuilder.append(((JSONObject)localObject).optString("id"));
            localStringBuilder.append("/628");
            localTroopNotify.e = localStringBuilder.toString();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("https://gdynamic.qpic.cn/gdynamic/");
            localStringBuilder.append(((JSONObject)localObject).optString("id"));
            localStringBuilder.append("/");
            localTroopNotify.f = localStringBuilder.toString();
          }
        }
        localObject = paramJSONObject.optJSONObject("settings");
        if (localObject != null)
        {
          if (((JSONObject)localObject).optInt("is_show_edit_card", 0) == 1) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          localTroopNotify.l = bool1;
          if (((JSONObject)localObject).optInt("tip_window_type", 0) == 0) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          localTroopNotify.n = bool1;
          if (((JSONObject)localObject).optInt("confirm_required", 0) == 1) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }
          localTroopNotify.o = bool1;
        }
        if (localJSONObject.has("v"))
        {
          localJSONObject = localJSONObject.optJSONObject("v");
          localTroopNotify.g = localJSONObject.optString("l");
          localTroopNotify.e = localJSONObject.optString("bi");
        }
        localTroopNotify.h = paramJSONObject.optString("u");
        localTroopNotify.i = ContactUtils.b(paramQQAppInterface, paramString, localTroopNotify.h);
        localTroopNotify.j = paramJSONObject.optLong("pubt");
        localTroopNotify.m = paramJSONObject.optInt("read_num");
        return localTroopNotify;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFeedsDataManager.TroopNotify
 * JD-Core Version:    0.7.0.1
 */