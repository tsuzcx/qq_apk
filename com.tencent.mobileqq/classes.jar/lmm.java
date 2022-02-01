import java.io.BufferedReader;

public class lmm
  extends lmh
{
  int a;
  int b = 0;
  boolean c;
  
  public lmm()
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
      this.jdField_a_of_type_Int = lml.a(lme.a(paramBufferedReader, "shape"));
    } while (this.jdField_a_of_type_Int != 3);
    this.c = lme.a(paramBufferedReader, "edges");
    this.b = lmk.a(lme.a(paramBufferedReader, "side"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lmm
 * JD-Core Version:    0.7.0.1
 */