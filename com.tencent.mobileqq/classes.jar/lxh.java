public abstract class lxh
  extends lwt
{
  protected long b;
  public lxt[] c;
  
  public void a(long paramLong)
  {
    long l = this.jdField_a_of_type_Long;
    if (this.c != null)
    {
      int i = (int)((paramLong - l) % this.b * this.c.length / this.b);
      if ((i >= 0) && (i < this.c.length)) {
        this.jdField_a_of_type_Lxt = this.c[i];
      }
    }
  }
  
  public void b()
  {
    super.b();
    if (this.c != null)
    {
      lxt[] arrayOflxt = this.c;
      int j = arrayOflxt.length;
      int i = 0;
      while (i < j)
      {
        lxt locallxt = arrayOflxt[i];
        if (locallxt != null) {
          locallxt.a();
        }
        i += 1;
      }
      this.c = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lxh
 * JD-Core Version:    0.7.0.1
 */