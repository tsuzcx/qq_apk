import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverVideoActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class lxy
  implements Runnable
{
  public lxy(ReadInJoyDeliverVideoActivity paramReadInJoyDeliverVideoActivity) {}
  
  public void run()
  {
    if (ReadInJoyDeliverVideoActivity.a(this.a)) {
      return;
    }
    DialogUtil.a(this.a, 233, "提示", this.a.getString(2131438894), new lxz(this), null).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lxy
 * JD-Core Version:    0.7.0.1
 */