public class qcn
  implements Cloneable
{
  public int a;
  public String a;
  public int b;
  public String b;
  
  public qcn a()
  {
    try
    {
      qcn localqcn = (qcn)super.clone();
      return localqcn;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qcn
 * JD-Core Version:    0.7.0.1
 */