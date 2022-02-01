package com.tencent.mobileqq.easysync2;

final class Changeset$11
  implements OpZipProcessor
{
  Changeset$11(StringIterator paramStringIterator1, StringIterator paramStringIterator2, AttributeTester paramAttributeTester, boolean paramBoolean, AttribPool paramAttribPool, int[] paramArrayOfInt1, int[] paramArrayOfInt2) {}
  
  public void a(Operation paramOperation1, Operation paramOperation2, Operation paramOperation3)
  {
    if ((paramOperation1.a != '+') && (paramOperation2.a != '+'))
    {
      if (paramOperation1.a == '-')
      {
        Changeset.b(paramOperation1, paramOperation2);
      }
      else if (paramOperation2.a == '-')
      {
        Changeset.a(paramOperation1, paramOperation2, paramOperation3);
      }
      else if (paramOperation1.a == 0)
      {
        Changeset.a(paramOperation2, paramOperation3);
        paramOperation2.a = '\000';
      }
      else if (paramOperation2.a == 0)
      {
        paramOperation1.a = '\000';
      }
      else
      {
        Changeset.c(paramOperation1, paramOperation2, paramOperation3, this.e);
      }
    }
    else {
      Changeset.a(paramOperation1, paramOperation2, paramOperation3, this.a, this.b, this.c, this.d);
    }
    int i = paramOperation3.a;
    if (i != 43)
    {
      if (i != 45)
      {
        if (i != 61) {
          return;
        }
        paramOperation1 = this.f;
        paramOperation1[0] += paramOperation3.b;
        paramOperation1 = this.g;
        paramOperation1[0] += paramOperation3.b;
        return;
      }
      paramOperation1 = this.f;
      paramOperation1[0] += paramOperation3.b;
      return;
    }
    paramOperation1 = this.g;
    paramOperation1[0] += paramOperation3.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.easysync2.Changeset.11
 * JD-Core Version:    0.7.0.1
 */