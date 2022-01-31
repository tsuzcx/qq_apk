import java.util.Comparator;

public class tfk
  implements Comparator<tfi>
{
  public int a(tfi paramtfi1, tfi paramtfi2)
  {
    if (paramtfi1.c < paramtfi2.c) {
      return 1;
    }
    if (paramtfi1.c > paramtfi2.c) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tfk
 * JD-Core Version:    0.7.0.1
 */