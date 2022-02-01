public abstract class lun
  extends ltz
{
  protected long b;
  public luz[] c;
  
  public void a(long paramLong)
  {
    long l = this.jdField_a_of_type_Long;
    if (this.c != null)
    {
      int i = (int)((paramLong - l) % this.b * this.c.length / this.b);
      if ((i >= 0) && (i < this.c.length)) {
        this.jdField_a_of_type_Luz = this.c[i];
      }
    }
  }
  
  public void b()
  {
    super.b();
    if (this.c != null)
    {
      luz[] arrayOfluz = this.c;
      int j = arrayOfluz.length;
      int i = 0;
      while (i < j)
      {
        luz localluz = arrayOfluz[i];
        if (localluz != null) {
          localluz.a();
        }
        i += 1;
      }
      this.c = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lun
 * JD-Core Version:    0.7.0.1
 */