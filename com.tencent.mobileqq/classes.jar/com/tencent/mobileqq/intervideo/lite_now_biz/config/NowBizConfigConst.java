package com.tencent.mobileqq.intervideo.lite_now_biz.config;

import com.tencent.biz.qqstory.shareGroup.ShareGroupUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NowBizConfigConst
{
  private static List<String> jdField_a_of_type_JavaUtilList;
  private static Map<String, String> jdField_a_of_type_JavaUtilMap;
  private static boolean jdField_a_of_type_Boolean = ;
  public static String[] a;
  private static List<String> b;
  public static String[] b;
  public static String[] c;
  private static String[] d;
  private static String[] e;
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_a_of_type_JavaUtilList = new ArrayList();
    jdField_b_of_type_JavaUtilList = new ArrayList();
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "10008", "10013", "10014", "10016", "10017", "10018", "10006", "10009", "10001", "10002", "82105555", "8230", "60010", "60011", "60012", "60013", "60014", "10030", "zxdt_20001", "zxdt_10013", "zxdt_10014", "zxdt_10018", "zxdt_10017", "zxdt_10018", "20001", "20002", "20003", "10005", "10009", "10033", "60030", "60031", "6032", "60033", "11013", "11014", "11017", "11016", "11018", "21001", "10032" };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "10015", "82106666", "10035", "10036", "1", "82103333", "82105556", "82107777", "82108888", "82109999" };
    c = new String[] { "10032" };
    d = new String[] { "10008", "10013", "10018", "10002", "10001" };
    e = new String[] { "10014", "10017" };
    jdField_a_of_type_JavaUtilList.addAll(Arrays.asList(d));
    jdField_b_of_type_JavaUtilList.addAll(Arrays.asList(e));
    a();
  }
  
  public static int a(String paramString)
  {
    if (paramString == null) {
      return 0;
    }
    if (jdField_b_of_type_JavaUtilList.contains(paramString)) {
      return 5;
    }
    return 1;
  }
  
  public static String a(String paramString)
  {
    if (jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
      return (String)jdField_a_of_type_JavaUtilMap.get(paramString);
    }
    return "";
  }
  
  private static void a()
  {
    jdField_a_of_type_JavaUtilMap.put("10014", HardCodeUtil.a(2131694579));
    jdField_a_of_type_JavaUtilMap.put("10017", HardCodeUtil.a(2131694580));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.config.NowBizConfigConst
 * JD-Core Version:    0.7.0.1
 */