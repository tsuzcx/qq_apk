import java.util.Comparator;

public final class mxs
  implements Comparator
{
  public int a(mxw parammxw1, mxw parammxw2)
  {
    int j = parammxw1.a - parammxw2.a;
    int i = j;
    if (j == 0) {
      i = parammxw1.b - parammxw2.b;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mxs
 * JD-Core Version:    0.7.0.1
 */