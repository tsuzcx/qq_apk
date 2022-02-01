package com.tencent.mobileqq.kandian.repo.ad;

import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class SmallMiniGameInfo
{
  public String a = "";
  public String b = "";
  public String c = "2";
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  public String h = "";
  public String i = "";
  public int j = 0;
  public JSONArray k;
  public int l;
  public String m = "";
  public String n = "";
  public String o = "";
  public String p = "";
  public String q = "";
  public String r = "";
  public String s = "";
  public String t;
  public String u;
  public String v;
  public String w;
  public String x;
  public CopyOnWriteArrayList<SmallMiniGameInfo.SmallMiniGameData> y;
  
  public static SmallMiniGameInfo a(String paramString)
  {
    SmallMiniGameInfo localSmallMiniGameInfo = new SmallMiniGameInfo();
    try
    {
      paramString = new JSONObject(paramString);
      localSmallMiniGameInfo.a = paramString.optString("more_btn_url");
      localSmallMiniGameInfo.b = paramString.optString("trace_id");
      localSmallMiniGameInfo.d = paramString.optString("md_style");
      localSmallMiniGameInfo.f = paramString.optString("game_tips");
      localSmallMiniGameInfo.g = paramString.optString("game_tips_icon");
      localSmallMiniGameInfo.m = paramString.optString("game_id");
      localSmallMiniGameInfo.r = paramString.optString("game_name");
      localSmallMiniGameInfo.o = paramString.optString("game_icon");
      localSmallMiniGameInfo.p = paramString.optString("game_desc");
      localSmallMiniGameInfo.q = paramString.optString("game_btn_text");
      localSmallMiniGameInfo.n = paramString.optString("game_jump_url");
      localSmallMiniGameInfo.k = paramString.optJSONArray("app_picthree");
      localSmallMiniGameInfo.s = paramString.optString("article_title");
      localSmallMiniGameInfo.l = paramString.optInt("card_size");
      localSmallMiniGameInfo.j = paramString.optInt("style_type");
      localSmallMiniGameInfo.h = paramString.optString("left_big_img_url");
      localSmallMiniGameInfo.i = paramString.optString("background_img_url");
      localSmallMiniGameInfo.t = paramString.optString("guide_icon");
      localSmallMiniGameInfo.w = paramString.optString("guide_jump_url");
      localSmallMiniGameInfo.x = paramString.optString("guide_name");
      localSmallMiniGameInfo.v = paramString.optString("guide_btn_unsubscribed");
      localSmallMiniGameInfo.u = paramString.optString("guide_btn_subscribed");
      int i1 = paramString.optInt("obj_type");
      if (i1 != 0) {
        localSmallMiniGameInfo.c = String.valueOf(i1);
      }
      if (localSmallMiniGameInfo.l > 0)
      {
        a(paramString, localSmallMiniGameInfo.l, localSmallMiniGameInfo);
        return localSmallMiniGameInfo;
      }
      a(paramString, 5, localSmallMiniGameInfo);
      return localSmallMiniGameInfo;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("json error:");
        localStringBuilder.append(paramString.getMessage());
        QLog.e("SmallMiniGameInfo", 2, localStringBuilder.toString());
      }
    }
    return localSmallMiniGameInfo;
  }
  
  private static void a(JSONObject paramJSONObject, int paramInt, SmallMiniGameInfo paramSmallMiniGameInfo)
  {
    paramSmallMiniGameInfo.y = new CopyOnWriteArrayList();
    int i1 = 1;
    while (i1 <= paramInt)
    {
      SmallMiniGameInfo.SmallMiniGameData localSmallMiniGameData = new SmallMiniGameInfo.SmallMiniGameData();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("game_id");
      localStringBuilder.append(i1);
      localSmallMiniGameData.a = paramJSONObject.optString(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("game_slot_type");
      localStringBuilder.append(i1);
      localSmallMiniGameData.c = paramJSONObject.optString(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("game_title");
      localStringBuilder.append(i1);
      localSmallMiniGameData.d = paramJSONObject.optString(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("game_url");
      localStringBuilder.append(i1);
      localSmallMiniGameData.b = paramJSONObject.optString(localStringBuilder.toString());
      paramSmallMiniGameInfo.y.add(localSmallMiniGameData);
      i1 += 1;
    }
  }
  
  public String a(int paramInt)
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = this.y;
    if ((localCopyOnWriteArrayList != null) && (localCopyOnWriteArrayList.size() > paramInt)) {
      return ((SmallMiniGameInfo.SmallMiniGameData)this.y.get(paramInt)).a;
    }
    return "";
  }
  
  public boolean a()
  {
    return this.j == 0;
  }
  
  public String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = this.y;
    if ((localObject != null) && (((CopyOnWriteArrayList)localObject).size() > 0))
    {
      localObject = this.y.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localStringBuilder.append(((SmallMiniGameInfo.SmallMiniGameData)((Iterator)localObject).next()).a);
        localStringBuilder.append(",");
      }
    }
    return localStringBuilder.toString();
  }
  
  public String b(int paramInt)
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = this.y;
    if ((localCopyOnWriteArrayList != null) && (localCopyOnWriteArrayList.size() > paramInt)) {
      return ((SmallMiniGameInfo.SmallMiniGameData)this.y.get(paramInt)).b;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.ad.SmallMiniGameInfo
 * JD-Core Version:    0.7.0.1
 */