package com.tencent.mobileqq.config.business.qvip;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class QVipPersonalIconConfig
{
  private static String jdField_a_of_type_JavaLangString;
  public static HashMap<String, String> a;
  private static String b;
  public static final HashMap<String, Integer> b;
  private boolean jdField_a_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaLangString = "skin_leba_tongyong_bg";
    jdField_b_of_type_JavaLangString = "https://zb.vip.qq.com/v2/pages/themeMall?_wv=16778243&from=themeIcon";
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_fujin_bg", Integer.valueOf(2130850627));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_xingqubuluo_bg", Integer.valueOf(2130850646));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_youxi_bg", Integer.valueOf(2130850649));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_wanyiwan_bg", Integer.valueOf(2130850642));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_weishi_bg", Integer.valueOf(2130850643));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_gouwu_bg", Integer.valueOf(2130850628));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_bodongdongman_bg", Integer.valueOf(2130850625));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_zhibo_bg", Integer.valueOf(2130850651));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_qiedianjing_bg", Integer.valueOf(2130850631));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_pupudushu_bg", Integer.valueOf(2130850630));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_yinyue_bg", Integer.valueOf(2130850648));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_yingyongbao_bg", Integer.valueOf(2130850647));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_tanbaishuo_bg", Integer.valueOf(2130850636));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_yundong_bg", Integer.valueOf(2130850650));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_chihewanle_bg", Integer.valueOf(2130850626));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_tongchengfuwu_bg", Integer.valueOf(2130850640));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_tengxunxinwen_bg", Integer.valueOf(2130850638));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_tengxunketang_bg", Integer.valueOf(2130850637));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_qiefudao_bg", Integer.valueOf(2130850632));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_xiaoyuankuolie_bg", Integer.valueOf(2130850645));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_tongyong_bg", Integer.valueOf(2130850641));
  }
  
  @NonNull
  public static QVipPersonalIconConfig a(String paramString)
  {
    QVipPersonalIconConfig localQVipPersonalIconConfig = new QVipPersonalIconConfig();
    if (TextUtils.isEmpty(paramString))
    {
      localQVipPersonalIconConfig.jdField_a_of_type_Boolean = false;
      return localQVipPersonalIconConfig;
    }
    localQVipPersonalIconConfig.jdField_a_of_type_Boolean = true;
    a(paramString);
    return localQVipPersonalIconConfig;
  }
  
  private static void a(String paramString)
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
          jdField_a_of_type_JavaUtilHashMap.put(str, localJSONObject.getString(str));
        }
      }
      jdField_a_of_type_JavaLangString = paramString.getString("defaultIconName");
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      return;
    }
    jdField_b_of_type_JavaLangString = paramString.getString("themeStoreUrl");
  }
  
  public int a(String paramString)
  {
    paramString = (Integer)jdField_b_of_type_JavaUtilHashMap.get(paramString);
    if (paramString == null) {
      return 0;
    }
    return paramString.intValue();
  }
  
  public String a()
  {
    return jdField_b_of_type_JavaLangString;
  }
  
  public String a(String paramString)
  {
    String str = (String)jdField_a_of_type_JavaUtilHashMap.get(paramString);
    paramString = str;
    if (TextUtils.isEmpty(str)) {
      paramString = jdField_a_of_type_JavaLangString;
    }
    return paramString;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qvip.QVipPersonalIconConfig
 * JD-Core Version:    0.7.0.1
 */