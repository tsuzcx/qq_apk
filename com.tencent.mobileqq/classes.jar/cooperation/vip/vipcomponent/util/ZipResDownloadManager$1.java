package cooperation.vip.vipcomponent.util;

import bgrj;
import bgrl;

public class ZipResDownloadManager$1
  implements Runnable
{
  public ZipResDownloadManager$1(bgrj parambgrj, String paramString) {}
  
  public void run()
  {
    String str = this.a;
    if (this.this$0.a(str)) {}
    bgrl localbgrl;
    do
    {
      return;
      localbgrl = bgrj.a(this.this$0, str, -1, null, null);
    } while (!bgrj.a(this.this$0, str, localbgrl));
    bgrj.a(this.this$0, localbgrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.vip.vipcomponent.util.ZipResDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */