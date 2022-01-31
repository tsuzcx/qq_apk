import java.util.Comparator;

class lms
  implements Comparator<lmt>
{
  lms(lmr paramlmr) {}
  
  public int a(lmt paramlmt1, lmt paramlmt2)
  {
    int j = -1;
    int i;
    if (paramlmt1 == paramlmt2) {
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
            } while (paramlmt1 == null);
            if (paramlmt2 == null) {
              return 1;
            }
            if ((!paramlmt1.a()) || (!paramlmt2.a())) {
              break label99;
            }
            if (paramlmt1.d == paramlmt2.d) {
              break;
            }
            i = j;
          } while (paramlmt2.d > paramlmt1.d);
          return 1;
          if (paramlmt1.b == paramlmt2.b) {
            break;
          }
          i = j;
        } while (paramlmt2.b > paramlmt1.b);
        return 1;
        return 0;
        if (paramlmt1.a()) {
          return 1;
        }
        i = j;
      } while (paramlmt2.a());
      if (paramlmt1.b == paramlmt2.b) {
        break;
      }
      i = j;
    } while (paramlmt2.b > paramlmt1.b);
    return 1;
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lms
 * JD-Core Version:    0.7.0.1
 */