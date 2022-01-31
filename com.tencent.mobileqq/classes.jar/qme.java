import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;

public class qme
  implements Cloneable
{
  public int a;
  public long a;
  public String a;
  public int b;
  
  public qme(SocializeFeedsInfo paramSocializeFeedsInfo) {}
  
  public qme a()
  {
    try
    {
      qme localqme = (qme)super.clone();
      return localqme;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qme
 * JD-Core Version:    0.7.0.1
 */