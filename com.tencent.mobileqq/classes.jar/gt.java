public final class gt
{
  public static final gt a;
  private final int jdField_a_of_type_Int;
  private gu jdField_a_of_type_Gu;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt;
  private final int jdField_b_of_type_Int;
  private gu jdField_b_of_type_Gu;
  private int[] jdField_b_of_type_ArrayOfInt;
  
  static
  {
    jdField_a_of_type_Gt = new gt(285, 256);
  }
  
  public gt(int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
    if (paramInt2 <= 0) {
      a();
    }
  }
  
  static int a(int paramInt1, int paramInt2)
  {
    return paramInt1 ^ paramInt2;
  }
  
  private void a()
  {
    this.jdField_a_of_type_ArrayOfInt = new int[this.jdField_a_of_type_Int];
    this.jdField_b_of_type_ArrayOfInt = new int[this.jdField_a_of_type_Int];
    int j = 0;
    int i = 1;
    while (j < this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_ArrayOfInt[j] = i;
      int k = i << 1;
      i = k;
      if (k >= this.jdField_a_of_type_Int) {
        i = (k ^ this.jdField_b_of_type_Int) & this.jdField_a_of_type_Int - 1;
      }
      j += 1;
    }
    i = 0;
    while (i < this.jdField_a_of_type_Int - 1)
    {
      this.jdField_b_of_type_ArrayOfInt[this.jdField_a_of_type_ArrayOfInt[i]] = i;
      i += 1;
    }
    this.jdField_a_of_type_Gu = new gu(this, new int[] { 0 });
    this.jdField_b_of_type_Gu = new gu(this, new int[] { 1 });
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void b()
  {
    if (!this.jdField_a_of_type_Boolean) {
      a();
    }
  }
  
  int a(int paramInt)
  {
    b();
    return this.jdField_a_of_type_ArrayOfInt[paramInt];
  }
  
  gu a()
  {
    b();
    return this.jdField_a_of_type_Gu;
  }
  
  gu a(int paramInt1, int paramInt2)
  {
    b();
    if (paramInt1 < 0) {
      throw new IllegalArgumentException();
    }
    if (paramInt2 == 0) {
      return this.jdField_a_of_type_Gu;
    }
    int[] arrayOfInt = new int[paramInt1 + 1];
    arrayOfInt[0] = paramInt2;
    return new gu(this, arrayOfInt);
  }
  
  int b(int paramInt)
  {
    b();
    if (paramInt == 0) {
      throw new IllegalArgumentException();
    }
    return this.jdField_b_of_type_ArrayOfInt[paramInt];
  }
  
  int b(int paramInt1, int paramInt2)
  {
    b();
    if ((paramInt1 == 0) || (paramInt2 == 0)) {
      return 0;
    }
    return this.jdField_a_of_type_ArrayOfInt[((this.jdField_b_of_type_ArrayOfInt[paramInt1] + this.jdField_b_of_type_ArrayOfInt[paramInt2]) % (this.jdField_a_of_type_Int - 1))];
  }
  
  int c(int paramInt)
  {
    b();
    if (paramInt == 0) {
      throw new ArithmeticException();
    }
    return this.jdField_a_of_type_ArrayOfInt[(this.jdField_a_of_type_Int - this.jdField_b_of_type_ArrayOfInt[paramInt] - 1)];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     gt
 * JD-Core Version:    0.7.0.1
 */