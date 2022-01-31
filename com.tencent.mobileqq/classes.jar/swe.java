import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.HashMap;

public class swe
{
  static ByteBuffer jdField_a_of_type_JavaNioByteBuffer = ByteBuffer.allocate(8);
  static swe jdField_a_of_type_Swe;
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  int jdField_b_of_type_Int;
  String jdField_b_of_type_JavaLangString;
  int jdField_c_of_type_Int;
  String jdField_c_of_type_JavaLangString;
  int jdField_d_of_type_Int;
  String jdField_d_of_type_JavaLangString;
  int e;
  int f;
  int g;
  int h = 1;
  
  public static swe a()
  {
    if (jdField_a_of_type_Swe == null) {
      jdField_a_of_type_Swe = new swe();
    }
    return jdField_a_of_type_Swe;
  }
  
  public String a(String paramString1, String paramString2)
  {
    try
    {
      if ((!this.jdField_b_of_type_JavaLangString.equals(paramString2)) || (this.jdField_a_of_type_JavaLangString == null))
      {
        paramString1 = MD5.toMD5Byte(paramString1 + String.valueOf(System.currentTimeMillis()) + Math.random());
        jdField_a_of_type_JavaNioByteBuffer.put(paramString1, 0, 8);
        jdField_a_of_type_JavaNioByteBuffer.flip();
        this.h = 0;
        long l = jdField_a_of_type_JavaNioByteBuffer.getLong();
        return String.valueOf(l);
      }
    }
    catch (Exception paramString1) {}
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.e = 0;
  }
  
  public void a(int paramInt)
  {
    a();
    long l = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    localHashMap.put("sVer", "1.0");
    localHashMap.put("sScene", String.valueOf(paramInt));
    localHashMap.put("sCurTime", String.valueOf(l));
    a("actSearchExposure", localHashMap);
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_Int = paramInt;
    this.h = 0;
    if (QLog.isDevelopLevel()) {
      QLog.d("PADetailReportUtil", 4, "start report entrance event cur view:" + paramInt + ", time:" + l);
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    long l = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    localHashMap.put("sVer", "1.0");
    localHashMap.put("sSearch", this.jdField_a_of_type_JavaLangString);
    localHashMap.put("sKey", this.jdField_b_of_type_JavaLangString);
    localHashMap.put("sCurTime", String.valueOf(l));
    localHashMap.put("sItem", paramString);
    localHashMap.put("sPScene", String.valueOf(this.jdField_c_of_type_Int));
    localHashMap.put("sScene", String.valueOf(this.jdField_a_of_type_Int + paramInt1));
    localHashMap.put("sItemPos", String.valueOf(paramInt2));
    if (paramInt3 == 12) {
      localHashMap.put("sFolder", "1");
    }
    for (;;)
    {
      a("actSearchNetClick", localHashMap);
      this.jdField_b_of_type_Int = this.jdField_c_of_type_Int;
      this.jdField_c_of_type_Int = (this.jdField_a_of_type_Int + paramInt1);
      this.f = paramInt2;
      this.jdField_d_of_type_JavaLangString = paramString;
      if (QLog.isDevelopLevel()) {
        QLog.d("PADetailReportUtil", 4, "start report click event searchID:" + this.jdField_a_of_type_JavaLangString + ", superview:" + this.jdField_b_of_type_Int + ", thisview:" + this.jdField_c_of_type_Int + ", itemPos:" + this.f + ", time:" + l + ", itemID:" + this.jdField_d_of_type_JavaLangString + ", from:" + paramInt3);
      }
      return;
      localHashMap.put("sFolder", "0");
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    localHashMap.put("sVer", "1.0");
    localHashMap.put("sSearch", this.jdField_a_of_type_JavaLangString);
    localHashMap.put("sKey", this.jdField_b_of_type_JavaLangString);
    localHashMap.put("sCurTime", String.valueOf(l));
    localHashMap.put("sPScene", String.valueOf(this.jdField_c_of_type_Int));
    localHashMap.put("sScene", String.valueOf(this.jdField_a_of_type_Int + paramInt1));
    localHashMap.put("sDirect", String.valueOf(paramInt2));
    localHashMap.put("sItem", paramString);
    if (paramInt3 == 12)
    {
      localHashMap.put("sFolder", "1");
      if (!paramBoolean) {
        break label308;
      }
      localHashMap.put("sFrom", "1");
    }
    for (;;)
    {
      a("actSearchSubscribe", localHashMap);
      this.jdField_b_of_type_Int = this.jdField_c_of_type_Int;
      this.jdField_c_of_type_Int = (this.jdField_a_of_type_Int + paramInt1);
      this.jdField_d_of_type_JavaLangString = paramString;
      this.g = paramInt2;
      if (QLog.isDevelopLevel()) {
        QLog.d("PADetailReportUtil", 4, "start report attention event searchID:" + this.jdField_a_of_type_JavaLangString + ", superview:" + this.jdField_b_of_type_Int + ", thisview:" + this.jdField_c_of_type_Int + ", itemID:" + this.jdField_d_of_type_JavaLangString + ", isDirectClick:" + this.g + ", time" + l + ", from:" + paramInt3 + ", isoffline:" + paramBoolean);
      }
      return;
      localHashMap.put("sFolder", "0");
      break;
      label308:
      localHashMap.put("sFrom", "0");
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, boolean paramBoolean, int paramInt2, String paramString3)
  {
    long l;
    HashMap localHashMap;
    if (paramInt1 == 3)
    {
      this.h += 1;
      this.e = ((this.h - 1) * paramInt2);
      l = System.currentTimeMillis();
      localHashMap = new HashMap();
      localHashMap.put("sVer", "1.0");
      if (paramString1 == null) {
        break label366;
      }
      localHashMap.put("sSearch", paramString1);
      label65:
      localHashMap.put("sCurTime", String.valueOf(l));
      localHashMap.put("sKey", paramString2);
      localHashMap.put("sPScene", String.valueOf(this.jdField_c_of_type_Int));
      localHashMap.put("sScene", String.valueOf(this.jdField_a_of_type_Int + paramInt1));
      if (this.h == 0) {
        break label381;
      }
      localHashMap.put("sItemListPage", String.valueOf(this.h));
      localHashMap.put("sItemListStart", String.valueOf((this.h - 1) * paramInt2));
    }
    for (;;)
    {
      localHashMap.put("sItemlist", paramString3);
      a("actSearchNet", localHashMap);
      this.jdField_b_of_type_Int = this.jdField_c_of_type_Int;
      this.jdField_c_of_type_Int = (this.jdField_a_of_type_Int + paramInt1);
      if (paramString1 != null) {
        this.jdField_a_of_type_JavaLangString = paramString1;
      }
      this.jdField_b_of_type_JavaLangString = paramString2;
      this.jdField_d_of_type_Int = this.h;
      this.jdField_c_of_type_JavaLangString = paramString3;
      if (QLog.isDevelopLevel())
      {
        QLog.d("PADetailReportUtil", 4, "start report searchpage searchID:" + this.jdField_a_of_type_JavaLangString + " superview:" + this.jdField_b_of_type_Int + ", thisview:" + this.jdField_c_of_type_Int + ", search:" + this.jdField_b_of_type_JavaLangString);
        QLog.d("PADetailReportUtil", 4, "pagenum:" + this.jdField_d_of_type_Int + ", startPos:" + this.e + ", itemList:" + this.jdField_c_of_type_JavaLangString + ", time:" + l);
      }
      return;
      this.h = 0;
      break;
      label366:
      localHashMap.put("sSearch", this.jdField_a_of_type_JavaLangString);
      break label65;
      label381:
      localHashMap.put("sItemListPage", "1");
      localHashMap.put("sItemListStart", "0");
    }
  }
  
  public void a(String paramString, HashMap<String, String> paramHashMap)
  {
    azmz.a(BaseApplicationImpl.getApplication()).a(null, paramString, true, 0L, 0L, paramHashMap, null);
  }
  
  public void b()
  {
    this.h = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     swe
 * JD-Core Version:    0.7.0.1
 */