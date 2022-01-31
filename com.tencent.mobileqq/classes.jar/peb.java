import com.tencent.biz.widgets.ScannerView;

public class peb
  implements Runnable
{
  public peb(ScannerView paramScannerView) {}
  
  public void run()
  {
    ScannerView.a(this.a, false);
    ScannerView.a(this.a, ScannerView.a(this.a));
    this.a.a(ScannerView.c(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     peb
 * JD-Core Version:    0.7.0.1
 */