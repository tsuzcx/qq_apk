import java.util.Comparator;

final class lmx
  implements Comparator<lmw>
{
  public int a(lmw paramlmw1, lmw paramlmw2)
  {
    if (paramlmw1 == paramlmw2) {
      return 0;
    }
    if (paramlmw1 == null) {
      return -1;
    }
    if (paramlmw2 == null) {
      return 1;
    }
    return paramlmw1.a - paramlmw2.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lmx
 * JD-Core Version:    0.7.0.1
 */