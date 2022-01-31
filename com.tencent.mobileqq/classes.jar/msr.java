import java.util.Comparator;

public final class msr
  implements Comparator
{
  public int a(msv parammsv1, msv parammsv2)
  {
    int j = parammsv1.a - parammsv2.a;
    int i = j;
    if (j == 0) {
      i = parammsv1.b - parammsv2.b;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     msr
 * JD-Core Version:    0.7.0.1
 */