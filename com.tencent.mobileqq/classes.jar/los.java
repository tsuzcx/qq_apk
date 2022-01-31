import java.io.BufferedReader;

public class los
  extends lor
{
  private float a;
  private float b;
  
  public float a()
  {
    return this.jdField_a_of_type_Float + (this.b - this.jdField_a_of_type_Float) * loj.a();
  }
  
  public void a(BufferedReader paramBufferedReader)
  {
    super.a(paramBufferedReader);
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Float = loo.a(paramBufferedReader, "lowMin");
    this.b = loo.a(paramBufferedReader, "lowMax");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     los
 * JD-Core Version:    0.7.0.1
 */