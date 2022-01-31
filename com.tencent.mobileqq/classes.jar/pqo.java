import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;

public class pqo
  implements Cloneable
{
  public int a;
  public long a;
  public int b;
  
  public pqo(SocializeFeedsInfo paramSocializeFeedsInfo) {}
  
  public pqo a()
  {
    try
    {
      pqo localpqo = (pqo)super.clone();
      return localpqo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
  
  public boolean a()
  {
    return this.b == 1;
  }
  
  public String toString()
  {
    return "uin=" + this.jdField_a_of_type_Long + "type=" + this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pqo
 * JD-Core Version:    0.7.0.1
 */