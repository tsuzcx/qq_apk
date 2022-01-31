public class lqj
{
  public static final Object a;
  private static lqj b;
  private static int c;
  public int a;
  private lqj a;
  public int b;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  private lqj(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public static lqj a(int paramInt1, int paramInt2)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_b_of_type_Lqj != null)
      {
        lqj locallqj = jdField_b_of_type_Lqj;
        jdField_b_of_type_Lqj = locallqj.jdField_a_of_type_Lqj;
        locallqj.jdField_a_of_type_Lqj = null;
        locallqj.jdField_a_of_type_Int = paramInt1;
        locallqj.jdField_b_of_type_Int = paramInt2;
        c -= 1;
        return locallqj;
      }
      return new lqj(paramInt1, paramInt2);
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
        this.jdField_a_of_type_Lqj = jdField_b_of_type_Lqj;
        jdField_b_of_type_Lqj = this;
        c += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lqj
 * JD-Core Version:    0.7.0.1
 */