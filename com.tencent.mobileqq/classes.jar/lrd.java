public class lrd
{
  private short jdField_a_of_type_Short;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private short b;
  
  public lrd(short paramShort1, short paramShort2, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_Short = paramShort1;
    this.b = paramShort2;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public int a()
  {
    return b() + 4;
  }
  
  public short a()
  {
    return this.jdField_a_of_type_Short;
  }
  
  public byte[] a()
  {
    return this.jdField_a_of_type_ArrayOfByte;
  }
  
  public short b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lrd
 * JD-Core Version:    0.7.0.1
 */