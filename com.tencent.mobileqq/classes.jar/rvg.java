import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;

public class rvg
  implements Runnable
{
  public rvg(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    this.a.d.setText(this.a.a.d);
    if (AppSetting.b)
    {
      String str = this.a.d.getText().toString();
      this.a.d.setContentDescription(str);
      this.a.a().setTitle(this.a.d.getText());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rvg
 * JD-Core Version:    0.7.0.1
 */