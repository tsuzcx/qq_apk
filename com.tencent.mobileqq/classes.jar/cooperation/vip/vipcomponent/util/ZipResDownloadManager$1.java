package cooperation.vip.vipcomponent.util;

import bmpb;
import bmpd;

public class ZipResDownloadManager$1
  implements Runnable
{
  public ZipResDownloadManager$1(bmpb parambmpb, String paramString) {}
  
  public void run()
  {
    String str = this.a;
    if (this.this$0.a(str)) {}
    bmpd localbmpd;
    do
    {
      return;
      localbmpd = bmpb.a(this.this$0, str, -1, null, null);
    } while (!bmpb.a(this.this$0, str, localbmpd));
    bmpb.a(this.this$0, localbmpd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.vipcomponent.util.ZipResDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */