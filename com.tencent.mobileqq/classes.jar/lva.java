public abstract class lva
  extends lum
{
  protected long b;
  public lvm[] c;
  
  public void a(long paramLong)
  {
    long l = this.jdField_a_of_type_Long;
    if (this.c != null)
    {
      int i = (int)((paramLong - l) % this.b * this.c.length / this.b);
      if ((i >= 0) && (i < this.c.length)) {
        this.jdField_a_of_type_Lvm = this.c[i];
      }
    }
  }
  
  public void b()
  {
    super.b();
    if (this.c != null)
    {
      lvm[] arrayOflvm = this.c;
      int j = arrayOflvm.length;
      int i = 0;
      while (i < j)
      {
        lvm locallvm = arrayOflvm[i];
        if (locallvm != null) {
          locallvm.a();
        }
        i += 1;
      }
      this.c = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     lva
 * JD-Core Version:    0.7.0.1
 */