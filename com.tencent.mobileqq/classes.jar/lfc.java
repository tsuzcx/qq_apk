import com.tencent.qphone.base.util.QLog;

public class lfc
  extends ldh
{
  protected int ah;
  protected long l;
  
  public long b()
  {
    return this.l;
  }
  
  public void d(int paramInt)
  {
    this.ah = paramInt;
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
      paramObject = (lfc)paramObject;
    } while (this.l == paramObject.l);
    return false;
  }
  
  public int f()
  {
    return this.ah;
  }
  
  public int hashCode()
  {
    return (int)(this.l ^ this.l >>> 32);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lfc
 * JD-Core Version:    0.7.0.1
 */