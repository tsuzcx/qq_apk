public class mnd
{
  public long a;
  public byte[] a;
  public long b;
  
  public mnd(byte[] paramArrayOfByte, long paramLong)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("PCMFrame:");
    if (this.jdField_a_of_type_ArrayOfByte == null) {}
    for (int i = -1;; i = this.jdField_a_of_type_ArrayOfByte.length) {
      return i + ", idx=" + this.jdField_a_of_type_Long + ", pts=" + this.b;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mnd
 * JD-Core Version:    0.7.0.1
 */