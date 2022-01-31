class mni
{
  public int a;
  public mnh a;
  public boolean a;
  
  public mni(mnh parammnh, boolean paramBoolean)
  {
    this.jdField_a_of_type_Mnh = parammnh;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = 0;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i;
    if (this.jdField_a_of_type_Boolean) {
      for (;;)
      {
        i = paramInt2;
        if (paramInt1 >= paramInt2) {
          break;
        }
        if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_Mnh.a.length) {
          this.jdField_a_of_type_Int = 0;
        }
        i = Math.min(this.jdField_a_of_type_Mnh.a.length - this.jdField_a_of_type_Int, paramInt2 - paramInt1);
        System.arraycopy(this.jdField_a_of_type_Mnh.a, this.jdField_a_of_type_Int, paramArrayOfByte, paramInt1, i);
        this.jdField_a_of_type_Int += i;
        paramInt1 += i;
      }
    }
    if (a())
    {
      i = 0;
      return i;
    }
    paramInt2 = Math.min(this.jdField_a_of_type_Mnh.a.length - this.jdField_a_of_type_Int, paramInt2);
    System.arraycopy(this.jdField_a_of_type_Mnh.a, this.jdField_a_of_type_Int, paramArrayOfByte, paramInt1, paramInt2);
    this.jdField_a_of_type_Int += paramInt2;
    return paramInt2;
  }
  
  public boolean a()
  {
    return (!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int >= this.jdField_a_of_type_Mnh.a.length);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mni
 * JD-Core Version:    0.7.0.1
 */