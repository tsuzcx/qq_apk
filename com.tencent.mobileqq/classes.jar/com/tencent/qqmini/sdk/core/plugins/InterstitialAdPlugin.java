package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import android.text.TextUtils;
import begv;
import begy;
import begz;
import bejy;
import beka;
import bekg;
import besl;
import bfgq;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class InterstitialAdPlugin
  extends BaseJsPlugin
{
  public static final String API_OPERATE_DESTROY = "destroy";
  public static final String API_OPERATE_INTERSTITIAL_AD = "operateInterstitialAd";
  public static final String API_OPERATE_LOAD = "load";
  public static final String API_OPERATE_SHOW = "show";
  private static final String ERRCODE = "errCode";
  private static final String ERRMSG = "errMsg";
  public static final String EVENT_INTERSTITIAL_CLOSE = "onInterstitialAdClose";
  public static final String KEY_REF_ID = "biz_src_miniapp";
  public static final HashMap<Integer, String> S_CodeMsg_Map = bfgq.a;
  private static final String TAG = "InterstitialAdPlugin";
  private Map<Integer, InterstitialAdPlugin.MiniInterstitialAd> mInterstitialMap = new HashMap();
  
  static boolean isAdUnitIdValid(String paramString)
  {
    return !TextUtils.isEmpty(paramString);
  }
  
  InterstitialAdPlugin.MiniInterstitialAd getMiniInterstitialAd(int paramInt, String paramString, beka parambeka)
  {
    Object localObject2 = null;
    Object localObject1;
    if (this.mInterstitialMap.containsKey(Integer.valueOf(paramInt)))
    {
      paramString = (InterstitialAdPlugin.MiniInterstitialAd)this.mInterstitialMap.get(Integer.valueOf(paramInt));
      if (paramString != null)
      {
        localObject1 = localObject2;
        if (this.mMiniAppContext != null) {
          localObject1 = this.mMiniAppContext.a();
        }
        paramString.setJsService(parambeka.jdField_a_of_type_Begy);
        paramString.setActivity((Activity)localObject1);
      }
      return paramString;
    }
    if ((this.mMiniAppContext != null) && (this.mApkgInfo != null))
    {
      localObject1 = this.mApkgInfo.d;
      label101:
      if (this.mMiniAppContext == null) {
        break label163;
      }
    }
    label163:
    for (Activity localActivity = this.mMiniAppContext.a();; localActivity = null)
    {
      paramString = new InterstitialAdPlugin.MiniInterstitialAd(this, localActivity, paramInt, paramString, (String)localObject1, parambeka.jdField_a_of_type_Begy);
      this.mInterstitialMap.put(Integer.valueOf(paramInt), paramString);
      break;
      localObject1 = "";
      break label101;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Iterator localIterator = this.mInterstitialMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      InterstitialAdPlugin.MiniInterstitialAd localMiniInterstitialAd = (InterstitialAdPlugin.MiniInterstitialAd)((Map.Entry)localIterator.next()).getValue();
      if (localMiniInterstitialAd != null) {
        localMiniInterstitialAd.destroy();
      }
    }
  }
  
  public String operateInterstitialAd(beka parambeka)
  {
    try
    {
      besl.d("InterstitialAdPlugin", "operateInterstitialAd, jsonParams = " + parambeka.jdField_b_of_type_JavaLangString);
      JSONObject localJSONObject1 = new JSONObject(parambeka.jdField_b_of_type_JavaLangString);
      int j = localJSONObject1.optInt("id", -1);
      Object localObject = localJSONObject1.optString("adUnitId", null);
      if (!isAdUnitIdValid((String)localObject))
      {
        localJSONObject1 = bekg.b(parambeka.jdField_a_of_type_JavaLangString, localJSONObject1);
        localJSONObject1.put("errCode", 1002);
        localJSONObject1.put("errMsg", "广告单元无效");
        localObject = localJSONObject1.toString();
        parambeka.a(localJSONObject1, "广告单元无效");
        return localObject;
      }
      localObject = getMiniInterstitialAd(j, (String)localObject, parambeka);
      String str = localJSONObject1.optString("type");
      int i = localJSONObject1.optInt("compId", -1);
      if ("load".equals(str)) {
        if (!((InterstitialAdPlugin.MiniInterstitialAd)localObject).load(i, parambeka.jdField_b_of_type_Int))
        {
          localJSONObject1 = bekg.b(parambeka.jdField_a_of_type_JavaLangString, localJSONObject1);
          localJSONObject1.put("errCode", 1003);
          localJSONObject1.put("errMsg", "内部错误");
          parambeka.a(localJSONObject1, "内部错误");
        }
      }
      for (;;)
      {
        return "";
        if ("show".equals(str))
        {
          j = begv.a();
          if (j != 0)
          {
            localJSONObject1 = bekg.b(parambeka.jdField_a_of_type_JavaLangString, localJSONObject1);
            localJSONObject1.put("errCode", j);
            localJSONObject1.put("errMsg", "内部错误");
            parambeka.a(localJSONObject1, "内部错误");
            return localJSONObject1.toString();
          }
          if (((InterstitialAdPlugin.MiniInterstitialAd)localObject).show(i, parambeka.jdField_b_of_type_Int)) {
            continue;
          }
          localJSONObject1 = bekg.b(parambeka.jdField_a_of_type_JavaLangString, localJSONObject1);
          localJSONObject1.put("errCode", 1003);
          localJSONObject1.put("errMsg", "内部错误");
          parambeka.a(localJSONObject1, "内部错误");
          continue;
        }
        try
        {
          localJSONObject2.put("errCode", 1003);
          localJSONObject2.put("errMsg", "内部错误");
          parambeka.a(localJSONObject2, "内部错误");
          return localJSONObject2.toString();
          if (!"destroy".equals(str)) {
            continue;
          }
          if (((InterstitialAdPlugin.MiniInterstitialAd)localObject).destroy()) {}
          for (JSONObject localJSONObject2 = bekg.a(parambeka.jdField_a_of_type_JavaLangString, localJSONObject2);; localJSONObject2 = bekg.a(parambeka.jdField_a_of_type_JavaLangString, localJSONObject2, "内部错误").put("errCode", 1003).put("errMsg", "内部错误"))
          {
            parambeka.jdField_a_of_type_Begy.a(parambeka.jdField_b_of_type_Int, localJSONObject2.toString());
            this.mInterstitialMap.remove(Integer.valueOf(j));
            break;
          }
        }
        catch (Throwable parambeka)
        {
          break label384;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      besl.d("InterstitialAdPlugin", "operateInterstitialAdfailed e:", localThrowable);
      localJSONObject2 = bekg.b(parambeka.jdField_a_of_type_JavaLangString, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.InterstitialAdPlugin
 * JD-Core Version:    0.7.0.1
 */