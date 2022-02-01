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
  public static String[] a;
  public static String[] b;
  public static String[] c;
  private static boolean d = ;
  private static Map<String, String> e = new HashMap();
  private static List<String> f = new ArrayList();
  private static List<String> g = new ArrayList();
  private static String[] h;
  private static String[] i;
  
  static
  {
    a = new String[] { "10008", "10013", "10014", "10016", "10017", "10018", "10006", "10009", "10001", "10002", "82105555", "8230", "60010", "60011", "60012", "60013", "60014", "10030", "zxdt_20001", "zxdt_10013", "zxdt_10014", "zxdt_10018", "zxdt_10017", "zxdt_10018", "20001", "20002", "20003", "10005", "10007", "10009", "qq_smallvideo", "10033", "60030", "60031", "6032", "60033", "11013", "11014", "11017", "11016", "11018", "21001", "10032" };
    b = new String[] { "10015", "82106666", "10035", "10036", "10038", "1", "82103333", "82105556", "82107777", "82108888", "82109999" };
    c = new String[] { "10032" };
    h = new String[] { "10008", "10013", "10018", "10002", "10001" };
    i = new String[] { "10014", "10017" };
    f.addAll(Arrays.asList(h));
    g.addAll(Arrays.asList(i));
    b();
  }
  
  public static int a(String paramString)
  {
    if (paramString == null) {
      return 0;
    }
    if (g.contains(paramString)) {
      return 5;
    }
    return 1;
  }
  
  public static String b(String paramString)
  {
    if (e.containsKey(paramString)) {
      return (String)e.get(paramString);
    }
    return "";
  }
  
  private static void b()
  {
    e.put("10014", HardCodeUtil.a(2131892231));
    e.put("10017", HardCodeUtil.a(2131892232));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.config.NowBizConfigConst
 * JD-Core Version:    0.7.0.1
 */