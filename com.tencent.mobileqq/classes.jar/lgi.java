public class lgi
  extends leo
{
  protected int ac;
  protected long l;
  
  public long b()
  {
    return this.l;
  }
  
  public void d(int paramInt)
  {
    this.ac = paramInt;
  }
  
  public void d(long paramLong)
  {
    this.l = paramLong;
  }
  
  public int e()
  {
    return this.ac;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (lgi)paramObject;
    } while (this.l == paramObject.l);
    return false;
  }
  
  public int hashCode()
  {
    return (int)(this.l ^ this.l >>> 32);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lgi
 * JD-Core Version:    0.7.0.1
 */