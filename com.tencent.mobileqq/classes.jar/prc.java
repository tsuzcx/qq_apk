public class prc
  implements Cloneable
{
  public int a = 0;
  public long a;
  public long b;
  
  public prc a()
  {
    try
    {
      prc localprc = (prc)super.clone();
      return localprc;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     prc
 * JD-Core Version:    0.7.0.1
 */