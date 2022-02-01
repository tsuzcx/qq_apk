package com.tencent.qapmsdk.socket.a;

import com.tencent.qapmsdk.socket.c.a;
import java.io.ByteArrayOutputStream;

class j$i
{
  j.g a;
  j.a b;
  
  j$i(boolean paramBoolean, a parama)
  {
    this.a = new j.g(paramBoolean, parama);
    this.b = new j.a(paramBoolean, parama);
  }
  
  int a()
  {
    return this.a.j.size() + this.b.c;
  }
  
  void b()
  {
    this.a.j.reset();
    this.b.j.reset();
  }
  
  byte[] c()
  {
    byte[] arrayOfByte1 = this.a.a();
    byte[] arrayOfByte2 = this.b.a();
    byte[] arrayOfByte3 = new byte[arrayOfByte1.length + arrayOfByte2.length];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte3, 0, arrayOfByte1.length);
    System.arraycopy(arrayOfByte2, 0, arrayOfByte3, arrayOfByte1.length, arrayOfByte2.length);
    return arrayOfByte3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.a.j.i
 * JD-Core Version:    0.7.0.1
 */