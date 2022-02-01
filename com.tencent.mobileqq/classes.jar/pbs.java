import com.tencent.biz.pubaccount.readinjoy.config.AladdinListener;
import java.util.ArrayList;

public class pbs
{
  public static ArrayList<AladdinListener> a = new ArrayList();
  
  public static void a(AladdinListener paramAladdinListener)
  {
    a.add(paramAladdinListener);
  }
  
  public static void b(AladdinListener paramAladdinListener)
  {
    a.remove(paramAladdinListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pbs
 * JD-Core Version:    0.7.0.1
 */