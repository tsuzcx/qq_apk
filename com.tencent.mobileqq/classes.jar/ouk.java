import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyDailyFragment;

public class ouk
  extends BroadcastReceiver
{
  public ouk(ReadInJoyDailyFragment paramReadInJoyDailyFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (this.a.getActivity() != null)
    {
      if (ReadInJoyDailyFragment.a(this.a) != null) {
        ReadInJoyDailyFragment.a(this.a).i();
      }
      ReadInJoyDailyFragment.a(this.a, true);
      this.a.getActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ouk
 * JD-Core Version:    0.7.0.1
 */