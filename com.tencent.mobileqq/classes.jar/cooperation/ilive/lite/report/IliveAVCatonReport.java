package cooperation.ilive.lite.report;

import com.tencent.biz.common.util.HttpUtil;
import com.tencent.livesdk.livesdkplayer.AVCatonReport4Player;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.lite.IliveLiteMonitorUtil;
import java.util.HashMap;

public class IliveAVCatonReport
  extends AVCatonReport4Player
{
  private String jdField_a_of_type_JavaLangString;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap.put("netstring", String.valueOf(HttpUtil.getNetWorkType()));
    IliveLiteMonitorUtil.a("live_avcaton");
    IliveLiteMonitorUtil.a("live_avcaton", this.jdField_a_of_type_JavaUtilHashMap);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("avCatonReport: ");
      localStringBuilder.append(this.jdField_a_of_type_JavaUtilHashMap);
      QLog.i("IliveAVCatonReport", 2, localStringBuilder.toString());
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put("firstframeduration", String.valueOf(paramLong1));
    this.jdField_a_of_type_JavaUtilHashMap.put("playduration", String.valueOf(paramLong2));
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put("gap0_5", String.valueOf(paramLong1));
    this.jdField_a_of_type_JavaUtilHashMap.put("gap5_10", String.valueOf(paramLong2));
    this.jdField_a_of_type_JavaUtilHashMap.put("gap10_100", String.valueOf(paramLong3));
    this.jdField_a_of_type_JavaUtilHashMap.put("framecount", String.valueOf(paramLong4));
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put("url", paramString1);
    this.jdField_a_of_type_JavaUtilHashMap.put("resolution", paramString2);
    this.jdField_a_of_type_JavaUtilHashMap.put("roomid", this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_JavaUtilHashMap.put("sdktyp", paramString4);
    this.jdField_a_of_type_JavaUtilHashMap.put("sdkversion", paramString5);
    this.jdField_a_of_type_JavaUtilHashMap.put("openid", paramString6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.lite.report.IliveAVCatonReport
 * JD-Core Version:    0.7.0.1
 */