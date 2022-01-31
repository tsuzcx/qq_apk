final class gu
{
  private final gt jdField_a_of_type_Gt;
  private final int[] jdField_a_of_type_ArrayOfInt;
  
  gu(gt paramgt, int[] paramArrayOfInt)
  {
    if (paramArrayOfInt.length == 0) {
      throw new IllegalArgumentException();
    }
    this.jdField_a_of_type_Gt = paramgt;
    int j = paramArrayOfInt.length;
    if ((j > 1) && (paramArrayOfInt[0] == 0))
    {
      while ((i < j) && (paramArrayOfInt[i] == 0)) {
        i += 1;
      }
      if (i == j)
      {
        this.jdField_a_of_type_ArrayOfInt = paramgt.a().jdField_a_of_type_ArrayOfInt;
        return;
      }
      this.jdField_a_of_type_ArrayOfInt = new int[j - i];
      System.arraycopy(paramArrayOfInt, i, this.jdField_a_of_type_ArrayOfInt, 0, this.jdField_a_of_type_ArrayOfInt.length);
      return;
    }
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
  }
  
  int a()
  {
    return this.jdField_a_of_type_ArrayOfInt.length - 1;
  }
  
  int a(int paramInt)
  {
    return this.jdField_a_of_type_ArrayOfInt[(this.jdField_a_of_type_ArrayOfInt.length - 1 - paramInt)];
  }
  
  gu a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      throw new IllegalArgumentException();
    }
    if (paramInt2 == 0) {
      return this.jdField_a_of_type_Gt.a();
    }
    int i = this.jdField_a_of_type_ArrayOfInt.length;
    int[] arrayOfInt = new int[i + paramInt1];
    paramInt1 = 0;
    while (paramInt1 < i)
    {
      arrayOfInt[paramInt1] = this.jdField_a_of_type_Gt.b(this.jdField_a_of_type_ArrayOfInt[paramInt1], paramInt2);
      paramInt1 += 1;
    }
    return new gu(this.jdField_a_of_type_Gt, arrayOfInt);
  }
  
  gu a(gu paramgu)
  {
    if (!this.jdField_a_of_type_Gt.equals(paramgu.jdField_a_of_type_Gt)) {
      throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }
    if (a()) {
      return paramgu;
    }
    if (paramgu.a()) {
      return this;
    }
    Object localObject = this.jdField_a_of_type_ArrayOfInt;
    int[] arrayOfInt = paramgu.jdField_a_of_type_ArrayOfInt;
    if (localObject.length > arrayOfInt.length) {
      paramgu = arrayOfInt;
    }
    for (;;)
    {
      arrayOfInt = new int[localObject.length];
      int j = localObject.length - paramgu.length;
      System.arraycopy(localObject, 0, arrayOfInt, 0, j);
      int i = j;
      while (i < localObject.length)
      {
        arrayOfInt[i] = gt.a(paramgu[(i - j)], localObject[i]);
        i += 1;
      }
      return new gu(this.jdField_a_of_type_Gt, arrayOfInt);
      paramgu = (gu)localObject;
      localObject = arrayOfInt;
    }
  }
  
  boolean a()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ArrayOfInt[0] == 0) {
      bool = true;
    }
    return bool;
  }
  
  int[] a()
  {
    return this.jdField_a_of_type_ArrayOfInt;
  }
  
  gu[] a(gu paramgu)
  {
    if (!this.jdField_a_of_type_Gt.equals(paramgu.jdField_a_of_type_Gt)) {
      throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }
    if (paramgu.a()) {
      throw new IllegalArgumentException("Divide by 0");
    }
    gu localgu2 = this.jdField_a_of_type_Gt.a();
    int i = paramgu.a(paramgu.a());
    i = this.jdField_a_of_type_Gt.c(i);
    gu localgu3;
    for (gu localgu1 = this; (localgu1.a() >= paramgu.a()) && (!localgu1.a()); localgu1 = localgu1.a(localgu3))
    {
      int j = localgu1.a() - paramgu.a();
      int k = this.jdField_a_of_type_Gt.b(localgu1.a(localgu1.a()), i);
      localgu3 = paramgu.a(j, k);
      localgu2 = localgu2.a(this.jdField_a_of_type_Gt.a(j, k));
    }
    return new gu[] { localgu2, localgu1 };
  }
  
  gu b(gu paramgu)
  {
    if (!this.jdField_a_of_type_Gt.equals(paramgu.jdField_a_of_type_Gt)) {
      throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }
    if ((a()) || (paramgu.a())) {
      return this.jdField_a_of_type_Gt.a();
    }
    int[] arrayOfInt1 = this.jdField_a_of_type_ArrayOfInt;
    int k = arrayOfInt1.length;
    paramgu = paramgu.jdField_a_of_type_ArrayOfInt;
    int m = paramgu.length;
    int[] arrayOfInt2 = new int[k + m - 1];
    int i = 0;
    while (i < k)
    {
      int n = arrayOfInt1[i];
      int j = 0;
      while (j < m)
      {
        arrayOfInt2[(i + j)] = gt.a(arrayOfInt2[(i + j)], this.jdField_a_of_type_Gt.b(n, paramgu[j]));
        j += 1;
      }
      i += 1;
    }
    return new gu(this.jdField_a_of_type_Gt, arrayOfInt2);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(a() * 8);
    int i = a();
    if (i >= 0)
    {
      int k = a(i);
      int j;
      if (k != 0)
      {
        if (k >= 0) {
          break label104;
        }
        localStringBuilder.append(" - ");
        j = -k;
        label50:
        if ((i == 0) || (j != 1))
        {
          j = this.jdField_a_of_type_Gt.b(j);
          if (j != 0) {
            break label127;
          }
          localStringBuilder.append('1');
        }
        label80:
        if (i != 0)
        {
          if (i != 1) {
            break label161;
          }
          localStringBuilder.append('x');
        }
      }
      for (;;)
      {
        i -= 1;
        break;
        label104:
        j = k;
        if (localStringBuilder.length() <= 0) {
          break label50;
        }
        localStringBuilder.append(" + ");
        j = k;
        break label50;
        label127:
        if (j == 1)
        {
          localStringBuilder.append('a');
          break label80;
        }
        localStringBuilder.append("a^");
        localStringBuilder.append(j);
        break label80;
        label161:
        localStringBuilder.append("x^");
        localStringBuilder.append(i);
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     gu
 * JD-Core Version:    0.7.0.1
 */