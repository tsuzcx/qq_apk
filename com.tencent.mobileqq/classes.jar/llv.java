import java.io.BufferedReader;

public class llv
  extends llu
{
  private float a;
  private float b;
  
  public float a()
  {
    return this.jdField_a_of_type_Float + (this.b - this.jdField_a_of_type_Float) * llm.a();
  }
  
  public void a(BufferedReader paramBufferedReader)
  {
    super.a(paramBufferedReader);
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Float = llr.a(paramBufferedReader, "lowMin");
    this.b = llr.a(paramBufferedReader, "lowMax");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     llv
 * JD-Core Version:    0.7.0.1
 */