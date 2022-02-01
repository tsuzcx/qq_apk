import com.tencent.biz.pubaccount.readinjoy.imageopt.RIJImageOptReport.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;

public class puw
{
  public static int a;
  public static long a;
  public static long b;
  public static long c;
  public static long d;
  public static long e;
  public static long f;
  
  private static int a(String paramString)
  {
    Map localMap = bkgj.a(paramString);
    if (localMap.get("busiType") != null) {
      try
      {
        int i = Integer.parseInt((String)localMap.get("busiType"));
        return i;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        QLog.e("RIJImageOptReport", 2, "urlString: " + paramString + "  busiType:" + (String)localMap.get("busiType"), localNumberFormatException);
      }
    }
    return -1;
  }
  
  public static void a(int paramInt, tdw paramtdw)
  {
    if ((puu.a.a()) && (paramtdw != null))
    {
      if (paramInt != 1) {
        break label26;
      }
      paramtdw.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    label26:
    while (paramtdw.jdField_a_of_type_Long == 0L) {
      return;
    }
    switch (paramInt)
    {
    default: 
      QLog.d("RIJImageOptReport", 1, "unknown type: " + paramInt + " " + paramtdw);
      return;
    case 2: 
      paramtdw.jdField_b_of_type_Long = System.currentTimeMillis();
      return;
    case 3: 
      paramtdw.c = System.currentTimeMillis();
      return;
    case 4: 
      paramtdw.jdField_d_of_type_Long = System.currentTimeMillis();
      return;
    case 5: 
      paramtdw.g = System.currentTimeMillis();
      return;
    }
    paramtdw.h = System.currentTimeMillis();
  }
  
  public static void a(tdw paramtdw)
  {
    if (paramtdw != null) {
      oat.a(null, "", "0X800AEF3", "0X800AEF3", 0, 0, "", "", "", paramtdw.toString(), false);
    }
  }
  
  public static void a(tdw paramtdw, boolean paramBoolean, String paramString)
  {
    ThreadManager.getSubThreadHandler().post(new RIJImageOptReport.1(paramtdw, paramString));
  }
  
  public static void b(int paramInt, tdw paramtdw)
  {
    if (b(paramtdw)) {
      paramtdw.jdField_d_of_type_Int = paramInt;
    }
  }
  
  private static boolean b(tdw paramtdw)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (puu.a.a())
    {
      bool1 = bool2;
      if (paramtdw != null)
      {
        bool1 = bool2;
        if (paramtdw.jdField_a_of_type_Long != 0L) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private static void c(tdw paramtdw)
  {
    long l2 = paramtdw.c - paramtdw.jdField_b_of_type_Long;
    long l3 = paramtdw.jdField_d_of_type_Long - paramtdw.c;
    long l4 = paramtdw.jdField_e_of_type_Long;
    long l5 = paramtdw.f;
    long l1;
    long l6;
    int i;
    int j;
    long l7;
    if (paramtdw.g > 0L)
    {
      l1 = paramtdw.h - paramtdw.g;
      l6 = paramtdw.h - paramtdw.jdField_a_of_type_Long;
      i = paramtdw.jdField_d_of_type_Int;
      j = paramtdw.jdField_e_of_type_Int;
      l7 = paramtdw.i;
      if (paramtdw.jdField_a_of_type_JavaNetURL == null) {
        break label627;
      }
    }
    label627:
    for (String str1 = paramtdw.jdField_a_of_type_JavaNetURL.toString();; str1 = "")
    {
      int k = a(str1);
      String str2 = paramtdw.jdField_b_of_type_JavaLangString;
      paramtdw = paramtdw.jdField_a_of_type_JavaLangString;
      HashMap localHashMap = new HashMap();
      localHashMap.put("subThreadWaitTime", l2 + "");
      localHashMap.put("threadPoolWaitTime", l3 + "");
      localHashMap.put("threadWaitTime", l2 + l3 + "");
      localHashMap.put("downloadAndWriteFileTime", l4 + "");
      localHashMap.put("decodeTime", l5 + "");
      localHashMap.put("mainThreadWaitTime", l1 + "");
      localHashMap.put("cacheType", i + "");
      localHashMap.put("errMsg", paramtdw);
      localHashMap.put("contentType", str2);
      localHashMap.put("fileSize", Long.valueOf(l7));
      localHashMap.put("urlStr", str1);
      localHashMap.put("busiType", Integer.valueOf(k));
      localHashMap.put("ipv6", Boolean.valueOf(bdvz.b()));
      ube.a(j, 6, l6, localHashMap);
      if (QLog.isColorLevel())
      {
        jdField_a_of_type_Int += 1;
        jdField_a_of_type_Long += l6;
        jdField_b_of_type_Long += l3;
        c = l1 + c;
        jdField_d_of_type_Long += l4;
        jdField_e_of_type_Long += l5;
        f += l7;
        if (jdField_a_of_type_Int == 100)
        {
          QLog.d("RIJImageOptReport", 2, "average  total: " + (float)jdField_a_of_type_Long / jdField_a_of_type_Int + " size: " + f / jdField_a_of_type_Int + " threapool: " + (float)jdField_b_of_type_Long / jdField_a_of_type_Int + " mainthread: " + (float)c / jdField_a_of_type_Int + " downloadAndWriteFileTime: " + (float)jdField_d_of_type_Long / jdField_a_of_type_Int + " decodeTime: " + (float)jdField_e_of_type_Long / jdField_a_of_type_Int);
          jdField_a_of_type_Int = 0;
          jdField_a_of_type_Long = 0L;
          jdField_b_of_type_Long = 0L;
          c = 0L;
          jdField_d_of_type_Long = 0L;
          jdField_e_of_type_Long = 0L;
          f = 0L;
        }
      }
      return;
      l1 = 0L;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     puw
 * JD-Core Version:    0.7.0.1
 */