import com.tencent.biz.pubaccount.readinjoy.ark.ReadInJoyArkViewController;
import com.tencent.mobileqq.ark.ArkAppCenter;

public class lga
  implements Runnable
{
  public lga(ReadInJoyArkViewController paramReadInJoyArkViewController) {}
  
  public void run()
  {
    ArkAppCenter.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lga
 * JD-Core Version:    0.7.0.1
 */