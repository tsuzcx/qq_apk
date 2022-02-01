public final class ha
{
  private final int jdField_a_of_type_Int;
  private final gz[] jdField_a_of_type_ArrayOfGz;
  
  ha(int paramInt, gz... paramVarArgs)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ArrayOfGz = paramVarArgs;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public gz[] a()
  {
    return this.jdField_a_of_type_ArrayOfGz;
  }
  
  public int b()
  {
    int i = 0;
    gz[] arrayOfgz = this.jdField_a_of_type_ArrayOfGz;
    int k = arrayOfgz.length;
    int j = 0;
    while (i < k)
    {
      j += arrayOfgz[i].a();
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
 * Qualified Name:     ha
 * JD-Core Version:    0.7.0.1
 */