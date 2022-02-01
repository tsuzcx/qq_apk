import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;

public class mvw
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
  lkk a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "sharp/video_effect/";
  }
  
  public mvw()
  {
    this.jdField_a_of_type_Lkk = null;
  }
  
  public int a(lkk paramlkk)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoEffectConfigParser", 2, "getVideoEffectTestFlag sdk: " + Build.VERSION.SDK_INT);
    }
    try
    {
      int[] arrayOfInt = paramlkk.a(h);
      if (arrayOfInt != null)
      {
        if ((arrayOfInt[0] & 0x1) != 1) {
          return 0;
        }
        arrayOfInt = paramlkk.a(f);
        if ((arrayOfInt != null) && (Build.VERSION.SDK_INT >= arrayOfInt[0]))
        {
          boolean bool = mrm.a(paramlkk.a(g), Build.VERSION.SDK_INT);
          if (!bool) {
            return 1;
          }
        }
      }
    }
    catch (Exception paramlkk) {}
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mvw
 * JD-Core Version:    0.7.0.1
 */