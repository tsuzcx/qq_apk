public class lpp
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  public mrd a;
  boolean jdField_a_of_type_Boolean;
  byte[] jdField_a_of_type_ArrayOfByte;
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long;
  int jdField_c_of_type_Int;
  long jdField_c_of_type_Long;
  int d;
  int e;
  public int f;
  public int g;
  
  lpp() {}
  
  public lpp(long paramLong1, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, long paramLong2, long paramLong3)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_c_of_type_Int = paramInt3;
    this.d = paramInt4;
    this.e = paramInt5;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Long = paramLong2;
    this.jdField_b_of_type_Long = paramLong3;
    this.jdField_c_of_type_Long = paramLong1;
    this.f = 0;
    this.g = 0;
  }
  
  lpp(lpp paramlpp)
  {
    this(paramlpp.jdField_c_of_type_Long, paramlpp.jdField_a_of_type_ArrayOfByte, paramlpp.jdField_a_of_type_Int, paramlpp.jdField_b_of_type_Int, paramlpp.jdField_c_of_type_Int, paramlpp.d, paramlpp.e, paramlpp.jdField_a_of_type_Boolean, paramlpp.jdField_a_of_type_Long, paramlpp.jdField_b_of_type_Long);
    this.f = paramlpp.f;
    this.g = paramlpp.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lpp
 * JD-Core Version:    0.7.0.1
 */