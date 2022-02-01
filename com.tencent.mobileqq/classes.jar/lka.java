import java.util.Comparator;

class lka
  implements Comparator<lkb>
{
  lka(ljz paramljz) {}
  
  public int a(lkb paramlkb1, lkb paramlkb2)
  {
    int j = -1;
    int i;
    if (paramlkb1 == paramlkb2) {
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
            } while (paramlkb1 == null);
            if (paramlkb2 == null) {
              return 1;
            }
            if ((!paramlkb1.a()) || (!paramlkb2.a())) {
              break label99;
            }
            if (paramlkb1.d == paramlkb2.d) {
              break;
            }
            i = j;
          } while (paramlkb2.d > paramlkb1.d);
          return 1;
          if (paramlkb1.b == paramlkb2.b) {
            break;
          }
          i = j;
        } while (paramlkb2.b > paramlkb1.b);
        return 1;
        return 0;
        i = j;
      } while (paramlkb1.a());
      if (paramlkb2.a()) {
        return 1;
      }
      if (paramlkb1.b == paramlkb2.b) {
        break;
      }
      i = j;
    } while (paramlkb2.b > paramlkb1.b);
    return 1;
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lka
 * JD-Core Version:    0.7.0.1
 */