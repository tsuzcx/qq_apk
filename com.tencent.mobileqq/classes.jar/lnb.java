public class lnb
{
  private int jdField_a_of_type_Int;
  private byte[] jdField_a_of_type_ArrayOfByte = new byte[512];
  private int b;
  
  public lnb()
  {
    int i = 0;
    while (i < 512)
    {
      this.jdField_a_of_type_ArrayOfByte[i] = 0;
      i += 1;
    }
    this.jdField_a_of_type_Int = 0;
    this.b = 0;
  }
  
  public void a(byte paramByte)
  {
    this.jdField_a_of_type_ArrayOfByte[this.jdField_a_of_type_Int] = paramByte;
    this.jdField_a_of_type_Int += 1;
    this.b += 1;
  }
  
  public void a(int paramInt)
  {
    int i = (byte)(paramInt & 0xFF);
    int j = (byte)(paramInt >> 8 & 0xFF);
    int k = (byte)(paramInt >> 16 & 0xFF);
    int m = (byte)(paramInt >> 24 & 0xFF);
    byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    paramInt = this.jdField_a_of_type_Int;
    System.arraycopy(new byte[] { m, k, j, i }, 0, arrayOfByte, paramInt, 4);
    this.jdField_a_of_type_Int += 4;
    this.b += 4;
  }
  
  public byte[] a()
  {
    byte[] arrayOfByte = new byte[this.b];
    System.arraycopy(this.jdField_a_of_type_ArrayOfByte, 0, arrayOfByte, 0, this.b);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lnb
 * JD-Core Version:    0.7.0.1
 */