class qwl
  extends qwp
{
  private final int jdField_a_of_type_Int;
  private final qwr jdField_a_of_type_Qwr;
  private final qwr b;
  
  public qwl(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Qwr = new qwr(this.jdField_a_of_type_Int);
    this.b = new qwr(this.jdField_a_of_type_Int);
  }
  
  public long a(long paramLong)
  {
    this.jdField_a_of_type_Qwr.a(paramLong);
    paramLong = this.jdField_a_of_type_Qwr.b;
    this.b.a(paramLong);
    long l = this.b.b;
    float f = 2.0F / (Math.max(this.jdField_a_of_type_Qwr.a(), 2) - 1);
    return ((float)(paramLong - l) * f + (float)(2L * paramLong - l));
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_Qwr.a();
    this.b.a();
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_Qwr.b();
    this.b.b();
  }
  
  public String toString()
  {
    return "DoubleMoveAvgPredictor(" + this.jdField_a_of_type_Int + ')';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qwl
 * JD-Core Version:    0.7.0.1
 */