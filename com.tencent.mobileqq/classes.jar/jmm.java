import android.content.res.Resources;
import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.random.RandomController;
import com.tencent.av.utils.PopupDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class jmm
  implements Runnable
{
  public jmm(RandomController paramRandomController) {}
  
  public void run()
  {
    RandomController.a(this.a).a().removeCallbacks(RandomController.d(this.a));
    if (!RandomController.a(this.a).a()) {
      PopupDialog.a(RandomController.a(this.a).getApp().getApplicationContext(), RandomController.a(this.a).getApp().getResources().getString(2131429371), RandomController.a(this.a, RandomController.d(this.a)));
    }
    do
    {
      while (RandomController.d(this.a) > 60)
      {
        RandomController.a(this.a).a().postDelayed(RandomController.d(this.a), 60000L);
        RandomController.a(this.a, RandomController.d(this.a) - 60);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("RandomController", 2, "background mRemainBlockTime : " + RandomController.d(this.a));
        }
      }
      if ((RandomController.d(this.a) <= 60) && (RandomController.d(this.a) > 0))
      {
        RandomController.a(this.a).a().postDelayed(RandomController.d(this.a), 10000L);
        RandomController.a(this.a, RandomController.d(this.a) - 10);
        return;
      }
    } while (RandomController.d(this.a) > 0);
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jmm
 * JD-Core Version:    0.7.0.1
 */