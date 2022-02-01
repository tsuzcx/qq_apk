import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class nhq
{
  private static int jdField_a_of_type_Int;
  private static long jdField_a_of_type_Long;
  public static String a;
  public static String b = "param_Type";
  
  static
  {
    jdField_a_of_type_JavaLangString = "actAVGameOpenCamera";
  }
  
  public static void a(int paramInt)
  {
    jdField_a_of_type_Long = System.currentTimeMillis();
    jdField_a_of_type_Int = paramInt;
  }
  
  public static void a(boolean paramBoolean)
  {
    if ((jdField_a_of_type_Long <= 0L) || (jdField_a_of_type_Int <= 0)) {
      return;
    }
    long l = System.currentTimeMillis() - jdField_a_of_type_Long;
    HashMap localHashMap = new HashMap();
    localHashMap.put(b, String.valueOf(jdField_a_of_type_Int));
    bdmc.a(BaseApplicationImpl.getApplication()).a("", jdField_a_of_type_JavaLangString, paramBoolean, l, 1L, localHashMap, "", true);
    if (QLog.isColorLevel()) {
      QLog.i("actAVGameOpenCamera", 1, "reportOpenCameraEnd duration:" + l + " success:" + paramBoolean + " type:" + jdField_a_of_type_Int);
    }
    jdField_a_of_type_Int = 0;
    jdField_a_of_type_Long = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nhq
 * JD-Core Version:    0.7.0.1
 */