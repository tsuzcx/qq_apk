package cooperation.vip.vipcomponent.util;

class ZipResDownloadManager$1
  implements Runnable
{
  ZipResDownloadManager$1(ZipResDownloadManager paramZipResDownloadManager, String paramString) {}
  
  public void run()
  {
    String str = this.a;
    if (this.this$0.b(str)) {
      return;
    }
    ZipResEntry localZipResEntry = ZipResDownloadManager.a(this.this$0, str, -1, null, null);
    if (ZipResDownloadManager.a(this.this$0, str, localZipResEntry)) {
      ZipResDownloadManager.a(this.this$0, localZipResEntry);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.vipcomponent.util.ZipResDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */