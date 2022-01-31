import android.content.res.Resources;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.QavVideoRecordUICtrl;

public class jzs
  implements Runnable
{
  public jzs(QavVideoRecordUICtrl paramQavVideoRecordUICtrl) {}
  
  public void run()
  {
    QavVideoRecordUICtrl.a(this.a, 1004, QavVideoRecordUICtrl.a(this.a).getResources().getString(2131429644), 2000L, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jzs
 * JD-Core Version:    0.7.0.1
 */