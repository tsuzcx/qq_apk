public class qcq
  implements Cloneable
{
  public int a;
  public String a;
  public int b;
  public String b;
  
  public qcq a()
  {
    try
    {
      qcq localqcq = (qcq)super.clone();
      return localqcq;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qcq
 * JD-Core Version:    0.7.0.1
 */