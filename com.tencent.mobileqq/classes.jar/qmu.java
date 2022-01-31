public class qmu
  implements Cloneable
{
  public int a = 0;
  public long a;
  public long b;
  
  public qmu a()
  {
    try
    {
      qmu localqmu = (qmu)super.clone();
      return localqmu;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qmu
 * JD-Core Version:    0.7.0.1
 */