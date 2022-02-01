package com.tencent.mobileqq.vas.config.business.qvip;

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
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_fujin_bg", Integer.valueOf(2130850553));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_xingqubuluo_bg", Integer.valueOf(2130850572));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_youxi_bg", Integer.valueOf(2130850575));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_wanyiwan_bg", Integer.valueOf(2130850568));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_weishi_bg", Integer.valueOf(2130850569));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_gouwu_bg", Integer.valueOf(2130850554));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_bodongdongman_bg", Integer.valueOf(2130850551));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_zhibo_bg", Integer.valueOf(2130850577));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_qiedianjing_bg", Integer.valueOf(2130850557));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_pupudushu_bg", Integer.valueOf(2130850556));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_yinyue_bg", Integer.valueOf(2130850574));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_yingyongbao_bg", Integer.valueOf(2130850573));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_tanbaishuo_bg", Integer.valueOf(2130850562));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_yundong_bg", Integer.valueOf(2130850576));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_chihewanle_bg", Integer.valueOf(2130850552));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_tongchengfuwu_bg", Integer.valueOf(2130850566));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_tengxunxinwen_bg", Integer.valueOf(2130850564));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_tengxunketang_bg", Integer.valueOf(2130850563));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_qiefudao_bg", Integer.valueOf(2130850558));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_xiaoyuankuolie_bg", Integer.valueOf(2130850571));
    jdField_b_of_type_JavaUtilHashMap.put("skin_leba_tongyong_bg", Integer.valueOf(2130850567));
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
      jdField_b_of_type_JavaLangString = paramString.getString("themeStoreUrl");
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.QVipPersonalIconConfig
 * JD-Core Version:    0.7.0.1
 */