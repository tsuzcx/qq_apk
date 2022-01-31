import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ReadInJoyGlobalReporter;

public class ldg
  implements Runnable
{
  public ldg(ReadInJoyNewFeedsActivity paramReadInJoyNewFeedsActivity) {}
  
  public void run()
  {
    ReadInJoyGlobalReporter.a().b(this.a.app);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ldg
 * JD-Core Version:    0.7.0.1
 */