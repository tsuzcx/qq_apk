import java.util.Comparator;

class fk
  implements Comparator<fl>
{
  public int a(fl paramfl1, fl paramfl2)
  {
    if (paramfl1.a != paramfl2.a)
    {
      if (paramfl1.a > paramfl2.a) {
        return 1;
      }
      return -1;
    }
    return paramfl1.b - paramfl2.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     fk
 * JD-Core Version:    0.7.0.1
 */