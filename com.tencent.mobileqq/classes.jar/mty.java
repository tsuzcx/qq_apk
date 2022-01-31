import java.util.Comparator;

public final class mty
  implements Comparator
{
  public int a(muc parammuc1, muc parammuc2)
  {
    int j = parammuc1.a - parammuc2.a;
    int i = j;
    if (j == 0) {
      i = parammuc1.b - parammuc2.b;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mty
 * JD-Core Version:    0.7.0.1
 */