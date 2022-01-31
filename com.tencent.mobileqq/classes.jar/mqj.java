import com.tencent.av.ui.funchat.record.QavRecordReporter.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class mqj
{
  private static int jdField_a_of_type_Int;
  private static long jdField_a_of_type_Long;
  private static Throwable jdField_a_of_type_JavaLangThrowable;
  private static boolean jdField_a_of_type_Boolean;
  private static int jdField_b_of_type_Int;
  private static long jdField_b_of_type_Long;
  private static int c;
  
  public static void a()
  {
    jdField_a_of_type_Int = 0;
    jdField_a_of_type_Long = System.currentTimeMillis();
    jdField_b_of_type_Long = -1L;
    jdField_b_of_type_Int = 0;
    jdField_a_of_type_Boolean = false;
    c = 0;
    jdField_a_of_type_JavaLangThrowable = null;
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    long l1 = System.currentTimeMillis();
    long l2 = jdField_a_of_type_Long;
    long l3 = jdField_b_of_type_Long;
    int i = jdField_a_of_type_Int;
    int j = jdField_b_of_type_Int;
    if (QLog.isColorLevel()) {
      QLog.i("QavRecordReporter", 2, "onRecordEnd cores=" + paramInt1 + ", fqc=" + paramInt2 + ", start=" + l2 + ", end=" + l1 + ", frames=" + i + ", stopType=" + paramInt3 + ", mp4Start=" + l3 + ", mp4Frames=" + j);
    }
    ThreadManager.post(new QavRecordReporter.1(paramInt2, i, l1, l2, j, l3, paramLong, paramInt1, paramInt3), 5, null, false);
  }
  
  public static void a(int paramInt, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavRecordReporter", 2, "onError " + paramInt);
    }
    jdField_a_of_type_Boolean = true;
    c = paramInt;
    jdField_a_of_type_JavaLangThrowable = paramThrowable;
  }
  
  public static void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavRecordReporter", 2, "reportConvertPcmCostTime cost=" + paramLong);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("device_model", bdcb.d());
    localHashMap.put("api", bdcb.e());
    localHashMap.put("manufacture", bdcb.h());
    azmz localazmz = azmz.a(BaseApplicationImpl.getContext());
    if (!jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      localazmz.a("", "av_record_convert_pcm_cost", bool, paramLong / 1000L, 0L, localHashMap, "", false);
      return;
    }
  }
  
  public static void a(String paramString)
  {
    azmj.b(null, "CliOper", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  public static void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavRecordReporter", 2, "reportPCMSuccess success=" + paramBoolean + ", errcode=" + paramInt);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    azmz.a(BaseApplicationImpl.getContext()).a("", "av_record_convert_pcm_success", paramBoolean, 0L, 0L, localHashMap, "", false);
  }
  
  public static void b()
  {
    jdField_a_of_type_Int += 1;
  }
  
  public static void c()
  {
    if (jdField_b_of_type_Long < 0L) {
      jdField_b_of_type_Long = System.currentTimeMillis();
    }
    jdField_b_of_type_Int += 1;
  }
  
  public static void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavRecordReporter", 2, "reportEnd");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(c));
    localHashMap.put("device_model", bdcb.d());
    localHashMap.put("api", bdcb.e());
    localHashMap.put("manufacture", bdcb.h());
    localHashMap.put("throwable", String.valueOf(jdField_a_of_type_JavaLangThrowable));
    jdField_a_of_type_JavaLangThrowable = null;
    if (QLog.isColorLevel()) {
      QLog.i("QavRecordReporter", 2, "reportEnd params=" + localHashMap);
    }
    azmz localazmz = azmz.a(BaseApplicationImpl.getContext());
    if (!jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      localazmz.a("", "av_record_report_end", bool, 0L, 0L, localHashMap, "", false);
      return;
    }
  }
  
  public static void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavRecordReporter", 2, "onAudioTrackInitFail");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("device_model", bdcb.d());
    localHashMap.put("api", bdcb.e());
    localHashMap.put("manufacture", bdcb.h());
    if (QLog.isColorLevel()) {
      QLog.i("QavRecordReporter", 2, "onAudioTrackInitFail  params=" + localHashMap);
    }
    azmz localazmz = azmz.a(BaseApplicationImpl.getContext());
    if (!jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      localazmz.a("", "av_record_audio_fail", bool, 0L, 0L, localHashMap, "", false);
      return;
    }
  }
  
  public static void f()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavRecordReporter", 2, "reportConvertPcmTimeout");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("device_model", bdcb.d());
    localHashMap.put("api", bdcb.e());
    localHashMap.put("manufacture", bdcb.h());
    azmz localazmz = azmz.a(BaseApplicationImpl.getContext());
    if (!jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      localazmz.a("", "av_record_convert_pcm_timeout", bool, 0L, 0L, localHashMap, "", false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mqj
 * JD-Core Version:    0.7.0.1
 */