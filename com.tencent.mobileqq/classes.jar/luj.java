public abstract class luj
  extends ltv
{
  protected long b;
  public luv[] c;
  
  public void a(long paramLong)
  {
    long l = this.jdField_a_of_type_Long;
    if (this.c != null)
    {
      int i = (int)((paramLong - l) % this.b * this.c.length / this.b);
      if ((i >= 0) && (i < this.c.length)) {
        this.jdField_a_of_type_Luv = this.c[i];
      }
    }
  }
  
  public void b()
  {
    super.b();
    if (this.c != null)
    {
      luv[] arrayOfluv = this.c;
      int j = arrayOfluv.length;
      int i = 0;
      while (i < j)
      {
        luv localluv = arrayOfluv[i];
        if (localluv != null) {
          localluv.a();
        }
        i += 1;
      }
      this.c = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     luj
 * JD-Core Version:    0.7.0.1
 */