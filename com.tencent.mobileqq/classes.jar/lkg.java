import java.util.Comparator;

class lkg
  implements Comparator<lkh>
{
  lkg(lkf paramlkf) {}
  
  public int a(lkh paramlkh1, lkh paramlkh2)
  {
    int j = -1;
    int i;
    if (paramlkh1 == paramlkh2) {
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
            } while (paramlkh1 == null);
            if (paramlkh2 == null) {
              return 1;
            }
            if ((!paramlkh1.a()) || (!paramlkh2.a())) {
              break label99;
            }
            if (paramlkh1.d == paramlkh2.d) {
              break;
            }
            i = j;
          } while (paramlkh2.d > paramlkh1.d);
          return 1;
          if (paramlkh1.b == paramlkh2.b) {
            break;
          }
          i = j;
        } while (paramlkh2.b > paramlkh1.b);
        return 1;
        return 0;
        i = j;
      } while (paramlkh1.a());
      if (paramlkh2.a()) {
        return 1;
      }
      if (paramlkh1.b == paramlkh2.b) {
        break;
      }
      i = j;
    } while (paramlkh2.b > paramlkh1.b);
    return 1;
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lkg
 * JD-Core Version:    0.7.0.1
 */