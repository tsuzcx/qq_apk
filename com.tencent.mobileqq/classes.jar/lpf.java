public class lpf
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static lpf b;
  private static int c;
  public int a;
  private lpf jdField_a_of_type_Lpf;
  public int b;
  
  private lpf(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public static lpf a(int paramInt1, int paramInt2)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_b_of_type_Lpf != null)
      {
        lpf locallpf = jdField_b_of_type_Lpf;
        jdField_b_of_type_Lpf = locallpf.jdField_a_of_type_Lpf;
        locallpf.jdField_a_of_type_Lpf = null;
        locallpf.jdField_a_of_type_Int = paramInt1;
        locallpf.jdField_b_of_type_Int = paramInt2;
        c -= 1;
        return locallpf;
      }
      return new lpf(paramInt1, paramInt2);
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
        this.jdField_a_of_type_Lpf = jdField_b_of_type_Lpf;
        jdField_b_of_type_Lpf = this;
        c += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lpf
 * JD-Core Version:    0.7.0.1
 */