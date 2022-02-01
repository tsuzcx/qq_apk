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
  public String T = "mqqapi://miniapp/open?_atype=0&_mappid=1110647717&_mvid=&_vt=3&via=2016_71&_sig=1295754989";
  public int a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public boolean c;
  public String d;
  public boolean d;
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
  
  public FriendIntimateRelationshipBean()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "https://ti.qq.com/hybrid-h5/intimate/list?_wv=83886083";
    this.jdField_b_of_type_JavaLangString = "https://ti.qq.com/hybrid-h5/intimate/launch?_wv=83886083";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 80;
    this.jdField_b_of_type_Int = 100;
    this.jdField_c_of_type_Int = 80;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = true;
  }
  
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
          localFriendIntimateRelationshipBean.jdField_a_of_type_Boolean = bool;
          localFriendIntimateRelationshipBean.jdField_a_of_type_JavaLangString = paramString.optString("managePageURL", "https://ti.qq.com/hybrid-h5/intimate/list?_wv=83886083");
          if (TextUtils.isEmpty(localFriendIntimateRelationshipBean.jdField_a_of_type_JavaLangString)) {
            localFriendIntimateRelationshipBean.jdField_a_of_type_JavaLangString = "https://ti.qq.com/hybrid-h5/intimate/list?_wv=83886083";
          }
          localFriendIntimateRelationshipBean.jdField_b_of_type_JavaLangString = paramString.optString("bindPageURL", "https://ti.qq.com/hybrid-h5/intimate/launch?_wv=83886083");
          if (TextUtils.isEmpty(localFriendIntimateRelationshipBean.jdField_b_of_type_JavaLangString)) {
            localFriendIntimateRelationshipBean.jdField_b_of_type_JavaLangString = "https://ti.qq.com/hybrid-h5/intimate/launch?_wv=83886083";
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
                localFriendIntimateRelationshipBean.jdField_c_of_type_JavaLangString = localJSONArray.getString(0);
              }
            }
            if ((localObject != null) && (((JSONObject)localObject).has("relationGuimi")))
            {
              localJSONArray = ((JSONObject)localObject).optJSONArray("relationGuimi");
              if ((localJSONArray != null) && (localJSONArray.length() > 2))
              {
                localFriendIntimateRelationshipBean.jdField_d_of_type_JavaLangString = localJSONArray.getString(0);
                localFriendIntimateRelationshipBean.e = localJSONArray.getString(1);
                localFriendIntimateRelationshipBean.f = localJSONArray.getString(2);
              }
            }
            if ((localObject != null) && (((JSONObject)localObject).has("relationBestFriend")))
            {
              localJSONArray = ((JSONObject)localObject).optJSONArray("relationBestFriend");
              if ((localJSONArray != null) && (localJSONArray.length() > 2))
              {
                localFriendIntimateRelationshipBean.g = localJSONArray.getString(0);
                localFriendIntimateRelationshipBean.h = localJSONArray.getString(1);
                localFriendIntimateRelationshipBean.i = localJSONArray.getString(2);
              }
            }
            if ((localObject != null) && (((JSONObject)localObject).has("relationJiyou")))
            {
              localJSONArray = ((JSONObject)localObject).optJSONArray("relationJiyou");
              if ((localJSONArray != null) && (localJSONArray.length() > 2))
              {
                localFriendIntimateRelationshipBean.j = localJSONArray.getString(0);
                localFriendIntimateRelationshipBean.k = localJSONArray.getString(1);
                localFriendIntimateRelationshipBean.l = localJSONArray.getString(2);
              }
            }
            if ((localObject != null) && (((JSONObject)localObject).has("relationLover")))
            {
              localObject = ((JSONObject)localObject).optJSONArray("relationLover");
              if ((localObject != null) && (((JSONArray)localObject).length() > 2))
              {
                localFriendIntimateRelationshipBean.m = ((JSONArray)localObject).getString(0);
                localFriendIntimateRelationshipBean.n = ((JSONArray)localObject).getString(1);
                localFriendIntimateRelationshipBean.o = ((JSONArray)localObject).getString(2);
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
                localFriendIntimateRelationshipBean.p = localJSONArray.getString(0);
                localFriendIntimateRelationshipBean.q = localJSONArray.getString(1);
                localFriendIntimateRelationshipBean.r = localJSONArray.getString(2);
              }
            }
            if ((localObject != null) && (((JSONObject)localObject).has("relationBestFriend")))
            {
              localJSONArray = ((JSONObject)localObject).optJSONArray("relationBestFriend");
              if ((localJSONArray != null) && (localJSONArray.length() > 2))
              {
                localFriendIntimateRelationshipBean.s = localJSONArray.getString(0);
                localFriendIntimateRelationshipBean.t = localJSONArray.getString(1);
                localFriendIntimateRelationshipBean.u = localJSONArray.getString(2);
              }
            }
            if ((localObject != null) && (((JSONObject)localObject).has("relationJiyou")))
            {
              localJSONArray = ((JSONObject)localObject).optJSONArray("relationJiyou");
              if ((localJSONArray != null) && (localJSONArray.length() > 2))
              {
                localFriendIntimateRelationshipBean.v = localJSONArray.getString(0);
                localFriendIntimateRelationshipBean.w = localJSONArray.getString(1);
                localFriendIntimateRelationshipBean.x = localJSONArray.getString(2);
              }
            }
            if ((localObject != null) && (((JSONObject)localObject).has("relationLover")))
            {
              localObject = ((JSONObject)localObject).optJSONArray("relationLover");
              if ((localObject != null) && (((JSONArray)localObject).length() > 2))
              {
                localFriendIntimateRelationshipBean.y = ((JSONArray)localObject).getString(0);
                localFriendIntimateRelationshipBean.z = ((JSONArray)localObject).getString(1);
                localFriendIntimateRelationshipBean.A = ((JSONArray)localObject).getString(2);
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
                localFriendIntimateRelationshipBean.B = localJSONArray.getString(0);
              }
            }
            if ((localObject != null) && (((JSONObject)localObject).has("relationGuimi")))
            {
              localJSONArray = ((JSONObject)localObject).optJSONArray("relationGuimi");
              if ((localJSONArray != null) && (localJSONArray.length() > 2))
              {
                localFriendIntimateRelationshipBean.C = localJSONArray.getString(0);
                localFriendIntimateRelationshipBean.D = localJSONArray.getString(1);
                localFriendIntimateRelationshipBean.E = localJSONArray.getString(2);
              }
            }
            if ((localObject != null) && (((JSONObject)localObject).has("relationBestFriend")))
            {
              localJSONArray = ((JSONObject)localObject).optJSONArray("relationBestFriend");
              if ((localJSONArray != null) && (localJSONArray.length() > 2))
              {
                localFriendIntimateRelationshipBean.F = localJSONArray.getString(0);
                localFriendIntimateRelationshipBean.G = localJSONArray.getString(1);
                localFriendIntimateRelationshipBean.H = localJSONArray.getString(2);
              }
            }
            if ((localObject != null) && (((JSONObject)localObject).has("relationJiyou")))
            {
              localJSONArray = ((JSONObject)localObject).optJSONArray("relationJiyou");
              if ((localJSONArray != null) && (localJSONArray.length() > 2))
              {
                localFriendIntimateRelationshipBean.I = localJSONArray.getString(0);
                localFriendIntimateRelationshipBean.J = localJSONArray.getString(1);
                localFriendIntimateRelationshipBean.K = localJSONArray.getString(2);
              }
            }
            if ((localObject != null) && (((JSONObject)localObject).has("relationLover")))
            {
              localObject = ((JSONObject)localObject).optJSONArray("relationLover");
              if ((localObject != null) && (((JSONArray)localObject).length() > 2))
              {
                localFriendIntimateRelationshipBean.L = ((JSONArray)localObject).getString(0);
                localFriendIntimateRelationshipBean.M = ((JSONArray)localObject).getString(1);
                localFriendIntimateRelationshipBean.N = ((JSONArray)localObject).getString(2);
              }
            }
          }
          if (paramString.has("scoreAnimation")) {
            localFriendIntimateRelationshipBean.Q = paramString.optString("scoreAnimation");
          }
          if (paramString.has("scoreAnimationMd5")) {
            localFriendIntimateRelationshipBean.R = paramString.optString("scoreAnimationMd5");
          }
          if (paramString.has("scoreRuleURL")) {
            localFriendIntimateRelationshipBean.S = paramString.optString("scoreRuleURL");
          }
          if (paramString.has("scoreDisplayIntimateMin")) {
            localFriendIntimateRelationshipBean.jdField_a_of_type_Int = paramString.optInt("scoreDisplayIntimateMin");
          }
          if (paramString.has("scoreDisplayFriendMin")) {
            localFriendIntimateRelationshipBean.jdField_b_of_type_Int = paramString.optInt("scoreDisplayFriendMin");
          }
          if (paramString.has("scoreDisplayFriendMin818")) {
            localFriendIntimateRelationshipBean.jdField_c_of_type_Int = paramString.optInt("scoreDisplayFriendMin818");
          }
          if (paramString.has("coupleAchievementSwitch")) {
            localFriendIntimateRelationshipBean.jdField_b_of_type_Boolean = paramString.optBoolean("coupleAchievementSwitch");
          }
          if (paramString.has("oldFriendDnaSwitch")) {
            localFriendIntimateRelationshipBean.jdField_c_of_type_Boolean = paramString.optBoolean("oldFriendDnaSwitch");
          }
          if (paramString.has("newFriendDnaSwitch")) {
            localFriendIntimateRelationshipBean.jdField_d_of_type_Boolean = paramString.optBoolean("newFriendDnaSwitch");
          }
          if (paramString.has("loveAchieveScheme")) {
            localFriendIntimateRelationshipBean.T = paramString.optString("loveAchieveScheme");
          }
          localFriendIntimateRelationshipBean.O = paramString.optString("gifNormalUrl");
          localFriendIntimateRelationshipBean.P = paramString.optString("gifNightUrl");
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
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(" managePageURL:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" bindPageURL:");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(" relationNoBgUrl:");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append(" relationGuimiBg0Url:");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append(" relationGuimiBg1Url:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" relationGuimiBg2Url:");
    localStringBuilder.append(this.f);
    localStringBuilder.append(" relationSidangBg0Url:");
    localStringBuilder.append(this.g);
    localStringBuilder.append(" relationSidangBg1Url:");
    localStringBuilder.append(this.h);
    localStringBuilder.append(" relationSidangBg2Url:");
    localStringBuilder.append(this.i);
    localStringBuilder.append(" relationJiyouBg0Url:");
    localStringBuilder.append(this.j);
    localStringBuilder.append(" relationJiyouBg1Url:");
    localStringBuilder.append(this.k);
    localStringBuilder.append(" relationJiyouBg2Url:");
    localStringBuilder.append(this.l);
    localStringBuilder.append(" relationLoverBg0Url:");
    localStringBuilder.append(this.m);
    localStringBuilder.append(" relationLoverBg1Url:");
    localStringBuilder.append(this.n);
    localStringBuilder.append(" relationLoverBg2Url:");
    localStringBuilder.append(this.o);
    localStringBuilder.append(" relationGuimiDarkBg0Url:");
    localStringBuilder.append(this.p);
    localStringBuilder.append(" relationGuimiDarkBg1Url:");
    localStringBuilder.append(this.q);
    localStringBuilder.append(" relationGuimiDarkBg2Url:");
    localStringBuilder.append(this.r);
    localStringBuilder.append(" relationSidangDarkBg0Url:");
    localStringBuilder.append(this.s);
    localStringBuilder.append(" relationSidangDarkBg1Url:");
    localStringBuilder.append(this.t);
    localStringBuilder.append(" relationSidangDarkBg2Url:");
    localStringBuilder.append(this.u);
    localStringBuilder.append(" relationJiyouDarkBg0Url:");
    localStringBuilder.append(this.v);
    localStringBuilder.append(" relationJiyouDarkBg1Url:");
    localStringBuilder.append(this.w);
    localStringBuilder.append(" relationJiyouDarkBg2Url:");
    localStringBuilder.append(this.x);
    localStringBuilder.append(" relationLoverDarkBg0Url:");
    localStringBuilder.append(this.y);
    localStringBuilder.append(" relationLoverDarkBg1Url:");
    localStringBuilder.append(this.z);
    localStringBuilder.append(" relationLoverDarkBg2Url:");
    localStringBuilder.append(this.A);
    localStringBuilder.append(" relationNoShareUrl:");
    localStringBuilder.append(this.B);
    localStringBuilder.append(" relationGuimiShare0Url:");
    localStringBuilder.append(this.C);
    localStringBuilder.append(" relationGuimiShare1Url:");
    localStringBuilder.append(this.D);
    localStringBuilder.append(" relationGuimiShare2Url:");
    localStringBuilder.append(this.E);
    localStringBuilder.append(" relationSidangShare0Url:");
    localStringBuilder.append(this.F);
    localStringBuilder.append(" relationSidangShare1Url:");
    localStringBuilder.append(this.G);
    localStringBuilder.append(" relationSidangShare2Url:");
    localStringBuilder.append(this.H);
    localStringBuilder.append(" relationJiyouShare0Url:");
    localStringBuilder.append(this.I);
    localStringBuilder.append(" relationJiyouShare1Url:");
    localStringBuilder.append(this.J);
    localStringBuilder.append(" relationJiyouShare2Url:");
    localStringBuilder.append(this.K);
    localStringBuilder.append(" relationLoverShare0Url:");
    localStringBuilder.append(this.L);
    localStringBuilder.append(" relationLoverShare1Url:");
    localStringBuilder.append(this.M);
    localStringBuilder.append(" relationLoverShare2Url:");
    localStringBuilder.append(this.N);
    localStringBuilder.append(" coupleAchievementSwitch:");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append(" oldFriendDnaSwitch:");
    localStringBuilder.append(this.jdField_c_of_type_Boolean);
    localStringBuilder.append(" newFriendDnaSwitch:");
    localStringBuilder.append(this.jdField_d_of_type_Boolean);
    localStringBuilder.append(" loveAchieveScheme:");
    localStringBuilder.append(this.T);
    localStringBuilder.append(" gifNormalUrl:");
    localStringBuilder.append(this.O);
    localStringBuilder.append(" gifNightUrl:");
    localStringBuilder.append(this.P);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.FriendIntimateRelationshipBean
 * JD-Core Version:    0.7.0.1
 */