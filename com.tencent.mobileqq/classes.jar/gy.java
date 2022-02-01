public final class gy
{
  private final int jdField_a_of_type_Int;
  private final gx[] jdField_a_of_type_ArrayOfGx;
  
  gy(int paramInt, gx... paramVarArgs)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ArrayOfGx = paramVarArgs;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public gx[] a()
  {
    return this.jdField_a_of_type_ArrayOfGx;
  }
  
  public int b()
  {
    int i = 0;
    gx[] arrayOfgx = this.jdField_a_of_type_ArrayOfGx;
    int k = arrayOfgx.length;
    int j = 0;
    while (i < k)
    {
      j += arrayOfgx[i].a();
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
 * Qualified Name:     gy
 * JD-Core Version:    0.7.0.1
 */