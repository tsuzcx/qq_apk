import java.util.Comparator;

final class lju
  implements Comparator<ljt>
{
  public int a(ljt paramljt1, ljt paramljt2)
  {
    if (paramljt1 == paramljt2) {
      return 0;
    }
    if (paramljt1 == null) {
      return -1;
    }
    if (paramljt2 == null) {
      return 1;
    }
    return paramljt1.a - paramljt2.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lju
 * JD-Core Version:    0.7.0.1
 */