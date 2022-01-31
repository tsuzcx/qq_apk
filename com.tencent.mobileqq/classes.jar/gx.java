public final class gx
{
  private final int jdField_a_of_type_Int;
  private final gw[] jdField_a_of_type_ArrayOfGw;
  
  gx(int paramInt, gw... paramVarArgs)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ArrayOfGw = paramVarArgs;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public gw[] a()
  {
    return this.jdField_a_of_type_ArrayOfGw;
  }
  
  public int b()
  {
    int i = 0;
    gw[] arrayOfgw = this.jdField_a_of_type_ArrayOfGw;
    int k = arrayOfgw.length;
    int j = 0;
    while (i < k)
    {
      j += arrayOfgw[i].a();
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
 * Qualified Name:     gx
 * JD-Core Version:    0.7.0.1
 */