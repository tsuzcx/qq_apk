final class gt
{
  private final gs jdField_a_of_type_Gs;
  private final int[] jdField_a_of_type_ArrayOfInt;
  
  gt(gs paramgs, int[] paramArrayOfInt)
  {
    if (paramArrayOfInt.length == 0) {
      throw new IllegalArgumentException();
    }
    this.jdField_a_of_type_Gs = paramgs;
    int j = paramArrayOfInt.length;
    if ((j > 1) && (paramArrayOfInt[0] == 0))
    {
      while ((i < j) && (paramArrayOfInt[i] == 0)) {
        i += 1;
      }
      if (i == j)
      {
        this.jdField_a_of_type_ArrayOfInt = paramgs.a().jdField_a_of_type_ArrayOfInt;
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
  
  gt a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      throw new IllegalArgumentException();
    }
    if (paramInt2 == 0) {
      return this.jdField_a_of_type_Gs.a();
    }
    int i = this.jdField_a_of_type_ArrayOfInt.length;
    int[] arrayOfInt = new int[i + paramInt1];
    paramInt1 = 0;
    while (paramInt1 < i)
    {
      arrayOfInt[paramInt1] = this.jdField_a_of_type_Gs.b(this.jdField_a_of_type_ArrayOfInt[paramInt1], paramInt2);
      paramInt1 += 1;
    }
    return new gt(this.jdField_a_of_type_Gs, arrayOfInt);
  }
  
  gt a(gt paramgt)
  {
    if (!this.jdField_a_of_type_Gs.equals(paramgt.jdField_a_of_type_Gs)) {
      throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }
    if (a()) {
      return paramgt;
    }
    if (paramgt.a()) {
      return this;
    }
    Object localObject = this.jdField_a_of_type_ArrayOfInt;
    int[] arrayOfInt = paramgt.jdField_a_of_type_ArrayOfInt;
    if (localObject.length > arrayOfInt.length) {
      paramgt = arrayOfInt;
    }
    for (;;)
    {
      arrayOfInt = new int[localObject.length];
      int j = localObject.length - paramgt.length;
      System.arraycopy(localObject, 0, arrayOfInt, 0, j);
      int i = j;
      while (i < localObject.length)
      {
        arrayOfInt[i] = gs.a(paramgt[(i - j)], localObject[i]);
        i += 1;
      }
      return new gt(this.jdField_a_of_type_Gs, arrayOfInt);
      paramgt = (gt)localObject;
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
  
  gt[] a(gt paramgt)
  {
    if (!this.jdField_a_of_type_Gs.equals(paramgt.jdField_a_of_type_Gs)) {
      throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }
    if (paramgt.a()) {
      throw new IllegalArgumentException("Divide by 0");
    }
    gt localgt2 = this.jdField_a_of_type_Gs.a();
    int i = paramgt.a(paramgt.a());
    i = this.jdField_a_of_type_Gs.c(i);
    gt localgt3;
    for (gt localgt1 = this; (localgt1.a() >= paramgt.a()) && (!localgt1.a()); localgt1 = localgt1.a(localgt3))
    {
      int j = localgt1.a() - paramgt.a();
      int k = this.jdField_a_of_type_Gs.b(localgt1.a(localgt1.a()), i);
      localgt3 = paramgt.a(j, k);
      localgt2 = localgt2.a(this.jdField_a_of_type_Gs.a(j, k));
    }
    return new gt[] { localgt2, localgt1 };
  }
  
  gt b(gt paramgt)
  {
    if (!this.jdField_a_of_type_Gs.equals(paramgt.jdField_a_of_type_Gs)) {
      throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }
    if ((a()) || (paramgt.a())) {
      return this.jdField_a_of_type_Gs.a();
    }
    int[] arrayOfInt1 = this.jdField_a_of_type_ArrayOfInt;
    int k = arrayOfInt1.length;
    paramgt = paramgt.jdField_a_of_type_ArrayOfInt;
    int m = paramgt.length;
    int[] arrayOfInt2 = new int[k + m - 1];
    int i = 0;
    while (i < k)
    {
      int n = arrayOfInt1[i];
      int j = 0;
      while (j < m)
      {
        arrayOfInt2[(i + j)] = gs.a(arrayOfInt2[(i + j)], this.jdField_a_of_type_Gs.b(n, paramgt[j]));
        j += 1;
      }
      i += 1;
    }
    return new gt(this.jdField_a_of_type_Gs, arrayOfInt2);
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
          j = this.jdField_a_of_type_Gs.b(j);
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
 * Qualified Name:     gt
 * JD-Core Version:    0.7.0.1
 */