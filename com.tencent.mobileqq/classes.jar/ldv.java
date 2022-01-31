import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ReadInJoyGlobalReporter;

public class ldv
  implements Runnable
{
  public ldv(ReadInJoyNewFeedsActivity paramReadInJoyNewFeedsActivity) {}
  
  public void run()
  {
    ReadInJoyGlobalReporter.a().b(this.a.app);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ldv
 * JD-Core Version:    0.7.0.1
 */