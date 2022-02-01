import com.tencent.qphone.base.util.QLog;

public class qwr
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
      qwr localqwr = (qwr)super.clone();
      return localqwr;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      QLog.e("NewPolymericInfo", 2, "PackTopicExtraInfo item clone failed. exception = " + localCloneNotSupportedException);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qwr
 * JD-Core Version:    0.7.0.1
 */