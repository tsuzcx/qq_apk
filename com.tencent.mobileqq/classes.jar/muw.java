import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;

public class muw
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
  lkz a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "sharp/video_effect/";
  }
  
  public muw()
  {
    this.jdField_a_of_type_Lkz = null;
  }
  
  public int a(lkz paramlkz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoEffectConfigParser", 2, "getVideoEffectTestFlag sdk: " + Build.VERSION.SDK_INT);
    }
    try
    {
      int[] arrayOfInt = paramlkz.a(h);
      if (arrayOfInt != null)
      {
        if ((arrayOfInt[0] & 0x1) != 1) {
          return 0;
        }
        arrayOfInt = paramlkz.a(f);
        if ((arrayOfInt != null) && (Build.VERSION.SDK_INT >= arrayOfInt[0]))
        {
          boolean bool = mqp.a(paramlkz.a(g), Build.VERSION.SDK_INT);
          if (!bool) {
            return 1;
          }
        }
      }
    }
    catch (Exception paramlkz) {}
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     muw
 * JD-Core Version:    0.7.0.1
 */