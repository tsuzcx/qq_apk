import java.util.Comparator;

class sqw
  implements Comparator<sqb>
{
  sqw(squ paramsqu) {}
  
  public int a(sqb paramsqb1, sqb paramsqb2)
  {
    if (paramsqb1.f() == paramsqb2.f()) {
      return 0;
    }
    if (paramsqb1.f() > paramsqb2.f()) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sqw
 * JD-Core Version:    0.7.0.1
 */