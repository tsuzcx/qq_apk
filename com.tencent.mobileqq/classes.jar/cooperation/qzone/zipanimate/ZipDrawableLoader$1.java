package cooperation.qzone.zipanimate;

import bgmh;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;

public class ZipDrawableLoader$1
  implements Runnable
{
  public ZipDrawableLoader$1(bgmh parambgmh, int paramInt) {}
  
  public void run()
  {
    if (QzoneZipCacheHelper.checkAndDownLoadFileIfNeeded(null, bgmh.a(this.this$0), bgmh.b(this.this$0), bgmh.c(this.this$0), this.a, bgmh.a(this.this$0))) {
      bgmh.a(this.this$0, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.zipanimate.ZipDrawableLoader.1
 * JD-Core Version:    0.7.0.1
 */