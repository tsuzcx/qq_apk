import java.io.BufferedReader;

public class lmh
  extends lmc
{
  int a;
  int b = 0;
  boolean c;
  
  public lmh()
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
      this.jdField_a_of_type_Int = lmg.a(llz.a(paramBufferedReader, "shape"));
    } while (this.jdField_a_of_type_Int != 3);
    this.c = llz.a(paramBufferedReader, "edges");
    this.b = lmf.a(llz.a(paramBufferedReader, "side"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lmh
 * JD-Core Version:    0.7.0.1
 */