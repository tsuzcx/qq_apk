package com.tencent.mobileqq.microapp.apkg;

final class o
  implements g.d
{
  o(n paramn) {}
  
  public void onInitApkgInfo(int paramInt, f paramf)
  {
    if (this.a.b.b) {
      return;
    }
    switch (this.a.a.c)
    {
    default: 
      return;
    case 1: 
      if (paramInt != 0) {
        this.a.b.b = true;
      }
      for (;;)
      {
        g.b.a(this.a.b, this.a.a.c);
        return;
        this.a.b.f = paramInt;
      }
    }
    if ((paramInt == 0) && (paramf != null))
    {
      this.a.b.h = paramf;
      this.a.b.g = paramInt;
    }
    for (;;)
    {
      g.b.a(this.a.b, this.a.a.c);
      return;
      this.a.b.b = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.apkg.o
 * JD-Core Version:    0.7.0.1
 */