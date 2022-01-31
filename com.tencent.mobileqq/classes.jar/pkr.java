import java.util.Comparator;

public final class pkr
  implements Comparator
{
  public int a(pkt parampkt1, pkt parampkt2)
  {
    if (parampkt1.b > parampkt2.b) {
      return -1;
    }
    if (parampkt1.b < parampkt2.b) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pkr
 * JD-Core Version:    0.7.0.1
 */