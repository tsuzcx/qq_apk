import java.io.BufferedReader;

public class lcd
  extends lcc
{
  private float a;
  private float b;
  
  public float a()
  {
    return this.jdField_a_of_type_Float + (this.b - this.jdField_a_of_type_Float) * lbu.a();
  }
  
  public void a(BufferedReader paramBufferedReader)
  {
    super.a(paramBufferedReader);
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Float = lbz.a(paramBufferedReader, "lowMin");
    this.b = lbz.a(paramBufferedReader, "lowMax");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lcd
 * JD-Core Version:    0.7.0.1
 */