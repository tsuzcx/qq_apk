final class gv
{
  private final gu jdField_a_of_type_Gu;
  private final int[] jdField_a_of_type_ArrayOfInt;
  
  gv(gu paramgu, int[] paramArrayOfInt)
  {
    if (paramArrayOfInt.length == 0) {
      throw new IllegalArgumentException();
    }
    this.jdField_a_of_type_Gu = paramgu;
    int j = paramArrayOfInt.length;
    if ((j > 1) && (paramArrayOfInt[0] == 0))
    {
      while ((i < j) && (paramArrayOfInt[i] == 0)) {
        i += 1;
      }
      if (i == j)
      {
        this.jdField_a_of_type_ArrayOfInt = paramgu.a().jdField_a_of_type_ArrayOfInt;
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
  
  gv a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      throw new IllegalArgumentException();
    }
    if (paramInt2 == 0) {
      return this.jdField_a_of_type_Gu.a();
    }
    int i = this.jdField_a_of_type_ArrayOfInt.length;
    int[] arrayOfInt = new int[i + paramInt1];
    paramInt1 = 0;
    while (paramInt1 < i)
    {
      arrayOfInt[paramInt1] = this.jdField_a_of_type_Gu.b(this.jdField_a_of_type_ArrayOfInt[paramInt1], paramInt2);
      paramInt1 += 1;
    }
    return new gv(this.jdField_a_of_type_Gu, arrayOfInt);
  }
  
  gv a(gv paramgv)
  {
    if (!this.jdField_a_of_type_Gu.equals(paramgv.jdField_a_of_type_Gu)) {
      throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }
    if (a()) {
      return paramgv;
    }
    if (paramgv.a()) {
      return this;
    }
    Object localObject = this.jdField_a_of_type_ArrayOfInt;
    int[] arrayOfInt = paramgv.jdField_a_of_type_ArrayOfInt;
    if (localObject.length > arrayOfInt.length) {
      paramgv = arrayOfInt;
    }
    for (;;)
    {
      arrayOfInt = new int[localObject.length];
      int j = localObject.length - paramgv.length;
      System.arraycopy(localObject, 0, arrayOfInt, 0, j);
      int i = j;
      while (i < localObject.length)
      {
        arrayOfInt[i] = gu.a(paramgv[(i - j)], localObject[i]);
        i += 1;
      }
      return new gv(this.jdField_a_of_type_Gu, arrayOfInt);
      paramgv = (gv)localObject;
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
  
  gv[] a(gv paramgv)
  {
    if (!this.jdField_a_of_type_Gu.equals(paramgv.jdField_a_of_type_Gu)) {
      throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }
    if (paramgv.a()) {
      throw new IllegalArgumentException("Divide by 0");
    }
    gv localgv2 = this.jdField_a_of_type_Gu.a();
    int i = paramgv.a(paramgv.a());
    i = this.jdField_a_of_type_Gu.c(i);
    gv localgv3;
    for (gv localgv1 = this; (localgv1.a() >= paramgv.a()) && (!localgv1.a()); localgv1 = localgv1.a(localgv3))
    {
      int j = localgv1.a() - paramgv.a();
      int k = this.jdField_a_of_type_Gu.b(localgv1.a(localgv1.a()), i);
      localgv3 = paramgv.a(j, k);
      localgv2 = localgv2.a(this.jdField_a_of_type_Gu.a(j, k));
    }
    return new gv[] { localgv2, localgv1 };
  }
  
  gv b(gv paramgv)
  {
    if (!this.jdField_a_of_type_Gu.equals(paramgv.jdField_a_of_type_Gu)) {
      throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }
    if ((a()) || (paramgv.a())) {
      return this.jdField_a_of_type_Gu.a();
    }
    int[] arrayOfInt1 = this.jdField_a_of_type_ArrayOfInt;
    int k = arrayOfInt1.length;
    paramgv = paramgv.jdField_a_of_type_ArrayOfInt;
    int m = paramgv.length;
    int[] arrayOfInt2 = new int[k + m - 1];
    int i = 0;
    while (i < k)
    {
      int n = arrayOfInt1[i];
      int j = 0;
      while (j < m)
      {
        arrayOfInt2[(i + j)] = gu.a(arrayOfInt2[(i + j)], this.jdField_a_of_type_Gu.b(n, paramgv[j]));
        j += 1;
      }
      i += 1;
    }
    return new gv(this.jdField_a_of_type_Gu, arrayOfInt2);
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
          j = this.jdField_a_of_type_Gu.b(j);
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
 * Qualified Name:     gv
 * JD-Core Version:    0.7.0.1
 */