public class pqt
  implements Cloneable
{
  public int a;
  public String a;
  public int b;
  public String b;
  
  public pqt a()
  {
    try
    {
      pqt localpqt = (pqt)super.clone();
      return localpqt;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pqt
 * JD-Core Version:    0.7.0.1
 */