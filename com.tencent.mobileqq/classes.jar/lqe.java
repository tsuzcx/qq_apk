public class lqe
{
  public static final Object a;
  private static lqe b;
  private static int c;
  public int a;
  private lqe a;
  public int b;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  private lqe(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public static lqe a(int paramInt1, int paramInt2)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_b_of_type_Lqe != null)
      {
        lqe locallqe = jdField_b_of_type_Lqe;
        jdField_b_of_type_Lqe = locallqe.jdField_a_of_type_Lqe;
        locallqe.jdField_a_of_type_Lqe = null;
        locallqe.jdField_a_of_type_Int = paramInt1;
        locallqe.jdField_b_of_type_Int = paramInt2;
        c -= 1;
        return locallqe;
      }
      return new lqe(paramInt1, paramInt2);
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
        this.jdField_a_of_type_Lqe = jdField_b_of_type_Lqe;
        jdField_b_of_type_Lqe = this;
        c += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lqe
 * JD-Core Version:    0.7.0.1
 */