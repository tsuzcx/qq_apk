import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFollowActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFollowActivity.1.1;
import com.tencent.mobileqq.app.ThreadManager;

public class nze
  implements View.OnClickListener
{
  public nze(ReadInJoyFollowActivity paramReadInJoyFollowActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a.a(true);
    ThreadManager.executeOnSubThread(new ReadInJoyFollowActivity.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nze
 * JD-Core Version:    0.7.0.1
 */