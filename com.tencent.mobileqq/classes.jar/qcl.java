import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;

public class qcl
  implements Cloneable
{
  public int a;
  public long a;
  public String a;
  public int b;
  
  public qcl(SocializeFeedsInfo paramSocializeFeedsInfo) {}
  
  public qcl a()
  {
    try
    {
      qcl localqcl = (qcl)super.clone();
      return localqcl;
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
 * Qualified Name:     qcl
 * JD-Core Version:    0.7.0.1
 */