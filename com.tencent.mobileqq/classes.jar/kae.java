import android.os.Handler;
import com.tencent.av.ui.QavVideoRecordUICtrl;
import com.tencent.av.ui.funchat.record.FileSwapHelper;

public class kae
  implements Runnable
{
  public kae(QavVideoRecordUICtrl paramQavVideoRecordUICtrl) {}
  
  public void run()
  {
    QavVideoRecordUICtrl.a(this.a, this.a.a());
    QavVideoRecordUICtrl.b(this.a, FileSwapHelper.a());
    if (QavVideoRecordUICtrl.a(this.a) < 31457280L) {
      QavVideoRecordUICtrl.a(this.a).post(new kaf(this));
    }
    while (!QavVideoRecordUICtrl.b) {
      return;
    }
    QavVideoRecordUICtrl.a(this.a).sendEmptyMessageDelayed(11, 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kae
 * JD-Core Version:    0.7.0.1
 */