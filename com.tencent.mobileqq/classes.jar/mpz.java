import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;

public class mpz
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  public String f;
  public String g;
  public String h;
  public String i = "---";
  
  public mpz(String paramString1, String paramString2, VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_e_of_type_Int = -1;
    this.jdField_e_of_type_JavaLangString = "-9999";
    this.jdField_f_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_Boolean = TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramVideoAppInterface.getCurrentAccountUin());
    this.jdField_a_of_type_Long = AudioHelper.b();
  }
  
  public boolean a()
  {
    return (this.jdField_f_of_type_Int == 1) || (this.jdField_f_of_type_Int == 2) || ((this.jdField_a_of_type_Int == 0) && (this.jdField_f_of_type_Int == 0));
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Int != 0) && (this.jdField_f_of_type_Int == 0);
  }
  
  public String toString()
  {
    return "mSeq(" + this.jdField_a_of_type_Long + "), mStartUin(" + this.jdField_a_of_type_JavaLangString + "), mPlayUin(" + this.jdField_b_of_type_JavaLangString + "), mStarter(" + this.jdField_b_of_type_Boolean + "), mRedbagId(" + this.c + "), SucAboutGame(" + this.jdField_a_of_type_Boolean + "), ExceptionType(" + this.jdField_f_of_type_Int + "), ErrorType(" + this.jdField_e_of_type_Int + "), ResultCode(" + this.jdField_e_of_type_JavaLangString + "), ResultState(" + this.jdField_f_of_type_JavaLangString + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mpz
 * JD-Core Version:    0.7.0.1
 */