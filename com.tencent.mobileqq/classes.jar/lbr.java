import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.widget.ActionSheet.OnDismissListener;
import mqq.os.MqqHandler;

public class lbr
  implements ActionSheet.OnDismissListener
{
  public lbr(ReadInJoyBaseDeliverActivity paramReadInJoyBaseDeliverActivity) {}
  
  public void onDismiss()
  {
    if ((!this.a.a) && (this.a.h != -1)) {
      ThreadManager.getUIHandler().postDelayed(new lbs(this), 300L);
    }
    this.a.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lbr
 * JD-Core Version:    0.7.0.1
 */