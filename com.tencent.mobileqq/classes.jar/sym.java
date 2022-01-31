import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.LebaEnabledPluginsActivity;
import com.tencent.mobileqq.activity.LebaListMgrActivity;

public class sym
  implements View.OnClickListener
{
  public sym(LebaListMgrActivity paramLebaListMgrActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, LebaEnabledPluginsActivity.class);
    this.a.startActivityForResult(paramView, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sym
 * JD-Core Version:    0.7.0.1
 */