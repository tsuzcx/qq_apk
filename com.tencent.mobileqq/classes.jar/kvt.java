public class kvt
  extends ktz
{
  protected int aa;
  protected long l;
  
  public long b()
  {
    return this.l;
  }
  
  public int c()
  {
    return this.aa;
  }
  
  public void d(int paramInt)
  {
    this.aa = paramInt;
  }
  
  public void d(long paramLong)
  {
    this.l = paramLong;
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
      paramObject = (kvt)paramObject;
    } while (this.l == paramObject.l);
    return false;
  }
  
  public int hashCode()
  {
    return (int)(this.l ^ this.l >>> 32);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     kvt
 * JD-Core Version:    0.7.0.1
 */