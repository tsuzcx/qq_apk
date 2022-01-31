import java.util.Comparator;

final class lkz
  implements Comparator<lky>
{
  public int a(lky paramlky1, lky paramlky2)
  {
    if (paramlky1 == paramlky2) {
      return 0;
    }
    if (paramlky1 == null) {
      return -1;
    }
    if (paramlky2 == null) {
      return 1;
    }
    return paramlky1.a - paramlky2.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lkz
 * JD-Core Version:    0.7.0.1
 */