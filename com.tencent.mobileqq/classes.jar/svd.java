import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.HongbaoShowerActivity;

public class svd
  implements View.OnClickListener
{
  public svd(HongbaoShowerActivity paramHongbaoShowerActivity) {}
  
  public void onClick(View paramView)
  {
    boolean bool = HongbaoShowerActivity.a(this.a).isChecked();
    paramView = HongbaoShowerActivity.a(this.a);
    if (!bool) {}
    for (bool = true;; bool = false)
    {
      paramView.setChecked(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     svd
 * JD-Core Version:    0.7.0.1
 */