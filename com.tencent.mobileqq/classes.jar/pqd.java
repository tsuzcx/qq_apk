import android.content.Intent;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySelfFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySelfFragment.9.1;
import com.tencent.mobileqq.app.ThreadManager;

public class pqd
  implements pqe
{
  public pqd(ReadInJoySelfFragment paramReadInJoySelfFragment) {}
  
  public void a()
  {
    ThreadManager.postImmediately(new ReadInJoySelfFragment.9.1(this), null, true);
    Intent localIntent = new Intent(this.a.a.getContext(), ReadInJoySettingActivity.class);
    this.a.startActivity(localIntent);
    ReadInJoySelfFragment.a(this.a, 15);
    bcef.b(null, "CliOper", "", "", "0X800705B", "0X800705B", 0, 0, "", "", "", pay.f());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pqd
 * JD-Core Version:    0.7.0.1
 */