import java.util.Comparator;

final class sdj
  implements Comparator<sdo>
{
  public int a(sdo paramsdo1, sdo paramsdo2)
  {
    int j = paramsdo1.a - paramsdo2.a;
    int i = j;
    if (j == 0) {
      i = paramsdo1.b - paramsdo2.b;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sdj
 * JD-Core Version:    0.7.0.1
 */