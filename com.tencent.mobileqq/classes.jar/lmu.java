import java.io.BufferedReader;

public class lmu
  extends lmt
{
  private float a;
  private float b;
  
  public float a()
  {
    return this.jdField_a_of_type_Float + (this.b - this.jdField_a_of_type_Float) * lml.a();
  }
  
  public void a(BufferedReader paramBufferedReader)
  {
    super.a(paramBufferedReader);
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Float = lmq.a(paramBufferedReader, "lowMin");
    this.b = lmq.a(paramBufferedReader, "lowMax");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lmu
 * JD-Core Version:    0.7.0.1
 */