import com.tencent.av.VideoController;
import java.util.Comparator;

public class lcq
  implements Comparator<lcv>
{
  public lcq(VideoController paramVideoController) {}
  
  public int a(lcv paramlcv1, lcv paramlcv2)
  {
    return (int)(paramlcv1.d - paramlcv2.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lcq
 * JD-Core Version:    0.7.0.1
 */