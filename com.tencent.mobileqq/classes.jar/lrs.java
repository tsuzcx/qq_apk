public class lrs
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  public mtx a;
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
  
  lrs() {}
  
  public lrs(long paramLong1, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, long paramLong2, long paramLong3)
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
  
  lrs(lrs paramlrs)
  {
    this(paramlrs.jdField_c_of_type_Long, paramlrs.jdField_a_of_type_ArrayOfByte, paramlrs.jdField_a_of_type_Int, paramlrs.jdField_b_of_type_Int, paramlrs.jdField_c_of_type_Int, paramlrs.d, paramlrs.e, paramlrs.jdField_a_of_type_Boolean, paramlrs.jdField_a_of_type_Long, paramlrs.jdField_b_of_type_Long);
    this.f = paramlrs.f;
    this.g = paramlrs.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lrs
 * JD-Core Version:    0.7.0.1
 */