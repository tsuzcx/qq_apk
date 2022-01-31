class qwk
  extends qwp
{
  private final float jdField_a_of_type_Float;
  private final qwn jdField_a_of_type_Qwn;
  private final qwn b;
  
  public qwk(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_a_of_type_Qwn = new qwn(this.jdField_a_of_type_Float);
    this.b = new qwn(this.jdField_a_of_type_Float);
  }
  
  public long a(long paramLong)
  {
    this.jdField_a_of_type_Qwn.a(paramLong);
    paramLong = this.jdField_a_of_type_Qwn.b;
    this.b.a(paramLong);
    long l = this.b.b;
    float f = this.jdField_a_of_type_Float / (1.0F - this.jdField_a_of_type_Float);
    return ((float)(paramLong - l) * f + (float)(2L * paramLong - l));
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_Qwn.a();
    this.b.a();
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_Qwn.b();
    this.b.b();
  }
  
  public String toString()
  {
    return "DoubleExponentialPredictor(" + this.jdField_a_of_type_Float + ')';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qwk
 * JD-Core Version:    0.7.0.1
 */