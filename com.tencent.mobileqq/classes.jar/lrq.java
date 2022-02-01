import java.util.Comparator;

class lrq
  implements Comparator<lrl>
{
  lrq(lro paramlro) {}
  
  public int a(lrl paramlrl1, lrl paramlrl2)
  {
    if (paramlrl1.d() >= paramlrl2.d()) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lrq
 * JD-Core Version:    0.7.0.1
 */