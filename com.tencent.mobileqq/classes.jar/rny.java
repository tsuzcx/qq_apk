import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.widget.XEditTextEx;

public class rny
  implements View.OnLongClickListener
{
  public rny(BaseChatPie paramBaseChatPie) {}
  
  public boolean onLongClick(View paramView)
  {
    if ("//findcrash".equals(this.a.a.getText().toString())) {
      BaseChatPie.a(this.a);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rny
 * JD-Core Version:    0.7.0.1
 */