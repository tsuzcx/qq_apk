import java.util.Comparator;

final class sdm
  implements Comparator<sdr>
{
  public int a(sdr paramsdr1, sdr paramsdr2)
  {
    int j = paramsdr1.a - paramsdr2.a;
    int i = j;
    if (j == 0) {
      i = paramsdr1.b - paramsdr2.b;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sdm
 * JD-Core Version:    0.7.0.1
 */