import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.widget.XEditTextEx;

public class rvo
  implements View.OnLongClickListener
{
  public rvo(BaseChatPie paramBaseChatPie) {}
  
  public boolean onLongClick(View paramView)
  {
    if ("//findcrash".equals(this.a.a.getText().toString())) {
      BaseChatPie.a(this.a);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rvo
 * JD-Core Version:    0.7.0.1
 */