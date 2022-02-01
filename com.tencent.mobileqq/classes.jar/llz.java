import java.io.BufferedReader;

public class llz
  extends llu
{
  int a;
  int b = 0;
  boolean c;
  
  public llz()
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
      this.jdField_a_of_type_Int = lly.a(llr.a(paramBufferedReader, "shape"));
    } while (this.jdField_a_of_type_Int != 3);
    this.c = llr.a(paramBufferedReader, "edges");
    this.b = llx.a(llr.a(paramBufferedReader, "side"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     llz
 * JD-Core Version:    0.7.0.1
 */