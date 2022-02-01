import com.tencent.qphone.base.util.QLog;

public class rfy
  implements Cloneable
{
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  
  protected Object clone()
  {
    try
    {
      rfy localrfy = (rfy)super.clone();
      return localrfy;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      QLog.e("NewPolymericInfo", 2, "PackTopicExtraInfo item clone failed. exception = " + localCloneNotSupportedException);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rfy
 * JD-Core Version:    0.7.0.1
 */