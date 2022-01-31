import android.os.Handler;
import com.tencent.biz.widgets.ScannerView;

public class pir
  implements Runnable
{
  public pir(ScannerView paramScannerView) {}
  
  public void run()
  {
    if (!ScannerView.b(this.a)) {
      this.a.b.sendEmptyMessage(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pir
 * JD-Core Version:    0.7.0.1
 */