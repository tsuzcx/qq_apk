import java.util.Comparator;

public final class pkf
  implements Comparator
{
  public int a(pkg parampkg1, pkg parampkg2)
  {
    if (parampkg1.a < parampkg2.a) {
      return -1;
    }
    if (parampkg1.a == parampkg2.a) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pkf
 * JD-Core Version:    0.7.0.1
 */