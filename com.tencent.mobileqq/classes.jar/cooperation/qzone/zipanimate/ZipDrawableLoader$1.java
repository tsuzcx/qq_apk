package cooperation.qzone.zipanimate;

import bnqv;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;

public class ZipDrawableLoader$1
  implements Runnable
{
  public ZipDrawableLoader$1(bnqv parambnqv, int paramInt) {}
  
  public void run()
  {
    if (QzoneZipCacheHelper.checkAndDownLoadFileIfNeeded(null, bnqv.a(this.this$0), bnqv.b(this.this$0), bnqv.c(this.this$0), this.a, bnqv.a(this.this$0))) {
      bnqv.a(this.this$0, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.zipanimate.ZipDrawableLoader.1
 * JD-Core Version:    0.7.0.1
 */