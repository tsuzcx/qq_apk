import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ReadInJoyGlobalReporter;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

public class lef
  implements Runnable
{
  public lef(ReadInJoyNewFeedsActivity paramReadInJoyNewFeedsActivity) {}
  
  public void run()
  {
    ReadInJoyGlobalReporter.a().a(this.a.app, NetConnInfoCenter.getServerTimeMillis(), ReadInJoyUtils.e(), ReadInJoyUtils.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lef
 * JD-Core Version:    0.7.0.1
 */