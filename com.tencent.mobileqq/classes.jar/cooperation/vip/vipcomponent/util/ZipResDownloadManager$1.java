package cooperation.vip.vipcomponent.util;

import biai;
import biak;

public class ZipResDownloadManager$1
  implements Runnable
{
  public ZipResDownloadManager$1(biai parambiai, String paramString) {}
  
  public void run()
  {
    String str = this.a;
    if (this.this$0.a(str)) {}
    biak localbiak;
    do
    {
      return;
      localbiak = biai.a(this.this$0, str, -1, null, null);
    } while (!biai.a(this.this$0, str, localbiak));
    biai.a(this.this$0, localbiak);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.vip.vipcomponent.util.ZipResDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */