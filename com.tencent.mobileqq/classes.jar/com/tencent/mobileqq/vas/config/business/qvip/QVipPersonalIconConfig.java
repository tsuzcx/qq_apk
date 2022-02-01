package com.tencent.mobileqq.vas.config.business.qvip;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class QVipPersonalIconConfig
{
  public static HashMap<String, String> a = new HashMap();
  public static final HashMap<String, Integer> b;
  private static String c = "skin_leba_tongyong_bg";
  private static String d = "https://zb.vip.qq.com/v2/pages/themeMall?_wv=16778243&from=themeIcon";
  private boolean e = false;
  
  static
  {
    b = new HashMap();
    b.put("skin_leba_fujin_bg", Integer.valueOf(2130852351));
    b.put("skin_leba_xingqubuluo_bg", Integer.valueOf(2130852368));
    b.put("skin_leba_youxi_bg", Integer.valueOf(2130852371));
    b.put("skin_leba_wanyiwan_bg", Integer.valueOf(2130852364));
    b.put("skin_leba_weishi_bg", Integer.valueOf(2130852365));
    b.put("skin_leba_gouwu_bg", Integer.valueOf(2130852352));
    b.put("skin_leba_bodongdongman_bg", Integer.valueOf(2130852349));
    b.put("skin_leba_zhibo_bg", Integer.valueOf(2130852373));
    b.put("skin_leba_qiedianjing_bg", Integer.valueOf(2130852355));
    b.put("skin_leba_pupudushu_bg", Integer.valueOf(2130852354));
    b.put("skin_leba_yinyue_bg", Integer.valueOf(2130852370));
    b.put("skin_leba_yingyongbao_bg", Integer.valueOf(2130852369));
    b.put("skin_leba_tanbaishuo_bg", Integer.valueOf(2130852358));
    b.put("skin_leba_yundong_bg", Integer.valueOf(2130852372));
    b.put("skin_leba_chihewanle_bg", Integer.valueOf(2130852350));
    b.put("skin_leba_tongchengfuwu_bg", Integer.valueOf(2130852362));
    b.put("skin_leba_tengxunxinwen_bg", Integer.valueOf(2130852360));
    b.put("skin_leba_tengxunketang_bg", Integer.valueOf(2130852359));
    b.put("skin_leba_qiefudao_bg", Integer.valueOf(2130852356));
    b.put("skin_leba_xiaoyuankuolie_bg", Integer.valueOf(2130852367));
    b.put("skin_leba_tongyong_bg", Integer.valueOf(2130852363));
  }
  
  @NonNull
  public static QVipPersonalIconConfig a(String paramString)
  {
    QVipPersonalIconConfig localQVipPersonalIconConfig = new QVipPersonalIconConfig();
    if (TextUtils.isEmpty(paramString))
    {
      localQVipPersonalIconConfig.e = false;
      return localQVipPersonalIconConfig;
    }
    localQVipPersonalIconConfig.e = true;
    d(paramString);
    return localQVipPersonalIconConfig;
  }
  
  private static void d(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).getJSONObject("android");
      JSONObject localJSONObject = paramString.getJSONObject("backgroundIconConfig");
      if (localJSONObject != null)
      {
        Iterator localIterator = localJSONObject.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          a.put(str, localJSONObject.getString(str));
        }
      }
      c = paramString.getString("defaultIconName");
      d = paramString.getString("themeStoreUrl");
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public String a()
  {
    return d;
  }
  
  public String b(String paramString)
  {
    String str = (String)a.get(paramString);
    paramString = str;
    if (TextUtils.isEmpty(str)) {
      paramString = c;
    }
    return paramString;
  }
  
  public boolean b()
  {
    return this.e;
  }
  
  public int c(String paramString)
  {
    paramString = (Integer)b.get(paramString);
    if (paramString == null) {
      return 0;
    }
    return paramString.intValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.QVipPersonalIconConfig
 * JD-Core Version:    0.7.0.1
 */