public class qdb
  implements Cloneable
{
  public int a = 0;
  public long a;
  public long b;
  
  public qdb a()
  {
    try
    {
      qdb localqdb = (qdb)super.clone();
      return localqdb;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qdb
 * JD-Core Version:    0.7.0.1
 */