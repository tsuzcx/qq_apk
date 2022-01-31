import java.util.Comparator;

class hb
  implements Comparator<hc>
{
  public int a(hc paramhc1, hc paramhc2)
  {
    if (paramhc1.a != paramhc2.a)
    {
      if (paramhc1.a > paramhc2.a) {
        return 1;
      }
      return -1;
    }
    return paramhc1.b - paramhc2.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     hb
 * JD-Core Version:    0.7.0.1
 */