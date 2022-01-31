import java.util.Comparator;

final class lku
  implements Comparator<lkt>
{
  public int a(lkt paramlkt1, lkt paramlkt2)
  {
    if (paramlkt1 == paramlkt2) {
      return 0;
    }
    if (paramlkt1 == null) {
      return -1;
    }
    if (paramlkt2 == null) {
      return 1;
    }
    return paramlkt1.a - paramlkt2.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lku
 * JD-Core Version:    0.7.0.1
 */