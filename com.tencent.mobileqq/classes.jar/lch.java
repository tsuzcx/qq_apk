import java.io.BufferedReader;

public class lch
  extends lcc
{
  int a;
  int b = 0;
  boolean c;
  
  public lch()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(BufferedReader paramBufferedReader)
  {
    super.a(paramBufferedReader);
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_a_of_type_Int = lcg.a(lbz.a(paramBufferedReader, "shape"));
    } while (this.jdField_a_of_type_Int != 3);
    this.c = lbz.a(paramBufferedReader, "edges");
    this.b = lcf.a(lbz.a(paramBufferedReader, "side"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lch
 * JD-Core Version:    0.7.0.1
 */