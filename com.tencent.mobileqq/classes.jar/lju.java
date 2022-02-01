import java.util.Comparator;

class lju
  implements Comparator<ljv>
{
  lju(ljt paramljt) {}
  
  public int a(ljv paramljv1, ljv paramljv2)
  {
    int j = -1;
    int i;
    if (paramljv1 == paramljv2) {
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
            } while (paramljv1 == null);
            if (paramljv2 == null) {
              return 1;
            }
            if ((!paramljv1.a()) || (!paramljv2.a())) {
              break label99;
            }
            if (paramljv1.d == paramljv2.d) {
              break;
            }
            i = j;
          } while (paramljv2.d > paramljv1.d);
          return 1;
          if (paramljv1.b == paramljv2.b) {
            break;
          }
          i = j;
        } while (paramljv2.b > paramljv1.b);
        return 1;
        return 0;
        i = j;
      } while (paramljv1.a());
      if (paramljv2.a()) {
        return 1;
      }
      if (paramljv1.b == paramljv2.b) {
        break;
      }
      i = j;
    } while (paramljv2.b > paramljv1.b);
    return 1;
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lju
 * JD-Core Version:    0.7.0.1
 */