import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewController;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFollowActivity;
import com.tencent.mobileqq.app.ThreadManager;

public class lfj
  implements View.OnClickListener
{
  public lfj(ReadInJoyFollowActivity paramReadInJoyFollowActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a.a(true);
    ThreadManager.executeOnSubThread(new lfk(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lfj
 * JD-Core Version:    0.7.0.1
 */