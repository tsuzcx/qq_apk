package cooperation.qzone.zipanimate;

import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;

class ZipDrawableLoader$1
  implements Runnable
{
  ZipDrawableLoader$1(ZipDrawableLoader paramZipDrawableLoader, int paramInt) {}
  
  public void run()
  {
    if (QzoneZipCacheHelper.checkAndDownLoadFileIfNeeded(null, ZipDrawableLoader.access$000(this.this$0), ZipDrawableLoader.access$100(this.this$0), ZipDrawableLoader.access$200(this.this$0), this.val$count, ZipDrawableLoader.access$300(this.this$0))) {
      ZipDrawableLoader.access$400(this.this$0, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.zipanimate.ZipDrawableLoader.1
 * JD-Core Version:    0.7.0.1
 */