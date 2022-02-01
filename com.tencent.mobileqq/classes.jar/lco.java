import com.tencent.av.VideoController;
import java.util.Comparator;

public class lco
  implements Comparator<lcu>
{
  public lco(VideoController paramVideoController) {}
  
  public int a(lcu paramlcu1, lcu paramlcu2)
  {
    return (int)(paramlcu1.d - paramlcu2.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lco
 * JD-Core Version:    0.7.0.1
 */