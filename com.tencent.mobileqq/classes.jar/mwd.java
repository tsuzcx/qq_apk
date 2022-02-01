import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;

public class mwd
{
  public static String a;
  public static String b = jdField_a_of_type_JavaLangString + "test/";
  public static String c = "min_sdk";
  public static String d = "disable_sdk";
  public static String e = "flag";
  public static String f = b + c;
  public static String g = b + d;
  public static String h = b + e;
  @Deprecated
  lkq a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "sharp/video_effect/";
  }
  
  public mwd()
  {
    this.jdField_a_of_type_Lkq = null;
  }
  
  public int a(lkq paramlkq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoEffectConfigParser", 2, "getVideoEffectTestFlag sdk: " + Build.VERSION.SDK_INT);
    }
    try
    {
      int[] arrayOfInt = paramlkq.a(h);
      if (arrayOfInt != null)
      {
        if ((arrayOfInt[0] & 0x1) != 1) {
          return 0;
        }
        arrayOfInt = paramlkq.a(f);
        if ((arrayOfInt != null) && (Build.VERSION.SDK_INT >= arrayOfInt[0]))
        {
          boolean bool = mrs.a(paramlkq.a(g), Build.VERSION.SDK_INT);
          if (!bool) {
            return 1;
          }
        }
      }
    }
    catch (Exception paramlkq) {}
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mwd
 * JD-Core Version:    0.7.0.1
 */