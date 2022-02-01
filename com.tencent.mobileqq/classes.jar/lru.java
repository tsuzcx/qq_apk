import java.util.Comparator;

class lru
  implements Comparator<lrp>
{
  lru(lrs paramlrs) {}
  
  public int a(lrp paramlrp1, lrp paramlrp2)
  {
    if (paramlrp1.d() >= paramlrp2.d()) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lru
 * JD-Core Version:    0.7.0.1
 */