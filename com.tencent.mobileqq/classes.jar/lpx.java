public class lpx
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static lpx b;
  private static int c;
  public int a;
  private lpx jdField_a_of_type_Lpx;
  public int b;
  
  private lpx(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public static lpx a(int paramInt1, int paramInt2)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_b_of_type_Lpx != null)
      {
        lpx locallpx = jdField_b_of_type_Lpx;
        jdField_b_of_type_Lpx = locallpx.jdField_a_of_type_Lpx;
        locallpx.jdField_a_of_type_Lpx = null;
        locallpx.jdField_a_of_type_Int = paramInt1;
        locallpx.jdField_b_of_type_Int = paramInt2;
        c -= 1;
        return locallpx;
      }
      return new lpx(paramInt1, paramInt2);
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
        this.jdField_a_of_type_Lpx = jdField_b_of_type_Lpx;
        jdField_b_of_type_Lpx = this;
        c += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lpx
 * JD-Core Version:    0.7.0.1
 */