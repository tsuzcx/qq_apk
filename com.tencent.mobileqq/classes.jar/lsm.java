import java.util.Comparator;

class lsm
  implements Comparator<lsh>
{
  lsm(lsk paramlsk) {}
  
  public int a(lsh paramlsh1, lsh paramlsh2)
  {
    if (paramlsh1.d() >= paramlsh2.d()) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lsm
 * JD-Core Version:    0.7.0.1
 */