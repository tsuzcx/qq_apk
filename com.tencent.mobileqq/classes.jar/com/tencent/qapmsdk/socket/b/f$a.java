package com.tencent.qapmsdk.socket.b;

final class f$a
{
  final a[] a;
  final int b;
  final int c;
  
  f$a()
  {
    this.a = new a[256];
    this.b = 0;
    this.c = 0;
  }
  
  f$a(int paramInt1, int paramInt2)
  {
    this.a = null;
    this.b = paramInt1;
    paramInt2 &= 0x7;
    paramInt1 = paramInt2;
    if (paramInt2 == 0) {
      paramInt1 = 8;
    }
    this.c = paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.b.f.a
 * JD-Core Version:    0.7.0.1
 */