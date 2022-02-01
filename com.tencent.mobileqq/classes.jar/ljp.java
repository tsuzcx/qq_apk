import java.util.Comparator;

class ljp
  implements Comparator<ljq>
{
  ljp(ljo paramljo) {}
  
  public int a(ljq paramljq1, ljq paramljq2)
  {
    int j = -1;
    int i;
    if (paramljq1 == paramljq2) {
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
            } while (paramljq1 == null);
            if (paramljq2 == null) {
              return 1;
            }
            if ((!paramljq1.a()) || (!paramljq2.a())) {
              break label99;
            }
            if (paramljq1.d == paramljq2.d) {
              break;
            }
            i = j;
          } while (paramljq2.d > paramljq1.d);
          return 1;
          if (paramljq1.b == paramljq2.b) {
            break;
          }
          i = j;
        } while (paramljq2.b > paramljq1.b);
        return 1;
        return 0;
        if (paramljq1.a()) {
          return 1;
        }
        i = j;
      } while (paramljq2.a());
      if (paramljq1.b == paramljq2.b) {
        break;
      }
      i = j;
    } while (paramljq2.b > paramljq1.b);
    return 1;
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ljp
 * JD-Core Version:    0.7.0.1
 */