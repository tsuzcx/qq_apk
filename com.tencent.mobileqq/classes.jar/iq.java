public final class iq
{
  private final int jdField_a_of_type_Int;
  private final ip[] jdField_a_of_type_ArrayOfIp;
  
  iq(int paramInt, ip... paramVarArgs)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ArrayOfIp = paramVarArgs;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public ip[] a()
  {
    return this.jdField_a_of_type_ArrayOfIp;
  }
  
  public int b()
  {
    int i = 0;
    ip[] arrayOfip = this.jdField_a_of_type_ArrayOfIp;
    int k = arrayOfip.length;
    int j = 0;
    while (i < k)
    {
      j += arrayOfip[i].a();
      i += 1;
    }
    return j;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Int * b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     iq
 * JD-Core Version:    0.7.0.1
 */