package cooperation.vip.vipcomponent.util;

import bnxe;
import bnxg;

public class ZipResDownloadManager$1
  implements Runnable
{
  public ZipResDownloadManager$1(bnxe parambnxe, String paramString) {}
  
  public void run()
  {
    String str = this.a;
    if (this.this$0.a(str)) {}
    bnxg localbnxg;
    do
    {
      return;
      localbnxg = bnxe.a(this.this$0, str, -1, null, null);
    } while (!bnxe.a(this.this$0, str, localbnxg));
    bnxe.a(this.this$0, localbnxg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.vipcomponent.util.ZipResDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */