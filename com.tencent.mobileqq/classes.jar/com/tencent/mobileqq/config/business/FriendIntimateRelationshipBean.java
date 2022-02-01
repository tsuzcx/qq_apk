package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class FriendIntimateRelationshipBean
{
  public String A = "";
  public String B = "";
  public String C = "";
  public String D = "";
  public String E = "";
  public String F = "";
  public String G = "";
  public String H = "";
  public String I = "";
  public String J = "";
  public String K = "";
  public String L = "";
  public String M = "";
  public String N = "";
  public String O = "";
  public String P = "";
  public String Q = "";
  public String R = "";
  public String S = "";
  public String T = "";
  public int U = 80;
  public int V = 100;
  public int W = 80;
  public boolean X = true;
  public boolean Y = false;
  public boolean Z = true;
  public boolean a = false;
  public String aa = "mqqapi://miniapp/open?_atype=0&_mappid=1110647717&_mvid=&_vt=3&via=2016_71&_sig=1295754989";
  public String b = "https://ti.qq.com/hybrid-h5/intimate/list?_wv=83886083";
  public String c = "https://ti.qq.com/hybrid-h5/intimate/launch?_wv=83886083";
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  public String h = "";
  public String i = "";
  public String j = "";
  public String k = "";
  public String l = "";
  public String m = "";
  public String n = "";
  public String o = "";
  public String p = "";
  public String q = "";
  public String r = "";
  public String s = "";
  public String t = "";
  public String u = "";
  public String v = "";
  public String w = "";
  public String x = "";
  public String y = "";
  public String z = "";
  
  public static FriendIntimateRelationshipBean a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        FriendIntimateRelationshipBean localFriendIntimateRelationshipBean = new FriendIntimateRelationshipBean();
        paramString = new JSONObject(paramString);
        if (paramString.optInt("isUpgradeOpen", 0) == 1)
        {
          bool = true;
          localFriendIntimateRelationshipBean.a = bool;
          localFriendIntimateRelationshipBean.b = paramString.optString("managePageURL", "https://ti.qq.com/hybrid-h5/intimate/list?_wv=83886083");
          if (TextUtils.isEmpty(localFriendIntimateRelationshipBean.b)) {
            localFriendIntimateRelationshipBean.b = "https://ti.qq.com/hybrid-h5/intimate/list?_wv=83886083";
          }
          localFriendIntimateRelationshipBean.c = paramString.optString("bindPageURL", "https://ti.qq.com/hybrid-h5/intimate/launch?_wv=83886083");
          if (TextUtils.isEmpty(localFriendIntimateRelationshipBean.c)) {
            localFriendIntimateRelationshipBean.c = "https://ti.qq.com/hybrid-h5/intimate/launch?_wv=83886083";
          }
          bool = paramString.has("bgImg");
          Object localObject;
          JSONArray localJSONArray;
          if (bool)
          {
            localObject = paramString.optJSONObject("bgImg");
            if ((localObject != null) && (((JSONObject)localObject).has("relationNo")))
            {
              localJSONArray = ((JSONObject)localObject).optJSONArray("relationNo");
              if ((localJSONArray != null) && (localJSONArray.length() > 0)) {
                localFriendIntimateRelationshipBean.d = localJSONArray.getString(0);
              }
            }
            if ((localObject != null) && (((JSONObject)localObject).has("relationGuimi")))
            {
              localJSONArray = ((JSONObject)localObject).optJSONArray("relationGuimi");
              if ((localJSONArray != null) && (localJSONArray.length() > 2))
              {
                localFriendIntimateRelationshipBean.e = localJSONArray.getString(0);
                localFriendIntimateRelationshipBean.f = localJSONArray.getString(1);
                localFriendIntimateRelationshipBean.g = localJSONArray.getString(2);
              }
            }
            if ((localObject != null) && (((JSONObject)localObject).has("relationBestFriend")))
            {
              localJSONArray = ((JSONObject)localObject).optJSONArray("relationBestFriend");
              if ((localJSONArray != null) && (localJSONArray.length() > 2))
              {
                localFriendIntimateRelationshipBean.h = localJSONArray.getString(0);
                localFriendIntimateRelationshipBean.i = localJSONArray.getString(1);
                localFriendIntimateRelationshipBean.j = localJSONArray.getString(2);
              }
            }
            if ((localObject != null) && (((JSONObject)localObject).has("relationJiyou")))
            {
              localJSONArray = ((JSONObject)localObject).optJSONArray("relationJiyou");
              if ((localJSONArray != null) && (localJSONArray.length() > 2))
              {
                localFriendIntimateRelationshipBean.k = localJSONArray.getString(0);
                localFriendIntimateRelationshipBean.l = localJSONArray.getString(1);
                localFriendIntimateRelationshipBean.m = localJSONArray.getString(2);
              }
            }
            if ((localObject != null) && (((JSONObject)localObject).has("relationLover")))
            {
              localObject = ((JSONObject)localObject).optJSONArray("relationLover");
              if ((localObject != null) && (((JSONArray)localObject).length() > 2))
              {
                localFriendIntimateRelationshipBean.n = ((JSONArray)localObject).getString(0);
                localFriendIntimateRelationshipBean.o = ((JSONArray)localObject).getString(1);
                localFriendIntimateRelationshipBean.p = ((JSONArray)localObject).getString(2);
              }
            }
          }
          if (paramString.has("darkBgImg"))
          {
            localObject = paramString.optJSONObject("darkBgImg");
            if ((localObject != null) && (((JSONObject)localObject).has("relationGuimi")))
            {
              localJSONArray = ((JSONObject)localObject).optJSONArray("relationGuimi");
              if ((localJSONArray != null) && (localJSONArray.length() > 2))
              {
                localFriendIntimateRelationshipBean.q = localJSONArray.getString(0);
                localFriendIntimateRelationshipBean.r = localJSONArray.getString(1);
                localFriendIntimateRelationshipBean.s = localJSONArray.getString(2);
              }
            }
            if ((localObject != null) && (((JSONObject)localObject).has("relationBestFriend")))
            {
              localJSONArray = ((JSONObject)localObject).optJSONArray("relationBestFriend");
              if ((localJSONArray != null) && (localJSONArray.length() > 2))
              {
                localFriendIntimateRelationshipBean.t = localJSONArray.getString(0);
                localFriendIntimateRelationshipBean.u = localJSONArray.getString(1);
                localFriendIntimateRelationshipBean.v = localJSONArray.getString(2);
              }
            }
            if ((localObject != null) && (((JSONObject)localObject).has("relationJiyou")))
            {
              localJSONArray = ((JSONObject)localObject).optJSONArray("relationJiyou");
              if ((localJSONArray != null) && (localJSONArray.length() > 2))
              {
                localFriendIntimateRelationshipBean.w = localJSONArray.getString(0);
                localFriendIntimateRelationshipBean.x = localJSONArray.getString(1);
                localFriendIntimateRelationshipBean.y = localJSONArray.getString(2);
              }
            }
            if ((localObject != null) && (((JSONObject)localObject).has("relationLover")))
            {
              localObject = ((JSONObject)localObject).optJSONArray("relationLover");
              if ((localObject != null) && (((JSONArray)localObject).length() > 2))
              {
                localFriendIntimateRelationshipBean.z = ((JSONArray)localObject).getString(0);
                localFriendIntimateRelationshipBean.A = ((JSONArray)localObject).getString(1);
                localFriendIntimateRelationshipBean.B = ((JSONArray)localObject).getString(2);
              }
            }
          }
          if (paramString.has("shareImg"))
          {
            localObject = paramString.optJSONObject("shareImg");
            if ((localObject != null) && (((JSONObject)localObject).has("relationNo")))
            {
              localJSONArray = ((JSONObject)localObject).optJSONArray("relationNo");
              if ((localJSONArray != null) && (localJSONArray.length() > 0)) {
                localFriendIntimateRelationshipBean.C = localJSONArray.getString(0);
              }
            }
            if ((localObject != null) && (((JSONObject)localObject).has("relationGuimi")))
            {
              localJSONArray = ((JSONObject)localObject).optJSONArray("relationGuimi");
              if ((localJSONArray != null) && (localJSONArray.length() > 2))
              {
                localFriendIntimateRelationshipBean.D = localJSONArray.getString(0);
                localFriendIntimateRelationshipBean.E = localJSONArray.getString(1);
                localFriendIntimateRelationshipBean.F = localJSONArray.getString(2);
              }
            }
            if ((localObject != null) && (((JSONObject)localObject).has("relationBestFriend")))
            {
              localJSONArray = ((JSONObject)localObject).optJSONArray("relationBestFriend");
              if ((localJSONArray != null) && (localJSONArray.length() > 2))
              {
                localFriendIntimateRelationshipBean.G = localJSONArray.getString(0);
                localFriendIntimateRelationshipBean.H = localJSONArray.getString(1);
                localFriendIntimateRelationshipBean.I = localJSONArray.getString(2);
              }
            }
            if ((localObject != null) && (((JSONObject)localObject).has("relationJiyou")))
            {
              localJSONArray = ((JSONObject)localObject).optJSONArray("relationJiyou");
              if ((localJSONArray != null) && (localJSONArray.length() > 2))
              {
                localFriendIntimateRelationshipBean.J = localJSONArray.getString(0);
                localFriendIntimateRelationshipBean.K = localJSONArray.getString(1);
                localFriendIntimateRelationshipBean.L = localJSONArray.getString(2);
              }
            }
            if ((localObject != null) && (((JSONObject)localObject).has("relationLover")))
            {
              localObject = ((JSONObject)localObject).optJSONArray("relationLover");
              if ((localObject != null) && (((JSONArray)localObject).length() > 2))
              {
                localFriendIntimateRelationshipBean.M = ((JSONArray)localObject).getString(0);
                localFriendIntimateRelationshipBean.N = ((JSONArray)localObject).getString(1);
                localFriendIntimateRelationshipBean.O = ((JSONArray)localObject).getString(2);
              }
            }
          }
          if (paramString.has("scoreAnimation")) {
            localFriendIntimateRelationshipBean.R = paramString.optString("scoreAnimation");
          }
          if (paramString.has("scoreAnimationMd5")) {
            localFriendIntimateRelationshipBean.S = paramString.optString("scoreAnimationMd5");
          }
          if (paramString.has("scoreRuleURL")) {
            localFriendIntimateRelationshipBean.T = paramString.optString("scoreRuleURL");
          }
          if (paramString.has("scoreDisplayIntimateMin")) {
            localFriendIntimateRelationshipBean.U = paramString.optInt("scoreDisplayIntimateMin");
          }
          if (paramString.has("scoreDisplayFriendMin")) {
            localFriendIntimateRelationshipBean.V = paramString.optInt("scoreDisplayFriendMin");
          }
          if (paramString.has("scoreDisplayFriendMin818")) {
            localFriendIntimateRelationshipBean.W = paramString.optInt("scoreDisplayFriendMin818");
          }
          if (paramString.has("coupleAchievementSwitch")) {
            localFriendIntimateRelationshipBean.X = paramString.optBoolean("coupleAchievementSwitch");
          }
          if (paramString.has("oldFriendDnaSwitch")) {
            localFriendIntimateRelationshipBean.Y = paramString.optBoolean("oldFriendDnaSwitch");
          }
          if (paramString.has("newFriendDnaSwitch")) {
            localFriendIntimateRelationshipBean.Z = paramString.optBoolean("newFriendDnaSwitch");
          }
          if (paramString.has("loveAchieveScheme")) {
            localFriendIntimateRelationshipBean.aa = paramString.optString("loveAchieveScheme");
          }
          localFriendIntimateRelationshipBean.P = paramString.optString("gifNormalUrl");
          localFriendIntimateRelationshipBean.Q = paramString.optString("gifNightUrl");
          return localFriendIntimateRelationshipBean;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      boolean bool = false;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FriendIntimateRelationshipBean isUpgradeOpen:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" managePageURL:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" bindPageURL:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" relationNoBgUrl:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" relationGuimiBg0Url:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" relationGuimiBg1Url:");
    localStringBuilder.append(this.f);
    localStringBuilder.append(" relationGuimiBg2Url:");
    localStringBuilder.append(this.g);
    localStringBuilder.append(" relationSidangBg0Url:");
    localStringBuilder.append(this.h);
    localStringBuilder.append(" relationSidangBg1Url:");
    localStringBuilder.append(this.i);
    localStringBuilder.append(" relationSidangBg2Url:");
    localStringBuilder.append(this.j);
    localStringBuilder.append(" relationJiyouBg0Url:");
    localStringBuilder.append(this.k);
    localStringBuilder.append(" relationJiyouBg1Url:");
    localStringBuilder.append(this.l);
    localStringBuilder.append(" relationJiyouBg2Url:");
    localStringBuilder.append(this.m);
    localStringBuilder.append(" relationLoverBg0Url:");
    localStringBuilder.append(this.n);
    localStringBuilder.append(" relationLoverBg1Url:");
    localStringBuilder.append(this.o);
    localStringBuilder.append(" relationLoverBg2Url:");
    localStringBuilder.append(this.p);
    localStringBuilder.append(" relationGuimiDarkBg0Url:");
    localStringBuilder.append(this.q);
    localStringBuilder.append(" relationGuimiDarkBg1Url:");
    localStringBuilder.append(this.r);
    localStringBuilder.append(" relationGuimiDarkBg2Url:");
    localStringBuilder.append(this.s);
    localStringBuilder.append(" relationSidangDarkBg0Url:");
    localStringBuilder.append(this.t);
    localStringBuilder.append(" relationSidangDarkBg1Url:");
    localStringBuilder.append(this.u);
    localStringBuilder.append(" relationSidangDarkBg2Url:");
    localStringBuilder.append(this.v);
    localStringBuilder.append(" relationJiyouDarkBg0Url:");
    localStringBuilder.append(this.w);
    localStringBuilder.append(" relationJiyouDarkBg1Url:");
    localStringBuilder.append(this.x);
    localStringBuilder.append(" relationJiyouDarkBg2Url:");
    localStringBuilder.append(this.y);
    localStringBuilder.append(" relationLoverDarkBg0Url:");
    localStringBuilder.append(this.z);
    localStringBuilder.append(" relationLoverDarkBg1Url:");
    localStringBuilder.append(this.A);
    localStringBuilder.append(" relationLoverDarkBg2Url:");
    localStringBuilder.append(this.B);
    localStringBuilder.append(" relationNoShareUrl:");
    localStringBuilder.append(this.C);
    localStringBuilder.append(" relationGuimiShare0Url:");
    localStringBuilder.append(this.D);
    localStringBuilder.append(" relationGuimiShare1Url:");
    localStringBuilder.append(this.E);
    localStringBuilder.append(" relationGuimiShare2Url:");
    localStringBuilder.append(this.F);
    localStringBuilder.append(" relationSidangShare0Url:");
    localStringBuilder.append(this.G);
    localStringBuilder.append(" relationSidangShare1Url:");
    localStringBuilder.append(this.H);
    localStringBuilder.append(" relationSidangShare2Url:");
    localStringBuilder.append(this.I);
    localStringBuilder.append(" relationJiyouShare0Url:");
    localStringBuilder.append(this.J);
    localStringBuilder.append(" relationJiyouShare1Url:");
    localStringBuilder.append(this.K);
    localStringBuilder.append(" relationJiyouShare2Url:");
    localStringBuilder.append(this.L);
    localStringBuilder.append(" relationLoverShare0Url:");
    localStringBuilder.append(this.M);
    localStringBuilder.append(" relationLoverShare1Url:");
    localStringBuilder.append(this.N);
    localStringBuilder.append(" relationLoverShare2Url:");
    localStringBuilder.append(this.O);
    localStringBuilder.append(" coupleAchievementSwitch:");
    localStringBuilder.append(this.X);
    localStringBuilder.append(" oldFriendDnaSwitch:");
    localStringBuilder.append(this.Y);
    localStringBuilder.append(" newFriendDnaSwitch:");
    localStringBuilder.append(this.Z);
    localStringBuilder.append(" loveAchieveScheme:");
    localStringBuilder.append(this.aa);
    localStringBuilder.append(" gifNormalUrl:");
    localStringBuilder.append(this.P);
    localStringBuilder.append(" gifNightUrl:");
    localStringBuilder.append(this.Q);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.FriendIntimateRelationshipBean
 * JD-Core Version:    0.7.0.1
 */