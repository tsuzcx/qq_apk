import android.content.res.Resources;
import android.os.Handler;
import com.tencent.av.ui.BaseCallbackUI;
import com.tencent.av.ui.CallbackWaitingActivityExt;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class jru
  implements Runnable
{
  jru(jrt paramjrt) {}
  
  public void run()
  {
    this.a.a.a.a.removeCallbacksAndMessages(null);
    DialogUtil.b(this.a.a, 230, this.a.a.getResources().getString(2131429571), this.a.a.getResources().getString(2131429572), 2131428670, 2131428670, null, new jrv(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jru
 * JD-Core Version:    0.7.0.1
 */