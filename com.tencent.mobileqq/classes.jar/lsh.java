import java.util.Comparator;

class lsh
  implements Comparator<lsc>
{
  lsh(lsf paramlsf) {}
  
  public int a(lsc paramlsc1, lsc paramlsc2)
  {
    if (paramlsc1.d() >= paramlsc2.d()) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lsh
 * JD-Core Version:    0.7.0.1
 */