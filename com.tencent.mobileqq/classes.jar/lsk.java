public class lsk
{
  public static final Object a;
  private static lsk b;
  private static int c;
  public int a;
  private lsk a;
  public int b;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  private lsk(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public static lsk a(int paramInt1, int paramInt2)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_b_of_type_Lsk != null)
      {
        lsk locallsk = jdField_b_of_type_Lsk;
        jdField_b_of_type_Lsk = locallsk.jdField_a_of_type_Lsk;
        locallsk.jdField_a_of_type_Lsk = null;
        locallsk.jdField_a_of_type_Int = paramInt1;
        locallsk.jdField_b_of_type_Int = paramInt2;
        c -= 1;
        return locallsk;
      }
      return new lsk(paramInt1, paramInt2);
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
        this.jdField_a_of_type_Lsk = jdField_b_of_type_Lsk;
        jdField_b_of_type_Lsk = this;
        c += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lsk
 * JD-Core Version:    0.7.0.1
 */