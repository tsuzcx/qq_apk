abstract class qkk
{
  protected long a;
  protected long b;
  
  abstract long a(long paramLong);
  
  public void a()
  {
    this.b = 0L;
  }
  
  public void a(long paramLong)
  {
    this.b = a(paramLong);
    if (this.b < 0L) {
      this.b = 0L;
    }
    if ((float)Math.abs(this.b - this.a) / (float)this.a < 0.2F)
    {
      this.a = Math.max(this.b, this.a);
      return;
    }
    this.a = this.b;
  }
  
  public void b()
  {
    this.a = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qkk
 * JD-Core Version:    0.7.0.1
 */