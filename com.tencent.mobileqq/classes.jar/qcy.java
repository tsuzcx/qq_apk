public class qcy
  implements Cloneable
{
  public int a = 0;
  public long a;
  public long b;
  
  public qcy a()
  {
    try
    {
      qcy localqcy = (qcy)super.clone();
      return localqcy;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qcy
 * JD-Core Version:    0.7.0.1
 */