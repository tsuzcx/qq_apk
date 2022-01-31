import java.util.Comparator;

public class sbe
  implements Comparator<saw>
{
  public sbe(sbc paramsbc) {}
  
  public int a(saw paramsaw1, saw paramsaw2)
  {
    long l1 = paramsaw1.a;
    long l2 = paramsaw2.a;
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
 * Qualified Name:     sbe
 * JD-Core Version:    0.7.0.1
 */