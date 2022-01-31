class qkg
  extends qkk
{
  private final int jdField_a_of_type_Int;
  private final qkm jdField_a_of_type_Qkm;
  private final qkm b;
  
  public qkg(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Qkm = new qkm(this.jdField_a_of_type_Int);
    this.b = new qkm(this.jdField_a_of_type_Int);
  }
  
  public long a(long paramLong)
  {
    this.jdField_a_of_type_Qkm.a(paramLong);
    paramLong = this.jdField_a_of_type_Qkm.b;
    this.b.a(paramLong);
    long l = this.b.b;
    float f = 2.0F / (Math.max(this.jdField_a_of_type_Qkm.a(), 2) - 1);
    return ((float)(paramLong - l) * f + (float)(2L * paramLong - l));
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_Qkm.a();
    this.b.a();
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_Qkm.b();
    this.b.b();
  }
  
  public String toString()
  {
    return "DoubleMoveAvgPredictor(" + this.jdField_a_of_type_Int + ')';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qkg
 * JD-Core Version:    0.7.0.1
 */