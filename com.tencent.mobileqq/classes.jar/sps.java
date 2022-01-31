import java.util.Comparator;

final class sps
  implements Comparator<sqb>
{
  public int a(sqb paramsqb1, sqb paramsqb2)
  {
    if (paramsqb1.a() > paramsqb2.a()) {}
    do
    {
      return 1;
      if (paramsqb1.a() < paramsqb2.a()) {
        return -1;
      }
      if (paramsqb1.d() == paramsqb2.d()) {
        return 0;
      }
    } while (paramsqb1.d() < paramsqb2.d());
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sps
 * JD-Core Version:    0.7.0.1
 */