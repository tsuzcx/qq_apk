import java.util.Comparator;

class fp
  implements Comparator<fq>
{
  public int a(fq paramfq1, fq paramfq2)
  {
    if (paramfq1.a != paramfq2.a)
    {
      if (paramfq1.a > paramfq2.a) {
        return 1;
      }
      return -1;
    }
    return paramfq1.b - paramfq2.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     fp
 * JD-Core Version:    0.7.0.1
 */