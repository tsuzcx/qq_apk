import java.util.Comparator;

final class spq
  implements Comparator<spz>
{
  public int a(spz paramspz1, spz paramspz2)
  {
    if ((paramspz1 == paramspz2) || (paramspz1.b == paramspz2.b)) {
      return 0;
    }
    if (paramspz1.b < paramspz2.b) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     spq
 * JD-Core Version:    0.7.0.1
 */