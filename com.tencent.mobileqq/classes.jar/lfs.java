public class lfs
{
  public static final Object a;
  private static lfs b;
  private static int c;
  public int a;
  private lfs a;
  public int b;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  private lfs(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public static lfs a(int paramInt1, int paramInt2)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_b_of_type_Lfs != null)
      {
        lfs locallfs = jdField_b_of_type_Lfs;
        jdField_b_of_type_Lfs = locallfs.jdField_a_of_type_Lfs;
        locallfs.jdField_a_of_type_Lfs = null;
        locallfs.jdField_a_of_type_Int = paramInt1;
        locallfs.jdField_b_of_type_Int = paramInt2;
        c -= 1;
        return locallfs;
      }
      return new lfs(paramInt1, paramInt2);
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
        this.jdField_a_of_type_Lfs = jdField_b_of_type_Lfs;
        jdField_b_of_type_Lfs = this;
        c += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lfs
 * JD-Core Version:    0.7.0.1
 */