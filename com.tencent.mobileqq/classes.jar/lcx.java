import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyBaseViewController;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;

public class lcx
  implements View.OnClickListener
{
  public lcx(ReadInJoyChannelActivity paramReadInJoyChannelActivity) {}
  
  public void onClick(View paramView)
  {
    if (ReadInJoyChannelActivity.a(this.a))
    {
      this.a.a.a(true);
      return;
    }
    this.a.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lcx
 * JD-Core Version:    0.7.0.1
 */