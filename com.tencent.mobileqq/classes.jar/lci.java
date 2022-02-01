import com.tencent.av.VideoController;
import java.util.Comparator;

public class lci
  implements Comparator<lcp>
{
  public lci(VideoController paramVideoController) {}
  
  public int a(lcp paramlcp1, lcp paramlcp2)
  {
    return (int)(paramlcp1.d - paramlcp2.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lci
 * JD-Core Version:    0.7.0.1
 */