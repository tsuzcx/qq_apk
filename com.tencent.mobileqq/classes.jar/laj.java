import java.util.Comparator;

final class laj
  implements Comparator<lai>
{
  public int a(lai paramlai1, lai paramlai2)
  {
    if (paramlai1 == paramlai2) {
      return 0;
    }
    if (paramlai1 == null) {
      return -1;
    }
    if (paramlai2 == null) {
      return 1;
    }
    return paramlai1.a - paramlai2.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     laj
 * JD-Core Version:    0.7.0.1
 */