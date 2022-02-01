package com.tencent.mobileqq.intervideo.lite_now_biz.config;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NowBizConfigManager
{
  private static NowBizConfigManager jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizConfigNowBizConfigManager = new NowBizConfigManager();
  private static List<String> jdField_a_of_type_JavaUtilList;
  private static Map<String, Boolean> jdField_a_of_type_JavaUtilMap = new HashMap();
  private static boolean jdField_a_of_type_Boolean;
  private Bundle jdField_a_of_type_AndroidOsBundle = null;
  private List<String> jdField_b_of_type_JavaUtilList = new ArrayList();
  private Map<String, String> jdField_b_of_type_JavaUtilMap = new HashMap();
  private List<String> c = new ArrayList();
  private List<String> d = new ArrayList();
  private List<String> e = new ArrayList();
  
  static
  {
    jdField_a_of_type_JavaUtilList = new ArrayList();
    jdField_a_of_type_Boolean = false;
  }
  
  private NowBizConfigManager()
  {
    a();
  }
  
  public static NowBizConfigManager a()
  {
    return jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizConfigNowBizConfigManager;
  }
  
  public static String a(Bundle paramBundle, String paramString)
  {
    Object localObject2 = paramBundle.getString("mqqschema");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = paramBundle.getString("mqqScheme");
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = Uri.parse((String)localObject1);
      if (localObject1 != null)
      {
        localObject1 = ((Uri)localObject1).getQueryParameter(paramString);
        break label51;
      }
    }
    localObject1 = "";
    label51:
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = paramBundle.getString(paramString);
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getValueFromBundle: bundle=");
      ((StringBuilder)localObject1).append(paramBundle.toString());
      ((StringBuilder)localObject1).append(" name=");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(" value=");
      ((StringBuilder)localObject1).append((String)localObject2);
      QLog.i("NowBizConfigManager", 1, ((StringBuilder)localObject1).toString());
    }
    return localObject2;
  }
  
  private void a()
  {
    this.jdField_b_of_type_JavaUtilList.addAll(Arrays.asList(NowBizConfigConst.a));
    this.c.addAll(Arrays.asList(NowBizConfigConst.b));
    jdField_a_of_type_JavaUtilList.addAll(Arrays.asList(NowBizConfigConst.c));
  }
  
  private void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    jdField_a_of_type_JavaUtilMap.put(paramString, Boolean.valueOf(paramBoolean));
  }
  
  public static void a(boolean paramBoolean)
  {
    jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static String b(Bundle paramBundle)
  {
    String str = a(paramBundle, "fromid");
    if (jdField_a_of_type_JavaUtilList.contains(str)) {
      return "multi_voice";
    }
    if ("10001".equals(a(paramBundle, "roomtype"))) {
      return "od";
    }
    return "live";
  }
  
  public static boolean b(String paramString)
  {
    if (jdField_a_of_type_JavaUtilList.contains(paramString)) {
      return ((Boolean)jdField_a_of_type_JavaUtilMap.get("multi_voice")).booleanValue();
    }
    return jdField_a_of_type_Boolean;
  }
  
  public String a(Bundle paramBundle)
  {
    a(paramBundle);
    String str = a(paramBundle, "fromid");
    if (jdField_a_of_type_JavaUtilList.contains(str))
    {
      if ((jdField_a_of_type_JavaUtilMap.containsKey("multi_voice")) && (((Boolean)jdField_a_of_type_JavaUtilMap.get("multi_voice")).booleanValue())) {
        return "multi_voice";
      }
      return "";
    }
    paramBundle = a(paramBundle, "roomtype");
    if (!jdField_a_of_type_Boolean) {
      return "";
    }
    if ("10001".equals(paramBundle)) {
      return "od";
    }
    return "live";
  }
  
  public boolean a(Bundle paramBundle)
  {
    return true;
  }
  
  public boolean a(String paramString)
  {
    return jdField_a_of_type_JavaUtilList.contains(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.config.NowBizConfigManager
 * JD-Core Version:    0.7.0.1
 */