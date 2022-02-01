package com.tencent.mobileqq.easysync2;

final class Changeset$4
  implements OpZipProcessor
{
  Changeset$4(StringIterator paramStringIterator1, AttribPool paramAttribPool, StringBuilder paramStringBuilder, StringIterator paramStringIterator2) {}
  
  public void a(Operation paramOperation1, Operation paramOperation2, Operation paramOperation3)
  {
    int i = paramOperation1.a;
    int j = paramOperation2.a;
    if ((i == 43) && (j == 45)) {
      this.a.c(Math.min(paramOperation1.b, paramOperation2.b));
    }
    Changeset.a(paramOperation1, paramOperation2, paramOperation3, this.b);
    if (paramOperation3.a == '+')
    {
      if (j == 43)
      {
        this.c.append(this.d.a(paramOperation3.b));
        return;
      }
      this.c.append(this.a.a(paramOperation3.b));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.easysync2.Changeset.4
 * JD-Core Version:    0.7.0.1
 */