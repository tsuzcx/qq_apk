import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AboutActivity;
import com.tencent.mobileqq.grayversion.ShareAppLogActivity;

public class rfo
  implements View.OnClickListener
{
  public rfo(AboutActivity paramAboutActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.startActivity(ShareAppLogActivity.buildIntent(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rfo
 * JD-Core Version:    0.7.0.1
 */