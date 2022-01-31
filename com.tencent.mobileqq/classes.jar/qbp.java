import com.tencent.qphone.base.util.QLog;

public class qbp
  implements Cloneable
{
  public String a;
  public String b;
  
  protected Object clone()
  {
    try
    {
      qbp localqbp = (qbp)super.clone();
      return localqbp;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      QLog.e("NewPolymericInfo", 2, "PackTopicExtraInfo item clone failed. exception = " + localCloneNotSupportedException);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qbp
 * JD-Core Version:    0.7.0.1
 */