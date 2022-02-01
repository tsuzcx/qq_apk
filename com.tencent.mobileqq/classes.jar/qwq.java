import com.tencent.qphone.base.util.QLog;

public class qwq
  implements Cloneable
{
  public String a;
  public String b;
  
  protected Object clone()
  {
    try
    {
      qwq localqwq = (qwq)super.clone();
      return localqwq;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      QLog.e("NewPolymericInfo", 2, "PackTopicExtraInfo item clone failed. exception = " + localCloneNotSupportedException);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qwq
 * JD-Core Version:    0.7.0.1
 */