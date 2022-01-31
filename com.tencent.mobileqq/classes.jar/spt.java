import java.util.Comparator;

final class spt
  implements Comparator<sqc>
{
  public int a(sqc paramsqc1, sqc paramsqc2)
  {
    if ((paramsqc1 == paramsqc2) || (paramsqc1.b == paramsqc2.b)) {
      return 0;
    }
    if (paramsqc1.b < paramsqc2.b) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     spt
 * JD-Core Version:    0.7.0.1
 */