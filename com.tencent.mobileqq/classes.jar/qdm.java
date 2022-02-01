import com.tencent.biz.pubaccount.readinjoy.imageopt.RIJImageOptReport.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;

public class qdm
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
    Map localMap = bkyp.a(paramString);
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
  
  public static void a(int paramInt, tlw paramtlw)
  {
    if ((qdk.a.a()) && (paramtlw != null))
    {
      if (paramInt != 1) {
        break label26;
      }
      paramtlw.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    label26:
    while (paramtlw.jdField_a_of_type_Long == 0L) {
      return;
    }
    switch (paramInt)
    {
    default: 
      QLog.d("RIJImageOptReport", 1, "unknown type: " + paramInt + " " + paramtlw);
      return;
    case 2: 
      paramtlw.jdField_b_of_type_Long = System.currentTimeMillis();
      return;
    case 3: 
      paramtlw.c = System.currentTimeMillis();
      return;
    case 4: 
      paramtlw.jdField_d_of_type_Long = System.currentTimeMillis();
      return;
    case 5: 
      paramtlw.g = System.currentTimeMillis();
      return;
    }
    paramtlw.h = System.currentTimeMillis();
  }
  
  public static void a(tlw paramtlw)
  {
    if (paramtlw != null) {
      olh.a(null, "", "0X800AEF3", "0X800AEF3", 0, 0, "", "", "", paramtlw.toString(), false);
    }
  }
  
  public static void a(tlw paramtlw, boolean paramBoolean, String paramString)
  {
    ThreadManager.getSubThreadHandler().post(new RIJImageOptReport.1(paramtlw, paramString));
  }
  
  public static void b(int paramInt, tlw paramtlw)
  {
    if (b(paramtlw)) {
      paramtlw.jdField_d_of_type_Int = paramInt;
    }
  }
  
  private static boolean b(tlw paramtlw)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (qdk.a.a())
    {
      bool1 = bool2;
      if (paramtlw != null)
      {
        bool1 = bool2;
        if (paramtlw.jdField_a_of_type_Long != 0L) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private static void c(tlw paramtlw)
  {
    long l2 = paramtlw.c - paramtlw.jdField_b_of_type_Long;
    long l3 = paramtlw.jdField_d_of_type_Long - paramtlw.c;
    long l4 = paramtlw.jdField_e_of_type_Long;
    long l5 = paramtlw.f;
    long l1;
    long l6;
    int i;
    long l7;
    String str1;
    label97:
    HashMap localHashMap;
    if (paramtlw.g > 0L)
    {
      l1 = paramtlw.h - paramtlw.g;
      l6 = paramtlw.h - paramtlw.jdField_a_of_type_Long;
      int j = paramtlw.jdField_d_of_type_Int;
      i = paramtlw.jdField_e_of_type_Int;
      l7 = paramtlw.i;
      if (paramtlw.jdField_a_of_type_JavaNetURL == null) {
        break label644;
      }
      str1 = paramtlw.jdField_a_of_type_JavaNetURL.toString();
      int k = a(str1);
      String str2 = paramtlw.jdField_b_of_type_JavaLangString;
      paramtlw = paramtlw.jdField_a_of_type_JavaLangString;
      localHashMap = new HashMap();
      localHashMap.put("subThreadWaitTime", l2 + "");
      localHashMap.put("threadPoolWaitTime", l3 + "");
      localHashMap.put("threadWaitTime", l2 + l3 + "");
      localHashMap.put("downloadAndWriteFileTime", l4 + "");
      localHashMap.put("decodeTime", l5 + "");
      localHashMap.put("mainThreadWaitTime", l1 + "");
      localHashMap.put("cacheType", j + "");
      localHashMap.put("errMsg", paramtlw);
      localHashMap.put("contentType", str2);
      localHashMap.put("fileSize", Long.valueOf(l7));
      localHashMap.put("urlStr", str1);
      localHashMap.put("busiType", Integer.valueOf(k));
      j = NetConnInfoCenter.getActiveNetIpFamily(true);
      if ((j != 2) && (j != 3)) {
        break label651;
      }
    }
    label644:
    label651:
    for (boolean bool = true;; bool = false)
    {
      localHashMap.put("ipv6", Boolean.valueOf(bool));
      uvs.a(i, 6, l6, localHashMap);
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
      str1 = "";
      break label97;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qdm
 * JD-Core Version:    0.7.0.1
 */