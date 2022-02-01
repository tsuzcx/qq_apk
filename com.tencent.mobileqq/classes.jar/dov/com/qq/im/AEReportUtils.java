package dov.com.qq.im;

import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.HashMap;

public class AEReportUtils
{
  public static void a()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 87, 5, 2);
  }
  
  public static void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (String str = "1";; str = "2")
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("ext2", str);
      ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 88, 9, 1, localHashMap, null, null);
      return;
    }
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 88, paramInt1, paramInt2);
  }
  
  public static void a(int paramInt1, int paramInt2, HashMap<String, String> paramHashMap)
  {
    if (paramHashMap == null)
    {
      ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 89, paramInt1, paramInt2);
      return;
    }
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 89, paramInt1, paramInt2, paramHashMap, null, null);
  }
  
  public static void a(int paramInt, long paramLong) {}
  
  public static void a(int paramInt, HashMap<String, String> paramHashMap)
  {
    a(paramInt, 1, paramHashMap);
  }
  
  public static void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("ext2", paramString);
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 88, 6, 2, localHashMap, null, null);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 87, 6, 2, paramString1, paramString2, paramString3, paramString4);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ext2", paramString1);
    localHashMap.put("ext3", paramString2);
    localHashMap.put("ext4", paramString3);
    localHashMap.put("ext5", paramString4);
    localHashMap.put("ext6", paramString5);
    localHashMap.put("ext7", paramString6);
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 90, 6, 2, localHashMap, null, null);
  }
  
  public static void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 92;; i = 88)
    {
      ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", i, 1, 1);
      return;
    }
  }
  
  public static void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    String str;
    HashMap localHashMap;
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      str = "3";
      localHashMap = new HashMap();
      localHashMap.put("ext2", str);
      localHashMap.put("ext3", String.valueOf(paramInt1 + paramInt2));
      localHashMap.put("ext4", String.valueOf(paramInt1));
      localHashMap.put("ext5", String.valueOf(paramInt2));
      if (!paramBoolean) {
        break label113;
      }
    }
    label113:
    for (paramInt1 = 92;; paramInt1 = 88)
    {
      ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", paramInt1, 3, 2, localHashMap, null, null);
      return;
      if (paramInt1 > 0)
      {
        str = "1";
        break;
      }
      str = "2";
      break;
    }
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    int i;
    String str;
    if (paramBoolean2)
    {
      i = 2;
      switch (paramInt1)
      {
      default: 
        str = "1";
        label32:
        if (!paramBoolean1) {
          break;
        }
      }
    }
    for (paramInt1 = 92;; paramInt1 = 88)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("ext2", str);
      localHashMap.put("ext3", String.valueOf(paramInt2 + 1));
      ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", paramInt1, 2, i, localHashMap, null, null);
      return;
      i = 3;
      break;
      str = "2";
      break label32;
    }
  }
  
  public static void b()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 87, 7, 1);
  }
  
  public static void b(int paramInt)
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 90, 8, paramInt);
  }
  
  public static void b(int paramInt1, int paramInt2)
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 87, 9, paramInt1, String.valueOf(paramInt2), "", "", "");
  }
  
  public static void b(int paramInt, HashMap<String, String> paramHashMap)
  {
    a(paramInt, 2, paramHashMap);
  }
  
  public static void b(String paramString)
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 87, 2, 3, paramString, "", "", "");
  }
  
  public static void b(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 92;; i = 88)
    {
      ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", i, 4, 1);
      return;
    }
  }
  
  public static void c()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 87, 7, 2);
  }
  
  public static void c(int paramInt, HashMap<String, String> paramHashMap)
  {
    a(paramInt, 3, paramHashMap);
  }
  
  public static void c(String paramString)
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 87, 2, 4, paramString, "", "", "");
  }
  
  public static void d()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 87, 8, 1);
  }
  
  public static void d(int paramInt, HashMap<String, String> paramHashMap)
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 90, 8, paramInt, paramHashMap, null, null);
  }
  
  public static void d(String paramString)
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 87, 3, 2, paramString, "", "", "");
  }
  
  public static void e()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 87, 8, 2);
  }
  
  public static void e(String paramString)
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 87, 3, 3, paramString, "", "", "");
  }
  
  public static void f()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 87, 10, 1);
  }
  
  public static void f(String paramString)
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 87, 3, 4, paramString, "", "", "");
  }
  
  public static void g()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 87, 7, 1);
  }
  
  public static void g(String paramString)
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 87, 4, 3, paramString, "", "", "");
  }
  
  public static void h()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 87, 2, 1);
  }
  
  public static void h(String paramString)
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 87, 4, 4, paramString, "", "", "");
  }
  
  public static void i()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 87, 3, 1);
  }
  
  public static void i(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ext2", paramString);
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 90, 7, 3, localHashMap, null, null);
  }
  
  public static void j()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 87, 4, 1);
  }
  
  public static void j(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ext2", paramString);
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 90, 9, 2, localHashMap, null, null);
  }
  
  public static void k()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 90, 7, 1);
  }
  
  public static void k(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ext2", paramString);
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 90, 9, 3, localHashMap, null, null);
  }
  
  public static void l()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 90, 5, 2);
  }
  
  public static void l(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ext2", paramString);
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 90, 9, 4, localHashMap, null, null);
  }
  
  public static void m()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 90, 7, 2);
  }
  
  public static void m(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ext2", paramString);
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 90, 9, 5, localHashMap, null, null);
  }
  
  public static void n()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 90, 7, 4);
  }
  
  public static void n(String paramString)
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 90, 2, 3, paramString, "", "", "");
  }
  
  public static void o()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 90, 7, 5);
  }
  
  public static void o(String paramString)
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 90, 2, 4, paramString, "", "", "");
  }
  
  public static void p()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 90, 7, 6);
  }
  
  public static void p(String paramString)
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 90, 3, 2, paramString, "", "", "");
  }
  
  public static void q()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 90, 9, 1);
  }
  
  public static void q(String paramString)
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 90, 3, 3, paramString, "", "", "");
  }
  
  public static void r()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 90, 2, 1);
  }
  
  public static void r(String paramString)
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 90, 3, 4, paramString, "", "", "");
  }
  
  public static void s()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 90, 3, 1);
  }
  
  public static void t() {}
  
  public static void u()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 90, 1, 1);
  }
  
  public static void v()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 90, 8, 1);
  }
  
  public static void w()
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 87, 1, 1);
    b();
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.AEReportUtils
 * JD-Core Version:    0.7.0.1
 */