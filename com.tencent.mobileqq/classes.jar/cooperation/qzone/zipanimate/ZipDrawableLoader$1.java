package cooperation.qzone.zipanimate;

import bjxa;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;

public class ZipDrawableLoader$1
  implements Runnable
{
  public ZipDrawableLoader$1(bjxa parambjxa, int paramInt) {}
  
  public void run()
  {
    if (QzoneZipCacheHelper.checkAndDownLoadFileIfNeeded(null, bjxa.a(this.this$0), bjxa.b(this.this$0), bjxa.c(this.this$0), this.a, bjxa.a(this.this$0))) {
      bjxa.a(this.this$0, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.zipanimate.ZipDrawableLoader.1
 * JD-Core Version:    0.7.0.1
 */