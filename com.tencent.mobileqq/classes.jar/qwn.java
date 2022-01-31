class qwn
  extends qwp
{
  private final float a;
  
  public qwn(float paramFloat)
  {
    this.a = paramFloat;
  }
  
  public long a(long paramLong)
  {
    long l = paramLong;
    if (this.b > 0L) {
      l = (this.a * (float)paramLong + (1.0F - this.a) * (float)this.b);
    }
    return l;
  }
  
  public String toString()
  {
    return "ExponentialPredictor(" + this.a + ')';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qwn
 * JD-Core Version:    0.7.0.1
 */