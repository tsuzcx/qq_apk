import com.tencent.qphone.base.util.QLog;

public class lzt
{
  public static String a;
  public static String b;
  public static String c;
  public static String d;
  public static String e;
  public int a;
  @Deprecated
  lle a;
  public int b;
  public int c;
  public int d;
  public int e;
  
  static
  {
    jdField_b_of_type_JavaLangString = "sharp/small_window/" + "close_flag";
    jdField_a_of_type_JavaLangString = "sharp/small_window/" + "version";
    jdField_c_of_type_JavaLangString = "sharp/small_window/" + "use_textureview";
    jdField_d_of_type_JavaLangString = "sharp/small_window/" + "close_video";
    jdField_e_of_type_JavaLangString = "sharp/small_window/" + "close_audio";
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenConfigParser", 2, " SmallScreenConfigParser --> key_open_flag = " + jdField_b_of_type_JavaLangString + " , key_version = " + jdField_a_of_type_JavaLangString + " , key_textureview = " + jdField_c_of_type_JavaLangString + " , key_close_video_flag = " + jdField_d_of_type_JavaLangString + " , key_close_audio_flag = " + jdField_e_of_type_JavaLangString);
    }
  }
  
  public lzt()
  {
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_Lle = null;
  }
  
  public boolean a(lle paramlle)
  {
    try
    {
      this.jdField_a_of_type_Int = paramlle.a(jdField_a_of_type_JavaLangString, 0);
      this.jdField_b_of_type_Int = paramlle.a(jdField_b_of_type_JavaLangString, 0);
      this.jdField_c_of_type_Int = paramlle.a(jdField_c_of_type_JavaLangString, -1);
      this.jdField_d_of_type_Int = paramlle.a(jdField_d_of_type_JavaLangString, 0);
      this.jdField_e_of_type_Int = paramlle.a(jdField_e_of_type_JavaLangString, 0);
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenConfigParser", 2, "value_version = " + this.jdField_a_of_type_Int + " , value_close_flag = " + this.jdField_b_of_type_Int + " , value_use_textureview = " + this.jdField_c_of_type_Int + " ,value_close_video = " + this.jdField_d_of_type_Int + " , value_close_audio = " + this.jdField_e_of_type_Int);
      }
      return true;
    }
    catch (Exception paramlle)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenConfigParser", 2, "parseConfig --> Error");
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lzt
 * JD-Core Version:    0.7.0.1
 */