import java.util.Comparator;

final class rqu
  implements Comparator<rqz>
{
  public int a(rqz paramrqz1, rqz paramrqz2)
  {
    int j = paramrqz1.a - paramrqz2.a;
    int i = j;
    if (j == 0) {
      i = paramrqz1.b - paramrqz2.b;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rqu
 * JD-Core Version:    0.7.0.1
 */