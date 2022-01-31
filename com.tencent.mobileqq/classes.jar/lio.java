import com.tencent.biz.pubaccount.readinjoy.ark.ReadInJoyArkViewController;
import com.tencent.mobileqq.ark.ArkAppCenter;

public class lio
  implements Runnable
{
  public lio(ReadInJoyArkViewController paramReadInJoyArkViewController) {}
  
  public void run()
  {
    ArkAppCenter.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lio
 * JD-Core Version:    0.7.0.1
 */