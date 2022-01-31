import android.content.res.Resources;
import android.os.Handler;
import com.tencent.av.ui.BaseCallbackUI;
import com.tencent.av.ui.CallbackWaitingActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class jrk
  implements Runnable
{
  public jrk(CallbackWaitingActivity paramCallbackWaitingActivity) {}
  
  public void run()
  {
    this.a.a.a.removeCallbacksAndMessages(null);
    DialogUtil.b(this.a, 230, this.a.getResources().getString(2131429571), this.a.getResources().getString(2131429572), 2131428670, 2131428670, null, new jrl(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jrk
 * JD-Core Version:    0.7.0.1
 */