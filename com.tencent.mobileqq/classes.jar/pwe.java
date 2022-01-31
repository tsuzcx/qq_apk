import com.tencent.qphone.base.util.QLog;

public class pwe
{
  private static volatile pwe jdField_a_of_type_Pwe;
  private boolean jdField_a_of_type_Boolean;
  
  public static pwe a()
  {
    if (jdField_a_of_type_Pwe == null) {}
    try
    {
      if (jdField_a_of_type_Pwe == null) {
        jdField_a_of_type_Pwe = new pwe();
      }
      return jdField_a_of_type_Pwe;
    }
    finally {}
  }
  
  private void a(String paramString1, int paramInt, String paramString2)
  {
    paramString1 = new pwy().a("name", paramString1).a("resCode", "" + paramInt).a("version", paramString2).a();
    if (paramInt == 0)
    {
      pwx.a("0X800A832", "", "", "", paramString1);
      return;
    }
    pwx.a("0X800A833", "", "", "", paramString1);
  }
  
  public void a(String paramString)
  {
    QLog.i("PTSSoLoader", 1, "[load], name = " + paramString);
    azip.a().a(paramString, new pwf(this, paramString));
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pwe
 * JD-Core Version:    0.7.0.1
 */