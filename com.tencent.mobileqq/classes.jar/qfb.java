import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverVideoActivity;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverVideoActivity.3;

public class qfb
  implements DialogInterface.OnClickListener
{
  public qfb(ReadInJoyDeliverVideoActivity.3 param3) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    aqfb.a(this.a.this$0, true, "shareToQQ", ReadInJoyDeliverVideoActivity.a(this.a.this$0));
    this.a.this$0.moveTaskToBack(true);
    this.a.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qfb
 * JD-Core Version:    0.7.0.1
 */