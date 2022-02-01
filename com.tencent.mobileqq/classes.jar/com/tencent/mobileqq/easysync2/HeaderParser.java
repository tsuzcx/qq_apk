package com.tencent.mobileqq.easysync2;

public class HeaderParser
{
  int a;
  int b;
  int c;
  private char[] d;
  
  private int b()
  {
    int i = 0;
    for (;;)
    {
      int j = this.a;
      char[] arrayOfChar = this.d;
      if (j + i >= arrayOfChar.length) {
        break;
      }
      j = arrayOfChar[(j + i)];
      if (((j < 48) || (j > 57)) && ((j < 97) || (j > 122))) {
        break;
      }
      i += 1;
    }
    return i;
  }
  
  void a()
  {
    this.a = 0;
    this.d = null;
    this.b = 0;
    this.c = 0;
  }
  
  void a(String paramString)
  {
    this.d = paramString.toCharArray();
    Object localObject = this.d;
    int j = localObject[0];
    int i = 1;
    if ((j != 90) && (localObject[1] != ':'))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Not a exports: ");
      ((StringBuilder)localObject).append(paramString);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    this.a += 2;
    j = b();
    if (j > 0)
    {
      int k = this.a;
      this.b = Changeset.b(paramString.substring(k, k + j));
      this.a += j;
      localObject = this.d;
      j = this.a;
      this.a = (j + 1);
      j = localObject[j];
      if ((j != 60) && (j != 62))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Not a exports: ");
        ((StringBuilder)localObject).append(paramString);
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
      if (62 != j) {
        i = -1;
      }
      j = b();
      if (j > 0)
      {
        k = this.a;
        k = Changeset.b(paramString.substring(k, k + j));
        this.a += j;
        this.c = (this.b + i * k);
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Not a exports: ");
      ((StringBuilder)localObject).append(paramString);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Not a exports: ");
    ((StringBuilder)localObject).append(paramString);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.easysync2.HeaderParser
 * JD-Core Version:    0.7.0.1
 */