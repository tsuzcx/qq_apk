import java.util.Comparator;

class lkp
  implements Comparator<lkq>
{
  lkp(lko paramlko) {}
  
  public int a(lkq paramlkq1, lkq paramlkq2)
  {
    int j = -1;
    int i;
    if (paramlkq1 == paramlkq2) {
      i = 0;
    }
    label99:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return i;
              i = j;
            } while (paramlkq1 == null);
            if (paramlkq2 == null) {
              return 1;
            }
            if ((!paramlkq1.a()) || (!paramlkq2.a())) {
              break label99;
            }
            if (paramlkq1.d == paramlkq2.d) {
              break;
            }
            i = j;
          } while (paramlkq2.d > paramlkq1.d);
          return 1;
          if (paramlkq1.b == paramlkq2.b) {
            break;
          }
          i = j;
        } while (paramlkq2.b > paramlkq1.b);
        return 1;
        return 0;
        if (paramlkq1.a()) {
          return 1;
        }
        i = j;
      } while (paramlkq2.a());
      if (paramlkq1.b == paramlkq2.b) {
        break;
      }
      i = j;
    } while (paramlkq2.b > paramlkq1.b);
    return 1;
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lkp
 * JD-Core Version:    0.7.0.1
 */