import java.util.Comparator;

class lhv
  implements Comparator<lhq>
{
  lhv(lht paramlht) {}
  
  public int a(lhq paramlhq1, lhq paramlhq2)
  {
    if (paramlhq1.d() >= paramlhq2.d()) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lhv
 * JD-Core Version:    0.7.0.1
 */