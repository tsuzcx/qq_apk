import java.util.Comparator;

final class svc
  implements Comparator<svh>
{
  public int a(svh paramsvh1, svh paramsvh2)
  {
    int j = paramsvh1.a - paramsvh2.a;
    int i = j;
    if (j == 0) {
      i = paramsvh1.b - paramsvh2.b;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     svc
 * JD-Core Version:    0.7.0.1
 */