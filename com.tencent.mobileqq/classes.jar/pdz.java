import android.os.Handler;
import com.tencent.biz.widgets.ScannerView;

public class pdz
  implements Runnable
{
  public pdz(ScannerView paramScannerView) {}
  
  public void run()
  {
    if (!ScannerView.b(this.a)) {
      this.a.b.sendEmptyMessage(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pdz
 * JD-Core Version:    0.7.0.1
 */