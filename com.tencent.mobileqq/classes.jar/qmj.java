public class qmj
  implements Cloneable
{
  public int a;
  public String a;
  public int b;
  public String b;
  
  public qmj a()
  {
    try
    {
      qmj localqmj = (qmj)super.clone();
      return localqmj;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qmj
 * JD-Core Version:    0.7.0.1
 */