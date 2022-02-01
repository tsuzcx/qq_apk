public class lps
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static lps b;
  private static int c;
  public int a;
  private lps jdField_a_of_type_Lps;
  public int b;
  
  private lps(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public static lps a(int paramInt1, int paramInt2)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_b_of_type_Lps != null)
      {
        lps locallps = jdField_b_of_type_Lps;
        jdField_b_of_type_Lps = locallps.jdField_a_of_type_Lps;
        locallps.jdField_a_of_type_Lps = null;
        locallps.jdField_a_of_type_Int = paramInt1;
        locallps.jdField_b_of_type_Int = paramInt2;
        c -= 1;
        return locallps;
      }
      return new lps(paramInt1, paramInt2);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (c < 4)
      {
        this.jdField_a_of_type_Lps = jdField_b_of_type_Lps;
        jdField_b_of_type_Lps = this;
        c += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     lps
 * JD-Core Version:    0.7.0.1
 */