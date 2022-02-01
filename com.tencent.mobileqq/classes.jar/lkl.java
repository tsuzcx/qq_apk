import java.util.Comparator;

final class lkl
  implements Comparator<lkk>
{
  public int a(lkk paramlkk1, lkk paramlkk2)
  {
    if (paramlkk1 == paramlkk2) {
      return 0;
    }
    if (paramlkk1 == null) {
      return -1;
    }
    if (paramlkk2 == null) {
      return 1;
    }
    return paramlkk1.a - paramlkk2.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lkl
 * JD-Core Version:    0.7.0.1
 */