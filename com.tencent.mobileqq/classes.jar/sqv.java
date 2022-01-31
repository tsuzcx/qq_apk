import java.util.Comparator;

class sqv
  implements Comparator<sqc>
{
  sqv(squ paramsqu) {}
  
  public int a(sqc paramsqc1, sqc paramsqc2)
  {
    if (paramsqc1.b == paramsqc2.b) {
      return 0;
    }
    if (paramsqc1.b > paramsqc2.b) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sqv
 * JD-Core Version:    0.7.0.1
 */