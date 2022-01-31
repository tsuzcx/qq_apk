import android.content.Context;
import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.random.RandomController;
import com.tencent.av.random.RandomWebProtocol;
import com.tencent.av.utils.PopupDialog;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class jkw
  implements Runnable
{
  public jkw(RandomController paramRandomController) {}
  
  private void a()
  {
    if (!this.a.c)
    {
      Context localContext = RandomController.a(this.a).getApp().getApplicationContext();
      PopupDialog.b(localContext, 230, localContext.getString(2131429318), localContext.getString(2131429317), 0, 2131429050, new jkx(this), null);
      this.a.c = true;
    }
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomController", 2, "mRandomKickTimeoutRunnable trigger, request room owner!");
    }
    RandomController.a(this.a).b();
    a();
    ReportController.b(null, "CliOper", "", "", "0X8007430", "0X8007430", 0, 0, "", "", "", "");
    RandomController.a(this.a).a().removeCallbacks(RandomController.a(this.a));
    RandomController.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jkw
 * JD-Core Version:    0.7.0.1
 */