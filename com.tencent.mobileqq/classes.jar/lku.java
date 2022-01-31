import java.util.Comparator;

class lku
  implements Comparator<lkv>
{
  lku(lkt paramlkt) {}
  
  public int a(lkv paramlkv1, lkv paramlkv2)
  {
    int j = -1;
    int i;
    if (paramlkv1 == paramlkv2) {
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
            } while (paramlkv1 == null);
            if (paramlkv2 == null) {
              return 1;
            }
            if ((!paramlkv1.a()) || (!paramlkv2.a())) {
              break label99;
            }
            if (paramlkv1.d == paramlkv2.d) {
              break;
            }
            i = j;
          } while (paramlkv2.d > paramlkv1.d);
          return 1;
          if (paramlkv1.b == paramlkv2.b) {
            break;
          }
          i = j;
        } while (paramlkv2.b > paramlkv1.b);
        return 1;
        return 0;
        if (paramlkv1.a()) {
          return 1;
        }
        i = j;
      } while (paramlkv2.a());
      if (paramlkv1.b == paramlkv2.b) {
        break;
      }
      i = j;
    } while (paramlkv2.b > paramlkv1.b);
    return 1;
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lku
 * JD-Core Version:    0.7.0.1
 */