import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverVideoActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class lyp
  implements Runnable
{
  public lyp(ReadInJoyDeliverVideoActivity paramReadInJoyDeliverVideoActivity) {}
  
  public void run()
  {
    if (ReadInJoyDeliverVideoActivity.b(this.a)) {
      return;
    }
    DialogUtil.a(this.a, 233, "提示", this.a.getString(2131438922), new lyq(this), null).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lyp
 * JD-Core Version:    0.7.0.1
 */