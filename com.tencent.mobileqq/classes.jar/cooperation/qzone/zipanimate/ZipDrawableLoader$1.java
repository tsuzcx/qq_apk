package cooperation.qzone.zipanimate;

import bhvp;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;

public class ZipDrawableLoader$1
  implements Runnable
{
  public ZipDrawableLoader$1(bhvp parambhvp, int paramInt) {}
  
  public void run()
  {
    if (QzoneZipCacheHelper.checkAndDownLoadFileIfNeeded(null, bhvp.a(this.this$0), bhvp.b(this.this$0), bhvp.c(this.this$0), this.a, bhvp.a(this.this$0))) {
      bhvp.a(this.this$0, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.zipanimate.ZipDrawableLoader.1
 * JD-Core Version:    0.7.0.1
 */