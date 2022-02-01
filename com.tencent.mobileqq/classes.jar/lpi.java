public class lpi
{
  public static final Object a;
  private static lpi b;
  private static int c;
  public int a;
  private lpi a;
  public int b;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  private lpi(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public static lpi a(int paramInt1, int paramInt2)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_b_of_type_Lpi != null)
      {
        lpi locallpi = jdField_b_of_type_Lpi;
        jdField_b_of_type_Lpi = locallpi.jdField_a_of_type_Lpi;
        locallpi.jdField_a_of_type_Lpi = null;
        locallpi.jdField_a_of_type_Int = paramInt1;
        locallpi.jdField_b_of_type_Int = paramInt2;
        c -= 1;
        return locallpi;
      }
      return new lpi(paramInt1, paramInt2);
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
        this.jdField_a_of_type_Lpi = jdField_b_of_type_Lpi;
        jdField_b_of_type_Lpi = this;
        c += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lpi
 * JD-Core Version:    0.7.0.1
 */