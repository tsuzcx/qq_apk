import java.util.Comparator;

public class sbb
  implements Comparator<sat>
{
  public sbb(saz paramsaz) {}
  
  public int a(sat paramsat1, sat paramsat2)
  {
    long l1 = paramsat1.a;
    long l2 = paramsat2.a;
    if (l2 > l1) {
      return 1;
    }
    if (l2 < l1) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sbb
 * JD-Core Version:    0.7.0.1
 */