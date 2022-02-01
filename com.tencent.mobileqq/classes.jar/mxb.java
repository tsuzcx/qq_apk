import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.wtogether.data.WTFileInfo;
import com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl;
import com.tencent.qphone.base.util.QLog;

public class mxb
{
  private static int jdField_a_of_type_Int;
  private static long jdField_a_of_type_Long;
  private static String jdField_a_of_type_JavaLangString;
  private static long b;
  
  public static String a(myv parammyv)
  {
    if ((parammyv == null) || (parammyv.a == null)) {
      return null;
    }
    return parammyv.a.c();
  }
  
  public static void a()
  {
    jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    b = 0L;
    if (QLog.isColorLevel()) {
      QLog.i("WTDataReportUtil", 2, "onEnterWTRoom, start[" + jdField_a_of_type_Long + "]");
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    long l1 = 0L;
    if ((paramString1 == null) || (!TextUtils.equals(paramString1, jdField_a_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("WTDataReportUtil", 2, "onPlayEnd, from[" + paramString2 + "], report before.");
      }
      return;
    }
    Object localObject1 = VideoController.a().a();
    label69:
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label233;
      }
      localObject2 = null;
      label77:
      if (localObject2 == null) {
        break label244;
      }
      l1 = ((nag)localObject2).jdField_a_of_type_Int;
    }
    label233:
    label244:
    for (long l2 = ((nag)localObject2).b;; l2 = 0L)
    {
      localObject2 = String.valueOf(l1 / 1000L);
      String str = String.valueOf(l2 / 1000L);
      mrr.a("0X800B639", 0, 0, (String)localObject2, str, "", "");
      b += l2;
      jdField_a_of_type_JavaLangString = null;
      if (localObject1 != null) {
        ((naf)localObject1).a(paramString1);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("WTDataReportUtil", 2, "onPlayEnd, from[" + paramString2 + "], key[" + paramString1 + "], r2[" + (String)localObject2 + "], r3[" + str + "]");
      return;
      localObject1 = ((WatchTogetherMediaPlayCtrl)localObject1).a();
      break label69;
      localObject2 = ((naf)localObject1).a(paramString1);
      break label77;
    }
  }
  
  public static void a(myv parammyv, long paramLong)
  {
    if ((parammyv == null) || (parammyv.a == null)) {}
    int i;
    String str1;
    String str2;
    do
    {
      return;
      if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
        a(jdField_a_of_type_JavaLangString, "onPlayStart");
      }
      jdField_a_of_type_Int += 1;
      jdField_a_of_type_JavaLangString = a(parammyv);
      i = parammyv.a.a();
      str1 = String.valueOf(paramLong / 1000L);
      str2 = parammyv.a.a();
      parammyv = parammyv.a.b();
      mrr.a("0X800B62E", i, 0, str1, "", str2, parammyv);
    } while (!QLog.isColorLevel());
    QLog.i("WTDataReportUtil", 2, "onPlayStart, key[" + jdField_a_of_type_JavaLangString + "], from[" + i + "], r2[" + str1 + "], r4[" + str2 + "], r5[" + parammyv + "]");
  }
  
  public static void a(myv parammyv, String paramString)
  {
    a(a(parammyv), paramString);
  }
  
  public static void b()
  {
    if (jdField_a_of_type_Long != 0L) {}
    for (long l = Math.abs(SystemClock.elapsedRealtime() - jdField_a_of_type_Long);; l = 0L)
    {
      int i = jdField_a_of_type_Int;
      String str1 = String.valueOf(l / 1000L);
      String str2 = String.valueOf(b / 1000L);
      mrr.a("0X800B6C0", i, 0, str1, str2, "", "");
      if (QLog.isColorLevel()) {
        QLog.i("WTDataReportUtil", 2, "onExitWTRoom, from[" + i + "], r2[" + str1 + "], r3[" + str2 + "]");
      }
      b = 0L;
      jdField_a_of_type_Long = 0L;
      jdField_a_of_type_Int = 0;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mxb
 * JD-Core Version:    0.7.0.1
 */