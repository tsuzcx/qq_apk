import com.tencent.qphone.base.util.QLog;

public class lig
  extends lgm
{
  protected int af;
  protected long l;
  
  public long b()
  {
    return this.l;
  }
  
  public void d(int paramInt)
  {
    this.af = paramInt;
  }
  
  public void d(long paramLong)
  {
    QLog.i("SessionInfoBase", 1, "setRoomId old room id[" + this.l + "], new room id[" + paramLong + "].");
    this.l = paramLong;
  }
  
  public int e()
  {
    return this.af;
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
      paramObject = (lig)paramObject;
    } while (this.l == paramObject.l);
    return false;
  }
  
  public int hashCode()
  {
    return (int)(this.l ^ this.l >>> 32);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lig
 * JD-Core Version:    0.7.0.1
 */