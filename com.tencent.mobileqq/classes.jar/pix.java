import java.util.Comparator;

public final class pix
  implements Comparator
{
  public int a(piz parampiz1, piz parampiz2)
  {
    if (parampiz1.b > parampiz2.b) {
      return -1;
    }
    if (parampiz1.b < parampiz2.b) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pix
 * JD-Core Version:    0.7.0.1
 */