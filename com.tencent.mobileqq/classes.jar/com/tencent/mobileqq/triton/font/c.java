package com.tencent.mobileqq.triton.font;

public class c
{
  private final byte[] a = new byte[4];
  private long b;
  private long c;
  
  c() {}
  
  public c(long paramLong1, long paramLong2)
  {
    this.b = paramLong1;
    this.c = paramLong2;
  }
  
  public long a()
  {
    return this.b;
  }
  
  public String a(a parama)
  {
    this.a[0] = parama.b();
    this.a[1] = parama.b();
    this.a[2] = parama.b();
    this.a[3] = parama.b();
    parama.b(4L);
    this.b = parama.e();
    this.c = parama.e();
    return new String(this.a, "ISO-8859-1");
  }
  
  public String toString()
  {
    return "Read dir tab [" + this.a[0] + " " + this.a[1] + " " + this.a[2] + " " + this.a[3] + "] offset: " + this.b + " bytesToUpload: " + this.c + " name: " + this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.font.c
 * JD-Core Version:    0.7.0.1
 */