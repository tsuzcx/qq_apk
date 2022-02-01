class mod
{
  public String a;
  public byte[] a;
  
  public mod(String paramString, byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      arrayOfByte = new byte[0];
    }
    this.jdField_a_of_type_ArrayOfByte = arrayOfByte;
    paramArrayOfByte = paramString;
    if (paramString == null) {
      paramArrayOfByte = "";
    }
    this.jdField_a_of_type_JavaLangString = paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mod
 * JD-Core Version:    0.7.0.1
 */