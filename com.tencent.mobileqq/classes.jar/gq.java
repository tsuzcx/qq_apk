public final class gq
{
  private int jdField_a_of_type_Int = 0;
  private int[] jdField_a_of_type_ArrayOfInt = new int[1];
  
  private void a(int paramInt)
  {
    if (paramInt > this.jdField_a_of_type_ArrayOfInt.length << 5)
    {
      int[] arrayOfInt = a(paramInt);
      System.arraycopy(this.jdField_a_of_type_ArrayOfInt, 0, arrayOfInt, 0, this.jdField_a_of_type_ArrayOfInt.length);
      this.jdField_a_of_type_ArrayOfInt = arrayOfInt;
    }
  }
  
  private static int[] a(int paramInt)
  {
    return new int[paramInt + 31 >> 5];
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt2 < 0) || (paramInt2 > 32)) {
      throw new IllegalArgumentException("Num bits must be between 0 and 32");
    }
    a(this.jdField_a_of_type_Int + paramInt2);
    if (paramInt2 > 0)
    {
      if ((paramInt1 >> paramInt2 - 1 & 0x1) == 1) {}
      for (boolean bool = true;; bool = false)
      {
        a(bool);
        paramInt2 -= 1;
        break;
      }
    }
  }
  
  public void a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    int i = 0;
    while (i < paramInt3)
    {
      int j = 0;
      int m;
      for (int k = 0; j < 8; k = m)
      {
        m = k;
        if (a(paramInt1)) {
          m = k | 1 << 7 - j;
        }
        paramInt1 += 1;
        j += 1;
      }
      paramArrayOfByte[(paramInt2 + i)] = ((byte)k);
      i += 1;
    }
  }
  
  public void a(gq paramgq)
  {
    int j = paramgq.jdField_a_of_type_Int;
    a(this.jdField_a_of_type_Int + j);
    int i = 0;
    while (i < j)
    {
      a(paramgq.a(i));
      i += 1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    a(this.jdField_a_of_type_Int + 1);
    if (paramBoolean)
    {
      int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      int i = this.jdField_a_of_type_Int >> 5;
      arrayOfInt[i] |= 1 << (this.jdField_a_of_type_Int & 0x1F);
    }
    this.jdField_a_of_type_Int += 1;
  }
  
  public boolean a(int paramInt)
  {
    return (this.jdField_a_of_type_ArrayOfInt[(paramInt >> 5)] & 1 << (paramInt & 0x1F)) != 0;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int + 7 >> 3;
  }
  
  public void b(gq paramgq)
  {
    if (this.jdField_a_of_type_ArrayOfInt.length != paramgq.jdField_a_of_type_ArrayOfInt.length) {
      throw new IllegalArgumentException("Sizes don't match");
    }
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfInt.length)
    {
      int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      arrayOfInt[i] ^= paramgq.jdField_a_of_type_ArrayOfInt[i];
      i += 1;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(this.jdField_a_of_type_Int);
    int i = 0;
    if (i < this.jdField_a_of_type_Int)
    {
      if ((i & 0x7) == 0) {
        localStringBuilder.append(' ');
      }
      if (a(i)) {}
      for (char c = 'X';; c = '.')
      {
        localStringBuilder.append(c);
        i += 1;
        break;
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     gq
 * JD-Core Version:    0.7.0.1
 */