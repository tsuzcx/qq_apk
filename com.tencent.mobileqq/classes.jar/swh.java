import android.annotation.TargetApi;
import android.os.SystemClock;

@TargetApi(14)
public class swh
  extends waa
{
  private int jdField_a_of_type_Int = 941000;
  private long jdField_a_of_type_Long = SystemClock.elapsedRealtime();
  private String jdField_a_of_type_JavaLangString;
  private swj jdField_a_of_type_Swj;
  private String b;
  
  public swh(String paramString1, String paramString2, swj paramswj)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Swj = paramswj;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onFailure(String paramString)
  {
    if (paramString.equals(String.valueOf(941001))) {
      this.jdField_a_of_type_Swj.a(941001, paramString, "");
    }
    for (;;)
    {
      ved.d(swc.jdField_a_of_type_JavaLangString, "combine audio fail %s, %d", new Object[] { paramString, Integer.valueOf(this.jdField_a_of_type_Int) });
      vyf.g(this.jdField_a_of_type_JavaLangString);
      return;
      if (paramString.equals(String.valueOf(941002))) {
        this.jdField_a_of_type_Swj.a(941002, paramString, "");
      } else {
        this.jdField_a_of_type_Swj.a(this.jdField_a_of_type_Int, paramString, "");
      }
    }
  }
  
  public void onSuccess(String paramString)
  {
    ved.a(swc.jdField_a_of_type_JavaLangString, "combine music success take time:%d", Long.valueOf(SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long));
    this.jdField_a_of_type_Swj.a(0, "", this.b);
    vyf.g(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     swh
 * JD-Core Version:    0.7.0.1
 */