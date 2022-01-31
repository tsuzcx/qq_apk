import java.util.Comparator;

class fi
  implements Comparator<fj>
{
  public int a(fj paramfj1, fj paramfj2)
  {
    if (paramfj1.a != paramfj2.a)
    {
      if (paramfj1.a > paramfj2.a) {
        return 1;
      }
      return -1;
    }
    return paramfj1.b - paramfj2.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     fi
 * JD-Core Version:    0.7.0.1
 */