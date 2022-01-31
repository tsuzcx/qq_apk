public abstract class lko
  extends lka
{
  protected long b;
  public lla[] c;
  
  public void a(long paramLong)
  {
    long l = this.jdField_a_of_type_Long;
    if (this.c != null)
    {
      int i = (int)((paramLong - l) % this.b * this.c.length / this.b);
      if ((i >= 0) && (i < this.c.length)) {
        this.jdField_a_of_type_Lla = this.c[i];
      }
    }
  }
  
  public void b()
  {
    super.b();
    if (this.c != null)
    {
      lla[] arrayOflla = this.c;
      int j = arrayOflla.length;
      int i = 0;
      while (i < j)
      {
        lla locallla = arrayOflla[i];
        if (locallla != null) {
          locallla.a();
        }
        i += 1;
      }
      this.c = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lko
 * JD-Core Version:    0.7.0.1
 */