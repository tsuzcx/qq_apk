import com.tencent.av.VideoController;
import java.util.Comparator;

public class lci
  implements Comparator<lco>
{
  public lci(VideoController paramVideoController) {}
  
  public int a(lco paramlco1, lco paramlco2)
  {
    return (int)(paramlco1.d - paramlco2.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lci
 * JD-Core Version:    0.7.0.1
 */