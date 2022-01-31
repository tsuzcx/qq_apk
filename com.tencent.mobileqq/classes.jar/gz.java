public final class gz
{
  private final int jdField_a_of_type_Int;
  private final gy[] jdField_a_of_type_ArrayOfGy;
  
  gz(int paramInt, gy... paramVarArgs)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ArrayOfGy = paramVarArgs;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public gy[] a()
  {
    return this.jdField_a_of_type_ArrayOfGy;
  }
  
  public int b()
  {
    int i = 0;
    gy[] arrayOfgy = this.jdField_a_of_type_ArrayOfGy;
    int k = arrayOfgy.length;
    int j = 0;
    while (i < k)
    {
      j += arrayOfgy[i].a();
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
 * Qualified Name:     gz
 * JD-Core Version:    0.7.0.1
 */