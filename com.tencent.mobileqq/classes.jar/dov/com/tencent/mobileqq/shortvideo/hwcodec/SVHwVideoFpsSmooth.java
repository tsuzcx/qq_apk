package dov.com.tencent.mobileqq.shortvideo.hwcodec;

public class SVHwVideoFpsSmooth
{
  private float jdField_a_of_type_Float = 0.0F;
  private long jdField_a_of_type_Long = 0L;
  private float jdField_b_of_type_Float = 0.0F;
  private long jdField_b_of_type_Long = 0L;
  private float jdField_c_of_type_Float = 0.0F;
  private long jdField_c_of_type_Long = 0L;
  
  public long a(float paramFloat)
  {
    this.jdField_b_of_type_Long += (1000.0F * paramFloat);
    return this.jdField_b_of_type_Long;
  }
  
  public long a(long paramLong)
  {
    if (this.jdField_a_of_type_Long == 0L)
    {
      this.jdField_a_of_type_Long = (paramLong * 1000L);
      this.jdField_b_of_type_Long = (paramLong * 1000L);
      this.jdField_c_of_type_Long = paramLong;
    }
    return paramLong * 1000L;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_c_of_type_Float = 0.0F;
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = ((float)(1000.0D / paramFloat));
    this.jdField_b_of_type_Float = (this.jdField_a_of_type_Float + 0.3F);
    this.jdField_c_of_type_Float = (this.jdField_a_of_type_Float - 0.7F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.hwcodec.SVHwVideoFpsSmooth
 * JD-Core Version:    0.7.0.1
 */