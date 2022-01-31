import android.os.Handler;
import com.tencent.biz.widgets.ScannerView;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class pip
  implements Runnable
{
  public pip(ScannerView paramScannerView) {}
  
  public void run()
  {
    if ((ScannerView.a(this.a)) && (ScannerView.b(this.a)))
    {
      ThreadManager.getUIHandler().post(new piq(this));
      this.a.b.sendEmptyMessage(7);
      return;
    }
    this.a.b.sendEmptyMessage(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pip
 * JD-Core Version:    0.7.0.1
 */