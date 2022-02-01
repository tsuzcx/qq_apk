import com.tencent.qphone.base.util.QLog;

public class lfi
  extends ldn
{
  protected int ag;
  protected long l;
  
  public long b()
  {
    return this.l;
  }
  
  public void d(int paramInt)
  {
    this.ag = paramInt;
  }
  
  public void d(long paramLong)
  {
    QLog.i("SessionInfoBase", 1, "setRoomId old room id[" + this.l + "], new room id[" + paramLong + "].");
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
      paramObject = (lfi)paramObject;
    } while (this.l == paramObject.l);
    return false;
  }
  
  public int f()
  {
    return this.ag;
  }
  
  public int hashCode()
  {
    return (int)(this.l ^ this.l >>> 32);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lfi
 * JD-Core Version:    0.7.0.1
 */