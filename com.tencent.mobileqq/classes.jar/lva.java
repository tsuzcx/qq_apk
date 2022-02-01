public class lva
  extends lur
{
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h;
  
  public lva()
  {
    a(255);
  }
  
  public void a(long paramLong)
  {
    int i = (int)((paramLong - this.a) % 4000L * this.h / 2000L - this.c);
    a(this.g, i, this.g + this.b, this.c + i);
  }
  
  public void b(int paramInt)
  {
    if (this.e != paramInt)
    {
      this.e = paramInt;
      c();
    }
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.b = (paramInt1 * 70 / 160);
    this.c = (paramInt1 * 70 / 160);
    this.d = (paramInt1 * 5 / 160);
    this.f = paramInt1;
    this.h = (this.c + paramInt2);
    c();
  }
  
  public void c()
  {
    if (this.e == 0) {}
    for (int i = this.d;; i = this.f - this.d - this.b)
    {
      this.g = i;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lva
 * JD-Core Version:    0.7.0.1
 */