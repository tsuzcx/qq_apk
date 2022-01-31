import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFollowActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFollowActivity.1.1;
import com.tencent.mobileqq.app.ThreadManager;

public class nwd
  implements View.OnClickListener
{
  public nwd(ReadInJoyFollowActivity paramReadInJoyFollowActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a.a(true);
    ThreadManager.executeOnSubThread(new ReadInJoyFollowActivity.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nwd
 * JD-Core Version:    0.7.0.1
 */