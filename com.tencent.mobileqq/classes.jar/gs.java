final class gs
{
  private final gr jdField_a_of_type_Gr;
  private final int[] jdField_a_of_type_ArrayOfInt;
  
  gs(gr paramgr, int[] paramArrayOfInt)
  {
    if (paramArrayOfInt.length == 0) {
      throw new IllegalArgumentException();
    }
    this.jdField_a_of_type_Gr = paramgr;
    int j = paramArrayOfInt.length;
    if ((j > 1) && (paramArrayOfInt[0] == 0))
    {
      while ((i < j) && (paramArrayOfInt[i] == 0)) {
        i += 1;
      }
      if (i == j)
      {
        this.jdField_a_of_type_ArrayOfInt = paramgr.a().jdField_a_of_type_ArrayOfInt;
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
  
  gs a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      throw new IllegalArgumentException();
    }
    if (paramInt2 == 0) {
      return this.jdField_a_of_type_Gr.a();
    }
    int i = this.jdField_a_of_type_ArrayOfInt.length;
    int[] arrayOfInt = new int[i + paramInt1];
    paramInt1 = 0;
    while (paramInt1 < i)
    {
      arrayOfInt[paramInt1] = this.jdField_a_of_type_Gr.b(this.jdField_a_of_type_ArrayOfInt[paramInt1], paramInt2);
      paramInt1 += 1;
    }
    return new gs(this.jdField_a_of_type_Gr, arrayOfInt);
  }
  
  gs a(gs paramgs)
  {
    if (!this.jdField_a_of_type_Gr.equals(paramgs.jdField_a_of_type_Gr)) {
      throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }
    if (a()) {
      return paramgs;
    }
    if (paramgs.a()) {
      return this;
    }
    Object localObject = this.jdField_a_of_type_ArrayOfInt;
    int[] arrayOfInt = paramgs.jdField_a_of_type_ArrayOfInt;
    if (localObject.length > arrayOfInt.length) {
      paramgs = arrayOfInt;
    }
    for (;;)
    {
      arrayOfInt = new int[localObject.length];
      int j = localObject.length - paramgs.length;
      System.arraycopy(localObject, 0, arrayOfInt, 0, j);
      int i = j;
      while (i < localObject.length)
      {
        arrayOfInt[i] = gr.a(paramgs[(i - j)], localObject[i]);
        i += 1;
      }
      return new gs(this.jdField_a_of_type_Gr, arrayOfInt);
      paramgs = (gs)localObject;
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
  
  gs[] a(gs paramgs)
  {
    if (!this.jdField_a_of_type_Gr.equals(paramgs.jdField_a_of_type_Gr)) {
      throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }
    if (paramgs.a()) {
      throw new IllegalArgumentException("Divide by 0");
    }
    gs localgs2 = this.jdField_a_of_type_Gr.a();
    int i = paramgs.a(paramgs.a());
    i = this.jdField_a_of_type_Gr.c(i);
    gs localgs3;
    for (gs localgs1 = this; (localgs1.a() >= paramgs.a()) && (!localgs1.a()); localgs1 = localgs1.a(localgs3))
    {
      int j = localgs1.a() - paramgs.a();
      int k = this.jdField_a_of_type_Gr.b(localgs1.a(localgs1.a()), i);
      localgs3 = paramgs.a(j, k);
      localgs2 = localgs2.a(this.jdField_a_of_type_Gr.a(j, k));
    }
    return new gs[] { localgs2, localgs1 };
  }
  
  gs b(gs paramgs)
  {
    if (!this.jdField_a_of_type_Gr.equals(paramgs.jdField_a_of_type_Gr)) {
      throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }
    if ((a()) || (paramgs.a())) {
      return this.jdField_a_of_type_Gr.a();
    }
    int[] arrayOfInt1 = this.jdField_a_of_type_ArrayOfInt;
    int k = arrayOfInt1.length;
    paramgs = paramgs.jdField_a_of_type_ArrayOfInt;
    int m = paramgs.length;
    int[] arrayOfInt2 = new int[k + m - 1];
    int i = 0;
    while (i < k)
    {
      int n = arrayOfInt1[i];
      int j = 0;
      while (j < m)
      {
        arrayOfInt2[(i + j)] = gr.a(arrayOfInt2[(i + j)], this.jdField_a_of_type_Gr.b(n, paramgs[j]));
        j += 1;
      }
      i += 1;
    }
    return new gs(this.jdField_a_of_type_Gr, arrayOfInt2);
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
          j = this.jdField_a_of_type_Gr.b(j);
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
 * Qualified Name:     gs
 * JD-Core Version:    0.7.0.1
 */