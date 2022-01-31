import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;

public class roo
  implements Runnable
{
  public roo(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    if (this.a.g != null)
    {
      this.a.g.getVisibility();
      this.a.g.setVisibility(8);
    }
    if (BaseChatPie.a(this.a) != null) {
      BaseChatPie.a(this.a).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     roo
 * JD-Core Version:    0.7.0.1
 */