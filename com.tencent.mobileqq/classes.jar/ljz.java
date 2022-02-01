import java.util.Comparator;

final class ljz
  implements Comparator<ljy>
{
  public int a(ljy paramljy1, ljy paramljy2)
  {
    if (paramljy1 == paramljy2) {
      return 0;
    }
    if (paramljy1 == null) {
      return -1;
    }
    if (paramljy2 == null) {
      return 1;
    }
    return paramljy1.a - paramljy2.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ljz
 * JD-Core Version:    0.7.0.1
 */